package Cplex;

import java.io.IOException;

import Input_Output_txt.Double_Auction.Read_Double_Auction;


public class CPLEX_Vector_DA {

		public static int N;
		public static int I;
		public static int K;
	 
		static double passenger_money[][];
		static double driver_money[][];
		public static String fileName, CfileName;
		public static String[] filename, Cfilename;
		public static int i, j;

		public static void main( ) throws IOException {

								
								// 讀取txt檔案
								 
								Read_Double_Auction.main();
								N = Read_Double_Auction.getN();
								I = Read_Double_Auction.getI();
								K = Read_Double_Auction.getK();
								 
								// CPLEX計算
								Algorithm_Vector_DA.CPLEX_Algorithm();
				 
		}
	}