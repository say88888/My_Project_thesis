package Algorithm_Carpool.DMSDL_PSO2_AB_NNH;

import java.util.ArrayList;
import java.util.List;

import READ_TXT.Read_INPUT_TXT_filter;
import READ_TXT.Read_distance;

public class Convert_Function extends DMSDL_PSO2_AB_NNH {

	private static int[] rid=new int[P];
	private static double[] Si=new double[P];
	private static int[] A=new int[P];
	private static int[] B=new int[2*P];
	private static int[] Si_p = new int[P];
	
	private static int[] binaryX=new int[D];
	private static int[] binaryY=new int[P];
	
	private static int[][] X;
	private static int[][] Y;
	
	public static void main(double[] X,double[] Y){
		rid=new int[P];
		Si=new double[P];
		A=new int[P];
		B=new int[2*P];
		Si_p = new int[P];
		binaryX=new int[D];
		binaryY=new int[P];
		int number;
		
		for(int d=0;d<P;d++){
			if(Md.get(d).size()>0){
				number=(int) Math.round(((Md.get(d).size()-1)*(X[d]+Vmax))/(2*Vmax)+1);
				rid[d]=number;
			}
			else 
			{
				rid[d]=0;
			}
		}
		
		for(int d=0;d<Y.length;d++)
			Si[d]=Y[d];
		
		Si_p=sortSi(Si);
		
		A=Get_A(rid);
		B=Get_B(A,Si_p);
		getbinaryXY();
	}
	
	public static int[] Get_A(int[] rid) {
		// TODO Auto-generated method stub
		int[] A=new int[P];
		for (int i = 0; i < P; i++)
		if(rid[i]!=0){
			A[i]=Md.get(i).get(rid[i]-1);
			}else{A[i]=0;}
		
		return A;
	}
	
	public static int[] Get_B(int[]A ,int[] Si) {
		
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

	
	static int[] Get_binaryX(int[] A) {
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
	
	static int[] Get_binaryY(int[] A) {
		
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
	
	static int[] sortSi(double[] Si) 
	{
		int[] Si_p=new int[P];
		for(int i=0;i<P;i++)
			Si_p[i]=i+1;
		
	//	System.out.println();
	//	System.out.print("排序前 Si[i] = ");
	//	for(int i=0;i<P;i++)
	//		System.out.print(Si[i]+" ");
		
		for(int i=0;i<P-1;i++)
			for(int j=0;j<P-1;j++)
			{
				if(Si[j]<Si[j+1]){
					double temp;
					temp=Si[j];
					Si[j]=Si[j+1];
					Si[j+1]=temp;
					int temp1;
					temp1=Si_p[j];
					Si_p[j]=Si_p[j+1];
					Si_p[j+1]=temp1;
				}
			}
		
	//	System.out.println();
	//	System.out.print("排序後 Si[i] = ");
	//	for(int i=0;i<P;i++)
	//		System.out.print(Si[i]+" ");
		
	//	System.out.println();
	//	System.out.print("乘客順序 Si_p[i] = ");
	//	for(int i=0;i<P;i++)
	//		System.out.print(Si_p[i]+" ");
		
		return Si_p;
	}
	
	static void getbinaryXY() 
	{
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
		
		Y = new int[P][];
		for (int i = 0; i < Y.length; i++)
			Y[i] = new int[1];
		for (int p = 0; p < Y.length; p++)
			for (int h = 0; h < Y[p].length; h++) {
				for (int d = 0; d < D; d++)
					Y[p][h] += Adp[d][p];
			}

		X = new int[D][];
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
		
		for (int d = 0; d < X.length; d++)
			for (int j = 0; j < X[d].length; j++) 
				binaryX[d]=X[d][j];
		for (int p = 0; p < Y.length; p++)
			for (int h = 0; h < Y[p].length; h++)
				binaryY[p]=Y[p][h];
	}
		
	public static int getrid(int index) {
		return rid[index];
	}
	public static double getSi(int index) {
		return Si[index];
	}
	public static int getA(int index) {
		return A[index];
	}
	public static int getB(int index) {
		return B[index];
	}
	public static int getbinaryX(int index) {
		return binaryX[index];
	}
	public static int getbinaryY(int index) {
		return binaryY[index];
	}
	
}
