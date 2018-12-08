package Algorithm_Tourism.NSDE_Tourism;

public class Function extends NSDE_Tourism {
	static V_Individual Algorithm1_1(double F, Individual individual_r1, Individual individual_r2, Individual individual_r3) {

		V_Individual V = new V_Individual();
		if (DE_Read_Write_txt.random_generate_or_read1(Execution_Mode) < 0.5) {
			for (int i = 0; i < Xasize; i++)
				V.setVxa(i, individual_r1.getXa(i) + (individual_r2.getXa(i) - individual_r3.getXa(i))
						* (DE_Read_Write_txt.random_generate_or_read3(Execution_Mode) * 0.5 + 0.5));
			for (int i = 0; i < Xhsize; i++)
				V.setVxh(i, individual_r1.getXh(i) + (individual_r2.getXh(i) - individual_r3.getXh(i))
						* (DE_Read_Write_txt.random_generate_or_read3(Execution_Mode) * 0.5 + 0.5));
			for (int i = 0; i < Xtsize; i++)
				V.setVxt(i, individual_r1.getXt(i) + (individual_r2.getXt(i) - individual_r3.getXt(i))
						* (DE_Read_Write_txt.random_generate_or_read3(Execution_Mode) * 0.5 + 0.5));
			for (int i = 0; i < Ysize; i++)
				V.setVy(i, individual_r1.getY(i) + (individual_r2.getY(i) - individual_r3.getY(i))
						* (DE_Read_Write_txt.random_generate_or_read3(Execution_Mode) * 0.5 + 0.5));
		}
		else {
			for (int i = 0; i < Xasize; i++)
				V.setVxa(i, individual_r1.getXa(i) + (individual_r2.getXa(i) - individual_r3.getXa(i))
						* (Math.tan(Math.PI * (DE_Read_Write_txt.random_generate_or_read5(Execution_Mode) - 0.5))));
			for (int i = 0; i < Xhsize; i++)
				V.setVxh(i, individual_r1.getXh(i) + (individual_r2.getXh(i) - individual_r3.getXh(i))
						* (Math.tan(Math.PI * (DE_Read_Write_txt.random_generate_or_read5(Execution_Mode) - 0.5))));
			for (int i = 0; i < Xtsize; i++)
				V.setVxt(i, individual_r1.getXt(i) + (individual_r2.getXt(i) - individual_r3.getXt(i))
						* (Math.tan(Math.PI * (DE_Read_Write_txt.random_generate_or_read5(Execution_Mode) - 0.5))));
			for (int i = 0; i < Ysize; i++)
				V.setVy(i, individual_r1.getY(i) + (individual_r2.getY(i) - individual_r3.getY(i))
						* (Math.tan(Math.PI * (DE_Read_Write_txt.random_generate_or_read5(Execution_Mode) - 0.5))));
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
			if (DE_Read_Write_txt.random_generate_or_read1(Execution_Mode) < CR || i == a)
				U.setUxa(i, P_indiv.getVxa(i));
		a = DE_Read_Write_txt.random_generate_or_read2(Execution_Mode, Xhsize);
		for (int i = 0; i < Xhsize; i++)
			if (DE_Read_Write_txt.random_generate_or_read1(Execution_Mode) < CR || i == a)
				U.setUxh(i, P_indiv.getVxh(i));
		a = DE_Read_Write_txt.random_generate_or_read2(Execution_Mode, Xtsize);
		for (int i = 0; i < Xtsize; i++)
			if (DE_Read_Write_txt.random_generate_or_read1(Execution_Mode) < CR || i == a)
				U.setUxt(i, P_indiv.getVxt(i));
		a = DE_Read_Write_txt.random_generate_or_read2(Execution_Mode, Ysize);
		for (int i = 0; i < Ysize; i++)
			if (DE_Read_Write_txt.random_generate_or_read1(Execution_Mode) < CR || i == a)
				U.setUy(i, P_indiv.getVy(i));
		
		
		return U;
	}

}
