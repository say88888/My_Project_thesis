package Generate_random_data;


import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;

import GUI.I_Set_Paths_for_Current_Simulation_Example;
import carpool_Alogorithm_MOD.Calculate_the_function;

public class Read_CATS_output_and_Genarate_Parameter_and_sik_for_DoubleAuction {
	
	private static int N;
	private static int I;
	private static int K;

	public static void main() throws IOException {
		
		try {
			Read_CATS_output_and_Genarate_Buyer_for_DoubleAuction.main();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			Read_CATS_output_and_Genarate_Seller_for_DoubleAuction.main();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		N=Read_CATS_output_and_Genarate_Buyer_for_DoubleAuction.N();
		I=Read_CATS_output_and_Genarate_Seller_for_DoubleAuction.I();
		K=Read_CATS_output_and_Genarate_Buyer_for_DoubleAuction.K();
		
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(1);
		FileWriter fw1 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path()+"\\Double_Action\\Parameter_Double_Action.txt");

			fw1.write(String.valueOf(N) + " ");
			fw1.write("\r\n");
			for(int i=0;i<Read_CATS_output_and_Genarate_Buyer_for_DoubleAuction.H().size();i++)
				fw1.write(String.valueOf(Read_CATS_output_and_Genarate_Buyer_for_DoubleAuction.H().get(i)) + " ");
			fw1.write("\r\n");
			
			fw1.write(String.valueOf(I)+" ");
			fw1.write("\r\n");
			for(int i=0;i<Read_CATS_output_and_Genarate_Seller_for_DoubleAuction.J().size();i++)
				fw1.write(String.valueOf(Read_CATS_output_and_Genarate_Seller_for_DoubleAuction.J().get(i)) + " ");
			fw1.write("\r\n");
			fw1.write(String.valueOf(K) + " ");
			fw1.write("\r\n");
			fw1.write(String.valueOf(nf.format(Calculate_the_function.random(0,1))) + "\r\n");
			fw1.write(String.valueOf(nf.format(Calculate_the_function.random(0,1))) + "\r\n");
			
		fw1.close();
		
		
		FileWriter fw2 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path()+"\\Double_Action\\Sik.txt");
		
			for(int i=0;i<I;i++)
				for(int j=0;j<Read_CATS_output_and_Genarate_Seller_for_DoubleAuction.J().get(i);j++)
				{
					for(int k=0;k<K;k++)
					{
						fw2.write(String.valueOf(Read_CATS_output_and_Genarate_Seller_for_DoubleAuction.max_number(k) + " "));
					}
					fw2.write("\r\n");
				}
		fw2.close();
	}
	
	
}
