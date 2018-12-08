package Algorithm_Carpool.CCPSO2_AB_NNH;

import java.util.ArrayList;
import java.util.List;

import READ_TXT.Read_INPUT_TXT_filter;
import READ_TXT.Read_distance;
import READ_TXT.Read_filter_and_detour_rate;

public class Check_DetourRation extends CCPSO2_AB_NNH{

	public static void main( ) {
		// TODO Auto-generated method stub
		for(int p=0;p<P;p++){
			List<Integer> Alist2 = new ArrayList<Integer>();
			Alist2.add(0);
			for(int d=0;d<D;d++){
				
				int D_S,D_E,P_S,P_E;
				D_S=Integer.parseInt(Read_INPUT_TXT_filter.getD_S_PLACE(d));				//司機起點
				D_E=Integer.parseInt(Read_INPUT_TXT_filter.getD_D_ADDRESS(d));		//司機終點
				P_S=Integer.parseInt(Read_INPUT_TXT_filter.getP_R_PLACE(p));				//乘客搭車點
				P_E=Integer.parseInt(Read_INPUT_TXT_filter.getP_D_ADDRESS(p));			//乘客下車點
				
				if( ((Read_distance.getDistance(D_S,P_S)														//判定 司機起點到達乘客搭車點
						+ Read_distance.getDistance(P_S, P_E)													//乘客搭車點到達乘客下車點
						+Read_distance.getDistance(P_E,D_E))													//乘客下車點到達司機終點
						/Read_distance.getDistance(D_S,D_E) )													//上面三段距離和    與 司機起點到達司機終點  
						<=Read_filter_and_detour_rate.getdetour_rate()){       							//小於繞道值
					Alist2.add(d+1);																							//將司機加入Alist2
				}
			}
																										//如果這位乘客沒有小於繞道值的司機
																												//將0加入Alist2
			Md.add(Alist2);																									//將Alist2放進Alist
			
		}
		
	}

}
