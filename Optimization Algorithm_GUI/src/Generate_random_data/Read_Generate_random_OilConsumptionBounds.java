package Generate_random_data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.Vector;

import GUI.I_Set_Paths_for_Current_Simulation_Example;

public class Read_Generate_random_OilConsumptionBounds {

	private static double[] DriverOilConsumptionBounds=new double[2]; 
	private static double[] PassengerOilConsumptionBounds =new double[2];
	private static double Driver_OilPrice;
	private static double Passenger_OilPrice;

	public static void main() throws ParseException, IOException {
		
		String str;
		Vector<String[]> str_vec = new Vector<String[]>(); // 暫存
		Vector<String[]> str_vec1 = new Vector<String[]>(); // 暫存
		String Driver[][];
		String Passenger[][];

	try {
		FileReader PBr = new FileReader(I_Set_Paths_for_Current_Simulation_Example.path()+ "\\Generate_random\\DriverOilConsumptionBounds");
		BufferedReader br = new BufferedReader(PBr);
		while ((str = br.readLine()) != null) { // 每次讀一行
			str_vec.add(str.split("=| ")); // 將此行以空白(white space)切成字串陣列,存入 Vector暫存
		}
		br.close(); // 關檔
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	try {
		FileReader PBr = new FileReader(I_Set_Paths_for_Current_Simulation_Example.path()+ "\\Generate_random\\PassengerOilConsumptionBounds");
		BufferedReader br1 = new BufferedReader(PBr);
		while ((str = br1.readLine()) != null) { // 每次讀一行
			str_vec1.add(str.split("=| ")); // 將此行以空白(white space)切成字串陣列,存入 Vector暫存
		}
		br1.close(); // 關檔
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	Driver = new String[str_vec.size()][]; // 產生二維陣列, 依據暫存的size(txt檔的行數)
	for (int i = 0; i < str_vec.size(); i++)
		Driver[i] = str_vec.elementAt(i); // 將暫存區每一個元素(一行裡的字串陣列)放入二維陣列
	
	Passenger = new String[str_vec1.size()][]; // 產生二維陣列, 依據暫存的size(txt檔的行數)
	for (int i = 0; i < str_vec1.size(); i++)
		Passenger[i] = str_vec1.elementAt(i); // 將暫存區每一個元素(一行裡的字串陣列)放入二維陣列
	
	for (int i = 0; i < Driver.length-1; i++) {
		for(int j=Driver[i].length-1;j< Driver[i].length;j++)
		DriverOilConsumptionBounds[i] = Double.parseDouble(Driver[i][1]);  
		Driver_OilPrice= Double.parseDouble(Driver[2][1]); 
	}
	
	for (int i = 0; i < Passenger.length-1; i++) {
		for(int j=Passenger[i].length-1;j< Passenger[i].length;j++)
		PassengerOilConsumptionBounds[i] = Double.parseDouble(Passenger[i][1]); 
		Passenger_OilPrice= Double.parseDouble(Passenger[2][1]); 
	}
		
	
	
	
	}
	public static double DriverOilConsumptionBounds(int i) {
		return DriverOilConsumptionBounds[i];
	}

	public static double PassengerOilConsumptionBounds(int i) {
		return PassengerOilConsumptionBounds[i];
	}

	public static double Driver_OilPrice() {
		return Driver_OilPrice;
	}	
	
	public static double Passenger_OilPrice() {
		return Passenger_OilPrice;
	}
	
}
