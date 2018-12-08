package Algorithm_Tourism.SaNSDE_POP_NEW_Tourism;

 
 
public class DE_Data_print {
	public static void print2(Population pop,int Print_Mode)   {
		if(Print_Mode==1){
			System.out.println("---------------------");
			System.out.print("X=");
			
			for(int j=0;j<pop.getFittest().Xasize();j++)
	   			 System.out.print(pop.getFittest().getXa(j));
			System.out.println();
			System.out.print("Y=");
			 
	    		for(int j=0;j<pop.getFittest().Ysize();j++)
	    			 System.out.print(pop.getFittest().getY(j));
	    		System.out.println(" fitness="+ pop.getFittest().getFitness1());
		System.out.println("----------------");
    
    	System.out.println();
     
		}
	}
}
