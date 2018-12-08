package Algorithm_Carpool.PSO3;

import java.util.Random;

 



public class Individual extends PSO3{

    static int defaultGeneLengthX =Xsize ;
    private double[] X = new double[defaultGeneLengthX];
 
    static int defaultGeneLengthY =Ysize ;
    private double[] Y = new double[defaultGeneLengthY];
    
    // Cache
    private double fitness = 0;
      Random ran=new Random();
	
    public void XgenerateIndividual() {
    	for (int i = 0; i <Xsize(); i++)
    	{ 
    	X[i]= PSO_Read_Write_txt.random_generate_or_read(Execution_Mode) ;
   
    	}
    	}
    
    	public void YgenerateIndividual() {
    	for (int i = 0; i <Ysize(); i++)
    	{
    	Y[i]=PSO_Read_Write_txt.random_generate_or_read(Execution_Mode) ;
   
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
    
    public double getX(int index) {
        return X[index];
    }
 
    public double getY(int index) {
        return Y[index];
    }
  
    public void setX(int index, double value) {
        X[index] = value;
        fitness = 0;
    }
 
    public void setY(int index, double value) {
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

