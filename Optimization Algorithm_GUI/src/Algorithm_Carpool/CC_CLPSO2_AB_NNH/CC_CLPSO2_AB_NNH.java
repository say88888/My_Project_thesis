package Algorithm_Carpool.CC_CLPSO2_AB_NNH;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import GUI.I_Set_Paths_for_Current_Simulation_Example;
import Generate_random_data.Read_Generate_random_OilConsumptionBounds;
import Input_Output_txt.Batch.Read_PSO_Batch_Parameter;
import Input_Output_txt.Carpool.Output_EXCEL;
import Input_Output_txt.Carpool.Output_Result;
import Input_Output_txt.Carpool.Read_BPL_TXT;
import Input_Output_txt.Carpool.Read_CarpoolData_Generation_Mode;
import Input_Output_txt.Carpool.Read_Group_Size;
import Input_Output_txt.Carpool.Read_Objective_Weight;
import Input_Output_txt.Carpool.Read_file;
import READ_TXT.Read_INPUT_TXT_filter;
import READ_TXT.Read_distance;
import READ_TXT.Read_filter_and_detour_rate;
import carpool_Alogorithm_MOD.Print_input;

public class CC_CLPSO2_AB_NNH {

	public static int Xsize = 0, Ysize = 0;
	public static int  i1=0,i2=0,i3=0,i4=0;
	public static int Fittest_Iter;
	public static int P;
	public static int D;
	public static int K;
	public static double w;
	public static double c1;
	public static double c2;
	public static double Pc;
	public static int Vmax;
	public static int Execution_Mode;
	public static int Print_Mode;
	public static int Write_Mode;
	public static int populationSize;
	public static double threshold;
	public static double PSO_lamda;
	public static double Alpha1,Alpha2,Alpha3;
	private static int Iteration;
	private static int Iteration_Mode;
	public static double Omega_1,Omega_2,Omega_3,Omega_4,Omega_5,Omega_6,Omega_7,Omega_8;
	private static int[] X;
	private static int[] Y;
	public static int[] GX;
	public static int[] GY;
	public static int[] GA;
	public static int[] GB;
	public static int[] Grid;
	public static int[] GSi;
	private static int[] X_Batch;
	private static int[] Y_Batch;
	public static double Sfmin;
	public static int generationCount;
	public static StringBuilder SFminsb = new StringBuilder();
	public static StringBuilder sb = new StringBuilder();
	public static StringBuilder sb1 = new StringBuilder();
	public static StringBuilder sb2 = new StringBuilder();
	public static StringBuilder sb3 = new StringBuilder();
	public static int n=0;//計算batch次數
	
	public static int KS; //分群的次數
	public static int n_lengh; //n 的長
	public static int[] S={2,5,10};
	public static int s;
	public static List<List<Integer>> n3 = new ArrayList<List<Integer>>();
	
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
	
	public static List<List<Integer>> Md = new ArrayList<List< Integer >>();
	public static void main(  ) throws IOException {
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
		time_write_to_TXT=0;
		Xsize=0;
		 Ysize=0;
		 Fittest_Iter=0;
		 i1=0;
		 i2=0;
		 n=0;
		 sb=new StringBuilder();
		 sb1=new StringBuilder();
		 Read_file.loadData();
			P = Read_INPUT_TXT_filter.getP();
			D = Read_INPUT_TXT_filter.getD();
			K = Read_file.getK();
			
			GX = new int[D];
			GY = new int[P];
			GA = new int[P];
			GB = new int[P*2];
			Grid= new int[P];
			GSi= new int[P];
			Xsize=P;
			Ysize=P;
		X_Batch = new int[Xsize];
		Y_Batch = new int[Ysize];
 
		if(GUI.main.getmethod()!=2){
		PSO_Read_Write_txt.read_PSO_Parameter();
		 
		Iteration_Mode=PSO_Read_Write_txt.Iteration_Mode();
		if(Iteration_Mode==0  || Iteration_Mode==2){
		Iteration=PSO_Read_Write_txt.Iteration();
		}else{Iteration=Xsize+Ysize+K+1+Xsize+Xsize+D;} 
		
		populationSize=PSO_Read_Write_txt.populationSize();
		w=PSO_Read_Write_txt.w();
		c1=PSO_Read_Write_txt.c1();
		c2=PSO_Read_Write_txt.c2();
		Vmax=PSO_Read_Write_txt.Vmax();
		Execution_Mode=PSO_Read_Write_txt.Execution_Mode();
		Print_Mode=PSO_Read_Write_txt.Print_Mode();
		threshold=PSO_Read_Write_txt.threshold();
		PSO_lamda=PSO_Read_Write_txt.PSO_lamda();
		Pc=PSO_Read_Write_txt.Pc();
		
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
		
		Md = new ArrayList<List< Integer >>();
		Check_DetourRation.main();
		
		Read_Group_Size.main();
		S=new int[Read_Group_Size.S().size()];
		for(int i=0;i<Read_Group_Size.S().size();i++)
			S[i]=Read_Group_Size.S().get(i);
		long totalstartTime = System.currentTimeMillis();
		n3 = new ArrayList<List<Integer>>();
		//進行分群
		PSO_Read_Write_txt.random_generate_or_read4(Execution_Mode);
		/*for(int i=0;i<n3.size();i++){
			for(int j=0;j<n3.get(i).size();j++)
				System.out.print(n3.get(i).get(j)+" ");
			System.out.println();
		}*/
		String str="";
		
		long startTime = System.currentTimeMillis();
		Population myPop = new Population(populationSize, true);
		long endTime = System.currentTimeMillis();
		  generationCount = 1;
		double myPopFitnessN_1,Fittest;
		// F(X,Y)
		System.out.println();
		System.out.println("F2(X,Y)");
		PSO_Data_print.print2(myPop,Print_Mode);
		System.out.print("Generation: " + generationCount +  " F(x,y) Fittest: "+ myPop.getFittest().getFitness() + " F2(x,y) Fittest: "+ myPop.getFittest().getFitness1() + " Y=");
		str+="Generation=" + generationCount + " Fitness Function= "+myPop.getFittest().getFitness1();
		Fittest=myPop.getFittest().getFitness1() ;
		for (int i = 0; i < myPop.getFittest().binaryGysize(); i++) {
			GY[i]=myPop.getFittest().getbinaryGy(i);
			System.out.print(GY[i]);
		}
		System.out.print("X=");
		for (int j = 0; j < myPop.getFittest().binaryGxsize(); j++) {
			GX[j]=myPop.getFittest().getbinaryGx(j);
			System.out.print(GX[j]);
		}
		
		for (int i = 0; i < myPop.getFittest().GAsize(); i++)
			GA[i]=myPop.getFittest().getGA(i);
		for (int j = 0; j < myPop.getFittest().GBsize(); j++)
			GB[j]=myPop.getFittest().getGB(j);
		
		System.out.print(" 執行時間: "+(endTime-startTime));
		 if(Iteration_Mode==2){
				String X1="",Y1="";
				for(int i=0;i<GX.length;i++)
						X1+=GX[i]+" ";
				for(int i=0;i<GY.length;i++)
						Y1+=GY[i]+" ";
	
		Original_temp_variables_iteration.add(generationCount);
		Original_temp_variables_fitness_function_value.add( myPop.getFittest().getFitness1());
		Original_temp_variables_violate_restrictions.add(String.valueOf(CheckConstraint.CheckConstraints_boolean(GA, GB)));
		Original_temp_variables_Global_best_X.add(X1);
		Original_temp_variables_Global_best_Y.add(Y1);
		 }
		str+=" Time= "+(endTime-startTime)+"ms\r\n";
		System.out.println();
		
		myPopFitnessN_1 = myPop.getFittest().getFitness1();
		
		Sfmin = FitnessCalc.getSFmin(SFminsb);
		startTime = System.currentTimeMillis();
		myPop = Algorithm.evolvePopulation(myPop);
		endTime = System.currentTimeMillis();
		 SFminsb = new StringBuilder();
		 PSO_Data_print.print2(myPop,Print_Mode);
		
		 for(int iter=0;iter<Iteration;iter++){
			 System.out.println("  F2(x,y) Fittest: = "+ myPop.getFittest().getFitness1() +"   F2(x,y) Fittest 成長值 = "+Math.abs(myPop.getFittest().getFitness1()-myPopFitnessN_1)/Math.abs(myPopFitnessN_1)+"     限制式 : " + CheckConstraint.CheckConstraints_boolean(GA, GB));
				
			 if(Iteration_Mode!=2){
			 
			 if((Math.abs(myPop.getFittest().getFitness1()-myPopFitnessN_1)/Math.abs(myPopFitnessN_1) > threshold) || CheckConstraint.CheckConstraints_boolean(GA, GB)==false || myPop.getFittest().getFitness1()<=0) {
			generationCount++;
			if((Math.abs(myPop.getFittest().getFitness1()-myPopFitnessN_1)/Math.abs(myPopFitnessN_1) > threshold))
				Fittest_Iter=generationCount;
			System.out.print("Generation: " + generationCount +  " F(x,y) Fittest: "+ myPop.getFittest().getFitness() + " F2(x,y) Fittest: "+ myPop.getFittest().getFitness1() + " Y=");
			str+="Generation=" + generationCount + " Fitness Function= "+myPop.getFittest().getFitness1();
			Fittest=myPop.getFittest().getFitness1() ;
			for (int i = 0; i < myPop.getFittest().binaryGysize(); i++) {
				GY[i]=myPop.getFittest().getbinaryGy(i);
				System.out.print(GY[i]);
			}
			System.out.print("X=");
			for (int j = 0; j < myPop.getFittest().binaryGxsize(); j++) {
				GX[j]=myPop.getFittest().getbinaryGx(j);
				System.out.print(GX[j]);
			}
			for (int i = 0; i < myPop.getFittest().GAsize(); i++)
				GA[i]=myPop.getFittest().getGA(i);
			for (int j = 0; j < myPop.getFittest().GBsize(); j++)
				GB[j]=myPop.getFittest().getGB(j);
			
			System.out.print(" 執行時間: "+(endTime-startTime));
			str+=" Time= "+(endTime-startTime)+"ms\r\n";
			System.out.println();
			if(myPopFitnessN_1>=myPop.getFittest().getFitness1()){
				n3 = new ArrayList<List<Integer>>();
				//進行分群
				PSO_Read_Write_txt.random_generate_or_read4(Execution_Mode);
			}
			myPopFitnessN_1 = myPop.getFittest().getFitness1();
			Sfmin = FitnessCalc.getSFmin(SFminsb);
			startTime = System.currentTimeMillis();
			myPop = Algorithm.evolvePopulation(myPop);
			endTime = System.currentTimeMillis();
			SFminsb = new StringBuilder();
			PSO_Data_print.print2(myPop,Print_Mode);
		
		}else{break;}
			 }else{
				 generationCount++;
					if((Math.abs(myPop.getFittest().getFitness1()-myPopFitnessN_1)/Math.abs(myPopFitnessN_1) > threshold))
						Fittest_Iter=generationCount;
					System.out.print("Generation: " + generationCount +  " F(x,y) Fittest: "+ myPop.getFittest().getFitness() + " F2(x,y) Fittest: "+ myPop.getFittest().getFitness1() + " Y=");
					str+="Generation=" + generationCount + " Fitness Function= "+myPop.getFittest().getFitness1();
					Fittest=myPop.getFittest().getFitness1() ;
					for (int i = 0; i < myPop.getFittest().binaryGysize(); i++) {
						GY[i]=myPop.getFittest().getbinaryGy(i);
						System.out.print(GY[i]);
					}
					System.out.print("X=");
					for (int j = 0; j < myPop.getFittest().binaryGxsize(); j++) {
						GX[j]=myPop.getFittest().getbinaryGx(j);
						System.out.print(GX[j]);
					}
					for (int i = 0; i < myPop.getFittest().GAsize(); i++)
						GA[i]=myPop.getFittest().getGA(i);
					for (int j = 0; j < myPop.getFittest().GBsize(); j++)
						GB[j]=myPop.getFittest().getGB(j);
					String X1="",Y1="";
					for(int i=0;i<GX.length;i++)
							X1+=GX[i]+" ";
					for(int i=0;i<GY.length;i++)
							Y1+=GY[i]+" ";
					System.out.print(" 執行時間: "+(endTime-startTime));
					System.out.print(" 執行時間: "+(endTime-startTime));
					Original_temp_variables_iteration.add(generationCount);
					Original_temp_variables_fitness_function_value.add( myPop.getFittest().getFitness1());
					Original_temp_variables_violate_restrictions.add(String.valueOf(CheckConstraint.CheckConstraints_boolean(GA, GB)));
					Original_temp_variables_Global_best_X.add(X1);
					Original_temp_variables_Global_best_Y.add(Y1);
					str+=" Time= "+(endTime-startTime)+"ms\r\n";
					System.out.println();
					if(myPopFitnessN_1>=myPop.getFittest().getFitness1()){
						n3 = new ArrayList<List<Integer>>();
						//進行分群
						PSO_Read_Write_txt.random_generate_or_read4(Execution_Mode);
					}
					myPopFitnessN_1 = myPop.getFittest().getFitness1();
					Sfmin = FitnessCalc.getSFmin(SFminsb);
					startTime = System.currentTimeMillis();
					myPop = Algorithm.evolvePopulation(myPop);
					endTime = System.currentTimeMillis();
					SFminsb = new StringBuilder();
					PSO_Data_print.print2(myPop,Print_Mode);
			 }
		 }
		
		System.out.println("Solution found!");
		System.out.println("Generation: " + generationCount);
		long totalendTime = System.currentTimeMillis();
		T_total_time=totalendTime - totalstartTime;
		System.out.println("執行時間 T_total_time=" + T_total_time+"ms");
		System.out.println("執行時間扣除寫檔時間  T_net=" + (T_total_time-time_write_to_TXT)+"ms");
		//CheckConstraint.CheckConstraints();
		Print_input.main(Print_Mode);
		Output_Result.CC_CLPSO2_AB_NNH(GY, GX, Fittest, Fittest_Iter, T_total_time, (T_total_time-time_write_to_TXT));
		String X1="",Y1="";
		for(int i=0;i<GX.length;i++)
				X1+=GX[i]+" ";
		for(int i=0;i<GY.length;i++)
				Y1+=GY[i]+" ";
		Output_EXCEL.main(D,P,Omega_1,Omega_2,Omega_3,Omega_4,Omega_5,Omega_6,Omega_7,Omega_8 ,X1, Y1, Fittest, Iteration, Fittest_Iter, T_total_time, (T_total_time-time_write_to_TXT),CheckConstraint.CheckConstraints_boolean(GA, GB));
	
		 if(Iteration_Mode==2)
				Output_EXCEL.Original_data(Original_temp_variables_iteration,Original_temp_variables_fitness_function_value,Original_temp_variables_violate_restrictions,Original_temp_variables_Global_best_X,Original_temp_variables_Global_best_Y);
			
		 decoding_ABString.main(GA,GB);
		 
		}else{
			Read_PSO_Batch_Parameter.main();
			 
			Read_Objective_Weight.main();
			long Time_Batch = 0;
			int generationCount_Batch = 0,k=-9999;
			double Fittest_Batch=-999999999;
			
			int populationSize_Batch=0;
			double w_Batch=0,c1_Batch=0,c2_Batch=0;
			
			 
			Omega_1=Read_Objective_Weight.Omega_1();
			Omega_2=Read_Objective_Weight.Omega_2();
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
					 	System.out.println("PSO2_Batch"+n);
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
			System.out.println("F2(X,Y)");
			PSO_Data_print.print2(myPop,Print_Mode);
			System.out.print("Generation: " + generationCount +  " F(x,y) Fittest: "+ myPop.getFittest().getFitness() + " F2(x,y) Fittest: "+ myPop.getFittest().getFitness1() + " Y=");
			Fittest=myPop.getFittest().getFitness1() ;
			for (int i = 0; i < myPop.getFittest().binaryGysize(); i++) {
				GY[i]=myPop.getFittest().getbinaryGy(i);
				System.out.print(GY[i]);
			}
			System.out.print("X=");
			for (int j = 0; j < myPop.getFittest().binaryGxsize(); j++) {
				GX[j]=myPop.getFittest().getbinaryGx(j);
				System.out.print(GX[j]);
			}
			for (int i = 0; i < myPop.getFittest().GAsize(); i++)
				GA[i]=myPop.getFittest().getGA(i);
			for (int j = 0; j < myPop.getFittest().GBsize(); j++)
				GB[j]=myPop.getFittest().getGB(j);
			System.out.println();
			myPopFitnessN_1 = myPop.getFittest().getFitness1();
			
			Sfmin = FitnessCalc.getSFmin(SFminsb);
			myPop = Algorithm.evolvePopulation(myPop);
			 SFminsb = new StringBuilder();
			 PSO_Data_print.print2(myPop,Print_Mode);
			
		while (Math.abs(myPop.getFittest().getFitness1()-myPopFitnessN_1)/Math.abs(myPopFitnessN_1) > threshold) {
		//	for(int t=0;t<100;t++){
				generationCount++;
				
				System.out.print("Generation: " + generationCount +  " F(x,y) Fittest: "+ myPop.getFittest().getFitness() + " F2(x,y) Fittest: "+ myPop.getFittest().getFitness1() + " Y=");
				Fittest=myPop.getFittest().getFitness1() ;
				for (int i = 0; i < myPop.getFittest().binaryGysize(); i++) {
					GY[i]=myPop.getFittest().getbinaryGy(i);
					System.out.print(GY[i]);
				}
				System.out.print("X=");
				for (int j = 0; j < myPop.getFittest().binaryGxsize(); j++) {
					GX[j]=myPop.getFittest().getbinaryGx(j);
					System.out.print(GX[j]);
				}
				for (int i = 0; i < myPop.getFittest().GAsize(); i++)
					GA[i]=myPop.getFittest().getGA(i);
				for (int j = 0; j < myPop.getFittest().GBsize(); j++)
					GB[j]=myPop.getFittest().getGB(j);
				System.out.println();
				myPopFitnessN_1 = myPop.getFittest().getFitness1();
				Sfmin = FitnessCalc.getSFmin(SFminsb);
				myPop = Algorithm.evolvePopulation(myPop);
				SFminsb = new StringBuilder();
				PSO_Data_print.print2(myPop,Print_Mode);
			
			}
			
			System.out.println("Solution found!");
			System.out.println("Generation: " + generationCount);
			long totalendTime = System.currentTimeMillis();
			T_total_time=totalendTime - totalstartTime;
			System.out.println("執行時間 T_total_time=" + T_total_time+"ms");
			System.out.println("執行時間扣除寫檔時間  T_net=" + (T_total_time-time_write_to_TXT)+"ms");
			CheckConstraint.CheckConstraints(GA,GB);
			Print_input.main(Print_Mode);
			Output_Result.saveCCPSO2_Batch_Parameter(n,populationSize,w,c1,c2, Vmax, Execution_Mode, Print_Mode, threshold );
			Output_Result.CCPSO2_Batch(n,Y, X, Fittest, generationCount,T_total_time, (T_total_time-time_write_to_TXT));
			System.out.println();
			System.err.println(k);
			System.err.println(Fittest_Batch);
			if(Fittest>Fittest_Batch){
				Fittest_Batch=Fittest;
				k=n;
			}
						}
					}
				}
			}
			System.out.println(k);
			//Output_Result.CCPSO2_Batch(n,Y_Batch, X_Batch, Fittest_Batch, generationCount_Batch);
			//Output_Result.saveCCPSO2_Batch_Parameter(populationSize_Batch,w_Batch,c1_Batch,c2_Batch, Vmax, Execution_Mode, Print_Mode, threshold );
		}
	}

	public static int X(int i) {
		return X[i];
	}

	public static int Y(int i) {
		return Y[i];
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
