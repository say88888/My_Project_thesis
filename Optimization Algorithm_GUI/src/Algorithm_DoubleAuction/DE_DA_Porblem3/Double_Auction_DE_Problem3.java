package Algorithm_DoubleAuction.DE_DA_Porblem3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
 
import Input_Output_txt.Double_Auction.Output_EXCEL;
import Input_Output_txt.Double_Auction.Output_Result;
import Input_Output_txt.Double_Auction.Read_Double_Auction_Problem3;
import Input_Output_txt.Double_Auction.Read_Seller_Price_Parameter;
 
public class Double_Auction_DE_Problem3 {

	public static int Xsize = 0, Ysize = 0;
	public static int i1 = 0, i2 = 0;
	public static int Fittest_Iter;
	public static double Fittest;
	public static int N;
	public static int I;
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
	public static double Epsilon;
	public static int Iteration;
	public static int Iteration_Mode;
/*	public static double[] p;
	public static double[] f;
	public static double[] cr;
	public static int[] s;*/
	public static int ka;
	public static int knumber;
	public static double F,F1,F2,Km;
	public static double CR;
	private static int[] X;
	private static int[] Y;
	public static int[] GmX;
	public static int[] GmY;
	public static int[] dv;
	public static double Sfmin;
	public static int generationCount;
	public static StringBuilder SFminsb = new StringBuilder();
	public static StringBuilder sb = new StringBuilder();
	public static StringBuilder sb1 = new StringBuilder();
	public static int b;
	public static int n = 0;// 計算batch次數
	public static ArrayList<Double> successfulF = new ArrayList<Double>();
	public static ArrayList<Double> successfulCR = new ArrayList<Double>();

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
		Fittest_Iter=0;
		time_write_to_TXT = 0;
		Xsize = 0;
		Ysize = 0;
		i1 = 0;
		i2 = 0;
		n = 0;
		knumber=0;
		sb = new StringBuilder();
		sb1 = new StringBuilder();
		Sfmin=0;
		SFminsb = new StringBuilder();
		Read_Double_Auction_Problem3.main();
		Read_Seller_Price_Parameter.main();
		N = Read_Double_Auction_Problem3.getN();
		I = Read_Double_Auction_Problem3.getI();
		K = Read_Double_Auction_Problem3.getK();

		for (int i = 0; i < I; i++)
			for(int n=0;n< N;n++)
				for(int h=0;h<Read_Double_Auction_Problem3.getH(n);h++)
					for(int k=0;k<K;k++)
						Xsize += 1;
		for (int i = 0; i < N; i++)
			Ysize += Read_Double_Auction_Problem3.getH(i);

		X = new int[Xsize];
		Y = new int[Ysize];
		GmX = new int[Xsize];
		GmY = new int[Ysize];
		dv=new int[Xsize];

		DE_Read_Write_txt.Read_DE_Parameter();
		populationSize = DE_Read_Write_txt.NP();
		LP = DE_Read_Write_txt.LP();
		Epsilon = DE_Read_Write_txt.Epsilon();

		Iteration_Mode = DE_Read_Write_txt.Iteration_Mode();

		if (Iteration_Mode == 0 || Iteration_Mode==2) {
			Iteration = DE_Read_Write_txt.Iteration();
		} else {
			Iteration = Xsize + Ysize + K + 1 + I * K;
		}
		System.out.print(Iteration);
		
		Execution_Mode = DE_Read_Write_txt.Execution_Mode();
		Write_Mode = DE_Read_Write_txt.write_Mode();

		F = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode)*4;
	/*	F1=2;
		F2=2;
		Km=3;*/
		CR = 0.5;
		ka=5;
	
		generationCount = 1;
		String str = "";
		long totalstartTime = System.currentTimeMillis();
		long startTime = System.currentTimeMillis();
		Population myPop = new Population(populationSize, true);
		long endTime = System.currentTimeMillis();
		
		double myPopFitnessN_1;
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
		for (int i = 0; i < myPop.getFittest().Ysize(); i++) {
			Y[i] = myPop.getFittest().getY(i);
			System.out.print(Y[i]);
		}
		System.out.print("X=");
		for (int j = 0; j < myPop.getFittest().Xsize(); j++) {
			X[j] = myPop.getFittest().getX(j);
			System.out.print(X[j]);
		}
		System.out.print(" 執行時間: " + (endTime - startTime));
		 if(Iteration_Mode==2){
				String X1="",Y1="";
				for(int i=0;i<X.length;i++)
						X1+=X[i]+" ";
				for(int i=0;i<Y.length;i++)
						Y1+=Y[i]+" ";
	
		Original_temp_variables_iteration.add(generationCount);
		Original_temp_variables_fitness_function_value.add( myPop.getFittest().getFitness1());
		Original_temp_variables_violate_restrictions.add(String.valueOf(constraint(X, Y)));
		Original_temp_variables_Global_best_X.add(X1);
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
		 * while (Math.abs(myPop.getFittest().getFitness1() - myPopFitnessN_1) /
		 * Math.abs(myPopFitnessN_1) > threshold) {
		 */
		for (int t = 0; t < Iteration; t++) {
			 System.out.println("  F2(x,y) Fittest: = "+ myPop.getFittest().getFitness1() +"   F2(x,y) Fittest 成長值 = "+Math.abs(myPop.getFittest().getFitness1()-myPopFitnessN_1)/Math.abs(myPopFitnessN_1)+"     限制式 : " + constraint(X, Y));
				
			 if(Iteration_Mode!=2){
			 
			 if((Math.abs(myPop.getFittest().getFitness1()-myPopFitnessN_1)/Math.abs(myPopFitnessN_1) > threshold) || constraint(X, Y)==false || myPop.getFittest().getFitness1()<=0) {
	
				
		/*		if (generationCount > LP)
					Function.Update_p_f_cr();
*/
				generationCount++;
				 if(Math.abs(myPop.getFittest().getFitness1()-myPopFitnessN_1)/Math.abs(myPopFitnessN_1) > 0){
					 Fittest_Iter=generationCount;
				 	knumber=0;
			 	}else{
			 		knumber+=1;
			 	}				
			 System.out.print("Generation: " + generationCount
						+ " F(x,y) Fittest: " + myPop.getFittest().getFitness()
						+ " F2(x,y) Fittest: "
						+ myPop.getFittest().getFitness1() + " Y=");
				str += "Generation=" + generationCount + " Fitness Function= "
						+ myPop.getFittest().getFitness1();
				Fittest = myPop.getFittest().getFitness1();
				for (int i = 0; i < myPop.getFittest().Ysize(); i++) {
					Y[i] = myPop.getFittest().getY(i);
					System.out.print(Y[i]);
				}
				System.out.print("X=");
				for (int j = 0; j < myPop.getFittest().Xsize(); j++) {
					X[j] = myPop.getFittest().getX(j);
					System.out.print(X[j]);
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
				 
				
			/*	 if (generationCount > LP)
						Function.Update_p_f_cr();*/
					generationCount++;
					 if(Math.abs(myPop.getFittest().getFitness1()-myPopFitnessN_1)/Math.abs(myPopFitnessN_1) > 0){
						 Fittest_Iter=generationCount;
						 knumber=0;
					 }else{
						 knumber+=1;
					 }
						 
					System.out.print("Generation: " + generationCount
							+ " F(x,y) Fittest: " + myPop.getFittest().getFitness()
							+ " F2(x,y) Fittest: "
							+ myPop.getFittest().getFitness1() + " Y=");
					str += "Generation=" + generationCount + " Fitness Function= "
							+ myPop.getFittest().getFitness1();
					Fittest = myPop.getFittest().getFitness1();
					for (int i = 0; i < myPop.getFittest().Ysize(); i++) {
						Y[i] = myPop.getFittest().getY(i);
						System.out.print(Y[i]);
					}
					System.out.print("X=");
					for (int j = 0; j < myPop.getFittest().Xsize(); j++) {
						X[j] = myPop.getFittest().getX(j);
						System.out.print(X[j]);
					}
					System.out.print(" 執行時間: " + (endTime - startTime));
				//	System.err.println("Knum= "+knumber);
					String X1="",Y1="";
					for(int i=0;i<X.length;i++)
							X1+=X[i]+" ";
					for(int i=0;i<Y.length;i++)
							Y1+=Y[i]+" ";
					
					Original_temp_variables_iteration.add(generationCount);
					Original_temp_variables_fitness_function_value.add( myPop.getFittest().getFitness1());
					Original_temp_variables_violate_restrictions.add(String.valueOf(constraint(X, Y)));
					Original_temp_variables_Global_best_X.add(X1);
					Original_temp_variables_Global_best_Y.add(Y1);
					str += " Time= " + (endTime - startTime) + "ms\r\n";
					System.out.println();
					myPopFitnessN_1 = myPop.getFittest().getFitness1();
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
	//	CheckConstraint.CheckConstraints();
		Output_Result.DE(Y, X, Fittest, Fittest_Iter, T_total_time,
				(T_total_time - time_write_to_TXT), str);
		String X1="",Y1="";
		for(int i=0;i<X.length;i++)
			X1+=X[i]+" ";
		for(int i=0;i<Y.length;i++)
			Y1+=Y[i]+" ";
		Output_EXCEL.main(N, I, K, X1, Y1, Fittest, Iteration, Fittest_Iter, T_total_time, (T_total_time-time_write_to_TXT),constraint(X, Y));
		 if(Iteration_Mode==2)
			Output_EXCEL.Original_data(Original_temp_variables_iteration,Original_temp_variables_fitness_function_value,Original_temp_variables_violate_restrictions,Original_temp_variables_Global_best_X,Original_temp_variables_Global_best_Y);

	}


	public static int X(int i) {
		return X[i];
	}

	public static int Y(int i) {
		return Y[i];
	}

	public static boolean constraint(int[] x, int[] y) {
		boolean right = true;
	
		int c = 0;
		int[][] Y = new int[N][];
		for (int i = 0; i < N; i++)
			Y[i] = new int[Read_Double_Auction_Problem3.getH(i)];
		
		int[][][][] X = new int[I][][][];
		for (int i = 0; i < I; i++)
			X[i] = new int[N][][];
		for(int i=0;i<I;i++)
			for(int n=0;n<N;n++)
				X[i][n]=new int[Read_Double_Auction_Problem3.getH(n)][];
		for(int i=0;i<I;i++)
			for(int n=0;n<N;n++)
				for(int h=0;h<Read_Double_Auction_Problem3.getH(n);h++)
				X[i][n][h]=new int[K];
		
		int b = 0;
		for (int i = 0; i < N; i++)
			for (int j = 0; j < Y[i].length; j++)
				Y[i][j] = y[c++];

		for (int i = 0; i < I; i++)
			for(int n=0;n<X[i].length;n++)
				for(int h=0;h<X[i][n].length;h++)
					for(int k=0;k<X[i][n][h].length;k++)
						X[i][n][h][k]= x[b++];
		
		for(int n=0;n<N;n++)
			for(int h=0;h<Read_Double_Auction_Problem3.getH(n);h++)
				for(int k=0;k<K;k++){
					double st221 = 0, st222 = 0;
					for(int i=0;i<I;i++)
						st221+=X[i][n][h][k];
					st222=Y[n][h]*Read_Double_Auction_Problem3.getdnhk(n, h, k);
					if(st221!=st222)
						right =false;
				}
		
		

		for(int n=0;n<N;n++)
			for(int h=0;h<Read_Double_Auction_Problem3.getH(n);h++){
				double st231 = 0, st232 = 0;
				st231=Y[n][h]*Read_Double_Auction_Problem3.getPnh(n, h);
				
				for(int i=0;i<I;i++)
					for(int k=0;k<K;k++)
						st232+=X[i][n][h][k]*Read_Double_Auction_Problem3.getPij(i, k);
				if(st231<st232)
					right=false;
			}
	
		
		for (int i = 0; i < I; i++)
			for (int k = 0; k < K; k++){
				double st241 = 0;
				for(int n=0;n<N;n++)
					for(int h=0;h<Read_Double_Auction_Problem3.getH(n);h++)
						st241+=X[i][n][h][k];
				if (st241 > Read_Double_Auction_Problem3.getSik(i, k))
					right = false;
			}

		return right;
	}
}
