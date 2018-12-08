package Result_to_out_Carpool;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

import carpool_Alogorithm_MOD.Calculate_the_function;
import Generate_random_data.Read_Generate_random_OilConsumptionBounds;
import READ_TXT.READ_XY_and_Order;
import READ_TXT.Read_INPUT_TXT_filter;
import READ_TXT.Read_distance;

public class Algorithm_for_Adjustment_cost extends Adjust{

	private static final double NULL = 0;
	private static double[][] Jud_this_Bids ;
	private static int[][] Jud_Order;
	
	//-------------------------------------------------------------------
	//--------------演算整體成本-------------------------------
	public static double Cost(double[][] bids) throws Exception {
		
	//	Read_distance.Read_distance();	
	//	Read_Generate_random_OilConsumptionBounds.main();
	//	READ_XY_and_Order.main();
	
		int location1,location2;
		int[] DB=new int[D];
		int[] Order_lengh = new int[D];
		double[] Dcost = new double[D]; // 司機成本
		double Xcost = 0;
		int i,j,k,n = 0,S;
		//宣告d1為Read_distance類別物件
		
		System.out.println("---------計算各個的投標-----------");
		
		Jud_this_Bids=bids;
		
		
		for(i=0;i<D;i++){
			for(j=0;j<K;j++){
				System.out.print(Jud_this_Bids[i][j]+" ");
			}
			System.out.println();
		}
		
		Jud_Order = new int[D][K*2];
		
		//----------將順序代入-------------------------------------
		for (i = 0; i < D; i++){
			if(READ_XY_and_Order.getDB(i)<0){DB[i]=0;}
			if(READ_XY_and_Order.getDB(i)>=0){DB[i]=READ_XY_and_Order.getDB(i);}
			
	//		System.out.println("DB= "+DB[i]+" ");
			
			if(DB[i]==0){Order_lengh[i]=0;}
			if(DB[i]>0){Order_lengh[i]=READ_XY_and_Order.getOrder_lengh(DB[i]-1);}
			
	//		System.out.println("Order_lengh= "+Order_lengh[i]+" ");
			
		if(Order_lengh[i]>0){
			for(j=0;j<Order_lengh[i];j++)
			{
				Jud_Order[i][j]=READ_XY_and_Order.getOrder(DB[i]-1,j);
	//			System.out.print(Jud_Order[i][j]+" ");
			}
			}
		}
		
		if(data_mode.equals("Single_mode")){
		for( i=0;i<Jud_this_Bids.length;i++){
			int lengh=Order_lengh[i];
			ArrayList<Integer> b = new ArrayList<Integer>();
			
			for( j=0;j<Jud_this_Bids[i].length;j++){
				if(Jud_this_Bids[i][j]==0){
					for(int x=0;x<Read_INPUT_TXT_filter.getP();x++)
						if(PassengerList.get(j).equals(Read_INPUT_TXT_filter.getP_ID(x)) 
								&& PassengerList1.get(j).equals(Read_INPUT_TXT_filter.getP_R_PLACE(x)) ){
						b.add(x+1);}
				}
			}
				for(j=0;j<Order_lengh[i];j++){
					for( k=0;k<b.size();k++){
					if(Jud_Order[i][j]==b.get(k) || Jud_Order[i][j]==(-b.get(k))){
						Jud_Order[i][j]=0;
						lengh-=1;
					}
				}
				}
				if(lengh==0){Order_lengh[i]=0;}
		}
		}else{
			for( i=0;i<Jud_this_Bids.length;i++){
				int lengh=Order_lengh[i];
				ArrayList<Integer> b = new ArrayList<Integer>();
				
				for( j=0;j<Jud_this_Bids[i].length;j++){
					if(Jud_this_Bids[i][j]==0){
						for(int x=0;x<Read_INPUT_TXT_filter.getP();x++)
							if(PassengerList.get(j).equals(Read_INPUT_TXT_filter.getP_D_ADDRESS(x)) 
									&& PassengerList1.get(j).equals(Read_INPUT_TXT_filter.getP_R_PLACE(x)) ){
							b.add(x+1);}
					}
				}
					for(j=0;j<Order_lengh[i];j++){
						for( k=0;k<b.size();k++){
						if(Jud_Order[i][j]==b.get(k) || Jud_Order[i][j]==(-b.get(k))){
							Jud_Order[i][j]=0;
							lengh-=1;
						}
					}
					}
					if(lengh==0){Order_lengh[i]=0;}
			}
		}
		
		for(i=0;i<Jud_Order.length;i++){
			for(j=0;j<Order_lengh[i];j++)
				System.out.print(Jud_Order[i][j]+" ");
			System.out.println();
		}
		
		//-----------------計算成本----------------------------------------------
		double Route=0;
		for(i=0;i<Jud_Order.length;i++){	
			location1=Integer.parseInt(Read_INPUT_TXT_filter.getD_S_PLACE(i));
			for(j=0;j<Order_lengh[i];j++)
			{
				k=Jud_Order[i][j];
				if(k>0)
				{
					S=k;
					 location2=Integer.parseInt(Read_INPUT_TXT_filter.getP_R_PLACE(S-1));
					 Route+=Read_distance.getDistance(location1,location2);
					 location1=location2;
					n++;
				}
				else if(k<0)
				{
					S=-k;
					location2=Integer.parseInt(Read_INPUT_TXT_filter.getP_D_ADDRESS(S-1));
					 Route+=Read_distance.getDistance(location1,location2);
					 location1=location2;
				}
			}
			if(n>0){
			location2=Integer.parseInt(Read_INPUT_TXT_filter.getD_D_ADDRESS(i));
			Route+=Read_distance.getDistance(location1,location2);
			Dcost[i]+=Calculate_the_function.Cdj_cost(Route,Read_INPUT_TXT_filter.getDriverOilConsumption(i),Read_Generate_random_OilConsumptionBounds.Driver_OilPrice(),data_mode,n);
			}
		 n=0;
		 Route=0;
		 Xcost+=Dcost[i];
		}
		return Xcost;                         //回傳總體成本
	}

	
}
