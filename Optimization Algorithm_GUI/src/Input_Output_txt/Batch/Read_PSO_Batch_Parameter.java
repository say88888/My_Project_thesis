package Input_Output_txt.Batch;

import java.io.BufferedReader;
import java.io.FileReader;

import GUI.I_Set_Paths_for_Current_Simulation_Example;
import GUI.GUI_Batch.X_Select_Algorithm_Type_to_Solve_the_Problem;

public class Read_PSO_Batch_Parameter {
	
	private static int Iteration;
	private static int Iteration_Mode;
	private static int lowpopulationSize, UppopulationSize, StpopulationSize;
	private static double loww, Upw, Stw;
	private static double lowc1, Upc1, Stc1;
	private static double lowc2, Upc2, Stc2;
	private static int Vmax;
	private static int Execution_Mode;
	private static int Print_Mode;
	private static int Write_Mode;
	private static double threshold;
	private static double epsilon;	//ε
	private static double micro;	//μ
	private static String[][] Parameter = new String[13][3];

 
	public static void main( ) {
		
		String str;
		int d = 0;
		
		try {
			FileReader PBr = new FileReader(
					I_Set_Paths_for_Current_Simulation_Example.path()
							+ "\\PSO_Parameter"
							+ X_Select_Algorithm_Type_to_Solve_the_Problem
									.path() + "Batch_PSO_Parameter.txt");
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
		
		lowpopulationSize = Integer.parseInt(Parameter[2][1]);
		UppopulationSize = Integer.parseInt(Parameter[2][2]);
		StpopulationSize = Integer.parseInt(Parameter[2][3]);

		loww = Double.parseDouble(Parameter[3][1]);
		Upw = Double.parseDouble(Parameter[3][2]);
		Stw = Double.parseDouble(Parameter[3][3]);

		lowc1 = Double.parseDouble(Parameter[4][1]);
		Upc1 = Double.parseDouble(Parameter[4][2]);
		Stc1 = Double.parseDouble(Parameter[4][3]);
		
		lowc2 = Double.parseDouble(Parameter[5][1]);
		Upc2 = Double.parseDouble(Parameter[5][2]);
		Stc2 = Double.parseDouble(Parameter[5][3]);
		
		Vmax = Integer.parseInt(Parameter[6][1]);
		
		Execution_Mode = Integer.parseInt(Parameter[7][1]);
	
		Print_Mode = Integer.parseInt(Parameter[8][1]);
	
		Write_Mode= Integer.parseInt(Parameter[9][1]);
		
		threshold = Double.parseDouble(Parameter[10][1]);
		if(X_Select_Algorithm_Type_to_Solve_the_Problem.method()=="PSO4"){
			epsilon=Double.parseDouble(Parameter[10][1]);
			micro=Double.parseDouble(Parameter[11][1]);
		}
	}

	 public static int Iteration() {
			return Iteration;
	}
	public static int Iteration_Mode(){
			return Iteration_Mode;
	}
	
	public static int lowpopulationSize() {
		return lowpopulationSize;
	}

	public static int UppopulationSize() {
		return UppopulationSize;
	}

	public static int StpopulationSize() {
		return StpopulationSize;
	}

	public static double loww() {
		return loww;
	}

	public static double Upw() {
		return Upw;
	}

	public static double Stw() {
		return Stw;
	}

	public static double lowc1() {
		return lowc1;
	}

	public static double Upc1() {
		return Upc1;
	}

	public static double Stc1() {
		return Stc1;
	}

	public static double lowc2() {
		return lowc2;
	}

	public static double Upc2() {
		return Upc2;
	}

	public static double Stc2() {
		return Stc2;
	}

	public static int Vmax() {
		return Vmax;
	}
	public static int Execution_Mode(){
		return Execution_Mode;
	}
	public static int Print_Mode(){
		return Print_Mode;
	}
	public static int Write_Mode(){
		return Write_Mode;
	}
	public static double threshold(){
		return threshold;
	}
	public static double epsilon(){
		return epsilon;
	}
	public static double micro(){
		return micro;
	}

}
