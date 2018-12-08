package Algorithm_Carpool.CC_CLPSO2_AB_2Si_ApproachI;

import java.util.Random;

public class Algorithm extends CC_CLPSO2_AB_2Si_ApproachI {
	private static double[] x;
	private static double[] y;
	private static double[] px;
	private static double[] py;
	private static double[] gx;
	private static double[] gy;
	private static int[] A;
	private static int[] B;
	private static int[] PA;
	private static int[] PB;
	private static int[] GA;
	private static int[] GB;
	private static int[] binaryx;
	private static int[] binaryy;
	// Evolve a population 演變人口
	public static Population evolvePopulation(Population pop) {

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
				x=new double[P];
				y=new double[P];
				px=new double[P];
				py=new double[P];
				gx=new double[P];
				gy=new double[P];
				A=new int[P];
				B=new int[2*P];
				PA=new int[P];
				PB=new int[2*P];
				GA=new int[P];
				GB=new int[2*P];
				binaryx=new int[D];
				binaryy=new int[P];
				Individual invid = pop.getIndividual(i);
				P_Individual Pinvid = pop.getP_Individual(i);
				G_Individual Ginvid = pop.getG_Individual();
				for(int d=0;d<Xsize;d++){				//Gx先存放在x、px
					x[d]=Ginvid.getGx(d);
					px[d]=Ginvid.getGx(d);
				}
				for(int d=0;d<Ysize;d++){				//Gy先存放在y、py
					y[d]=Ginvid.getGy(d);
					py[d]=Ginvid.getGy(d);
				}
				for (int k = 0; k < n3.get(j).size(); k++) {	//根據分群來產生b(j,Pj.Xi)、b(j,Pj.Yi)
					if (n3.get(j).get(k) < Xsize) {
						for (int g = 0; g < Xsize; g++)				
							if (g == n3.get(j).get(k)) {				//如果g為當前分群中挑選的維度時
								x[g]=invid.getX(g);						//將x、px第g個維度取代為個別的X、個別最好的Px
								px[g]=Pinvid.getPx(g);
							}
					} else {
						for (int g = 0; g < Ysize; g++)
							if (g == n3.get(j).get(k) - Xsize) {	//如果gy為當前分群中挑選的維度時
								y[g]=invid.getY(g);						//將y、py第g個維度取代為個別的Y、個別最好的Py
								py[g]=Pinvid.getPy(g);
							}
					}
				}
				 //------------取得 x 與 y 的A、B 字串--------------------
				Convert_Function.main(x,y);
				for(int d=0;d<P;d++){
					A[d]=Convert_Function.getA(d);
					invid.setA(d,A[d]);
				}
				for(int d=0;d<(P*2);d++){
					B[d]=Convert_Function.getB(d);
					invid.setB(d,B[d]);
				}
				for(int d=0;d<D;d++) {
					invid.setbinaryX(d,Convert_Function.getbinaryX(d));
					binaryx[d]=Convert_Function.getbinaryX(d);
				}
				for(int d=0;d<P;d++) {
					invid.setbinaryY(d,Convert_Function.getbinaryY(d));
					binaryy[d]=Convert_Function.getbinaryY(d);
				}
				 //------------取得 Px 與 Py 的A、B 字串--------------------
				Convert_Function.main(px,py);
				for(int d=0;d<P;d++){
					PA[d]=Convert_Function.getA(d);
					Pinvid.setPA(d,PA[d]);
				}
				for(int d=0;d<(P*2);d++){
					PB[d]=Convert_Function.getB(d);
					Pinvid.setPB(d,PB[d]);
				}
				for(int d=0;d<D;d++) {
					Pinvid.setbinaryPx(d,Convert_Function.getbinaryX(d));
				}
				for(int d=0;d<P;d++) {
					Pinvid.setbinaryPy(d,Convert_Function.getbinaryY(d));
				}
				//---------------------------------------------------------
				if (Print_Mode == 1) {
					System.out.print("第" + i + "個 ");
					System.out.print(" X=");
					for (int d = 0; d < invid.Xsize(); d++)
						System.out.print(x[d]);
					System.out.print(" Y=");
					for (int d = 0; d < invid.Ysize(); d++)
						System.out.print(y[d]);
					System.out.print(" Px=");
					for (int d = 0; d < Pinvid.Pxsize(); d++)
						System.out.print(px[d]);
					System.out.print(" Py=");
					for (int d = 0; d < Pinvid.Pysize(); d++)
						System.out.print(py[d]);
				}

				if (FitnessCalc.F(A, B)>FitnessCalc.F(PA, PB)) {		//比較F(b(j,Pj.xi)) > F(b(j,Pj.yi))
					if (Print_Mode == 1)
						System.out.println(" F(b(X,Y))=" + FitnessCalc.F(A, B)+ " F(b(Px,Py))=" +FitnessCalc.F(PA, PB)+ "F(b(X,Y))>F(b(Px,Py)) Px=X,Py=Y");

					for (int k = 0; k < n3.get(j).size(); k++) {
						if (n3.get(j).get(k) < Xsize) {			
							for (int g = 0; g < Xsize; g++)						//如果F(b(j,Pj.xi)) > F(b(j,Pj.yi))時
								if (g == n3.get(j).get(k)) 
									Pinvid.setPx(g, x[g]);							//b(j,Pj.xi))取代b(j<Pj.yi)
						} else {
							for (int g = 0; g < Ysize; g++)
								if (g == n3.get(j).get(k) - Xsize) 
									Pinvid.setPy(g, y[g]);
						}
					}
					for(int d=0;d<P;d++){
						Pinvid.setPA(d,A[d]);
					}
					for(int d=0;d<(P*2);d++){
						Pinvid.setPB(d,B[d]);
					}
					for(int d=0;d<D;d++)
						Pinvid.setbinaryPx(d,binaryx[d]);
					for(int d=0;d<P;d++)
						Pinvid.setbinaryPy(d,binaryy[d]);
				} else {
					if (Print_Mode == 1)
						System.out.println(" F(b(X,Y))=" + FitnessCalc.F(A, B)+ " F(b(Px,Py))=" +FitnessCalc.F(PA, PB)+ " F(b(X,Y)) <= F(b(Px,Py)) Px,Py不變");
				}

				newPopulation.saveP_Individual(i, Pinvid);
				
				if (Print_Mode == 1)
				System.out.println("比較F(b(Px,Py)) F(b(Gx,Gy))");
				G_Individual Ginvid1 = pop.getG_Individual();
				P_Individual Pinvid1 = pop.getP_Individual(i);
				for(int d=0;d<Xsize;d++){										
					px[d]=Ginvid1.getGx(d);							//Gx先存放在px、gx
					gx[d]=Ginvid1.getGx(d);
				}
				for(int d=0;d<Ysize;d++){
					py[d]=Ginvid1.getGy(d);							//Gy先存放在py、gy
					gy[d]=Ginvid1.getGy(d);
				}
				
				for (int k = 0; k < n3.get(j).size(); k++) {	//根據分群來產生b(j,Pj.Yi)、b(j,Pj.^Yi)
					if (n3.get(j).get(k) < Xsize) {
						for (int g = 0; g < Xsize; g++)
							if (g == n3.get(j).get(k)){					//如果g為當前分群中挑選的維度時
								px[g]=Pinvid1.getPx(g);				//將px、gx第g個維度取代為個別最好的Px、整體最好的Gx
								gx[g]=Ginvid1.getGx(g);
							}
					} else {
						for (int g = 0; g < Ysize; g++)
							if (g == n3.get(j).get(k) - Xsize) {	//如果g為當前分群中挑選的維度時
								py[g]=Pinvid1.getPy(g);				//將py、gy第g個維度取代為個別最好的Py、整體最好的Gy
								gy[g]=Ginvid1.getGy(g);
							}
					}
				}
				 //------------取得 x 與 y 的A、B 字串--------------------
				Convert_Function.main(px,py);
				for(int d=0;d<P;d++){
					PA[d]=Convert_Function.getA(d);
					Pinvid.setPA(d,PA[d]);
				}
				for(int d=0;d<(P*2);d++){
					PB[d]=Convert_Function.getB(d);
					Pinvid.setPB(d,PB[d]);
				}
				for(int d=0;d<D;d++) {
					binaryx[d]=Convert_Function.getbinaryX(d);
					Pinvid.setbinaryPx(d,Convert_Function.getbinaryX(d));
				}
				for(int d=0;d<P;d++) {
					Pinvid.setbinaryPy(d,Convert_Function.getbinaryY(d));
					binaryy[d]=Convert_Function.getbinaryY(d);
				}
				 //------------取得 Px 與 Py 的A、B 字串--------------------
				Convert_Function.main(gx,gy);
				for(int d=0;d<P;d++){
					GA[d]=Convert_Function.getA(d);
					Ginvid.setGA(d,GA[d]);
				}
				for(int d=0;d<(P*2);d++){
					GB[d]=Convert_Function.getB(d);
					Ginvid.setGB(d,GB[d]);
				}
				for(int d=0;d<D;d++)
					Ginvid.setbinaryGx(d,Convert_Function.getbinaryX(d));
				for(int d=0;d<P;d++)
					Ginvid.setbinaryGy(d,Convert_Function.getbinaryY(d));
				//---------------------------------------------------------
				if (Print_Mode == 1) {
					System.out.print("第" + j + "個 ");
					System.out.print(" Px=");
					for (int d = 0; d < Pinvid1.Pxsize(); d++)
						System.out.print(px[d]);
					System.out.print(" Py=");
					for (int d = 0; d < Pinvid1.Pysize(); d++)
						System.out.print(py[d]);
					System.out.print(" Gx=");
					for (int d = 0; d < Ginvid.Gxsize(); d++)
						System.out.print(gx[d]);
					System.out.print(" Gy=");
					for (int d = 0; d < Ginvid.Gysize(); d++)
						System.out.print(gy[d]);
				}
				if (FitnessCalc.F(PA, PB) > FitnessCalc.F(GA, GB)) {		//比較F(b(j,Pj.yi)) > F(b(j,Pj.^yi))
					if (Print_Mode == 1)
						System.out.println(" F(b(Px,Py))=" + FitnessCalc.F(PA, PB)+ " F(b(Gx,Gy))=" + FitnessCalc.F(GA, GB)+ "F(b(Px,Py))>F(b(Gx,Gy)) Gx=Px,Gy=Py");
					for (int k = 0; k < n3.get(j).size(); k++) {
						if (n3.get(j).get(k) < Xsize) {								//如果F(b(j,Pj.yi)) > F(b(j,Pj.^yi))時
							for (int g = 0; g < Xsize; g++)
								if (g == n3.get(j).get(k)) {
									Ginvid1.setGx(g, px[g]);							//b(j,Pj.yi)取代b(j<Pj.^yi)
									 
								}
						} else {
							for (int g = 0; g < Ysize; g++)
								if (g == n3.get(j).get(k) - Xsize) {
									Ginvid1.setGy(g, py[g]);
									 
								}
						}
					}
					for(int d=0;d<P;d++){
						Ginvid.setGA(d,PA[d]);
					}
					for(int d=0;d<(P*2);d++){
						Ginvid.setGB(d,PB[d]);
					}
					for(int d=0;d<D;d++)
						Ginvid.setbinaryGx(d,binaryx[d]);
					for(int d=0;d<P;d++)
						Ginvid.setbinaryGy(d,binaryy[d]);
				} else {
					if (Print_Mode == 1)
						System.out.println(" F(b(Px,Py))=" + FitnessCalc.F(PA, PB)+ " F(b(Gx,Gy))=" + FitnessCalc.F(GA, GB)+ " F(b(Px,Py)) <= F(b(Gx,Gy)) Gx,Gy不變");
				}
				newPopulation.saveG_Individual(Ginvid1);
			
			}
			if (Print_Mode == 1)
				System.out.println("比較F(b(Gx,Gy)) F(Gx,Gy)");
			G_Individual Ginvid2 = pop.getG_Individual();
			for(int d=0;d<Xsize;d++){
				gx[d]=Ginvid2.getGx(d);					//Gx先存放在gx
			}
			for(int d=0;d<Ysize;d++){
				gy[d]=Ginvid2.getGy(d);					//Gy先存放在gy
			}
			
			for (int k = 0; k < n3.get(j).size(); k++) {	//根據分群來產生b(j,Pj.^Yi)
				if (n3.get(j).get(k) < Xsize) {
					for (int g = 0; g < Xsize; g++)	
						if (g == n3.get(j).get(k))					//如果g為當前分群中挑選的維度時
							gx[g]=Ginvid2.getGx(g);				//將gx第g個維度取代為整體最好的Gx
				} else {
					for (int g = 0; g < Ysize; g++)
						if (g == n3.get(j).get(k) - Xsize) 		//如果g為當前分群中挑選的維度時
							gy[g]=Ginvid2.getGy(g);				//將gy第g個維度取代為整體最好的Gy
				}
			}
			 //------------取得 Gx 與 Gy 的A、B 字串--------------------
			Convert_Function.main(gx,gy);
			for(int d=0;d<P;d++){
				GA[d]=Convert_Function.getA(d);
			}
			for(int d=0;d<(P*2);d++){
				GB[d]=Convert_Function.getB(d);
			}
			for(int d=0;d<D;d++) {
				binaryx[d]=Convert_Function.getbinaryX(d);
			}
			for(int d=0;d<P;d++) {
				binaryy[d]=Convert_Function.getbinaryY(d);
			}
			//---------------------------------------------------------
			if (FitnessCalc.F(GA, GB) > Ginvid2.getFitness1()) {	////比較 F(b(j,Pj.^yi))>F(^y)
				if (Print_Mode == 1)
					System.out.println(" F(b(Gx,Gy))=" + FitnessCalc.F(GA, GB)+ " F(Gx,Gy)=" +Ginvid2.getFitness1()+ "F(b(Gx,Gy))>F(Gx,Gy) Gx=Gx,Gy=Gy");
				for (int k = 0; k < n3.get(j).size(); k++) {
					if (n3.get(j).get(k) < Xsize) {							///如果F(b(j,Pj.^yi))>F(^y)時
						for (int g = 0; g < Xsize; g++)
							if (g == n3.get(j).get(k)) 
								Ginvid2.setGx(g, gx[g]);						//b(j,Pj.^yi)取代^y
							
					} else {
						for (int g = 0; g < Ysize; g++)
							if (g == n3.get(j).get(k) - Xsize) 
								Ginvid2.setGy(g, gy[g]);
								
					}
				}
				for(int d=0;d<P;d++)
					Ginvid2.setGA(d,GA[d]);
				for(int d=0;d<(P*2);d++)
					Ginvid2.setGB(d,GB[d]);
				for(int d=0;d<D;d++)
					Ginvid2.setbinaryGx(d,binaryx[d]);
				for(int d=0;d<P;d++)
					Ginvid2.setbinaryGy(d,binaryy[d]);
			} else {
				if (Print_Mode == 1)
					System.out.println(" F(b(Gx,Gy))=" + FitnessCalc.F(GA, GB)+ " F(Gx,Gy)=" + Ginvid2.getFitness1()+ " F(b(Gx,Gy)) <= F(Gx,Gy) Gx,Gy不變");
			}
			newPopulation.saveG_Individual(Ginvid2);
		}
			 
			if (Print_Mode == 1)
				System.out.println("進行更改 速度跟粒子");

			for (int i = 0; i < pop.size(); i++) {
				Individual invid = pop.getIndividual(i);
				P_Individual Pinvid = pop.getP_Individual(PBest_f(pop, i));
				G_Individual Ginvid = pop.getG_Individual();
				double r1 = PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode);
				for (int d = 0; d < invid.Xsize(); d++) {	//變更X速度
					if (Print_Mode == 1)
						System.out.print("Vx=" + invid.getX(d) + " ");
					invid.setX(d,w * invid.getX(d)+ (c1 * r1 * (Pinvid.getPx(d) - invid.getX(d))));		
					if (invid.getX(d) > Vmax)
						invid.setX(d, Vmax);
					if (invid.getX(d) < -Vmax)
						invid.setX(d, -Vmax);
					if (Print_Mode == 1)
						System.out.println("改為 X=" + invid.getX(d) + " ");

				}

				for (int d = 0; d < invid.Ysize(); d++) {	//變更Y速度
					if (Print_Mode == 1)
						System.out.print("Vy=" + invid.getY(d) + " ");
					invid.setY(d,w * invid.getY(d)+ (c1 * r1 * (Pinvid.getPy(d) - invid.getY(d))));
					if (invid.getY(d) > Vmax)
						invid.setY(d, Vmax);
					if (invid.getY(d) < -Vmax)
						invid.setY(d, -Vmax);
					if (Print_Mode == 1)
						System.out.println("改為 Vy=" + invid.getY(d) + " ");
				}
				newPopulation.saveIndividual(i, invid);
			}
		
		return newPopulation;
	}

	static int PBest_f(Population pop, int i) {
		double Pci = Pc;
		double rnd = PSO_Read_Write_txt
				.random_generate_or_read1(Execution_Mode);
		int f1,f2;
		 
		if (rnd < Pci) {
			double rnd1 = PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode);
			double rnd2 = PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode);

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
}
