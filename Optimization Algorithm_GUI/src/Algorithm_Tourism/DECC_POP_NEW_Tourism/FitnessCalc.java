package Algorithm_Tourism.DECC_POP_NEW_Tourism;

import Algorithm_Tourism.Function_Vector; 
import Input_Output_txt.Tourism.Read_Tourism;

public class FitnessCalc extends DECC_POP_NEW_Tourism {

	static double F(int[] xa, int[] xh, int[] xt, int[] y) {

		double fitness = 0;
		int c = 0;
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
				Y[i][j] = y[b++];
		b = 0;
		for (int i = 0; i < Xa.length; i++)
			for (int j = 0; j < Xa[i].length; j++)
				Xa[i][j] = xa[b++];
		b = 0;
		for (int i = 0; i < Xh.length; i++)
			for (int j = 0; j < Xh[i].length; j++)
				Xh[i][j] = xh[b++];
		b = 0;
		for (int i = 0; i < Xt.length; i++)
			for (int j = 0; j < Xt[i].length; j++)
				Xt[i][j] = xt[b++];

		if (Function_Vector.constraint(Xa, Xh, Xt, Y, A, B) == true) {
			fitness = Function_Vector.Fitness(Xa, Xh, Xt, Y, Omega_1, Omega_2, C);
			SFminsb.append(fitness + " ");
		}
		// U1(X,Y)
		else {
			double Sfmin;
			Sfmin = DECC_POP_NEW_Tourism.Sfmin;
			fitness = Sfmin + Function_Vector.U1(Xa, Xh, Xt, Y, A, B);
		}
		return fitness;
	}

	static double getFitness(Individual individual) {

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
				Y[i][j] = individual.getbinaryY(b++);
		b = 0;
		for (int i = 0; i < Xa.length; i++)
			for (int j = 0; j < Xa[i].length; j++)
				Xa[i][j] = individual.getbinaryXa(b++);
		b = 0;
		for (int i = 0; i < Xh.length; i++)
			for (int j = 0; j < Xh[i].length; j++)
				Xh[i][j] = individual.getbinaryXh(b++);
		b = 0;
		for (int i = 0; i < Xt.length; i++)
			for (int j = 0; j < Xt[i].length; j++)
				Xt[i][j] = individual.getbinaryXt(b++);

		fitness = Function_Vector.Fitness(Xa, Xh, Xt, Y, Omega_1, Omega_2, C);

		return fitness;
	}

	// F2(X,Y)
	static double getFitness1(Individual individual) {
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
				Y[i][j] = individual.getbinaryY(b++);
		b = 0;
		for (int i = 0; i < Xa.length; i++)
			for (int j = 0; j < Xa[i].length; j++)
				Xa[i][j] = individual.getbinaryXa(b++);
		b = 0;
		for (int i = 0; i < Xh.length; i++)
			for (int j = 0; j < Xh[i].length; j++)
				Xh[i][j] = individual.getbinaryXh(b++);
		b = 0;
		for (int i = 0; i < Xt.length; i++)
			for (int j = 0; j < Xt[i].length; j++)
				Xt[i][j] = individual.getbinaryXt(b++);

		// F(X,Y)
		// if((st22==K)&&(st23>=0)&&(st24==Xsize)&&(st25==Xsize)&&(st26<=D) ){
		if (Function_Vector.constraint(Xa, Xh, Xt, Y, A, B) == true) {

			fitness = Function_Vector.Fitness(Xa, Xh, Xt, Y, Omega_1, Omega_2, C);
			SFminsb.append(fitness + " ");
		}
		// U1(X,Y)
		else {
			double Sfmin;
			Sfmin = DECC_POP_NEW_Tourism.Sfmin;

			fitness = Sfmin + Function_Vector.U1(Xa, Xh, Xt, Y, A, B);
		}
		return fitness;
	}

	static double getUFitness(U_Individual individual) {
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
				Y[i][j] = individual.getbinaryUy(b++);
		b = 0;
		for (int i = 0; i < Xa.length; i++)
			for (int j = 0; j < Xa[i].length; j++)
				Xa[i][j] = individual.getbinaryUxa(b++);
		b = 0;
		for (int i = 0; i < Xh.length; i++)
			for (int j = 0; j < Xh[i].length; j++)
				Xh[i][j] = individual.getbinaryUxh(b++);
		b = 0;
		for (int i = 0; i < Xt.length; i++)
			for (int j = 0; j < Xt[i].length; j++)
				Xt[i][j] = individual.getbinaryUxt(b++);

		// F(X,Y)
		// if((st22==K)&&(st23>=0)&&(st24==Xsize)&&(st25==Xsize)&&(st26<=D) ){
		if (Function_Vector.constraint(Xa, Xh, Xt, Y, A, B) == true) {

			fitness = Function_Vector.Fitness(Xa, Xh, Xt, Y, Omega_1, Omega_2, C);
			SFminsb.append(fitness + " ");
		}
		// U1(X,Y)
		else {
			double Sfmin;
			Sfmin = DECC_POP_NEW_Tourism.Sfmin;

			fitness = Sfmin + Function_Vector.U1(Xa, Xh, Xt, Y, A, B);
		}
		return fitness;
	}

	static double getSFmin(StringBuilder sb) {
		double SFmin;
		String[] a = sb.toString().split(" ");
		if (a.length == 1) {
			SFmin = 0;
		} else {
			SFmin = Double.parseDouble(a[0]);
			for (int i = 0; i < a.length; i++)
				if (SFmin >= Double.parseDouble(a[i]))
					SFmin = Double.parseDouble(a[i]);

		}

		SFminsb = new StringBuilder();
		return SFmin;
	}
}
