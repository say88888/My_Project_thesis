package Generate_random_data;

import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;

import carpool_Alogorithm_MOD.Calculate_the_function;
import GUI.I_Set_Paths_for_Current_Simulation_Example;
import READ_TXT.Read_distance;

public class Generate_Data_of_Passengers_Randomly_multi_hop {
	private static double lat[];                      //緯度
	private static double lng[];                    //經度
	private static String location[];               //地點
	private static int P;                    //產生乘客人數
	private static int[] PTimeRandom=new int[10];                //時間參數值
	
	public static void Generate_Data_of_Passengers_Randomly() throws IOException{
		Read_distance.Read_distance();
		
		try {
			Read_Generate_random_multi_hop.main();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int i,k;
		k=Read_Generate_random_multi_hop.location_length();
		P= Read_Generate_random_multi_hop.P()+Read_Generate_random_multi_hop.No_of_Additional_Passengers();

		int random,random1,time=0,d=0,location1,location2;

		double P_distance;
		
		boolean a=false;
		
	//-----------------------定義乘客相關資料-------------------------
		   //乘客資料輸入   乘客四筆資料
	    int[] P_ID=new int[P];;                      int[] P_itinerary_ID=new int[P];;                          //乘客ID	  //乘客行程ID;
	    String[] P_F_R_Time=new String[P];        			 String[] P_D_R_Time=new String[P];;    			    //乘客提早搭車時間  //乘客延遲搭車時間						 	 
	    String[] P_F_A_Time=new String[P];         			 String[] P_D_A_Time=new String[P];;        			//乘客到達目的時間    //乘客延遲到達目的地時間
	    String[] P_R_PLACE=new String[P];      double[] P_R_LAT=new double[P];      //乘客搭車地點     //乘客搭車地點緯度
	    double[] P_R_LNG=new double[P];        String[] P_D_ADDRESS= new String[P]; //乘客搭車地點經度  //定義乘客目的地位置			              
	    double[] P_D_LAT=new double[P];		 double[] P_D_LNG=new double[P];      //乘客目的地經度   //乘客目的地緯度
	    double[] PassengerOilConsumptionBounds=new double[P];
	    double[] fph=new double[P]; //支付成本
		
	    int[] P_m=new int[P];
	    int[] P_n=new int[P];

		for(i=0;i<P;i++)
		{	
			
			PassengerOilConsumptionBounds[i]=(int)Calculate_the_function.random(Read_Generate_random_OilConsumptionBounds.PassengerOilConsumptionBounds(1)
				,Read_Generate_random_OilConsumptionBounds.PassengerOilConsumptionBounds(0));    //車子油耗量
		
			a=false;
			P_ID[i]=1000+i;    P_itinerary_ID[i]=(int) Calculate_the_function.random(1,10); 			 //乘客ID	  //乘客行程ID;
			P_F_R_Time[i]=Calculate_the_function.randomtime(Read_Generate_random_multi_hop.PTimeRandom(1),Read_Generate_random_multi_hop.PTimeRandom(0));      //乘客提早搭車時間
			P_D_R_Time[i]=Calculate_the_function.randomtime(Read_Generate_random_multi_hop.PTimeRandom(3),Read_Generate_random_multi_hop.PTimeRandom(2));     //乘客延遲搭車時間
			
			if(i > Read_Generate_random_multi_hop.P()){
			while(a!=true){
			random=(int) Calculate_the_function.random(0,k); 
			P_m[i]=random;
			P_R_LAT[i]=Read_Generate_random_multi_hop.lat(random);     P_R_LNG[i]=Read_Generate_random_multi_hop.lng(random);      //乘客搭車地點緯度        //乘客搭車地點經度
			random1=(int) Calculate_the_function.random(0,k); 
			P_n[i]=random1;
			P_D_LAT[i] =Read_Generate_random_multi_hop.lat(random1);          P_D_LNG[i]=Read_Generate_random_multi_hop.lng(random1);        //乘客目的地經度   //乘客目的地緯度
			time=(int) Read_distance.getDistancetime(P_m[i],P_n[i]);
			P_distance=Read_distance.getDistance(P_m[i], P_n[i]);
			
			if(time>40 && P_distance>Read_Generate_random_multi_hop.PassengerDistance()){a=true;}
			}
			}else {
				while(a!=true){
					random=(int) Calculate_the_function.random(0,k); 
					P_m[i]=random;
					P_R_LAT[i]=Read_Generate_random_multi_hop.lat(random);     P_R_LNG[i]=Read_Generate_random_multi_hop.lng(random);      //乘客搭車地點緯度        //乘客搭車地點經度
					random1=(int) Calculate_the_function.random(0,k); 
					P_n[i]=random1;
					P_D_LAT[i] =Read_Generate_random_multi_hop.lat(random1);          P_D_LNG[i]=Read_Generate_random_multi_hop.lng(random1);        //乘客目的地經度   //乘客目的地緯度
					time=(int) Read_distance.getDistancetime(P_m[i],P_n[i]);
					P_distance=Read_distance.getDistance(P_m[i], P_n[i]);
					
					if(time !=0 && P_distance>Read_Generate_random_multi_hop.No_of_Additional_Passengers()){a=true;}
			}
			}
			P_F_A_Time[i]=Calculate_the_function.randomtime((Read_Generate_random_multi_hop.PTimeRandom(3)+time),(Read_Generate_random_multi_hop.PTimeRandom(2)+time));     //乘客到達目的時間
			P_D_A_Time[i]=Calculate_the_function.randomtime((Read_Generate_random_multi_hop.PTimeRandom(3)+time+20),(Read_Generate_random_multi_hop.PTimeRandom(2)+time+20));     //乘客延遲到達目的地時間
			fph[i]=Calculate_the_function.Fph_cost(Read_distance.getDistance(P_m[i],P_n[i]),(int)PassengerOilConsumptionBounds[i],Read_Generate_random_OilConsumptionBounds.Passenger_OilPrice());
			
		}
		
		
		
				//-------------------passenger_calendar.txt----------------------
				FileWriter fw4 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path()+"\\SQL_input_random\\passenger_calendar");
				for(i=0;i<P;i++){
				fw4.write(String.valueOf(P_ID[i])+",");
				fw4.write(Calculate_the_function.randomtime(PTimeRandom[7]+20,PTimeRandom[6]+20)+",");
				fw4.write(Calculate_the_function.randomtime(PTimeRandom[7]+60,PTimeRandom[6]+60)+",");
				fw4.write(generateRandomString()+",");
				fw4.write(generateRandomString());
				fw4.write("\r\n");
				}
				fw4.close();
				//-------------------passenger_data.txt----------------------
				FileWriter fw5 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path()+"\\SQL_input_random\\passenger_data");
				for(i=0;i<P;i++){
				fw5.write(String.valueOf(P_ID[i])+",");
				fw5.write(generateRandomString()+",");fw5.write(generateRandomString()+",");
				fw5.write(generateRandomString()+",");fw5.write(generateRandomString()+",");
				fw5.write(generateRandomString()+",");fw5.write(generateRandomString()+",");
				fw5.write(generateRandomString()+",");fw5.write(generateRandomString()+",");
				fw5.write(generateRandomString()+",");fw5.write(generateRandomString()+",");
				fw5.write(String.valueOf(PassengerOilConsumptionBounds[i]));
				fw5.write("\r\n");
				}
				fw5.close();
				//-----------------passenger_initial itinerary---------------------------
				FileWriter fw6 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path()+"\\SQL_input_random\\Original_passenger_initial_itinerary");
				for(i=0;i<P;i++){
				fw6.write(String.valueOf(P_ID[i])+",");                        //乘客ID	 
				fw6.write(String.valueOf(P_itinerary_ID[i])+",");              //乘客行程ID;
				fw6.write(P_F_R_Time[i]+","); fw6.write(P_D_R_Time[i]+",");    //乘客提早搭車時間         //乘客延遲搭車時間
				fw6.write(P_F_A_Time[i]+","); fw6.write(P_D_A_Time[i]+",");    //乘客到達目的時間        //乘客延遲到達目的地時間
				fw6.write(String.valueOf(P_R_LAT[i])+","); fw6.write(String.valueOf(P_R_LNG[i])+",");  //乘客搭車地點緯度        //乘客搭車地點經度     
				fw6.write(String.valueOf(P_m[i])+",");                                    //乘客搭車地點
				fw6.write(String.valueOf(P_D_LAT[i])+","); fw6.write(String.valueOf(P_D_LNG[i])+",");  //乘客目的地經度   //乘客目的地緯度
				fw6.write(String.valueOf(P_n[i])+",");        //定義乘客目的地位置
				fw6.write(String.valueOf(fph[i])+",");     //成本
				fw6.write(String.valueOf((int)Calculate_the_function.random(1,2))+",");     
				fw6.write(String.valueOf((int)Calculate_the_function.random(50,120)));     
				fw6.write("\r\n");
				}
				fw6.close();
	}
	
	//--產生隨機字串----------------------
	public static String generateRandomString() {
	    int wordLength = (int)(Math.random()*4+1);
	    char[] word = new char[wordLength];
	    for (int i=0; i<wordLength; ++i) {
	        word[i] = (char)(Math.random()*('z'-'a'+1)+'a'); // 產生隨機字元 a~z
	    }
	    return new String(word);
	}
	
}
