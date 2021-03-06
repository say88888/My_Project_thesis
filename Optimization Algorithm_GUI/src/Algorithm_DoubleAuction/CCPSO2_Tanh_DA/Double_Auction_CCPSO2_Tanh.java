package Algorithm_DoubleAuction.CCPSO2_Tanh_DA;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
 







import Input_Output_txt.Batch.Read_PSO_Batch_Parameter;
import Input_Output_txt.Double_Auction.Read_Group_Size_DA;
import Input_Output_txt.Double_Auction.Output_EXCEL;
import Input_Output_txt.Double_Auction.Output_Result;
import Input_Output_txt.Double_Auction.Read_Double_Auction;
 
public class Double_Auction_CCPSO2_Tanh {

	public static int Xsize = 0, Ysize = 0;
	public static int i1 = 0, i2 = 0, i3 = 0, i4 = 0;
	public static int Fittest_Iter;

	public static int N;
	public static int I;
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
	public static double Alpha1,Alpha2,Alpha3;
	public static int Iteration;
	public static int Iteration_Mode;
	public static int KS; // 分群次數
	public static int[] S;
	public static int s;
	public static List<List<Integer>> n3 = new ArrayList<List<Integer>>();
	private static int[] X;
	private static int[] Y;
	private static int[] X_Batch;
	private static int[] Y_Batch;
	public static double Sfmin;
	public static int generationCount;
	public static StringBuilder SFminsb = new StringBuilder();
	public static StringBuilder sb = new StringBuilder();
	public static StringBuilder sb1 = new StringBuilder();
	public static StringBuilder sb2 = new StringBuilder();
	public static StringBuilder sb3 = new StringBuilder();
	public static int n = 0;// 計算batch次數

	public static long time_write_to_TXT;
	public static long T_total_time;

	private static List<Integer> Original_temp_variables_iteration = new ArrayList<Integer>();
	private static List<Double> Original_temp_variables_fitness_function_value = new ArrayList<Double>();
	private static List<String> Original_temp_variables_violate_restrictions = new ArrayList<String>();
	
	private static List<String> Original_temp_variables_Global_best_X = new ArrayList<String>();
	private static List<String> Original_temp_variables_Global_best_Y = new ArrayList<String>();
	
	public static void main() throws IOException {
		time_write_to_TXT = 0;
		Xsize = 0;
		Ysize = 0;
		i1 = 0;
		i2 = 0;
		n = 0;
		Fittest_Iter=0;
		sb = new StringBuilder();
		sb1 = new StringBuilder();
		Sfmin=0;
		SFminsb = new StringBuilder();
		Read_Double_Auction.main();
		N = Read_Double_Auction.getN();
		I = Read_Double_Auction.getI();
		K = Read_Double_Auction.getK();

		for (int i = 0; i < I; i++)
			Xsize += Read_Double_Auction.getJ(i);
		for (int i = 0; i < N; i++)
			Ysize += Read_Double_Auction.getH(i);

		X = new int[Xsize];
		Y = new int[Ysize];

		X_Batch = new int[Xsize];
		Y_Batch = new int[Ysize];

		if (GUI.main.getmethod() != 2) {
			PSO_Read_Write_txt.read_PSO_Parameter();

			 
			Iteration_Mode = PSO_Read_Write_txt.Iteration_Mode();
			if (Iteration_Mode == 0  || Iteration_Mode==2) {
				Iteration = PSO_Read_Write_txt.Iteration();
			} else {
				Iteration = Xsize + Ysize + K + 1 + I * K;
			}
			populationSize = PSO_Read_Write_txt.populationSize();
			w = PSO_Read_Write_txt.w();
			c1 = PSO_Read_Write_txt.c1();
			c2 = PSO_Read_Write_txt.c2();
			Vmax = PSO_Read_Write_txt.Vmax();
			Execution_Mode = PSO_Read_Write_txt.Execution_Mode();
			Print_Mode = PSO_Read_Write_txt.Print_Mode();
			Write_Mode = PSO_Read_Write_txt.Write_Mode();
			threshold = PSO_Read_Write_txt.threshold();
			Alpha1=PSO_Read_Write_txt.Alpha1();
			Alpha2=PSO_Read_Write_txt.Alpha2();
			Alpha3=PSO_Read_Write_txt.Alpha3();
			
			Read_Group_Size_DA.main();
			S = new int[Read_Group_Size_DA.S().size()];
			for (int i = 0; i < Read_Group_Size_DA.S().size(); i++)
				S[i] = Read_Group_Size_DA.S().get(i);
			long totalstartTime = System.currentTimeMillis();
			n3 = new ArrayList<List<Integer>>();
			// 進行分群
			PSO_Read_Write_txt.random_generate_or_read4(Execution_Mode);
			/*
			 * for(int i=0;i<n3.size();i++){ for(int j=0;j<n3.get(i).size();j++)
			 * System.out.print(n3.get(i).get(j)+" "); System.out.println(); }
			 */
			String str = "";
			generationCount = 1;
			long startTime = System.currentTimeMillis();
			Population myPop = new Population(populationSize, true);
			long endTime = System.currentTimeMillis();
			
			double myPopFitnessN_1, Fittest;
			// F(X,Y)
			System.out.println();
			System.out.println("F2(X,Y)");
			PSO_Data_print.print2(myPop, Print_Mode);
			System.out.print("Generation: " + generationCount
					+ " F(x,y) Fittest: " + myPop.getFittest().getFitness()
					+ " F2(x,y) Fittest: " + myPop.getFittest().getFitness1()
					+ " Y=");
			str += "Generation=" + generationCount + " Fitness Function= "
					+ myPop.getFittest().getFitness1();
			Fittest = myPop.getFittest().getFitness1();
			for (int i = 0; i < myPop.getFittest().Gysize(); i++) {
				Y[i] = myPop.getFittest().getGy(i);
				System.out.print(Y[i]);
			}
			System.out.print(" X=");
			for (int j = 0; j < myPop.getFittest().Gxsize(); j++) {
				X[j] = myPop.getFittest().getGx(j);
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
			PSO_Data_print.print2(myPop, Print_Mode);

			for (int iter = 0; iter < Iteration; iter++) {
				 System.out.println("  F2(x,y) Fittest: = "+ myPop.getFittest().getFitness1() +"   F2(x,y) Fittest 成長值 = "+Math.abs(myPop.getFittest().getFitness1()-myPopFitnessN_1)/Math.abs(myPopFitnessN_1)+"     限制式 : " + constraint(X, Y));
					
				 if(Iteration_Mode!=2){
				 
				 if((Math.abs(myPop.getFittest().getFitness1()-myPopFitnessN_1)/Math.abs(myPopFitnessN_1) > threshold) || constraint(X, Y)==false || myPop.getFittest().getFitness1()<=0) {
		
					generationCount++;
					 if(Math.abs(myPop.getFittest().getFitness1()-myPopFitnessN_1)/Math.abs(myPopFitnessN_1) > 0)
						 Fittest_Iter=generationCount;
					System.out.print("Generation: " + generationCount
							+ " F(x,y) Fittest: "
							+ myPop.getFittest().getFitness()
							+ " F2(x,y) Fittest: "
							+ myPop.getFittest().getFitness1() + " Y=");
					str += "Generation=" + generationCount
							+ " Fitness Function= "
							+ myPop.getFittest().getFitness1();
					Fittest = myPop.getFittest().getFitness1();
					for (int i = 0; i < myPop.getFittest().Gysize(); i++) {
						Y[i] = myPop.getFittest().getGy(i);
						System.out.print(Y[i]);
					}
					System.out.print(" X=");
					for (int j = 0; j < myPop.getFittest().Gxsize(); j++) {
						X[j] = myPop.getFittest().getGx(j);
						System.out.print(X[j]);
					}
					System.out.print(" 執行時間: " + (endTime - startTime));
					str += " Time= " + (endTime - startTime) + "ms\r\n";
					System.out.println();

					if (myPopFitnessN_1 >= myPop.getFittest().getFitness1()) {
						n3 = new ArrayList<List<Integer>>();
						// 進行分群
						PSO_Read_Write_txt
								.random_generate_or_read4(Execution_Mode);
					}

					myPopFitnessN_1 = myPop.getFittest().getFitness1();
					Sfmin = FitnessCalc.getSFmin(SFminsb);
					startTime = System.currentTimeMillis();
					myPop = Algorithm.evolvePopulation(myPop);
					endTime = System.currentTimeMillis();
					SFminsb = new StringBuilder();
					PSO_Data_print.print2(myPop, Print_Mode);

				} else {
					break;
				}
				 }else{		
					 generationCount++;
					 if(Math.abs(myPop.getFittest().getFitness1()-myPopFitnessN_1)/Math.abs(myPopFitnessN_1) > 0)
						 Fittest_Iter=generationCount;
						System.out.print("Generation: " + generationCount
								+ " F(x,y) Fittest: "
								+ myPop.getFittest().getFitness()
								+ " F2(x,y) Fittest: "
								+ myPop.getFittest().getFitness1() + " Y=");
						str += "Generation=" + generationCount
								+ " Fitness Function= "
								+ myPop.getFittest().getFitness1();
						Fittest = myPop.getFittest().getFitness1();
						for (int i = 0; i < myPop.getFittest().Gysize(); i++) {
							Y[i] = myPop.getFittest().getGy(i);
							System.out.print(Y[i]);
						}
						System.out.print(" X=");
						for (int j = 0; j < myPop.getFittest().Gxsize(); j++) {
							X[j] = myPop.getFittest().getGx(j);
							System.out.print(X[j]);
						}
						System.out.print(" 執行時間: " + (endTime - startTime));
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

						if (myPopFitnessN_1 >= myPop.getFittest().getFitness1()) {
							n3 = new ArrayList<List<Integer>>();
							// 進行分群
							PSO_Read_Write_txt
									.random_generate_or_read4(Execution_Mode);
						}

						myPopFitnessN_1 = myPop.getFittest().getFitness1();
						Sfmin = FitnessCalc.getSFmin(SFminsb);
						startTime = System.currentTimeMillis();
						myPop = Algorithm.evolvePopulation(myPop);
						endTime = System.currentTimeMillis();
						SFminsb = new StringBuilder();
						PSO_Data_print.print2(myPop, Print_Mode);
				 }
			}

			System.out.println("Solution found!");
			System.out.println("Generation: " + generationCount);
			long totalendTime = System.currentTimeMillis();
			T_total_time = totalendTime - totalstartTime;
			System.out.println("執行時間 T_total_time=" + T_total_time + "ms");
			System.out.println("執行時間扣除寫檔時間  T_net="
					+ (T_total_time - time_write_to_TXT) + "ms");
			// CheckConstraint.CheckConstraints();
			Output_Result.CCPSO2_Tanh(Y, X, Fittest, Fittest_Iter, T_total_time,
					(T_total_time - time_write_to_TXT));
			String X1="",Y1="";
			for(int i=0;i<X.length;i++)
				X1+=X[i]+" ";
			for(int i=0;i<Y.length;i++)
				Y1+=Y[i]+" ";
			Output_EXCEL.main(N, I, K, X1, Y1, Fittest, Iteration, Fittest_Iter, T_total_time, (T_total_time-time_write_to_TXT),constraint(X, Y));
			 if(Iteration_Mode==2)
					Output_EXCEL.Original_data(Original_temp_variables_iteration,Original_temp_variables_fitness_function_value,Original_temp_variables_violate_restrictions,Original_temp_variables_Global_best_X,Original_temp_variables_Global_best_Y);
			
		} else {
			Read_PSO_Batch_Parameter.main();

			 
			long Time_Batch = 0;
			int generationCount_Batch = 0, k = -9999;
			double Fittest_Batch = -999999999;

			int populationSize_Batch = 0;
			double w_Batch = 0, c1_Batch = 0, c2_Batch = 0;

			Vmax = Read_PSO_Batch_Parameter.Vmax();
			Execution_Mode = Read_PSO_Batch_Parameter.Execution_Mode();
			Print_Mode = Read_PSO_Batch_Parameter.Print_Mode();
			threshold = Read_PSO_Batch_Parameter.threshold();

			for (populationSize = Read_PSO_Batch_Parameter.lowpopulationSize(); populationSize <= Read_PSO_Batch_Parameter
					.UppopulationSize(); populationSize += Read_PSO_Batch_Parameter
					.StpopulationSize()) {
				for (w = Read_PSO_Batch_Parameter.loww(); w <= Read_PSO_Batch_Parameter
						.Upw(); w += Read_PSO_Batch_Parameter.Stw()) {
					for (c1 = Read_PSO_Batch_Parameter.lowc1(); c1 <= Read_PSO_Batch_Parameter
							.Upc1(); c1 += Read_PSO_Batch_Parameter.Stc1()) {
						for (c2 = Read_PSO_Batch_Parameter.lowc2(); c2 <= Read_PSO_Batch_Parameter
								.Upc2(); c2 += Read_PSO_Batch_Parameter.Stc2()) {
							n++;
							sb = new StringBuilder();
							sb1 = new StringBuilder();
							System.out.println("PSO2_Batch" + n);
							System.out.println("populationSize="
									+ populationSize);
							System.out.println("w=" + w);
							System.out.println("c1=" + c1);
							System.out.println("c2=" + c2);
							System.out.println("Vmax=" + Vmax);
							System.out.println("Execution_Mode="
									+ Execution_Mode);
							System.out.println("Print_Mode=" + Print_Mode);
							System.out
									.println("threshold="
											+ new BigDecimal(String
													.valueOf(threshold)));
							long totalstartTime = System.currentTimeMillis();
							Population myPop = new Population(populationSize,
									true);
							generationCount = 1;
							double myPopFitnessN_1, Fittest;
							// F(X,Y)
							System.out.println();
							System.out.println("F2(X,Y)");
							PSO_Data_print.print2(myPop, Print_Mode);
							System.out.print("Generation: " + generationCount
									+ " F(x,y) Fittest: "
									+ myPop.getFittest().getFitness()
									+ " F2(x,y) Fittest: "
									+ myPop.getFittest().getFitness1() + " Y=");
							Fittest = myPop.getFittest().getFitness1();
							for (int i = 0; i < myPop.getFittest().Gysize(); i++) {
								Y[i] = myPop.getFittest().getGy(i);
								System.out.print(Y[i]);
							}
							System.out.print("X=");
							for (int j = 0; j < myPop.getFittest().Gxsize(); j++) {
								X[j] = myPop.getFittest().getGx(j);
								System.out.print(X[j]);
							}
							System.out.println();
							myPopFitnessN_1 = myPop.getFittest().getFitness1();

							Sfmin = FitnessCalc.getSFmin(SFminsb);
							myPop = Algorithm.evolvePopulation(myPop);
							SFminsb = new StringBuilder();
							PSO_Data_print.print2(myPop, Print_Mode);

							while (Math.abs(myPop.getFittest().getFitness1()
									- myPopFitnessN_1)
									/ Math.abs(myPopFitnessN_1) > threshold) {
								// for(int t=0;t<100;t++){
								generationCount++;

								System.out.print("Generation: "
										+ generationCount + " F(x,y) Fittest: "
										+ myPop.getFittest().getFitness()
										+ " F2(x,y) Fittest: "
										+ myPop.getFittest().getFitness1()
										+ " Y=");
								Fittest = myPop.getFittest().getFitness1();
								for (int i = 0; i < myPop.getFittest().Gysize(); i++) {
									Y[i] = myPop.getFittest().getGy(i);
									System.out.print(Y[i]);
								}
								System.out.print("X=");
								for (int j = 0; j < myPop.getFittest().Gxsize(); j++) {
									X[j] = myPop.getFittest().getGx(j);
									System.out.print(X[j]);
								}
								System.out.println();
								myPopFitnessN_1 = myPop.getFittest()
										.getFitness1();
								Sfmin = FitnessCalc.getSFmin(SFminsb);
								myPop = Algorithm.evolvePopulation(myPop);
								SFminsb = new StringBuilder();
								PSO_Data_print.print2(myPop, Print_Mode);

							}

							System.out.println("Solution found!");
							System.out
									.println("Generation: " + generationCount);
							long totalendTime = System.currentTimeMillis();
							T_total_time = totalendTime - totalstartTime;
							System.out.println("執行時間 T_total_time="
									+ T_total_time + "ms");
							System.out
									.println("執行時間扣除寫檔時間  T_net="
											+ (T_total_time - time_write_to_TXT)
											+ "ms");
							CheckConstraint.CheckConstraints();
							Output_Result.saveCCPSO2_Batch_Parameter(n,
									populationSize, w, c1, c2, Vmax,
									Execution_Mode, Print_Mode, threshold);
							Output_Result.CCPSO2_Batch(n, Y, X, Fittest,
									generationCount, T_total_time,
									(T_total_time - time_write_to_TXT));
							System.out.println();
							System.err.println(k);
							System.err.println(Fittest_Batch);
							if (Fittest > Fittest_Batch) {
								Fittest_Batch = Fittest;
								k = n;
							}
						}
					}
				}
			}
			System.out.println(k);
			// Output_Result.PSO2_Batch_best(Y_Batch, X_Batch, Fittest_Batch,
			// generationCount_Batch,Time_Batch);
			// Output_Result.savePSO2_Batch_Parameter(populationSize_Batch,w_Batch,c1_Batch,c2_Batch,
			// Vmax, Execution_Mode, Print_Mode, threshold );
		}
	}

	public static int X(int i) {
		return X[i];
	}

	public static int Y(int i) {
		return Y[i];
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
