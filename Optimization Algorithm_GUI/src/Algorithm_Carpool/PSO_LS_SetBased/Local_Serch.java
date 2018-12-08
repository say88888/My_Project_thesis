package Algorithm_Carpool.PSO_LS_SetBased;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import carpool_Alogorithm_MOD.Calculate_the_function;
import carpool_Alogorithm_MOD.TimeCalculate;
import Generate_random_data.Read_Generate_random_OilConsumptionBounds;
import READ_TXT.Read_INPUT_TXT_filter;
import READ_TXT.Read_distance;

public class Local_Serch extends PSO_LS_SetBased {

	private static	ArrayList<Integer> Pi = new ArrayList<Integer>();
	private static	ArrayList<Integer> Pi_1 = new ArrayList<Integer>();
	
	private static boolean feasibility_flag1;
	private static	boolean feasibility_flag2;
	
	private static double Profit1;
	private static double Profit2 ;
	public static void NNH(int[][] A) {
		// TODO Auto-generated method stub

		List<List<Integer>> B1 = new ArrayList<List<Integer>>();
		List<List<Integer>> B = new ArrayList<List<Integer>>();
		for (int d= 0; d < D; d++) {
			List<Integer> b = new ArrayList<Integer>();
			for (int p = 0; p < P; p++)
				if (A[d][p] == 1) 
					b.add(p+1);
			B1.add(b);
		}
		int location1, location2, k;
		for (int d = 0; d < B1.size(); d++) {
			List<Integer> Pi = new ArrayList<Integer>();
			List<Integer> Pi_1 = new ArrayList<Integer>();
			int m=2;
			int L1=Integer.parseInt(Read_INPUT_TXT_filter.getD_S_PLACE(d));
			int L2=Integer.parseInt(Read_INPUT_TXT_filter.getD_D_ADDRESS(d));
			Pi.add(L1);
			Pi.add(L2);
			int best_P;
			while(B1.get(d).size()>0){
				best_P=FindTheBestPassengerToBeInserted(B1.get(d),Pi,m,L1);
				Pi.add(best_P); 
				Pi_1.add(best_P); Pi_1.add(-(best_P));
				for(int p=0;p<B1.get(d).size();p++){
					if(best_P==B1.get(d).get(p))
						B1.get(d).remove(p);
				}
				m++;
			}
			B.add(Pi_1);
		}
		M= new ArrayList<List<Integer>>();
		for (int d = 0; d < B.size(); d++) {
			double route = 99999999.0;
			int min = 0, i = 0;
			Bstring= new ArrayList<Integer>();
			while (B.get(d).size() != 0) {
				int n = 0;
				if (i == 0)
					location1 = Integer.parseInt(Read_INPUT_TXT_filter	.getD_S_PLACE(d));
				else if (min > 0)
					location1 = Integer.parseInt(Read_INPUT_TXT_filter	.getP_R_PLACE(min - 1));
				else
					location1 = Integer.parseInt(Read_INPUT_TXT_filter	.getP_D_ADDRESS((-min) - 1));
				i++;
				for (int j = 0; j < B.get(d).size(); j++) {
					if (B.get(d).get(j) > 0) {
						k = B.get(d).get(j);
						location2 = Integer.parseInt(Read_INPUT_TXT_filter	.getP_R_PLACE(k - 1));
						if (Read_distance.getDistance(location1, location2) < route) {
							route = Read_distance.getDistance(location1,	location2);
							min = B.get(d).get(j);
							n = j;
						}
					} else if (B.get(d).get(j) < 0) {
						k = -(B.get(d).get(j));
						location2 = Integer.parseInt(Read_INPUT_TXT_filter	.getP_D_ADDRESS(k - 1));
						if (Read_distance.getDistance(location1, location2) < route) {
							route = Read_distance.getDistance(location1,	location2);
							min = B.get(d).get(j);
							n = j;
						}
					}
				}
				Bstring.add(B.get(d).get(n));
				B.get(d).remove(n);
			}
			M.add(Bstring);
		}
	}
	
	public static void BuildTour(int[][] A) {
		// TODO Auto-generated method stub
		Read_distance.Read_distance();
		List<List<Integer>> B1 = new ArrayList<List<Integer>>();
		List<List<Integer>> B = new ArrayList<List<Integer>>();
		for (int d= 0; d < D; d++) {
			List<Integer> b = new ArrayList<Integer>();
			for (int p = 0; p < P; p++)
				if (A[d][p] == 1) 
					b.add(p+1);
			B1.add(b);
		}
		
		Pi_id= new ArrayList<List<Integer>>();

		for (int d = 0; d < B1.size(); d++) {
			Pi = new ArrayList<Integer>();
			Pi_1 = new ArrayList<Integer>();
			int m=2;
			int L1=Integer.parseInt(Read_INPUT_TXT_filter.getD_S_PLACE(d));
			int L2=Integer.parseInt(Read_INPUT_TXT_filter.getD_D_ADDRESS(d));
			Pi.add(L1);
			Pi.add(L2);
			int best_P,length=B1.get(d).size();
				
			while(length>0){
				Pi_1.clear();
				Pi_1.addAll(Pi);
				best_P=FindTheBestPassengerToBeInserted(B1.get(d),Pi,m,L1);
				length-=1;
				for(int p=0;p<B1.get(d).size();p++){
					if(best_P==B1.get(d).get(p))
						B1.get(d).remove(p);
				}
				
				InsertPickupLocationOfTheBestPassenger(best_P,m,d);
						
				if(feasibility_flag1==true)
				{
					InsertDropOffLocationOfTheBestPassenger(best_P,(m+1),d);
					
					if(feasibility_flag2==true)
					{
						
						if(profit_constraint_rule.equals("Without_checking_profit_constraint"))
						{
							Pi.clear();
							Pi.addAll(Pi_1);
							m+=2;
						}
						else if(profit_constraint_rule.equals("hecking_whether_profit_is_positive"))
						{
							Profit1=Function(d,Pi_1);
							if(Profit1>0){
								Pi.clear();
								Pi.addAll(Pi_1);
								m+=2;
							}
						}
						else if(profit_constraint_rule.equals("Checking_whether_profit_is_increased"))
						{
							Profit1=Function(d,Pi_1);
							Profit2=Function(d,Pi);
							if(Profit1>Profit2){
								Pi.clear();
								Pi.addAll(Pi_1);
								m+=2;
							}
						}
					}
				}
			}
			Pi.remove(m-1);
			Pi.remove(0);
			Pi_id.add(Pi);
		}
	}
	
	static int FindTheBestPassengerToBeInserted(List<Integer> B,List<Integer> Pi,int m,int L1)
	{
		double cost[]=new double[B.size()];
		int best_P=0;
		double cost1,cost2,cost3;
		for(int i=0;i<B.size();i++)
		{
			int p=B.get(i);
			int P_up=Integer.parseInt(Read_INPUT_TXT_filter.getP_R_PLACE(p-1));
			int P_down=Integer.parseInt(Read_INPUT_TXT_filter.getP_D_ADDRESS(p-1));
			
			cost1=Read_distance.getDistance(L1,P_up)+Read_distance.getDistance(P_up,Pi.get(m-1))-Mu*Read_distance.getDistance(L1,Pi.get(m-1));
			cost2=Read_distance.getDistance(P_up,P_down)+Read_distance.getDistance(P_down,Pi.get(m-1))-Eta*Read_distance.getDistance(P_up,Pi.get(m-1));
			cost3=Read_distance.getDistance(L1,P_up);
			
			cost[i]=(Lambda1*cost1)+(Lambda2*cost2)+(Lambda3*cost3);
		}
		int min=B.get(0);
		for(int i=0;i<B.size()-1;i++)
			if(cost[i]>cost[i+1]){
				min=B.get(i+1);
			}
		best_P=min;
		
		return best_P;
	}
	
	static void InsertPickupLocationOfTheBestPassenger(int Best_p,int m,int d)
	{
		double cost[]=new double[Pi_1.size()];
		double cost4;	
		int P_up=Integer.parseInt(Read_INPUT_TXT_filter.getP_R_PLACE(Best_p-1));
		for(int i=0;i<(m-1);i++)
		{
			int Lm=Pi_1.get(i);
			int Lm1=Pi_1.get(i+1);
			if(i==0)
				Lm=Pi_1.get(i);
			else if(i>0){
				if(Lm>0)
					Lm=Integer.parseInt(Read_INPUT_TXT_filter.getP_R_PLACE(Lm-1));
				else
					Lm=Integer.parseInt(Read_INPUT_TXT_filter.getP_D_ADDRESS(-(Lm)-1));
				}
			
			if((i+1)==(m-1))
				Lm1=Pi_1.get(i+1);
			else if((i+1)<m){
				if(Lm1>0)
					Lm1=Integer.parseInt(Read_INPUT_TXT_filter.getP_R_PLACE(Lm1-1));
				else
					Lm1=Integer.parseInt(Read_INPUT_TXT_filter.getP_D_ADDRESS(-(Lm1)-1));
			}
			
			cost4=Read_distance.getDistance(Lm,P_up)+Read_distance.getDistance(P_up,Lm1)-Mu*Read_distance.getDistance(Lm,Lm1);
			cost[i]=cost4;
		}
		
		int min=0;
		double Costmin=cost[0];
		for(int i=0;i<(m-1);i++){
			if(Costmin<cost[i]){
				Costmin=cost[i];
				min=i;
			}
		}
		Pi_1.add((min+1),Best_p);
		feasibility_flag1=CheckFeasibility(Pi_1,d);
	}
	
	static void InsertDropOffLocationOfTheBestPassenger(int Best_p,int m,int d)
	{
		double cost[]=new double[Pi_1.size()];
		double cost5;		
		int down=Integer.parseInt(Read_INPUT_TXT_filter.getP_D_ADDRESS(Best_p-1));
		for(int i=0;i<(m-1);i++)
		{
			int Lm=Pi_1.get(i);
			int Lm1=Pi_1.get(i+1);
			if(i==0)
				Lm=Pi_1.get(i);
			else if(i>0){
				if(Lm>0)
					Lm=Integer.parseInt(Read_INPUT_TXT_filter.getP_R_PLACE(Lm-1));
				else
					Lm=Integer.parseInt(Read_INPUT_TXT_filter.getP_D_ADDRESS(-(Lm)-1));
				}
			
			if((i+1)==m)
				Lm1=Pi_1.get(i+1);
			else if((i+1)<(m-1)){
				if(Lm1>0)
					Lm1=Integer.parseInt(Read_INPUT_TXT_filter.getP_R_PLACE(Lm1-1));
				else
					Lm1=Integer.parseInt(Read_INPUT_TXT_filter.getP_D_ADDRESS(-(Lm1)-1));
			}
			
			cost5=Read_distance.getDistance(Lm,down)+Read_distance.getDistance(down,Lm1)-Mu*Read_distance.getDistance(Lm,Lm1);
			cost[i]=cost5;
		}
		int min=0;
		double Costmin=cost[0];
		for(int i=0;i<(m-1);i++){
			if(Costmin>cost[i]){
				min=i;
				Costmin=cost[i];
			}
		}
		Pi_1.add((min+1),-(Best_p));
		feasibility_flag2=CheckFeasibility(Pi_1,d);
	}
	
	static boolean CheckFeasibility(List<Integer> Pi,int d){
		boolean CheckFeasibility=true;
		String[] PT = null;
	
	PT=new String[Pi.size()];
	
	int j=0,m;
		for(int i=1;i<(Pi.size()-1);i++){
			 if(Pi.get(i)>0){
				 m=Pi.get(i)-1;
				 PT[i]=Read_INPUT_TXT_filter.getP_F_R_Time(m);           //乘客提早搭車時間
			 }
			 if(Pi.get(i)<0){
				 m=-(Pi.get(i))-1;
				 PT[i]=Read_INPUT_TXT_filter.getP_D_A_Time(m);         //乘客最晚下車時間
			 }
		 }
		
		// 宣告c1為TimeCalculate類別物件
		TimeCalculate c1 = new TimeCalculate();
		String Driving_time;
		int Delay_time;
		int location1,location2;
		int k=0;
		
		 Driving_time=Read_INPUT_TXT_filter.getD_F_D_Time(d);
		 Delay_time=0; m=0;
		 location1=Integer.parseInt(Read_INPUT_TXT_filter.getD_S_PLACE(d));
		 
		 for(j=1;j<(Pi.size()-1);j++){
			 try {
				if(c1.time(Driving_time,PT[j])==true)
				 {
				 if(Pi.get(j)>0){
					 k=Pi.get(j);			
						 location2=Integer.parseInt(Read_INPUT_TXT_filter.getP_R_PLACE(k-1));
						 Delay_time=(int)(c1.reducetime(Driving_time,PT[j])-Read_distance.getDistancetime(location1,location2));
						 Driving_time=c1.Addtime(PT[j],Delay_time);
						 location1=location2;
						 m++;
							 }
				 
				 else if(Pi.get(j)<0){
						 k=-Pi.get(j);
						 location2=Integer.parseInt(Read_INPUT_TXT_filter.getP_D_ADDRESS(k-1));
						 Delay_time=(int)(c1.reducetime(Driving_time,PT[j])-Read_distance.getDistancetime(location1,location2));
						 Driving_time=c1.Addtime(PT[j],Delay_time);
						 location1=location2;
						 m++; 
				 }
				 }
				 else{CheckFeasibility=false; break;}
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }	
		 try {
			if(c1.time(Driving_time,Read_INPUT_TXT_filter.getD_S_A_Time(d))==true && CheckFeasibility==true){CheckFeasibility=true;}
			 else{CheckFeasibility=false;}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	return CheckFeasibility;
	}
	
	
	static double Function(int d, List<Integer>Pi_1){
		
		double Cdj=Cdj(d,Pi_1);
		double Odj=Odj(d);
		double Fph=0;
		double Profit=0;
		for(int P=1;P<Pi_1.size()-1;P++)
		{
			if(Pi_1.get(P)>0){
				int  P1=Pi_1.get(P)-1;
				Fph=Fph+fph(P1);
			}
		}
		
		Profit=Fph-Cdj+Odj;
		return Profit;
	}
	
	
	static double Cdj(int d, List<Integer> Bdm) {

		int location1, location2, k;
		int qdjk=0;
		double route = 0;
		location1 = Integer.parseInt(Read_INPUT_TXT_filter.getD_S_PLACE(d));
		for (int i = 1; i < (Bdm.size()-1); i++) {
			if (Bdm.get(i) > 0) {
				k = Bdm.get(i);
				location2 = Integer.parseInt(Read_INPUT_TXT_filter
						.getP_R_PLACE(k - 1));
				route += Read_distance.getDistance(location1, location2);
				location1 = location2;
				qdjk++;
			} else if (Bdm.get(i) < 0) {
				k = -(Bdm.get(i));
				location2 = Integer.parseInt(Read_INPUT_TXT_filter
						.getP_D_ADDRESS(k - 1));
				route += Read_distance.getDistance(location1, location2);
				location1 = location2;
			}
		}
		location2 = Integer.parseInt(Read_INPUT_TXT_filter.getD_D_ADDRESS(d));
		route += Read_distance.getDistance(location1, location2);
		double cost = Calculate_the_function.Cdj_cost(route,
				Read_INPUT_TXT_filter.getDriverOilConsumption(d),
				Read_Generate_random_OilConsumptionBounds.Driver_OilPrice(),"Single_mode",qdjk);
		return cost;
	}
	
	static double fph(int p) {

		int location1, location2;
		double route = 0;
		location1 = Integer.parseInt(Read_INPUT_TXT_filter.getP_R_PLACE(p));
		
		location2 = Integer.parseInt(Read_INPUT_TXT_filter	.getP_D_ADDRESS(p));
		route += Read_distance.getDistance(location1, location2);
			

		double cost = Calculate_the_function.Fph_cost(route,
				Read_INPUT_TXT_filter.getPassengerOilConsumption(p),
				Read_Generate_random_OilConsumptionBounds.Passenger_OilPrice());
		return cost;
	}
	
	static double Odj(int d) {

		int location1, location2;
		double route = 0;
		location1 = Integer.parseInt(Read_INPUT_TXT_filter.getD_S_PLACE(d));
		
		location2 = Integer.parseInt(Read_INPUT_TXT_filter	.getD_D_ADDRESS(d));
		route += Read_distance.getDistance(location1, location2);
			

		double cost = Calculate_the_function.Fph_cost(route,
				Read_INPUT_TXT_filter.getDriverOilConsumption(d),
				Read_Generate_random_OilConsumptionBounds.Driver_OilPrice());
		return cost;
	}
	
}
