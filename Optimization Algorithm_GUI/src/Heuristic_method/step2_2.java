package Heuristic_method;

import java.io.IOException;
import java.util.List;

import Enumeration.select_Neighborhood_rule1;
import READ_TXT.Read_INPUT_TXT;
import READ_TXT.Read_INPUT_TXT_filter;
import READ_TXT.Read_distance;

public class step2_2  extends step2 {
	
	public static int RQdjk;
	public static int K;
	public static int[]Order,Order1; 
	public static double[] distance,distance1;
	public static int[] ALLDP;
	
	public static void main() throws IOException {
		// TODO Auto-generated method stub
		System.out.println("sep2_2");
		
		Read_INPUT_TXT_filter.loadData();
		
		RQdjk=Read_INPUT_TXT_filter.getP_NUMBER(d);
		System.out.println(" RQdjk "+RQdjk);
		
		double[] Detour= new double[select_Neighborhood_rule1.DP().get(d).size()];
		
		ALLDP=new int[select_Neighborhood_rule1.DP().get(d).size()];
		
		for(int i=0;i<select_Neighborhood_rule1.DP().get(d).size();i++)
		{
			ALLDP[i]=select_Neighborhood_rule1.DP().get(d).get(i);
			Detour[i]=select_Neighborhood_rule1.DP_Detour_Ratio().get(d).get(i);
		}
		
		System.out.println(" OK1 ");
		 for (int i=0;i<Detour.length;i++){
			 System.out.print(" ALLDP "+ALLDP[i]+ " Detour "+Detour[i]);
		 }
		 System.out.println();
		System.out.println(" OK2 氣泡排法");
		   for (int i=0;i<Detour.length-1;i++)  
	          {
		       for (int j=0;j<Detour.length-i-1;j++)  
           		{
                 if (Detour[j+1]<Detour[j])
                 {
                     int temp = ALLDP[j+1];  //交換陣列元素
                     double temp1=Detour[j+1];
                     ALLDP[j+1]=ALLDP[j];
                     Detour[j+1]=Detour[j];
                     ALLDP[j]= temp;
                     Detour[j]=temp1;
                 }
            }
	        }
		   for (int i=0;i<Detour.length;i++){
			   System.out.print(" ALLDP "+ALLDP[i]+ " Detour "+Detour[i]);
		   }	   
		   System.out.println();
		   
		   int D_S=Integer.parseInt(Read_INPUT_TXT_filter.getD_S_PLACE(d));
		   K=0;
		   Order=new int[2*RQdjk];
		   Order1=new int[2*RQdjk];
		    distance=new double[2*RQdjk];
		    distance1=new double[2*RQdjk];
		    
		    int number,number1;
		    
		   for(int i=0;i<ALLDP.length;i++)
		   {
			 number=0; number1=0;
			String Request_p1="";
			System.out.println(" RQdjk "+RQdjk);
			   if(RQdjk>0)
			   {
				   if(ALLDP[i]>0){
				   for(int j=0;j<Read_INPUT_TXT.getP();j++)
					   if(Read_INPUT_TXT_filter.getP_ID(ALLDP[i]- 1).equals(Read_INPUT_TXT.getP_ID(j)))
					   {number+=Read_INPUT_TXT_filter.getseat(ALLDP[i]- 1);}
				   
				   for(int j=0;j<ALLDP.length;j++){
					 if(ALLDP[j]>0){
					   if(Read_INPUT_TXT_filter.getP_ID(ALLDP[i]- 1).equals(Read_INPUT_TXT_filter.getP_ID(ALLDP[j]-1)))
					   {number1+=Read_INPUT_TXT_filter.getseat(ALLDP[j]-1);}
					 }
				   }
				   
				   	if(number>0 && number1 >0 && number==number1){Request_p1="A2345";}
					if(number==1 && number1==1){Request_p1="A1";}
									
				//	System.out.println( "Request_p1= "+Request_p1+" number= "+number+" number1= "+number1);
					
			if(Request_p1=="A1"){step2_2_2.A1(i);}
			if(Request_p1=="A2345"){step2_2_2.A2345(i,number);}
				   }
				 }
			}
		   			for(int i=0;i<K;i++){System.out.print(Order1[i]);
		  			Orders[d][i]=Order1[i]; 
		  			}
		   }
	}


