package Algorithm_DoubleAuction.DECC_POP_NEW_DA;

import java.util.ArrayList;
import java.util.Random;

public class Algorithm extends Double_Auction_DECC_POP_NEW {
	private static int[] x;
	private static int[] y;

	private static int[] ux;
	private static int[] uy;

	// Evolve a population 演變人口
	public static Population evolvePopulation(Population pop) {
		Population newPopulation = new Population(pop.size(), false);

		for (int j = 0; j < n3.size(); j++) {
			for (int t = 0; t < FEs; t++) {
				if (t % LP == 0)
					Function.Update_p_f_cr(); // 更新p、f、cr

				strategy = new ArrayList<Integer>();
				// 突變V
				for (int i = 0; i < pop.size(); i++) {
					int r1 = 0, r2 = 0, r3 = 0; //挑選r1,r2,r3
					while (r1 == i || r2 == i || r3 == i || r1 == r2
							|| r1 == r3 || r2 == r3 || r1 == b || r2 == b
							|| r3 == b) {// 取r1,r2,r3,r4
						r1 = DE_Read_Write_txt.random_generate_or_read2(
								Execution_Mode, pop.size());
						r2 = DE_Read_Write_txt.random_generate_or_read2(
								Execution_Mode, pop.size());
						r3 = DE_Read_Write_txt.random_generate_or_read2(
								Execution_Mode, pop.size());

					}

					Individual invid = pop.getIndividual(i);
					Individual invid1 = pop.getIndividual(r1);
					Individual invid2 = pop.getIndividual(r2);
					Individual invid3 = pop.getIndividual(r3);
					Individual invidb = pop.getIndividual(b);
					// G_Individual invidb = pop.getG_Individual();
					//計算V
					V_Individual newPinvid = new V_Individual();
					newPinvid = Function.Algorithm1_1(j, F[i], invid1, invid2,
							invid3, invid, invidb);

					// 交叉U
					U_Individual newGinvid = new U_Individual();
					newGinvid = Function.Algorithm2(j, i, invid, newPinvid);
					newPopulation.saveU_Individual(i, newGinvid);
				}
				
					// 貪婪選擇
				for(int i=0;i<pop.size();i++){
					x = new int[Xsize];
					y = new int[Ysize];
					ux = new int[Xsize];
					uy = new int[Ysize];
					U_Individual Uinvid = pop.getU_Individual(i);
					Individual inv = pop.getIndividual(i);
					
					for (int k = 0; k < n3.get(j).size(); k++) {
						if (n3.get(j).get(k) < Xsize) {
							for (int g = 0; g < Xsize; g++)
								if (g == n3.get(j).get(k)) {				//如果g為當前分群中挑選的維度時
									double rsid = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
									if (rsid < 1 / (1 + Math.exp(-lamda*inv.getX(g)))){
										inv.setbinaryX(g, 1);
									}
									else{
										inv.setbinaryX(g, 0);
									}
									 rsid = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
									if (rsid < 1 / (1 + Math.exp(-lamda*Uinvid.getUx(g)))){
										Uinvid.setbinaryUx(g, 1);
									}
									else{
										Uinvid.setbinaryUx(g, 0);
									}
									
									x[g] = inv.getbinaryX(g);						//將x、ux第g個維度取代為個別的X、Ux
									ux[g] = Uinvid.getbinaryUx(g);
								} else {
									x[g] = GX[g];								//如果不是當前分群中的維度時
									ux[g] = GX[g];								//將x、ux第g個維度取代當前最好的解GX
								}
						} else {
							for (int g = 0; g < Ysize; g++)
								if (g == n3.get(j).get(k) - Xsize) {	//如果g為當前分群中挑選的維度時
									double rsid = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
									if (rsid < 1 / (1 + Math.exp(-lamda*inv.getY(g)))){
										inv.setbinaryY(g, 1);
									}
									else{
										inv.setbinaryY(g, 0);
									}
									 rsid = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
									if (rsid < 1 / (1 + Math.exp(-lamda*Uinvid.getUy(g)))){
										Uinvid.setbinaryUy(g, 1);
									}
									else{
										Uinvid.setbinaryUy(g, 0);
									}
									
									y[g] = inv.getbinaryY(g);					//將y、uy第g個維度取代為個別的Y、Uy
									uy[g] = Uinvid.getbinaryUy(g);
								} else {
									y[g] = GY[g];								//如果不是當前分群中的維度時
									uy[g] = GY[g];								//將y、uy第g個維度取代當前最好的解GY
								}
						}
					}
					double Ginf = FitnessCalc.F(ux, uy);			//計算Ux、Uy的Fittest
					double inf = FitnessCalc.F(x, y);					//計算X、Y的Fittest
					if (Ginf > inf) {											//如果Ux、Uy的Fittest > X、Y的Fittest

						for (int k = 0; k < n3.get(j).size(); k++) {
							if (n3.get(j).get(k) < Xsize) {
								for (int g = 0; g < Xsize; g++)			//如果g為當前分群中挑選的維度時
									if (g == n3.get(j).get(k)){				//將x第g個維度存為ux
										inv.setbinaryX(g, ux[g]);
										inv.setX(g, Uinvid.getUx(g));
									}
							} else {
								for (int g = 0; g < Ysize; g++)			//如果g為當前分群中挑選的維度時
									if (g == n3.get(j).get(k) - Xsize){	//將y第g個維度存為uy
										inv.setbinaryY(g, uy[g]);
										inv.setY(g, Uinvid.getUy(g));
									}
							}
						}

						if (strategy.get(i) == 1)						//如果策略為1時
							ns1 += 1;										//ns1+1
						else													//如果策略為3時
							ns2 += 1;										//ns2+1

						CRrec.add(CR[i]);
						frec.add(Ginf - inf);
					}
					newPopulation.saveIndividual(i, inv);

				}
			}
		}

		return newPopulation;
	}
}
