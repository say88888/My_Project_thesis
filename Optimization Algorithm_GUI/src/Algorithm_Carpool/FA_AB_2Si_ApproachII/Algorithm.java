package Algorithm_Carpool.FA_AB_2Si_ApproachII;

public class Algorithm extends FA_AB_2Si_ApproachII {

	private static double[] x1;
	private static double[] y1;
	// Evolve a population 演變人口
	public static Population evolvePopulation(Population pop) {
		Population newPopulation = new Population(pop.size(), false);
		
		for(int i=0;i<pop.size();i++){
			for(int j=0;j<pop.size();j++){
				
				Individual invid = pop.getIndividual(i);
				Individual invid1= pop.getIndividual(j);
				x1=new double[P];
				y1=new double[2*P];
				
				if(invid.getFitness()<invid1.getFitness()){
					double r=r(invid,invid1);
					for(int d=0;d<invid.Xsize();d++){
						double x=invid.getX(d)+B0*Math.exp(-Gamma*Math.pow(r, 2))*(invid1.getX(d)-invid.getX(d))+Alpha*PSO_Read_Write_txt.random_generate_or_read1( Execution_Mode) ;
							invid.setX(d, x);
							if (invid.getX(d) > Vmax)
								invid.setX(d, Vmax);
							if (invid.getX(d) < -Vmax)
								invid.setX(d, -Vmax);
							x1[d]=invid.getX(d);
					}
					for(int d=0;d<invid.Ysize();d++){
						double y=invid.getY(d)+B0*Math.exp(-Gamma*Math.pow(r, 2))*(invid1.getY(d)-invid.getY(d))+Alpha*PSO_Read_Write_txt.random_generate_or_read1( Execution_Mode) ;
							invid.setY(d, y);
							if (invid.getY(d) > Vmax)
								invid.setY(d, Vmax);
							if (invid.getY(d) < -Vmax)
								invid.setY(d, -Vmax);
							y1[d]=invid.getY(d);
					}
					Convert_Function.main(x1,y1);
					
					for(int d=0;d<invid.Asize();d++)
						invid.setA(d, Convert_Function.getA(d));
					for(int d=0;d<invid.Bsize();d++)
						invid.setB(d, Convert_Function.getB(d));
					
					for(int d=0;d<invid.binaryXsize();d++)
						invid.setbinaryX(d, Convert_Function.getbinaryX(d));
					for(int d=0;d<invid.binaryYsize();d++)
						invid.setbinaryY(d, Convert_Function.getbinaryY(d));
				} 
					
				newPopulation.saveIndividual(i, invid);
				Individual Invid= pop.getIndividual(i);
		 
				G_Individual Ginvid = pop.getG_Individual();
				if(Invid.getFitness()>Ginvid.getFitness1()){
					for(int d=0;d<Ginvid.Gxsize();d++)
						Ginvid.setGx(d, Invid.getX(d));
					for(int d=0;d<Ginvid.Gysize();d++)
						Ginvid.setGy(d, Invid.getY(d));
					
					for(int d=0;d<Ginvid.GAsize();d++)
						Ginvid.setGA(d, Invid.getA(d));
					for(int d=0;d<Ginvid.GBsize();d++)
						Ginvid.setGB(d, Invid.getB(d));
					
					for(int d=0;d<Ginvid.binaryGxsize();d++)
						Ginvid.setbinaryGx(d, Invid.getbinaryX(d));
					for(int d=0;d<Ginvid.binaryGysize();d++)
						Ginvid.setbinaryGy(d, Invid.getbinaryY(d));
					
				}
				newPopulation.saveG_Individual(Ginvid);
			}
		}
		return newPopulation;
	}

	private static double r(Individual invid, Individual invid1) {
		 double fitness=0;
		 
		 for(int d=0;d<invid.Xsize();d++)
			 fitness+=Math.pow((invid.getX(d)-invid1.getX(d)),2);
		 for(int d=0;d<invid.Ysize();d++)
			 fitness+=Math.pow((invid.getY(d)-invid1.getY(d)),2);
		 
		 fitness=Math.pow(fitness,0.5);
		 
		return fitness;
	}
	
	 
}
