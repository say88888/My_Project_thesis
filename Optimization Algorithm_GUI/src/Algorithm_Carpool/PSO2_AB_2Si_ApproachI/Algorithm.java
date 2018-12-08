package Algorithm_Carpool.PSO2_AB_2Si_ApproachI;

public class Algorithm extends PSO2_AB_2Si_ApproachI {

	private static double[] x;
	private static double[] y;
 
	// Evolve a population 演變人口
	public static Population evolvePopulation(Population pop) {
		Population newPopulation = new Population(pop.size(), false);
		if(Print_Mode==1){
			System.out.println("比較F(X,Y)  F(Px,Py)");
		}
		
		for (int i = 0; i < pop.size(); i++) {

			Individual invid = pop.getIndividual(i);
			P_Individual Pinvid = pop.getP_Individual(i);
			if(Print_Mode==0){
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
			}else{
				System.out.print("第"+i+"個 " );
				System.out.print(" X=");
				for (int d = 0; d < invid.Xsize(); d++)
					System.out.print(invid.getX(d));
				System.out.print(" Y=");
				for (int d = 0; d < invid.Ysize(); d++)
					System.out.print(invid.getY(d));
				System.out.print(" Px=");
				for(int d=0;d<Pinvid.Pxsize();d++)
					System.out.print(Pinvid.getPx(d));
				System.out.print(" Py=");
				for(int d=0;d<Pinvid.Pysize();d++)
					System.out.print(Pinvid.getPy(d));
				
				if (invid.getFitness() > Pinvid.getFitness()) {	
					System.out.println(" F(X,Y)="+invid.getFitness()+" F(Px,Py)="+Pinvid.getFitness()+"F(X,Y)>F(Px,Py) Px=X,Py=Y" );
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
					
				}else{
					System.out.println(" F(X,Y)="+invid.getFitness()+" F(Px,Py)="+Pinvid.getFitness()+" F(X,Y) <= F(Px,Py) Px,Py不變");					
				}
			}
			newPopulation.saveP_Individual(i, Pinvid);
		}
		if(Print_Mode==1)
			System.out.println("比較F(Px,Py) F(Gx,Gy)");
		for (int j = 0; j < pop.size(); j++) {
			G_Individual Ginvid = pop.getG_Individual();
			P_Individual Pinvid1 = pop.getP_Individual(j);
			if(Print_Mode==0){
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
					
				}
			}else{
				System.out.print("第"+j+"個 " );
				System.out.print(" Px=");
				for (int d = 0; d < Pinvid1.Pxsize(); d++)
					System.out.print(Pinvid1.getPx(d));
				System.out.print(" Py=");
				for (int d = 0; d < Pinvid1.Pysize(); d++)
					System.out.print(Pinvid1.getPy(d));
				System.out.print(" Gx=");
				for(int d=0;d<Ginvid.Gxsize();d++)
					System.out.print(Ginvid.getGx(d));
				System.out.print(" Gy=");
				for(int d=0;d<Ginvid.Gysize();d++)
					System.out.print(Ginvid.getGy(d));
				if (Pinvid1.getFitness() > Ginvid.getFitness1()) {
					System.out.println(" F(Px,Py)="+Pinvid1.getFitness()+" F(Gx,Gy)="+Ginvid.getFitness1()+"F(Px,Py)>F(Gx,Gy) Gx=Px,Gy=Py" );
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
				}
				else{
					System.out.println(" F(Px,Py)="+Pinvid1.getFitness()+" F(Gx,Gy)="+Ginvid.getFitness1()+" F(Px,Py) <= F(Gx,Gy) Gx,Gy不變");					
				}
			}
			newPopulation.saveG_Individual(Ginvid);
		}
		if(Print_Mode==1)
			System.out.println("進行更改 速度跟粒子");
			
	
		
		for (int i = 0; i < pop.size(); i++) {
			Individual invid = pop.getIndividual(i);
			P_Individual Pinvid = pop.getP_Individual(i);
			G_Individual Ginvid = pop.getG_Individual();
			double r1 = PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode);
			double r2 = PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode);
		
			if(Print_Mode==1){
				System.out.println("第"+i+"個");
				System.out.println("r1="+r1+"  r2="+r2+" w="+w+" c1="+c1+" c2="+c2);
				}
			for (int d = 0; d < invid.Xsize(); d++) {
				if(Print_Mode==1)
					System.out.print("Vx="+invid.getX(d)+" ");
				invid.setX(d,w * invid.getX(d)+ (c1 * r1 * (Pinvid.getPx(d) - invid.getX(d)))+ c2 * r2 * (Ginvid.getGx(d) - invid.getX(d)));
				if (invid.getX(d) > Vmax)
					invid.setX(d, Vmax);
				if (invid.getX(d) < -Vmax)
					invid.setX(d, -Vmax);
				if(Print_Mode==1)
					System.out.println("改為 Vx="+invid.getX(d)+" ");
			}

			for (int d = 0; d < invid.Ysize(); d++) {
				if(Print_Mode==1)
					System.out.print("Y="+invid.getY(d)+" ");
				invid.setY(d,w * invid.getY(d)+ (c1 * r1 * (Pinvid.getPy(d) - invid.getY(d)))+ c2 * r2 * (Ginvid.getGy(d) - invid.getY(d)));
				if (invid.getY(d) > Vmax)
					invid.setY(d, Vmax);
				if (invid.getY(d) < -Vmax)
					invid.setY(d, -Vmax);
				if(Print_Mode==1)
					System.out.println("改為 Vy="+invid.getY(d)+" ");
			
			}
			newPopulation.saveIndividual(i, invid);
		}
		
		for (int i = 0; i < pop.size(); i++) {
			x=new double[P];
			y=new double[2*P];
			Individual invid = pop.getIndividual(i);
			
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
		
		return newPopulation;
	}
	
	 
}
