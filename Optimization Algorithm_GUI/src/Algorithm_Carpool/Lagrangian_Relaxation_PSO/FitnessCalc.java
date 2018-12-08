package Algorithm_Carpool.Lagrangian_Relaxation_PSO;

import Input_Output_txt.Carpool.Read_file;

public class FitnessCalc extends LRPSO {

	static double getFitness(G_Individual individual) {
		double fitness = 0;
		int c = 0;
		int[][] Y = new int[P][];
		for (int i = 0; i < P; i++)
			Y[i] = new int[Read_file.getHp(i)];
		int[][] X = new int[D][];
		for (int i = 0; i < D; i++)
			X[i] = new int[Read_file.getJd(i)];
		int b = 0;
		for (int i = 0; i < P; i++)
			for (int j = 0; j < Y[i].length; j++)
				Y[i][j] = individual.getGy(c++);

		for (int i = 0; i < D; i++)
			for (int j = 0; j < X[i].length; j++)
				X[i][j] = individual.getGx(b++);

		fitness = Fitness(X, Y);

		return fitness;
	}

	// F1(X,Y)
	static double getFitness1(Individual individual) {

		double fitness = 0;
		int c = 0;
		int[][] Y = new int[P][];
		for (int i = 0; i < P; i++)
			Y[i] = new int[Read_file.getHp(i)];
		int[][] X = new int[D][];
		for (int i = 0; i < D; i++)
			X[i] = new int[Read_file.getJd(i)];
		int b = 0;
		for (int i = 0; i < P; i++)
			for (int j = 0; j < Y[i].length; j++)
				Y[i][j] = individual.getY(c++);

		for (int i = 0; i < D; i++)
			for (int j = 0; j < X[i].length; j++)
				X[i][j] = individual.getX(b++);

		fitness = Fitness(X, Y) - Fitness1(X, Y,Lambda1,Lambda2,Lambda3,Lambda4);

		return fitness;
	}

	static double getPFitness1(P_Individual individual) {
		double fitness = 0;

		int c = 0;
		int[][] Y = new int[P][];
		for (int i = 0; i < P; i++)
			Y[i] = new int[Read_file.getHp(i)];
		int[][] X = new int[D][];
		for (int i = 0; i < D; i++)
			X[i] = new int[Read_file.getJd(i)];
		int b = 0;
		for (int i = 0; i < P; i++)
			for (int j = 0; j < Y[i].length; j++)
				Y[i][j] = individual.getPy(c++);

		for (int i = 0; i < D; i++)
			for (int j = 0; j < X[i].length; j++)
				X[i][j] = individual.getPx(b++);

		fitness = Fitness(X, Y) - Fitness1(X, Y,Lambda1,Lambda2,Lambda3,Lambda4);

		return fitness;
	}

	static double getGFitness1(G_Individual individual) {
		double fitness = 0;

		int c = 0;
		int[][] Y = new int[P][];
		for (int i = 0; i < P; i++)
			Y[i] = new int[Read_file.getHp(i)];
		int[][] X = new int[D][];
		for (int i = 0; i < D; i++)
			X[i] = new int[Read_file.getJd(i)];
		int b = 0;
		for (int i = 0; i < P; i++)
			for (int j = 0; j < Y[i].length; j++)
				Y[i][j] = individual.getGy(c++);

		for (int i = 0; i < D; i++)
			for (int j = 0; j < X[i].length; j++)
				X[i][j] = individual.getGx(b++);

		fitness = Fitness(X, Y) - Fitness1(X, Y,Lambda1,Lambda2,Lambda3,Lambda4);
		return fitness;
	}

	static double getEFitness1(E_Individual individual) {
		double fitness = 0;

		int c = 0;
		int[][] Y = new int[P][];
		for (int i = 0; i < P; i++)
			Y[i] = new int[Read_file.getHp(i)];
		int[][] X = new int[D][];
		for (int i = 0; i < D; i++)
			X[i] = new int[Read_file.getJd(i)];
		int b = 0;
		for (int i = 0; i < P; i++)
			for (int j = 0; j < Y[i].length; j++)
				Y[i][j] = individual.getEy(c++);

		for (int i = 0; i < D; i++)
			for (int j = 0; j < X[i].length; j++)
				X[i][j] = individual.getEx(b++);

		fitness = Fitness(X, Y) - Fitness1(X, Y,Lambda1,Lambda2,Lambda3,Lambda4);

		return fitness;
	}

	static double Fitness(int[][] X, int[][] Y) {
		double fitness = 0, fitness2 = 0,fitness3=0,fitness5=0;
		for (int p = 0; p < P; p++)
			for (int h = 0; h < Y[p].length; h++) {
				fitness += Y[p][h] * Read_file.getfph(p, h);
				fitness += Y[p][h] * Read_file.getTpm()* Read_file.getfph(p, h);
				fitness2 += Y[p][h];
				
				fitness5+=Y[p][h] * Read_file.getfph(p, h);
			}
		for (int d = 0; d < D; d++)
			for (int j = 0; j < X[d].length; j++) {
				fitness -= X[d][j]* (Read_file.getCdj(d, j) - Read_file.getOdj(d, j));
				fitness += X[d][j] * Read_file.getTdm()* (Read_file.getCdj(d, j) - Read_file.getOdj(d, j));
				fitness2 += X[d][j];
			
				fitness5+=X[d][j]* (Read_file.getCdj(d, j)) ;
			}
		fitness3 = (fitness/fitness2)*Omega_3;
		fitness5 = (fitness/fitness5)*Omega_5;
		fitness *= Omega_1;
		fitness2 *= Omega_2;

		return fitness + fitness2 + fitness3 + fitness5;
	}

	static double Fitness1(int[][] X, int[][] Y, double[] lambda1, double lambda2, double[][] lambda3, double[][] lambda4) {
		double fitness = 0 ;

		for(int k=0;k<K;k++){
			fitness+=lambda1[k]*Functions.g1(k, X, Y);
		}
		fitness+=lambda2*Functions.g2( X, Y);
	 
		for(int d=0;d<D;d++)
			for(int j=0;j<Read_file.getJd(d);j++){
				fitness+=lambda3[d][j]*Functions.g3(d, j, X, Y);
				fitness+=lambda4[d][j]*Functions.g4(d, j, X, Y);
			}
		 
		return fitness ;
	}
}