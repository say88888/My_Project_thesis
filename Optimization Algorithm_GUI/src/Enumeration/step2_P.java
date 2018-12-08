package Enumeration;


import java.io.FileWriter;

import Make_Carpool_data.make_step2_P_Bids;
import READ_TXT.READ_C;
import READ_TXT.Read_distance;
public class step2_P {
	private static int[][] C;

	private static int[] P1;
	private static int[][] PX;
	private static int[] PX_lengh;
	private static int[][] P;
	private static int z = 0;
	private static int C_high;
	private static int C_lengh;
	private static String[] CX;;
	private static String[] PX1;
	
	public static void permutation(int[] str, int first, int end,int[] str1) {
		// 输出str[first..end]的所有排列方式
		String result = "";
		if(end>2){
			for (int j = 0; j <= end/2; j++) 
				 result+=String.valueOf(str1[j]);
			}
			if(end==2){
				for (int j = 0; j < end; j++) 
					 result+=String.valueOf(str1[j]);
						}
		if (first == end) { // 输出一个排列方式
			for (int j = 0; j <= end; j++) {
				PX[z][j] = str[j];
			}
			CX[z]=result;
			PX_lengh[z]=end;
			z++;
			// System.out.println();
		}

		for (int i = first; i <= end; i++) {
			swap(str, i, first);
			permutation(str, first + 1, end,str1); // 固定好当前一位，继续排列后面的
			swap(str, i, first);
		}
	}

	private static void swap(int[] str, int i, int first) {
		int tmp;
		tmp = str[first];
		str[first] = str[i];
		str[i] = tmp;
	}

	public static void main( ) throws Exception {
		READ_C.READ_C();
		Read_distance.Read_distance();	
		C_high = READ_C.getC_high();
		C_lengh= READ_C.getC_length(C_high-1);
		int i, j, t = 1;
	z=0;
		C = new int[C_high][];
		for (i = 0; i < C_high; i++)
			C[i] = new int[READ_C.getC_length(i)];

		for (i = 0; i < C_high; i++) 
			for (j = 0; j < READ_C.getC_length(i); j++) 
				C[i][j] = READ_C.getC(i, j);
			
			

		P = new int[C_high][];

		for (i = 0; i < C_high; i++)
			P[i] = new int[C[i].length * 2];

		for (i = 0; i < C_high; i++) {
			for (j = 0; j < C[i].length; j++) {
				P[i][j] = C[i][j];
			}
		}

		for (i = 0; i < P.length; i++)
			for (j = C[i].length; j < P[i].length; j++) {
				P[i][j] = C[i][j - C[i].length] * (-1);
			}

		for (i = 0; i < P.length; i++) {
			for (j = 0; j < P[i].length; j++) {
				System.out.print(P[i][j] + " ");
			}
			System.out.println();
		}
		
		int sum = 0;
		for (i = 0; i < P.length; i++) {
			for (int p = 1; p < P[i].length; p++) {
				t += t * p;
			} sum=sum+t;
			t=1;
		}
		
 
		PX = new int[sum][C_lengh*2];
		PX_lengh=new int[sum];
		CX=new String[sum];
		PX1= new String[sum];
		
for (i = 0; i < P.length; i++) {
			P1 = new int[P[i].length];
			for (j = 0; j < P[i].length; j++) {
				P1[j] = P[i][j];
				 
			}    
		 permutation(P1, 0, (P[i].length-1 ),C[i]);
		}

		 //System.out.print(z); 
 		
		  FileWriter fw2 = new FileWriter("matrix\\P.txt"); 
		  for (i = 0; i < z; i++) {
			  String result = "";
			  for (j = 0; j <PX_lengh[i]; j++) {
				  fw2.write(String.valueOf(PX[i][j])+" ");
				  result+=String.valueOf(PX[i][j])+"_";
			  }
			  result+=String.valueOf(PX[i][j]);
			 PX1[i]=result;
			  fw2.write(String.valueOf(PX[i][j]));
			fw2.write("\r\n");
		  }
		  fw2.close();
		  
		 make_step2_P_Bids.make_data(CX,PX1,z,PX,PX_lengh); 
	}
	
	
	
	
	public static int getP_high() {
		return z;
	}

	public static int getP_lengh(int z) {
		return PX_lengh[z];
	}
	
	public static String getC_String(int i){
		return CX[i];
	}
	public static String getP_String(int i){
		return PX1[i];
	}

}
