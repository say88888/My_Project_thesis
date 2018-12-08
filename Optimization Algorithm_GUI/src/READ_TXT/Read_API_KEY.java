package READ_TXT;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

public class Read_API_KEY {
	 
	 private static ArrayList<String> Key = new ArrayList<String>();
	public static void main( ) throws Exception{
		String str;
		
		try {
			FileReader PBr = new FileReader("API_KEY");
			BufferedReader br = new BufferedReader(PBr);
			while ((str = br.readLine()) != null) { //每次讀一行
				Key.add(str);//將此行以空白(white space)切成字串陣列, 存入 Vector暫存 	 
		}
		br.close(); //關檔
		} catch (Exception e) {
		e.printStackTrace();
		}
		for(int i=0;i<Key.size();i++)
			System.out.println(Key.get(i));
		
	}
	public static ArrayList<String> Key(){
		return Key;
	}
	 
}
