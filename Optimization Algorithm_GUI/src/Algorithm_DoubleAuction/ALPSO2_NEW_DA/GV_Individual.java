package Algorithm_DoubleAuction.ALPSO2_NEW_DA;

import java.util.Random;



public class GV_Individual extends ALPSO2_NEW{

    static int defaultGeneLengthX =Xsize ;
    private double[]GVx=new double[defaultGeneLengthX];
    static int defaultGeneLengthY =Ysize ;
    private double[] GVy = new double[defaultGeneLengthY];
  
    // Cache
    private double fitness = 0;
      Random ran=new Random();
	
    public void XvelocityIndividual() {
    	for (int i = 0; i <GVxsize(); i++)
    	{ 
    	GVx[i]=PSO_Read_Write_txt.random_generate_or_read2(Execution_Mode);//Math.random()*(GVmax-(-GVmax))+(-GVmax);
    	}
    	}
    
    	public void YvelocityIndividual() {
    	for (int i = 0; i <GVysize(); i++)
    	{
    	GVy[i]=PSO_Read_Write_txt.random_generate_or_read2(Execution_Mode);//Math.random()*(GVmax-(-GVmax))+(-GVmax);
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
    
    
    public double getGVx(int index){
    	return GVx[index];
    }
    
    
   
    public double getGVy(int index){
    	return GVy[index];
    }
   
   
    public void setGVx(int index, double value) {
        GVx[index] = value;
        fitness = 0;
    }
  
    public void setGVy(int index, double value) {
        GVy[index] = value;
        fitness = 0;
    }
 
   
    /* Public methods */
    public int GVxsize() {
        return GVx.length;
    }
    public int GVysize() {
        return GVy.length;
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

