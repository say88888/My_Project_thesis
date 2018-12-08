package Input_Output_txt.Carpool;

import java.io.FileWriter;
import java.io.IOException;

import GUI.I_Set_Paths_for_Current_Simulation_Example;

public class Write_filter_TransactionFee_Parameter {

	public static void savefilter(String filter,String detour_rate) throws IOException
	{
		 FileWriter fw2 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path()+"\\Generate_random\\filter_and_detour_rate",false);
			fw2.write("Passenger_filter="+filter+"\r\n");
			fw2.write("detour_rate="+detour_rate+"\r\n");
			
			fw2.close();
	 }
	public static void saveTransactionFee(String Alpha,String Delta,String Tdm,String Tpm,String Theta) throws IOException
	{
		 FileWriter fw2 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path()+"\\Carpool\\TransactionFee.txt",false);
			fw2.write("Alpha="+Alpha+"\r\n");
			fw2.write("Delta="+Delta+"\r\n");
			fw2.write("Tdm="+Tdm+"\r\n");
			fw2.write("Tdm="+Tpm+"\r\n");
			fw2.write("Theta="+Theta+"\r\n");
			fw2.close();
	 }
}
