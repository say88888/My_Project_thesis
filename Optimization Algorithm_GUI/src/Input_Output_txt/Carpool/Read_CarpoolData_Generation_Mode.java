package Input_Output_txt.Carpool;

import java.io.BufferedReader;
import java.io.FileReader;

import GUI.I_Set_Paths_for_Current_Simulation_Example;

public class Read_CarpoolData_Generation_Mode {
	private static String mode;  
	 
	private static String[][] Parameter = new String[1][3];
	public static void main( ) {
		// TODO Auto-generated method stub
		String str;
		int d = 0;
		try {
			FileReader PBr = new FileReader(
					I_Set_Paths_for_Current_Simulation_Example.path()
							+ "\\Generate_random\\CarpoolData_Generation_Mode");
			
			BufferedReader br = new BufferedReader(PBr);
			while ((str = br.readLine()) != null) { // 每次讀一行
				mode = str; // 將此行以空白(white space)切成字串陣列,
													// 存入 Vector暫存
			}
			br.close(); // 關檔
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	 
	
	}
	public static String mode() {
		return mode;
	}
}
