package Generate_random_data;

import java.io.BufferedReader;
import java.io.FileReader;

import GUI.I_Set_Paths_for_Current_Simulation_Example;

public class Read_Generate_random_Tourism {
	private static int N; 
	private static double buyer_bot_price;  
	private static int Ia; 
	private static int K;  
	private static int K_top; 
	private static int Ih;  
	private static int M;  
	private static int M_top; 
	private static int It;  
	private static int T;  
	private static int T_top;  
	private static String[][] Parameter = new String[11][3];
	public static void main( ) {
		// TODO Auto-generated method stub
		String str;
		int d = 0;
		try {
			FileReader PBr = new FileReader(
					I_Set_Paths_for_Current_Simulation_Example.path()
							+ "\\Generate_random\\Tourism");
 
			BufferedReader br = new BufferedReader(PBr);
			while ((str = br.readLine()) != null) { // 每次讀一行
				Parameter[d++] = str.split("=| "); // 將此行以空白(white space)切成字串陣列,
													// 存入 Vector暫存
			}
			br.close(); // 關檔
		} catch (Exception e) {
			e.printStackTrace();
		}
		 

		N=Integer.parseInt(Parameter[0][1]); 
		buyer_bot_price  = Double.parseDouble(Parameter[1][1]);
		Ia= Integer.parseInt(Parameter[2][1]);
		K  = Integer.parseInt(Parameter[3][1]);
		K_top = Integer.parseInt(Parameter[4][1]);
		Ih= Integer.parseInt(Parameter[5][1]);
		M = Integer.parseInt(Parameter[6][1]);
		M_top = Integer.parseInt(Parameter[7][1]);
		It= Integer.parseInt(Parameter[8][1]);
		T  = Integer.parseInt(Parameter[9][1]);
		T_top  = Integer.parseInt(Parameter[10][1]);
	 
		 
	}
	public static int N() {
		return N;
	}
	public static double buyer_bot_price(){
		return buyer_bot_price;
	}
	public static int Ia() {
		return Ia;
	}
	public static int K() {
		return K;
	}
	public static int K_top() {
		return K_top;
	}
	public static int Ih() {
		return Ih;
	}
	public static int M() {
		return M;
	}
	public static int M_top() {
		return M_top;
	}
	public static int It() {
		return It;
	}
	public static int T() {
		return T;
	}
	public static int T_top() {
		return T_top;
	}
}
