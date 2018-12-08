package Make_Carpool_data;

import java.io.FileWriter;
import java.io.IOException;

import GUI.I_Set_Paths_for_Current_Simulation_Example;
import Heuristic_method_multi_hop.Passenger_filter_multi_hop;
import READ_TXT.Read_INPUT_TXT;
import READ_TXT.Read_distance;

public class make_SQL_input_random_filter_multi_hop {
	
	private static int P;                    //產生乘客人數
	private static int D;                   //產生司機人數
	private static int P_length;         
	public static void main(int P_filter) throws IOException {
		Read_INPUT_TXT.loadData();				//讀取SQL資料
		Read_distance.Read_distance();
		int i,j,k;
		//passenger_filter.main();
		D=Read_INPUT_TXT.getD();
		P=P_filter;
		P_length=Read_INPUT_TXT.getP_data_length();
		
		// TODO Auto-generated method stub
		//----------------編寫TXT檔------------------------------------------
				String cal = "00:00:00";
						//-------------cardata.txt---------------------------------------
						FileWriter fw2 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path()+"\\SQL_input_random_filter\\car_data");
						for(i=0;i<D;i++){
						fw2.write(String.valueOf(Read_INPUT_TXT.getD_ID(i))+",");
						fw2.write(Read_INPUT_TXT.getLicense_Plate(i)+",");
						fw2.write(String.valueOf(Read_INPUT_TXT.getP_NUMBER(i))+",");
						fw2.write(String.valueOf(Read_INPUT_TXT.getDriverOilConsumption(i))+",");
						fw2.write(String.valueOf(Read_INPUT_TXT.getVehicle_Displacement(i))+",");
						fw2.write(String.valueOf(Read_INPUT_TXT.getVehicle_Age(i))+",");
						fw2.write(Read_INPUT_TXT.getVehicle_Color(i)+",");
						fw2.write(String.valueOf(Read_INPUT_TXT.getWeight_Limit(i)));
						fw2.write("\r\n");
						}
						fw2.close();
						
						//----------------------------driver_initial itinerary.txt---------------------
						FileWriter fw11 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path()+"\\SQL_input_random_filter\\driver_initial_itinerary");
						for(i=0;i<D;i++){
						fw11.write(String.valueOf(Read_INPUT_TXT.getD_ID(i))+",");
						fw11.write(String.valueOf(Read_INPUT_TXT.getD_itinerary_ID(i))+",");
						fw11.write(Read_INPUT_TXT.getD_F_D_Time(i)+","); fw11.write(Read_INPUT_TXT.getD_S_D_Time(i)+",");
						fw11.write(Read_INPUT_TXT.getD_F_A_Time(i)+","); fw11.write(Read_INPUT_TXT.getD_S_A_Time(i)+",");			
						fw11.write(String.valueOf(Read_INPUT_TXT.getD_S_LAT(i))+","); fw11.write(String.valueOf(Read_INPUT_TXT.getD_S_LNG(i))+",");
						fw11.write(String.valueOf(Read_INPUT_TXT.getD_S_PLACE(i))+",");
						fw11.write(String.valueOf(Read_INPUT_TXT.getD_D_LAT(i))+","); fw11.write(String.valueOf(Read_INPUT_TXT.getD_D_LNG(i))+",");
						fw11.write(String.valueOf(Read_INPUT_TXT.getD_D_ADDRESS(i))+",");
						fw11.write(cal);
						fw11.write("\r\n");
						}
						fw11.close();
						
						//-----------------passenger_initial itinerary---------------------------
						FileWriter fw6 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path()+"\\SQL_input_random_filter\\passenger_initial_itinerary");
						for(i=0;i<P;i++){
							k=Passenger_filter_multi_hop.filter().get(0).get(i)-1;
						fw6.write(String.valueOf(Read_INPUT_TXT.getP_ID(k))+",");                        //乘客ID	 
						fw6.write(String.valueOf(Read_INPUT_TXT.getP_itinerary_ID(k))+",");              //乘客行程ID;
						fw6.write(Read_INPUT_TXT.getP_F_R_Time(k)+","); fw6.write(Read_INPUT_TXT.getP_D_R_Time(k)+",");    //乘客提早搭車時間         //乘客延遲搭車時間
						fw6.write(Read_INPUT_TXT.getP_F_A_Time(k)+","); fw6.write(Read_INPUT_TXT.getP_D_A_Time(k)+",");    //乘客到達目的時間        //乘客延遲到達目的地時間
						fw6.write(String.valueOf(Read_INPUT_TXT.getP_R_LAT(k))+","); fw6.write(String.valueOf(Read_INPUT_TXT.getP_R_LNG(k))+",");  //乘客搭車地點緯度        //乘客搭車地點經度     
						fw6.write(String.valueOf(Read_INPUT_TXT.getP_R_PLACE(k))+",");                                    //乘客搭車地點
						fw6.write(String.valueOf(Read_INPUT_TXT.getP_D_LAT(k))+","); fw6.write(String.valueOf(Read_INPUT_TXT.getP_D_LNG(k))+",");  //乘客目的地經度   //乘客目的地緯度
						fw6.write(String.valueOf(Read_INPUT_TXT.getP_D_ADDRESS(k))+",");        //定義乘客目的地位置
						fw6.write(String.valueOf(Read_INPUT_TXT.getfph(k))+",");     //成本
						fw6.write(String.valueOf(Read_INPUT_TXT.getseat(k))+",");     
						fw6.write(String.valueOf(Read_INPUT_TXT.getweight(k)));     //成本
						fw6.write("\r\n");
						}
						fw6.close();
						
						FileWriter fw7 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path()+"\\SQL_input_random_filter\\passenger_data");
						for(i=0;i<P;i++){
							k=Passenger_filter_multi_hop.filter().get(0).get(i)-1;
							for(j=0;j<P_length;j++){
								if(Read_INPUT_TXT.getP_ID(k).equals(Read_INPUT_TXT.getP_data_Id(j)))
								{
									fw7.write(Read_INPUT_TXT.getP_data_Id(j)+",");                        //乘客ID	 
									fw7.write(Read_INPUT_TXT.getPassenger_Account_Number(j)+",");      //帳號
									fw7.write(Read_INPUT_TXT.getPassenger_Password(j)+",");    //密碼
									fw7.write(Read_INPUT_TXT.getPassenger_Birthday(j)+",");     //生日
									fw7.write(Read_INPUT_TXT.getPassenger_Cell_Phone(j)+","); //電話
									fw7.write(Read_INPUT_TXT.getPassenger_E_mail(j)+",");      //電子郵件
									fw7.write(Read_INPUT_TXT.getPassenger_Occupation(j)+",");//職業
									fw7.write(Read_INPUT_TXT.getPassenger_Age(j)+",");     // 年齡  
									fw7.write(Read_INPUT_TXT.getPassenger_Gender(j)+",");     //性別
									fw7.write(Read_INPUT_TXT.getPassenger_School(j)+",");     // 學校
									fw7.write(Read_INPUT_TXT.getPassenger_Department(j)+",");        // 科系
									fw7.write(String.valueOf(Read_INPUT_TXT.getPassengerOilConsumption(j)));        // 油耗量
									fw7.write("\r\n");
								}
							}
						}
						fw7.close();
	}
}
