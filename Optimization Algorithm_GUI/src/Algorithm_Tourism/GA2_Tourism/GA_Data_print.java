package Algorithm_Tourism.GA2_Tourism;
 
public class GA_Data_print  extends GA2_Tourism{
	
	public static void print2(Population pop,int Print_Mode)   {
		if(Print_Mode==1){
		System.out.println("----------------");
    	for (int i = 0; i < pop.populationSize; i++) {
    		
    		String[] xy=pop.getIndividual(i).toString().split(",");
    		System.out.println(i+" Y="+xy[0]);
    		System.out.println("  X="+xy[1]);
    		System.out.println("  fitness="+pop.getIndividual(i).getFitness2());
    		//System.out.println(" Sfmin=" +pop.getminFittest().getFitness());
    	}
    	System.out.println();
    	//System.out.println(sb2);
		}
	}
}
