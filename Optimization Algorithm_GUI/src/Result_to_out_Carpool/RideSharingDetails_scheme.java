package Result_to_out_Carpool;

import java.util.ArrayList;

import Make_Carpool_data.make_result;
import Make_Excel.Carpool.Output_EXCEL_RideSharingDetails;
import READ_TXT.READ_XY_and_Order;
import READ_TXT.Read_INPUT_TXT_filter;

public class RideSharingDetails_scheme extends carpool_results_test {

	public static ArrayList<Double> P_distance_after = new ArrayList<Double>(); //記錄此乘客得標後共乘中所行駛距離
	public static ArrayList<Double> D_distance_after = new ArrayList<Double>(); //記錄此司機得標後共乘中所行駛距離
	
	public static ArrayList<Double> P_distance_beforce = new ArrayList<Double>(); //記錄此乘客得標後共乘前所行駛距離
	public static ArrayList<Double> D_distance_beforce = new ArrayList<Double>(); //記錄此司機得標後重前所行駛距離
	
	public static ArrayList<Double> P_distance_Ratio = new ArrayList<Double>(); //記錄此乘客得標後共乘前所行駛距離
	public static ArrayList<Double> D_distance_Ratio = new ArrayList<Double>(); //記錄此司機得標後重前所行駛距離
	
	
	public static ArrayList<Double> Fdj =new ArrayList<Double>();
	
	public static void RideSharingDetails_scheme(int dj) throws Exception {
		
	//------這邊將矩陣存進--------------------
		P_distance_after.clear();
		D_distance_after.clear();
		P_distance_beforce.clear();
		D_distance_beforce.clear(); 
		P_distance_Ratio.clear();
		D_distance_Ratio.clear();
		

		Fdj .clear();
		
		for(int i=0;i<carpool_after_distance.P_distance().size();i++)     
			P_distance_after.add(carpool_after_distance.P_distance().get(i));
		for(int i=0;i<carpool_after_distance.D_distance().size();i++)
			D_distance_after.add(carpool_after_distance.D_distance().get(i));
		
		for(int i=0;i<Ride_Sharing_Function_dist.P_distance_Ratio().size();i++)     
			P_distance_Ratio.add(Ride_Sharing_Function_dist.P_distance_Ratio().get(i));
		for(int i=0;i<Ride_Sharing_Function_dist.D_distance_Ratio().size();i++)
			D_distance_Ratio.add(Ride_Sharing_Function_dist.D_distance_Ratio().get(i));
		
		
				//先用 Fdj_function() 找出 各自 Fdj ---------------------------------------------------------------------
				Allocate_surplus.Fdj_function(DriverBids,Order,Order_lengh);
				
				//執行 計算利潤方案一-------------------------------------------------
				Allocate_surplus.Scheme_I(Order,Order_lengh,DriverBids);
				
				//執行 計算利潤方案二-------------------------------------------------
				Allocate_surplus.Scheme_II(Order,Order_lengh,DriverBids);
				
				System.out.println();
				System.out.println();
				
				RideSharingDetails_print(dj);
	}
	

	public static void RideSharingDetails_print(int dj) throws NumberFormatException, Exception{
		
		//首先將標給找出
		int DB[]=new int [D];
		
		int PB[]=new int [(D+P)*4];
		
		int p=0,x=0,w=0,S=0,k1=0,K1=0,k=0;
		
		for (int i = 0; i < D; i++){
			if(READ_XY_and_Order.getDB(i)==0){DB[i]=0;}
			if(READ_XY_and_Order.getDB(i)>0){DB[i]=READ_XY_and_Order.getDB(i);}
		}
		
		if(dj>0){
			
			for(int i=0;i<Order.length;i++){
				
				if(Order_lengh[i]!=0 && DB[i]>0 && DriverBids[i][K]>0){	
				
				System.out.println("司機 ("+Xd[DB[i]-1]+","+Xj[DB[i]-1]+")"+" "+ up_down[p]+" 乘客 " + math1[p]+" 車上乘客數 "+math[p]+" 位  "
				+" 共乘前距離 "+D_distance_beforce.get(x)
				+" 共乘後距離 "+D_distance_after.get(x)
				+" 共乘前後百分比 "+((D_distance_after.get(x)-D_distance_beforce.get(x))/D_distance_beforce.get(x))
				+" 投標金額 "+DriverBids[i][K]
				+" Reward1 "+ Allocate_surplus.D_surplus_I().get(x)
				+" Reward1/投標金額 "+ Allocate_surplus.D_surplus_I().get(x)/DriverBids[i][K]
				+" Reward2 = "+ Allocate_surplus.D_surplus_II().get(x)
				+" Reward2/投標金額 = "+ Allocate_surplus.D_surplus_II().get(x)/DriverBids[i][K]
				+" Reward3 = "+ Allocate_surplus.D_surplus_III().get(x)
				+" Reward3/投標金額 = "+ Allocate_surplus.D_surplus_III().get(x)/DriverBids[i][K]
				+" Reward4 = "+ Allocate_surplus.D_surplus_IV().get(x)
				+" Reward4/投標金額 = "+ Allocate_surplus.D_surplus_IV().get(x)/DriverBids[i][K]
				+" distance = " + Distanceing[p]
				+"  time = "+	Timeing[p]
				+" 共乘前後距離比率  "+ D_distance_Ratio.get(x));
				
	   	if(x==0){
					make_result.makeRideSharingDetails(Xd[DB[i]-1], Xj[DB[i]-1], up_down[p]
						,D_distance_beforce.get(x)
						,D_distance_after.get(x)
						,((D_distance_after.get(x)-D_distance_beforce.get(x))/D_distance_beforce.get(x))
						, DriverBids[i][K]
						,Allocate_surplus.D_surplus_I().get(x)
						,Allocate_surplus.D_surplus_II().get(x)
						,Allocate_surplus.D_surplus_III().get(x)
						,Allocate_surplus.D_surplus_IV().get(x)
						,  Distanceing[p]
						, Timeing[p]
						,D_distance_Ratio.get(x));
					
					Output_EXCEL_RideSharingDetails.main(Xd[DB[i]-1], Xj[DB[i]-1], up_down[p]
							,D_distance_beforce.get(x)
							,D_distance_after.get(x)
							,((D_distance_after.get(x)-D_distance_beforce.get(x))/D_distance_beforce.get(x))
							, DriverBids[i][K]
							,Allocate_surplus.D_surplus_I().get(x)
							,Allocate_surplus.D_surplus_II().get(x)
							,Allocate_surplus.D_surplus_III().get(x)
							,Allocate_surplus.D_surplus_IV().get(x)
							,  Distanceing[p]
							, Timeing[p]
							,D_distance_Ratio.get(x),true);
				}
				else{make_result.makeRideSharingDetails1(Xd[DB[i]-1], Xj[DB[i]-1], up_down[p]
						,D_distance_beforce.get(x)
						, D_distance_after.get(x)
						,((D_distance_after.get(x)-D_distance_beforce.get(x))/D_distance_beforce.get(x))
						, DriverBids[i][K]
						,Allocate_surplus.D_surplus_I().get(x)
						,Allocate_surplus.D_surplus_II().get(x)
						,Allocate_surplus.D_surplus_III().get(x)
						,Allocate_surplus.D_surplus_IV().get(x)
						,  Distanceing[p]
						, Timeing[p]
						,D_distance_Ratio.get(x));
				
				Output_EXCEL_RideSharingDetails.main(Xd[DB[i]-1], Xj[DB[i]-1], up_down[p]
						,D_distance_beforce.get(x)
						,D_distance_after.get(x)
						,((D_distance_after.get(x)-D_distance_beforce.get(x))/D_distance_beforce.get(x))
						, DriverBids[i][K]
						,Allocate_surplus.D_surplus_I().get(x)
						,Allocate_surplus.D_surplus_II().get(x)
						,Allocate_surplus.D_surplus_III().get(x)
						,Allocate_surplus.D_surplus_IV().get(x)
						,  Distanceing[p]
						, Timeing[p]
						,D_distance_Ratio.get(x),true);
				}
	   	
				p++;
				
				for(int j=0;j< Order_lengh[i];j++){
					w=Order[i][j];
					if(w!=0){
					if(w>0){w=w-1;
								PB[k]=w;
								
								System.out.println("乘客"+" ("+Yp[w]+","+Yh[w]+")"
										+" "+ up_down[p]+" 乘客 " + math1[p]+" 車上乘客數 "+math[p]+" 位  "
										+" 共乘前距離 "+P_distance_beforce.get(k)
										+" 共乘後距離 "+P_distance_after.get(k)
										+" 共乘前後百分比 "+ ((P_distance_after.get(k)-P_distance_beforce.get(k))/P_distance_beforce.get(k))
										+" 投標金額 = "+Read_INPUT_TXT_filter.getfph(w)
										+"Reward1= "+Allocate_surplus.P_surplus_I().get(k)
										+" Reward1/投標金額 "+ Allocate_surplus.P_surplus_I().get(k)/Read_INPUT_TXT_filter.getfph(w)
										+"Reward2 = "+Allocate_surplus.P_surplus_II().get(k)
										+" Reward2/投標金額 = "+ Allocate_surplus.P_surplus_II().get(k)/Read_INPUT_TXT_filter.getfph(w)
										+" Reward3 = "+Allocate_surplus.P_surplus_III().get(k)
										+" Reward3/投標金額 = "+ Allocate_surplus.P_surplus_III().get(k)/Read_INPUT_TXT_filter.getfph(w)
										+" Reward4 = "+Allocate_surplus.P_surplus_IV().get(k)
										+" Reward4/投標金額 = "+ Allocate_surplus.P_surplus_IV().get(k)/Read_INPUT_TXT_filter.getfph(w)
										+" distance =" + Distanceing[p]
										+" time = "+	Timeing[p]
										+" 共乘前後距離比率  "+ P_distance_Ratio.get(k)
										);
									
							make_result.makeRideSharingDetails1(Yp[w], Yh[w], up_down[p]
									,P_distance_beforce.get(k)
									,P_distance_after.get(k)
									,((P_distance_after.get(k)-P_distance_beforce.get(k))/P_distance_beforce.get(k))
									, Read_INPUT_TXT_filter.getfph(w)
									,Allocate_surplus.P_surplus_I().get(k)
									,Allocate_surplus.P_surplus_II().get(k)
									,Allocate_surplus.P_surplus_III().get(k)
									,Allocate_surplus.P_surplus_IV().get(k)
									,  Distanceing[p]
									, Timeing[p]
									,P_distance_Ratio.get(k));
						 
							
							Output_EXCEL_RideSharingDetails.main(Yp[w], Yh[w], up_down[p]
									,P_distance_beforce.get(k)
									,P_distance_after.get(k)
									,((P_distance_after.get(k)-P_distance_beforce.get(k))/P_distance_beforce.get(k))
									, Read_INPUT_TXT_filter.getfph(w)
									,Allocate_surplus.P_surplus_I().get(k)
									,Allocate_surplus.P_surplus_II().get(k)
									,Allocate_surplus.P_surplus_III().get(k)
									,Allocate_surplus.P_surplus_IV().get(k)
									,  Distanceing[p]
									, Timeing[p]
									,P_distance_Ratio.get(k),false);
							
							
							k=k+1; K1=K1+1;
							p++;
								}
					
					if(w<0){
						w=(-w)-1; 
						for(S=0;S<k;S++)
							if(PB[S]==w){k=S;}
						
						System.out.println("乘客"+" ("+Yp[w]+","+Yh[w]+")"
								+" "+ up_down[p]+" 乘客 " + math1[p]+" 車上乘客數 "+math[p]+" 位  "
								+" 共乘前距離  "+P_distance_beforce.get(k)
								+" 共乘後距離  "+P_distance_after.get(k)
								+" 共乘前後百分比  "+((P_distance_after.get(k)-P_distance_beforce.get(k))/P_distance_beforce.get(k))
								
								+" 投標金額 = "+Read_INPUT_TXT_filter.getfph(w)
								+"Reward1"+Allocate_surplus.P_surplus_I().get(k)
								+" Reward1/投標金額 "+ Allocate_surplus.P_surplus_I().get(k)/Read_INPUT_TXT_filter.getfph(w)
								+"Reward2 = "+Allocate_surplus.P_surplus_II().get(k)
								+" Reward2/投標金額 = "+ Allocate_surplus.P_surplus_II().get(k)/Read_INPUT_TXT_filter.getfph(w)
								+" Reward3 = "+Allocate_surplus.P_surplus_III().get(k)
								+" Reward3/投標金額 = "+ Allocate_surplus.P_surplus_III().get(k)/Read_INPUT_TXT_filter.getfph(w)
								+" Reward4 = "+Allocate_surplus.P_surplus_IV().get(k)
								+" Reward4/投標金額 = "+ Allocate_surplus.P_surplus_IV().get(k)/Read_INPUT_TXT_filter.getfph(w)
								+" distance = " + Distanceing[p]
								+" time = "+	Timeing[p]
								+" 共乘前後距離比率  "+ P_distance_Ratio.get(k)
								);
						
						make_result.makeRideSharingDetails1(Yp[w], Yh[w], up_down[p]
								,P_distance_beforce.get(k)
								, P_distance_after.get(k)
								,((P_distance_after.get(k)-P_distance_beforce.get(k))/P_distance_beforce.get(k))
								, Read_INPUT_TXT_filter.getfph(w)
								,Allocate_surplus.P_surplus_I().get(k)
								,Allocate_surplus.P_surplus_II().get(k)
								,Allocate_surplus.P_surplus_III().get(k)
								,Allocate_surplus.P_surplus_IV().get(k)
								, Distanceing[p]
								, Timeing[p]
								,P_distance_Ratio.get(k));
						
						Output_EXCEL_RideSharingDetails.main(Yp[w], Yh[w], up_down[p]
								,P_distance_beforce.get(k)
								,P_distance_after.get(k)
								,((P_distance_after.get(k)-P_distance_beforce.get(k))/P_distance_beforce.get(k))
								, Read_INPUT_TXT_filter.getfph(w)
								,Allocate_surplus.P_surplus_I().get(k)
								,Allocate_surplus.P_surplus_II().get(k)
								,Allocate_surplus.P_surplus_III().get(k)
								,Allocate_surplus.P_surplus_IV().get(k)
								,  Distanceing[p]
								, Timeing[p]
								,P_distance_Ratio.get(k),false);
					
						p++;  k=K1;
					}
					}
				}
				
				System.out.println("司機 ("+Xd[DB[i]-1]+","+Xj[DB[i]-1]+")"
						+" "+up_down[p]+" 乘客 " + math1[p]+" 車上乘客數 "+math[p]+" 位  "
						+" 共乘前距離 "+D_distance_beforce.get(x)
						+" 共乘後距離 "+D_distance_after.get(x)
						+" 共乘前後百分比 "+((D_distance_after.get(x)-D_distance_beforce.get(x))/D_distance_beforce.get(x))
						+" 投標金額 "+DriverBids[i][K]
						+" Reward1 "+ Allocate_surplus.D_surplus_I().get(x)
						+" Reward1/投標金額 "+ Allocate_surplus.D_surplus_I().get(x)/DriverBids[i][K]
						+" Reward2 = "+ Allocate_surplus.D_surplus_II().get(x)
						+" Reward2/投標金額 = "+ Allocate_surplus.D_surplus_II().get(x)/DriverBids[i][K]
						+" Reward3 = "+ Allocate_surplus.D_surplus_III().get(x)
						+" Reward3/投標金額 = "+Allocate_surplus.D_surplus_III().get(x)/DriverBids[i][K]
						+" Reward4 = "+ Allocate_surplus.D_surplus_IV().get(x)
						+" Reward4/投標金額 = "+ Allocate_surplus.D_surplus_IV().get(x)/DriverBids[i][K]
						+" distance = " + Distanceing[p]
						+"  time = "+	Timeing[p]
						+" 共乘前後距離比率  "+ D_distance_Ratio.get(x));

				make_result.makeRideSharingDetails1(Xd[DB[i]-1], Xj[DB[i]-1], up_down[p]
						,D_distance_beforce.get(x)
						, D_distance_after.get(x)
						,((D_distance_after.get(x)-D_distance_beforce.get(x))/D_distance_beforce.get(x))
						, DriverBids[i][K]
						,Allocate_surplus.D_surplus_I().get(x)
						,Allocate_surplus.D_surplus_II().get(x)
						,Allocate_surplus.D_surplus_III().get(x)
						,Allocate_surplus.D_surplus_IV().get(x)
						,  Distanceing[p]
						, Timeing[p]
						,D_distance_Ratio.get(x));
				
				Output_EXCEL_RideSharingDetails.main(Xd[DB[i]-1], Xj[DB[i]-1], up_down[p]
						,D_distance_beforce.get(x)
						,D_distance_after.get(x)
						,((D_distance_after.get(x)-D_distance_beforce.get(x))/D_distance_beforce.get(x))
						, DriverBids[i][K]
						,Allocate_surplus.D_surplus_I().get(x)
						,Allocate_surplus.D_surplus_II().get(x)
						,Allocate_surplus.D_surplus_III().get(x)
						,Allocate_surplus.D_surplus_IV().get(x)
						,  Distanceing[p]
						, Timeing[p]
						,D_distance_Ratio.get(x),false);
				
				make_result.make_RideSharing();
				System.out.println( " K1= "+K1+" k= "+k1);
		
		/*		//驗證每個方案回饋比率--------------------------------------
				System.out.println("方案一");
				Verification_Check.Check_SchemI(i,x,PB,k1,K);
				System.out.println("方案二");
				Verification_Check.Check_SchemII(i,x,PB,k1,K);
				System.out.println("方案三");
				Verification_Check.Check_SchemIII(x,PB,k1,K);
				System.out.println("方案四");
				Verification_Check.Check_SchemIV(x,PB,k1,K);	
		*/
				
			x++; p++; k=K1; k1=K1;
			
				System.out.println("-----------------------------------------------------------------");
			}
			}
			}
			else {make_result.makeRideSharingDetails(0,0,null,0,0,0,0,0,0,0,0,0,0,0);
			
			Output_EXCEL_RideSharingDetails.main(0,0,null,0,0,0,0,0,0,0,0,0,0,0,true);
			}
		}
	
}
