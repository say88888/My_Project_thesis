package Input_Output_txt.Double_Auction;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Vector;

import GUI.I_Set_Paths_for_Current_Simulation_Example;

public class Read_the_CATSexe_path {
	
	private static String Path;
	
	public static void main() {
	
		String str;
		String Parameter[][];
		
		Vector<String []> str_vec = new Vector<String []>(); //暫存
		
		
		// TODO Auto-generated method stub
		try {
			FileReader PBr = new FileReader("Read_the_cats.exe_path.txt");
			BufferedReader br = new BufferedReader(PBr);
			while ((str = br.readLine()) != null) { //每次讀一行
		str_vec.add(str.split("=")); //將此行以空白(white space)切成字串陣列, 存入 Vector暫存 
		}
		br.close(); //關檔
		} catch (Exception e) {
		e.printStackTrace();
		}
		Parameter = new String [str_vec.size()][]; //產生二維陣列, 依據暫存的size(txt檔的行數)
		for (int i = 0; i < str_vec.size(); i++)
		Parameter[i] = str_vec.elementAt(i); //將暫存區每一個元素(一行裡的字串陣列)放入二維陣列
		
		Path=Parameter[0][0];
				
		//System.out.print("Url="+Url);
	}
	
	public static String getPath(){
		return Path;
	}

	
}
