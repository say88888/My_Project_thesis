package Generate_random_data;

import java.text.ParseException;

import carpool_Alogorithm_MOD.TimeCalculate;
import READ_TXT.Read_INPUT_TXT;
import READ_TXT.Read_distance;

public class time_limit {

	public static Boolean main(int[] Order,int length,int d) throws Exception {
		// TODO Auto-generated method stub
		Boolean Time=true;
		Read_INPUT_TXT.loadData();
		
	int j=0,m=0;

	for(int i=0;i<length;i++){System.out.print(" Order=  "+Order[i]);}
		System.out.println();
		
		// 宣告c1為TimeCalculate類別物件
		TimeCalculate c1 = new TimeCalculate();
		int l=0;
		String Driving_time = Read_INPUT_TXT.getD_F_D_Time(d);
		int Delay_time;
		int location1,location2;
		
		location1=Integer.parseInt(Read_INPUT_TXT.getD_S_PLACE(d));
		
		 for(j=0;j<length;j++){
			 
			 if(c1.time(Driving_time,Read_INPUT_TXT.getD_S_A_Time(d))==true)
			 {
			 if(Order[j]>0){
				location2=Order[j];
				Delay_time=(int)(Read_distance.getDistancetime(location1,location2));
				Driving_time=c1.Addtime(Driving_time,Delay_time);
				location1=location2;
				m++;
					}
			 }
			 else{Time=false; break;}
		 }
		 
		 location2=Integer.parseInt(Read_INPUT_TXT.getD_D_ADDRESS(d));
		 Delay_time=(int)(Read_distance.getDistancetime(location1,location2));
		 Driving_time=c1.Addtime(Driving_time,Delay_time);
	
		 System.out.println("Driving_time "+Driving_time +" getD_S_A_Time  "+Read_INPUT_TXT.getD_S_A_Time(d));
		
		 if(c1.time(Driving_time,Read_INPUT_TXT.getD_S_A_Time(0))==true && Time==true){Time=true;}
		 else{Time=false;}
		 
		 System.out.println(" Time 為 True 或 false   "+ Time);
		 System.out.println(" ----------------------------------------- ");
		return Time;
	}
}
