package Make_Carpool_data;

import java.io.FileWriter;
import java.io.IOException;

import Enumeration.Enumeration;
import READ_TXT.Read_INPUT_TXT_filter;

public class make_order  extends Enumeration{

	private static int P_lengh;
	public static void makebids(int P_high,String[] C_string,String[] P_String,int[][] PX) throws IOException {
		Read_INPUT_TXT_filter.loadData();


		P_lengh=Read_INPUT_TXT_filter.getP();
		
		int i,j,k;
		
    System.out.println("建立orderr.TXT檔");
    String t="";
    if(d>8)
		t="GA_input\\Drivers_"+(d+1)+"_data";
	else
		t="GA_input\\Drivers_"+"0"+(d+1)+"_data";
    for(i=0;i<P_high;i++){
  	FileWriter fw1 = new FileWriter(t+"\\Com"+C_string[i]+"\\"+"Per"+P_String[i]+"\\Order.txt");
  	for(j=0;j<PX[i].length-1;j++){
	fw1.write(String.valueOf(PX[i][j])+",");}
  	fw1.write(String.valueOf(PX[i][j]));
  	fw1.write("\r\n");
	fw1.close();
    }
	}
	}


