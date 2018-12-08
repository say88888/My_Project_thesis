package Algorithm_DoubleAuction.L_SHADE_CCPSO2_DA;
 
import Input_Output_txt.Double_Auction.Read_Double_Auction;
 

public class FitnessCalc extends Double_Auction_L_SHADE_CCPSO2 {
	static double getFitness(G_Individual individual) {

		double fitness = 0;
		int c = 0;
		int[][] Y = new int[N][];
		double[][] rb = new double[N][];
		for (int i = 0; i < N; i++) {
			Y[i] = new int[Read_Double_Auction.getH(i)];
			rb[i] = new double[Read_Double_Auction.getH(i)];
		}

		int[][] X = new int[I][];
		double[][] rs = new double[I][];
		for (int i = 0; i < I; i++) {
			X[i] = new int[Read_Double_Auction.getJ(i)];
			rs[i] = new double[Read_Double_Auction.getJ(i)];
		}

		int b = 0;
		for (int i = 0; i < N; i++)
			for (int j = 0; j < Y[i].length; j++) {
				Y[i][j] = individual.getGy(c);
				rb[i][j] = individual.getGrb(c);
				c++;
			}

		for (int i = 0; i < I; i++)
			for (int j = 0; j < X[i].length; j++) {
				X[i][j] = individual.getGx(b);
				rs[i][j] = individual.getGrs(b);
				b++;
			}

		double r = individual.getGr();

		if (Omega1 == 1) {
			fitness = Fitness(X, Y);
		} else if (Omega2 == 1) {
			fitness = Fitness2(X, Y, rs, rb);
		} else if (Omega3 == 1) {
			fitness = Fitness3(X, Y, rs, rb);
		} else if (Omega4 == 1) {
			fitness = Fitness4(X, Y, r);
		}

		return fitness;
	}

	// F2(X,Y)
	static double getFitness1(Individual individual) {
		double fitness = 0;
		int c = 0;
		int[][] Y = new int[N][];
		double[][] rb = new double[N][];
		for (int i = 0; i < N; i++) {
			Y[i] = new int[Read_Double_Auction.getH(i)];
			rb[i] = new double[Read_Double_Auction.getH(i)];
		}

		int[][] X = new int[I][];
		double[][] rs = new double[I][];
		for (int i = 0; i < I; i++) {
			X[i] = new int[Read_Double_Auction.getJ(i)];
			rs[i] = new double[Read_Double_Auction.getJ(i)];
		}

		int b = 0;
		for (int i = 0; i < N; i++)
			for (int j = 0; j < Y[i].length; j++) {
				Y[i][j] = individual.getY(c);
				rb[i][j] = individual.getrb(c);
				c++;
			}

		for (int i = 0; i < I; i++)
			for (int j = 0; j < X[i].length; j++) {
				X[i][j] = individual.getX(b);
				rs[i][j] = individual.getrs(b);
				b++;
			}
		double r=individual.getr();
		
		if (Omega1 == 1) {
			if (constraint(X, Y) == true) {
				fitness = Fitness(X, Y);
				SFminsb.append(fitness + " ");
			}
			// U1(X,Y)
			else {
				double Sfmin;
				Sfmin = Double_Auction_L_SHADE_CCPSO2.Sfmin;
				fitness = Sfmin + U1(X, Y);
			}
		} else if (Omega2 == 1) {
			if (constraint2(X, Y, rs, rb) == true) {
				fitness = Fitness2(X, Y, rs, rb);
				SFminsb.append(fitness + " ");
			}
			// U1(X,Y)
			else {
				double Sfmin;
				Sfmin = Double_Auction_L_SHADE_CCPSO2.Sfmin;
				fitness = Sfmin + U2(X, Y, rs, rb);
			}

		} else if (Omega3 == 1) {
			if (constraint3(X, Y, rs, rb) == true) {
				fitness = Fitness3(X, Y, rs, rb);
				SFminsb.append(fitness + " ");
			}
			// U1(X,Y)
			else {
				double Sfmin;
				Sfmin = Double_Auction_L_SHADE_CCPSO2.Sfmin;
				fitness = Sfmin + U3(X, Y, rs, rb);
			}

		}else if (Omega4 == 1) {
			if (constraint4(X, Y, r) == true) {
				fitness = Fitness4(X, Y, r);
				SFminsb.append(fitness + " ");
			}
			// U1(X,Y)
			else {
				double Sfmin;
				Sfmin = Double_Auction_L_SHADE_CCPSO2.Sfmin;
				fitness = Sfmin + U4(X, Y, r);
			}

		}

		return fitness;
	}

	static double getPFitness(P_Individual individual) {
		double fitness = 0;
		int c = 0;
		int[][] Y = new int[N][];
		double[][] rb = new double[N][];
		for (int i = 0; i < N; i++) {
			Y[i] = new int[Read_Double_Auction.getH(i)];
			rb[i] = new double[Read_Double_Auction.getH(i)];
		}

		int[][] X = new int[I][];
		double[][] rs = new double[I][];
		for (int i = 0; i < I; i++) {
			X[i] = new int[Read_Double_Auction.getJ(i)];
			rs[i] = new double[Read_Double_Auction.getJ(i)];
		}

		int b = 0;
		for (int i = 0; i < N; i++)
			for (int j = 0; j < Y[i].length; j++) {
				Y[i][j] = individual.getPy(c);
				rb[i][j] = individual.getPrb(c);
				c++;
			}

		for (int i = 0; i < I; i++)
			for (int j = 0; j < X[i].length; j++) {
				X[i][j] = individual.getPx(b);
				rs[i][j] = individual.getPrs(b);
				b++;
			}
		double r=individual.getPr();
		
		if (Omega1 == 1) {
			if (constraint(X, Y) == true) {
				fitness = Fitness(X, Y);
				SFminsb.append(fitness + " ");
			}
			// U1(X,Y)
			else {
				double Sfmin;
				Sfmin = Double_Auction_L_SHADE_CCPSO2.Sfmin;
				fitness = Sfmin + U1(X, Y);
			}
		} else if (Omega2 == 1) {
			if (constraint2(X, Y, rs, rb) == true) {
				fitness = Fitness2(X, Y, rs, rb);
				SFminsb.append(fitness + " ");
			}
			// U1(X,Y)
			else {
				double Sfmin;
				Sfmin = Double_Auction_L_SHADE_CCPSO2.Sfmin;
				fitness = Sfmin + U2(X, Y, rs, rb);
			}

		} else if (Omega3 == 1) {
			if (constraint3(X, Y, rs, rb) == true) {
				fitness = Fitness3(X, Y, rs, rb);
				SFminsb.append(fitness + " ");
			}
			// U1(X,Y)
			else {
				double Sfmin;
				Sfmin = Double_Auction_L_SHADE_CCPSO2.Sfmin;
				fitness = Sfmin + U3(X, Y, rs, rb);
			}

		}else if (Omega4 == 1) {
			if (constraint4(X, Y, r) == true) {
				fitness = Fitness4(X, Y, r);
				SFminsb.append(fitness + " ");
			}
			// U1(X,Y)
			else {
				double Sfmin;
				Sfmin = Double_Auction_L_SHADE_CCPSO2.Sfmin;
				fitness = Sfmin + U4(X, Y, r);
			}
		}
		return fitness;
	}

	static double getGFitness(G_Individual individual) {
		double fitness = 0;
		int c = 0;
		int[][] Y = new int[N][];
		double[][] rb = new double[N][];
		for (int i = 0; i < N; i++) {
			Y[i] = new int[Read_Double_Auction.getH(i)];
			rb[i] = new double[Read_Double_Auction.getH(i)];
		}

		int[][] X = new int[I][];
		double[][] rs = new double[I][];
		for (int i = 0; i < I; i++) {
			X[i] = new int[Read_Double_Auction.getJ(i)];
			rs[i] = new double[Read_Double_Auction.getJ(i)];
		}

		int b = 0;
		for (int i = 0; i < N; i++)
			for (int j = 0; j < Y[i].length; j++) {
				Y[i][j] = individual.getGy(c);
				rb[i][j] = individual.getGrb(c);
				c++;
			}

		for (int i = 0; i < I; i++)
			for (int j = 0; j < X[i].length; j++) {
				X[i][j] = individual.getGx(b);
				rs[i][j] = individual.getGrs(b);
				b++;
			}
		double r=individual.getGr();
		
		if (Omega1 == 1) {
			if (constraint(X, Y) == true) {
				fitness = Fitness(X, Y);
				SFminsb.append(fitness + " ");
			}
			// U1(X,Y)
			else {
				double Sfmin;
				Sfmin = Double_Auction_L_SHADE_CCPSO2.Sfmin;
				fitness = Sfmin + U1(X, Y);
			}
		} else if (Omega2 == 1) {
			if (constraint2(X, Y, rs, rb) == true) {
				fitness = Fitness2(X, Y, rs, rb);
				SFminsb.append(fitness + " ");
			}
			// U1(X,Y)
			else {
				double Sfmin;
				Sfmin = Double_Auction_L_SHADE_CCPSO2.Sfmin;
				fitness = Sfmin + U2(X, Y, rs, rb);
			}

		} else if (Omega3 == 1) {
			if (constraint3(X, Y, rs, rb) == true) {
				fitness = Fitness3(X, Y, rs, rb);
				SFminsb.append(fitness + " ");
			}
			// U1(X,Y)
			else {
				double Sfmin;
				Sfmin = Double_Auction_L_SHADE_CCPSO2.Sfmin;
				fitness = Sfmin + U3(X, Y, rs, rb);
			}

		}else if (Omega4 == 1) {
			if (constraint4(X, Y, r) == true) {
				fitness = Fitness4(X, Y, r);
				SFminsb.append(fitness + " ");
			}
			// U1(X,Y)
			else {
				double Sfmin;
				Sfmin = Double_Auction_L_SHADE_CCPSO2.Sfmin;
				fitness = Sfmin + U4(X, Y, r);
			}
		}
		
		return fitness;
	}

	static double getEFitness1(E_Individual individual) {

		double fitness = 0;
		int c = 0;
		int[][] Y = new int[N][];
		double[][] rb = new double[N][];
		for (int i = 0; i < N; i++) {
			Y[i] = new int[Read_Double_Auction.getH(i)];
			rb[i] = new double[Read_Double_Auction.getH(i)];
		}

		int[][] X = new int[I][];
		double[][] rs = new double[I][];
		for (int i = 0; i < I; i++) {
			X[i] = new int[Read_Double_Auction.getJ(i)];
			rs[i] = new double[Read_Double_Auction.getJ(i)];
		}

		int b = 0;
		for (int i = 0; i < N; i++)
			for (int j = 0; j < Y[i].length; j++) {
				Y[i][j] = individual.getEy(c);
				rb[i][j] = individual.getErb(c);
				c++;
			}

		for (int i = 0; i < I; i++)
			for (int j = 0; j < X[i].length; j++) {
				X[i][j] = individual.getEx(b);
				rs[i][j] = individual.getErs(b);
				b++;
			}
		double r=individual.getEr();
		
		if (Omega1 == 1) {
			if (constraint(X, Y) == true) {
				fitness = Fitness(X, Y);
				SFminsb.append(fitness + " ");
			}
			// U1(X,Y)
			else {
				double Sfmin;
				Sfmin = Double_Auction_L_SHADE_CCPSO2.Sfmin;
				fitness = Sfmin + U1(X, Y);
			}
		} else if (Omega2 == 1) {
			if (constraint2(X, Y, rs, rb) == true) {
				fitness = Fitness2(X, Y, rs, rb);
				SFminsb.append(fitness + " ");
			}
			// U1(X,Y)
			else {
				double Sfmin;
				Sfmin = Double_Auction_L_SHADE_CCPSO2.Sfmin;
				fitness = Sfmin + U2(X, Y, rs, rb);
			}

		} else if (Omega3 == 1) {
			if (constraint3(X, Y, rs, rb) == true) {
				fitness = Fitness3(X, Y, rs, rb);
				SFminsb.append(fitness + " ");
			}
			// U1(X,Y)
			else {
				double Sfmin;
				Sfmin = Double_Auction_L_SHADE_CCPSO2.Sfmin;
				fitness = Sfmin + U3(X, Y, rs, rb);
			}

		}else if (Omega4 == 1) {
			if (constraint4(X, Y, r) == true) {
				fitness = Fitness4(X, Y, r);
				SFminsb.append(fitness + " ");
			}
			// U1(X,Y)
			else {
				double Sfmin;
				Sfmin = Double_Auction_L_SHADE_CCPSO2.Sfmin;
				fitness = Sfmin + U4(X, Y, r);
			}
		}
		
		return fitness;
	}

	static double Fitness(int[][] X, int[][] Y) {
		double fitness = 0;
		for (int n = 0; n < N; n++)
			for (int h = 0; h < Y[n].length; h++) {
				fitness += Y[n][h] * (Read_Double_Auction.getPnh(n, h) + (Read_Double_Auction.getTbm() * Read_Double_Auction.getPnh(n, h)));
			}
		for (int i = 0; i < I; i++)
			for (int j = 0; j < X[i].length; j++) {
				fitness -= X[i][j] * (Read_Double_Auction.getPij(i, j) - (Read_Double_Auction.getTsm() * Read_Double_Auction.getPij(i, j)));
			}

		return fitness;
	}

	static double Fitness2(int[][] X, int[][] Y, double[][] rs, double[][] rb) {
		double fitness = 0;
		for (int n = 0; n < N; n++)
			for (int h = 0; h < Y[n].length; h++) {
				fitness += Y[n][h] * rb[n][h] * Read_Double_Auction.getPnh(n, h);
			}
		for (int i = 0; i < I; i++)
			for (int j = 0; j < X[i].length; j++) {
				fitness += X[i][j] * rs[i][j] * Read_Double_Auction.getPij(i, j);
			}

		return fitness;
	}

	static double Fitness3(int[][] X, int[][] Y, double[][] rs, double[][] rb) {
		double fitness = 0;
		for (int n = 0; n < N; n++)
			for (int h = 0; h < Y[n].length; h++) {
				fitness += rb[n][h];
			}
		for (int i = 0; i < I; i++)
			for (int j = 0; j < X[i].length; j++) {
				fitness += rs[i][j];
			}

		return fitness;
	}

	static double Fitness4(int[][] X, int[][] Y, double r) {
		double fitness = r;

		return fitness;
	}

	static double U1(int[][] X, int[][] Y) {
		double fitness = 0;

		for (int k = 0; k < K; k++) {
			double s1 = 0, s2 = 0;
			for (int i = 0; i < I; i++) {
				for (int j = 0; j < X[i].length; j++)
					s1 += X[i][j] * Read_Double_Auction.getqijk(i, j, k);
			}
			for (int n = 0; n < N; n++) {
				for (int h = 0; h < Y[n].length; h++)
					s2 += Y[n][h] * Read_Double_Auction.getdnhk(n, h, k);
			}
			fitness += Math.min(s1 - s2, 0.0);

		}
		double s3 = 0, s4 = 0;
		for (int n = 0; n < N; n++) {
			for (int h = 0; h < Y[n].length; h++)
				s3 += Y[n][h] * Read_Double_Auction.getPnh(n, h);
		}
		for (int i = 0; i < I; i++) {
			for (int j = 0; j < X[i].length; j++)
				s4 += X[i][j] * Read_Double_Auction.getPij(i, j);
		}
		fitness += Math.min(s3 - s4, 0.0);

		for (int i = 0; i < I; i++) {
			for (int k = 0; k < K; k++) {
				double s5 = 0;
				for (int j = 0; j < X[i].length; j++)
					s5 += X[i][j] * Read_Double_Auction.getqijk(i, j, k);
				fitness += Math.min(Read_Double_Auction.getSik(i, k) - s5, 0.0);

			}
		}

		return fitness;
	}

	static double U2(int[][] X, int[][] Y, double[][] rs, double[][] rb) {
		double fitness = 0;

		for (int k = 0; k < K; k++) {
			double s1 = 0, s2 = 0;
			for (int i = 0; i < I; i++) {
				for (int j = 0; j < X[i].length; j++)
					s1 += X[i][j] * Read_Double_Auction.getqijk(i, j, k);
			}
			for (int n = 0; n < N; n++) {
				for (int h = 0; h < Y[n].length; h++)
					s2 += Y[n][h] * Read_Double_Auction.getdnhk(n, h, k);
			}
			fitness += Math.min(s1 - s2, 0.0);
		}

		double s3 = 0, s4 = 0;
		for (int n = 0; n < N; n++) {
			for (int h = 0; h < Y[n].length; h++)
				s3 += Y[n][h] * Read_Double_Auction.getPnh(n, h) * (1 - rb[n][h]);
		}
		for (int i = 0; i < I; i++) {
			for (int j = 0; j < X[i].length; j++)
				s4 += X[i][j] * Read_Double_Auction.getPij(i, j) * (1 + rs[i][j]);
		}
		fitness += Math.min(s3 - s4, 0.0);

		for (int i = 0; i < I; i++) {
			for (int k = 0; k < K; k++) {
				double s5 = 0;
				for (int j = 0; j < X[i].length; j++)
					s5 += X[i][j] * Read_Double_Auction.getqijk(i, j, k);
				fitness += Math.min(Read_Double_Auction.getSik(i, k) - s5, 0.0);

			}
		}

		for (int n = 0; n < N; n++)
			for (int h = 0; h < Y[n].length; h++) {
				fitness += Math.min((1 - rb[n][h]), 0.0);
				fitness += Math.min((rb[n][h]), 0.0);
			}

		for (int i = 0; i < I; i++)
			for (int j = 0; j < X[i].length; j++) {
				fitness += Math.min((1 - rs[i][j]), 0.0);
				fitness += Math.min((rs[i][j]), 0.0);
			}

		return fitness;
	}

	static double U3(int[][] X, int[][] Y, double[][] rs, double[][] rb) {
		double fitness = 0;

		for (int k = 0; k < K; k++) {
			double s1 = 0, s2 = 0;
			for (int i = 0; i < I; i++) {
				for (int j = 0; j < X[i].length; j++)
					s1 += X[i][j] * Read_Double_Auction.getqijk(i, j, k);
			}
			for (int n = 0; n < N; n++) {
				for (int h = 0; h < Y[n].length; h++)
					s2 += Y[n][h] * Read_Double_Auction.getdnhk(n, h, k);
			}
			fitness += Math.min(s1 - s2, 0.0);
		}

		double s3 = 0, s4 = 0;
		for (int n = 0; n < N; n++) {
			for (int h = 0; h < Y[n].length; h++)
				s3 += Y[n][h] * Read_Double_Auction.getPnh(n, h) * (1 - rb[n][h]);
		}
		for (int i = 0; i < I; i++) {
			for (int j = 0; j < X[i].length; j++)
				s4 += X[i][j] * Read_Double_Auction.getPij(i, j) * (1 + rs[i][j]);
		}
		fitness += Math.min(s3 - s4, 0.0);

		for (int i = 0; i < I; i++) {
			for (int k = 0; k < K; k++) {
				double s5 = 0;
				for (int j = 0; j < X[i].length; j++)
					s5 += X[i][j] * Read_Double_Auction.getqijk(i, j, k);
				fitness += Math.min(Read_Double_Auction.getSik(i, k) - s5, 0.0);

			}
		}

		for (int n = 0; n < N; n++)
			for (int h = 0; h < Y[n].length; h++) {
				fitness += Math.min((1 - rb[n][h]), 0.0);
				fitness += Math.min((rb[n][h]), 0.0);
			}

		for (int i = 0; i < I; i++)
			for (int j = 0; j < X[i].length; j++) {
				fitness += Math.min((1 - rs[i][j]), 0.0);
				fitness += Math.min((rs[i][j]), 0.0);
			}

		double s=0;
		for(int i=0;i<I;i++)
			for(int j=0;j<X[i].length;j++)
				s+=X[i][j];
		fitness+=Math.min(s-1, 0.0);
		
		s=0;
		for(int n=0;n<N;n++)
			for(int h=0;h<Y[n].length;h++)
				s+=Y[n][h];
		fitness+=Math.min(s-1, 0.0);
		
		return fitness;
	}

	static double U4(int[][] X, int[][] Y, double r) {
		double fitness = 0;

		for (int k = 0; k < K; k++) {
			double s1 = 0, s2 = 0;
			for (int i = 0; i < I; i++) {
				for (int j = 0; j < X[i].length; j++)
					s1 += X[i][j] * Read_Double_Auction.getqijk(i, j, k);
			}
			for (int n = 0; n < N; n++) {
				for (int h = 0; h < Y[n].length; h++)
					s2 += Y[n][h] * Read_Double_Auction.getdnhk(n, h, k);
			}
			fitness += Math.min(s1 - s2, 0.0);
		}

		double s3 = 0, s4 = 0;
		for (int n = 0; n < N; n++) {
			for (int h = 0; h < Y[n].length; h++)
				s3 += Y[n][h] * Read_Double_Auction.getPnh(n, h) * (1 - r);
		}
		for (int i = 0; i < I; i++) {
			for (int j = 0; j < X[i].length; j++)
				s4 += X[i][j] * Read_Double_Auction.getPij(i, j) * (1 + r);
		}
		fitness += Math.min(s3 - s4, 0.0);

		for (int i = 0; i < I; i++) {
			for (int k = 0; k < K; k++) {
				double s5 = 0;
				for (int j = 0; j < X[i].length; j++)
					s5 += X[i][j] * Read_Double_Auction.getqijk(i, j, k);
				fitness += Math.min(Read_Double_Auction.getSik(i, k) - s5, 0.0);

			}
		}

		fitness += Math.min((1 - r), 0.0);
		fitness += Math.min(r, 0.0);

		double s=0;
		for(int i=0;i<I;i++)
			for(int j=0;j<X[i].length;j++)
				s+=X[i][j];
		fitness+=Math.min(s-1, 0.0);
		
		s=0;
		for(int n=0;n<N;n++)
			for(int h=0;h<Y[n].length;h++)
				s+=Y[n][h];
		fitness+=Math.min(s-1, 0.0);
		
		return fitness;
	}

	static boolean constraint(int[][] X, int[][] Y) {
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

	static boolean constraint2(int[][] X, int[][] Y, double[][] rs, double[][] rb) {
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
				st231 += Y[n][h] * Read_Double_Auction.getPnh(n, h) * (1 - rb[n][h]);
		for (int i = 0; i < I; i++)
			for (int j = 0; j < X[i].length; j++)
				st232 += X[i][j] * Read_Double_Auction.getPij(i, j) * (1 + rs[i][j]);
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

		for (int n = 0; n < N; n++)
			for (int h = 0; h < Y[n].length; h++)
				if (rb[n][h] > 1 || rb[n][h] < 0)
					right = false;

		for (int i = 0; i < I; i++)
			for (int j = 0; j < X[i].length; j++)
				if (rs[i][j] > 1 || rs[i][j] < 0)
					right = false;

		return right;
	}

	static boolean constraint3(int[][] X, int[][] Y, double[][] rs, double[][] rb) {
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
				st231 += Y[n][h] * Read_Double_Auction.getPnh(n, h) * (1 - rb[n][h]);
		for (int i = 0; i < I; i++)
			for (int j = 0; j < X[i].length; j++)
				st232 += X[i][j] * Read_Double_Auction.getPij(i, j) * (1 + rs[i][j]);
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

		for (int n = 0; n < N; n++)
			for (int h = 0; h < Y[n].length; h++)
				if (rb[n][h] > 1 || rb[n][h] < 0)
					right = false;

		for (int i = 0; i < I; i++)
			for (int j = 0; j < X[i].length; j++)
				if (rs[i][j] > 1 || rs[i][j] < 0)
					right = false;

		double s=0;
		for (int i = 0; i < I; i++)
			for (int j = 0; j < X[i].length; j++)
				s+=X[i][j];
		if(s<1)
			right = false;
		
		s=0;
		for (int n = 0; n < N; n++)
			for (int h = 0; h < Y[n].length; h++)
				s+=Y[n][h];
		if(s<1)
			right=false;
		
		return right;
	}

	static boolean constraint4(int[][] X, int[][] Y, double r) {
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
				st231 += Y[n][h] * Read_Double_Auction.getPnh(n, h) * (1 - r);
		for (int i = 0; i < I; i++)
			for (int j = 0; j < X[i].length; j++)
				st232 += X[i][j] * Read_Double_Auction.getPij(i, j) * (1 + r);
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

		if (r > 1 || r < 0)
			right = false;

		double s=0;
		for (int i = 0; i < I; i++)
			for (int j = 0; j < X[i].length; j++)
				s+=X[i][j];
		if(s<1)
			right = false;
		
		s=0;
		for (int n = 0; n < N; n++)
			for (int h = 0; h < Y[n].length; h++)
				s+=Y[n][h];
		if(s<1)
			right=false;
		
		return right;
	}

	static double getSFmin(StringBuilder sb) {
		double SFmin;
		String[] a = sb.toString().split(" ");
		if (a.length == 1) {
			SFmin = 0;
		} else {
			SFmin = Double.parseDouble(a[0]);
			for (int i = 0; i < a.length; i++)
				if (SFmin >= Double.parseDouble(a[i]))
					SFmin = Double.parseDouble(a[i]);

		}

		SFminsb = new StringBuilder();
		return SFmin;
	}
}
