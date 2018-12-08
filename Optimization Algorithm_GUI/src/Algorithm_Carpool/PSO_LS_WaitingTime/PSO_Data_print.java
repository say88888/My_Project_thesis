package Algorithm_Carpool.PSO_LS_WaitingTime;

 
public class PSO_Data_print {
	public static void print2(Population pop,int Print_Mode) {
		if(Print_Mode==1){
			System.out.println("---------------------");
			System.out.print("GAstring=");
			
			for(int j=0;j<pop.getFittest().GAsize();j++)
	   			 System.out.print(pop.getFittest().getGA(j));
			System.out.println();
			System.out.print("GBstring=");
			 
	    		for(int j=0;j<pop.getFittest().GBsize();j++)
	    			 System.out.print(pop.getFittest().getGB(j));
	    		System.out.println(" fitness="+ pop.getG_Individual().getFitness1());
		System.out.println("----------------");
    	for (int i = 0; i < pop.size(); i++) {
    		
    		String[] xy=pop.getIndividual(i).toString().split(",");
    		System.out.println(i+" Bstring="+xy[0]);
    		System.out.println("  Astring="+xy[1]);
    	 
    		 
    		System.out.println("  fitness="+pop.getIndividual(i).getFitness());
    	 
    	}
    	System.out.println();
     
		}
	}
}
