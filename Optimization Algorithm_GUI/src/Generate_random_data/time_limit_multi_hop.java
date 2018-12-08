package Generate_random_data;

import java.text.ParseException;

import carpool_Alogorithm_MOD.TimeCalculate;
import READ_TXT.Read_INPUT_TXT;
import READ_TXT.Read_distance;

public class time_limit_multi_hop {

	public static Boolean main(int[] Order,int length,int p) throws Exception {
		// TODO Auto-generated method stub
		Boolean Time=true;
		Read_INPUT_TXT_Original_passenger_initial_itinerary.loadData();
		
	int j=0,m=0;

	for(int i=0;i<length;i++){System.out.print(" Order=  "+Order[i]);}
		System.out.println();
		
		// 宣告c1為TimeCalculate類別物件
		TimeCalculate c1 = new TimeCalculate();
		String Driving_time = Read_INPUT_TXT_Original_passenger_initial_itinerary.getP_F_R_Time(p);
		int Delay_time;
		int location1,location2;
		
		location1=Integer.parseInt(Read_INPUT_TXT_Original_passenger_initial_itinerary.getP_R_PLACE(p));
		
		 for(j=0;j<length;j++){
			 
			 if(c1.time(Driving_time,Read_INPUT_TXT_Original_passenger_initial_itinerary.getP_D_A_Time(p))==true)
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
		 
		 location2=Integer.parseInt(Read_INPUT_TXT_Original_passenger_initial_itinerary.getP_D_ADDRESS(p));
		 Delay_time=(int)(Read_distance.getDistancetime(location1,location2));
		 Driving_time=c1.Addtime(Driving_time,Delay_time);
	
		 System.out.println("Driving_time "+Driving_time +" getP_D_A_Time  "+Read_INPUT_TXT_Original_passenger_initial_itinerary.getP_D_A_Time(p));
		
		 if(c1.time(Driving_time,Read_INPUT_TXT_Original_passenger_initial_itinerary.getP_D_A_Time(p))==true && Time==true){Time=true;}
		 else{Time=false;}
		 
		 System.out.println(" Time 為 True 或 false   "+ Time);
		 System.out.println(" ----------------------------------------- ");
		return Time;
	}
}
