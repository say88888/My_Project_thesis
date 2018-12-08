package Heuristic_method;

import java.io.FileWriter;
import java.io.IOException;

import carpool_Alogorithm_MOD.Calculate_the_function;
import GUI.I_Set_Paths_for_Current_Simulation_Example;
import Generate_random_data.Read_Generate_random_OilConsumptionBounds;
import Input_Output_txt.Carpool.Read_TransactionFee;
import READ_TXT.Read_INPUT_TXT_filter;
import READ_TXT.Read_distance;

public class male_bids_and_data extends Heuristic
{
	private static int[] Hp;
	private static int[] Jd;
	private static boolean[] Write;

	public static  void make_Orders() throws IOException
	{
		System.out.println();
		
		int Ord;
		
		FileWriter fw2 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path()+"\\Carpool\\Orders.txt");
		for(int i=0;i<Read_INPUT_TXT_filter.getD();i++)
		{
			Ord=0;
				for(int j=0;j<8;j++)
				{
					if(Orders[i][j]!=0)
					{	System.out.print(Orders[i][j]+"    ");
						if(Orders[i][j+1]!=0){fw2.write(String.valueOf(Orders[i][j])+",");}
						else if(Orders[i][j+1]==0){fw2.write(String.valueOf(Orders[i][j]));}
						
						Ord++;
					}
				}
				if(Ord>0){ fw2.write("\r\n");}
		}
		fw2.close();	
	}
	
	public static  void make_DriverBids() throws IOException{
	System.out.println();
	Jd=new int[Read_INPUT_TXT_filter.getD()];
	Write=new boolean[Read_INPUT_TXT_filter.getD()];
	for(int i=0;i<Read_INPUT_TXT_filter.getD();i++){Jd[i]=0;}
	
	for(int i=0;i<Read_INPUT_TXT_filter.getD();i++)
	{
		if(Orders[i][0]==0){System.out.println("第 "+ (i+1) +" 位司機沒有載客");  Write[i]=false;}
		else{
		System.out.print("第  "+( i+1)+ " 位司機有載客 順序為 ");  Write[i]=true;
		for(int j=0;j<8;j++)
		{
			if(Orders[i][j]!=0){System.out.print(Orders[i][j]+"   ");
				if(Orders[i][j]>0)
					{
					String P_UP=Read_INPUT_TXT_filter.getP_R_PLACE(Orders[i][j]-1);
					String PID=Read_INPUT_TXT_filter.getP_ID(Orders[i][j]-1);
					for(int k=0;k<DriverBidList.size();k++)
						{
							if(DriverBidList.get(k).equals(PID) && DriverBidList1.get(k).equals(P_UP)){
							DriverBids[i][k]+=Read_INPUT_TXT_filter.getseat(Orders[i][j]-1);
							DriverBids[i][DriverBidList.size()+3+k]+=Read_INPUT_TXT_filter.getweight(Orders[i][j]-1);
							}
						}
					}
			}
		}
		System.out.println();
		System.out.print("計算此趟行程成本   ");
		Dcost[i]=cost.Cost(i);
		System.out.println(Dcost[i]);
		Jd[i]+=1;
		}
	}
	
	System.out.println("產生 DriverBids");
	
	for(int i=0;i<Read_INPUT_TXT_filter.getD();i++){DriverBids[i][DriverBidList.size()]=Dcost[i];
	double obj=Calculate_the_function.Odj_cost(Read_distance.getDistance(Integer.parseInt(Read_INPUT_TXT_filter.getD_S_PLACE(i)),
			Integer.parseInt(Read_INPUT_TXT_filter.getD_D_ADDRESS(i))),Read_INPUT_TXT_filter.getDriverOilConsumption(i),Read_Generate_random_OilConsumptionBounds.Driver_OilPrice());

	DriverBids[i][DriverBidList.size()+1]=	obj;
	DriverBids[i][DriverBidList.size()+2]=Read_INPUT_TXT_filter.getP_NUMBER(i);
	
	DriverBids[i][(DriverBidList.size()*2)+3]=Read_INPUT_TXT_filter.getWeight_Limit(i);
	}
	
	System.out.println("DriverBids");
	
	FileWriter fw2 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path()+"\\Carpool\\DriverBids.txt");
	for(int i=0;i<Read_INPUT_TXT_filter.getD();i++){
		if(Write[i]==true){
		for(int j=0;j<(DriverBidList.size()*2+4);j++){
	
			if(j==DriverBidList.size()  || j==DriverBidList.size()+1){
				System.out.print(DriverBids[i][j]+"  ");
			fw2.write(String.valueOf(DriverBids[i][j])+" ");
			}
			else{fw2.write(String.valueOf((int)DriverBids[i][j])+" ");
			System.out.print((int)DriverBids[i][j]+"  ");}
		}
		System.out.println();
		fw2.write("\r\n");
		}
	}
	fw2.close();	
	}
	
	
	public static  void make_PassengerBids() throws IOException
	{
		Read_INPUT_TXT_filter.loadData();
		Hp=new int[PassengerBidList.size()+1];
		
		for(int i=0;i<PassengerBidList.size();i++){Hp[i]=0;}
		
		System.out.println("產生 PassengerBids");
	
		for(int j=0;j<PassengerList.size();j++){
			for(int k=0;k<PassengerBidList.size();k++){
			
			for(int i=0;i<Read_INPUT_TXT_filter.getP();i++)
			{	
				String PID=Read_INPUT_TXT_filter.getP_ID(i);
				String P_UP=Read_INPUT_TXT_filter.getP_R_PLACE(i);
				
					if(PassengerBidList.get(k).equals(PID) && PassengerBidList1.get(k).equals(P_UP) && PassengerList.get(j).equals(PID))
					{
					PassengerBids[j][k]+=Read_INPUT_TXT_filter.getseat(i); 
					PassengerBids[j][PassengerBidList.size()]+=Read_INPUT_TXT_filter.getfph(i);
					}
				}
			}
			Hp[j]=1;
		}
			
		System.out.println("PassengerBids");
		FileWriter fw2 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path()+"\\Carpool\\PassengerBids.txt");
		for(int i=0;i<PassengerList.size();i++)
		{
			for(int j=0;j<PassengerBidList.size();j++){
				System.out.print((int)PassengerBids[i][j]+"   ");
				fw2.write(String.valueOf((int)PassengerBids[i][j])+" ");
			}
			System.out.print(PassengerBids[i][PassengerBidList.size()]+" ");
			System.out.println();
			fw2.write(String.valueOf(PassengerBids[i][PassengerBidList.size()]));
			fw2.write("\r\n");
		}
		fw2.close();
	}
	
	public static  void make_Parameter() throws IOException
	{
		Read_TransactionFee.main();
		
		FileWriter fw2 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path()+"\\Carpool\\Parameter.txt");
		fw2.write(String.valueOf(PassengerList.size()) + "\r\n");
		for (int k = 0; k < PassengerList.size(); k++)
			fw2.write(String.valueOf(Hp[k]) + " ");
		fw2.write("\r\n");
		fw2.write(String.valueOf(Read_INPUT_TXT_filter.getD()) + "\r\n");
		for (int k = 0; k <Read_INPUT_TXT_filter.getD(); k++)
		fw2.write(String.valueOf(Jd[k])+" ");
		fw2.write("\r\n");
		fw2.write(String.valueOf(DriverBidList.size()) + "\r\n");
		fw2.write(String.valueOf(Read_TransactionFee.Tdm()) + "\r\n");
		fw2.write(String.valueOf(Read_TransactionFee.Tpm()) + "\r\n");
		fw2.close();
		
	}
	
}
