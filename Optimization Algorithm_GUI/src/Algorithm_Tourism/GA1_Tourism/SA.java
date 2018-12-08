package Algorithm_Tourism.GA1_Tourism;
 

public class SA {
	 
	public static Population SA_f1(double N_1, Population pop, int SA_Mode)   {
		if (SA_Mode == 1) {
			double T =  GA_Read_Write_txt.T();
			double f = N_1 - pop.getFittest1().getFitness1();
			double r = 0.05;
			double Factor_T=GA_Read_Write_txt.Factor_T();
			while (T >= 1) {	
				if (f < 0)
					break;
				if (f >= 0) {
				
					// System.out.println(Math.exp(-f / T)+" "+Math.exp(f / T));
				
					if (Math.exp(-f / T) < r ){
						break;}
					else {
						pop = Algorithm.evolvePopulation(pop);
						//System.out.println(pop.getFittest1()+" "+pop.getFittest1().getFitness1());
						
					}
					f = N_1 - pop.getFittest1().getFitness1();
					}
				T *= Factor_T;
			
			}
		}	
		return pop;

	}
 
}
