package Algorithm_Carpool.DynDE_AB_2Si_ApproachI;


public class Function extends DynDE_AB_2Si_ApproachI {
	
	private static double[] x;
	private static double[] y;
	
	static V_Individual Differential_Evolution(int strategy, Individual ind, Individual ind_r1, Individual ind_r2, Individual ind_r3, Individual ind_r4, Individual ind_r5, Individual ind_b) {

		V_Individual V = new V_Individual();
		switch (strategy) {
		case 0:
			for (int i = 0; i < Xsize; i++) {
				F = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
				V.setVx(i, ind_r1.getX(i) + (ind_r2.getX(i) - ind_r3.getX(i)) * (DE_Read_Write_txt.random_generate_or_read3(Execution_Mode) * 0.5 + 0.5));
			}
			for (int i = 0; i < Ysize; i++) {
				F = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
				V.setVy(i, ind_r1.getY(i) + (ind_r2.getY(i) - ind_r3.getY(i)) * (DE_Read_Write_txt.random_generate_or_read3(Execution_Mode) * 0.5 + 0.5));
			}
			break;
		case 1:
			for (int i = 0; i < Xsize; i++) {
				F = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
				V.setVx(i, ind_b.getX(i) + F * (ind_r2.getX(i) - ind_r3.getX(i)));
			}
			for (int i = 0; i < Ysize; i++) {
				F = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
				V.setVy(i, ind_b.getY(i) + F * (ind_r2.getY(i) - ind_r3.getY(i)));
			}
			break;
		case 2:
			for (int i = 0; i < Xsize; i++) {
				F = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
				V.setVx(i, ind_r1.getX(i) + F * (ind_r2.getX(i) - ind_r3.getX(i)) + F * (ind_r4.getX(i) - ind_r5.getX(i)));
			}
			for (int i = 0; i < Ysize; i++) {
				F = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
				V.setVy(i, ind_r1.getY(i) + F * (ind_r2.getY(i) - ind_r3.getY(i)) + F * (ind_r4.getY(i) - ind_r5.getY(i)));
			}
			break;
		case 3:
			for (int i = 0; i < Xsize; i++) {
				F = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
				V.setVx(i, ind_b.getX(i) + F * (ind_r1.getX(i) - ind_r2.getX(i)) + F * (ind_r3.getX(i) - ind_r4.getX(i)));
			}
			for (int i = 0; i < Ysize; i++) {
				F = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
				V.setVy(i, ind_b.getY(i) + F * (ind_r1.getY(i) - ind_r2.getY(i)) + F * (ind_r3.getY(i) - ind_r4.getY(i)));
			}
			break;
		case 4:
			for (int i = 0; i < Xsize; i++) {
				F = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
				V.setVx(i, ind.getX(i) + F * (ind_b.getX(i) - ind.getX(i)) + F * (ind_r1.getX(i) - ind_r2.getX(i)));
			}
			for (int i = 0; i < Ysize; i++) {
				F = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
				V.setVy(i, ind.getY(i) + F * (ind_b.getY(i) - ind.getY(i)) + F * (ind_r1.getY(i) - ind_r2.getY(i)));
			}
			break;
		default:
			for (int i = 0; i < Xsize; i++) {
				F = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
				V.setVx(i, ind.getX(i) + F * (ind_b.getX(i) - ind.getX(i)) + F * (ind_r1.getX(i) - ind_r2.getX(i)) + F * (ind_r3.getX(i) - ind_r4.getX(i)));
			}
			for (int i = 0; i < Ysize; i++) {
				F = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
				V.setVy(i, ind.getY(i) + F * (ind_b.getY(i) - ind.getY(i)) + F * (ind_r1.getY(i) - ind_r2.getY(i)) + F * (ind_r3.getY(i) - ind_r4.getY(i)));
			}
		}

		for (int i = 0; i < Xsize; i++) {
			if (V.getVx(i) > Vmax)
				V.setVx(i, Vmax);
			if (V.getVx(i) < -Vmax)
				V.setVx(i, -Vmax);
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
		x=new double[P];
		y=new double[2*P];
		double dist = 0;
		double[] X = new double[Xsize];
		for (int d = 0; d < Xsize; d++) {
			X[d] = DE_Read_Write_txt.random_generate_or_read3(Execution_Mode);
			dist += Math.pow(X[d], 2.0);
		}
		dist = Math.sqrt(dist);
		for (int d = 0; d < Xsize; d++) {
			double r = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode) * rcloud;
			U.setUx(d, G_invid.getGx(d) + ((r * X[d]) / dist));
			if (U.getUx(d) > Vmax)
				U.setUx(d, Vmax);
			if (U.getUx(d) < -Vmax)
				U.setUx(d, -Vmax);
			x[d]=U.getUx(d);
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
			if (U.getUy(d) > Vmax)
				U.setUy(d, Vmax);
			if (U.getUy(d) < -Vmax)
				U.setUy(d, -Vmax);
			y[d]=U.getUy(d);
		}

		Convert_Function.main(x,y);
		
		for(int d=0;d<U.UAsize();d++)
			U.setUA(d, Convert_Function.getA(d));
		for(int d=0;d<U.UBsize();d++)
			U.setUB(d, Convert_Function.getB(d));
		
		for(int d=0;d<U.binaryUxsize();d++)
			U.setbinaryUx(d, Convert_Function.getbinaryX(d));
		for(int d=0;d<U.binaryUysize();d++)
			U.setbinaryUy(d, Convert_Function.getbinaryY(d));
		
		
		return U;
	}

	static U_Individual Brownian(G_Individual G_invid) {

		U_Individual U = new U_Individual();
		x=new double[P];
		y=new double[2*P];
		for (int d = 0; d < Xsize; d++) {
			U.setUx(d, G_invid.getGx(d) + DE_Read_Write_txt.random_generate_or_read3(Execution_Mode) * Sigma);
			if (U.getUx(d) > Vmax)
				U.setUx(d, Vmax);
			if (U.getUx(d) < -Vmax)
				U.setUx(d, -Vmax);
			x[d]=U.getUx(d);
		}

		for (int d = 0; d < Ysize; d++) {
			U.setUy(d, G_invid.getGy(d) + DE_Read_Write_txt.random_generate_or_read3(Execution_Mode) * Sigma);
			if (U.getUy(d) > Vmax)
				U.setUy(d, Vmax);
			if (U.getUy(d) < -Vmax)
				U.setUy(d, -Vmax);
			y[d]=U.getUy(d);
		}
		
		Convert_Function.main(x,y);
		
		for(int d=0;d<U.UAsize();d++)
			U.setUA(d, Convert_Function.getA(d));
		for(int d=0;d<U.UBsize();d++)
			U.setUB(d, Convert_Function.getB(d));
		
		for(int d=0;d<U.binaryUxsize();d++)
			U.setbinaryUx(d, Convert_Function.getbinaryX(d));
		for(int d=0;d<U.binaryUysize();d++)
			U.setbinaryUy(d, Convert_Function.getbinaryY(d));
		
		return U;
	}

	static U_Individual Entropy_Differential_Evolution(Individual invid) {

		U_Individual U = new U_Individual();
		x=new double[P];
		y=new double[2*P];
		for (int d = 0; d < invid.Xsize(); d++) {
			U.setUx(d, invid.getX(d) + DE_Read_Write_txt.random_generate_or_read3(Execution_Mode) * Sigma);
			if (U.getUx(d) > Vmax)
				U.setUx(d, Vmax);
			if (U.getUx(d) < -Vmax)
				U.setUx(d, -Vmax);
			x[d]=U.getUx(d);
		}

		for (int d = 0; d < invid.Ysize(); d++) {
			U.setUy(d, invid.getY(d) + DE_Read_Write_txt.random_generate_or_read3(Execution_Mode) * Sigma);
			if (U.getUy(d) > Vmax)
				U.setUy(d, Vmax);
			if (U.getUy(d) < -Vmax)
				U.setUy(d, -Vmax);
			y[d]=U.getUy(d);
		}
		
		Convert_Function.main(x,y);
		
		for(int d=0;d<U.UAsize();d++)
			U.setUA(d, Convert_Function.getA(d));
		for(int d=0;d<U.UBsize();d++)
			U.setUB(d, Convert_Function.getB(d));
		
		for(int d=0;d<U.binaryUxsize();d++)
			U.setbinaryUx(d, Convert_Function.getbinaryX(d));
		for(int d=0;d<U.binaryUysize();d++)
			U.setbinaryUy(d, Convert_Function.getbinaryY(d));
		
		return U;
	}

	static U_Individual Algorithm2(Individual indiv, V_Individual P_indiv) {

		int a = DE_Read_Write_txt.random_generate_or_read2(Execution_Mode, Xsize);

		U_Individual U = new U_Individual();
		x=new double[P];
		y=new double[2*P];
		for (int i = 0; i < Xsize; i++)
			U.setUx(i, indiv.getX(i));
		for (int i = 0; i < Ysize; i++)
			U.setUy(i, indiv.getY(i));

		for (int i = 0; i < Xsize; i++) {
			CR = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
			if (DE_Read_Write_txt.random_generate_or_read1(Execution_Mode) < CR || i == a) {
				U.setUx(i, P_indiv.getVx(i));
				x[i]=U.getUx(i);
			}
		}

		a = DE_Read_Write_txt.random_generate_or_read2(Execution_Mode, Ysize);
		for (int i = 0; i < Ysize; i++) {
			CR = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
			if (DE_Read_Write_txt.random_generate_or_read1(Execution_Mode) < CR || i == a) {
				U.setUy(i, P_indiv.getVy(i));
				y[i]=U.getUy(i);
			}
		}
		Convert_Function.main(x,y);
		
		for(int d=0;d<U.UAsize();d++)
			U.setUA(d, Convert_Function.getA(d));
		for(int d=0;d<U.UBsize();d++)
			U.setUB(d, Convert_Function.getB(d));
		
		for(int d=0;d<U.binaryUxsize();d++)
			U.setbinaryUx(d, Convert_Function.getbinaryX(d));
		for(int d=0;d<U.binaryUysize();d++)
			U.setbinaryUy(d, Convert_Function.getbinaryY(d));
		
		return U;
	}

	static double calculateDistance(Plbest_Individual plbest_i, Plbest_Individual plbest_j)
	{
		double Sum = 0.0;
		for (int i = 0; i < plbest_i.Pxsize(); i++)
			Sum = Sum + Math.pow((plbest_i.getPx(i) - plbest_j.getPx(i)), 2.0);
		for (int i = 0; i < plbest_i.Pysize(); i++)
			Sum = Sum + Math.pow((plbest_i.getPy(i) - plbest_j.getPy(i)), 2.0);
		return Math.sqrt(Sum);
	}

}
