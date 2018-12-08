package Input_Output_txt.Double_Auction;

import java.io.BufferedReader;
import java.io.FileReader;

import GUI.I_Set_Paths_for_Current_Simulation_Example;
import GUI.GUI_Double_Auction.X_Select_Algorithm_Type_to_Solve_the_Problem;

public class Read_Omega {
	
	private static double Omega_1; //Ω1
	private static double Omega_2;	//Ω2
	private static double Omega_3; //Ω3
	private static double Omega_4;	//Ω4
	
	private static String[][] Parameter = new String[4][3];
	public static void main( ) {
		// TODO Auto-generated method stub
		String str;
		int d = 0;
		
		try {
			FileReader PBr = new FileReader(I_Set_Paths_for_Current_Simulation_Example.path()+"\\Double_Action\\Omega_For_Objective.txt");
			BufferedReader br = new BufferedReader(PBr);
			while ((str = br.readLine()) != null) { // 每次讀一行
				Parameter[d++] = str.split("=| "); // 將此行以空白(white space)切成字串陣列,
													// 存入 Vector暫存
			}
			br.close(); // 關檔
		} catch (Exception e) {
			e.printStackTrace();
		}
		 

		Omega_1 = Double.parseDouble(Parameter[0][1]);
		Omega_2 = Double.parseDouble(Parameter[1][1]);
		Omega_3= Double.parseDouble(Parameter[2][1]);
		Omega_4 = Double.parseDouble(Parameter[3][1]);
		
		
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
	
}
