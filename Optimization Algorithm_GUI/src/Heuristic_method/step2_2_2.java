package Heuristic_method;

import java.util.List;

import READ_TXT.Read_INPUT_TXT_filter;
import READ_TXT.Read_distance;

public class step2_2_2   extends step2_2{

	public static void A1(int i) {
		// TODO Auto-generated method stub
			System.out.println("進入A1 輸出當前Order");
			for(int o=0;o<K;o++)
			{Order[o]=Order1[o]; distance[o]=distance1[o];
			System.out.print(" Order "+Order[o] +" distance "+distance[o]);
			}
			System.out.println();
			
			int D_S=Integer.parseInt(Read_INPUT_TXT_filter.getD_S_PLACE(d));
		   Order[K]=ALLDP[i];
		   Order[K+1]=-ALLDP[i];
		   int Pon=Integer.parseInt(Read_INPUT_TXT_filter.getP_R_PLACE(ALLDP[i]-1));
		   int Poff=Integer.parseInt(Read_INPUT_TXT_filter.getP_D_ADDRESS(ALLDP[i]-1));
			
		   distance[K]=Read_distance.getDistance(D_S,Pon );
		   distance[K+1]=Read_distance.getDistance(D_S,Poff );

			for(int o=0;o<(K+2);o++){System.out.print(" Order "+Order[o] +" distance "+distance[o]);}
			System.out.println();
			
		   for (int m=0;m<(K+2)-1;m++)  
	          {
		       for (int j=0;j<(K+2)-m-1;j++)  
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
		   
			for(int o=0;o<(K+2);o++){System.out.print(" Order "+Order[o] +" distance "+distance[o]);}
			System.out.println();
		   try {
				if (time_limit.main(Order,(K+2))==true)
				 {
					RQdjk-=1;
					K+=2;
					for(int o=0;o<K;o++){Order1[o]=Order[o];}
					for(int o=0;o<K;o++){distance1[o]=distance[o];}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public static void A2345( int i,int number) {
		// TODO Auto-generated method stub
		
		int D_S=Integer.parseInt(Read_INPUT_TXT_filter.getD_S_PLACE(d));
		System.out.println("當前在 A2" );
	 ok:  if(RQdjk>=number){
		 
				  for(int j=i;j<ALLDP.length;j++){
					  
					if(Read_INPUT_TXT_filter.getP_ID(ALLDP[i]-1).equals(Read_INPUT_TXT_filter.getP_ID(ALLDP[j]-1))){
				
					System.out.println("輸出目前 Order distance" );
					for(int o=0;o<K;o++){Order[o]=Order1[o]; distance[o]=distance1[o];
					System.out.print(" Order "+Order[o] +" distance "+distance[o]);
					}
					 System.out.println();
					
					  Order[K]=ALLDP[j];
				  	  Order[K+1]=-ALLDP[j];
				  	  
					  int Pon=Integer.parseInt(Read_INPUT_TXT_filter.getP_R_PLACE(ALLDP[j]-1));
					  int Poff=Integer.parseInt(Read_INPUT_TXT_filter.getP_D_ADDRESS(ALLDP[j]-1));
					  	
					 distance[K]=Read_distance.getDistance(D_S,Pon );
					 distance[K+1]=Read_distance.getDistance(D_S,Poff);

					 for(int o=0;o<(K+2);o++){	System.out.print(" Order "+Order[o] +" distance "+distance[o]);	}
					 System.out.println();
					 
					   for (int m=0;m<(K+2)-1;m++)  
				          {
					       for (int y=0;y<(K+2)-m-1;y++)  
			               {
			                    if (distance[y+1]<distance[y])
			                    {
			                        int temp = Order[y+1];  //交換陣列元素
			                        double temp1=distance[y+1];
			                        Order[y+1]=Order[y];
			                        distance[y+1]=distance[y];
			                        Order[y]= temp;
			                        distance[y]=temp1;
			                    }
			              }
				          }
					   
						for(int o=0;o<K+2;o++){System.out.print(" Order "+Order[o] +" distance "+distance[o]);}
						 System.out.println();
						 
					   try {
							if (time_limit.main(Order,(K+2))==true)
							{
								RQdjk-=Read_INPUT_TXT_filter.getseat(ALLDP[j]-1);
								K+=2;
								for(int o=0;o<K;o++){Order1[o]=Order[o];}
								for(int o=0;o<K;o++){distance1[o]=distance[o];}
							}else
							{
								for(int z=0;z<ALLDP.length;z++)
								for(int o=0;o<K;o++)
									if(ALLDP[z]==Order1[o] || ALLDP[z]==-Order1[o])
									{Order1[o]=0; RQdjk+=0.5;	}
								
								String P=Read_INPUT_TXT_filter.getP_ID(ALLDP[i]-1);
								
								for(int o=0;o<ALLDP.length;o++){
									if(ALLDP[o]>0){
									if(P.equals(Read_INPUT_TXT_filter.getP_ID(ALLDP[o]-1)))
											{ALLDP[o]=0;}
								}
								}
								
								break ok;
							}
								
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				  }
			  }
	 		}
		}
	
		
}

