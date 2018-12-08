package Algorithm_Carpool.PSO_LS_SetBased;

import java.util.ArrayList;
import java.util.List;

import READ_TXT.Read_INPUT_TXT_filter;

public class Algorithm extends PSO_LS_SetBased {

	// Evolve a population 演變人口
	public static Population evolvePopulation(Population pop) {
		Population newPopulation = new Population(pop.size(), false);
		if (Print_Mode == 1) {
			System.out.println("比較F(Astring,Bstring)  F(PAstring,PBstring)");
		}

		for (int i = 0; i < pop.size(); i++) {
			Individual invid = pop.getIndividual(i);
			P_Individual Pinvid = pop.getP_Individual(i);
			if (Print_Mode == 1) {
				System.out.print("第" + i + "個 ");
				System.out.print(" Astring=");
				for (int d = 0; d < invid.Asize(); d++)
					for (int p = 0; p < invid.Asize1(d); p++)
						System.out.print(invid.getA(d, p));
				System.out.print(" Bstring=");
				for (int d = 0; d < invid.Bsize(); d++)
					for (int p = 0; p < invid.Bsize1(d); p++)
						System.out.print(invid.getB(d, p));
				System.out.print(" PAstring=");
				for (int d = 0; d < Pinvid.PAsize(); d++)
					for (int p = 0; p < Pinvid.PAsize1(d); p++)
						System.out.print(Pinvid.getPA(d, p));
				System.out.print(" PBstring=");
				for (int d = 0; d < Pinvid.PBsize(); d++)
					for (int p = 0; p < Pinvid.PBsize1(d); p++)
						System.out.print(Pinvid.getPB(d, p));
			}
			if (invid.getFitness() > Pinvid.getFitness()) {
				if (Print_Mode == 1)
					System.out.println(" F(Astring,Bstring)="+ invid.getFitness()	+ " F(PAstring,PBstring)="+ Pinvid.getFitness()+ "F(Astring,Bstring)>F(PAstring,PBstring) PAstring=Astring,PBstring=Bstring");
				for (int d = 0; d < invid.Asize(); d++)
					for (int p = 0; p < invid.Asize1(d); p++)
						Pinvid.setPA(d, p, invid.getA(d, p));
				for (int d = 0; d < invid.Bsize(); d++)
					for (int p = 0; p < invid.Bsize1(d); p++)
						Pinvid.setPB(d, p, invid.getB(d, p));
			} else {
				if (Print_Mode == 1)
					System.out.println(" F(Astring,Bstring)="+ invid.getFitness()+ " F(PAstring,PBstring)="+ Pinvid.getFitness()+ " F(Astring,Bstring) <= F(PAstring,PBstring) PAstring,PBstring不變");
			}

			newPopulation.saveP_Individual(i, Pinvid);
		}
		
		if (Print_Mode == 1)
			System.out.println("比較F(PAstring,PBstring) F(GAstring,GBstring)");
		for (int j = 0; j < pop.size(); j++) {
			G_Individual Ginvid = pop.getG_Individual();
			P_Individual Pinvid1 = pop.getP_Individual(j);
			if (Print_Mode == 1) {
				System.out.print("第" + j + "個 ");
				System.out.print(" PAstring=");
				System.out.print(" PAstring=");
				for (int d = 0; d < Pinvid1.PAsize(); d++)
					for (int p = 0; p < Pinvid1.PAsize1(d); p++)
						System.out.print(Pinvid1.getPA(d, p));
				System.out.print(" PBstring=");
				for (int d = 0; d < Pinvid1.PBsize(); d++)
					for (int p = 0; p < Pinvid1.PBsize1(d); p++)
						System.out.print(Pinvid1.getPB(d, p));
				System.out.print(" GAstring=");
				for (int d = 0; d < Ginvid.GAsize(); d++)
					for (int p = 0; p < Ginvid.GAsize1(d); p++)
					System.out.print(Ginvid.getGA(d,p));
				System.out.print(" GBstring=");
				for (int d = 0; d < Ginvid.GBsize(); d++)
					for (int p = 0; p < Ginvid.GBsize1(d); p++)
					System.out.print(Ginvid.getGB(d,p));
			}
				if (Pinvid1.getFitness() > Ginvid.getFitness1()) {
					if (Print_Mode == 1)
					System.out.println(" F(PAstring,PBstring)=" + Pinvid1.getFitness()+ " F(GAstring,GBstring)=" + Ginvid.getFitness1()+ "F(PAstring,PBstring)>F(GAstring,GBstring) GAstring=PAstring,GBstring=PBstring");
					for (int d = 0; d < Ginvid.GAsize(); d++)
						for (int p = 0; p < Ginvid.GAsize1(d); p++)
						Ginvid.setGA(d,p, Pinvid1.getPA(d,p));
					for (int d = 0; d < Ginvid.GBsize(); d++)
						for (int p = 0; p < Ginvid.GBsize1(d); p++)
						Ginvid.setGB(d,p, Pinvid1.getPB(d,p));
				} else {
					if (Print_Mode == 1)
					System.out.println(" F(PAstring,PBstring)=" + Pinvid1.getFitness()+ " F(GAstring,GBstring)=" + Ginvid.getFitness1()	+ " F(PAstring,PBstring) <= F(GAstring,GAstring) GAstring,GBstring不變");
				}

			newPopulation.saveG_Individual(Ginvid);
		}
		
		// ---------Step1------------------
		for (int i = 0; i < pop.size(); i++) {
			V_Individual Vinvid = pop.getV_Individual(i);
			
			Individual invid = pop.getIndividual(i);
			double Pw[] = new double[P];
			double Pc[] = new double[P];
			for (int d = 0; d < D; d++) {
				double rid = PSO_Read_Write_txt.random_generate_or_read5(Execution_Mode);
				for (int p = 0; p < P; p++) {
					if ((w * Vinvid.getV(d, p)) > 1) {
						Pw[p] = 1.0;
					} else {
						Pw[p] = w * Vinvid.getV(d, p);
					}
				}
				
				P_Individual Pinvid = pop.getP_Individual( PBest_f(pop, i, d));
			
				for (int p = 0; p < P; p++) {
					if ((C * rid) > 1
							&& (Pinvid.getPA(d, p) - invid.getA(d, p)) == 1) {
						Pc[p] = 1;
					} else if ((C * rid) < 1
							&& (Pinvid.getPA(d, p) - invid.getA(d, p)) == 1) {
						Pc[p] = (C * rid);
					} else {
						Pc[p] = 0;
					}
				}
				for (int p = 0; p < P; p++) {
					Vinvid.setV(d, p, Math.max(Pw[p], Pc[p]));
				}
			}
			newPopulation.saveV_Individual(i, Vinvid);
		}

		// ---------Step2------------------
		for (int i = 0; i < pop.size(); i++) {
			V_Individual Vinvid = pop.getV_Individual(i);
			Individual invid = pop.getIndividual(i);
			Individual invid1 = invid;
			
			// --------- Step2-1 -----------------
			for (int d = 0; d < D; d++) {
				double Alpha = PSO_Read_Write_txt.random_generate_or_read5(Execution_Mode);
				List<Integer> C1 = new ArrayList<Integer>();
				List<Integer> C2 = new ArrayList<Integer>();
				List<Integer> C3 = new ArrayList<Integer>();
				for (int p = 0; p < P; p++) {
					if (Vinvid.getV(d, p) > Alpha)
						C1.add(p);
					if (invid.getA(d, p) == 1)
						C2.add(p);

					C3.add(p);
				}
				
				for (int p = 0; p < P; p++)
					invid1.setA(d, p,0);

				int Qdjk = Read_INPUT_TXT_filter.getP_NUMBER(d);
				ok:while (Qdjk > 0) {
					int p1 = 0;
					if (C1.size() > 0) {
						int ran = PSO_Read_Write_txt.random_generate_or_read4(Execution_Mode, C1.size());
						p1 = ran;
						C1.remove(ran);
					} else if (C2.size() > 0) {	int ran = PSO_Read_Write_txt.random_generate_or_read4(
								Execution_Mode, C2.size());
						p1 = ran;
						C2.remove(ran);
					} else if (C3.size() > 0) {	int ran = PSO_Read_Write_txt.random_generate_or_read4(
								Execution_Mode, C3.size());
						p1 = ran;
						C3.remove(ran);
					}
					invid1.setA(d, p1, 1);
					Qdjk -= 1;
					if (C3.size() <= 0 && C1.size()<=0 && C2.size() <=0) {
						break ok;
					}
				}
				//-----------------
				int [][]A=new int[D][P];
				for(int j=0;j<D;j++)
					for(int k=0;k<P;k++){
						A[j][k]=invid1.getA(j, k);
	//					System.out.print(A[j][k]);
					}
				int[][] B=Bstring(A);
				for(int j=0;j<B.length;j++)
					for(int k=0;k<B[j].length;k++){
						invid1.setB(j, k, B[j][k]);
	//					System.out.print(B[j][k]);
					}
				//------------------			
				if (invid1.getFitness() > invid.getFitness()) {
						invid=invid1;
				}
				// --------- Step2-2 ----------------
				for (int k = 0; k < Nmax; k++) {
					Individual invid2 = GenerateCaidadatePosition(pop, i, d);
					
					//-----------------
					A=new int[D][P];
					for(int m=0;m<D;m++)
						for(int n=0;n<P;n++){
							A[m][n]=invid1.getA(m, n);
						}
					B=Bstring(A);
					for(int m=0;m<B.length;m++)
						for(int n=0;n<B[m].length;n++)
							invid2.setB(m, n, B[m][n]);
					//------------------			
					if (invid2.getFitness() > invid.getFitness())
							invid= invid2;
				}
			}
			newPopulation.saveIndividual(i, invid);
		}
		
		return newPopulation;
	}

	static int[][] Bstring(int[][] A) {
		int[][] B=new int[D][2*P];
		
		Local_Serch.NNH(A);
		
		for (int i = 0; i < M.size(); i++) 
			for (int j = 0; j < M.get(i).size();j++) 
				B[i][j] = M.get(i).get(j);
		
		return B;
	}
	
	static int PBest_f(Population pop, int i, int d) {
		double Pci = Pc;
		double rnd = PSO_Read_Write_txt
				.random_generate_or_read5(Execution_Mode);
		int f1,f2;
		 
		if (rnd < Pci) {
			double rnd1 = PSO_Read_Write_txt.random_generate_or_read5(Execution_Mode);
			double rnd2 = PSO_Read_Write_txt.random_generate_or_read5(Execution_Mode);

			f1=(int) (rnd1 * populationSize);
			f2=(int) (rnd2 * populationSize);
			
			P_Individual Pinvid1 = pop.getP_Individual(f1);
			P_Individual Pinvid2 = pop.getP_Individual(f2);

			if (Pinvid1.getFitness() > Pinvid2.getFitness()) 
				return f1;
			else
				return f2;
		}
		else
		return i;
		
	}

	static Individual GenerateCaidadatePosition(Population pop, int i, int d) {
		Individual invid = pop.getIndividual(i);
		Individual invid1=invid;

		double Di = PSO_Read_Write_txt.random_generate_or_read5(Execution_Mode);

		double rv = Di * Sigma;

		List<Integer> SR = new ArrayList<Integer>();
		List<Integer> ScR = new ArrayList<Integer>();
		for (int p = 0; p < P; p++)
			if (invid.getA(d, p) == 1)
				SR.add((p));
			else
				ScR.add((p));

		int n = (int) (ScR.size() * (1 - rv));

		for (int m = 0; m < n; m++) {
			int nextInt = PSO_Read_Write_txt.random_generate_or_read4(Execution_Mode, ScR.size());
			ScR.remove(nextInt);
		}

		int Qdjk = Read_INPUT_TXT_filter.getP_NUMBER(d);
		int p1 = 0;

		ok:while (Qdjk > 0) {
			if (ScR.size() > 0) {
				int nextInt = PSO_Read_Write_txt.random_generate_or_read4(
						Execution_Mode, ScR.size());
				p1 = ScR.get(nextInt);
				ScR.remove(nextInt);
			} else if (SR.size() > 0) {
				int nextInt = PSO_Read_Write_txt.random_generate_or_read4(	Execution_Mode, SR.size());
				p1 = SR.get(nextInt);
				SR.remove(nextInt);
			}
			for (int p = 0; p < P; p++)
				if (p == p1)
					invid1.setA(d, p, 1);
			
			if(SR.size()<=0 && ScR.size()<=0)
				break ok;
			
		}

		return invid1;
	}

}
