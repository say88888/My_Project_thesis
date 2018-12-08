package Cplex;

import java.io.IOException;

import Input_Output_txt.Double_Auction.Output_EXCEL;
import Input_Output_txt.Double_Auction.Read_Double_Auction;
import Input_Output_txt.Double_Auction.Read_Omega;

 


public class CPLEX_DA {

		public static int N;
		public static int I;
		public static int K;
	 
		static double passenger_money[][];
		static double driver_money[][];
		public static String fileName, CfileName;
		public static String[] filename, Cfilename;
		public static int i, j;
		public static double Omega1,Omega2,Omega3,Omega4;
		public static void main( ) throws IOException {

								
								// 讀取txt檔案
								 
								Read_Double_Auction.main();
								N = Read_Double_Auction.getN();
								I = Read_Double_Auction.getI();
								K = Read_Double_Auction.getK();
								Read_Omega.main();
								Omega1=Read_Omega.Omega_1();
								Omega2=Read_Omega.Omega_2();
								Omega3=Read_Omega.Omega_3();
								Omega4=Read_Omega.Omega_4();
								// CPLEX計算
								 Algorithm_DA.CPLEX_Algorithm();
				 
								 
		}
	}