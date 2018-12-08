package Input_Output_txt.Carpool;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.Vector;

public class Read_example_Location {
	private static int N; // 經緯度數量
	private static double lat[]; // 緯度
	private static double lng[]; // 經度
	private static String location[]; // 地點

	public static void main(String path) throws ParseException, IOException {
		String str;
		String Parameter[][]; // 二維陣列
		Vector<String[]> str_vec = new Vector<String[]>(); // 暫存
		int i, j, k = 0;
	 
		// 讀取 Generate random Location TXT
		try {
			FileReader PBr = new FileReader(path);
			BufferedReader br = new BufferedReader(PBr);
			while ((str = br.readLine()) != null) { // 每次讀一行
				k++;
				str_vec.add(str.split(",")); // 將此行以空白(white space)切成字串陣列, 存入
												// Vector暫存
			}
			br.close(); // 關檔
		} catch (Exception e) {
			e.printStackTrace();
		}

		lat = new double[k];
		lng = new double[k];
		location = new String[k];
		Parameter = new String[str_vec.size()][]; // 產生二維陣列, 依據暫存的size(txt檔的行數)
		for (i = 0; i < str_vec.size(); i++)
			Parameter[i] = str_vec.elementAt(i); // 將暫存區每一個元素(一行裡的字串陣列)放入二維陣列
		// System.out.println("Generate random  Location:");
		// 印出二維陣列內容
		for (i = 0; i < Parameter.length; i++) {
			for (j = 0; j <= Parameter[i].length - 1; j++) {
				lat[i] = Double.parseDouble(Parameter[i][0]);
				lng[i] = Double.parseDouble(Parameter[i][1]);
				location[i] = Parameter[i][2];
			}
		}

	}
	public static int N(){
		return lat.length;
	}
	public static double lat(int i)
	{
		return lat[i];
	}
	
	public static double lng(int i)
	{
		return lng[i];
	}
	
	public static String location(int i)
	{
		return location[i];
	}
}
