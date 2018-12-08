package Heuristic_method_multi_hop_for_Original_Passenger;

import java.util.ArrayList;
import java.util.List;

import READ_TXT.Read_INPUT_TXT_filter_Original;
import READ_TXT.Read_distance;

public class step2_1 extends Heuristic_multi_hop{
	
	private static 	List<List<Integer>> DP = new ArrayList<List<Integer>>();
	public static int RQdjk;
	private static int[]Order,Order1; 
	private static double[] distance,distance1;
	
	private static boolean up_down;
	
	public static void main()  {
		
		// TODO Auto-generated method stub
		System.out.print("Step2-1");
		Read_distance.Read_distance();
		RQdjk=Read_INPUT_TXT_filter_Original.getP_NUMBER(d);
		System.out.println("此司機提供 "+ RQdjk + " 座位數 ");
		double[] Detour= new double[select_Neighborhood.DP().get(d).size()];
		int[] DP1=new int[select_Neighborhood.DP().get(d).size()];
		Order=new int[2*select_Neighborhood.DP().get(d).size()];
		Order1=new int[2*select_Neighborhood.DP().get(d).size()];
		distance=new double[2*select_Neighborhood.DP().get(d).size()];
		distance1=new double[2*select_Neighborhood.DP().get(d).size()];
		
		for(int i=0;i<Order.length;i++){
			Order[i]=0;
			distance[i]=0;
		}
		
		 int k=0;
			   
			System.out.println(" OK1 ");
			for(int i=0;i<select_Neighborhood.DP().get(d).size();i++)
			{
				DP1[i]=select_Neighborhood.DP().get(d).get(i);
				
				Detour[i]=select_Neighborhood.DP_Detour_Ratio().get(d).get(i);
				
				System.out.println(" DP "+ DP1[i] + " Detour " + Detour[i]);
			}
			
			System.out.println(" OK2 ");
			   for (int i=0;i<DP1.length-1;i++)  
		          {
			       for (int j=0;j<DP1.length-i-1;j++)  
	               {
	                    if (Detour[j+1]<Detour[j])
	                    {
	                        int temp = DP1[j+1];  //交換陣列元素
	                        double temp1=Detour[j+1];
	                        DP1[j+1]=DP1[j];
	                        Detour[j+1]=Detour[j];
	                        DP1[j]= temp;
	                        Detour[j]=temp1;
	                    }
	               }
		          }
			   System.out.println("氣泡排序後");
				for(int i=0;i<select_Neighborhood.DP().get(d).size();i++)
				{
					System.out.print(" DP "+ DP1[i] + " Detour " + Detour[i]);
				}
				
			   int D_S=Integer.parseInt(Read_INPUT_TXT_filter_Original.getD_S_PLACE(d));
			  
			   System.out.println();
			   System.out.println("OK3  將著插入");
			   
				if(RQdjk >=1)
				{	
			   for(int i=0;i<DP1.length;i++)
			   {
				   System.out.println(" RQdjk=  "+ RQdjk);
				   System.out.println(" k=  "+ k);
				   if(RQdjk>=1){
					for(int o=0;o<k;o++){Order[o]=Order1[o]; distance1[o]=distance[o]; }
				   Order[k]=DP1[i];
				   Order[k+1]=-DP1[i];
				   
				   System.out.println(DP1[i]);
				   int Pon=Integer.parseInt(Read_INPUT_TXT_filter_Original.getP_R_PLACE(DP1[i]-1));
				   int Poff=Integer.parseInt(Read_INPUT_TXT_filter_Original.getP_D_ADDRESS(DP1[i]-1));
				   
					for(int o=0;o<k;o++){distance[o]=distance1[o];}
					
				   distance[k]=Read_distance.getDistance(D_S,Pon );
				   distance[k+1]=Read_distance.getDistance(D_S,Poff );
				   
				   System.out.println(" distance[k]=  "+ distance[k]);
				   System.out.println(" distance[k+1]=  "+ distance[k+1]);
				   
				   
				   
				   for (int m=0;m<(k+2)-1;m++)  
			          {
				       for (int j=0;j<(k+2)-m-1;j++)  
		               {
		                    if (distance[j+1]<distance[j])
		                    {
		                        int temp = Order[j+1];  //交換陣列元素
		                        double temp1=distance[j+1];
		                        Order[j+1]=Order[j];
		                        distance[j+1]=distance[j];
		                        Order[j]= temp;
		                        distance[j]=temp1;
		                    }
		              }
			          }
				   
				ArrayList<Integer> Orde_p = new ArrayList<Integer>();
				up_down=true;
				   for (int m=0;m<(k+2)-1;m++)  
			          {
					   	if(Order[m]<0 && Orde_p.contains(-Order[m]))
					   	{up_down=false; break; }
					   	else{Orde_p.add(Order[m]);}
			          }
				   
				   for (int m=0;m<(k+2);m++) {System.out.print(" Order "+ Order[m] + " distance "+ distance[m]);} 
				   
				   System.out.println("進入時間判斷與順序問題");
				   System.out.println(" ----------------------------------------- ");
				   try {
					if (time_limit.main(Order,k+2)==true && up_down==true )
					{
						RQdjk-=1;
						k+=2;
						for(int o=0;o<k;o++){Order1[o]=Order[o]; distance1[o]=distance[o];}
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
			   }
		}
		System.err.println("k= "+k);
		for(int i=0;i<k;i++){System.err.print(Order1[i]+"  ");}
		System.out.println();
		for(int i=0;i<k;i++){System.out.print(Order1[i]);
			Orders[d][i]=Order1[i];
			}
	}
	
}
