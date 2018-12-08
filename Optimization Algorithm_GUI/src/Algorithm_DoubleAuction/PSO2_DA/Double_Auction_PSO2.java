package Algorithm_DoubleAuction.PSO2_DA;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import Input_Output_txt.Batch.Read_PSO_Batch_Parameter;
import Input_Output_txt.Double_Auction.Output_EXCEL;
import Input_Output_txt.Double_Auction.Output_Result;
import Input_Output_txt.Double_Auction.Read_Double_Auction;
import Input_Output_txt.Double_Auction.Read_Omega;

public class Double_Auction_PSO2 {

	public static int Xsize = 0, Ysize = 0;
	public static int i1 = 0, i2 = 0;
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
	public static double PSO_lamda;
	public static int Iteration;
	public static int Iteration_Mode;
	private static int[] X;
	private static int[] Y;
	private static int[] X_Batch;
	private static int[] Y_Batch;
	public static double Sfmin;
	public static int generationCount;
	public static StringBuilder SFminsb = new StringBuilder();
	public static StringBuilder sb = new StringBuilder();
	public static StringBuilder sb1 = new StringBuilder();
	public static int n = 0;// 計算batch次數

	public static long time_write_to_TXT;
	public static long T_total_time;
	private static List<Integer> Original_temp_variables_iteration = new ArrayList<Integer>();
	private static List<Double> Original_temp_variables_fitness_function_value = new ArrayList<Double>();
	private static List<String> Original_temp_variables_violate_restrictions = new ArrayList<String>();

	private static List<String> Original_temp_variables_Global_best_X = new ArrayList<String>();
	private static List<String> Original_temp_variables_Global_best_Y = new ArrayList<String>();

	public static double Omega1, Omega2, Omega3, Omega4;

	private static List<String> Original_temp_variables_Global_best_rs = new ArrayList<String>();
	private static List<String> Original_temp_variables_Global_best_rb = new ArrayList<String>();
	private static List<String> Original_temp_variables_Global_best_r = new ArrayList<String>();
	private static double[] rs;
	private static double[] rb;
	private static double r;
	public static void main() throws IOException {
		Original_temp_variables_iteration = new ArrayList<Integer>();
		Original_temp_variables_fitness_function_value = new ArrayList<Double>();
		Original_temp_variables_violate_restrictions = new ArrayList<String>();
		Original_temp_variables_Global_best_X = new ArrayList<String>();
		Original_temp_variables_Global_best_Y = new ArrayList<String>();
		Original_temp_variables_Global_best_rs = new ArrayList<String>();
		Original_temp_variables_Global_best_rb = new ArrayList<String>();
		Original_temp_variables_Global_best_r = new ArrayList<String>();
		r = 0;
		Xsize = 0;
		Ysize = 0;
		Fittest_Iter = 0;
		time_write_to_TXT = 0;
		i1 = 0;
		i2 = 0;
		n = 0;
		sb = new StringBuilder();
		sb1 = new StringBuilder();
		Sfmin = 0;
		SFminsb = new StringBuilder();
		Read_Double_Auction.main();
		N = Read_Double_Auction.getN();
		I = Read_Double_Auction.getI();
		K = Read_Double_Auction.getK();
		if (GUI.main.getmethod() != 2) {

			Read_Omega.main();
			Omega1 = Read_Omega.Omega_1();
			Omega2 = Read_Omega.Omega_2();
			Omega3 = Read_Omega.Omega_3();
			Omega4 = Read_Omega.Omega_4();

			for (int i = 0; i < I; i++)
				Xsize += Read_Double_Auction.getJ(i);
			for (int i = 0; i < N; i++)
				Ysize += Read_Double_Auction.getH(i);

			X = new int[Xsize];
			Y = new int[Ysize];
			if (Omega2 == 1 || Omega3 == 1) {
				rs = new double[Xsize];
				rb = new double[Ysize];
			}
			X_Batch = new int[Xsize];
			Y_Batch = new int[Ysize];

			PSO_Read_Write_txt.read_PSO_Parameter();

			Iteration_Mode = PSO_Read_Write_txt.Iteration_Mode();
			if (Iteration_Mode == 0 || Iteration_Mode == 2) {
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
			PSO_lamda = PSO_Read_Write_txt.PSO_lamda();
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
			System.out.print("X=");
			for (int j = 0; j < myPop.getFittest().Gxsize(); j++) {
				X[j] = myPop.getFittest().getGx(j);
				System.out.print(X[j]);
			}
			if (Omega2 == 1 || Omega3 == 1) {
				System.out.print(" rb=");
				for (int j = 0; j < myPop.getFittest().Grbsize(); j++) {
					rb[j] = myPop.getFittest().getGrb(j);
					System.out.print(rb[j] + " ");
				}
				System.out.print(" rs=");
				for (int j = 0; j < myPop.getFittest().Grssize(); j++) {
					rs[j] = myPop.getFittest().getGrs(j);
					System.out.print(rs[j] + " ");
				}
			}
			if (Omega4 == 1) {
				System.out.print(" r=");
				r = myPop.getFittest().getGr();
				System.out.print(r + " ");
			}
			System.out.print(" 執行時間: " + (endTime - startTime));
			if (Iteration_Mode == 2) {
				String X1 = "", Y1 = "", rs1 = "", rb1 = "",r1="";
				for (int i = 0; i < X.length; i++)
					X1 += X[i] + " ";
				for (int i = 0; i < Y.length; i++)
					Y1 += Y[i] + " ";
				if(Omega2==1 || Omega3==1){
					for (int i = 0; i < X.length; i++)
						rs1 += rs[i] + " ";
					for (int i = 0; i < Y.length; i++)
						rb1 += rb[i] + " ";
				}
				if(Omega4==1)
					r1+=r;
				Original_temp_variables_iteration.add(generationCount);
				Original_temp_variables_fitness_function_value.add(myPop.getFittest().getFitness1());
				Original_temp_variables_violate_restrictions.add(String.valueOf(constraint( )));
				Original_temp_variables_Global_best_X.add(X1);
				Original_temp_variables_Global_best_Y.add(Y1);
				if (Omega2 == 1 || Omega3 == 1) {
					Original_temp_variables_Global_best_rs.add(rs1);
					Original_temp_variables_Global_best_rb.add(rb1);
				}
				if (Omega4 == 1) {
					Original_temp_variables_Global_best_r.add(r1);
				}
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

				System.out.println("  F2(x,y) Fittest: = " + myPop.getFittest().getFitness1() + "   F2(x,y) Fittest 成長值 = " + Math.abs(myPop.getFittest().getFitness1() - myPopFitnessN_1) / Math.abs(myPopFitnessN_1) + "     限制式 : " + constraint());
				if (Iteration_Mode != 2) {
					if ((Math.abs(myPop.getFittest().getFitness1() - myPopFitnessN_1) / Math.abs(myPopFitnessN_1) > threshold) || constraint() == false || myPop.getFittest().getFitness1() <= 0) {
						generationCount++;
						if (Math.abs(myPop.getFittest().getFitness1() - myPopFitnessN_1) / Math.abs(myPopFitnessN_1) > 0)
							Fittest_Iter = generationCount;
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
						System.out.print("X=");
						for (int j = 0; j < myPop.getFittest().Gxsize(); j++) {
							X[j] = myPop.getFittest().getGx(j);
							System.out.print(X[j]);
						}
						if (Omega2 == 1 || Omega3 == 1) {
							System.out.print(" rb=");
							for (int j = 0; j < myPop.getFittest().Grbsize(); j++) {
								rb[j] = myPop.getFittest().getGrb(j);
								System.out.print(rb[j] + " ");
							}
							System.out.print(" rs=");
							for (int j = 0; j < myPop.getFittest().Grssize(); j++) {
								rs[j] = myPop.getFittest().getGrs(j);
								System.out.print(rs[j] + " ");
							}

						}
						if (Omega4 == 1) {
							System.out.print(" r=");
							r = myPop.getFittest().getGr();
							System.out.print(r + " ");
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
						PSO_Data_print.print2(myPop, Print_Mode);

					} else {
						break;
					}
				} else {
					generationCount++;
					if (Math.abs(myPop.getFittest().getFitness1() - myPopFitnessN_1) / Math.abs(myPopFitnessN_1) > 0)
						Fittest_Iter = generationCount;
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
					System.out.print("X=");
					for (int j = 0; j < myPop.getFittest().Gxsize(); j++) {
						X[j] = myPop.getFittest().getGx(j);
						System.out.print(X[j]);
					}
					if (Omega2 == 1 || Omega3 == 1) {
						System.out.print(" rb=");
						for (int j = 0; j < myPop.getFittest().Grbsize(); j++) {
							rb[j] = myPop.getFittest().getGrb(j);
							System.out.print(rb[j] + " ");
						}
						System.out.print(" rs=");
						for (int j = 0; j < myPop.getFittest().Grssize(); j++) {
							rs[j] = myPop.getFittest().getGrs(j);
							System.out.print(rs[j] + " ");
						}

					}
					if (Omega4 == 1) {
						System.out.print(" r=");
						r = myPop.getFittest().getGr();
						System.out.print(r + " ");
					}
					System.out.print(" 執行時間: " + (endTime - startTime));
					String X1 = "", Y1 = "", rs1 = "", rb1 = "",r1="";
					for (int i = 0; i < X.length; i++)
						X1 += X[i] + " ";
					for (int i = 0; i < Y.length; i++)
						Y1 += Y[i] + " ";
					if(Omega2==1 || Omega3==1){
						for (int i = 0; i < X.length; i++)
							rs1 += rs[i] + " ";
						for (int i = 0; i < Y.length; i++)
							rb1 += rb[i] + " ";
					}
					if(Omega4==1)
						r1+=r;
					Original_temp_variables_iteration.add(generationCount);
					Original_temp_variables_fitness_function_value.add(myPop.getFittest().getFitness1());
					Original_temp_variables_violate_restrictions.add(String.valueOf(constraint( )));
					Original_temp_variables_Global_best_X.add(X1);
					Original_temp_variables_Global_best_Y.add(Y1);
					if (Omega2 == 1 || Omega3 == 1) {
						Original_temp_variables_Global_best_rs.add(rs1);
						Original_temp_variables_Global_best_rb.add(rb1);
					}
					if (Omega4 == 1) {
						Original_temp_variables_Global_best_r.add(r1);
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
			if(Omega1==1)
				Output_Result.PSO2(Y, X, Fittest, Fittest_Iter, T_total_time,
					(T_total_time - time_write_to_TXT), str);
			else if(Omega2==1 || Omega3==1)
				Output_Result.PSO2_problem2(Y, X,rb,rs, Fittest, Fittest_Iter, T_total_time,
						(T_total_time - time_write_to_TXT), str);
			else if(Omega4==1)
				Output_Result.PSO2_problem4(Y, X,r, Fittest, Fittest_Iter, T_total_time,
						(T_total_time - time_write_to_TXT), str);
			String X1 = "", Y1 = "", rs1 = "", rb1 = "",r1="";
			for (int i = 0; i < X.length; i++)
				X1 += X[i] + " ";
			for (int i = 0; i < Y.length; i++)
				Y1 += Y[i] + " ";
			if(Omega2==1 || Omega3==1){
				for (int i = 0; i < X.length; i++)
					rs1 += rs[i] + " ";
				for (int i = 0; i < Y.length; i++)
					rb1 += rb[i] + " ";
			}
			if(Omega4==1)
				r1+=r;
			if (Omega1 == 1) {
				Output_EXCEL.main(N, I, K, X1, Y1, Fittest, Iteration, Fittest_Iter, T_total_time, (T_total_time - time_write_to_TXT), constraint());
				if (Iteration_Mode == 2)
					Output_EXCEL.Original_data(Original_temp_variables_iteration, Original_temp_variables_fitness_function_value
							, Original_temp_variables_violate_restrictions, Original_temp_variables_Global_best_X
							, Original_temp_variables_Global_best_Y);
			} else if (Omega2 == 1 || Omega3 == 1) {
				Output_EXCEL.main2(N, I, K, X1, Y1, rs1, rb1, Fittest, Iteration, Fittest_Iter, T_total_time
						, (T_total_time - time_write_to_TXT), constraint());
				if (Iteration_Mode == 2)
					Output_EXCEL.Original_data2(Original_temp_variables_iteration, Original_temp_variables_fitness_function_value
							, Original_temp_variables_violate_restrictions, Original_temp_variables_Global_best_X
							, Original_temp_variables_Global_best_Y, Original_temp_variables_Global_best_rs
							, Original_temp_variables_Global_best_rb);
			} else if (Omega4 == 1) {
				Output_EXCEL.main3(N, I, K, X1, Y1, r1, Fittest, Iteration, Fittest_Iter, T_total_time
						, (T_total_time - time_write_to_TXT), constraint());
				if (Iteration_Mode == 2)
					Output_EXCEL.Original_data3(Original_temp_variables_iteration, Original_temp_variables_fitness_function_value
							, Original_temp_variables_violate_restrictions, Original_temp_variables_Global_best_X
							, Original_temp_variables_Global_best_Y, Original_temp_variables_Global_best_r);
			}
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
			Write_Mode = Read_PSO_Batch_Parameter.Write_Mode();
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
							time_write_to_TXT = 0;
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

							Output_Result.savePSO2_Batch_Parameter(n,
									populationSize, w, c1, c2, Vmax,
									Execution_Mode, Print_Mode, Write_Mode,
									threshold);
							Output_Result.PSO2_Batch(n, Y, X, Fittest,
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

	public static boolean constraint( ) {
		boolean right = true;
		int c = 0;
		int[][] y = new int[N][];
		for (int i = 0; i < N; i++)
			y[i] = new int[Read_Double_Auction.getH(i)];
		int[][] x = new int[I][];
		for (int i = 0; i < I; i++)
			x[i] = new int[Read_Double_Auction.getJ(i)];
		int b = 0;
		for (int i = 0; i < N; i++)
			for (int j = 0; j < y[i].length; j++)
				y[i][j] = Y[c++];

		for (int i = 0; i < I; i++)
			for (int j = 0; j < x[i].length; j++)
				x[i][j] = X[b++];

		if (Omega1 == 1)
			right = FitnessCalc.constraint(x, y);
		if (Omega2 == 1 || Omega3 == 1) {
			c = 0;
			double[][] rb1 = new double[N][];
			for (int i = 0; i < N; i++)
				rb1[i] = new double[Read_Double_Auction.getH(i)];
			double[][] rs1 = new double[I][];
			for (int i = 0; i < I; i++)
				rs1[i] = new double[Read_Double_Auction.getJ(i)];
			b = 0;
			for (int i = 0; i < N; i++)
				for (int j = 0; j < rb1[i].length; j++)
					rb1[i][j] = rb[c++];

			for (int i = 0; i < I; i++)
				for (int j = 0; j < rs1[i].length; j++)
					rs1[i][j] = rs[b++];

			if (Omega2 == 1)
				right = FitnessCalc.constraint2(x, y, rs1, rb1);
			if (Omega3 == 1)
				right = FitnessCalc.constraint3(x, y, rs1, rb1);
		}
		if (Omega4 == 1) {
			right = FitnessCalc.constraint4(x, y, r);
		}

		return right;
	}
}
