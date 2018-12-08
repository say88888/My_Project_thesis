package Algorithm_Carpool.DMSDL_PSO2_AB_2Si_ApproachII;

public class Algorithm extends DMSDL_PSO2_AB_2Si_ApproachII {

	private static double[] x;
	private static double[] y;
	// Evolve a population 演變人口
	public static Population evolvePopulation(Population pop) {
		Population newPopulation = new Population(pop.size(), false);

		for (int i = 0; i < pop.size(); i++) {
			Individual invid = pop.getIndividual(i);
			P_Individual Pinvid = pop.getP_Individual(i);

			if (invid.getFitness() > Pinvid.getFitness()) {
				for (int d = 0; d < invid.Xsize(); d++)
					Pinvid.setPx(d, invid.getX(d));
				for (int d = 0; d < invid.Ysize(); d++)
					Pinvid.setPy(d, invid.getY(d));
			
				for (int d = 0; d < invid.Asize(); d++)
					Pinvid.setPA(d, invid.getA(d));
				for (int d = 0; d < invid.Bsize(); d++)
					Pinvid.setPB(d, invid.getB(d));
				
				for (int d = 0; d < invid.binaryXsize(); d++)
					Pinvid.setbinaryPx(d, invid.getbinaryX(d));
				for (int d = 0; d < invid.binaryYsize(); d++)
					Pinvid.setbinaryPy(d, invid.getbinaryY(d));
			}
			newPopulation.saveP_Individual(i, Pinvid);
		}

		for (int i = 0; i < pop.size(); i++) {
			Plbest_Individual Plbestinvid1 = pop.getPlbest_Individual(i);
			P_Individual Pinvid1 = pop.getP_Individual(i);
			if (Pinvid1.getFitness() > Plbestinvid1.getFitness()) {
				for (int d = 0; d < Plbestinvid1.Pxsize(); d++)
					Plbestinvid1.setPx(d, Pinvid1.getPx(d));
				for (int d = 0; d < Plbestinvid1.Pysize(); d++)
					Plbestinvid1.setPy(d, Pinvid1.getPy(d));
				
				for (int d = 0; d < Pinvid1.PAsize(); d++)
					Plbestinvid1.setPA(d, Pinvid1.getPA(d));
				for (int d = 0; d < Pinvid1.PBsize(); d++)
					Plbestinvid1.setPB(d, Pinvid1.getPB(d));
				
				for (int d = 0; d < Pinvid1.binaryPxsize(); d++)
					Plbestinvid1.setbinaryPx(d, Pinvid1.getbinaryPx(d));
				for (int d = 0; d < Pinvid1.binaryPysize(); d++)
					Plbestinvid1.setbinaryPy(d, Pinvid1.getbinaryPy(d));
				
			}
			newPopulation.savePlbest_Individual(i, Plbestinvid1);
		}
		for (int i = 0; i < n3.size(); i++)
			for (int j = 0; j < n3.get(i).size(); j++)
				for (int k = 0; k < n3.get(i).size(); k++) {
					Plbest_Individual Plbestinvid1 = pop.getPlbest_Individual(n3.get(i).get(j));
					Plbest_Individual Plbestinvid2 = pop.getPlbest_Individual(n3.get(i).get(k));
					if (Plbestinvid2.getFitness() > Plbestinvid1.getFitness()) {
						for (int d = 0; d < Plbestinvid1.Pxsize(); d++)
							Plbestinvid1.setPx(d, Plbestinvid2.getPx(d));
						for (int d = 0; d < Plbestinvid1.Pysize(); d++)
							Plbestinvid1.setPy(d, Plbestinvid2.getPy(d));
						
						for (int d = 0; d < Plbestinvid1.PAsize(); d++)
							Plbestinvid1.setPA(d, Plbestinvid2.getPA(d));
						for (int d = 0; d < Plbestinvid1.PBsize(); d++)
							Plbestinvid1.setPB(d, Plbestinvid2.getPB(d));
						
						for (int d = 0; d < Plbestinvid1.binaryPxsize(); d++)
							Plbestinvid1.setbinaryPx(d, Plbestinvid2.getbinaryPx(d));
						for (int d = 0; d < Plbestinvid1.binaryPysize(); d++)
							Plbestinvid1.setbinaryPy(d, Plbestinvid2.getbinaryPy(d));
						
					}
					newPopulation.savePlbest_Individual(n3.get(i).get(j), Plbestinvid1);
				}

		for (int i = 0; i < pop.size(); i++) {
			Plbest_Individual Plbestinvid1 = pop.getPlbest_Individual(i);
			G_Individual Ginvid1 = pop.getG_Individual();
			if (Plbestinvid1.getFitness() > Ginvid1.getFitness1()) {
				for (int d = 0; d < Plbestinvid1.Pxsize(); d++)
					Ginvid1.setGx(d, Plbestinvid1.getPx(d));
				for (int d = 0; d < Plbestinvid1.Pysize(); d++)
					Ginvid1.setGy(d, Plbestinvid1.getPy(d));
				
				for (int d = 0; d < Plbestinvid1.PAsize(); d++)
					Ginvid1.setGA(d, Plbestinvid1.getPA(d));
				for (int d = 0; d < Plbestinvid1.PBsize(); d++)
					Ginvid1.setGB(d, Plbestinvid1.getPB(d));
				
				for (int d = 0; d < Plbestinvid1.binaryPxsize(); d++)
					Ginvid1.setbinaryGx(d, Plbestinvid1.getbinaryPx(d));
				for (int d = 0; d < Plbestinvid1.binaryPysize(); d++)
					Ginvid1.setbinaryGy(d, Plbestinvid1.getbinaryPy(d));
				
			}
			newPopulation.saveG_Individual(Ginvid1);
		}

		 
		for (int i = 0; i < pop.size(); i++) {
			int r1 = 0, r2 = 0;
			while (r1 == i || r2 == i || r1 == r2) {// 取r1,r2,r3,r4
				r1 = PSO_Read_Write_txt.random_generate_or_read5(Execution_Mode,populationSize);
				r2 = PSO_Read_Write_txt.random_generate_or_read5(Execution_Mode,populationSize);
			}

			Plbest_Individual Plbestinvid = pop.getPlbest_Individual(i);
			P_Individual Pinvid1 = pop.getP_Individual(r1);
			P_Individual Pinvid2 = pop.getP_Individual(r2);
			Vim_Individual newViminvid=new Vim_Individual();
			
			newViminvid =Function.Algorithm1_1(F, Plbestinvid, Pinvid1, Pinvid2);
			
			//交叉U
			P_Individual Pinvid = pop.getP_Individual(i);
			U_Individual newGinvid=new U_Individual();
			newGinvid=Function.Algorithm2(i, Pinvid, newViminvid);
		//	newPopulation.saveU_Individual(i, newGinvid);
			
			GV_Individual newGVinvid=new GV_Individual();
			newGVinvid=Function.Algorithm3(newGinvid,Pinvid);
			newPopulation.saveGV_Individual(i, newGVinvid);
			
		}
		
		for (int i = 0; i < pop.size(); i++) {
			Individual invid = pop.getIndividual(i);
			GV_Individual GVinvid=pop.getGV_Individual(i);

			double r1 = PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode);
			for (int d = 0; d < invid.Xsize(); d++) {
				invid.setX(d, w * invid.getX(d) + (c1 * r1 * (GVinvid.getGVx(d) - invid.getX(d))) );
				if (invid.getX(d) > Vmax)
					invid.setX(d, Vmax);
				if (invid.getX(d) < -Vmax)
					invid.setX(d, -Vmax);
			}

			for (int d = 0; d < invid.Ysize(); d++) {
				invid.setY(d, w * invid.getY(d) + (c1 * r1 * (GVinvid.getGVy(d) - invid.getY(d))) );
				if (invid.getY(d) > Vmax)
					invid.setY(d, Vmax);
				if (invid.getY(d) < -Vmax)
					invid.setY(d, -Vmax);
			}
			
			//------------取得 x 與 y 的A、B 字串--------------------
			x=new double[P];
			y=new double[2*P];
			for (int d = 0; d < invid.Xsize(); d++)
				x[d]=invid.getX(d);
			for (int d = 0; d < invid.Ysize(); d++)
				y[d]=invid.getY(d);
			
			Convert_Function.main(x,y);
			for(int d=0;d<P;d++){
				invid.setA(d,Convert_Function.getA(d));
			}
			for(int d=0;d<(P*2);d++){
				invid.setB(d,Convert_Function.getB(d));
			}
			for(int d=0;d<D;d++) {
				invid.setbinaryX(d,Convert_Function.getbinaryX(d));
			}
			for(int d=0;d<P;d++) {
				invid.setbinaryY(d,Convert_Function.getbinaryY(d));
			}
			
			newPopulation.saveIndividual(i, invid);
		}

		return newPopulation;
	}

	public static Population evolvePopulationafter(Population pop) {
		Population newPopulation = new Population(pop.size(), false);
		for (int i = 0; i < pop.size(); i++) {
			 
			Plbest_Individual Plbest_invid = pop.getPlbest_Individual(i);
			newPopulation.savePlbest_Individual(i, Plbest_invid);
		//	GV_Individual GVinvid =pop.getGV_Individual(i);
		//	newPopulation.saveGV_Individual(i, GVinvid);
		}
		for (int i = 0; i < pop.size(); i++) {

			Individual invid = pop.getIndividual(i);
			P_Individual Pinvid = pop.getP_Individual(i);

			if (invid.getFitness() > Pinvid.getFitness()) {
				for (int d = 0; d < invid.Xsize(); d++)
					Pinvid.setPx(d, invid.getX(d));
				for (int d = 0; d < invid.Ysize(); d++)
					Pinvid.setPy(d, invid.getY(d));
				
				for (int d = 0; d < invid.Asize(); d++)
					Pinvid.setPA(d, invid.getA(d));
				for (int d = 0; d < invid.Bsize(); d++)
					Pinvid.setPB(d, invid.getB(d));
				
				for (int d = 0; d < invid.binaryXsize(); d++)
					Pinvid.setPx(d, invid.getbinaryX(d));
				for (int d = 0; d < invid.binaryYsize(); d++)
					Pinvid.setPy(d, invid.getbinaryY(d));
			}

			newPopulation.saveP_Individual(i, Pinvid);
		}

		for (int j = 0; j < pop.size(); j++) {
			G_Individual Ginvid = pop.getG_Individual();
			P_Individual Pinvid1 = pop.getP_Individual(j);

			if (Pinvid1.getFitness() > Ginvid.getFitness1()) {
				for (int d = 0; d < Ginvid.Gxsize(); d++)
					Ginvid.setGx(d, Pinvid1.getPx(d));
				for (int d = 0; d < Ginvid.Gysize(); d++)
					Ginvid.setGy(d, Pinvid1.getPy(d));
				
				for (int d = 0; d < Ginvid.GAsize(); d++)
					Ginvid.setGA(d, Pinvid1.getPA(d));
				for (int d = 0; d < Ginvid.GAsize(); d++)
					Ginvid.setGB(d, Pinvid1.getPB(d));
				
				for (int d = 0; d < Ginvid.binaryGxsize(); d++)
					Ginvid.setbinaryGx(d, Pinvid1.getbinaryPx(d));
				for (int d = 0; d < Ginvid.binaryGysize(); d++)
					Ginvid.setbinaryGy(d, Pinvid1.getbinaryPy(d));
			}

			newPopulation.saveG_Individual(Ginvid);
		}

		for (int i = 0; i < pop.size(); i++) {
			Individual invid = pop.getIndividual(i);
		
			P_Individual Pinvid = pop.getP_Individual(i);
			G_Individual Ginvid = pop.getG_Individual();
			double r1 = PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode);
			double r2 = PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode);

			for (int d = 0; d < invid.Xsize(); d++) {

				invid.setX(d, w * invid.getX(d) + (c1 * r1 * (Pinvid.getPx(d) - invid.getX(d))) + c2 * r2 * (Ginvid.getGx(d) - invid.getX(d)));
				if (invid.getX(d) > Vmax)
					invid.setX(d, Vmax);
				if (invid.getX(d) < -Vmax)
					invid.setX(d, -Vmax);
			}

			for (int d = 0; d < invid.Ysize(); d++) {

				invid.setY(d, w * invid.getY(d) + (c1 * r1 * (Pinvid.getPy(d) - invid.getY(d))) + c2 * r2 * (Ginvid.getGy(d) - invid.getY(d)));
				if (invid.getY(d) > Vmax)
					invid.setY(d, Vmax);
				if (invid.getY(d) < -Vmax)
					invid.setY(d, -Vmax);
			}
			
			//------------取得 x 與 y 的A、B 字串--------------------
			x=new double[P];
			y=new double[2*P];
			for (int d = 0; d < invid.Xsize(); d++)
				x[d]=invid.getX(d);
			for (int d = 0; d < invid.Ysize(); d++)
				y[d]=invid.getY(d);
			
			Convert_Function.main(x,y);
			for(int d=0;d<P;d++){
				invid.setA(d,Convert_Function.getA(d));
			}
			for(int d=0;d<(P*2);d++){
				invid.setB(d,Convert_Function.getB(d));
			}
			for(int d=0;d<D;d++) {
				invid.setbinaryX(d,Convert_Function.getbinaryX(d));
			}
			for(int d=0;d<P;d++) {
				invid.setbinaryY(d,Convert_Function.getbinaryY(d));
			}
			
			newPopulation.saveIndividual(i, invid);
		}
		return newPopulation;
	}

	public static Population UpdataPlbest(Population pop) {
		Population newPopulation = new Population(pop.size(), false);
		G_Individual Ginvid = pop.getG_Individual();
		newPopulation.saveG_Individual(Ginvid);
		for (int i = 0; i < pop.size(); i++) {
			Individual invid = pop.getIndividual(i);
			newPopulation.saveIndividual(i, invid);
			Plbest_Individual Plbest_invid = pop.getPlbest_Individual(i);
			newPopulation.savePlbest_Individual(i, Plbest_invid);
			GV_Individual GVinvid =pop.getGV_Individual(i);
			newPopulation.saveGV_Individual(i, GVinvid);
		}
 

		int[] num = new int[pop.size()];
		int temp; // 用來交換元素的暫存變數
		for (int i = 0; i < pop.size(); i++)
			num[i] = i;

		Plbest_Individual Plbestinvid = new Plbest_Individual();
		for (int i = 0; i < pop.size() - 1; i++)
			for (int j = 0; j < pop.size() - 1 - i; j++) {
				Plbest_Individual Plbest1 = pop.getPlbest_Individual(j);
				Plbest_Individual Plbest2 = pop.getPlbest_Individual(j + 1);
				// 第i輪比對到倒數第i+1個元素
				// ↓裡做這修改就可以了
				if (Plbest1.getFitness() < Plbest2.getFitness()) {
					Plbestinvid = Plbest1;
					Plbest1 = Plbest2;
					Plbest2 = Plbestinvid;

					temp = num[j];
					num[j] = num[j + 1];
					num[j + 1] = temp;
				}
			}

		int Nsize = (int) (pop.size() * 0.25);

		for (int i = 0; i < pop.size(); i++) {
			P_Individual Pinvid1 = pop.getP_Individual(i);
			for (int j = 0; j < Nsize; j++) {
				if (i == num[j]) {
					P_Individual Pinvid = pop.getP_Individual(num[j]);
					Plbest_Individual Pblestinvid = pop.getPlbest_Individual(num[i]);
					for (int d = 0; d < Pinvid.Pxsize(); d++) {
						Pinvid1.setPx(d, Pinvid.getPx(d)+PSO_Read_Write_txt.random_generate_or_read3(Execution_Mode) * Math.abs(Pblestinvid.getPx(d) - Pinvid.getPx(d)));
						if (Pinvid1.getPx(d) > Vmax)
							Pinvid1.setPx(d, Vmax);
						if (Pinvid1.getPx(d) < -Vmax)
							Pinvid1.setPx(d, -Vmax);
					}

					for (int d = 0; d < Pinvid.Pysize(); d++) {
						Pinvid1.setPy(d,Pinvid.getPy(d)+ PSO_Read_Write_txt.random_generate_or_read3(Execution_Mode) * Math.abs(Pblestinvid.getPy(d) - Pinvid.getPy(d)));
						if (Pinvid1.getPy(d) > Vmax)
							Pinvid1.setPy(d, Vmax);
						if (Pinvid1.getPy(d) < -Vmax)
							Pinvid1.setPy(d, -Vmax);
					}
					
				}
			}
			
			x=new double[P];
			y=new double[2*P];
			
			for (int d = 0; d < Pinvid1.Pxsize(); d++)
				x[d]=Pinvid1.getPx(d);
			for (int d = 0; d < Pinvid1.Pysize(); d++)
				y[d]=Pinvid1.getPy(d);
				
			Convert_Function.main(x,y);
			
			for(int d=0;d<Pinvid1.PAsize();d++)
				Pinvid1.setPA(d, Convert_Function.getA(d));
			for(int d=0;d<Pinvid1.PBsize();d++)
				Pinvid1.setPB(d, Convert_Function.getB(d));
			
			for(int d=0;d<Pinvid1.binaryPxsize();d++)
				Pinvid1.setbinaryPx(d, Convert_Function.getbinaryX(d));
			for(int d=0;d<Pinvid1.binaryPysize();d++)
				Pinvid1.setbinaryPy(d, Convert_Function.getbinaryY(d));
			
			newPopulation.saveP_Individual(i, Pinvid1);
		}
		return newPopulation;
	}

}
