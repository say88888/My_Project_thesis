package Input_Output_txt.Carpool;

import java.io.BufferedReader;
import java.io.FileReader;

import GUI.I_Set_Paths_for_Current_Simulation_Example;
import GUI.GUI_Carpool.X_Select_Algorithm_Type_to_Solve_the_Problem;

public class Read_Adaptive {
	private static int Adaptive_Mode_1;
	private static int Adaptive_Mode_2;
	private static double Mu; //μ
	private static double Sigma_max;	//σmax
	private static double Sigma_min;	//σmin
	private static double G;	//G
	private static String[][] Parameter = new String[6][3];
	public static void read_Adaptive( ) {
		
		String str;
		int d = 0;
		
		try {
			FileReader PBr = new FileReader(
					I_Set_Paths_for_Current_Simulation_Example.path()
							+ "\\PSO_Parameter"
							+ X_Select_Algorithm_Type_to_Solve_the_Problem
									.path() + "Adaptive.txt");
			BufferedReader br = new BufferedReader(PBr);
			while ((str = br.readLine()) != null) { // 每次讀一行
				Parameter[d++] = str.split("=| "); // 將此行以空白(white space)切成字串陣列,
													// 存入 Vector暫存
			}
			br.close(); // 關檔
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
		Adaptive_Mode_1 = Integer.parseInt(Parameter[0][1]);
		Adaptive_Mode_2 = Integer.parseInt(Parameter[1][1]);
		Mu = Double.parseDouble(Parameter[2][1]);

		Sigma_max = Double.parseDouble(Parameter[3][1]);
		Sigma_min= Double.parseDouble(Parameter[4][1]);
		G = Double.parseDouble(Parameter[5][1]);
	}
	public static int Adaptive_Mode_1() {
		return Adaptive_Mode_1;
	}
	public static int Adaptive_Mode_2() {
		return Adaptive_Mode_2;
	}
	public static double Mu() {
		return Mu;
	}
	public static double Sigma_max() {
		return Sigma_max;
	}
	public static double Sigma_min() {
		return Sigma_min;
	}
	public static double G() {
		return G;
	}

}
