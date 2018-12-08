package Generate_random_data;

import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Random;

import GUI.I_Set_Paths_for_Current_Simulation_Example;
import Input_Output_txt.Double_Auction.Read_Buyer_Parameter;
import Input_Output_txt.Double_Auction.Read_Sik_Parameter;
import carpool_Alogorithm_MOD.Calculate_the_function;

public class Generate_random_Double_Auction {

	private static int I; // 產生賣方人數
	private static int N; // 產生買方人數
	private static int[] I_J; // 產生賣方投標數量
	private static int[] N_H; //  產生買方投標數量
	private static int[][] SellerBid;
	private static int[][] BuyerBid;
	private static int[] SellertotalQuantity;
	public	static void Generate_Data_of_Double_Auction_Sik() throws IOException
	{
		
		int[][] Sik=new int[I][Read_Generate_random_Double_Auction.K()];
		Random r = new Random();
		Read_Sik_Parameter.main();
		for(int i=0;i<Sik.length;i++) 
			for(int j=0;j<Sik[i].length;j++) 
				Sik[i][j]= r.nextInt((Read_Sik_Parameter.top()+1)-Read_Sik_Parameter.bot() )+Read_Sik_Parameter.bot();
		 
		make_Sik(Sik);
	}
		
	public	static void Generate_Data_of_Double_Auction_Seller() throws IOException{
		try {
			Read_Generate_random_Double_Auction.main();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	I=Read_Generate_random_Double_Auction.Seller();
	I_J=new int[I];
	int random,Ik=0,Pk=0,n=0;
	
	//隨機機產生 DriverBids.txt --------------------------------------------------
		for(int i=0;i<I;i++)
		{
			random=(int) Calculate_the_function.random(1,1); 
			I_J[i]=random;
			Ik+=I_J[i];
		}
		SellerBid=new int[Ik][Read_Generate_random_Double_Auction.K()+1];
		
		for(int i=0;i<Ik;i++)
		{
			while(n<1){
				int t=0;
				for(int l=0;l<Read_Generate_random_Double_Auction.K();l++){
					if(Calculate_the_function.random(0,1)<0.5){
						SellerBid[i][l]=(int)(Math.random()*Read_Generate_random_Double_Auction.K_top())+1;
						t+=SellerBid[i][l];
						n++;
					}
					else
						SellerBid[i][l]=0;
				} 
				SellerBid[i][Read_Generate_random_Double_Auction.K()]=t*(int) Calculate_the_function.random(20,40);                       // 30到 50之 間
			}
				n=0;
		}
		make_SellerBid(SellerBid,Ik);
	}
	public	static void Generate_Data_of_Double_Auction_Buyer() throws IOException{
		try {
			Read_Generate_random_Double_Auction.main();
			Read_Buyer_Parameter.main( );
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	 
	N=Read_Generate_random_Double_Auction.Buyer();
	 
	N_H=new int[N];
	int random,Dk=0,Nk=0,n=0;
	//隨機機產生 PassengerBid.txt --------------------------------------------------
	for(int i=0;i<N;i++)
	{
		random=(int) Calculate_the_function.random(1,1); 
		N_H[i]=random;
		Nk+=N_H[i];
	}
	 SellertotalQuantity=new int[Read_Generate_random_Double_Auction.K()];
	for(int i=0;i<Read_Generate_random_Double_Auction.K();i++){
		int total=0;
		for(int j=0;j<SellerBid.length;j++)
			total+=SellerBid[j][i];
		SellertotalQuantity[i]=total;
	}
	for(int i=0;i<SellertotalQuantity.length;i++)
		System.out.println(SellertotalQuantity[i]);
	BuyerBid=new int[Nk][Read_Generate_random_Double_Auction.K()+1];
	n=0;
	
	Random r = new Random();
	for(int i=0;i<Nk;i++)
	{
		while(n<1){
			int t=0;
			for(int l=0;l<Read_Generate_random_Double_Auction.K();l++){
				if(Calculate_the_function.random(0,1)<0.5 && SellertotalQuantity[l]!=0){
				
					//BuyerBid[i][l]=(int)(Math.random()*Read_Generate_random_Double_Auction.K_top())+1;
					BuyerBid[i][l]=r.nextInt(SellertotalQuantity[l])+1;
					t+=BuyerBid[i][l];
					n++;
					
				}
				else
					BuyerBid[i][l]=0;
			} 
			BuyerBid[i][Read_Generate_random_Double_Auction.K()]=t*(int) Calculate_the_function.random(20,40)+Read_Buyer_Parameter.price();                       // 30到 50之 間
		}
			n=0;
	}
	make_BuyerBid(BuyerBid,Nk);
	make_Parameter(I_J,N_H); 
	}
	public static void make_SellerBid(int[][] SellerBid, int k) throws IOException
	{
		FileWriter fw2 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path()+"\\Double_Action\\Seller_Double_Action.txt");
		
		for(int i=0;i<k;i++){
			for(int j=0;j<Read_Generate_random_Double_Auction.K()+1;j++){
			fw2.write(String.valueOf(SellerBid[i][j]) + " ");
			}
			fw2.write("\r\n");
		}
		fw2.close();
	}
	public static void make_BuyerBid(int[][] BuyerBid, int k) throws IOException
	{
		FileWriter fw2 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path()+"\\Double_Action\\Buyer_Double_Action.txt");
		for(int i=0;i<k;i++){
			for(int j=0;j<Read_Generate_random_Double_Auction.K()+1;j++)
			fw2.write(String.valueOf(BuyerBid[i][j]) + " ");
			
			fw2.write("\r\n");
		}
		fw2.close();
	}
	public static void make_Parameter(int[] D_N, int[] P_N) throws IOException
	{
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(1);
		FileWriter fw2 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path()+"\\Double_Action\\Parameter_Double_Action.txt");
		fw2.write(String.valueOf(N) + "\r\n");
		for(int i=0;i<N;i++)
		fw2.write(String.valueOf(P_N[i]) +" ");
		fw2.write("\r\n");
		fw2.write(String.valueOf(I) + "\r\n");
		for(int i=0;i<I;i++)
		fw2.write(String.valueOf(D_N[i]) + " ");
		fw2.write("\r\n");
		fw2.write(String.valueOf(Read_Generate_random_Double_Auction.K()) + "\r\n");
		fw2.write(String.valueOf(nf.format(Calculate_the_function.random(0,1))) + "\r\n");
		fw2.write(String.valueOf(nf.format(Calculate_the_function.random(0,1))) + "\r\n");
		
		fw2.close();
	}
	
	public static void make_Sik(int[][] Sik ) throws IOException
	{
		FileWriter fw2 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path()+"\\Double_Action\\Sik.txt");
		
		for(int i=0;i<Sik.length;i++){
			for(int j=0;j<Sik[i].length;j++){
			fw2.write(String.valueOf(Sik[i][j]) + " ");
			}
			fw2.write("\r\n");
		}
		fw2.close();
	}

	
}
