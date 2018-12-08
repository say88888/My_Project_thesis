package Algorithm_Carpool.Lagrangian_Relaxation_and_PSO1_P;

import Input_Output_txt.Carpool.Read_file;

public class FitnessCalc extends LR_and_PSO1_P {

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

		Object_Function.Function(X, Y);
		
		fitness += Fitness(X, Y);

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

		Object_Function.Function(X, Y);
		
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

		Object_Function.Function(X, Y);
		
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

		Object_Function.Function(X, Y);
		
		fitness = Fitness(X, Y) + Fitness1(X, Y);
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

		Object_Function.Function(X, Y);
		
		fitness = Fitness(X, Y) + Fitness1(X, Y);

		return fitness;
	}

	static double Fitness(int[][] X, int[][] Y) {
		double fitness = 0, fitness2 = 0,fitness3=0,fitness5=0,fitness6=0,fitness7=0;
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
		fitness6=Omega_6*Object_Function.get_cp_all_actual();
		fitness7=Omega_7*((Object_Function.get_cp_p()*wp1)+(Object_Function.get_cp_d()*wd1));
		
		return fitness + fitness2 + fitness3 + fitness5+fitness6+fitness7;
	}

	static double Fitness1(int[][] X, int[][] Y) {
		double fitness = 0;
		
		double[] R1 = new double[K];
		double R2;
		double[][] R3 = new double[D][];
		double[][] R4 = new double[D][];
		double[] R5 = new double[D];

		for (int i = 0; i < D; i++)
			R3[i] = new double[Read_file.getJd(i)];

		for (int i = 0; i < D; i++)
			R4[i] = new double[Read_file.getJd(i)];
		 
		for (int i = 0; i < R1.length; i++)
			R1[i] = PSO_Read_Write_txt.R1();
		
		R2 = PSO_Read_Write_txt.R2();
		
		for (int i = 0; i < R3.length; i++)
			for (int j = 0; j < R3[i].length; j++)
				R3[i][j] = PSO_Read_Write_txt.R3();

		for (int i = 0; i < R4.length; i++)
			for (int j = 0; j < R4[i].length; j++)
				R4[i][j] =PSO_Read_Write_txt.R4();

		for (int i = 0; i < R5.length; i++)
			R5[i] = PSO_Read_Write_txt.R5();
		for (int k = 0; k < K; k++) {
			int s1 = 0, s2 = 0;
			for (int d = 0; d < D; d++)
				for (int j = 0; j < X[d].length; j++)
					s1 += X[d][j] * Read_file.getqdjk(d, j, k);

			for (int p = 0; p < P; p++)
				for (int h = 0; h < Y[p].length; h++)
					s2 += Y[p][h] * Read_file.getSphk(p, h, k);
			fitness += R1[k] * Math.min(s1 - s2, 0.0);
		}

		int s3 = 0, s4 = 0;
		for (int p = 0; p < P; p++)
			for (int h = 0; h < Y[p].length; h++)
				s3 += Y[p][h] * Read_file.getfph(p, h);

		for (int d = 0; d < D; d++)
			for (int j = 0; j < X[d].length; j++)
				s4 += X[d][j]
						* (Read_file.getCdj(d, j) - Read_file.getOdj(d, j));
		fitness += R2 * Math.min(s3 - s4, 0.0);

		for (int d = 0; d < D; d++)
			for (int j = 0; j < X[d].length; j++) {
				int s5 = 0;
				for (int k = 0; k < K; k++)
					s5 += X[d][j] * Read_file.getqdjk(d, j, k);
				fitness += R3[d][j]* Math.min(Read_file.getadj(d, j) - s5, 0.0);
			}

		for (int d = 0; d < D; d++)
			for (int j = 0; j < X[d].length; j++) {
				int s6 = 0;
				for (int k = 0; k < K; k++)
					s6 += X[d][j] * Read_file.getWqdjk(d, j, k);
				fitness += R4[d][j]* Math.min(Read_file.getldj(d, j) - s6, 0.0);
			}

		for (int d = 0; d < D; d++) {
			int s7 = 0;
			for (int j = 0; j < X[d].length; j++) {
				s7 += X[d][j];
			}
			fitness += R5[d] * Math.min(1 - s7, 0.0);
		}
		return fitness;
	}
}