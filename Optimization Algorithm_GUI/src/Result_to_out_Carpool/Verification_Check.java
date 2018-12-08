package Result_to_out_Carpool;

import Input_Output_txt.Carpool.Read_TransactionFee;
import READ_TXT.Read_INPUT_TXT_filter;

public class Verification_Check extends RideSharingDetails_scheme{

	
	public static void Check_SchemI(int current,int x, int[] PB, int k1, int k2)
	{

		for(int i=k1;i<k2;i++)
		{
			System.out.println(" Cdj= "+DriverBids[current][P]);
			System.out.println(" Fph= "+Read_INPUT_TXT_filter.getfph(PB[i]));
			System.out.println(" D_reward1= "+ Allocate_surplus.D_surplus_I().get(x));
			System.out.println(" P_reward1= "+Allocate_surplus.P_surplus_I().get(i));
			
			System.out.println(" 利潤比例為  Fph/Cdj= "+Read_INPUT_TXT_filter.getfph(PB[i])/DriverBids[current][P]);
			System.out.println(" 利潤比例為  P_reward1/D_reward1= "+ Allocate_surplus.P_surplus_I().get(i)/Allocate_surplus.D_surplus_I().get(x));
		}
		
	}
	
	public static void Check_SchemII(int current,int x, int[] PB, int k1, int k2)
	{
		Read_TransactionFee.main();
		double Cdj_total=0,Fph_total=0;
		
		double Cdj=DriverBids[current][P];
		double Fph=
		
		P = PassengerList.size();
		int w;
		for (int i = 0; i < Order_lengh.length; i++) {

			if (Order_lengh[i] != 0 && DriverBids[i][P] > 0) {

				Cdj_total += DriverBids[i][P];

				for (int j = 0; j < Order_lengh[i]; j++) {
					w = Order[i][j];
					if (w != 0) {
						if (w > 0) {
							w = w - 1;
							Fph_total += Read_INPUT_TXT_filter.getfph(w);
						}
					}
				}
			}
		}

		for(int i=k1;i<k2;i++)
		{
			System.out.println(" Delta()= "+Read_TransactionFee.Delta());
			System.out.println(" 當前的得標的 Cdj= "+Cdj);
			System.out.println(" 當前的得標的 Fph= "+Read_INPUT_TXT_filter.getfph(PB[i]));
			System.out.println(" 所有得標的司機總計 Cdj_total= "+ Cdj_total);
			System.out.println(" 所有得標的乘客總計 Fph_total= "+Fph_total);
			System.out.println(" D_reward2= "+ Allocate_surplus.D_surplus_II().get(x));
			System.out.println(" P_reward2= "+Allocate_surplus.P_surplus_II().get(i));
			
			System.out.println(" 利潤比例為  (Delta*當前的得標的 Fph/所有得標的乘客總計 Fph_total)/((1-Delta)*當前的得標的 Cdj/所有得標的乘客總計 Cdj_total)="
					+ (Read_TransactionFee.Delta()*Read_INPUT_TXT_filter.getfph(PB[i])/Fph_total)/((1-Read_TransactionFee.Delta())*Cdj/Cdj_total));
				
				System.out.println(" 利潤比例為  P_reward2/D_reward2= "+ Allocate_surplus.P_surplus_II().get(i)/Allocate_surplus.D_surplus_II().get(x));
		}
		
	}
	

	public static void Check_SchemIII(int x, int[] PB, int k1, int k2)
	{
		for(int i=k1;i<k2;i++)
		{
			System.out.println(" 司機共乘前距離= "+ D_distance_beforce.get(x));
			System.out.println(" 乘客共乘前距離= "+ P_distance_beforce.get(i));
			System.out.println(" D_reward3= "+ Allocate_surplus.D_surplus_III().get(x));
			System.out.println(" P_reward3= "+ Allocate_surplus.P_surplus_III().get(i));
			
			System.out.println(" 利潤比例為  乘客共乘前距離/司機共乘前距離 = "+P_distance_beforce.get(i)/D_distance_beforce.get(x));
			System.out.println(" 利潤比例為  P_reward3/D_reward3= "+ Allocate_surplus.P_surplus_III().get(i)/Allocate_surplus.D_surplus_III().get(x));
		}
		
	}
	

	public static void Check_SchemIV(int x, int[] PB, int k1, int k2)
	{
		for(int i=k1;i<k2;i++)
		{
			System.out.println(" 司機共乘後距離= "+ D_distance_after.get(x));
			System.out.println(" 乘客共乘後距離= "+ P_distance_after .get(i));
			System.out.println(" D_reward4= "+ Allocate_surplus.D_surplus_IV().get(x));
			System.out.println(" P_reward4= "+ Allocate_surplus.P_surplus_IV().get(i));
			System.out.println(" 利潤比例為  乘客共乘前距離/司機共乘前距離 = "+P_distance_after.get(i)/D_distance_after.get(x));
			System.out.println(" 利潤比例為  P_reward4/D_reward4= "+ Allocate_surplus.P_surplus_IV().get(i)/Allocate_surplus.D_surplus_IV().get(x));
		}
	}
	
}
