package Result_to_out_Carpool;

import java.util.ArrayList;

import Generate_random_data.Read_Generate_random_OilConsumptionBounds;
import READ_TXT.Read_INPUT_TXT_filter;
import carpool_Alogorithm_MOD.Calculate_the_function;

public class Ride_Sharing_Function_dist extends carpool_results_test {

	private  static double V_1;
	private  static double V_2;
	private  static double V_3;
	private  static double V_4;
	private  static double V_5;
	
	private  static double W_1;
	private  static double W_2;
	private  static double W_3;
	private  static double W_4;
	private  static double W_5;
	
	private  static double X_1;
	private  static double X_2;
	private  static double X_3;
	
	
	private static ArrayList<Double> P_distance_Ratio = new ArrayList<Double>(); //記錄此乘客得標後所行駛距離比率
	private static ArrayList<Double> D_distance_Ratio = new ArrayList<Double>(); //記錄此乘客得標後所行駛距離比率
	
	// 所有司機和乘客的乘坐共享和無乘坐共享的總行程距離之間的比率 ; cdj1=共乘後的費率
	public static  void ride_sharing_distance_Ratio() {
		
		int c = 0;
		int[][] Y = new int[Read_Carpool_file.getP()][];
		for (int i = 0; i < Read_Carpool_file.getP(); i++)
			Y[i] = new int[Read_Carpool_file.getHp(i)];
		int[][] X = new int[Read_Carpool_file.getD()][];
		for (int i = 0; i < Read_Carpool_file.getD(); i++)
			X[i] = new int[Read_Carpool_file.getJd(i)];

		int b = 0;
		for (int i = 0; i < Y.length; i++)
			for (int j = 0; j < Y[i].length; j++)
				Y[i][j] = Yph[c++];
		for (int i = 0; i < X.length; i++)
			for (int j = 0; j < X[i].length; j++)
				X[i][j] = Xdj[b++];

		int[] Xd=new int[D];
		
		double fit = 0;
		for (int p = 0; p < Read_Carpool_file.getP(); p++)
			for (int h = 0; h < Read_Carpool_file.getHp(p); h++) {
				fit += (1 - Y[p][h]) * Calculate_the_function.Fph_dist( Read_Carpool_file.getfph(p, h),Read_INPUT_TXT_filter.getPassengerOilConsumption(p),Read_Generate_random_OilConsumptionBounds.Passenger_OilPrice());
				
				System.out.println("第 "+(p+1)+" 位乘客 第 "+(h+1)+" 標 Yph = "+Y[p][h]
						+" (1-Yph )* πph_dist= " + (1 - Y[p][h]) * Calculate_the_function.Fph_dist(Read_Carpool_file.getfph(p, h),Read_INPUT_TXT_filter.getPassengerOilConsumption(p)
								,Read_Generate_random_OilConsumptionBounds.Passenger_OilPrice()));
			}
		System.out.println("總和 (1-Yph)  πph_dist= "+fit);
		
		double fit1=0;
		int a = 0;
		for (int d = 0; d < Read_Carpool_file.getD(); d++)
			for (int j = 0; j < Read_Carpool_file.getJd(d); j++) {
				if (X[d][j] == 1) {
					fit1 += X[d][j] *Calculate_the_function.Cdj_dist(DriverBids[d][K],Read_INPUT_TXT_filter.getDriverOilConsumption(d),Read_Generate_random_OilConsumptionBounds.Driver_OilPrice(),data_mode,qdjk[d]);	
					System.out.println("第 "+(d+1)+" 位司機 第 "+(j+1)+" 個標  Xdj = "+X[d][j]+ " π ̃dj_dist= "+DriverBids[d][K]+" dist= "+Calculate_the_function.Cdj_dist(DriverBids[d][K]
							,Read_INPUT_TXT_filter.getDriverOilConsumption(d),	Read_Generate_random_OilConsumptionBounds.Driver_OilPrice(),data_mode,qdjk[d]));
					Xd[d]=1;
				}
			}
		System.out.println("總和 π ̃dj_dist= "+fit1);
		
		double fit2=0;
		for (int d = 0; d < Read_Carpool_file.getD(); d++){
			if(Xd[d]<=0){
				fit2 +=determine_XObj.getOdj_distance(d);
			System.out.println("第 "+(d+1)+" 位司機 並未得標"+ " πdj_dist= "+ determine_XObj.getOdj_distance(d));
			}
			else
			{
				System.out.println("第 "+(d+1)+" 位司機 有得標");
			}
		}
		System.out.println("總和(1-Xd) πdj_dist= "+fit2);
		
		double fit3 = 0;
		for (int p = 0; p < Read_Carpool_file.getP(); p++)
			for (int h = 0; h < Read_Carpool_file.getHp(p); h++) {
				fit3 += Calculate_the_function.Fph_dist( Read_Carpool_file.getfph(p, h),Read_INPUT_TXT_filter.getPassengerOilConsumption(p),Read_Generate_random_OilConsumptionBounds.Passenger_OilPrice());
			System.out.println("第 "+(p+1)+" 位乘客 第 "+(h+1)+" 個標 πph_dist= " + Calculate_the_function.Fph_dist(Read_Carpool_file.getfph(p, h),Read_INPUT_TXT_filter.getPassengerOilConsumption(p),
					Read_Generate_random_OilConsumptionBounds.Passenger_OilPrice()));
			}
		System.out.println("總和 πph_dist = "+fit3);
		
		double fit4=0;
		for (int d = 0; d < Read_Carpool_file.getD(); d++)
		{
			fit4+=determine_XObj.getOdj_distance(d);
			System.out.println("第 "+(d+1)+" 位司機 πdj_dist= "+ determine_XObj.getOdj_distance(d));
		}
		System.out.println("總和 πdj_dist= "+fit4);
		
		V_1=fit+fit1+fit2;
		V_2=fit3+fit4;
		V_3=V_1/V_2;
		V_4=1-V_3;
		
		
		System.out.println(" ( v-1 ) 為總和 (1-Yph )*πph_dist + π ̃dj_dis + πph_dist= "+V_1);
		System.out.println(" ( v-2 ) 總和  πph_dist + πdj_dis = "+ V_2);		
		System.out.println(" ( v-3 ) 為 (v-1) 除(v-2)除等於 = "+  V_3);
		System.out.println(" ( v-4 ) 為 1-(v-3) 除等於 = "+  V_4);

	}

	// 成功的乘坐共享駕駛員和乘客之間的乘坐共享和沒有乘坐共享的總行程距離之間的比率
	public static void  successful_ride_sharing_and_no_ride_sharing_distance_Ratio() {

		int c = 0;
		int[][] Y = new int[Read_Carpool_file.getP()][];
		for (int i = 0; i < Read_Carpool_file.getP(); i++)
			Y[i] = new int[Read_Carpool_file.getHp(i)];
		int[][] X = new int[Read_Carpool_file.getD()][];
		for (int i = 0; i < Read_Carpool_file.getD(); i++)
			X[i] = new int[Read_Carpool_file.getJd(i)];

		int b = 0;
		for (int i = 0; i < Y.length; i++)
			for (int j = 0; j < Y[i].length; j++)
				Y[i][j] = Yph[c++];
		for (int i = 0; i < X.length; i++)
			for (int j = 0; j < X[i].length; j++)
				X[i][j] = Xdj[b++];

		double fit = 0, fit1 = 0, fit2=0;
		int a = 0,location1,location2;

		for (int d = 0; d < Read_Carpool_file.getD(); d++)
			for (int j = 0; j < Read_Carpool_file.getJd(d); j++) {
				if (X[d][j] == 1) {
					fit += X[d][j] *Calculate_the_function.Cdj_dist(DriverBids[d][K],Read_INPUT_TXT_filter.getDriverOilConsumption(d),Read_Generate_random_OilConsumptionBounds.Driver_OilPrice(),data_mode,qdjk[d]);
					System.out.println("第 "+(d+1)+" 個司機 第 "+(j+1)+" 個標  Xdj = "+X[d][j]+ " π ̃dj_dist= "+DriverBids[d][K]+" dist= "+Calculate_the_function.Cdj_dist(DriverBids[d][K],
							Read_INPUT_TXT_filter.getDriverOilConsumption(d),Read_Generate_random_OilConsumptionBounds.Driver_OilPrice(),data_mode,qdjk[d]));
				}
			}
		System.out.println("總和 π ̃dj_dist= "+fit);
		
		for (int p = 0; p < Read_Carpool_file.getP(); p++)
			for (int h = 0; h < Read_Carpool_file.getHp(p); h++) {
				if (Y[p][h] == 1) {
					fit1 += Calculate_the_function.Fph_dist( Read_Carpool_file.getfph(p, h),Read_INPUT_TXT_filter.getPassengerOilConsumption(p),Read_Generate_random_OilConsumptionBounds.Passenger_OilPrice());
					System.out.println("第 "+(p+1)+" 個乘客 第 "+(h+1)+" 個標 Yph= " +  Y[p][h] + "πph_dist= " + Calculate_the_function.Fph_dist(Read_Carpool_file.getfph(p, h),
							Read_INPUT_TXT_filter.getPassengerOilConsumption(p),Read_Generate_random_OilConsumptionBounds.Passenger_OilPrice()));
			}
		}
		System.out.println("總和 πph_dist= "+fit1);
		
		a = 0;
		for (int d = 0; d < Read_Carpool_file.getD(); d++)
			for (int j = 0; j < Read_Carpool_file.getJd(d); j++) {
				if (X[d][j] == 1) {
					fit2 += X[d][j]*determine_XObj.getOdj_distance(d);
				System.out.println("第 "+(d+1)+" 個司機 第 "+(j+1)+" 個標  Xdj = "+X[d][j]	+
					" πdj_dist= "+ X[d][j] *determine_XObj.getOdj_distance(d));
				}
		}
		System.out.println("總和 πdj_dist= "+fit2);
		
		W_1=fit;
		W_2=fit1+fit2;
		W_3=W_1/W_2;
		W_4=1-W_3;
		
		System.out.println(" ( w-1 ) 總和 π ̃dj_dist= "+W_1);
		System.out.println(" ( w-2 ) 總和 πdj_dist + πph_dist = "+W_2);
		System.out.println(" ( w-3 ) 為  (w-1)/(w-2) = "+W_3);
		System.out.println(" ( w-4 ) 為  1-(w-3)= "+W_4);
	}
	
	public static void  original_travel_distancetime_for_each_ridesharing_passenger_and_driver() {

		int c = 0;
		int[][] Y = new int[Read_Carpool_file.getP()][];
		for (int i = 0; i < Read_Carpool_file.getP(); i++)
			Y[i] = new int[Read_Carpool_file.getHp(i)];
		int[][] X = new int[Read_Carpool_file.getD()][];
		for (int i = 0; i < Read_Carpool_file.getD(); i++)
			X[i] = new int[Read_Carpool_file.getJd(i)];

		int b = 0;
		for (int i = 0; i < Y.length; i++)
			for (int j = 0; j < Y[i].length; j++)
				Y[i][j] = Yph[c++];
		for (int i = 0; i < X.length; i++)
			for (int j = 0; j < X[i].length; j++)
				X[i][j] = Xdj[b++];

		int a = 0;
		carpool_after_distance.P_ID();
		System.out.println(" 乘客部分 ");
		
		double[] P_Ratio =new double[carpool_after_distance.P_ID_size()];
		
		double fit11 = 0,fit12=0;
		for (int p = 0; p < Read_Carpool_file.getP(); p++)
			for (int h = 0; h < Read_Carpool_file.getHp(p); h++) {
				if (Y[p][h] == 1) {
				
					for(int k=0;k<carpool_after_distance.P_ID_size();k++)
					{
						if(carpool_after_distance.P_ID().get(k).equals(PID.get(p))){
							fit11 = carpool_after_distance.P_distance().get(k);
							a=k;
						}
					}		
					System.out.println("第 "+(p+1)+" 個乘客 第 "+(h+1)+" 個標 Yph= " +  Y[p][h] + "  ~πph= " + fit11);
					
					fit12 = Calculate_the_function.Fph_dist( Read_Carpool_file.getfph(p, h),Read_INPUT_TXT_filter.getPassengerOilConsumption(p),Read_Generate_random_OilConsumptionBounds.Passenger_OilPrice());
					
					System.out.println("第 "+(p+1)+" 個乘客 第 "+(h+1)+" 個標 Yph= " +  Y[p][h] + "  πph= " + fit12);
						
					System.out.println(" ~πph / πph =" +  (fit11/fit12));
					
					P_Ratio[a]= (fit11/fit12);
				}
			}
		
		
		for(int k=0;k<carpool_after_distance.P_ID_size();k++)
		{
			P_distance_Ratio.add(P_Ratio[k]);
		}
		
		
		System.out.println();
		System.out.println(" 司機部分 ");
		
		double fit21 = 0,fit22=0,fit31 = 0;
		for (int d = 0; d < Read_Carpool_file.getD(); d++)
			for (int j = 0; j < Read_Carpool_file.getJd(d); j++) {
				if (X[d][j] == 1) {
					for(int k=0;k<carpool_after_distance.D_ID_size();k++)
					{
						if(carpool_after_distance.D_ID().get(k).equals(Read_INPUT_TXT_filter.getD_ID(d))){
							fit21 = carpool_after_distance.D_distance().get(k);
						}
					}
					fit31 = X[d][j] *determine_XObj.getOdj_distance(d);
					fit22 = X[d][j] *determine_XObj.getOdj_distance(d);
					
					System.out.println("第 "+(d+1)+" 個司機 第 "+(j+1)+" 個標 Xdj= " +  X[d][j] + "  ~πdj= " + fit21);
					
					System.out.println("第 "+(d+1)+" 個司機 第 "+(j+1)+" 個標 Xdj= " +  X[d][j] + "  πdj= " + fit31);
					
					System.out.println("第 "+(d+1)+" 個司機 第 "+(j+1)+" 個標 Xdj= " +  X[d][j] + " πd= " + fit22);
					
					
					System.out.println("  ~πdj/πd= " + (fit21/fit22));
				
					System.out.println( "  πdj/πd= " +(fit31/ fit22));
					
					D_distance_Ratio.add((fit21/fit22));
					
				}
			}
		

		//System.out.println(" ( X-1 ) 總和 π ̃dj_dist= "+W_1);
		//System.out.println(" ( X-2 ) 總和 πdj_dist + πph_dist = "+W_2);
		//System.out.println(" ( X-3 ) 為  (w-1)/(w-2) = "+W_3);
	}
	
	public static double getV_1(){
		return V_1;
	}
	public static double getV_2(){
		return V_2;
	}
	public static double getV_3(){
		return V_3;
	}
	public static double getV_4(){
		return V_4;
	}
	public static double getW_1(){
		return W_1;
	}
	public static double getW_2(){
		return W_2;
	}
	public static double getW_3(){
		return W_3;
	}
	public static double getW_4(){
		return W_4;
	}
	public static double getX_1(){
		return X_1;
	}
	public static double getX_2(){
		return X_2;
	}
	public static double getX_3(){
		return X_3;
	}
	
	public static ArrayList<Double> P_distance_Ratio(){
		return P_distance_Ratio;
	}
	public static ArrayList<Double> D_distance_Ratio(){
		return D_distance_Ratio;
	}
}
