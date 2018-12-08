package Algorithm_DoubleAuction.Lagrangain_Relaxation_DA;

 
public class Updata_Lambda extends Double_Auction_LR {
	public static void Updata_Lambda( int[][] X,int[][] Y) {
			
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
		 
		for(int i=0;i<I;i++)
			for(int k=0;k<K;k++)  {
				if ((Lambda3[i][k]+ Functions.a3(X, Y) * Functions.g3(i,k, X, Y)) >= 0)
					Lambda3[i][k] += Functions.a3(X, Y) * Functions.g3(i,k, X, Y);
				else
					Lambda3[i][k] = 0;
			 
			}
		
	 
	}
}
