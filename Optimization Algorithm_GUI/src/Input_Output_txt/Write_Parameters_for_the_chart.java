package Input_Output_txt;

import java.io.FileWriter;
import java.io.IOException;

import GUI.I_Set_Paths_for_Current_Simulation_Example;

public class Write_Parameters_for_the_chart {

	public static void save_Parameters_for_the_chart(String Start,String End,String Interval) throws IOException
	{
		 FileWriter fw2 = new FileWriter("Set_Parameters_for_the_chart.txt",false);
			fw2.write("Start="+Start+"\r\n");
			fw2.write("End="+End+"\r\n");
			fw2.write("Interval="+Interval+"\r\n");
			
			fw2.close();
	 }
}
