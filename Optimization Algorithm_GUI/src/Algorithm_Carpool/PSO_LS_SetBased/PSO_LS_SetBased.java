package Algorithm_Carpool.PSO_LS_SetBased;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import carpool_Alogorithm_MOD.Print_input;
import Generate_random_data.Read_Generate_random_OilConsumptionBounds;
import Input_Output_txt.Batch.Read_PSO_Batch_Parameter;
import Input_Output_txt.Carpool.Output_EXCEL;
import Input_Output_txt.Carpool.Output_Result;
import Input_Output_txt.Carpool.Read_Objective_Weight;
import Input_Output_txt.Carpool.Read_file;
import READ_TXT.Read_INPUT_TXT_filter;
import READ_TXT.Read_distance;
import READ_TXT.Read_filter_and_detour_rate;
 
public class PSO_LS_SetBased {
	public static int Xsize = 0, Ysize = 0;
	public static int  i1=0,i2=0,i3=0;
	public static int Fittest_Iter;
	public static int P;
	public static int D;
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
	private static int Iteration;
	private static int Iteration_Mode;
	public static double Omega_1,Omega_2,Omega_3,Omega_4,Omega_5,Omega_6,Omega_7,Omega_8;
	private static int[][] A;
	private static int[][] B;
	private static int[] A_Batch;
	private static int[] B_Batch;
	public static double Sfmin;
	public static int generationCount;
	public static StringBuilder SFminsb = new StringBuilder();
	public static StringBuilder sb = new StringBuilder();
	public static StringBuilder sb1 = new StringBuilder();
	public static StringBuilder sb2 = new StringBuilder();
	public static int n=0;//計算batch次數
	 
	public static List<List<Integer>> Alist = new ArrayList<List< Integer >>();
	public static List<Integer> l2 = new ArrayList<Integer>();
	
	public static List<List<Integer>> M = new ArrayList<List< Integer >>();
	public static List<List<Integer>> Pi_id = new ArrayList<List< Integer >>();
	public static List<Integer> Bstring = new ArrayList<Integer>();
	
	public static long time_write_to_TXT;
	public static long T_total_time;
	public static int  Local_search_Mode;
	
	public static double wp;
	public static double wd;
	public static double Epsilon1;
	public static double Epsilon2;
	
	public static double wp1;
	public static double wd1;
	public static double Epsilon3;
	public static double Epsilon4;
	
	private static List<Integer> Original_temp_variables_iteration = new ArrayList<Integer>();
	private static List<Double> Original_temp_variables_fitness_function_value = new ArrayList<Double>();
	private static List<String> Original_temp_variables_violate_restrictions = new ArrayList<String>();
	
	private static List<String> Original_temp_variables_Global_best_X = new ArrayList<String>();
	private static List<String> Original_temp_variables_Global_best_Y = new ArrayList<String>();
	
	public static  double Lambda1,Lambda2,Lambda3;

	public static  double Pc,Mu,Eta,W,C,Sigma,random_or_heuristic_prob;
	public static  int Nmax;
	public static String profit_constraint_rule;
	
	public static void main() throws IOException {
		
		Lambda1=1;
		Lambda2=1;
		while ((Lambda1+Lambda2)>1){
			Lambda1=Math.random();
			Lambda2=Math.random();
		}
		Lambda3=1-(Lambda1+Lambda2);
		
		Original_temp_variables_iteration = new ArrayList<Integer>();
		Original_temp_variables_fitness_function_value = new ArrayList<Double>();
		Original_temp_variables_violate_restrictions = new ArrayList<String>();
		Original_temp_variables_Global_best_X = new ArrayList<String>();
		Original_temp_variables_Global_best_Y = new ArrayList<String>();
		
		time_write_to_TXT=0;
		Fittest_Iter=0;
		 i1=0;
		 i2=0;
		 n=0;
		 sb=new StringBuilder();
		 sb1=new StringBuilder();
		Read_INPUT_TXT_filter.loadData();			//讀取初始資料
		Read_distance.Read_distance();		//讀取距離矩陣
		Read_filter_and_detour_rate.main();
		try {
			Read_Generate_random_OilConsumptionBounds.main();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Read_file.loadData();
		P = Read_INPUT_TXT_filter.getP();
		D = Read_INPUT_TXT_filter.getD();
		K = Read_file.getK();
		
		for (int i = 0; i < D; i++)
			Xsize += Read_file.getJd(i);
		for (int i = 0; i < P; i++)
			Ysize += Read_file.getHp(i);
		
		A = new int[D][P];
		B = new int[D][2*P];
		
		A_Batch = new int[P];
		B_Batch = new int[2*P];
		
		if(GUI.main.getmethod()!=2){
		PSO_Read_Write_txt.read_PSO_Parameter();
		 
		Iteration_Mode=PSO_Read_Write_txt.Iteration_Mode();
		if(Iteration_Mode==0  || Iteration_Mode==2){
		Iteration=PSO_Read_Write_txt.Iteration();
		}else{Iteration=Xsize+Ysize+K+1+Xsize+Xsize+D;}
		
		System.out.println(Iteration);
		
		Read_Objective_Weight.main();
		populationSize=PSO_Read_Write_txt.populationSize();
		w=PSO_Read_Write_txt.w();
		W=w;
		
		c1=PSO_Read_Write_txt.c1();
		C=c1;
		
		c2=PSO_Read_Write_txt.c2();
		Vmax=PSO_Read_Write_txt.Vmax();
		Execution_Mode=PSO_Read_Write_txt.Execution_Mode();
		Print_Mode=PSO_Read_Write_txt.Print_Mode();
		Write_Mode=PSO_Read_Write_txt.Write_Mode();
		threshold=PSO_Read_Write_txt.threshold();
		Local_search_Mode= PSO_Read_Write_txt.Local_Search_Mode();
		Pc= PSO_Read_Write_txt.Pc();
		Mu= PSO_Read_Write_txt.Mu();
		Eta= PSO_Read_Write_txt.Eta();
		Sigma= PSO_Read_Write_txt.Sigma();
		Nmax= PSO_Read_Write_txt.Nmax();
		random_or_heuristic_prob= PSO_Read_Write_txt.random_or_heuristic_prob();
		profit_constraint_rule=PSO_Read_Write_txt.profit_constraint_rule();
		
		Omega_1=Read_Objective_Weight.Omega_1();
		Omega_2=Read_Objective_Weight.Omega_2();
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
		
		Alist = new ArrayList<List< Integer >>();
		Check_DetourRation.main();
		
		String str="";
		long totalstartTime = System.currentTimeMillis();
		long startTime = System.currentTimeMillis();
		Population myPop = new Population(populationSize, true);
		long endTime = System.currentTimeMillis();
		  generationCount = 1;
		double myPopFitnessN_1,Fittest;
		// F(X,Y)
		System.out.println();
		System.out.println("F2(X,Y)");
		PSO_Data_print.print2(myPop,Print_Mode);
		System.out.print("Generation: " + generationCount +  " F(x,y) Fittest: "+ myPop.getFittest().getFitness() + " F2(x,y) Fittest: "+ myPop.getFittest().getFitness1() + " Bstring=");
		str+="Generation=" + generationCount + " Fitness Function= "+myPop.getFittest().getFitness1();
		Fittest=myPop.getFittest().getFitness1();
		for (int i = 0; i < myPop.getFittest().GBsize(); i++)
			for (int j = 0; j < myPop.getFittest().GBsize1(i); j++) {
			B[i][j] = myPop.getFittest().getGB(i,j);
			System.out.print(B[i][j]);
		}
		System.out.print(" Astring=");
		for (int i = 0; i < myPop.getFittest().GAsize(); i++)
			for (int j = 0; j < myPop.getFittest().GAsize1(i); j++) {
			A[i][j] = myPop.getFittest().getGA(i,j);
			System.out.print(A[i][j]);
		}
		System.out.print(" 執行時間: "+(endTime-startTime));
		 if(Iteration_Mode==2){
				String X1="",Y1="";
				for(int i=0;i<A.length;i++)
						X1+=A[i]+" ";
				for(int i=0;i<B.length;i++)
						Y1+=B[i]+" ";
	
		Original_temp_variables_iteration.add(generationCount);
		Original_temp_variables_fitness_function_value.add( myPop.getFittest().getFitness1());
		Original_temp_variables_violate_restrictions.add(String.valueOf(CheckConstraint.CheckConstraints_boolean(A,B)));
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
			 
			 System.out.println("  F2(x,y) Fittest: = "+ myPop.getFittest().getFitness1() +"   F2(x,y) Fittest 成長值 = "+Math.abs(myPop.getFittest().getFitness1()-myPopFitnessN_1)/Math.abs(myPopFitnessN_1)+"     限制式 : " +  CheckConstraint.CheckConstraints_boolean(A,B));
			
			 if(Iteration_Mode!=2){
	if((Math.abs(myPop.getFittest().getFitness1()-myPopFitnessN_1)/Math.abs(myPopFitnessN_1) > threshold) || CheckConstraint.CheckConstraints_boolean(A,B)==false || myPop.getFittest().getFitness1()<=0) {
			generationCount++;
			if((Math.abs(myPop.getFittest().getFitness1()-myPopFitnessN_1)/Math.abs(myPopFitnessN_1) > threshold))
				Fittest_Iter=generationCount;
	
			System.out.print("Generation: " + generationCount +  " F(x,y) Fittest: "+ myPop.getFittest().getFitness() + " F2(x,y) Fittest: "+ myPop.getFittest().getFitness1() + " Bstring=");
			str+="Generation=" + generationCount + " Fitness Function= "+myPop.getFittest().getFitness1();
			Fittest=myPop.getFittest().getFitness1() ;
			for (int i = 0; i < myPop.getFittest().GBsize(); i++)
				for (int j = 0; j < myPop.getFittest().GBsize1(i); j++) {
				B[i][j] = myPop.getFittest().getGB(i,j);
				System.out.print(B[i][j]);
			}
			System.out.print(" Astring=");
			for (int i = 0; i < myPop.getFittest().GAsize(); i++)
				for (int j = 0; j < myPop.getFittest().GAsize1(i); j++) {
				A[i][j] = myPop.getFittest().getGA(i,j);
				System.out.print(A[i][j]);
			}
			System.out.print(" 執行時間: "+(endTime-startTime));
			str+=" Time= "+(endTime-startTime)+"ms\r\n";
			System.out.println();
			myPopFitnessN_1 = myPop.getFittest().getFitness1();
			Sfmin = FitnessCalc.getSFmin(SFminsb);
			startTime = System.currentTimeMillis();
			myPop = Algorithm.evolvePopulation(myPop);
			endTime = System.currentTimeMillis();
			SFminsb = new StringBuilder();
			PSO_Data_print.print2(myPop,Print_Mode);
			
			}else{break;}}else{
				generationCount++;
				if((Math.abs(myPop.getFittest().getFitness1()-myPopFitnessN_1)/Math.abs(myPopFitnessN_1) > threshold))
					Fittest_Iter=generationCount;
		
				System.out.print("Generation: " + generationCount +  " F(x,y) Fittest: "+ myPop.getFittest().getFitness() + " F2(x,y) Fittest: "+ myPop.getFittest().getFitness1() + " Bstring=");
				str+="Generation=" + generationCount + " Fitness Function= "+myPop.getFittest().getFitness1();
				Fittest=myPop.getFittest().getFitness1() ;
				for (int i = 0; i < myPop.getFittest().GBsize(); i++)
					for (int j = 0; j < myPop.getFittest().GBsize1(i); j++) {
					B[i][j] = myPop.getFittest().getGB(i,j);
					System.out.print(B[i][j]);
				}
				System.out.print(" Astring=");
				for (int i = 0; i < myPop.getFittest().GAsize(); i++)
					for (int j = 0; j < myPop.getFittest().GAsize1(i); j++) {
					A[i][j] = myPop.getFittest().getGA(i,j);
					System.out.print(A[i][j]);
				}
				System.out.print(" 執行時間: "+(endTime-startTime));
				String X1="",Y1="";
				for(int i=0;i<A.length;i++)
					for(int j=0;j<A[i].length;j++)
						X1+=A[i][j]+" ";
				for(int i=0;i<B.length;i++)
					for(int j=0;j<B[i].length;j++)
						Y1+=B[i][j]+" ";

				Original_temp_variables_iteration.add(generationCount);
				Original_temp_variables_fitness_function_value.add( myPop.getFittest().getFitness1());
				Original_temp_variables_violate_restrictions.add(String.valueOf(CheckConstraint.CheckConstraints_boolean(A,B)));
				Original_temp_variables_Global_best_X.add(X1);
				Original_temp_variables_Global_best_Y.add(Y1);
				str+=" Time= "+(endTime-startTime)+"ms\r\n";
				System.out.println();
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
		CheckConstraint.CheckConstraints(A,B);
		Print_input.main(Print_Mode);
		Output_Result.PSO_LS_SetBased(B, A, Fittest, Fittest_Iter, T_total_time, (T_total_time-time_write_to_TXT),str);
		decoding_ABString.main(myPop);
		
		String X1="",Y1="";
		for(int i=0;i<A.length;i++)
			for(int j=0;j<A[i].length;j++)
				X1+=A[i][j]+" ";
		for(int i=0;i<B.length;i++)
			for(int j=0;j<B[i].length;j++)
				Y1+=B[i][j]+" ";
		Output_EXCEL.main(D,P,Omega_1,Omega_2,Omega_3,Omega_4,Omega_5,Omega_6,Omega_7,Omega_8 ,X1, Y1, Fittest, Iteration, Fittest_Iter, T_total_time, (T_total_time-time_write_to_TXT),CheckConstraint.CheckConstraints_boolean(A,B));
		 if(Iteration_Mode==2)
				Output_EXCEL.Original_data(Original_temp_variables_iteration,Original_temp_variables_fitness_function_value,Original_temp_variables_violate_restrictions,Original_temp_variables_Global_best_X,Original_temp_variables_Global_best_Y);
						
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
						Check_DetourRation.main();
			long totalstartTime = System.currentTimeMillis();
			Population myPop = new Population(populationSize, true);
			  generationCount = 1;
			double myPopFitnessN_1,Fittest;
			// F(X,Y)
			System.out.println();
			System.out.println("F2(X,Y)");
			PSO_Data_print.print2(myPop,Print_Mode);
			System.out.print("Generation: " + generationCount +  " F(x,y) Fittest: "+ myPop.getFittest().getFitness() + " F2(x,y) Fittest: "+ myPop.getFittest().getFitness1() + " Bstring=");
			Fittest=myPop.getFittest().getFitness1() ;
			for (int i = 0; i < myPop.getFittest().GBsize(); i++) {
//				B[i] = myPop.getFittest().getGB(i);
				System.out.print(B[i]);
			}
			System.out.print(" Astring=");
			for (int j = 0; j < myPop.getFittest().GAsize(); j++) {
//				A[j] = myPop.getFittest().getGA(j);
				System.out.print(A[j]);
			}
			System.out.println();
			myPopFitnessN_1 = myPop.getFittest().getFitness1();
			
			Sfmin = FitnessCalc.getSFmin(SFminsb);
			myPop = Algorithm.evolvePopulation(myPop);
			 SFminsb = new StringBuilder();
			 PSO_Data_print.print2(myPop,Print_Mode);
			
		while (Math.abs(myPop.getFittest().getFitness1()-myPopFitnessN_1)/Math.abs(myPopFitnessN_1) > threshold) {
	
				generationCount++;
				
				System.out.print("Generation: " + generationCount +  " F(x,y) Fittest: "+ myPop.getFittest().getFitness() + " F2(x,y) Fittest: "+ myPop.getFittest().getFitness1() + " Bstring=");
				Fittest=myPop.getFittest().getFitness1() ;
				for (int i = 0; i < myPop.getFittest().GBsize(); i++) {
	//				B[i] = myPop.getFittest().getGB(i);
					System.out.print(B[i]);
				}
				System.out.print(" Astring=");
				for (int j = 0; j < myPop.getFittest().GAsize(); j++) {
	//				A[j] = myPop.getFittest().getGA(j);
					System.out.print(A[j]);
				}
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
		//	CheckConstraint.CheckConstraints();
			//Print_input.main(Print_Mode);
			Output_Result.savePSO_LS_Batch_Parameter(n,populationSize,w,c1,c2, Vmax, Execution_Mode, Print_Mode, threshold );
	//		Output_Result.PSO_LS_Batch(n,B, A, Fittest, generationCount,T_total_time, (T_total_time-time_write_to_TXT));
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
			//Output_Result.PSO2_Batch_best(Y_Batch, X_Batch, Fittest_Batch, generationCount_Batch,Time_Batch);
			//Output_Result.savePSO2_Batch_Parameter(populationSize_Batch,w_Batch,c1_Batch,c2_Batch, Vmax, Execution_Mode, Print_Mode, threshold );
		}
	}


	public static int A(int i,int j) {
		return A[i][j];
	}

	public static int B(int i,int j) {
		return B[i][j];
	}

}
