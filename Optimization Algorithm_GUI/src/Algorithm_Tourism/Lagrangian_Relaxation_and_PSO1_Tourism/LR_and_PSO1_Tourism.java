package Algorithm_Tourism.Lagrangian_Relaxation_and_PSO1_Tourism;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import Algorithm_Tourism.Function_Vector;
import Input_Output_txt.Batch.Read_PSO_Batch_Parameter;
 
import Input_Output_txt.Tourism.Output_Result;
import Input_Output_txt.Tourism.Read_LR_Lambda;
import Input_Output_txt.Tourism.Read_LR_XY;
import Input_Output_txt.Tourism.Read_Objective_Weight;
import Input_Output_txt.Tourism.Read_Tourism;
import carpool_Alogorithm_MOD.Print_input;

 
public class LR_and_PSO1_Tourism {

	public static int Xasize = 0, Xhsize = 0, Xtsize = 0, Ysize = 0;
	
	public static int  i1=0,i2=0;
	public static int N;
	public static int I;
	public static int K;
	public static double w;
	public static double c1;
	public static double c2;
	public static int Vmax;
	public static int Execution_Mode;
	public static int Print_Mode;
	public static int Write_Mode;
	public static int populationSize;
	public static double threshold;
	public static int Iteration;
	public static int Iteration_Mode;
	private static int[] Xa;
	private static int[] Xh;
	private static int[] Xt;
	private static int[] Y;
	private static int[][] X_Batch;
	private static int[][] Y_Batch;
	public static 	int generationCount ;
	public static StringBuilder sb = new StringBuilder();
	public static StringBuilder sb1 = new StringBuilder();
	public static int n=0;//計算Batch次數
	public static double Omega_1,Omega_2;
	public static long time_write_to_TXT;
	public static long T_total_time;
	
	public static void main( ) throws IOException {
		n=0;
		time_write_to_TXT=0;
		Xasize = 0;
		Xhsize = 0;
		Xtsize = 0;
		Ysize = 0;
		i1=0;
		i2=0;
		n=0;
		sb=new StringBuilder();
		sb1=new StringBuilder();
		Read_Tourism.main();
		Read_Objective_Weight.main();
		Omega_1=Read_Objective_Weight.Omega_1();
		Omega_2=Read_Objective_Weight.Omega_2();
		for (int i = 0; i < Read_Tourism.Ia(); i++)
			Xasize += Read_Tourism.Ja(i);
		for (int i = 0; i < Read_Tourism.Ih(); i++)
			Xhsize += Read_Tourism.Jh(i);
		for (int i = 0; i < Read_Tourism.It(); i++)
			Xtsize += Read_Tourism.Jt(i);
		for (int i = 0; i < Read_Tourism.N(); i++)
			Ysize += Read_Tourism.H(i);

		Xa = new int[Xasize];
		Xh = new int[Xhsize];
		Xt = new int[Xtsize];
		Y = new int[Ysize];
		
		if(GUI.main.getmethod()!=2){
		PSO_Read_Write_txt.read_PSO_Parameter();
	 
		Read_Objective_Weight.main();
		Iteration_Mode=PSO_Read_Write_txt.Iteration_Mode();
		if(Iteration_Mode==0){
		Iteration = PSO_Read_Write_txt.Iteration();
		}else{
			Iteration= Xasize + Xhsize + Xtsize + Ysize + Read_Tourism.K()
					+ 1 + Read_Tourism.Ia() * Read_Tourism.K()
					+ Read_Tourism.Ih() * Read_Tourism.M()
					+ Read_Tourism.It() * Read_Tourism.T();
		}
		populationSize=PSO_Read_Write_txt.populationSize();
		w=PSO_Read_Write_txt.w();
		c1=PSO_Read_Write_txt.c1();
		c2=PSO_Read_Write_txt.c2();
		Vmax=PSO_Read_Write_txt.Vmax();
		Execution_Mode=PSO_Read_Write_txt.Execution_Mode();
		Print_Mode=PSO_Read_Write_txt.Print_Mode();
		Write_Mode=PSO_Read_Write_txt.Write_Mode();
		threshold=PSO_Read_Write_txt.threshold();
		 
		LR_Tourism.main();
		Read_LR_XY.main();
		Read_LR_Lambda.LR_and_PSO1();
		
		String str="";
		long totalstartTime = System.currentTimeMillis();
		long startTime = System.currentTimeMillis();
		Population myPop = new Population(populationSize, true);
		long endTime = System.currentTimeMillis();
		 generationCount = 1;
		double myPopFitnessN_1,Fittest;
		// F(X,Y)
		System.out.println();
		System.out.println("F1(X,Y)");
		PSO_Data_print.print2(myPop,Print_Mode);
		System.out.print("Generation: " + generationCount + " F(x,y) Fittest: "+ myPop.getFittest().getFitness() + " F1(x,y) Fittest: "+ myPop.getFittest().getFitness1() + " Y=");
		str+="Generation=" + generationCount + " Fitness Function= "+myPop.getFittest().getFitness1()  ;
		Fittest=myPop.getFittest().getFitness1() ;
	
		for (int i = 0; i < myPop.getFittest().Gysize(); i++) {
			Y[i] = myPop.getFittest().getGy(i);
			System.out.print(Y[i]);
		}
		System.out.print("Xa=");
		for (int j = 0; j < myPop.getFittest().Gxasize(); j++) {
			Xa[j] = myPop.getFittest().getGxa(j);
			System.out.print(Xa[j]);
		}
		System.out.print(" Xh=");
		for (int j = 0; j < myPop.getFittest().Gxhsize(); j++) {
			Xh[j] = myPop.getFittest().getGxh(j);
			System.out.print(Xh[j]);
		}
		System.out.print(" Xt=");
		for (int j = 0; j < myPop.getFittest().Gxtsize(); j++) {
			Xt[j] = myPop.getFittest().getGxt(j);
			System.out.print(Xt[j]);
		}
		
		System.out.print(" 執行時間: "+(endTime-startTime));
		str+=" Time= "+(endTime-startTime)+"ms\r\n";
		System.out.println();
		myPopFitnessN_1 = myPop.getFittest().getFitness1();
		 startTime = System.currentTimeMillis();
		myPop = Algorithm.evolvePopulation(myPop);
		endTime = System.currentTimeMillis();
		 PSO_Data_print.print2(myPop,Print_Mode);
			for (int iter = 0; iter < Iteration; iter++) {
				if ((Math.abs(myPop.getFittest().getFitness1()	- myPopFitnessN_1)/ Math.abs(myPopFitnessN_1) > threshold)	|| constraint(Xa,Xh,Xt, Y) == false) {
 
 	//	for(int t=0;t<100;t++){
			generationCount++;
			
			System.out.print("Generation: " + generationCount + " F(x,y) Fittest: "+ myPop.getFittest().getFitness() + " F1(x,y) Fittest: "+ myPop.getFittest().getFitness1() + " Y=");
			str+="Generation=" + generationCount + " Fitness Function= "+myPop.getFittest().getFitness1()  ;
			Fittest=myPop.getFittest().getFitness1() ;
			
			for (int i = 0; i < myPop.getFittest().Gysize(); i++) {
				Y[i] = myPop.getFittest().getGy(i);
				System.out.print(Y[i]);
			}
			System.out.print("Xa=");
			for (int j = 0; j < myPop.getFittest().Gxasize(); j++) {
				Xa[j] = myPop.getFittest().getGxa(j);
				System.out.print(Xa[j]);
			}
			System.out.print(" Xh=");
			for (int j = 0; j < myPop.getFittest().Gxhsize(); j++) {
				Xh[j] = myPop.getFittest().getGxh(j);
				System.out.print(Xh[j]);
			}
			System.out.print(" Xt=");
			for (int j = 0; j < myPop.getFittest().Gxtsize(); j++) {
				Xt[j] = myPop.getFittest().getGxt(j);
				System.out.print(Xt[j]);
			}
			System.out.print(" 執行時間: "+(endTime-startTime));
			str+=" Time= "+(endTime-startTime)+"ms\r\n";
			System.out.println();
			myPopFitnessN_1 = myPop.getFittest().getFitness1();
			startTime = System.currentTimeMillis();
			myPop = Algorithm.evolvePopulation(myPop);
			endTime = System.currentTimeMillis();
			PSO_Data_print.print2(myPop,Print_Mode);
			 
		}else{break;}
			}
		
		System.out.println("Solution found!");
		System.out.println("Generation: " + generationCount);
		long totalendTime = System.currentTimeMillis();
		T_total_time=totalendTime - totalstartTime;
		System.out.println("執行時間 T_total_time=" + T_total_time+"ms");
		System.out.println("執行時間扣除寫檔時間  T_net=" + (T_total_time-time_write_to_TXT)+"ms");
		//CheckConstraint.CheckConstraints(X,Y);
		Print_input.main(Print_Mode);
		Output_Result.LR_and_PSO1_Tourism(Y, Xa,Xh,Xt, Fittest, generationCount, T_total_time, (T_total_time-time_write_to_TXT));
		
		}else{
			PSO_Read_Write_txt.read_PSO_Parameter();
			Read_PSO_Batch_Parameter.main();
			LR_Tourism.main();
			Read_LR_XY.main();
			Read_Objective_Weight.main();
			long Time_Batch = 0;
			int generationCount_Batch = 0,k=-99999;
			double Fittest_Batch=-999999999;
			
			int populationSize_Batch=0;
			double w_Batch=0,c1_Batch=0,c2_Batch=0;
			
			
			
			Vmax=Read_PSO_Batch_Parameter.Vmax();
			Execution_Mode=Read_PSO_Batch_Parameter.Execution_Mode();
			Print_Mode=Read_PSO_Batch_Parameter.Print_Mode();
			Write_Mode=Read_PSO_Batch_Parameter.Write_Mode();
			threshold=Read_PSO_Batch_Parameter.threshold();
			 
			 
			for(populationSize=Read_PSO_Batch_Parameter.lowpopulationSize();populationSize<=Read_PSO_Batch_Parameter.UppopulationSize();populationSize+=Read_PSO_Batch_Parameter.StpopulationSize()){
				for(w=Read_PSO_Batch_Parameter.loww();w<=Read_PSO_Batch_Parameter.Upw();w+=Read_PSO_Batch_Parameter.Stw()){
					for(c1=Read_PSO_Batch_Parameter.lowc1();c1<=Read_PSO_Batch_Parameter.Upc1();c1+=Read_PSO_Batch_Parameter.Stc1()){
						for(c2=Read_PSO_Batch_Parameter.lowc2();c2<=Read_PSO_Batch_Parameter.Upc2();c2+=Read_PSO_Batch_Parameter.Stc2()){
					 n++;
					 time_write_to_TXT=0;
					 sb=new StringBuilder();
					sb1=new StringBuilder();
					System.out.println("PSO1_Batch"+n);
					System.out.println("populationSize="+populationSize);
					System.out.println("w="+w);
					System.out.println("c1="+c1);
					System.out.println("c2="+c2);
					System.out.println("Vmax="+Vmax);
					System.out.println("Execution_Mode="+Execution_Mode);
					System.out.println("Print_Mode="+Print_Mode);
					System.out.println("threshold="+new BigDecimal(String.valueOf(threshold)));
			long totalstartTime = System.currentTimeMillis();
			Population myPop = new Population(populationSize, true);
			 generationCount = 1;
			double myPopFitnessN_1,Fittest;
			
			
			// F(X,Y)
			System.out.println();
			System.out.println("F1(X,Y)");
			PSO_Data_print.print2(myPop,Print_Mode);
			System.out.print("Generation: " + generationCount + " F(x,y) Fittest: "+ myPop.getFittest().getFitness() + " F1(x,y) Fittest: "+ myPop.getFittest().getFitness1() + " Y=");
			
			Fittest=myPop.getFittest().getFitness1() ;

			for (int i = 0; i < myPop.getFittest().Gysize(); i++) {
				Y[i] = myPop.getFittest().getGy(i);
				System.out.print(Y[i]);
			}
			System.out.print("Xa=");
			for (int j = 0; j < myPop.getFittest().Gxasize(); j++) {
				Xa[j] = myPop.getFittest().getGxa(j);
				System.out.print(Xa[j]);
			}
			System.out.print(" Xh=");
			for (int j = 0; j < myPop.getFittest().Gxhsize(); j++) {
				Xh[j] = myPop.getFittest().getGxh(j);
				System.out.print(Xh[j]);
			}
			System.out.print(" Xt=");
			for (int j = 0; j < myPop.getFittest().Gxtsize(); j++) {
				Xt[j] = myPop.getFittest().getGxt(j);
				System.out.print(Xt[j]);
			}
			System.out.println();
			myPopFitnessN_1 = myPop.getFittest().getFitness1();
			myPop = Algorithm.evolvePopulation(myPop);
			 PSO_Data_print.print2(myPop,Print_Mode);
			
		 while (Math.abs(myPop.getFittest().getFitness1()-myPopFitnessN_1)/Math.abs(myPopFitnessN_1) > threshold) {
		//	for(int t=0;t<100;t++){
				generationCount++;
				
				System.out.print("Generation: " + generationCount + " F(x,y) Fittest: "+ myPop.getFittest().getFitness() + " F1(x,y) Fittest: "+ myPop.getFittest().getFitness1() + " Y=");
				Fittest=myPop.getFittest().getFitness1() ;
				for (int i = 0; i < myPop.getFittest().Gysize(); i++) {
					Y[i] = myPop.getFittest().getGy(i);
					System.out.print(Y[i]);
				}
				System.out.print("Xa=");
				for (int j = 0; j < myPop.getFittest().Gxasize(); j++) {
					Xa[j] = myPop.getFittest().getGxa(j);
					System.out.print(Xa[j]);
				}
				System.out.print(" Xh=");
				for (int j = 0; j < myPop.getFittest().Gxhsize(); j++) {
					Xh[j] = myPop.getFittest().getGxh(j);
					System.out.print(Xh[j]);
				}
				System.out.print(" Xt=");
				for (int j = 0; j < myPop.getFittest().Gxtsize(); j++) {
					Xt[j] = myPop.getFittest().getGxt(j);
					System.out.print(Xt[j]);
				}
				System.out.println();
				myPopFitnessN_1 = myPop.getFittest().getFitness1();
				
				myPop = Algorithm.evolvePopulation(myPop);
				PSO_Data_print.print2(myPop,Print_Mode);
			}
			
			System.out.println("Solution found!");
			System.out.println("Generation: " + generationCount);
			long totalendTime = System.currentTimeMillis();
			T_total_time=totalendTime - totalstartTime;
			System.out.println("執行時間 T_total_time=" + T_total_time+"ms");
			System.out.println("執行時間扣除寫檔時間  T_net=" + (T_total_time-time_write_to_TXT)+"ms");
		//	CheckConstraint.CheckConstraints(X,Y);
			Print_input.main(Print_Mode);
			Output_Result.saveLR_and_PSO1_Batch_Parameter(n,populationSize,w,c1,c2, Vmax, Execution_Mode, Print_Mode,Write_Mode, threshold );
		//	Output_Result.LR_and_PSO1_Batch(n,Y, X, Fittest, generationCount,T_total_time, (T_total_time-time_write_to_TXT));
			System.out.println();
				if(Fittest>Fittest_Batch){
					k=n;
					Fittest_Batch=Fittest;
				}System.err.println(Fittest_Batch);
				System.err.println(k);
						}
					}
				}
			}
			System.out.println(Fittest_Batch);
			System.out.println(k);
			//Output_Result.PSO1_Batch_best(Y_Batch, X_Batch, Fittest_Batch, generationCount_Batch,Time_Batch);
			//Output_Result.savePSO1_Batch_Parameter(n,populationSize_Batch,w_Batch,c1_Batch,c2_Batch, Vmax, Execution_Mode, Print_Mode, threshold );
		}
	}

	public static int Xa(int i) {
		return Xa[i];
	}
	public static int Xh(int i) {
		return Xh[i];
	}
	public static int Xt(int i) {
		return Xt[i];
	}
	public static int Y(int i) {
		return Y[i];
	}

	public static boolean constraint(int[] xa,int[] xh,int[] xt, int[] y)   {
		boolean right = true;
		
		int[][] Y = new int[Read_Tourism.N()][];
		for (int i = 0; i < Read_Tourism.N(); i++)
			Y[i] = new int[Read_Tourism.H(i)];
		
		int[][] Xa = new int[Read_Tourism.Ia()][];
		for (int i = 0; i < Read_Tourism.Ia(); i++)
			Xa[i] = new int[Read_Tourism.Ja(i)];
		
		int[][] Xh = new int[Read_Tourism.Ih()][];
		for (int i = 0; i < Read_Tourism.Ih(); i++)
			Xh[i] = new int[Read_Tourism.Jh(i)];
		
		int[][] Xt = new int[Read_Tourism.It()][];
		for (int i = 0; i < Read_Tourism.It(); i++)
			Xt[i] = new int[Read_Tourism.Jt(i)];
		
		int b = 0;
		for (int i = 0; i < Y.length; i++)
			for (int j = 0; j < Y[i].length; j++)
				Y[i][j] = y[b++];
		b=0;
		for (int i = 0; i < Xa.length; i++)
			for (int j = 0; j < Xa[i].length; j++)
				Xa[i][j] = xa[b++];
		b=0;
		for (int i = 0; i < Xh.length; i++)
			for (int j = 0; j < Xh[i].length; j++)
				Xh[i][j] = xh[b++];
		b=0;
		for (int i = 0; i < Xt.length; i++)
			for (int j = 0; j < Xt[i].length; j++)
				Xt[i][j] = xt[b++];
		ArrayList<List<Integer>> A =Function_Vector.A_Vector();
		ArrayList<Integer> B = Function_Vector.B_Vector();
		ArrayList<Integer> z = Function_Vector.z_Vector(Y, Xa, Xh, Xt);
		
		for(int i=0;i<A.size();i++){
			int sum=0;
			for(int j=0;j<A.get(i).size();j++)
				sum+=A.get(i).get(j)*z.get(j);
			if(sum<B.get(i))
				right=false;
		}
		return right;
	}
}
