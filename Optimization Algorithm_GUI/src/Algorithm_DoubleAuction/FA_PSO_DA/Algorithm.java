package Algorithm_DoubleAuction.FA_PSO_DA;
 
public class Algorithm extends Double_Auction_FA_PSO {

 
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
					
				}else{
					
					V_Individual Vinvid = pop.getV_Individual(i);
					P_Individual Pinvid = pop.getP_Individual(i);
					G_Individual Ginvid = pop.getG_Individual();
					double r1 = PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode);
					double r2 = PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode);
				
					for (int d = 0; d < Vinvid.Vxsize(); d++) {
						
						Vinvid.setVx(d,w * Vinvid.getVx(d)+ (c1 * r1 * (Pinvid.getPx(d) - invid.getX(d)))+ c2 * r2 * (Ginvid.getGx(d) - invid.getX(d)));
						if (Vinvid.getVx(d) > Vmax)
							Vinvid.setVx(d, Vmax);
						if (Vinvid.getVx(d) < -Vmax)
							Vinvid.setVx(d, -Vmax);
						
						if(PSO_Read_Write_txt.random_generate_or_read1( Execution_Mode)>Math.tanh(Math.abs(Vinvid.getVx(d))))
							invid.setX(d, 1);
						else
							invid.setX(d, 0);
					}

					for (int d = 0; d < Vinvid.Vysize(); d++) {
					
						Vinvid.setVy(d,w * Vinvid.getVy(d)+ (c1 * r1 * (Pinvid.getPy(d) - invid.getY(d)))+ c2 * r2 * (Ginvid.getGy(d) - invid.getY(d)));
						if (Vinvid.getVy(d) > Vmax)
							Vinvid.setVy(d, Vmax);
						if (Vinvid.getVy(d) < -Vmax)
							Vinvid.setVy(d, -Vmax);
						
						if(PSO_Read_Write_txt.random_generate_or_read1( Execution_Mode)>Math.tanh(Math.abs(Vinvid.getVy(d))))
							invid.setY(d, 1);
						else
							invid.setY(d, 0);
					}
					newPopulation.saveV_Individual(i, Vinvid);
		//			newPopulation.saveIndividual(i, invid);
		//			Individual Invid= pop.getIndividual(i);
				 
					
					if(invid.getFitness()>Pinvid.getFitness()){
						for(int d=0;d<Pinvid.Pxsize();d++)
							Pinvid.setPx(d, invid.getX(d));
						for(int d=0;d<Pinvid.Pysize();d++)
							Pinvid.setPy(d, invid.getY(d));
					}
					newPopulation.saveP_Individual(i, Pinvid);
					
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
