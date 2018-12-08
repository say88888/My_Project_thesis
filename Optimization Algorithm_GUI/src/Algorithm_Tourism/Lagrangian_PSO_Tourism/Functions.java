package Algorithm_Tourism.Lagrangian_PSO_Tourism;

import Input_Output_txt.Tourism.Read_Tourism;
 

public class Functions extends ALPSO_Tourism {

	public static double g1(int k, int[][] Xa, int[][] Y) {
		double fittest = 0;
		
		for(int n=0;n<Y.length;n++)
			for(int h=0;h<Y[n].length;h++)
				fittest+=Y[n][h]*Read_Tourism.dnhk(n, h, k);
		for(int i=0;i<Xa.length;i++)
			for(int j=0;j<Xa[i].length;j++)
				fittest-=Xa[i][j]*Read_Tourism.qijk(i, j, k);
		return fittest;
	}

	public static double g2(int k,int[][] Xh, int[][] Y) {
		double fittest = 0;
		
		for(int n=0;n<Y.length;n++)
			for(int h=0;h<Y[n].length;h++)
				for(int m=0;m<Read_Tourism.M();m++)
					fittest+=Y[n][h]*Read_Tourism.dnhk(n, h,k)*Read_Tourism.DELTA(k, m);
		
		for(int i=0;i<Xh.length;i++)
			for(int j=0;j<Xh[i].length;j++)
				for(int m=0;m<Read_Tourism.M();m++)
					fittest-=Xh[i][j]*Read_Tourism.DELTA(k, m)*Read_Tourism.uijm(i, j, m);
		
		return fittest;
	}

	public static double g3( int k, int[][] Xt, int[][] Y) {
		double fittest = 0;
		
		for(int n=0;n<Y.length;n++)
			for(int h=0;h<Y[n].length;h++)
				for(int t=0;t<Read_Tourism.T();t++)
					fittest+=Y[n][h]*Read_Tourism.dnhk(n, h,k)*Read_Tourism.PI(k, t);
		
		for(int i=0;i<Xt.length;i++)
			for(int j=0;j<Xt[i].length;j++)
				for(int t=0;t<Read_Tourism.T();t++)
					fittest-=Xt[i][j]*Read_Tourism.PI(k, t)*Read_Tourism.tijt(i, j, t);
		return fittest;
	}

	public static double g4( int[][] Xa,int[][] Xh,int[][] Xt, int[][] Y) {
		double fittest = 0;
		
		for(int i=0;i<Xa.length;i++)
			for(int j=0;j<Xa[i].length;j++)
				fittest+=Xa[i][j]*Read_Tourism.Paij(i, j);
		for(int i=0;i<Xh.length;i++)
			for(int j=0;j<Xh[i].length;j++)
				fittest+=Xh[i][j]*Read_Tourism.Phij(i, j);
		for(int i=0;i<Xt.length;i++)
			for(int j=0;j<Xt[i].length;j++)
				fittest+=Xt[i][j]*Read_Tourism.Ptij(i, j);
		
		for(int n=0;n<Y.length;n++)
			for(int h=0;h<Y[n].length;h++)
				fittest+=Y[n][h]*Read_Tourism.Pbnh(n, h);
	
		
		return fittest;
	}
	
	public static double g5(int i,int k, int[][] Xa ) {
		double fittest = 0;
		
		 for(int j=0;j<Read_Tourism.Ja(i);j++)
			 fittest+=Xa[i][j]*Read_Tourism.qijk(i, j, k);
		 fittest-=Read_Tourism.Vaik(i, k);
		
		return fittest;
	}
	
	public static double g6(int i,int m, int[][] Xh ) {
		double fittest = 0;
		
		 for(int j=0;j<Read_Tourism.Jh(i);j++)
			 fittest+=Xh[i][j]*Read_Tourism.uijm(i, j, m);
		 fittest-=Read_Tourism.Vhim(i,m);
		
		return fittest;
	}
	
	public static double g7(int i,int t, int[][] Xt ) {
		double fittest = 0;
		
		 for(int j=0;j<Read_Tourism.Jt(i);j++)
			 fittest+=Xt[i][j]*Read_Tourism.tijt(i, j, t);
		 fittest-=Read_Tourism.Vtit(i,t);
		
		return fittest;
	}
	 

	public static double Theta1(int k, int[][] Xa, int[][] Y) // Theta1=θ1  Lambda =λ1
	{
		return Math.max(g1(k,Xa,Y),-(Lambda1[k]/(2*r1[k])));
	}
	public static double Theta2(int k, int[][] Xh, int[][] Y) // Theta1=θ1  Lambda =λ1
	{
		return Math.max(g2(k,Xh,Y),-(Lambda2[k]/(2*r2[k])));
	}
	public static double Theta3(int k, int[][] Xt, int[][] Y) // Theta1=θ1  Lambda =λ1
	{
		return Math.max(g3(k,Xt,Y),-(Lambda3[k]/(2*r3[k])));
	}
	public static double Theta4( int[][] Xa,int[][] Xh,int[][] Xt, int[][] Y ) // Theta2=θ2  Lambda =λ2
	{
		return Math.min(g4(Xa,Xh,Xt,Y),-(Lambda4/(2*r4)));
	}
	public static double Theta5( int i,int k,int[][] Xa  ) // Theta3=θ3  Lambda =λ3
	{
		return  Math.min(g5(i,k,Xa ),-(Lambda5[i][k]/(2*r5[i][k])));
	}
	public static double Theta6( int i,int m,int[][] Xh  ) // Theta3=θ3  Lambda =λ3
	{
		return  Math.min(g6(i,m,Xh ),-(Lambda6[i][m]/(2*r6[i][m])));
	}
	public static double Theta7( int i,int t,int[][] Xt ) // Theta3=θ3  Lambda =λ3
	{
		return  Math.min(g7(i,t,Xt ),-(Lambda7[i][t]/(2*r7[i][t])));
	}
}
