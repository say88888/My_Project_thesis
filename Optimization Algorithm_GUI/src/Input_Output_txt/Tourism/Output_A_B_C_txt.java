package Input_Output_txt.Tourism;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import GUI.I_Set_Paths_for_Current_Simulation_Example;
import GUI.GUI_Tourism.X_Select_Algorithm_Type_to_Solve_the_Problem;

public class Output_A_B_C_txt {

	public static void A_B_C_txt(ArrayList<List<Integer>> A, ArrayList<Integer> B, ArrayList<Double> C ) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path());
	    f2.mkdir();
    	FileWriter fw = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\A.txt",false);
    	for(int i=0;i<A.size();i++) {
    		for(int j=0;j<A.get(i).size();j++)
    			fw.write(String.valueOf(A.get(i).get(j)+" "));
    		fw.write("\r\n");
    	}
    	fw.close();
    	
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\B.txt",false);
    	for(int i=0;i<B.size();i++) {
			fw1.write(String.valueOf(B.get(i)));
			fw1.write("\r\n");
    	}
		fw1.close();
    	
		FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\C.txt",false);
		for(int i=0;i<C.size();i++) {
			fw2.write(String.valueOf(C.get(i)));
			fw2.write("\r\n");
		}
		fw2.close();
		
	}
	
	}
