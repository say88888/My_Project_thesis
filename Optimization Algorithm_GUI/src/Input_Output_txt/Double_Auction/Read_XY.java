package Input_Output_txt.Double_Auction;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import GUI.I_Set_Paths_for_Current_Simulation_Example;
import GUI.GUI_Double_Auction.X_Select_Algorithm_Type_to_Solve_the_Problem;
 
public class Read_XY {
	private static ArrayList<String> X = new ArrayList<String>();
	private static ArrayList<String> Y = new ArrayList<String>();
	public static void main( ) {
		// TODO Auto-generated method stub
		String str;
		try {
			FileReader PBr = new FileReader("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+
					
					X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"X.txt");
			
			BufferedReader br = new BufferedReader(PBr);
			while ((str = br.readLine()) != null) { // 每次讀一行
				X.add(str);// 將此行以空白(white space)切成字串陣列, 存入 Vector暫存
			}
			br.close(); // 關檔
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			FileReader PBr = new FileReader("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+
					X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"Y.txt");
			BufferedReader br = new BufferedReader(PBr);
			while ((str = br.readLine()) != null) { // 每次讀一行
				Y.add(str);// 將此行以空白(white space)切成字串陣列, 存入 Vector暫存
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
