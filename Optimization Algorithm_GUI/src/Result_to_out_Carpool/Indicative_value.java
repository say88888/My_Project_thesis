package Result_to_out_Carpool;

import Make_Carpool_data.make_result;
import Make_Excel.Carpool.Output_EXCEL_Usage;
import READ_TXT.Read_INPUT_TXT_filter;

public class Indicative_value extends carpool_results_test {	

private static double V1,V2,V3,V4;
private static double W1,W2,W3,W4;
public  static double cost_d;

	//------------------------------------計算共乘決策後的值跟比較數值-------------------------------------------------
	public static void Get_Ratio_between_ride_sharing_distsance_and_without_ride_sharing() throws Exception
	{
		
		/*		//(a)共乘決策後得標的司機與乘客的總距離
		double a=Route;        //Route 得到得標共乘乘客距離
		
		//(b)共乘決策後未得標的司機與乘客的總距離
		double b=Calculate_all_distances_and_comparisons.b();
		
		//(c)未使用共乘決策的所有司機與乘客的運輸總距離。
		double c=Calculate_all_distances_and_comparisons.c();
		
		//(d)共乘決策得標的司機與乘客如果未使用共乘決策的運輸總距離。
		double d=Calculate_all_distances_and_comparisons.d();
		 
		
//-------------------比較及輸出兩者間的距離及輸出----------------
		System.out.println(" (a) 共乘決策後得標的司機與乘客的總距離= "+a);
		System.out.println(" (b) 共乘決策後未得標的司機與乘客的總距離= "+b);
		System.out.println(" (c) 未使用共乘決策的所有司機與乘客的運輸總距離= " +c);
		System.out.println(" (d) 共乘決策得標的司機與乘客如果未使用共乘決策的運輸總距離= "+d);
		System.out.println(" 決策前所有整體路徑 : "+"總距離(c) ="+ c);
		System.out.println(" 決策後所有整體路徑 : "+"總距離(a)+(b) ="+ a+b);
		System.out.println(" 計算出 [(a)+(b)]/(c) 的值。: "+ (a+b)/c);
		System.out.println(" 計算出 1-[(a)+(b)]/(c) 的值。: "+ (1-((a+b)/c)));
		System.out.println(" 計算出 [a] 的值。: "+ Route);
		System.out.println(" 計算出 [d] 的值。: "+ d);
		System.out.println(" 計算出 [a/d]的值。: "+Route/d);
		System.out.println(" 計算出 1-[a/d] 的值。: "+(1-(Route/d)));
		System.out.println();
	*/
			
			//呼叫演算  V-1~V-4 and W-1 ~W-4
			System.out.println( "計算 V- 1~ V-4 " );
			Ride_Sharing_Function_dist.ride_sharing_distance_Ratio();
			System.out.println( "計算 W- 1~ W-4 " );
			Ride_Sharing_Function_dist.successful_ride_sharing_and_no_ride_sharing_distance_Ratio();
			 V1=Ride_Sharing_Function_dist.getV_1();
			 V2=Ride_Sharing_Function_dist.getV_2();
			 V3=Ride_Sharing_Function_dist.getV_3();
			 V4=Ride_Sharing_Function_dist.getV_4();
			
			 W1=Ride_Sharing_Function_dist.getW_1();
			 W2=Ride_Sharing_Function_dist.getW_2();
			 W3=Ride_Sharing_Function_dist.getW_3();
			 W4=Ride_Sharing_Function_dist.getW_4();
			
			make_result.makeEqution_Value(V1,V2,V3,V4,W1,W2,W3,W4);
			//make_result .makeresult1(route,cost,route_B,cost_B,(float)route_B/route,(float)Route/route_d);
			//make_result .makereport1(route,cost,route_B,cost_B,(float)route_B/route,(float)Route/route_d);
			
			//新增的部分
			System.out.println();
			System.out.println( "以下為計算 X- 1~ X-3 的輸出 " );
			Ride_Sharing_Function_dist.original_travel_distancetime_for_each_ridesharing_passenger_and_driver();
			
			
	}
	
	//----------------------計算整體載客率------------------------------------
	public	static void GetUsage() throws Exception
	{
		Read_INPUT_TXT_filter.loadData();

		int i,j;
		
		double Raiot,Passenger_Seat=0,Driver_Seat=0;
		for(i=0;i<D;i++)
			for(j=0;j<K;j++)
				if(DriverBids[i][j]>=1){
					Passenger_Seat+=DriverBids[i][j];}
		
		for(i=0;i<D;i++)
			Driver_Seat+=Read_INPUT_TXT_filter.getP_NUMBER(i);
		
		Raiot=(double)(Passenger_Seat/Driver_Seat);
		
		System.out.println("整體共乘人數"+(int)Passenger_Seat);
		System.out.println("整體車子座位數"+(int)Driver_Seat);
		System.out.println("計算出整體使用率的值。:"+Raiot);
		
		
		Output_EXCEL_Usage.main((int)Passenger_Seat,(int)Driver_Seat,Raiot);
	//	make_result .makeresult2(k,l,(float)k/l);
	//	make_result .makereport2(k,l,(float)k/l);
		
	}

	public static double getV1() {
		return V1;
	}
	public static double getV2() {
		return V2;
	}
	public static double getV3() {
		return V3;
	}
	public static double getV4() {
		return V4;
	}
	public static double getW1() {
		return W1;
	}
	public static double getW2() {
		return W2;
	}
	public static double getW3() {
		return W3;
	}
	public static double getW4() {
		return W4;
	}
}






