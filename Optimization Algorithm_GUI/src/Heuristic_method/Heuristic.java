package Heuristic_method;

import java.util.ArrayList;

import Enumeration.select_Neighborhood_rule1;
import Generate_random_data.Read_Generate_random_OilConsumptionBounds;
import READ_TXT.Read_INPUT_TXT_filter;

public class Heuristic {
	public static int d;
	public static double[][] DriverBids;
	public static double[] Dcost;
	public static double[][] PassengerBids;
	public static double[][] Parameter;
	public static int[][] Orders;
	
	public static ArrayList<String> PassengerList = new ArrayList<String>();

	public static ArrayList<String> DriverBidList = new ArrayList<String>();
	public static ArrayList<String> DriverBidList1 = new ArrayList<String>();
	
	public static ArrayList<String> PassengerBidList = new ArrayList<String>();
	public static ArrayList<String> PassengerBidList1 = new ArrayList<String>();
	public static ArrayList<Integer> PassengerBidList2 = new ArrayList<Integer>();
	
	public static void main( ) throws Exception {
		// TODO Auto-generated method stub
		PassengerList.clear();
		DriverBidList .clear();
		DriverBidList1.clear();
		PassengerBidList.clear();
		PassengerBidList1.clear();
		PassengerBidList2.clear();
		Read_INPUT_TXT_filter.loadData();
	//	Read_INPUT_TXT.loadData();
		Read_Generate_random_OilConsumptionBounds.main();
		Orders=new int[Read_INPUT_TXT_filter.getD()][8];
		
		for(int i=0;i<Read_INPUT_TXT_filter.getP();i++){
			//判斷是否已有此字串
			if(!PassengerList.contains(Read_INPUT_TXT_filter.getP_ID(i))){
			  //無字串,加入字串
				PassengerList.add(Read_INPUT_TXT_filter.getP_ID(i));
			}
		}
		
		for(int i=0;i<Read_INPUT_TXT_filter.getP();i++){
			//判斷是否已有此字串
			if(!PassengerBidList1.contains(Read_INPUT_TXT_filter.getP_R_PLACE(i)) || !PassengerBidList.contains(Read_INPUT_TXT_filter.getP_ID(i))){
			  //無字串,加入字串
				PassengerBidList1.add(Read_INPUT_TXT_filter.getP_R_PLACE(i));
				PassengerBidList.add(Read_INPUT_TXT_filter.getP_ID(i));
				PassengerBidList2.add(i);
			}
		}
		
		for(int i=0;i<Read_INPUT_TXT_filter.getP();i++){
			//判斷是否已有此字串
			if(!DriverBidList1.contains(Read_INPUT_TXT_filter.getP_R_PLACE(i)) || !DriverBidList.contains(Read_INPUT_TXT_filter.getP_ID(i))){
			  //無字串,加入字串
				DriverBidList1.add(Read_INPUT_TXT_filter.getP_R_PLACE(i));
				DriverBidList.add(Read_INPUT_TXT_filter.getP_ID(i));
			}
		}
		
		System.out.println(PassengerList.size());
		for(int i=0;i<PassengerList.size();i++){System.out.print(PassengerList.get(i)+"  ");}
		System.out.println();
		
		DriverBids=new  double[Read_INPUT_TXT_filter.getD()][DriverBidList.size()*2+4];
		for(int i=0;i<Read_INPUT_TXT_filter.getD();i++)
			for(int j=0;j<(DriverBidList.size()*2+4);j++)
				DriverBids[i][j]=0;
		
		Dcost=new double[Read_INPUT_TXT_filter.getD()];
		
		PassengerBids=new double[PassengerList.size()][PassengerBidList.size()+1];
		for(int i=0;i<PassengerList.size();i++)
			for(int j=0;j<PassengerBidList.size()+1;j++)
				PassengerBids[i][j]=0;
		
		
		for(int i=0;i<Read_INPUT_TXT_filter.getD();i++){Dcost[i]=0;}
		
		select_Neighborhood_rule1.main();
		System.out.println("--------------------------------");
		for( d=0;d<Read_INPUT_TXT_filter.getD();d++){
			if(select_Neighborhood_rule1.DP().get(d).get(0)!=0)
		 step2.main();
		}
		
		//建立檔案
		male_bids_and_data.make_Orders();
		male_bids_and_data.make_DriverBids();
		male_bids_and_data.make_PassengerBids();
		 male_bids_and_data.make_Parameter();
		 
		 step3_checkOdj.main();
	}

}
