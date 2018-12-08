package Algorithm_Tourism.L_SHADE_Tourism;
 
public class Function extends L_SHADE_Tourism{
	static V_Individual Algorithm1_1(double F, Individual individual, Individual individual_r1
			, Individual individual_r2, Individual individual_pbest) {

		V_Individual V = new V_Individual();
		for (int d = 0; d < Xasize; d++) {
			V.setVxa(d, individual.getXa(d) + F * (individual_pbest.getXa(d) - individual.getXa(d))
					+ F * (individual_r1.getXa(d) - individual_r2.getXa(d)));
		}
		for (int d = 0; d < Xhsize; d++) {
			V.setVxh(d, individual.getXh(d) + F * (individual_pbest.getXh(d) - individual.getXh(d))
					+ F * (individual_r1.getXh(d) - individual_r2.getXh(d)));
		}
		for (int d = 0; d < Xtsize; d++) {
			V.setVxt(d, individual.getXt(d) + F * (individual_pbest.getXt(d) - individual.getXt(d))
					+ F * (individual_r1.getXt(d) - individual_r2.getXt(d)));
		}
		for (int d = 0; d < Ysize; d++) {
			V.setVy(d, individual.getY(d) + F * (individual_pbest.getY(d) - individual.getY(d))
					+ F * (individual_r1.getY(d) - individual_r2.getY(d)));
		}

		for (int i = 0; i < Xasize; i++) {
			if (V.getVxa(i) > Vmax)
				V.setVxa(i, (Vmax + individual.getXa(i)) / 2);
			if (V.getVxa(i) < -Vmax)
				V.setVxa(i, (-Vmax + individual.getXa(i)) / 2);
		}
		for (int i = 0; i < Xhsize; i++) {
			if (V.getVxh(i) > Vmax)
				V.setVxh(i, (Vmax + individual.getXh(i)) / 2);
			if (V.getVxh(i) < -Vmax)
				V.setVxh(i, (-Vmax + individual.getXh(i)) / 2);
		}
		for (int i = 0; i < Xtsize; i++) {
			if (V.getVxt(i) > Vmax)
				V.setVxt(i, (Vmax + individual.getXt(i)) / 2);
			if (V.getVxt(i) < -Vmax)
				V.setVxt(i, (-Vmax + individual.getXt(i)) / 2);
		}
		for (int i = 0; i < Ysize; i++) {
			if (V.getVy(i) > Vmax)
				V.setVy(i, (Vmax + individual.getY(i)) / 2);
			if (V.getVy(i) < -Vmax)
				V.setVy(i, (-Vmax + individual.getY(i)) / 2);
		}
		return V;
	}

	
	
	
	static void Update_MCR_MF() {

		if (SCR.size() > 0 && SF.size() > 0) {
			double totalsum = 0;
			double meanwSCR = 0;
			for (int i = 0; i < SCR.size(); i++)
				totalsum += ferc.get(i);
			for (int i = 0; i < SCR.size(); i++) {
				double w = ferc.get(i) / totalsum;
				meanwSCR += w * SCR.get(i);
			}
			MCR[k11] = meanwSCR;
			double totalSF1 = 0, totalSF2 = 0;
			for (int i = 0; i < SF.size(); i++) {
				double w = ferc.get(i) / totalsum;
				totalSF1 += w * Math.pow(SF.get(i), 2);
				totalSF2 += w * SF.get(i);
			}
			double meanwSF = totalSF1 / totalSF2;
			MF[k11] = meanwSF;
		}
		k11++;
		if (k11 >= H)
			k11 = 0;

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
			if (DE_Read_Write_txt.random_generate_or_read1(Execution_Mode) < CR[j] || i == a)
				U.setUxh(i, P_indiv.getVxh(i));
		 a = DE_Read_Write_txt.random_generate_or_read2(Execution_Mode, Xtsize);
		for (int i = 0; i < Xtsize; i++)
			if (DE_Read_Write_txt.random_generate_or_read1(Execution_Mode) < CR[j] || i == a)
				U.setUxt(i, P_indiv.getVxt(i));
		a = DE_Read_Write_txt.random_generate_or_read2(Execution_Mode, Ysize);
		for (int i = 0; i < Ysize; i++)
			if (DE_Read_Write_txt.random_generate_or_read1(Execution_Mode) < CR[j] || i == a)
				U.setUy(i, P_indiv.getVy(i));

		return U;
	}

	
	
	
	static boolean Update_NP( ) {
		boolean right=false;
		 
		int newpop = (int)((((Nmin - Ninit) / Max_NFE) * NFE + Ninit)); 
		if (newpop < populationSize) {
			populationSize = newpop;
			right=true;
		}
		if(populationSize<=Nmin)
			populationSize=Nmin;
		return right;
	}

}
