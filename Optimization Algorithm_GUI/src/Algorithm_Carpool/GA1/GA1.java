package Algorithm_Carpool.GA1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import GUI.I_Set_Paths_for_Current_Simulation_Example;
import Generate_random_data.Read_Generate_random_OilConsumptionBounds;
import Input_Output_txt.Carpool.Output_EXCEL;
import Input_Output_txt.Carpool.Output_Result;
import Input_Output_txt.Carpool.Read_Objective_Weight;
import Input_Output_txt.Carpool.Read_file;
import READ_TXT.Read_INPUT_TXT_filter;
import READ_TXT.Read_distance;
import READ_TXT.Read_filter_and_detour_rate;
import carpool_Alogorithm_MOD.Print_input;

public class GA1 {

	public static int Xsize = 0, Ysize = 0;
	public static int P;
	public static int D;
	public static int K;
	public static int i1 = 0;
	public static int i2 = 0;
	public static int Fittest_Iter;
	private static int Iteration;
	private static int Iteration_Mode;
	public static double initialPopulationRate;
	public static double crossoverRate;
	public static double mutationRate;
	public static int tournamentSize;
	public static int populationSize;
	public static double threshold;
	public static int Execution_Mode;
	public static int Print_Mode;
	public static int SA_Mode;
	public static int Write_Mode;
	public static double T;
	public static double Omega_1,Omega_2,Omega_3,Omega_4,Omega_5,Omega_6,Omega_7,Omega_8;
	static StringBuilder sb2 = new StringBuilder();

	private static int[] X1;
	private static int[] Y1;

	public static long time_write_to_TXT;
	public static long T_total_time;

	public static double wp;
	public static double wd;
	public static double Epsilon1;
	public static double Epsilon2;
	
	public static double wp1;
	public static double wd1;
	public static double Epsilon3;
	public static double Epsilon4;
	
	public static String[][]  Orders;
	public static int[][] Order;
	public static int[] Order_lengh;
	private static List<Integer> Original_temp_variables_iteration = new ArrayList<Integer>();
	private static List<Double> Original_temp_variables_fitness_function_value = new ArrayList<Double>();
	private static List<String> Original_temp_variables_violate_restrictions = new ArrayList<String>();
	
	private static List<String> Original_temp_variables_Global_best_X = new ArrayList<String>();
	private static List<String> Original_temp_variables_Global_best_Y = new ArrayList<String>();
	public static void main() throws IOException {
		Original_temp_variables_iteration = new ArrayList<Integer>();
		Original_temp_variables_fitness_function_value = new ArrayList<Double>();
		Original_temp_variables_violate_restrictions = new ArrayList<String>();
		Original_temp_variables_Global_best_X = new ArrayList<String>();
		Original_temp_variables_Global_best_Y = new ArrayList<String>();
		
		try {
			Read_Generate_random_OilConsumptionBounds.main();
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Read_distance.Read_distance();
		Read_INPUT_TXT_filter.loadData();
		Read_filter_and_detour_rate.main();
		try {
			Order();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Xsize = 0;
		Ysize = 0;
		Fittest_Iter=0;
		time_write_to_TXT = 0;
		i1 = 0;
		i2 = 0;
		Read_file.loadData();
		GA_Read_Write_txt.read_GA_Parameters();
		Read_Objective_Weight.main();

		P = Read_file.getP();
		D = Read_file.getD();
		K = Read_file.getK();

		for (int i = 0; i < D; i++)
			Xsize += Read_file.getJd(i);
		for (int i = 0; i < P; i++)
			Ysize += Read_file.getHp(i);

		X1 = new int[Xsize];
		Y1 = new int[Ysize];
		Iteration_Mode = GA_Read_Write_txt.Iteration_Mode();
		if (Iteration_Mode == 0 || Iteration_Mode==2) {
			Iteration = GA_Read_Write_txt.Iteration();
		} else {
			Iteration = Xsize + Ysize + K + 1 + Xsize + Xsize + D;
		}

		initialPopulationRate = GA_Read_Write_txt.initialPopulationRate();
		crossoverRate = GA_Read_Write_txt.crossoverRate();
		mutationRate = GA_Read_Write_txt.mutationRate();
		tournamentSize = GA_Read_Write_txt.tournamentSize();
		populationSize = GA_Read_Write_txt.populationSize();
		threshold = GA_Read_Write_txt.threshold();
		Execution_Mode = GA_Read_Write_txt.Execution_Mode();
		Print_Mode = GA_Read_Write_txt.Print_Mode();
		SA_Mode = GA_Read_Write_txt.SA_Mode();
		Write_Mode = GA_Read_Write_txt.Write_Mode();
		T = GA_Read_Write_txt.T();

		Omega_1 = Read_Objective_Weight.Omega_1();
		Omega_2 = Read_Objective_Weight.Omega_2();
		Omega_3=Read_Objective_Weight.Omega_3();
		Omega_4=Read_Objective_Weight.Omega_4();
		Omega_5=Read_Objective_Weight.Omega_5();
		Omega_6=Read_Objective_Weight.Omega_6();
		Omega_7=Read_Objective_Weight.Omega_7();
		Omega_8=Read_Objective_Weight.Omega_8();
		wp1=Read_Objective_Weight.wp1();
		wd1=Read_Objective_Weight.wd1();
		Epsilon3=Read_Objective_Weight.Epsilon3();
		Epsilon4=Read_Objective_Weight.Epsilon4();
		String str = "";
		long totalstartTime = System.currentTimeMillis();
		long startTime = System.currentTimeMillis();
		Population myPop1 = new Population(populationSize, true);
		long endTime = System.currentTimeMillis();
		int generationCount1 = 1;
		double myPop1FitnessN_1, Fittest;
		// Fitness Function 1: F1(x, y)
		System.out.println();
		System.out.println("Fitness Function 1: F1(x, y)");
		// str+="Fitness Function 1: F1(x, y)\r\n";
		myPop1FitnessN_1 = myPop1.getFittest1().getFitness1();
		GA_Data_print.print1(myPop1, Print_Mode);
		System.out.print("Generation: " + generationCount1
				+ " F(x,y) Fittest: " + myPop1.getFittest1().getFitness()
				+ " F1(x,y) Fittest: " + myPop1.getFittest1().getFitness1()
				+ " " + " Y=");
		str += "Generation=" + generationCount1 + " Fitness Function= "
				+ myPop1.getFittest1().getFitness1();
		Fittest = myPop1.getFittest1().getFitness1();
		for (int i = 0; i < myPop1.getFittest1().Ysize(); i++) {
			Y1[i] = myPop1.getFittest1().getY(i);
			System.out.print(Y1[i]);
			// str+=Y1[i];
		}
		System.out.print("X=");
		// str+="X=";
		for (int j = 0; j < myPop1.getFittest1().Xsize(); j++) {
			System.out.print(myPop1.getFittest1().getX(j));
			X1[j] = myPop1.getFittest1().getX(j);
			// str+=X1[j];
		}
		System.out.print(" 執行時間: " + (endTime - startTime));
		 if(Iteration_Mode==2){
				String X="",Y="";
				for(int i=0;i<X1.length;i++)
						X+=X1[i]+" ";
				for(int i=0;i<Y1.length;i++)
						Y+=Y1[i]+" ";
	
		Original_temp_variables_iteration.add(generationCount1);
		Original_temp_variables_fitness_function_value.add( myPop1.getFittest1().getFitness1());
		Original_temp_variables_violate_restrictions.add(String.valueOf(constraint(X1, Y1)));
		Original_temp_variables_Global_best_X.add(X);
		Original_temp_variables_Global_best_Y.add(Y);
		 }
		str += " Time " + (endTime - startTime) + "ms\r\n";
		startTime = System.currentTimeMillis();
		myPop1 = Algorithm.evolvePopulation(myPop1);

		GA_Data_print.print1(myPop1, Print_Mode);
		System.out.println();
		myPop1 = SA.SA_f1(myPop1FitnessN_1, myPop1, SA_Mode);
		endTime = System.currentTimeMillis();
		for (int iter = 0; iter < Iteration; iter++) {
			
			 System.out.println("  F1(x,y) Fittest: = "+ myPop1.getFittest1().getFitness1() +"   F1(x,y) Fittest 成長值 = "+Math.abs(myPop1.getFittest1().getFitness1()-myPop1FitnessN_1)/Math.abs(myPop1FitnessN_1)+"     限制式 : " + constraint(X1, Y1));
				
			 if(Iteration_Mode!=2){
			 
			 if((Math.abs(myPop1.getFittest1().getFitness1()-myPop1FitnessN_1)/Math.abs(myPop1FitnessN_1) > threshold) || constraint(X1, Y1)==false || myPop1.getFittest1().getFitness1()<=0) {
				
				myPop1FitnessN_1 = myPop1.getFittest1().getFitness1();
				generationCount1++;
				 if((Math.abs(myPop1.getFittest1().getFitness1()-myPop1FitnessN_1)/Math.abs(myPop1FitnessN_1) > threshold))
					 Fittest_Iter=generationCount1;
				System.out.print("Generation: " + generationCount1
						+ " F(x,y) Fittest: "
						+ myPop1.getFittest1().getFitness()
						+ " F1(x,y) Fittest: "
						+ myPop1.getFittest1().getFitness1() + " " + " Y=");
				str += "Generation=" + generationCount1 + " Fitness Function= "
						+ myPop1.getFittest1().getFitness1();
				Fittest = myPop1.getFittest1().getFitness1();
				for (int i = 0; i < myPop1.getFittest1().Ysize(); i++) {
					Y1[i] = myPop1.getFittest1().getY(i);
					System.out.print(Y1[i]);
					// str+=Y1[i];
				}
				System.out.print("X=");
				// str+="X=";
				for (int j = 0; j < myPop1.getFittest1().Xsize(); j++) {
					System.out.print(myPop1.getFittest1().getX(j));
					X1[j] = myPop1.getFittest1().getX(j);
					// str+=X1[j];
				}
				System.out.print(" 執行時間: " + (endTime - startTime));
				str += " Time = " + (endTime - startTime) + "ms\r\n";
				startTime = System.currentTimeMillis();

				myPop1 = Algorithm.evolvePopulation(myPop1);
				GA_Data_print.print1(myPop1, Print_Mode);
				System.out.println();
				myPop1 = SA.SA_f1(myPop1FitnessN_1, myPop1, SA_Mode);
				endTime = System.currentTimeMillis();
			} else {
				break;
			}
				}else{
					myPop1FitnessN_1 = myPop1.getFittest1().getFitness1();
					generationCount1++;
					 if((Math.abs(myPop1.getFittest1().getFitness1()-myPop1FitnessN_1)/Math.abs(myPop1FitnessN_1) > threshold))
						 Fittest_Iter=generationCount1;
					System.out.print("Generation: " + generationCount1
							+ " F(x,y) Fittest: "
							+ myPop1.getFittest1().getFitness()
							+ " F1(x,y) Fittest: "
							+ myPop1.getFittest1().getFitness1() + " " + " Y=");
					str += "Generation=" + generationCount1 + " Fitness Function= "
							+ myPop1.getFittest1().getFitness1();
					Fittest = myPop1.getFittest1().getFitness1();
					for (int i = 0; i < myPop1.getFittest1().Ysize(); i++) {
						Y1[i] = myPop1.getFittest1().getY(i);
						System.out.print(Y1[i]);
						// str+=Y1[i];
					}
					System.out.print("X=");
					// str+="X=";
					for (int j = 0; j < myPop1.getFittest1().Xsize(); j++) {
						System.out.print(myPop1.getFittest1().getX(j));
						X1[j] = myPop1.getFittest1().getX(j);
						// str+=X1[j];
					}
					String X="",Y="";
					for(int i=0;i<X1.length;i++)
							X+=X1[i]+" ";
					for(int i=0;i<Y1.length;i++)
							Y+=Y1[i]+" ";
					
					System.out.print(" 執行時間: "+(endTime-startTime));
					Original_temp_variables_iteration.add(generationCount1);
					Original_temp_variables_fitness_function_value.add( myPop1.getFittest1().getFitness1());
					Original_temp_variables_violate_restrictions.add(String.valueOf(constraint(X1, Y1)));
					Original_temp_variables_Global_best_X.add(X);
					Original_temp_variables_Global_best_Y.add(Y);
					str += " Time = " + (endTime - startTime) + "ms\r\n";
					startTime = System.currentTimeMillis();

					myPop1 = Algorithm.evolvePopulation(myPop1);
					GA_Data_print.print1(myPop1, Print_Mode);
					System.out.println();
					myPop1 = SA.SA_f1(myPop1FitnessN_1, myPop1, SA_Mode);
					endTime = System.currentTimeMillis();
				}
		}

		GA_Data_print.print1(myPop1, Print_Mode);
		System.out.println("Solution found!");
		System.out.println("Generation: " + generationCount1);
		long totalendTime = System.currentTimeMillis();
		// str+="Solution found!\r\n"+"Generation: " +
		// generationCount1+"\r\n"+"總執行時間="+(totalendTime-totalstartTime)+"ms";
		T_total_time = totalendTime - totalstartTime;
		System.out.println("執行時間 T_total_time=" + T_total_time + "ms");
		System.out.println("執行時間扣除寫檔時間  T_net="
				+ (T_total_time - time_write_to_TXT) + "ms");
		CheckConstraint.CheckConstraints1();
		Print_input.main(Print_Mode);
		Output_Result.Genetic_Algorithm1(Y1, X1, Fittest, Fittest_Iter,
				T_total_time, (T_total_time - time_write_to_TXT), str);
		
		String X="",Y="";
		for(int i=0;i<X1.length;i++)
				X+=X1[i]+" ";
		for(int i=0;i<Y1.length;i++)
				Y+=Y1[i]+" ";
		Output_EXCEL.main(D,P,Omega_1,Omega_2,Omega_3,Omega_4,Omega_5,Omega_6,Omega_7,Omega_8 ,X, Y, Fittest, Iteration, Fittest_Iter, T_total_time, (T_total_time-time_write_to_TXT),constraint(X1, Y1));
		 if(Iteration_Mode==2)
		Output_EXCEL.Original_data(Original_temp_variables_iteration,Original_temp_variables_fitness_function_value,Original_temp_variables_violate_restrictions,Original_temp_variables_Global_best_X,Original_temp_variables_Global_best_Y);
			
	}

	public static int X1(int i) {
		return X1[i];
	}

	public static int Y1(int i) {
		return Y1[i];
	}

	static boolean constraint(int[] x, int[] y) {
		boolean right = true;

		int c = 0;
		int[][] Y = new int[P][];
		for (int i = 0; i < P; i++)
			Y[i] = new int[Read_file.getHp(i)];
		int[][] X = new int[D][];
		for (int i = 0; i < D; i++)
			X[i] = new int[Read_file.getJd(i)];
		int b = 0;
		for (int i = 0; i < P; i++)
			for (int j = 0; j < Y[i].length; j++)
				Y[i][j] = y[c++];

		for (int i = 0; i < D; i++)
			for (int j = 0; j < X[i].length; j++)
				X[i][j] = x[b++];

		double st221 = 0, st222 = 0;
		for (int k = 0; k < K; k++) {
			for (int d = 0; d < D; d++)
				for (int j = 0; j < X[d].length; j++)
					st221 += X[d][j] * Read_file.getqdjk(d, j, k);

			for (int p = 0; p < P; p++)
				for (int h = 0; h < Y[p].length; h++)
					st222 += Y[p][h] * Read_file.getSphk(p, h, k);

			if (st221 < st222)
				right = false;

			st221 = 0;
			st222 = 0;
		}
		double st231 = 0, st232 = 0;

		for (int p = 0; p < P; p++)
			for (int h = 0; h < Y[p].length; h++)
				st231 += Y[p][h] * Read_file.getfph(p, h);
		for (int d = 0; d < D; d++)
			for (int j = 0; j < X[d].length; j++)
				st232 += X[d][j]
						* (Read_file.getCdj(d, j) - Read_file.getOdj(d, j));
		if (st231 < st232)
			right = false;

		double st241 = 0;
		for (int d = 0; d < D; d++)
			for (int j = 0; j < X[d].length; j++) {
				for (int k = 0; k < K; k++)
					st241 += X[d][j] * Read_file.getqdjk(d, j, k);
				if (st241 > Read_file.getadj(d, j))
					right = false;
				st241 = 0;
			}

		double st251 = 0;
		for (int d = 0; d < D; d++)
			for (int j = 0; j < X[d].length; j++) {
				for (int k = 0; k < K; k++)
					st251 += X[d][j] * Read_file.getWqdjk(d, j, k);
				if (st251 > Read_file.getldj(d, j))
					right = false;
				st251 = 0;
			}
		int st261 = 0;
		for (int d = 0; d < D; d++) {
			st261 = 0;
			for (int j = 0; j < X[d].length; j++) {
				st261 += X[d][j];
			}
			if (st261 > 1)
				right = false;
		}
		return right;
	}
	
	 static void Order() throws Exception{
		 
		 String str;
			Vector<String []> str_vec = new Vector<String []>(); //暫存
			try {
				FileReader PBr = new FileReader(I_Set_Paths_for_Current_Simulation_Example.path()+"\\Carpool\\Orders.txt");
				BufferedReader br = new BufferedReader(PBr);
				while ((str = br.readLine()) != null) { //每次讀一行
			
			str_vec.add(str.split(",")); //將此行以空白(white space)切成字串陣列, 存入 Vector暫存 
			}
			br.close(); //關檔
			
			Orders = new String [str_vec.size()][]; 
			for (int i = 0; i < str_vec.size(); i++)
				Orders[i] = str_vec.elementAt(i);
		     } catch (Exception e) {
		 		e.printStackTrace();
				}
			
		    Order = new int[Orders.length][];
		    Order_lengh= new int[Orders.length];
		   
		    for(int i=0;i<Orders.length;i++){
		    	Order[i]=new int[Orders[i].length];
		    }
		   
			   for (int i = 0; i < Orders.length; i++) {
			    	for (int j =0; j < Orders[i].length; j++) 
			    		Order[i][j]=Integer.parseInt(Orders[i][j]);
			    	Order_lengh[i]=Orders[i].length;
			   }

	 }
}
