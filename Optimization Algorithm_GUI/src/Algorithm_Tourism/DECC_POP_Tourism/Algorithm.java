package Algorithm_Tourism.DECC_POP_Tourism;

import java.util.ArrayList;
import java.util.Random;

public class Algorithm extends DECC_POP_Tourism {
	private static int[] xa;
	private static int[] xh;
	private static int[] xt;
	private static int[] y;
	
	private static int[] uxa;
	private static int[] uxh;
	private static int[] uxt;
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
					xa=new int[Xasize];
					xh=new int[Xhsize];
					xt=new int[Xtsize];
					y=new int[Ysize];
					uxa=new int[Xasize];
					uxh=new int[Xhsize];
					uxt=new int[Xtsize];
					uy=new int[Ysize];
					U_Individual Uinvid = pop.getU_Individual(i);
					Individual inv = pop.getIndividual(i);
					
					for (int k = 0; k < n3.get(j).size(); k++) {
						if (n3.get(j).get(k) < Xasize) {
							for (int g = 0; g < Xasize; g++)
								if (g == n3.get(j).get(k)) {				//如果g為當前分群中挑選的維度時
									double rsid = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
									if (rsid < 1 / (1 + Math.exp(-lamda*inv.getXa(g)))){
										inv.setbinaryXa(g, 1);
									}
									else{
										inv.setbinaryXa(g, 0);
									}
									 rsid = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
									if (rsid < 1 / (1 + Math.exp(-lamda*Uinvid.getUxa(g)))){
										Uinvid.setbinaryUxa(g, 1);
									}
									else{
										Uinvid.setbinaryUxa(g, 0);
									}
									
									xa[g] = inv.getbinaryXa(g);						//將x、ux第g個維度取代為個別的X、Ux
									uxa[g] = Uinvid.getbinaryUxa(g);
								} else {
									xa[g] = Xa[g];								//如果不是當前分群中的維度時
									uxa[g] = Xa[g];								//將x、ux第g個維度取代當前最好的解GX
								}
						}else if (n3.get(j).get(k) < Xasize + Xhsize) {
							for (int g = 0; g < Xhsize; g++)
								if (g == n3.get(j).get(k)-Xasize) {				//如果g為當前分群中挑選的維度時
									double rsid = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
									if (rsid < 1 / (1 + Math.exp(-lamda*inv.getXh(g)))){
										inv.setbinaryXh(g, 1);
									}
									else{
										inv.setbinaryXh(g, 0);
									}
									 rsid = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
									if (rsid < 1 / (1 + Math.exp(-lamda*Uinvid.getUxh(g)))){
										Uinvid.setbinaryUxh(g, 1);
									}
									else{
										Uinvid.setbinaryUxh(g, 0);
									}
									
									xh[g] = inv.getbinaryXh(g);						//將x、ux第g個維度取代為個別的X、Ux
									uxh[g] = Uinvid.getbinaryUxh(g);
								} else {
									xh[g] = Xh[g];								//如果不是當前分群中的維度時
									uxh[g] = Xh[g];								//將x、ux第g個維度取代當前最好的解GX
								}
						} else if (n3.get(j).get(k) < Xasize+Xhsize+Xtsize) {
							for (int g = 0; g < Xtsize; g++)
								if (g == n3.get(j).get(k)-Xasize -Xhsize) {				//如果g為當前分群中挑選的維度時
									double rsid = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
									if (rsid < 1 / (1 + Math.exp(-lamda*inv.getXt(g)))){
										inv.setbinaryXt(g, 1);
									}
									else{
										inv.setbinaryXt(g, 0);
									}
									 rsid = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
									if (rsid < 1 / (1 + Math.exp(-lamda*Uinvid.getUxt(g)))){
										Uinvid.setbinaryUxt(g, 1);
									}
									else{
										Uinvid.setbinaryUxt(g, 0);
									}
									
									xt[g] = inv.getbinaryXt(g);						//將x、ux第g個維度取代為個別的X、Ux
									uxt[g] = Uinvid.getbinaryUxt(g);
								} else {
									xt[g] = Xt[g];								//如果不是當前分群中的維度時
									uxt[g] = Xt[g];								//將x、ux第g個維度取代當前最好的解GX
								}
						}else {
							for (int g = 0; g < Ysize; g++)
								if (g == n3.get(j).get(k) - Xasize - Xhsize - Xtsize) {	//如果g為當前分群中挑選的維度時
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
									y[g] = Y[g];								//如果不是當前分群中的維度時
									uy[g] = Y[g];								//將y、uy第g個維度取代當前最好的解GY
								}
						}
					}
					double Ginf = FitnessCalc.F(uxa, uxh, uxt, uy);			//計算Ux、Uy的Fittest
					double inf = FitnessCalc.F(xa, xh, xt, y);					//計算X、Y的Fittest
					if (Ginf > inf) {											//如果Ux、Uy的Fittest > X、Y的Fittest

						for (int k = 0; k < n3.get(j).size(); k++) {
							if (n3.get(j).get(k) < Xasize) {
								for (int g = 0; g < Xasize; g++)			//如果g為當前分群中挑選的維度時
									if (g == n3.get(j).get(k)){				//將x第g個維度存為ux
										inv.setbinaryXa(g, uxa[g]);
										inv.setXa(g, Uinvid.getUxa(g));
									}
							}else if (n3.get(j).get(k) < Xasize+Xhsize) {
								for (int g = 0; g < Xhsize; g++)			//如果g為當前分群中挑選的維度時
									if (g == n3.get(j).get(k)-Xhsize){				//將x第g個維度存為ux
										inv.setbinaryXh(g, uxh[g]);
										inv.setXh(g, Uinvid.getUxh(g));
									}
							} else if (n3.get(j).get(k) < Xasize + Xhsize +Xtsize) {
								for (int g = 0; g < Xtsize; g++)			//如果g為當前分群中挑選的維度時
									if (g == n3.get(j).get(k)-Xasize-Xhsize){				//將x第g個維度存為ux
										inv.setbinaryXt(g, uxt[g]);
										inv.setXt(g, Uinvid.getUxt(g));
									}
							}else {
								for (int g = 0; g < Ysize; g++)			//如果g為當前分群中挑選的維度時
									if (g == n3.get(j).get(k) - Xasize- Xhsize- Xtsize){	//將y第g個維度存為uy
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
