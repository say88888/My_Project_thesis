package Enumeration;

import java.io.FileWriter;

import GUI.I_Set_Paths_for_Current_Simulation_Example;
import Input_Output_txt.Carpool.Read_TransactionFee;
import READ_TXT.Read_INPUT_TXT_filter;
import READ_TXT.Read_GA_Drivers_data;


public class step6_create_GA_input {
	private static double TmP ;
	private static double TmD ;
	private static int D_lengh;
	private static int P_lengh;

	public static void main( ) throws Exception {
		Read_INPUT_TXT_filter.loadData();
		Read_GA_Drivers_data.main();
		Read_TransactionFee.main();
		TmP=Read_TransactionFee.Tpm();
		TmD=Read_TransactionFee.Tdm();
		int[] Hp = new int[Read_INPUT_TXT_filter.getD()];
		String[] D = new String[Read_GA_Drivers_data.Drivers().size()];
		String[] Order = new String[Read_GA_Drivers_data.Orders().size()];
	//	for (int i = 0; i < Hp.length; i++)
	//		Hp[i] = Read_GA_Drivers_data.Hp(i);
		for (int i = 0; i < D.length; i++)
			D[i] = Read_GA_Drivers_data.Drivers().get(i);
		for (int i = 0; i < D.length; i++)
			Order[i] = Read_GA_Drivers_data.Orders().get(i);
		
		FileWriter fw1 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path()+"\\Carpool\\DriverBids.txt");
		for (int i = 0; i < D.length; i++)
			fw1.write(D[i]+ "\r\n");
		fw1.close();
		
		FileWriter fw4 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path()+"\\Carpool\\Orders.txt");
		for (int i = 0; i < D.length; i++)
			fw4.write(Order[i]+ "\r\n");
		fw4.close();
		
		D_lengh = Read_INPUT_TXT_filter.getD();
		P_lengh = Read_INPUT_TXT_filter.getP();

		
		int k;
		FileWriter fw2 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path()+"\\Carpool\\Parameter.txt");
		fw2.write(String.valueOf(P_lengh) + "\r\n");
		for (k = 0; k < P_lengh; k++)
			fw2.write(String.valueOf(1) + " ");
		fw2.write("\r\n");
		fw2.write(String.valueOf(D_lengh) + "\r\n");
		for (k = 0; k < Read_GA_Drivers_data.D().size(); k++)
			fw2.write(String.valueOf(Read_GA_Drivers_data.D().get(k))+ " ");
		fw2.write("\r\n");
		fw2.write(String.valueOf(P_lengh) + "\r\n");
		fw2.write(String.valueOf(TmD) + "\r\n");
		fw2.write(String.valueOf(TmP) + "\r\n");
		fw2.close();

		int i = 0, j = 0, t;
	 
		double[][] PassengerBids = new double[P_lengh][P_lengh + 1];
		for (i = 0; i < P_lengh; i++) {
			for (j = 0; j < P_lengh; j++) {
				if (i == j) {
					PassengerBids[i][j] =Read_INPUT_TXT_filter.getseat(j);
				} else {
					PassengerBids[i][j] = 0;
				}
			}
		}

		for (i = 0; i < P_lengh; i++) {
			j = P_lengh;
			PassengerBids[i][j] = Read_INPUT_TXT_filter.getfph(i);
		}
		
		FileWriter fw3 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path()+"\\Carpool\\PassengerBids.txt");
		   for(j=0;j<P_lengh;j++){
			   for(t=0;t<P_lengh+1;t++){
			  if(t==P_lengh){
				
				  fw3.write(String.valueOf(PassengerBids[j][t])+" "); 
			  }
			  else  fw3.write(String.valueOf((int)PassengerBids[j][t])+" ");
			   }
		    fw3.write("\r\n");}
			fw3.close();
	}
}
