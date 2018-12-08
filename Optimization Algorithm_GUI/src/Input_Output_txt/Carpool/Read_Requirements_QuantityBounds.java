package Input_Output_txt.Carpool;

import java.io.BufferedReader;
import java.io.FileReader;

import GUI.I_Set_Paths_for_Current_Simulation_Example;

public class Read_Requirements_QuantityBounds {
	private static int Requirements_Quantity_lower; //要求數量
	private static int Requirements_Quantity_higher; //要求數量
	
	private static String[][] Parameter = new String[1][3];
	public static void main( ) {
		// TODO Auto-generated method stub
		String str;
		int d = 0;
		try {
			FileReader PBr = new FileReader(
					I_Set_Paths_for_Current_Simulation_Example.path()
							+ "\\Generate_random\\Requirements_QuantityBounds.txt");
					 
			BufferedReader br = new BufferedReader(PBr);
			while ((str = br.readLine()) != null) { // 每次讀一行
				Parameter[d++] = str.split("=| "); // 將此行以空白(white space)切成字串陣列,
													// 存入 Vector暫存
			}
			br.close(); // 關檔
		} catch (Exception e) {
			e.printStackTrace();
		}
		Requirements_Quantity_lower=Integer.parseInt(Parameter[0][1]);
		Requirements_Quantity_higher=Integer.parseInt(Parameter[0][2]);
	//	System.out.println(Requirements_Quantity);
	}
	
	
	public static int Requirements_Quantity_lower() {
		return Requirements_Quantity_lower;
	}
	public static int Requirements_Quantity_higher() {
		return Requirements_Quantity_higher;
	}
}
