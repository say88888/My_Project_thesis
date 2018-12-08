package Input_Output_txt.Carpool;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import GUI.I_Set_Paths_for_Current_Simulation_Example;
import GUI.GUI_Carpool.X_Select_Algorithm_Type_to_Solve_the_Problem;

public class Read_LR_XY {
	private static ArrayList<String> X = new ArrayList<String>();
	private static ArrayList<String> Y = new ArrayList<String>();
	public static void main( ) {
		// TODO Auto-generated method stub
		String str;
		int d = 0;
		
		try {
			FileReader PBr = new FileReader(
					"output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"LR_XY_Lambda\\LR_X.txt");
			BufferedReader br = new BufferedReader(PBr);
			while ((str = br.readLine()) != null) { // 每次讀一行
				X.add(str); // 將此行以空白(white space)切成字串陣列,
													// 存入 Vector暫存
			}
			br.close(); // 關檔
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
		String str1;
		 d = 0;
		
		try {
			FileReader PBr = new FileReader(
					"output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"LR_XY_Lambda\\LR_Y.txt");
			BufferedReader br = new BufferedReader(PBr);
			while ((str1 = br.readLine()) != null) { // 每次讀一行
				Y.add(str1); // 將此行以空白(white space)切成字串陣列,
			}
			br.close(); // 關檔
		} catch (Exception e) {
			e.printStackTrace();
		}
	 
	}
	public static ArrayList<String> X(){
		return X;
	}
	public static ArrayList<String> Y(){
		return Y;
	}
}
