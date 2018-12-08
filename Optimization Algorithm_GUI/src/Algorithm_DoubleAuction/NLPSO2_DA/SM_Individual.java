package Algorithm_DoubleAuction.NLPSO2_DA;

import java.util.Random;

 

public class SM_Individual extends NLPSO2{

    static int defaultGeneLengthX =Xsize ;
    private double[]SMx=new double[defaultGeneLengthX];
    static int defaultGeneLengthY =Ysize ;
    private double[] SMy = new double[defaultGeneLengthY];
    
    // Cache
    private double fitness = 0;
    private double fitness1 = 0;
      Random ran=new Random();
	
    public void XglobalIndividual() {
    	   defaultGeneLengthX =Xsize ;
    	   SMx=new double[defaultGeneLengthX];
    	    
    	for (int i = 0; i <SMxsize(); i++)
    	{ 
    	 
    	SMx[i]=PSO_Read_Write_txt.random_generate_or_read2(Execution_Mode) ;
    	}
    	}
    
    	public void YglobalIndividual() {
    	defaultGeneLengthY =Ysize ;
   	     SMy = new double[defaultGeneLengthY];
    	for (int i = 0; i <SMysize(); i++)
    	{
    	SMy[i]=PSO_Read_Write_txt.random_generate_or_read2(Execution_Mode) ;
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
    
    
    public double getSMx(int index){
    	return SMx[index];
    }
    
    
   
    public double getSMy(int index){
    	return SMy[index];
    }
   
   
    public void setSMx(int index, double value) {
        SMx[index] = value;
        fitness = 0;
        fitness1 = 0;
    }
  
    public void setSMy(int index, double value) {
        SMy[index] = value;
        fitness = 0;
        fitness1 = 0;
    }
 
   
    /* Public methods */
    public int SMxsize() {
        return SMx.length;
    }
    public int SMysize() {
        return SMy.length;
    }
   
  
    public void setfitness() {
		fitness = 0;
	}
   
// Cache

@Override
public String toString() {
    String geneString = "";
    for (int i = 0; i < SMysize(); i++) {
        geneString += getSMy(i);
    }
    geneString+=",";
	for (int i = 0; i < SMxsize(); i++) {
		geneString += getSMx(i);
	}
    return geneString;
}
}

