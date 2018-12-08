package Algorithm_DoubleAuction.FA_DA;
 
public class Algorithm extends Double_Auction_FA {

 
	// Evolve a population 演變人口
	public static Population evolvePopulation(Population pop) {
		Population newPopulation = new Population(pop.size(), false);
		
		for(int i=0;i<pop.size();i++){
			for(int j=0;j<pop.size();j++){
				
				Individual invid = pop.getIndividual(i);
				Individual invid1= pop.getIndividual(j);
				
				if(invid.getFitness()<invid1.getFitness()){
					
					int r=r(invid,invid1);
					for(int d=0;d<invid.Xsize();d++){
						double x=invid.getX(d)+B0*Math.exp(-Gamma*Math.pow(r, 2))*(invid1.getX(d)-invid.getX(d))+Alpha*PSO_Read_Write_txt.random_generate_or_read1( Execution_Mode) ;
						if(PSO_Read_Write_txt.random_generate_or_read1( Execution_Mode)>Math.tanh(Math.abs(x)))
							invid.setX(d, 1);
						else
							invid.setX(d, 0);
					}
					for(int d=0;d<invid.Ysize();d++){
						double y=invid.getY(d)+B0*Math.exp(-Gamma*Math.pow(r, 2))*(invid1.getY(d)-invid.getY(d))+Alpha*PSO_Read_Write_txt.random_generate_or_read1( Execution_Mode) ;
						if(PSO_Read_Write_txt.random_generate_or_read1( Execution_Mode)>Math.tanh(Math.abs(y)))
							invid.setY(d, 1);
						else
							invid.setY(d, 0);
					}
				} 
				
				newPopulation.saveIndividual(i, invid);
				Individual Invid= pop.getIndividual(i);
		 
				G_Individual Ginvid = pop.getG_Individual();
				if(Invid.getFitness()>Ginvid.getFitness1()){
					for(int d=0;d<Ginvid.Gxsize();d++)
						Ginvid.setGx(d, Invid.getX(d));
					for(int d=0;d<Ginvid.Gysize();d++)
						Ginvid.setGy(d, Invid.getY(d));
				}
				newPopulation.saveG_Individual(Ginvid);
			}
		}
		return newPopulation;
	}

	private static int r(Individual invid, Individual invid1) {
		 int fitness=0,fitness1=0;
		 
		 for(int d=0;d<invid.Xsize();d++)
			 fitness+=invid.getX(d)^invid1.getX(d);
		 for(int d=0;d<invid.Ysize();d++)
			 fitness+=invid.getY(d)^invid1.getY(d);
		 
		 fitness1+=2*(Xsize+Ysize);
		 for(int d=0;d<invid.Xsize();d++)
			 fitness1-=(invid.getX(d)+invid1.getX(d));
		 for(int d=0;d<invid.Ysize();d++)
			 fitness1-=(invid.getY(d)+invid1.getY(d));
		return fitness/fitness1;
	}
	
	 
}
