package Algorithm_Carpool.DE_Real_AB_2Si_ApproachII;

 import java.util.ArrayList;
import java.util.List;

import Generate_random_data.Read_Generate_random_OilConsumptionBounds;
import Input_Output_txt.Carpool.Read_TransactionFee;
import Input_Output_txt.Carpool.Read_file;
import READ_TXT.Read_INPUT_TXT_filter;
import READ_TXT.Read_distance;
import carpool_Alogorithm_MOD.Calculate_the_function;

public class Object_Function extends  DE_Real_AB_2Si_ApproachII{

	private static double cp_all_actual;
	private static double cp_d;
	private static double cp_p;

	private static double ads;
	private static double aps;
	
	
	private static ArrayList<String> P_ID = new ArrayList<String>();  //紀錄得標乘客ID
	private static ArrayList<Double> P_distance = new ArrayList<Double>(); //記錄此乘客得標後所行駛距離
	
	private static double after_Fph=0;
	private static double after_Cdj=0;
	
	private static double Xdj=0;
	private static double Yph=0;
	
	public static void Function(int[][] X, int[][] Y, List<List<Integer>> Bdm){
		after_Fph=0;
		after_Cdj=0;
		P_ID.clear();
		P_distance.clear();
		Xdj=0;
		Yph=0;
		
		double fitness = 0;

		for (int d = 0; d < D; d++)
			for (int j = 0; j < X[d].length; j++) {
				fitness -= X[d][j]* (Cdj(d, Bdm.get(d)) - Odj(d));
				fitness += X[d][j] * Read_file.getTdm()*(Cdj(d, Bdm.get(d)) - Odj(d));
				after_Cdj+=X[d][j] * Cdj(d, Bdm.get(d));
				if(X[d][j]==1){
					after_Fph(d,Bdm.get(d));
					Xdj++;
				}
			}
		int ph=0;
		for (int p = 0; p < P; p++)
			for (int h = 0; h < Y[p].length; h++) {
				fitness += Y[p][h] * fph(p);
				fitness += Y[p][h] * Read_file.getTpm()*fph(p);
				if(Y[p][h]==1)
				{
					if(!P_ID.contains(Read_INPUT_TXT_filter.getP_ID(ph))) {
						after_Fph+=Y[p][h] * fph(p);
						Yph++;
					}
				}
				ph++;
			}
		
		Caculate_the_cp_all_actual(fitness);
		Caculate_the_cp_p(fitness);
		Caculate_the_cp_d(fitness);
		Caculate_the_aps(fitness);
		Caculate_the_ads(fitness);
	}
	
	 static void Caculate_the_cp_all_actual(double fitness){
		 if((after_Cdj+after_Fph)!=0) {
		 cp_all_actual=fitness/(after_Cdj+after_Fph);
		 }else {
			 cp_all_actual=0;
		 }
		//	System.out.println("cp_all_actual= "+fitness/(after_Cdj+after_Fph));
	 }
	 
	 static void Caculate_the_cp_p(double fitness){
		 if(after_Fph!=0) {
			cp_p=(Read_TransactionFee.Delta())*fitness/after_Fph;
		 }else {
			 cp_p=0;
		 }
		//	System.out.println("cp_p= "+(1-Read_TransactionFee.Delta())*fitness/after_Fph);
	 }

	 static void Caculate_the_cp_d(double fitness){
			if(after_Cdj!=0) {
				cp_d=(1-Read_TransactionFee.Delta())*fitness/(after_Cdj);
			}else {
				cp_d=0;
			}
			//	System.out.println("cp_all_actual= "+(1-Read_TransactionFee.Delta())*fitness/(after_Cdj));
				
		 }
	 
	 static void Caculate_the_aps(double fitness){
		 if(Yph!=0) {
			aps=(Read_TransactionFee.Delta())*fitness/(Yph);
		 }else {
			 aps=0;
		 }
		
	 }
	 
	 static void Caculate_the_ads(double fitness)  {
			if(Xdj!=0) {
			ads=(1-Read_TransactionFee.Delta())*fitness/(Xdj);
			}else {
				ads=0;
			}
	 }
	 
	
	static void after_Fph(int d,List<Integer> Bdm) {
		// TODO Auto-generated method stub
		
		//宣告d1為Read_distance類別物件
		int location1,location2;
		
		int n=0,l=0,k=0,S;
		
			int[] P_ID_B=new int[K*2];
			double[] P_ID_B_distance=new double[K*2];
			int M,o=0,p=0,R=0;
			double P_ID_route=0;
			int[] PP=new int [K*2];
			
			l=0;
			//先將乘客弄出來
			for(int i = 0; i < Bdm.size(); i++)
				if(Bdm.get(i) > 0)
				{
					P_ID_B[l]=k;		
					l++;
				}		
				k=0;
			for(int i = 0; i < Bdm.size(); i++)
			{		
				if(Bdm.get(i)>0){
					k++;
					PP[R]=k;
				}
			}
	
			//對照著順序將 個別的距離都算出來------------------------------------
			
				for(int j=0;j<Bdm.size();j++)
				{
					M=P_ID_B[n];
					k=Bdm.get(j);
					if(k==M && k!=0){
					P_ID_route=0;
					location1=Integer.parseInt(Read_INPUT_TXT_filter.getP_R_PLACE(M-1));
					for(o=j;o<Bdm.size();o++)
					{
						p=Bdm.get(o);
						if(p>0)
						{
						S=p;
						location2=Integer.parseInt(Read_INPUT_TXT_filter.getP_R_PLACE(S-1));
						P_ID_route += Read_distance.getDistance(location1,location2);
						location1=location2;
						}
					else if(p<0)
						{
						S=-p;
						location2=Integer.parseInt(Read_INPUT_TXT_filter.getP_D_ADDRESS(S-1));
						P_ID_route += Read_distance.getDistance(location1,location2);
						location1=location2;
						}
					if(k==-p){
						P_ID_B_distance[n]=P_ID_route;
						after_Fph+=Calculate_the_function.Fph_cost(P_ID_route, Read_INPUT_TXT_filter.getDriverOilConsumption(d), Read_Generate_random_OilConsumptionBounds.Driver_OilPrice());
						n++; 
						break;}
					}
				}
					if(n==l){break;}
				}
			
			k=0;
			

			
			for(int i=0;i<l;i++)
			{
				if(P_ID_B[i]>0){
				P_ID.add(Read_INPUT_TXT_filter.getP_ID(P_ID_B[i]-1));
				P_distance.add(P_ID_B_distance[i]);
				}
			}	
		}
	
	
	static double Cdj(int d, List<Integer> Bdm) {

		int location1, location2, k;
		int qdjk=0;
		double route = 0;
		location1 = Integer.parseInt(Read_INPUT_TXT_filter.getD_S_PLACE(d));
		for (int i = 0; i < Bdm.size(); i++) {
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
	
	public static double get_cp_all_actual(){
		return cp_all_actual;
	}
	
	public static double get_cp_p(){
		return cp_p;
	}
	
	public static double get_cp_d(){
		return cp_d;
	}
	public static double get_ads(){
		return ads;
	}
	
	public static double get_aps(){
		return aps;
	}
	
}
