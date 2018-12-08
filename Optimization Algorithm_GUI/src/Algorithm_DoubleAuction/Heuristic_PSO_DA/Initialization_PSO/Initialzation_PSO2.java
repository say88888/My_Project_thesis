package Algorithm_DoubleAuction.Heuristic_PSO_DA.Initialization_PSO;

import java.io.IOException;
import java.math.BigDecimal;

import Input_Output_txt.Batch.Read_PSO_Batch_Parameter;
import Input_Output_txt.Double_Auction.Output_Result;
import Input_Output_txt.Double_Auction.Read_Double_Auction;
 
public class Initialzation_PSO2 {

	public static int Xsize = 0, Ysize = 0;
	public static int i1 = 0, i2 = 0;

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
	public static int Iteration;
	public static int Iteration_Mode;
	private static int[] X;
	private static int[] Y;
 
	public static double Sfmin;
	public static int generationCount;
	public static StringBuilder SFminsb = new StringBuilder();
	public static StringBuilder sb = new StringBuilder();
	public static StringBuilder sb1 = new StringBuilder();

	public static long time_write_to_TXT;
	public static long T_total_time;

	public static void main(int n) throws IOException {
		Xsize = 0;
		Ysize = 0;
		time_write_to_TXT = 0;
		i1 = 0;
		i2 = 0;
		
		sb = new StringBuilder();
		sb1 = new StringBuilder();
		Read_Double_Auction.main();
		N = n;
		I = Read_Double_Auction.getI();
		K = Read_Double_Auction.getK();

		for (int i = 0; i < I; i++)
			Xsize += Read_Double_Auction.getJ(i);
	 
			Ysize += Read_Double_Auction.getH(N);

		X = new int[Xsize];
		Y = new int[Ysize];
 
			PSO_Read_Write_txt.read_PSO_Parameter();

		 
			Iteration_Mode=PSO_Read_Write_txt.Iteration_Mode();
			if(Iteration_Mode==0){
			Iteration = PSO_Read_Write_txt.Iteration();
			}else{
				Iteration=Xsize+Ysize+K+1+I*K;
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

			String str = "";
			long totalstartTime = System.currentTimeMillis();
			long startTime = System.currentTimeMillis();
			Population myPop = new Population(populationSize, true);
			long endTime = System.currentTimeMillis();
			generationCount = 1;
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
			
			for (int iter = 0; iter < Iteration; iter++) {
				if ((Math.abs(myPop.getFittest().getFitness1()- myPopFitnessN_1)	/ Math.abs(myPopFitnessN_1) > threshold)	|| constraint(X, Y) == false) {

					generationCount++;

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

				}else{
					break;
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
		int[] Y = new int[Read_Double_Auction.getH(N)];
		
		int[][] X = new int[I][];
		for (int i = 0; i < I; i++)
			X[i] = new int[Read_Double_Auction.getJ(i)];
		int b = 0;
		for (int i = 0; i < Y.length; i++)
				Y[i] = y[i];

		for (int i = 0; i < I; i++)
			for (int j = 0; j < X[i].length; j++)
				X[i][j] = x[b++];
		for (int k = 0; k < K; k++) {
			for (int i = 0; i < I; i++)
				for (int j = 0; j < X[i].length; j++)
					st221 += X[i][j] * Read_Double_Auction.getqijk(i, j, k);

			
				for (int h = 0; h < Y.length; h++)
					st222 += Y[h] * Read_Double_Auction.getdnhk(N, h, k);

			if (st221 < st222)
				right = false;

			st221 = 0;
			st222 = 0;
		}
		double st231 = 0, st232 = 0;

	 
			for (int h = 0; h < Y.length; h++)
				st231 += Y[h] * Read_Double_Auction.getPnh(N, h);
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
