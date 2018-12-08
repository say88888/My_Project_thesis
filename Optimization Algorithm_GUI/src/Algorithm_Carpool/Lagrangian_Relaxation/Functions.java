package Algorithm_Carpool.Lagrangian_Relaxation;

import Input_Output_txt.Carpool.Read_file;

public class Functions extends LR {

	public static double g1(int k, int[][] X, int[][] Y) {
		double fittest = 0;

		for (int p = 0; p < Y.length; p++)
			for (int h = 0; h < Y[p].length; h++)
				fittest += Y[p][h] * Read_file.getSphk(p, h, k);
		for (int d = 0; d < X.length; d++)
			for (int j = 0; j < X[d].length; j++)
				fittest -= X[d][j] * Read_file.getqdjk(d, j, k);
		
		return fittest;
	}

	public static double g2(int[][] X, int[][] Y) {
		double fittest = 0;

		for (int d = 0; d < X.length; d++)
			for (int j = 0; j < X[d].length; j++)
				fittest += X[d][j] * Read_file.getCdj(d, j);
		for (int p = 0; p < Y.length; p++)
			for (int h = 0; h < Y[p].length; h++)
				fittest -= Y[p][h] * Read_file.getfph(p, h);
		return fittest;
	}

	public static double g3(int d, int j, int[][] X, int[][] Y) {
		double fittest = 0;

		for (int k = 0; k < K; k++)
			fittest += X[d][j] * Read_file.getqdjk(d, j, k);
		fittest -= Read_file.getadj(d, j);
		return fittest;
	}

	public static double g4(int d, int j, int[][] X, int[][] Y) {
		double fittest = 0;

		for (int k = 0; k < K; k++)
			fittest += X[d][j] * Read_file.getWqdjk(d, j, k);
		fittest -= Read_file.getldj(d, j);
		return fittest;
	}

	public static double a1(int[][] X, int[][] Y) // Theta1=θ1 Lambda =λ1
	{
		double fitness = 0;

		for (int k = 0; k < K; k++)
			fitness += Math.pow(g1(k, X, Y), 2);
		fitness += Math.pow(g2(X, Y), 2);
		for (int d = 0; d < D; d++)
			for (int j = 0; j < Read_file.getJd(d); j++) {
				fitness += Math.pow(g3(d, j, X, Y), 2);
				fitness += Math.pow(g4(d, j, X, Y), 2);
			}
		return c * (L(X, Y) - L) / fitness;
	}

	public static double a2(int[][] X, int[][] Y) // Theta2=θ2 Lambda =λ2
	{
		double fitness = 0;

		for (int k = 0; k < K; k++)
			fitness += Math.pow(g1(k, X, Y), 2);
		fitness += Math.pow(g2(X, Y), 2);
		for (int d = 0; d < D; d++)
			for (int j = 0; j < Read_file.getJd(d); j++) {
				fitness += Math.pow(g3(d, j, X, Y), 2);
				fitness += Math.pow(g4(d, j, X, Y), 2);
			}
		return c * (L(X, Y) - L) / fitness;
	}

	public static double a3(int[][] X, int[][] Y) // Theta3=θ3 Lambda =λ3
	{
		double fitness = 0;

		for (int k = 0; k < K; k++)
			fitness += Math.pow(g1(k, X, Y), 2);
		fitness += Math.pow(g2(X, Y), 2);
		for (int d = 0; d < D; d++)
			for (int j = 0; j < Read_file.getJd(d); j++) {
				fitness += Math.pow(g3(d, j, X, Y), 2);
				fitness +=Math.pow(g4(d, j, X, Y), 2);
			}
		return c * (L(X, Y) - L) / fitness;
	}

	public static double a4(int[][] X, int[][] Y) // Theta3=θ3 Lambda =λ3
	{
		double fitness = 0;

		for (int k = 0; k < K; k++)
			fitness += Math.pow(g1(k, X, Y), 2);
		fitness += Math.pow(g2(X, Y), 2);
		for (int d = 0; d < D; d++)
			for (int j = 0; j < Read_file.getJd(d); j++) {
				fitness += Math.pow(g3(d, j, X, Y), 2);
				fitness +=Math.pow(g4(d, j, X, Y), 2);
			}
		return c * (L(X, Y) - L) / fitness;
	}
	
	public static double L(int[][] X, int[][] Y) {
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
		
		for (int k = 0; k < K; k++)
			fitness -= Lambda1[k] * g1(k, X, Y);
		fitness -= Lambda2 * g2(X, Y);
		for (int d = 0; d < D; d++)
			for (int j = 0; j < Read_file.getJd(d); j++){
				fitness -= Lambda3[d][j] * g3( d,j, X, Y);
				fitness -= Lambda4[d][j] * g4( d,j, X, Y);
			} 
		return fitness;
	}
	
	public static int[][] Xdj(int[][] X ) {
		
		double[][] fitness =new double[D][];
		for (int i = 0; i <D; i++){
			fitness[i] = new double[X[i].length];
			}
		
		for (int d = 0; d < D; d++)
			for (int j = 0; j < X[d].length; j++) {
				fitness[d][j] -= (Read_file.getCdj(d, j) - Read_file.getOdj(d, j));
				fitness[d][j] += Read_file.getTdm()* (Read_file.getCdj(d, j)-Read_file.getOdj(d, j));
				
				for (int k = 0; k < K; k++){
					fitness[d][j] += Lambda1[k] * Read_file.getqdjk(d, j, k);
					fitness[d][j] -= Lambda3[d][j] * Read_file.getqdjk(d, j, k);
					fitness[d][j] -= Lambda4[d][j] * Read_file.getWqdjk(d, j, k);
				}
				
				fitness[d][j]-=Lambda2*(Read_file.getCdj(d, j)-Read_file.getOdj(d, j));
				
				if(fitness[d][j]>0){X[d][j]=1;}
				else{X[d][j]=0;}
			}
		
		return X;
	}

	
	public static int[][] Yph(int[][] Y) {
		
		double[][] fitness =new double[P][];
		for (int i = 0; i <P; i++){
			fitness[i] = new double[Y[i].length];
			}
		
		for (int p = 0; p < P; p++)
			for (int h = 0; h < Y[p].length; h++) {
				fitness[p][h] += Read_file.getfph(p, h);
				fitness[p][h] += Read_file.getTpm()* (Read_file.getfph(p,h));
				
				for (int k = 0; k < K; k++){
					fitness[p][h] -= Lambda1[k];
				}
				
				fitness[p][h]+=Lambda2*Read_file.getfph(p, h);
				
				if(fitness[p][h]>0){Y[p][h]=1;}
				else{Y[p][h]=0;}
			}
		
		return Y;
	}
	
}
