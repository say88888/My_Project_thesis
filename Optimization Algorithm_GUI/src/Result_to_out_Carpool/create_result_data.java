package Result_to_out_Carpool;

import java.io.File;

import Generate_random_data.Read_Generate_random;

public class create_result_data {
	private static String resultName;
	public static void main( ) throws Exception {
		String fileName = "result\\";
		String[] filename;
		Read_Generate_random.main();   
		int n = 0;
		File f = new File(fileName);
		if (f.isDirectory()) {
			filename = f.list();
			// System.out.println("開始讀檔...");
			for (int i = 0; i < filename.length; i++) {
				String[] tokens = filename[i].split("_");
				if (Integer.parseInt(tokens[1]) == Read_Generate_random.D()&& Integer.parseInt(tokens[3]) == Read_Generate_random.P()) {
					if (Integer.parseInt(tokens[5]) > n) {
						n = Integer.parseInt(tokens[5]);
					}
				}
			}
		} else {
			System.out.println("Error 目錄錯誤");
		}
		resultName = "Driver_" + Read_Generate_random.D() + "_Passenger_"+ Read_Generate_random.P() + "_Case_" + (n + 1);
		File f1 = new File("result\\" + resultName);
		f1.mkdir();
		System.out.println("result資料夾建立完成");
	}
	
	public static String reusltName(){
		return resultName;
	}
}
