package Algorithm_Carpool.GA2;

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
import carpool_Alogorithm_MOD.Print_input;

 
public class GA2 {

	public static double Sfmin;
	public static int Xsize = 0, Ysize = 0;
	public static int  i1=0,i2=0;
	public static int Fittest_Iter;
	public static int P;
	public static int D;
	public static int K;
	public static StringBuilder SFminsb = new StringBuilder();
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
	public static int Iteration;
	public static int Iteration_Mode;
	static StringBuilder sb2 = new StringBuilder();
	
	private static int[] X2;
	private static int[] Y2;
	
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
		 Xsize=0;
		 Ysize=0;
		 Fittest_Iter=0;
		 i1=0;
		 i2=0;
		 time_write_to_TXT=0;
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

		X2 = new int[Xsize];
		Y2 = new int[Ysize];
		Iteration_Mode=GA_Read_Write_txt.Iteration_Mode();
		if(Iteration_Mode==0 || Iteration_Mode==2){
		Iteration=GA_Read_Write_txt.Iteration();
		}else{Iteration=Xsize+Ysize+K+1+Xsize+Xsize+D;} 
		
		initialPopulationRate = GA_Read_Write_txt.initialPopulationRate();
		crossoverRate = GA_Read_Write_txt.crossoverRate();
		mutationRate = GA_Read_Write_txt.mutationRate();
		tournamentSize = GA_Read_Write_txt.tournamentSize();
		populationSize = GA_Read_Write_txt.populationSize();
		threshold = GA_Read_Write_txt.threshold();
		Execution_Mode = GA_Read_Write_txt.Execution_Mode();
		Print_Mode = GA_Read_Write_txt.Print_Mode();
		SA_Mode = GA_Read_Write_txt.SA_Mode();
		Write_Mode=GA_Read_Write_txt.Write_Mode();
		T = GA_Read_Write_txt.T();
		Omega_1=Read_Objective_Weight.Omega_1();
		Omega_2=Read_Objective_Weight.Omega_2();
		Omega_3=Read_Objective_Weight.Omega_3();
		Omega_4=Read_Objective_Weight.Omega_4();
		Omega_5=Read_Objective_Weight.Omega_5();
		Omega_6=Read_Objective_Weight.Omega_6();
		Omega_7=Read_Objective_Weight.Omega_7();
		Omega_8=Read_Objective_Weight.Omega_8();
		wp=Read_Objective_Weight.wp1();
		wd=Read_Objective_Weight.wd1();
		Epsilon1=Read_Objective_Weight.Epsilon1();
		Epsilon2=Read_Objective_Weight.Epsilon2();
		wp1=Read_Objective_Weight.wp1();
		wd1=Read_Objective_Weight.wd1();
		Epsilon3=Read_Objective_Weight.Epsilon3();
		Epsilon4=Read_Objective_Weight.Epsilon4();
		String str="";
		long totalstartTime = System.currentTimeMillis();
		long startTime = System.currentTimeMillis();
		Population myPop2 = new Population(populationSize, true);
		long endTime = System.currentTimeMillis();
		int generationCount2 = 1;
		double  myPop2FitnessN_1,Fittest;
		// Fitness Function 2(without penalty parameter): F2 (x, y)
		System.out.println();
		System.out.println("Fitness Function 2: F2(x, y)");
		 
		myPop2FitnessN_1 = myPop2.getFittest2().getFitness2();
		GA_Data_print.print2(myPop2, Print_Mode);
		Sfmin = FitnessCalc.getSFmin(SFminsb);
		System.out.print("Generation: " + generationCount2 +" F(x,y) Fittest: "+myPop2.getFittest2().getFitness()+ " F2(x,y) Fittest: "+ myPop2.getFittest2().getFitness2() + " Y=");
		str+="Generation=" + generationCount2 + " Fitness Function= "+myPop2.getFittest2().getFitness2() ;
		Fittest= myPop2.getFittest2().getFitness2();
		for (int i = 0; i < myPop2.getFittest2().Ysize(); i++) {
			Y2[i] = myPop2.getFittest2().getY(i);
			System.out.print(Y2[i]);
		}
		System.out.print("X=");
		for (int j = 0; j < myPop2.getFittest2().Xsize(); j++) {
			System.out.print(myPop2.getFittest2().getX(j));
			X2[j] = myPop2.getFittest2().getX(j);
		}
		System.out.print(" 執行時間: "+(endTime-startTime));
		 if(Iteration_Mode==2){
				String X1="",Y1="";
				for(int i=0;i<X2.length;i++)
						X1+=X2[i]+" ";
				for(int i=0;i<Y2.length;i++)
						Y1+=Y2[i]+" ";
	
		Original_temp_variables_iteration.add(generationCount2);
		Original_temp_variables_fitness_function_value.add( myPop2.getFittest2().getFitness2());
		Original_temp_variables_violate_restrictions.add(String.valueOf(constraint(X2, Y2)));
		Original_temp_variables_Global_best_X.add(X1);
		Original_temp_variables_Global_best_Y.add(Y1);
		 }
		
		str+=" Time= "+(endTime-startTime)+"ms\r\n";
		 startTime = System.currentTimeMillis();
		myPop2 = Algorithm.evolvePopulation(myPop2);
		
		 SFminsb = new StringBuilder();
		System.out.println();
		myPop2 = SA.SA_f2(myPop2FitnessN_1, myPop2, SA_Mode);
		 endTime = System.currentTimeMillis();
			 for(int iter=0;iter<Iteration;iter++){
				 
				 System.out.println("  F2(x,y) Fittest: = "+ myPop2.getFittest2().getFitness2() +"   F2(x,y) Fittest 成長值 = "+Math.abs(myPop2.getFittest2().getFitness2()-myPop2FitnessN_1)/Math.abs(myPop2FitnessN_1)+"     限制式 : " + constraint(X2, Y2));
					
				 if(Iteration_Mode!=2){
				 
				 if((Math.abs(myPop2.getFittest2().getFitness2()-myPop2FitnessN_1)/Math.abs(myPop2FitnessN_1) > threshold) || constraint(X2, Y2)==false || myPop2.getFittest2().getFitness2()<=0) {
				
			generationCount2++;
			 if(Math.abs(myPop2.getFittest2().getFitness2()-myPop2FitnessN_1)/Math.abs(myPop2FitnessN_1) > threshold) 
				 Fittest_Iter= generationCount2;
			System.out.print("Generation: " + generationCount2 +" F(x,y) Fittest: "+myPop2.getFittest2().getFitness()+ " F2(x,y) Fittest: "+ myPop2.getFittest2().getFitness2() + " Y=");
			str+="Generation=" + generationCount2 + " Fitness Function= "+myPop2.getFittest2().getFitness2() ;
			Fittest= myPop2.getFittest2().getFitness2();
			for (int i = 0; i < myPop2.getFittest2().Ysize(); i++) {
				Y2[i] = myPop2.getFittest2().getY(i);
				System.out.print(Y2[i]);
			}
			System.out.print("X=");
			for (int j = 0; j < myPop2.getFittest2().Xsize(); j++) {
				System.out.print(myPop2.getFittest2().getX(j));
				X2[j] = myPop2.getFittest2().getX(j);
			}
			GA_Data_print.print2(myPop2, Print_Mode);
			myPop2FitnessN_1 = myPop2.getFittest2().getFitness2();
			Sfmin = FitnessCalc.getSFmin(SFminsb);
			System.out.print(" 執行時間: "+(endTime-startTime));
			str+=" Time= "+(endTime-startTime)+"ms\r\n";
			 startTime = System.currentTimeMillis();
			myPop2 = Algorithm.evolvePopulation(myPop2);
			
			SFminsb = new StringBuilder();
			
			System.out.println();
			myPop2 = SA.SA_f2(myPop2FitnessN_1, myPop2, SA_Mode);
			 endTime = System.currentTimeMillis();
		}else{break;}
				 }else{
						generationCount2++;
						 if(Math.abs(myPop2.getFittest2().getFitness2()-myPop2FitnessN_1)/Math.abs(myPop2FitnessN_1) > threshold) 
							 Fittest_Iter= generationCount2;
						System.out.print("Generation: " + generationCount2 +" F(x,y) Fittest: "+myPop2.getFittest2().getFitness()+ " F2(x,y) Fittest: "+ myPop2.getFittest2().getFitness2() + " Y=");
						str+="Generation=" + generationCount2 + " Fitness Function= "+myPop2.getFittest2().getFitness2() ;
						Fittest= myPop2.getFittest2().getFitness2();
						for (int i = 0; i < myPop2.getFittest2().Ysize(); i++) {
							Y2[i] = myPop2.getFittest2().getY(i);
							System.out.print(Y2[i]);
						}
						System.out.print("X=");
						for (int j = 0; j < myPop2.getFittest2().Xsize(); j++) {
							System.out.print(myPop2.getFittest2().getX(j));
							X2[j] = myPop2.getFittest2().getX(j);
						}
						GA_Data_print.print2(myPop2, Print_Mode);
						myPop2FitnessN_1 = myPop2.getFittest2().getFitness2();
						Sfmin = FitnessCalc.getSFmin(SFminsb);
						System.out.print(" 執行時間: "+(endTime-startTime));
						String X1="",Y1="";
						for(int i=0;i<X2.length;i++)
								X1+=X2[i]+" ";
						for(int i=0;i<Y2.length;i++)
								Y1+=Y2[i]+" ";
			
						Original_temp_variables_iteration.add(generationCount2);
						Original_temp_variables_fitness_function_value.add( myPop2.getFittest2().getFitness2());
						Original_temp_variables_violate_restrictions.add(String.valueOf(constraint(X2, Y2)));
						Original_temp_variables_Global_best_X.add(X1);
						Original_temp_variables_Global_best_Y.add(Y1);
						
						str+=" Time= "+(endTime-startTime)+"ms\r\n";
						 startTime = System.currentTimeMillis();
						myPop2 = Algorithm.evolvePopulation(myPop2);
						
						SFminsb = new StringBuilder();
						
						System.out.println();
						myPop2 = SA.SA_f2(myPop2FitnessN_1, myPop2, SA_Mode);
						 endTime = System.currentTimeMillis();
				 }
			 }
		
		GA_Data_print.print2(myPop2, Print_Mode);
		System.out.println("Solution found!");
		System.out.println("Generation: " + generationCount2);
		long totalendTime = System.currentTimeMillis();
		T_total_time=totalendTime - totalstartTime;
		System.out.println("執行時間 T_total_time=" + T_total_time+"ms");
		System.out.println("執行時間扣除寫檔時間  T_net=" + (T_total_time-time_write_to_TXT)+"ms");
		CheckConstraint.CheckConstraints2();
		Print_input.main(Print_Mode);
		Output_Result.Genetic_Algorithm2(Y2, X2, Fittest, Fittest_Iter, T_total_time, (T_total_time-time_write_to_TXT),str);
		String X1="",Y1="";
		for(int i=0;i<X2.length;i++)
				X1+=X2[i]+" ";
		for(int i=0;i<Y2.length;i++)
				Y1+=Y2[i]+" ";
		Output_EXCEL.main(D,P,Omega_1,Omega_2,Omega_3,Omega_4,Omega_5,Omega_6,Omega_7,Omega_8 ,X1, Y1, Fittest, Iteration, Fittest_Iter, T_total_time, (T_total_time-time_write_to_TXT),constraint(X2, Y2));
		 if(Iteration_Mode==2)
				Output_EXCEL.Original_data(Original_temp_variables_iteration,Original_temp_variables_fitness_function_value,Original_temp_variables_violate_restrictions,Original_temp_variables_Global_best_X,Original_temp_variables_Global_best_Y);
			
	}


	public static int X2(int i) {
		return X2[i];
	}

	public static int Y2(int i) {
		return Y2[i];
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
				X[i][j] =  x[b++];

		
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
				st232 += X[d][j]* (Read_file.getCdj(d, j) - Read_file.getOdj(d, j));
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
		
		 if((Omega_4*(1-Epsilon1)*Object_Function.get_ads()) <= (Omega_4*Object_Function.get_aps())
					&& (Omega_4*Object_Function.get_aps()) >= (Omega_4*(1-Epsilon1)*Object_Function.get_ads())
					&& (Omega_4*Object_Function.get_aps()) <= (Omega_4*(1+Epsilon2)*Object_Function.get_ads()))
					 {}
					 else{
				 right=false;}
		
		 if((Omega_7*(1-Epsilon3)*Object_Function.get_cp_d()) <= (Omega_7*Object_Function.get_cp_p())
					&& (Omega_7*Object_Function.get_cp_p()) >= (Omega_7*(1-Epsilon3)*Object_Function.get_cp_d())
					&& (Omega_7*Object_Function.get_cp_p()) <= (Omega_7*(1+Epsilon4)*Object_Function.get_cp_d()))
					 {}
					 else{
				 right=false;}
		 
		if(Read_CarpoolData_Generation_Mode.mode().contains("multi_hop")){
		for(int p=0;p<Read_BPL_TXT.Bpl().size();p++){
			int a=0;
			for(int j=0;j<Read_BPL_TXT.Bpl().get(p).size();j++){
				double s8=0,s9=0;
				for(int k=0;k<Read_BPL_TXT.Bpl().get(p).get(j);k++){
					s8+=Y[p][a];
					s9+=(1-Y[p][a]);
					a+=1;
				}
				if((s8*s9)!=0)
					right = false;
			}
		}
		 
		for(int p=0;p<Read_BPL_TXT.Bpl().size();p++){
			int a=0;
			 double s11=0;
			for(int j=0;j<Read_BPL_TXT.Bpl().get(p).size();j++){
				double s10=1;
				for(int k=0;k<Read_BPL_TXT.Bpl().get(p).get(j);k++){
					s10*=Y[p][a];
					a+=1;
				}
				s11+=s10;
			}	
			if(s11>1)
				right = false;
		}
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
