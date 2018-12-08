package Algorithm_Carpool.GA1;

 




public class Individual extends GA1{

    static int defaultGeneLengthX =Xsize ;
    private int[] X = new int[defaultGeneLengthX];
    static int defaultGeneLengthY =Ysize ;
    private int[] Y = new int[defaultGeneLengthY];
    // Cache
    private double fitness = 0;
    private double fitness1 = 0;
    static StringBuilder sb = new StringBuilder();
	
	
    
  
    public void XgenerateIndividual() {
    	for (int i = 0; i <Xsize(); i++)
    	{ if( (double)(random_generate_or_read(Execution_Mode) )<initialPopulationRate)
    	X[i]=0;
    	else
    	X[i]=1;
    	}

    	}
    	public void YgenerateIndividual() {
    	for (int i = 0; i <Ysize(); i++)
    	{ if( (double)(random_generate_or_read(Execution_Mode) )<initialPopulationRate)
    	Y[i]=0;
    	else
    	Y[i]=1;
    	}

    	}
    	

    	public double random_generate_or_read(int Execution_Mode) 
    	{
    	double xxx1; 
    	if (Execution_Mode == 0)
    	{
    	xxx1=Math.random();
    	sb.append(xxx1 + " ");
    	//GA_Read_Write_txt.write_to_evolution_log(sb);
    	if(Write_Mode==0){
    		long totalstartTime = System.currentTimeMillis();
    		GA_Read_Write_txt.write_to_evolution_log(sb);
    		long totalendTime = System.currentTimeMillis();
    		time_write_to_TXT+=(totalendTime-totalstartTime);
    		}
    	return xxx1;
    	}
    	else
    	{
    	return GA_Read_Write_txt.read_from_evolution_log();
    	}
    	}
    /* Getters and setters */
    // Use this if you want to create individuals with different gene lengths 如果你想創建具有不同基因的長度個體使用本
    public static void setDefaultGeneLengthX(int length) {
           defaultGeneLengthX = length;
       }
    public static void setDefaultGeneLengthY(int length) {
        defaultGeneLengthY = length;
    }     
    
    public int getX(int index) {
        return X[index];
    }
    public int getY(int index) {
        return Y[index];
    }
    
    public void setX(int index, int value) {
        X[index] = value;
        fitness = 0;
    }
    public void setY(int index, int value) {
        Y[index] = value;
        fitness = 0;
    }

   
    /* Public methods */
    public int Xsize() {
        return X.length;
    }
    public int Ysize() {
        return Y.length;
    }
 
    public  double getFitness() {
        if (fitness1 == 0) {
           fitness1 = FitnessCalc.getFitness_Function(this);
      
        }
        return fitness1;
    }
    public  double getFitness1() {
        if (fitness == 0) {
           fitness = FitnessCalc.getFitness_Function1(this);
      
        }
        return fitness;
    }
  
    public void setfitness() {
		fitness = 0;
	}
   
// Cache

@Override
public String toString() {
    String geneString = "";
    for (int i = 0; i < Ysize(); i++) {
        geneString += getY(i);
    }
    geneString+=",";
	for (int i = 0; i < Xsize(); i++) {
		geneString += getX(i);
	}
    return geneString;
}
}

