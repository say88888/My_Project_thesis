package Generate_random_data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.Vector;

import GUI.I_Set_Paths_for_Current_Simulation_Example;

public class Read_Generate_random {
	private static int N; // 經緯度數量
	private static double lat[]; // 緯度
	private static double lng[]; // 經度
	private static String location[]; // 地點
	private static int P; // 產生乘客人數
	private static int D; // 產生司機人數
	private static int location_length;
	private static int[] DTimeRandom = new int[10]; // 時間參數值
	private static int[] PTimeRandom = new int[10]; // 時間參數值
	
	private static int Seats_Lower,Seats_Upper;  //司機座位數
	
	private static double Route_rate; // 與司機距離比率
	private static double PassengerDistance; //  乘客自己那段距離
	private static int MaxNumBestBids;  //每位司機最大投標數
	private static double DriversDistance;  //每位司機f各自起訖距離

	public static void main() throws ParseException, IOException {
		String str;
		String Parameter[][]; // 二維陣列
		String Driver[][];
		String Passenger[][];
		Vector<String[]> str_vec = new Vector<String[]>(); // 暫存
		Vector<String[]> str_vec1 = new Vector<String[]>(); // 暫存
		Vector<String[]> str_vec2 = new Vector<String[]>(); // 暫存
		int i, j, k = 0;

		// 讀取 Generate random Location TXT
		if (GUI.main.getmethod() == 0) {
			try {
				FileReader PBr = new FileReader(I_Set_Paths_for_Current_Simulation_Example.path()+ "\\Generate_random\\Location");
				BufferedReader br = new BufferedReader(PBr);
				while ((str = br.readLine()) != null) { // 每次讀一行
					k++;
					str_vec.add(str.split(",")); // 將此行以空白(white space)切成字串陣列,存入 Vector暫存
				}
				br.close(); // 關檔
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			try {
				FileReader PBr = new FileReader("範本 200X200\\Location");
				BufferedReader br = new BufferedReader(PBr);
				while ((str = br.readLine()) != null) { // 每次讀一行
					k++;
					str_vec.add(str.split(",")); // 將此行以空白(white space)切成字串陣列,存入 Vector暫存
				}
				br.close(); // 關檔
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 讀取 driver_data TXT
		try {
			FileReader PBr1 = new FileReader(
					I_Set_Paths_for_Current_Simulation_Example.path()+ "\\Generate_random\\driver_data");
			BufferedReader br1 = new BufferedReader(PBr1);
			while ((str = br1.readLine()) != null) { // 每次讀一行
				str_vec1.add(str.split(",")); // 將此行以空白(white space)切成字串陣列, 存入Vector暫存
			}
			br1.close(); // 關檔
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 讀取 passenger_data TXT
		try {
			FileReader PBr2 = new FileReader(I_Set_Paths_for_Current_Simulation_Example.path()+ "\\Generate_random\\passenger_data");
			BufferedReader br2 = new BufferedReader(PBr2);
			while ((str = br2.readLine()) != null) { // 每次讀一行
				str_vec2.add(str.split(",")); // 將此行以空白(white space)切成字串陣列, 存入Vector暫存
			}
			br2.close(); // 關檔
		} catch (Exception e) {
			e.printStackTrace();
		}

		lat = new double[k];
		lng = new double[k];
		location = new String[k];

		Parameter = new String[str_vec.size()][]; // 產生二維陣列, 依據暫存的size(txt檔的行數)
		for (i = 0; i < str_vec.size(); i++)
			Parameter[i] = str_vec.elementAt(i); // 將暫存區每一個元素(一行裡的字串陣列)放入二維陣列
		for (i = 0; i < Parameter.length; i++) {
			for (j = 0; j <= Parameter[i].length - 1; j++) {
				lat[i] = Double.parseDouble(Parameter[i][0]);
				lng[i] = Double.parseDouble(Parameter[i][1]);
				location[i] = Parameter[i][2];
			}
		}

		Driver = new String[str_vec1.size()][]; // 產生二維陣列, 依據暫存的size(txt檔的行數)
		for (i = 0; i < str_vec1.size(); i++)
			Driver[i] = str_vec1.elementAt(i); // 將暫存區每一個元素(一行裡的字串陣列)放入二維陣列

		Passenger = new String[str_vec2.size()][]; // 產生二維陣列, 依據暫存的size(txt檔的行數)
		for (i = 0; i < str_vec2.size(); i++)
			Passenger[i] = str_vec2.elementAt(i); // 將暫存區每一個元素(一行裡的字串陣列)放入二維陣列
	
		P = Integer.parseInt(Passenger[0][0]);
		D = Integer.parseInt(Driver[0][0]); // 司機與乘客人數
		
		Seats_Lower= Integer.parseInt(Driver[1][0]);
		Seats_Upper= Integer.parseInt(Driver[1][1]);

		for (j = 0; j <= Driver[1].length - 1; j++)
			DTimeRandom[j] = Integer.parseInt(Driver[2][j]); // 司機時間參數
		for (j = 0; j <= Passenger[1].length - 1; j++)
			PTimeRandom[j] = Integer.parseInt(Passenger[1][j]); // 乘客時間參數
			
		location_length = k;
		
		Route_rate=Double.parseDouble(Passenger[2][0]);
		PassengerDistance=Double.parseDouble(Passenger[3][0]);
		MaxNumBestBids=Integer.parseInt(Driver[3][0]);
		DriversDistance=Double.parseDouble(Driver[4][0]);
	}

	public static int P() {
		return P;
	}

	public static int D() {
		return D;
	}

	public static int Seats_Lower() {
		return Seats_Lower;
	}
	
	public static int Seats_Upper() {
		return Seats_Upper;
	}
	
	public static int N() {
		return lat.length;
	}

	public static double lat(int i) {
		return lat[i];
	}

	public static double lng(int i) {
		return lng[i];
	}

	public static String location(int i) {
		return location[i];
	}

	public static int location_length() {
		return location_length;
	}

	public static int DTimeRandon(int i) {
		return DTimeRandom[i];
	}

	public static int PTimeRandom(int i) {
		return PTimeRandom[i];
	}

	public static double Route_rate() {
		return Route_rate;
	}
	public static double PassengerDistance() {
		return PassengerDistance;
	}
	public static int MaxNumBestBids() {
		return MaxNumBestBids;
	}
	public static double DriversDistance() {
		return DriversDistance;
	}
}
