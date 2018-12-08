package Input_Output_txt.Carpool;

import java.io.FileWriter;
import java.io.IOException;

import GUI.I_Set_Paths_for_Current_Simulation_Example;

public class Write_Objective_Function_Parameters {
	
	public static void saveObjective_Omega(
			double Omega_1,double Omega_2,	double Omega_3,
			double Omega_4,double wp,double wd,double Epsilon1,double Epsilon2,
			double Omega_5,double Omega_6,
			double Omega_7,double wp1,double wd1,double Epsilon3,double Epsilon4,
			double Omega_8,
			double Omega_9,
			double Omega_10
			) throws IOException{

		 FileWriter fw2 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path()
					+ "\\Carpool\\Objective_Weight.txt");
			fw2.write("Omega_1="+Omega_1+"\r\n");
			fw2.write("Omega_2="+Omega_2+"\r\n");
			fw2.write("Omega_3="+Omega_3+"\r\n");
			fw2.write("Omega_4="+Omega_4+",司機cp值wp="+wp+",乘客cp值wd="+wd+",Epsilon1="+Epsilon1+",Epsilon2="+Epsilon2+"\r\n");
			fw2.write("Omega_5="+Omega_5+"\r\n");
			fw2.write("Omega_6="+Omega_6+"\r\n");
			fw2.write("Omega_7="+Omega_7+",司機cp值wp="+wp1+",乘客cp值wd="+wd1+",Epsilon3="+Epsilon3+",Epsilon4="+Epsilon4+"\r\n");
			fw2.write("Omega_8="+Omega_8+"\r\n");
			fw2.write("Omega_9="+Omega_9+"\r\n");
			fw2.write("Omega_10="+Omega_10+"\r\n");
			fw2.close();
			
			
	}
	
}
