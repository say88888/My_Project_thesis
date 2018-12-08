package Enumeration;

 
import java.io.File;
import java.io.FileWriter;

import READ_TXT.READ_C;
import READ_TXT.READ_P;
import READ_TXT.Read_INPUT_TXT_filter;

public class step3_select_P extends Enumeration {
	private static int[][] PX,PC;
	private static boolean[] geton_getoff;
	private static boolean[] Car_capacity;
	private static int P1;
	
	public static void main() throws Exception {
		READ_P.READ_P();
		READ_C.READ_C();
		Read_INPUT_TXT_filter.loadData();
		int i, j, k = 0,l,o=0,q=0,capacity;
		P1=READ_P.getP_high();
		PX = new int[P1][];
		PC=new int[P1][];
		 geton_getoff=new boolean[P1];
		 Car_capacity=new boolean[P1];
		 
		 
		for (i = 0; i < READ_P.getP_high(); i++){
			PX[i] = new int[READ_P.getP_length(i)];
			PC[i] = new int[READ_P.getP_length(i)];
		}
		for (i = 0; i < PX.length; i++)
			for (j = 0; j < PX[i].length; j++) {
				PX[i][j] = READ_P.getP(i, j);
			}

		for (i = 0; i < PX.length; i++) {
			k = 0; q=0; l=0;
			for (j = 0; j < PX[i].length; j++) {
				if (PX[i][j] < 0){
					k--;
				}
				if (PX[i][j] > 0){
					k++;
					for(o=0;o<j;o++){
						if (-(PX[i][o])==(PX[i][j])) {
							q++;
						}}
				}
				if (k < 0 && j < PX[i].length - 1 ) {
					geton_getoff[i]=false;
					
					break;
				}
				if (k == 0 && j == PX[i].length - 1 && q==0) {
					geton_getoff[i]=true;
				}
			}
		}
		

		for (i = 0; i < PX.length; i++) {
			k = 0; q=0; l=0;
			capacity=Read_INPUT_TXT_filter.getP_NUMBER(d);
			for (j = 0; j < PX[i].length; j++) {
				if (PX[i][j] < 0){
					k--;
					PC[i][j]=Read_INPUT_TXT_filter.getseat((-PX[i][j])-1);
					l-=PC[i][j];
				}
				if (PX[i][j] > 0){
					k++;
					PC[i][j]=Read_INPUT_TXT_filter.getseat((PX[i][j])-1);
					l+=PC[i][j];
					}
				if(l < 0 || l>capacity)
				{Car_capacity[i]=false;
				break;}
				else {Car_capacity[i]=true;}
				}
			}
		
		
		String t="";
    	if(d>8)
    		t="data\\Drivers_"+(d+1)+"_data";
    	else
    		t="data\\Drivers_"+"0"+(d+1)+"_data";
	for(i=0;i<P1;i++){
	/*	File f2 = new File("data\\Drivers_"+(d+1)+"_data");
	    f2.mkdir();
    	File f1 = new File("data\\Drivers_"+(d+1)+"_data\\Com"+step2_P.getC_String(i));
	    f1.mkdir();
	   File f = new File("data\\Drivers_"+(d+1)+"_data\\Com"+step2_P.getC_String(i)+"\\"+"Per"+step2_P.getP_String(i));
	    f.mkdir();ds
	    */
	    FileWriter fw1 = new FileWriter(t+"\\Com"+step2_P.getC_String(i)+"\\"+"Per"+step2_P.getP_String(i)+"\\geton_getoff.txt");
	    fw1.write(String.valueOf(geton_getoff[i]));
	 	fw1.close();	
	 	FileWriter fw2 = new FileWriter(t+"\\Com"+step2_P.getC_String(i)+"\\"+"Per"+step2_P.getP_String(i)+"\\Car_capacity.txt");
		 fw2.write(String.valueOf(Car_capacity[i]));
		 fw2.close();	
	}
	}

}
