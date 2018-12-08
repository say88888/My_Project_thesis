package Cplex;

import ilog.concert.IloNumVar;

import java.io.IOException;
import java.util.ArrayList;

import Algorithm_DoubleAuction.TS_DA.TS_DA;
import Input_Output_txt.Double_Auction.Read_Double_Auction;


public class CPLEX_DA_LP extends TS_DA{

		public static int N;
		public static int I;
		public static int K;
		static double passenger_money[][];
		static double driver_money[][];
		public static String fileName, CfileName,X="",Y="";
		public static String[] filename, Cfilename;
		public static int i, j;
	 
		public static void main( ) throws IOException {

								
								// 讀取txt檔案
								 
								Read_Double_Auction.main();
								N = Read_Double_Auction.getN();
								I = Read_Double_Auction.getI();
								K = Read_Double_Auction.getK();
							 
								// CPLEX計算LP
								System.out.println("CPLEX第一步驟  解Mj 不包括F(X,Y)");
								Algorithm_DA_LP.CPLEX_Algorithm();
								
								
								
		}
		
	}