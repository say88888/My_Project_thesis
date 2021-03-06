package Algorithm_Carpool.ALPSO2_NEW_PrematureConvegence1_AB_2Si_ApproachII;

public class Algorithm extends ALPSO2_NEW_PrematureConvegence1_AB_2Si_ApproachII {

	private static double[] Previous_Fitness;
	private static double[] x;
	private static double[] y;
	// Evolve a population 演變人口
	public static Population evolvePopulation(Population pop) {
		Population newPopulation = new Population(pop.size(), false);
		
		Previous_Fitness = new double[pop.size()];

		for (int i = 0; i < pop.size(); i++) {
			Individual invid = pop.getIndividual(i);
			P_Individual Pinvid = pop.getP_Individual(i);
			Previous_Fitness[i] = invid.getFitness();

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

		for (int j = 0; j < pop.size(); j++) {
			G_Individual Ginvid = pop.getG_Individual();
			P_Individual Pinvid1 = pop.getP_Individual(j);
			V_Individual Vinvid = pop.getV_Individual(j);
			GV_Individual GVinvid = pop.getGV_Individual();
			if (Pinvid1.getFitness() > Ginvid.getFitness1()) {
				for (int d = 0; d < Ginvid.Gxsize(); d++)
					Ginvid.setGx(d, Pinvid1.getPx(d));
				for (int d = 0; d < Ginvid.Gysize(); d++)
					Ginvid.setGy(d, Pinvid1.getPy(d));
				
				for (int d = 0; d < Ginvid.GAsize(); d++)
					Ginvid.setGA(d, Pinvid1.getPA(d));
				for (int d = 0; d < Pinvid1.PBsize(); d++)
					Ginvid.setGB(d, Pinvid1.getPB(d));
				
				for (int d = 0; d < Pinvid1.binaryPxsize(); d++)
					Ginvid.setbinaryGx(d, Pinvid1.getbinaryPx(d));
				for (int d = 0; d < Pinvid1.binaryPysize(); d++)
					Ginvid.setbinaryGy(d, Pinvid1.getbinaryPy(d));

				for (int d = 0; d < Vinvid.Vxsize(); d++)
					GVinvid.setGVx(d, Vinvid.getVx(d));
				for (int d = 0; d < Vinvid.Vysize(); d++)
					GVinvid.setGVy(d, Vinvid.getVy(d));
			}
			newPopulation.saveG_Individual(Ginvid);
			newPopulation.saveGV_Individual(GVinvid);
		}

		for (int i = 0; i < pop.size(); i++) {
			Individual invid = pop.getIndividual(i);
			V_Individual Vinvid = pop.getV_Individual(i);
			P_Individual Pinvid = pop.getP_Individual(i);
			G_Individual Ginvid = pop.getG_Individual();
			r1 = PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode);
			r2 = PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode);

			for (int d = 0; d < Vinvid.Vxsize(); d++) {
				Vinvid.setVx(d, w * Vinvid.getVx(d) + (c1 * r1 * (Pinvid.getPx(d) - invid.getX(d)))
						+ c2 * r2 * (Ginvid.getGx(d) - invid.getX(d)));
				if (Vinvid.getVx(d) > Vmax)
					Vinvid.setVx(d, Vmax);
				if (Vinvid.getVx(d) < -Vmax)
					Vinvid.setVx(d, -Vmax);
			}

			for (int d = 0; d < Vinvid.Vysize(); d++) {
				Vinvid.setVy(d, w * Vinvid.getVy(d) + (c1 * r1 * (Pinvid.getPy(d) - invid.getY(d)))
						+ c2 * r2 * (Ginvid.getGy(d) - invid.getY(d)));
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
					invid.setX(d, Vinvid.getVx(d));
				}
			for (int d = 0; d < invid.Ysize(); d++) {
					invid.setY(d, Vinvid.getVy(d));
				}
			
			x=new double[P];
			y=new double[2*P];
			for (int d = 0; d < invid.Xsize(); d++)
				x[d]=invid.getX(d);
			for (int d = 0; d < invid.Ysize(); d++)
				y[d]=invid.getY(d);
				
			Convert_Function.main(x,y);
			
			for(int d=0;d<invid.Asize();d++)
				invid.setA(d, Convert_Function.getA(d));
			for(int d=0;d<invid.Bsize();d++)
				invid.setB(d, Convert_Function.getB(d));
			
			for(int d=0;d<invid.binaryXsize();d++)
				invid.setbinaryX(d, Convert_Function.getbinaryX(d));
			for(int d=0;d<invid.binaryYsize();d++)
				invid.setbinaryY(d, Convert_Function.getbinaryY(d));
			
			newPopulation.saveIndividual(i, invid);
		}

		double r = PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode);
		if (Prob_adjust > r) {
			G_Individual Ginvid = pop.getG_Individual();
			boolean Update=false;
			for(int L_Iter=0;L_Iter<Local_Search_Iteration;L_Iter++) {
			for (int i = 0; i < pop.size(); i++) {

				CandidateV_Individual CandidateV = pop.getCandidateV_Individual(i);
				
				// Step 1.1: Generate a candidate particle
				CandidateV = GenerateCandidate(pop, i, CandidateV);
				
				// Step 1.2: Select a better particle as new global best from the current global
				// best and
				Individual invid = pop.getIndividual(i);
				P_Individual Pinvid = pop.getP_Individual(i);
				
				Candidate_Individual Candidate = pop.getCandidate_Individual(i);
				for (int d = 0; d < CandidateV.CandidateVxsize(); d++) {
					CandidateV.setCandidateVx(d,
							w * CandidateV.getCandidateVx(d) + (c1 * r1 * (Pinvid.getPx(d) - invid.getX(d)))
									+ c2 * r2 * (CandidateV.getCandidateVx(d) - invid.getX(d)));
					if (CandidateV.getCandidateVx(d) > Vmax)
						CandidateV.setCandidateVx(d, Vmax);
					if (CandidateV.getCandidateVx(d) < -Vmax)
						CandidateV.setCandidateVx(d, -Vmax);
				}
				for (int d = 0; d < CandidateV.CandidateVysize(); d++) {
					CandidateV.setCandidateVy(d,
							w * CandidateV.getCandidateVy(d) + (c1 * r1 * (Pinvid.getPy(d) - invid.getY(d)))
									+ c2 * r2 * (CandidateV.getCandidateVy(d) - invid.getY(d)));
					if (CandidateV.getCandidateVy(d) > Vmax)
						CandidateV.setCandidateVy(d, Vmax);
					if (CandidateV.getCandidateVy(d) < -Vmax)
						CandidateV.setCandidateVy(d, -Vmax);
				}
				newPopulation.saveCandidateV_Individual(i, CandidateV);

				for (int d = 0; d < invid.Xsize(); d++) {
						Candidate.setX(d, CandidateV.getCandidateVx(d));
				}
				for (int d = 0; d < invid.Ysize(); d++) {
						Candidate.setY(d, CandidateV.getCandidateVy(d));
				}
				
				x=new double[P];
				y=new double[2*P];
				for (int d = 0; d < Candidate.Xsize(); d++)
					x[d]=Candidate.getX(d);
				for (int d = 0; d < Candidate.Ysize(); d++)
					y[d]=Candidate.getY(d);
					
				Convert_Function.main(x,y);
				
				for(int d=0;d<Candidate.Asize();d++)
					Candidate.setA(d, Convert_Function.getA(d));
				for(int d=0;d<Candidate.Bsize();d++)
					Candidate.setB(d, Convert_Function.getB(d));
				
				for(int d=0;d<Candidate.binaryXsize();d++)
					Candidate.setbinaryX(d, Convert_Function.getbinaryX(d));
				for(int d=0;d<Candidate.binaryYsize();d++)
					Candidate.setbinaryY(d, Convert_Function.getbinaryY(d));
				
				newPopulation.saveCandidate_Individual(i, Candidate);
			}
			double Competitiveness_Candidate = 0;
			for (int i = 0; i < pop.size(); i++) {
				Candidate_Individual Candidate = pop.getCandidate_Individual(i);
		
				Competitiveness_Candidate += Candidate.getFitness() - Previous_Fitness[i];
			
			}
			double Competitiveness = 0;
			for (int i = 0; i < pop.size(); i++) {
				Competitiveness += Ginvid.getFitness1() - Previous_Fitness[i];
			}
		
			if (Competitiveness_Candidate > Competitiveness) {
				for (int i = 0; i < pop.size(); i++) {
					Candidate_Individual Candidate = pop.getCandidate_Individual(i);
					if (Candidate.getFitness() > Ginvid.getFitness1()) {
						for (int d = 0; d < Ginvid.Gxsize(); d++)
							Ginvid.setGx(d, Candidate.getX(d));
						for (int d = 0; d < Ginvid.Gysize(); d++)
							Ginvid.setGy(d, Candidate.getY(d));
						
						for(int d=0;d<Ginvid.GAsize();d++)
							Ginvid.setGA(d, Candidate.getA(d));
						for(int d=0;d<Ginvid.GBsize();d++)
							Ginvid.setGB(d, Candidate.getB(d));
						
						for(int d=0;d<Ginvid.binaryGxsize();d++)
							Ginvid.setbinaryGx(d, Candidate.getbinaryX(d));
						for(int d=0;d<Ginvid.binaryGysize();d++)
							Ginvid.setbinaryGy(d, Candidate.getbinaryY(d));
					}
					newPopulation.saveG_Individual(Ginvid);
				}
				T=0; Update=true;
			}
			}
			if(Update==false){
				T=T-1;
			}
		} else {
			for (int i = 0; i < pop.size(); i++) {
				CandidateV_Individual CandidateV = pop.getCandidateV_Individual(i);
				newPopulation.saveCandidateV_Individual(i, CandidateV);
				Candidate_Individual Candidate = pop.getCandidate_Individual(i);
				newPopulation.saveCandidate_Individual(i, Candidate);
			}
		}

		Update_T_Prob_adjust(pop);

		return newPopulation;
	}

	static CandidateV_Individual GenerateCandidate(Population pop, int i, CandidateV_Individual CandidateV) {

		GV_Individual GVinvid = pop.getGV_Individual();
		for (int d = 0; d < Xsize; d++) {
			double rgen = PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode);
			if (Prob_candidate > rgen) {
	
				CandidateV.setCandidateVx(d, GVinvid.getGVx(d));

			} else {
				int n1 = PSO_Read_Write_txt.random_generate_or_read4(Execution_Mode, pop.size());
				int n2 = PSO_Read_Write_txt.random_generate_or_read4(Execution_Mode, pop.size());
				P_Individual Pinvid1 = pop.getP_Individual(n1);
				P_Individual Pinvid2 = pop.getP_Individual(n2);
				V_Individual Vinvid1 = pop.getV_Individual(n1);
				V_Individual Vinvid2 = pop.getV_Individual(n2);
		
				if (Pinvid1.getFitness() > Pinvid2.getFitness()) {
					CandidateV.setCandidateVx(d, Vinvid1.getVx(d) + Gaussian_x(pop, d));
				} else {
					CandidateV.setCandidateVx(d, Vinvid2.getVx(d) + Gaussian_x(pop, d));
				}
			}
		}
		for (int d = 0; d < Ysize; d++) {
			double rgen = PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode);
			if (Prob_candidate > rgen) {
				CandidateV.setCandidateVy(d, GVinvid.getGVy(d));
			} else {
				int n1 = PSO_Read_Write_txt.random_generate_or_read4(Execution_Mode, pop.size());
				int n2 = PSO_Read_Write_txt.random_generate_or_read4(Execution_Mode, pop.size());
				P_Individual Pinvid1 = pop.getP_Individual(n1);
				P_Individual Pinvid2 = pop.getP_Individual(n2);
				V_Individual Vinvid1 = pop.getV_Individual(n1);
				V_Individual Vinvid2 = pop.getV_Individual(n2);

				if (Pinvid1.getFitness() > Pinvid2.getFitness()) {
					CandidateV.setCandidateVy(d, Vinvid1.getVy(d) + Gaussian_y(pop, d));
				} else {
					CandidateV.setCandidateVy(d, Vinvid2.getVy(d) + Gaussian_y(pop, d));
				}
			}
		}
		return CandidateV;

	}

	static double Gaussian_x(Population pop, int d) {
		double mean_x = 0;

		double SDxn = 0;

		for (int i = 0; i < pop.size(); i++) {
			P_Individual Pinvid = pop.getP_Individual(i);
			mean_x += Pinvid.getPx(d) / pop.size();
		}
		for (int i = 0; i < pop.size(); i++) {
			P_Individual Pinvid = pop.getP_Individual(i);
			SDxn += Math.pow(Pinvid.getPx(d) - mean_x, 2);
		}

		SDxn = Math.pow((SDxn / pop.size()), 0.5);

		double SDx = PSO_Read_Write_txt.random_generate_or_read3(Execution_Mode) * SDxn;

		return SDx;
	}

	static double Gaussian_y(Population pop, int d) {
		double mean_y = 0;

		double SDyn = 0;

		for (int i = 0; i < pop.size(); i++) {
			P_Individual Pinvid = pop.getP_Individual(i);
			mean_y += Pinvid.getPy(d) / pop.size();
		}
		for (int i = 0; i < pop.size(); i++) {
			P_Individual Pinvid = pop.getP_Individual(i);
			SDyn += Math.pow(Pinvid.getPy(d) - mean_y, 2);
		}

		SDyn = Math.pow((SDyn / pop.size()), 0.5);

		double SDy = PSO_Read_Write_txt.random_generate_or_read3(Execution_Mode) * SDyn;

		return SDy;
	}

	static void Update_T_Prob_adjust(Population pop) {

		double fit = 0;
		G_Individual Ginvid = pop.getG_Individual();
		fit += Ginvid.getFitness1() - Previous_GFitness;

		System.out.println("fit=" + fit);

		if (fit == 0)
			T = T + 1;

		Prob_adjust = (Math.exp(T) - 1) / (Math.exp(10) - 1);

	}

}
