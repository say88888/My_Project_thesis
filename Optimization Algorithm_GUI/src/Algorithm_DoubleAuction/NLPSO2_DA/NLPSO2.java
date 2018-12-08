package Algorithm_DoubleAuction.NLPSO2_DA;

  import java.io.IOException;
 import java.util.ArrayList;
import java.util.List;
 
import carpool_Alogorithm_MOD.Print_input;
import Input_Output_txt.Double_Auction.Output_EXCEL;
import Input_Output_txt.Double_Auction.Output_Result;
import Input_Output_txt.Double_Auction.Read_Double_Auction;
import Input_Output_txt.Double_Auction.Read_Group_Size_DA;
 

public class NLPSO2 {

	public static int Xsize = 0, Ysize = 0;
	public static int i1 = 0, i2 = 0;
	public static int Fittest_Iter;
	public static double myPopFitnessN_1;
	public static int N;
	public static int I;
	public static int K;
	public static double w;
	public static double c1;
	public static double prand;
	public static double psm;
	public static double Rfl;
	public static double Rfu;
	public static int Vmax;
	public static int Execution_Mode;
	public static int Print_Mode;
	public static int Write_Mode;
	public static int populationSize;
	public static double threshold;
	public static double PSO_lamda;
	private static int Iteration;
	private static int Iteration_Mode;
	public static int Local_Search_Iteration;
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
	public static int n = 0;// 計算batch次數
 
	public static double F;
 
	public static long time_write_to_TXT;
	public static long T_total_time;
	
	public static int[] S;
	public static int s;
	public static List<List<Integer>> n3 = new ArrayList<List<Integer>>();


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
		
		Xsize = 0;
		Ysize = 0;
		Fittest_Iter = 0;
		time_write_to_TXT = 0;
		i1 = 0;
		i2 = 0;
		n = 0;
		sb = new StringBuilder();
		sb1 = new StringBuilder();
		sb2 = new StringBuilder();
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
	 
		Vmax = PSO_Read_Write_txt.Vmax();
		Execution_Mode = PSO_Read_Write_txt.Execution_Mode();
		Print_Mode = PSO_Read_Write_txt.Print_Mode();
		Write_Mode = PSO_Read_Write_txt.Write_Mode();
		threshold = PSO_Read_Write_txt.threshold();
		PSO_lamda = PSO_Read_Write_txt.PSO_lamda();
		prand=PSO_Read_Write_txt.prand();
		psm=PSO_Read_Write_txt.psm();
		Rfl=PSO_Read_Write_txt.Rfl();
		Rfu=PSO_Read_Write_txt.Rfu();
		
		F = PSO_Read_Write_txt.random_generate_or_read2(Execution_Mode);
	  
		Read_Group_Size_DA.main();
		S = new int[Read_Group_Size_DA.S().size()];
		for (int i = 0; i < Read_Group_Size_DA.S().size(); i++)
			S[i] = Read_Group_Size_DA.S().get(i);
		long totalstartTime = System.currentTimeMillis();
		n3 = new ArrayList<List<Integer>>();
		// 進行分群
		PSO_Read_Write_txt.random_generate_or_read4(Execution_Mode);

		String str = "";
		long startTime = System.currentTimeMillis();
		Population myPop = new Population(populationSize, true);
		long endTime = System.currentTimeMillis();
		generationCount = 1;
		double Fittest;
		// F(X,Y)
		System.out.println();
		System.out.println("F2(X,Y)");
		PSO_Data_print.print2(myPop, Print_Mode);
		System.out.print("Generation: " + generationCount + " F(x,y) Fittest: " + myPop.getFittest().getFitness()
				+ " F2(x,y) Fittest: " + myPop.getFittest().getFitness1() + " Y=");
		str += "Generation=" + generationCount + " Fitness Function= " + myPop.getFittest().getFitness1();
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
		System.out.print(" 執行時間: " + (endTime - startTime));

		if (Iteration_Mode == 2) {
			String X1 = "", Y1 = "";
			for (int i = 0; i < X.length; i++)
				X1 += X[i] + " ";
			for (int i = 0; i < Y.length; i++)
				Y1 += Y[i] + " ";

			Original_temp_variables_iteration.add(generationCount);
			Original_temp_variables_fitness_function_value.add(myPop.getFittest().getFitness1());
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

		for (int iter = 1; iter < Iteration; iter++) {

			if(myPop.getFittest().getFitness1() != myPopFitnessN_1){
				myPop=Algorithm.evolvePopulation_UpLM(myPop);
				myPop=Algorithm.evolvePopulation_Algorithm2(myPop);
			}
			System.out.println("  F2(x,y) Fittest: = " + myPop.getFittest().getFitness1()
					+ "   F2(x,y) Fittest 成長值 = "
					+ Math.abs(myPop.getFittest().getFitness1() - myPopFitnessN_1) / Math.abs(myPopFitnessN_1)
					+ "     限制式 : " + constraint(X, Y));
			// L_right = false;
			if (Iteration_Mode != 2) {

				if ((Math.abs(myPop.getFittest().getFitness1() - myPopFitnessN_1)
						/ Math.abs(myPopFitnessN_1) > threshold) || constraint(X, Y) == false
						|| myPop.getFittest().getFitness1() <= 0) {

					generationCount++;
					if ((Math.abs(myPop.getFittest().getFitness1() - myPopFitnessN_1)
							/ Math.abs(myPopFitnessN_1) > threshold))
						Fittest_Iter = generationCount;

					System.out.print(
							"Generation: " + generationCount + " F(x,y) Fittest: " + myPop.getFittest().getFitness()
									+ " F2(x,y) Fittest: " + myPop.getFittest().getFitness1() + " Y=");
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

				if ((Math.abs(myPop.getFittest().getFitness1() - myPopFitnessN_1)
						/ Math.abs(myPopFitnessN_1) > threshold))
					Fittest_Iter = generationCount;

				System.out.print(
						"Generation: " + generationCount + " F(x,y) Fittest: " + myPop.getFittest().getFitness()
								+ " F2(x,y) Fittest: " + myPop.getFittest().getFitness1() + " Y=");
				str += "Generation=" + generationCount + " Fitness Function= " + myPop.getFittest().getFitness1();
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
				System.out.print(" 執行時間: " + (endTime - startTime));
				String X1 = "", Y1 = "";
				for (int i = 0; i < X.length; i++)
					X1 += X[i] + " ";
				for (int i = 0; i < Y.length; i++)
					Y1 += Y[i] + " ";

				Original_temp_variables_iteration.add(generationCount);
				Original_temp_variables_fitness_function_value.add(myPop.getFittest().getFitness1());
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
				PSO_Data_print.print2(myPop, Print_Mode);
			}

		}

		System.out.println("Solution found!");
		System.out.println("Generation: " + generationCount);
		long totalendTime = System.currentTimeMillis();
		T_total_time = totalendTime - totalstartTime;
		System.out.println("執行時間 T_total_time=" + T_total_time + "ms");
		System.out.println("執行時間扣除寫檔時間  T_net=" + (T_total_time - time_write_to_TXT) + "ms");
		CheckConstraint.CheckConstraints();
		Print_input.main(Print_Mode);
		Output_Result.NLPSO2(Y, X, Fittest, Fittest_Iter, T_total_time, (T_total_time - time_write_to_TXT), str);
		String X1 = "", Y1 = "";
		for (int i = 0; i < X.length; i++)
			X1 += X[i] + " ";
		for (int i = 0; i < Y.length; i++)
			Y1 += Y[i] + " ";
		Output_EXCEL.main(N, I, K, X1, Y1, Fittest, Iteration, Fittest_Iter, T_total_time,
				(T_total_time - time_write_to_TXT), constraint(X, Y));
		if (Iteration_Mode == 2)
			Output_EXCEL.Original_data(Original_temp_variables_iteration,
					Original_temp_variables_fitness_function_value, Original_temp_variables_violate_restrictions,
					Original_temp_variables_Global_best_X, Original_temp_variables_Global_best_Y);

	}

	public static int X(int i) {
		return X[i];
	}

	public static int Y(int i) {
		return Y[i];
	}

	static boolean constraint(int[] x, int[] y) {
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
