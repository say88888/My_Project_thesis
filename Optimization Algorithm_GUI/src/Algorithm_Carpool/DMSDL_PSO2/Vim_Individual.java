package Algorithm_Carpool.DMSDL_PSO2;

import java.util.Random;



public class Vim_Individual extends DMSDL_PSO2{

    static int defaultGeneLengthX =Xsize ;
    private double[]Vimx=new double[defaultGeneLengthX];
    static int defaultGeneLengthY =Ysize ;
    private double[] Vimy = new double[defaultGeneLengthY];
  
    // Cache
    private double fitness = 0;
      Random ran=new Random();
	
    public void XvelocityIndividual() {
    	for (int i = 0; i <Vimxsize(); i++)
    	{ 
    	Vimx[i]=PSO_Read_Write_txt.random_generate_or_read2(Execution_Mode);//Math.random()*(Vimmax-(-Vimmax))+(-Vimmax);
    	}
    	}
    
    	public void YvelocityIndividual() {
    	for (int i = 0; i <Vimysize(); i++)
    	{
    	Vimy[i]=PSO_Read_Write_txt.random_generate_or_read2(Execution_Mode);//Math.random()*(Vimmax-(-Vimmax))+(-Vimmax);
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
    
    
    public double getVimx(int index){
    	return Vimx[index];
    }
    
    
   
    public double getVimy(int index){
    	return Vimy[index];
    }
   
   
    public void setVimx(int index, double value) {
        Vimx[index] = value;
        fitness = 0;
    }
  
    public void setVimy(int index, double value) {
        Vimy[index] = value;
        fitness = 0;
    }
 
   
    /* Public methods */
    public int Vimxsize() {
        return Vimx.length;
    }
    public int Vimysize() {
        return Vimy.length;
    }
   
 
  
  
   
// Cache

@Override
public String toString() {
    String geneString = "";
    for (int i = 0; i < Vimysize(); i++) {
        geneString += getVimy(i);
    }
    geneString+=",";
	for (int i = 0; i < Vimxsize(); i++) {
		geneString += getVimx(i);
	}
    return geneString;
}
}

