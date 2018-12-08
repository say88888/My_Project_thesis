package Enumeration;

import java.io.File;
import java.io.FileWriter;

import carpool_Alogorithm_MOD.TimeCalculate;
import READ_TXT.Read_INPUT_TXT_filter;
import READ_TXT.Read_distance;
import READ_TXT.READ_P;


public class step4_select_time extends Enumeration{
	private static int[][] PX;                 //初始P 順序矩陣
	private static String[][] PT;                 //初始P  時間矩陣	
	private static int P;
	private static int D;
	private static int P_high;
	private static int P_length;
	private static boolean[] time_restraint;
	public static void main() throws Exception {
	Read_INPUT_TXT_filter.loadData();
	READ_P.READ_P(); 
	
	P = Read_INPUT_TXT_filter.getP();
	D = Read_INPUT_TXT_filter.getD();
	P_high=READ_P.getP_high();
	P_length=READ_P.getP_length(P_high-1);
	time_restraint=new boolean[P_high];
	
	 int i,j,k=0;
		PX = new int[P_high][];
		PT = new String[P_high][];
	 for (i = 0; i < READ_P.getP_high(); i++){
			PX[i] = new int[READ_P.getP_length(i)];
			PT [i] = new String[READ_P.getP_length(i)];
	 }
		for (i = 0; i < PX.length; i++)
			for (j = 0; j < PX[i].length; j++) 
				PX[i][j] = READ_P.getP(i, j);
			
		
	 for(i=0;i<P_high;i++){
		 for(j=0;j<PX[i].length;j++){
			 if(PX[i][j]>0){
				 k=PX[i][j]-1;
				 PT[i][j]=Read_INPUT_TXT_filter.getP_F_R_Time(k);           //乘客提早搭車時間
			 }
			 if(PX[i][j]<0){
				 k=-(PX[i][j])-1;
				 PT[i][j]=Read_INPUT_TXT_filter.getP_D_A_Time(k);         //乘客最晚下車時間
			 }
		 }
	 }
			 
		// 宣告c1為TimeCalculate類別物件
		TimeCalculate c1 = new TimeCalculate();
		int l=0,m=0;
		String Driving_time;
		int Delay_time;
		int location1,location2;
	 for(i=0;i<P_high;i++){
		 l=0; k=0; 
		 Driving_time=Read_INPUT_TXT_filter.getD_F_D_Time(d);
		 Delay_time=0; m=0;
		 location1=Integer.parseInt(Read_INPUT_TXT_filter.getD_S_PLACE(d));
		 for(j=0;j<PX[i].length;j++){
			 if(PX[i][j]>0){
				 k=PX[i][j];
				 if(c1.time(Driving_time,PT[i][j])==true)
						 {
					 location2=Integer.parseInt(Read_INPUT_TXT_filter.getP_R_PLACE(k-1));
					 Delay_time=(int)(c1.reducetime(Driving_time,PT[i][j])-Read_distance.getDistancetime(location1,location2));
					 Driving_time=c1.Addtime(PT[i][j],Delay_time);
					 location1=location2;
					 m++;
						 }
			 }
			 else if(PX[i][j]<0){
				 k=-PX[i][j];
				 if(c1.time(Driving_time,PT[i][j])==true)
				 {
					 location2=Integer.parseInt(Read_INPUT_TXT_filter.getP_D_ADDRESS(k-1));
					 Delay_time=(int)(c1.reducetime(Driving_time,PT[i][j])-Read_distance.getDistancetime(location1,location2));
					 Driving_time=c1.Addtime(PT[i][j],Delay_time);
					 location1=location2;
					 m++;
				 }
			 }
		 }
		 
		 if(c1.time(Driving_time,Read_INPUT_TXT_filter.getD_S_A_Time(d))==true){
				 m++;
		 }
		 if(m>PX[i].length){time_restraint[i]=true;}
		 else if(m<=PX[i].length){time_restraint[i]=false;}
		 }
	 String t="";
 	if(d>8)
 		t="data\\Drivers_"+(d+1)+"_data";
 	else
 		t="data\\Drivers_"+"0"+(d+1)+"_data";
	 for(i=0;i<P_high;i++){
		    FileWriter fw1 = new FileWriter(t+"\\Com"+step2_P.getC_String(i)+"\\"+"Per"+step2_P.getP_String(i)+"\\time_restraint.txt");
		    fw1.write(String.valueOf(time_restraint[i]));
		 	fw1.close();	
		} 
	}
}
