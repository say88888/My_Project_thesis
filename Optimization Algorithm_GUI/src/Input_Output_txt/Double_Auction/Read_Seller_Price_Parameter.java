package Input_Output_txt.Double_Auction;

import java.io.BufferedReader;
import java.io.FileReader;

import GUI.I_Set_Paths_for_Current_Simulation_Example;

public class Read_Seller_Price_Parameter {
	private static int top;  
	private static int bot;  
	private static String[][] Parameter = new String[2][3];
	public static void main( ) {
		// TODO Auto-generated method stub
		String str;
		int d = 0;
		try {
			FileReader PBr = new FileReader(
					I_Set_Paths_for_Current_Simulation_Example.path()
							+ "\\Double_Action\\Seller_price_Parameter.txt");
 
			BufferedReader br = new BufferedReader(PBr);
			while ((str = br.readLine()) != null) { // 每次讀一行
				Parameter[d++] = str.split("=| "); // 將此行以空白(white space)切成字串陣列,
													// 存入 Vector暫存
			}
			br.close(); // 關檔
		} catch (Exception e) {
			e.printStackTrace();
		}
		 

		top = Integer.parseInt(Parameter[0][1]);
		bot = Integer.parseInt(Parameter[1][1]);
		 
	}
	public static int top() {
		return top;
	}
	public static int bot() {
		return bot;
	}
}
