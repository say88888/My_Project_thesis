package Algorithm_DoubleAuction.Lagrangian_Relaxation_PSO_Tanh_DA;

import Input_Output_txt.Double_Auction.Read_Double_Auction;



public class FitnessCalc extends Double_Auction_LRPSO_Tanh {

	static double getFitness(G_Individual individual) {
		double fitness = 0;
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
				Y[i][j] = individual.getGy(c++);

		for (int i = 0; i < I; i++)
			for (int j = 0; j < X[i].length; j++)
				X[i][j] = individual.getGx(b++);

		fitness = Fitness(X, Y);

		return fitness;
	}

	// F1(X,Y)
	static double getFitness1(Individual individual ) {

		double fitness = 0;
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
				Y[i][j] = individual.getY(c++);

		for (int i = 0; i < I; i++)
			for (int j = 0; j < X[i].length; j++)
				X[i][j] = individual.getX(b++);

		fitness = Fitness(X, Y) + Fitness1(X, Y, Lambda1, Lambda2, Lambda3 );

		return fitness;
	}

	static double getPFitness1(P_Individual individual) {
		double fitness = 0;
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
				Y[i][j] = individual.getPy(c++);

		for (int i = 0; i < I; i++)
			for (int j = 0; j < X[i].length; j++)
				X[i][j] = individual.getPx(b++);

		fitness = Fitness(X, Y) +Fitness1(X, Y, Lambda1, Lambda2, Lambda3);

		return fitness;
	}

	static double getGFitness1(G_Individual individual) {
		double fitness = 0;
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
				Y[i][j] = individual.getGy(c++);

		for (int i = 0; i < I; i++)
			for (int j = 0; j < X[i].length; j++)
				X[i][j] = individual.getGx(b++);

		fitness = Fitness(X, Y) + Fitness1(X, Y, Lambda1, Lambda2, Lambda3);
		
		return fitness;
	}

	static double getEFitness1(E_Individual individual) {
		double fitness = 0;
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
				Y[i][j] = individual.getEy(c++);

		for (int i = 0; i < I; i++)
			for (int j = 0; j < X[i].length; j++)
				X[i][j] = individual.getEx(b++);

		fitness = Fitness(X, Y) + Fitness1(X, Y, Lambda1, Lambda2, Lambda3);

		return fitness;
	}

	static double Fitness(int[][] X, int[][] Y) {
		double fitness = 0 ;
		for (int n = 0; n < N; n++)
			for (int h = 0; h < Y[n].length; h++) {
				fitness += Y[n][h] * (Read_Double_Auction.getPnh(n, h)+(Read_Double_Auction.getTbm()*Read_Double_Auction.getPnh(n, h)));
			}
		for (int i = 0; i < I; i++)
			for (int j = 0; j < X[i].length; j++) {
				fitness -= X[i][j]* (Read_Double_Auction.getPij(i, j)-(Read_Double_Auction.getTsm()*Read_Double_Auction.getPij(i, j)));
			}
		
		return fitness;
	}

	static double Fitness1(int[][] X, int[][] Y, double[] lambda1, double lambda2, double[][] lambda3) {
		double fitness = 0;
		for (int k = 0; k < K; k++)
			fitness -= lambda1[k] * Functions.g1(k, X, Y);
		fitness -= lambda2 * Functions.g2(X, Y);
		for(int i=0;i<I;i++)
			for(int k=0;k<K;k++) 
				fitness-=lambda3[i][k]*Functions.g3(i, k, X, Y);			 
	 
		return  fitness ;
	}
}