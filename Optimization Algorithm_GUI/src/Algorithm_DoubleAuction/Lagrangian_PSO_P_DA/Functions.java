package Algorithm_DoubleAuction.Lagrangian_PSO_P_DA;

import Input_Output_txt.Double_Auction.Read_Double_Auction;

 

public class Functions extends Double_Auction_ALPSO_P {

	public static double g1(int k, int[][] X, int[][] Y) {
		double fittest = 0;
		
		
		for(int n=0;n<N;n++)
			for(int h=0;h<Y[n].length;h++)
				fittest-=Y[n][h]*Read_Double_Auction.getdnhk(n, h, k);
		for(int i=0;i<I;i++)
			for(int j=0;j<X[i].length;j++)
				fittest+=X[i][j]*Read_Double_Auction.getqijk(i, j, k);
		return fittest;
	}

	public static double g2(int[][] X, int[][] Y) {
		double fittest = 0;
		
		for(int i=0;i<I;i++)
			for(int j=0;j<X[i].length;j++)
				fittest-=X[i][j]*Read_Double_Auction.getPij(i, j);
		for(int n=0;n<N;n++)
			for(int h=0;h<Y[n].length;h++)
				fittest+=Y[n][h]*Read_Double_Auction.getPnh(n, h);
		return fittest;
	}

	public static double g3(int i, int k, int[][] X, int[][] Y) {
		double fittest = 0;
		
		for (int j = 0; j < X[i].length; j++)
			fittest -= X[i][j] * Read_Double_Auction.getqijk(i, j, k);
		fittest+=Read_Double_Auction.getSik(i, k);
		return fittest;
	}

	 

	public static double Theta1(int k, int[][] X, int[][] Y) // Theta1=θ1  Lambda =λ1
	{
		return Math.min(g1(k,X,Y),(Lambda1[k]/(2*r1[k])));
	}
	public static double Theta2( int[][] X, int[][] Y ) // Theta2=θ2  Lambda =λ2
	{
		return Math.min(g2(X,Y),(Lambda2/(2*r2)));
	}
	public static double Theta3( int i,int k,int[][] X, int[][] Y ) // Theta3=θ3  Lambda =λ3
	{
		return  Math.min(g3(i,k,X,Y),(Lambda3[i][k]/(2*r3[i][k])));
	}
	 
}
