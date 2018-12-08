package Algorithm_Tourism.DMSDL_PSO2_Tourism;

public class Function extends DMSDL_PSO2_Tourism {
	static Vim_Individual Algorithm1_1(double F, Plbest_Individual plbestinvid, P_Individual pinvid1, P_Individual pinvid2) {

		Vim_Individual V = new Vim_Individual();
		for (int i = 0; i < Xasize; i++)
			V.setVimxa(i, plbestinvid.getPxa(i) + F * (pinvid1.getPxa(i) - pinvid2.getPxa(i)));
		for (int i = 0; i < Xhsize; i++)
			V.setVimxh(i, plbestinvid.getPxh(i) + F * (pinvid1.getPxh(i) - pinvid2.getPxh(i)));
		for (int i = 0; i < Xtsize; i++)
			V.setVimxt(i, plbestinvid.getPxt(i) + F * (pinvid1.getPxt(i) - pinvid2.getPxt(i)));
		for (int i = 0; i < Ysize; i++)
			V.setVimy(i, plbestinvid.getPy(i) + F * (pinvid1.getPy(i) - pinvid2.getPy(i)));

		for (int i = 0; i < Xasize; i++) {
			if (V.getVimxa(i) > Vmax)
				V.setVimxa(i, Vmax);
			if (V.getVimxa(i) < -Vmax)
				V.setVimxa(i, -Vmax);
		}
		for (int i = 0; i < Xhsize; i++) {
			if (V.getVimxh(i) > Vmax)
				V.setVimxh(i, Vmax);
			if (V.getVimxh(i) < -Vmax)
				V.setVimxh(i, -Vmax);
		}
		for (int i = 0; i < Xtsize; i++) {
			if (V.getVimxt(i) > Vmax)
				V.setVimxt(i, Vmax);
			if (V.getVimxt(i) < -Vmax)
				V.setVimxt(i, -Vmax);
		}
		for (int i = 0; i < Ysize; i++) {
			if (V.getVimy(i) > Vmax)
				V.setVimy(i, Vmax);
			if (V.getVimy(i) < -Vmax)
				V.setVimy(i, -Vmax);
		}

		return V;
	}

	static U_Individual Algorithm2(int j, P_Individual P_indiv, Vim_Individual Vim_indiv) {

		U_Individual U = new U_Individual();
		int a = PSO_Read_Write_txt.random_generate_or_read5(Execution_Mode, Xasize);
		for (int i = 0; i < Xasize; i++)
			if (PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode) <= CR || i == a) {
				double rsid = PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode);
				if (rsid < 1 / (1 + Math.exp(-PSO_lamda * Vim_indiv.getVimxa(i)))) {
					U.setUxa(i, 1);
				}
				else {
					U.setUxa(i, 0);
				}
			} else {
				U.setUxa(i, P_indiv.getPxa(i));
			}
		a = PSO_Read_Write_txt.random_generate_or_read5(Execution_Mode, Xhsize);
		for (int i = 0; i < Xhsize; i++)
			if (PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode) <= CR || i == a) {
				double rsid = PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode);
				if (rsid < 1 / (1 + Math.exp(-PSO_lamda * Vim_indiv.getVimxh(i)))) {
					U.setUxh(i, 1);
				}
				else {
					U.setUxh(i, 0);
				}
			} else {
				U.setUxh(i, P_indiv.getPxh(i));
			}
		a = PSO_Read_Write_txt.random_generate_or_read5(Execution_Mode, Xtsize);
		for (int i = 0; i < Xtsize; i++)
			if (PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode) <= CR || i == a) {
				double rsid = PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode);
				if (rsid < 1 / (1 + Math.exp(-PSO_lamda * Vim_indiv.getVimxt(i)))) {
					U.setUxt(i, 1);
				}
				else {
					U.setUxt(i, 0);
				}
			} else {
				U.setUxt(i, P_indiv.getPxt(i));
			}
		a = PSO_Read_Write_txt.random_generate_or_read5(Execution_Mode, Ysize);
		for (int i = 0; i < Ysize; i++)
			if (PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode) <= CR || i == a) {
				double rsid = PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode);
				if (rsid < 1 / (1 + Math.exp(-PSO_lamda * Vim_indiv.getVimy(i)))) {
					U.setUy(i, 1);
				}
				else {
					U.setUy(i, 0);
				}
			} else {
				U.setUy(i, P_indiv.getPy(i));
			}

		return U;
	}

	public static GV_Individual Algorithm3(U_Individual newGinvid, P_Individual pinvid) {
		// TODO Auto-generated method stub
		GV_Individual GV = new GV_Individual();

		if (newGinvid.getFitness1() > pinvid.getFitness()) {
			for (int d = 0; d < newGinvid.Uxasize(); d++)
				GV.setGVxa(d, newGinvid.getUxa(d));
			for (int d = 0; d < newGinvid.Uxhsize(); d++)
				GV.setGVxh(d, newGinvid.getUxh(d));
			for (int d = 0; d < newGinvid.Uxtsize(); d++)
				GV.setGVxt(d, newGinvid.getUxt(d));
			for (int d = 0; d < newGinvid.Uysize(); d++)
				GV.setGVy(d, newGinvid.getUy(d));
		} else {
			for (int d = 0; d < pinvid.Pxasize(); d++)
				GV.setGVxa(d, pinvid.getPxa(d));
			for (int d = 0; d < pinvid.Pxhsize(); d++)
				GV.setGVxh(d, pinvid.getPxh(d));
			for (int d = 0; d < pinvid.Pxtsize(); d++)
				GV.setGVxt(d, pinvid.getPxt(d));
			for (int d = 0; d < pinvid.Pysize(); d++)
				GV.setGVy(d, pinvid.getPy(d));
		}

		return GV;
	}

}
