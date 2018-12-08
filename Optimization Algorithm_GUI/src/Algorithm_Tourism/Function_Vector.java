package Algorithm_Tourism;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Algorithm_Tourism.Lagrangian_PSO_Tourism.Functions;
import Input_Output_txt.Tourism.Read_Tourism;

public class Function_Vector {

	public static ArrayList<List<Integer>> A_Vector()   {
 		ArrayList<List<Integer>> A = new ArrayList<List<Integer>>();

		//限制式2-2
		for (int k = 0; k < Read_Tourism.K(); k++) {
			ArrayList<Integer> A2_2 = new ArrayList<Integer>();

			for (int i = 0; i < Read_Tourism.N(); i++)
				for (int j = 0; j < Read_Tourism.H(i); j++)
					A2_2.add(-(Read_Tourism.dnhk(i, j, k)));
			for (int i = 0; i < Read_Tourism.Ia(); i++)
				for (int j = 0; j < Read_Tourism.Ja(i); j++)
					A2_2.add(Read_Tourism.qijk(i, j, k));
			for (int i = 0; i < Read_Tourism.Ih(); i++)
				for (int j = 0; j < Read_Tourism.Jh(i); j++)
					A2_2.add(0);
			for (int i = 0; i < Read_Tourism.It(); i++)
				for (int j = 0; j < Read_Tourism.Jt(i); j++)
					A2_2.add(0);
			for (int i = 0; i < Read_Tourism.N(); i++)
				for (int j = 0; j < Read_Tourism.H(i); j++)
					A2_2.add(0);
			for (int i = 0; i < Read_Tourism.Ia(); i++)
				for (int j = 0; j < Read_Tourism.Ja(i); j++)
					A2_2.add(0);
			for (int i = 0; i < Read_Tourism.Ih(); i++)
				for (int j = 0; j < Read_Tourism.Jh(i); j++)
					A2_2.add(0);
			for (int i = 0; i < Read_Tourism.It(); i++)
				for (int j = 0; j < Read_Tourism.Jt(i); j++)
					A2_2.add(0);
			A.add(A2_2);
		}
		//限制式2-3
		for (int k = 0; k < Read_Tourism.K(); k++) {
			if (Read_Tourism.M() != 0) {
				ArrayList<Integer> A2_3 = new ArrayList<Integer>();

				int DELTA = 0;
				for (int m = 0; m < Read_Tourism.M(); m++)
					DELTA += Read_Tourism.DELTA(k, m);
				for (int i = 0; i < Read_Tourism.N(); i++)
					for (int j = 0; j < Read_Tourism.H(i); j++)
						A2_3.add(-(Read_Tourism.dnhk(i, j, k) * DELTA));
				for (int i = 0; i < Read_Tourism.Ia(); i++)
					for (int j = 0; j < Read_Tourism.Ja(i); j++)
						A2_3.add(0);
				for (int i = 0; i < Read_Tourism.Ih(); i++)
					for (int j = 0; j < Read_Tourism.Jh(i); j++) {
						int sum = 0;
						for (int m = 0; m < Read_Tourism.M(); m++)
							sum += Read_Tourism.uijm(i, j, m)
									* Read_Tourism.DELTA(k, m);
						A2_3.add(sum);
					}
				for (int i = 0; i < Read_Tourism.It(); i++)
					for (int j = 0; j < Read_Tourism.Jt(i); j++)
						A2_3.add(0);
				for (int i = 0; i < Read_Tourism.N(); i++)
					for (int j = 0; j < Read_Tourism.H(i); j++)
					 
							A2_3.add(0);
				for (int i = 0; i < Read_Tourism.Ia(); i++)
					for (int j = 0; j < Read_Tourism.Ja(i); j++)
					 
							A2_3.add(0);
				for (int i = 0; i < Read_Tourism.Ih(); i++)
					for (int j = 0; j < Read_Tourism.Jh(i); j++)
					 
							A2_3.add(0);
				for (int i = 0; i < Read_Tourism.It(); i++)
					for (int j = 0; j < Read_Tourism.Jt(i); j++)
						A2_3.add(0);
				A.add(A2_3);
			}
		}
		//限制式2-4
		for (int k = 0; k < Read_Tourism.K(); k++) {
			if (Read_Tourism.T() != 0) {
				ArrayList<Integer> A2_4 = new ArrayList<Integer>();

				int PI = 0;
				for (int t = 0; t < Read_Tourism.T(); t++)
					PI += Read_Tourism.PI(k, t);
				for (int i = 0; i < Read_Tourism.N(); i++)
					for (int j = 0; j < Read_Tourism.H(i); j++)
						A2_4.add(-(Read_Tourism.dnhk(i, j, k) * PI));
				for (int i = 0; i < Read_Tourism.Ia(); i++)
					for (int j = 0; j < Read_Tourism.Ja(i); j++)
						A2_4.add(0);
				for (int i = 0; i < Read_Tourism.Ih(); i++)
					for (int j = 0; j < Read_Tourism.Jh(i); j++)
						A2_4.add(0);
				for (int i = 0; i < Read_Tourism.It(); i++)
					for (int j = 0; j < Read_Tourism.Jt(i); j++) {
						int sum = 0;
						for (int t = 0; t < Read_Tourism.T(); t++)
							sum += Read_Tourism.tijt(i, j, t)
									* Read_Tourism.PI(k, t);
						A2_4.add(sum);
					}

				for (int i = 0; i < Read_Tourism.N(); i++)
					for (int j = 0; j < Read_Tourism.H(i); j++)
						A2_4.add(0);
				for (int i = 0; i < Read_Tourism.Ia(); i++)
					for (int j = 0; j < Read_Tourism.Ja(i); j++)
						A2_4.add(0);
				for (int i = 0; i < Read_Tourism.Ih(); i++)
					for (int j = 0; j < Read_Tourism.Jh(i); j++)
						A2_4.add(0);
				for (int i = 0; i < Read_Tourism.It(); i++)
					for (int j = 0; j < Read_Tourism.Jt(i); j++)
						A2_4.add(0);
				A.add(A2_4);
			}
		}
		//限制式2-5
		ArrayList<Integer> A2_5 = new ArrayList<Integer>();
		for (int i = 0; i < Read_Tourism.N(); i++)
			for (int j = 0; j < Read_Tourism.H(i); j++)
				A2_5.add(Read_Tourism.Pbnh(i, j));
		for (int i = 0; i < Read_Tourism.Ia(); i++)
			for (int j = 0; j < Read_Tourism.Ja(i); j++)
				A2_5.add(-Read_Tourism.Paij(i, j));
		for (int i = 0; i < Read_Tourism.Ih(); i++)
			for (int j = 0; j < Read_Tourism.Jh(i); j++)
				A2_5.add(-Read_Tourism.Phij(i, j));
		for (int i = 0; i < Read_Tourism.It(); i++)
			for (int j = 0; j < Read_Tourism.Jt(i); j++)
				A2_5.add(-Read_Tourism.Ptij(i, j));
		for (int i = 0; i < Read_Tourism.N(); i++)
			for (int j = 0; j < Read_Tourism.H(i); j++)
				A2_5.add(0);
		for (int i = 0; i < Read_Tourism.Ia(); i++)
			for (int j = 0; j < Read_Tourism.Ja(i); j++)
				A2_5.add(0);
		for (int i = 0; i < Read_Tourism.Ih(); i++)
			for (int j = 0; j < Read_Tourism.Jh(i); j++)
				A2_5.add(0);
		for (int i = 0; i < Read_Tourism.It(); i++)
			for (int j = 0; j < Read_Tourism.Jt(i); j++)
				A2_5.add(0);
		A.add(A2_5);
		//限制式2-6
		for (int ia = 0; ia < Read_Tourism.Ia(); ia++)
			for (int k = 0; k < Read_Tourism.K(); k++) {
				ArrayList<Integer> A2_6 = new ArrayList<Integer>();
				for (int i = 0; i < Read_Tourism.N(); i++)
					for (int j = 0; j < Read_Tourism.H(i); j++)
						A2_6.add(0);
				for (int i = 0; i < Read_Tourism.Ia(); i++)
					for (int j = 0; j < Read_Tourism.Ja(i); j++) {
						if (ia == i)
							A2_6.add(-Read_Tourism.qijk(i, j, k));
						else
							A2_6.add(0);
					}
				for (int i = 0; i < Read_Tourism.Ih(); i++)
					for (int j = 0; j < Read_Tourism.Jh(i); j++)
						A2_6.add(0);
				for (int i = 0; i < Read_Tourism.It(); i++)
					for (int j = 0; j < Read_Tourism.Jt(i); j++)
						A2_6.add(0);
				for (int i = 0; i < Read_Tourism.N(); i++)
					for (int j = 0; j < Read_Tourism.H(i); j++)
						A2_6.add(0);
				for (int i = 0; i < Read_Tourism.Ia(); i++)
					for (int j = 0; j < Read_Tourism.Ja(i); j++)
						A2_6.add(0);
				for (int i = 0; i < Read_Tourism.Ih(); i++)
					for (int j = 0; j < Read_Tourism.Jh(i); j++)
						A2_6.add(0);
				for (int i = 0; i < Read_Tourism.It(); i++)
					for (int j = 0; j < Read_Tourism.Jt(i); j++)
						A2_6.add(0);
				A.add(A2_6);
			}
		//限制式2-7
		for (int ih = 0; ih < Read_Tourism.Ih(); ih++)
			for (int m = 0; m < Read_Tourism.M(); m++) {
				ArrayList<Integer> A2_7 = new ArrayList<Integer>();
				for (int i = 0; i < Read_Tourism.N(); i++)
					for (int j = 0; j < Read_Tourism.H(i); j++)
						A2_7.add(0);
				for (int i = 0; i < Read_Tourism.Ia(); i++)
					for (int j = 0; j < Read_Tourism.Ja(i); j++)
						A2_7.add(0);
				for (int i = 0; i < Read_Tourism.Ih(); i++)
					for (int j = 0; j < Read_Tourism.Jh(i); j++) {
						if (ih == i)
							A2_7.add(-Read_Tourism.uijm(i, j, m));
						else
							A2_7.add(0);
					}
				for (int i = 0; i < Read_Tourism.It(); i++)
					for (int j = 0; j < Read_Tourism.Jt(i); j++)
						A2_7.add(0);
				for (int i = 0; i < Read_Tourism.N(); i++)
					for (int j = 0; j < Read_Tourism.H(i); j++)
						A2_7.add(0);
				for (int i = 0; i < Read_Tourism.Ia(); i++)
					for (int j = 0; j < Read_Tourism.Ja(i); j++)
						A2_7.add(0);
				for (int i = 0; i < Read_Tourism.Ih(); i++)
					for (int j = 0; j < Read_Tourism.Jh(i); j++)
						A2_7.add(0);
				for (int i = 0; i < Read_Tourism.It(); i++)
					for (int j = 0; j < Read_Tourism.Jt(i); j++)
						A2_7.add(0);
				A.add(A2_7);
			}
		//限制式2-8
		for (int it = 0; it < Read_Tourism.It(); it++)
			for (int t = 0; t < Read_Tourism.T(); t++) {
				ArrayList<Integer> A2_8 = new ArrayList<Integer>();
				for (int i = 0; i < Read_Tourism.N(); i++)
					for (int j = 0; j < Read_Tourism.H(i); j++)
						A2_8.add(0);
				for (int i = 0; i < Read_Tourism.Ia(); i++)
					for (int j = 0; j < Read_Tourism.Ja(i); j++)
						A2_8.add(0);
				for (int i = 0; i < Read_Tourism.Ih(); i++)
					for (int j = 0; j < Read_Tourism.Jh(i); j++)
						A2_8.add(0);
				for (int i = 0; i < Read_Tourism.It(); i++)
					for (int j = 0; j < Read_Tourism.Jt(i); j++) {
						if (it == i)
							A2_8.add(-Read_Tourism.tijt(i, j, t));
						else
							A2_8.add(0);
					}
				for (int i = 0; i < Read_Tourism.N(); i++)
					for (int j = 0; j < Read_Tourism.H(i); j++)
						A2_8.add(0);
				for (int i = 0; i < Read_Tourism.Ia(); i++)
					for (int j = 0; j < Read_Tourism.Ja(i); j++)
						A2_8.add(0);
				for (int i = 0; i < Read_Tourism.Ih(); i++)
					for (int j = 0; j < Read_Tourism.Jh(i); j++)
						A2_8.add(0);
				for (int i = 0; i < Read_Tourism.It(); i++)
					for (int j = 0; j < Read_Tourism.Jt(i); j++)
						A2_8.add(0);
				A.add(A2_8);
			}

	/*	for (int i = 0; i < A.size(); i++) {
			for (int j = 0; j < A.get(i).size(); j++)
				System.out.print(A.get(i).get(j) + " ");
			System.out.println();
		}*/
		return A;
	}

	public static ArrayList<Integer> B_Vector()   {
 
		ArrayList<Integer> B = new ArrayList<Integer>();

		for (int i = 0; i <  Read_Tourism.K(); i++)
			B.add(0);
		for (int i = 0; i <  Read_Tourism.K(); i++)
			if(Read_Tourism.M()!=0)
				B.add(0);
		for (int i = 0; i <  Read_Tourism.K(); i++)
			if(Read_Tourism.T()!=0)
				B.add(0);
		B.add(0);
		for (int i = 0; i < Read_Tourism.Ia(); i++)
			for (int j = 0; j < Read_Tourism.K(); j++)
				B.add(-Read_Tourism.Vaik(i, j));
		for (int i = 0; i < Read_Tourism.Ih(); i++)
			for (int j = 0; j < Read_Tourism.M(); j++)
				B.add(-Read_Tourism.Vhim(i, j));
		for (int i = 0; i < Read_Tourism.It(); i++)
			for (int j = 0; j < Read_Tourism.T(); j++)
				B.add(-Read_Tourism.Vtit(i, j));

		return B;
	}

	public static ArrayList<Double> C_Vector(double Omega_1, double Omega_2)
			  {
 		ArrayList<Double> C = new ArrayList<Double>();
		for (int i = 0; i < Read_Tourism.N(); i++)
			for (int j = 0; j < Read_Tourism.H(i); j++)
				C.add(Omega_1
						* (Read_Tourism.Pbnh(i, j) * (1 + Read_Tourism.Tbm())));
		for (int i = 0; i < Read_Tourism.Ia(); i++)
			for (int j = 0; j < Read_Tourism.Ja(i); j++)
				C.add(Omega_1
						* (-(Read_Tourism.Paij(i, j) * (1 - Read_Tourism.Tsm()))));
		for (int i = 0; i < Read_Tourism.Ih(); i++)
			for (int j = 0; j < Read_Tourism.Jh(i); j++)
				C.add(Omega_1
						* (-(Read_Tourism.Phij(i, j) * (1 - Read_Tourism.Tsm()))));
		for (int i = 0; i < Read_Tourism.It(); i++)
			for (int j = 0; j < Read_Tourism.Jt(i); j++)
				C.add(Omega_1
						* (-(Read_Tourism.Ptij(i, j) * (1 - Read_Tourism.Tsm()))));

		for (int i = 0; i < Read_Tourism.N(); i++)
			for (int j = 0; j < Read_Tourism.H(i); j++)
				C.add(Omega_2);
		for (int i = 0; i < Read_Tourism.Ia(); i++)
			for (int j = 0; j < Read_Tourism.Ja(i); j++)
				C.add(Omega_2);
		for (int i = 0; i < Read_Tourism.Ih(); i++)
			for (int j = 0; j < Read_Tourism.Jh(i); j++)
				C.add(Omega_2);
		for (int i = 0; i < Read_Tourism.It(); i++)
			for (int j = 0; j < Read_Tourism.Jt(i); j++)
				C.add(Omega_2);

		return C;
	}

	public static ArrayList<Integer> z_Vector(int[][] Y, int[][] Xa,
			int[][] Xh, int[][] Xt)   {

 		ArrayList<Integer> z = new ArrayList<Integer>();

		for (int i = 0; i < Y.length; i++)
			for (int j = 0; j < Y[i].length; j++)
				z.add(Y[i][j]);

		for (int i = 0; i < Xa.length; i++)
			for (int j = 0; j < Xa[i].length; j++)
				z.add(Xa[i][j]);

		for (int i = 0; i < Xh.length; i++)
			for (int j = 0; j < Xh[i].length; j++)
				z.add(Xh[i][j]);

		for (int i = 0; i < Xt.length; i++)
			for (int j = 0; j < Xt[i].length; j++)
				z.add(Xt[i][j]);

		for (int i = 0; i < Y.length; i++)
			for (int j = 0; j < Y[i].length; j++)
				z.add(Y[i][j]);

		for (int i = 0; i < Xa.length; i++)
			for (int j = 0; j < Xa[i].length; j++)
				z.add(Xa[i][j]);

		for (int i = 0; i < Xh.length; i++)
			for (int j = 0; j < Xh[i].length; j++)
				z.add(Xh[i][j]);

		for (int i = 0; i < Xt.length; i++)
			for (int j = 0; j < Xt[i].length; j++)
				z.add(Xt[i][j]);
		return z;
	}

	public static ArrayList<Integer> R_Vector(int R1, int R2, int R3, int R4,
			int R5, int R6, int R7)   {

 		ArrayList<Integer> R = new ArrayList<Integer>();

		for (int i = 0; i < Read_Tourism.K(); i++)
			R.add(R1);
		for (int i = 0; i < Read_Tourism.K(); i++)
			R.add(R2);
		for (int i = 0; i < Read_Tourism.K(); i++)
			R.add(R3);
		R.add(R4);
		for (int i = 0; i < Read_Tourism.Ia(); i++)
			for (int j = 0; j < Read_Tourism.K(); j++)
				R.add(R5);
		for (int i = 0; i < Read_Tourism.Ih(); i++)
			for (int j = 0; j < Read_Tourism.M(); j++)
				R.add(R6);
		for (int i = 0; i < Read_Tourism.It(); i++)
			for (int j = 0; j < Read_Tourism.T(); j++)
				R.add(R7);

		return R;
	}
	
	public static ArrayList<List<Integer>> g_Vector()   {
 		ArrayList<List<Integer>> g = new ArrayList<List<Integer>>();

		for (int k = 0; k < Read_Tourism.K(); k++) {
			ArrayList<Integer> g2_2 = new ArrayList<Integer>();

			for (int i = 0; i < Read_Tourism.N(); i++)
				for (int j = 0; j < Read_Tourism.H(i); j++)
					g2_2.add((Read_Tourism.dnhk(i, j, k)));
			for (int i = 0; i < Read_Tourism.Ia(); i++)
				for (int j = 0; j < Read_Tourism.Ja(i); j++)
					g2_2.add(-Read_Tourism.qijk(i, j, k));
			for (int i = 0; i < Read_Tourism.Ih(); i++)
				for (int j = 0; j < Read_Tourism.Jh(i); j++)
					g2_2.add(0);
			for (int i = 0; i < Read_Tourism.It(); i++)
				for (int j = 0; j < Read_Tourism.Jt(i); j++)
					g2_2.add(0);
			for (int i = 0; i < Read_Tourism.N(); i++)
				for (int j = 0; j < Read_Tourism.H(i); j++)
					g2_2.add(0);
			for (int i = 0; i < Read_Tourism.Ia(); i++)
				for (int j = 0; j < Read_Tourism.Ja(i); j++)
					g2_2.add(0);
			for (int i = 0; i < Read_Tourism.Ih(); i++)
				for (int j = 0; j < Read_Tourism.Jh(i); j++)
					g2_2.add(0);
			for (int i = 0; i < Read_Tourism.It(); i++)
				for (int j = 0; j < Read_Tourism.Jt(i); j++)
					g2_2.add(0);
			 
			g.add(g2_2);
		}

		for (int k = 0; k < Read_Tourism.K(); k++) {
			
			if (Read_Tourism.M() != 0) {
				
				ArrayList<Integer> g2_3 = new ArrayList<Integer>();
				int DELTA = 0;
				for (int m = 0; m < Read_Tourism.M(); m++)
					DELTA += Read_Tourism.DELTA(k, m);
				for (int i = 0; i < Read_Tourism.N(); i++)
					for (int j = 0; j < Read_Tourism.H(i); j++)
						g2_3.add((Read_Tourism.dnhk(i, j, k) * DELTA));
				for (int i = 0; i < Read_Tourism.Ia(); i++)
					for (int j = 0; j < Read_Tourism.Ja(i); j++)
						g2_3.add(0);
				for (int i = 0; i < Read_Tourism.Ih(); i++)
					for (int j = 0; j < Read_Tourism.Jh(i); j++) {
						int sum = 0;
						for (int m = 0; m < Read_Tourism.M(); m++)
							sum += Read_Tourism.uijm(i, j, m)
									* Read_Tourism.DELTA(k, m);
						g2_3.add(-sum);
					}
				for (int i = 0; i < Read_Tourism.It(); i++)
					for (int j = 0; j < Read_Tourism.Jt(i); j++)
						g2_3.add(0);
				for (int i = 0; i < Read_Tourism.N(); i++)
					for (int j = 0; j < Read_Tourism.H(i); j++)
							g2_3.add(0);
				for (int i = 0; i < Read_Tourism.Ia(); i++)
					for (int j = 0; j < Read_Tourism.Ja(i); j++)
							g2_3.add(0);
				for (int i = 0; i < Read_Tourism.Ih(); i++)
					for (int j = 0; j < Read_Tourism.Jh(i); j++)
							g2_3.add(0);
				for (int i = 0; i < Read_Tourism.It(); i++)
					for (int j = 0; j < Read_Tourism.Jt(i); j++)
						g2_3.add(0);
				 
				g.add(g2_3);
			}
		}
		for (int k = 0; k < Read_Tourism.K(); k++) {
			if (Read_Tourism.T() != 0) {
				ArrayList<Integer> g2_4 = new ArrayList<Integer>();

				int PI = 0;
				for (int t = 0; t < Read_Tourism.T(); t++)
					PI += Read_Tourism.PI(k, t);
				for (int i = 0; i < Read_Tourism.N(); i++)
					for (int j = 0; j < Read_Tourism.H(i); j++)
						g2_4.add((Read_Tourism.dnhk(i, j, k) * PI));
				for (int i = 0; i < Read_Tourism.Ia(); i++)
					for (int j = 0; j < Read_Tourism.Ja(i); j++)
						g2_4.add(0);
				for (int i = 0; i < Read_Tourism.Ih(); i++)
					for (int j = 0; j < Read_Tourism.Jh(i); j++)
						g2_4.add(0);
				for (int i = 0; i < Read_Tourism.It(); i++)
					for (int j = 0; j < Read_Tourism.Jt(i); j++) {
						int sum = 0;
						for (int t = 0; t < Read_Tourism.T(); t++)
							sum += Read_Tourism.tijt(i, j, t)
									* Read_Tourism.PI(k, t);
						g2_4.add(-sum);
					}

				for (int i = 0; i < Read_Tourism.N(); i++)
					for (int j = 0; j < Read_Tourism.H(i); j++)
						g2_4.add(0);
				for (int i = 0; i < Read_Tourism.Ia(); i++)
					for (int j = 0; j < Read_Tourism.Ja(i); j++)
						g2_4.add(0);
				for (int i = 0; i < Read_Tourism.Ih(); i++)
					for (int j = 0; j < Read_Tourism.Jh(i); j++)
						g2_4.add(0);
				for (int i = 0; i < Read_Tourism.It(); i++)
					for (int j = 0; j < Read_Tourism.Jt(i); j++)
						g2_4.add(0);
			 
				g.add(g2_4);
			}
		}

		ArrayList<Integer> g2_5 = new ArrayList<Integer>();
		for (int i = 0; i < Read_Tourism.N(); i++)
			for (int j = 0; j < Read_Tourism.H(i); j++)
				g2_5.add(-Read_Tourism.Pbnh(i, j));
		for (int i = 0; i < Read_Tourism.Ia(); i++)
			for (int j = 0; j < Read_Tourism.Ja(i); j++)
				g2_5.add(Read_Tourism.Paij(i, j));
		for (int i = 0; i < Read_Tourism.Ih(); i++)
			for (int j = 0; j < Read_Tourism.Jh(i); j++)
				g2_5.add(Read_Tourism.Phij(i, j));
		for (int i = 0; i < Read_Tourism.It(); i++)
			for (int j = 0; j < Read_Tourism.Jt(i); j++)
				g2_5.add(Read_Tourism.Ptij(i, j));
		for (int i = 0; i < Read_Tourism.N(); i++)
			for (int j = 0; j < Read_Tourism.H(i); j++)
				g2_5.add(0);
		for (int i = 0; i < Read_Tourism.Ia(); i++)
			for (int j = 0; j < Read_Tourism.Ja(i); j++)
				g2_5.add(0);
		for (int i = 0; i < Read_Tourism.Ih(); i++)
			for (int j = 0; j < Read_Tourism.Jh(i); j++)
				g2_5.add(0);
		for (int i = 0; i < Read_Tourism.It(); i++)
			for (int j = 0; j < Read_Tourism.Jt(i); j++)
				g2_5.add(0);
		g.add(g2_5);

		for (int ia = 0; ia < Read_Tourism.Ia(); ia++)
			for (int k = 0; k < Read_Tourism.K(); k++) {
				ArrayList<Integer> g2_6 = new ArrayList<Integer>();
				for (int i = 0; i < Read_Tourism.N(); i++)
					for (int j = 0; j < Read_Tourism.H(i); j++)
						g2_6.add(0);
				for (int i = 0; i < Read_Tourism.Ia(); i++)
					for (int j = 0; j < Read_Tourism.Ja(i); j++) {
						if (ia == i)
							g2_6.add(Read_Tourism.qijk(i, j, k));
						else
							g2_6.add(0);
					}
				for (int i = 0; i < Read_Tourism.Ih(); i++)
					for (int j = 0; j < Read_Tourism.Jh(i); j++)
						g2_6.add(0);
				for (int i = 0; i < Read_Tourism.It(); i++)
					for (int j = 0; j < Read_Tourism.Jt(i); j++)
						g2_6.add(0);
				for (int i = 0; i < Read_Tourism.N(); i++)
					for (int j = 0; j < Read_Tourism.H(i); j++)
						g2_6.add(0);
				for (int i = 0; i < Read_Tourism.Ia(); i++)
					for (int j = 0; j < Read_Tourism.Ja(i); j++)
						g2_6.add(0);
				for (int i = 0; i < Read_Tourism.Ih(); i++)
					for (int j = 0; j < Read_Tourism.Jh(i); j++)
						g2_6.add(0);
				for (int i = 0; i < Read_Tourism.It(); i++)
					for (int j = 0; j < Read_Tourism.Jt(i); j++)
						g2_6.add(0);
				g.add(g2_6);
			}

		for (int ih = 0; ih < Read_Tourism.Ih(); ih++)
			for (int m = 0; m < Read_Tourism.M(); m++) {
				ArrayList<Integer> g2_7 = new ArrayList<Integer>();
				for (int i = 0; i < Read_Tourism.N(); i++)
					for (int j = 0; j < Read_Tourism.H(i); j++)
						g2_7.add(0);
				for (int i = 0; i < Read_Tourism.Ia(); i++)
					for (int j = 0; j < Read_Tourism.Ja(i); j++)
						g2_7.add(0);
				for (int i = 0; i < Read_Tourism.Ih(); i++)
					for (int j = 0; j < Read_Tourism.Jh(i); j++) {
						if (ih == i)
							g2_7.add(Read_Tourism.uijm(i, j, m));
						else
							g2_7.add(0);
					}
				for (int i = 0; i < Read_Tourism.It(); i++)
					for (int j = 0; j < Read_Tourism.Jt(i); j++)
						g2_7.add(0);
				for (int i = 0; i < Read_Tourism.N(); i++)
					for (int j = 0; j < Read_Tourism.H(i); j++)
						g2_7.add(0);
				for (int i = 0; i < Read_Tourism.Ia(); i++)
					for (int j = 0; j < Read_Tourism.Ja(i); j++)
						g2_7.add(0);
				for (int i = 0; i < Read_Tourism.Ih(); i++)
					for (int j = 0; j < Read_Tourism.Jh(i); j++)
						g2_7.add(0);
				for (int i = 0; i < Read_Tourism.It(); i++)
					for (int j = 0; j < Read_Tourism.Jt(i); j++)
						g2_7.add(0);
				g.add(g2_7);
			}

		for (int it = 0; it < Read_Tourism.It(); it++)
			for (int t = 0; t < Read_Tourism.T(); t++) {
				ArrayList<Integer> g2_8 = new ArrayList<Integer>();
				for (int i = 0; i < Read_Tourism.N(); i++)
					for (int j = 0; j < Read_Tourism.H(i); j++)
						g2_8.add(0);
				for (int i = 0; i < Read_Tourism.Ia(); i++)
					for (int j = 0; j < Read_Tourism.Ja(i); j++)
						g2_8.add(0);
				for (int i = 0; i < Read_Tourism.Ih(); i++)
					for (int j = 0; j < Read_Tourism.Jh(i); j++)
						g2_8.add(0);
				for (int i = 0; i < Read_Tourism.It(); i++)
					for (int j = 0; j < Read_Tourism.Jt(i); j++) {
						if (it == i)
							g2_8.add(Read_Tourism.tijt(i, j, t));
						else
							g2_8.add(0);
					}
				for (int i = 0; i < Read_Tourism.N(); i++)
					for (int j = 0; j < Read_Tourism.H(i); j++)
						g2_8.add(0);
				for (int i = 0; i < Read_Tourism.Ia(); i++)
					for (int j = 0; j < Read_Tourism.Ja(i); j++)
						g2_8.add(0);
				for (int i = 0; i < Read_Tourism.Ih(); i++)
					for (int j = 0; j < Read_Tourism.Jh(i); j++)
						g2_8.add(0);
				for (int i = 0; i < Read_Tourism.It(); i++)
					for (int j = 0; j < Read_Tourism.Jt(i); j++)
						g2_8.add(0);
				g.add(g2_8);
			}

	/*	for (int i = 0; i < A.size(); i++) {
			for (int j = 0; j < A.get(i).size(); j++)
				System.out.print(A.get(i).get(j) + " ");
			System.out.println();
		}*/
		return g;
	}
	
	public static ArrayList<Double> Lambda_Vector(double[] Lambda1, double[] Lambda2, double[] Lambda3, double Lambda4,
			double[][] Lambda5, double[][] Lambda6, double[][] Lambda7)   {

 		ArrayList<Double> Lambda = new ArrayList<Double>();

		for (int i = 0; i < Read_Tourism.K(); i++)
			Lambda.add(Lambda1[i]);
		for (int i = 0; i < Read_Tourism.K(); i++)
			Lambda.add(Lambda2[i]);
		for (int i = 0; i < Read_Tourism.K(); i++)
			Lambda.add(Lambda3[i]);
		Lambda.add(Lambda4);
		for (int i = 0; i < Read_Tourism.Ia(); i++)
			for (int j = 0; j < Read_Tourism.K(); j++)
				Lambda.add(Lambda5[i][j]);
		for (int i = 0; i < Read_Tourism.Ih(); i++)
			for (int j = 0; j < Read_Tourism.M(); j++)
				Lambda.add(Lambda6[i][j]);
		for (int i = 0; i < Read_Tourism.It(); i++)
			for (int j = 0; j < Read_Tourism.T(); j++)
				Lambda.add(Lambda7[i][j]);

		return Lambda;
	}
	
	public static ArrayList<Double> Theta_Vector(int[][] Xa,int[][] Xh,int[][] Xt,int[][] Y,double[] Lambda1, double[] Lambda2, double[] Lambda3, double Lambda4,
			double[][] Lambda5, double[][] Lambda6, double[][] Lambda7,double[] r1, double[] r2, double[] r3, double r4,
			double[][] r5, double[][] r6, double[][] r7)   {

 		ArrayList<Double> Theta = new ArrayList<Double>();

		for (int i = 0; i < Read_Tourism.K(); i++)
			Theta.add(Functions.Theta1(i, Xa, Y));
		for (int i = 0; i < Read_Tourism.K(); i++)
			Theta.add(Functions.Theta2(i, Xh, Y));
		for (int i = 0; i < Read_Tourism.K(); i++)
			Theta.add(Functions.Theta3(i, Xt, Y));
		Theta.add(Functions.Theta4(Xa,Xh,Xt, Y));
		for (int i = 0; i < Read_Tourism.Ia(); i++)
			for (int j = 0; j < Read_Tourism.K(); j++)
				Theta.add(Functions.Theta5(i,j,Xa ));
		for (int i = 0; i < Read_Tourism.Ih(); i++)
			for (int j = 0; j < Read_Tourism.M(); j++)
				Theta.add(Functions.Theta6(i,j,Xh ));
		for (int i = 0; i < Read_Tourism.It(); i++)
			for (int j = 0; j < Read_Tourism.T(); j++)
				Theta.add(Functions.Theta7(i,j,Xt ));

		return Theta;
	}
	
	public static ArrayList<Double> C_LR_Vector(double Omega_1, double Omega_2,double[] Lambda1, double[] Lambda2, double[] Lambda3, double Lambda4,
			double[][] Lambda5, double[][] Lambda6, double[][] Lambda7)
			  {
 		ArrayList<Double> C = new ArrayList<Double>();
		for (int i = 0; i < Read_Tourism.N(); i++)
			for (int j = 0; j < Read_Tourism.H(i); j++){
				double fit=0;
				fit=Omega_1* (Read_Tourism.Pbnh(i, j) * (1 + Read_Tourism.Tbm()));
				fit+=Omega_2;
				for(int k=0;k<Read_Tourism.K();k++)
					fit-=Lambda1[k]*Read_Tourism.dnhk(i, j, k);
				for(int k=0;k<Read_Tourism.K();k++)
					for(int m=0;m<Read_Tourism.M();m++)
						fit-=Lambda2[k]*Read_Tourism.DELTA(k, m)*Read_Tourism.dnhk(i, j, k);
				for(int k=0;k<Read_Tourism.K();k++)
					for(int t=0;t<Read_Tourism.T();t++)
						fit-=Lambda3[k]*Read_Tourism.PI(k, t)*Read_Tourism.dnhk(i, j, k);
				fit+=Lambda4*Read_Tourism.Pbnh(i, j);
				C.add(fit);
			}
				
		for (int i = 0; i < Read_Tourism.Ia(); i++)
			for (int j = 0; j < Read_Tourism.Ja(i); j++){
				double fit=0;
				fit+=Omega_1* (-(Read_Tourism.Paij(i, j) * (1 - Read_Tourism.Tsm())));
				fit+=Omega_2;
				for(int k=0;k<Read_Tourism.K();k++)
					fit+=Lambda1[k]*Read_Tourism.qijk(i, j, k);
				fit-=Lambda4*Read_Tourism.Paij(i, j);
				for(int k=0;k<Read_Tourism.K();k++)
					fit-=Lambda5[i][k]*Read_Tourism.qijk(i, j, k);
				C.add(fit);
			}
			
		for (int i = 0; i < Read_Tourism.Ih(); i++)
			for (int j = 0; j < Read_Tourism.Jh(i); j++){
				double fit=0;
				fit+=Omega_1* (-(Read_Tourism.Phij(i, j) * (1 - Read_Tourism.Tsm())));
				fit+=Omega_2;
				for(int k=0;k<Read_Tourism.K();k++)
					for(int m=0;m<Read_Tourism.M();m++)
						fit+=Lambda2[k]*Read_Tourism.DELTA(k, m)*Read_Tourism.uijm(i, j, m);
				fit-=Lambda4*Read_Tourism.Phij(i, j);
				for(int m=0;m<Read_Tourism.M();m++)
					fit-=Lambda6[i][m]*Read_Tourism.uijm(i, j, m);
				C.add(fit);
			}
				 
		for (int i = 0; i < Read_Tourism.It(); i++)
			for (int j = 0; j < Read_Tourism.Jt(i); j++){
				double fit=0;
				fit+=Omega_1* (-(Read_Tourism.Ptij(i, j) * (1 - Read_Tourism.Tsm())));
				fit+=Omega_2;
				for(int k=0;k<Read_Tourism.K();k++)
					for(int t=0;t<Read_Tourism.T();t++)
						fit+=Lambda3[k]*Read_Tourism.PI(k, t)*Read_Tourism.tijt(i, j, t);
				fit-=Lambda4*Read_Tourism.Ptij(i, j);
				for(int t=0;t<Read_Tourism.T();t++)
					fit-=Lambda7[i][t]*Read_Tourism.tijt(i, j, t);
				C.add(fit);
			}
				
		return C;
	}
	
	public static ArrayList<Integer> z_LR_Vector(int[][] Y, int[][] Xa,
			int[][] Xh, int[][] Xt)   {

 		ArrayList<Integer> z = new ArrayList<Integer>();

		for (int i = 0; i < Y.length; i++)
			for (int j = 0; j < Y[i].length; j++)
				z.add(Y[i][j]);

		for (int i = 0; i < Xa.length; i++)
			for (int j = 0; j < Xa[i].length; j++)
				z.add(Xa[i][j]);

		for (int i = 0; i < Xh.length; i++)
			for (int j = 0; j < Xh[i].length; j++)
				z.add(Xh[i][j]);

		for (int i = 0; i < Xt.length; i++)
			for (int j = 0; j < Xt[i].length; j++)
				z.add(Xt[i][j]);
 
		return z;
	}
	
	public static double Fitness(int[][] Xa, int[][] Xh, int[][] Xt, int[][] Y,double Omega_1,double Omega_2,ArrayList<Double> C)    {
		double fitness = 0;
 		ArrayList<Integer> z = z_Vector(Y, Xa, Xh, Xt);
		
		for(int i=0;i<C.size();i++)
			fitness+=C.get(i)*z.get(i);
		
		return fitness;
	}

	public static double U1(int[][] Xa,int[][] Xh,int[][] Xt, int[][] Y,ArrayList<List<Integer>> A,ArrayList<Integer> B)   {
		double fitness = 0;
		 
		ArrayList<Integer> z = z_Vector(Y, Xa, Xh, Xt);
		 
		for(int i=0;i<A.size();i++){
			double sum=0;
			for(int j=0;j<A.get(i).size();j++){
				sum+=A.get(i).get(j)*z.get(j);
			}
			fitness+=Math.min(sum-B.get(i), 0.0);
		}
		return fitness;
	}

	public static boolean constraint(int[][] Xa,int[][] Xh,int[][] Xt, int[][] Y,ArrayList<List<Integer>> A,ArrayList<Integer> B)   {
		boolean right = true;

	
		ArrayList<Integer> z = z_Vector(Y, Xa, Xh, Xt);

		for (int i = 0; i < A.size(); i++) {
			int sum = 0;
			for (int j = 0; j < A.get(i).size(); j++)
				sum += A.get(i).get(j) * z.get(j);
			if (sum < B.get(i))
				right = false;
		}
		return right;

	}
}
