package Input_Output_txt.Double_Auction;

import java.io.BufferedReader;
import java.io.FileReader;

import GUI.I_Set_Paths_for_Current_Simulation_Example;
import GUI.GUI_Double_Auction.X_Select_Algorithm_Type_to_Solve_the_Problem;

public class Read_Objective_Weight {
	
	private static double Omega_1; //Ω1
	private static double Omega_2;	//Ω2
	 
	private static String[][] Parameter = new String[2][3];
	public static void main( ) {
		// TODO Auto-generated method stub
		String str;
		int d = 0;
		
		try {
			FileReader PBr = new FileReader(
					I_Set_Paths_for_Current_Simulation_Example.path()
							+ "\\PSO_Parameter\\"+X_Select_Algorithm_Type_to_Solve_the_Problem.method()+"\\Objective_Weight.txt");
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
		 
		
		
	}

	public static double Omega_1() {
		return Omega_1;
	}
	public static double Omega_2() {
		return Omega_2;
	}
	 
	
}
