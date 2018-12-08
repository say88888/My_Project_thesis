package Algorithm_DoubleAuction.GA2_DA;

 




public class SA {

	public static Population SA_f2(double N_1, Population pop, int SA_Mode) {
		if (SA_Mode == 1) {
			double T =GA_Read_Write_txt.T();
			double f = N_1 - pop.getFittest2().getFitness2();
			double r = 0.05;// Math.random();
			double Factor_T=GA_Read_Write_txt.Factor_T();
			while (T >= 1) {
				if (f < 0)
					break;
				else {
					
					//System.out.println(pop.getFittest2()+" "+pop.getFittest2().getFitness2());
					if (Math.exp(-f / T) < r ){
						break;}
					else {
						pop = Algorithm.evolvePopulation(pop);
					 //System.out.println(pop.getFittest2()+" "+pop.getFittest2().getFitness2());
				
					}
				f = N_1 - pop.getFittest2().getFitness2();
				}
				T *= Factor_T;
		
			}
		}		
		return pop;

	}
	
}
