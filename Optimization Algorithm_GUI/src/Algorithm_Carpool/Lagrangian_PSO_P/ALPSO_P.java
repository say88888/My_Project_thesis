package Algorithm_Carpool.Lagrangian_PSO_P;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import Input_Output_txt.Read_ALPSO_P_Parameter;
import Input_Output_txt.Batch.Read_PSO_Batch_Parameter;
import Input_Output_txt.Carpool.Output_EXCEL;
import Input_Output_txt.Carpool.Output_Result;
import Input_Output_txt.Carpool.Read_Objective_Weight;
import Input_Output_txt.Carpool.Read_file;
import carpool_Alogorithm_MOD.Print_input;

 
public class ALPSO_P {

	public static int Xsize = 0, Ysize = 0;
	public static int Fittest_Iter;
	public static int  i1=0,i2=0;
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
	public static int Print;
	public static double[] Lambda1; //λ
	public static double Lambda2;
	public static double[][] Lambda3;
	public static double[][] Lambda4;
	private static int Iteration;
	private static int Iteration_Mode;
	public static double[] r1;
	public static double r2;
	public static double[][] r3;
	public static double[][] r4;
	public static double Epsilonh;	//εh
	public static double Omega_1,Omega_2,Omega_3,Omega_4,Omega_5,Omega_6,Omega_7,Omega_8;
	private static int[][] X;
	private static int[][] Y;
	private static int[][] X_Batch;
	private static int[][] Y_Batch;
	public static 	int generationCount ;
	public static StringBuilder sb = new StringBuilder();
	public static StringBuilder sb1 = new StringBuilder();
	public static int n=0;//計算Batch次數
	
	public static long time_write_to_TXT;
	public static long T_total_time;
	private static List<Integer> Original_temp_variables_iteration = new ArrayList<Integer>();
	private static List<Double> Original_temp_variables_fitness_function_value = new ArrayList<Double>();
	private static List<String> Original_temp_variables_violate_restrictions = new ArrayList<String>();
	
	private static List<String> Original_temp_variables_Global_best_X = new ArrayList<String>();
	private static List<String> Original_temp_variables_Global_best_Y = new ArrayList<String>();

	
	public static void main( ) throws IOException {
		Original_temp_variables_iteration = new ArrayList<Integer>();
		Original_temp_variables_fitness_function_value = new ArrayList<Double>();
		Original_temp_variables_violate_restrictions = new ArrayList<String>();
		Original_temp_variables_Global_best_X = new ArrayList<String>();
		Original_temp_variables_Global_best_Y = new ArrayList<String>();
		
		n=0;
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
		P = Read_file.getP();
		D = Read_file.getD();
		K = Read_file.getK();
		for (int i = 0; i < D; i++)
			Xsize += Read_file.getJd(i);
		for (int i = 0; i < P; i++)
			Ysize += Read_file.getHp(i);
		
		Y = new int[P][];
		Y_Batch = new int[P][];
		for (int i = 0; i < P; i++){
			Y[i] = new int[Read_file.getHp(i)];
			Y_Batch[i] = new int[Read_file.getHp(i)];
		}
		X = new int[D][];
		X_Batch = new int[D][];
		for (int i = 0; i <D; i++){
			X[i] = new int[Read_file.getJd(i)];
			X_Batch[i] = new int[Read_file.getJd(i)];
		}
		
		Lambda1=new double[K];
		Lambda3 = new double[D][];
		Lambda4 = new double[D][];
		
		r1=new double[K];
		r3 = new double[D][];
		r4 = new double[D][];
		Read_ALPSO_P_Parameter.main();
		Epsilonh=Read_ALPSO_P_Parameter.Epsilonh();
		Print=Read_ALPSO_P_Parameter.Print();
		
		Read_Objective_Weight.main();
		Omega_1=Read_Objective_Weight.Omega_1();
		Omega_2=Read_Objective_Weight.Omega_2();
		Omega_3=Read_Objective_Weight.Omega_3();
		Omega_4=Read_Objective_Weight.Omega_4();
		Omega_5=Read_Objective_Weight.Omega_5();
		Omega_6=Read_Objective_Weight.Omega_6();
		Omega_7=Read_Objective_Weight.Omega_7();
		Omega_8=Read_Objective_Weight.Omega_8();
		if(GUI.main.getmethod()!=2){
		
	 
			for (int i = 0; i < D; i++){
				Lambda3[i] = new double[Read_file.getJd(i)];
				Lambda4[i] = new double[Read_file.getJd(i)];
				r3[i] = new double[Read_file.getJd(i)];
				r4[i] = new double[Read_file.getJd(i)];
			}
			 
			for(int i=0;i<Lambda1.length;i++)
				Lambda1[i]=1;
			Lambda2=1;
			for(int i=0;i<D;i++)
				for(int j=0;j<Lambda3[i].length;j++){
					Lambda3[i][j] = 1;
					Lambda4[i][j] = 1;
				}
			PSO_Read_Write_txt.read_PSO_Parameter();
			
			for (int i = 0; i < r1.length; i++)
				r1[i] = PSO_Read_Write_txt.R1();
			r2 = PSO_Read_Write_txt.R2();
			for (int i = 0; i < r3.length; i++)
				for (int j = 0; j < r3[i].length; j++)
					r3[i][j] = PSO_Read_Write_txt.R3();

			for (int i = 0; i < r4.length; i++)
				for (int j = 0; j < r4[i].length; j++)
					r4[i][j] = PSO_Read_Write_txt.R4();
			
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
		Print_Lambda_g.main(X, Y);
		PSO_Data_print.print2(myPop,Print_Mode);
		System.out.print("Generation: " + generationCount + " F(x,y) Fittest: "+ myPop.getFittest().getFitness() + " F1(x,y) Fittest: "+ myPop.getFittest().getFitness1() + " Y=");
		str+="Generation=" + generationCount + " Fitness Function= "+myPop.getFittest().getFitness1()  ;
		Fittest=myPop.getFittest().getFitness1() ;
		int a=0;
		for(int i=0;i<Y.length;i++)
			for(int j=0;j<Y[i].length;j++){
				Y[i][j]=myPop.getFittest().getGy(a++);
				System.out.print(Y[i][j]);
			}
		a=0;
		System.out.print("X=");
		for(int i=0;i<X.length;i++)
			for(int j=0;j<X[i].length;j++){
				X[i][j]=myPop.getFittest().getGx(a++);
				System.out.print(X[i][j]);
			}
		System.out.print(" 執行時間: "+(endTime-startTime));
		 if(Iteration_Mode==2){
				String X1="",Y1="";
				for(int i=0;i<X.length;i++)
					for(int j=0;j<X[i].length;j++)
						X1+=X[i][j]+" ";
				for(int i=0;i<Y.length;i++)
					for(int j=0;j<Y[i].length;j++)
						Y1+=Y[i][j]+" ";
	
		Original_temp_variables_iteration.add(generationCount);
		Original_temp_variables_fitness_function_value.add( myPop.getFittest().getFitness1());
		Original_temp_variables_violate_restrictions.add(String.valueOf(constraint(X, Y)));
		Original_temp_variables_Global_best_X.add(X1);
		Original_temp_variables_Global_best_Y.add(Y1);
		 }
		str+=" Time= "+(endTime-startTime)+"ms\r\n";
		System.out.println();
		 Updata_Lambda_penalty.Updata_Lambda(X, Y);
		 Updata_Lambda_penalty.Updata_penalty(X,Y , myPop);
		 Print_Lambda_g.main(X, Y);
		myPopFitnessN_1 = myPop.getFittest().getFitness1();
		 startTime = System.currentTimeMillis();
		myPop = Algorithm.evolvePopulation(myPop);
		endTime = System.currentTimeMillis();
		 PSO_Data_print.print2(myPop,Print_Mode);
		 for(int iter=0;iter<Iteration;iter++){
			 
			 System.out.println("  F1(x,y) Fittest: = "+ myPop.getFittest().getFitness1() +"   F1(x,y) Fittest 成長值 = "+Math.abs(myPop.getFittest().getFitness1()-myPopFitnessN_1)/Math.abs(myPopFitnessN_1)+"     限制式 : " + constraint(X, Y));
			 if(Iteration_Mode!=2){	
			 
			 if((Math.abs(myPop.getFittest().getFitness1()-myPopFitnessN_1)/Math.abs(myPopFitnessN_1) > threshold) || constraint(X, Y)==false || myPop.getFittest().getFitness1()<=0) {
	
	 
		//for(int t=0;t<500;t++){
			generationCount++;
			if((Math.abs(myPop.getFittest().getFitness1()-myPopFitnessN_1)/Math.abs(myPopFitnessN_1) > threshold))
				Fittest_Iter=generationCount;
	
			System.out.print("Generation: " + generationCount + " F(x,y) Fittest: "+ myPop.getFittest().getFitness() + " F1(x,y) Fittest: "+ myPop.getFittest().getFitness1() + " Y=");
			str+="Generation=" + generationCount + " Fitness Function= "+myPop.getFittest().getFitness1()  ;
			Fittest=myPop.getFittest().getFitness1() ;
			 a=0;
				for(int i=0;i<Y.length;i++)
					for(int j=0;j<Y[i].length;j++){
						Y[i][j]=myPop.getFittest().getGy(a++);
						System.out.print(Y[i][j]);
					}
				a=0;
				System.out.print("X=");
				for(int i=0;i<X.length;i++)
					for(int j=0;j<X[i].length;j++){
						X[i][j]=myPop.getFittest().getGx(a++);
						System.out.print(X[i][j]);
					}
			System.out.print(" 執行時間: "+(endTime-startTime));
			str+=" Time= "+(endTime-startTime)+"ms\r\n";
			System.out.println();
			Updata_Lambda_penalty.Updata_Lambda(X, Y);
			 Updata_Lambda_penalty.Updata_penalty(X,Y , myPop);
			 Print_Lambda_g.main(X, Y);
			myPopFitnessN_1 = myPop.getFittest().getFitness1();
			startTime = System.currentTimeMillis();
			myPop = Algorithm.evolvePopulation(myPop);
			endTime = System.currentTimeMillis();
			PSO_Data_print.print2(myPop,Print_Mode);
			
		}else{break;}
			 }else{			generationCount++;
				if((Math.abs(myPop.getFittest().getFitness1()-myPopFitnessN_1)/Math.abs(myPopFitnessN_1) > threshold))
					Fittest_Iter=generationCount;
		
				System.out.print("Generation: " + generationCount + " F(x,y) Fittest: "+ myPop.getFittest().getFitness() + " F1(x,y) Fittest: "+ myPop.getFittest().getFitness1() + " Y=");
				str+="Generation=" + generationCount + " Fitness Function= "+myPop.getFittest().getFitness1()  ;
				Fittest=myPop.getFittest().getFitness1() ;
				 a=0;
					for(int i=0;i<Y.length;i++)
						for(int j=0;j<Y[i].length;j++){
							Y[i][j]=myPop.getFittest().getGy(a++);
							System.out.print(Y[i][j]);
						}
					a=0;
					System.out.print("X=");
					for(int i=0;i<X.length;i++)
						for(int j=0;j<X[i].length;j++){
							X[i][j]=myPop.getFittest().getGx(a++);
							System.out.print(X[i][j]);
						}
				System.out.print(" 執行時間: "+(endTime-startTime));
				String X1="",Y1="";
				for(int i=0;i<X.length;i++)
					for(int j=0;j<X[i].length;j++)
						X1+=X[i][j]+" ";
				for(int i=0;i<Y.length;i++)
					for(int j=0;j<Y[i].length;j++)
						Y1+=Y[i][j]+" ";

				Original_temp_variables_iteration.add(generationCount);
				Original_temp_variables_fitness_function_value.add( myPop.getFittest().getFitness1());
				Original_temp_variables_violate_restrictions.add(String.valueOf(constraint(X, Y)));
				Original_temp_variables_Global_best_X.add(X1);
				Original_temp_variables_Global_best_Y.add(Y1);
				str+=" Time= "+(endTime-startTime)+"ms\r\n";
				System.out.println();
				Updata_Lambda_penalty.Updata_Lambda(X, Y);
				 Updata_Lambda_penalty.Updata_penalty(X,Y , myPop);
				 Print_Lambda_g.main(X, Y);
				myPopFitnessN_1 = myPop.getFittest().getFitness1();
				startTime = System.currentTimeMillis();
				myPop = Algorithm.evolvePopulation(myPop);
				endTime = System.currentTimeMillis();
				PSO_Data_print.print2(myPop,Print_Mode);}
		 }
		
		System.out.println("Solution found!");
		System.out.println("Generation: " + generationCount);
		long totalendTime = System.currentTimeMillis();
		T_total_time=totalendTime - totalstartTime;
		System.out.println("執行時間 T_total_time=" + T_total_time+"ms");
		System.out.println("執行時間扣除寫檔時間  T_net=" + (T_total_time-time_write_to_TXT)+"ms");
		CheckConstraint.CheckConstraints(X,Y);
		Print_input.main(Print_Mode);
		Output_Result.ALPSO_P(Y, X, Fittest, Fittest_Iter,T_total_time, (T_total_time-time_write_to_TXT),str);
		String X1="",Y1="";
		for(int i=0;i<X.length;i++)
			for(int j=0;j<X[i].length;j++)
				X1+=X[i][j]+" ";
		for(int i=0;i<Y.length;i++)
			for(int j=0;j<Y[i].length;j++)
				Y1+=Y[i][j]+" ";
		Output_EXCEL.main(D,P,Omega_1,Omega_2,Omega_3,Omega_4,Omega_5,Omega_6,Omega_7,Omega_8 ,X1, Y1, Fittest, Iteration, Fittest_Iter, T_total_time, (T_total_time-time_write_to_TXT),constraint(X, Y));
		 if(Iteration_Mode==2)
				Output_EXCEL.Original_data(Original_temp_variables_iteration,Original_temp_variables_fitness_function_value,Original_temp_variables_violate_restrictions,Original_temp_variables_Global_best_X,Original_temp_variables_Global_best_Y);
			
		}else{
			 
			Read_PSO_Batch_Parameter.main();
			 
			 
			long Time_Batch = 0;
			int generationCount_Batch = 0,k=-99999;
			double Fittest_Batch=-999999999;
			
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
					
					for (int i = 0; i < D; i++){
						Lambda3[i] = new double[Read_file.getJd(i)];
						Lambda4[i] = new double[Read_file.getJd(i)];
						r3[i] = new double[Read_file.getJd(i)];
						r4[i] = new double[Read_file.getJd(i)];
					}
					 
					for(int i=0;i<Lambda1.length;i++)
						Lambda1[i]=5;
					Lambda2=5;
					for(int i=0;i<D;i++)
						for(int j=0;j<Lambda3[i].length;j++){
							Lambda3[i][j] = 5;
							Lambda4[i][j] = 5;
						}
					PSO_Read_Write_txt.read_PSO_Parameter();
					
					for (int i = 0; i < r1.length; i++)
						r1[i] = PSO_Read_Write_txt.R1();
					r2 = PSO_Read_Write_txt.R2();
					for (int i = 0; i < r3.length; i++)
						for (int j = 0; j < r3[i].length; j++)
							r3[i][j] = PSO_Read_Write_txt.R3();

					for (int i = 0; i < r4.length; i++)
						for (int j = 0; j < r4[i].length; j++)
							r4[i][j] = PSO_Read_Write_txt.R4();
					
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
			System.out.print("X=");
			for(int i=0;i<X.length;i++)
				for(int j=0;j<X[i].length;j++){
					X[i][j]=myPop.getFittest().getGx(a++);
					System.out.print(X[i][j]);
				}
			System.out.println();
			Updata_Lambda_penalty.Updata_Lambda(X, Y);
			 Updata_Lambda_penalty.Updata_penalty(X,Y , myPop);
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
					System.out.print("X=");
					for(int i=0;i<X.length;i++)
						for(int j=0;j<X[i].length;j++){
							X[i][j]=myPop.getFittest().getGx(a++);
							System.out.print(X[i][j]);
						}
				System.out.println();
				Updata_Lambda_penalty.Updata_Lambda(X, Y);
				 Updata_Lambda_penalty.Updata_penalty(X,Y , myPop);
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
			CheckConstraint.CheckConstraints(X,Y);
			Print_input.main(Print_Mode);
			Output_Result.saveALPSO_P_Batch_Parameter(n,populationSize,w,c1,c2, Vmax, Execution_Mode, Print_Mode, threshold );
			Output_Result.ALPSO_P_Batch(n,Y, X, Fittest, generationCount,T_total_time, (T_total_time-time_write_to_TXT));
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

	public static int X(int i,int j) {
		return X[i][j];
	}

	public static int Y(int i,int j) {
		return Y[i][j];
	}
	static boolean constraint(int[][] X, int[][] Y) {
		boolean right = true;
		
		

		
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
		return right;
	}
}
