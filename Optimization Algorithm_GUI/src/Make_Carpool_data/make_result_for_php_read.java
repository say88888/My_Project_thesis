package Make_Carpool_data;

import java.io.FileWriter;

import GUI.I_Set_Paths_for_Current_Simulation_Example;
import GUI.GUI_Carpool.X_Select_Algorithm_Type_to_Solve_the_Problem;
import READ_TXT.READ_XY_and_Order;
import READ_TXT.Read_INPUT_TXT_filter;
import Result_to_out_Carpool.Read_Carpool_file;
import Result_to_out_Carpool.carpool_results_test;
import Result_to_out_Carpool.determine_XObj;

public class make_result_for_php_read extends carpool_results_test{

	public static	void Ridesharing_beforce_location_lat_and_lng() throws Exception {

		Read_Carpool_file.loadData();
		Read_INPUT_TXT_filter.loadData();
		int c = 0;
		int[][] Y = new int[Read_Carpool_file.getP()][];
		for (int i = 0; i < Read_Carpool_file.getP(); i++)
			Y[i] = new int[Read_Carpool_file.getHp(i)];
		int[][] X = new int[Read_Carpool_file.getD()][];
		for (int i = 0; i < Read_Carpool_file.getD(); i++)
			X[i] = new int[Read_Carpool_file.getJd(i)];
		int b = 0;
		for (int i = 0; i < Y.length; i++)
			for (int j = 0; j < Y[i].length; j++)
				Y[i][j] = Yph[c++];
		for (int i = 0; i < X.length; i++)
			for (int j = 0; j < X[i].length; j++)
				X[i][j] = Xdj[b++];
		
		FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()
				   +X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"Ridesharing_beforce_location_lat_and_lng.txt",false);
		
		for (int d = 0; d < Read_Carpool_file.getD(); d++){
			for (int j = 0; j < determine_XObj.getOdj_Order_lengh(d)-1; j++) {
				 fw1.write(String.valueOf(determine_XObj.getOdj_lat(d,j))+","+String.valueOf(determine_XObj.getOdj_lng(d,j)));
				 fw1.write(",");	 
				}
				fw1.write(String.valueOf(determine_XObj.getOdj_lat(d,determine_XObj.getOdj_Order_lengh(d)-1))+","+String.valueOf(determine_XObj.getOdj_lng(d,determine_XObj.getOdj_Order_lengh(d)-1)));
			   fw1.write("\r\n");
		}
		for (int p = 0; p < Read_INPUT_TXT_filter.getP(); p++){
				fw1.write(String.valueOf(Read_INPUT_TXT_filter.getP_R_LAT(p))+","+String.valueOf(Read_INPUT_TXT_filter.getP_R_LNG(p)));
				fw1.write(",");
				fw1.write(String.valueOf(Read_INPUT_TXT_filter.getP_D_LAT(p))+","+String.valueOf(Read_INPUT_TXT_filter.getP_D_LNG(p)));
				fw1.write("\r\n");
			}
		fw1.close();
	}
	
	public static	void Ridesharing_beforce_location_Geton_and_Getoff() throws Exception {
		
		Read_Carpool_file.loadData();
		Read_INPUT_TXT_filter.loadData();

		int c = 0;
		int[][] Y = new int[Read_Carpool_file.getP()][];
		for (int i = 0; i < Read_Carpool_file.getP(); i++)
			Y[i] = new int[Read_Carpool_file.getHp(i)];
		int[][] X = new int[Read_Carpool_file.getD()][];
		for (int i = 0; i < Read_Carpool_file.getD(); i++)
			X[i] = new int[Read_Carpool_file.getJd(i)];

		int b = 0;
		for (int i = 0; i < Y.length; i++)
			for (int j = 0; j < Y[i].length; j++)
				Y[i][j] = Yph[c++];
		for (int i = 0; i < X.length; i++)
			for (int j = 0; j < X[i].length; j++)
				X[i][j] = Xdj[b++];
		
		FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()
				   +X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"Ridesharing_beforce_location_Geton_and_Getoff.txt",false);
		
		for (int d = 0; d < Read_Carpool_file.getD(); d++){
			for (int j = 0; j < determine_XObj.getOdj_Order_lengh(d)-1; j++) {
				if(j==0){fw2.write(" 第 "+ (d+1)+" 司機 起點 ");}
				if(j>0){fw2.write(" 第 "+ (d+1)+" 司機第 "+j+" 中繼點 " );}
				 fw2.write(",");	
				}
			fw2.write(" 第 "+ (d+1)+" 司機 終點");
			fw2.write("\r\n");
		}
		
		for (int p = 0; p < Read_INPUT_TXT_filter.getP(); p++){
			fw2.write(" 第 "+ (p+1)+" 乘客 起點 ");
			fw2.write(",");
			fw2.write(" 第 "+ (p+1)+" 乘客 終點 ");
			fw2.write("\r\n");
		}
	fw2.close();
	}
	
	
	
	public static	void Ridesharing_after_location_lat_and_lng() throws Exception {

		Read_Carpool_file.loadData();
		Read_INPUT_TXT_filter.loadData();
		int c = 0;
		int[][] Y = new int[Read_Carpool_file.getP()][];
		for (int i = 0; i < Read_Carpool_file.getP(); i++)
			Y[i] = new int[Read_Carpool_file.getHp(i)];
		int[][] X = new int[Read_Carpool_file.getD()][];
		for (int i = 0; i < Read_Carpool_file.getD(); i++)
			X[i] = new int[Read_Carpool_file.getJd(i)];
		
		int b = 0;
		for (int i = 0; i < Y.length; i++)
			for (int j = 0; j < Y[i].length; j++)
				Y[i][j] = Yph[c++];
		for (int i = 0; i < X.length; i++)
			for (int j = 0; j < X[i].length; j++)
				X[i][j] = Xdj[b++];
		int[] Xd=new int[D];
		
		FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()
				   +X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"Ridesharing_after_location_lat_and_lng.txt",false);
		
					for(int i=0;i<Order.length;i++){
						if(Order_lengh[i]!=0  && DriverBids[i][PassengerList1.size()]>0){
							fw1.write(String.valueOf(Read_INPUT_TXT_filter.getD_S_LAT(i))+","+String.valueOf(Read_INPUT_TXT_filter.getD_S_LNG(i))+",");
						
						for(int j=0;j< Order_lengh[i];j++){
							int w=Order[i][j];
							if(Order[i][j]>0)
							{
								w-=1;
								fw1.write(String.valueOf(Read_INPUT_TXT_filter.getP_R_LAT(w))+","+String.valueOf(Read_INPUT_TXT_filter.getP_R_LNG(w)));
								fw1.write(",");
							}
							if(Order[i][j]<0)
							{
								w=(-w)-1;
								fw1.write(String.valueOf(Read_INPUT_TXT_filter.getP_D_LAT(w))+","+String.valueOf(Read_INPUT_TXT_filter.getP_D_LNG(w)));
								fw1.write(",");
							}
						}
						fw1.write(String.valueOf(Read_INPUT_TXT_filter.getD_D_LAT(i))+","+String.valueOf(Read_INPUT_TXT_filter.getD_D_LNG(i)));
						fw1.write("\r\n");
						Xd[i]=1;
						}
					}
			/*		int k;
					for(int d=0;d<Read_Carpool_file.getD();d++)
					{
						if(Xd[d]==0)
						{
							for (int j = 0; j < determine_XObj.getOdj_Order_lengh(d)-1; j++) {
								 fw1.write(String.valueOf(determine_XObj.getOdj_lat(d,j))+","+String.valueOf(determine_XObj.getOdj_lng(d,j)));
								 fw1.write(",");
								}
							k=determine_XObj.getOdj_Order_lengh(d)-1;
							fw1.write(String.valueOf(determine_XObj.getOdj_lat(d,k))+","+String.valueOf(determine_XObj.getOdj_lng(d,k)));
							fw1.write("\r\n");
						}
					}
					k=0;
					for (int p = 0; p < Read_Carpool_file.getP(); p++){
						for (int h = 0; h < Read_Carpool_file.getHp(p); h++) {
							if(Y[p][h]==0){
							fw1.write(String.valueOf(Read_INPUT_TXT_filter.getP_R_LAT(k))+","+String.valueOf(Read_INPUT_TXT_filter.getP_R_LNG(k)));
							fw1.write(",");
							fw1.write(String.valueOf(Read_INPUT_TXT_filter.getP_D_LAT(k))+","+String.valueOf(Read_INPUT_TXT_filter.getP_D_LNG(k)));
							fw1.write("\r\n");
							}
							k++;
						}
					}
			*/
		fw1.close();
	}
	
	public static	void Ridesharing_after_location_Geton_and_Getoff() throws Exception {
	
		Read_Carpool_file.loadData();
		Read_INPUT_TXT_filter.loadData();
		int c = 0;
		int[][] Y = new int[Read_Carpool_file.getP()][];
		for (int i = 0; i < Read_Carpool_file.getP(); i++)
			Y[i] = new int[Read_Carpool_file.getHp(i)];
		int[][] X = new int[Read_Carpool_file.getD()][];
		for (int i = 0; i < Read_Carpool_file.getD(); i++)
			X[i] = new int[Read_Carpool_file.getJd(i)];
		
		int b = 0;
		for (int i = 0; i < Y.length; i++)
			for (int j = 0; j < Y[i].length; j++)
				Y[i][j] = Yph[c++];
		for (int i = 0; i < X.length; i++)
			for (int j = 0; j < X[i].length; j++)
				X[i][j] = Xdj[b++];
		
		int[] Xd=new int[D];
		int DB[]=new int [D];
		for (int i = 0; i < D; i++){
			if(READ_XY_and_Order.getDB(i)==0){DB[i]=0;}
			if(READ_XY_and_Order.getDB(i)>0){DB[i]=READ_XY_and_Order.getDB(i);}
		}
		
		FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()
				   +X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"Ridesharing_after_distance_Geton_and_Getoff.txt",false);
		
		int p=0;
		for(int i=0;i<Order.length;i++){
			if(Order_lengh[i]!=0 && DriverBids[i][PassengerList1.size()]>0){
				int d=DB[i]-1;
				fw2.write(" 第 "+String.valueOf((i+1))+" 司機 起點 " );
				fw2.write(",");
				for(int j=0;j< Order_lengh[i];j++){
				int w=Order[i][j];
				if(w>0)
				{
				w=w-1;
				fw2.write(" 第 "+String.valueOf(Yp[w])+" 乘客 上車 " );
				}
				else if(w<0)
				{
					w=(-w-1);
					fw2.write(" 第 "+String.valueOf(Yp[w])+" 乘客 下車 " );
				}
				fw2.write(",");
				}
				fw2.write(" 第 "+String.valueOf((i+1))+" 司機 終點 " );
				fw2.write("\r\n");
				Xd[i]=1;
		}
	}
	/*	int k;
		for(int d=0;d<Read_Carpool_file.getD();d++)
		{
			if(Xd[d]==0)
			{
				for (int j = 0; j < determine_XObj.getOdj_Order_lengh(d)-1; j++) {
					if(j==0){fw2.write(" 第 "+ (d+1)+" 司機 起點 ");}
					if(j>0){fw2.write(" 第 "+ (d+1)+" 司機 第 "+j+" 中繼點 " );}
					fw2.write(",");	
					}
				fw2.write(" 第 "+ (d+1)+" 司機 終點 ");
				fw2.write("\r\n");
			}
		}
		
		k=0;
		for ( p = 0; p < Read_Carpool_file.getP(); p++){
			for (int h = 0; h < Read_Carpool_file.getHp(p); h++) {
				if(Y[p][h]==0){
				fw2.write(" 第 "+ (k+1)+" 乘客 起點 ");
				fw2.write(",");
				fw2.write(" 第 "+ (k+1)+" 乘客 終點 ");
				fw2.write("\r\n");
				}
				k++;
			}
		}
	 */
		fw2.close();
	}
}
