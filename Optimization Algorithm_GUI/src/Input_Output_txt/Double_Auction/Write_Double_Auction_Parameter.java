package Input_Output_txt.Double_Auction;

import java.io.FileWriter;
import java.io.IOException;

import GUI.I_Set_Paths_for_Current_Simulation_Example;

public class Write_Double_Auction_Parameter {
	
	public static void saveDouble_action_Parameter(String D,String D_N,String P,String P_N) throws IOException
	{
		 FileWriter fw2 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path()+"\\Generate_random\\double_action.txt",false);
			fw2.write(D+"\r\n");
			fw2.write(D_N+"\r\n");
			fw2.write(P+"\r\n");
			fw2.write(P_N+"\r\n");
			
			fw2.close();
	 }
	public static void saveDouble_action_Buyer_Parameter(String K,String Ktop,String M,String price) throws IOException
	{
		 FileWriter fw2 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path()+"\\Generate_random\\double_action_Buyer.txt",false);
		 fw2.write("物品種類="+K+"\r\n");
		 fw2.write("物品上限="+Ktop+"\r\n");
		 fw2.write("隨機挑選物品數量="+M+"\r\n");
		 fw2.write("底價價格="+price+"\r\n");
			fw2.close();
	 }
}
