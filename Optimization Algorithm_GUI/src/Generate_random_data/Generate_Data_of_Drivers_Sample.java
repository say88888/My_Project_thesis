package Generate_random_data;

import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import carpool_Alogorithm_MOD.Calculate_the_function;
import GUI.I_Set_Paths_for_Current_Simulation_Example;
import READ_TXT.Read_distance;

public class Generate_Data_of_Drivers_Sample {
	private static double lat[];                      //緯度
	private static double lng[];                    //經度
	private static String location[];               //地點
	private static int P;                    //產生乘客人數
	private static int D;                   //產生司機人數
	
	private static int[] DTimeRandom=new int[10];                //時間參數值
	private static int[] PTimeRandom=new int[10];                //時間參數值
	private static int[] DisplacemeRandom=new int[10];           //油耗參數值
	
	public	static void Generate_Data_of_Drivers_Sample() throws IOException
	{
		Read_distance.Read_distance();
		try {
			Read_Generate_random.main();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Read_Generate_random_OilConsumptionBounds.main();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int i,j,k;
		k=Read_Generate_random.location_length();
		D= Read_Generate_random.D();
	    int[] D_m=new int[D];
	    int[] D_n=new int[D];
	    
	    int[] have_place=new int[D];
	    int[] have_place1=new int[D];
	    
		int random,random1,time=0;
		boolean a=false;
		//------------------------定義司機相關資料------------------------
		int[] D_ID=new int[D];		 int[] D_itinerary_ID=new int[D]; 			    //司機 ID  //司機行程ID;
		String[] D_F_D_Time=new String[D];     String[] D_S_D_Time=new String[D];   //司機提早發車時間  //司機延遲發車時間
		String[] D_F_A_Time=new String[D];     String[] D_S_A_Time=new String[D];   //司機到達目的地時間    //司機延遲到達目的地時間
		String[] D_S_PLACE=new String[D];      double[] D_S_LAT =new double[D];     //司機發車地點      //司機發車地點緯度
		double[] D_S_LNG =new double[D];       String[] D_D_ADDRESS=new String[D];  //司機發車地點經度  //定義司機目的地位置
		double[]  D_D_LAT =new double[D];      double[] D_D_LNG =new double[D];     //司機目的地緯度       //司機目的地經度
	    int[] D_NUMBER=new int[D];             double[] DriverOilConsumption=new double[D]; //可搭乘人數  //車子油耗量
	    
		for(i=0;i<D;i++)
		{
			a=false;
			D_ID[i]=2000+i;		D_itinerary_ID[i]=(int) Calculate_the_function.random(1,10); 			    //司機 ID  //司機行程ID;
			
			D_F_D_Time[i]=Calculate_the_function.randomtime(Read_Generate_random.DTimeRandon(1),Read_Generate_random.DTimeRandon(0));    //司機提早發車時間
			D_S_D_Time[i]=Calculate_the_function.randomtime(Read_Generate_random.DTimeRandon(3),Read_Generate_random.DTimeRandon(2));      //司機延遲發車時間
			
			while(a!=true){
				
			random=(int) Calculate_the_function.random(0,k); 
			D_m[i]=random; 
			D_S_LAT[i]=Read_Generate_random.lat(random);     D_S_LNG[i]=Read_Generate_random.lng(random);   //司機發車地點緯度        //司機發車地點經度     
			random1=(int)Calculate_the_function.random(0,k);
			D_n[i]=random1;
			D_D_LAT[i]=Read_Generate_random.lat(random1);    D_D_LNG[i]=Read_Generate_random.lng(random1);    //司機目的地緯度       //司機目的地經度
			
		
			time=(int) Read_distance.getDistancetime(D_m[i],D_n[i]);
			if(time>30){a=true;}
			
			
			for(j=0;j<i;j++){if(Read_distance.getDistance(have_place[j],D_m[i])<Read_Generate_random.DriversDistance() || 
					Read_distance.getDistance(have_place1[j],D_n[i])<Read_Generate_random.DriversDistance()	|| 	
					have_place1[j]==D_n[i] || have_place[j]==D_m[i])
				{a=false; break;}}
			
			}
			
			have_place[i]=D_m[i];
			have_place1[i]=D_n[i];
		
			
			time=(int) Read_distance.getDistancetime(D_m[i],D_n[i]);
			D_F_A_Time[i]=Calculate_the_function.randomtime((Read_Generate_random.DTimeRandon(1)+time+30),(Read_Generate_random.DTimeRandon(0)+time+40));    //司機到達目的地時間
			D_S_A_Time[i]=Calculate_the_function.randomtime((Read_Generate_random.DTimeRandon(3)+time+40),(Read_Generate_random.DTimeRandon(2)+time+50));    //司機延遲到達目的地時間
			
			D_NUMBER[i]=(int)Calculate_the_function.random(Read_Generate_random.Seats_Upper(),Read_Generate_random.Seats_Lower());  //可搭乘人數
			DriverOilConsumption[i]=(int)Calculate_the_function.random(Read_Generate_random_OilConsumptionBounds.DriverOilConsumptionBounds(1)
					,Read_Generate_random_OilConsumptionBounds.DriverOilConsumptionBounds(0));    //車子油耗量
		  
		}
			//----------------編寫TXT檔------------------------------------------
			String cal = "00:00:00";
					//-------------cardata.txt---------------------------------------
					FileWriter fw2 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path()+"\\SQL_input_random\\car_data");
					for(i=0;i<D;i++){
					fw2.write(String.valueOf(D_ID[i])+",");
					fw2.write(generateRandomString()+",");
					fw2.write( D_NUMBER[i]+",");
					fw2.write(String.valueOf(DriverOilConsumption[i])+",");
					fw2.write(String.valueOf((int)Calculate_the_function.random(20000,0))+",");
					fw2.write(String.valueOf((int)Calculate_the_function.random(0,10))+",");
					fw2.write(generateRandomString()+",");
					fw2.write(String.valueOf((int)Calculate_the_function.random(250,500)));
					fw2.write("\r\n");
					}
					fw2.close();
					//-------------driver_calendar.txt---------------------------------------
					FileWriter fw = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path()+"\\SQL_input_random\\driver_calendar");
					for(i=0;i<D;i++){
					fw.write(Calculate_the_function.randomtime(DTimeRandom[7]+20,DTimeRandom[6]+20)+",");
					fw.write(Calculate_the_function.randomtime(DTimeRandom[7]+60,DTimeRandom[6]+60)+",");
					fw.write(D_NUMBER[i]+",");
					fw.write(generateRandomString()+",");
					fw.write(generateRandomString());
					fw.write("\r\n");
					}
					fw.close();
					//-------------driver_data.txt-------------------------------------------
					FileWriter fw1 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path()+"\\SQL_input_random\\driver_data");
					for(i=0;i<D;i++){
					fw1.write(String.valueOf(D_ID[i])+",");
					fw1.write(generateRandomString()+",");fw1.write(generateRandomString()+",");
					fw1.write(generateRandomString()+",");fw1.write(generateRandomString()+",");
					fw1.write(generateRandomString()+",");fw1.write(generateRandomString()+",");
					fw1.write(generateRandomString()+",");fw1.write(generateRandomString()+",");
					fw1.write(generateRandomString()+",");fw1.write(generateRandomString());
					fw1.write("\r\n");
					}
					fw1.close();
					
					//----------------------------driver_initial itinerary.txt---------------------
					FileWriter fw11 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path()+"\\SQL_input_random\\driver_initial_itinerary");
					for(i=0;i<D;i++){
					fw11.write(String.valueOf(D_ID[i])+",");
					fw11.write(String.valueOf(D_itinerary_ID[i])+",");
					fw11.write(D_F_D_Time[i]+","); fw11.write(D_S_D_Time[i]+",");
					fw11.write(D_F_A_Time[i]+","); fw11.write(D_S_A_Time[i]+",");			
					fw11.write(String.valueOf(D_S_LAT[i])+","); fw11.write(String.valueOf(D_S_LNG[i])+",");
					fw11.write(String.valueOf(D_m[i])+",");
					fw11.write(String.valueOf(D_D_LAT[i])+","); fw11.write(String.valueOf(D_D_LNG[i])+",");
					fw11.write(String.valueOf(D_n[i])+",");
					fw11.write(cal);
					fw11.write("\r\n");
					}
					fw11.close();
		
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
