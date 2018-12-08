package Algorithm_Carpool.PSO4;

import java.util.Random;

 



public class P_Individual extends PSO4{

    static int defaultGeneLengthX =Xsize ;
    private double[]Px=new double[defaultGeneLengthX];
    static int defaultGeneLengthY =Ysize ;
    private double[] Py = new double[defaultGeneLengthY];
  
    // Cache
    private double fitness = 0;
      Random ran=new Random();
	
    public void XpreviousIndividual() {
    	for (int i = 0; i <Pxsize(); i++)
    	{ 
    	Px[i]=PSO_Read_Write_txt.random_generate_or_read(Execution_Mode) ;
    	}
    	}
    
    	public void YpreviousIndividual() {
    	for (int i = 0; i <Pysize(); i++)
    	{
    	Py[i]=PSO_Read_Write_txt.random_generate_or_read(Execution_Mode) ;
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
    
    
    public double getPx(int index){
    	return Px[index];
    }
    
    
   
    public double getPy(int index){
    	return Py[index];
    }
   
   
    public void setPx(int index, double value) {
        Px[index] = value;
        fitness = 0;
    }
  
    public void setPy(int index, double value) {
        Py[index] = value;
        fitness = 0;
    }
 
   
    /* Public methods */
    public int Pxsize() {
        return Px.length;
    }
    public int Pysize() {
        return Py.length;
    }
   
    public double getFitness() {
        if (fitness == 0) {
           fitness = FitnessCalc.getPFitness(this);
        
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
    for (int i = 0; i < Pysize(); i++) {
        geneString += getPy(i);
    }
    geneString+=",";
	for (int i = 0; i < Pxsize(); i++) {
		geneString += getPx(i);
	}
    return geneString;
}
}

