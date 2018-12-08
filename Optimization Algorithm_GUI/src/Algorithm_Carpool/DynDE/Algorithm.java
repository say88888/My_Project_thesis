package Algorithm_Carpool.DynDE;

public class Algorithm extends DynDE {

	// Evolve a population 演變人口
	public static Population evolvePopulation(Population pop) {
		Population newPopulation = new Population(pop.size(), false);

		double Dthreshold = (2 * Vmax) / (2 * Math.pow(n3.size(), 1 / (double) (Xsize + Ysize)));
		for (int i = 0; i < n3.size(); i++) {
			for (int j = 0; j < n3.size(); j++) {
				if (i != j) {
					Plbest_Individual Plbestinvid_i = pop.getPlbest_Individual(i);
					Plbest_Individual Plbestinvid_j = pop.getPlbest_Individual(j);
					if (Function.calculateDistance(Plbestinvid_i, Plbestinvid_j) < Dthreshold) {
						if (Plbestinvid_i.getFitness() > Plbestinvid_j.getFitness()) {
							for(int k=0;k<pop.size();k++){
								U_Individual newU_Individual = pop.getU_Individual(k);
								for(int t=0;t<n3.get(j).size();t++){
									if(k==n3.get(j).get(t)){
										newU_Individual.XglobalIndividual();
										newU_Individual.YglobalIndividual();
									}
								}newPopulation.saveU_Individual(k, newU_Individual);
							}
				/*			for (int k = 0; k < n3.get(j).size(); k++) {
								U_Individual newU_Individual = new U_Individual();
								newU_Individual.XglobalIndividual();
								newU_Individual.YglobalIndividual();
								newPopulation.saveU_Individual(n3.get(j).get(k), newU_Individual);
								System.out.print(n3.get(j).get(k));
							}*/
						} else {
							for(int k=0;k<pop.size();k++){
								U_Individual newU_Individual = pop.getU_Individual(k);
								for(int t=0;t<n3.get(i).size();t++){
									if(k==n3.get(i).get(t)){
										newU_Individual.XglobalIndividual();
										newU_Individual.YglobalIndividual();
									}
								}newPopulation.saveU_Individual(k, newU_Individual);
							}
						/*	for (int k = 0; k < n3.get(i).size(); k++) {
								U_Individual newU_Individual = new U_Individual();
								newU_Individual.XglobalIndividual();
								newU_Individual.YglobalIndividual();
								newPopulation.saveU_Individual(n3.get(i).get(k), newU_Individual);
								System.out.print(n3.get(i).get(k));
							}*/
						}
					} else {
						if(Type[i]==0){
							for (int k = 0; k < n3.get(i).size(); k++) {
								//突變
								int r1 = 0, r2 = 0, r3 = 0, r4 = 0, r5 = 0;
								while (r1 == i || r2 == i || r3 == i || r4 == i || r5 == i || r1 == r2
										|| r1 == r3 || r1 == r4 || r1 == r5 || r2 == r3 || r2 == r4 || r2 == r5 || r3 == r4
										|| r3 == r5 || r1 == b || r2 == b || r3 == b || r4 == b || r5 == b) {// 取r1,r2,r3,r4
									r1 = DE_Read_Write_txt.random_generate_or_read2(Execution_Mode, populationSize);
									r2 = DE_Read_Write_txt.random_generate_or_read2(Execution_Mode, populationSize);
									r3 = DE_Read_Write_txt.random_generate_or_read2(Execution_Mode, populationSize);
									r4 = DE_Read_Write_txt.random_generate_or_read2(Execution_Mode, populationSize);
									r5 = DE_Read_Write_txt.random_generate_or_read2(Execution_Mode, populationSize);
								}

								Individual invid = pop.getIndividual(i);
								Individual invid1 = pop.getIndividual(r1);
								Individual invid2 = pop.getIndividual(r2);
								Individual invid3 = pop.getIndividual(r3);
								Individual invid4 = pop.getIndividual(r4);
								Individual invid5 = pop.getIndividual(r5);
								Individual invidb = pop.getIndividual(b);
								V_Individual newPinvid = new V_Individual();
								int strategy=DE_Read_Write_txt.random_generate_or_read2(Execution_Mode, 6);
								newPinvid = Function.Differential_Evolution(strategy,invid,invid1, invid2, invid3,invid4,invid5,invidb);


								// 交叉U
								U_Individual newUinvid = new U_Individual();
								newUinvid = Function.Algorithm2( invid, newPinvid);
								newPopulation.saveU_Individual(n3.get(i).get(k), newUinvid);
							}
						} if(Type[i]==1){
							for (int k = 0; k < n3.get(i).size(); k++) {
								Individual invid = pop.getIndividual(n3.get(i).get(k));
								U_Individual newUinvid = new U_Individual();
								newUinvid=Function.Entropy_Differential_Evolution(invid);
								newPopulation.saveU_Individual(n3.get(i).get(k), newUinvid);
							}
							
						} if(Type[i]==2){
							for (int k = 0; k < n3.get(i).size(); k++) {
								G_Individual Ginvid = pop.getG_Individual( );
								U_Individual newUinvid = new U_Individual();
								newUinvid=Function.Quantum(Ginvid);
								newPopulation.saveU_Individual(n3.get(i).get(k), newUinvid);
							}
							
						}if(Type[i]==3){
							for (int k = 0; k < n3.get(i).size(); k++) {
								G_Individual Ginvid = pop.getG_Individual( );
								U_Individual newUinvid = new U_Individual();
								newUinvid=Function.Brownian(Ginvid);
								newPopulation.saveU_Individual(n3.get(i).get(k), newUinvid);
							}
							
						}
					
						if(Type[j]==0){
							for (int k = 0; k < n3.get(j).size(); k++) {
								//突變
								int r1 = 0, r2 = 0, r3 = 0, r4 = 0, r5 = 0;
								while (r1 == i || r2 == i || r3 == i || r4 == i || r5 == i || r1 == r2
										|| r1 == r3 || r1 == r4 || r1 == r5 || r2 == r3 || r2 == r4 || r2 == r5 || r3 == r4
										|| r3 == r5 || r1 == b || r2 == b || r3 == b || r4 == b || r5 == b) {// 取r1,r2,r3,r4
									r1 = DE_Read_Write_txt.random_generate_or_read2(Execution_Mode, populationSize);
									r2 = DE_Read_Write_txt.random_generate_or_read2(Execution_Mode, populationSize);
									r3 = DE_Read_Write_txt.random_generate_or_read2(Execution_Mode, populationSize);
									r4 = DE_Read_Write_txt.random_generate_or_read2(Execution_Mode, populationSize);
									r5 = DE_Read_Write_txt.random_generate_or_read2(Execution_Mode, populationSize);
								}

								Individual invid = pop.getIndividual(i);
								Individual invid1 = pop.getIndividual(r1);
								Individual invid2 = pop.getIndividual(r2);
								Individual invid3 = pop.getIndividual(r3);
								Individual invid4 = pop.getIndividual(r4);
								Individual invid5 = pop.getIndividual(r5);
								Individual invidb = pop.getIndividual(b);
								V_Individual newPinvid = new V_Individual();
								
								int strategy=DE_Read_Write_txt.random_generate_or_read2(Execution_Mode, 6);
								newPinvid = Function.Differential_Evolution(strategy,invid,invid1, invid2, invid3,invid4,invid5,invidb);

								// 交叉U
								U_Individual newUinvid = new U_Individual();
								newUinvid = Function.Algorithm2( invid, newPinvid);
								newPopulation.saveU_Individual(n3.get(j).get(k), newUinvid);
							}
						} if(Type[j]==1){
							for (int k = 0; k < n3.get(j).size(); k++) {
								Individual invid = pop.getIndividual(n3.get(j).get(k));
								U_Individual newUinvid = new U_Individual();
								newUinvid=Function.Entropy_Differential_Evolution(invid);
								newPopulation.saveU_Individual(n3.get(j).get(k), newUinvid);
							}
							
						} if(Type[j]==2){
							for (int k = 0; k < n3.get(j).size(); k++) {
								G_Individual Ginvid = pop.getG_Individual( );
								U_Individual newUinvid = new U_Individual();
								newUinvid=Function.Quantum(Ginvid);
								newPopulation.saveU_Individual(n3.get(j).get(k), newUinvid);
							}
							
						}if(Type[j]==3){
							for (int k = 0; k < n3.get(j).size(); k++) {
								G_Individual Ginvid = pop.getG_Individual( );
								U_Individual newUinvid = new U_Individual();
								newUinvid=Function.Brownian(Ginvid);
								newPopulation.saveU_Individual(n3.get(j).get(k), newUinvid);
							}
							
						}
					}
				}
			}
		}



		// 貪婪選擇
		for (int i = 0; i < pop.size(); i++) {
			U_Individual Ginvid = pop.getU_Individual(i);
			Individual invid = pop.getIndividual(i);
	
			if (Ginvid.getFitness1() > invid.getFitness1()) {
				for (int d = 0; d < invid.Xsize(); d++) {
					invid.setX(d, Ginvid.getUx(d));
					invid.setbinaryX(d, Ginvid.getbinaryUx(d));
				}

				for (int d = 0; d < invid.Ysize(); d++) {
					invid.setY(d, Ginvid.getUy(d));
					invid.setbinaryY(d, Ginvid.getbinaryUy(d));
				}

			}
			newPopulation.saveIndividual(i, invid);
		}

		for (int i = 0; i < n3.size(); i++) {
			Plbest_Individual Plbestinvid1 = pop.getPlbest_Individual(i);
			for (int j = 0; j < n3.get(i).size(); j++) {
				Individual invid1 = pop.getIndividual(n3.get(i).get(j));
				if (invid1.getFitness1() > Plbestinvid1.getFitness()) {
					for (int d = 0; d < Plbestinvid1.Pxsize(); d++) {
						Plbestinvid1.setbinaryPx(d, invid1.getbinaryX(d));
						Plbestinvid1.setPx(d, invid1.getX(d));
					}
					for (int d = 0; d < Plbestinvid1.Pysize(); d++) {
						Plbestinvid1.setbinaryPy(d, invid1.getbinaryY(d));
						Plbestinvid1.setPy(d, invid1.getY(d));
					}

				}
			}
			newPopulation.savePlbest_Individual(i, Plbestinvid1);
		}

		for (int i = 0; i < n3.size(); i++) {
			Plbest_Individual Plbestinvid1 = pop.getPlbest_Individual(i);
			G_Individual Ginvid1 = pop.getG_Individual();
			if (Plbestinvid1.getFitness() > Ginvid1.getFitness1()) {
				for (int d = 0; d < Plbestinvid1.Pxsize(); d++){
					Ginvid1.setGx(d, Plbestinvid1.getPx(d));
					Ginvid1.setbinaryGx(d, Plbestinvid1.getbinaryPx(d));
				}
					
				for (int d = 0; d < Plbestinvid1.Pysize(); d++){
					Ginvid1.setGy(d, Plbestinvid1.getPy(d));
					Ginvid1.setbinaryGy(d, Plbestinvid1.getbinaryPy(d));
				}
					
			}
			newPopulation.saveG_Individual(Ginvid1);
		}

		return newPopulation;
	}
}
