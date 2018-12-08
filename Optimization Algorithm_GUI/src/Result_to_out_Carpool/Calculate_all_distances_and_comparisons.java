package Result_to_out_Carpool;

import java.io.IOException;

import READ_TXT.Read_INPUT_TXT_filter;
import READ_TXT.Read_distance;

public class Calculate_all_distances_and_comparisons extends carpool_results_test{

	public static double b() throws IOException 
	{
		//(b)共乘決策後未得標的司機與乘客的總距離
		
		Read_INPUT_TXT_filter.loadData();
		//宣告d1為Read_distance類別物件
		Read_distance d1=new Read_distance();
		
		double Route=0;
		
		int location1,location2;
		
		//計算決策後路徑跟距離
		//首先找出沒有被共乘的乘客及計算成本跟路徑--------------------
		int k=0;      //先定義k=0 代表判別是否有得標
		
		//計算乘客未共乘成本及路徑---------------------
		for(int i=0;i<P;i++){
			for(int j=0;j<K;j++){
				if(DriverBids[j][i]>=1){
					k++;}
			}
			if(k==0)              //如果未得標 則計算成本及路徑
				{
				for(int o=0;o<Read_INPUT_TXT_filter.getP();o++){
					if(PassengerList.get(i).equals(Read_INPUT_TXT_filter.getP_ID(o)) && PassengerList1.get(i).equals(Read_INPUT_TXT_filter.getP_R_PLACE(o))){
						location1=Integer.parseInt(Read_INPUT_TXT_filter.getP_R_PLACE(o));
						location2=Integer.parseInt(Read_INPUT_TXT_filter.getP_D_ADDRESS(o));	
						Route+=d1.getDistance(location1,location2); 
					}
				}
				}
			k=0;
		}
		
		//計算司機未共乘成本路徑------------------------------------------------------------------------------------------------
		k=0;
		for(int i=0;i<D;i++){
			for(int j=0;j<P;j++){
				if(DriverBids[i][j]==1){
					k++;}
			}
			if(k==0)          //如果未得標 則計算成本及路徑
				{
				Route+= determine_XObj.getOdj_distance(i);
				}
				k=0;
		}
		return Route;
	}
	
	
	
	public static double c() throws IOException 
	{
		//(c)共乘決策f前所有的司機與乘客的總距離
		
		Read_INPUT_TXT_filter.loadData();
		
		//宣告d1為Read_distance類別物件
		Read_distance d1=new Read_distance();
		
		double Route=0;
		
		int location1,location2;
		
		//計算為決策前之行程路徑-----------------------------------------------------------
		for(int i=0;i<D;i++){
			Route+= determine_XObj.getOdj_distance(i);
		}
		
		 for(int i=0;i<Read_INPUT_TXT_filter.getP();i++){
			 location1=Integer.parseInt(Read_INPUT_TXT_filter.getP_R_PLACE(i));
			 location2=Integer.parseInt(Read_INPUT_TXT_filter.getP_D_ADDRESS(i));	
			 Route+=d1.getDistance(location1,location2);
		 }
		return Route;
	}
	
	public static double d() throws IOException 
	{
		//(d)共乘決策得標的司機與乘客如果未使用共乘決策的運輸總距離。
		
		Read_INPUT_TXT_filter.loadData();
		
		//宣告d1為Read_distance類別物件
		Read_distance d1=new Read_distance();
		
		double Route=0;
		
		int location1,location2,k=0;
		
		 //----------------計算(d)共乘決策得標的司機與乘客如果未使用共乘決策的運輸總距離。--------------------------------------------------------
		 double l=0;
		 
		 int cost_d=0;
			for(int i=0;i<D;i++){
				for(int j=0;j<P;j++){
					if(DriverBids[i][j]>=1){
						k++;}
					if(k>=1)          //如果未得標 則計算成本及路徑
					{ 
					for(int o=0;o<Read_INPUT_TXT_filter.getP();o++){
					if(PassengerList.get(j).equals(Read_INPUT_TXT_filter.getP_ID(o)) && PassengerList1.get(j).equals(Read_INPUT_TXT_filter.getP_R_PLACE(o)))
						{
					 location1=Integer.parseInt(Read_INPUT_TXT_filter.getP_R_PLACE(o));
					 location2=Integer.parseInt(Read_INPUT_TXT_filter.getP_D_ADDRESS(o));
					 Route+=d1.getDistance(location1,location2); 
						}
					}
					}
					k=0;    l++;
				}
				if(l>0)
				{
						Route+= determine_XObj.getOdj_distance(i);
				}
				l=0;
			}
		 
		return Route;
	}
	
	
}
