package Enumeration;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


import READ_TXT.Read_INPUT_TXT_filter;

public class step1_C extends Enumeration{


	private static int C;	

	public static void main( ) throws IOException {
		

		Read_INPUT_TXT_filter.loadData();

		C=Read_INPUT_TXT_filter.getP_NUMBER(d);
		
		int from[] = new int[select_Neighborhood_rule1.DP().get(d).size()];
		
			for(int i=0;i<select_Neighborhood_rule1.DP().get(d).size();i++)
				from[i]=select_Neighborhood_rule1.DP().get(d).get(i);
			
			
			int to[] = new int[from.length];
		 			
			FileWriter fX = null;
			BufferedWriter bX = null;
			
			try {
				fX = new FileWriter("matrix\\C.txt", false);
				bX = new BufferedWriter(fX);
				if(C<=from.length){
				for (int i = 1; i <= C; i++) {
					System.out.print(comb(from, to, i, from.length, i));
					bX.write(comb(from, to, i, from.length, i));
				}}
				else{
					for (int i = 1; i <= from.length; i++) {
					System.out.print(comb(from, to, i, from.length, i));
					bX.write(comb(from, to, i, from.length, i));}
				}
			} catch (IOException e) {
			} finally {
				try {
					bX.close();
				} catch (IOException e) {
				}
			}
		
	}

	public static String comb(int[] from, int[] to, int len, int m, int n) {
		String result = "";
		if (n == 0) {
			for (int i = 0; i < len; i++) {
				result += to[i];
				result += " ";
			}
			result += "\n";
		} else {
			to[n - 1] = from[m - 1];
			if (m > n - 1) {
				result = comb(from, to, len, m - 1, n - 1);
			}
			if (m > n) {
				result = comb(from, to, len, m - 1, n) + result;
			}
		}
		return result;
	}

}
