package Input_Output_txt.Carpool;

import java.io.FileWriter;
import java.io.IOException;

import GUI.I_Set_Paths_for_Current_Simulation_Example;


public class Write_Driver_Passenger_data {
	public static void savedriver_data(String D,String D1,String D2,String DT1,String DT2,String DT3,String DT4,String DR1,String DR2,String DR3,String DR4,String DR5) throws IOException
	{
		 FileWriter fw2 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path()+"\\Generate_random\\driver_data",false);
			fw2.write(D+"\r\n");
			fw2.write(D1+","+D2+"\r\n");
			fw2.write(DT1+","+DT2+","+DT3+","+DT4+"\r\n");
			fw2.write(DR3+"\r\n");
			fw2.write(DR4+"\r\n");
			fw2.close();
			
		FileWriter fw1 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path()+"\\Generate_random\\DriverOilConsumptionBounds",false);
				fw1.write("DriverOilConsumption_Upper="+DR1+"\r\n");
				fw1.write("DriverOilConsumption_Lower="+DR2+"\r\n");
				fw1.write("Driver_OilPrice="+DR5+"\r\n");
				fw1.close();
			
	 }
	public static void savepassenger_data(String P,String PT1,String PT2,String PT3,String PT4,String PT5,String PT6,String PT7,String PT8,String PT9) throws IOException
	{
		 FileWriter fw2 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path()+"\\Generate_random\\passenger_data",false);
			fw2.write(P+"\r\n");
			fw2.write(PT1+","+PT2+","+PT3+","+PT4+"\r\n");
			fw2.write(PT5+"\r\n");
			fw2.write(PT6+"\r\n");
			fw2.close();
			
		 FileWriter fw1 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path()+"\\Generate_random\\PassengerOilConsumptionBounds",false);
			fw1.write("PassengerOilConsumption_Upper="+PT7+"\r\n");
			fw1.write("PassengerOilConsumption_Lower="+PT8+"\r\n");
			fw1.write("Passenger_OilPrice="+PT9+"\r\n");
				fw1.close();
	 }
}
