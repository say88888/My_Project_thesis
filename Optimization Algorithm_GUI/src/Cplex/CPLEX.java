package Cplex;

import java.io.IOException;

import Input_Output_txt.Carpool.Read_BPL_TXT;
import Input_Output_txt.Carpool.Read_CarpoolData_Generation_Mode;
import Input_Output_txt.Carpool.Read_Objective_Weight;
import Input_Output_txt.Carpool.Read_file;

public class CPLEX {
	public static int P;
	public static int D;
	public static int K;
	public static double Omega_1;
	public static double Omega_2;
	public static double Omega_3;
	public static double Omega_4;
	public static double Omega_5;
	public static double Omega_6;
	public static double Omega_7;
	public static double Omega_8;
	static double passenger_money[][];
	static double driver_money[][];
	public static String fileName, CfileName;
	public static String[] filename, Cfilename;
	public static int i, j;

	public static void main( ) throws IOException {

							
							// 讀取txt檔案
							Read_file.loadData();
							Read_CarpoolData_Generation_Mode.main();
							if(Read_CarpoolData_Generation_Mode.mode().contains("multi_hop")){
								Read_BPL_TXT.main();
							}
							P = Read_file.getP();
							D = Read_file.getD();
							K = Read_file.getK();
							Read_Objective_Weight.main();
							Omega_1=Read_Objective_Weight.Omega_1();
							Omega_2=Read_Objective_Weight.Omega_2();
							Omega_3=Read_Objective_Weight.Omega_3();
							Omega_4=Read_Objective_Weight.Omega_4();
							Omega_5=Read_Objective_Weight.Omega_5();
							Omega_6=Read_Objective_Weight.Omega_6();
							Omega_7=Read_Objective_Weight.Omega_7();
							Omega_8=Read_Objective_Weight.Omega_8();
							// CPLEX計算
							Algorithm.CPLEX_Algorithm();
			 
	}
}