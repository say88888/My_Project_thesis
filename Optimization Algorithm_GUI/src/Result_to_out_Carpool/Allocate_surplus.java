package Result_to_out_Carpool;

import java.util.ArrayList;

import Input_Output_txt.Carpool.Read_TransactionFee;
import READ_TXT.Read_INPUT_TXT_filter;
import READ_TXT.Read_distance;

public class Allocate_surplus extends RideSharingDetails_scheme {

	private static ArrayList<Double> P_surplusI = new ArrayList<Double>(); // 記錄此乘客得標後共乘前利潤值
	private static ArrayList<Double> D_surplusI = new ArrayList<Double>(); // 記錄此司機得標後共乘前利潤值
	private static ArrayList<Double> P_surplusII = new ArrayList<Double>(); // 記錄此乘客得標後共乘後利潤值
	private static ArrayList<Double> D_surplusII = new ArrayList<Double>(); // 記錄此司機得標後共乘後利潤值
	
	private static ArrayList<Double> P_surplusIII = new ArrayList<Double>(); //記錄此乘客得標後共乘前利潤值
	private static ArrayList<Double> D_surplusIII = new ArrayList<Double>(); //記錄此司機得標後共乘前利潤值
	private static ArrayList<Double> P_surplusIV = new ArrayList<Double>(); 	// 記錄此乘客得標後共乘後利潤值
	private static ArrayList<Double> D_surplusIV = new ArrayList<Double>(); 	//記錄此司機得標後共乘後利潤值
	
	
	public static void Fdj_function(double[][] driverBids,int[][] Order,int[] Order_lengh)
	{
		P_surplusIII.clear();
		D_surplusIII.clear();
		P_surplusIV.clear(); 
		D_surplusIV.clear(); 
		
		double Cdj=0,Fph=0,total=0,Xobj=0,fdj;
		int w,y=0,y1=0,x=0;
		for(int i=0;i<Order_lengh.length;i++){
			if(Order_lengh[i]!=0 && driverBids[i][K]>0){
				Cdj=driverBids[i][K];    //此司機的 Cdj  
				D_distance_beforce.add(determine_XObj.getOdj_distance(i)); //此司機共乘前的距離
				Xobj=determine_XObj.getOdj(i);   //此司機共乘前 Obj 的值
				for(int j=0;j<Order_lengh[i];j++)
				{
					w=Order[i][j];
					if(w!=0){
								if(w>0){w=w-1;
								 //此乘客共乘前的 Fph
								Fph+=Read_INPUT_TXT_filter.getfph(w);  
								 //此乘客共乘前的距離
								P_distance_beforce.add(Read_distance.getDistance(Integer.parseInt(Read_INPUT_TXT_filter.getP_R_PLACE(w)),Integer.parseInt(Read_INPUT_TXT_filter.getP_D_ADDRESS(w))));
								y1++;
								}
						}
				}
				System.out.println();
				System.out.println(" 計算 Fdj的值 第 "+ (i+1) +" 位司機 ");
				System.out.println(" 乘客 Fph= "+Fph+ " 司機 Xobj= "+Xobj+" 司機 Cdj= "+Cdj+" 乘客手續費 Tpm= "+ Read_Carpool_file.getTpm()
						+" 司機手續費 Tdm= "+ Read_Carpool_file.getTdm()+" Fph*Tpm= "+(Fph*Read_Carpool_file.getTpm())+" Cdj*Tdm "+ (Cdj*Read_Carpool_file.getTdm()));
				
				fdj=Fph+Xobj-Cdj+(Fph*Read_Carpool_file.getTpm())+(Cdj*Read_Carpool_file.getTdm())-(Xobj*Read_Carpool_file.getTdm());  //總計此標的金額
				
				System.out.println(" Fdj = "+ fdj);
				
				Allocate_surplus.Schem_III_surplus(fdj,D_distance_beforce.get(x),P_distance_beforce,y,y1);      //計算方案三的利潤
				
				Allocate_surplus.Schem_IV_surplus(fdj,D_distance_after.get(x),P_distance_after,y,y1);    //計算方案四的利潤
				
				Fdj.add(fdj);
				y=y1; x++;  total+=fdj;
				Fph=0;Cdj=0;Xobj=0;
			}
		}
		System.out.print("加總各自的 Fdj = "+total);
	}
	
	
	public static void Scheme_I(int[][] Order, int[] Order_lengh,	double[][] DriverBids) throws NumberFormatException, Exception {

		P_surplusI.clear();
		D_surplusI.clear();

		double Cdj = 0, Fph = 0, total = 0, Y_Allocate_surplus, X_Allocate_surplus;
		
		int P = PassengerList.size();
		int w;
		for (int i = 0; i < Order_lengh.length; i++) {

			if (Order_lengh[i] != 0 && DriverBids[i][K] > 0) {
				Fph = 0; 
				Cdj = DriverBids[i][K];                         // 此得標司機的 Cdj 
				for (int j = 0; j < Order_lengh[i]; j++) {
					w = Order[i][j];
					if (w != 0) {
						if (w > 0) {
							w = w - 1;
							Fph += Read_INPUT_TXT_filter.getfph(w);        // 此得標乘客的 fph
						}
					}
				}
				total += Cdj + Fph;      //將 Cdj 與 fph加總
			}
		}
		//System.out.print(" total= "+ total+ " 代入F(Xdj,Yph)= " +F(Xdj,Yph) );
		for (int i = 0; i < Order_lengh.length; i++) {

			if (Order_lengh[i] != 0 && DriverBids[i][K] > 0) {

				for (int j = 0; j < Order_lengh[i]; j++) {
					w = Order[i][j];
					if (w != 0) {
						if (w > 0) {
							w = w - 1;
							// 將 對應的 Fph 除以 所有 Cdj 與 fph加總
							Y_Allocate_surplus = ((1 - Read_TransactionFee.Alpha()) * Read_INPUT_TXT_filter.getfph(w)*F(Xdj,Yph)) / total; 
							P_surplusI.add(Y_Allocate_surplus);
						}
					}
				}
				// 將 對應的 Cdj  除以 所有 Cdj 與 fph加總
				X_Allocate_surplus = ((1 - Read_TransactionFee.Alpha()) * DriverBids[i][K]*F(Xdj,Yph))/ total;
				D_surplusI.add(X_Allocate_surplus);
			}
		}
		
	}

	public static void Scheme_II(int[][] Order, int[] Order_lengh,double[][] DriverBids) throws NumberFormatException, Exception {

		P_surplusII.clear();
		D_surplusII.clear();

		double Cdj = 0, Fph = 0, Y_Allocate_surplus, X_Allocate_surplus;

		int P = PassengerList.size();
		int w;
		for (int i = 0; i < Order_lengh.length; i++) {

			if (Order_lengh[i] != 0 && DriverBids[i][K] > 0) {

				Cdj += DriverBids[i][K];          // 此得標司機的 Cdj 

				for (int j = 0; j < Order_lengh[i]; j++) {
					w = Order[i][j];
					if (w != 0) {
						if (w > 0) {
							w = w - 1;
							Fph += Read_INPUT_TXT_filter.getfph(w);   // 此得標乘客的 fph
						}
					}
				}
			}
		}

		for (int i = 0; i < Order_lengh.length; i++) {

			if (Order_lengh[i] != 0 && DriverBids[i][K] > 0) {

				for (int j = 0; j < Order_lengh[i]; j++) {
					w = Order[i][j];
					if (w != 0) {
						if (w > 0) {
							w = w - 1;
							// 將 對應的 Fph除以 fph加總
							Y_Allocate_surplus = Read_TransactionFee.Delta()*((1 - Read_TransactionFee.Alpha()) * Read_INPUT_TXT_filter.getfph(w)*F(Xdj,Yph))/Fph;
							P_surplusII.add(Y_Allocate_surplus);
						}
					}
				}
				// 將 對應的 Cdj 除以 Cdj 加總
				X_Allocate_surplus = (1-Read_TransactionFee.Delta())*((1 - Read_TransactionFee.Alpha()) * DriverBids[i][K])*F(Xdj,Yph)/Cdj;
				D_surplusII.add(X_Allocate_surplus);
			}
		}
	}
	
	public static void Schem_III_surplus(double Fdj,double X_dist,ArrayList<Double> P_distance_before,int y,int y1){
		
		double surplus,Y_dist=0;
		
		for(int i=y;i<y1;i++){
	//	System.out.println(" i= "+  i + "  P_distance= "+P_distance_after.get(i));
			Y_dist+=P_distance_after.get(i);
		}
	
		//計算乘客的利潤--------------------
		
		for(int i=y;i<y1;i++){
	//		System.out.println(" i= "+P_distance_beforce.get(i));
		surplus=(1-Read_TransactionFee.Alpha() )*Fdj*P_distance_beforce.get(i)/(Y_dist+X_dist);
			P_surplusIII.add(surplus);
		}		
		
		//計算司機的利潤-------------------
		surplus=(1-Read_TransactionFee.Alpha()) *Fdj*X_dist/(Y_dist+X_dist);
		D_surplusIII.add(surplus);
		
	
	}
	
	public static void Schem_IV_surplus(double Fdj, double X_dist, ArrayList<Double> P_distance_after, int y, int y1){
		
		double surplus=0,Y_dist=0;
		
		for(int i=y;i<y1;i++){
	//	System.out.println(" i= "+  i + "  P_distance= "+P_distance_after.get(i));
			Y_dist+=P_distance_after.get(i);
		}
		
		//System.out.println(" X_distatce= "+  X_dist);
		//計算司機的利潤-------------------
			surplus=(1 - Read_TransactionFee.Alpha()) *X_dist*Fdj/(Y_dist+X_dist);
		//	System.out.println(" D_surplus = " + surplus);
			D_surplusIV.add(surplus);
		
		
		//計算乘客的利潤--------------------
		for(int i=y;i<y1;i++){
			surplus=(1 - Read_TransactionFee.Alpha()) *Fdj* P_distance_after.get(i)/(Y_dist+X_dist);
	//		System.out.println(" P_surplus = " + surplus);
			P_surplusIV.add(surplus);
		}
	}
	
	
	public static double  F(int[] x,int[] y){
			double fitness = 0;
			
			int[][] Y = new int[P][];
			for (int i = 0; i < P; i++)
				Y[i] = new int[Read_Carpool_file.getHp(i)];
			int[][] X = new int[D][];
			for (int i = 0; i < D; i++)
				X[i] = new int[Read_Carpool_file.getJd(i)];
			int c=0;
			for (int i = 0; i < P; i++)
				for (int j = 0; j < Y[i].length; j++)
					Y[i][j] = y[c++];

			int b = 0;
			for (int i = 0; i < D; i++)
				for (int j = 0; j < X[i].length; j++)
					X[i][j] = x[b++];
			
			for (int p = 0; p < P; p++)
				for (int h = 0; h < Y[p].length; h++) {
			fitness += Y[p][h] * Read_Carpool_file.getfph(p, h);
			fitness += Y[p][h] * Read_Carpool_file.getTpm()
					* Read_Carpool_file.getfph(p, h);
		}
			
			for (int d = 0; d < D; d++)
				for (int j = 0; j < X[d].length; j++) {
			fitness -= X[d][j]
					* (Read_Carpool_file.getCdj(d, j) - determine_XObj.getOdj(d));
			fitness += X[d][j] * Read_Carpool_file.getTdm()
					* (Read_Carpool_file.getCdj(d, j) - determine_XObj.getOdj(d));
		}
			return fitness;
}

	public static ArrayList<Double> P_surplus_I() {
		return P_surplusI;
	}

	public static ArrayList<Double> D_surplus_I() {
		return D_surplusI;
	}

	public static ArrayList<Double> P_surplus_II() {
		return P_surplusII;
	}

	public static ArrayList<Double> D_surplus_II() {
		return D_surplusII;
	}
	public static ArrayList<Double> P_surplus_III() {
		return P_surplusIII;
	}

	public static ArrayList<Double> D_surplus_III() {
		return D_surplusIII;
	}

	public static ArrayList<Double> P_surplus_IV() {
		return P_surplusIV;
	}

	public static ArrayList<Double> D_surplus_IV() {
		return D_surplusIV;
	}
}
