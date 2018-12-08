package Result_to_out_Carpool;

import carpool_Alogorithm_MOD.Calculate_the_function;
import Generate_random_data.Read_Generate_random_OilConsumptionBounds;
import Input_Output_txt.Carpool.Read_TransactionFee;
import READ_TXT.Read_INPUT_TXT_filter;

public class Function_Objective  extends carpool_results_test{

	private static double cp_all_actual;
	private static double cp_d;
	private static double cp_p;
	
	private static double aps;
	private static double ads;
	
	public static void F1() {
		
		System.out.println();
		System.out.println("新增的 式子計算 目標函式" );
		
		double fitness = 0, fitness2 = 0,fitness5=0;
		int c = 0;
		
		int[][] Y = new int[Read_Carpool_file.getP()][];
		for (int i = 0; i < Read_Carpool_file.getP(); i++)
			Y[i] = new int[Read_Carpool_file.getHp(i)];
		int[][] X = new int[Read_Carpool_file.getD()][];
		for (int i = 0; i < Read_Carpool_file.getD(); i++)
			X[i] = new int[Read_Carpool_file.getJd(i)];

		System.out.print(" Yph =  ");
		int b = 0;
		for (int i = 0; i < Y.length; i++)
			for (int j = 0; j < Y[i].length; j++){
				Y[i][j] = Yph[c++];
				System.out.print(Y[i][j]+ "  ");
			}
		System.out.println();
		System.out.print(" Xdj  =  ");
		for (int i = 0; i < X.length; i++)
			for (int j = 0; j < X[i].length; j++){
				X[i][j] = Xdj[b++];
				System.out.print(X[i][j] + "  ");
		}
		System.out.println();
		for (int p = 0; p < P; p++)
			for (int h = 0; h < Y[p].length; h++) {
				fitness += Y[p][h] * Read_Carpool_file.getfph(p, h);
				fitness += Y[p][h] * Read_Carpool_file.getTpm()* Read_Carpool_file.getfph(p, h);
				fitness2 += Y[p][h];
				
				fitness5+=Y[p][h] * Read_Carpool_file.getfph(p, h);
			}
		
		for (int d = 0; d < D; d++)
			for (int j = 0; j < X[d].length; j++) {
				fitness -= (X[d][j]* (DriverBids[d][K] - determine_XObj.getOdj(d)));
				
				fitness += (X[d][j] * Read_Carpool_file.getTdm()* (DriverBids[d][K] - determine_XObj.getOdj(d)));
				
				fitness2 += X[d][j];
				
				fitness5+=X[d][j] * (DriverBids[d][K]) ;
			}

		ads(X,fitness);
		aps(Y,fitness);
		double O3=fitness/fitness2;
		double O5=fitness/fitness5;
		fitness5 = (fitness/fitness5)*Omega_5;
		
		cp_all_actual(X,Y);
		double O6=cp_all_actual;
		

		cp_d(X,Y);
		cp_p(X,Y);
		
		double O4=wp*aps+wd*ads;
		double O7=wp1*cp_p+wd1*cp_d;
		
		System.out.println("Omega_1 = " + Omega_1 );
		System.out.println("Objectived1 = " + fitness );
		System.out.println("Omega_1*Objectived1 =" + (fitness*Omega_1));
		System.out.println();
		System.out.println("Omega_2 = " + Omega_2 );
		System.out.println("Objectived2 = " + fitness2 );
		System.out.println("Omega_2*Objectived2 = " + (fitness2*Omega_2));
		System.out.println();
		System.out.println("Omega_3 = " + Omega_3 );
		System.out.println("Objectived3 = " + O3 );
		System.out.println("Omega_3*Objectived3 = " + (O3)*Omega_3);
		System.out.println();
		System.out.println("Omega_4 = " + Omega_4 );
		System.out.println("aps = " + aps  +"  wp= " +wp );
		System.out.println("ads = " + ads +" wd= "+wd);
		System.out.println("Objectived4 = " + O4 );
		System.out.println("Omega_4*Objectived4 = " + (O4)*Omega_4);
		System.out.println();
		System.out.println("Omega_5 = " + Omega_5);
		System.out.println("Objectived5 = " + O5 );
		System.out.println("Omega_5*Objectived5 = " + (O5)*Omega_5);
		System.out.println();
		System.out.println("Omega_6 = " + Omega_6);
		System.out.println("Objectived6 = " + cp_all_actual );
		System.out.println("Omega_6*Objectived6 = " + (O6)*Omega_6);
		System.out.println();
		System.out.println("Omega_7 = " + Omega_7);
		System.out.println("cp_p = " + cp_p  +"  wp1= " +wp1 );
		System.out.println("cp_d = " + cp_d +" wd1= "+wd1);
		System.out.println("Objectived7 = " + O7 );
		System.out.println("Omega_7*Objectived7 = " + (O7)*Omega_7);
		System.out.println();
		
		
	}
	
	static void cp_all_actual(int[][] X,int[][] Y)
	{
		double fitness = 0;
		double after_cdj=0;
		double after_fph=0;
		

		for (int d = 0; d < D; d++)
			for (int j = 0; j < X[d].length; j++) {
				fitness -= (X[d][j]* (DriverBids[d][K] - determine_XObj.getOdj(d)));
				fitness += (X[d][j] * Read_Carpool_file.getTdm()* (DriverBids[d][K] - determine_XObj.getOdj(d)));
				after_cdj+=X[d][j] *DriverBids[d][K];
			}
		
		for(int i=0;i<carpool_after_distance.P_ID_size();i++)
		{
			int d=carpool_after_distance.P_as_D().get(i);
			after_fph+=Calculate_the_function.Fph_cost(carpool_after_distance.P_distance().get(i), Read_INPUT_TXT_filter.getDriverOilConsumption(d), Read_Generate_random_OilConsumptionBounds.Driver_OilPrice());
		}
		
		int ph=0;
		for (int p = 0; p < P; p++)
			for (int h = 0; h < Y[p].length; h++) {
				fitness += Y[p][h] * Read_Carpool_file.getfph(p, h);
				fitness += Y[p][h] * Read_Carpool_file.getTpm()* Read_Carpool_file.getfph(p, h);
				if(Y[p][h]==1)
				{
					if(! carpool_after_distance.P_ID().contains(Read_INPUT_TXT_filter.getP_ID(ph)))
					after_fph+=Y[p][h] * Read_Carpool_file.getfph(p, h);
				}
				ph++;
			}
		
		
		cp_all_actual=fitness/(after_cdj+after_fph);
	}
	
	static void cp_p(int[][] X,int[][] Y)
	{
		double fitness = 0;
		double after_fph=0;
		
		for (int p = 0; p < P; p++)
			for (int h = 0; h < Y[p].length; h++) {
				fitness += Y[p][h] * Read_Carpool_file.getfph(p, h);
				fitness += Y[p][h] * Read_Carpool_file.getTpm()* Read_Carpool_file.getfph(p, h);
			}
		
		for (int d = 0; d < D; d++)
			for (int j = 0; j < X[d].length; j++) {
				fitness -= (X[d][j]* (DriverBids[d][K] - determine_XObj.getOdj(d)));
				fitness += (X[d][j] * Read_Carpool_file.getTdm()* (DriverBids[d][K] - determine_XObj.getOdj(d)));
			}
		
		
		for(int i=0;i<carpool_after_distance.P_ID_size();i++)
		{
			int d=carpool_after_distance.P_as_D().get(i);
			after_fph+=Calculate_the_function.Fph_cost(carpool_after_distance.P_distance().get(i), Read_INPUT_TXT_filter.getDriverOilConsumption(d), Read_Generate_random_OilConsumptionBounds.Driver_OilPrice());
		}
		
		cp_p= (Read_TransactionFee.Delta()*fitness)/after_fph;
	}
	
	static void cp_d(int[][] X,int[][] Y)
	{
		double fitness = 0;
		double after_cdj=0;
		
		for (int p = 0; p < P; p++)
			for (int h = 0; h < Y[p].length; h++) {
				fitness += Y[p][h] * Read_Carpool_file.getfph(p, h);
				fitness += Y[p][h] * Read_Carpool_file.getTpm()* Read_Carpool_file.getfph(p, h);
			}
		
		for (int d = 0; d < D; d++)
			for (int j = 0; j < X[d].length; j++) {
				fitness -= (X[d][j]* (DriverBids[d][K] - determine_XObj.getOdj(d)));
				fitness += (X[d][j] * Read_Carpool_file.getTdm()* (DriverBids[d][K] - determine_XObj.getOdj(d)));
				after_cdj+=X[d][j]*DriverBids[d][K];
			}
		
		cp_d=(1-Read_TransactionFee.Delta())*fitness/after_cdj;
		
	}
	static void aps(int[][] Y,double fitness)
	{
		int yph=0;
		for (int p = 0; p < P; p++)
			for (int h = 0; h < Y[p].length; h++)
				if(Y[p][h]==1)
				{
					yph++;
				}
		
		 if(yph!=0) {
				aps=(Read_TransactionFee.Delta())*fitness/(yph);
			 }else {
				 aps=0;
			 }
	}
	
	static void ads(int[][] X,double fitness)
	{
		int xdj=0;
		for (int d = 0; d < D; d++)
			for (int j = 0; j < X[d].length; j++) 
				if(X[d][j]==1) {
					xdj++;
				}
		
		 if(xdj!=0) {
				ads=(1-Read_TransactionFee.Delta())*fitness/(xdj);
				}else {
				ads=0;
			}
	}
	
}
