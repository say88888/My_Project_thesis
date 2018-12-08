package Algorithm_Carpool.Lagrangian_PSO;

import Input_Output_txt.Carpool.Read_file;

public class Updata_Lambda_penalty extends ALPSO{
	public static void Updata_Lambda(int[][] x,int[][] y) {
		 
		for(int k=0;k<K;k++){
			Lambda1[k]+=2*r1[k]*-Functions.Theta1(k, x, y );
			if(Lambda1[k] <0)
				Lambda1[k] =0;
		}
		Lambda2+=2*r2*-Functions.Theta2( x, y );
		if(Lambda2 <0)
			Lambda2 =0;
		for(int d=0;d<D;d++)
			for(int j=0;j<Read_file.getJd(d);j++){
				Lambda3[d][j]+=2*r3[d][j]*-Functions.Theta3(d, j, x, y );
				Lambda4[d][j]+=2*r4[d][j]*-Functions.Theta4(d, j, x, y );
				if(Lambda3[d][j] <0)
					Lambda3[d][j] =0;
				if(Lambda4[d][j] <0)
					Lambda4[d][j] =0;
			}
	/*	for(int k=0;k<K;k++)
			System.out.print(Lambda1[k]+" ");
		System.out.println();
		System.out.print(Lambda2+" ");
		System.out.println();
		for(int d=0;d<D;d++)
			for(int j=0;j<Read_file.getJd(d);j++)
				System.out.print(Lambda3[d][j]+" ");
		System.out.println();
		for(int d=0;d<D;d++)
			for(int j=0;j<Read_file.getJd(d);j++)
				System.out.print(Lambda4[d][j]+" ");
		System.out.println();*/
	}
	public static void Updata_penalty(int[][] beforex,int[][] beforey,Population mypop) {
		 
		int[][]  y=new int[P][];
	    for(int i=0;i<P;i++){
	     
	    	y[i]=new int[Read_file.getHp(i)];
	    }
	 
	    int[][] x =new int[D][];
	    for(int i=0;i<D;i++){
	    	 
	    	x[i]=new int[Read_file.getJd(i)];
	    }
	    
	    int s=0,s1=0;
	    for (int i = 0; i <D ; i++) 
		   	  for(int j=0;j<Read_file.getJd(i);j++){
		   		  x[i][j]=mypop.getFittest().getGx(s);
		   	 
		   		s++;
		   	  }
	    
			 for (int i = 0; i < P ; i++) 
			   	  for(int j=0;j<y[i].length;j++){
			   		  y[i][j]=mypop.getFittest().getGy(s1);
			   	 			   		s1++;
			   	  }
		for(int k=0;k<K;k++){
			if((Functions.g1(k, x,y)>Functions.g1(k, beforex,beforey))&&(Functions.g1(k, x,y)>Epsilonh))
				r1[k]*=2;
			if(Functions.g1(k, x,y)<=Epsilonh)
				r1[k]/=2;
		}
		if((Functions.g2( x,y)>Functions.g2( beforex,beforey))&&(Functions.g2(x,y)>Epsilonh))
			r2*=2;
		if(Functions.g2( x,y)<=Epsilonh)
			r2/=2;
		
		for(int d=0;d<D;d++)
			for(int j=0;j<Read_file.getJd(d);j++){
				if((Functions.g3(d,j, x,y)>Functions.g3(d,j,beforex,beforey))&&(Functions.g3(d,j,x,y)>Epsilonh))
					r3[d][j]*=2;
				if(Functions.g3(d,j, x,y)<=Epsilonh)
					r3[d][j]/=2;
				if((Functions.g4(d,j, x,y)>Functions.g4(d,j,beforex,beforey))&&(Functions.g4(d,j,x,y)>Epsilonh))
					r4[d][j]*=2;
				if(Functions.g4(d,j, x,y)<=Epsilonh)
					r4[d][j]/=2;
			}
	/*	System.out.println("R");
		for(int k=0;k<K;k++)
			System.out.print(r1[k]+" ");
		System.out.println();
		System.out.print(r2+" ");
		System.out.println();
		for(int d=0;d<D;d++)
			for(int j=0;j<Read_file.getJd(d);j++)
				System.out.print(r3[d][j]+" ");
		System.out.println();
		for(int d=0;d<D;d++)
			for(int j=0;j<Read_file.getJd(d);j++)
				System.out.print(r4[d][j]+" ");
		System.out.println();*/
	}
}
