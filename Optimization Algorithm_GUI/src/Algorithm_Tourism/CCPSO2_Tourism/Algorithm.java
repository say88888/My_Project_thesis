package Algorithm_Tourism.CCPSO2_Tourism;

 import java.util.ArrayList;
import java.util.List;
import java.util.Random;
 
public class Algorithm extends CCPSO2_Tourism {
	private static int[] xa;
	private static int[] xh;
	private static int[] xt;
	private static int[] y;
	
	private static int[] pxa;
	private static int[] pxh;
	private static int[] pxt;
	private static int[] py;
	
	private static int[] gxa;
	private static int[] gxh;
	private static int[] gxt;
	private static int[] gy;
	// Evolve a population 演變人口
	public static Population evolvePopulation(Population pop)   {

		Population newPopulation = new Population(pop.size(), false);

		if (Print_Mode == 1) {
			System.out.println("比較F(b(X,Y))  F(b(Px,Py))");
		}
		E_Individual Einvid = pop.getE_Individual();
		newPopulation.saveE_Individual(Einvid);
		G_Individual Gin=pop.getG_Individual();
		Random ran = new Random();

		for (int j = 0; j < n3.size(); j++) {
			for (int i = 0; i < pop.size(); i++) {
				xa=new int[Xasize];
				xh=new int[Xhsize];
				xt=new int[Xtsize];
				y=new int[Ysize];
				pxa=new int[Xasize];
				pxh=new int[Xhsize];
				pxt=new int[Xtsize];
				py=new int[Ysize];
				
				gxa=new int[Xasize];
				gxh=new int[Xhsize];
				gxt=new int[Xtsize];
				gy=new int[Ysize];
				Individual invid = pop.getIndividual(i);
				P_Individual Pinvid = pop.getP_Individual(i);
				G_Individual Ginvid = pop.getG_Individual();
				for(int d=0;d<Xasize;d++){				//Gx先存放在x、px
					xa[d]=Ginvid.getGxa(d);
					pxa[d]=Ginvid.getGxa(d);
				}
				for(int d=0;d<Xhsize;d++){				//Gx先存放在x、px
					xh[d]=Ginvid.getGxh(d);
					pxh[d]=Ginvid.getGxh(d);
				}
				for(int d=0;d<Xtsize;d++){				//Gx先存放在x、px
					xt[d]=Ginvid.getGxt(d);
					pxt[d]=Ginvid.getGxt(d);
				}
				for(int d=0;d<Ysize;d++){				//Gy先存放在y、py
					y[d]=Ginvid.getGy(d);
					py[d]=Ginvid.getGy(d);
				}
				for (int k = 0; k < n3.get(j).size(); k++) {	//根據分群來產生b(j,Pj.Xi)、b(j,Pj.Yi)
					if (n3.get(j).get(k) < Xasize) {
						for (int g = 0; g < Xasize; g++)				
							if (g == n3.get(j).get(k)) {				//如果g為當前分群中挑選的維度時
								xa[g]=invid.getXa(g);						//將x、px第g個維度取代為個別的X、個別最好的Px
								pxa[g]=Pinvid.getPxa(g);
							}
					} else if (n3.get(j).get(k) < Xasize+Xhsize) {
						for (int g = 0; g < Xhsize; g++)				
							if (g == n3.get(j).get(k) -Xasize) {				//如果g為當前分群中挑選的維度時
								xh[g]=invid.getXh(g);						//將x、px第g個維度取代為個別的X、個別最好的Px
								pxh[g]=Pinvid.getPxh(g);
							}
					}else if (n3.get(j).get(k) < Xasize+Xhsize+Xtsize) {
						for (int g = 0; g < Xtsize; g++)				
							if (g == n3.get(j).get(k)- Xasize -Xhsize) {				//如果g為當前分群中挑選的維度時
								xt[g]=invid.getXt(g);						//將x、px第g個維度取代為個別的X、個別最好的Px
								pxt[g]=Pinvid.getPxt(g);
							}
					}else {
						for (int g = 0; g < Ysize; g++)
							if (g == n3.get(j).get(k) - Xasize -Xhsize-Xtsize) {	//如果gy為當前分群中挑選的維度時
								y[g]=invid.getY(g);						//將y、py第g個維度取代為個別的Y、個別最好的Py
								py[g]=Pinvid.getPy(g);
							}
					}
				}
				 
				if (Print_Mode == 1) {
					System.out.print("第" + i + "個 ");
					System.out.print(" X=");
					for (int d = 0; d < invid.Xasize(); d++)
						System.out.print(xa[d]);
					System.out.print(" Y=");
					for (int d = 0; d < invid.Ysize(); d++)
						System.out.print(y[d]);
					System.out.print(" Px=");
					for (int d = 0; d < Pinvid.Pxasize(); d++)
						System.out.print(pxa[d]);
					System.out.print(" Py=");
					for (int d = 0; d < Pinvid.Pysize(); d++)
						System.out.print(py[d]);
				}

				if (FitnessCalc.F(xa,xh,xt, y)>FitnessCalc.F(pxa,pxh,pxt, py)) {		//比較F(b(j,Pj.xi)) > F(b(j,Pj.yi))
					if (Print_Mode == 1)
						System.out.println(" F(b(X,Y))=" + FitnessCalc.F(xa,xh,xt, y)+ " F(b(Px,Py))=" +FitnessCalc.F(pxa,pxh,pxt, py)+ "F(b(X,Y))>F(b(Px,Py)) Px=X,Py=Y");

					for (int k = 0; k < n3.get(j).size(); k++) {
						if (n3.get(j).get(k) < Xasize) {			
							for (int g = 0; g < Xasize; g++)						//如果F(b(j,Pj.xi)) > F(b(j,Pj.yi))時
								if (g == n3.get(j).get(k)) 
									Pinvid.setPxa(g, xa[g]);							//b(j,Pj.xi))取代b(j<Pj.yi)
						} else if (n3.get(j).get(k) < Xasize+Xhsize) {			
							for (int g = 0; g < Xhsize; g++)						//如果F(b(j,Pj.xi)) > F(b(j,Pj.yi))時
								if (g == n3.get(j).get(k)-Xasize) 
									Pinvid.setPxh(g, xh[g]);							//b(j,Pj.xi))取代b(j<Pj.yi)
						}else if (n3.get(j).get(k) < Xasize+Xhsize+Xtsize) {			
							for (int g = 0; g < Xtsize; g++)						//如果F(b(j,Pj.xi)) > F(b(j,Pj.yi))時
								if (g == n3.get(j).get(k)-Xasize-Xhsize) 
									Pinvid.setPxt(g, xt[g]);							//b(j,Pj.xi))取代b(j<Pj.yi)
						}else {
							for (int g = 0; g < Ysize; g++)
								if (g == n3.get(j).get(k) - Xasize- Xhsize- Xtsize) 
									Pinvid.setPy(g, y[g]);
						}
					}
				} else {
					if (Print_Mode == 1)
						System.out.println(" F(b(X,Y))=" + FitnessCalc.F(xa,xh,xt, y)+ " F(b(Px,Py))=" +FitnessCalc.F(pxa,pxh,pxt, py)+ " F(b(X,Y)) <= F(b(Px,Py)) Px,Py不變");
				}

				newPopulation.saveP_Individual(i, Pinvid);
				
				if (Print_Mode == 1)
				System.out.println("比較F(b(Px,Py)) F(b(Gx,Gy))");
				G_Individual Ginvid1 = pop.getG_Individual();
				P_Individual Pinvid1 = pop.getP_Individual(i);
				for(int d=0;d<Xasize;d++){										
					pxa[d]=Ginvid1.getGxa(d);							//Gx先存放在px、gx
					gxa[d]=Ginvid1.getGxa(d);
				}
				for(int d=0;d<Xhsize;d++){										
					pxh[d]=Ginvid1.getGxh(d);							//Gx先存放在px、gx
					gxh[d]=Ginvid1.getGxh(d);
				}
				for(int d=0;d<Xtsize;d++){										
					pxt[d]=Ginvid1.getGxt(d);							//Gx先存放在px、gx
					gxt[d]=Ginvid1.getGxt(d);
				}
				for(int d=0;d<Ysize;d++){
					py[d]=Ginvid1.getGy(d);							//Gy先存放在py、gy
					gy[d]=Ginvid1.getGy(d);
				}
				
				for (int k = 0; k < n3.get(j).size(); k++) {	//根據分群來產生b(j,Pj.Yi)、b(j,Pj.^Yi)
					if (n3.get(j).get(k) < Xasize) {
						for (int g = 0; g < Xasize; g++)
							if (g == n3.get(j).get(k)){					//如果g為當前分群中挑選的維度時
								pxa[g]=Pinvid1.getPxa(g);				//將px、gx第g個維度取代為個別最好的Px、整體最好的Gx
								gxa[g]=Ginvid1.getGxa(g);
							}
					}else if (n3.get(j).get(k) < Xasize+Xhsize) {
						for (int g = 0; g < Xhsize; g++)
							if (g == n3.get(j).get(k)-Xasize){					//如果g為當前分群中挑選的維度時
								pxh[g]=Pinvid1.getPxh(g);				//將px、gx第g個維度取代為個別最好的Px、整體最好的Gx
								gxh[g]=Ginvid1.getGxh(g);
							}
					}else if (n3.get(j).get(k) < Xasize+Xhsize+Xtsize) {
						for (int g = 0; g < Xtsize; g++)
							if (g == n3.get(j).get(k)-Xasize -Xhsize){					//如果g為當前分群中挑選的維度時
								pxt[g]=Pinvid1.getPxt(g);				//將px、gx第g個維度取代為個別最好的Px、整體最好的Gx
								gxt[g]=Ginvid1.getGxt(g);
							}
					} else {
						for (int g = 0; g < Ysize; g++)
							if (g == n3.get(j).get(k) - Xasize -Xhsize -Xtsize) {	//如果g為當前分群中挑選的維度時
								py[g]=Pinvid1.getPy(g);				//將py、gy第g個維度取代為個別最好的Py、整體最好的Gy
								gy[g]=Ginvid1.getGy(g);
							}
					}
				}
				if (Print_Mode == 1) {
					System.out.print("第" + j + "個 ");
					System.out.print(" Px=");
					for (int d = 0; d < Pinvid1.Pxasize(); d++)
						System.out.print(pxa[d]);
					System.out.print(" Py=");
					for (int d = 0; d < Pinvid1.Pysize(); d++)
						System.out.print(py[d]);
					System.out.print(" Gx=");
					for (int d = 0; d < Ginvid.Gxasize(); d++)
						System.out.print(gxa[d]);
					System.out.print(" Gy=");
					for (int d = 0; d < Ginvid.Gysize(); d++)
						System.out.print(gy[d]);
				}
				if (FitnessCalc.F(pxa,pxh,pxt, py) > FitnessCalc.F(gxa,gxh,gxt, gy)) {		//比較F(b(j,Pj.yi)) > F(b(j,Pj.^yi))
					if (Print_Mode == 1)
						System.out.println(" F(b(Px,Py))=" + FitnessCalc.F(pxa,pxh,pxt, py)+ " F(b(Gx,Gy))=" + FitnessCalc.F(gxa,gxh,gxt, gy)+ "F(b(Px,Py))>F(b(Gx,Gy)) Gx=Px,Gy=Py");
					for (int k = 0; k < n3.get(j).size(); k++) {
						if (n3.get(j).get(k) < Xasize) {								//如果F(b(j,Pj.yi)) > F(b(j,Pj.^yi))時
							for (int g = 0; g < Xasize; g++)
								if (g == n3.get(j).get(k)) {
									Ginvid1.setGxa(g, pxa[g]);							//b(j,Pj.yi)取代b(j<Pj.^yi)
									 
								}
						}else if (n3.get(j).get(k) < Xasize+Xhsize) {								//如果F(b(j,Pj.yi)) > F(b(j,Pj.^yi))時
							for (int g = 0; g < Xhsize; g++)
								if (g == n3.get(j).get(k)-Xasize) {
									Ginvid1.setGxh(g, pxh[g]);							//b(j,Pj.yi)取代b(j<Pj.^yi)
									 
								}
						} else if (n3.get(j).get(k) < Xasize+Xhsize+Xtsize) {								//如果F(b(j,Pj.yi)) > F(b(j,Pj.^yi))時
							for (int g = 0; g < Xtsize; g++)
								if (g == n3.get(j).get(k)-Xasize -Xhsize) {
									Ginvid1.setGxt(g, pxt[g]);							//b(j,Pj.yi)取代b(j<Pj.^yi)
									 
								}
						}else {
							for (int g = 0; g < Ysize; g++)
								if (g == n3.get(j).get(k) - Xasize- Xhsize -Xtsize) {
									Ginvid1.setGy(g, py[g]);
									 
								}
						}
					}
				} else {
					if (Print_Mode == 1)
						System.out.println(" F(b(Px,Py))=" + FitnessCalc.F(pxa,pxh,pxt, py)+ " F(b(Gx,Gy))=" + FitnessCalc.F(gxa,gxh,gxt, gy)+ " F(b(Px,Py)) <= F(b(Gx,Gy)) Gx,Gy不變");
				}
				newPopulation.saveG_Individual(Ginvid1);
			
			}
			if (Print_Mode == 1)
				System.out.println("比較F(b(Gx,Gy)) F(Gx,Gy)");
			G_Individual Ginvid2 = pop.getG_Individual();
			for(int d=0;d<Xasize;d++){
				gxa[d]=Ginvid2.getGxa(d);					//Gx先存放在gx
			}
			for(int d=0;d<Xhsize;d++){
				gxh[d]=Ginvid2.getGxh(d);					//Gx先存放在gx
			}
			for(int d=0;d<Xtsize;d++){
				gxt[d]=Ginvid2.getGxt(d);					//Gx先存放在gx
			}
			for(int d=0;d<Ysize;d++){
				gy[d]=Ginvid2.getGy(d);					//Gy先存放在gy
			}
			
			for (int k = 0; k < n3.get(j).size(); k++) {	//根據分群來產生b(j,Pj.^Yi)
				if (n3.get(j).get(k) < Xasize) {
					for (int g = 0; g < Xasize; g++)	
						if (g == n3.get(j).get(k))					//如果g為當前分群中挑選的維度時
							gxa[g]=Ginvid2.getGxa(g);				//將gx第g個維度取代為整體最好的Gx
				}else if (n3.get(j).get(k) < Xasize+Xhsize) {
					for (int g = 0; g < Xhsize; g++)	
						if (g == n3.get(j).get(k)-Xasize)					//如果g為當前分群中挑選的維度時
							gxh[g]=Ginvid2.getGxh(g);				//將gx第g個維度取代為整體最好的Gx
				} else if (n3.get(j).get(k) < Xasize+Xhsize+Xtsize) {
					for (int g = 0; g < Xtsize; g++)	
						if (g == n3.get(j).get(k)-Xasize-Xhsize)					//如果g為當前分群中挑選的維度時
							gxt[g]=Ginvid2.getGxt(g);				//將gx第g個維度取代為整體最好的Gx
				}  else {
					for (int g = 0; g < Ysize; g++)
						if (g == n3.get(j).get(k) - Xasize-Xhsize-Xtsize) 		//如果g為當前分群中挑選的維度時
							gy[g]=Ginvid2.getGy(g);				//將gy第g個維度取代為整體最好的Gy
				}
			}
			if (FitnessCalc.F(gxa,gxh,gxt, gy) > Ginvid2.getFitness1()) {	////比較 F(b(j,Pj.^yi))>F(^y)
				if (Print_Mode == 1)
					System.out.println(" F(b(Gx,Gy))=" + FitnessCalc.F(gxa,gxh,gxt, gy)+ " F(Gx,Gy)=" +Ginvid2.getFitness1()+ "F(b(Gx,Gy))>F(Gx,Gy) Gx=Gx,Gy=Gy");
				for (int k = 0; k < n3.get(j).size(); k++) {
					if (n3.get(j).get(k) < Xasize) {							///如果F(b(j,Pj.^yi))>F(^y)時
						for (int g = 0; g < Xasize; g++)
							if (g == n3.get(j).get(k)) 
								Ginvid2.setGxa(g, gxa[g]);						//b(j,Pj.^yi)取代^y
							
					} else if (n3.get(j).get(k) < Xasize+Xhsize) {							///如果F(b(j,Pj.^yi))>F(^y)時
						for (int g = 0; g < Xhsize; g++)
							if (g == n3.get(j).get(k)-Xasize) 
								Ginvid2.setGxh(g, gxh[g]);						//b(j,Pj.^yi)取代^y
							
					}else if (n3.get(j).get(k) < Xasize+Xhsize+Xtsize) {							///如果F(b(j,Pj.^yi))>F(^y)時
						for (int g = 0; g < Xtsize; g++)
							if (g == n3.get(j).get(k)-Xasize-Xhsize) 
								Ginvid2.setGxt(g, gxt[g]);						//b(j,Pj.^yi)取代^y
							
					}else {
						for (int g = 0; g < Ysize; g++)
							if (g == n3.get(j).get(k) - Xasize-Xhsize-Xtsize) 
								Ginvid2.setGy(g, gy[g]);
								
					}
				}
			} else {
				if (Print_Mode == 1)
					System.out.println(" F(b(Gx,Gy))=" + FitnessCalc.F(gxa,gxh,gxt, gy)+ " F(Gx,Gy)=" + Ginvid2.getFitness1()+ " F(b(Gx,Gy)) <= F(Gx,Gy) Gx,Gy不變");
			}
			newPopulation.saveG_Individual(Ginvid2);
		}
			 
			if (Print_Mode == 1)
				System.out.println("進行更改 速度跟粒子");

			for (int i = 0; i < pop.size(); i++) {
				Individual invid = pop.getIndividual(i);
				V_Individual Vinvid = pop.getV_Individual(i);
				P_Individual Pinvid = pop.getP_Individual(i);
				G_Individual Ginvid = pop.getG_Individual();
			 
				for (int d = 0; d < Vinvid.Vxasize(); d++) {	//變更X速度
					if (Print_Mode == 1)
						System.out.print("Vxa=" + Vinvid.getVxa(d) + " ");
					Vinvid.setVxa(d,PSO_Read_Write_txt.random_generate_or_read3(Execution_Mode)*Alpha3*Math.abs(Pinvid.getPxa(d)-Ginvid.getGxa(d))+(Alpha1*Pinvid.getPxa(d)+Alpha2*Ginvid.getGxa(d)));
					if (Vinvid.getVxa(d) > Vmax)
						Vinvid.setVxa(d, Vmax);
					if (Vinvid.getVxa(d) < -Vmax)
						Vinvid.setVxa(d, -Vmax);
					if (Print_Mode == 1)
						System.out.println("改為 Vxa=" + Vinvid.getVxa(d) + " ");

				}
				for (int d = 0; d < Vinvid.Vxhsize(); d++) {	//變更X速度
					if (Print_Mode == 1)
						System.out.print("Vxh=" + Vinvid.getVxh(d) + " ");
					Vinvid.setVxh(d,PSO_Read_Write_txt.random_generate_or_read3(Execution_Mode)*Alpha3*Math.abs(Pinvid.getPxh(d)-Ginvid.getGxh(d))+(Alpha1*Pinvid.getPxh(d)+Alpha2*Ginvid.getGxh(d)));
					if (Vinvid.getVxh(d) > Vmax)
						Vinvid.setVxh(d, Vmax);
					if (Vinvid.getVxh(d) < -Vmax)
						Vinvid.setVxh(d, -Vmax);
					if (Print_Mode == 1)
						System.out.println("改為 Vxh=" + Vinvid.getVxh(d) + " ");

				}
				for (int d = 0; d < Vinvid.Vxtsize(); d++) {	//變更X速度
					if (Print_Mode == 1)
						System.out.print("Vxt=" + Vinvid.getVxt(d) + " ");
					Vinvid.setVxt(d,PSO_Read_Write_txt.random_generate_or_read3(Execution_Mode)*Alpha3*Math.abs(Pinvid.getPxt(d)-Ginvid.getGxt(d))+(Alpha1*Pinvid.getPxt(d)+Alpha2*Ginvid.getGxt(d)));
					if (Vinvid.getVxt(d) > Vmax)
						Vinvid.setVxt(d, Vmax);
					if (Vinvid.getVxt(d) < -Vmax)
						Vinvid.setVxt(d, -Vmax);
					if (Print_Mode == 1)
						System.out.println("改為 Vxt=" + Vinvid.getVxt(d) + " ");

				}
				for (int d = 0; d < Vinvid.Vysize(); d++) {	//變更Y速度
					if (Print_Mode == 1)
						System.out.print("Vy=" + Vinvid.getVy(d) + " ");
					Vinvid.setVy(d,PSO_Read_Write_txt.random_generate_or_read3(Execution_Mode)*Alpha3*Math.abs(Pinvid.getPy(d)-Ginvid.getGy(d))+(Alpha1*Pinvid.getPy(d)+Alpha2*Ginvid.getGy(d)));
					if (Vinvid.getVy(d) > Vmax)
						Vinvid.setVy(d, Vmax);
					if (Vinvid.getVy(d) < -Vmax)
						Vinvid.setVy(d, -Vmax);
					if (Print_Mode == 1)
						System.out.println("改為 Vy=" + Vinvid.getVy(d) + " ");
				}
				newPopulation.saveV_Individual(i, Vinvid);
			}
			if (Print_Mode == 1)
				System.out.println("變更粒子");
			for (int i = 0; i < pop.size(); i++) {
				Individual invid = pop.getIndividual(i);
				V_Individual Vinvid = pop.getV_Individual(i);
				P_Individual Pinvid = pop.getP_Individual(i);
				G_Individual Ginvid = pop.getG_Individual();
				if (Print_Mode == 1)
					System.out.println("第" + i + "個");
				for (int d = 0; d < invid.Xasize(); d++) {		//變更X粒子
					double rsid = PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode);
					if (Print_Mode == 1) {
						System.out.print("rsid=" + rsid);
						System.out.println(" S(Vx)=" + 1	/ (1 + Math.exp(-Vinvid.getVxa(d))));
					}
					if (rsid < 1 / (1 + Math.exp(-Vinvid.getVxa(d)))) {
						if (Print_Mode == 1)
							System.out.print("rsid<S(Vx)  X為1");
						invid.setXa(d, 1);
					} else {
						if (Print_Mode == 1)
							System.out.print("rsid>=S(Vx)  X為0");
						invid.setXa(d, 0);
					}
					if (Print_Mode == 1)
						System.out.println();

				}
				for (int d = 0; d < invid.Xhsize(); d++) {		//變更X粒子
					double rsid = PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode);
					if (Print_Mode == 1) {
						System.out.print("rsid=" + rsid);
						System.out.println(" S(Vx)=" + 1	/ (1 + Math.exp(-Vinvid.getVxh(d))));
					}
					if (rsid < 1 / (1 + Math.exp(-Vinvid.getVxh(d)))) {
						if (Print_Mode == 1)
							System.out.print("rsid<S(Vx)  X為1");
						invid.setXh(d, 1);
					} else {
						if (Print_Mode == 1)
							System.out.print("rsid>=S(Vx)  X為0");
						invid.setXh(d, 0);
					}
					if (Print_Mode == 1)
						System.out.println();

				}
				for (int d = 0; d < invid.Xtsize(); d++) {		//變更X粒子
					double rsid = PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode);
					if (Print_Mode == 1) {
						System.out.print("rsid=" + rsid);
						System.out.println(" S(Vx)=" + 1	/ (1 + Math.exp(-Vinvid.getVxt(d))));
					}
					if (rsid < 1 / (1 + Math.exp(-Vinvid.getVxt(d)))) {
						if (Print_Mode == 1)
							System.out.print("rsid<S(Vx)  X為1");
						invid.setXt(d, 1);
					} else {
						if (Print_Mode == 1)
							System.out.print("rsid>=S(Vx)  X為0");
						invid.setXt(d, 0);
					}
					if (Print_Mode == 1)
						System.out.println();

				}
				for (int d = 0; d < invid.Ysize(); d++) {	//變更Y粒子
					double rsid = PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode);
					if (Print_Mode == 1) {
						System.out.print("rsid=" + rsid);
						System.out.println(" S(Vy)=" + 1	/ (1 + Math.exp(-Vinvid.getVy(d))));
					}
					if (rsid < 1 / (1 + Math.exp(-Vinvid.getVy(d)))) {
						if (Print_Mode == 1)
							System.out.print("rsid<S(Vy)  Y為1");
						invid.setY(d, 1);
					} else {
						if (Print_Mode == 1)
							System.out.print("rsid>=S(Vy)  Y為0");
						invid.setY(d, 0);
					}
					if (Print_Mode == 1)
						System.out.println();
				}
				newPopulation.saveIndividual(i, invid);
			}
		
		return newPopulation;
	}

}
