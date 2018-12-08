package Input_Output_txt.Carpool;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

import GUI.I_Set_Paths_for_Current_Simulation_Example;
 
public class Read_BPL_TXT {
	private static ArrayList<ArrayList<Integer>> Bpl = new ArrayList<ArrayList<Integer>>();
	private static ArrayList<ArrayList<String>> Data = new ArrayList<ArrayList<String>>();
	private static ArrayList<String> data = new ArrayList<String>();
	public static void main( ) {
		// TODO Auto-generated method stub
		String str;
		int d = 0;
		Data = new ArrayList<ArrayList<String>>();
		try {
			FileReader PBr = new FileReader(
					I_Set_Paths_for_Current_Simulation_Example.path()+"\\Carpool\\BPL.txt");
			BufferedReader br = new BufferedReader(PBr);
			while ((str = br.readLine()) != null) { // 每次讀一行
				data= new ArrayList(Arrays.asList(str.split("\\s")));
				Data.add(data);
			}
			br.close(); // 關檔
		} catch (Exception e) {
			e.printStackTrace();
		}
		Bpl = new ArrayList<ArrayList<Integer>>();
		 for(int i=0;i<Data.size();i++){
			 ArrayList<Integer> test = new ArrayList<Integer>();
			 for(int j=2;j<Data.get(i).size();j++){
				 test.add(Integer.parseInt(Data.get(i).get(j)));
			 }Bpl.add(test);
		 }
		 
		  
	}
 
	public static ArrayList<ArrayList<Integer>> Bpl(){
		return Bpl;
	}
}
