package Algorithm_Carpool.PSO2;

import java.util.Random;

 

 



public class G_Individual extends PSO2{

    static int defaultGeneLengthX =Xsize ;
    private int[]Gx=new int[defaultGeneLengthX];
    static int defaultGeneLengthY =Ysize ;
    private int[] Gy = new int[defaultGeneLengthY];
    // Cache
    private double fitness = 0;
    private double fitness1 = 0;
      Random ran=new Random();
	
    public void XglobalIndividual() {
    	for (int i = 0; i <Gxsize(); i++)
    	{ 
    	 
    	Gx[i]=PSO_Read_Write_txt.random_generate_or_read(Execution_Mode) ;
    	}
    	}
    
    	public void YglobalIndividual() {
    	for (int i = 0; i <Gysize(); i++)
    	{
    	Gy[i]=PSO_Read_Write_txt.random_generate_or_read(Execution_Mode) ;
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
    
    
    public int getGx(int index){
    	return Gx[index];
    }
    
    
   
    public int getGy(int index){
    	return Gy[index];
    }
   
    
    
    public void setGx(int index, int value) {
        Gx[index] = value;
        fitness = 0;
        fitness1 = 0;
    }
  
    public void setGy(int index, int value) {
        Gy[index] = value;
        fitness = 0;
        fitness1 = 0;
    }
 
    
    /* Public methods */
    public int Gxsize() {
        return Gx.length;
    }
    public int Gysize() {
        return Gy.length;
    }
  
    public double getFitness() {
        if (fitness1 == 0) {
           fitness1 = FitnessCalc.getFitness(this);
        
        }
        return fitness1;
    } 
    public double getFitness1() {
        if (fitness == 0) {
           fitness = FitnessCalc.getGFitness(this);
        
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
    for (int i = 0; i < Gysize(); i++) {
        geneString += getGy(i);
    }
    geneString+=",";
	for (int i = 0; i < Gxsize(); i++) {
		geneString += getGx(i);
	}
    return geneString;
}
}

