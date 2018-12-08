package Algorithm_Tourism.GA2_Tourism;

 import java.util.ArrayList;
import java.util.List;

import Algorithm_Tourism.Function_Vector;
import Input_Output_txt.Tourism.Read_Tourism;


public class FitnessCalc extends GA2_Tourism{
	 //F2(X,Y)
	static double getFitness_Function(Individual individual)  {
	 
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

		fitness = Fitness(Xa, Xh, Xt, Y);

		return fitness;
	    }
    //F2(X,Y)
static double getFitness_Function2(Individual individual)  {
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

	 
//F(X,Y)
	if (constraint(Xa,Xh,Xt, Y) == true) {

		fitness = Fitness(Xa,Xh,Xt, Y);
		SFminsb.append(fitness + " ");
	}
	// U1(X,Y)
	else {
		double Sfmin;
		Sfmin = GA2_Tourism.Sfmin;

		fitness = Sfmin + U1(Xa,Xh,Xt, Y);
	}
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
static double U1(int[][] Xa,int[][] Xh,int[][] Xt, int[][] Y)   {
	double fitness = 0;
	ArrayList<List<Integer>> A =Function_Vector.A_Vector();
	ArrayList<Integer> B = Function_Vector.B_Vector();
	ArrayList<Integer> z = Function_Vector.z_Vector(Y, Xa, Xh, Xt);
	 
	for(int i=0;i<A.size();i++){
		double sum=0;
		for(int j=0;j<A.get(i).size();j++){
			sum+=A.get(i).get(j)*z.get(j);
		}
		fitness+=Math.min(sum-B.get(i), 0.0);
	}
	return fitness;
}
static boolean constraint(int[][] Xa,int[][] Xh,int[][] Xt, int[][] Y)   {
	boolean right = true;

	ArrayList<List<Integer>> A = Function_Vector.A_Vector();
	ArrayList<Integer> B = Function_Vector.B_Vector();
	ArrayList<Integer> z = Function_Vector.z_Vector(Y, Xa, Xh, Xt);

	for (int i = 0; i < A.size(); i++) {
		int sum = 0;
		for (int j = 0; j < A.get(i).size(); j++)
			sum += A.get(i).get(j) * z.get(j);
		if (sum < B.get(i))
			right = false;
	}
	return right;

}
static double getSFmin(StringBuilder sb) {
	double SFmin;
	String[] a = sb.toString().split(" ");
	if (a.length == 1){
		SFmin = 0;}
	else {
		SFmin = Double.parseDouble(a[0]);
		for (int i = 0; i < a.length; i++) {
			if (SFmin >= Double.parseDouble(a[i]))
				SFmin = Double.parseDouble(a[i]);
		}
	}
	//System.err.println(sb);

	SFminsb = new StringBuilder();
	return SFmin;
}
}
