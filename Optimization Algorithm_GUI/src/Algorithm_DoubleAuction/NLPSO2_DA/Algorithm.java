package Algorithm_DoubleAuction.NLPSO2_DA;
 
public class Algorithm extends NLPSO2 {

	// Evolve a population 演變人口
	public static Population evolvePopulation(Population pop) {
		Population newPopulation = new Population(pop.size(), false);
		
		newPopulation=evolvePopulation_Algorithm3(pop);
		
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

		for (int i = 0; i < n3.size(); i++) {
			Plbest_Individual Plbestinvid1 = pop.getPlbest_Individual(i);
			Pworst_Individual Pworstinvid1 = pop.getPworst_Individual(i);
			for (int j = 0; j < n3.get(i).size(); j++) {
				P_Individual Pinvid1 = pop.getP_Individual(n3.get(i).get(j));
				V_Individual Vinid =pop.getV_Individual(n3.get(i).get(j));
				if (Pinvid1.getFitness() > Plbestinvid1.getFitness()) {
					for (int d = 0; d < Plbestinvid1.Pxsize(); d++){
						Plbestinvid1.setbinaryPx(d, Pinvid1.getPx(d));
						Plbestinvid1.setPx(d, Vinid.getVx(d));
					}
						
					for (int d = 0; d < Plbestinvid1.Pysize(); d++){
						Plbestinvid1.setbinaryPy(d, Pinvid1.getPy(d));
						Plbestinvid1.setPy(d, Vinid.getVy(d));
					}
					
				}
				if (Pinvid1.getFitness() < Pworstinvid1.getFitness()) {
					for (int d = 0; d < Pworstinvid1.Pxsize(); d++)
						Pworstinvid1.setPx(d, Pinvid1.getPx(d));
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
				for (int d = 0; d < Plbestinvid1.Pxsize(); d++)
					Ginvid1.setGx(d, Plbestinvid1.getbinaryPx(d));
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

				for (int d = 0; d < Vinvid.Vxsize(); d++) {
					double r1 = PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode);
					if (r1 < prand) {
						double r2 = PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode);
						Vinvid.setVx(d, w * Vinvid.getVx(d) + (F * (invid_K.getX(d) - invid.getX(d)) + (c1 * r2 * (Plbestinvid1.getbinaryPx(d) - invid.getX(d)))));
						if (Vinvid.getVx(d) > Vmax)
							Vinvid.setVx(d, Vmax);
						if (Vinvid.getVx(d) < -Vmax)
							Vinvid.setVx(d, -Vmax);
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
				for (int d = 0; d < Uinvid.Uxsize(); d++) {
					Uinvid.setUx(d, invid.getX(d) + Vinvid.getVx(d));
					double rsid = PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode);
					if (rsid < 1 / (1 + Math.exp(-PSO_lamda * Uinvid.getUx(d)))) {
						Uinvid.setbinaryUx(d, 1);
					} else {
						Uinvid.setbinaryUx(d, 0);
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
					for (int d = 0; d < Uinvid.Uxsize(); d++)
						Plbestinvid1.setPx(d, Uinvid.getbinaryUx(d));
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
					for (int d = 0; d < Uinvid.Uxsize(); d++)
						invid_worst.setX(d, Uinvid.getbinaryUx(d));
					for (int d = 0; d < Uinvid.Uysize(); d++)
						invid_worst.setY(d, Uinvid.getbinaryUy(d));
				}
				SM_Individual SM_invid = pop.getSM_Individual(n3.get(i).get(j));
				if ((Uinvid.getFitness1() - Pworstinvid1.getFitness()) / (Plbestinvid1.getFitness() - Pworstinvid1.getFitness()) <= Rfu
						&& (Uinvid.getFitness1() - Pworstinvid1.getFitness()) / (Plbestinvid1.getFitness() - Pworstinvid1.getFitness()) >= Rfl) {

					for (int d = 0; d < Uinvid.Uxsize(); d++)
						SM_invid.setSMx(d, Uinvid.getUx(d));
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
				for (int d = 0; d < Plbestinvid1.Pxsize(); d++)
					Ginvid1.setGx(d, Plbestinvid1.getbinaryPx(d));
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
				for (int d = 0; d < V_invid.Vxsize(); d++) {
					V_invid.setVx(d, SM_invid.getSMx(d));
					if (V_invid.getVx(d) > Vmax)
						V_invid.setVx(d, Vmax);
					if (V_invid.getVx(d) < -Vmax)
						V_invid.setVx(d, -Vmax);
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
			for (int d = 0; d < V_invid.Vxsize(); d++) {
				V_invid.setVx(d, LM_invid.getLMx(d));
				if (V_invid.getVx(d) > Vmax)
					V_invid.setVx(d, Vmax);
				if (V_invid.getVx(d) < -Vmax)
					V_invid.setVx(d, -Vmax);
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
			for (int d = 0; d < V_invid1.Vxsize(); d++) {
				V_invid1.setVx(d, LM_invid.getLMx(d) + PSO_Read_Write_txt.random_generate_or_read3(Execution_Mode));
				if (V_invid1.getVx(d) > Vmax)
					V_invid1.setVx(d, Vmax);
				if (V_invid1.getVx(d) < -Vmax)
					V_invid1.setVx(d, -Vmax);
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
				for (int d = 0; d < V_invid2.Vxsize(); d++) {
					V_invid2.setVx(d, Vmax + (2 * Vmax) * PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode));
					if (V_invid2.getVx(d) > Vmax)
						V_invid2.setVx(d, Vmax);
					if (V_invid2.getVx(d) < -Vmax)
						V_invid2.setVx(d, -Vmax);
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
			for (int d = 0; d < invid.Xsize(); d++) {
				double rsid = PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode);
				if (rsid < 1 / (1 + Math.exp(-PSO_lamda * Vinvid.getVx(d)))) {
					invid.setX(d, 1);
				} else {
					invid.setX(d, 0);
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
				for (int d = 0; d < invid.Xsize(); d++)
					Pinvid.setPx(d, invid.getX(d));
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
					for (int d = 0; d < Plbestinvid1.Pxsize(); d++){
						Plbestinvid1.setbinaryPx(d, Pinvid1.getPx(d));
						Plbestinvid1.setPx(d, Vinid.getVx(d));
					}
						
					for (int d = 0; d < Plbestinvid1.Pysize(); d++){
						Plbestinvid1.setbinaryPy(d, Pinvid1.getPy(d));
						Plbestinvid1.setPy(d, Vinid.getVy(d));
					}
					
				}
				if (Pinvid1.getFitness() < Pworstinvid1.getFitness()) {
					for (int d = 0; d < Pworstinvid1.Pxsize(); d++)
						Pworstinvid1.setPx(d, Pinvid1.getPx(d));
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
				for (int d = 0; d < Plbestinvid1.Pxsize(); d++)
					Ginvid1.setGx(d, Plbestinvid1.getbinaryPx(d));
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
		
		
		double Dthreshold = (2 * Vmax) / (2 * Math.pow(n3.size(), 1 /(double)(Xsize + Ysize)));
		for (int i = 0; i < n3.size(); i++) {
			for (int j = i + 1; j < n3.size(); j++) {
				Plbest_Individual Plbestinvid_i = pop.getPlbest_Individual(i);
				Plbest_Individual Plbestinvid_j = pop.getPlbest_Individual(j);
			//	System.out.println("Dij="+calculateDistance(Plbestinvid_i, Plbestinvid_j) +"Dth="+ Dthreshold);
				if (calculateDistance(Plbestinvid_i, Plbestinvid_j) < Dthreshold) {
					Individual invidc = new Individual();
					boolean right;
					if (Plbestinvid_i.getFitness() < Plbestinvid_j.getFitness()) {
						for (int d = 0; d < invidc.Xsize(); d++)
							invidc.setX(d, Plbestinvid_i.getbinaryPx(d));
						for (int d = 0; d < invidc.Ysize(); d++)
							invidc.setY(d, Plbestinvid_i.getbinaryPy(d));
						right=true; 
					} else {
						for (int d = 0; d < invidc.Xsize(); d++)
							invidc.setX(d, Plbestinvid_j.getbinaryPx(d));
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
						for (int d = 0; d < invidc.Xsize(); d++)
							invid_wst.setX(d, invidc.getX(d));
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
				for (int d = 0; d < Plbestinvid.Pxsize(); d++) {
					LM_invid.setLMx(d, Plbestinvid.getPx(d));
					LM_invid.setbinaryLMx(d, Plbestinvid.getbinaryPx(d));
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
		for (int i = 0; i < plbest_i.Pxsize(); i++)
			Sum = Sum + Math.pow((plbest_i.getPx(i) - plbest_j.getPx(i)), 2.0);
		for (int i = 0; i < plbest_i.Pysize(); i++)
			Sum = Sum + Math.pow((plbest_i.getPy(i) - plbest_j.getPy(i)), 2.0);
		return Math.sqrt(Sum);
	}
}
