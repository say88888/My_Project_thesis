package Input_Output_txt.Carpool;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Vector;

import GUI.I_Set_Paths_for_Current_Simulation_Example;
import GUI.GUI_Carpool.X_Select_Algorithm_Type_to_Solve_the_Problem;

public class Read_Eqution_Value {
	
	private static String[] Eqution;
	private static double[] Value;
	private static int n;
	
	public static void main( ) {
	
		String str;
		String Parameter[][];
		
		Vector<String []> str_vec = new Vector<String []>(); //暫存
		
		int i,j,k=0;
		
		// TODO Auto-generated method stub
		try {
			FileReader PBr = new FileReader("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"Eqution_Value.txt");
			BufferedReader br = new BufferedReader(PBr);
			while ((str = br.readLine()) != null) { //每次讀一行
				k++;
		str_vec.add(str.split("=")); //將此行以空白(white space)切成字串陣列, 存入 Vector暫存 
		}
		br.close(); //關檔
		} catch (Exception e) {
		e.printStackTrace();
		}
		Parameter = new String [str_vec.size()][]; //產生二維陣列, 依據暫存的size(txt檔的行數)
		for (i = 0; i < str_vec.size(); i++)
		Parameter[i] = str_vec.elementAt(i); //將暫存區每一個元素(一行裡的字串陣列)放入二維陣列
		
		Eqution=new String[k];
		Value=new double[k];
		
		for (i = 0; i < Parameter.length; i++) {
			for (j = Parameter[i].length-1; j <= Parameter[i].length-1; j++) {
					Eqution[i]=Parameter[i][0];
					Value[i]=Double.parseDouble(Parameter[i][1]);
			}
		}
		n=k;
	}
	
	public static String getEqution(int i){
		return Eqution[i];
	}
	public static double getValue(int i){
		return Value[i];
	}
	public static int n(){
		return n;
	}
	
}
