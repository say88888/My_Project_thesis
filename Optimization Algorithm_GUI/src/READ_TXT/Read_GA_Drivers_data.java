package READ_TXT;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import READ_TXT.Read_INPUT_TXT_filter;

public class Read_GA_Drivers_data {
		  
		 private static int[] Order;
		 private static ArrayList<String> Drivers = new ArrayList<String>();
		 private static ArrayList<String> Orders = new ArrayList<String>();
		 private static ArrayList<Integer> D = new ArrayList<Integer>();
	public static void main( ) throws Exception {
		Read_INPUT_TXT_filter.loadData();

		Drivers.clear();
		Orders.clear();
		D.clear();
		
		int i, j, k, m = 0,t=0;
		String fileName = "GA_input\\";
		String[] filename, Pfilename, Dfilename;
		String CfileName, line, line1, DfileName;
		File f = new File(fileName);
		if (f.isDirectory()) {
			filename = f.list();
			System.out.println("開始讀檔...");
			for (i = 0; i < filename.length; i++) {
				// ------------------------------
				DfileName = fileName + filename[i] + "\\";
				System.out.println(DfileName);
				File Df = new File(DfileName);
				if (Df.isDirectory()) {
					Dfilename = Df.list();
					t=0;
					for (k = 0; k < Dfilename.length; k++) {
						
						// ---------------------
						CfileName = fileName + filename[i] + "\\"
								+ Dfilename[k] + "\\";
						//System.out.println(CfileName);
						File Cf = new File(CfileName);
						if (Cf.isDirectory()) {
							Pfilename = Cf.list();
							for (j = 0; j < Pfilename.length; j++) {
								t++;
								 System.out.println(fileName+filename[i] + "\\" +
								 Dfilename[k] + "\\"+
								 Pfilename[j]);
							
								FileReader fr = new FileReader(fileName
										+ filename[i] + "\\" + Dfilename[k]
										+ "\\" + Pfilename[j]
										+ "\\DriverBids.txt");
								BufferedReader br = new BufferedReader(fr);
							
								while ((line = br.readLine()) != null) {
									Drivers.add(line);
								}
								
						
								
								FileReader fr1 = new FileReader(fileName
										+ filename[i] + "\\" + Dfilename[k]
										+ "\\" + Pfilename[j]
										+ "\\Order.txt");
								BufferedReader br1 = new BufferedReader(fr1);
								while ((line = br1.readLine()) != null) {
									Orders.add(line);
								}
							
							}
						} else {
							System.out.println("Error 子目錄錯誤");
						}
					}D.add(t);
				}
			}
		} else {
			System.out.println("Error 目錄錯誤");
		}
	 
		  for(int g=0;g<D.size();g++)
			 System.out.println(D.get(g)); 
	}
	public static ArrayList<Integer> D(){
		return D;
	}
	
	public static ArrayList<String> Drivers(){
		return Drivers;
	}
	public static ArrayList<String> Orders(){
		return Orders;
	}
}
