package Algorithm_DoubleAuction.GA2_DA;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Input_Output_txt.Double_Auction.Output_EXCEL;
import Input_Output_txt.Double_Auction.Output_Result;
import Input_Output_txt.Double_Auction.Read_Double_Auction;
import Input_Output_txt.Double_Auction.Read_Objective_Weight;

 
public class Double_Auction_GA2 {

	public static double Sfmin;
	public static int Xsize = 0, Ysize = 0;
	public static int  i1=0,i2=0;
	public static int Fittest_Iter;
	public static int N;
	public static int I;
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
	public static int Iteration;
	public static int Iteration_Mode;
	static StringBuilder sb2 = new StringBuilder();
	
	private static int[] X2;
	private static int[] Y2;

	public static long time_write_to_TXT;
	public static long T_total_time;
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
		 Xsize=0;
		 Ysize=0;
		 Fittest_Iter=0;
		 time_write_to_TXT=0;
		 i1=0;
		 i2=0;
		 Read_Double_Auction.main();
		GA_Read_Write_txt.read_GA_Parameters();
		
		
		N = Read_Double_Auction.getN();
		I = Read_Double_Auction.getI();
		K = Read_Double_Auction.getK();

		for (int i = 0; i < I; i++)
			Xsize += Read_Double_Auction.getJ(i);
		for (int i = 0; i < N; i++)
			Ysize += Read_Double_Auction.getH(i);

		X2 = new int[Xsize];
		Y2 = new int[Ysize];
		Iteration_Mode=GA_Read_Write_txt.Iteration_Mode();
		if(Iteration_Mode==0 || Iteration_Mode==2){
		Iteration = GA_Read_Write_txt.Iteration();
		}else{
			Iteration=Xsize+Ysize+K+1+I*K;
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
		Write_Mode=GA_Read_Write_txt.Write_Mode();
		T = GA_Read_Write_txt.T();
		 
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
		 for (int iter = 0; iter < Iteration; iter++) {
				
			 if(Iteration_Mode!=2){
			 
			 System.out.println("  F2(x,y) Fittest: = "+ myPop2.getFittest2().getFitness2() +"   F2(x,y) Fittest 成長值 = "+Math.abs(myPop2.getFittest2().getFitness2()-myPop2FitnessN_1)/Math.abs(myPop2FitnessN_1)+"     限制式 : " + constraint(X2, Y2));
				if ((Math.abs(myPop2.getFittest2().getFitness2() - myPop2FitnessN_1) 	/ Math.abs( myPop2FitnessN_1)> threshold)	|| constraint(X2, Y2) == false ||myPop2.getFittest2().getFitness2()<=0) {
			
			generationCount2++;
			if(Math.abs(myPop2.getFittest2().getFitness2() - myPop2FitnessN_1) 	/ Math.abs( myPop2FitnessN_1)  > 0)
				 Fittest_Iter=generationCount2;
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
					if(Math.abs(myPop2.getFittest2().getFitness2() - myPop2FitnessN_1) 	/ Math.abs( myPop2FitnessN_1)  > 0)
						 Fittest_Iter=generationCount2;
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
		Output_Result.Genetic_Algorithm2(Y2, X2, Fittest, Fittest_Iter,T_total_time, (T_total_time-time_write_to_TXT),str);
		String X1="",Y1="";
		for(int i=0;i<X2.length;i++)
			X1+=X2[i]+" ";
		for(int i=0;i<Y2.length;i++)
			Y1+=Y2[i]+" ";
		Output_EXCEL.main(N, I, K, X1, Y1, Fittest, Iteration, Fittest_Iter, T_total_time, (T_total_time-time_write_to_TXT),constraint(X2, Y2));
		 if(Iteration_Mode==2)
				Output_EXCEL.Original_data(Original_temp_variables_iteration,Original_temp_variables_fitness_function_value,Original_temp_variables_violate_restrictions,Original_temp_variables_Global_best_X,Original_temp_variables_Global_best_Y);

	}


	public static int X2(int i) {
		return X2[i];
	}

	public static int Y2(int i) {
		return Y2[i];
	}
	public static boolean constraint(int[] x, int[] y) {
		boolean right = true;
		double st221 = 0, st222 = 0;
		int c = 0;
		int[][] Y = new int[N][];
		for (int i = 0; i < N; i++)
			Y[i] = new int[Read_Double_Auction.getH(i)];
		int[][] X = new int[I][];
		for (int i = 0; i < I; i++)
			X[i] = new int[Read_Double_Auction.getJ(i)];
		int b = 0;
		for (int i = 0; i < N; i++)
			for (int j = 0; j < Y[i].length; j++)
				Y[i][j] = y[c++];

		for (int i = 0; i < I; i++)
			for (int j = 0; j < X[i].length; j++)
				X[i][j] = x[b++];
		for (int k = 0; k < K; k++) {
			for (int i = 0; i < I; i++)
				for (int j = 0; j < X[i].length; j++)
					st221 += X[i][j] * Read_Double_Auction.getqijk(i, j, k);

			for (int n = 0; n < N; n++)
				for (int h = 0; h < Y[n].length; h++)
					st222 += Y[n][h] * Read_Double_Auction.getdnhk(n, h, k);

			if (st221 < st222)
				right = false;

			st221 = 0;
			st222 = 0;
		}
		double st231 = 0, st232 = 0;

		for (int n = 0; n < N; n++)
			for (int h = 0; h < Y[n].length; h++)
				st231 += Y[n][h] * Read_Double_Auction.getPnh(n, h);
		for (int i = 0; i < I; i++)
			for (int j = 0; j < X[i].length; j++)
				st232 += X[i][j] * Read_Double_Auction.getPij(i, j);
		if (st231 < st232)
			right = false;

		double st241 = 0;
		for (int i = 0; i < I; i++)
			for (int k = 0; k < K; k++) {
				for (int j = 0; j < X[i].length; j++)
					st241 += X[i][j] * Read_Double_Auction.getqijk(i, j, k);
				if (st241 > Read_Double_Auction.getSik(i, k))
					right = false;
				st241 = 0;
			}

		return right;
	}
}
