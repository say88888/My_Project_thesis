package Generate_random_data;

import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import GUI.I_Set_Paths_for_Current_Simulation_Example;
import Input_Output_txt.Double_Auction.Read_Seller_Parameter_Buyer;
import Input_Output_txt.Double_Auction.Read_Sik_Parameter;
import carpool_Alogorithm_MOD.Calculate_the_function;

public class Generate_random_DA_Seller {
	private static int I; // 產生賣方人數
	private static int N; // 產生買方人數
	
	private static int[][] SellerBid;
	private static int[][] BuyerBid;
	private static int[] SellertotalQuantity;

	public static void Generate_Data_of_Double_Auction_Seller()throws IOException {
		try {
			Read_Generata_random_Double_Auction_Buyer.main();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
		List<List<Integer>> sellerbid = new ArrayList<List<Integer>>();
		List<Integer> K = new ArrayList<Integer>();
		
		Random r = new Random();
		for(int i=1;i<=Read_Generata_random_Double_Auction_Buyer.K();i++)
			K.add(i);
		while(K.size()!=0){
			int price=0;
			int[]SellerBid1 = new int[Read_Generata_random_Double_Auction_Buyer.K()+1 ];
			for(int k=0;k<SellerBid1.length;k++)
				SellerBid1[k]=0;
			for(int i=0;i< r.nextInt(Read_Generata_random_Double_Auction_Buyer.M()) + 1;i++){
				if(K.size()!=0){
					
				int n=r.nextInt(K.size());
				 
				SellerBid1[K.get(n)-1]= (int) (Math.random() * Read_Generata_random_Double_Auction_Buyer.K_top()) + 1;
				price+=(int) (Math.random() * Read_Generata_random_Double_Auction_Buyer.K_top()) + 1;
				K.remove(n);
				}
			}
			SellerBid1[SellerBid1.length-1]=Read_Generata_random_Double_Auction_Buyer.Buyerprice()+price* (int) Calculate_the_function.random(20, 40); 
			List<Integer> listData = new ArrayList<Integer>();
			for(int k=0;k<SellerBid1.length;k++)
				listData.add(SellerBid1[k]);
			sellerbid.add(listData);
		
		}
		I=sellerbid.size();
		SellerBid = new int[I][Read_Generata_random_Double_Auction_Buyer.K() + 1];
		for(int i=0;i<SellerBid.length;i++)
			for(int j=0;j<SellerBid[i].length;j++)
				SellerBid[i][j]=sellerbid.get(i).get(j);

		 make_SellerBid(sellerbid);

	}

	public static void Generate_Data_of_Double_Auction_Sik() throws IOException {

		int[][] Sik = new int[I][Read_Generata_random_Double_Auction_Buyer.K()];
		Random r = new Random();
		Read_Sik_Parameter.main();
		for (int i = 0; i < Sik.length; i++)
			for (int j = 0; j < Sik[i].length; j++)
				Sik[i][j] = r.nextInt((Read_Sik_Parameter.top() + 1)
						- Read_Sik_Parameter.bot())
						+ Read_Sik_Parameter.bot();

		make_Sik(Sik);
	}

	public static void Generate_Data_of_Double_Auction_Buyer()
			throws IOException {
		try {
			Read_Seller_Parameter_Buyer.main();
			Read_Generata_random_Double_Auction_Buyer.main();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		int Dk = 0, n = 0;
		Random r = new Random();
		List<List<Integer>> buyerbid = new ArrayList<List<Integer>>();
		List<List<Integer>> sellerbid = new ArrayList<List<Integer>>();
		for (int i = 0; i < SellerBid.length; i++) {
			List<Integer> ListData = new ArrayList<Integer>();
			for (int j = 0; j < SellerBid[i].length; j++) {
				ListData.add(SellerBid[i][j]);
			}
			sellerbid.add(ListData);
		}

		while (sellerbid.size() != 0) {
			SellertotalQuantity = new int[Read_Generata_random_Double_Auction_Buyer.K() + 1];
			for (int j = 0; j < r.nextInt(Read_Seller_Parameter_Buyer.Q()) + 1; j++) {
				if(sellerbid.size()!=0){
				n = r.nextInt(sellerbid.size());
				for (int k = 0; k < Read_Generata_random_Double_Auction_Buyer.K() + 1; k++)
					SellertotalQuantity[k] += sellerbid.get(n).get(k);
				sellerbid.remove(n);
				}
			}
			List<Integer> ListData = new ArrayList<Integer>();
			for (int i = 0; i < SellertotalQuantity.length - 1; i++)
				ListData.add(SellertotalQuantity[i]);
			ListData.add(SellertotalQuantity[SellertotalQuantity.length - 1] + Read_Seller_Parameter_Buyer.price());
				
			buyerbid.add(ListData);
			if(Read_Seller_Parameter_Buyer.R()!=1){
				ListData = new ArrayList<Integer>();
				for(int i=0;i<Read_Seller_Parameter_Buyer.R()-1;i++){
					for (int j = 0; j < SellertotalQuantity.length - 1; j++)
						ListData.add(SellertotalQuantity[j]);
					ListData.add(SellertotalQuantity[SellertotalQuantity.length - 1] + Read_Seller_Parameter_Buyer.price()+ r.nextInt((Read_Seller_Parameter_Buyer.topprice() + 1)- Read_Seller_Parameter_Buyer.botprice())+ Read_Seller_Parameter_Buyer.botprice());
				}
				buyerbid.add(ListData);
			}
		}
		

		N=buyerbid.size();
		 make_BuyerBid(buyerbid);
		make_Parameter(buyerbid.size());
	}

	public static void make_SellerBid(List<List<Integer>> sellerbid )
			throws IOException {
		FileWriter fw2 = new FileWriter(
				I_Set_Paths_for_Current_Simulation_Example.path()
						+ "\\Double_Action\\Seller_Double_Action.txt");

		for (int i = 0; i < sellerbid.size(); i++) {
			for (int j = 0; j < sellerbid.get(i).size(); j++) {
				fw2.write(String.valueOf(sellerbid.get(i).get(j)) + " ");
			}
			fw2.write("\r\n");
		}
		fw2.close();
	}

	public static void make_BuyerBid(List<List<Integer>> buyerbid)
			throws IOException {
		FileWriter fw2 = new FileWriter(
				I_Set_Paths_for_Current_Simulation_Example.path()
						+ "\\Double_Action\\Buyer_Double_Action.txt");
		for (int i = 0; i < buyerbid.size(); i++) {
			for (int j = 0; j < buyerbid.get(i).size(); j++)
				fw2.write(String.valueOf(buyerbid.get(i).get(j)) + " ");

			fw2.write("\r\n");
		}
		fw2.close();
	}

	public static void make_Parameter(int buyer) throws IOException {
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(1);
		FileWriter fw2 = new FileWriter(
				I_Set_Paths_for_Current_Simulation_Example.path()
						+ "\\Double_Action\\Parameter_Double_Action.txt");
		fw2.write(String.valueOf(buyer) + "\r\n");
		for (int i = 0; i < N; i++)
			fw2.write(String.valueOf(1) + " ");
		fw2.write("\r\n");
		fw2.write(String.valueOf(I) + "\r\n");
		for (int i = 0; i < I; i++)
			fw2.write(String.valueOf(1) + " ");
		fw2.write("\r\n");
		fw2.write(String.valueOf(Read_Generata_random_Double_Auction_Buyer.K())
				+ "\r\n");
		fw2.write(String.valueOf(nf.format(Calculate_the_function.random(0, 1))) + "\r\n");
		fw2.write(String.valueOf(nf.format(Calculate_the_function.random(0, 1))) + "\r\n");

		fw2.close();
	}

	public static void make_Sik(int[][] Sik) throws IOException {
		FileWriter fw2 = new FileWriter(
				I_Set_Paths_for_Current_Simulation_Example.path()
						+ "\\Double_Action\\Sik.txt");

		for (int i = 0; i < Sik.length; i++) {
			for (int j = 0; j < Sik[i].length; j++) {
				fw2.write(String.valueOf(Sik[i][j]) + " ");
			}
			fw2.write("\r\n");
		}
		fw2.close();
	}

}
