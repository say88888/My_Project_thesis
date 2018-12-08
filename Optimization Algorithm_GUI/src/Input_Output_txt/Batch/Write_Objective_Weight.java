package Input_Output_txt.Batch;

import java.io.FileWriter;
import java.io.IOException;

import GUI.I_Set_Paths_for_Current_Simulation_Example;

public class Write_Objective_Weight {
	public static void saveObjective_Weight(double Omega_1,double Omega_2,double Omega_3,double Omega_4
			,double Omega_5,double Omega_6,double Omega_7,double Omega_8) throws IOException{

		 FileWriter fw2 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path()
					+ "\\Objective_Weight.txt");
			fw2.write("Omega_1="+Omega_1+"\r\n");
			fw2.write("Omega_2="+Omega_2+"\r\n");
			fw2.write("Omega_3="+Omega_3+"\r\n");
			fw2.write("Omega_4="+Omega_4+"\r\n");
			fw2.write("Omega_5="+Omega_5+"\r\n");
			fw2.write("Omega_6="+Omega_6+"\r\n");
			fw2.write("Omega_7="+Omega_7+"\r\n");
			fw2.write("Omega_8="+Omega_8+"\r\n");
			fw2.close();
	}
	public static void saveObjective_Weight_Tourism(double Omega_1,double Omega_2) throws IOException{

		 FileWriter fw2 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path()
					+ "\\Tourism\\Objective_Weight.txt");
			fw2.write("Omega_1="+Omega_1+"\r\n");
			fw2.write("Omega_2="+Omega_2+"\r\n");
			
			fw2.close();
	}
}
