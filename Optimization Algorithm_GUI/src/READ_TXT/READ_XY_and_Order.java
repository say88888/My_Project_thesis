package READ_TXT;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import GUI.I_Set_Paths_for_Current_Simulation_Example;
import GUI.GUI_Carpool.X_Select_Algorithm_Type_to_Solve_the_Problem;
import Input_Output_txt.Carpool.Read_BPL_TXT;
import Input_Output_txt.Carpool.Read_CarpoolData_Generation_Mode;
import Input_Output_txt.Carpool.check_batch_TXT;
import Result_to_out_Carpool.Read_Carpool_file;


public class READ_XY_and_Order {
	private static ArrayList<String> X = new ArrayList<String>();
	private static ArrayList<String> Y = new ArrayList<String>();
	private static ArrayList<String> Y1 = new ArrayList<String>();
	private static ArrayList<String> DriverBids = new ArrayList<String>();
	private static String[][]  Orders;
	private static String[][] DriverBids1, X2, Bids1,Y2;
	private static int[][] Bids;
	private static int[][] Order;
	private static String[] D;
	private static int[] DB;
	private static int[] DB_lenght;
	private static int[] Order_lengh;
	
	private static ArrayList<String> P_ID = new ArrayList<String>();
	private static ArrayList<String> PassengerList = new ArrayList<String>();
	private static ArrayList<String> PassengerList1 = new ArrayList<String>();
	static String data_mode;
	
	public static void main( ) throws IOException {
		// TODO Auto-generated method stub
		
		
		X.clear();
		Y.clear();
		Y1.clear();
		DriverBids.clear();
		
		P_ID.clear();
		PassengerList.clear();
		PassengerList1.clear();
		
		Read_Carpool_file.loadData();
		Read_INPUT_TXT_filter.loadData();
		Read_CarpoolData_Generation_Mode.main();
		
		if(Read_CarpoolData_Generation_Mode.mode().contains("multi_hop")){
			Read_BPL_TXT.main();
			data_mode="multi_hop";
		}else{data_mode="Single_mode";}
		
		for(int i=0;i<Read_INPUT_TXT_filter.getP();i++){
			//判斷是否已有此字串
			if(!P_ID.contains(Read_INPUT_TXT_filter.getP_ID(i))){
			  //無字串,加入字串
				P_ID.add(Read_INPUT_TXT_filter.getP_ID(i));
			}
		}
		
		if(data_mode.equals("Single_mode")){
		for(int i=0;i<Read_INPUT_TXT_filter.getP();i++){
			//判斷是否已有此字串
			if(!PassengerList.contains(Read_INPUT_TXT_filter.getP_ID(i)) || !PassengerList1.contains(Read_INPUT_TXT_filter.getP_R_PLACE(i))){
			  //無字串,加入字串
				PassengerList.add(Read_INPUT_TXT_filter.getP_ID(i));
				PassengerList1.add(Read_INPUT_TXT_filter.getP_R_PLACE(i));
			}
		}
		}else
		{
			for(int i=0;i<Read_INPUT_TXT_filter.getP();i++){
				//判斷是否已有此字串
				if(!PassengerList.contains(Read_INPUT_TXT_filter.getP_D_ADDRESS(i)) || !PassengerList1.contains(Read_INPUT_TXT_filter.getP_R_PLACE(i))){
				  //無字串,加入字串
					PassengerList.add(Read_INPUT_TXT_filter.getP_D_ADDRESS(i));
					PassengerList1.add(Read_INPUT_TXT_filter.getP_R_PLACE(i));
				}
			}
		}
		
		DriverBids1 = new String[Read_Carpool_file.getD()][];
		X2 = new String[Read_Carpool_file.getD()][];
		Y2= new String[Read_Carpool_file.getP()][];
		for (int i = 0; i < Read_Carpool_file.getD(); i++) {
			DriverBids1[i] = new String[Read_Carpool_file.getJd(i)];
			X2[i] = new String[Read_Carpool_file.getJd(i)];
		}
		
		for (int i = 0; i < Read_Carpool_file.getP(); i++) {
			Y2[i] = new String[Read_Carpool_file.getHp(i)];
		}
		
		String str;
		
		if(GUI.main.getmethod()!=2){
		try {
			FileReader PBr = new FileReader("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+
					
					X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"X.txt");
			
			BufferedReader br = new BufferedReader(PBr);
			while ((str = br.readLine()) != null) { // 每次讀一行
				X.add(str);// 將此行以空白(white space)切成字串陣列, 存入 Vector暫存
			}
			br.close(); // 關檔
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			FileReader PBr = new FileReader("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+
					X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"Y.txt");
			BufferedReader br = new BufferedReader(PBr);
			while ((str = br.readLine()) != null) { // 每次讀一行
				Y.add(str);// 將此行以空白(white space)切成字串陣列, 存入 Vector暫存
			}
			br.close(); // 關檔
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
		else if(GUI.main.getmethod()==2)
		{
			String str1;
			str1=check_batch_TXT.getString(check_batch_TXT.getN1());
			System.out.println(str1);
			
			try {
				FileReader PBr = new FileReader("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"
			+X_Select_Algorithm_Type_to_Solve_the_Problem.method()+"_Batch\\"+str1+"\\X.txt");
				
				BufferedReader br = new BufferedReader(PBr);
				while ((str = br.readLine()) != null) { // 每次讀一行
					X.add(str);// 將此行以空白(white space)切成字串陣列, 存入 Vector暫存
				}
				br.close(); // 關檔
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				FileReader PBr = new FileReader("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"
						+X_Select_Algorithm_Type_to_Solve_the_Problem.method()+"_Batch\\"+str1+"\\Y.txt");
				BufferedReader br = new BufferedReader(PBr);
				while ((str = br.readLine()) != null) { // 每次讀一行
					Y.add(str);// 將此行以空白(white space)切成字串陣列, 存入 Vector暫存
				}
				br.close(); // 關檔
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		int k = 0;
		if(X_Select_Algorithm_Type_to_Solve_the_Problem.Advance_bid()==true)
		{
			System.out.println("Yes"+X_Select_Algorithm_Type_to_Solve_the_Problem.method());
			
		try {
			FileReader PBr = new FileReader(I_Set_Paths_for_Current_Simulation_Example.path()+"\\Carpool\\DriverBids.txt");
			BufferedReader br = new BufferedReader(PBr);
			while ((str = br.readLine()) != null) { // 每次讀一行
				DriverBids.add(str);// 將此行以空白(white space)切成字串陣列, 存入 Vector暫存
			}
			br.close(); // 關檔
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		Vector<String []> str_vec = new Vector<String []>(); //暫存
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
			
			System.out.println("No"+X_Select_Algorithm_Type_to_Solve_the_Problem.method());
			
		try {
			FileReader PBr = new FileReader(I_Set_Paths_for_Current_Simulation_Example.path()+"\\Carpool\\"+X_Select_Algorithm_Type_to_Solve_the_Problem.method()+"\\DriverBids.txt");
			BufferedReader br = new BufferedReader(PBr);
			while ((str = br.readLine()) != null) { // 每次讀一行
				DriverBids.add(str);// 將此行以空白(white space)切成字串陣列, 存入 Vector暫存
			}
			br.close(); // 關檔
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		Vector<String []> str_vec = new Vector<String []>(); //暫存
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
		
		k=0;
	
		System.out.println("X= "+X);
		
		for (int i = 0; i < DriverBids1.length; i++) {
			for (int j = 0; j < DriverBids1[i].length; j++) {
				X2[i][j] = X.get(k);
				DriverBids1[i][j] = DriverBids.get(k);
				k++;
			}
		}
		
		for (int i = 0; i < DriverBids1.length; i++)
			for (int j = 0; j < DriverBids1[i].length; j++){
				DriverBids1[i][j] = DriverBids1[i][j].substring(0,	Read_Carpool_file.getK() * 2 - 1);
			}
		
		for (int i = 0; i < DriverBids1.length; i++){
			for (int j = 0; j < DriverBids1[i].length; j++){
				System.out.print(DriverBids1[i][j]+" ");
			}
		System.out.println();
	}
		
		DB = new int[Read_Carpool_file.getD()];
		DB_lenght = new int[Read_Carpool_file.getD()];
		
		int q = 0;
		D = new String[Read_Carpool_file.getD()];
		
		for (int i = 0; i < X2.length; i++) {
			for (int j = 0; j < X2[i].length; j++) {
					if (Integer.parseInt(X2[i][j]) == 1) {
						D[i] = DriverBids1[i][j];
						DB[i] = (q + j + 1);
					}
			}
			q += X2[i].length;
			DB_lenght[i]=X2[i].length;
		}

		for (int i = 0; i < D.length; i++) {
			String r = "";
			if (D[i] == null) {
				for (int j = 0; j < Read_Carpool_file.getK(); j++) {
					r += "0 ";
				}
				D[i] = r;
			}
		}
		
		
	    Order = new int[Orders.length][];
	    Order_lengh= new int[Orders.length];
	   
	    for(int i=0;i<Orders.length;i++){
	    	Order[i]=new int[Orders[i].length];
	    }
	   
	    
		   for (int i = 0; i < Orders.length; i++) {
			   int lengh=Orders[i].length;
		    	for (int j =0; j < Orders[i].length; j++) {
		    		Order[i][j]=Integer.parseInt(Orders[i][j]);
		    	Order_lengh[i]=Orders[i].length;
		    	}

		    }
	    
	    
		String st;
		Bids = new int[Read_Carpool_file.getD()][Read_Carpool_file.getK()];
		Bids1 = new String[Read_Carpool_file.getD()][Read_Carpool_file.getK()];
		
		System.out.println( " PassengerList.size= "+ PassengerList.size());
		
		if(data_mode.equals("Single_mode")){
		for(int i=0;i<Y.size();i++)
			for(int j=0;j<PassengerList.size();j++)
				if(P_ID.get(i).equals(PassengerList.get(j)))
						{Y1.add(Y.get(i));}
		}
		else{
			for(int i=0;i<Y.size();i++)
					{Y1.add(Y.get(i));}
		}
		
	//	for(int i=0;i<Y.size();i++)
	//		System.out.println(Y1.get(i)+" ");
		
		
		System.out.println("k="+Read_Carpool_file.getK());
		
		for (int i = 0; i < D.length; i++) {
			String[] t = D[i].split(" ");
			for (int j = 0; j < t.length; j++)
				Bids1[i][j] = t[j];
		}
		
		for (int i = 0; i < Bids1.length; i++) {
			for (int j = 0; j < Bids1[i].length; j++) {
					  Bids[i][j] = Integer.parseInt(Bids1[i][j]);
				if(Bids[i][j]>=1 && Integer.parseInt(Y1.get(j))==0){Bids[i][j]=0;}
//		System.out.print(Bids[i][j] + " ");
			}
//	System.out.println();
		}
		
 	/*	for (int i = 0; i < DB.length; i++)
		System.out.println(DB[i] + " ");
		
		for (int i = 0; i < DB_lenght.length; i++)
			System.out.println(DB_lenght[i] + " ");
	
		for(int i=0;i<Order.length;i++){
			for(int j=0;j<Order[i].length;j++)
				System.out.print(Order[i][j] + " ");
		System.out.println();
		}
		
		for(int i=0;i<Order.length;i++)
				System.out.println(Order_lengh[i] + " ");
		*/
	
	}
	
	public static int getBids(int i, int j) {
		return Bids[i][j];
	}
	public static int getOrder(int i, int j) {
		return Order[i][j];
	}
	public static int getOrder_lengh(int i) {
		return Order_lengh[i];
	}
	public static int getDB(int i) {
		return DB[i];
	}
	public static int getDB_lenght(int i) {
		return DB_lenght[i];
	}
	public static String getX2(int i,int j){
		return X2[i][j];
	}
	
	public static ArrayList<String> Y(){
		return Y;
	}

}
