package Algorithm_Carpool.Lagrangian_Relaxation_and_PSO2_P;

import java.util.ArrayList;

import Generate_random_data.Read_Generate_random_OilConsumptionBounds;
import Input_Output_txt.Carpool.Read_TransactionFee;
import Input_Output_txt.Carpool.Read_file;
import READ_TXT.Read_INPUT_TXT_filter;
import READ_TXT.Read_distance;
import carpool_Alogorithm_MOD.Calculate_the_function;

public class Object_Function extends LR_and_PSO2_P{

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
	
	public static void Function(int[][] X, int[][] Y) {
		double fitness = 0;
		P_ID.clear();
		P_distance.clear();
		after_Fph=0;
		after_Cdj=0;
		Xdj=0;
		Yph=0;
		
		int dj=0;
		for (int d = 0; d < D; d++)
			for (int j = 0; j < X[d].length; j++) {
				if(X[d][j]==1)
				{
					after_Cdj+=X[d][j]* (Read_file.getCdj(d, j));
					after_Fph(d,dj);
					Xdj++;
					fitness -= X[d][j]
							* (Read_file.getCdj(d, j) - Read_file.getOdj(d, j));
					fitness += X[d][j] * Read_file.getTdm()
							* (Read_file.getCdj(d, j) - Read_file.getOdj(d, j));
				}
				dj++;
			}
		
		 int ph=0;
			for (int p = 0; p < P; p++)
				for (int h = 0; h < Y[p].length; h++) {
					if(Y[p][h] ==1)
					{
						if(!P_ID.contains(Read_INPUT_TXT_filter.getP_ID(ph)))
							{
								after_Fph+=Y[p][h] * Read_file.getfph(p, h);
								Yph++;
								fitness += Y[p][h] * Read_file.getfph(p, h);
								fitness += Y[p][h] * Read_file.getTpm()
										* Read_file.getfph(p, h);
							}
					}
					ph++;
				}
		//	System.out.println("fitness= "+fitness);
		//	System.out.println("after_Fph= "+after_Fph);
		//	System.out.println("after_Cdj= "+after_Cdj);
			
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
	 
	 static void Caculate_the_cp_p(double fitness) {
		 if(after_Fph!=0) {
			cp_p=(Read_TransactionFee.Delta())*fitness/after_Fph;
		 }else {
			 cp_p=0;
		 }
		//	System.out.println("cp_p= "+(1-Read_TransactionFee.Delta())*fitness/after_Fph);
	 }

	 static void Caculate_the_cp_d(double fitness) {
			if(after_Cdj!=0) {
				cp_d=(1-Read_TransactionFee.Delta())*fitness/(after_Cdj);
			}else {
				cp_d=0;
			}
			//	System.out.println("cp_all_actual= "+(1-Read_TransactionFee.Delta())*fitness/(after_Cdj));
				
		 }
	 
	 static void Caculate_the_aps(double fitness) {
		 if(Yph!=0) {
			aps=(Read_TransactionFee.Delta())*fitness/(Yph);
		 }else {
			 aps=0;
		 }
		
	 }
	 
	 static void Caculate_the_ads(double fitness) {
			if(Xdj!=0) {
			ads=(1-Read_TransactionFee.Delta())*fitness/(Xdj);
			}else {
				ads=0;
			}
	 }
	 
	static void after_Fph(int d,int dj){
		// TODO Auto-generated method stub
		int location1,location2;
		
		int i,j,n=0,l=0,k=0,S;
		
			int[] P_ID_B=new int[Ysize];
			double[] P_ID_B_distance=new double[Ysize];
			int M,o=0,p=0,R=0;
			double P_ID_route=0;
			int[] PP=new int [Ysize];
			
			l=0;
			//先將乘客弄出來
				for(j=0;j<Order_lengh[dj];j++)
				{		
					k=Order[dj][j];
						if(k>0)
						{P_ID_B[l]=k;
					l++;}		
				}
				k=0;
				for(j=0;j<Order_lengh[dj];j++)
				{		
					if(Order[dj][j]>0){
					k++;
					PP[R]=k;
					}
				}
			
	
			//對照著順序將 個別的距離都算出來------------------------------------
	
				for(j=0;j<Order_lengh[dj];j++)
				{
					M=P_ID_B[n];
					k=Order[dj][j];
					if(k==M && k!=0){
					P_ID_route=0;
					location1=Integer.parseInt(Read_INPUT_TXT_filter.getP_R_PLACE(M-1));
					for(o=j;o<Order_lengh[dj];o++)
					{
						p=Order[dj][o];
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
			
			for(i=0;i<l;i++)
			{
				if(P_ID_B[i]>0){
				P_ID.add(Read_INPUT_TXT_filter.getP_ID(P_ID_B[i]-1));
				P_distance.add(P_ID_B_distance[i]);
				}
			}
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
