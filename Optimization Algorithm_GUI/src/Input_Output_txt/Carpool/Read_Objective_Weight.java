package Input_Output_txt.Carpool;

import java.io.BufferedReader;
import java.io.FileReader;

import GUI.I_Set_Paths_for_Current_Simulation_Example;
import GUI.GUI_Carpool.X_Select_Algorithm_Type_to_Solve_the_Problem;

public class Read_Objective_Weight {
	
	private static double Omega_1; //Ω1
	private static double Omega_2;	//Ω2
	private static double Omega_3; //Ω3
	private static double Omega_4;	//Ω4
	private static double Omega_5; //Ω5
	private static double Omega_6;	//Ω6
	private static double Omega_7; //Ω7
	private static double Omega_8;	//Ω8
	private static double Omega_9;	//Ω9
	private static double Omega_10;	//Ω10
	private static String[][] Parameter = new String[10][3];
	
	private static double wp;
	private static double wd;
	
	private static double wp1;
	private static double wd1;
	
	private static double Epsilon1;
	private static double Epsilon2;
	private static double Epsilon3;
	private static double Epsilon4;
	public static void main( ) {
		// TODO Auto-generated method stub
		String str;
		int d = 0;
		
		try {
			FileReader PBr = new FileReader(
					I_Set_Paths_for_Current_Simulation_Example.path()
							+ "\\Carpool\\Objective_Weight.txt");
			BufferedReader br = new BufferedReader(PBr);
			while ((str = br.readLine()) != null) { // 每次讀一行
				Parameter[d++] = str.split("=| |,"); // 將此行以空白(white space)切成字串陣列,
													// 存入 Vector暫存
			}
			br.close(); // 關檔
		} catch (Exception e) {
			e.printStackTrace();
		}
		 

		Omega_1 = Double.parseDouble(Parameter[0][1]);
		Omega_2 = Double.parseDouble(Parameter[1][1]);
		Omega_3 = Double.parseDouble(Parameter[2][1]);
		Omega_4 = Double.parseDouble(Parameter[3][1]);
		Omega_5 = Double.parseDouble(Parameter[4][1]);
		Omega_6 = Double.parseDouble(Parameter[5][1]);
		Omega_7 = Double.parseDouble(Parameter[6][1]);
		Omega_8 = Double.parseDouble(Parameter[7][1]);
		Omega_9 = Double.parseDouble(Parameter[8][1]);
		Omega_10 = Double.parseDouble(Parameter[9][1]);
		
		
		wp=Double.parseDouble(Parameter[3][3]);
		wd=Double.parseDouble(Parameter[3][5]);
		Epsilon1=Double.parseDouble(Parameter[3][7]);
		Epsilon2=Double.parseDouble(Parameter[3][9]);
		
		wp1=Double.parseDouble(Parameter[6][3]);
		wd1=Double.parseDouble(Parameter[6][5]);
		Epsilon3=Double.parseDouble(Parameter[6][7]);
		Epsilon4=Double.parseDouble(Parameter[6][9]);
	}

	public static double Omega_1() {
		return Omega_1;
	}
	public static double Omega_2() {
		return Omega_2;
	}
	public static double Omega_3() {
		return Omega_3;
	}
	public static double Omega_4() {
		return Omega_4;
	}
	public static double Omega_5() {
		return Omega_5;
	}
	public static double Omega_6() {
		return Omega_6;
	}
	public static double Omega_7() {
		return Omega_7;
	}
	public static double Omega_8() {
		return Omega_8;
	}
	public static double Omega_9() {
		return Omega_9;
	}
	public static double Omega_10() {
		return Omega_10;
	}
	public static double Epsilon1() {
		return Epsilon1;
	}
	public static double Epsilon2() {
		return Epsilon2;
	}
	public static double Epsilon3() {
		return Epsilon3;
	}
	public static double Epsilon4() {
		return Epsilon4;
	}
	
	public static double wp() {
		return wp;
	}
	public static double wp1() {
		return wp1;
	}
	public static double wd() {
		return wd;
	}
	public static double wd1() {
		return wd1;
	}
}
