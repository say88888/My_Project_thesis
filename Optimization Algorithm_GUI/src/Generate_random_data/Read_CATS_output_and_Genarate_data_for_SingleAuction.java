package Generate_random_data;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

import GUI.I_Set_Paths_for_Current_Simulation_Example;
import carpool_Alogorithm_MOD.Calculate_the_function;

public class Read_CATS_output_and_Genarate_data_for_SingleAuction {

	private static int N;
	private static int K;
	private static ArrayList<Integer> H = new ArrayList<Integer>();

	
	public static void main() throws IOException {
		String str;
		String[][] Parameter1;
		Vector<String[]> str_vec = new Vector<String[]>(); // 暫存
		try {
			FileReader PBr = new FileReader(I_Set_Paths_for_Current_Simulation_Example.path()+"\\CATS_Auction\\Single_Auction\\CATS_Buyerbids.txt");
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

			ArrayList<List<String>> BuyerBid = new ArrayList<List<String>>();
			for (int i = 24; i < Parameter1.length; i++) {
				ArrayList<String> bid = new ArrayList<String>();
				for (int j = 1; j < Parameter1[i].length; j++)
					if (!Parameter1[i][j].contains("#"))
						bid.add(Parameter1[i][j]);
				BuyerBid.add(bid);
			}

			for (int i = 0; i < BuyerBid.size(); i++)
				for (int j = i + 1; j < BuyerBid.size(); j++)
					if ((BuyerBid.get(i).size() == BuyerBid.get(j).size())
							&& (BuyerBid.get(i).size() != BuyerBid.get(i + 1)
									.size()))
						Collections.swap(BuyerBid, j, i + 1);

			for (int i = 0; i < BuyerBid.size(); i++) {
				for (int j = 1; j < BuyerBid.get(i).size(); j++)
					System.out.print(BuyerBid.get(i).get(j) + " ");
				System.out.println();
			}
			H = new ArrayList<Integer>();
			ArrayList<List<Integer>> n = new ArrayList<List<Integer>>();
			ArrayList<Integer> b = new ArrayList<Integer>();
			for (int i = 0; i < BuyerBid.size(); i++) {
				if (!b.contains(i))
					b.add(i);
				boolean right = true;
				for (int j = i + 1; j < BuyerBid.size(); j++) {
					if (BuyerBid.get(i).size() == BuyerBid.get(j).size()) {
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
				H.add(n.get(i).size());
			N = H.size();

			System.out.println(N);
			for (int i = 0; i < N; i++)
				System.out.print (H.get(i)+" ");
			double[][] buyerbid = new double[BuyerBid.size()][K + 1];
			for (int i = 0; i < BuyerBid.size(); i++) {
				for (int j = 1; j < BuyerBid.get(i).size(); j++)
					buyerbid[i][j - 1] = Double.parseDouble(BuyerBid.get(i).get(j));
				buyerbid[i][K] = Double.parseDouble(BuyerBid.get(i).get(0));
			}
			
			System.out.println("-------buyerbid-------------");
			for (int i = 0; i < buyerbid.length; i++) {
				for (int j = 0; j < buyerbid[i].length; j++)
					System.out.print(buyerbid[i][j] + " ");
				System.out.println();
			}
			
			make_ALL_Double_Action(buyerbid);
				
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void make_ALL_Double_Action(double[][] BuyerBid) throws IOException
	{
	//	for (int i = 0; i < H.size(); i++)
	//		System.out.print("H = "+H.get(i));
		
		int[] SellerBids=Get_goods_maxnumber(BuyerBid);
		
	FileWriter fw = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path()+"\\Double_Action\\Seller_Double_Action.txt");
		
		for(int i=0;i<SellerBids.length;i++)
			fw.write(String.valueOf(SellerBids[i]) + " ");

		fw.write("0");
		fw.close();
		
	/*	NumberFormat nf1 = NumberFormat.getInstance();
		nf1.setMaximumFractionDigits(3);*/
		FileWriter fw1 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path()+"\\Double_Action\\Buyer_Double_Action.txt");
		for(int i=0;i<BuyerBid.length;i++){
			for(int j=0;j<BuyerBid[i].length-1;j++)
				fw1.write(String.valueOf((int)BuyerBid[i][j]) + " ");
			fw1.write(String.valueOf(BuyerBid[i][BuyerBid[i].length-1]) + " ");
			fw1.write("\r\n");
		}
		fw1.close();
		
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(1);
		FileWriter fw3 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path()+"\\Double_Action\\Parameter_Double_Action.txt");
		fw3.write(String.valueOf(N) + "\r\n");
		for(int i=0;i<N;i++)
		fw3.write(String.valueOf(H.get(i)) +" ");
		fw3.write("\r\n");
		fw3.write(String.valueOf(1) + "\r\n");
	//	for(int i=0;i<I;i++)
		fw3.write(String.valueOf(1) + " ");
		fw3.write("\r\n");
		fw3.write(String.valueOf(K) + "\r\n");
		fw3.write(String.valueOf(nf.format(Calculate_the_function.random(0,1))) + "\r\n");
		fw3.write(String.valueOf(nf.format(Calculate_the_function.random(0,1))) + "\r\n");
		
		fw3.close();
		
		FileWriter fw4 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path()+"\\Double_Action\\Sik.txt");
		
			for(int i=0;i<SellerBids.length;i++)
				fw4.write(String.valueOf(SellerBids[i]) + " ");
			fw4.write("\r\n");
		fw4.close();
		
	}
	
	public static int[]  Get_goods_maxnumber(double[][] BuyerBid)
	{
		int max_number[]=new int[K];
		
		for(int j=0;j<K;j++){
		int max=0;
			for(int i=0;i<BuyerBid.length;i++){
				if(max <(int)BuyerBid[i][j] )
					max=(int)BuyerBid[i][j];
			}
			max_number[j]=max;
		}
		return max_number;
	}
	


	
}
