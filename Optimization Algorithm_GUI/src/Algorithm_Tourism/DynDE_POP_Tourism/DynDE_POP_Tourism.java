package Algorithm_Tourism.DynDE_POP_Tourism;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import Algorithm_Tourism.Function_Vector;
import Input_Output_txt.Tourism.Output_A_B_C_txt;
import Input_Output_txt.Tourism.Output_EXCEL;
import Input_Output_txt.Tourism.Output_Result;
import Input_Output_txt.Tourism.Read_Objective_Weight;
import Input_Output_txt.Tourism.Read_Tourism;
 
public class DynDE_POP_Tourism {

	public static int Xasize = 0, Xhsize = 0, Xtsize = 0, Ysize = 0;	public static int i1 = 0, i2 = 0;
	public static int Fittest_Iter;
	public static int N,Ia,Ih,It,K;

	public static int Vmax;
	public static int Execution_Mode;
	public static int Write_Mode;
	public static int Print_Mode;
	public static int populationSize;
	public static double threshold;
	public static int Pmax;
	public static int PmaxNumbertimes;
	//public static double Epsilon;
	public static int Iteration;
	public static int Iteration_Mode;
 	public static double lamda;
	public static double rcloud;
	public static double Sigma;
	public static double F;
	public static double CR;
	public static int S;
	public static int Mode1,Mode2,Mode3,Mode4;
	public static int[] Xa;
	public static int[] Xh;
	public static int[] Xt;
	public static int[] Y;
	public static double Omega_1,Omega_2;
	public static double Sfmin;
	public static int generationCount;
	public static StringBuilder SFminsb = new StringBuilder();
	public static StringBuilder sb = new StringBuilder();
	public static StringBuilder sb1 = new StringBuilder();
	public static StringBuilder sb2 = new StringBuilder();
	public static int b;
	public static int n = 0;// 計算batch次數
//	public static ArrayList<Double> successfulF = new ArrayList<Double>();
//	public static ArrayList<Double> successfulCR = new ArrayList<Double>();
 
//	public static int[] S;
	public static int s;
	public static List<List<Integer>> n3 = new ArrayList<List<Integer>>();
	
	public static long time_write_to_TXT;
	public static long T_total_time;
	 
	private static List<Integer> Original_temp_variables_iteration = new ArrayList<Integer>();
	private static List<Double> Original_temp_variables_fitness_function_value = new ArrayList<Double>();
	private static List<String> Original_temp_variables_violate_restrictions = new ArrayList<String>();
	
	private static List<String> Original_temp_variables_Global_best_Xa = new ArrayList<String>();
	private static List<String> Original_temp_variables_Global_best_Xh = new ArrayList<String>();
	private static List<String> Original_temp_variables_Global_best_Xt = new ArrayList<String>();
	private static List<String> Original_temp_variables_Global_best_Y = new ArrayList<String>();
	public static ArrayList<List<Integer>> A = new ArrayList<List<Integer>>();
	public static ArrayList<Integer> B = new ArrayList<Integer>();
	public static ArrayList<Double> C = new ArrayList<Double>();
	public static List<Integer> Iter = new ArrayList<Integer>();
	public static List<Integer> Ppopsize = new ArrayList<Integer>();
	public static List<Integer> Type = new ArrayList<Integer>();
	public static void main() throws IOException {
		Original_temp_variables_iteration = new ArrayList<Integer>();
		Original_temp_variables_fitness_function_value = new ArrayList<Double>();
		Original_temp_variables_violate_restrictions = new ArrayList<String>();
		Original_temp_variables_Global_best_Xa = new ArrayList<String>();
		Original_temp_variables_Global_best_Xh = new ArrayList<String>();
		Original_temp_variables_Global_best_Xt = new ArrayList<String>();
		Original_temp_variables_Global_best_Y = new ArrayList<String>();
		
		Sfmin=0;
		SFminsb = new StringBuilder();
		Iter = new ArrayList<Integer>();
		Ppopsize = new ArrayList<Integer>();
		Type = new ArrayList<Integer>();
		time_write_to_TXT = 0;
		Xasize = 0;
		Xhsize = 0;
		Xtsize = 0;
		Ysize = 0;
		Fittest_Iter=0;
		i1 = 0;
		i2 = 0;
		n = 0;
		sb = new StringBuilder();
		sb1 = new StringBuilder();
		sb2 = new StringBuilder();
		Read_Tourism.main();
		N=Read_Tourism.N();
		Ia=Read_Tourism.Ia();
		Ih=Read_Tourism.Ih();
		It=Read_Tourism.It();
		K=Read_Tourism.K();
		Read_Objective_Weight.main();
		Omega_1=Read_Objective_Weight.Omega_1();
		Omega_2=Read_Objective_Weight.Omega_2();

		A = new ArrayList<List<Integer>>();
		B = new ArrayList<Integer>();
		C = new ArrayList<Double>();
		A = Function_Vector.A_Vector();
		B = Function_Vector.B_Vector();
		C = Function_Vector.C_Vector(Omega_1, Omega_2);

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

		DE_Read_Write_txt.Read_NSDE_Parameter(); 
		populationSize = DE_Read_Write_txt.NP();
		//Epsilon = DE_Read_Write_txt.Epsilon();

		Iteration_Mode = DE_Read_Write_txt.Iteration_Mode();

		if (Iteration_Mode == 0  || Iteration_Mode==2) {
			Iteration = DE_Read_Write_txt.Iteration();
		} else {
			Iteration = Xasize + Xhsize + Xtsize + Ysize + Read_Tourism.K()
					+ 1 + Read_Tourism.Ia() * Read_Tourism.K()
					+ Read_Tourism.Ih() * Read_Tourism.M()
					+ Read_Tourism.It() * Read_Tourism.T();		}
		System.out.print(Iteration);
		
		Execution_Mode = DE_Read_Write_txt.Execution_Mode();
		Write_Mode = DE_Read_Write_txt.write_Mode();
		rcloud=DE_Read_Write_txt.rcloud();
		Sigma=DE_Read_Write_txt.Sigma();
		 
		Vmax=DE_Read_Write_txt.Vmax();
		lamda=DE_Read_Write_txt.lamda();
 
	 
		Pmax=DE_Read_Write_txt.Pmax();
		S=DE_Read_Write_txt.S();
		Mode1=DE_Read_Write_txt.Mode1();
		Mode2=DE_Read_Write_txt.Mode2();
		Mode3=DE_Read_Write_txt.Mode3();
		Mode4=DE_Read_Write_txt.Mode4();
		
		for(int i=0;i<Mode1;i++)
 			Type.add(1);
 		for(int i=0;i<Mode2;i++)
 			Type.add(2);
 		for(int i=0;i<Mode3;i++)
 			Type.add(3);
 		for(int i=0;i<Mode4;i++)
 			Type.add(4);
 		n3 = new ArrayList<List<Integer>>();
		for(int i=0;i<S;i++){
			 List<Integer> n1 = new ArrayList<Integer>();
			for(int j=0;j<populationSize;j++)
				n1.add(j+i*populationSize);
			n3.add(n1);
		}
		System.out.println(n3);
		int popsize=populationSize;
		for(int i=0;i<Pmax;i++){
			Iter.add(Iteration/Pmax);
			Ppopsize.add(popsize);
			popsize/=2;
 		}
		PmaxNumbertimes=0;
		generationCount = 1;
		int totalpopsize=populationSize*S;
		String str = "";
		long totalstartTime = System.currentTimeMillis();
		long startTime = System.currentTimeMillis();
		Population myPop = new Population(totalpopsize, true);
		long endTime = System.currentTimeMillis();
		
		double myPopFitnessN_1, Fittest;
		// F(X,Y)
		System.out.println();
		System.out.println("F2(X,Y)");
		DE_Data_print.print2(myPop, Print_Mode);
		System.out.print("Generation: " + generationCount + " F(x,y) Fittest: "
				+ myPop.getFittest().getFitness() + " F2(x,y) Fittest: "
				+ myPop.getFittest().getFitness1() + " Y=");
		str += "Generation=" + generationCount + " Fitness Function= "
				+ myPop.getFittest().getFitness1();
		Fittest = myPop.getFittest().getFitness1();
		for (int i = 0; i < myPop.getFittest().Gysize(); i++) {
			Y[i]=myPop.getFittest().getbinaryGy(i);
			System.out.print(Y[i]);
		}
		System.out.print("Xa=");
		for (int j = 0; j < myPop.getFittest().Gxasize(); j++) {
			Xa[j]=myPop.getFittest().getbinaryGxa(j);
			System.out.print(Xa[j]);
		}
		System.out.print("Xh=");
		for (int j = 0; j < myPop.getFittest().Gxhsize(); j++) {
			Xh[j]=myPop.getFittest().getbinaryGxh(j);
			System.out.print(Xh[j]);
		}
		System.out.print("Xt=");
		for (int j = 0; j < myPop.getFittest().Gxtsize(); j++) {
			Xt[j]=myPop.getFittest().getbinaryGxt(j);
			System.out.print(Xt[j]);
		}
		System.out.print(" 執行時間: " + (endTime - startTime));
		 if(Iteration_Mode==2){
			 String Xa1="",Xh1="",Xt1="",Y1="";
				for(int i=0;i<Xa.length;i++)
						Xa1+=Xa[i]+" ";
				for(int i=0;i<Xh.length;i++)
					Xh1+=Xh[i]+" ";
				for(int i=0;i<Xt.length;i++)
					Xt1+=Xt[i]+" ";
				for(int i=0;i<Y.length;i++)
						Y1+=Y[i]+" ";

		Original_temp_variables_iteration.add(generationCount);
		Original_temp_variables_fitness_function_value.add(myPop.getFittest().getFitness1());
		Original_temp_variables_violate_restrictions.add(String.valueOf(constraint(Xa,Xh,Xt, Y)));
		Original_temp_variables_Global_best_Xa.add(Xa1);
		Original_temp_variables_Global_best_Xh.add(Xh1);
		Original_temp_variables_Global_best_Xt.add(Xt1);
		Original_temp_variables_Global_best_Y.add(Y1);
		 }
		str += " Time= " + (endTime - startTime) + "ms\r\n";
		System.out.println();
		myPopFitnessN_1 = myPop.getFittest().getFitness1();
		Sfmin = FitnessCalc.getSFmin(SFminsb);
		startTime = System.currentTimeMillis();

		myPop = Algorithm.evolvePopulation(myPop);
		endTime = System.currentTimeMillis();
		SFminsb = new StringBuilder();
		DE_Data_print.print2(myPop, Print_Mode);

		/*
		 * while (Math.abs(Global_fittest - myPopFitnessN_1) /
		 * Math.abs(myPopFitnessN_1) > threshold) {
		 */
		for(int p=0;p<Pmax;p++){
			if(p>0){
				PmaxNumbertimes=p;
				 myPop.Update_Population();
				}
		for (int t = 0; t < Iter.get(p); t++) {
			 System.out.println("  F2(x,y) Fittest: = "+ myPop.getFittest().getFitness1() +"   F2(x,y) Fittest 成長值 = "+Math.abs(myPop.getFittest().getFitness1()-myPopFitnessN_1)/Math.abs(myPopFitnessN_1)+"     限制式 : " + constraint(Xa,Xh,Xt, Y));
				
			 if(Iteration_Mode!=2){
			 
			 if((Math.abs(myPop.getFittest().getFitness1()-myPopFitnessN_1)/Math.abs(myPopFitnessN_1) > threshold) || constraint(Xa,Xh,Xt, Y)==false || myPop.getFittest().getFitness1()<=0) {
	

			/*	if (generationCount > LP)
					Function.Update_p_f_cr();*/

				generationCount++;
				if((Math.abs(myPop.getFittest().getFitness1()-myPopFitnessN_1)/Math.abs(myPopFitnessN_1) > threshold))
					Fittest_Iter=generationCount;
		
				System.out.print("Generation: " + generationCount
						+ " F(x,y) Fittest: " + myPop.getFittest().getFitness()
						+ " F2(x,y) Fittest: "
						+ myPop.getFittest().getFitness1() + " Y=");
				str += "Generation=" + generationCount + " Fitness Function= "
						+ myPop.getFittest().getFitness1();
				Fittest = myPop.getFittest().getFitness1();
				for (int i = 0; i < myPop.getFittest().Gysize(); i++) {
					Y[i]=myPop.getFittest().getbinaryGy(i);
					System.out.print(Y[i]);
				}
				System.out.print("Xa=");
				for (int j = 0; j < myPop.getFittest().Gxasize(); j++) {
					Xa[j]=myPop.getFittest().getbinaryGxa(j);
					System.out.print(Xa[j]);
				}
				System.out.print("Xh=");
				for (int j = 0; j < myPop.getFittest().Gxhsize(); j++) {
					Xh[j]=myPop.getFittest().getbinaryGxh(j);
					System.out.print(Xh[j]);
				}
				System.out.print("Xt=");
				for (int j = 0; j < myPop.getFittest().Gxtsize(); j++) {
					Xt[j]=myPop.getFittest().getbinaryGxt(j);
					System.out.print(Xt[j]);
				}
				System.out.print(" 執行時間: " + (endTime - startTime));
				str += " Time= " + (endTime - startTime) + "ms\r\n";
				System.out.println();
				myPopFitnessN_1 = myPop.getFittest().getFitness1();
				Sfmin = FitnessCalc.getSFmin(SFminsb);
				startTime = System.currentTimeMillis();

				myPop = Algorithm.evolvePopulation(myPop);
				endTime = System.currentTimeMillis();
				SFminsb = new StringBuilder();
				DE_Data_print.print2(myPop, Print_Mode);

			} else {
				break;
			}
			 }else{
					generationCount++;
					if((Math.abs(myPop.getFittest().getFitness1()-myPopFitnessN_1)/Math.abs(myPopFitnessN_1) > threshold))
						Fittest_Iter=generationCount;
			
					System.out.print("Generation: " + generationCount
							+ " F(x,y) Fittest: " + myPop.getFittest().getFitness()
							+ " F2(x,y) Fittest: "
							+ myPop.getFittest().getFitness1() + " Y=");
					str += "Generation=" + generationCount + " Fitness Function= "
							+ myPop.getFittest().getFitness1();
					Fittest = myPop.getFittest().getFitness1();
					for (int i = 0; i < myPop.getFittest().Gysize(); i++) {
						Y[i]=myPop.getFittest().getbinaryGy(i);
						System.out.print(Y[i]);
					}
					System.out.print("Xa=");
					for (int j = 0; j < myPop.getFittest().Gxasize(); j++) {
						Xa[j]=myPop.getFittest().getbinaryGxa(j);
						System.out.print(Xa[j]);
					}
					System.out.print("Xh=");
					for (int j = 0; j < myPop.getFittest().Gxhsize(); j++) {
						Xh[j]=myPop.getFittest().getbinaryGxh(j);
						System.out.print(Xh[j]);
					}
					System.out.print("Xt=");
					for (int j = 0; j < myPop.getFittest().Gxtsize(); j++) {
						Xt[j]=myPop.getFittest().getbinaryGxt(j);
						System.out.print(Xt[j]);
					}
					System.out.print(" 執行時間: " + (endTime - startTime));
					String Xa1="",Xh1="",Xt1="",Y1="";
					for(int i=0;i<Xa.length;i++)
							Xa1+=Xa[i]+" ";
					for(int i=0;i<Xh.length;i++)
						Xh1+=Xh[i]+" ";
					for(int i=0;i<Xt.length;i++)
						Xt1+=Xt[i]+" ";
					for(int i=0;i<Y.length;i++)
							Y1+=Y[i]+" ";

			Original_temp_variables_iteration.add(generationCount);
			Original_temp_variables_fitness_function_value.add(myPop.getFittest().getFitness1());
			Original_temp_variables_violate_restrictions.add(String.valueOf(constraint(Xa,Xh,Xt, Y)));
			Original_temp_variables_Global_best_Xa.add(Xa1);
			Original_temp_variables_Global_best_Xh.add(Xh1);
			Original_temp_variables_Global_best_Xt.add(Xt1);
			Original_temp_variables_Global_best_Y.add(Y1);
					str += " Time= " + (endTime - startTime) + "ms\r\n";
					System.out.println();
					myPopFitnessN_1 = myPop.getFittest().getFitness1();
					Sfmin = FitnessCalc.getSFmin(SFminsb);
					startTime = System.currentTimeMillis();

					myPop = Algorithm.evolvePopulation(myPop);
					endTime = System.currentTimeMillis();
					SFminsb = new StringBuilder();
					DE_Data_print.print2(myPop, Print_Mode);}
		}
		}
		System.out.println("Solution found!");
		System.out.println("Generation: " + generationCount);
		long totalendTime = System.currentTimeMillis();
		T_total_time = totalendTime - totalstartTime;
		System.out.println("執行時間 T_total_time=" + T_total_time + "ms");
		System.out.println("執行時間扣除寫檔時間  T_net="
				+ (T_total_time - time_write_to_TXT) + "ms");
		CheckConstraint.CheckConstraints();
		Output_Result.Tourism(Y, Xa,Xh,Xt, Fittest, generationCount, T_total_time,
				(T_total_time - time_write_to_TXT), str);
		String Xa1="",Xh1="",Xt1="",Y1="";
		for(int i=0;i<Xa.length;i++)
				Xa1+=Xa[i]+" ";
		for(int i=0;i<Xh.length;i++)
			Xh1+=Xh[i]+" ";
		for(int i=0;i<Xt.length;i++)
			Xt1+=Xt[i]+" ";
		for(int i=0;i<Y.length;i++)
				Y1+=Y[i]+" ";
		Output_EXCEL.main(N,Ia,Ih,It,K,Omega_1,Omega_2 ,Xa1,Xh1,Xt1, Y1, Fittest, Iteration, Fittest_Iter, T_total_time, (T_total_time-time_write_to_TXT),constraint(Xa,Xh,Xt, Y));
		
		 if(Iteration_Mode==2)
				Output_EXCEL.Original_data(Original_temp_variables_iteration,Original_temp_variables_fitness_function_value,Original_temp_variables_violate_restrictions,Original_temp_variables_Global_best_Xa
						,Original_temp_variables_Global_best_Xh,Original_temp_variables_Global_best_Xt,Original_temp_variables_Global_best_Y);
		 
		 Output_A_B_C_txt.A_B_C_txt(A,B,C);
		
}
	public static double Xa(int i) {
		return Xa[i];
	}
	public static double Xh(int i) {
		return Xh[i];
	}
	public static double Xt(int i) {
		return Xt[i];
	}
	public static double Y(int i) {
		return Y[i];
	}

	static boolean constraint(int[] xa,int[] xh,int[] xt, int[] y)   {
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
		
		
		right=Function_Vector.constraint(Xa,Xh,Xt,Y,A,B);
		
		return right;
	}
}
