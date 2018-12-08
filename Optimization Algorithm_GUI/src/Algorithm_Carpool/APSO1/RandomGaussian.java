package Algorithm_Carpool.APSO1;

import java.util.Random;

/**
 * Generate pseudo-random floating point values, with an approximately Gaussian
 * (normal) distribution.
 * 
 * Many physical measurements have an approximately Gaussian distribution; this
 * provides a way of simulating such values.
 */

public final class RandomGaussian  extends APSO1 {

	public static Population main(Population pop, Population newPopulation) {
	
		
		G_Individual Ginvid = pop.getG_Individual();

		int d = 0;

		//int D = Ginvid.Gxsize() + Ginvid.Gysize();
		double pd;
		Random ran=new Random();
		int xy=PSO_Read_Write_txt.random_generate_or_read(Execution_Mode);
		if(xy==0){
			d = PSO_Read_Write_txt.random_generate_or_read3(Execution_Mode, Ginvid.Gxsize());
			pd = Ginvid.getGx(d);
			System.err.println("d=" + d+" xy="+xy);
			System.err.println("  取Gx "+"  pd值= " + pd);
		}
		else{
			d=PSO_Read_Write_txt.random_generate_or_read3(Execution_Mode,Ginvid.Gysize());
			pd = Ginvid.getGy(d);
			System.err.println("d=" + d);
			System.err.println("  取Gy   pd值= " + pd);
		}
		

	
		RandomGaussian gaussian = new RandomGaussian();
		double VARIANCE = Sigma();
        double Gaussian;
        Gaussian=gaussian.getGaussian(Mu, Math.pow(VARIANCE, 2));
		System.err.print("Gaussian : "	+ Gaussian);

		pd = pd +Gaussian;

		System.err.println("pd= " + pd);
	 
		if (pd > 0.5)
			pd = 1;
		else
			pd = 0;

		E_Individual Einvid = pop.getE_Individual();

		for (int i = 0; i < Ginvid.Gxsize(); i++)
			Einvid.setEx(i, Ginvid.getGx(i));
		newPopulation.saveE_Individual(Einvid);
		for (int i = 0; i < Ginvid.Gysize(); i++)
			Einvid.setEy(i, Ginvid.getGy(i));
		newPopulation.saveE_Individual(Einvid);
		
		if (xy==0)
			Einvid.setEx(d, (int) pd);
		else
			Einvid.setEy(d, (int) pd);
		newPopulation.saveE_Individual(Einvid);

		System.err.print("Ex= ");
		for (int i = 0; i < Einvid.Exsize(); i++)
			System.err.print(Einvid.getEx(i)+" ");
		System.out.println();
		System.err.print("Ey= ");
		for (int i = 0; i < Einvid.Eysize(); i++)
			System.err.print(Einvid.getEy(i)+" ");
		
		Individual invid1 = pop.getIndividual(0);
		double m = invid1.getFitness();
		int n = 0;
		for (int i = 0; i < pop.size(); i++) {
			Individual invid = pop.getIndividual(i);
			if (invid.getFitness() < m) {
				m = invid.getFitness();
				n = i;
			}
		}

		if (Einvid.getFitness1() > Ginvid.getFitness1()) {
			System.err.print("   比 gbest 好   ") ;
			System.err.print(Einvid.getFitness1() +" > "+  Ginvid.getFitness1()) ;
			for (int i = 0; i < Einvid.Exsize(); i++)
				Ginvid.setGx(i, Einvid.getEx(i));
			for (int i = 0; i < Einvid.Eysize(); i++)
				Ginvid.setGy(i, Einvid.getEy(i));
			newPopulation.saveG_Individual(Ginvid);
			
			System.err.print("Gx= ");
			for (int i = 0; i < Ginvid.Gxsize(); i++)
				System.err.print(Ginvid.getGx(i)+" ");
			System.out.println();
			System.err.print("Gy= ");
			for (int i = 0; i < Ginvid.Gysize(); i++)
				System.err.print(Ginvid.getGy(i)+" ");
			
		} else {
			System.err.print("   沒有比 gbest 好   ") ;
			System.err.print(Einvid.getFitness1() +" <= "+  Ginvid.getFitness1()) ;
			Individual invid = pop.getIndividual(n);
			for (int i = 0; i < invid.Xsize(); i++)
				invid.setX(i, Einvid.getEx(i));
			for (int i = 0; i < invid.Ysize(); i++)
				invid.setY(i, Einvid.getEy(i));
			newPopulation.saveIndividual(n, invid);
		}
		return newPopulation;
	}

	private Random fRandom = new Random();

	private double getGaussian(double aMean, double aVariance) {
		return aMean + fRandom.nextGaussian() * aVariance;
	}

	private static double Sigma() {
		
		return Sigma_max - ((Sigma_max - Sigma_min) * generationCount /G);
	}
}
