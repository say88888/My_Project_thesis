package Input_Output_txt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Vector;

import GUI.I_Set_Paths_for_Current_Simulation_Example;

public class Read_Parameters_for_the_chart {
	private static String Start;
	private static String End;
	private static String Interval;
	public static void main( ) {
		// TODO Auto-generated method stub
		String str;
		String Parameter[][];
		
		Vector<String []> str_vec = new Vector<String []>(); //暫存
		
		int i,j,k=0;
		
		// TODO Auto-generated method stub
		try {
			FileReader PBr = new FileReader("Set_Parameters_for_the_chart.txt");
			BufferedReader br = new BufferedReader(PBr);
			while ((str = br.readLine()) != null) { //每次讀一行
				k++;
		str_vec.add(str.split("=| ")); //將此行以空白(white space)切成字串陣列, 存入 Vector暫存 
		}
		br.close(); //關檔
		} catch (Exception e) {
		e.printStackTrace();
		}
		
		
		Parameter = new String [str_vec.size()][]; //產生二維陣列, 依據暫存的size(txt檔的行數)
		for (i = 0; i < str_vec.size(); i++)
		Parameter[i] = str_vec.elementAt(i); //將暫存區每一個元素(一行裡的字串陣列)放入二維陣列
		Start=Parameter[0][1];
		End=Parameter[1][1];
		Interval=Parameter[2][1];
		
	}
public static String Start(){
	return Start;
}
public static String End(){
	return End;
}
public static String Interval(){
	return Interval;
}


}
