package Algorithm_DoubleAuction.Lagrangain_Relaxation_DA;

import Input_Output_txt.Double_Auction.Read_Double_Auction;


public class Functions extends Double_Auction_LR {
	public static double g1(int k, int[][] X, int[][] Y) {
		double fittest = 0;
		
		for(int n=0;n<N;n++)
			for(int h=0;h<Y[n].length;h++)
				fittest+=Y[n][h]*Read_Double_Auction.getdnhk(n, h, k);
		for(int i=0;i<I;i++)
			for(int j=0;j<X[i].length;j++)
				fittest-=X[i][j]*Read_Double_Auction.getqijk(i, j, k);
		return fittest;
	}

	public static double g2(int[][] X, int[][] Y) {
		double fittest = 0;
		
		for(int i=0;i<I;i++)
			for(int j=0;j<X[i].length;j++)
				fittest+=X[i][j]*Read_Double_Auction.getPij(i, j);
		for(int n=0;n<N;n++)
			for(int h=0;h<Y[n].length;h++)
				fittest-=Y[n][h]*Read_Double_Auction.getPnh(n, h);
		return fittest;
	}

	public static double g3(int i, int k, int[][] X, int[][] Y) {
		double fittest = 0;
		
		for (int j = 0; j < X[i].length; j++)
			fittest+= X[i][j] * Read_Double_Auction.getqijk(i, j, k);
		fittest-=Read_Double_Auction.getSik(i, k);
		return fittest;
	}

	 
	public static double a1(int[][] X, int[][] Y) // Theta1=θ1 Lambda =λ1
	{
		double fitness = 0;

		for (int k = 0; k < K; k++)
			fitness += Math.pow(g1(k, X, Y), 2);
		fitness += Math.pow(g2(X, Y), 2);
		for (int i = 0; i < I; i++)
			for (int k = 0; k < K; k++) 
				fitness += Math.pow(g3(i, k, X, Y), 2);
				 
	
		return c * (L(X, Y) - L) / fitness;
	}

	public static double a2(int[][] X, int[][] Y) // Theta2=θ2 Lambda =λ2
	{
		double fitness = 0;

		for (int k = 0; k < K; k++)
			fitness += Math.pow(g1(k, X, Y), 2);
		fitness += Math.pow(g2(X, Y), 2);
		for (int i = 0; i < I; i++)
			for (int k = 0; k < K; k++) 
				fitness += Math.pow(g3(i, k, X, Y), 2);
				 
		
		return c * (L(X, Y) - L) / fitness;
	}

	public static double a3(int[][] X, int[][] Y) // Theta3=θ3 Lambda =λ3
	{
		double fitness = 0;

		for (int k = 0; k < K; k++)
			fitness += Math.pow(g1(k, X, Y), 2);
		fitness += Math.pow(g2(X, Y), 2);
		for (int i = 0; i < I; i++)
			for (int k = 0; k < K; k++) 
				fitness += Math.pow(g3(i, k, X, Y), 2);
				 
		
		return c * (L(X, Y) - L) / fitness;
	}
	public static double L(int[][] X, int[][] Y) {
		double fitness = 0 ;
		for (int n = 0; n < N; n++)
			for (int h = 0; h < Y[n].length; h++) {
				fitness += Y[n][h] * (Read_Double_Auction.getPnh(n, h)+(Read_Double_Auction.getTbm()*Read_Double_Auction.getPnh(n, h)));
			}
		for (int i = 0; i < I; i++)
			for (int j = 0; j < X[i].length; j++) {
				fitness -= X[i][j]* (Read_Double_Auction.getPij(i, j)-(Read_Double_Auction.getTsm()*Read_Double_Auction.getPij(i, j)));
			}
		for (int k = 0; k < K; k++)
			fitness -= Lambda1[k] * g1(k, X, Y);
		fitness -= Lambda2 * g2(X, Y);
		for(int i=0;i<I;i++)
			for(int k=0;k<K;k++) 
				fitness-=Lambda3[i][k]*Functions.g3(i, k, X, Y);
				 
		return fitness;
	}
}
