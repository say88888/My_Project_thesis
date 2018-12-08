package Algorithm_DoubleAuction.L_SHADE_DA;

public class Function extends Double_Auction_L_SHADE {
	static V_Individual Algorithm1_1(double F, Individual individual, Individual individual_r1
			, Individual individual_r2, Individual individual_pbest) {

		V_Individual V = new V_Individual();
		for (int d = 0; d < Xsize; d++) {
			V.setVx(d, individual.getX(d) + F * (individual_pbest.getX(d) - individual.getX(d))
					+ F * (individual_r1.getX(d) - individual_r2.getX(d)));
		}
		for (int d = 0; d < Ysize; d++) {
			V.setVy(d, individual.getY(d) + F * (individual_pbest.getY(d) - individual.getY(d))
					+ F * (individual_r1.getY(d) - individual_r2.getY(d)));
		}

		for (int i = 0; i < Xsize; i++) {
			if (V.getVx(i) > Vmax)
				V.setVx(i, (Vmax + individual.getX(i)) / 2);
			if (V.getVx(i) < -Vmax)
				V.setVx(i, (-Vmax + individual.getX(i)) / 2);
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

		int a = DE_Read_Write_txt.random_generate_or_read2(Execution_Mode, Xsize);

		U_Individual U = new U_Individual();
		for (int i = 0; i < Xsize; i++)
			U.setUx(i, indiv.getX(i));
		for (int i = 0; i < Ysize; i++)
			U.setUy(i, indiv.getY(i));

		for (int i = 0; i < Xsize; i++)
			if (DE_Read_Write_txt.random_generate_or_read1(Execution_Mode) < CR[j] || i == a)
				U.setUx(i, P_indiv.getVx(i));

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
