package Algorithm_DoubleAuction.FA_PSO_DA;

import java.util.Random;

 

 



public class E_Individual extends Double_Auction_FA_PSO{

    static int defaultGeneLengthX =Xsize ;
    private int[]Ex=new int[defaultGeneLengthX];
    static int defaultGeneLengthY =Ysize ;
    private int[] Ey = new int[defaultGeneLengthY];
    
    // Cache
    private double fitness = 0;
    private double fitness1 = 0;
      Random ran=new Random();
	
    public void XglobalIndividual() {
    	for (int i = 0; i <Exsize(); i++)
    	{ 
    	 
    	Ex[i]=PSO_Read_Write_txt.random_generate_or_read(Execution_Mode) ;
    	}
    	}
    
    	public void YglobalIndividual() {
    	for (int i = 0; i <Eysize(); i++)
    	{
    	Ey[i]=PSO_Read_Write_txt.random_generate_or_read(Execution_Mode) ;
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
    
    
    public int getEx(int index){
    	return Ex[index];
    }
    
    
   
    public int getEy(int index){
    	return Ey[index];
    }
   
   
    public void setEx(int index, int value) {
        Ex[index] = value;
        fitness = 0;
        fitness1 = 0;

    }
  
    public void setEy(int index, int value) {
        Ey[index] = value;
        fitness = 0;
        fitness1 = 0;
    }
 
   
    /* Public methods */
    public int Exsize() {
        return Ex.length;
    }
    public int Eysize() {
        return Ey.length;
    }
   
   /* public double getFitness() {
        if (fitness1 == 0) {
           fitness1 = FitnessCalc.getFitness(this);
        
        }
        return fitness1;
    } */
    public double getFitness1() {
        if (fitness == 0) {
           fitness = FitnessCalc.getEFitness1(this);
        
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
    for (int i = 0; i < Eysize(); i++) {
        geneString += getEy(i);
    }
    geneString+=",";
	for (int i = 0; i < Exsize(); i++) {
		geneString += getEx(i);
	}
    return geneString;
}
}

