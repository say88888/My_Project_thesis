package Algorithm_Carpool.Lagrangian_Relaxation_PSO_P;

import Input_Output_txt.Carpool.Read_file;

public class Print_Lambda_g extends LRPSO_P {

	public static void main(int[][] X, int[][] Y) {

		// TODO Auto-generated method stub
		if (Print == 1) {
			System.out.println("");
			System.out.println("λ1");
			for (int k = 0; k < K; k++)
				System.out.println("k="+(k+1)+" λ1="+Lambda1[k]+ " g1="+Functions.g1(k, X, Y));
			System.out.println("λ2");
			System.out.println("λ2="+Lambda2+ " g2="+Functions.g2( X, Y));
			System.out.println("λ3");
			for (int i = 0; i < D; i++)
				for (int k = 0; k <Read_file.getJd(i); k++)
					System.out.println( "i="+(i+1)+" k="+(k+1)+" λ3="+Lambda3[i][k] +" g3="+Functions.g3(i,k, X, Y));
		}
		System.out.println();
	}

}
