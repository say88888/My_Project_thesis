package Input_Output_txt.Double_Auction;

import java.io.BufferedReader;
import java.io.FileReader;

import GUI.I_Set_Paths_for_Current_Simulation_Example;

public class Read_Set_intput_CATS_Buyer_Parameter {
	private static String d_value;  
	private static int goods_value;  
	private static int bids_value;  
	
	private static String[][] Parameter = new String[3][2];
	
	private static String d_value1;  
	private static int goods_value1;  
	private static int bids_value1;  
	private static String[][] Parameter1 = new String[3][2];
	
	
	public static void Single_Auction() {
		// TODO Auto-generated method stub
		String str;
		int d = 0;
		try {
			FileReader PBr = new FileReader(
					I_Set_Paths_for_Current_Simulation_Example.path()
							+ "\\CATS_Auction\\Single_Auction\\Set_intput_CATS_Buyer_Parameter.txt");
 
			BufferedReader br = new BufferedReader(PBr);
			while ((str = br.readLine()) != null) { // 每次讀一行
				Parameter[d++] = str.split("=| "); // 將此行以空白(white space)切成字串陣列,
													// 存入 Vector暫存
			}
			br.close(); // 關檔
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
		d_value =Parameter[0][1];
		goods_value = Integer.parseInt(Parameter[1][1]);
		bids_value = Integer.parseInt(Parameter[2][1]);
	}
	
	
	public static void Double_Auction() {
		// TODO Auto-generated method stub
		String str;
		int d = 0;
		try {
			FileReader PBr = new FileReader(
					I_Set_Paths_for_Current_Simulation_Example.path()
							+ "\\CATS_Auction\\Double_Auction\\Set_intput_CATS_Buyer_Parameter.txt");
 
			BufferedReader br = new BufferedReader(PBr);
			while ((str = br.readLine()) != null) { // 每次讀一行
				Parameter1[d++] = str.split("=| "); // 將此行以空白(white space)切成字串陣列,
													// 存入 Vector暫存
			}
			br.close(); // 關檔
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
		d_value1 =Parameter1[0][1];
		goods_value1 = Integer.parseInt(Parameter1[1][1]);
		bids_value1 = Integer.parseInt(Parameter1[2][1]);
	}
	
	
	public static String d_value() {
		return d_value;
	}
	
	public static int goods_value() {
		return goods_value;
	}
	
	public static int bids_value() {
		return bids_value;
	}
	
	public static String d_value1() {
		return d_value1;
	}
	
	public static int goods_value1() {
		return goods_value1;
	}
	
	public static int bids_value1() {
		return bids_value1;
	}
}
