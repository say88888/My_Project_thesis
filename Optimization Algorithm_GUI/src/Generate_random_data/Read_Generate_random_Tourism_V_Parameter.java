package Generate_random_data;

import java.io.BufferedReader;
import java.io.FileReader;

import GUI.I_Set_Paths_for_Current_Simulation_Example;

public class Read_Generate_random_Tourism_V_Parameter {
	private static int Vaik_bot; 
	private static int Vaik_top; 
	private static int Vhim_bot;  
	private static int Vhim_top; 
	private static int Vtit_bot;  
	private static int Vtit_top; 
	
	private static String[][] Parameter = new String[6][3];
	public static void main( ) {
		// TODO Auto-generated method stub
		String str;
		int d = 0;
		try {
			FileReader PBr = new FileReader(
					I_Set_Paths_for_Current_Simulation_Example.path()
							+ "\\Generate_random\\V_Parameter");
 
			BufferedReader br = new BufferedReader(PBr);
			while ((str = br.readLine()) != null) { // 每次讀一行
				Parameter[d++] = str.split("=| "); // 將此行以空白(white space)切成字串陣列,
													// 存入 Vector暫存
			}
			br.close(); // 關檔
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
	 
		Vaik_bot=Integer.parseInt(Parameter[0][1]); 
		Vaik_top= Integer.parseInt(Parameter[0][2]);
		Vhim_bot=Integer.parseInt(Parameter[1][1]); 
		Vhim_top= Integer.parseInt(Parameter[1][2]);
		Vtit_bot=Integer.parseInt(Parameter[2][1]); 
		Vtit_top= Integer.parseInt(Parameter[2][2]);
	 
		 
	}
	public static int Vaik_bot() {
		return Vaik_bot;
	}
	public static int Vaik_top() {
		return Vaik_top;
	}
	public static int Vhim_bot() {
		return Vhim_bot;
	}
	public static int Vhim_top() {
		return Vhim_top;
	}
	public static int Vtit_bot() {
		return Vtit_bot;
	}
	public static int Vtit_top() {
		return Vtit_top;
	}
 
}

