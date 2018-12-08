package Result_to_out_Carpool;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import GUI.I_Set_Paths_for_Current_Simulation_Example;
import GUI.GUI_Carpool.X_Select_Algorithm_Type_to_Solve_the_Problem;
import Input_Output_txt.Carpool.check_batch_TXT;
import READ_TXT.READ_XY_and_Order;
import READ_TXT.Read_INPUT_TXT_filter;

public class male_Bids_and_Xdj_and_Yph extends carpool_results_test{

	//-----------------------產生DriverBids--------------------------
	public static double[][] GetDriverBids(double[][] Bids,double[] Dcost)
	{
		int i, j, k;
		double[][] DriverBids = new double[D ][K* 2+3];
		String[][] Drivers=new String[D ][K* 2+3];
		
		for (i = 0; i < D ; i++)
			for (j = 0; j < K ; j++)
				Drivers[i][j] = Read_INPUT_TXT_filter.getP_ID(j);
		
		for (i = 0; i < D ; i++)
			for (j = 0; j < K ; j++) 
				DriverBids[i][j]=Bids[i][j];
			

		// -----------成本加入矩陣-------------------------
		for (i = 0; i <= D - 1; i++) 
		{
			for (j = K; j <= K; j++)
				DriverBids[i][j] = Dcost[i];
			DriverBids[i][j] = Read_INPUT_TXT_filter.getP_NUMBER(i);
		}
		return DriverBids;
	}
	//-----------------------產生PassengerBids--------------------------
	public static double[][] GetPassengerBids() throws IOException
	{
		Read_INPUT_TXT_filter.loadData();
		double[][] PassengerBids = new double[PassengerList.size()][K+1];
		 
	if(data_mode.equals("Single_mode")){
		 for(int i=0;i<P;i++)
             	for(int j=0;j<K;j++){
             		for(int k=0;k<Read_INPUT_TXT_filter.getP();k++){
             			if(Read_INPUT_TXT_filter.getP_ID(k).equals(PassengerList.get(j)) 
             					&&  Read_INPUT_TXT_filter.getP_R_PLACE(k).equals(PassengerList1.get(j))
             					&&  PID.get(i).equals(Read_INPUT_TXT_filter.getP_ID(k))
             					){
             				PassengerBids[i][j]+=Read_INPUT_TXT_filter.getseat(k);
             				PassengerBids[i][K]+=Read_INPUT_TXT_filter.getfph(k);
             			}
             		}
             	}
		}else{
			for(int j=0;j<PassengerList.size();j++){

				for(int i=0;i<Read_INPUT_TXT_filter.getP();i++)
				{	
				String P_DN=Read_INPUT_TXT_filter.getP_D_ADDRESS(i);
				String P_UP=Read_INPUT_TXT_filter.getP_R_PLACE(i);
				
					if(PassengerList.get(j).equals(P_DN) && PassengerList1.get(j).equals(P_UP))
					{
					if(PassengerBids[j][j]==0) {	
					PassengerBids[j][j]+=Read_INPUT_TXT_filter.getseat(i); 
					PassengerBids[j][PassengerList.size()]+=Read_INPUT_TXT_filter.getfph(i);
					}
					}
				}
		}
		}
	
         for(int i=0;i<=PassengerList.size()-1;i++)
         	for(int j=0;j<=K-1;j++){
         	if(PassengerBids[i][j]<=0)
         		PassengerBids[i][j]=0;
         	}
		return PassengerBids;
	}
		
		
		public static void Yph() throws IOException
		{
			//--------------------------------------------------------寫 Yph 的標矩陣--------------------------------------------
			Yp=new int[Read_INPUT_TXT_filter.getP()];
			Yh=new int[Read_INPUT_TXT_filter.getP()];
			Yph=new int[Read_INPUT_TXT_filter.getP()];
			
			
			for(int j=0;j<PID.size();j++){
			int k=0;
			for(int i=0;i<Read_INPUT_TXT_filter.getP();i++)
			{
				if(PID.get(j).equals(Read_INPUT_TXT_filter.getP_ID(i))){
					Yp[i]=j+1;
					Yh[i]=k+1;
					Yph[i]=0;
					k++;
					}
			}
			}
			
		//	for(int j=0;j<Read_INPUT_TXT_filter.getP();j++){
		//		System.out.println("Yp= "+Yp[j]+ "Yh= "+Yh[j]+"Yph= "+Yph[j]);	
		//	}
			
			//--------------------------------------------------------------------------------------------------------------------
		}
		
		public static void Xdj() throws IOException
		{
			//--------------------------------------------------------寫 Xdj 的標矩陣--------------------------------------------
			int dj_lenght=0;
			
			for(int i=0;i<D;i++)
				dj_lenght+=READ_XY_and_Order.getDB_lenght(i);
			
			Xd=new int[dj_lenght];
			Xj=new int[dj_lenght];
			Xdj=new int[dj_lenght];
			int DB_math=0;
			int DB_math1=0;
			
			for(int i=0;i<Order.length;i++)
			{
				int k=0;
				DB_math+=READ_XY_and_Order.getDB_lenght(i);
				
				for(int j=DB_math1;j<DB_math;j++)
				{
					Xd[j]=i+1;
					Xj[j]=k+1;
					if((DB_math1+1)==READ_XY_and_Order.getDB(i) && READ_XY_and_Order.getDB(i)!=0
							&& Order_lengh[i]!=0 && DriverBids[i][K]>0)
					{Xdj[DB_math1]=1;}
					DB_math1++;
					k++;
				}
				DB_math1=DB_math;
			}
			
			//Output_EXCEL_Bids.main(Xd,Xj,Xdj,);
		}
		
		public static void DriverBids_Adjust() throws IOException
		{
			
			System.out.println("由於出現投標的調節部分而投標金額有些不同，輸出調節的每個標的DriverBids"+" ");
			
			ArrayList<String> X = new ArrayList<String>();
			String[][] DriverBids2;
						
			DriverBids2 = new String[Read_Carpool_file.getD()][];
			for (int i = 0; i < Read_Carpool_file.getD(); i++)
				DriverBids2[i] = new String[Read_Carpool_file.getJd(i)];
			
			X.clear();
			
			String str;
			
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
			
			if(X_Select_Algorithm_Type_to_Solve_the_Problem.Advance_bid() == true)
			{
			String str1;
			int b=0;
			// String DriverBids1 [][]; //二維陣列
			Vector<String[]> str_vec1 = new Vector<String[]>(); // 暫存
			try {
				FileReader PBr = new FileReader(I_Set_Paths_for_Current_Simulation_Example.path()+"\\Carpool\\DriverBids.txt");
				BufferedReader br = new BufferedReader(PBr);
				while ((str1 = br.readLine()) != null) { // 每次讀一行
					str_vec1.add(str1.split("\\s")); // 將此行以空白(white space)切成字串陣列,
														// 存入 Vector暫存
				}
				br.close(); // 關檔
				DriverBids2 = new String[str_vec1.size()][]; // 產生二維陣列,
																// 依據暫存的size(txt檔的行數)
				for (int i = 0; i < str_vec1.size(); i++)
					DriverBids2[i] = str_vec1.elementAt(i); // 將暫存區每一個元素(一行裡的字串陣列)放入二維陣列
				// System.out.println("DriverBids:");
				// 印出二維陣列內容
				for (int i = 0; i < DriverBids2.length; i++) {
					for (int j = 0; j < DriverBids2[i].length; j++) {
						// System.out.print(DriverBids1[i][j] + " ");
						b++;
						// DriverBids[i][j] =Integer.parseInt(DriverBids1[i][j]);
					}
					// System.out.println();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			}
			else if(X_Select_Algorithm_Type_to_Solve_the_Problem.Advance_bid() == false )
			{
				String str1;
				int b=0;
				// String DriverBids1 [][]; //二維陣列
				Vector<String[]> str_vec1 = new Vector<String[]>(); // 暫存
				try {
					FileReader PBr = new FileReader(I_Set_Paths_for_Current_Simulation_Example.path()+"\\Carpool\\"+X_Select_Algorithm_Type_to_Solve_the_Problem.method()+"\\DriverBids.txt");
					BufferedReader br = new BufferedReader(PBr);
					while ((str1 = br.readLine()) != null) { // 每次讀一行
						str_vec1.add(str1.split("\\s")); // 將此行以空白(white space)切成字串陣列,
															// 存入 Vector暫存
					}
					br.close(); // 關檔
					DriverBids2 = new String[str_vec1.size()][]; // 產生二維陣列,
																	// 依據暫存的size(txt檔的行數)
					for (int i = 0; i < str_vec1.size(); i++)
						DriverBids2[i] = str_vec1.elementAt(i); // 將暫存區每一個元素(一行裡的字串陣列)放入二維陣列
					// System.out.println("DriverBids:");
					// 印出二維陣列內容
					for (int i = 0; i < DriverBids2.length; i++) {
						for (int j = 0; j < DriverBids2[i].length; j++) {
							// System.out.print(DriverBids1[i][j] + " ");
							b++;
							// DriverBids[i][j] =Integer.parseInt(DriverBids1[i][j]);
						}
						// System.out.println();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			String path = null;
			if(GUI.main.getmethod()!=2){
				FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()
						   +X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"DriverBids_Adjust.txt");
				int k=0;
				for (int i = 0; i < Read_Carpool_file.getD(); i++){
					for(int j=0;j<Read_Carpool_file.getJd(i);j++){
					if(Integer.parseInt(X.get(k))==1){
						for(int l=0;l<K+1;l++){
							if(l+1<(P+1))
								fw1.write(String.valueOf((int)DriverBids[i][l])+" ");
							else 
							    fw1.write(String.valueOf((int)DriverBids[i][l])+" ");
							System.out.print((int)DriverBids[i][l]+" ");
						}
						   fw1.write(String.valueOf(determine_XObj.getOdj(i))+"\r\n");
						   System.out.println(determine_XObj.getOdj(i));
					}
					else
					{
						for (int l = 0; l <(DriverBids2[k].length/2); l++){
							   fw1.write(String.valueOf(DriverBids2[k][l])+" ");
							System.out.print(DriverBids2[k][l]+" ");
							}
						   fw1.write("\r\n");
							System.out.println();
					}
					k++;
					}
				}
					fw1.close();
			}
			
		if(GUI.main.getmethod()==2){
		int N=check_batch_TXT.getN1();
		String path2 = check_batch_TXT.getString(N);
		
		if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\PSO1\\"))
		{path="PSO1_Batch"; 
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
		 f1.mkdir();
		}
		if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\PSO2\\"))
		{path="PSO2_Batch";
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
		 f1.mkdir();
		}
		if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\PSO3\\"))
		{path="PSO3_Batch";
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
		 f1.mkdir();
		}
		if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\PSO4\\"))
		{path="PSO4_Batch";
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
		 f1.mkdir();
		}
		if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\APSO1\\"))
		{path="APSO1_Batch";
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
		 f1.mkdir();
		}
		if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\APSO2\\"))
		{path="APSO2_Batch";
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
		 f1.mkdir();
		}
		FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result"+"\\"+"DriverBids_Adjust.txt",true);
		   fw1.write("--------------------------------------------------------------------------------------------");
		    fw1.write("\r\n");
			fw1.close();
	}
			
	}
		
		
}
