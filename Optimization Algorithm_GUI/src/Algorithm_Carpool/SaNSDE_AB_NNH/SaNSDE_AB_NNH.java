package Algorithm_Carpool.SaNSDE_AB_NNH;

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
import Input_Output_txt.Carpool.Read_BPL_TXT;
import Input_Output_txt.Carpool.Read_CarpoolData_Generation_Mode;
import Input_Output_txt.Carpool.Read_Objective_Weight;
import Input_Output_txt.Carpool.Read_file;
import READ_TXT.Read_INPUT_TXT_filter;
import READ_TXT.Read_distance;
import READ_TXT.Read_filter_and_detour_rate;
 
public class SaNSDE_AB_NNH {

	public static int Xsize = 0, Ysize = 0;
	public static int i1 = 0, i2 = 0;
	public static int Fittest_Iter;
	public static int D;
	public static int P;
	public static int K;
	public static double w;
	public static double c1;
	public static double c2;
	public static int Vmax;
	public static int Execution_Mode;
	public static int Write_Mode;
	public static int Print_Mode;
	public static int populationSize;
	public static double threshold;
	public static int LP;
	//public static double Epsilon;
	public static int Iteration;
	public static int Iteration_Mode;
	public static double Omega_1,Omega_2,Omega_3,Omega_4,Omega_5,Omega_6,Omega_7,Omega_8;
	public static double lamda;
	
//	public static double f;
//	public static double cr;

	public static double[] F;
	public static double[] CR;
	public static int[] GX;
	public static int[] GY;
	public static int[] GA;
	public static int[] GB;
	public static int[] Grid;
	public static int[] GSi;
	public static double Sfmin;
	public static int generationCount;
	public static StringBuilder SFminsb = new StringBuilder();
	public static StringBuilder sb = new StringBuilder();
	public static StringBuilder sb1 = new StringBuilder();
	public static int b;
	public static int n = 0;// 計算batch次數
	public static ArrayList<Double> CRrec = new ArrayList<Double>();
	public static ArrayList<Double> frec = new ArrayList<Double>();
	public static ArrayList<Integer> strategy = new ArrayList<Integer>();
	public static double ns1,ns2,nf1,nf2;
	public static double p,CRm;
	
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
	
	public static double Global_fittest =-999999999;
	
	public static List<List<Integer>> Md = new ArrayList<List< Integer >>();
	
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
		Read_CarpoolData_Generation_Mode.main();
		if(Read_CarpoolData_Generation_Mode.mode().contains("multi_hop")){
			Read_BPL_TXT.main();
		}
		try {
			Order();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Sfmin=0;
		SFminsb = new StringBuilder();
		Global_fittest =-999999999;
		time_write_to_TXT = 0;
		ns1=0;
		ns2=0;
		nf1=0;
		nf2=0;
		p=0.5;
		CRm=0.5;
		CRrec = new ArrayList<Double>();
		frec = new ArrayList<Double>();
		strategy = new ArrayList<Integer>();
		Xsize = 0;
		Ysize = 0;
		i1 = 0;
		i2 = 0;
		Fittest_Iter=0;
		n = 0;
		sb = new StringBuilder();
		sb1 = new StringBuilder();
		Read_file.loadData();
		P = Read_INPUT_TXT_filter.getP();
		D = Read_INPUT_TXT_filter.getD();
		K = Read_file.getK();

		for (int i = 0; i < D; i++)
			Xsize += Read_file.getJd(i);
		for (int i = 0; i < P; i++)
			Ysize += Read_file.getHp(i);

		GX = new int[D];
		GY = new int[P];
		GA = new int[P];
		GB = new int[P*2];
		Grid= new int[P];
		GSi= new int[P];
		
		DE_Read_Write_txt.Read_SaNSDE_Parameter(); 
		populationSize = DE_Read_Write_txt.NP();
		LP = DE_Read_Write_txt.LP();
		//Epsilon = DE_Read_Write_txt.Epsilon();

		Iteration_Mode = DE_Read_Write_txt.Iteration_Mode();

		if (Iteration_Mode == 0|| Iteration_Mode==2) {
			Iteration = DE_Read_Write_txt.Iteration();
		} else {
			Iteration = Xsize + Ysize + K + 1 + D * K;
		}
		System.out.print(Iteration);
		
		Execution_Mode = DE_Read_Write_txt.Execution_Mode();
		Write_Mode = DE_Read_Write_txt.write_Mode();
		
		Read_Objective_Weight.main();
		Omega_1=Read_Objective_Weight.Omega_1();
		Omega_2=Read_Objective_Weight.Omega_2();
		Omega_3=Read_Objective_Weight.Omega_3();
		Omega_4=Read_Objective_Weight.Omega_4();
		Omega_5=Read_Objective_Weight.Omega_5();
		Omega_6=Read_Objective_Weight.Omega_6();
		Omega_7=Read_Objective_Weight.Omega_7();
		Omega_8=Read_Objective_Weight.Omega_8();
		wp=Read_Objective_Weight.wp();
		wd=Read_Objective_Weight.wd();
		Epsilon1=Read_Objective_Weight.Epsilon1();
		Epsilon2=Read_Objective_Weight.Epsilon2();
		wp1=Read_Objective_Weight.wp1();
		wd1=Read_Objective_Weight.wd1();
		Epsilon3=Read_Objective_Weight.Epsilon3();
		Epsilon4=Read_Objective_Weight.Epsilon4();
		
		Vmax=DE_Read_Write_txt.Vmax();
		lamda=-DE_Read_Write_txt.lamda();
		F=new double[populationSize];
		CR=new double[populationSize];
		
		for(int i=0;i<populationSize;i++){
			F[i]=DE_Read_Write_txt.random_generate_or_read3(Execution_Mode)*0.3+0.5;
			CR[i]=DE_Read_Write_txt.random_generate_or_read3(Execution_Mode)*0.1+CRm;
		}
		
		Md = new ArrayList<List< Integer >>();
		Check_DetourRation.main();
		
		System.out.println();
		System.out.print("Md="+Md);
 
		generationCount = 1;
		String str = "";
		long totalstartTime = System.currentTimeMillis();
		long startTime = System.currentTimeMillis();
		Population myPop = new Population(populationSize, true);
		long endTime = System.currentTimeMillis();
		
		double myPopFitnessN_1, Fittest;
		// F(X,Y)
		System.out.println();
		System.out.println("F2(X,Y)");
		DE_Data_print.print2(myPop, Print_Mode);
		System.out.print("Generation: " + generationCount + " F(x,y) Fittest: "+ myPop.getFittest().getFitness() + " F2(x,y) Fittest: "	+ Global_fittest  + " Y=");
		str += "Generation=" + generationCount + " Fitness Function= "+ Global_fittest ;
		Fittest = Global_fittest ;
		
		for (int i = 0; i < myPop.getFittest().binaryYsize(); i++) {
			System.out.print(GY[i]);
		}
		System.out.print("X=");
		for (int j = 0; j < myPop.getFittest().binaryXsize(); j++) {
		 
			System.out.print(GX[j]);
		}
		System.out.print(" 執行時間: " + (endTime - startTime));
		 if(Iteration_Mode==2){
				String X1="",Y1="";
				for(int i=0;i<GX.length;i++)
						X1+=GX[i]+" ";
				for(int i=0;i<GY.length;i++)
						Y1+=GY[i]+" ";
	
		Original_temp_variables_iteration.add(generationCount);
		Original_temp_variables_fitness_function_value.add( Global_fittest );
		Original_temp_variables_violate_restrictions.add(String.valueOf(CheckConstraint.CheckConstraints_boolean(GA, GB)));
		Original_temp_variables_Global_best_X.add(X1);
		Original_temp_variables_Global_best_Y.add(Y1);
		 }
		
		str += " Time= " + (endTime - startTime) + "ms\r\n";
		System.out.println();
		myPopFitnessN_1 = Global_fittest ;
		Sfmin = FitnessCalc.getSFmin(SFminsb);
		startTime = System.currentTimeMillis();

		myPop = Algorithm.evolvePopulation(myPop);
		endTime = System.currentTimeMillis();
		SFminsb = new StringBuilder();
		DE_Data_print.print2(myPop, Print_Mode);

		/*
		 * while (Math.abs(Global_fittest  - myPopFitnessN_1) /
		 * Math.abs(myPopFitnessN_1) > threshold) {
		 */
		for (int t = 0; t < Iteration; t++) {
			 System.out.println("  F2(x,y) Fittest: = "+ Global_fittest  +"   F2(x,y) Fittest 成長值 = "+Math.abs(Global_fittest -myPopFitnessN_1)/Math.abs(myPopFitnessN_1)+"     限制式 : " + CheckConstraint.CheckConstraints_boolean(GA, GB));
			 
			 if(Iteration_Mode!=2){
			 if((Math.abs(Global_fittest -myPopFitnessN_1)/Math.abs(myPopFitnessN_1) > threshold) || CheckConstraint.CheckConstraints_boolean(GA, GB)==false || Global_fittest <=0) {
	

				if (generationCount % LP ==0)
					Function.Update_p_f_cr();

				generationCount++;
			//	if((Math.abs(Global_fittest-myPopFitnessN_1)/Math.abs(myPopFitnessN_1) > threshold))
				//	Fittest_Iter=generationCount;
				System.out.print("Generation: " + generationCount
						+ " F(x,y) Fittest: " + myPop.getFittest().getFitness()
						+ " F2(x,y) Fittest: "
						+ Global_fittest  + " Y=");
				str += "Generation=" + generationCount + " Fitness Function= "
						+ Global_fittest ;
				Fittest = Global_fittest ;
				for (int i = 0; i < myPop.getFittest().binaryYsize(); i++) {
			
					System.out.print(GY[i]);
				}
					
				
				System.out.print("X=");
				for (int j = 0; j < myPop.getFittest().binaryXsize(); j++) {
				
					System.out.print(GX[j]);
				}
				System.out.print(" 執行時間: " + (endTime - startTime));
				str += " Time= " + (endTime - startTime) + "ms\r\n";
				System.out.println();
				myPopFitnessN_1 = Global_fittest ;
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
					if (generationCount % LP ==0)
						Function.Update_p_f_cr();
				 generationCount++;
			//		if((Math.abs(Global_fittest-myPopFitnessN_1)/Math.abs(myPopFitnessN_1) > threshold))
				//		Fittest_Iter=generationCount;
					System.out.print("Generation: " + generationCount
							+ " F(x,y) Fittest: " + myPop.getFittest().getFitness1()
							+ " F2(x,y) Fittest: "
							+ Global_fittest  + " Y=");
					str += "Generation=" + generationCount + " Fitness Function= "
							+ Global_fittest ;
					Fittest = Global_fittest ;
					for (int i = 0; i < myPop.getFittest().binaryYsize(); i++) {
						System.out.print(GY[i]);
					}
					System.out.print("X=");
					for (int j = 0; j < myPop.getFittest().binaryXsize(); j++) {
						System.out.print(GX[j]);
					}
					String X1="",Y1="";
					for(int i=0;i<GX.length;i++)
							X1+=GX[i]+" ";
					for(int i=0;i<GY.length;i++)
							Y1+=GY[i]+" ";
					
					System.out.print(" 執行時間: "+(endTime-startTime));
					Original_temp_variables_iteration.add(generationCount);
					Original_temp_variables_fitness_function_value.add( Global_fittest );
					Original_temp_variables_violate_restrictions.add(String.valueOf(CheckConstraint.CheckConstraints_boolean(GA, GB)));
					Original_temp_variables_Global_best_X.add(X1);
					Original_temp_variables_Global_best_Y.add(Y1);
					str += " Time= " + (endTime - startTime) + "ms\r\n";
					System.out.println();
					myPopFitnessN_1 = Global_fittest ;
					Sfmin = FitnessCalc.getSFmin(SFminsb);
					startTime = System.currentTimeMillis();

					myPop = Algorithm.evolvePopulation(myPop);
					endTime = System.currentTimeMillis();
					SFminsb = new StringBuilder();
					DE_Data_print.print2(myPop, Print_Mode);
			 }
		}

		System.out.println("Solution found!");
		System.out.println("Generation: " + generationCount);
		long totalendTime = System.currentTimeMillis();
		T_total_time = totalendTime - totalstartTime;
		System.out.println("執行時間 T_total_time=" + T_total_time + "ms");
		System.out.println("執行時間扣除寫檔時間  T_net="
				+ (T_total_time - time_write_to_TXT) + "ms");
		CheckConstraint.CheckConstraints(GA, GB);
	
		Output_Result.SaNSDE_AB_NNH(GY, GX, Fittest, Fittest_Iter,T_total_time, (T_total_time-time_write_to_TXT),str);
		String X1="",Y1="";
		for(int i=0;i<GX.length;i++)
			X1+=GX[i]+" ";
		for(int i=0;i<GY.length;i++)
			Y1+=GY[i]+" ";
		Output_EXCEL.main(D,P,Omega_1,Omega_2,Omega_3,Omega_4,Omega_5,Omega_6,Omega_7,Omega_8 ,X1, Y1, Fittest, Iteration, Fittest_Iter, T_total_time, (T_total_time-time_write_to_TXT),CheckConstraint.CheckConstraints_boolean(GA, GB));
		 if(Iteration_Mode==2)
		Output_EXCEL.Original_data(Original_temp_variables_iteration,Original_temp_variables_fitness_function_value,Original_temp_variables_violate_restrictions,Original_temp_variables_Global_best_X,Original_temp_variables_Global_best_Y);
		decoding_ABString.main();
	}

	public static double X(int i) {
		return GX[i];
	}

	public static double Y(int i) {
		return GY[i];
	}
	public static double A(int i) {
		return GA[i];
	}

	public static double B(int i) {
		return GB[i];
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
