package Algorithm_DoubleAuction.Lagrangian_PSO_Tanh_DA;

import Input_Output_txt.Double_Auction.Read_Double_Auction;

 

public class Updata_Lambda_penalty extends Double_Auction_ALPSO_Tanh{
	public static void Updata_Lambda( int[][] X,int[][] Y) {
	
		 for(int k=0;k<K;k++){
			Lambda1[k]+=2*r1[k]*-Functions.Theta1(k, X, Y );
			if(Lambda1[k] <0)
				Lambda1[k] =0;
		 }
		
		 
	 	Lambda2+=2*r2*-Functions.Theta2( X, Y);
		if(Lambda2<0)
			Lambda2=0;
		for(int i=0;i<I;i++)
			for(int k=0;k<K;k++){
				Lambda3[i][k]+=2*r3[i][k]*-Functions.Theta3(i, k, X, Y );
				if(Lambda3[i][k]<0)
					Lambda3[i][k]=0;
			}
		
	 
		 
	 /*	for(int k=0;k<K;k++)
			System.out.print(Lambda1[k]+" ");
		System.out.println();
		System.out.print(Lambda2+" ");
		System.out.println();
		for(int d=0;d<r3.length;d++)
			for(int j=0;j<r3[d].length;j++)
				System.out.print(Lambda3[d][j]+" ");
		System.out.println();*/
	/*	System.out.println("g");
		for(int k=0;k<K;k++)
			System.out.print(Functions.g1(k, X, Y)+" ");
		System.out.println();
		System.out.print(Functions.g2(X, Y)+" ");
		System.out.println();
		for(int d=0;d<r3.length;d++)
			for(int j=0;j<r3[d].length;j++)
				System.out.print(Functions.g3(d, j, X, Y)+" ");
		System.out.println();
		System.out.println(" ");
		for(int k=0;k<K;k++)
			System.out.print(Functions.Theta1(k, X, Y) +" ");
		System.out.println();
		System.out.print(Functions.Theta2(X, Y)+" ");
		System.out.println();
		for(int d=0;d<r3.length;d++)
			for(int j=0;j<r3[d].length;j++)
				System.out.print(Functions.Theta3(d, j, X, Y)+" ");
		System.out.println();
	*/
	}
	public static void Updata_penalty(int[][] beforeX,int[][] beforeY,Population mypop) {
	 
		int[][]  y=new int[N][];
	    for(int i=0;i<N;i++)
	    	y[i]=new int[Read_Double_Auction.getH(i)];
	    
	    int[][] x =new int[I][];
	    for(int i=0;i<I;i++)
	    	x[i]=new int[Read_Double_Auction.getJ(i)];
	    
	    
	    int s=0,s1=0;
	    for (int i = 0; i <I ; i++) 
		   	  for(int j=0;j<Read_Double_Auction.getJ(i);j++){
		   		  x[i][j]=mypop.getFittest().getGx(s);
		   		s++;
		   	  }
	    
			 for (int i = 0; i < N ; i++) 
			   	  for(int j=0;j<y[i].length;j++){
			   		  y[i][j]=mypop.getFittest().getGy(s1);
			   		s1++;
			   	  }
	/*	for(int k=0;k<K;k++){
			if((Math.abs(Functions.g1(k, x,y))>Math.abs(Functions.g1(k, beforeX,beforeY)))&&(Math.abs(Functions.g1(k, x,y))>Epsilonh))
				r1[k]*=2;
			else if(Math.abs(Functions.g1(k, x,y))<=Epsilonh)
				r1[k]/=2;
			else
				r1[k]=r1[k];
		}
		if((Math.abs(Functions.g2( x,y))>Math.abs(Functions.g2( beforeX,beforeY)))&&(Math.abs(Functions.g2(x,y))>Epsilonh))
			r2*=2;
		else if(Math.abs(Functions.g2( x,y))<=Epsilonh)
			r2/=2;
		else
			r2=r2;
		
		for(int i=0;i<I;i++)
			for(int k=0;k<K;k++){
				if((Math.abs(Functions.g3(i,k, x,y))>Math.abs(Functions.g3(i,k,beforeX,beforeY)))&&(Math.abs(Functions.g3(i,k,x,y))>Epsilonh))
					r3[i][k]*=2;
				else if(Math.abs(Functions.g3(i,k, x,y))<=Epsilonh)
					r3[i][k]/=2;
				else
					r3[i][k]=r3[i][k];
			}
		*/
			 for(int k=0;k<K;k++){
					if((Functions.g1(k, x,y)>Functions.g1(k, beforeX,beforeY))&&Functions.g1(k, x,y)>Epsilonh)
						r1[k]*=2;
					else if(Functions.g1(k, x,y)<=Epsilonh)
						r1[k]/=2;
					if(r1[k]<(Math.sqrt(Lambda1[k]/Epsilonh))/2)
						r1[k]=(Math.sqrt(Lambda1[k]/Epsilonh))/2;
					 
				}
				if((Functions.g2( x,y)>Functions.g2( beforeX,beforeY)) &&Functions.g2( x,y)>Epsilonh)
					r2*=2;
				else if(Functions.g2( x,y)<=Epsilonh)
					r2/=2;
				if(r2<(Math.sqrt(Lambda2/Epsilonh))/2)
					r2=(Math.sqrt(Lambda2/Epsilonh))/2;
				
				for(int i=0;i<I;i++)
					for(int k=0;k<K;k++){
						if((Functions.g3(i,k, x,y)>Functions.g3(i,k,beforeX,beforeY)) &&Functions.g3(i,k, x,y)>Epsilonh)
							r3[i][k]*=2;
						else  if(Functions.g3(i,k, x,y)<=Epsilonh)
							r3[i][k]/=2;
						if(r3[i][k]<(Math.sqrt(Lambda3[i][k]/Epsilonh))/2)
							r3[i][k]=(Math.sqrt(Lambda3[i][k]/Epsilonh))/2;
					}
	/* 	System.out.println("R");
		for(int k=0;k<K;k++)
			System.out.print(r1[k]+" ");
		System.out.println();
		System.out.print(r2+" ");
		System.out.println();
		for(int d=0;d<r3.length;d++)
			for(int j=0;j<r3[d].length;j++)
				System.out.print(r3[d][j]+" ");
		System.out.println(); */
	
	}
}
