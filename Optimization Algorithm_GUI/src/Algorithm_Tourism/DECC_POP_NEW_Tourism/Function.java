package Algorithm_Tourism.DECC_POP_NEW_Tourism;

import java.util.ArrayList;

public class Function extends DECC_POP_NEW_Tourism {
	static V_Individual Algorithm1_1(int j, double F, Individual individual_r1, Individual individual_r2, Individual individual_r3, Individual individual, Individual individual_b) {

		V_Individual V = new V_Individual();
		if (DE_Read_Write_txt.random_generate_or_read1(Execution_Mode) < p) {
			for (int k = 0; k < n3.get(j).size(); k++) { // 根據分群來計算V
				if (n3.get(j).get(k) < Xasize) {
					int g = n3.get(j).get(k);
					V.setVxa(g, individual_r1.getXa(g) + F * (individual_r2.getXa(g) - individual_r3.getXa(g)));
				} else if (n3.get(j).get(k) < Xasize + Xhsize) {
					int g = n3.get(j).get(k) - Xasize;
					V.setVxh(g, individual_r1.getXh(g) + F * (individual_r2.getXh(g) - individual_r3.getXh(g)));
				} else if (n3.get(j).get(k) < Xasize + Xhsize + Xtsize) {
					int g = n3.get(j).get(k) - Xasize - Xhsize;
					V.setVxt(g, individual_r1.getXt(g) + F * (individual_r2.getXt(g) - individual_r3.getXt(g)));
				} else {
					int g = n3.get(j).get(k) - Xasize - Xhsize - Xtsize;
					V.setVy(g, individual_r1.getY(g) + F * (individual_r2.getY(g) - individual_r3.getY(g)));
				}
			}

			nf1 += 1;
			strategy.add(1);
		} else {
			for (int k = 0; k < n3.get(j).size(); k++) { // 根據分群來計算V
				if (n3.get(j).get(k) < Xasize) {
					int g = n3.get(j).get(k);
					V.setVxa(g, individual.getXa(g) + F * (individual_b.getXa(g) - individual.getXa(g)) + F * (individual_r1.getXa(g) - individual_r2.getXa(g)));
				} else if (n3.get(j).get(k) < Xasize + Xhsize) {
					int g = n3.get(j).get(k) - Xasize;
					V.setVxh(g, individual.getXh(g) + F * (individual_b.getXh(g) - individual.getXh(g)) + F * (individual_r1.getXh(g) - individual_r2.getXh(g)));
				} else if (n3.get(j).get(k) < Xasize + Xhsize + Xtsize) {
					int g = n3.get(j).get(k) - Xasize - Xhsize;
					V.setVxt(g, individual.getXt(g) + F * (individual_b.getXt(g) - individual.getXt(g)) + F * (individual_r1.getXt(g) - individual_r2.getXt(g)));
				} else {
					int g = n3.get(j).get(k) - Xasize - Xhsize - Xtsize;
					V.setVy(g, individual.getY(g) + F * (individual_b.getY(g) - individual.getY(g)) + F * (individual_r1.getY(g) - individual_r2.getY(g)));
				}
			}

			nf2 += 1;
			strategy.add(3);
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

	static void Update_p_f_cr() {

		// Update p、 f、cr
		p = (ns1 * (ns2 + nf2)) / (ns2 * (ns1 + nf1) + ns1 * (ns2 + nf2)); // 計算p

		// 計算CR
		for (int i = 0; i < populationSize; i++) {
			double sum = 0;
			for (int k = 0; k < frec.size(); k++)
				sum += frec.get(k);
			double sum1 = 0;
			for (int k = 0; k < CRrec.size(); k++) {
				double w = frec.get(k);
				w /= sum;
				sum1 += w * CRrec.get(k);
			}
			CRm = sum1;
			CR[i] = DE_Read_Write_txt.random_generate_or_read3(Execution_Mode) * 0.1 + CRm;

			// 計算F
			if (DE_Read_Write_txt.random_generate_or_read1(Execution_Mode) < p)
				F[i] = DE_Read_Write_txt.random_generate_or_read3(Execution_Mode) * 0.3 + 0.5;
			else
				F[i] = (Math.tan(Math.PI * (DE_Read_Write_txt.random_generate_or_read5(Execution_Mode) - 0.5)));
		}
		ns1 = 0;
		ns2 = 0;
		nf1 = 0;
		nf2 = 0;
		CRrec = new ArrayList<Double>();
		frec = new ArrayList<Double>();
	}

	static U_Individual Algorithm2(int i, int j, Individual indiv, V_Individual P_indiv) {

		U_Individual U = new U_Individual();

		for (int k = 0; k < n3.get(i).size(); k++) {
			if (n3.get(i).get(k) < Xasize) { // 根據分群來計算Ux
				int g = n3.get(i).get(k);
				if (DE_Read_Write_txt.random_generate_or_read1(Execution_Mode) < CR[j])
					U.setUxa(g, P_indiv.getVxa(g));
				else
					U.setUxa(g, indiv.getXa(g));
			} else if (n3.get(i).get(k) < Xasize + Xhsize) { // 根據分群來計算Ux
				int g = n3.get(i).get(k) - Xasize;
				if (DE_Read_Write_txt.random_generate_or_read1(Execution_Mode) < CR[j])
					U.setUxh(g, P_indiv.getVxh(g));
				else
					U.setUxh(g, indiv.getXh(g));
			} else if (n3.get(i).get(k) < Xasize + Xhsize + Xtsize) { // 根據分群來計算Ux
				int g = n3.get(i).get(k) - Xasize - Xhsize;
				if (DE_Read_Write_txt.random_generate_or_read1(Execution_Mode) < CR[j])
					U.setUxt(g, P_indiv.getVxt(g));
				else
					U.setUxt(g, indiv.getXt(g));
			} else { // 根據分群來計算Uxy
				int g = n3.get(i).get(k) - Xasize - Xhsize - Xtsize;
				if (DE_Read_Write_txt.random_generate_or_read1(Execution_Mode) < CR[j])
					U.setUy(g, P_indiv.getVy(g));
				else
					U.setUy(g, indiv.getY(g));
			}
		}

		return U;
	}

}
