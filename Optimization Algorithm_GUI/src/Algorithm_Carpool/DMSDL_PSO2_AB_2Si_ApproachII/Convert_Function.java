package Algorithm_Carpool.DMSDL_PSO2_AB_2Si_ApproachII;

import java.util.ArrayList;
import java.util.List;

public class Convert_Function extends DMSDL_PSO2_AB_2Si_ApproachII {

	private static int[] rid=new int[P];
	private static double[] Si=new double[P*2];
	private static int[] A=new int[P];
	private static int[] B=new int[2*P];
	private static int[] Si_p = new int[P*2];
	
	private static int[] binaryX=new int[D];
	private static int[] binaryY=new int[P];
	
	private static int[][] X;
	private static int[][] Y;
	
	public static void main(double[] X,double[] Y){
		rid=new int[P];
		Si=new double[P*2];
		A=new int[P];
		B=new int[2*P];
		Si_p = new int[P*2];
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
		
		//Step2  If the value of passenger location d+ is less than the value of passenger location d-, swap the values of passenger location d+ and the value of passenger location d-.
		for(int i=0;i<P;i++)
		{
			if(Si[i]<Si[i+P])
			{
				double temp;
				temp=Si[i];
				Si[i]=Si[i+P];
				Si[i+P]=temp;
			}
		}
		//Step3  If the value of passenger location d+ is less than the value of passenger location d-, swap the values of passenger location d+ and the value of passenger location d-.
		int[] Si_p=new int[P*2];
		for(int i=0;i<P;i++) {
			Si_p[i]=i+1;
			Si_p[i+P]=-(i+1);
		}
		
		for(int i=0;i<(P*2)-1;i++)
			for(int j=0;j<(P*2)-1;j++)
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
