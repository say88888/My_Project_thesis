package Algorithm_Carpool.Lagrangian_Relaxation_and_PSO2;

import Input_Output_txt.Carpool.Read_file;
 

public class Updata_Lambda extends LR{
	public static void Updata_Lambda(int[][] X,int[][] Y) {
		
		for (int k = 0; k < K; k++) {
			if ((Lambda1[k] + Functions.a1(X, Y) * Functions.g1(k, X, Y)) >= 0)
				Lambda1[k] += Functions.a1(X, Y) * Functions.g1(k, X, Y);
			else
				Lambda1[k] = 0;
		}
		
		if ((Lambda2 + Functions.a2(X, Y) * Functions.g2( X, Y)) >= 0)
			Lambda2 += Functions.a2(X, Y) * Functions.g2(X, Y);
		else
			Lambda2 = 0;
		
		for (int d = 0; d < D;d++)
			for (int j = 0; j < Read_file.getJd(d); j++) {
				if ((Lambda3[d][j]+ Functions.a3(X, Y) * Functions.g3(d,j, X, Y)) >= 0)
					Lambda3[d][j] += Functions.a3(X, Y) * Functions.g3(d,j, X, Y);
				else
					Lambda3[d][j] = 0;
				
				if ((Lambda4[d][j]+ Functions.a4(X, Y) * Functions.g4(d,j, X, Y)) >= 0)
					Lambda4[d][j] += Functions.a4(X, Y) * Functions.g4(d,j, X, Y);
				else
					Lambda4[d][j] = 0;
			}
		
	}
	 
}
