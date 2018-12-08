package Input_Output_txt.Carpool;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.table.DefaultTableModel;

import GUI.I_Set_Paths_for_Current_Simulation_Example;

public class Write_Location {
	public static void write_Location(DefaultTableModel tableModel) throws IOException {
		// TODO Auto-generated method stub
	FileWriter fw2 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path()+"\\Generate_random\\Location",false);
	 for(int i=0;i<tableModel.getRowCount();i++){
		 for(int j=0;j<tableModel.getColumnCount()-1;j++){
			 fw2.write((String) tableModel.getValueAt(i, j)+",");
		 } fw2.write((String) tableModel.getValueAt(i, 2)+"\r\n");
	 }
		fw2.close();
	}
}
