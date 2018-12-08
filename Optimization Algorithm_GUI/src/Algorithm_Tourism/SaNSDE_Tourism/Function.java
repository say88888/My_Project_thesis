package Algorithm_Tourism.SaNSDE_Tourism;

import java.util.ArrayList;

public class Function extends SaNSDE_Tourism {
	static V_Individual Algorithm1_1(double F, Individual individual_r1, Individual individual_r2, Individual individual_r3, Individual individual, Individual individual_b) {

		V_Individual V = new V_Individual();
		if (DE_Read_Write_txt.random_generate_or_read1(Execution_Mode) < p) {
			for (int i = 0; i < Xasize; i++)
				V.setVxa(i, individual_r1.getXa(i) + F * (individual_r2.getXa(i) - individual_r3.getXa(i)));
			for (int i = 0; i < Xhsize; i++)
				V.setVxh(i, individual_r1.getXh(i) + F * (individual_r2.getXh(i) - individual_r3.getXh(i)));
			for (int i = 0; i < Xtsize; i++)
				V.setVxt(i, individual_r1.getXt(i) + F * (individual_r2.getXt(i) - individual_r3.getXt(i)));
			for (int i = 0; i < Ysize; i++)
				V.setVy(i, individual_r1.getY(i) + F * (individual_r2.getY(i) - individual_r3.getY(i)));
			nf1 += 1;
			strategy.add(1);
		} else {
			for (int i = 0; i < Xasize; i++)
				V.setVxa(i, individual.getXa(i) + F * (individual_b.getXa(i) - individual.getXa(i)) 
						+ F * (individual_r1.getXa(i) - individual_r2.getXa(i)));
			for (int i = 0; i < Xhsize; i++)
				V.setVxh(i, individual.getXh(i) + F * (individual_b.getXh(i) - individual.getXh(i)) 
						+ F * (individual_r1.getXh(i) - individual_r2.getXh(i)));
			for (int i = 0; i < Xtsize; i++)
				V.setVxt(i, individual.getXt(i) + F * (individual_b.getXt(i) - individual.getXt(i)) 
						+ F * (individual_r1.getXt(i) - individual_r2.getXt(i)));
			for (int i = 0; i < Ysize; i++)
				V.setVy(i, individual.getY(i) + F * (individual_b.getY(i) - individual.getY(i)) 
						+ F * (individual_r1.getY(i) - individual_r2.getY(i)));
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
		p = (ns1 * (ns2 + nf2)) / (ns2 * (ns1 + nf1) + ns1 * (ns2 + nf2));

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

	static U_Individual Algorithm2(int j, Individual indiv, V_Individual P_indiv) {

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
		for (int i = 0; i < Xasize; i++)
			if (DE_Read_Write_txt.random_generate_or_read1(Execution_Mode) < CR[j] || i == a)
				U.setUxa(i, P_indiv.getVxa(i));
		a = DE_Read_Write_txt.random_generate_or_read2(Execution_Mode, Xhsize);
		for (int i = 0; i < Xhsize; i++)
			if (DE_Read_Write_txt.random_generate_or_read1(Execution_Mode) < CR[j]  || i == a)
				U.setUxh(i, P_indiv.getVxh(i));
		a = DE_Read_Write_txt.random_generate_or_read2(Execution_Mode, Xtsize);
		for (int i = 0; i < Xtsize; i++)
			if (DE_Read_Write_txt.random_generate_or_read1(Execution_Mode) < CR[j]  || i == a)
				U.setUxt(i, P_indiv.getVxt(i));
		a = DE_Read_Write_txt.random_generate_or_read2(Execution_Mode, Ysize);
		for (int i = 0; i < Ysize; i++)
			if (DE_Read_Write_txt.random_generate_or_read1(Execution_Mode) < CR[j]  || i == a)
				U.setUy(i, P_indiv.getVy(i));

		return U;
	}

}
