package Heuristic_method_multi_hop_for_Original_Passenger;

import java.text.NumberFormat;

import carpool_Alogorithm_MOD.Calculate_the_function;
import Generate_random_data.Read_Generate_random_OilConsumptionBounds;
import Input_Output_txt.Carpool.Read_TransactionFee;
import READ_TXT.Read_INPUT_TXT_filter_Original;
import READ_TXT.Read_distance;

public class cost_multi_hop extends Heuristic_multi_hop{

	static double Theta;
	static int Qdjk=0;
	public static double Cost(int d) {
		Qdjk=0;
		int i,k;
		int location1= 0,location2;
		double route=0;
		double Dcost=0;
		Read_TransactionFee.main();
		Theta=Read_TransactionFee.Theta();
		
		location1=Integer.parseInt(Read_INPUT_TXT_filter_Original.getD_S_PLACE(d));
		for(i=0;i<8;i++){
			if(Orders[d][i]!=0){
			if(Orders[d][i]>0)
			{
				k=Orders[d][i];
				location2=Integer.parseInt(Read_INPUT_TXT_filter_Original.getP_R_PLACE(k-1));
				route+=Read_distance.getDistance(location1,location2);
				location1=location2;
				Qdjk+=1;
			}
			else if(Orders[d][i]<0)
			{
				k=-(Orders[d][i]);
				location2=Integer.parseInt(Read_INPUT_TXT_filter_Original.getP_D_ADDRESS(k-1));
				route+=Read_distance.getDistance(location1,location2);
				location1=location2;
			}
			}
		}
			location2=Integer.parseInt(Read_INPUT_TXT_filter_Original.getD_D_ADDRESS(d));
			route+=Read_distance.getDistance(location1,location2);
			Dcost=Calculate_the_function.Cdj_cost(route,Read_INPUT_TXT_filter_Original.getDriverOilConsumption(d),Read_Generate_random_OilConsumptionBounds.Driver_OilPrice(),"multi_hop",Qdjk);
		
			return Dcost;
		
	}

}
