package Input_Output_txt.Double_Auction;

import java.io.BufferedReader;
import java.io.FileReader;

import GUI.I_Set_Paths_for_Current_Simulation_Example;

public class Read_Seller_Parameter_Buyer{
	private static int Q;
	private static int price;  
	private static int R;
	private static int botprice;
	private static int topprice;
	private static String[][] Parameter = new String[4][3];
	public static void main( ) {
		// TODO Auto-generated method stub
		String str;
		int d = 0;
		try {
			FileReader PBr = new FileReader(
					I_Set_Paths_for_Current_Simulation_Example.path()
							+ "\\Double_Action\\Seller_Parameter_Buyer.txt");
			
			BufferedReader br = new BufferedReader(PBr);
			while ((str = br.readLine()) != null) { // 每次讀一行
				Parameter[d++] = str.split("=| "); // 將此行以空白(white space)切成字串陣列,
													// 存入 Vector暫存
			}
			br.close(); // 關檔
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
		Q = Integer.parseInt(Parameter[0][1]);
		price = Integer.parseInt(Parameter[1][1]);
		R = Integer.parseInt(Parameter[2][1]);
		botprice = Integer.parseInt(Parameter[3][1]);
		topprice = Integer.parseInt(Parameter[3][2]);
	}
	public static int Q() {
		return Q;
	}
	public static int price() {
		return price;
	}
	public static int R() {
		return R;
	}
	public static int botprice() {
		return botprice;
	}
	public static int topprice() {
		return topprice;
	}
}
