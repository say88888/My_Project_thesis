package GUI.GUI_Double_Auction;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import Input_Output_txt.Double_Auction.Read_Set_intput_CATS_Buyer_Parameter;
import Input_Output_txt.Double_Auction.Read_Set_intput_CATS_Seller_Parameter;
import Input_Output_txt.Double_Auction.Read_the_CATSexe_path;


public class Run_Cats_Output_0000txt {

	public static  void Single_Auction_Buyer() throws IOException, InterruptedException {
		
		Read_the_CATSexe_path.main();
		
		String path = Read_the_CATSexe_path.getPath();
		
		Read_Set_intput_CATS_Buyer_Parameter.Single_Auction();	
		
		    Runtime run = Runtime.getRuntime();   
		    String param1="-d";
			String param2="'"+Read_Set_intput_CATS_Buyer_Parameter.d_value()+"'";
			String param3="-goods";
			String param4= String.valueOf(Read_Set_intput_CATS_Buyer_Parameter.goods_value());
			String param5="-bids";
			String param6= String.valueOf(Read_Set_intput_CATS_Buyer_Parameter.bids_value());
			
			String	Parameter=" "+param1+" "+param2+" "+param3+" "+param4+" "+param5+" "+param6;
		 //   String Parameter= " -d 'arbitrary' -goods 5 -bids 8";
		    
		 //   Process process = run.exec("cmd.exe /k start " + path + " -d 'arbitrary' -goods 5 -bids 8");   
		    Process process = run.exec("cmd.exe /k start " + path + Parameter);   
		    final InputStream is1 = process.getInputStream();

	         new Thread(new Runnable() {

	             public void run() {

	                 BufferedReader br = new BufferedReader(new InputStreamReader(is1));

	                 try{

	                 while(br.readLine() != null) ;

	                 }

	                 catch(Exception e) {

	            e.printStackTrace();

	                 }

	             }
	         }).start(); 
	}
	
	public static  void Double_Auction_Buyer() throws IOException, InterruptedException {
		
		Read_the_CATSexe_path.main();
		
		String path = Read_the_CATSexe_path.getPath();
		
		Read_Set_intput_CATS_Buyer_Parameter.Double_Auction();	
		
		    Runtime run = Runtime.getRuntime();   
		    String param1="-d";
			String param2="'"+Read_Set_intput_CATS_Buyer_Parameter.d_value1()+"'";
			String param3="-goods";
			String param4= String.valueOf(Read_Set_intput_CATS_Buyer_Parameter.goods_value1());
			String param5="-bids";
			String param6= String.valueOf(Read_Set_intput_CATS_Buyer_Parameter.bids_value1());
			
			String	Parameter=" "+param1+" "+param2+" "+param3+" "+param4+" "+param5+" "+param6;
		 //   String Parameter= " -d 'arbitrary' -goods 5 -bids 8";
		    
		 //   Process process = run.exec("cmd.exe /k start " + path + " -d 'arbitrary' -goods 5 -bids 8");   
		    Process process = run.exec("cmd.exe /k start " + path + Parameter);   
		    final InputStream is1 = process.getInputStream();

	         new Thread(new Runnable() {

	             public void run() {

	                 BufferedReader br = new BufferedReader(new InputStreamReader(is1));

	                 try{

	                 while(br.readLine() != null) ;

	                 }

	                 catch(Exception e) {

	            e.printStackTrace();

	                 }

	             }
	         }).start(); 
	}
	
	public static  void Double_Auction_Seller() throws IOException, InterruptedException {
		
		Read_the_CATSexe_path.main();
		
		String path = Read_the_CATSexe_path.getPath();
		
		Read_Set_intput_CATS_Seller_Parameter.Double_Auction();	
		
		    Runtime run = Runtime.getRuntime();   
		    String param1="-d";
			String param2="'"+Read_Set_intput_CATS_Seller_Parameter.d_value()+"'";
			String param3="-goods";
			String param4= String.valueOf(Read_Set_intput_CATS_Seller_Parameter.goods_value());
			String param5="-bids";
			String param6= String.valueOf(Read_Set_intput_CATS_Seller_Parameter.bids_value());
			
			String	Parameter=" "+param1+" "+param2+" "+param3+" "+param4+" "+param5+" "+param6;
		 //   String Parameter= " -d 'arbitrary' -goods 5 -bids 8";
		    
		 //   Process process = run.exec("cmd.exe /k start " + path + " -d 'arbitrary' -goods 5 -bids 8");   
		    Process process = run.exec("cmd.exe /k start " + path + Parameter);   
		    final InputStream is1 = process.getInputStream();

	         new Thread(new Runnable() {

	             public void run() {

	                 BufferedReader br = new BufferedReader(new InputStreamReader(is1));

	                 try{

	                 while(br.readLine() != null) ;

	                 }

	                 catch(Exception e) {

	            e.printStackTrace();

	                 }

	             }
	         }).start(); 
	}
}
