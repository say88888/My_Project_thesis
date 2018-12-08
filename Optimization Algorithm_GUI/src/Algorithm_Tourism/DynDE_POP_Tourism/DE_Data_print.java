package Algorithm_Tourism.DynDE_POP_Tourism;

 
public class DE_Data_print {
	public static void print2(Population pop,int Print_Mode)   {
		if(Print_Mode==1){
			System.out.println("---------------------");
			System.out.print("X=");
			
			for(int j=0;j<pop.getFittest().Gxasize();j++)
	   			 System.out.print(pop.getFittest().getGxa(j));
			System.out.println();
			System.out.print("Y=");
			 
	    		for(int j=0;j<pop.getFittest().Gysize();j++)
	    			 System.out.print(pop.getFittest().getGy(j));
	    		System.out.println(" fitness="+ pop.getFittest().getFitness1());
		System.out.println("----------------");
    
    	System.out.println();
     
		}
	}
}
