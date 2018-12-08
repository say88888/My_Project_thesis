package Algorithm_Carpool.PSO_LS_SetBased;

import java.util.Random;

public class V_Individual extends PSO_LS_SetBased{

    static int defaultGeneLengthA =D;
    static int defaultGeneLengthB =P;
    private double[][]V=new double[defaultGeneLengthA][defaultGeneLengthB];
  
    // Cache
    private double fitness = 0;
      Random ran=new Random();
	
    public void V_velocityIndividual() {
    	for (int d = 0; d < defaultGeneLengthA; d++) {
			for (int p = 0; p < defaultGeneLengthB; p++) {
			V[d][p]=0;
				}
    		}
    }

    	
    /* Getters and setters */
    // Use this if you want to create individuals with different gene lengths 如果你想創建具有不同基因的長度個體使用本
    public static void setDefaultGeneLengthV(int length) {
           defaultGeneLengthA = length;
       }
    public static void setDefaultGeneLengthVprob(int length) {
        	defaultGeneLengthB = length;
    }     
    
    
    public double getV(int index,int index1){
    	return V[index][index1];
    }
    

    public void setV(int index,int index1, double value) {
        V[index][index1] = value;
        fitness = 0;
    }
 
 
   
    /* Public methods */
    public int Vsize() {
        return V.length;
    }
    public int Vsize1(int i) {
        return V[i].length;
    }
// Cache

@Override
public String toString() {
    String geneString = "";
    geneString+=",";
	for (int i = 0; i < Vsize(); i++) {
		for (int j = 0; j < Vsize1(i); j++) {
		geneString += getV(i,j);
		}
	}
    return geneString;
}
}

