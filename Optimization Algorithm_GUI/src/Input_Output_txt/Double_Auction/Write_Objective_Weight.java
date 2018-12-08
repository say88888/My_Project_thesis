package Input_Output_txt.Double_Auction;

import java.io.FileWriter;
import java.io.IOException;

import GUI.I_Set_Paths_for_Current_Simulation_Example;
import GUI.GUI_Double_Auction.X_Select_Algorithm_Type_to_Solve_the_Problem;

public class Write_Objective_Weight {
	public static void saveObjective_Weight(double Omega_1,double Omega_2 ) throws IOException{

		 FileWriter fw2 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path()
					+ "\\PSO_Parameter\\"+X_Select_Algorithm_Type_to_Solve_the_Problem.method()+
					"\\Objective_Weight.txt");
			fw2.write("Omega_1="+Omega_1+"\r\n");
			fw2.write("Omega_2="+Omega_2+"\r\n");
	
			fw2.close();
	}
	 
}
