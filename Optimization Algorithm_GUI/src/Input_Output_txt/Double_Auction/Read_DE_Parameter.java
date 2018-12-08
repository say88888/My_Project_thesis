package Input_Output_txt.Double_Auction;

import java.io.BufferedReader;
import java.io.FileReader;

import GUI.I_Set_Paths_for_Current_Simulation_Example;
import GUI.GUI_Double_Auction.X_Select_Algorithm_Type_to_Solve_the_Problem;

public class Read_DE_Parameter {
	public static double Epsilon;
	public static int Iteration,LP,NP,Execution_Mode,write_Mode,Iteration_Mode;
	private static String[][] Parameter = new String[7][2];
	
	public static void main( ) {
		// TODO Auto-generated method stub
		String str;
		int d = 0;
		
		try {
			FileReader PBr = new FileReader(
					I_Set_Paths_for_Current_Simulation_Example.path()
							+ "\\DE_Parameter"+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\DE_Parameter.txt");
			BufferedReader br = new BufferedReader(PBr);
			while ((str = br.readLine()) != null) { // 每次讀一行
				Parameter[d++] = str.split("=| "); // 將此行以空白(white space)切成字串陣列,
													// 存入 Vector暫存
			}
			br.close(); // 關檔
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
		Iteration=Integer.parseInt(Parameter[0][1]);
		Iteration_Mode=Integer.parseInt(Parameter[1][1]);
		NP = Integer.parseInt(Parameter[2][1]);
		LP = Integer.parseInt(Parameter[3][1]);
		Epsilon = Double.parseDouble(Parameter[4][1]);
		Execution_Mode= Integer.parseInt(Parameter[5][1]);
		write_Mode=Integer.parseInt(Parameter[6][1]);
	}
	
	public static int Iteration() {
		return Iteration;
	}
	public static int Iteration_Mode() {
		return Iteration_Mode;
	}
	public static int NP() {
		return NP;
	}
	public static int LP() {
		return LP;
	}
	public static double Epsilon() {
		return Epsilon;
	}
	public static int Execution_Mode() {
		return Execution_Mode;
	}
	public static int write_Mode() {
		return write_Mode;
	}

}
