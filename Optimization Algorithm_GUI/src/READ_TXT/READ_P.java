package READ_TXT;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public class READ_P {
	private static String[][] P;
	private static	int from[][];
	private static	int count=0;
	private static	int count1=0;
	private static String P_String[];
	 public static void READ_P() throws Exception {
		 String str;
		 int k=0;
			//String Parameter1 [][]; //二維陣列
			Vector<String []> str_vec = new Vector<String []>(); //暫存
			try {
				FileReader PBr = new FileReader("matrix\\P.txt");
				BufferedReader br = new BufferedReader(PBr);
				while ((str = br.readLine()) != null) { //每次讀一行
					k++;
			str_vec.add(str.split("\\s")); //將此行以空白(white space)切成字串陣列, 存入 Vector暫存 
			}
			br.close(); //關檔
			P = new String [str_vec.size()][]; 
			for (int i = 0; i < str_vec.size(); i++)
				P[i] = str_vec.elementAt(i);
		     } catch (Exception e) {
		 		e.printStackTrace();
				}
			  int i,j;
			   
			    from = new int[k][100];
			    P_String=new String[k];
			    for(i=0;i<P.length;i++)
			    	from[i]=new int[P[i].length];
			 
				   for ( i = 0; i < P.length; i++) {
					   String result = "";
					   for (j =0; j < P[i].length; j++) {
						
						   if((j+1)>=P[i].length){ result+=P[i][j];}
						   else  if(j+1<P[i].length){result+=P[i][j]+"_";}
				    		
						   from[i][j]=Integer.parseInt(P[i][j]);
				    		count1=P[i].length;
				    	
				    	}
					   P_String[i]=result;
				    	count++;
				    	}
				   
				  
	}
	
	public static int getP(int i,int j){
		return from[i][j];
	}
	public static int getP_high(){
		return from.length;
	}
	public static int getP_length(int i){
		return from[i].length;
	}
	public static String getP_String(int i){
		return P_String[i];
	}
	}


