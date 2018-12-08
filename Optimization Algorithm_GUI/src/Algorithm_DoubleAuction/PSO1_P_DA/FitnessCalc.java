package Algorithm_DoubleAuction.PSO1_P_DA;

import Input_Output_txt.Double_Auction.Read_Double_Auction;

public class FitnessCalc extends Double_Auction_PSO1_P {

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
	static double getFitness1(Individual individual) {

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

		fitness = Fitness(X, Y) + Fitness1(X, Y);

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

		fitness = Fitness(X, Y) + Fitness1(X, Y);

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

		fitness = Fitness(X, Y) + Fitness1(X, Y);

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

		fitness = Fitness(X, Y) + Fitness1(X, Y);

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

	static double Fitness1(int[][] X, int[][] Y) {
		double fitness = 0;

		int[] R1 = new int[K];
		int R2;
		int[][] R3 = new int[I][K];
	
		for (int i = 0; i < R1.length; i++)
			R1[i] = PSO_Read_Write_txt.R1();
		R2 = PSO_Read_Write_txt.R2();
		for (int i = 0; i < R3.length; i++)
			for (int j = 0; j < R3[i].length; j++)
				R3[i][j] = PSO_Read_Write_txt.R3();

		 
		for (int k = 0; k < K; k++) {
			int s1 = 0, s2 = 0;
			for (int i = 0; i < I; i++)
				for (int j = 0; j < X[i].length; j++)
					s1 += X[i][j] * Read_Double_Auction.getqijk(i, j, k);

			for (int n = 0; n < N; n++)
				for (int h = 0; h < Y[n].length; h++)
					s2 += Y[n][h] * Read_Double_Auction.getdnhk(n, h, k);
			fitness += R1[k] * Math.min(s1 - s2, 0.0);
		}

		int s3 = 0, s4 = 0;
		for (int n = 0; n < N; n++)
			for (int h = 0; h < Y[n].length; h++)
				s3 += Y[n][h] * Read_Double_Auction.getPnh(n, h);

		for (int i = 0; i < I; i++)
			for (int j = 0; j < X[i].length; j++)
				s4 += X[i][j]*Read_Double_Auction.getPij(i, j);
						 
		fitness += R2 * Math.min(s3 - s4, 0.0);

		for (int i = 0; i < I; i++)
				for (int k = 0; k < K; k++){
				int s5 = 0;
				for (int j = 0; j < X[i].length; j++) 
					s5 += X[i][j] * Read_Double_Auction.getqijk(i, j, k);
				fitness += R3[i][k]* Math.min(Read_Double_Auction.getSik(i, k) - s5, 0.0);
			}
		return fitness;
	}
}