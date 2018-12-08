package Algorithm_Tourism.DynDE_POP_Tourism;
 
public class Function extends DynDE_POP_Tourism {
	static V_Individual Differential_Evolution(int strategy, Individual ind, Individual ind_r1, Individual ind_r2, Individual ind_r3, Individual ind_r4, Individual ind_r5, Individual ind_b) {

		V_Individual V = new V_Individual();
		switch (strategy) {
		case 0:
			for (int i = 0; i < Xasize; i++) {
				F = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
				V.setVxa(i, ind_r1.getXa(i) + (ind_r2.getXa(i) - ind_r3.getXa(i)) * (DE_Read_Write_txt.random_generate_or_read3(Execution_Mode) * 0.5 + 0.5));
			}
			for (int i = 0; i < Xhsize; i++) {
				F = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
				V.setVxh(i, ind_r1.getXh(i) + (ind_r2.getXh(i) - ind_r3.getXh(i)) * (DE_Read_Write_txt.random_generate_or_read3(Execution_Mode) * 0.5 + 0.5));
			}
			for (int i = 0; i < Xtsize; i++) {
				F = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
				V.setVxt(i, ind_r1.getXt(i) + (ind_r2.getXt(i) - ind_r3.getXt(i)) * (DE_Read_Write_txt.random_generate_or_read3(Execution_Mode) * 0.5 + 0.5));
			}
			for (int i = 0; i < Ysize; i++) {
				F = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
				V.setVy(i, ind_r1.getY(i) + (ind_r2.getY(i) - ind_r3.getY(i)) * (DE_Read_Write_txt.random_generate_or_read3(Execution_Mode) * 0.5 + 0.5));
			}
			break;
		case 1:
			for (int i = 0; i < Xasize; i++) {
				F = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
				V.setVxa(i, ind_b.getXa(i) + F * (ind_r2.getXa(i) - ind_r3.getXa(i)));
			}
			for (int i = 0; i < Xhsize; i++) {
				F = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
				V.setVxh(i, ind_b.getXh(i) + F * (ind_r2.getXh(i) - ind_r3.getXh(i)));
			}
			for (int i = 0; i < Xtsize; i++) {
				F = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
				V.setVxt(i, ind_b.getXt(i) + F * (ind_r2.getXt(i) - ind_r3.getXt(i)));
			}
			for (int i = 0; i < Ysize; i++) {
				F = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
				V.setVy(i, ind_b.getY(i) + F * (ind_r2.getY(i) - ind_r3.getY(i)));
			}
			break;
		case 2:
			for (int i = 0; i < Xasize; i++) {
				F = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
				V.setVxa(i, ind_r1.getXa(i) + F * (ind_r2.getXa(i) - ind_r3.getXa(i)) + F * (ind_r4.getXa(i) - ind_r5.getXa(i)));
			}
			for (int i = 0; i < Xhsize; i++) {
				F = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
				V.setVxh(i, ind_r1.getXh(i) + F * (ind_r2.getXh(i) - ind_r3.getXh(i)) + F * (ind_r4.getXh(i) - ind_r5.getXh(i)));
			}
			for (int i = 0; i < Xtsize; i++) {
				F = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
				V.setVxt(i, ind_r1.getXt(i) + F * (ind_r2.getXt(i) - ind_r3.getXt(i)) + F * (ind_r4.getXt(i) - ind_r5.getXt(i)));
			}
			for (int i = 0; i < Ysize; i++) {
				F = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
				V.setVy(i, ind_r1.getY(i) + F * (ind_r2.getY(i) - ind_r3.getY(i)) + F * (ind_r4.getY(i) - ind_r5.getY(i)));
			}
			break;
		case 3:
			for (int i = 0; i < Xasize; i++) {
				F = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
				V.setVxa(i, ind_b.getXa(i) + F * (ind_r1.getXa(i) - ind_r2.getXa(i)) + F * (ind_r3.getXa(i) - ind_r4.getXa(i)));
			}
			for (int i = 0; i < Xhsize; i++) {
				F = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
				V.setVxh(i, ind_b.getXh(i) + F * (ind_r1.getXh(i) - ind_r2.getXh(i)) + F * (ind_r3.getXh(i) - ind_r4.getXh(i)));
			}
			for (int i = 0; i < Xtsize; i++) {
				F = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
				V.setVxt(i, ind_b.getXt(i) + F * (ind_r1.getXt(i) - ind_r2.getXt(i)) + F * (ind_r3.getXt(i) - ind_r4.getXt(i)));
			}
			for (int i = 0; i < Ysize; i++) {
				F = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
				V.setVy(i, ind_b.getY(i) + F * (ind_r1.getY(i) - ind_r2.getY(i)) + F * (ind_r3.getY(i) - ind_r4.getY(i)));
			}
			break;
		case 4:
			for (int i = 0; i < Xasize; i++) {
				F = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
				V.setVxa(i, ind.getXa(i) + F * (ind_b.getXa(i) - ind.getXa(i)) + F * (ind_r1.getXa(i) - ind_r2.getXa(i)));
			}
			for (int i = 0; i < Xhsize; i++) {
				F = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
				V.setVxh(i, ind.getXh(i) + F * (ind_b.getXh(i) - ind.getXh(i)) + F * (ind_r1.getXh(i) - ind_r2.getXh(i)));
			}
			for (int i = 0; i < Xtsize; i++) {
				F = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
				V.setVxt(i, ind.getXt(i) + F * (ind_b.getXt(i) - ind.getXt(i)) + F * (ind_r1.getXt(i) - ind_r2.getXt(i)));
			}
			for (int i = 0; i < Ysize; i++) {
				F = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
				V.setVy(i, ind.getY(i) + F * (ind_b.getY(i) - ind.getY(i)) + F * (ind_r1.getY(i) - ind_r2.getY(i)));
			}
			break;
		default:
			for (int i = 0; i < Xasize; i++) {
				F = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
				V.setVxa(i, ind.getXa(i) + F * (ind_b.getXa(i) - ind.getXa(i)) + F * (ind_r1.getXa(i) - ind_r2.getXa(i)) + F * (ind_r3.getXa(i) - ind_r4.getXa(i)));
			}
			for (int i = 0; i < Xhsize; i++) {
				F = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
				V.setVxh(i, ind.getXh(i) + F * (ind_b.getXh(i) - ind.getXh(i)) + F * (ind_r1.getXh(i) - ind_r2.getXh(i)) + F * (ind_r3.getXh(i) - ind_r4.getXh(i)));
			}
			for (int i = 0; i < Xtsize; i++) {
				F = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
				V.setVxt(i, ind.getXt(i) + F * (ind_b.getXt(i) - ind.getXt(i)) + F * (ind_r1.getXt(i) - ind_r2.getXt(i)) + F * (ind_r3.getXt(i) - ind_r4.getXt(i)));
			}
			for (int i = 0; i < Ysize; i++) {
				F = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
				V.setVy(i, ind.getY(i) + F * (ind_b.getY(i) - ind.getY(i)) + F * (ind_r1.getY(i) - ind_r2.getY(i)) + F * (ind_r3.getY(i) - ind_r4.getY(i)));
			}
		}

		for (int i = 0; i < Xasize; i++) {
			if (V.getVxa(i) > Vmax)
				V.setVxa(i, Vmax);
			if (V.getVxa(i) < -Vmax)
				V.setVxa(i, -Vmax);
		}
		for (int i = 0; i < Xhsize; i++) {
			if (V.getVxh(i) > Vmax)
				V.setVxh(i, Vmax);
			if (V.getVxh(i) < -Vmax)
				V.setVxh(i, -Vmax);
		}
		for (int i = 0; i < Xtsize; i++) {
			if (V.getVxt(i) > Vmax)
				V.setVxt(i, Vmax);
			if (V.getVxt(i) < -Vmax)
				V.setVxt(i, -Vmax);
		}
		for (int i = 0; i < Ysize; i++) {
			if (V.getVy(i) > Vmax)
				V.setVy(i, Vmax);
			if (V.getVy(i) < -Vmax)
				V.setVy(i, -Vmax);
		}
		return V;
	}

	static U_Individual Quantum(G_Individual G_invid) {
		U_Individual U = new U_Individual();

		double dist = 0;
		double[] Xa = new double[Xasize];
		for (int d = 0; d < Xasize; d++) {
			Xa[d] = DE_Read_Write_txt.random_generate_or_read3(Execution_Mode);
			dist += Math.pow(Xa[d], 2.0);
		}
		dist = Math.sqrt(dist);
		for (int d = 0; d < Xasize; d++) {
			double r = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode) * rcloud;
			U.setUxa(d, G_invid.getGxa(d) + ((r * Xa[d]) / dist));

			double rsid = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
			if (rsid < 1 / (1 + Math.exp(-lamda * U.getUxa(d)))) {
				U.setbinaryUxa(d, 1);
			} else {
				U.setbinaryUxa(d, 0);
			}

		}

		 dist = 0;
		double[] Xh = new double[Xhsize];
		for (int d = 0; d < Xhsize; d++) {
			Xh[d] = DE_Read_Write_txt.random_generate_or_read3(Execution_Mode);
			dist += Math.pow(Xh[d], 2.0);
		}
		dist = Math.sqrt(dist);
		for (int d = 0; d < Xhsize; d++) {
			double r = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode) * rcloud;
			U.setUxh(d, G_invid.getGxh(d) + ((r * Xh[d]) / dist));

			double rsid = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
			if (rsid < 1 / (1 + Math.exp(-lamda * U.getUxh(d)))) {
				U.setbinaryUxh(d, 1);
			} else {
				U.setbinaryUxh(d, 0);
			}

		}
		
		 dist = 0;
		double[] Xt = new double[Xtsize];
		for (int d = 0; d < Xtsize; d++) {
			Xt[d] = DE_Read_Write_txt.random_generate_or_read3(Execution_Mode);
			dist += Math.pow(Xt[d], 2.0);
		}
		dist = Math.sqrt(dist);
		for (int d = 0; d < Xtsize; d++) {
			double r = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode) * rcloud;
			U.setUxt(d, G_invid.getGxt(d) + ((r * Xt[d]) / dist));

			double rsid = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
			if (rsid < 1 / (1 + Math.exp(-lamda * U.getUxt(d)))) {
				U.setbinaryUxt(d, 1);
			} else {
				U.setbinaryUxt(d, 0);
			}

		}
		
		dist = 0;
		double[] Y = new double[Ysize];
		for (int d = 0; d < Ysize; d++) {
			Y[d] = DE_Read_Write_txt.random_generate_or_read3(Execution_Mode);
			dist += Math.pow(Y[d], 2.0);
		}
		dist = Math.sqrt(dist);
		for (int d = 0; d < Ysize; d++) {
			double r = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode) * rcloud;
			U.setUy(d, G_invid.getGy(d) + ((r * Y[d]) / dist));

			double rsid = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
			if (rsid < 1 / (1 + Math.exp(-lamda * U.getUy(d)))) {
				U.setbinaryUy(d, 1);
			} else {
				U.setbinaryUy(d, 0);
			}

		}

		return U;
	}

	static U_Individual Brownian(G_Individual G_invid) {
		U_Individual U = new U_Individual();

		for (int d = 0; d < Xasize; d++) {
			U.setUxa(d, G_invid.getGxa(d) + DE_Read_Write_txt.random_generate_or_read3(Execution_Mode) * Sigma);

			double rsid = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
			if (rsid < 1 / (1 + Math.exp(-lamda * U.getUxa(d)))) {
				U.setbinaryUxa(d, 1);
			} else {
				U.setbinaryUxa(d, 0);
			}
		}

		for (int d = 0; d < Xhsize; d++) {
			U.setUxh(d, G_invid.getGxh(d) + DE_Read_Write_txt.random_generate_or_read3(Execution_Mode) * Sigma);

			double rsid = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
			if (rsid < 1 / (1 + Math.exp(-lamda * U.getUxh(d)))) {
				U.setbinaryUxh(d, 1);
			} else {
				U.setbinaryUxh(d, 0);
			}
		}
		
		for (int d = 0; d < Xtsize; d++) {
			U.setUxt(d, G_invid.getGxt(d) + DE_Read_Write_txt.random_generate_or_read3(Execution_Mode) * Sigma);

			double rsid = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
			if (rsid < 1 / (1 + Math.exp(-lamda * U.getUxt(d)))) {
				U.setbinaryUxt(d, 1);
			} else {
				U.setbinaryUxt(d, 0);
			}
		}
		
		for (int d = 0; d < Ysize; d++) {
			U.setUy(d, G_invid.getGy(d) + DE_Read_Write_txt.random_generate_or_read3(Execution_Mode) * Sigma);

			double rsid = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
			if (rsid < 1 / (1 + Math.exp(-lamda * U.getUy(d)))) {
				U.setbinaryUy(d, 1);
			} else {
				U.setbinaryUy(d, 0);
			}
		}

		return U;
	}

	static U_Individual Entropy_Differential_Evolution(Individual invid) {

		U_Individual U = new U_Individual();

		for (int d = 0; d < Xasize; d++) {
			U.setUxa(d, invid.getXa(d) + DE_Read_Write_txt.random_generate_or_read3(Execution_Mode) * Sigma);

			double rsid = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
			if (rsid < 1 / (1 + Math.exp(-lamda * U.getUxa(d)))) {
				U.setbinaryUxa(d, 1);
			} else {
				U.setbinaryUxa(d, 0);
			}
		}

		for (int d = 0; d < Xhsize; d++) {
			U.setUxh(d, invid.getXh(d) + DE_Read_Write_txt.random_generate_or_read3(Execution_Mode) * Sigma);

			double rsid = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
			if (rsid < 1 / (1 + Math.exp(-lamda * U.getUxh(d)))) {
				U.setbinaryUxh(d, 1);
			} else {
				U.setbinaryUxh(d, 0);
			}
		}
		
		for (int d = 0; d < Xtsize; d++) {
			U.setUxt(d, invid.getXt(d) + DE_Read_Write_txt.random_generate_or_read3(Execution_Mode) * Sigma);

			double rsid = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
			if (rsid < 1 / (1 + Math.exp(-lamda * U.getUxt(d)))) {
				U.setbinaryUxt(d, 1);
			} else {
				U.setbinaryUxt(d, 0);
			}
		}
		
		for (int d = 0; d < Ysize; d++) {
			U.setUy(d, invid.getY(d) + DE_Read_Write_txt.random_generate_or_read3(Execution_Mode) * Sigma);

			double rsid = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
			if (rsid < 1 / (1 + Math.exp(-lamda * U.getUy(d)))) {
				U.setbinaryUy(d, 1);
			} else {
				U.setbinaryUy(d, 0);
			}
		}

		return U;
	}

	static U_Individual Algorithm2(Individual indiv, V_Individual P_indiv) {

		U_Individual U = new U_Individual();
		for (int i = 0; i < Xasize; i++)
			U.setUxa(i, indiv.getXa(i));
		for (int i = 0; i < Xhsize; i++)
			U.setUxh(i, indiv.getXh(i));
		for (int i = 0; i < Xtsize; i++)
			U.setUxt(i, indiv.getXt(i));
		for (int i = 0; i < Ysize; i++)
			U.setUy(i, indiv.getY(i));
		
		int a = DE_Read_Write_txt.random_generate_or_read2(Execution_Mode, Xasize);
		for (int i = 0; i < Xasize; i++) {
			CR = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
			if (DE_Read_Write_txt.random_generate_or_read1(Execution_Mode) < CR || i == a)
				U.setUxa(i, P_indiv.getVxa(i));

			double rsid = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
			if (rsid < 1 / (1 + Math.exp(-lamda * U.getUxa(i)))) {
				U.setbinaryUxa(i, 1);
			} else {
				U.setbinaryUxa(i, 0);
			}
		}

		 a = DE_Read_Write_txt.random_generate_or_read2(Execution_Mode, Xhsize);
		for (int i = 0; i < Xhsize; i++) {
			CR = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
			if (DE_Read_Write_txt.random_generate_or_read1(Execution_Mode) < CR || i == a)
				U.setUxh(i, P_indiv.getVxh(i));

			double rsid = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
			if (rsid < 1 / (1 + Math.exp(-lamda * U.getUxh(i)))) {
				U.setbinaryUxh(i, 1);
			} else {
				U.setbinaryUxh(i, 0);
			}
		}
		
		 a = DE_Read_Write_txt.random_generate_or_read2(Execution_Mode, Xtsize);
		for (int i = 0; i < Xtsize; i++) {
			CR = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
			if (DE_Read_Write_txt.random_generate_or_read1(Execution_Mode) < CR || i == a)
				U.setUxt(i, P_indiv.getVxt(i));

			double rsid = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
			if (rsid < 1 / (1 + Math.exp(-lamda * U.getUxt(i)))) {
				U.setbinaryUxt(i, 1);
			} else {
				U.setbinaryUxt(i, 0);
			}
		}
		
		a = DE_Read_Write_txt.random_generate_or_read2(Execution_Mode, Ysize);
		for (int i = 0; i < Ysize; i++) {
			CR = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
			if (DE_Read_Write_txt.random_generate_or_read1(Execution_Mode) < CR || i == a)
				U.setUy(i, P_indiv.getVy(i));

			double rsid = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
			if (rsid < 1 / (1 + Math.exp(-lamda * U.getUy(i)))) {
				U.setbinaryUy(i, 1);
			} else {
				U.setbinaryUy(i, 0);
			}
		}

		return U;
	}

	static double calculateDistance(Plbest_Individual plbest_i, Plbest_Individual plbest_j)
	{
		double Sum = 0.0;
		for (int i = 0; i < plbest_i.Pxasize(); i++)
			Sum = Sum + Math.pow((plbest_i.getPxa(i) - plbest_j.getPxa(i)), 2.0);
		for (int i = 0; i < plbest_i.Pxhsize(); i++)
			Sum = Sum + Math.pow((plbest_i.getPxh(i) - plbest_j.getPxh(i)), 2.0);
		for (int i = 0; i < plbest_i.Pxtsize(); i++)
			Sum = Sum + Math.pow((plbest_i.getPxt(i) - plbest_j.getPxt(i)), 2.0);
		for (int i = 0; i < plbest_i.Pysize(); i++)
			Sum = Sum + Math.pow((plbest_i.getPy(i) - plbest_j.getPy(i)), 2.0);
		return Math.sqrt(Sum);
	}

}
