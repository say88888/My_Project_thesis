package GUI;

import java.io.FileWriter;
import java.io.IOException;

public class Write_Classroom_Serial_number {

	public static void saveClassroom_Serial_number (String Classroom,String Serial_number) throws IOException{

		 FileWriter fw2 = new FileWriter("Read_Classroom_and_Serial_number.txt");
			fw2.write("Omega_1="+Classroom+"\r\n");
			fw2.write("Omega_2="+Serial_number+"\r\n");
			
			fw2.close();
	}
}
