package Generate_random_data;

import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import carpool_Alogorithm_MOD.Calculate_the_function;
import carpool_Alogorithm_MOD.TimeCalculate;
import GUI.I_Set_Paths_for_Current_Simulation_Example;
import READ_TXT.Read_INPUT_TXT;
import READ_TXT.Read_distance;

public class Generate_Data_of_Passengers_Randomly_many_to_many {
	private static double lat[];                      //緯度
	private static double lng[];                    //經度
	private static String location[];               //地點
	private static int P;                    //產生乘客人數
	private static int D;                   //產生司機人數
	
	private static int[] PTimeRandom=new int[10];                //時間參數值
	
	private static int[] DSeat;                  //司機發車時間

	public static void Generate_Data_of_Passengers_Randomly_many_to_many( int N,int M) throws Exception{

		Read_distance.Read_distance();
		Read_INPUT_TXT.loadData();

		
		try {
			Read_Generate_random.main();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		int K=Read_Generate_random.location_length();
		P= Read_Generate_random.P();
		D= Read_Generate_random.D();

		DSeat=new int[D];
		
		for(int i=0;i<D;i++){DSeat[i]=Read_INPUT_TXT.getP_NUMBER(i);}
		

	//-----------------------定義乘客相關資料-------------------------
		   //乘客資料輸入   乘客四筆資料
	    int[] P_ID=new int[P];                      int[] P_itinerary_ID=new int[P];                                              //乘客ID	  //乘客行程ID;
	    String[][] P_F_R_Time=new String[P][M];        			 String[][] P_D_R_Time=new String[P][M];    			    //乘客提早搭車時間  //乘客延遲搭車時間						 	 
	    String[][] P_F_A_Time=new String[P][M];         			 String[][] P_D_A_Time=new String[P][M];   //乘客到達目的時間    //乘客延遲到達目的地時間
	    String[][] P_R_PLACE=new String[P][M];      double[][] P_R_LAT=new double[P][M];                                //乘客搭車地點     //乘客搭車地點緯度
	    double[][] P_R_LNG=new double[P][M];        String[][] P_D_ADDRESS= new String[P][M];              //乘客搭車地點經度  //定義乘客目的地位置			              
	    double[][] P_D_LAT=new double[P][M];		 double[][] P_D_LNG=new double[P][M];         //乘客目的地經度   //乘客目的地緯度
	    double[] PassengerOilConsumptionBounds=new double[P];
	    double[][] fph=new double[P][M]; //支付成本
		
	    int[][] P_m=new int[P][M];
	    int[][]P_n=new int[P][M];

		int[] n1=new int [P];
		
		int random,random1,time=0,d=0,location1,location2;
		double P_distance,D_distance,Route;
		boolean a=false,b=false,c=false; 
		
		d=0;
		
		for(int i=0;i<P;i++){n1[i]=(int)Calculate_the_function.random(N,M+1);}
		
		TimeCalculate c1 = new TimeCalculate();
		
		for(int i=0;i<P;i++)
		{
			P_ID[i]=1000+i;    P_itinerary_ID[i]=(int) Calculate_the_function.random(1,10); 			 //乘客ID	  //乘客行程ID;
			
			if(d>D-1){d=0;}
			location1=Integer.parseInt(Read_INPUT_TXT.getD_S_PLACE(d));
			location2=Integer.parseInt(Read_INPUT_TXT.getD_D_ADDRESS(d));
			D_distance=Read_distance.getDistance(location1,location2);
			
			int Qdjk=DSeat[d];
			
			if(n1[i]>Qdjk){n1[i]=Qdjk;}
			
			int[] Order=new int[n1[i]*2];
			int[] Order1=new int[n1[i]*2];
			double[] distance=new double[n1[i]*2];
			double[] distance1=new double[n1[i]*2];
			int[] have_place=new int[n1[i]*2];
			
			int k=0, l=0,R=0; 
			System.out.println("乘客  "+ (i+1));
			
					a=false;
					b=false;
		
					
			ok: while(n1[i]>l && a==false){		
				
				System.out.println("OK2 Qdjk = " + Qdjk);
		
						System.out.println("OK3 在Qdjk大於情況下 = " + Qdjk);
						
						if(R<K){R++;}
						else if(R>=K){n1[i]=l; break ok;}
						
						while(b!=true){
							for(int o=0;o<k;o++){Order[o]=Order1[o]; distance[o]=distance1[o];}
							
							random=(int) Calculate_the_function.random(0,K); 
							P_m[i][l]=random;
							P_R_LAT[i][l]=Read_Generate_random.lat(random);     P_R_LNG[i][l]=Read_Generate_random.lng(random);      //乘客搭車地點緯度        //乘客搭車地點經度
							System.out.println("OK1 起點為 = " + P_m[i][l]);
							P_F_R_Time[i][l]=c1.Addtime(Read_INPUT_TXT.getD_F_D_Time(d),Read_distance.getDistancetime(location1,P_m[i][l]));
							P_D_R_Time[i][l]=c1.Addtime(Read_INPUT_TXT.getD_F_D_Time(d),Read_distance.getDistancetime(location1,P_m[i][l]));
							
							if((int)Read_distance.getDistancetime(location1, P_m[i][l])>5 && (int)Read_distance.getDistancetime(location1, P_m[i][l]) < 15){b=true;}
							}
						
						
						b=false;
						
						
						while(b!=true){
							
						c=true;
						
						random1=(int) Calculate_the_function.random(0,K);
						P_n[i][l]=random1;
						System.out.println("OK3 迄點為 = " + P_n[i][l]);
						
						P_D_LAT[i][l] =Read_Generate_random.lat(random1);          P_D_LNG[i][l]=Read_Generate_random.lng(random1);        //乘客目的地經度   //乘客目的地緯度
					
						time=(int) Read_distance.getDistancetime(P_m[i][l],P_n[i][l]);
						
						for(int o=0;o<k;o++){if(have_place[o]==P_m[i][l] && have_place[o]==P_n[i][l]){c=false;}}
						
						
						if((int)Read_distance.getDistancetime(location2, P_n[i][l])<=20 && P_m[i][l]!=P_n[i][l] && c==true){b=true;}
						
						}
						
						
						// 這邊是判別司機與乘客距離的遠近--------------------
						P_distance=Read_distance.getDistance(P_m[i][l],P_n[i][l]);
					
						Route=Read_distance.getDistance(location1,P_m[i][l])+P_distance+Read_distance.getDistance(P_n[i][l],location2);
					 
						Order[k]=P_m[i][l];  Order[k+1]=P_n[i][l];
						distance[k]=Read_distance.getDistance(location1,P_m[i][l]);  distance[k+1]=Read_distance.getDistance(location1,P_n[i][l]); 
						
						for(int o=0;o<(k+2);o++){System.out.print("Order= "+Order[o]  + " distance= " + distance[o]);}
						System.out.println();
						
						   for (int m=0;m<(k+2)-1;m++)  
					          {
						       for (int o=0;o<(k+2)-m-1;o++)  
				               {
				                    if (distance[o+1]<distance[o])
				                    {
				                        int temp = Order[o+1];  //交換陣列元素
				                        double temp1=distance[o+1];
				                        Order[o+1]=Order[o];
				                        distance[o+1]=distance[o];
				                        Order[o]= temp;
				                        distance[o]=temp1;
				                    }
				              }
					          }
						   
					for(int o=0;o<(k+2);o++){System.out.print("  Order= "+Order[o]  + " distance= " + distance[o]);}
					System.out.println();
					
						if((Route/D_distance )<Read_Generate_random.Route_rate() && P_distance >Read_Generate_random.PassengerDistance())
						 	{
							System.out.println("繞道值 OK");
							if( time_limit.main(Order,(k+2),d)==true )
							{
								System.out.println("時間判斷 OK");
							 	k+=2; Qdjk-=1; l++; R=0;
								if(k>=Order.length){a=true;}
									for(int o=0;o<k;o++){Order1[o]=Order[o]; distance1[o]=distance[o];  have_place[o]=Order[o];}
								}
						 	}
				}
					location1=Integer.parseInt(Read_INPUT_TXT.getD_S_PLACE(d));
					String Driving_time = Read_INPUT_TXT.getD_F_D_Time(d);
					
				for(int j=0;j<(l*2);j++)
					{	
					if(j<l){
						time=(int) Read_distance.getDistancetime(location1,Order[j]);
						P_m[i][j]=Order[j];
						P_R_LAT[i][j] =Read_Generate_random.lat(Order[j]);          P_R_LNG[i][j]=Read_Generate_random.lng(Order[j]); 			
						Driving_time=c1.Addtime(Driving_time,Read_distance.getDistancetime(location1,Order[j]));
						String Driving_time1=Driving_time;
						P_F_R_Time[i][j]=Driving_time;
						P_D_R_Time[i][j]=Driving_time1;
						location1=Order[j];
					}
					if(j>=l)
						{
						int q=j-l;
						time=(int) Read_distance.getDistancetime(location1,Order[j]);
						P_n[i][q]=Order[j];
						P_D_LAT[i][q] =Read_Generate_random.lat(Order[j]);          P_D_LNG[i][q]=Read_Generate_random.lng(Order[j]); 			
						Driving_time=c1.Addtime(Driving_time,Read_distance.getDistancetime(location1,Order[j]));
						String Driving_time1=Driving_time;
						P_F_A_Time[i][q]=Driving_time;
						P_D_A_Time[i][q]=Driving_time1;
						location1=Order[j];
						}
					}
				PassengerOilConsumptionBounds[i]=(int)Calculate_the_function.random(Read_Generate_random_OilConsumptionBounds.PassengerOilConsumptionBounds(1)
						,Read_Generate_random_OilConsumptionBounds.PassengerOilConsumptionBounds(0));    //車子油耗量
				for(int j=0;j<l;j++)
				{
					fph[i][j]=Calculate_the_function.Fph_cost(Read_distance.getDistance(P_m[i][j],P_n[i][j]),PassengerOilConsumptionBounds[i],Read_Generate_random_OilConsumptionBounds.Passenger_OilPrice());
				}
				d++;
		}
		
				//-------------------passenger_calendar.txt----------------------
				FileWriter fw4 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path()+"\\SQL_input_random\\passenger_calendar");
				for(int i=0;i<P;i++){
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
				for(int i=0;i<P;i++){
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
				FileWriter fw6 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path()+"\\SQL_input_random\\passenger_initial_itinerary");
				for(int i=0;i<P;i++){
					for(int j=0;j<n1[i];j++){
				fw6.write(String.valueOf(P_ID[i])+",");                        //乘客ID	 
				fw6.write(String.valueOf(P_itinerary_ID[i])+",");              //乘客行程ID;
				fw6.write(P_F_R_Time[i][j]+","); fw6.write(P_D_R_Time[i][j]+",");    //乘客提早搭車時間         //乘客延遲搭車時間
				fw6.write(P_F_A_Time[i][j]+","); fw6.write(P_D_A_Time[i][j]+",");    //乘客到達目的時間        //乘客延遲到達目的地時間
				fw6.write(String.valueOf(P_R_LAT[i][j])+","); fw6.write(String.valueOf(P_R_LNG[i][j])+",");  //乘客搭車地點緯度        //乘客搭車地點經度     
				fw6.write(String.valueOf(P_m[i][j])+",");                                    //乘客搭車地點
				fw6.write(String.valueOf(P_D_LAT[i][j])+","); fw6.write(String.valueOf(P_D_LNG[i][j])+",");  //乘客目的地經度   //乘客目的地緯度
				fw6.write(String.valueOf(P_n[i][j])+",");        //定義乘客目的地位置
				fw6.write(String.valueOf(fph[i][j])+",");     //成本
				fw6.write(String.valueOf(1)+",");     
				fw6.write(String.valueOf((int)Calculate_the_function.random(50,120)));     
				fw6.write("\r\n");
					}
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
