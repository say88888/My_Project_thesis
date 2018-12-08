package Algorithm_DoubleAuction.GA2_DA;

import Input_Output_txt.Double_Auction.Read_Double_Auction;

public class CheckConstraint  extends Double_Auction_GA2 {
	
	public static void CheckConstraints2(){
		int s=0,s1=0;
		   double[][] y=new double[N][];
		    for(int i=0;i<N;i++)
		    	y[i]=new double[Read_Double_Auction.getH(i)];
		    double[][] x =new double[I][];
		    for(int i=0;i<I;i++)
		    	x[i]=new double[Read_Double_Auction.getJ(i)];
		    
		 for (int i = 0; i <I ; i++) 
	   	  for(int j=0;j<x[i].length;j++)
	   	x[i][j]=X2(s++);	     
		 for (int i = 0; i < N ; i++) 
		   	  for(int j=0;j<y[i].length;j++)
		   	y[i][j]=Y2(s1++);	   
		 System.out.println();

		 System.out.println("限制式 2-2");
		 int st2=0,st22=0;
		 for(int k=0;k<K;k++){
			 for(int i=0;i<I;i++)
				 for(int j=0;j<x[i].length;j++)
					 st2+=x[i][j]*Read_Double_Auction.getqijk(i, j, k);
			
			 for(int n=0;n<N;n++)
				 for(int h=0;h<y[n].length;h++)
					 st22+=y[n][h]*Read_Double_Auction.getdnhk(n, h, k);
		
			 if(st2-st22>=0)
				 System.out.println("K="+(k+1)+" "+"True "+(st2-st22));
			 else
				 System.out.println("K="+(k+1)+" "+"False "+(st2-st22));
			 st2=0;
			 st22=0;
		 }
		 System.out.println();
		 System.out.println("限制式 2-3");
		 int st3=0,st32=0;
		 for(int n=0;n<N;n++)
			 for(int h=0;h<y[n].length;h++)
				 st3+=y[n][h]*Read_Double_Auction.getPnh(n, h);
		 
		 for(int i=0;i<I;i++)
			 for(int j=0;j<x[i].length;j++)
				 st32+=x[i][j]*Read_Double_Auction.getPij(i, j);
			 
		if(st3>=st32)
			System.out.println("True "  +(st3-st32));
		else
			System.out.println("False " +(st3-st32));
		
		 System.out.println();
		 System.out.println("限制式 2-4");
		 int st4=0;
		 for(int i=0;i<I;i++)
			 for(int k=0;k<K;k++){
		 
				for(int j=0;j<x[i].length;j++)
					st4+=x[i][j]*Read_Double_Auction.getqijk(i, j, k);
		 
				if(st4<=Read_Double_Auction.getSik(i, k))
					System.out.println("I="+(i+1)+" K="+(k+1)+" True "+(Read_Double_Auction.getSik(i, k)-st4));
				else
					System.out.println("I="+(i+1)+" K="+(k+1)+" False "+(Read_Double_Auction.getSik(i, k)-st4));
				st4=0;
			}
		 System.out.println();
		  
	}
}