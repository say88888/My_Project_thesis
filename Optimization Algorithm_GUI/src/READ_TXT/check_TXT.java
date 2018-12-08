package READ_TXT;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import Enumeration.Enumeration;
import Generate_random_data.Read_Generate_random;

public class check_TXT extends Enumeration {
	private static String tf, tf1,tf2;
	private static double F;
	private static String[] Com;
	private static String[] Per;
	private static double[] Fdj;
	private static int[] CString_length;
	private static int[] PString_length;
	private static int P_high = 0;
	private static String[][] CString;
	private static String[][] PString;

	
	public static void main() throws Exception {
		// TODO Auto-generated method stub
		int i, j, k, m = 0;
		READ_P.READ_P();
		Com = new String[READ_P.getP_high()];
		Per = new String[READ_P.getP_high()];
		Fdj = new double[READ_P.getP_high()];
		String fileName;
		if(d<8)
		 fileName = "data\\Drivers_0" + (d + 1) + "_data\\";
		else
			fileName="data\\Drivers_" + (d + 1) + "_data\\";
		String[] filename, Pfilename, Dfilename;
		String CfileName, line, line1,line2,line3,DfileName;
	
		File f = new File(fileName);
		if (f.isDirectory()) {
			filename = f.list();
			System.out.println("開始讀檔...");
			// for (i = 0; i < filename.length; i++) {
			// ------------------------------
			// DfileName = fileName + filename[i] + "\\";
			/*
			 * DfileName = fileName +"Driver_"+(d+1)+"_data" + "\\"; File Df =
			 * new File(DfileName); if (Df.isDirectory()) { Dfilename =
			 * Df.list();
			 */
			for (k = 0; k < filename.length; k++) {
				// ---------------------
				CfileName = fileName + "\\" + filename[k] + "\\";
				double MaxF=0;
				String MaxCom="",MaxPer="";
				
				File Cf = new File(CfileName);
				if (Cf.isDirectory()) {
					Pfilename = Cf.list();
					for (j = 0; j < Pfilename.length; j++) {
						/* System.out.println(filename[i] + "\\" + Dfilename[k]
						 + "\\"+
						 Pfilename[j]);*/
						System.out.println(fileName + "\\"
								+ filename[k] + "\\" + Pfilename[j]);
						FileReader fr = new FileReader(fileName + "\\"
								+ filename[k] + "\\" + Pfilename[j]
								+ "\\geton_getoff.txt");
						BufferedReader br = new BufferedReader(fr);
						FileReader fr1 = new FileReader(fileName + "\\"
								+ filename[k] + "\\" + Pfilename[j]
								+ "\\time_restraint.txt");
						BufferedReader br1 = new BufferedReader(fr1);
						
						FileReader fr3 = new FileReader(fileName + "\\"
								+ filename[k] + "\\" + Pfilename[j]
								+ "\\Car_capacity.txt");
						BufferedReader br3 = new BufferedReader(fr3);
						
						while ((line = br.readLine()) != null) {
							tf = line;
						}
						while ((line1 = br1.readLine()) != null) {
							tf1 = line1;
						}
						while ((line3 = br3.readLine()) != null) {
							tf2 = line3;
						}
						
						if (tf.equals("true") && tf1.equals("true") && tf2.equals("true") ) {
							System.out.println("OK3" + filename[k]
									+ Pfilename[j]);
		
							FileReader fr2 = new FileReader(fileName + "\\"
									+ filename[k] + "\\" + Pfilename[j]
									+ "\\DriverBidsFdj.txt");
							
							BufferedReader br2 = new BufferedReader(fr2);
							while ((line2 = br2.readLine()) != null) {
								F= Double.parseDouble(line2);
							}
							
							System.err.print("F= "+F);
						
							if(F>MaxF)
							{
								MaxF=F;
								MaxCom=filename[k];
								MaxPer=Pfilename[j];
							}
						}
					}
					if(MaxF!=0){
					Com[m] = MaxCom;
					Per[m] = MaxPer;
					Fdj[m]=MaxF;
					m++;
				}
				} else {
					System.out.println("Error 子目錄錯誤");
				}
			
				// }
			}
		} else {
			System.out.println("Error 目錄錯誤");
		}
		//---------在這裡做判斷---------------------------------------------
		
		Read_Generate_random.main();
		P_high = m;
		if(m>Read_Generate_random.MaxNumBestBids())
		{
			for(i=0;i<m-1;i++)
			{
				for(j=0;j<m-i-1;j++)
				{
					if(Fdj[j+1]>Fdj[j])
					{
						double temp=Fdj[j+1];
						String String1=Com[j+1];
						String String2=Per[j+1];
						Fdj[j+1]=Fdj[j];
						Com[j+1]=Com[j];
						Per[j+1]=Per[j];
						Fdj[j]=temp;
						Com[j]=String1;
						Per[j]=String2;
					}
				}
			}
			P_high=Read_Generate_random.MaxNumBestBids();
			Split_String(Com, Per,Read_Generate_random.MaxNumBestBids());
		}
		else{
		Split_String(Com, Per, m);
		}
	}

	public static void Split_String(String[] Com, String[] Per, int high) {
		int i, j, k;
		CString = new String[high][10];
		PString = new String[high][10];
		CString_length = new int[high];
		PString_length = new int[high];
		for (i = 0; i < high; i++) {
			String result = "", String1, String2;
			String1 = Com[i];
			String2 = Per[i];
			String[] AfterSplit = String1.split("Com");
			String[] AfterSplit1 = String2.split("Per");

			System.out.print(" C ");
			for (j = 0; j < AfterSplit.length; j++) {
				CString[i][j] = AfterSplit[j];
				System.out.print(AfterSplit[j]);
			}
			for (j = 0; j < AfterSplit1.length; j++) {
				result += AfterSplit1[j];
			}

			System.out.print(" P  ");
			String[] AfterSplit2 = result.split("_");
			for (j = 0; j < AfterSplit2.length; j++) {
				PString[i][j] = AfterSplit2[j];
				System.out.print(AfterSplit2[j] + " ");
			}
			System.out.println();

			CString_length[i] = AfterSplit.length;
			PString_length[i] = AfterSplit2.length;
		}
	}

	public static String getC_String(int i, int j) {
		return CString[i][j];
	}

	public static int getC_length(int i) {
		return CString_length[i];
	}

	public static String getP_String(int i, int j) {
		return PString[i][j];
	}

	public static int getP_length(int i) {
		return PString_length[i];
	}

	public static int getP_high() {
		return P_high;
	}

}
