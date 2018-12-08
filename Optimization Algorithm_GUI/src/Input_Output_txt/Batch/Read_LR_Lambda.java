package Input_Output_txt.Batch;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import GUI.I_Set_Paths_for_Current_Simulation_Example;
import GUI.GUI_Batch.X_Select_Algorithm_Type_to_Solve_the_Problem;


public class Read_LR_Lambda {
	public static ArrayList<String> Lambda1 = new ArrayList<String>();
	public static ArrayList<String> Lambda2 = new ArrayList<String>();
	public static ArrayList<String> Lambda3 = new ArrayList<String>();
	public static ArrayList<String> Lambda4 = new ArrayList<String>();
	
	public static void LR_and_PSO1( ) {
		// TODO Auto-generated method stub
		String str;
		int d = 0;
		
		try {
			FileReader PBr = new FileReader(
					"output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"LR_XY_Lambda\\Lambda1.txt");
			BufferedReader br = new BufferedReader(PBr);
			while ((str = br.readLine()) != null) { // 每次讀一行
				Lambda1.add(str); // 將此行以空白(white space)切成字串陣列,
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
					"output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"LR_XY_Lambda\\Lambda2.txt");
			BufferedReader br = new BufferedReader(PBr);
			while ((str1 = br.readLine()) != null) { // 每次讀一行
				Lambda2.add(str1); // 將此行以空白(white space)切成字串陣列,
			}
			br.close(); // 關檔
		} catch (Exception e) {
			e.printStackTrace();
		}
	 
		String str2;
		 d = 0;
		try {
			FileReader PBr = new FileReader(
					"output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"LR_XY_Lambda\\Lambda3.txt");
			BufferedReader br = new BufferedReader(PBr);
			while ((str2 = br.readLine()) != null) { // 每次讀一行
				Lambda3.add(str2); // 將此行以空白(white space)切成字串陣列,
			}
			br.close(); // 關檔
		} catch (Exception e) {
			e.printStackTrace();
		}
		
			String str3;
			 d = 0;
			 
			try {
				FileReader PBr = new FileReader(
						"output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"LR_XY_Lambda\\Lambda4.txt");
				BufferedReader br = new BufferedReader(PBr);
				while ((str3 = br.readLine()) != null) { // 每次讀一行
					Lambda4.add(str3); // 將此行以空白(white space)切成字串陣列,
				}
				br.close(); // 關檔
			} catch (Exception e) {
				e.printStackTrace();
			}
			 
	}
	
	public static void LR_and_PSO1_DA( ) {
		// TODO Auto-generated method stub
		String str;
		int d = 0;
		
		try {
			FileReader PBr = new FileReader(
					"output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"LR_XY_Lambda\\Lambda1.txt");
			BufferedReader br = new BufferedReader(PBr);
			while ((str = br.readLine()) != null) { // 每次讀一行
				Lambda1.add(str); // 將此行以空白(white space)切成字串陣列,
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
					"output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"LR_XY_Lambda\\Lambda2.txt");
			BufferedReader br = new BufferedReader(PBr);
			while ((str1 = br.readLine()) != null) { // 每次讀一行
				Lambda2.add(str1); // 將此行以空白(white space)切成字串陣列,
			}
			br.close(); // 關檔
		} catch (Exception e) {
			e.printStackTrace();
		}
	 
		String str2;
		 d = 0;
		try {
			FileReader PBr = new FileReader(
					"output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"LR_XY_Lambda\\Lambda3.txt");
			BufferedReader br = new BufferedReader(PBr);
			while ((str2 = br.readLine()) != null) { // 每次讀一行
				Lambda3.add(str2); // 將此行以空白(white space)切成字串陣列,
			}
			br.close(); // 關檔
		} catch (Exception e) {
			e.printStackTrace();
		}
		
			String str3;
			 d = 0;
			 
			 
	}
	public static ArrayList<String> Lambda1(){
		return Lambda1;
	}
	public static ArrayList<String> Lambda2(){
		return Lambda2;
	}
	public static ArrayList<String> Lambda3(){
		return Lambda3;
	}
	public static ArrayList<String> Lambda4(){
		return Lambda4;
	}
}
