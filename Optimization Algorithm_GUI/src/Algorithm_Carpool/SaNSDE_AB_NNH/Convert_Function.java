package Algorithm_Carpool.SaNSDE_AB_NNH;

import java.util.ArrayList;
import java.util.List;

import READ_TXT.Read_INPUT_TXT_filter;
import READ_TXT.Read_distance;

public class Convert_Function extends SaNSDE_AB_NNH {

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
			int[] si=new int[P];
			for (int i = 0; i < P; i++)
				if (A[i] == j)
					b.add(i+1);
	
				if(b.size()>0){
					int[] Si_p=new int[P];
					for(int i=0;i<P;i++) 
						for(int k=0;k<b.size();k++)
						{
							if(Si[i]==b.get(k))
							{
								Si_p[i]=b.get(k);
							}
						}
					for(int i=0;i<P;i++)
						if(Si_p[i]!=0)
						{b1.add(Si_p[i]);
						b1.add(-(Si_p[i]));
						}
				}
			B.add(b1);
		}
		
		int location1, location2, k;
		List Bstring = new ArrayList<Integer>();
		for (int d = 0; d < B.size(); d++) {
			double route = 99999999.0;
			int min = 0, i = 0;

			while (B.get(d).size() != 0) {
				int n = 0;
				if (i == 0)
					location1 = Integer.parseInt(Read_INPUT_TXT_filter	.getD_S_PLACE(d));
				else if (min > 0)
					location1 = Integer.parseInt(Read_INPUT_TXT_filter	.getP_R_PLACE(min - 1));
				else
					location1 = Integer.parseInt(Read_INPUT_TXT_filter	.getP_D_ADDRESS((-min) - 1));
				i++;
				for (int j = 0; j < B.get(d).size(); j++) {
					if (B.get(d).get(j) > 0) {
						k = B.get(d).get(j);
						location2 = Integer.parseInt(Read_INPUT_TXT_filter	.getP_R_PLACE(k - 1));
						if (Read_distance.getDistance(location1, location2) < route) {
							route = Read_distance.getDistance(location1,	location2);
							min = B.get(d).get(j);
							n = j;
						}
					} else if (B.get(d).get(j) < 0) {
						k = -(B.get(d).get(j));
						location2 = Integer.parseInt(Read_INPUT_TXT_filter	.getP_D_ADDRESS(k - 1));
						if (Read_distance.getDistance(location1, location2) < route) {
							route = Read_distance.getDistance(location1,	location2);
							min = B.get(d).get(j);
							n = j;
						}
					}
				}
				Bstring.add(B.get(d).get(n));
				B.get(d).remove(n);
			}
		}
		
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
