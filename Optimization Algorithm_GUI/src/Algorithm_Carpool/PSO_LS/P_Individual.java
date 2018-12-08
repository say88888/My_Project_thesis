package Algorithm_Carpool.PSO_LS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import READ_TXT.Read_INPUT_TXT_filter;

 
public class P_Individual extends PSO_LS{

    static int defaultGeneLengthA =P ;
   
    static int defaultGeneLengthB =P ;
    private int[]PA=new int[defaultGeneLengthB];
    private int[] PB = new int[2*defaultGeneLengthB];
  
    // Cache
    private double fitness = 0;
      Random ran=new Random();
	
    public void ApreviousIndividual() {
    	int[] seat=new int[D];
		int[] Weight_Limit=new int[D];
		for (int i = 0; i < PAsize(); i++) {
			int k=Alist.get(i).get(PSO_Read_Write_txt.random_generate_or_readA(Execution_Mode,i)) ;
			if(k!=0){
				seat[k-1]+=1;
				Weight_Limit[k-1]+=Read_INPUT_TXT_filter.getweight(i);
			if((seat[k-1]<=Read_INPUT_TXT_filter.getP_NUMBER(k-1)&&(Weight_Limit[k-1]<=Read_INPUT_TXT_filter.getWeight_Limit(k-1))))
				PA[i] = k ;
			}
			else
				PA[i]=0;
		}
    }
    
    	public void BpreviousIndividual() {
    		Local_Serch.NNH(PA);
    		for (int i = 0; i < Bstring.size(); i++) 
    				PB[i] = Bstring.get(i);
    		
    	}
    	
    	 
    	
    /* Getters and setters */
    // Use this if you want to create individuals with different gene lengths 如果你想創建具有不同基因的長度個體使用本
    public static void setDefaultGeneLengthA(int length) {
           defaultGeneLengthA = length;
       }
    public static void setDefaultGeneLengthB(int length) {
        defaultGeneLengthB = length;
    }     
    
    
    public int getPA(int index){
    	return PA[index];
    }
    
    
   
    public int getPB(int index){
    	return PB[index];
    }
   
   
    public void setPA(int index, int value) {
        PA[index] = value;
        fitness = 0;
    }
  
    public void setPB(int index, int value) {
        PB[index] = value;
        fitness = 0;
    }
 
   
    /* Public methods */
    public int PAsize() {
        return PA.length;
    }
    public int PBsize() {
        return PB.length;
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
    for (int i = 0; i < PBsize(); i++) {
        geneString += getPB(i);
    }
    geneString+=",";
	for (int i = 0; i < PAsize(); i++) {
		geneString += getPA(i);
	}
    return geneString;
}
}

