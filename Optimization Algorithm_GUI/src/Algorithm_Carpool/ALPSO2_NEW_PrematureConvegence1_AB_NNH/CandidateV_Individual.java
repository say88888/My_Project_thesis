package Algorithm_Carpool.ALPSO2_NEW_PrematureConvegence1_AB_NNH;

import java.util.Random;

public class CandidateV_Individual extends ALPSO2_NEW_PrematureConvegence1_AB_NNH{

    static int defaultGeneLengthX =Xsize ;
    private double[]CandidateVx=new double[defaultGeneLengthX];
    static int defaultGeneLengthY =Ysize ;
    private double[] CandidateVy = new double[defaultGeneLengthY];
  
    // Cache
    private double fitness = 0;
      Random ran=new Random();
	
   public void XvelocityIndividual() {
    	for (int i = 0; i <CandidateVxsize(); i++)
    	{ 
    	CandidateVx[i]=PSO_Read_Write_txt.random_generate_or_read2(Execution_Mode);//Math.random()*(Vmax-(-Vmax))+(-Vmax);
    	}
    	}
    
    	public void YvelocityIndividual() {
    	for (int i = 0; i <CandidateVysize(); i++)
    	{
    	CandidateVy[i]=PSO_Read_Write_txt.random_generate_or_read2(Execution_Mode);//Math.random()*(Vmax-(-Vmax))+(-Vmax);
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
    
    
    public double getCandidateVx(int index){
    	return CandidateVx[index];
    }
    
    
   
    public double getCandidateVy(int index){
    	return CandidateVy[index];
    }
   
   
    public void setCandidateVx(int index, double value) {
        CandidateVx[index] = value;
        fitness = 0;
    }
  
    public void setCandidateVy(int index, double value) {
        CandidateVy[index] = value;
        fitness = 0;
    }
 
   
    /* Public methods */
    public int CandidateVxsize() {
        return CandidateVx.length;
    }
    public int CandidateVysize() {
        return CandidateVy.length;
    }
  
   
// Cache

@Override
public String toString() {
    String geneString = "";
    for (int i = 0; i < CandidateVysize(); i++) {
        geneString += getCandidateVy(i);
    }
    geneString+=",";
	for (int i = 0; i < CandidateVxsize(); i++) {
		geneString += getCandidateVx(i);
	}
    return geneString;
}
}

