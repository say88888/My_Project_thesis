package Algorithm_Carpool.CCPSO2_P;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
  
public class Algorithm extends CCPSO2_P {
	private static int[] x;
	private static int[] y;
	private static int[] px;
	private static int[] py;
	private static int[] gx;
	private static int[] gy;
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
				x=new int[Xsize];
				y=new int[Ysize];
				px=new int[Xsize];
				py=new int[Ysize];
				gx=new int[Xsize];
				gy=new int[Ysize];
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

				if (FitnessCalc.F(x, y)>FitnessCalc.F(px, py)) {		//比較F(b(j,Pj.xi)) > F(b(j,Pj.yi))
					if (Print_Mode == 1)
						System.out.println(" F(b(X,Y))=" + FitnessCalc.F(x, y)+ " F(b(Px,Py))=" +FitnessCalc.F(px, py)+ "F(b(X,Y))>F(b(Px,Py)) Px=X,Py=Y");

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
				} else {
					if (Print_Mode == 1)
						System.out.println(" F(b(X,Y))=" + FitnessCalc.F(x, y)+ " F(b(Px,Py))=" +FitnessCalc.F(px, py)+ " F(b(X,Y)) <= F(b(Px,Py)) Px,Py不變");
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
				if (FitnessCalc.F(px, py) > FitnessCalc.F(gx, gy)) {		//比較F(b(j,Pj.yi)) > F(b(j,Pj.^yi))
					if (Print_Mode == 1)
						System.out.println(" F(b(Px,Py))=" + FitnessCalc.F(px, py)+ " F(b(Gx,Gy))=" + FitnessCalc.F(gx, gy)+ "F(b(Px,Py))>F(b(Gx,Gy)) Gx=Px,Gy=Py");
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
				} else {
					if (Print_Mode == 1)
						System.out.println(" F(b(Px,Py))=" + FitnessCalc.F(px, py)+ " F(b(Gx,Gy))=" + FitnessCalc.F(gx, gy)+ " F(b(Px,Py)) <= F(b(Gx,Gy)) Gx,Gy不變");
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
			if (FitnessCalc.F(gx, gy) > Ginvid2.getFitness1()) {	////比較 F(b(j,Pj.^yi))>F(^y)
				if (Print_Mode == 1)
					System.out.println(" F(b(Gx,Gy))=" + FitnessCalc.F(px, py)+ " F(Gx,Gy)=" + FitnessCalc.F(gx, gy)+ "F(b(Gx,Gy))>F(Gx,Gy) Gx=Gx,Gy=Gy");
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
			} else {
				if (Print_Mode == 1)
					System.out.println(" F(b(Gx,Gy))=" + FitnessCalc.F(gx, gy)+ " F(Gx,Gy)=" + FitnessCalc.F(gx, gy)+ " F(b(Gx,Gy)) <= F(Gx,Gy) Gx,Gy不變");
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
			double r1 = PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode);
			double r2 = PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode);
			if(Print_Mode==1){
				System.out.println("第"+i+"個");
				System.out.println("r1="+r1+"  r2="+r2+" w="+w+" c1="+c1+" c2="+c2);
				}
			for (int d = 0; d < Vinvid.Vxsize(); d++) {
				if(Print_Mode==1)
					System.out.print("Vx="+Vinvid.getVx(d)+" ");
				Vinvid.setVx(d,PSO_Read_Write_txt.random_generate_or_read3(Execution_Mode)*Alpha3*Math.abs(Pinvid.getPx(d)-Ginvid.getGx(d))+(Alpha1*Pinvid.getPx(d)+Alpha2*Ginvid.getGx(d)));
				if (Vinvid.getVx(d) > Vmax)
					Vinvid.setVx(d, Vmax);
				if (Vinvid.getVx(d) < -Vmax)
					Vinvid.setVx(d, -Vmax);
				if(Print_Mode==1)
					System.out.println("改為 Vx="+Vinvid.getVx(d)+" ");
				
			}

			for (int d = 0; d < Vinvid.Vysize(); d++) {
				if(Print_Mode==1)
					System.out.print("Vy="+Vinvid.getVy(d)+" ");
				Vinvid.setVy(d,PSO_Read_Write_txt.random_generate_or_read3(Execution_Mode)*Alpha3*Math.abs(Pinvid.getPy(d)-Ginvid.getGy(d))+(Alpha1*Pinvid.getPy(d)+Alpha2*Ginvid.getGy(d)));
				if (Vinvid.getVy(d) > Vmax)
					Vinvid.setVy(d, Vmax);
				if (Vinvid.getVy(d) < -Vmax)
					Vinvid.setVy(d, -Vmax);
				if(Print_Mode==1)
					System.out.println("改為 Vy="+Vinvid.getVy(d)+" ");
			}
			newPopulation.saveV_Individual(i, Vinvid);
		}
		
		if(Print_Mode==1)
			System.out.println("變更粒子");
		for(int i=0;i<pop.size();i++){
			Individual invid = pop.getIndividual(i);
			V_Individual Vinvid = pop.getV_Individual(i);
			 
			if(Print_Mode==1)
				System.out.println("第"+i+"個");
			for(int d=0;d<invid.Xsize();d++){
			double rsid = PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode);
			if(Print_Mode==1){
				System.out.print("U(0,1)="+rsid  );
				System.out.println(" p(xid,vid)="+(invid.getX(d)+Vinvid.getVx(d)+Vmax)/(1+2*Vmax)  );
			}
			if (rsid < 1 / (invid.getX(d)+Vinvid.getVx(d)+Vmax)/(1+2*Vmax) ){
				if(Print_Mode==1)
					System.out.print("rsid<p(xid,vid)  X為1");
				invid.setX(d, 1);
			}
			else{
				if(Print_Mode==1)
					System.out.print("rsid>=p(xid,vid)  X為0");
				invid.setX(d, 0);
			}
			 if(Print_Mode==1)
				 System.out.println();
 
		}
			for(int d=0;d<invid.Ysize();d++){
				double rsid = PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode);
				if(Print_Mode==1){
					System.out.print("U(0,1)="+rsid  );
					System.out.println(" p(xid,vid)="+(invid.getY(d)+Vinvid.getVy(d)+Vmax)/(1+2*Vmax)  );
				}
				if (rsid < (invid.getY(d)+Vinvid.getVy(d)+Vmax)/(1+2*Vmax) ){
					if(Print_Mode==1)
						System.out.print("rsid< p(xid,vid)  Y為1");
					invid.setY(d, 1);
				}
				else{
					if(Print_Mode==1)
						System.out.print("rsid>= p(xid,vid)  Y為0");
					invid.setY(d, 0);
				}
				 
			}newPopulation.saveIndividual(i, invid);
		}
		
		return newPopulation;
	}

}
