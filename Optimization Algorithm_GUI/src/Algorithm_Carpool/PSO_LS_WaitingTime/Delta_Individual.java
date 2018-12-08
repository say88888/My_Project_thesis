package Algorithm_Carpool.PSO_LS_WaitingTime;

import java.util.Random;

public class Delta_Individual extends PSO_LS_WaitingTime{

    static int defaultGeneLengthX =D ;
    static int defaultGeneLengthY =P ;
    
    private double[][]Delta=new double[defaultGeneLengthX][defaultGeneLengthY*2];


    // Cache
    private double fitness = 0;
      Random ran=new Random();
	
    public void DvelocityIndividual() {
    	for (int i = 0; i <defaultGeneLengthX; i++)
    		for (int j = 0; j <defaultGeneLengthY*2; j++)
    			{ 
    			Delta[i][j]=PSO_Read_Write_txt.random_generate_or_read5(Execution_Mode);
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
    
    
    public double getDx(int index,int m){
    	return Delta[index][m];
    }
    
   
    public void setDx(int index, int m,double value) {
    	Delta[index][m] = value;
        fitness = 0;
    }
  
 
   
// Cache
/*
@Override
public String toString() {
    String geneString = "";
    for (int i = 0; i < Vysize(); i++) {
        geneString += getVy(i);
    }
    geneString+=",";
	for (int i = 0; i < Vxsize(); i++) {
		geneString += getVx(i);
	}
    return geneString;
	}	
	*/
}

