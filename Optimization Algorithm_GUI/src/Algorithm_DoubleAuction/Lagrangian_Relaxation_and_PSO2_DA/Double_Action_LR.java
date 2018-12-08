package Algorithm_DoubleAuction.Lagrangian_Relaxation_and_PSO2_DA;

import java.io.IOException;

import Input_Output_txt.Read_LR_and_PSO2_Parameter;
import Input_Output_txt.Double_Auction.Output_Result;
import Input_Output_txt.Double_Auction.Read_Double_Auction;
 

public class Double_Action_LR extends Double_Auction_LR_and_PSO2{

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

	public static void main() throws IOException {
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

		 Read_LR_and_PSO2_Parameter.main();
		L =  Read_LR_and_PSO2_Parameter.L();
		c =  Read_LR_and_PSO2_Parameter.c();
		Print = Read_LR_and_PSO2_Parameter.Print();

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
		for(int i=0;i<Y.length;i++)
			for(int j=0;j<Y[i].length;j++){
				System.out.print(Y[i][j]);
			}
		System.out.print("X=");
		for(int i=0;i<X.length;i++)
			for(int j=0;j<X[i].length;j++){
				System.out.print(X[i][j]);
			}
		System.out.println("  F(X,Y)=  "+Functions.L(X, Y));
		Updata_Lambda.Updata_Lambda(X, Y);
		Print_Lambda_g.main(X, Y);
		double fintestN_1=0;
		 
		
	 
		 while ( /*constraint(X, Y)==false*/Math.abs(Functions.L(X, Y)-fintestN_1) /Math.abs(Functions.L(X, Y))> threshold) {
			 fintestN_1=Functions.L(X, Y);
			 
			 generationCount++;
			 startTime = System.currentTimeMillis();
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
			endTime = System.currentTimeMillis();
			System.out.print("Y=");
			for(int i=0;i<Y.length;i++)
				for(int j=0;j<Y[i].length;j++){
					System.out.print(Y[i][j]);
				}
			System.out.print("X=");
			for(int i=0;i<X.length;i++)
				for(int j=0;j<X[i].length;j++){
					System.out.print(X[i][j]);
				}
		
			System.out.println("  F(X,Y)=  "+Functions.L(X, Y));
			
			
			Updata_Lambda.Updata_Lambda(X, Y);
			 
		}
		//System.out.println(Functions.L(X, Y) + " " + constraint(X, Y));
		 
		CheckConstraint.CheckConstraints(X, Y);
		System.out.println();
		long totalendTime = System.currentTimeMillis();
		System.out.println("執行時間: " +(totalendTime-totalstartTime));
		 Output_Result.LR_XY_Lambda_DA(Y, X, Functions.L(X, Y), generationCount, totalendTime-totalstartTime,Lambda1,Lambda2,Lambda3);
		//Print_Lambda_g.main(X, Y);
		 
	}

	public static int X(int i,int j) {
		return X[i][j];
	}

	public static int Y(int i,int j) {
		return Y[i][j];
	}
	public static double Lambda1(int i ) {
		return Lambda1[i];
	}

	public static double Lambda2(){
		return Lambda2 ;
	}
	public static double Lambda3(int i,int j) {
		return Lambda3[i][j];
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
