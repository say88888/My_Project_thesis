package Algorithm_Carpool.Lagrangian_PSO;

import Input_Output_txt.Carpool.Read_file;

public class Functions extends ALPSO {

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

	public static double Theta1(int k, int[][] X, int[][] Y) // Theta1=θ1  Lambda =λ1
	{
		return -Math.max(g1(k,X,Y),-(Lambda1[k]/(2*r1[k])));
	}
	public static double Theta2( int[][] X, int[][] Y ) // Theta2=θ2  Lambda =λ2
	{
		return -Math.max(g2(X,Y),-(Lambda2/(2*r2)));
	}
	public static double Theta3( int d,int j,int[][] X, int[][] Y ) // Theta3=θ3  Lambda =λ3
	{
		return -Math.max(g3(d,j,X,Y),-(Lambda3[d][j]/(2*r3[d][j])));
	}
	public static double Theta4( int d,int j,int[][] X, int[][] Y) // Theta4=θ4  Lambda =λ4
	{
		return -Math.max(g4(d,j,X,Y),-(Lambda4[d][j]/(2*r4[d][j])));
	}
}
