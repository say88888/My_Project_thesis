package Algorithm_Tourism.FA_PSO_Tourism;
 
public class Algorithm extends FA_PSO_Tourism {

 
	// Evolve a population 演變人口
	public static Population evolvePopulation(Population pop) {
		Population newPopulation = new Population(pop.size(), false);
		
		for(int i=0;i<pop.size();i++){
			for(int j=0;j<pop.size();j++){
				
				Individual invid = pop.getIndividual(i);
				Individual invid1= pop.getIndividual(j);
				
				if(invid.getFitness()<invid1.getFitness()){
					 
					int r=r(invid,invid1);
					for(int d=0;d<invid.Xasize();d++){
						double x=invid.getXa(d)+B0*Math.exp(-Gamma*Math.pow(r, 2))*(invid1.getXa(d)-invid.getXa(d))+Alpha*PSO_Read_Write_txt.random_generate_or_read1( Execution_Mode) ;
						if(PSO_Read_Write_txt.random_generate_or_read1( Execution_Mode)>Math.tanh(Math.abs(x)))
							invid.setXa(d, 1);
						else
							invid.setXa(d, 0);
					}
					for(int d=0;d<invid.Xhsize();d++){
						double x=invid.getXh(d)+B0*Math.exp(-Gamma*Math.pow(r, 2))*(invid1.getXh(d)-invid.getXh(d))+Alpha*PSO_Read_Write_txt.random_generate_or_read1( Execution_Mode) ;
						if(PSO_Read_Write_txt.random_generate_or_read1( Execution_Mode)>Math.tanh(Math.abs(x)))
							invid.setXh(d, 1);
						else
							invid.setXh(d, 0);
					}
					for(int d=0;d<invid.Xtsize();d++){
						double x=invid.getXt(d)+B0*Math.exp(-Gamma*Math.pow(r, 2))*(invid1.getXt(d)-invid.getXt(d))+Alpha*PSO_Read_Write_txt.random_generate_or_read1( Execution_Mode) ;
						if(PSO_Read_Write_txt.random_generate_or_read1( Execution_Mode)>Math.tanh(Math.abs(x)))
							invid.setXt(d, 1);
						else
							invid.setXt(d, 0);
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
				
					for (int d = 0; d < Vinvid.Vxasize(); d++) {
			
						Vinvid.setVxa(d,w * Vinvid.getVxa(d)+ (c1 * r1 * (Pinvid.getPxa(d) - invid.getXa(d)))+ c2 * r2 * (Ginvid.getGxa(d) - invid.getXa(d)));
						if (Vinvid.getVxa(d) > Vmax)
							Vinvid.setVxa(d, Vmax);
						if (Vinvid.getVxa(d) < -Vmax)
							Vinvid.setVxa(d, -Vmax);
						
						if(PSO_Read_Write_txt.random_generate_or_read1( Execution_Mode)>Math.tanh(Math.abs(Vinvid.getVxa(d))))
							invid.setXa(d, 1);
						else
							invid.setXa(d, 0);
					}
					for (int d = 0; d < Vinvid.Vxhsize(); d++) {
						
						Vinvid.setVxh(d,w * Vinvid.getVxh(d)+ (c1 * r1 * (Pinvid.getPxh(d) - invid.getXh(d)))+ c2 * r2 * (Ginvid.getGxh(d) - invid.getXh(d)));
						if (Vinvid.getVxh(d) > Vmax)
							Vinvid.setVxh(d, Vmax);
						if (Vinvid.getVxh(d) < -Vmax)
							Vinvid.setVxh(d, -Vmax);
						
						if(PSO_Read_Write_txt.random_generate_or_read1( Execution_Mode)>Math.tanh(Math.abs(Vinvid.getVxh(d))))
							invid.setXh(d, 1);
						else
							invid.setXh(d, 0);
					}
					for (int d = 0; d < Vinvid.Vxtsize(); d++) {
						
						Vinvid.setVxt(d,w * Vinvid.getVxt(d)+ (c1 * r1 * (Pinvid.getPxt(d) - invid.getXt(d)))+ c2 * r2 * (Ginvid.getGxt(d) - invid.getXt(d)));
						if (Vinvid.getVxt(d) > Vmax)
							Vinvid.setVxt(d, Vmax);
						if (Vinvid.getVxt(d) < -Vmax)
							Vinvid.setVxt(d, -Vmax);
						
						if(PSO_Read_Write_txt.random_generate_or_read1( Execution_Mode)>Math.tanh(Math.abs(Vinvid.getVxt(d))))
							invid.setXt(d, 1);
						else
							invid.setXt(d, 0);
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
						for(int d=0;d<Pinvid.Pxasize();d++)
							Pinvid.setPxa(d, invid.getXa(d));
						for(int d=0;d<Pinvid.Pxhsize();d++)
							Pinvid.setPxh(d, invid.getXh(d));
						for(int d=0;d<Pinvid.Pxtsize();d++)
							Pinvid.setPxt(d, invid.getXt(d));
						for(int d=0;d<Pinvid.Pysize();d++)
							Pinvid.setPy(d, invid.getY(d));
					}
					newPopulation.saveP_Individual(i, Pinvid);
					
				}
				
				newPopulation.saveIndividual(i, invid);
				Individual Invid= pop.getIndividual(i);
				 
				G_Individual Ginvid = pop.getG_Individual();
				if(Invid.getFitness()>Ginvid.getFitness1()){
					for(int d=0;d<Ginvid.Gxasize();d++)
						Ginvid.setGxa(d, Invid.getXa(d));
					for(int d=0;d<Ginvid.Gxhsize();d++)
						Ginvid.setGxh(d, Invid.getXh(d));
					for(int d=0;d<Ginvid.Gxtsize();d++)
						Ginvid.setGxt(d, Invid.getXt(d));
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
		 
		 for(int d=0;d<invid.Xasize();d++)
			 fitness+=invid.getXa(d)^invid1.getXa(d);
		 for(int d=0;d<invid.Xhsize();d++)
			 fitness+=invid.getXh(d)^invid1.getXh(d);
		 for(int d=0;d<invid.Xtsize();d++)
			 fitness+=invid.getXt(d)^invid1.getXt(d);
		 for(int d=0;d<invid.Ysize();d++)
			 fitness+=invid.getY(d)^invid1.getY(d);
		 
		 fitness1+=2*(Xasize+Xhsize+Xtsize+Ysize);
		 for(int d=0;d<invid.Xasize();d++)
			 fitness1-=(invid.getXa(d)+invid1.getXa(d));
		 for(int d=0;d<invid.Xhsize();d++)
			 fitness1-=(invid.getXh(d)+invid1.getXh(d));
		 for(int d=0;d<invid.Xtsize();d++)
			 fitness1-=(invid.getXt(d)+invid1.getXt(d));
		 for(int d=0;d<invid.Ysize();d++)
			 fitness1-=(invid.getY(d)+invid1.getY(d));
		return fitness/fitness1;
	}
	
	 
}
