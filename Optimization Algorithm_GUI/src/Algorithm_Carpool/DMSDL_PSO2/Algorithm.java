package Algorithm_Carpool.DMSDL_PSO2;
 
public class Algorithm extends DMSDL_PSO2 {

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
			V_Individual Vinvid = pop.getV_Individual(i);
			GV_Individual GVinvid=pop.getGV_Individual(i);

			double r1 = PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode);
			for (int d = 0; d < Vinvid.Vxsize(); d++) {
				Vinvid.setVx(d, w * Vinvid.getVx(d) + (c1 * r1 * (GVinvid.getGVx(d) - invid.getX(d))) );
				if (Vinvid.getVx(d) > Vmax)
					Vinvid.setVx(d, Vmax);
				if (Vinvid.getVx(d) < -Vmax)
					Vinvid.setVx(d, -Vmax);

			}

			for (int d = 0; d < Vinvid.Vysize(); d++) {
				Vinvid.setVy(d, w * Vinvid.getVy(d) + (c1 * r1 * (GVinvid.getGVy(d) - invid.getY(d))) );
				if (Vinvid.getVy(d) > Vmax)
					Vinvid.setVy(d, Vmax);
				if (Vinvid.getVy(d) < -Vmax)
					Vinvid.setVy(d, -Vmax);
			}
			newPopulation.saveV_Individual(i, Vinvid);
		}

		for (int i = 0; i < pop.size(); i++) {
			Individual invid = pop.getIndividual(i);
			V_Individual Vinvid = pop.getV_Individual(i);

			for (int d = 0; d < invid.Xsize(); d++) {
				double rsid = PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode);
				if (rsid < 1 / (1 + Math.exp(-PSO_lamda * Vinvid.getVx(d)))) {
					invid.setX(d, 1);
				}
				else {
					invid.setX(d, 0);
				}
			}
			for (int d = 0; d < invid.Ysize(); d++) {
				double rsid = PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode);
				if (rsid < 1 / (1 + Math.exp(-PSO_lamda * Vinvid.getVy(d)))) {
					invid.setY(d, 1);
				}
				else {
					invid.setY(d, 0);
				}

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
			}

			newPopulation.saveG_Individual(Ginvid);
		}

		for (int i = 0; i < pop.size(); i++) {
			Individual invid = pop.getIndividual(i);
			V_Individual Vinvid = pop.getV_Individual(i);
			P_Individual Pinvid = pop.getP_Individual(i);
			G_Individual Ginvid = pop.getG_Individual();
			double r1 = PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode);
			double r2 = PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode);

			for (int d = 0; d < Vinvid.Vxsize(); d++) {

				Vinvid.setVx(d, w * Vinvid.getVx(d) + (c1 * r1 * (Pinvid.getPx(d) - invid.getX(d))) + c2 * r2 * (Ginvid.getGx(d) - invid.getX(d)));
				if (Vinvid.getVx(d) > Vmax)
					Vinvid.setVx(d, Vmax);
				if (Vinvid.getVx(d) < -Vmax)
					Vinvid.setVx(d, -Vmax);

			}

			for (int d = 0; d < Vinvid.Vysize(); d++) {

				Vinvid.setVy(d, w * Vinvid.getVy(d) + (c1 * r1 * (Pinvid.getPy(d) - invid.getY(d))) + c2 * r2 * (Ginvid.getGy(d) - invid.getY(d)));
				if (Vinvid.getVy(d) > Vmax)
					Vinvid.setVy(d, Vmax);
				if (Vinvid.getVy(d) < -Vmax)
					Vinvid.setVy(d, -Vmax);

			}
			newPopulation.saveV_Individual(i, Vinvid);
		}

		for (int i = 0; i < pop.size(); i++) {
			Individual invid = pop.getIndividual(i);
			V_Individual Vinvid = pop.getV_Individual(i);

			for (int d = 0; d < invid.Xsize(); d++) {
				double rsid = PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode);

				if (rsid < 1 / (1 + Math.exp(-PSO_lamda * Vinvid.getVx(d)))) {

					invid.setX(d, 1);
				}
				else {

					invid.setX(d, 0);
				}

			}
			for (int d = 0; d < invid.Ysize(); d++) {
				double rsid = PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode);

				if (rsid < 1 / (1 + Math.exp(-PSO_lamda * Vinvid.getVy(d)))) {

					invid.setY(d, 1);
				}
				else {

					invid.setY(d, 0);
				}

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
			V_Individual Vinvid = pop.getV_Individual(i);
			for (int j = 0; j < Nsize; j++) {
				if (i == num[j]) {
					P_Individual Pinvid = pop.getP_Individual(num[j]);
					Plbest_Individual Pblestinvid = pop.getPlbest_Individual(num[i]);
					for (int d = 0; d < Vinvid.Vxsize(); d++) {
						Vinvid.setVx(d, Pinvid.getPx(d)+PSO_Read_Write_txt.random_generate_or_read3(Execution_Mode) * Math.abs(Pblestinvid.getPx(d) - Pinvid.getPx(d)));
						if (Vinvid.getVx(d) > Vmax)
							Vinvid.setVx(d, Vmax);
						if (Vinvid.getVx(d) < -Vmax)
							Vinvid.setVx(d, -Vmax);
					}

					for (int d = 0; d < Vinvid.Vysize(); d++) {
						Vinvid.setVy(d,Pinvid.getPy(d)+ PSO_Read_Write_txt.random_generate_or_read3(Execution_Mode) * Math.abs(Pblestinvid.getPy(d) - Pinvid.getPy(d)));
						if (Vinvid.getVy(d) > Vmax)
							Vinvid.setVy(d, Vmax);
						if (Vinvid.getVy(d) < -Vmax)
							Vinvid.setVy(d, -Vmax);
					}
				}
			}
			newPopulation.saveV_Individual(i, Vinvid);
		}

		for (int i = 0; i < pop.size(); i++) {
			P_Individual Pinvid1 = pop.getP_Individual(i);
			for (int j = 0; j < Nsize; j++) {
				if (i == num[j]) {
					V_Individual Vinvid = pop.getV_Individual(num[j]);
					P_Individual Pinvid =new P_Individual();

					for (int d = 0; d < Pinvid.Pxsize(); d++) {
						double rsid = PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode);
						if (rsid < 1 / (1 + Math.exp(-PSO_lamda * Vinvid.getVx(d)))) {
							Pinvid.setPx(d, 1);
						}
						else {
							Pinvid.setPx(d, 0);
						}
					}
					for (int d = 0; d < Pinvid.Pysize(); d++) {
						double rsid = PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode);
						if (rsid < 1 / (1 + Math.exp(-PSO_lamda * Vinvid.getVy(d)))) {
							Pinvid.setPy(d, 1);
						}
						else {
							Pinvid.setPy(d, 0);
						}
					}
					if (Pinvid.getFitness() > Pinvid1.getFitness()) {
						for (int d = 0; d < Pinvid.Pxsize(); d++)
							Pinvid1.setPx(d, Pinvid.getPx(d));
						for (int d = 0; d < Pinvid.Pysize(); d++)
							Pinvid1.setPy(d, Pinvid.getPy(d));
		//				L_right=true;
					}
				}

			}
			newPopulation.saveP_Individual(i, Pinvid1);
		}

		return newPopulation;
	}

}
