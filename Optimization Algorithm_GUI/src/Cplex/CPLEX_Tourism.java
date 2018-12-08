package Cplex;

import java.io.IOException;

import Input_Output_txt.Tourism.Read_Objective_Weight;
import Input_Output_txt.Tourism.Read_Tourism;
 

public class CPLEX_Tourism {

		static double Omega_1,Omega_2;
		static double passenger_money[][];
		static double driver_money[][];
		public static String fileName, CfileName;
		public static String[] filename, Cfilename;
		public static int i, j;
		public static int N,Ia,Ih,It,K;
		public static void main( ) throws IOException {

								
								// 讀取txt檔案
								 
								 Read_Tourism.main();
								 N=Read_Tourism.N();
								Ia=Read_Tourism.Ia();
								Ih=Read_Tourism.Ih();
								It=Read_Tourism.It();
								K=Read_Tourism.K();
								 Read_Objective_Weight.main();
								Omega_1=Read_Objective_Weight.Omega_1();
								Omega_2=Read_Objective_Weight.Omega_2();
								 
								// CPLEX計算
								 Algorithm_Tourism.CPLEX_Algorithm();
				 
		}
	}