package Generate_random_data;

import java.io.FileWriter;
import java.text.ParseException;
import java.util.Random;

import carpool_Alogorithm_MOD.Calculate_the_function;
import carpool_Alogorithm_MOD.TimeCalculate;
import GUI.I_Set_Paths_for_Current_Simulation_Example;
import READ_TXT.Read_distance;

public class Generate_Data_of_Driver_multi_hop {
	private static double lat[];                      //緯度
	private static double lng[];                    //經度
	private static String location[];               //地點
	private static int P;                    //產生乘客人數
	private static int D_length;                   //產生司機人數
	
	private static int[] PTimeRandom=new int[10];                //時間參數值
	private static int[] DTimeRandom=new int[10];                //時間參數值
	
	private static int No_of_Additional_Passengers;
	private static int No_of_Additional_Drivers;
	
	private static double random_rate=0.5;

	public static void main() throws Exception{

		Read_distance.Read_distance();

		Read_INPUT_TXT_Original_passenger_initial_itinerary.loadData();

		Read_Generate_random_OilConsumptionBounds.main();
		
		try {
			Read_Generate_random_multi_hop.main();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int K=Read_Generate_random_multi_hop.location_length();
		
		int Bpl_Upper=Read_Generate_random_multi_hop.Bpl_Upper();
		
		No_of_Additional_Passengers=Read_Generate_random_multi_hop.No_of_Additional_Passengers();
		No_of_Additional_Drivers=Read_Generate_random_multi_hop.No_of_Additional_Drivers();
		System.out.println("No_of_Additional_Drivers="+No_of_Additional_Drivers);
		
		P=Read_Generate_random_multi_hop.P()+No_of_Additional_Passengers;
		
	  //-----------------------定義乘客初始相關資料-------------------------
		   //乘客資料輸入   乘客四筆資料
	    int[][][] P_ID=new int[P][Bpl_Upper][];                      int[][][] P_itinerary_ID=new int[P][Bpl_Upper][10];                                              //乘客ID	  //乘客行程ID;
	    String[][][] P_F_R_Time=new String[P][Bpl_Upper][10];        			 String[][][] P_D_R_Time=new String[P][Bpl_Upper][10];    			    //乘客提早搭車時間  //乘客延遲搭車時間						 	 
	    String[][][] P_F_A_Time=new String[P][Bpl_Upper][10];         			 String[][][] P_D_A_Time=new String[P][Bpl_Upper][10];   //乘客到達目的時間    //乘客延遲到達目的地時間
	    String[][][] P_R_PLACE=new String[P][Bpl_Upper][10];      double[][][] P_R_LAT=new double[P][Bpl_Upper][10];                                //乘客搭車地點     //乘客搭車地點緯度
	    double[][][] P_R_LNG=new double[P][Bpl_Upper][10];        String[][][] P_D_ADDRESS= new String[P][Bpl_Upper][10];              //乘客搭車地點經度  //定義乘客目的地位置			              
	    double[][][] P_D_LAT=new double[P][Bpl_Upper][10];		 double[][][] P_D_LNG=new double[P][Bpl_Upper][10];         //乘客目的地經度   //乘客目的地緯度
	    double[][] PassengerOilConsumptionBounds=new double[P][Bpl_Upper];
	    double[][][] fph=new double[P][Bpl_Upper][10]; //支付成本   
		
	    int[][] n1=new int [P][Bpl_Upper];
	    int[] Bpl_length=new int[P];
	    int[][] BPL_Associated=new int[P][Bpl_Upper];
	    
	    
	    int[][][] P_m=new int[P][Bpl_Upper][10];
	    int[][][] P_n=new int[P][Bpl_Upper][10];
		
		int random1,time=0,d=0,location1,location2;
		double D_distance,Route;
		boolean a=false,b=false,c=false; 
		
		for(int i=0;i<4;i++){
		PTimeRandom[i]=Read_Generate_random_multi_hop.PTimeRandom(i);
		DTimeRandom[i]=Read_Generate_random_multi_hop.DTimeRandon(i);
		}
		
		D_length=0;
		
		TimeCalculate c1 = new TimeCalculate();
		
		for(int i=0;i<P;i++)
		{
			double xxx1 = Math.random();
			int Bpl;
			if(i>=Read_Generate_random_multi_hop.P()) {
				fph[i][0][0]=Read_INPUT_TXT_Original_passenger_initial_itinerary.getfph(i);
				Bpl_length[i]=1;
				n1[i][0]=1;
				BPL_Associated[i][0]=1;
				P_F_R_Time[i][0][0]=Read_INPUT_TXT_Original_passenger_initial_itinerary.getP_F_R_Time(i);
				P_D_R_Time[i][0][0]=Read_INPUT_TXT_Original_passenger_initial_itinerary.getP_D_R_Time(i);
				P_F_A_Time[i][0][0]=Read_INPUT_TXT_Original_passenger_initial_itinerary.getP_F_A_Time(i);
				P_D_A_Time[i][0][0]=Read_INPUT_TXT_Original_passenger_initial_itinerary.getP_D_A_Time(i);
				P_R_LAT[i][0][0]=Read_INPUT_TXT_Original_passenger_initial_itinerary.getP_R_LAT(i); 
				P_R_LNG[i][0][0]=Read_INPUT_TXT_Original_passenger_initial_itinerary.getP_R_LNG(i); 
				P_m[i][0][0]=Integer.parseInt(Read_INPUT_TXT_Original_passenger_initial_itinerary.getP_R_PLACE(i));                                    
				P_D_LAT[i][0][0]=Read_INPUT_TXT_Original_passenger_initial_itinerary.getP_D_LAT(i);
				P_D_LNG[i][0][0]=Read_INPUT_TXT_Original_passenger_initial_itinerary.getP_D_LNG(i);
				P_n[i][0][0]=Integer.parseInt(Read_INPUT_TXT_Original_passenger_initial_itinerary.getP_D_ADDRESS(i));
		//		random_rate-=(i/P);
		//		No_of_Additional_Passengers-=1;
				D_length++;
			}else 
			{
			 Bpl=(int) Calculate_the_function.random(Read_Generate_random_multi_hop.Bpl_Lower(),Read_Generate_random_multi_hop.Bpl_Upper());
		
			for(int bpl=0;bpl<Bpl;bpl++){
			a=false;
			location1=Integer.parseInt(Read_INPUT_TXT_Original_passenger_initial_itinerary.getP_R_PLACE(i));
			location2=Integer.parseInt(Read_INPUT_TXT_Original_passenger_initial_itinerary.getP_D_ADDRESS(i));
			D_distance=Read_distance.getDistance(location1,location2);
				
			Bpl_length[i]=Bpl;
			System.out.println("BPL第 "+ (bpl+1) +" 條 ");
			
			int Qdjk=(int) Calculate_the_function.random(2,3);
			
			int[] Order=new int[Qdjk*2+2];
			int[] Order1=new int[Qdjk*2+2];
			double[] distance=new double[Qdjk*2+2];
			double[] distance1=new double[Qdjk*2+2];
			int[] have_place=new int[Qdjk*2+2];
			
			int D_m = 0,D_n=0;
			
			n1[i][bpl]=Qdjk;
			
			int k=0, l=0,R=0; 
			System.out.println("乘客  "+ (i+1));
				
			ok: while(n1[i][bpl]>l && a==false){
				
						if(R<K){R++;}
						else if(R>=K){n1[i][bpl]=l; break ok;}
						
						D_m=location1;

						b=false;
						
						while(b!=true){
						c=true;
						random1=(int) Calculate_the_function.random(0,K);
						
						D_n=random1;
						
						System.out.println("OK3 迄點為 = " + D_n);
					
						time=(int) Read_distance.getDistancetime(D_m,D_n);
							
						if(Read_distance.getDistance(D_m,D_n) > Read_Generate_random_multi_hop.DriversDistance() 
							&& c==true ){b=true;}
						}
						
						
						// 這邊是判別司機與乘客距離的遠近--------------------
						D_distance=Read_distance.getDistance(D_m,D_n);
					
						Route=Read_distance.getDistance(location1,D_m)+D_distance+Read_distance.getDistance(D_n,location2);			 
						
						Order[k]=D_m;  Order[k+1]=D_n;
						
						distance[k]=Read_distance.getDistance(location1,D_m);  distance[k+1]=Read_distance.getDistance(location1,D_n); 
						
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
					
						if((Route/D_distance )<(Read_Generate_random_multi_hop.Route_rate()-(l*0.3)))
						 	{
							System.out.println("繞道值 OK");
							if( time_limit_multi_hop.main(Order,(k+2),i)==true )
							{
								System.out.println("時間判斷 OK");
							 	k+=2; Qdjk-=1; l++; R=0;
								if(k>=Order.length){a=true;}
									for(int o=0;o<k;o++){Order1[o]=Order[o]; distance1[o]=distance[o];  have_place[o]=Order[o];  location1=Order[o];}
							}
						 	}
				}
					
					System.out.println("-----------------");
					for(int o=0;o<k;o++)
						System.out.println(Order[o]+" ");
					System.out.println("-----------------");
					
					if(k!=0){
					if((int) Read_distance.getDistancetime(Order[k-1],location2)>10)
					{	
						Order[k]=Order[k-1];  Order[k+1]=location2;
						k+=2;
						n1[i][bpl]++;
					}
					}else{
						
						Order[k]=location1;  Order[k+1]=location2;
						k+=2;
						n1[i][bpl]++;
					}
					
					location1=Integer.parseInt(Read_INPUT_TXT_Original_passenger_initial_itinerary.getP_R_PLACE(i));
					String Driving_time = Read_INPUT_TXT_Original_passenger_initial_itinerary.getP_F_R_Time(i);
					
					int m=0;
					
					PassengerOilConsumptionBounds[i][bpl]=(double)((int)Calculate_the_function.random(Read_Generate_random_OilConsumptionBounds.PassengerOilConsumptionBounds(1)
							,Read_Generate_random_OilConsumptionBounds.PassengerOilConsumptionBounds(0)));    //車子油耗量
			
					
				for(int j=0;j<(n1[i][bpl]*2);j+=2)
					{	
						System.out.println("j= "+ j );
						System.out.print(Order[j]+" ");
						time=(int) Read_distance.getDistancetime(location1,Order[j]);
						P_m[i][bpl][m]=Order[j];
						P_R_LAT[i][bpl][m] =Read_Generate_random_multi_hop.lat(Order[j]);          P_R_LNG[i][bpl][m]=Read_Generate_random_multi_hop.lng(Order[j]); 			
						Driving_time=c1.Addtime(Driving_time,Read_distance.getDistancetime(location1,Order[j]));
						String Driving_time1=Driving_time;
						P_F_R_Time[i][bpl][m]=Driving_time;
						P_D_R_Time[i][bpl][m]=Driving_time1;
						location1=Order[j];
	
						System.out.print(Order[j+1]);
						time=(int) Read_distance.getDistancetime(location1,Order[j+1]);
						P_n[i][bpl][m]=Order[j+1];
						P_D_LAT[i][bpl][m] =Read_Generate_random_multi_hop.lat(Order[j+1]);          P_D_LNG[i][bpl][m]=Read_Generate_random_multi_hop.lng(Order[j+1]); 			
						Driving_time=c1.Addtime(Driving_time,Read_distance.getDistancetime(location1,Order[j+1]));
						Driving_time1=Driving_time;
						P_F_A_Time[i][bpl][m]=Driving_time;
						P_D_A_Time[i][bpl][m]=Driving_time1;
						location1=Order[j+1];
								
						System.out.println();
						fph[i][bpl][m]=(double)Calculate_the_function.Fph_cost(Read_distance.getDistance(P_m[i][bpl][m],P_n[i][bpl][m]),PassengerOilConsumptionBounds[i][bpl],Read_Generate_random_OilConsumptionBounds.Passenger_OilPrice());
						
						m++;
						
					}
				
				System.out.print("-----Fph------");
				
				System.out.println("第"+ (i+1) +"位乘客第"+(bpl+1)+"路線");
				System.out.println("成本");
				
				for(int j=0;j<m;j++)
				{
					System.out.print(fph[i][bpl][j]+" ");
				}
				System.out.println();
				
				BPL_Associated[i][bpl]=n1[i][bpl];
				
					D_length+=n1[i][bpl];
					}
				}
			}
		
		
		//------------------------定義司機相關資料------------------------
		int[] D_ID=new int[No_of_Additional_Drivers];		 int[] D_itinerary_ID=new int[No_of_Additional_Drivers]; 			    //司機 ID  //司機行程ID;
		String[] D_F_D_Time=new String[No_of_Additional_Drivers];     String[] D_S_D_Time=new String[No_of_Additional_Drivers];   //司機提早發車時間  //司機延遲發車時間
		String[] D_F_A_Time=new String[No_of_Additional_Drivers];     String[] D_S_A_Time=new String[No_of_Additional_Drivers];   //司機到達目的地時間    //司機延遲到達目的地時間
		String[] D_S_PLACE=new String[No_of_Additional_Drivers];      double[] D_S_LAT =new double[No_of_Additional_Drivers];     //司機發車地點      //司機發車地點緯度
		double[] D_S_LNG =new double[No_of_Additional_Drivers];       String[] D_D_ADDRESS=new String[No_of_Additional_Drivers];  //司機發車地點經度  //定義司機目的地位置
		double[]  D_D_LAT =new double[No_of_Additional_Drivers];      double[] D_D_LNG =new double[No_of_Additional_Drivers];     //司機目的地緯度       //司機目的地經度
	    
	    int[] D_m=new int[No_of_Additional_Drivers];
	    int[] D_n=new int[No_of_Additional_Drivers];
		int random;
	    
		for(int i=0;i<No_of_Additional_Drivers;i++)
		{
			a=false;
			D_ID[i]=2000+D_length+i;		D_itinerary_ID[i]=(int) Calculate_the_function.random(1,10); 			    //司機 ID  //司機行程ID;
			
			D_F_D_Time[i]=Calculate_the_function.randomtime(Read_Generate_random_multi_hop.DTimeRandon(1),Read_Generate_random_multi_hop.DTimeRandon(0));    //司機提早發車時間
			D_S_D_Time[i]=Calculate_the_function.randomtime(Read_Generate_random_multi_hop.DTimeRandon(3),Read_Generate_random_multi_hop.DTimeRandon(2));      //司機延遲發車時間
			
			while(a!=true){
			random=(int) Calculate_the_function.random(0,K); 
			D_m[i]=random; 
			D_S_LAT[i]=Read_Generate_random_multi_hop.lat(random);     D_S_LNG[i]=Read_Generate_random_multi_hop.lng(random);   //司機發車地點緯度        //司機發車地點經度     
			random1=(int) Calculate_the_function.random(0,K);
			D_n[i]=random1;
			D_D_LAT[i]=Read_Generate_random_multi_hop.lat(random1);    D_D_LNG[i]=Read_Generate_random_multi_hop.lng(random1);    //司機目的地緯度       //司機目的地經度
			time=(int) Read_distance.getDistancetime(D_m[i],D_n[i]);
			if(Read_distance.getDistance(D_m[i],D_n[i])>Read_Generate_random_multi_hop.No_of_Additional_Drivers_distance()){a=true;}
			}
			
			time=(int) Read_distance.getDistancetime(D_m[i],D_n[i]);
			D_F_A_Time[i]=Calculate_the_function.randomtime((Read_Generate_random_multi_hop.DTimeRandon(3)+time+10),(Read_Generate_random.DTimeRandon(2)+time+10));    //司機到達目的地時間
			D_S_A_Time[i]=Calculate_the_function.randomtime((Read_Generate_random_multi_hop.DTimeRandon(3)+time+20),(Read_Generate_random_multi_hop.DTimeRandon(2)+time+20));    //司機延遲到達目的地時間
		  
		}
		D_length+=No_of_Additional_Drivers;
		
				//-----------------passenger_initial itinerary---------------------------
				FileWriter fw6 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path()+"\\SQL_input_random\\passenger_initial_itinerary");
				for(int i=0;i<P;i++){
					for(int bpl=0;bpl<Bpl_length[i];bpl++){
					for(int j=0;j<n1[i][bpl];j++){
						fw6.write(String.valueOf(1000+i)+",");                        //乘客ID	 
						fw6.write(Read_INPUT_TXT_Original_passenger_initial_itinerary.getP_itinerary_ID(i)+",");              //乘客行程ID;
						fw6.write(P_F_R_Time[i][bpl][j]+","); fw6.write(P_D_R_Time[i][bpl][j]+",");    //乘客提早搭車時間         //乘客延遲搭車時間
						fw6.write(P_F_A_Time[i][bpl][j]+","); fw6.write(P_D_A_Time[i][bpl][j]+",");    //乘客到達目的時間        //乘客延遲到達目的地時間
						fw6.write(String.valueOf(P_R_LAT[i][bpl][j])+","); fw6.write(String.valueOf(P_R_LNG[i][bpl][j])+",");  //乘客搭車地點緯度        //乘客搭車地點經度     
						fw6.write(String.valueOf(P_m[i][bpl][j])+",");                                    //乘客搭車地點
						fw6.write(String.valueOf(P_D_LAT[i][bpl][j])+","); fw6.write(String.valueOf(P_D_LNG[i][bpl][j])+",");  //乘客目的地經度   //乘客目的地緯度
						fw6.write(String.valueOf(P_n[i][bpl][j])+",");        //定義乘客目的地位置
						fw6.write(String.valueOf(fph[i][bpl][j])+",");     //成本
						fw6.write(String.valueOf(1)+",");     
						fw6.write(String.valueOf((int)Calculate_the_function.random(50,120)));     
						fw6.write("\r\n");
						}
					}
				}
				fw6.close();
				
				//----------------編寫TXT檔------------------------------------------
				String cal = "00:00:00";
			//	int[] D_NUMBER=new int[D_length];
			//	for(int i=0;i<D_length;i++)
			//		D_NUMBER[i]=(int)Calculate_the_function.random(Read_Generate_random.Seats_Upper(),Read_Generate_random.Seats_Lower());  //可搭乘人數
				
				
						//-------------cardata.txt---------------------------------------
						FileWriter fw2 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path()+"\\SQL_input_random\\car_data");
						for(int i=0;i<D_length;i++){
						fw2.write(String.valueOf(2000+i)+",");
						fw2.write(generateRandomString()+",");
						fw2.write(String.valueOf(1)+",");
						int DriverOilConsumption=(int)Calculate_the_function.random(Read_Generate_random_OilConsumptionBounds.DriverOilConsumptionBounds(1)
								,Read_Generate_random_OilConsumptionBounds.DriverOilConsumptionBounds(0));    //車子油耗量
						fw2.write(String.valueOf(DriverOilConsumption)+",");
						fw2.write(String.valueOf((int)Calculate_the_function.random(20000,0))+",");
						fw2.write(String.valueOf((int)Calculate_the_function.random(0,10))+",");
						fw2.write(generateRandomString()+",");
						fw2.write(String.valueOf((int)Calculate_the_function.random(250,500)));
						fw2.write("\r\n");
						}
						fw2.close();
						//-------------driver_calendar.txt---------------------------------------
						FileWriter fw = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path()+"\\SQL_input_random\\driver_calendar");
						for(int i=0;i<D_length;i++){
						fw.write(Calculate_the_function.randomtime(DTimeRandom[7]+20,DTimeRandom[6]+20)+",");
						fw.write(Calculate_the_function.randomtime(DTimeRandom[7]+60,DTimeRandom[6]+60)+",");
						fw.write(String.valueOf(1)+",");
						fw.write(generateRandomString()+",");
						fw.write(generateRandomString());
						fw.write("\r\n");
						}
						fw.close();
						//-------------driver_data.txt-------------------------------------------
						FileWriter fw1 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path()+"\\SQL_input_random\\driver_data");
						for(int i=0;i<D_length;i++){
						fw1.write(String.valueOf(2000+i)+",");
						fw1.write(generateRandomString()+",");fw1.write(generateRandomString()+",");
						fw1.write(generateRandomString()+",");fw1.write(generateRandomString()+",");
						fw1.write(generateRandomString()+",");fw1.write(generateRandomString()+",");
						fw1.write(generateRandomString()+",");fw1.write(generateRandomString()+",");
						fw1.write(generateRandomString()+",");fw1.write(generateRandomString());
						fw1.write("\r\n");
						}
						fw1.close();
						
						//----------------------------driver_initial itinerary.txt---------------------
						int D=0,Additional_Drivers=0,math=0;
						random_rate=0.5;
						FileWriter fw11 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path()+"\\SQL_input_random\\driver_initial_itinerary");
						for(int i=0;i<P;i++){
							double xxx1 = Math.random();
							if(No_of_Additional_Drivers > 0 && xxx1> random_rate) {
								fw11.write(String.valueOf(D_ID[Additional_Drivers])+",");
								fw11.write(String.valueOf(D_itinerary_ID[Additional_Drivers])+",");
								fw11.write(D_F_D_Time[Additional_Drivers]+","); fw11.write(D_S_D_Time[Additional_Drivers]+",");
								fw11.write(D_F_A_Time[Additional_Drivers]+","); fw11.write(D_S_A_Time[Additional_Drivers]+",");			
								fw11.write(String.valueOf(D_S_LAT[Additional_Drivers])+","); fw11.write(String.valueOf(D_S_LNG[Additional_Drivers])+",");
								fw11.write(String.valueOf(D_m[Additional_Drivers])+",");
								fw11.write(String.valueOf(D_D_LAT[Additional_Drivers])+","); fw11.write(String.valueOf(D_D_LNG[Additional_Drivers])+",");
								fw11.write(String.valueOf(D_n[Additional_Drivers])+",");
								fw11.write(cal);
								fw11.write("\r\n");
								Additional_Drivers++;
								No_of_Additional_Drivers--;
								i=i-1;
								random_rate-=i/P;
								math++;
							}else 
							{
								for(int bpl=0;bpl<Bpl_length[i];bpl++){
									for(int j=0;j<n1[i][bpl];j++){
										fw11.write(String.valueOf(2000+D)+",");                        //司機ID	 
										fw11.write(String.valueOf(1)+",");              //司機行程ID;
							
										P_D_A_Time[i][bpl][j]=c1.Addtime(P_D_A_Time[i][bpl][j],20);
										fw11.write(P_F_R_Time[i][bpl][j]+",");		fw11.write(P_D_R_Time[i][bpl][j]+",");    //司機提早搭車時間         //乘客延遲搭車時間
										fw11.write(P_F_A_Time[i][bpl][j]+","); 	fw11.write(P_D_A_Time[i][bpl][j]+",");    //乘客到達目的時間        //乘客延遲到達目的地時間
							
										fw11.write(String.valueOf(P_R_LAT[i][bpl][j])+","); fw11.write(String.valueOf(P_R_LNG[i][bpl][j])+",");  //乘客搭車地點緯度        //乘客搭車地點經度     
										fw11.write(String.valueOf(P_m[i][bpl][j])+",");                                    //乘客搭車地點
							
										fw11.write(String.valueOf(P_D_LAT[i][bpl][j])+","); fw11.write(String.valueOf(P_D_LNG[i][bpl][j])+",");  //乘客目的地經度   //乘客目的地緯度
										fw11.write(String.valueOf(P_n[i][bpl][j])+",");        //定義乘客目的地位置
										fw11.write(cal);
										fw11.write("\r\n");
										D++;			
									}
							}
								random_rate-=i/P;
								math++;
							}
						}
						if(math<D_length){
							for(int i=Additional_Drivers;i<Read_Generate_random_multi_hop.No_of_Additional_Drivers();i++)
							{
								fw11.write(String.valueOf(D_ID[Additional_Drivers])+",");
								fw11.write(String.valueOf(D_itinerary_ID[Additional_Drivers])+",");
								fw11.write(D_F_D_Time[Additional_Drivers]+","); fw11.write(D_S_D_Time[Additional_Drivers]+",");
								fw11.write(D_F_A_Time[Additional_Drivers]+","); fw11.write(D_S_A_Time[Additional_Drivers]+",");			
								fw11.write(String.valueOf(D_S_LAT[Additional_Drivers])+","); fw11.write(String.valueOf(D_S_LNG[Additional_Drivers])+",");
								fw11.write(String.valueOf(D_m[Additional_Drivers])+",");
								fw11.write(String.valueOf(D_D_LAT[Additional_Drivers])+","); fw11.write(String.valueOf(D_D_LNG[Additional_Drivers])+",");
								fw11.write(String.valueOf(D_n[Additional_Drivers])+",");
								fw11.write(cal);
								fw11.write("\r\n");
							}
						}
						
						fw11.close();
						
						
						//----------------------------BPL.txt---------------------
						FileWriter fw12 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path()+"\\SQL_input_random\\BPL.txt");
						for(int i=0;i<P;i++){
							fw12.write(String.valueOf(1000+i)+" "+Bpl_length[i]+" ");
							for(int bpl=0;bpl<Bpl_length[i];bpl++){
							fw12.write(String.valueOf(BPL_Associated[i][bpl])+" ");
							}
							fw12.write("\r\n");
						}
						fw12.close();
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
