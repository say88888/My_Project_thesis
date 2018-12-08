package Algorithm_Tourism.Lagrangian_RelaxationPSO_Tourism;

 import java.util.ArrayList;

import Algorithm_Tourism.Function_Vector;
import Input_Output_txt.Tourism.Read_Tourism;

 
public class Functions extends LRPSO_Tourism {
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
	
	public static double a1(int[][] Xa,int[][] Xh,int[][] Xt, int[][] Y)   // Theta1=θ1 Lambda =λ1
	{
		double fitness = 0;

		for (int k = 0; k < Read_Tourism.K(); k++)
			fitness += Math.pow(g1(k, Xa, Y), 2);
		for (int k = 0; k < Read_Tourism.K(); k++)
			fitness += Math.pow(g2(k, Xh, Y), 2);
		for (int k = 0; k < Read_Tourism.K(); k++)
			fitness += Math.pow(g3(k, Xt, Y), 2);
		fitness += Math.pow(g4(Xa,Xh,Xt, Y), 2);
		for (int i = 0; i < Read_Tourism.Ia(); i++)
			for (int k = 0; k < Read_Tourism.K(); k++) 
				fitness += Math.pow(g5(i, k, Xa), 2);
		for (int i = 0; i < Read_Tourism.Ih(); i++)
			for (int m = 0; m < Read_Tourism.M();m++) 
				fitness += Math.pow(g6(i, m, Xh), 2);
		for (int i = 0; i < Read_Tourism.It(); i++)
			for (int t = 0; t < Read_Tourism.T();t++) 
				fitness += Math.pow(g7(i, t, Xt), 2);
		return c * (L(Xa,Xh,Xt, Y) - L) / fitness;
	}

	public static double a2(int[][] Xa,int[][] Xh,int[][] Xt, int[][] Y)   // Theta1=θ1 Lambda =λ1
	{
		double fitness = 0;

		for (int k = 0; k < Read_Tourism.K(); k++)
			fitness += Math.pow(g1(k, Xa, Y), 2);
		for (int k = 0; k < Read_Tourism.K(); k++)
			fitness += Math.pow(g2(k, Xh, Y), 2);
		for (int k = 0; k < Read_Tourism.K(); k++)
			fitness += Math.pow(g3(k, Xt, Y), 2);
		fitness += Math.pow(g4(Xa,Xh,Xt, Y), 2);
		for (int i = 0; i < Read_Tourism.Ia(); i++)
			for (int k = 0; k < Read_Tourism.K(); k++) 
				fitness += Math.pow(g5(i, k, Xa), 2);
		for (int i = 0; i < Read_Tourism.Ih(); i++)
			for (int m = 0; m < Read_Tourism.M();m++) 
				fitness += Math.pow(g6(i, m, Xh), 2);
		for (int i = 0; i < Read_Tourism.It(); i++)
			for (int t = 0; t < Read_Tourism.T();t++) 
				fitness += Math.pow(g7(i, t, Xt), 2);
		return c * (L(Xa,Xh,Xt, Y) - L) / fitness;
	}
	
	public static double a3(int[][] Xa,int[][] Xh,int[][] Xt, int[][] Y)   // Theta1=θ1 Lambda =λ1
	{
		double fitness = 0;

		for (int k = 0; k < Read_Tourism.K(); k++)
			fitness += Math.pow(g1(k, Xa, Y), 2);
		for (int k = 0; k < Read_Tourism.K(); k++)
			fitness += Math.pow(g2(k, Xh, Y), 2);
		for (int k = 0; k < Read_Tourism.K(); k++)
			fitness += Math.pow(g3(k, Xt, Y), 2);
		fitness += Math.pow(g4(Xa,Xh,Xt, Y), 2);
		for (int i = 0; i < Read_Tourism.Ia(); i++)
			for (int k = 0; k < Read_Tourism.K(); k++) 
				fitness += Math.pow(g5(i, k, Xa), 2);
		for (int i = 0; i < Read_Tourism.Ih(); i++)
			for (int m = 0; m < Read_Tourism.M();m++) 
				fitness += Math.pow(g6(i, m, Xh), 2);
		for (int i = 0; i < Read_Tourism.It(); i++)
			for (int t = 0; t < Read_Tourism.T();t++) 
				fitness += Math.pow(g7(i, t, Xt), 2);
		return c * (L(Xa,Xh,Xt, Y) - L) / fitness;
	}
	
	public static double a4(int[][] Xa,int[][] Xh,int[][] Xt, int[][] Y)   // Theta1=θ1 Lambda =λ1
	{
		double fitness = 0;

		for (int k = 0; k < Read_Tourism.K(); k++)
			fitness += Math.pow(g1(k, Xa, Y), 2);
		for (int k = 0; k < Read_Tourism.K(); k++)
			fitness += Math.pow(g2(k, Xh, Y), 2);
		for (int k = 0; k < Read_Tourism.K(); k++)
			fitness += Math.pow(g3(k, Xt, Y), 2);
		fitness += Math.pow(g4(Xa,Xh,Xt, Y), 2);
		for (int i = 0; i < Read_Tourism.Ia(); i++)
			for (int k = 0; k < Read_Tourism.K(); k++) 
				fitness += Math.pow(g5(i, k, Xa), 2);
		for (int i = 0; i < Read_Tourism.Ih(); i++)
			for (int m = 0; m < Read_Tourism.M();m++) 
				fitness += Math.pow(g6(i, m, Xh), 2);
		for (int i = 0; i < Read_Tourism.It(); i++)
			for (int t = 0; t < Read_Tourism.T();t++) 
				fitness += Math.pow(g7(i, t, Xt), 2);
		return c * (L(Xa,Xh,Xt, Y) - L) / fitness;
	}
	
	public static double a5(int[][] Xa,int[][] Xh,int[][] Xt, int[][] Y)   // Theta1=θ1 Lambda =λ1
	{
		double fitness = 0;

		for (int k = 0; k < Read_Tourism.K(); k++)
			fitness += Math.pow(g1(k, Xa, Y), 2);
		for (int k = 0; k < Read_Tourism.K(); k++)
			fitness += Math.pow(g2(k, Xh, Y), 2);
		for (int k = 0; k < Read_Tourism.K(); k++)
			fitness += Math.pow(g3(k, Xt, Y), 2);
		fitness += Math.pow(g4(Xa,Xh,Xt, Y), 2);
		for (int i = 0; i < Read_Tourism.Ia(); i++)
			for (int k = 0; k < Read_Tourism.K(); k++) 
				fitness += Math.pow(g5(i, k, Xa), 2);
		for (int i = 0; i < Read_Tourism.Ih(); i++)
			for (int m = 0; m < Read_Tourism.M();m++) 
				fitness += Math.pow(g6(i, m, Xh), 2);
		for (int i = 0; i < Read_Tourism.It(); i++)
			for (int t = 0; t < Read_Tourism.T();t++) 
				fitness += Math.pow(g7(i, t, Xt), 2);
		return c * (L(Xa,Xh,Xt, Y) - L) / fitness;
	}
	
	public static double a6(int[][] Xa,int[][] Xh,int[][] Xt, int[][] Y)   // Theta1=θ1 Lambda =λ1
	{
		double fitness = 0;

		for (int k = 0; k < Read_Tourism.K(); k++)
			fitness += Math.pow(g1(k, Xa, Y), 2);
		for (int k = 0; k < Read_Tourism.K(); k++)
			fitness += Math.pow(g2(k, Xh, Y), 2);
		for (int k = 0; k < Read_Tourism.K(); k++)
			fitness += Math.pow(g3(k, Xt, Y), 2);
		fitness += Math.pow(g4(Xa,Xh,Xt, Y), 2);
		for (int i = 0; i < Read_Tourism.Ia(); i++)
			for (int k = 0; k < Read_Tourism.K(); k++) 
				fitness += Math.pow(g5(i, k, Xa), 2);
		for (int i = 0; i < Read_Tourism.Ih(); i++)
			for (int m = 0; m < Read_Tourism.M();m++) 
				fitness += Math.pow(g6(i, m, Xh), 2);
		for (int i = 0; i < Read_Tourism.It(); i++)
			for (int t = 0; t < Read_Tourism.T();t++) 
				fitness += Math.pow(g7(i, t, Xt), 2);
		return c * (L(Xa,Xh,Xt, Y) - L) / fitness;
	}
	
	public static double a7(int[][] Xa,int[][] Xh,int[][] Xt, int[][] Y)   // Theta1=θ1 Lambda =λ1
	{
		double fitness = 0;

		for (int k = 0; k < Read_Tourism.K(); k++)
			fitness += Math.pow(g1(k, Xa, Y), 2);
		for (int k = 0; k < Read_Tourism.K(); k++)
			fitness += Math.pow(g2(k, Xh, Y), 2);
		for (int k = 0; k < Read_Tourism.K(); k++)
			fitness += Math.pow(g3(k, Xt, Y), 2);
		fitness += Math.pow(g4(Xa,Xh,Xt, Y), 2);
		for (int i = 0; i < Read_Tourism.Ia(); i++)
			for (int k = 0; k < Read_Tourism.K(); k++) 
				fitness += Math.pow(g5(i, k, Xa), 2);
		for (int i = 0; i < Read_Tourism.Ih(); i++)
			for (int m = 0; m < Read_Tourism.M();m++) 
				fitness += Math.pow(g6(i, m, Xh), 2);
		for (int i = 0; i < Read_Tourism.It(); i++)
			for (int t = 0; t < Read_Tourism.T();t++) 
				fitness += Math.pow(g7(i, t, Xt), 2);
		return c * (L(Xa,Xh,Xt, Y) - L) / fitness;
	}
	
	public static double L(int[][] Xa,int[][] Xh,int[][] Xt, int[][] Y)   {
		double fitness = 0  ;
		ArrayList<Double> C = Function_Vector.C_LR_Vector(Omega_1,Omega_2,Lambda1,Lambda2,Lambda3,Lambda4,Lambda5,Lambda6,Lambda7);
		ArrayList<Integer> z = Function_Vector.z_LR_Vector(Y, Xa, Xh, Xt);
		 
		for(int i=0;i<C.size();i++)
			fitness+=C.get(i)*z.get(i);
	 
		return fitness;
	}

	 
}

	 
 
