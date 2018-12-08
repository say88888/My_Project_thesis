package Input_Output_txt.Carpool;

import java.io.File;

import GUI.I_Set_Paths_for_Current_Simulation_Example;
import GUI.GUI_Carpool.X_Select_Algorithm_Type_to_Solve_the_Problem;
import Result_to_out_Carpool.carpool_results_test;

public class check_batch_TXT {

	private static int  N; //此為計算目錄下有多少資料夾數量
	private static int  N1; //此為計算目錄下有多少資料夾數量
	private static String[]  Batch_Folder;
	
	public static void main() {
		// TODO Auto-generated method stub
	
		String fileName="output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+X_Select_Algorithm_Type_to_Solve_the_Problem.method()+"_Batch";
		
		System.out.println(fileName);
		
		//String fileName="output//Q1//PSO1_Batch";
		
		String[] filename;
		
		File f = new File(fileName);
		if (f.isDirectory()) {
			filename = f.list();
			System.out.println("開始讀檔...");
			for (int i = 0; i < filename.length; i++) {
				
				System.out.println(fileName+filename[i]);
			}
			
				N=filename.length;
				Batch_Folder=new String [N];
				for (int i = 0; i < filename.length; i++) {
					Batch_Folder[i]=filename[i];
			}
		}
		
		for (int i = 0; i < N; i++) 
			System.out.println(Batch_Folder[i]);
		
		
		for(N1=0;N1<N;N1++)
		{
			try {
				carpool_results_test.main();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public static int getN() {
		return N;
	}
	
	public static int getN1() {
		return N1;
	}
	
	public static String getString(int i) {
		return Batch_Folder[i];
	}
	
}
