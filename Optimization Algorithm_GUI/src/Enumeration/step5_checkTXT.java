package Enumeration;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import carpool_Alogorithm_MOD.Calculate_the_function;
import Generate_random_data.Read_Generate_random_OilConsumptionBounds;
import READ_TXT.Read_INPUT_TXT_filter;
import READ_TXT.READ_P;
import READ_TXT.Read_distance;
import READ_TXT.check_TXT;

public class step5_checkTXT extends Enumeration{

	private static int[][] PX;                 //初始P 順序矩陣
	private static String[][] PT;             //初始P 時間矩陣
	private static int P_high;
	private static String[][] C_String;
	private static String[][] P_String;
	private static int[] C_String_length;
	private static int[] P_String_length;
	private static int P;
	private static int D;
	private static String[] Com;
	private static String[] Per;
	public static void main() throws Exception {
		
		Read_INPUT_TXT_filter.loadData();
		Read_Generate_random_OilConsumptionBounds.main();
		check_TXT.main();
		//GoogleAPI_matrix.main();
		int i,j,k,l;
		P = Read_INPUT_TXT_filter.getP();
		D = Read_INPUT_TXT_filter.getD();
		P_high=check_TXT.getP_high();
		C_String=new String[P_high][10];
		P_String=new String[P_high][10];
		C_String_length=new int[P_high];
		P_String_length=new int[P_high];
		Com=new String[P_high];
		Per=new String[P_high];
		
		for(i=0;i<P_high;i++){
			C_String_length[i]=check_TXT.getC_length(i);
			P_String_length[i]=check_TXT.getP_length(i);
			String result="";
			String result1="";
			for(j=0;j<C_String_length[i];j++){
			C_String[i][j]=check_TXT.getC_String(i, j);
			result+=C_String[i][j];
			}
			for(j=0;j<P_String_length[i];j++){
			P_String[i][j]=check_TXT.getP_String(i, j);
			if(j+1<P_String_length[i]){result1+=P_String[i][j]+"_";}
			if(j+1==P_String_length[i]){result1+=P_String[i][j];}
			}
			Com[i]=result;
			Per[i]=result1;
		}

		PX = new int[P_high][];
		PT = new String[P_high][];
		
	 for (i = 0; i < P_high; i++){
			PX[i] = new int[P_String_length[i]];
	 }
	 
	 
	 for (i = 0; i < P_high; i++){
		 for(j=0;j<PX[i].length;j++){
		 PX[i][j] = Integer.parseInt(P_String[i][j]);
		 System.out.print(PX[i][j]+" ");
		 }}
	 
		double[] Dcost = new double[P_high];                             // 司機成本
		int location1,location2;
		double route;
		int qdjk=0;
		for( i=0;i<P_high;i++){
			route=0;
			location1=Integer.parseInt(Read_INPUT_TXT_filter.getD_S_PLACE(d));
			for(j=0;j<PX[i].length;j++){
			if(PX[i][j]>0)
			{
				k=PX[i][j];
				 location2=Integer.parseInt(Read_INPUT_TXT_filter.getP_R_PLACE(k-1));
				route+=Read_distance.getDistance(location1,location2);
				location1=location2;
				qdjk++;
			}
			else if(PX[i][j]<0)
			{
				k=-(PX[i][j]);
				location2=Integer.parseInt(Read_INPUT_TXT_filter.getP_D_ADDRESS(k-1));
				route+=Read_distance.getDistance(location1,location2);
				location1=location2;
			}
			}
			location2=Integer.parseInt(Read_INPUT_TXT_filter.getD_D_ADDRESS(d));
			route+=Read_distance.getDistance(location1,location2);
			Dcost[i]+=Calculate_the_function.Cdj_cost(route,Read_INPUT_TXT_filter.getDriverOilConsumption(d),Read_Generate_random_OilConsumptionBounds.Driver_OilPrice(),"Single_mode",qdjk);
		System.out.println(Dcost[i]);
		}
		
		Make_Carpool_data.make_DriverBids.makebids(P_high,PX,Dcost,Com,Per);
		Make_Carpool_data.make_Parameter.makebids(P_high, Com, Per);
		Make_Carpool_data.make_PassengerBids.makebids(P_high, Com,Per);
		Make_Carpool_data.make_order.makebids(P_high,Com,Per,PX);
	}
	
}
