package Algorithm_DoubleAuction.ALPSO2_NEW_DA;

import java.util.Random;

public class Algorithm extends ALPSO2_NEW {

	private static double[] Previous_Fitness;
	private static double[] Previous_PFitness;
	
	// Evolve a population 演變人口
	public static Population evolvePopulation(Population pop) {
		Population newPopulation = new Population(pop.size(), false);

		Previous_Fitness = new double[pop.size()];
		Previous_PFitness = new double[pop.size()];
		for (int i = 0; i < pop.size(); i++) {
			Individual invid = pop.getIndividual(i);
			P_Individual Pinvid = pop.getP_Individual(i);
			Previous_Fitness[i] = invid.getFitness();
			Previous_PFitness[i]=Pinvid.getFitness();
			if (invid.getFitness() > Pinvid.getFitness()) {

				for (int d = 0; d < invid.Xsize(); d++) {
					Pinvid.setPx(d, invid.getX(d));
				}

				for (int d = 0; d < invid.Ysize(); d++) {
					Pinvid.setPy(d, invid.getY(d));
				}
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

		double r = PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode);
		if (Prob_adjust > r) {
			boolean Update=false;
			for(int L_Iter=0;L_Iter<Local_Search_Iteration;L_Iter++) {
			G_Individual Ginvid = pop.getG_Individual();
			for (int i = 0; i < pop.size(); i++) {
				CandidateV_Individual CandidateV = pop.getCandidateV_Individual(i);
				
				// Step 1.1: Generate a candidate particle
				CandidateV = GenerateCandidate(pop, i);
				
				// Step 1.2: Select a better particle as new global best from the current global
				// best and
				Individual invid = pop.getIndividual(i);
				P_Individual Pinvid = pop.getP_Individual(i);
			
				Candidate_Individual Candidate = pop.getCandidate_Individual(i);
				for (int d = 0; d < CandidateV.Vxsize(); d++) {
					CandidateV.setVx(d, w * CandidateV.getVx(d) + (c1 * r1 * (Pinvid.getPx(d) - invid.getX(d)))
							+ c2 * r2 * (CandidateV.getVx(d) - invid.getX(d)));
					if (CandidateV.getVx(d) > Vmax)
						CandidateV.setVx(d, Vmax);
					if (CandidateV.getVx(d) < -Vmax)
						CandidateV.setVx(d, -Vmax);
				}
				for (int d = 0; d < CandidateV.Vysize(); d++) {
					CandidateV.setVy(d, w * CandidateV.getVy(d) + (c1 * r1 * (Pinvid.getPy(d) - invid.getY(d)))
							+ c2 * r2 * (CandidateV.getVy(d) - invid.getY(d)));
					if (CandidateV.getVy(d) > Vmax)
						CandidateV.setVy(d, Vmax);
					if (CandidateV.getVy(d) < -Vmax)
						CandidateV.setVy(d, -Vmax);
				}
				newPopulation.saveCandidateV_Individual(i, CandidateV);

				for (int d = 0; d < invid.Xsize(); d++) {
					double rsid = PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode);

					if (rsid < 1 / (1 + Math.exp(-PSO_lamda * CandidateV.getVx(d)))) {
						Candidate.setX(d, 1);
					} else {
						Candidate.setX(d, 0);
					}
				}
				for (int d = 0; d < invid.Ysize(); d++) {
					double rsid = PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode);
					if (rsid < 1 / (1 + Math.exp(-PSO_lamda * CandidateV.getVy(d)))) {
						Candidate.setY(d, 1);
					} else {
						Candidate.setY(d, 0);
					}
				}
				newPopulation.saveCandidate_Individual(i, Candidate);
			}
			
			double Competitiveness_Candidate = 0;
			for (int i = 0; i < pop.size(); i++) {
				Candidate_Individual Candidate = pop.getCandidate_Individual(i);
				Competitiveness_Candidate += Candidate.getFitness() - Previous_Fitness[i];
			}
			double Competitiveness=0;
			for (int i = 0; i < pop.size(); i++) {
				Competitiveness += Ginvid.getFitness1() - Previous_Fitness[i];
			}
			
			if(Competitiveness_Candidate>Competitiveness) 
			{
				for(int i=0;i<pop.size();i++){
					Candidate_Individual Candidate = pop.getCandidate_Individual(i);
					if(Candidate.getFitness() > Ginvid.getFitness1()){
						for (int d = 0; d < Ginvid.Gxsize(); d++)
							Ginvid.setGx(d, Candidate.getX(d));
						for (int d = 0; d < Ginvid.Gysize(); d++)
							Ginvid.setGy(d, Candidate.getY(d));
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

	static CandidateV_Individual GenerateCandidate(Population pop, int i) {
		
		CandidateV_Individual CandidateV = pop.getCandidateV_Individual(i);
		
		GV_Individual GVinvid = pop.getGV_Individual();
		for (int d = 0; d < Xsize; d++) {
			double rgen = PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode);
			if (Prob_candidate > rgen) {
	
				CandidateV.setVx(d, GVinvid.getGVx(d));
				
			} else {
				int n1 = PSO_Read_Write_txt.random_generate_or_read4(Execution_Mode, pop.size());
				int n2 = PSO_Read_Write_txt.random_generate_or_read4(Execution_Mode, pop.size());
				P_Individual Pinvid1 = pop.getP_Individual(n1);
				P_Individual Pinvid2 = pop.getP_Individual(n2);
				V_Individual Vinvid1 = pop.getV_Individual(n1);
				V_Individual Vinvid2 = pop.getV_Individual(n2);
			
				if (Pinvid1.getFitness() > Pinvid2.getFitness()) {
					CandidateV.setVx(d, Vinvid1.getVx(d) + Gaussian_x(pop, d));
				} else {
					CandidateV.setVx(d, Vinvid2.getVx(d) + Gaussian_x(pop, d));
				}
			}
		}
		for (int d = 0; d < Ysize; d++) {
			double rgen = PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode);
			if (Prob_candidate > rgen) {
				CandidateV.setVy(d, GVinvid.getGVy(d));
			} else {
				int n1 = PSO_Read_Write_txt.random_generate_or_read4(Execution_Mode, pop.size());
				int n2 = PSO_Read_Write_txt.random_generate_or_read4(Execution_Mode, pop.size());
				P_Individual Pinvid1 = pop.getP_Individual(n1);
				P_Individual Pinvid2 = pop.getP_Individual(n2);
				V_Individual Vinvid1 = pop.getV_Individual(n1);
				V_Individual Vinvid2 = pop.getV_Individual(n2);

				if (Pinvid1.getFitness() > Pinvid2.getFitness()) {
					CandidateV.setVy(d, Vinvid1.getVy(d) + Gaussian_y(pop, d));
				} else {
					CandidateV.setVy(d, Vinvid2.getVy(d) + Gaussian_y(pop, d));
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
	
		double fit=0;
		for(int i=0;i< pop.size();i++) {
			P_Individual Pinvid = pop.getP_Individual(i);
			fit+=Pinvid.getFitness()-Previous_PFitness[i];
		}
		
		if(fit==0)
			T=T+1;
		else {
			Prob_adjust=(Math.exp(T)-1)/(Math.exp(10)-1);
		}
	}
	
	
}
