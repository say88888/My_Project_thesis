package Input_Output_txt.Carpool;

import java.io.FileWriter;
import java.io.IOException;

import GUI.I_Set_Paths_for_Current_Simulation_Example;

public class Write_Requirements_QuantityBoumds {

	public static void saveRequirements_Quantity(int Requirements_Quantity_lower,int Requirements_Quantity_higher)
			throws IOException {

		FileWriter fw2 = new FileWriter(
				I_Set_Paths_for_Current_Simulation_Example.path()
						+ "\\Generate_random\\Requirements_QuantityBounds.txt");
		fw2.write("同車共乘要求數量=" + Requirements_Quantity_lower + " "+Requirements_Quantity_higher+"\r\n");
		 

		fw2.close();
	}

}
