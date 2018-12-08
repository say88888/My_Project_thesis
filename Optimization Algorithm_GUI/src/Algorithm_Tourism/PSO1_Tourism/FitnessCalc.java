package Algorithm_Tourism.PSO1_Tourism;

 import java.util.ArrayList;
import java.util.List;

import Algorithm_Tourism.Function_Vector;
import Input_Output_txt.Tourism.Read_Tourism;

 

public class FitnessCalc extends PSO1_Tourism {

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

	// F2(X,Y)
	static double getFitness1(Individual individual)   {
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

	static double getPFitness(P_Individual individual)   {
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

	static double getGFitness(G_Individual individual)   {
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

	static double Fitness(int[][] Xa, int[][] Xh, int[][] Xt, int[][] Y)   {
		double fitness = 0;
		ArrayList<Double> C = Function_Vector.C_Vector(Omega_1,Omega_2);
		ArrayList<Integer> z = Function_Vector.z_Vector(Y, Xa, Xh, Xt);
		
		for(int i=0;i<C.size();i++)
			fitness+=C.get(i)*z.get(i);
		
		return fitness;
	}

	static double Fitness1(int[][] Xa,int[][] Xh,int[][] Xt, int[][] Y)   {
		double fitness = 0;
		ArrayList<List<Integer>> A =Function_Vector.A_Vector();
		ArrayList<Integer> B = Function_Vector.B_Vector();
		ArrayList<Integer> z = Function_Vector.z_Vector(Y, Xa, Xh, Xt);
		int R1=PSO_Read_Write_txt.R1();
		int R2=PSO_Read_Write_txt.R2();
		int R3=PSO_Read_Write_txt.R3();
		int R4=PSO_Read_Write_txt.R4();
		int R5=PSO_Read_Write_txt.R5();
		int R6=PSO_Read_Write_txt.R6();
		int R7=PSO_Read_Write_txt.R7();
		
		ArrayList<Integer> R = Function_Vector.R_Vector(R1, R2, R3, R4, R5, R6, R7);
		for(int i=0;i<A.size();i++){
			double sum=0;
			for(int j=0;j<A.get(i).size();j++){
				sum+=A.get(i).get(j)*z.get(j);
			}
			fitness+=R.get(i)*Math.min(sum-B.get(i), 0.0);
		}
		return fitness;
	}

	 
}
