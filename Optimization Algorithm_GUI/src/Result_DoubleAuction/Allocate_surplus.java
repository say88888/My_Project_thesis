package Result_DoubleAuction;

import java.io.IOException;
import java.util.ArrayList;

import Input_Output_txt.Double_Auction.Read_Double_Auction;
import Input_Output_txt.Double_Auction.Read_TransactionFee;
import Input_Output_txt.Double_Auction.Read_XY;
import Make_Excel.Double_Auction.Output_Excel_Result;

public class Allocate_surplus {
	private static ArrayList<Double> N_surplusI = new ArrayList<Double>();
	private static ArrayList<Double> I_surplusI = new ArrayList<Double>();

	private static ArrayList<Double> N_surplusII = new ArrayList<Double>();
	private static ArrayList<Double> I_surplusII = new ArrayList<Double>();

	private static double Alpha;
	public static void main() {
		// TODO Auto-generated method stub
		Read_XY.main();
		Read_TransactionFee.main();
		Alpha=Read_TransactionFee.Alpha();
		try {
			Read_Double_Auction.main();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int[][] X = new int[Read_Double_Auction.getI()][];
		for (int i = 0; i < X.length; i++)
			X[i] = new int[Read_Double_Auction.getJ(i)];
		int[][] Y = new int[Read_Double_Auction.getN()][];
		for (int i = 0; i < Y.length; i++)
			Y[i] = new int[Read_Double_Auction.getH(i)];
		int a = 0;
		for (int i = 0; i < X.length; i++)
			for (int j = 0; j < X[i].length; j++)
				X[i][j] = Integer.parseInt(Read_XY.X().get(a++));
		a = 0;
		for (int i = 0; i < Y.length; i++)
			for (int j = 0; j < Y[i].length; j++)
				Y[i][j] = Integer.parseInt(Read_XY.Y().get(a++));
		
		Scheme_I(X, Y);
		Scheme_II(X, Y);
		a=0;
		boolean right=true;
		for (int i = 0; i < Y.length; i++)
			for (int j = 0; j < Y[i].length; j++)
				if(Y[i][j]==1){
					Output_Excel_Result.main(i+1, j+1, "Buyer", Read_Double_Auction.getPnh(i, j), N_surplusI.get(a), N_surplusII.get(a), right);
					a+=1;
					right=false;
				}
		a=0;
		for (int i = 0; i < X.length; i++)
			for (int j = 0; j < X[i].length; j++)
				if(X[i][j]==1){
					Output_Excel_Result.main(i+1, j+1, "Seller", Read_Double_Auction.getPij(i, j), I_surplusI.get(a), I_surplusII.get(a), right);
					a+=1;
				}
	}
	
	 
	public static void Scheme_I(int[][] X,int[][] Y)   {

		N_surplusI.clear();
		I_surplusI.clear();
		double Fittest = 0, Buycost = 0, Sellercost = 0;
		for (int i = 0; i < Read_Double_Auction.getN(); i++)
			for (int j = 0; j < Read_Double_Auction.getH(i); j++) {
				Fittest += Y[i][j] * Read_Double_Auction.getPnh(i, j);
				Buycost += Y[i][j] * Read_Double_Auction.getPnh(i, j);
			}
		for (int i = 0; i < Read_Double_Auction.getI(); i++)
			for (int j = 0; j < Read_Double_Auction.getJ(i); j++) {
				Fittest -= X[i][j] * Read_Double_Auction.getPij(i, j);
				Sellercost += X[i][j] * Read_Double_Auction.getPij(i, j);
			}
		Fittest *= (1 - Alpha) / 2;
		for (int i = 0; i < Read_Double_Auction.getN(); i++)
			for (int j = 0; j < Read_Double_Auction.getH(i); j++) {
				if (Y[i][j] == 1)
					N_surplusI.add(Read_Double_Auction.getPnh(i, j) / Buycost
							* Fittest);
			}
		for (int i = 0; i < Read_Double_Auction.getI(); i++)
			for (int j = 0; j < Read_Double_Auction.getJ(i); j++) {
				if (X[i][j] == 1)
					I_surplusI.add(Read_Double_Auction.getPij(i, j)
							/ Sellercost * Fittest);
			}

	//	System.out.println(N_surplusI);
	//	System.out.println(I_surplusI);
	}

	public static void Scheme_II(int[][] X,int[][] Y){

		N_surplusII.clear();
		I_surplusII.clear();

		double Fittest = 0, Buycost = 0, Sellercost = 0;
		for (int i = 0; i < Read_Double_Auction.getN(); i++)
			for (int j = 0; j < Read_Double_Auction.getH(i); j++) {
				Fittest += Y[i][j] * Read_Double_Auction.getPnh(i, j);
				Buycost += Y[i][j] * Read_Double_Auction.getPnh(i, j);
			}
		for (int i = 0; i < Read_Double_Auction.getI(); i++)
			for (int j = 0; j < Read_Double_Auction.getJ(i); j++) {
				Fittest -= X[i][j] * Read_Double_Auction.getPij(i, j);
				Sellercost += X[i][j] * Read_Double_Auction.getPij(i, j);
			}
		Fittest *= (1 - Alpha);
		for (int i = 0; i < Read_Double_Auction.getN(); i++)
			for (int j = 0; j < Read_Double_Auction.getH(i); j++) {
				if (Y[i][j] == 1)
					N_surplusII.add(Read_Double_Auction.getPnh(i, j) / (Buycost+Sellercost)* Fittest);
			}
		for (int i = 0; i < Read_Double_Auction.getI(); i++)
			for (int j = 0; j < Read_Double_Auction.getJ(i); j++) {
				if (X[i][j] == 1)
					I_surplusII.add(Read_Double_Auction.getPij(i, j) / (Buycost+Sellercost) * Fittest);
			}

	//	System.out.println(N_surplusII);
	//	System.out.println(I_surplusII);
	}
	
	
}
