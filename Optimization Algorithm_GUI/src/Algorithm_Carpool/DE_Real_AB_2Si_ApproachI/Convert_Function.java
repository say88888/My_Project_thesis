package Algorithm_Carpool.DE_Real_AB_2Si_ApproachI;

import java.util.ArrayList;
import java.util.List;

public class Convert_Function extends DE_Real_AB_2Si_ApproachI {

	public static int[] Get_A(int[] rid) {
		// TODO Auto-generated method stub
		int[] A=new int[P];
		for (int i = 0; i < P; i++)
		if(rid[i]!=0){
			A[i]=Md.get(i).get(rid[i]-1);
			}else{A[i]=0;}
		
		return A;
	}
	
	public static int[] Get_B(int[] A,int[] Si) {
		
		List<List<Integer>> B = new ArrayList<List<Integer>>();
		for (int j = 1; j <= D; j++) {
			List<Integer> b = new ArrayList<Integer>();
			List<Integer> b1 = new ArrayList<Integer>();
			for (int i = 0; i < P; i++)
				if (A[i] == j)
					b.add(i+1);
	
				if(b.size()>0){
					for(int i=0;i<Si.length;i++) 
						for(int k=0;k<b.size();k++)
						{
							if(Si[i]==b.get(k) || Si[i]==-(b.get(k)))
							{
								b1.add(Si[i]);
							}
						}
				}
			B.add(b1);
		}
		
		List Bstring = new ArrayList<Integer>();
		for (int d = 0; d < B.size(); d++) 
			for (int n= 0; n < B.get(d).size(); n++)
				Bstring.add(B.get(d).get(n));
		
		int[] B1=new int[P*2];
		for (int i = 0; i < Bstring.size(); i++) 
			B1[i] = (int) Bstring.get(i);
	
		return B1;
	}

	
	public static int[] Get_binaryX(int[] A) {
		List<List<Integer>> Dlist = new ArrayList<List<Integer>>();
		int[][] Adp = new int[D][P];
		for (int d = 0; d < D; d++){
			List<Integer> list = new ArrayList<Integer>();
			for (int p = 0; p < P; p++) {
				if (A[p] == (d + 1)){
					Adp[d][p] = 1;
					list.add(p+1);
				}else
					Adp[d][p] = 0;
			}
			Dlist.add(list);
		}

		int [][]X = new int[D][];
		for (int i = 0; i < D; i++)
			X[i] = new int[1];
		for (int d = 0; d < X.length; d++) {
			for (int j = 0; j < X[d].length; j++) {
				int a = 0;
				for (int p = 0; p < P; p++)
					a += Adp[d][p];
				if (a >= 1)
					X[d][j] = 1;
				else
					X[d][j] = 0;
			}
		}
		
		int[] X1=new int[D]; 
		for (int d = 0; d < X.length; d++) 
			for (int j = 0; j < X[d].length; j++)
				X1[d]=X[d][j];
				
		return X1;
	}
	
	public static int[] Get_binaryY(int[] A) {
		
		List<List<Integer>> Dlist = new ArrayList<List<Integer>>();
		int[][] Adp = new int[D][P];
		for (int d = 0; d < D; d++){
			List<Integer> list = new ArrayList<Integer>();
			for (int p = 0; p < P; p++) {
				if (A[p] == (d + 1)){
					Adp[d][p] = 1;
					list.add(p+1);
				}else
					Adp[d][p] = 0;
			}
			Dlist.add(list);
		}
		
		int [][] Y = new int[P][];
		for (int i = 0; i < Y.length; i++)
			Y[i] = new int[1];
		for (int p = 0; p < Y.length; p++)
			for (int h = 0; h < Y[p].length; h++) {
				for (int d = 0; d < D; d++)
					Y[p][h] += Adp[d][p];
			}
		
		int[] Y1=new int[P]; 
		for (int p = 0; p < Y.length; p++)
			for (int h = 0; h < Y[p].length; h++)
				Y1[p]=Y[p][h];
		
		return Y1;
	}
}
