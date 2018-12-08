package Input_Output_txt.Double_Auction;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import GUI.I_Set_Paths_for_Current_Simulation_Example;
import GUI.GUI_Double_Auction.X_Select_Algorithm_Type_to_Solve_the_Problem;
 
public class Read_Group_Size_DA {
	public static ArrayList<Integer> S = new ArrayList<Integer>();

	public static void main() {
		String str;

		try {
			FileReader PBr = new FileReader(
					I_Set_Paths_for_Current_Simulation_Example.path()
							+ "\\PSO_Parameter\\"+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\Group_Size.txt");
			BufferedReader br = new BufferedReader(PBr);
			while ((str = br.readLine()) != null) { // 每次讀一行
				String tempArray[] = str.split(" ");
				for (int i = 0; i < tempArray.length; i++)
					S.add(Integer.parseInt(tempArray[i]));
			}
			br.close(); // 關檔
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static ArrayList<Integer> S() {
		return S;
	}
}
