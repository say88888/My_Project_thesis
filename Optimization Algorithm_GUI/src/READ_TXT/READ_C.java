package READ_TXT;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Vector;

import Enumeration.Enumeration;

public class READ_C extends Enumeration{
	private static String[][] C;
	private static	int from[][];
	private static	int count=0;
	private static	int[] count1;
	private static String C_String[];
	
	public static void READ_C(  )throws Exception {
		 String str;
		 int k=0;
			//String Parameter1 [][]; //二維陣列
			Vector<String []> str_vec = new Vector<String []>(); //暫存
			try {
				FileReader PBr = new FileReader("matrix\\C.txt");
				BufferedReader br = new BufferedReader(PBr);
				while ((str = br.readLine()) != null) { //每次讀一行
					k++;
			str_vec.add(str.split("\\s")); //將此行以空白(white space)切成字串陣列, 存入 Vector暫存 
			}
			br.close(); //關檔
	 
			C = new String [str_vec.size()][]; 
			for (int i = 0; i < str_vec.size(); i++)
				C[i] = str_vec.elementAt(i);
		     } catch (Exception e) {
		 		e.printStackTrace();
				}
	
			    from = new int[C.length][ ];
			    C_String=new String[k];
			    for(int i=0;i<C.length;i++)
			    	from[i]=new int[C[i].length];
			   
				  int i,j;
				   for ( i = 0; i < C.length; i++) {
					   String result ="";
				    	for (j =0; j < C[i].length; j++) {
				    		from[i][j]=Integer.parseInt(C[i][j]);
				    		if(C[i].length>1){
				    		result+=C[i][j];}
				    	}
				    	C_String[i]=result;
				    }
				   
				  
	}
	
	public static int getC(int i,int j){
		return from[i][j];
	}

	public static int getC_high(){
		return from.length;
	}
	public static int getC_length(int i){
		return from[i].length;
	}
	public static String getC_String(int i){
		return C_String[i];
	}
	}


