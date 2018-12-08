package Generate_random_data;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

import GUI.I_Set_Paths_for_Current_Simulation_Example;
import carpool_Alogorithm_MOD.Calculate_the_function;

public class Read_CATS_output_and_Genarate_Seller_for_DoubleAuction {

	private static int I;
	private static int K;
	private static ArrayList<Integer> J = new ArrayList<Integer>();

	private static int[] max_number;
	
	public static void main() throws IOException {
		String str;
		String[][] Parameter1;
		Vector<String[]> str_vec = new Vector<String[]>(); // 暫存
		try {
			FileReader PBr = new FileReader(I_Set_Paths_for_Current_Simulation_Example.path()+"\\CATS_Auction\\Double_Auction\\CATS_Sellerbids.txt");
			// FileReader PBr = new FileReader(
			// "input\\Tourism_test\\Tourism\\Parameter.txt");
			BufferedReader br = new BufferedReader(PBr);
			while ((str = br.readLine()) != null) { // 每次讀一行
				str_vec.add(str.split("\\s")); // 將此行以空白(white space)切成字串陣列, 存入
			}
			br.close(); // 關檔
			Parameter1 = new String[str_vec.size()][]; // 產生二維陣列, //
														// 依據暫存的size(txt檔的行數)
			for (int i = 0; i < str_vec.size(); i++)
				Parameter1[i] = str_vec.elementAt(i); // 將暫存區每一個元素(一行裡的字串陣列)放入二維陣列

			K = Integer.parseInt(Parameter1[20][1]);

			ArrayList<List<String>> SellerBid = new ArrayList<List<String>>();
			for (int i = 24; i < Parameter1.length; i++) {
				ArrayList<String> bid = new ArrayList<String>();
				for (int j = 1; j < Parameter1[i].length; j++)
					if (!Parameter1[i][j].contains("#"))
						bid.add(Parameter1[i][j]);
				SellerBid.add(bid);
			}

			for (int i = 0; i < SellerBid.size(); i++)
				for (int j = i + 1; j < SellerBid.size(); j++)
					if ((SellerBid.get(i).size() == SellerBid.get(j).size())
							&& (SellerBid.get(i).size() != SellerBid.get(i + 1)
									.size()))
						Collections.swap(SellerBid, j, i + 1);

			for (int i = 0; i < SellerBid.size(); i++) {
				for (int j = 1; j < SellerBid.get(i).size(); j++)
					System.out.print(SellerBid.get(i).get(j) + " ");
				System.out.println();
			}
			J = new ArrayList<Integer>();
			ArrayList<List<Integer>> n = new ArrayList<List<Integer>>();
			ArrayList<Integer> b = new ArrayList<Integer>();
			for (int i = 0; i < SellerBid.size(); i++) {
				if (!b.contains(i))
					b.add(i);
				boolean right = true;
				for (int j = i + 1; j < SellerBid.size(); j++) {
					if (SellerBid.get(i).size() == SellerBid.get(j).size()) {
						right = false;
						if (!b.contains(j))
							b.add(j);
					}
				}
				if (right == true) {
					n.add(b);
					b = new ArrayList<Integer>();
				}
			}

			for (int i = 0; i < n.size(); i++)
				J.add(n.get(i).size());
			I = J.size();

			System.out.println(I);
			for (int i = 0; i < I; i++)
				System.out.print (J.get(i)+" ");
			double[][] sellerbid = new double[SellerBid.size()][K + 1];
			for (int i = 0; i < SellerBid.size(); i++) {
				for (int j = 1; j < SellerBid.get(i).size(); j++)
					sellerbid[i][j - 1] = Double.parseDouble(SellerBid.get(i)
							.get(j));
				sellerbid[i][K] = Double.parseDouble(SellerBid.get(i).get(0));
			}
			
			System.out.println("-------Sellerbid-------------");
			for (int i = 0; i < sellerbid.length; i++) {
				for (int j = 0; j < sellerbid[i].length; j++)
					System.out.print(sellerbid[i][j] + " ");
				System.out.println();
			}
			
			Get_goods_maxnumber(sellerbid);
			make_ALL_Double_Action(sellerbid);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void make_ALL_Double_Action(double[][] SellerBid) throws IOException
	{
	//	for (int i = 0; i < H.size(); i++)
	//		System.out.print("H = "+H.get(i));
		
	//	NumberFormat nf1 = NumberFormat.getInstance();
	//	nf1.setMaximumFractionDigits(3);
		FileWriter fw1 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path()+"\\Double_Action\\Seller_Double_Action.txt");
		for(int i=0;i<SellerBid.length;i++){
			for(int j=0;j<SellerBid[i].length-1;j++)
				fw1.write(String.valueOf((int)SellerBid[i][j]) + " ");
			fw1.write(String.valueOf(SellerBid[i][SellerBid[i].length-1]) + " ");
			fw1.write("\r\n");
		}
		fw1.close();
	 
	}
	
	public static void  Get_goods_maxnumber(double[][] SellerBid)
	{
		max_number=new int[K];
		
		for(int j=0;j<K;j++){
		int max=0;
			for(int i=0;i<SellerBid.length;i++){
				if(max <(int)SellerBid[i][j] )
					max=(int)SellerBid[i][j];
			}
			max_number[j]=max;
		}
	}
	
	public static int I(){
		return I;
	}
	public static ArrayList<Integer> J(){
		return J;
	}
	public static int max_number(int i){
		return max_number[i];
	}
}
