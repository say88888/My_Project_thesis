package Algorithm_DoubleAuction;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Input_Output_txt.Double_Auction.Read_Double_Auction;
 
 
public class Function_Vector_DA {
	public static ArrayList<List<Integer>> A_Vector() throws IOException {
		Read_Double_Auction.main();
		ArrayList<List<Integer>> A = new ArrayList<List<Integer>>();
		
		for(int k=0;k<Read_Double_Auction.getK();k++){
			ArrayList<Integer> A2_2 = new ArrayList<Integer>();
			for(int i=0;i<Read_Double_Auction.getN();i++)
				for(int j=0;j<Read_Double_Auction.getH(i);j++)
					A2_2.add(-Read_Double_Auction.getdnhk(i, j, k));
			for(int i=0;i<Read_Double_Auction.getI();i++)
				for(int j=0;j<Read_Double_Auction.getJ(i);j++)
					A2_2.add(Read_Double_Auction.getqijk(i, j, k));
			A.add(A2_2);
		}
		 
		ArrayList<Integer> A2_3 = new ArrayList<Integer>();
		for(int i=0;i<Read_Double_Auction.getN();i++)
			for(int j=0;j<Read_Double_Auction.getH(i);j++)
				A2_3.add((int)Read_Double_Auction.getPnh(i, j));
		for(int i=0;i<Read_Double_Auction.getI();i++)
			for(int j=0;j<Read_Double_Auction.getJ(i);j++)
				A2_3.add((int)(-Read_Double_Auction.getPij(i, j)));
		A.add(A2_3);
		
		for(int i1=0;i1<Read_Double_Auction.getI();i1++)
			for(int k=0;k<Read_Double_Auction.getK();k++){
				ArrayList<Integer> A2_4 = new ArrayList<Integer>();
				for(int n=0;n<Read_Double_Auction.getN();n++)
					for(int h=0;h<Read_Double_Auction.getH(n);h++)
						A2_4.add(0);
				for(int i=0;i<Read_Double_Auction.getI();i++)
					for(int j=0;j<Read_Double_Auction.getJ(i);j++)
						if(i1==1)
							A2_4.add(-Read_Double_Auction.getqijk(i, j, k));
						else
							A2_4.add(0);
				A.add(A2_4);
			}
	/*	for (int i = 0; i < A.size(); i++) {
			for (int j = 0; j < A.get(i).size(); j++)
				System.out.print(A.get(i).get(j) + " ");
			System.out.println();
		}*/
		return A;
	}

	public static ArrayList<Integer> B_Vector() throws IOException {
		 
		ArrayList<Integer> B = new ArrayList<Integer>();
		
		Read_Double_Auction.main();
		for(int i=0;i<Read_Double_Auction.getK();i++)
			B.add(0);
		B.add(0);
		for(int i=0;i<Read_Double_Auction.getI();i++)
			for(int j=0;j<Read_Double_Auction.getK();j++)
				B.add(-Read_Double_Auction.getSik(i, j));
		
		return B;
	}

	public static ArrayList<Double> C_Vector( )
			throws IOException {
		 
		ArrayList<Double> C = new ArrayList<Double>();
		Read_Double_Auction.main();
		for (int i = 0; i < Read_Double_Auction.getN(); i++)
			for (int j = 0; j < Read_Double_Auction.getH(i); j++)
				C.add((Read_Double_Auction.getPnh(i, j) * (1 + Read_Double_Auction.getTbm())));
		for (int i = 0; i < Read_Double_Auction.getI(); i++)
			for (int j = 0; j < Read_Double_Auction.getJ(i); j++)
				C.add( (-(Read_Double_Auction.getPij(i, j) * (1 - Read_Double_Auction.getTsm()))));
		return C;
	}

	public static ArrayList<Integer> z_Vector(int[][] Y, int[][] X) throws IOException {

		 
		ArrayList<Integer> z = new ArrayList<Integer>();

		for (int i = 0; i < Y.length; i++)
			for (int j = 0; j < Y[i].length; j++)
				z.add(Y[i][j]);

		for (int i = 0; i < X.length; i++)
			for (int j = 0; j < X[i].length; j++)
				z.add(X[i][j]);

		
		return z;
	}

	public static ArrayList<Integer> R_Vector(int R1, int R2, int R3, int R4,
			int R5, int R6, int R7) throws IOException {

		 
		ArrayList<Integer> R = new ArrayList<Integer>();

		 
		return R;
	}
}
