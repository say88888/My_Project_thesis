package Algorithm_Tourism.NLPSO2_Tourism;
 
public class Algorithm extends NLPSO2_Tourism {

	// Evolve a population 演變人口
	public static Population evolvePopulation(Population pop) {
		Population newPopulation = new Population(pop.size(), false);
		
		newPopulation=evolvePopulation_Algorithm3(pop);
		
		for (int i = 0; i < pop.size(); i++) {
			Individual invid = pop.getIndividual(i);
			P_Individual Pinvid = pop.getP_Individual(i);

			if (invid.getFitness() > Pinvid.getFitness()) {
				for (int d = 0; d < invid.Xasize(); d++)
					Pinvid.setPxa(d, invid.getXa(d));
				for (int d = 0; d < invid.Xhsize(); d++)
					Pinvid.setPxh(d, invid.getXh(d));
				for (int d = 0; d < invid.Xtsize(); d++)
					Pinvid.setPxt(d, invid.getXt(d));
				for (int d = 0; d < invid.Ysize(); d++)
					Pinvid.setPy(d, invid.getY(d));
			}
			newPopulation.saveP_Individual(i, Pinvid);
		}

		for (int i = 0; i < n3.size(); i++) {
			Plbest_Individual Plbestinvid1 = pop.getPlbest_Individual(i);
			Pworst_Individual Pworstinvid1 = pop.getPworst_Individual(i);
			for (int j = 0; j < n3.get(i).size(); j++) {
				P_Individual Pinvid1 = pop.getP_Individual(n3.get(i).get(j));
				V_Individual Vinid =pop.getV_Individual(n3.get(i).get(j));
				if (Pinvid1.getFitness() > Plbestinvid1.getFitness()) {
					for (int d = 0; d < Plbestinvid1.Pxasize(); d++){
						Plbestinvid1.setbinaryPxa(d, Pinvid1.getPxa(d));
						Plbestinvid1.setPxa(d, Vinid.getVxa(d));
					}
					for (int d = 0; d < Plbestinvid1.Pxhsize(); d++){
						Plbestinvid1.setbinaryPxh(d, Pinvid1.getPxh(d));
						Plbestinvid1.setPxh(d, Vinid.getVxh(d));
					}
					for (int d = 0; d < Plbestinvid1.Pxtsize(); d++){
						Plbestinvid1.setbinaryPxt(d, Pinvid1.getPxt(d));
						Plbestinvid1.setPxt(d, Vinid.getVxt(d));
					}
					for (int d = 0; d < Plbestinvid1.Pysize(); d++){
						Plbestinvid1.setbinaryPy(d, Pinvid1.getPy(d));
						Plbestinvid1.setPy(d, Vinid.getVy(d));
					}
					
				}
				if (Pinvid1.getFitness() < Pworstinvid1.getFitness()) {
					for (int d = 0; d < Pworstinvid1.Pxasize(); d++)
						Pworstinvid1.setPxa(d, Pinvid1.getPxa(d));
					for (int d = 0; d < Pworstinvid1.Pxhsize(); d++)
						Pworstinvid1.setPxh(d, Pinvid1.getPxh(d));
					for (int d = 0; d < Pworstinvid1.Pxtsize(); d++)
						Pworstinvid1.setPxt(d, Pinvid1.getPxt(d));
					for (int d = 0; d < Pworstinvid1.Pysize(); d++)
						Pworstinvid1.setPy(d, Pinvid1.getPy(d));
				}

			}
			newPopulation.savePlbest_Individual(i, Plbestinvid1);
			newPopulation.savePworst_Individual(i, Pworstinvid1);
		}

		for (int i = 0; i < n3.size(); i++) {
			Plbest_Individual Plbestinvid1 = pop.getPlbest_Individual(i);
			G_Individual Ginvid1 = pop.getG_Individual();
			if (Plbestinvid1.getFitness() > Ginvid1.getFitness1()) {
				for (int d = 0; d < Plbestinvid1.Pxasize(); d++)
					Ginvid1.setGxa(d, Plbestinvid1.getbinaryPxa(d));
				for (int d = 0; d < Plbestinvid1.Pxhsize(); d++)
					Ginvid1.setGxh(d, Plbestinvid1.getbinaryPxh(d));
				for (int d = 0; d < Plbestinvid1.Pxtsize(); d++)
					Ginvid1.setGxt(d, Plbestinvid1.getbinaryPxt(d));
				for (int d = 0; d < Plbestinvid1.Pysize(); d++)
					Ginvid1.setGy(d, Plbestinvid1.getbinaryPy(d));
			}
			newPopulation.saveG_Individual(Ginvid1);
		}
		
		for (int i = 0; i < n3.size(); i++) {
			Plbest_Individual Plbestinvid1 = pop.getPlbest_Individual(i);
			Pworst_Individual Pworstinvid1 = pop.getPworst_Individual(i);
			for (int j = 0; j < n3.get(i).size(); j++) {

				int k = n3.get(i).get(0);
				while (k == n3.get(i).get(j)) {// 取r1,r2,r3,r4
					k = n3.get(i).get(PSO_Read_Write_txt.random_generate_or_read5(Execution_Mode, n3.get(i).size()));
				}
				V_Individual Vinvid = pop.getV_Individual(n3.get(i).get(j));
				Individual invid = pop.getIndividual(n3.get(i).get(j));
				Individual invid_K = pop.getIndividual(k);

				for (int d = 0; d < Vinvid.Vxasize(); d++) {
					double r1 = PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode);
					if (r1 < prand) {
						double r2 = PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode);
						Vinvid.setVxa(d, w * Vinvid.getVxa(d) + (F * (invid_K.getXa(d) - invid.getXa(d)) + (c1 * r2 * (Plbestinvid1.getbinaryPxa(d) - invid.getXa(d)))));
						if (Vinvid.getVxa(d) > Vmax)
							Vinvid.setVxa(d, Vmax);
						if (Vinvid.getVxa(d) < -Vmax)
							Vinvid.setVxa(d, -Vmax);
					}
				}
				for (int d = 0; d < Vinvid.Vxhsize(); d++) {
					double r1 = PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode);
					if (r1 < prand) {
						double r2 = PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode);
						Vinvid.setVxh(d, w * Vinvid.getVxh(d) + (F * (invid_K.getXh(d) - invid.getXh(d)) + (c1 * r2 * (Plbestinvid1.getbinaryPxh(d) - invid.getXh(d)))));
						if (Vinvid.getVxh(d) > Vmax)
							Vinvid.setVxh(d, Vmax);
						if (Vinvid.getVxh(d) < -Vmax)
							Vinvid.setVxh(d, -Vmax);
					}
				}
				for (int d = 0; d < Vinvid.Vxtsize(); d++) {
					double r1 = PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode);
					if (r1 < prand) {
						double r2 = PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode);
						Vinvid.setVxt(d, w * Vinvid.getVxt(d) + (F * (invid_K.getXt(d) - invid.getXt(d)) + (c1 * r2 * (Plbestinvid1.getbinaryPxt(d) - invid.getXt(d)))));
						if (Vinvid.getVxt(d) > Vmax)
							Vinvid.setVxt(d, Vmax);
						if (Vinvid.getVxt(d) < -Vmax)
							Vinvid.setVxt(d, -Vmax);
					}
				}
				for (int d = 0; d < Vinvid.Vysize(); d++) {
					double r1 = PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode);
					if (r1 < prand) {
						double r2 = PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode);
						Vinvid.setVy(d, w * Vinvid.getVy(d) + (F * (invid_K.getY(d) - invid.getY(d)) + (c1 * r2 * (Plbestinvid1.getbinaryPy(d) - invid.getY(d)))));
						if (Vinvid.getVy(d) > Vmax)
							Vinvid.setVy(d, Vmax);
						if (Vinvid.getVy(d) < -Vmax)
							Vinvid.setVy(d, -Vmax);
					}
				}

				U_Individual Uinvid = new U_Individual();
				for (int d = 0; d < Uinvid.Uxasize(); d++) {
					Uinvid.setUxa(d, invid.getXa(d) + Vinvid.getVxa(d));
					double rsid = PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode);
					if (rsid < 1 / (1 + Math.exp(-PSO_lamda * Uinvid.getUxa(d)))) {
						Uinvid.setbinaryUxa(d, 1);
					} else {
						Uinvid.setbinaryUxa(d, 0);
					}
				}
				for (int d = 0; d < Uinvid.Uxhsize(); d++) {
					Uinvid.setUxh(d, invid.getXh(d) + Vinvid.getVxh(d));
					double rsid = PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode);
					if (rsid < 1 / (1 + Math.exp(-PSO_lamda * Uinvid.getUxh(d)))) {
						Uinvid.setbinaryUxh(d, 1);
					} else {
						Uinvid.setbinaryUxh(d, 0);
					}
				}
				for (int d = 0; d < Uinvid.Uxtsize(); d++) {
					Uinvid.setUxt(d, invid.getXt(d) + Vinvid.getVxt(d));
					double rsid = PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode);
					if (rsid < 1 / (1 + Math.exp(-PSO_lamda * Uinvid.getUxt(d)))) {
						Uinvid.setbinaryUxt(d, 1);
					} else {
						Uinvid.setbinaryUxt(d, 0);
					}
				}
				for (int d = 0; d < Uinvid.Uysize(); d++) {
					Uinvid.setUy(d, invid.getY(d) + Vinvid.getVy(d));
					double rsid = PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode);
					if (rsid < 1 / (1 + Math.exp(-PSO_lamda * Uinvid.getUy(d)))) {
						Uinvid.setbinaryUy(d, 1);
					} else {
						Uinvid.setbinaryUy(d, 0);
					}
				}

				if (Uinvid.getFitness1() > Plbestinvid1.getFitness()) {
					for (int d = 0; d < Uinvid.Uxasize(); d++)
						Plbestinvid1.setPxa(d, Uinvid.getbinaryUxa(d));
					for (int d = 0; d < Uinvid.Uxhsize(); d++)
						Plbestinvid1.setPxh(d, Uinvid.getbinaryUxh(d));
					for (int d = 0; d < Uinvid.Uxtsize(); d++)
						Plbestinvid1.setPxt(d, Uinvid.getbinaryUxt(d));
					for (int d = 0; d < Uinvid.Uysize(); d++)
						Plbestinvid1.setPy(d, Uinvid.getbinaryUy(d));
				}

				int worst = n3.get(i).get(0);
				double worst_fittest = pop.getIndividual(n3.get(i).get(0)).getFitness();
				for (int w = 0; w < n3.get(i).size(); w++) {
					Individual invid_n = pop.getIndividual(n3.get(i).get(w));
					if (invid_n.getFitness() < worst_fittest) {
						worst_fittest = invid_n.getFitness();
						worst = n3.get(i).get(w);
					}
				}
				Individual invid_worst = pop.getIndividual(worst);
				if (Uinvid.getFitness1() > invid_worst.getFitness()) {
					for (int d = 0; d < Uinvid.Uxasize(); d++)
						invid_worst.setXa(d, Uinvid.getbinaryUxa(d));
					for (int d = 0; d < Uinvid.Uxhsize(); d++)
						invid_worst.setXh(d, Uinvid.getbinaryUxh(d));
					for (int d = 0; d < Uinvid.Uxtsize(); d++)
						invid_worst.setXt(d, Uinvid.getbinaryUxt(d));
					for (int d = 0; d < Uinvid.Uysize(); d++)
						invid_worst.setY(d, Uinvid.getbinaryUy(d));
				}
				SM_Individual SM_invid = pop.getSM_Individual(n3.get(i).get(j));
				if ((Uinvid.getFitness1() - Pworstinvid1.getFitness()) / (Plbestinvid1.getFitness() - Pworstinvid1.getFitness()) <= Rfu
						&& (Uinvid.getFitness1() - Pworstinvid1.getFitness()) / (Plbestinvid1.getFitness() - Pworstinvid1.getFitness()) >= Rfl) {

					for (int d = 0; d < Uinvid.Uxasize(); d++)
						SM_invid.setSMxa(d, Uinvid.getUxa(d));
					for (int d = 0; d < Uinvid.Uxhsize(); d++)
						SM_invid.setSMxh(d, Uinvid.getUxh(d));
					for (int d = 0; d < Uinvid.Uxtsize(); d++)
						SM_invid.setSMxt(d, Uinvid.getUxt(d));
					for (int d = 0; d < Uinvid.Uysize(); d++)
						SM_invid.setSMy(d, Uinvid.getUy(d));
				}
				newPopulation.saveSM_Individual(n3.get(i).get(j), SM_invid);
				newPopulation.saveIndividual(worst, invid_worst);
				newPopulation.saveV_Individual(n3.get(i).get(j), Vinvid);
				
			}
			newPopulation.savePlbest_Individual(i, Plbestinvid1);
		}
		for(int i=0;i<pop.size();i++){
				Individual invid =pop.getIndividual(i);
				newPopulation.saveIndividual(i, invid);
		}
		for (int i = 0; i < n3.size(); i++) {
			Plbest_Individual Plbestinvid1 = pop.getPlbest_Individual(i);
			G_Individual Ginvid1 = pop.getG_Individual();
			if (Plbestinvid1.getFitness() > Ginvid1.getFitness1()) {
				for (int d = 0; d < Plbestinvid1.Pxasize(); d++)
					Ginvid1.setGxa(d, Plbestinvid1.getbinaryPxa(d));
				for (int d = 0; d < Plbestinvid1.Pxhsize(); d++)
					Ginvid1.setGxh(d, Plbestinvid1.getbinaryPxh(d));
				for (int d = 0; d < Plbestinvid1.Pxtsize(); d++)
					Ginvid1.setGxt(d, Plbestinvid1.getbinaryPxt(d));
				for (int d = 0; d < Plbestinvid1.Pysize(); d++)
					Ginvid1.setGy(d, Plbestinvid1.getbinaryPy(d));
			}
			newPopulation.saveG_Individual(Ginvid1);
		}
		

		return newPopulation;
	}

	public static Population evolvePopulation_Algorithm2(Population pop) {
		Population newPopulation = new Population(pop.size(), false);

		
		U_Individual U_invid =pop.getU_Individual();
		newPopulation.saveU_Individual(  U_invid);
		for(int i=0;i<pop.size();i++){
	
			SM_Individual SM_invid = pop.getSM_Individual(i);
			newPopulation.saveSM_Individual(i, SM_invid);
		}
		for(int i=0;i<n3.size();i++){
			LM_Individual LM_invid=pop.getLM_Individual(i);
			newPopulation.saveLM_Individual(i, LM_invid);
		}
		
		for (int i = 0; i < n3.size(); i++) {
			for (int j = 0; j < (int) (n3.get(i).size() * psm); j++) {
				V_Individual V_invid = pop.getV_Individual(n3.get(i).get(j));
				SM_Individual SM_invid = pop.getSM_Individual(n3.get(i).get(j));
				for (int d = 0; d < V_invid.Vxasize(); d++) {
					V_invid.setVxa(d, SM_invid.getSMxa(d));
					if (V_invid.getVxa(d) > Vmax)
						V_invid.setVxa(d, Vmax);
					if (V_invid.getVxa(d) < -Vmax)
						V_invid.setVxa(d, -Vmax);
				}
				for (int d = 0; d < V_invid.Vxhsize(); d++) {
					V_invid.setVxh(d, SM_invid.getSMxh(d));
					if (V_invid.getVxh(d) > Vmax)
						V_invid.setVxh(d, Vmax);
					if (V_invid.getVxh(d) < -Vmax)
						V_invid.setVxh(d, -Vmax);
				}
				for (int d = 0; d < V_invid.Vxtsize(); d++) {
					V_invid.setVxt(d, SM_invid.getSMxt(d));
					if (V_invid.getVxt(d) > Vmax)
						V_invid.setVxt(d, Vmax);
					if (V_invid.getVxt(d) < -Vmax)
						V_invid.setVxt(d, -Vmax);
				}
				for (int d = 0; d < V_invid.Vysize(); d++) {
					V_invid.setVy(d, SM_invid.getSMy(d));
					if (V_invid.getVy(d) > Vmax)
						V_invid.setVy(d, Vmax);
					if (V_invid.getVy(d) < -Vmax)
						V_invid.setVy(d, -Vmax);
				}
				newPopulation.saveV_Individual(n3.get(i).get(j), V_invid);
				 
			}

			LM_Individual LM_invid = pop.getLM_Individual(i);
			V_Individual V_invid = pop.getV_Individual(n3.get(i).get((int) (n3.get(i).size() * psm)));
			for (int d = 0; d < V_invid.Vxasize(); d++) {
				V_invid.setVxa(d, LM_invid.getLMxa(d));
				if (V_invid.getVxa(d) > Vmax)
					V_invid.setVxa(d, Vmax);
				if (V_invid.getVxa(d) < -Vmax)
					V_invid.setVxa(d, -Vmax);
			}
			for (int d = 0; d < V_invid.Vxhsize(); d++) {
				V_invid.setVxh(d, LM_invid.getLMxh(d));
				if (V_invid.getVxh(d) > Vmax)
					V_invid.setVxh(d, Vmax);
				if (V_invid.getVxh(d) < -Vmax)
					V_invid.setVxh(d, -Vmax);
			}
			for (int d = 0; d < V_invid.Vxtsize(); d++) {
				V_invid.setVxt(d, LM_invid.getLMxt(d));
				if (V_invid.getVxt(d) > Vmax)
					V_invid.setVxt(d, Vmax);
				if (V_invid.getVxt(d) < -Vmax)
					V_invid.setVxt(d, -Vmax);
			}
			for (int d = 0; d < V_invid.Vysize(); d++) {
				V_invid.setVy(d, LM_invid.getLMy(d));
				if (V_invid.getVy(d) > Vmax)
					V_invid.setVy(d, Vmax);
				if (V_invid.getVy(d) < -Vmax)
					V_invid.setVy(d, -Vmax);
			}
			newPopulation.saveV_Individual(n3.get(i).get((int) (n3.get(i).size() * psm)), V_invid);
			 
			V_Individual V_invid1 = pop.getV_Individual(n3.get(i).get((int) (n3.get(i).size() * psm) + 1));
			for (int d = 0; d < V_invid1.Vxasize(); d++) {
				V_invid1.setVxa(d, LM_invid.getLMxa(d) + PSO_Read_Write_txt.random_generate_or_read3(Execution_Mode));
				if (V_invid1.getVxa(d) > Vmax)
					V_invid1.setVxa(d, Vmax);
				if (V_invid1.getVxa(d) < -Vmax)
					V_invid1.setVxa(d, -Vmax);
			}
			for (int d = 0; d < V_invid1.Vxhsize(); d++) {
				V_invid1.setVxh(d, LM_invid.getLMxh(d) + PSO_Read_Write_txt.random_generate_or_read3(Execution_Mode));
				if (V_invid1.getVxh(d) > Vmax)
					V_invid1.setVxh(d, Vmax);
				if (V_invid1.getVxh(d) < -Vmax)
					V_invid1.setVxh(d, -Vmax);
			}
			for (int d = 0; d < V_invid1.Vxtsize(); d++) {
				V_invid1.setVxt(d, LM_invid.getLMxt(d) + PSO_Read_Write_txt.random_generate_or_read3(Execution_Mode));
				if (V_invid1.getVxt(d) > Vmax)
					V_invid1.setVxt(d, Vmax);
				if (V_invid1.getVxt(d) < -Vmax)
					V_invid1.setVxt(d, -Vmax);
			}
			for (int d = 0; d < V_invid1.Vysize(); d++) {
				V_invid1.setVy(d, LM_invid.getLMy(d) + PSO_Read_Write_txt.random_generate_or_read3(Execution_Mode));
				if (V_invid1.getVy(d) > Vmax)
					V_invid1.setVy(d, Vmax);
				if (V_invid1.getVy(d) < -Vmax)
					V_invid1.setVy(d, -Vmax);
			}
			newPopulation.saveV_Individual(n3.get(i).get((int) (n3.get(i).size() * psm) + 1), V_invid1);
			 
			for (int j = (int) (n3.get(i).size() * psm + 2); j < n3.get(i).size(); j++) {
		
				V_Individual V_invid2 = pop.getV_Individual(n3.get(i).get(j));
				for (int d = 0; d < V_invid2.Vxasize(); d++) {
					V_invid2.setVxa(d, Vmax + (2 * Vmax) * PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode));
					if (V_invid2.getVxa(d) > Vmax)
						V_invid2.setVxa(d, Vmax);
					if (V_invid2.getVxa(d) < -Vmax)
						V_invid2.setVxa(d, -Vmax);
				}
				for (int d = 0; d < V_invid2.Vxhsize(); d++) {
					V_invid2.setVxh(d, Vmax + (2 * Vmax) * PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode));
					if (V_invid2.getVxh(d) > Vmax)
						V_invid2.setVxh(d, Vmax);
					if (V_invid2.getVxh(d) < -Vmax)
						V_invid2.setVxh(d, -Vmax);
				}
				for (int d = 0; d < V_invid2.Vxtsize(); d++) {
					V_invid2.setVxt(d, Vmax + (2 * Vmax) * PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode));
					if (V_invid2.getVxt(d) > Vmax)
						V_invid2.setVxt(d, Vmax);
					if (V_invid2.getVxt(d) < -Vmax)
						V_invid2.setVxt(d, -Vmax);
				}
				for (int d = 0; d < V_invid2.Vysize(); d++) {
					V_invid2.setVy(d, Vmax + (2 * Vmax) * PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode));
					if (V_invid2.getVy(d) > Vmax)
						V_invid2.setVy(d, Vmax);
					if (V_invid2.getVy(d) < -Vmax)
						V_invid2.setVy(d, -Vmax);
				}
				newPopulation.saveV_Individual(n3.get(i).get(j), V_invid2);
				 
			}
		}

		for (int i = 0; i < pop.size(); i++) {
			Individual invid = pop.getIndividual(i);
			V_Individual Vinvid = pop.getV_Individual(i);
			for (int d = 0; d < invid.Xasize(); d++) {
				double rsid = PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode);
				if (rsid < 1 / (1 + Math.exp(-PSO_lamda * Vinvid.getVxa(d)))) {
					invid.setXa(d, 1);
				} else {
					invid.setXa(d, 0);
				}
			}
			for (int d = 0; d < invid.Xhsize(); d++) {
				double rsid = PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode);
				if (rsid < 1 / (1 + Math.exp(-PSO_lamda * Vinvid.getVxh(d)))) {
					invid.setXh(d, 1);
				} else {
					invid.setXh(d, 0);
				}
			}
			for (int d = 0; d < invid.Xtsize(); d++) {
				double rsid = PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode);
				if (rsid < 1 / (1 + Math.exp(-PSO_lamda * Vinvid.getVxt(d)))) {
					invid.setXt(d, 1);
				} else {
					invid.setXt(d, 0);
				}
			}
			for (int d = 0; d < invid.Ysize(); d++) {
				double rsid = PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode);
				if (rsid < 1 / (1 + Math.exp(-PSO_lamda * Vinvid.getVy(d)))) {
					invid.setY(d, 1);
				} else {
					invid.setY(d, 0);
				}

			}
			newPopulation.saveIndividual(i, invid);
		}
		for (int i = 0; i < pop.size(); i++) {
			Individual invid = pop.getIndividual(i);
			P_Individual Pinvid = pop.getP_Individual(i);

			if (invid.getFitness() > Pinvid.getFitness()) {
				for (int d = 0; d < invid.Xasize(); d++)
					Pinvid.setPxa(d, invid.getXa(d));
				for (int d = 0; d < invid.Xhsize(); d++)
					Pinvid.setPxh(d, invid.getXh(d));
				for (int d = 0; d < invid.Xtsize(); d++)
					Pinvid.setPxt(d, invid.getXt(d));
				for (int d = 0; d < invid.Ysize(); d++)
					Pinvid.setPy(d, invid.getY(d));
			}
			newPopulation.saveP_Individual(i, Pinvid);
		}

		for (int i = 0; i < n3.size(); i++) {
			Plbest_Individual Plbestinvid1 = pop.getPlbest_Individual(i);
			Pworst_Individual Pworstinvid1 = pop.getPworst_Individual(i);
			for (int j = 0; j < n3.get(i).size(); j++) {
				P_Individual Pinvid1 = pop.getP_Individual(n3.get(i).get(j));
				V_Individual Vinid =pop.getV_Individual(n3.get(i).get(j));
				if (Pinvid1.getFitness() > Plbestinvid1.getFitness()) {
					for (int d = 0; d < Plbestinvid1.Pxasize(); d++){
						Plbestinvid1.setbinaryPxa(d, Pinvid1.getPxa(d));
						Plbestinvid1.setPxa(d, Vinid.getVxa(d));
					}
					for (int d = 0; d < Plbestinvid1.Pxhsize(); d++){
						Plbestinvid1.setbinaryPxh(d, Pinvid1.getPxh(d));
						Plbestinvid1.setPxh(d, Vinid.getVxh(d));
					}
					for (int d = 0; d < Plbestinvid1.Pxtsize(); d++){
						Plbestinvid1.setbinaryPxt(d, Pinvid1.getPxt(d));
						Plbestinvid1.setPxt(d, Vinid.getVxt(d));
					}
					for (int d = 0; d < Plbestinvid1.Pysize(); d++){
						Plbestinvid1.setbinaryPy(d, Pinvid1.getPy(d));
						Plbestinvid1.setPy(d, Vinid.getVy(d));
					}
					
				}
				if (Pinvid1.getFitness() < Pworstinvid1.getFitness()) {
					for (int d = 0; d < Pworstinvid1.Pxasize(); d++)
						Pworstinvid1.setPxa(d, Pinvid1.getPxa(d));
					for (int d = 0; d < Pworstinvid1.Pxhsize(); d++)
						Pworstinvid1.setPxh(d, Pinvid1.getPxh(d));
					for (int d = 0; d < Pworstinvid1.Pxtsize(); d++)
						Pworstinvid1.setPxt(d, Pinvid1.getPxt(d));
					for (int d = 0; d < Pworstinvid1.Pysize(); d++)
						Pworstinvid1.setPy(d, Pinvid1.getPy(d));
				}

			}
			newPopulation.savePlbest_Individual(i, Plbestinvid1);
			newPopulation.savePworst_Individual(i, Pworstinvid1);
		}

		for (int i = 0; i < n3.size(); i++) {
			Plbest_Individual Plbestinvid1 = pop.getPlbest_Individual(i);
			G_Individual Ginvid1 = pop.getG_Individual();
			if (Plbestinvid1.getFitness() > Ginvid1.getFitness1()) {
				for (int d = 0; d < Plbestinvid1.Pxasize(); d++)
					Ginvid1.setGxa(d, Plbestinvid1.getbinaryPxa(d));
				for (int d = 0; d < Plbestinvid1.Pxhsize(); d++)
					Ginvid1.setGxh(d, Plbestinvid1.getbinaryPxh(d));
				for (int d = 0; d < Plbestinvid1.Pxtsize(); d++)
					Ginvid1.setGxt(d, Plbestinvid1.getbinaryPxt(d));
				for (int d = 0; d < Plbestinvid1.Pysize(); d++)
					Ginvid1.setGy(d, Plbestinvid1.getbinaryPy(d));
			}
			newPopulation.saveG_Individual(Ginvid1);
		}
		return newPopulation;
	}

	public static Population evolvePopulation_Algorithm3(Population pop) {
		Population newPopulation = new Population(pop.size(), false);

		G_Individual G_invid =pop.getG_Individual();
		newPopulation.saveG_Individual(G_invid);
		U_Individual U_invid =pop.getU_Individual();
		newPopulation.saveU_Individual(  U_invid);
		for(int i=0;i<pop.size();i++){
		//	Individual invid =pop.getIndividual(i);
		//	newPopulation.saveIndividual(i, invid);
			SM_Individual SM_invid = pop.getSM_Individual(i);
			newPopulation.saveSM_Individual(i, SM_invid);
			P_Individual P_invid =pop.getP_Individual(i);
			newPopulation.saveP_Individual(i, P_invid);
			V_Individual V_invid =pop.getV_Individual(i);
			newPopulation.saveV_Individual(i, V_invid);
		}
		for(int i=0;i<n3.size();i++){
			Plbest_Individual Plbestinvid = pop.getPlbest_Individual(i);
			newPopulation.savePlbest_Individual(i, Plbestinvid);
			Pworst_Individual Pworstinvid = pop.getPworst_Individual(i);
			newPopulation.savePworst_Individual(i, Pworstinvid);
			LM_Individual LM_invid=pop.getLM_Individual(i);
			newPopulation.saveLM_Individual(i, LM_invid);
		}
		
		
		double Dthreshold = (2 * Vmax) / (2 * Math.pow(n3.size(), 1 /(double)(Xasize + Xhsize + Xtsize + Ysize)));
		for (int i = 0; i < n3.size(); i++) {
			for (int j = i + 1; j < n3.size(); j++) {
				Plbest_Individual Plbestinvid_i = pop.getPlbest_Individual(i);
				Plbest_Individual Plbestinvid_j = pop.getPlbest_Individual(j);
			//	System.out.println("Dij="+calculateDistance(Plbestinvid_i, Plbestinvid_j) +"Dth="+ Dthreshold);
				if (calculateDistance(Plbestinvid_i, Plbestinvid_j) < Dthreshold) {
					Individual invidc = new Individual();
					boolean right;
					if (Plbestinvid_i.getFitness() < Plbestinvid_j.getFitness()) {
						for (int d = 0; d < invidc.Xasize(); d++)
							invidc.setXa(d, Plbestinvid_i.getbinaryPxa(d));
						for (int d = 0; d < invidc.Xhsize(); d++)
							invidc.setXh(d, Plbestinvid_i.getbinaryPxh(d));
						for (int d = 0; d < invidc.Xtsize(); d++)
							invidc.setXt(d, Plbestinvid_i.getbinaryPxt(d));
						for (int d = 0; d < invidc.Ysize(); d++)
							invidc.setY(d, Plbestinvid_i.getbinaryPy(d));
						right=true; 
					} else {
						for (int d = 0; d < invidc.Xasize(); d++)
							invidc.setXa(d, Plbestinvid_j.getbinaryPxa(d));
						for (int d = 0; d < invidc.Xhsize(); d++)
							invidc.setXh(d, Plbestinvid_j.getbinaryPxh(d));
						for (int d = 0; d < invidc.Xtsize(); d++)
							invidc.setXt(d, Plbestinvid_j.getbinaryPxt(d));
						for (int d = 0; d < invidc.Ysize(); d++)
							invidc.setY(d, Plbestinvid_j.getbinaryPy(d));
						right=false;
					}

					int swarm;
					if(right==true)
						swarm=j;
					else
						swarm=i;
					
					int worst =  n3.get(swarm).get(0);
					Individual invidx = pop.getIndividual(n3.get(swarm).get(0));
					double worst_fittest = invidx.getFitness();
					for (int w = 1; w < n3.get(i).size(); w++) {
						Individual invid_n = pop.getIndividual(n3.get(swarm).get(w));
				//		System.out.println("iF="+invid_n.getFitness()+"WF= "+worst_fittest);
						if (invid_n.getFitness() < worst_fittest) {
							worst_fittest = invid_n.getFitness();
							worst = n3.get(swarm).get(w);
						}
					}
					
					Individual invid_wst = pop.getIndividual(worst);
					if (invidc.getFitness() > invid_wst.getFitness()) {
				//		System.out.println("Y");
						for (int d = 0; d < invidc.Xasize(); d++)
							invid_wst.setXa(d, invidc.getXa(d));
						for (int d = 0; d < invidc.Xhsize(); d++)
							invid_wst.setXh(d, invidc.getXh(d));
						for (int d = 0; d < invidc.Xtsize(); d++)
							invid_wst.setXt(d, invidc.getXt(d));
						for (int d = 0; d < invidc.Ysize(); d++)
							invid_wst.setY(d, invidc.getY(d));
						if(right==true)
							swarm=i;
						else
							swarm=j;
						for (int d = 0; d < n3.get(swarm).size(); d++) {
							Individual newIndividual = new Individual();
							newIndividual.XgenerateIndividual();
							newIndividual.YgenerateIndividual();
							newPopulation.saveIndividual(n3.get(swarm).get(d), newIndividual);
						}

					}

				}

			}
		}
		return newPopulation;
	}

	public static Population evolvePopulation_UpLM(Population pop) {
		Population newPopulation = new Population(pop.size(), false);

		G_Individual G_invid =pop.getG_Individual();
		newPopulation.saveG_Individual(G_invid);
		U_Individual U_invid =pop.getU_Individual();
		newPopulation.saveU_Individual(  U_invid);
		for(int i=0;i<pop.size();i++){
			Individual invid =pop.getIndividual(i);
			newPopulation.saveIndividual(i, invid);
			SM_Individual SM_invid = pop.getSM_Individual(i);
			newPopulation.saveSM_Individual(i, SM_invid);
			P_Individual P_invid =pop.getP_Individual(i);
			newPopulation.saveP_Individual(i, P_invid);
			V_Individual V_invid =pop.getV_Individual(i);
			newPopulation.saveV_Individual(i, V_invid);
		}
		for(int i=0;i<n3.size();i++){
			Plbest_Individual Plbestinvid = pop.getPlbest_Individual(i);
			newPopulation.savePlbest_Individual(i, Plbestinvid);
			Pworst_Individual Pworstinvid = pop.getPworst_Individual(i);
			newPopulation.savePworst_Individual(i, Pworstinvid);
		}
		
		for (int i = 0; i < n3.size(); i++) {
			Plbest_Individual Plbestinvid = pop.getPlbest_Individual(i);
			LM_Individual LM_invid = pop.getLM_Individual(i);
			if (Plbestinvid.getFitness() > LM_invid.getFitness1()) {
				for (int d = 0; d < Plbestinvid.Pxasize(); d++) {
					LM_invid.setLMxa(d, Plbestinvid.getPxa(d));
					LM_invid.setbinaryLMxa(d, Plbestinvid.getbinaryPxa(d));
				}
				for (int d = 0; d < Plbestinvid.Pxhsize(); d++) {
					LM_invid.setLMxh(d, Plbestinvid.getPxh(d));
					LM_invid.setbinaryLMxh(d, Plbestinvid.getbinaryPxh(d));
				}
				for (int d = 0; d < Plbestinvid.Pxtsize(); d++) {
					LM_invid.setLMxt(d, Plbestinvid.getPxt(d));
					LM_invid.setbinaryLMxt(d, Plbestinvid.getbinaryPxt(d));
				}
				for (int d = 0; d < Plbestinvid.Pysize(); d++) {
					LM_invid.setLMy(d, Plbestinvid.getPy(d));
					LM_invid.setbinaryLMy(d, Plbestinvid.getbinaryPy(d));
				}
			}

			newPopulation.saveLM_Individual(i, LM_invid);
		}

		return newPopulation;
	}

	public static double calculateDistance(Plbest_Individual plbest_i, Plbest_Individual plbest_j)
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
