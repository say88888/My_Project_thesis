package Algorithm_DoubleAuction.DMSDL_PSO2_DA;

import java.util.Random;

 

public class GV_Individual extends DMSDL_PSO2{

    static int defaultGeneLengthX =Xsize ;
    private int[]GVx=new int[defaultGeneLengthX];
    static int defaultGeneLengthY =Ysize ;
    private int[] GVy = new int[defaultGeneLengthY];
    
    // Cache
    private double fitness = 0;
    private double fitness1 = 0;
      Random ran=new Random();
	
    public void XglobalIndividual() {
    	   defaultGeneLengthX =Xsize ;
    	   GVx=new int[defaultGeneLengthX];
    	    
    	for (int i = 0; i <GVxsize(); i++)
    	{ 
    	 
    	GVx[i]=PSO_Read_Write_txt.random_generate_or_read(Execution_Mode) ;
    	}
    	}
    
    	public void YglobalIndividual() {
    	defaultGeneLengthY =Ysize ;
   	     GVy = new int[defaultGeneLengthY];
    	for (int i = 0; i <GVysize(); i++)
    	{
    	GVy[i]=PSO_Read_Write_txt.random_generate_or_read(Execution_Mode) ;
    	}

    	}
    	 

    	
    /* Getters and setters */
    // GVse this if you want to create individuals with different gene lengths 如果你想創建具有不同基因的長度個體使用本
    public static void setDefaultGeneLengthX(int length) {
           defaultGeneLengthX = length;
       }
    public static void setDefaultGeneLengthY(int length) {
        defaultGeneLengthY = length;
    }     
    
    
    public int getGVx(int index){
    	return GVx[index];
    }
    
    
   
    public int getGVy(int index){
    	return GVy[index];
    }
   
   
    public void setGVx(int index, int value) {
        GVx[index] = value;
        fitness = 0;
        fitness1 = 0;
    }
  
    public void setGVy(int index, int value) {
        GVy[index] = value;
        fitness = 0;
        fitness1 = 0;
    }
 
   
    /* Public methods */
    public int GVxsize() {
        return GVx.length;
    }
    public int GVysize() {
        return GVy.length;
    }
  
    public double getFitness1() {
        if (fitness == 0) {
           fitness = FitnessCalc.getGVFitness(this);
        
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
    for (int i = 0; i < GVysize(); i++) {
        geneString += getGVy(i);
    }
    geneString+=",";
	for (int i = 0; i < GVxsize(); i++) {
		geneString += getGVx(i);
	}
    return geneString;
}
}

