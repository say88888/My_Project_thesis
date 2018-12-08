package Make_Carpool_data;

import java.io.File;
import java.io.FileWriter;






import READ_TXT.Read_INPUT_TXT_filter;
import Enumeration.Enumeration;


public class make_PassengerBids extends Enumeration{

		public static	void makebids(int D,String[] C_string,String[] P_String)throws Exception {
			Read_INPUT_TXT_filter.loadData();

			int i=0,j = 0,k;
			int P_lengh=Read_INPUT_TXT_filter.getP();
			double[][] PassengerBids=new double[P_lengh][P_lengh+1];
			//-----------建立DriverDids.TXT檔--------------------
	    System.out.println("建立PassengerBids.TXT檔");
	    
	    for(i=0;i<P_lengh;i++){
	    	 for(j=0;j<P_lengh;j++){
	    		 if(i==j){PassengerBids[i][j]=Read_INPUT_TXT_filter.getseat(j);}
	    		 else{PassengerBids[i][j]=0;}
	    	 }
	    }
	    
	    for(i=0;i<P_lengh;i++)
	    {
	    	j=P_lengh;
	    	PassengerBids[i][j]=Read_INPUT_TXT_filter.getfph(i);
	    }
	    		 
	    String t="";
	    if(d>8)
    		t="GA_input\\Drivers_"+(d+1)+"_data";
    	else
    		t="GA_input\\Drivers_"+"0"+(d+1)+"_data";
	    for(i=0;i<D;i++){
	    /*	  File f11 = new File("GA_input\\Drivers_"+(d+1)+"_data\\Com"+C_string[i]);
	  	    f11.mkdir();
	  	 File f = new File("GA_input\\Drivers_"+(d+1)+"_data\\Com"+C_string[i]+"\\"+"Per"+P_String[i]);
	  	    f.mkdir();*/
	  	  FileWriter fw1 = new FileWriter(t+"\\Com"+C_string[i]+"\\"+"Per"+P_String[i]+"\\PassengerBids.txt");
	   for(j=0;j<P_lengh;j++){
		   for(k=0;k<P_lengh+1;k++){
			   if(k==P_lengh){
			   fw1.write(String.valueOf(PassengerBids[j][k])+" ");
		   }
		   else   fw1.write(String.valueOf((int)PassengerBids[j][k])+" ");
		   }
		   
	    fw1.write("\r\n");}
		fw1.close();
	    }
		}
		
		
	

}
