package READ_TXT;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.util.Vector;

import GUI.I_Set_Paths_for_Current_Simulation_Example;

public class Read_filter_and_detour_rate {
	
	private static double detour_rate;
	private static double filter_rate;
	 
	public static void main( ) {
		// TODO Auto-generated method stub
		String str;
		String Parameter[][];
		
		Vector<String []> str_vec = new Vector<String []>(); //暫存
		
		int i,j,k=0;
		
		// TODO Auto-generated method stub
		try {
			FileReader PBr = new FileReader(I_Set_Paths_for_Current_Simulation_Example.path()+"\\Generate_random\\filter_and_detour_rate");
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
		filter_rate=Double.parseDouble(Parameter[0][1]);
		detour_rate=Double.parseDouble(Parameter[1][1]);
	 
		
	}
	

	
	public static double getdetour_rate(){
		return detour_rate;
	}
	public static double getfilter_rate(){
		return filter_rate;
	}
	 
}
