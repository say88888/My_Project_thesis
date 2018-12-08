package Algorithm_Carpool.CC_CLPSO2_AB_2Si_ApproachI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Generate_random_data.Read_Generate_random_OilConsumptionBounds;
import Input_Output_txt.Carpool.Output_Result;
import READ_TXT.Read_INPUT_TXT_filter;
import READ_TXT.Read_distance;
import carpool_Alogorithm_MOD.Calculate_the_function;

public class decoding_ABString extends CC_CLPSO2_AB_2Si_ApproachI{

	private static List<List<Integer>> Bdm = new ArrayList<List<Integer>>();
	private static List<List<Integer>> Bdm_position = new ArrayList<List<Integer>>();
	private static int X[][];
	private static int Y[][];
	private static double Bids[][];
	
	public	static void main(int[] GA,int[] GB) throws IOException
	{
		for(int d=0;d<P;d++)
			System.out.println(GA[d]);
		for(int d=0;d<(P*2);d++)
			System.out.println(GB[d]);
		
	//	Parameter_print();
		
		decoding_ABString(GA,GB);
		
		Bids=new double[D][P*2+4];
		
		List<Integer> Dlist = new ArrayList<Integer>();
		for (int d = 0; d < X.length; d++)
			for (int j = 0; j < X[d].length; j++) {
				if(X[d][j]==1){
					System.out.println(" 司機 "+(d+1));
					Bdm_print(Bdm.get(d),Bdm_position.get(d));
					
					for(int k=0;k<Bdm.get(d).size();k++){
						if(Bdm.get(d).get(k)>0){
							Bids[d][Bdm.get(d).get(k)-1]=1;
							Bids[d][Bdm.get(d).get(k)-1+3+P]+=Read_INPUT_TXT_filter.getweight(Bdm.get(d).get(k)-1);
						}
					}
					
					double Cdj=Cdj(d,Bdm.get(d));
					Bids[d][P]=Cdj;
					Bids[d][P+1]=Odj(d);
					Bids[d][P+2]=Read_INPUT_TXT_filter.getP_NUMBER(d);
					Bids[d][(P*2)+3]=Read_INPUT_TXT_filter.getWeight_Limit(d);
				}
			}
		Output_Result.CC_CLPSO2_AB_2Si_ApproachI_decodingABString(X,Y,Bids,Bdm);
	}

	static void decoding_ABString(int[] GA,int[] GB)
	{
		
		Bdm.clear();
		Bdm_position.clear();
		
		System.out.println("--------AString---------------------");
		for (int d = 0; d < GA.length; d++)
			System.out.print(GA[d]+" ");
		System.out.println();
		System.out.println("-----------------------------");
		
		System.out.println("--------BString---------------------");
		for (int d = 0; d <GB.length ; d++)
			System.out.print(GB[d]+" ");
		System.out.println();
		System.out.println("-----------------------------");
		System.out.println();
		
		List<List<Integer>> Dlist = new ArrayList<List<Integer>>();
		
		int[][] Adp = new int[D][P];
		for (int d = 0; d < D; d++){
			List<Integer> list = new ArrayList<Integer>();
			for (int p = 0; p < P; p++) {
				if (GA[p] == (d + 1)){
					Adp[d][p] = 1;
					list.add(p+1);
				}else
					Adp[d][p] = 0;
			}
			Dlist.add(list);
		}
		for (int d = 0; d < D; d++) {
			List<Integer> B = new ArrayList<Integer>();
			List<Integer> B_position = new ArrayList<Integer>();
					for (int i = 0; i < GB.length; i++)
						for(int j=0;j<Dlist.get(d).size();j++){
						if (Math.abs(GB[i]) == (Dlist.get(d).get(j))){
							B.add(GB[i]);
							B_position.add(i);
						}
					}
			Bdm.add(B);
			Bdm_position.add(B_position);
		}
		
		Y = new int[P][];
		for (int i = 0; i < Y.length; i++)
			Y[i] = new int[1];
		for (int p = 0; p < Y.length; p++)
			for (int h = 0; h < Y[p].length; h++) {
				for (int d = 0; d < D; d++)
					Y[p][h] += Adp[d][p];
			}
		
		X = new int[D][];
		for (int i = 0; i < D; i++)
			X[i] = new int[1];
		for (int d = 0; d < X.length; d++) {
			for (int j = 0; j < X[d].length; j++) {
				int a = 0;
				for (int p = 0; p < P; p++)
					a += Adp[d][p];
				if (a >= 1)
					X[d][j] = 1;
				else
					X[d][j] = 0;
			}
		}
		
		System.out.print(" X= ");
		for (int d = 0; d < X.length; d++) 
			for (int j = 0; j < X[d].length; j++) 
				if(X[d][j]==1)
				System.out.print(X[d][j]+" ");
		System.out.println();
		
		
		System.out.print(" Y= ");
		for (int p = 0; p < Y.length; p++) 
			for (int h = 0; h < Y[p].length; h++) 
				System.out.print(Y[p][h]+" ");
		System.out.println();
		
	}
	
	static void Bdm_print(List<Integer> Bdm,List<Integer> Bdm_postion)
	{
		System.out.println(" 輸出順序 與 BString 位置");
		for (int i = 0; i < Bdm.size(); i++) 
			System.out.print(Bdm.get(i)+" ");

		System.out.println();
		//return D;
		for (int i = 0; i < Bdm.size(); i++)
				System.out.print(Bdm_postion.get(i)+" ");
		
		System.out.println();
	}
	
	static void Parameter_print()
	{
		System.out.println(" 輸出 Md");
		System.out.println("Md = " + Md);
		System.out.println();
		
		System.out.println(" 輸出 rid");
		for(int i=0;i<P;i++)
		System.out.println("rid= " + Grid[i]);
		
		System.out.println(" 輸出 Si");
		for(int i=0;i<P;i++)
		System.out.println("Si= " + GSi[i]);
		
		System.out.println();
	}
	
	static double Odj(int d) {

		int location1, location2, k;
		double route = 0;
		location1 = Integer.parseInt(Read_INPUT_TXT_filter.getD_S_PLACE(d));
		
		location2 = Integer.parseInt(Read_INPUT_TXT_filter	.getD_D_ADDRESS(d));
		route += Read_distance.getDistance(location1, location2);
			

		double cost = Calculate_the_function.Odj_cost(route,
				Read_INPUT_TXT_filter.getDriverOilConsumption(d),
				Read_Generate_random_OilConsumptionBounds.Driver_OilPrice());
		return cost;
	}
	
	static double Cdj(int d, List<Integer> Bdm) {

		int location1, location2, k;
		int qdjk=0;
		double route = 0;
		location1 = Integer.parseInt(Read_INPUT_TXT_filter.getD_S_PLACE(d));
		for (int i = 0; i < Bdm.size(); i++) {
			if (Bdm.get(i) > 0) {
				k = Bdm.get(i);
				location2 = Integer.parseInt(Read_INPUT_TXT_filter
						.getP_R_PLACE(k - 1));
				route += Read_distance.getDistance(location1, location2);
				location1 = location2;
				qdjk++;
			} else if (Bdm.get(i) < 0) {
				k = -(Bdm.get(i));
				location2 = Integer.parseInt(Read_INPUT_TXT_filter
						.getP_D_ADDRESS(k - 1));
				route += Read_distance.getDistance(location1, location2);
				location1 = location2;
			}
		}
		location2 = Integer.parseInt(Read_INPUT_TXT_filter.getD_D_ADDRESS(d));
		route += Read_distance.getDistance(location1, location2);
		double cost = Calculate_the_function.Cdj_cost(route,
				Read_INPUT_TXT_filter.getDriverOilConsumption(d),
				Read_Generate_random_OilConsumptionBounds.Driver_OilPrice(),"Single_mode",qdjk);
		return cost;
	}
	
}