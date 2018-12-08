package Input_Output_txt.Double_Auction;

import java.io.FileWriter;
import java.io.IOException;

import GUI.I_Set_Paths_for_Current_Simulation_Example;

public class Write_TransactionFee {

	public static void saveTransactionFee(String Alpha) throws IOException
	{
		 FileWriter fw2 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path()+"\\Double_Action\\TransactionFee.txt",false);
			fw2.write("Alpha="+Alpha+"\r\n");
			
			fw2.close();
	 }
}
