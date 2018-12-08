package Input_Output_txt;

import java.io.BufferedReader;
import java.io.FileReader;

import GUI.I_Set_Paths_for_Current_Simulation_Example;

public class Read_TS_Parameter {
	public static double x0 , Epsilon,ClearMaxIter,MinTenure,MaxTenure;
	public static int d0 , gp, gs,tabu_tenure_model,Iteration,Iteration_Mode;
	private static String[][] Parameter = new String[11][2];
	
	public static void main( ) {
		// TODO Auto-generated method stub
		String str;
		int d = 0;
		
		try {
			FileReader PBr = new FileReader(
					I_Set_Paths_for_Current_Simulation_Example.path()
							+ "\\TS\\TS_Parameter.txt");
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
		x0 = Double.parseDouble(Parameter[2][1]);
		Epsilon = Double.parseDouble(Parameter[3][1]);
		d0 = Integer.parseInt(Parameter[4][1]);
		gp=Integer.parseInt(Parameter[5][1]);
		gs = Integer.parseInt(Parameter[6][1]);
		tabu_tenure_model= Integer.parseInt(Parameter[7][1]);
		ClearMaxIter= Double.parseDouble(Parameter[8][1]);
		MinTenure= Double.parseDouble(Parameter[9][1]);
		MaxTenure= Double.parseDouble(Parameter[10][1]);
		
	}
	
	public static int Iteration() {
		return Iteration;
	}
	public static int Iteration_Mode() {
		return Iteration_Mode;
	}
	public static double x0() {
		return x0;
	}
	public static double Epsilon() {
		return Epsilon;
	}
	public static int d0() {
		return d0;
	}
	public static int gp() {
		return gp;
	}
	public static int gs() {
		return gs;
	}
	public static int tabu_tenure_model() {
		return tabu_tenure_model;
	}
	
	public static double ClearMaxIter() {
		return ClearMaxIter;
	}
	public static double MinTenure() {
		return MinTenure;
	}
	public static double MaxTenure() {
		return MaxTenure;
	}
	
}
