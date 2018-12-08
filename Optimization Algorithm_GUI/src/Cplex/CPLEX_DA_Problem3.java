package Cplex;

import java.io.IOException;

import Input_Output_txt.Double_Auction.Read_Double_Auction_Problem3;
import Input_Output_txt.Double_Auction.Read_Seller_Price_Parameter;
 

public class CPLEX_DA_Problem3 {

		public static int N;
		public static int I;
		public static int K;
	 
		static double passenger_money[][];
		static double driver_money[][];
		public static String fileName, CfileName;
		public static String[] filename, Cfilename;
	

		public static void main( ) throws IOException {

								
								// 讀取txt檔案
								 
								Read_Double_Auction_Problem3.main();
								Read_Seller_Price_Parameter.main();
								N = Read_Double_Auction_Problem3.getN();
								I = Read_Double_Auction_Problem3.getI();
								K = Read_Double_Auction_Problem3.getK();

								
								// CPLEX計算
								 Algorithm_DA_Problem3.CPLEX_Algorithm();
				 
								 
		}
	}