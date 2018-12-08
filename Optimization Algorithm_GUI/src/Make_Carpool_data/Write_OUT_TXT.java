package Make_Carpool_data;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import GUI.I_Set_Paths_for_Current_Simulation_Example;

public class Write_OUT_TXT {
	private static int i,j;
	
	public static void DriverBids(int[][] DriverBids,int D,int P) throws IOException
	{
		FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\DriverBids.txt");
		for(i=0;i<D;i++){
			for(j=0;j<P+2;j++){
				if(j<P+1)
				fw2.write(String.valueOf(DriverBids[i][j])+" ");
				else
				fw2.write(String.valueOf(DriverBids[i][j]));}
		fw2.write("\r\n");
		}
		
		fw2.close();
	}
	public static void driver_output_table(int m,int[] a,String[][] D_ID_B,String[][] P_ID_B,int[][] P_ORDER_B,String[][] F_R_Time_B,String[][] R_PLACE_B)throws IOException
	{
		
		FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\result.txt");
		for (i = 0; i <= m; i++){
			for (j = 0; j <= a[i] - 1; j++){
				fw2.write("司機ID: "+String.valueOf(D_ID_B[i][j])+",");
		fw2.write(String.valueOf("乘客ID: "+P_ID_B[i][j])+",");
		fw2.write(String.valueOf("載客順序: "+P_ORDER_B[i][j])+",");
		fw2.write("搭車時間: "+F_R_Time_B[i][j]+",");
		fw2.write("搭車地點: "+R_PLACE_B[i][j]);
		fw2.write("\r\n");
		}
		
	}
		fw2.close();
	}
	
	public static void driver_final_itinerary(int m,int[] a,String[][] D_ID_B,String[][] P_ID_B,int[][] D_itinerary_ID_B,int[][] P_itinerary_ID_B
	,int[][] P_ORDER_B,String[][] D_F_D_Time_B,String[][] D_S_PLACE_B,String[][] D_END_POINT_B,String[][] D_S_A_Time_B
	,String[][] F_R_Time_B,String[][] G_Time_B,String[][] R_PLACE_B, double[][] P_R_LAT_B, double[][] P_R_LNG_B, String[][]G_PLACE_B
	,double[][] P_D_LAT_B, double[][] P_D_LNG_B, int[][] math,int[][] DELAY_Time)throws IOException
	{
		FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\driver_final_itinerary.txt");
		for(i=0;i<=m;i++){
			for(j=0;j<=a[i]-1;j++){
		fw2.write(D_ID_B[i][j]+",");
		fw2.write(P_ID_B[i][j]+",");
		fw2.write(String.valueOf(D_itinerary_ID_B[i][j])+",");
		fw2.write(String.valueOf(P_itinerary_ID_B[i][j])+",");
		fw2.write(String.valueOf(P_ORDER_B[i][j])+",");
		fw2.write(D_F_D_Time_B[i][j]+",");
		fw2.write(D_S_PLACE_B[i][j]+",");
		fw2.write(D_END_POINT_B[i][j]+",");
		fw2.write(D_S_A_Time_B[i][j]+",");
		fw2.write(F_R_Time_B[i][j]+",");
		fw2.write(G_Time_B[i][j]+",");
		fw2.write(R_PLACE_B[i][j]+",");
		fw2.write(String.valueOf(P_R_LAT_B[i][j])+",");
		fw2.write(String.valueOf(P_R_LNG_B[i][j])+",");
		fw2.write(G_PLACE_B[i][j]+",");
		fw2.write(String.valueOf(P_D_LAT_B[i][j])+",");
		fw2.write(String.valueOf(P_D_LNG_B[i][j])+",");
		fw2.write(String.valueOf(math[i][j])+",");
		fw2.write(String.valueOf(DELAY_Time[i][j]));
		fw2.write("\r\n");
			}
		
	}
		fw2.close();
		
	}
	//------------------------------------------
	public static void PassengerBids(int[][] PassengerBids,int D,int P)throws IOException
	{
		FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PassengerBids.txt");
		for(i=0;i<P;i++){
			for(j=0;j<P+1;j++){
				if(j<P+1)
					fw2.write(String.valueOf(PassengerBids[i][j])+" ");
				else
					fw2.write(String.valueOf(PassengerBids[i][j]));}
		fw2.write("\r\n");
		}
		fw2.close();
		
		
	}
	public static void passenger_final_itinerary(int m,int[] a,String[][] P_ID_B,String[][] D_ID_B
			,int[][] P_itinerary_ID_B,String[][] F_R_Time_B,String[][] G_Time_B,String[][] R_PLACE_B
			,double[][] P_R_LAT_B, double[][] P_R_LNG_B, String[][] G_PLACE_B,double[][] P_D_LAT_B, double[][] P_D_LNG_B, int[][] DELAY_Time)throws IOException
	{
		FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\passenger_final_itinerary.txt");
		for(i=0;i<=m;i++){
			for(j=0;j<=a[i]-1;j++){
			fw2.write(P_ID_B[i][j]+",");
			fw2.write(D_ID_B[i][j]+",");
			fw2.write(String.valueOf(P_itinerary_ID_B[i][j])+",");
			fw2.write(F_R_Time_B[i][j]+",");
			fw2.write(G_Time_B[i][j]+",");
			fw2.write(R_PLACE_B[i][j]+",");
			fw2.write(String.valueOf(P_R_LAT_B[i][j])+",");
			fw2.write(String.valueOf(P_R_LNG_B[i][j])+",");
			fw2.write(G_PLACE_B[i][j]+",");
			fw2.write(String.valueOf(P_D_LAT_B[i][j])+",");
			fw2.write(String.valueOf(P_D_LNG_B[i][j])+",");
			fw2.write(String.valueOf(DELAY_Time[i][j]));
			fw2.write("\r\n");
			}
		}
		fw2.close();
		
		
	}
	public static void passengers_output_table(int m,int[] a,String[][] P_ID_B,String[][] F_R_Time_B,String[][] R_PLACE_B
			,String[][] G_Time_B,String[][] G_PLACE_B)throws IOException
	{
		FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"output\\passengers_output_table.txt");
		for(i=0;i<=m;i++){
			for(j=0;j<=a[i]-1;j++){
		fw2.write(P_ID_B[i][j]+",");
		fw2.write(F_R_Time_B[i][j]+",");
		fw2.write(R_PLACE_B[i][j]+",");
		fw2.write(G_Time_B[i][j]+",");
		fw2.write(G_PLACE_B[i][j]);
		fw2.write("\r\n");
			}
		}
		fw2.close();
	}
}
