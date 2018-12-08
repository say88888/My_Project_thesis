package Algorithm_Tourism.Lagrangian_PSO_Tourism;

 import java.util.ArrayList;
import java.util.List;

import Algorithm_Tourism.Function_Vector;
 
import Input_Output_txt.Tourism.Read_Tourism;
 
public class FitnessCalc extends ALPSO_Tourism {

	static double getFitness(G_Individual individual)   {
		double fitness = 0;

		int[][] Y = new int[Read_Tourism.N()][];
		for (int i = 0; i < Read_Tourism.N(); i++)
			Y[i] = new int[Read_Tourism.H(i)];

		int[][] Xa = new int[Read_Tourism.Ia()][];
		for (int i = 0; i < Read_Tourism.Ia(); i++)
			Xa[i] = new int[Read_Tourism.Ja(i)];

		int[][] Xh = new int[Read_Tourism.Ih()][];
		for (int i = 0; i < Read_Tourism.Ih(); i++)
			Xh[i] = new int[Read_Tourism.Jh(i)];

		int[][] Xt = new int[Read_Tourism.It()][];
		for (int i = 0; i < Read_Tourism.It(); i++)
			Xt[i] = new int[Read_Tourism.Jt(i)];

		int b = 0;
		for (int i = 0; i < Y.length; i++)
			for (int j = 0; j < Y[i].length; j++)
				Y[i][j] = individual.getGy(b++);
		b = 0;
		for (int i = 0; i < Xa.length; i++)
			for (int j = 0; j < Xa[i].length; j++)
				Xa[i][j] = individual.getGxa(b++);
		b = 0;
		for (int i = 0; i < Xh.length; i++)
			for (int j = 0; j < Xh[i].length; j++)
				Xh[i][j] = individual.getGxh(b++);
		b = 0;
		for (int i = 0; i < Xt.length; i++)
			for (int j = 0; j < Xt[i].length; j++)
				Xt[i][j] = individual.getGxt(b++);

		fitness = Fitness(Xa, Xh, Xt, Y);
		return fitness;
	}

	// F1(X,Y)
	static double getFitness1(Individual individual )   {

		double fitness = 0;
		int[][] Y = new int[Read_Tourism.N()][];
		for (int i = 0; i < Read_Tourism.N(); i++)
			Y[i] = new int[Read_Tourism.H(i)];

		int[][] Xa = new int[Read_Tourism.Ia()][];
		for (int i = 0; i < Read_Tourism.Ia(); i++)
			Xa[i] = new int[Read_Tourism.Ja(i)];

		int[][] Xh = new int[Read_Tourism.Ih()][];
		for (int i = 0; i < Read_Tourism.Ih(); i++)
			Xh[i] = new int[Read_Tourism.Jh(i)];

		int[][] Xt = new int[Read_Tourism.It()][];
		for (int i = 0; i < Read_Tourism.It(); i++)
			Xt[i] = new int[Read_Tourism.Jt(i)];

		int b = 0;
		for (int i = 0; i < Y.length; i++)
			for (int j = 0; j < Y[i].length; j++)
				Y[i][j] = individual.getY(b++);
		b = 0;
		for (int i = 0; i < Xa.length; i++)
			for (int j = 0; j < Xa[i].length; j++)
				Xa[i][j] = individual.getXa(b++);
		b = 0;
		for (int i = 0; i < Xh.length; i++)
			for (int j = 0; j < Xh[i].length; j++)
				Xh[i][j] = individual.getXh(b++);
		b = 0;
		for (int i = 0; i < Xt.length; i++)
			for (int j = 0; j < Xt[i].length; j++)
				Xt[i][j] = individual.getXt(b++);

		fitness = Fitness(Xa,Xh,Xt, Y) + Fitness1(Xa,Xh,Xt,Y);

		return fitness;
	}

	static double getPFitness1(P_Individual individual)   {
		double fitness = 0;
		int[][] Y = new int[Read_Tourism.N()][];
		for (int i = 0; i < Read_Tourism.N(); i++)
			Y[i] = new int[Read_Tourism.H(i)];

		int[][] Xa = new int[Read_Tourism.Ia()][];
		for (int i = 0; i < Read_Tourism.Ia(); i++)
			Xa[i] = new int[Read_Tourism.Ja(i)];

		int[][] Xh = new int[Read_Tourism.Ih()][];
		for (int i = 0; i < Read_Tourism.Ih(); i++)
			Xh[i] = new int[Read_Tourism.Jh(i)];

		int[][] Xt = new int[Read_Tourism.It()][];
		for (int i = 0; i < Read_Tourism.It(); i++)
			Xt[i] = new int[Read_Tourism.Jt(i)];

		int b = 0;
		for (int i = 0; i < Y.length; i++)
			for (int j = 0; j < Y[i].length; j++)
				Y[i][j] = individual.getPy(b++);
		b = 0;
		for (int i = 0; i < Xa.length; i++)
			for (int j = 0; j < Xa[i].length; j++)
				Xa[i][j] = individual.getPxa(b++);
		b = 0;
		for (int i = 0; i < Xh.length; i++)
			for (int j = 0; j < Xh[i].length; j++)
				Xh[i][j] = individual.getPxh(b++);
		b = 0;
		for (int i = 0; i < Xt.length; i++)
			for (int j = 0; j < Xt[i].length; j++)
				Xt[i][j] = individual.getPxt(b++);

		fitness = Fitness(Xa,Xh,Xt, Y) + Fitness1(Xa,Xh,Xt,Y);
		return fitness;
	 
	}

	static double getGFitness1(G_Individual individual)   {
		double fitness = 0;
		int[][] Y = new int[Read_Tourism.N()][];
		for (int i = 0; i < Read_Tourism.N(); i++)
			Y[i] = new int[Read_Tourism.H(i)];

		int[][] Xa = new int[Read_Tourism.Ia()][];
		for (int i = 0; i < Read_Tourism.Ia(); i++)
			Xa[i] = new int[Read_Tourism.Ja(i)];

		int[][] Xh = new int[Read_Tourism.Ih()][];
		for (int i = 0; i < Read_Tourism.Ih(); i++)
			Xh[i] = new int[Read_Tourism.Jh(i)];

		int[][] Xt = new int[Read_Tourism.It()][];
		for (int i = 0; i < Read_Tourism.It(); i++)
			Xt[i] = new int[Read_Tourism.Jt(i)];

		int b = 0;
		for (int i = 0; i < Y.length; i++)
			for (int j = 0; j < Y[i].length; j++)
				Y[i][j] = individual.getGy(b++);
		b = 0;
		for (int i = 0; i < Xa.length; i++)
			for (int j = 0; j < Xa[i].length; j++)
				Xa[i][j] = individual.getGxa(b++);
		b = 0;
		for (int i = 0; i < Xh.length; i++)
			for (int j = 0; j < Xh[i].length; j++)
				Xh[i][j] = individual.getGxh(b++);
		b = 0;
		for (int i = 0; i < Xt.length; i++)
			for (int j = 0; j < Xt[i].length; j++)
				Xt[i][j] = individual.getGxt(b++);

		fitness = Fitness(Xa,Xh,Xt, Y) + Fitness1(Xa,Xh,Xt,Y);
		return fitness;
	}

	static double getEFitness1(E_Individual individual)   {
		double fitness = 0;
		 
		int[][] Y = new int[Read_Tourism.N()][];
		for (int i = 0; i < Read_Tourism.N(); i++)
			Y[i] = new int[Read_Tourism.H(i)];

		int[][] Xa = new int[Read_Tourism.Ia()][];
		for (int i = 0; i < Read_Tourism.Ia(); i++)
			Xa[i] = new int[Read_Tourism.Ja(i)];

		int[][] Xh = new int[Read_Tourism.Ih()][];
		for (int i = 0; i < Read_Tourism.Ih(); i++)
			Xh[i] = new int[Read_Tourism.Jh(i)];

		int[][] Xt = new int[Read_Tourism.It()][];
		for (int i = 0; i < Read_Tourism.It(); i++)
			Xt[i] = new int[Read_Tourism.Jt(i)];

		int b = 0;
		for (int i = 0; i < Y.length; i++)
			for (int j = 0; j < Y[i].length; j++)
				Y[i][j] = individual.getEy(b++);
		b = 0;
		for (int i = 0; i < Xa.length; i++)
			for (int j = 0; j < Xa[i].length; j++)
				Xa[i][j] = individual.getExa(b++);
		b = 0;
		for (int i = 0; i < Xh.length; i++)
			for (int j = 0; j < Xh[i].length; j++)
				Xh[i][j] = individual.getExh(b++);
		b = 0;
		for (int i = 0; i < Xt.length; i++)
			for (int j = 0; j < Xt[i].length; j++)
				Xt[i][j] = individual.getExt(b++);

		fitness = Fitness(Xa,Xh,Xt, Y) + Fitness1(Xa,Xh,Xt,Y);

		return fitness;
	}

	static double Fitness(int[][] Xa,int[][] Xh,int[][] Xt, int[][] Y)   {
		double fitness = 0;
		ArrayList<Double> C = Function_Vector.C_Vector(Omega_1,Omega_2);
		ArrayList<Integer> z = Function_Vector.z_Vector(Y, Xa, Xh, Xt);
		
		for(int i=0;i<C.size();i++)
			fitness+=C.get(i)*z.get(i);
		
		return fitness;
	}

	static double Fitness1(int[][] Xa,int[][] Xh,int[][] Xt, int[][] Y )   {
		ArrayList<Double> Lambda = Function_Vector.Lambda_Vector(Lambda1, Lambda2, Lambda3, Lambda4, Lambda5, Lambda6, Lambda7);
		ArrayList<Double> Theta = Function_Vector.Theta_Vector(Xa,Xh,Xt,Y,Lambda1, Lambda2, Lambda3, Lambda4, Lambda5, Lambda6, Lambda7,r1, r2, r3, r4, r5, r6, r7);
		double fitness = 0;
		for(int i=0;i<Lambda.size();i++)
			fitness+=Lambda.get(i)*Theta.get(i);
		fitness*=Omega_1;
		for(int i=0;i<Lambda.size();i++)
			fitness-=Lambda.get(i)*Math.pow(Theta.get(i), 2);
		fitness*=Omega_2;
		
		return  fitness ;
	}


}