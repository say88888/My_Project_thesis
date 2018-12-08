package Result_to_out_Carpool;

import java.util.ArrayList;

import READ_TXT.Read_INPUT_TXT_filter;
import READ_TXT.Read_distance;

public class carpool_after_distance extends carpool_results_test{

	private static ArrayList<String> P_ID = new ArrayList<String>();  //紀錄得標乘客ID
	private static ArrayList<Double> P_distance = new ArrayList<Double>(); //記錄此乘客得標後所行駛距離
	private static ArrayList<String> D_ID = new ArrayList<String>(); //紀錄得標司機ID
	private static ArrayList<Double> D_distance = new ArrayList<Double>(); //記錄此司機得標後所行駛距離
	
	private static ArrayList<Integer> P_as_D = new ArrayList<Integer>();  //紀錄P assign 哪位 D
	
	private static ArrayList<Integer> Order_p = new ArrayList<Integer>();  //紀錄P assign 哪位 D
	
	public static void distance(double[] D_ID_distance) throws Exception{
		// TODO Auto-generated method stub
		P_ID.clear();
		P_distance.clear();
		D_ID.clear();
		D_distance.clear();
		P_as_D.clear();
		Order_p.clear();
		//宣告d1為Read_distance類別物件
 
		int location1 = 0,location2;
		
		int i,j,n=0,l=0,k=0,S;
		
		System.out.println("計算各自共乘後的距離---------------------");
			
			int[] P_ID_B=new int[K*2];
			int[] D_ID_B=new int[D];
			double[] P_ID_B_distance=new double[K*2];
			int M,o=0,p=0,R=0;
			double P_ID_route=0;
			int[] PP=new int [K*2];
			
			l=0;
			//先將乘客弄出來
			for(i=0;i<Order.length;i++)
				for(j=0;j<Order_lengh[i];j++)
				{		
					k=Order[i][j];
						if(k!=0 && (!Order_p.contains(k) && !Order_p.contains(-k)) )
						{P_ID_B[l]=k;	Order_p.add(k);
							l++;}		
				}
			
			for(i=0;i<Order.length;i++){
				k=0;
				for(j=0;j<Order_lengh[i];j++)
				{		
					if(Order[i][j]>0){
					k++;
					D_ID_B[R]=i;
					PP[R]=k;
					}
				}
				if(k>0)
					{R++; k=0;}
			}
	
			//對照著順序將 個別的距離都算出來------------------------------------
			
			for(i=0;i<Order.length;i++){	
				
				for(j=0;j<Order_lengh[i];j++){
					if(Order[i][j]!=0)
						System.out.print(Order[i][j]+"");
				}
				System.out.println();
			}
			
			
			for(i=0;i<Order.length;i++){	
			
				for(j=0;j<Order_lengh[i];j++)
				{
					M=P_ID_B[n];
					k=Order[i][j];
					if(k==M && k!=0){
					P_ID_route=0;
					if(M>0)
					location1=Integer.parseInt(Read_INPUT_TXT_filter.getP_R_PLACE(M-1));
					else if(M<0)
					location1=Integer.parseInt(Read_INPUT_TXT_filter.getP_D_ADDRESS((-M)-1));
				for(o=j;o<Order_lengh[i];o++)
					{
						p=Order[i][o];
						if(p>0)
						{
						S=p;
						location2=Integer.parseInt(Read_INPUT_TXT_filter.getP_R_PLACE(S-1));
						P_ID_route += Read_distance.getDistance(location1,location2);
						location1=location2;
						}
					else if(p<0)
						{
						S=-p;
						location2=Integer.parseInt(Read_INPUT_TXT_filter.getP_D_ADDRESS(S-1));
						P_ID_route += Read_distance.getDistance(location1,location2);
						location1=location2;
						}
					if(k==-p){
						P_ID_B_distance[n]=P_ID_route;
						System.out.print("P_ID_B_distance[n]= "+P_ID_B_distance[n]);
						n++;
						P_as_D.add(i);
						break ;}
					}
				}
					System.out.print("n="+n);
					if(n==l){break ;}
				}
			}
			
			for(i=0;i<l;i++)
			{
				M=P_ID_B[i];
				if(M>0)
				P_ID.add(Read_INPUT_TXT_filter.getP_ID(P_ID_B[i]-1));
				else if(M<0)
				P_ID.add(Read_INPUT_TXT_filter.getP_ID(-(P_ID_B[i])-1));
				P_distance.add(P_ID_B_distance[i]);
				System.out.println(" i= "+P_ID_B_distance[i]);
			}
			
			for(i=0;i<R;i++)
			{
				D_ID.add(Read_INPUT_TXT_filter.getD_ID(D_ID_B[i]));
				D_distance.add(D_ID_distance[i]);
			//	System.out.println(" i= "+D_ID_distance[i]);
			} 
		//---------------------------------------------------------------------------------------------
		}
	
	public static ArrayList<String> D_ID(){
		return D_ID;
	}
	public static ArrayList<Double> D_distance(){
		return D_distance;
	}
	public static ArrayList<String> P_ID(){
		return P_ID;
	}
	public static ArrayList<Double> P_distance(){
		return P_distance;
	}
	
	public static int P_ID_size(){
		return P_ID.size();
	}
	
	public static int D_ID_size(){
		return D_ID.size();
	}

	public static ArrayList<Integer> P_as_D(){
		return P_as_D;
	}
	
}
