package Heuristic_method_multi_hop;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import Generate_random_data.Read_Generate_random_multi_hop;
import Make_Carpool_data.make_SQL_input_random_filter_multi_hop;
import READ_TXT.Read_INPUT_TXT;
import READ_TXT.Read_distance;

public class Passenger_filter_multi_hop {
	
	private static 	List<List<Integer>> filter= new ArrayList<List<Integer>>();
	private static int P_filter;
	public static void main() throws IOException {
		 filter.clear();
		 P_filter=0;
		// TODO Auto-generated method stub
		
		Read_INPUT_TXT.loadData();			//讀取初始資料
		Read_distance.Read_distance();		//讀取距離矩陣
		
		try {
			Read_Generate_random_multi_hop.main();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<Integer> D=new ArrayList<Integer>();	
		
		for(int i=0;i<Read_INPUT_TXT.getP();i++){
			
		for(int j=0;j<Read_INPUT_TXT.getD();j++){
			 
			int D_S,D_E,P_S,P_E;
			D_S=Integer.parseInt(Read_INPUT_TXT.getD_S_PLACE(j));										//司機起點
			D_E=Integer.parseInt(Read_INPUT_TXT.getD_D_ADDRESS(j));								//司機終點
			P_S=Integer.parseInt(Read_INPUT_TXT.getP_R_PLACE(i));										//乘客搭車點
			P_E=Integer.parseInt(Read_INPUT_TXT.getP_D_ADDRESS(i));								//乘客下車點
			
			if( ((Read_distance.getDistance(D_S,P_S)																		//判定 司機起點到達乘客搭車點
					+ Read_distance.getDistance(P_S, P_E)																	//乘客搭車點到達乘客下車點
					+Read_distance.getDistance(P_E,D_E))																	//乘客下車點到達司機終點
					/Read_distance.getDistance(D_S,D_E) )																	//上面三段距離和    與 司機起點到達司機終點  
					<= Read_Generate_random_multi_hop.Route_rate()){													//比例是否低於 detour_rate.txt值	
				D.add(i+1);
				P_filter++;
				break;
			}
		}
																											
		}
		filter.add(D);			//如果符合就把乘客放入DP 矩陣
	 	
		
		for(int i=0;i<filter.size();i++){                                                                                                    
			for(int j=0;j<filter.get(i).size();j++)
		System.out.print(filter.get(i).get(j)+" ");
			System.out.println();} 
 	System.out.println(); 
 	
 	make_SQL_input_random_filter_multi_hop.main(P_filter);
	}
	
	public static int getP_filter(){
		return P_filter;
		}
	
	public static ArrayList<List<Integer>> filter(){
		return (ArrayList<List<Integer>>) filter;
	}
}
