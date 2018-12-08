package Algorithm_DoubleAuction.Lagrangian_PSO_Tanh_DA;

public class Print_Lambda_g extends Double_Auction_ALPSO_Tanh {

	public static void main(int[][] X, int[][] Y) {

		// TODO Auto-generated method stub
		if (Print == 1) {
			System.out.println("");
			System.out.println("λ1");
			for (int k = 0; k < K; k++)
				System.out.println("k="+(k+1)+" λ1="+Lambda1[k]+" θ1="+Functions.Theta1(k, X, Y)+" g1="+Functions.g1(k, X, Y));
			System.out.println("λ2");
			System.out.println("λ2="+Lambda2+" θ2="+Functions.Theta2( X, Y)+" g2="+Functions.g2( X, Y));
			System.out.println("λ3");
			for (int i = 0; i < r3.length; i++)
				for (int k = 0; k < r3[i].length; k++)
					System.out.println( "i="+(i+1)+" k="+(k+1)+" λ3="+Lambda3[i][k]+" θ3="+Functions.Theta3(i,k, X, Y)+" g3="+Functions.g3(i,k, X, Y));
		}
		System.out.println();
	}

}
