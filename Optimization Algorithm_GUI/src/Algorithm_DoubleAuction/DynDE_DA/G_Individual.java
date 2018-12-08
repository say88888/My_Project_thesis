package Algorithm_DoubleAuction.DynDE_DA;

import java.util.Random;

public class G_Individual extends DynDE{

	static int defaultGeneLengthX = Xsize;
	private double[] Gx = new double[defaultGeneLengthX];
	private int[] binaryGx = new int[defaultGeneLengthX];

	static int defaultGeneLengthY = Ysize;
	private double[] Gy = new double[defaultGeneLengthY];
	private int[] binaryGy = new int[defaultGeneLengthY];
    
    // Cache
    private double fitness = 0;
    private double fitness1 = 0;
      Random ran=new Random();
	
    public void XglobalIndividual() {
    	defaultGeneLengthX = Xsize;
		Gx = new double[defaultGeneLengthX];
		binaryGx = new int[defaultGeneLengthX];
		for (int i = 0; i < Gxsize(); i++) {
			Gx[i] = DE_Read_Write_txt.random_generate_or_read4(Execution_Mode);
			double rsid = DE_Read_Write_txt
					.random_generate_or_read1(Execution_Mode);
			if (rsid < 1 / (1 + Math.exp(-lamda * Gx[i]))) {
				binaryGx[i] = 1;
			} else {
				binaryGx[i] = 0;
			}
		}
    	}
    
    	public void YglobalIndividual() {
    		defaultGeneLengthY = Ysize;
    		Gy = new double[defaultGeneLengthY];
    		binaryGy = new int[defaultGeneLengthY];
    		for (int i = 0; i < Gysize(); i++) {
    			Gy[i] = DE_Read_Write_txt.random_generate_or_read4(Execution_Mode);
    			double rsid = DE_Read_Write_txt
    					.random_generate_or_read1(Execution_Mode);
    			if (rsid < 1 / (1 + Math.exp(-lamda * Gy[i]))) {
    				binaryGy[i] = 1;
    			} else {
    				binaryGy[i] = 0;
    			}
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
    
    
    public double getGx(int index){
    	return Gx[index];
    }
    
    public double getGy(int index){
    	return Gy[index];
    }
   
    public int getbinaryGx(int index){
    	return binaryGx[index];
    }
    
    public int getbinaryGy(int index){
    	return binaryGy[index];
    }
   
    public void setGx(int index, double value) {
        Gx[index] = value;
        fitness = 0;
        fitness1 = 0;
    }
  
    public void setGy(int index, double value) {
        Gy[index] = value;
        fitness = 0;
        fitness1 = 0;
    }
 
    public void setbinaryGx(int index, int value) {
    	binaryGx[index] = value;
        fitness = 0;
        fitness1 = 0;
    }
  
    public void setbinaryGy(int index, int value) {
    	binaryGy[index] = value;
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

