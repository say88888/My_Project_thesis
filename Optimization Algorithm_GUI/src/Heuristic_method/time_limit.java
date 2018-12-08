package Heuristic_method;

import java.text.ParseException;

import carpool_Alogorithm_MOD.TimeCalculate;
import READ_TXT.Read_INPUT_TXT_filter;
import READ_TXT.Read_distance;

public class time_limit  extends step2_1{

	public static Boolean main(int[] Order,int length) throws Exception {
		// TODO Auto-generated method stub
		boolean Time=true;
		String[] PT = null;
	
	PT=new String[length];
	
	int j=0,m;
	
	for(int i=0;i<length;i++){System.out.print(" Order"+Order[i]);}
	System.out.println();
	
		for(int i=0;i<length;i++){
			 if(Order[i]>0){
				 m=Order[i]-1;
				 PT[i]=Read_INPUT_TXT_filter.getP_F_R_Time(m);           //乘客提早搭車時間
			 }
			 if(Order[i]<0){
				 m=-(Order[i])-1;
				 PT[i]=Read_INPUT_TXT_filter.getP_D_A_Time(m);         //乘客最晚下車時間
			 }
		 }
		
		for(int i=0;i<length;i++){System.out.print(" Order=  "+Order[i]+ " PT=  "+PT[i]);}
		System.out.println();
		
		// 宣告c1為TimeCalculate類別物件
		TimeCalculate c1 = new TimeCalculate();
		int l=0;
		String Driving_time;
		int Delay_time;
		int location1,location2;
		int k=0;
		
		 Driving_time=Read_INPUT_TXT_filter.getD_F_D_Time(d);
		 Delay_time=0; m=0;
		 location1=Integer.parseInt(Read_INPUT_TXT_filter.getD_S_PLACE(d));
		 
		 for(j=0;j<length;j++){
			 if(c1.time(Driving_time,PT[j])==true)
			 {
			 if(Order[j]>0){
				 k=Order[j];
					 System.out.println("Time1" + PT[j]);
					 location2=Integer.parseInt(Read_INPUT_TXT_filter.getP_R_PLACE(k-1));
					 Delay_time=(int)(c1.reducetime(Driving_time,PT[j])-Read_distance.getDistancetime(location1,location2));
					 Driving_time=c1.Addtime(PT[j],Delay_time);
					 location1=location2;
					 m++;
						 }
			 
			 else if(Order[j]<0){
					 k=-Order[j];
					 System.out.println("Time2" + PT[j]);
					 location2=Integer.parseInt(Read_INPUT_TXT_filter.getP_D_ADDRESS(k-1));
					 Delay_time=(int)(c1.reducetime(Driving_time,PT[j])-Read_distance.getDistancetime(location1,location2));
					 Driving_time=c1.Addtime(PT[j],Delay_time);
					 location1=location2;
					 m++; 
			 }
			 }
			 else{Time=false; break;}
		 }
		 
		 System.out.println("  Driving_time "+Driving_time +" getD_S_A_Time  "+Read_INPUT_TXT_filter.getD_S_A_Time(d));
		
		 if(c1.time(Driving_time,Read_INPUT_TXT_filter.getD_S_A_Time(d))==true && Time==true){Time=true;}
		 else{Time=false;}
		 
		 
		 System.out.println(" Time 為 True 或 false   "+ Time);
		 System.out.println(" ----------------------------------------- ");
		return Time;
	}
}
