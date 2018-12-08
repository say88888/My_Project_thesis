package Algorithm_Carpool.Lagrangian_PSO_P;

import Input_Output_txt.Carpool.Read_file;

public class FitnessCalc extends ALPSO_P {

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

		fitness = Fitness(X, Y) + Fitness1(X, Y);

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

		fitness = Fitness(X, Y) + Fitness1(X, Y);

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

		fitness = Fitness(X, Y) +Fitness1(X, Y);
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

		fitness = Fitness(X, Y) + Fitness1(X, Y);

		return fitness;
	}

	static double Fitness(int[][] X, int[][] Y) {
		double fitness = 0 ;
		for (int p = 0; p < P; p++)
			for (int h = 0; h < Y[p].length; h++) {
				fitness += Y[p][h] * Read_file.getfph(p, h);
				fitness += Y[p][h] * Read_file.getTpm()* Read_file.getfph(p, h);
				 
			}
		for (int d = 0; d < D; d++)
			for (int j = 0; j < X[d].length; j++) {
				fitness -= X[d][j]* (Read_file.getCdj(d, j) - Read_file.getOdj(d, j));
				fitness += X[d][j] * Read_file.getTdm()* (Read_file.getCdj(d, j) - Read_file.getOdj(d, j));
		 
			}

		return fitness  ;
	}

	static double Fitness1(int[][] X, int[][] Y) {
		double fitness = 0,fitness2=0;

		for(int k=0;k<K;k++){
			fitness+=Lambda1[k]*Functions.Theta1(k, X, Y);
			fitness2+=Lambda1[k]*Math.pow(Functions.Theta1(k, X, Y),2);
		}
		fitness+=Lambda2*Functions.Theta2( X, Y);
		fitness2+=Lambda2*Math.pow(Functions.Theta2( X, Y),2);
		for(int d=0;d<D;d++)
			for(int j=0;j<Read_file.getJd(d);j++){
				fitness+=Lambda3[d][j]*Functions.Theta3(d, j, X, Y);
				fitness+=Lambda4[d][j]*Functions.Theta4(d, j, X, Y);
				fitness2+=Lambda3[d][j]*Math.pow(Functions.Theta3(d, j, X, Y),2);
				fitness2+=Lambda4[d][j]*Math.pow(Functions.Theta4(d, j, X, Y),2);
			}
		fitness*=Omega_1;
		fitness2*=Omega_2;
		return fitness+fitness2;
	}
}