package Input_Output_txt.Double_Auction;

import java.io.FileWriter;
import java.io.IOException;

import GUI.I_Set_Paths_for_Current_Simulation_Example;

public class Write_Set_intput_CATS_Parameter {

	public static void save_Single_Buyer_Parameter(String d,int goods,int bids) throws IOException{

		 FileWriter fw2 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path()+"\\CATS_Auction\\Single_Auction\\Set_intput_CATS_Buyer_Parameter.txt");
			fw2.write("設定參數-d對應的值="+d+"\r\n");
			fw2.write("設定參數-goods的值="+goods+"\r\n");
			fw2.write("設定-bids參數對應的值="+bids+"\r\n");
			fw2.close();
	}
	
	public static void save_Double_Buyer_Parameter(String d,int goods,int bids) throws IOException{

		 FileWriter fw2 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path()+"\\CATS_Auction\\Double_Auction\\Set_intput_CATS_Buyer_Parameter.txt");
			fw2.write("設定參數-d對應的值="+d+"\r\n");
			fw2.write("設定參數-goods的值="+goods+"\r\n");
			fw2.write("設定-bids參數對應的值="+bids+"\r\n");
			fw2.close();
	}
	
	public static void save_Double_Seller_Parameter(String d,int goods,int bids) throws IOException{

		 FileWriter fw2 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path()+"\\CATS_Auction\\Double_Auction\\Set_intput_CATS_Seller_Parameter.txt");
			fw2.write("設定參數-d對應的值="+d+"\r\n");
			fw2.write("設定參數-goods的值="+goods+"\r\n");
			fw2.write("設定-bids參數對應的值="+bids+"\r\n");
			fw2.close();
	}
}
