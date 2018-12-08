package Input_Output_txt.Tourism;

import java.io.FileWriter;
import java.io.IOException;

import GUI.I_Set_Paths_for_Current_Simulation_Example;

public class Write_Tourism_Parameter {

	public static void saveTourism_Parameter(String N,String buyer_bot_price,String Ia,String K,String K_top,String Ih,String M,String M_top,String It,String T,String T_top) throws IOException
	{
		 FileWriter fw2 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path()+"\\Generate_random\\Tourism",false);
			fw2.write("買方數量="+N+"\r\n");
			fw2.write("買方底價價格="+buyer_bot_price+"\r\n");
			fw2.write("旅行社業者數量="+Ia+"\r\n");
			fw2.write("景點數量="+K+"\r\n");
			fw2.write("景點人數上限="+K_top+"\r\n");
			fw2.write("旅館業者數量="+Ih+"\r\n");
			fw2.write("旅館數量="+M+"\r\n");
			fw2.write("旅館可容上限="+M_top+"\r\n");
			fw2.write("運輸業者數量="+It+"\r\n");
			fw2.write("運輸數量="+T+"\r\n");
			fw2.write("運輸可容上限="+T_top+"\r\n");
			
			fw2.close();
	 }
	public static void saveTourism_V_Parameter(String Vaik_bot,String Vaik_top,String Vhim_bot,String Vhim_top,String Vtit_bot,String Vtit_top) throws IOException
	{
		 FileWriter fw2 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path()+"\\Generate_random\\V_Parameter",false);
			fw2.write("Vaik="+Vaik_bot+" "+Vaik_top+"\r\n");
			fw2.write("Vhim="+Vhim_bot+" "+Vhim_top+"\r\n");
			fw2.write("Vtit="+Vtit_bot+" "+Vtit_top+"\r\n");

			
			fw2.close();
	 }
}
