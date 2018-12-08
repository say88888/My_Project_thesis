package Input_Output_txt.Double_Auction;

import java.io.FileWriter;
import java.io.IOException;

import GUI.I_Set_Paths_for_Current_Simulation_Example;

public class Write_Data_Generation_Mode {
	public static void saveGeneration_Mode(String mode) throws IOException {

		FileWriter fw2 = new FileWriter(	I_Set_Paths_for_Current_Simulation_Example.path()	+ "\\Generate_random\\Data_Generation_Mode");
		fw2.write(mode+ "\r\n");
		fw2.close();
	}
}
