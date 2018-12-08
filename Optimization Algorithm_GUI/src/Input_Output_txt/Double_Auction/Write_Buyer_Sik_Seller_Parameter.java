package Input_Output_txt.Double_Auction;

import java.io.FileWriter;
import java.io.IOException;

import GUI.I_Set_Paths_for_Current_Simulation_Example;

public class Write_Buyer_Sik_Seller_Parameter {

	public static void saveBuyerParameter(int price) throws IOException{

		 FileWriter fw2 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path()+"\\Double_Action\\Buyer_Parameter.txt");
			fw2.write("價格="+price+"\r\n");
			fw2.close();
	}
	public static void saveSellerParameter(int Q,int price,int R,int botprice,int topprice) throws IOException{

		 FileWriter fw2 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path()+"\\Double_Action\\Seller_Parameter_Buyer.txt");
			fw2.write("隨機挑取買方數量="+Q+"\r\n");
			fw2.write("買賣方價差="+price+"\r\n");
			fw2.write("重複標數="+R+"\r\n");
			fw2.write("重複價差="+botprice+" "+topprice+"\r\n");
			fw2.close();
	}
	public static void saveSikParameter(int top,int bot) throws IOException{

		 FileWriter fw2 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path()+"\\Double_Action\\Sik_Parameter.txt");
			fw2.write("上限="+top+"\r\n");
			fw2.write("下限="+bot+"\r\n");
			fw2.close();
	}
	public static void saveSellerPriceParameter(int top,int bot) throws IOException{

		 FileWriter fw2 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path()+"\\Double_Action\\Seller_price_Parameter.txt");
			fw2.write("上限="+top+"\r\n");
			fw2.write("下限="+bot+"\r\n");
			fw2.close();
	}
}
