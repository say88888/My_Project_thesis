package Make_Carpool_data;

import java.io.File;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import carpool_Alogorithm_MOD.Calculate_the_function;
import READ_TXT.Read_INPUT_TXT_filter;
import READ_TXT.Read_distance;
import Enumeration.Enumeration;
import Enumeration.step2_P;
import Generate_random_data.Read_Generate_random_OilConsumptionBounds;


public class make_DriverBids extends Enumeration{
	
	public static	void makebids(int P_high,int[][] PX,double[] Dcost,String[] C_string,String[] P_String)throws Exception {
		
		Read_INPUT_TXT_filter.loadData();
		Read_Generate_random_OilConsumptionBounds.main();
		int i,j,k;
		int P_lengh=
				Read_INPUT_TXT_filter.getP();
		double[] DriverBids=new double[P_lengh*2+4];
		//-----------建立DriverDids.TXT檔--------------------
		File f1 = new File("GA_input");
	    f1.mkdir();
	    String t="";
	    if(d>8)
    		t="GA_input\\Drivers_"+(d+1)+"_data";
    	else
    		t="GA_input\\Drivers_"+"0"+(d+1)+"_data";
	    File f2 = new File(t);
	    f2.mkdir();
    	
    System.out.println("建立DriverBids.TXT檔");
    
    for( i=0;i<P_high;i++){  
    	for(k=0;k<DriverBids.length;k++)
    		DriverBids[k]=0;
    	
    	for(j=0;j<PX[i].length;j++){
    		if(PX[i][j]>0)
    		{
    			k=PX[i][j]-1;
    			DriverBids[k]=Read_INPUT_TXT_filter.getseat(k);
    		}
    	}
    	
    	for(k=0;k<P_lengh;k++)
    		if(DriverBids[k]<=0){DriverBids[k]=0;}
    	
    	DriverBids[P_lengh]=Dcost[i];
    	System.err.println("OK2    "+DriverBids[P_lengh]);
    		
    	DriverBids[P_lengh+1]=Calculate_the_function.Odj_cost(Read_distance.getDistance(Integer.parseInt(Read_INPUT_TXT_filter.getD_S_PLACE(d)),
    			Integer.parseInt(Read_INPUT_TXT_filter.getD_D_ADDRESS(d))),Read_INPUT_TXT_filter.getDriverOilConsumption(d),Read_Generate_random_OilConsumptionBounds.Driver_OilPrice());
        
    	
    	
    	DriverBids[P_lengh+2]=Read_INPUT_TXT_filter.getP_NUMBER(d);
    	
    	
    	for(k=0;k<P_lengh;k++)
    		if(DriverBids[k]==1){DriverBids[P_lengh+3+k]=Read_INPUT_TXT_filter.getweight(k);}
    	
    	DriverBids[P_lengh*2+3]=Read_INPUT_TXT_filter.getWeight_Limit(d);
    		
    
    	File f3 = new File(t+"\\Com"+C_string[i]);
	    f3.mkdir();
	   File f4 = new File(t+"\\Com"+C_string[i]+"\\"+"Per"+P_String[i]);
	    f4.mkdir();
    	
 
 
   FileWriter fw1 = new FileWriter(t+"\\Com"+C_string[i]+"\\"+"Per"+P_String[i]+"\\DriverBids.txt");
   for(k=0;k<P_lengh*2+4;k++){
	  if(k==P_lengh || k==P_lengh+1){
	   fw1.write(String.valueOf(DriverBids[k])+" ");
	  }
	  else   fw1.write(String.valueOf((int)DriverBids[k])+" ");
   }
    fw1.write("\r\n");
	fw1.close();
    }
    }
	
}
