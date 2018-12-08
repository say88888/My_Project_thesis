package Generate_random_data;

import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import GUI.I_Set_Paths_for_Current_Simulation_Example;
import Input_Output_txt.Double_Auction.Read_Seller_Price_Parameter;
import Input_Output_txt.Double_Auction.Read_Sik_Parameter;
import carpool_Alogorithm_MOD.Calculate_the_function;

public class Generate_random_DA_Problem3 {
	private static int I; // 產生賣方人數
	private static int N; // 產生買方人數
	private static int K; // 產生物品種類
	private static int[] N_H; // 產生買方投標數量
	private static int[][] SellerBid;
	private static int[][] BuyerBid;

	public static void Generate_Data_of_Double_Auction_Sik() throws IOException
	{

		try {
			Read_Generate_random_Double_Auction.main();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		I = Read_Generate_random_Double_Auction.Seller();
		K= Read_Generate_random_Double_Auction.K();
		int[][] Sik = new int[I][K];
		Random r = new Random();
		Read_Sik_Parameter.main();
		for (int i = 0; i < Sik.length; i++)
			for (int j = 0; j < Sik[i].length; j++)
				Sik[i][j] = r.nextInt((Read_Sik_Parameter.top() + 1) - Read_Sik_Parameter.bot()) + Read_Sik_Parameter.bot();

		make_Sik(Sik);
	}

	public static void Generate_Data_of_Double_Auction_Seller() throws IOException {
		try {
			Read_Generate_random_Double_Auction.main();
			Read_Seller_Price_Parameter.main();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		I = Read_Generate_random_Double_Auction.Seller();
		K= Read_Generate_random_Double_Auction.K();
		SellerBid = new int[I][K];
		Random r = new Random();
		for(int i=0;i<SellerBid.length;i++){
			for(int k=0;k<SellerBid[i].length;k++){
				SellerBid[i][k]=r.nextInt((Read_Seller_Price_Parameter.top() + 1) - Read_Seller_Price_Parameter.bot()) + Read_Seller_Price_Parameter.bot();
			}
		}
		
		make_SellerBid(SellerBid);
		make_Parameter(N_H);
	}

	public static void Generate_Data_of_Double_Auction_Buyer() throws IOException {
		try {
			Read_Generate_random_Double_Auction.main();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		N = Read_Generate_random_Double_Auction.Buyer();
		N_H = new int[N];
		int random, Ik = 0, Pk = 0, n = 0;

		// 隨機機產生 DriverBids.txt
		// --------------------------------------------------
		for (int i = 0; i < N; i++)
		{
			random = (int) Calculate_the_function.random(1, 1);
			N_H[i] = random;
			Ik += N_H[i];
		}
		BuyerBid = new int[Ik][Read_Generate_random_Double_Auction.K() + 1];

		for (int i = 0; i < Ik; i++)
		{
			while (n < 1) {
				int t = 0;
				for (int l = 0; l < Read_Generate_random_Double_Auction.K(); l++) {
					if (Calculate_the_function.random(0, 1) < 0.5) {
						BuyerBid[i][l] = (int) (Math.random() * Read_Generate_random_Double_Auction.K_top()) + 1;
						t += BuyerBid[i][l];
						n++;
					}
					else
						BuyerBid[i][l] = 0;
				}
				BuyerBid[i][Read_Generate_random_Double_Auction.K()] = t * (int) Calculate_the_function.random(20, 40); // 30到50之間
			}
			n = 0;
		}
		make_BuyerBid(BuyerBid, Ik);

	}

	public static void make_SellerBid(int[][] SellerBid) throws IOException
	{
		FileWriter fw2 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path() + "\\Double_Action\\Seller_Double_Action.txt");

		for (int i = 0; i < SellerBid.length; i++) {
			for (int j = 0; j < SellerBid[i].length; j++) {
				fw2.write(String.valueOf(SellerBid[i][j]) + " ");
			}
			fw2.write("\r\n");
		}
		fw2.close();
	}

	public static void make_BuyerBid(int[][] BuyerBid, int k) throws IOException
	{
		FileWriter fw2 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path() + "\\Double_Action\\Buyer_Double_Action.txt");
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < Read_Generate_random_Double_Auction.K() + 1; j++)
				fw2.write(String.valueOf(BuyerBid[i][j]) + " ");

			fw2.write("\r\n");
		}
		fw2.close();
	}

	public static void make_Parameter( int[] P_N) throws IOException
	{
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(1);
		FileWriter fw2 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path() + "\\Double_Action\\Parameter_Double_Action.txt");
		fw2.write(String.valueOf(N) + "\r\n");
		for (int i = 0; i < N; i++)
			fw2.write(String.valueOf(P_N[i]) + " ");
		fw2.write("\r\n");
		fw2.write(String.valueOf(I) + "\r\n");
	
		fw2.write(String.valueOf(Read_Generate_random_Double_Auction.K()) + "\r\n");
		fw2.write(String.valueOf(nf.format(Calculate_the_function.random(0, 1))) + "\r\n");
		fw2.write(String.valueOf(nf.format(Calculate_the_function.random(0, 1))) + "\r\n");

		fw2.close();
	}

	public static void make_Sik(int[][] Sik) throws IOException
	{
		FileWriter fw2 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path() + "\\Double_Action\\Sik.txt");

		for (int i = 0; i < Sik.length; i++) {
			for (int j = 0; j < Sik[i].length; j++) {
				fw2.write(String.valueOf(Sik[i][j]) + " ");
			}
			fw2.write("\r\n");
		}
		fw2.close();
	}

}
