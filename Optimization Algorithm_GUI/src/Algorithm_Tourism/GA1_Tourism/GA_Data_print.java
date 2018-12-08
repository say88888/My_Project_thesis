package Algorithm_Tourism.GA1_Tourism;

 


public class GA_Data_print  extends GA1_Tourism{
 
	public static void print1(Population pop,int Print_Mode)   {
		if(Print_Mode==1){
		System.out.println("----------------");
    	for (int i = 0; i < pop.populationSize; i++) {
    		
    		String[] xy=pop.getIndividual(i).toString().split(",");
    		System.out.println(i+" Y="+xy[0]);
    		System.out.println("  X="+xy[1]);
    		System.out.println("  fitness="+pop.getIndividual(i).getFitness1());
    	}
    	System.out.println();
    	//System.out.println(sb2);
		}
	}
 
 
}
