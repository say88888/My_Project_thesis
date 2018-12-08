package Heuristic_method;

import java.text.NumberFormat;

import carpool_Alogorithm_MOD.Calculate_the_function;
import Generate_random_data.Read_Generate_random_OilConsumptionBounds;
import READ_TXT.Read_INPUT_TXT_filter;
import READ_TXT.Read_distance;

public class cost extends Heuristic{

	public static double Cost(int d) {
		
		int i,k;
		int location1= 0,location2;
		double route=0;
		double Dcost=0;
		int qdjk=0;
		location1=Integer.parseInt(Read_INPUT_TXT_filter.getD_S_PLACE(d));
		for(i=0;i<8;i++){
			if(Orders[d][i]!=0){
			if(Orders[d][i]>0)
			{
				k=Orders[d][i];
				location2=Integer.parseInt(Read_INPUT_TXT_filter.getP_R_PLACE(k-1));
				route+=Read_distance.getDistance(location1,location2);
				location1=location2;
				qdjk++;
			}
			else if(Orders[d][i]<0)
			{
				k=-(Orders[d][i]);
				location2=Integer.parseInt(Read_INPUT_TXT_filter.getP_D_ADDRESS(k-1));
				route+=Read_distance.getDistance(location1,location2);
				location1=location2;
			}
			}
		}
			location2=Integer.parseInt(Read_INPUT_TXT_filter.getD_D_ADDRESS(d));
			route+=Read_distance.getDistance(location1,location2);
			Dcost=Calculate_the_function.Cdj_cost(route,Read_INPUT_TXT_filter.getDriverOilConsumption(d),Read_Generate_random_OilConsumptionBounds.Driver_OilPrice(),"Single_mode",qdjk);
		return Dcost;
		
	}

}
