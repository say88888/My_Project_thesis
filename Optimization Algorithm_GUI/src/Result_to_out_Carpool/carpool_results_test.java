package Result_to_out_Carpool;

import java.util.ArrayList;

import Generate_random_data.Read_Generate_random_OilConsumptionBounds;
import Input_Output_txt.Carpool.Read_BPL_TXT;
import Input_Output_txt.Carpool.Read_CarpoolData_Generation_Mode;
import Input_Output_txt.Carpool.Read_Objective_Weight;
import Input_Output_txt.Carpool.Read_TransactionFee;
import Make_Carpool_data.make_result;
import Make_Carpool_data.make_result_for_php_read;
import Make_Excel.Carpool.Output_EXCEL_DriverBids;
import Make_Excel.Carpool.Output_EXCEL_Eqution_Value;
import Make_Excel.Carpool.Output_EXCEL_PassengerBids;
import READ_TXT.READ_XY_and_Order;
import READ_TXT.Read_INPUT_TXT;
import READ_TXT.Read_INPUT_TXT_filter;
import READ_TXT.Read_distance;
import READ_TXT.Read_filter_and_detour_rate;
import carpool_Alogorithm_MOD.Calculate_the_function;
import carpool_Alogorithm_MOD.TimeCalculate;

public class carpool_results_test {
	
	private static final double NULL = 0;
	public static double Route = 0;                //計算有得到得標共乘乘客距離
	public static int P;
	public static int D;
	public static int K;
	private static boolean Algorithm = false;
	private static boolean Adjust_model = false;
	private static double[][] Bids ;
	public static int[][] Order;
	public static int[] Order_lengh;
	public static int[] Xd;
	public static int[] Xj;
	public static int[] Xdj;
	
	public static int[] Yp;
	public static int[] Yh;
	public static int[] Yph;
	
	public static String[] up_down;
	public static int[] Timeing;
	public static double[] Distanceing;
	public static  int[] math;
	public static  int[] math1;
	
	public static ArrayList<String> PID = new ArrayList<String>();
	public static ArrayList<String> PassengerList = new ArrayList<String>();
	public static ArrayList<String> PassengerList1 = new ArrayList<String>();
	
	public static double[][] DriverBids; // DriverDids.TXT矩陣
	public static double[][] PassengerBids; // PassengerBids.TXT矩陣
	
	public static double Omega_1,Omega_2,Omega_3,Omega_4,Omega_5,Omega_6,Omega_7,Omega_8;
	public static double wp,wp1,wd,wd1,Epsilon1,Epsilon2,Epsilon3,Epsilon4;
	
	public static String data_mode;
	public static int[] qdjk;
	
	public static void main() throws Exception {
		PID.clear();
		PassengerList.clear();
		PassengerList1.clear();
		P=0;
		D=0;
		K=0;
		Route = 0;
		Algorithm = false;
		Adjust_model=false;
		Read_INPUT_TXT_filter.loadData();
		Read_INPUT_TXT.loadData();
		
		Read_Carpool_file.loadData();
		READ_XY_and_Order.main();
		Read_Generate_random_OilConsumptionBounds.main();
		Read_Objective_Weight.main();
		Read_TransactionFee.main();
		Read_distance.Read_distance();
		Read_filter_and_detour_rate.main();
		Read_CarpoolData_Generation_Mode.main();
		if(Read_CarpoolData_Generation_Mode.mode().contains("multi_hop")){
			Read_BPL_TXT.main();
			data_mode="multi_hop";
		}else{data_mode="Single_mode";}
		
		for(int i=0;i<Read_INPUT_TXT_filter.getP();i++){
			//判斷是否已有此字串
			if(!PID.contains(Read_INPUT_TXT_filter.getP_ID(i))){
			  //無字串,加入字串
				PID.add(Read_INPUT_TXT_filter.getP_ID(i));
			}
		}
		
		if(data_mode.equals("Single_mode")){
		for(int i=0;i<Read_INPUT_TXT_filter.getP();i++){
			//判斷是否已有此字串
			if(!PassengerList.contains(Read_INPUT_TXT_filter.getP_ID(i)) || !PassengerList1.contains(Read_INPUT_TXT_filter.getP_R_PLACE(i))){
			  //無字串,加入字串
				PassengerList.add(Read_INPUT_TXT_filter.getP_ID(i));
				PassengerList1.add(Read_INPUT_TXT_filter.getP_R_PLACE(i));
			}
		}
		}else
		{
			for(int i=0;i<Read_INPUT_TXT_filter.getP();i++){
				//判斷是否已有此字串
		//		if(!PassengerList.contains(Read_INPUT_TXT_filter.getP_D_ADDRESS(i)) || !PassengerList1.contains(Read_INPUT_TXT_filter.getP_R_PLACE(i))){
				  //無字串,加入字串
					PassengerList.add(Read_INPUT_TXT_filter.getP_D_ADDRESS(i));
					PassengerList1.add(Read_INPUT_TXT_filter.getP_R_PLACE(i));
	//			}
			}
		}
		
		K=Read_Carpool_file.getK();
		P = Read_Carpool_file.getP();
		D = Read_Carpool_file.getD();
		
		// 定義標記完得資料，以及演算完的資料
		String[][] D_ID = new String[D+1][P+1]; // 司機ID
		String[][] P_ID = new String[D+1][P+1]; // 乘客ID
		int[][] D_itinerary_ID = new int[D+1][P+1]; // 司機行程ID
		int[][] P_itinerary_ID = new int[D+1][P+1]; // 乘客行程ID
		int[][] P_ORDER = new int[D][P]; // 載客次序
		String[][] D_F_D_Time = new String[D+1][P+1]; // 司機提早開車時間
		String[][] D_S_D_Time = new String[D+1][P+1]; // 司機延遲開車時間
		String[][] D_S_PLACE = new String[D+1][P+1]; // 司機出發點
		String[][] D_END_POINT = new String[D+1][P+1]; // 司機最終目的地
		String[][] D_F_A_Time = new String[D+1][P+1]; // 司機到達時間
		String[][] D_S_A_Time = new String[D+1][P+1]; // 司機延遲到達時間
		String[][] P_F_R_Time = new String[D+1][P+1]; // 乘客提早搭車時間
		String[][] P_S_R_Time = new String[D+1][P+1]; // 乘客延遲搭車時間
		String[][] P_G_Time = new String[D+1][P+1]; // 乘客下車時間
		String[][] P_G_D_Time = new String[D+1][P+1]; // 乘客延遲下車時間
		String[][] R_PLACE = new String[D+1][P+1]; // 乘客下車地點
		String[][] G_PLACE = new String[D+1][P+1]; // 乘客上車地點
		int[][] DELAY_Time = new int[D+1][P+1]; // 延遲時間
		double[][] D_S_LAT = new double[D+1][P+1]; // 司機發車地點緯度
		double[][] D_S_LNG = new double[D+1][P+1]; // 司機發車地點經度
		double[][] D_D_LAT = new double[D+1][P+1]; // 司機發車地點緯度
		double[][] D_D_LNG = new double[D+1][P+1]; // 司機發車地點經度
		double[][] P_R_LAT= new double[D+1][P+1]; // 乘客搭車地點經度
		double[][] P_R_LNG = new double[D+1][P+1]; // 乘客搭車地點緯度
		double[][] P_D_LAT = new double[D+1][P+1]; // 乘客目的地經度
		double[][] P_D_LNG = new double[D+1][P+1]; // 乘客目的地緯度      
		String[][] License_Plate = new String[D+1][P+1]; 
		int[][] seat = new int[D+1][P+1];     //乘坐人數
		int[][] weight = new int[D+1][P+1]; //重量限制
		// 定義得標資料-----------------------------------------------
		DriverBids = new double[D][K*2+3]; // DriverDids.TXT矩陣
		PassengerBids = new double[P][K]; // PassengerBids.TXT矩陣
		double[] Dcost = new double[100]; // 司機成本

		int k = 0, i = 0, j = 0, l = 0, m = 0,n=0,S=0;

		Bids = new double[D][K];
		
		Order = new int[D][K*2];
		Order_lengh=new int[D];
		
		for (i = 0; i < D; i++)
			for (j = 0; j < K; j++){
				Bids[i][j] = READ_XY_and_Order.getBids(i, j);
			}
		if(data_mode.equals("Single_mode")) {
		up_down=new String[(D+P)*2];
		Timeing=new int[(D+P)*2+D];
		Distanceing=new double[(D+P)*2];
		math = new int[(D+P)*2];
		math1 = new int[(D+P)*2];
		}else
		{
			up_down=new String[(D+P)*4];
			Timeing=new int[(D+P)*4];
			Distanceing=new double[(D+P)*4];
			math = new int[(D+P)*4];
			math1 = new int[(D+P)*4];
		}
		Omega_1=Read_Objective_Weight.Omega_1();
		Omega_2=Read_Objective_Weight.Omega_2();
		Omega_3=Read_Objective_Weight.Omega_3();
		Omega_4=Read_Objective_Weight.Omega_4();
		Omega_5=Read_Objective_Weight.Omega_5();
		Omega_6=Read_Objective_Weight.Omega_6();
		Omega_7=Read_Objective_Weight.Omega_7();
		Omega_8=Read_Objective_Weight.Omega_8();
		wp=Read_Objective_Weight.wp();
		wd=Read_Objective_Weight.wd();
		Epsilon1=Read_Objective_Weight.Epsilon1();
		Epsilon2=Read_Objective_Weight.Epsilon2();
		wp1=Read_Objective_Weight.wp1();
		wd1=Read_Objective_Weight.wd1();
		Epsilon3=Read_Objective_Weight.Epsilon3();
		Epsilon4=Read_Objective_Weight.Epsilon4();
		//宣告d1為Read_distance類別物件
		Read_distance d1=new Read_distance();
		// 宣告類別物件
		Algorithm_for_Adjustment_cost Al=new Algorithm_for_Adjustment_cost();

		int location1,location2;
		while (Algorithm == false) {
			k = 0; i = 0; j = 0; l = 0; m = 0; n = 0; S=0;
			System.out.println("---------目前的得標資料-----------");
			
			for (i = 0; i < D; i++){
				for (j = 0; j < K; j++){
					System.out.print(Bids[i][j]+" ");
				}
				System.out.println();
			}
			// ------------判斷是否重複------------------
			k = 0;
			// -------判斷乘客否被多個司機載-------------
			for (j = 0; j <= K - 1; j++) {
				for (i = 0; i <= D - 1; i++) {
					if (Bids[i][j] > 0) {
						k++;
					}
				}
				if (k >= 2)
					break;
				k = 0;
			}
			// -------判斷是哪位司機跟重複載到乘客加入矩陣----------
			if(k>1){
				Adjust.JudgeBIds_main(Bids);
				Bids=Adjust.getJudgeBIds();
				Algorithm=false;
				Adjust_model=true;
			}
			else{
				//------------調節完後沒有重複---------------------
				
				System.out.println("----------調節完後沒有重複-----------");
				Algorithm=true;
				//呼叫 male_Bids_and_Xdj_and_Yph 建立Yph 矩陣---------------------------------
				male_Bids_and_Xdj_and_Yph.Yph();
				
				
				System.out.println("---------將順序帶入陣列---------");
				//----------將順序帶入-------------------------------第 187~235 行
				int[] DB=new int[D];
				for (i = 0; i < D; i++){
					if(READ_XY_and_Order.getDB(i)<0){DB[i]=0;}
					if(READ_XY_and_Order.getDB(i)>=0){DB[i]=READ_XY_and_Order.getDB(i);}
					
					System.out.println("DB= "+DB[i]+" ");
					
					if(DB[i]==0){Order_lengh[i]=0;}
					if(DB[i]>0){Order_lengh[i]=READ_XY_and_Order.getOrder_lengh(DB[i]-1);}
					
					System.out.println("Order_lengh= "+Order_lengh[i]+" ");
					
				if(Order_lengh[i]>0){
					for(j=0;j<Order_lengh[i];j++)
					{
						Order[i][j]=READ_XY_and_Order.getOrder(DB[i]-1,j);
						System.out.print(Order[i][j]+" ");
					}
					}
				}
				for(i=0;i<D;i++){
					for(j=0;j<Order_lengh[i];j++)
						System.out.print(Order[i][j]+" ");
					System.out.println();
				}
				
				if(data_mode.equals("Single_mode")){
				for( i=0;i<Bids.length;i++){
					int lengh=Order_lengh[i];
					ArrayList<Integer> b = new ArrayList<Integer>();
					
					for( j=0;j<Bids[i].length;j++){
						if(Bids[i][j]==0){
							for(int x=0;x<Read_INPUT_TXT_filter.getP();x++)
							if(PassengerList.get(j).equals(Read_INPUT_TXT_filter.getP_ID(x)) 
									&& PassengerList1.get(j).equals(Read_INPUT_TXT_filter.getP_R_PLACE(x)) ){
							b.add(x+1);}
						}
					}
						for(j=0;j<Order_lengh[i];j++){
							for( k=0;k<b.size();k++){
							if(Order[i][j]==b.get(k) || Order[i][j]==(-b.get(k))){
								Order[i][j]=0;
								lengh-=1;
							}
						}
						}
						if(lengh==0){Order_lengh[i]=0;}
				}
				}else{
					for( i=0;i<Bids.length;i++){
						int lengh=Order_lengh[i];
						ArrayList<Integer> b = new ArrayList<Integer>();
						
						for( j=0;j<Bids[i].length;j++){
							if(Bids[i][j]==0){
								for(int x=0;x<Read_INPUT_TXT_filter.getP();x++)
								if(PassengerList.get(j).equals(Read_INPUT_TXT_filter.getP_D_ADDRESS(x)) 
										&& PassengerList1.get(j).equals(Read_INPUT_TXT_filter.getP_R_PLACE(x)) ){
								b.add(x+1);}
							}
						}
							for(j=0;j<Order_lengh[i];j++){
								for( k=0;k<b.size();k++){
								if(Order[i][j]==b.get(k) || Order[i][j]==(-b.get(k))){
									Order[i][j]=0;
									lengh-=1;
								}
							}
							}
							if(lengh==0){Order_lengh[i]=0;}
					}
				}
				
				
				for(i=0;i<D;i++){
					for(j=0;j<Order_lengh[i];j++)
						System.out.print(Order[i][j]+" ");
					System.out.println();
				}
				
				int[] a = new int[100];
				
				for(i=0;i<Order.length;i++){
					for(j=0;j<Order_lengh[i];j++)
					{
						k=Order[i][j];
						if(k>0){
						k=k-1;
						D_ID[m][l]=Read_INPUT_TXT_filter.getD_ID(i);
						P_ID[m][l]=Read_INPUT_TXT_filter.getP_ID(k);
						D_itinerary_ID[m][l] = Read_INPUT_TXT_filter.getD_itinerary_ID(i); // 司機行程ID
						P_itinerary_ID[m][l]= Read_INPUT_TXT_filter.getP_itinerary_ID(k); // 乘客行程ID
						D_F_D_Time[m][l] = Read_INPUT_TXT_filter.getD_F_D_Time(i); // 司機提早開車時間
						D_S_D_Time[m][l] = Read_INPUT_TXT_filter.getD_S_D_Time(i); // 司機延遲開車時間
						D_F_A_Time[m][l] = Read_INPUT_TXT_filter.getD_F_A_Time(i); // 司機最終到站時間
						D_S_A_Time[m][l] = Read_INPUT_TXT_filter.getD_S_A_Time(i); // 司機延遲最終到站時間
						D_S_PLACE[m][l] = Read_INPUT_TXT_filter.getD_S_PLACE(i); // 司機出發點
						D_END_POINT[m][l] = Read_INPUT_TXT_filter.getD_D_ADDRESS(i); // 司機最終目的地
						P_F_R_Time[m][l] = Read_INPUT_TXT_filter.getP_F_R_Time(k); // 乘客提早搭車時間
						P_S_R_Time[m][l] = Read_INPUT_TXT_filter.getP_D_R_Time(k); // 乘客延遲搭車時間
						P_G_Time[m][l]= Read_INPUT_TXT_filter.getP_F_A_Time(k); // 乘客下車時間
						P_G_D_Time[m][l] = Read_INPUT_TXT_filter.getP_D_A_Time(k); // 乘客延遲下車時間
						R_PLACE[m][l] = Read_INPUT_TXT_filter.getP_R_PLACE(k); // 乘客搭車地點
						G_PLACE[m][l] = Read_INPUT_TXT_filter.getP_D_ADDRESS(k); // 乘客下車地點
						D_S_LAT[m][l] = Read_INPUT_TXT_filter.getD_S_LAT(i); // 司機發車地點緯度
						D_S_LNG[m][l] = Read_INPUT_TXT_filter.getD_S_LNG(i); // 司機發車地點經度
						D_D_LAT[m][l] = Read_INPUT_TXT_filter.getD_D_LAT(i); // 司機目的地地點緯度
						D_D_LNG[m][l] = Read_INPUT_TXT_filter.getD_D_LNG(i); // 司機目的地地點經度
						P_R_LAT[m][l] = Read_INPUT_TXT_filter.getP_R_LAT(k); // 乘客搭車地點經度
						P_R_LNG[m][l] = Read_INPUT_TXT_filter.getP_R_LNG(k); // 乘客搭車地點緯度
						P_D_LAT[m][l] = Read_INPUT_TXT_filter.getP_D_LAT(k); // 乘客目的地經度
						P_D_LNG[m][l] = Read_INPUT_TXT_filter.getP_D_LNG(k); // 乘客目的地緯度
						License_Plate[m][l]=Read_INPUT_TXT_filter.getLicense_Plate(i);  
						seat[m][l]=Read_INPUT_TXT_filter.getseat(k);       
						weight[m][l]= Read_INPUT_TXT_filter.getweight(k);            //乘客需求重量
						l++;
						}
						}
					a[i]=l;  m++;  l=0;
				}
		
					//-----------------計算成本、距離、時間等等----------------------------------------------
				System.out.println("---------計算成本、距離、時間等等----------");
				double[] D_ID_distance=new double[D+1];
				qdjk=new int[D+1];
				double Route_A=0,Route_B=0;
				int o=0,p=0;
	
					// 宣告c1為TimeCalculate類別物件
					TimeCalculate c1 = new TimeCalculate();
					int G;
					
					for(i=0;i<Order.length;i++){	
						G=0;
						location1=Integer.parseInt(Read_INPUT_TXT_filter.getD_S_PLACE(i));
							if(Order_lengh[i]!=0)
							{
								up_down[p]="on";
								Route_A=0;
								Distanceing[p]=Route_A;
								Timeing[p]=(int)(Distanceing[p]/(0.35));
								math[p]=0;
								math1[p]=0;
								p++;
							}
						for(j=0;j<Order_lengh[i];j++)
						{
							k=Order[i][j];
							if(k>0)
							{
								Yph[k-1]=1;								
								S=k;
							     location2=Integer.parseInt(Read_INPUT_TXT_filter.getP_R_PLACE(S-1));		
								Route += Read_distance.getDistance(location1,location2);
								Route_A+= Read_distance.getDistance(location1,location2);
								location1=location2;
								n++;
								P_ORDER[i][j]=n;
								Distanceing[p]=Route_A;
								Timeing[p]=(int) (Distanceing[p]/0.35);
								up_down[p]="on"; 
								math1[p]=Read_INPUT_TXT_filter.getseat(S-1);
								G+=Read_INPUT_TXT_filter.getseat(S-1);
								math[p]=G;
								p++;
							}
							else if(k<0)
							{
								S=-k;
								location2=Integer.parseInt(Read_INPUT_TXT_filter.getP_D_ADDRESS(S-1));
								Route += Read_distance.getDistance(location1,location2);
								Route_A+= Read_distance.getDistance(location1,location2);
								location1=location2;
								Distanceing[p]=Route_A;
								Timeing[p]=(int) (Distanceing[p]/0.35);
								up_down[p]="off"; 
								math1[p]=Read_INPUT_TXT_filter.getseat(S-1);
								G-=Read_INPUT_TXT_filter.getseat(S-1);
								math[p]=G;
								p++;
							}
						}
						if(n>0){
						location2=Integer.parseInt(Read_INPUT_TXT_filter.getD_D_ADDRESS(i));
						Route += Read_distance.getDistance(location1,location2);
						Route_A+= Read_distance.getDistance(location1,location2);
						D_ID_distance[o]=Route-Route_B; 
						qdjk[i]=n;
						Dcost[i]=Calculate_the_function.Cdj_cost(D_ID_distance[o],Read_INPUT_TXT_filter.getDriverOilConsumption(i),Read_Generate_random_OilConsumptionBounds.Driver_OilPrice(),data_mode,qdjk[i]);
						o++;
						Route_B=Route;
						System.out.println(Dcost[i]);
						up_down[p]="off"; 
						Distanceing[p]=Route_A;
						Timeing[p]=(int) (Distanceing[p]/0.35);
						math[p]=0;
						math[p]=0;
						p++;
						}
						n=0;
					}
					
					System.out.println("DriverBids");
					//-----------DriverBids矩陣---------------------------------------------
					DriverBids=male_Bids_and_Xdj_and_Yph.GetDriverBids(Bids,Dcost);
					
					for (i = 0; i <D ; i++){
						for (j = 0; j < K+1; j++)
							System.out.print(DriverBids[i][j]+"  ");
						System.out.println();
					}
					
					
					
					//-----------PassengerBids矩陣---------------------------------------------
					System.out.println("PassengerBids");
					PassengerBids=male_Bids_and_Xdj_and_Yph.GetPassengerBids();
					for (i = 0; i <= PassengerList.size() - 1; i++){
						for (j = 0; j <= K; j++)
							System.out.print(PassengerBids[i][j]+"  ");
						System.out.println();
					}
					
					// -------------------------輸出演算的表-----------------------------------------------------
					for (i = 0; i <m; i++)
						for (j = 0; j < a[i]; j++) {
							System.out.println("司機ID:" + D_ID[i][j] + " 乘客ID:"
							+ P_ID[i][j] + " 司機行程ID:"	+ D_itinerary_ID[i][j] + " 乘客行程ID:"
							+ P_itinerary_ID[i][j] + " 司機載客順序:" + P_ORDER[i][j] + " 司機開車時間:" + D_F_D_Time[i][j]
							+ " 司機出發點:" + D_S_PLACE[i][j] + " 司機最終到站時間:" + D_S_A_Time[i][j] + " 乘客搭車時間:"
							+ P_F_R_Time[i][j] + " 乘客下車時間:" + P_G_Time[i][j] + " 乘客搭車地點:" + R_PLACE[i][j] + " 乘客下車地點:"
							+ G_PLACE[i][j] + " " + "延遲時間" + DELAY_Time[i][j]);
						}	
					
				
					
			//判斷 Obj 的值
			determine_XObj.determine_Xobj();	
			
			
			//計算共乘後每個司機與乘客的距離
			carpool_after_distance.distance(D_ID_distance);
	
			//呼叫 male_Bids_and_Xdj_and_Yph.Xdj 算 Xdj--------
			male_Bids_and_Xdj_and_Yph.Xdj();
			
			int dj=0;
				//---------------------------建立 ReportX.txt-------------------------------------------------
					System.out.println("---------輸出 Xdj 矩陣---------");	
				for(i=0;i<Xdj.length;i++){
			//		System.out.println(Xd[i]+"  "+ Xj[i]+"  "+Xdj[i]+"  "+i);
				  if(Xdj[i]==1){dj++;}             //此段判別Xdj是否有得標值
				}
				make_result.makereportX(Xd,Xj,Xdj);
		
				//---------------------------建立 ReportY.txt-------------------------------------------------
							System.out.println("---------輸出 Yph 矩陣---------");	
	//			for(i=0;i<Yph.length;i++)
	//				System.out.println(Yp[i]+"  "+ Yh[i]+"  "+Yph[i]+"  "+i);
				make_result.makereportY(Yp,Yh,Yph);
				
				
				//------------計算比率共乘前後的所有距離--------------------------------------
				Indicative_value.Get_Ratio_between_ride_sharing_distsance_and_without_ride_sharing();
				
				//-------------------------------------------------------------------------
			    //---------------------------呼叫 RideSharingDetails-----------------------------
				
				Function_Objective.F1();
				
				RideSharingDetails_scheme.RideSharingDetails_scheme(dj);
				
				
				//------------------------如果有到調節的部分建立TXT---------------------- 
				if(Adjust_model==true)
					male_Bids_and_Xdj_and_Yph.DriverBids_Adjust();
					
				Output_EXCEL_DriverBids.main(Xd,Xj,Xdj,DriverBids,Adjust_model);
				Output_EXCEL_PassengerBids.main();
			
				double surplus=Allocate_surplus.D_surplus_I().get(0);
				double Cdj=1;
				for (i = 0; i <D ; i++){
					for (j = K; j < K+1; j++)
						if(DriverBids[i][j]>0)
						{
							Cdj=DriverBids[i][j];
							break;
						}
				}
				
				double ShchmeI=surplus/Cdj;
				
				Output_EXCEL_Eqution_Value.main(Indicative_value.getV1(),Indicative_value.getV2(),Indicative_value.getV3(),Indicative_value.getV4()
						,Indicative_value.getW1(),Indicative_value.getW2(),Indicative_value.getW3(),Indicative_value.getW4(),ShchmeI);
				
				Indicative_value.GetUsage();
				
			//---------------------------------------------建立共乘前與共乘後的地點經緯度與上下車順序---------------
			make_result_for_php_read.Ridesharing_beforce_location_lat_and_lng();
			make_result_for_php_read.Ridesharing_after_location_lat_and_lng();
			make_result_for_php_read.Ridesharing_beforce_location_Geton_and_Getoff();
			make_result_for_php_read.Ridesharing_after_location_Geton_and_Getoff();
			
			}
		}
  }

}
