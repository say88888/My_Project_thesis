package Algorithm_DoubleAuction.ALPSO2_NEW_PrematureConvegence1_DA;

import java.util.Random;

public class Candidate_Individual extends ALPSO2_NEW_PrematureConvegence1{

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

