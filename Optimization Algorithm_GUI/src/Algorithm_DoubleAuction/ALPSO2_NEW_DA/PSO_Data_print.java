package Algorithm_DoubleAuction.ALPSO2_NEW_DA;

 
public class PSO_Data_print {
	public static void print2(Population pop,int Print_Mode) {
		if(Print_Mode==1){
			System.out.println("---------------------");
			System.out.print("Gx=");
			
			for(int j=0;j<pop.getFittest().Gxsize();j++)
	   			 System.out.print(pop.getFittest().getGx(j));
			System.out.println();
			System.out.print("Gy=");
			 
	    		for(int j=0;j<pop.getFittest().Gysize();j++)
	    			 System.out.print(pop.getFittest().getGy(j));
	    		System.out.println(" fitness="+ pop.getG_Individual().getFitness1());
		System.out.println("----------------");
    	for (int i = 0; i < pop.size(); i++) {
    		
    		String[] xy=pop.getIndividual(i).toString().split(",");
    		System.out.println(i+" Y="+xy[0]);
    		System.out.println("  X="+xy[1]);
    	 
    		 
    		System.out.println("  fitness="+pop.getIndividual(i).getFitness());
    	 
    	}
    	System.out.println();
     
		}
	}
}
