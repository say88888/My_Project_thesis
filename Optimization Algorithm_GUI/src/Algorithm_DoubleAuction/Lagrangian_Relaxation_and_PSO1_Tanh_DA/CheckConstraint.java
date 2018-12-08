package Algorithm_DoubleAuction.Lagrangian_Relaxation_and_PSO1_Tanh_DA;

import Input_Output_txt.Double_Auction.Read_Double_Auction;


	public class CheckConstraint  extends Double_Auction_LR {
		public static void CheckConstraints(int[][] X,int[][] Y){
			 
			 System.out.println();

			 System.out.println("限制式 2-2");
			 int st2=0,st22=0;
			 for(int k=0;k<K;k++){
				 for(int i=0;i<I;i++)
					 for(int j=0;j<X[i].length;j++)
						 st2+=X[i][j]*Read_Double_Auction.getqijk(i, j, k);
				
				 for(int n=0;n<N;n++)
					 for(int h=0;h<Y[n].length;h++)
						 st22+=Y[n][h]*Read_Double_Auction.getdnhk(n, h, k);
			
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
				 for(int h=0;h<Y[n].length;h++)
					 st3+=Y[n][h]*Read_Double_Auction.getPnh(n, h);
			 
			 for(int i=0;i<I;i++)
				 for(int j=0;j<X[i].length;j++)
					 st32+=X[i][j]*Read_Double_Auction.getPij(i, j);
				 
			if(st3>=st32)
				System.out.println("True "  +(st3-st32));
			else
				System.out.println("False " +(st3-st32));
			
			 System.out.println();
			 System.out.println("限制式 2-4");
			 int st4=0;
			 for(int i=0;i<I;i++)
				 for(int k=0;k<K;k++){
			 
					for(int j=0;j<X[i].length;j++)
						st4+=X[i][j]*Read_Double_Auction.getqijk(i, j, k);
			 
					if(st4<=Read_Double_Auction.getSik(i, k))
						System.out.println("I="+(i+1)+" K="+(k+1)+" True "+(Read_Double_Auction.getSik(i, k)-st4));
					else
						System.out.println("I="+(i+1)+" K="+(k+1)+" False "+(Read_Double_Auction.getSik(i, k)-st4));
					st4=0;
				}
			 System.out.println();
			  
		}
	}
