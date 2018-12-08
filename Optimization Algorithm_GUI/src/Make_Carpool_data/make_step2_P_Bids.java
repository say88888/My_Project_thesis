package Make_Carpool_data;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import carpool_Alogorithm_MOD.Calculate_the_function;
import READ_TXT.Read_INPUT_TXT_filter;
import READ_TXT.Read_distance;
import Enumeration.Enumeration;
import Generate_random_data.Read_Generate_random_OilConsumptionBounds;

public class make_step2_P_Bids extends Enumeration{
	private static int P1;
	private static int P2;
	private static int P;
	private static int D;
	public static  void make_data(String[] C_String,String[] P_String,int P_high,int[][] PX,int[] PX_lengh) throws Exception{
		Read_distance.Read_distance();	
		Read_INPUT_TXT_filter.loadData();
		Read_Generate_random_OilConsumptionBounds.main();
		P = Read_INPUT_TXT_filter.getP();
		D = Read_INPUT_TXT_filter.getD();
					// 定義投標資料-----------------------------------------------
		P1=P_high;
		P2=PX_lengh[P1-1];
		
		double[] Dcost = new double[P1];                             // 司機成本
		double[][] DriverBids=new double[P1+1][(P*2)+4];      //定義投標矩陣
		double[] Fdj=new double[P1];
		double route = 0;
		
		int i,j,k,l,m;
		int location1,location2;
		int qdjk=0;
		for( i=0;i<P_high;i++){
			route=0;
			location1=Integer.parseInt(Read_INPUT_TXT_filter.getD_S_PLACE(d));
					
			for(j=0;j<PX_lengh[i];j++){
			if(PX[i][j]>0)
			{
				k=PX[i][j];
				location2=Integer.parseInt(Read_INPUT_TXT_filter.getP_R_PLACE(k-1));
				route+=Read_distance.getDistance(location1,location2);
				location1=location2;
				qdjk++;
			}
			else if(PX[i][j]<0)
			{
				k=-(PX[i][j]);
				location2=Integer.parseInt(Read_INPUT_TXT_filter.getP_D_ADDRESS(k-1));
				route+=Read_distance.getDistance(location1,location2);
				location1=location2;
			}
			}
			location2=Integer.parseInt(Read_INPUT_TXT_filter.getD_D_ADDRESS(d));
			route+=Read_distance.getDistance(location1,location2);
			Dcost[i]=Calculate_the_function.Cdj_cost(route,Read_INPUT_TXT_filter.getDriverOilConsumption(d),Read_Generate_random_OilConsumptionBounds.Driver_OilPrice(),"Single_mode",qdjk);
		}
		
		for(i=0;i<P_high;i++){
			
			for(j=0;j<PX_lengh[i]+1;j++)
			{
				if(PX[i][j]>0)
				{
					k=(PX[i][j]-1);
					for(l=0;l<P;l++){
						if(l==k){DriverBids[i][l]=Read_INPUT_TXT_filter.getseat(k);}
					}
				}
			}
			
			for(l=0;l<P;l++){
				if(DriverBids[i][l]<=0){DriverBids[i][l]=0;}
			}
			
			DriverBids[i][P]=Dcost[i];
		 	System.err.println("OK1   "+DriverBids[i][P]);
		 	double obj=Calculate_the_function.Odj_cost(Read_distance.getDistance(Integer.parseInt(Read_INPUT_TXT_filter.getD_S_PLACE(d)),
		 			Integer.parseInt(Read_INPUT_TXT_filter.getD_D_ADDRESS(d))),Read_INPUT_TXT_filter.getDriverOilConsumption(d),Read_Generate_random_OilConsumptionBounds.Driver_OilPrice());
		   	
		 	DriverBids[i][P+1]=obj;
			DriverBids[i][P+2]=Read_INPUT_TXT_filter.getP_NUMBER(d);
			
			Fdj[i]=Fdj(PX[i],PX_lengh,i,obj,Dcost[i]);
			
					for(m=0;m<P;m++)
			    		if(DriverBids[i][m]==1)
			    		{DriverBids[i][P+3+m]=Read_INPUT_TXT_filter.getweight(m);}
					
			    	DriverBids[i][(P*2)+3]=Read_INPUT_TXT_filter.getWeight_Limit(d);
			    	String t="";
			    	if(d>8)
			    		t="data\\Drivers_"+(d+1)+"_data";
			    	else
			    		t="data\\Drivers_"+"0"+(d+1)+"_data";
			    	File f2 = new File(t);
				    f2.mkdir();
			    	File f1 = new File(t+"\\Com"+C_String[i]);
				    f1.mkdir();
				   File f = new File(t+"\\Com"+C_String[i]+"\\"+"Per"+P_String[i]);
				    f.mkdir();
				    FileWriter fw1 = new FileWriter(t+"\\Com"+C_String[i]+"\\"+"Per"+P_String[i]+"\\DriverBids.txt");
				    for(j=0;j<P*2+4;j++){
				    	if(j==P  || j==P+1){
				    	fw1.write(String.valueOf(DriverBids[i][j])+" ");
				    	}
				    	else fw1.write(String.valueOf((int)DriverBids[i][j])+" ");
				    }
				     fw1.write("\r\n");
				 	fw1.close();	
				 	
				    FileWriter fw2 = new FileWriter(t+"\\Com"+C_String[i]+"\\"+"Per"+P_String[i]+"\\DriverBidsFdj.txt");				    
				    fw2.write(Fdj[i]+"\r\n");
				 	fw2.close();	
			}
		
	}
	
	
	public static double Fdj(int[] PX, int[] PX_lengh,int i ,double obj,double  Dcost){
		NumberFormat nf = NumberFormat.getInstance();
			nf.setMaximumFractionDigits(3);		
		
			double Yph,Fdj,Tpm,Tdm;
			
				Yph=0; Fdj=0;Tpm=0;Tdm=0;
				
				for(int j=0;j<PX_lengh[i]+1;j++)
				{
					if(PX[j]>0)
					{
						Yph+=Read_INPUT_TXT_filter.getfph(PX[j]-1);
					}
				}
				
				Fdj=Yph+obj-Dcost+(Yph*Tpm)+(Dcost*Tdm);
		return Fdj;
	}
}
