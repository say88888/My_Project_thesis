package Algorithm_DoubleAuction.DE_DA_Porblem3;

import java.util.Random;

import Input_Output_txt.Double_Auction.Read_Seller_Price_Parameter;

 

public class U_Individual extends Double_Auction_DE_Problem3{

    static int defaultGeneLengthX =Xsize ;
    private int[]Ux=new int[defaultGeneLengthX];
    static int defaultGeneLengthY =Ysize ;
    private int[] Uy = new int[defaultGeneLengthY];
    
    // Cache
    private double fitness = 0;
    private double fitness1 = 0;
      Random ran=new Random();
	
    public void XglobalIndividual() {
    	for (int i = 0; i <Uxsize(); i++)
    	{ 
    	 
    	Ux[i]=DE_Read_Write_txt.random_generate_or_read2(Execution_Mode,Read_Seller_Price_Parameter.top()+1) ;
    	}
    	}
    
    	public void YglobalIndividual() {
    	for (int i = 0; i <Uysize(); i++)
    	{
    	Uy[i]=DE_Read_Write_txt.random_generate_or_read(Execution_Mode) ;
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
    
    
    public int getUx(int index){
    	return Ux[index];
    }
    
    
   
    public int getUy(int index){
    	return Uy[index];
    }
   
   
    public void setUx(int index, int value) {
        Ux[index] = value;
        fitness = 0;
        fitness1 = 0;
    }
  
    public void setUy(int index, int value) {
        Uy[index] = value;
        fitness = 0;
        fitness1 = 0;
    }
 
   
    /* Public methods */
    public int Uxsize() {
        return Ux.length;
    }
    public int Uysize() {
        return Uy.length;
    }
  
    public double getFitness1() {
        if (fitness == 0) {
           fitness = FitnessCalc.getUFitness(this);
        
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
    for (int i = 0; i < Uysize(); i++) {
        geneString += getUy(i);
    }
    geneString+=",";
	for (int i = 0; i < Uxsize(); i++) {
		geneString += getUx(i);
	}
    return geneString;
}
}

