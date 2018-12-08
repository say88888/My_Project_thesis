package Algorithm_Tourism.Lagrangian_PSO_Tourism;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import Algorithm_Tourism.Function_Vector;
import Input_Output_txt.Read_ALPSO_Parameter;
import Input_Output_txt.Batch.Read_PSO_Batch_Parameter;
 
import Input_Output_txt.Tourism.Output_Result;
import Input_Output_txt.Tourism.Read_Objective_Weight;
import Input_Output_txt.Tourism.Read_Tourism;
import carpool_Alogorithm_MOD.Print_input;

 
public class ALPSO_Tourism {

	public static int Xasize = 0, Xhsize = 0, Xtsize = 0, Ysize = 0;
	
	public static int  i1=0,i2=0;

	public static double w;
	public static double c1;
	public static double c2;
	public static int Vmax;
	public static int Execution_Mode;
	public static int Print_Mode;
	public static int Write_Mode;
	public static int populationSize;
	public static double threshold;
	 public static int Print;
 
	public static int Iteration;
	public static int Iteration_Mode;
	public static double[] r1;
	public static double[] r2;
	public static double[] r3;
	public static double r4;
	public static double[][] r5;
	public static double[][] r6;
	public static double[][] r7;
	public static double Epsilonh;	//εh
	public static double Omega_1;
	public static double Omega_2;
	public static double[] Lambda1; // λ
	public static double[] Lambda2; // λ
	public static double[] Lambda3; // λ
	public static double Lambda4;
	public static double[][] Lambda5;
	public static double[][] Lambda6;
	public static double[][] Lambda7;
 
	public static int[][] Xa;
	public static int[][] Xh;
	public static int[][] Xt;
	public static int[][] Y;
	private static int[][] X_Batch;
	private static int[][] Y_Batch;
	public static 	int generationCount ;
	public static StringBuilder sb = new StringBuilder();
	public static StringBuilder sb1 = new StringBuilder();
	public static int n=0;//計算Batch次數
	
	private static ArrayList<Integer> true1 = new ArrayList<Integer>();
	
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
		Y = new int[Read_Tourism.N()][];
		for (int i = 0; i < Read_Tourism.N(); i++)
			Y[i] = new int[Read_Tourism.H(i)];

		Xa = new int[Read_Tourism.Ia()][];
		for (int i = 0; i < Read_Tourism.Ia(); i++)
			Xa[i] = new int[Read_Tourism.Ja(i)];
		Xh = new int[Read_Tourism.Ih()][];
		for (int i = 0; i < Read_Tourism.Ih(); i++)
			Xh[i] = new int[Read_Tourism.Jh(i)];
		Xt = new int[Read_Tourism.It()][];
		for (int i = 0; i < Read_Tourism.It(); i++)
			Xt[i] = new int[Read_Tourism.Jt(i)];
		for (int i = 0; i < Read_Tourism.Ia(); i++)
			Xasize += Read_Tourism.Ja(i);
		for (int i = 0; i < Read_Tourism.Ih(); i++)
			Xhsize += Read_Tourism.Jh(i);
		for (int i = 0; i < Read_Tourism.It(); i++)
			Xtsize += Read_Tourism.Jt(i);
		for (int i = 0; i < Read_Tourism.N(); i++)
			Ysize += Read_Tourism.H(i);
		Lambda1 = new double[Read_Tourism.K()];
		Lambda2 = new double[Read_Tourism.K()];
		Lambda3 = new double[Read_Tourism.K()];
		Lambda5 = new double[Read_Tourism.Ia()][Read_Tourism.K()];
		Lambda6 = new double[Read_Tourism.Ih()][Read_Tourism.M()];
		Lambda7= new double[Read_Tourism.It()][Read_Tourism.T()];
		r1 = new double[Read_Tourism.K()];
		r2 = new double[Read_Tourism.K()];
		r3 = new double[Read_Tourism.K()];
		r5 = new double[Read_Tourism.Ia()][Read_Tourism.K()];
		r6 = new double[Read_Tourism.Ih()][Read_Tourism.M()];
		r7= new double[Read_Tourism.It()][Read_Tourism.T()];
		for (int i = 0; i < Lambda1.length; i++){
			Lambda1[i] = 0;
			Lambda2[i] = 0;
			Lambda3[i] = 0;
		}
		Lambda4 = 0;
		for (int i = 0; i < Lambda5.length; i++)
			for (int j = 0; j < Lambda5[i].length; j++)
				Lambda5[i][j] = 0;
		for (int i = 0; i < Lambda6.length; i++)
			for (int j = 0; j < Lambda6[i].length; j++)
				Lambda6[i][j] = 0;
		for (int i = 0; i < Lambda7.length; i++)
			for (int j = 0; j < Lambda7[i].length; j++)
				Lambda7[i][j] = 0;
		PSO_Read_Write_txt.read_PSO_Parameter();
		for (int i = 0; i < r1.length; i++){
			r1[i] = PSO_Read_Write_txt.R1();
			r2[i] = PSO_Read_Write_txt.R2();
			r3[i] = PSO_Read_Write_txt.R3();
		}
		r4 = PSO_Read_Write_txt.R4();
		for (int i = 0; i < r5.length; i++)
			for (int j = 0; j < r5[i].length; j++)
				r5[i][j] = PSO_Read_Write_txt.R5();
		for (int i = 0; i < r6.length; i++)
			for (int j = 0; j < r6[i].length; j++)
				r6[i][j] = PSO_Read_Write_txt.R6();
		for (int i = 0; i < r7.length; i++)
			for (int j = 0; j < r7[i].length; j++)
				r7[i][j] =PSO_Read_Write_txt.R7();
		
		Read_ALPSO_Parameter.main();
		Epsilonh=Read_ALPSO_Parameter.Epsilonh();
		Print=Read_ALPSO_Parameter.Print();
		 
 
		if(GUI.main.getmethod()!=2){
		
			Iteration_Mode=PSO_Read_Write_txt.Iteration_Mode();
			if(Iteration_Mode==0){
			Iteration = PSO_Read_Write_txt.Iteration();
			}else{
				Iteration=Xasize + Xhsize + Xtsize + Ysize + Read_Tourism.K()
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
		System.out.print("Generation: " + generationCount + " F(x,y) Fittest: "+ myPop.getFittest().getFitness() + " F1(x,y) Fittest: "+ myPop.getFittest().getFitness1() + " Y= ");
		str+="Generation=" + generationCount + " Fitness Function= "+myPop.getFittest().getFitness1()  ;
		Fittest=myPop.getFittest().getFitness1() ;
		 
		int  a=0;
		for(int i=0;i<Y.length;i++)
			for(int j=0;j<Y[i].length;j++){
				Y[i][j]=myPop.getFittest().getGy(a++);
				System.out.print(Y[i][j]);
			}
		a=0;
		System.out.print(" Xa= ");
		for(int i=0;i<Xa.length;i++)
			for(int j=0;j<Xa[i].length;j++){
				Xa[i][j]=myPop.getFittest().getGxa(a++);
				System.out.print(Xa[i][j]);
			}
		a=0;
		System.out.print(" Xh= ");
		for(int i=0;i<Xh.length;i++)
			for(int j=0;j<Xh[i].length;j++){
				Xh[i][j]=myPop.getFittest().getGxh(a++);
				System.out.print(Xh[i][j]);
			}
		a=0;
		System.out.print(" Xt= ");
		for(int i=0;i<Xt.length;i++)
			for(int j=0;j<Xt[i].length;j++){
				Xt[i][j]=myPop.getFittest().getGxt(a++);
				System.out.print(Xt[i][j]);
			}
		 
		System.out.print(" 執行時間: "+(endTime-startTime));
		str+=" Time= "+(endTime-startTime)+"ms\r\n";
		 
		System.out.println();
		Updata_Lambda_penalty.Updata_Lambda(Xa,Xh,Xt,Y );
		 Updata_Lambda_penalty.Updata_penalty(Xa,Xh,Xt,Y , myPop);
		  
		myPopFitnessN_1 = myPop.getFittest().getFitness1();
		 startTime = System.currentTimeMillis();
		myPop = Algorithm.evolvePopulation(myPop);
		endTime = System.currentTimeMillis();
		 PSO_Data_print.print2(myPop,Print_Mode);
			for (int iter = 0; iter < Iteration; iter++) {
				if ((Math.abs(myPop.getFittest().getFitness1()	- myPopFitnessN_1)/ Math.abs(myPopFitnessN_1) > threshold)	|| constraint(Xa,Xh,Xt,Y) == false) {
		
 
		//while ((myPop.getFittest().getFitness1()-myPopFitnessN_1)/(myPopFitnessN_1) > threshold) {
		//for(int t=0;t<500;t++){
			generationCount++;
			
			System.out.print("Generation: " + generationCount + " F(x,y) Fittest: "+ myPop.getFittest().getFitness() + " F1(x,y) Fittest: "+ myPop.getFittest().getFitness1() + " Y= ");
			str+="Generation=" + generationCount + " Fitness Function= "+myPop.getFittest().getFitness1()  ;
			Fittest=myPop.getFittest().getFitness1() ;
			a=0;
			for(int i=0;i<Y.length;i++)
				for(int j=0;j<Y[i].length;j++){
					Y[i][j]=myPop.getFittest().getGy(a++);
					System.out.print(Y[i][j]);
				}
			a=0;
			System.out.print(" Xa= ");
			for(int i=0;i<Xa.length;i++)
				for(int j=0;j<Xa[i].length;j++){
					Xa[i][j]=myPop.getFittest().getGxa(a++);
					System.out.print(Xa[i][j]);
				}
			a=0;
			System.out.print(" Xh= ");
			for(int i=0;i<Xh.length;i++)
				for(int j=0;j<Xh[i].length;j++){
					Xh[i][j]=myPop.getFittest().getGxh(a++);
					System.out.print(Xh[i][j]);
				}
			a=0;
			System.out.print(" Xt= ");
			for(int i=0;i<Xt.length;i++)
				for(int j=0;j<Xt[i].length;j++){
					Xt[i][j]=myPop.getFittest().getGxt(a++);
					System.out.print(Xt[i][j]);
				}
			System.out.print(" 執行時間: "+(endTime-startTime));
			str+=" Time= "+(endTime-startTime)+"ms\r\n";
			 
			System.out.println();
			Updata_Lambda_penalty.Updata_Lambda(Xa,Xh,Xt, Y);
			 
			 Updata_Lambda_penalty.Updata_penalty(Xa,Xh,Xt, Y , myPop);
		 
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
	//	CheckConstraint.CheckConstraints(X,Y);
		Print_input.main(Print_Mode);
		Output_Result.ALPSO_Tourism(Y, Xa,Xh,Xt, Fittest, generationCount, T_total_time, (T_total_time-time_write_to_TXT) );
		
		}else{
			 
			Read_PSO_Batch_Parameter.main();
			 
			 
			long Time_Batch = 0;
			int generationCount_Batch = 0,k=-99999;
			double Fittest_Batch=999999999;
			
			int populationSize_Batch=0;
			double w_Batch=0,c1_Batch=0,c2_Batch=0;
			
			
			
			Vmax=Read_PSO_Batch_Parameter.Vmax();
			Execution_Mode=Read_PSO_Batch_Parameter.Execution_Mode();
			Print_Mode=Read_PSO_Batch_Parameter.Print_Mode();
			threshold=Read_PSO_Batch_Parameter.threshold();
			 
		 
			for(populationSize=Read_PSO_Batch_Parameter.lowpopulationSize();populationSize<=Read_PSO_Batch_Parameter.UppopulationSize();populationSize+=Read_PSO_Batch_Parameter.StpopulationSize()){
				for(w=Read_PSO_Batch_Parameter.loww();w<=Read_PSO_Batch_Parameter.Upw();w+=Read_PSO_Batch_Parameter.Stw()){
					for(c1=Read_PSO_Batch_Parameter.lowc1();c1<=Read_PSO_Batch_Parameter.Upc1();c1+=Read_PSO_Batch_Parameter.Stc1()){
						for(c2=Read_PSO_Batch_Parameter.lowc2();c2<=Read_PSO_Batch_Parameter.Upc2();c2+=Read_PSO_Batch_Parameter.Stc2()){
					 n++;
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
			int a=0;
			for(int i=0;i<Y.length;i++)
				for(int j=0;j<Y[i].length;j++){
					Y[i][j]=myPop.getFittest().getGy(a++);
					System.out.print(Y[i][j]);
				}
			a=0;
			System.out.print(" Xa= ");
			for(int i=0;i<Xa.length;i++)
				for(int j=0;j<Xa[i].length;j++){
					Xa[i][j]=myPop.getFittest().getGxa(a++);
					System.out.print(Xa[i][j]);
				}
			a=0;
			System.out.print(" Xh= ");
			for(int i=0;i<Xh.length;i++)
				for(int j=0;j<Xh[i].length;j++){
					Xh[i][j]=myPop.getFittest().getGxh(a++);
					System.out.print(Xh[i][j]);
				}
			a=0;
			System.out.print(" Xt= ");
			for(int i=0;i<Xt.length;i++)
				for(int j=0;j<Xt[i].length;j++){
					Xt[i][j]=myPop.getFittest().getGxt(a++);
					System.out.print(Xt[i][j]);
				}
			System.out.println();
			Updata_Lambda_penalty.Updata_Lambda(Xa,Xh,Xt, Y);
			 Updata_Lambda_penalty.Updata_penalty(Xa,Xh,Xt, Y , myPop);
			myPopFitnessN_1 = myPop.getFittest().getFitness1();
			myPop = Algorithm.evolvePopulation(myPop);
			 PSO_Data_print.print2(myPop,Print_Mode);
			 
			 while (Math.abs(myPop.getFittest().getFitness1()-myPopFitnessN_1)/Math.abs(myPopFitnessN_1) > threshold) {
		//	for(int t=0;t<100;t++){
				generationCount++;
				
				System.out.print("Generation: " + generationCount + " F(x,y) Fittest: "+ myPop.getFittest().getFitness() + " F1(x,y) Fittest: "+ myPop.getFittest().getFitness1() + " Y=");
				Fittest=myPop.getFittest().getFitness1() ;
				a=0;
				for(int i=0;i<Y.length;i++)
					for(int j=0;j<Y[i].length;j++){
						Y[i][j]=myPop.getFittest().getGy(a++);
						System.out.print(Y[i][j]);
					}
				a=0;
				System.out.print(" Xa= ");
				for(int i=0;i<Xa.length;i++)
					for(int j=0;j<Xa[i].length;j++){
						Xa[i][j]=myPop.getFittest().getGxa(a++);
						System.out.print(Xa[i][j]);
					}
				a=0;
				System.out.print(" Xh= ");
				for(int i=0;i<Xh.length;i++)
					for(int j=0;j<Xh[i].length;j++){
						Xh[i][j]=myPop.getFittest().getGxh(a++);
						System.out.print(Xh[i][j]);
					}
				a=0;
				System.out.print(" Xt= ");
				for(int i=0;i<Xt.length;i++)
					for(int j=0;j<Xt[i].length;j++){
						Xt[i][j]=myPop.getFittest().getGxt(a++);
						System.out.print(Xt[i][j]);
					}
				System.out.println();
				Updata_Lambda_penalty.Updata_Lambda(Xa,Xh,Xt, Y);
				 Updata_Lambda_penalty.Updata_penalty(Xa,Xh,Xt,Y , myPop);
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
	 
			Print_input.main(Print_Mode);
		//	Output_Result.saveALPSO_Batch_Parameter(n,populationSize,w,c1,c2, Vmax, Execution_Mode, Print_Mode, threshold );
		//	Output_Result.ALPSO_Batch(n,Y, X, Fittest, generationCount,T_total_time, (T_total_time-time_write_to_TXT));
			System.out.println();
			if(constraint(Xa,Xh,Xt,Y)==true){
				true1.add(n);
			}
				if(Fittest<Fittest_Batch&&constraint(Xa,Xh,Xt,Y)==true){
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
			for(int i=0;i<true1.size();i++)
				System.out.print(true1.get(i)+" ");
			//Output_Result.PSO1_Batch_best(Y_Batch, X_Batch, Fittest_Batch, generationCount_Batch,Time_Batch);
			//Output_Result.savePSO1_Batch_Parameter(n,populationSize_Batch,w_Batch,c1_Batch,c2_Batch, Vmax, Execution_Mode, Print_Mode, threshold );
		}
	}

	public static boolean constraint(int[][] Xa,int[][] Xh,int[][] Xt, int[][] Y)   {
		boolean right = true;
		
		 
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
