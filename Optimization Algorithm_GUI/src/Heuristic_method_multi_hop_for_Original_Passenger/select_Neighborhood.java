package Heuristic_method_multi_hop_for_Original_Passenger;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import Generate_random_data.Read_Generate_random_multi_hop;
import READ_TXT.Read_INPUT_TXT_filter_Original;
import READ_TXT.Read_distance;

public class select_Neighborhood {
	
	private static 	List<List<Integer>> DP = new ArrayList<List<Integer>>();
	private static 	List<List<Double>> DP_Detour_Ratio = new ArrayList<List<Double>>();
	public static void main() throws  IOException{
		DP .clear();
		DP_Detour_Ratio.clear();
		// TODO Auto-generated method stub
		Read_INPUT_TXT_filter_Original.loadData();			//讀取初始資料
		Read_distance.Read_distance();		//讀取距離矩陣
		
		try {
			Read_Generate_random_multi_hop.main();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(" Route_rate= "+Read_Generate_random_multi_hop.Route_rate());
		
		for(int i=0;i<Read_INPUT_TXT_filter_Original.getD();i++){
			List<Integer> D=new ArrayList<Integer>();	
			List<Double> Detour=new ArrayList<Double>();	
		for(int j=0;j<Read_INPUT_TXT_filter_Original.getP();j++){
			 
			int D_S,D_E,P_S,P_E;
			D_S=Integer.parseInt(Read_INPUT_TXT_filter_Original.getD_S_PLACE(i));										//司機起點
			D_E=Integer.parseInt(Read_INPUT_TXT_filter_Original.getD_D_ADDRESS(i));								//司機終點
			P_S=Integer.parseInt(Read_INPUT_TXT_filter_Original.getP_R_PLACE(j));										//乘客搭車點
			P_E=Integer.parseInt(Read_INPUT_TXT_filter_Original.getP_D_ADDRESS(j));								//乘客下車點
			
			if( ((Read_distance.getDistance(D_S,P_S)																		//判定 司機起點到達乘客搭車點
					+ Read_distance.getDistance(P_S, P_E)																	//			 乘客搭車點到達乘客下車點
					+Read_distance.getDistance(P_E,D_E))																	//			乘客下車點到達司機終點
					/Read_distance.getDistance(D_S,D_E) )																	//				 上面三段距離和    與 司機起點到達司機終點  
					<=Read_Generate_random_multi_hop.Route_rate() && 
					
					((Read_distance.getDistance(D_S,P_S)																		//判定 司機起點到達乘客搭車點
							+ Read_distance.getDistance(P_S, P_E)																	//			 乘客搭車點到達乘客下車點
							+Read_distance.getDistance(P_E,D_E))																	//			乘客下車點到達司機終點
							/Read_distance.getDistance(D_S,D_E) )	==1
					
					){                                                                  //				比例是否低於 detour_rate.txt值
				
				D.add(j+1);
				Detour.add((Read_distance.getDistance(D_S,P_S)																		//判定 司機起點到達乘客搭車點
						+ Read_distance.getDistance(P_S, P_E)																	//			 乘客搭車點到達乘客下車點
						+Read_distance.getDistance(P_E,D_E))																	//			乘客下車點到達司機終點
						/Read_distance.getDistance(D_S,D_E));
			}
		}
		DP.add(D);																																	//如果符合就把乘客放入DP 矩陣
		DP_Detour_Ratio.add(Detour);
		}
		
		for(int i=0;i<DP.size();i++)
			if(DP.get(i).size()==0)	 
				DP.get(i).add(0);
		
		for(int i=0;i<DP_Detour_Ratio.size();i++)
			if(DP_Detour_Ratio.get(i).size()==0)	 
				DP_Detour_Ratio.get(i).add(Double.valueOf(0));
		
		for(int i=0;i<DP.size();i++){
			for(int j=0;j<DP.get(i).size();j++)
				System.out.print(DP.get(i).get(j)+" ");
			System.out.println();
		}
		
		for(int i=0;i<DP_Detour_Ratio.size();i++){
			for(int j=0;j<DP_Detour_Ratio.get(i).size();j++)
					System.out.print(DP_Detour_Ratio.get(i).get(j)+" ");	
			System.out.println();
		}
		
	}
	
	public static ArrayList<List<Integer>> DP(){
		return (ArrayList<List<Integer>>) DP;
	}
	public static ArrayList<List<Double>> DP_Detour_Ratio(){
		return (ArrayList<List<Double>>) DP_Detour_Ratio;
	}
}
