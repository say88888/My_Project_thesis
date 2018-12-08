package carpool_Alogorithm_MOD;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import Input_Output_txt.Carpool.Read_TransactionFee;

public class Calculate_the_function {

	//--------------用 距離 乘 油耗量------------------------
	public static double Cdj_cost(double dist,double Fuel_Consumption,double Oil_price,String data_mode,int qdjk){
		Read_TransactionFee.main();
			double d1=Fuel_Consumption/1000;
			
			double cost=Oil_price*((dist/1000)*d1);
			
			if(data_mode.equals("multi_hop"))
				cost=cost+(qdjk*Read_TransactionFee.Theta());
				
		return cost;
	}
	
	//--------------用 成本 除 油耗量------------------------
	public static double Cdj_dist(double cost,double  Fuel_Consumption,double Oil_price,String data_mode,int qdjk){
			double d1=Fuel_Consumption/1000;
			
			if(data_mode.equals("multi_hop"))
				cost=cost-(qdjk*Read_TransactionFee.Theta());
			
			double dist=(cost/Oil_price)/d1*1000;
		return dist;
	}
	
	//--------------用 距離 乘 油耗量----------------------
	public static double Odj_cost(double dist,double Fuel_Consumption,double Oil_price){
		
			double d1=Fuel_Consumption/1000;
			
			double cost=Oil_price*((dist/1000)*d1);
				
		return cost;
	}
	
	//--------------用 成本 除 油耗量------------------------
	public static double Odj_dist(double cost,double  Fuel_Consumption,double Oil_price){
		
			double d1=Fuel_Consumption/1000;
			double dist=(cost/Oil_price)/d1*1000;
		return dist;
	}
	//--------------用 距離 乘 油耗量----------------------
	public static double Fph_cost(double dist,double Fuel_Consumption,double Oil_price){
		
			double d1=Fuel_Consumption/1000;
			
			double cost=Oil_price*((dist/1000)*d1);
				
		return cost;
	}
	
	//--------------用 成本 除 油耗量------------------------
	public static double Fph_dist(double cost,double  Fuel_Consumption,double Oil_price){
	
			double d1=Fuel_Consumption/1000;
			double dist=(cost/Oil_price)/d1*1000;
		return dist;
	}
	
	//-------------產生隨機變數------------------------------
	public static double random(double x1,double x2)
	{
		double math,random;
		math=x1-x2;
		random=(double)(Math.random()*math+x2);
		random = Math.round(random*10000000)/10000000.0;      //去小數點第7位
		return random;
	} 
	//----------------產生隨機時間---------------------------------
	public static String randomtime(int x,int y)
	{
		int math;
		math=(int) random(x,y);  //使用上面產生隨機變數的函式
		Calendar cal = Calendar.getInstance();
		
		cal.add(Calendar.MINUTE ,+math); // 時間加減N小時
		String toDay =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(cal.getTime());
		return toDay;
	}
	
	
}
