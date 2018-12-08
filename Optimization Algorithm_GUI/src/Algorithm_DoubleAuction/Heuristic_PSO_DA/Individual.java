package Algorithm_DoubleAuction.Heuristic_PSO_DA;

import java.util.Random;

import Algorithm_DoubleAuction.Heuristic_PSO_DA.Initialization_PSO.Initialzation_PSO2;

 
public class Individual extends Heuristic_PSO_DA{

    static int defaultGeneLengthX =Xsize ;
    private int[] X = new int[defaultGeneLengthX];
 
    static int defaultGeneLengthY =Ysize ;
    private int[] Y = new int[defaultGeneLengthY];
    
    // Cache
    private double fitness = 0;
      Random ran=new Random();
	
    public void XgenerateIndividual() {
    	for (int i = 0; i <Xsize(); i++)
    	{ 
    		X[i]=Initialzation_PSO2.X(i);
    	//X[i]= PSO_Read_Write_txt.random_generate_or_read(Execution_Mode) ;
    	//	System.err.println("X="+X[i]);
    	}
    	}
    
    	public void YgenerateIndividual(int n) {
    	for (int i = 0; i <Ysize(); i++)
    	{
    		if(i==n)
    			Y[i]=Initialzation_PSO2.Y(0);
    		else
    			Y[i]=0;
    	//	System.err.println("Y="+Y[i]);
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
   
    public double getFitness() {
        if (fitness == 0) {
           fitness = FitnessCalc.getFitness1(this);
        
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

