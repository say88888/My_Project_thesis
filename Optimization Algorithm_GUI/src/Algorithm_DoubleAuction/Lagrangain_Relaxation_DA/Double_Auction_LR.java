package Algorithm_DoubleAuction.Lagrangain_Relaxation_DA;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Input_Output_txt.Read_LR_Parameter;
import Input_Output_txt.Double_Auction.Output_EXCEL;
import Input_Output_txt.Double_Auction.Output_Result;
import Input_Output_txt.Double_Auction.Read_Double_Auction;

public class Double_Auction_LR {

	public static int i1 = 0, i2 = 0;
	public static int N;
	public static int I;
	public static int K;
	public static double L;
	public static double c;
	public static int Print;
	public static double[] Lambda1; // λ
	public static double Lambda2;
	public static double[][] Lambda3;
	public static int[][] X;
	public static int[][] Y;
	public static int generationCount;
	public static StringBuilder sb = new StringBuilder();
	public static StringBuilder sb1 = new StringBuilder();
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
		// TODO Auto-generated method stub
		i1 = 0;
		i2 = 0;

		sb = new StringBuilder();
		sb1 = new StringBuilder();
		Read_Double_Auction.main();
		N = Read_Double_Auction.getN();
		I = Read_Double_Auction.getI();
		K = Read_Double_Auction.getK();

		Y = new int[N][];
		for (int i = 0; i < N; i++)
			Y[i] = new int[Read_Double_Auction.getH(i)];

		X = new int[I][];
		for (int i = 0; i < I; i++)
			X[i] = new int[Read_Double_Auction.getJ(i)];

		Read_LR_Parameter.main();
		L = Read_LR_Parameter.L();
		c = Read_LR_Parameter.c();
		Print = Read_LR_Parameter.Print();

		Lambda1 = new double[K];
		Lambda3 = new double[I][K];
		for (int i = 0; i < Lambda1.length; i++)
			Lambda1[i] = 0;
		Lambda2 = 0;
		for (int i = 0; i < I; i++)
			for (int j = 0; j < Lambda3[i].length; j++)
				Lambda3[i][j] = 0;
		generationCount = 1;
		// F(X,Y)
		System.out.println();
		System.out.println("F1(X,Y)");
		long totalstartTime = System.currentTimeMillis();
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < I; i++)
			for (int j = 0; j < Read_Double_Auction.getJ(i); j++) {
				double fitness = 0;
				fitness += Read_Double_Auction.getPij(i, j)
						* (1 - Read_Double_Auction.getTsm());
				for (int k = 0; k < K; k++) {
					fitness -= Lambda1[k] * Read_Double_Auction.getqijk(i, j, k);
					fitness += Lambda3[i][k]
							* Read_Double_Auction.getqijk(i, j, k);
				}
				fitness += Lambda2 * Read_Double_Auction.getPij(i, j);

				if (fitness >= 0)
					X[i][j] = 0;
				else
					X[i][j] = 1;
			}
		for (int n = 0; n < N; n++)
			for (int h = 0; h < Read_Double_Auction.getH(n); h++) {
				double fitness = 0;
				fitness += Read_Double_Auction.getPnh(n, h)
						* (1 + Read_Double_Auction.getTbm());
				for (int k = 0; k < K; k++)
					fitness -= Lambda1[k] * Read_Double_Auction.getdnhk(n, h, k);
				fitness += Lambda2 * Read_Double_Auction.getPnh(n, h);

				if (fitness >= 0)
					Y[n][h] = 1;
				else
					Y[n][h] = 0;
			}
		long endTime = System.currentTimeMillis();
		for (int i = 0; i < Y.length; i++)
			for (int j = 0; j < Y[i].length; j++) {
				System.out.print(Y[i][j]);
			}
		System.out.print("X=");
		for (int i = 0; i < X.length; i++)
			for (int j = 0; j < X[i].length; j++) {
				System.out.print(X[i][j]);
			}
		System.out.println("  F(X,Y)=  " + Functions.L(X, Y));
		double fintestN_1 = 0, fintestN = 0;
		Updata_Lambda.Updata_Lambda(X, Y);
		Print_Lambda_g.main(X, Y);
		// System.out.println(Math.abs(Functions.L(X,
		// Y)-fintestN_1)/Math.abs(fintestN_1));
		while ( /* constraint(X, Y)==false */Math.abs(Functions.L(X, Y) - fintestN_1/ Functions.L(X, Y)) > 0.0001) {
			/* for(int t=0;t<10;t++){ */
			fintestN_1 = Functions.L(X, Y);
			generationCount++;
			startTime = System.currentTimeMillis();
			for (int i = 0; i < I; i++)
				for (int j = 0; j < Read_Double_Auction.getJ(i); j++) {
					double fitness = 0;
					fitness += Read_Double_Auction.getPij(i, j)
							* (1 - Read_Double_Auction.getTsm());
					for (int k = 0; k < K; k++) {
						fitness -= Lambda1[k]
								* Read_Double_Auction.getqijk(i, j, k);
						fitness += Lambda3[i][k]
								* Read_Double_Auction.getqijk(i, j, k);
					}
					fitness += Lambda2 * Read_Double_Auction.getPij(i, j);
					if (fitness >= 0)
						X[i][j] = 0;
					else
						X[i][j] = 1;
				}
			for (int n = 0; n < N; n++)
				for (int h = 0; h < Read_Double_Auction.getH(n); h++) {
					double fitness = 0;
					fitness += Read_Double_Auction.getPnh(n, h)
							* (1 + Read_Double_Auction.getTbm());
					for (int k = 0; k < K; k++)
						fitness -= Lambda1[k]
								* Read_Double_Auction.getdnhk(n, h, k);
					fitness += Lambda2 * Read_Double_Auction.getPnh(n, h);
					if (fitness >= 0)
						Y[n][h] = 1;
					else
						Y[n][h] = 0;
				}
			endTime = System.currentTimeMillis();
			System.out.print("Y=");
			for (int i = 0; i < Y.length; i++)
				for (int j = 0; j < Y[i].length; j++) {
					System.out.print(Y[i][j]);
				}
			System.out.print("X=");
			for (int i = 0; i < X.length; i++)
				for (int j = 0; j < X[i].length; j++) {
					System.out.print(X[i][j]);
				}

			System.out.println("  F(X,Y)=  " + Functions.L(X, Y));
			fintestN = Functions.L(X, Y);

			Updata_Lambda.Updata_Lambda(X, Y);

		}
		// System.out.println(Functions.L(X, Y) + " " + constraint(X, Y));
		CheckConstraint.CheckConstraints(X, Y);
		System.out.println();
		long totalendTime = System.currentTimeMillis();

		Output_Result.LR(Y, X, fintestN, generationCount, totalendTime
				- totalstartTime);
		String X1="",Y1="";
		for(int i=0;i<X.length;i++)
			for(int j=0;j<X[i].length;j++)
				X1+=X[i][j]+" ";
		for(int i=0;i<Y.length;i++)
			for(int j=0;j<Y[i].length;j++)
				Y1+=Y[i][j]+" ";
		Output_EXCEL.main(N, I, K, X1, Y1, fintestN, 0, generationCount, totalendTime- totalstartTime, totalendTime- totalstartTime,constraint(X, Y));
		// Print_Lambda_g.main(X, Y);
	}

	public static boolean constraint(int[][] X, int[][] Y) {

		boolean right = true;
		double st221 = 0, st222 = 0;
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
