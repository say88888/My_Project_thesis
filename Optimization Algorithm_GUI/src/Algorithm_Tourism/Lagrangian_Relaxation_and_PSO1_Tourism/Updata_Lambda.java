package Algorithm_Tourism.Lagrangian_Relaxation_and_PSO1_Tourism;

 
 
import Input_Output_txt.Tourism.Read_Tourism;

 
public class Updata_Lambda extends LR_Tourism {
	public static void Updata_Lambda( int[][] X,int[][] Y)   {
			
		for (int k = 0; k < Read_Tourism.K(); k++) {
			if ((Lambda1[k] + Functions.a1(Xa,Xh,Xt, Y) * Functions.g1(k, Xa, Y)) >= 0)
				Lambda1[k] += Functions.a1(Xa,Xh,Xt, Y) * Functions.g1(k, Xa, Y);
			else
				Lambda1[k] = 0;
			 
			if ((Lambda2[k] + Functions.a2(Xa,Xh,Xt, Y) * Functions.g2(k, Xa, Y)) >= 0)
				Lambda2[k] += Functions.a2(Xa,Xh,Xt, Y) * Functions.g2(k, Xa, Y);
			else
				Lambda2[k] = 0;
			
			if ((Lambda3[k] + Functions.a3(Xa,Xh,Xt, Y) * Functions.g3(k, Xa, Y)) >= 0)
				Lambda3[k] += Functions.a3(Xa,Xh,Xt, Y) * Functions.g3(k, Xa, Y);
			else
				Lambda3[k] = 0;
		}

		if ((Lambda4+ Functions.a4(Xa,Xh,Xt, Y) * Functions.g4( Xa,Xh,Xt, Y)) >= 0)
			Lambda4 += Functions.a4(Xa,Xh,Xt, Y) * Functions.g4(Xa,Xh,Xt, Y);
		else
			Lambda4 = 0;
		 
		for(int i=0;i<Read_Tourism.Ia();i++)
			for(int k=0;k<Read_Tourism.K();k++)  {
				if ((Lambda5[i][k]+ Functions.a5(Xa,Xh,Xt, Y) * Functions.g5(i,k, Xa )) >= 0)
					Lambda5[i][k] += Functions.a5(Xa,Xh,Xt, Y) * Functions.g5(i,k, Xa );
				else
					Lambda5[i][k] = 0;
			}
		
		for(int i=0;i<Read_Tourism.Ih();i++)
			for(int k=0;k<Read_Tourism.M();k++)  {
				if ((Lambda6[i][k]+ Functions.a6(Xa,Xh,Xt, Y) * Functions.g6(i,k, Xh )) >= 0)
					Lambda6[i][k] += Functions.a6(Xa,Xh,Xt, Y) * Functions.g6(i,k, Xh );
				else
					Lambda6[i][k] = 0;
			}
		
		for(int i=0;i<Read_Tourism.It();i++)
			for(int k=0;k<Read_Tourism.T();k++)  {
				if ((Lambda7[i][k]+ Functions.a7(Xa,Xh,Xt, Y) * Functions.g7(i,k, Xt )) >= 0)
					Lambda7[i][k] += Functions.a7(Xa,Xh,Xt, Y) * Functions.g7(i,k, Xt );
				else
					Lambda7[i][k] = 0;
			}
	}
}
