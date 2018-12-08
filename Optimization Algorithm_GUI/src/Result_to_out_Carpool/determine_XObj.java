package Result_to_out_Carpool;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

import GUI.I_Set_Paths_for_Current_Simulation_Example;
import GUI.GUI_Carpool.X_Select_Algorithm_Type_to_Solve_the_Problem;
import Generate_random_data.Read_Generate_random_OilConsumptionBounds;
import READ_TXT.Read_INPUT_TXT_filter;
import READ_TXT.Read_distance;
import carpool_Alogorithm_MOD.Calculate_the_function;

public class determine_XObj extends carpool_results_test{

	private static double[] Odj;
	private static double[]Odj_distance;
	private static int[][] Odj_Orders;
	private static int[] Odj_Order_lengh;
	
	private static double[][] Odj_lat;
	private static double[][]Odj_lng;
	
	private static String[][]  Orders;
	private static int[][]  Order;
	private static int[] Order_lengh;
	
	public static void  determine_Xobj() throws IOException{
	
		String str;
		int k=0,k1=0;
		
		Vector<String []> str_vec = new Vector<String []>(); //暫存
		if(X_Select_Algorithm_Type_to_Solve_the_Problem.Advance_bid()==true)
		{
		try {
			FileReader PBr = new FileReader(I_Set_Paths_for_Current_Simulation_Example.path()+"\\Carpool\\Orders.txt");
			BufferedReader br = new BufferedReader(PBr);
			while ((str = br.readLine()) != null) { //每次讀一行
				k++;
		str_vec.add(str.split(",")); //將此行以空白(white space)切成字串陣列, 存入 Vector暫存 
		}
		br.close(); //關檔
		
		Orders = new String [str_vec.size()][]; 
		for (int i = 0; i < str_vec.size(); i++)
			Orders[i] = str_vec.elementAt(i);
	     } catch (Exception e) {
	 		e.printStackTrace();
			}
		}
		else if(X_Select_Algorithm_Type_to_Solve_the_Problem.Advance_bid()==false)
			{
			try {
				FileReader PBr = new FileReader(I_Set_Paths_for_Current_Simulation_Example.path()+"\\Carpool\\"+X_Select_Algorithm_Type_to_Solve_the_Problem.method()+"\\Orders.txt");
				BufferedReader br = new BufferedReader(PBr);
				while ((str = br.readLine()) != null) { //每次讀一行
					k++;
			str_vec.add(str.split(",")); //將此行以空白(white space)切成字串陣列, 存入 Vector暫存 
			}
			br.close(); //關檔
			
			Orders = new String [str_vec.size()][]; 
			for (int i = 0; i < str_vec.size(); i++)
				Orders[i] = str_vec.elementAt(i);
		     } catch (Exception e) {
		 		e.printStackTrace();
				}
			
		}
		   Order = new int[Orders.length][];
		   Order_lengh= new int[Orders.length];
		   
		    for(int i=0;i<Orders.length;i++){
		    	Order[i]=new int[Orders[i].length];
		    }
		    
			   for (int i = 0; i < Orders.length; i++) 
			    	for (int j =0; j < Orders[i].length; j++) {
			    		Order[i][j]=Integer.parseInt(Orders[i][j]);
			    	Order_lengh[i]=Orders[i].length;
			    	}
			   
		k=0;
		
		Odj= new double[Read_Carpool_file.getD()];
		Odj_distance= new double[Read_Carpool_file.getD()];
		Odj_Orders= new int[Read_Carpool_file.getD()][8];
		Odj_Order_lengh= new int[Read_Carpool_file.getD()];
		Odj_lat= new double[Read_Carpool_file.getD()][8];
		Odj_lng=new double[Read_Carpool_file.getD()][8];
		
		double[][] odj = new double[Read_Carpool_file.getD()][];
		double[][] cdj = new double[Read_Carpool_file.getD()][];
		for (int i = 0; i < Read_Carpool_file.getD(); i++) {
			odj[i] = new double[Read_Carpool_file.getJd(i)];
			cdj[i] = new double[Read_Carpool_file.getJd(i)];
		}
		
		System.out.println();
		System.out.println("判斷 Obj 與 Cdj");
		
		for (int i = 0; i < odj.length; i++){
			k=0;
			System.out.println(" 第 "+(i+1)+" 位司機");
			
			if(odj[i].length>0){
				for (int j = 0; j < odj[i].length; j++)
				{
				cdj[i][j]=Read_Carpool_file.getCdj(i, j);
				odj[i][j]=Read_Carpool_file.getOdj(i, j);
				k1++;
				if(cdj[i][j]<=odj[i][j]){k++;}
				System.out.println("第 "+(j+1)+" 標  Odj = "+odj[i][j] +" Cdj= "+cdj[i][j]);	
				}
				if(k==0){System.out.println("第 "+(i+1)+" 位司機的投的標 Cdj 並沒有小於 Obj的情況");
				int location1=Integer.parseInt(Read_INPUT_TXT_filter.getD_S_PLACE(i));
				int location2=Integer.parseInt(Read_INPUT_TXT_filter.getD_D_ADDRESS(i));
				Odj_distance[i]=Read_distance.getDistance(location1,location2);
				Odj[i]=Calculate_the_function.Odj_cost(Odj_distance[i],Read_INPUT_TXT_filter.getDriverOilConsumption(i),Read_Generate_random_OilConsumptionBounds.Driver_OilPrice());
				Odj_Order_lengh[i]=2;
				Odj_Orders[i][0]=location1; Odj_lat[i][0]=Read_INPUT_TXT_filter.getD_S_LAT(i); Odj_lng[i][0]=Read_INPUT_TXT_filter.getD_S_LNG(i);
				Odj_Orders[i][1]=location2; Odj_lat[i][1]=Read_INPUT_TXT_filter.getD_D_LAT(i); Odj_lng[i][1]=Read_INPUT_TXT_filter.getD_D_LNG(i); 
				}
				else if(k>0)
				{
					System.out.println("第 "+(i+1)+" 位司機的投的標 Cdj 小於等於 Obj 的情況，找出最小的 cdj 當作 odj");
					double min=cdj[i][0];
					for (int j = 0; j < odj[i].length; j++)
						if(cdj[i][j]<min){min=cdj[i][j]; }
					for (int j = 0; j < odj[i].length; j++)
						odj[i][j]=min;
					
					System.out.println("更改 Odj 為最小的 Cdj");
				}
				Odj[i]=odj[i][0];
				Odj_distance[i]=Calculate_the_function.Odj_dist(Odj[i],Read_INPUT_TXT_filter.getDriverOilConsumption(i),Read_Generate_random_OilConsumptionBounds.Driver_OilPrice());
				
				int k2=k1-odj[i].length;
				int Dlocation1=Integer.parseInt(Read_INPUT_TXT_filter.getD_S_PLACE(i));
				int Dlocation2=Integer.parseInt(Read_INPUT_TXT_filter.getD_D_ADDRESS(i));
				
				for (int j = 0; j < odj[i].length; j++)
					if(odj[i][j]==cdj[i][j])
					{
						Odj_Order_lengh[i]=Order[k2+j].length+2;
						Odj_Orders[i][0]=Dlocation1;
						Odj_lat[i][0]=Read_INPUT_TXT_filter.getD_S_LAT(i); 
						Odj_lng[i][0]=Read_INPUT_TXT_filter.getD_S_LNG(i);
						
						for(int m=0;m<Order[k2+j].length;m++)
							{
							if(Order[k2+j][m]>0){
								int o=Order[k2+j][m]-1;
								System.out.println("o= "+o);
								Odj_Orders[i][m+1]=Integer.parseInt(Read_INPUT_TXT_filter.getP_R_PLACE(o));
								Odj_lat[i][m+1]=Read_INPUT_TXT_filter.getP_R_LAT(o);
								Odj_lng[i][m+1]=Read_INPUT_TXT_filter.getP_R_LNG(o);
								}
							else{
								int o=(-Order[k2+j][m])-1;
								System.out.println("o= "+o);
								Odj_Orders[i][m+1]=Integer.parseInt(Read_INPUT_TXT_filter.getP_D_ADDRESS(o));
								Odj_lat[i][m+1]=Read_INPUT_TXT_filter.getP_D_LAT(o);
								Odj_lng[i][m+1]=Read_INPUT_TXT_filter.getP_D_LNG(o);
								}
							}
						Odj_Orders[i][Order[k2+j].length+1]=Dlocation2;
						Odj_lat[i][Order[k2+j].length+1]=Read_INPUT_TXT_filter.getD_D_LAT(i); 
						Odj_lng[i][Order[k2+j].length+1]=Read_INPUT_TXT_filter.getD_D_LNG(i); 
					}
				
				
			}else if(odj[i].length <=0){
				int location1=Integer.parseInt(Read_INPUT_TXT_filter.getD_S_PLACE(i));
				int location2=Integer.parseInt(Read_INPUT_TXT_filter.getD_D_ADDRESS(i));
				Odj_distance[i]=Read_distance.getDistance(location1,location2);
				Odj[i]=Calculate_the_function.Odj_cost(Odj_distance[i],Read_INPUT_TXT_filter.getDriverOilConsumption(i),Read_Generate_random_OilConsumptionBounds.Driver_OilPrice());
				Odj_Order_lengh[i]=2;
				Odj_Orders[i][0]=location1; Odj_lat[i][0]=Read_INPUT_TXT_filter.getD_S_LAT(i); Odj_lng[i][0]=Read_INPUT_TXT_filter.getD_S_LNG(i);
				Odj_Orders[i][1]=location2; Odj_lat[i][1]=Read_INPUT_TXT_filter.getD_D_LAT(i); Odj_lng[i][1]=Read_INPUT_TXT_filter.getD_D_LNG(i); 
			}
			System.out.println(" Odj = "+Odj[i]+" Odj_distance= "+Odj_distance[i]);
			for(int m=0;m<Odj_Order_lengh[i];m++){
			System.out.println(" Odj_Orders = "+Odj_Orders[i][m] +" Odj_lat " +Odj_lat[i][m]+" Odj_lng "+ Odj_lng[i][m]);
			}
			System.out.println();
			System.out.println();
		}
	}
	
	public static double  getOdj(int i){
		return Odj[i];
	}
	public static double  getOdj_distance(int i){
		return Odj_distance[i];
	}
	public static int  getOdj_Orders(int i,int j){
		return Odj_Orders[i][j];
	}
	public static int  getOdj_Order_lengh(int i){
		return Odj_Order_lengh[i];
	}
	public static double  getOdj_lat(int i,int j){
		return Odj_lat[i][j];
	}
	public static double  getOdj_lng(int i,int j){
		return Odj_lng[i][j];
	}
}
