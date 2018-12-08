package Algorithm_Tourism.Lagrangian_PSO_Tourism;

import Input_Output_txt.Tourism.Read_Tourism;

public class Updata_Lambda_penalty extends ALPSO_Tourism {
	public static void Updata_Lambda(int[][] Xa, int[][] Xh, int[][] Xt,
			int[][] Y) {

		for (int k = 0; k < Read_Tourism.K(); k++) {
			Lambda1[k] += 2 * r1[k] * +Functions.Theta1(k, Xa, Y);
			if (Lambda1[k] < 0)
				Lambda1[k] = 0;
		}

		for (int k = 0; k < Read_Tourism.K(); k++) {
			Lambda2[k] += 2 * r2[k] * +Functions.Theta2(k, Xh, Y);
			if (Lambda2[k] < 0)
				Lambda2[k] = 0;
		}

		for (int k = 0; k < Read_Tourism.K(); k++) {
			Lambda3[k] += 2 * r3[k] * +Functions.Theta3(k, Xt, Y);
			if (Lambda3[k] < 0)
				Lambda3[k] = 0;
		}

		Lambda4 += 2 * r4 * +Functions.Theta4(Xa, Xh, Xt, Y);
		if (Lambda4 < 0)
			Lambda4 = 0;

		for (int i = 0; i < Read_Tourism.Ia(); i++)
			for (int k = 0; k < Read_Tourism.K(); k++) {
				Lambda5[i][k] += 2 * r5[i][k] * +Functions.Theta5(i, k, Xa);
				if (Lambda5[i][k] < 0)
					Lambda5[i][k] = 0;
			}

		for (int i = 0; i < Read_Tourism.Ih(); i++)
			for (int k = 0; k < Read_Tourism.M(); k++) {
				Lambda6[i][k] += 2 * r6[i][k] * +Functions.Theta6(i, k, Xh);
				if (Lambda6[i][k] < 0)
					Lambda6[i][k] = 0;
			}

		for (int i = 0; i < Read_Tourism.It(); i++)
			for (int k = 0; k < Read_Tourism.T(); k++) {
				Lambda7[i][k] += 2 * r7[i][k] * +Functions.Theta7(i, k, Xt);
				if (Lambda7[i][k] < 0)
					Lambda7[i][k] = 0;
			}
		/*
		 * for(int k=0;k<K;k++) System.out.print(Lambda1[k]+" ");
		 * System.out.println(); System.out.print(Lambda2+" ");
		 * System.out.println(); for(int d=0;d<r3.length;d++) for(int
		 * j=0;j<r3[d].length;j++) System.out.print(Lambda3[d][j]+" ");
		 * System.out.println();
		 */
		/*
		 * System.out.println("g"); for(int k=0;k<K;k++)
		 * System.out.print(Functions.g1(k, X, Y)+" "); System.out.println();
		 * System.out.print(Functions.g2(X, Y)+" "); System.out.println();
		 * for(int d=0;d<r3.length;d++) for(int j=0;j<r3[d].length;j++)
		 * System.out.print(Functions.g3(d, j, X, Y)+" "); System.out.println();
		 * System.out.println(" "); for(int k=0;k<K;k++)
		 * System.out.print(Functions.Theta1(k, X, Y) +" ");
		 * System.out.println(); System.out.print(Functions.Theta2(X, Y)+" ");
		 * System.out.println(); for(int d=0;d<r3.length;d++) for(int
		 * j=0;j<r3[d].length;j++) System.out.print(Functions.Theta3(d, j, X,
		 * Y)+" "); System.out.println();
		 */
	}

	public static void Updata_penalty(int[][] beforeXa, int[][] beforeXh,
			int[][] beforeXt, int[][] beforeY, Population mypop) {

		int[][] y = new int[Read_Tourism.N()][];
		for (int i = 0; i < y.length; i++)
			y[i] = new int[Read_Tourism.H(i)];

		int[][] xa = new int[Read_Tourism.Ia()][];
		for (int i = 0; i < xa.length; i++)
			xa[i] = new int[Read_Tourism.Ja(i)];

		int[][] xh = new int[Read_Tourism.Ih()][];
		for (int i = 0; i < xh.length; i++)
			xh[i] = new int[Read_Tourism.Jh(i)];

		int[][] xt = new int[Read_Tourism.It()][];
		for (int i = 0; i < xt.length; i++)
			xt[i] = new int[Read_Tourism.Jt(i)];

		int s = 0, s1 = 0;
		for (int i = 0; i < xa.length; i++)
			for (int j = 0; j < xa[i].length; j++) {
				xa[i][j] = mypop.getFittest().getGxa(s);
				s++;
			}
		s = 0;
		for (int i = 0; i < xh.length; i++)
			for (int j = 0; j < xh[i].length; j++) {
				xh[i][j] = mypop.getFittest().getGxh(s);
				s++;
			}
		s = 0;
		for (int i = 0; i < xt.length; i++)
			for (int j = 0; j < xt[i].length; j++) {
				xt[i][j] = mypop.getFittest().getGxt(s);
				s++;
			}

		for (int i = 0; i < y.length; i++)
			for (int j = 0; j < y[i].length; j++) {
				y[i][j] = mypop.getFittest().getGy(s1);
				s1++;
			}
		
		for (int k = 0; k < Read_Tourism.K(); k++) {
			if ((Functions.g1(k, xa, y) > Functions.g1(k, beforeXa, beforeY))
					&& Functions.g1(k, xa, y) > Epsilonh)
				r1[k] *= 2;
			else if (Functions.g1(k, xa, y) <= Epsilonh)
				r1[k] /= 2;
			if (r1[k] < (Math.sqrt(Lambda1[k] / Epsilonh)) / 2)
				r1[k] = (Math.sqrt(Lambda1[k] / Epsilonh)) / 2;

		}
		for (int k = 0; k < Read_Tourism.K(); k++) {
			if ((Functions.g2(k, xh, y) > Functions.g2(k, beforeXh, beforeY))
					&& Functions.g2(k, xh, y) > Epsilonh)
				r2[k] *= 2;
			else if (Functions.g2(k, xh, y) <= Epsilonh)
				r2[k] /= 2;
			if (r2[k] < (Math.sqrt(Lambda2[k] / Epsilonh)) / 2)
				r2[k] = (Math.sqrt(Lambda2[k] / Epsilonh)) / 2;

		}
		for (int k = 0; k < Read_Tourism.K(); k++) {
			if ((Functions.g3(k, xt, y) > Functions.g3(k, beforeXt, beforeY))
					&& Functions.g3(k, xt, y) > Epsilonh)
				r3[k] *= 2;
			else if (Functions.g3(k, xt, y) <= Epsilonh)
				r3[k] /= 2;
			if (r3[k] < (Math.sqrt(Lambda3[k] / Epsilonh)) / 2)
				r3[k] = (Math.sqrt(Lambda3[k] / Epsilonh)) / 2;

		}
		if ((Functions.g4(xa,xh,xt, y) > Functions.g4(beforeXa,beforeXh,beforeXt, beforeY))
				&& Functions.g4(xa,xh,xt, y) > Epsilonh)
			r4 *= 2;
		else if (Functions.g4(xa,xh,xt, y) <= Epsilonh)
			r4 /= 2;
		if (r4 < (Math.sqrt(Lambda4 / Epsilonh)) / 2)
			r4 = (Math.sqrt(Lambda4 / Epsilonh)) / 2;

		for (int i = 0; i < Read_Tourism.Ia(); i++)
			for (int k = 0; k < Read_Tourism.K(); k++) {
				if ((Functions.g5(i, k, xa ) > Functions.g5(i, k, beforeXa)) && Functions.g5(i, k, xa ) > Epsilonh)
					r5[i][k] *= 2;
				else if (Functions.g5(i, k, xa) <= Epsilonh)
					r5[i][k] /= 2;
				if (r5[i][k] < (Math.sqrt(Lambda5[i][k] / Epsilonh)) / 2)
					r5[i][k] = (Math.sqrt(Lambda5[i][k] / Epsilonh)) / 2;
			}
		for (int i = 0; i < Read_Tourism.Ih(); i++)
			for (int k = 0; k < Read_Tourism.M(); k++) {
				if ((Functions.g6(i, k, xh ) > Functions.g6(i, k, beforeXh)) && Functions.g6(i, k, xh ) > Epsilonh)
					r6[i][k] *= 2;
				else if (Functions.g6(i, k, xh) <= Epsilonh)
					r6[i][k] /= 2;
				if (r6[i][k] < (Math.sqrt(Lambda6[i][k] / Epsilonh)) / 2)
					r6[i][k] = (Math.sqrt(Lambda6[i][k] / Epsilonh)) / 2;
			}
		for (int i = 0; i < Read_Tourism.It(); i++)
			for (int k = 0; k < Read_Tourism.T(); k++) {
				if ((Functions.g7(i, k, xt ) > Functions.g7(i, k, beforeXt)) && Functions.g7(i, k, xt ) > Epsilonh)
					r7[i][k] *= 2;
				else if (Functions.g7(i, k, xt) <= Epsilonh)
					r7[i][k] /= 2;
				if (r7[i][k] < (Math.sqrt(Lambda7[i][k] / Epsilonh)) / 2)
					r7[i][k] = (Math.sqrt(Lambda7[i][k] / Epsilonh)) / 2;
			}
		/*
		 * System.out.println("R"); for(int k=0;k<K;k++)
		 * System.out.print(r1[k]+" "); System.out.println();
		 * System.out.print(r2+" "); System.out.println(); for(int
		 * d=0;d<r3.length;d++) for(int j=0;j<r3[d].length;j++)
		 * System.out.print(r3[d][j]+" "); System.out.println();
		 */

	}
}
