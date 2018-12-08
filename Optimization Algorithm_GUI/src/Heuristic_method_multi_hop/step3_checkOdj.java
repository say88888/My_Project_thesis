package Heuristic_method_multi_hop;

import java.io.FileWriter;

import GUI.I_Set_Paths_for_Current_Simulation_Example;
import Generate_random_data.Read_Generate_random_OilConsumptionBounds;
import Input_Output_txt.Carpool.Read_file;
import READ_TXT.Read_INPUT_TXT_filter;
import READ_TXT.Read_distance;
import carpool_Alogorithm_MOD.Calculate_the_function;

public class step3_checkOdj {
	private static double[] Odj;
	private static double[]Odj_distance;
	private static String[][] DriverBids1;
	private static String[][]  Orders;
	
	public static void main( ) throws Exception {
		
	Read_file.loadData();
	Read_INPUT_TXT_filter.loadData();
	String str;
	
	Odj= new double[Read_file.getD()];
	Odj_distance= new double[Read_file.getD()];
	double[][] odj = new double[Read_file.getD()][];
	double[][] cdj = new double[Read_file.getD()][];
	for (int i = 0; i < Read_file.getD(); i++) {
		odj[i] = new double[Read_file.getJd(i)];
		cdj[i] = new double[Read_file.getJd(i)];
	}
	System.out.println();
	System.out.println("判斷 Odj 與 Cdj");
	
	for (int i = 0; i < odj.length; i++){
		int k=0;
		System.out.println(" 第 "+(i+1)+" 位司機");
		
		if(odj[i].length>0){
			for (int j = 0; j < odj[i].length; j++)
			{
			cdj[i][j]=Read_file.getCdj(i, j);
			odj[i][j]=Read_file.getOdj(i, j);
			
			if(cdj[i][j]<odj[i][j]){k++;}
			System.out.println("第 "+(j+1)+" 標  Odj = "+odj[i][j] +" Cdj= "+cdj[i][j]);	
			}
			if(k<=0){System.out.println("第 "+(i+1)+" 位司機的投的標 Cdj 並沒有小於 Obj的情況");}
			else if(k>0)
			{
				System.out.println("第 "+(i+1)+" 位司機的投的標 Cdj 小於 Obj 的情況，找出最小的 cdj 當作 odj");
				double min=cdj[i][0];
				for (int j = 0; j < odj[i].length; j++)
					if(cdj[i][j]<min){min=cdj[i][j]; }
				for (int j = 0; j < odj[i].length; j++)
				odj[i][j]=min;
				
				System.out.println("更改 Odj 為最小的 Cdj");
			}
			Odj[i]=odj[i][0];
			Odj_distance[i]=Calculate_the_function.Odj_dist(Odj[i],Read_INPUT_TXT_filter.getDriverOilConsumption(i),Read_Generate_random_OilConsumptionBounds.Driver_OilPrice());
		}else if(odj[i].length <=0){
			int location1=Integer.parseInt(Read_INPUT_TXT_filter.getD_S_PLACE(i));
			int location2=Integer.parseInt(Read_INPUT_TXT_filter.getD_D_ADDRESS(i));
			Odj_distance[i]=Read_distance.getDistance(location1,location2);
			Odj[i]=Calculate_the_function.Odj_cost(Odj_distance[i],Read_INPUT_TXT_filter.getDriverOilConsumption(i),Read_Generate_random_OilConsumptionBounds.Driver_OilPrice());
		}
			
		System.out.print(" Odj = "+Odj[i]+" Odj_distance= "+Odj_distance[i]);
		System.out.println();
		System.out.println();
	}
	
	
	FileWriter fw1 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path()+"\\Carpool\\DriverBids.txt");
	for (int d = 0; d < Read_file.getD(); d++)
		for(int j=0;j<Read_file.getJd(d);j++){
			for(int k=0;k<Read_file.getK();k++)
				fw1.write(Read_file.getqdjk(d, j, k)+" ");
	
			fw1.write(Read_file.getCdj(d, j)+" ");
			fw1.write(Odj[d]+" ");
			
			fw1.write(Read_file.getadj(d, j)+" ");
			for(int k=0;k<Read_file.getK();k++)
				fw1.write(Read_file.getWqdjk(d, j, k)+" ");
			fw1.write(Read_file.getldj(d, j)+"\r\n");
		}
				
	fw1.close();
	
	
	
}
}
