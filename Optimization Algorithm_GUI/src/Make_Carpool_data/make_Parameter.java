package Make_Carpool_data;

import java.io.File;
import java.io.FileWriter;

import READ_TXT.Read_INPUT_TXT_filter;
import Enumeration.Enumeration;
 

public class make_Parameter extends Enumeration{
	private static double TmP= 0.05;
	private static double TmD= 0.05;
	private static int D_lengh;
	private static int P_lengh;
	public static	void makebids(int P_high,String[] C_string,String[] P_String)throws Exception {
		Read_INPUT_TXT_filter.loadData();

		D_lengh=1;
		P_lengh=Read_INPUT_TXT_filter.getP();
		
		int i,j,k;
		
    System.out.println("建立Parameter.TXT檔");
    String t="";
    if(d>8)
		t="GA_input\\Drivers_"+(d+1)+"_data";
	else
		t="GA_input\\Drivers_"+"0"+(d+1)+"_data";
    for(i=0;i<P_high;i++){
/*    File f11 = new File("GA_input\\Drivers_"+(d+1)+"_data\\Com"+C_string[i]);
  	 f11.mkdir();
  	 File f = new File("GA_input\\Drivers_"+(d+1)+"_data\\Com"+C_string[i]+"\\"+"Per"+P_String[i]);
  	    f.mkdir();*/
  	  FileWriter fw1 = new FileWriter(t+"\\Com"+C_string[i]+"\\"+"Per"+P_String[i]+"\\Parameter.txt");
   fw1.write(String.valueOf(P_lengh)+"\r\n");
	for(k=0;k<P_lengh;k++)
	fw1.write(String.valueOf(1)+" ");
	fw1.write("\r\n");
	fw1.write(String.valueOf(D_lengh)+"\r\n");
	for(k=0;k<D_lengh;k++)
		fw1.write(String.valueOf(1)+" ");
	fw1.write("\r\n");
	fw1.write(String.valueOf(P_lengh)+"\r\n");
	fw1.write(String.valueOf(TmP)+"\r\n");
	fw1.write(String.valueOf(TmD)+"\r\n");
	fw1.close();
    }
	}
    

}
