package Algorithm_DoubleAuction.Lagrangian_PSO_DA;

import java.util.Random;



public class V_Individual extends Double_Auction_ALPSO{

    static int defaultGeneLengthX =Xsize ;
    private double[]Vx=new double[defaultGeneLengthX];
    static int defaultGeneLengthY =Ysize ;
    private double[] Vy = new double[defaultGeneLengthY];
  
    // Cache
    private double fitness = 0;
      Random ran=new Random();
	
    public void XvelocityIndividual() {
    	for (int i = 0; i <Vxsize(); i++)
    	{ 
    	Vx[i]=PSO_Read_Write_txt.random_generate_or_read2(Execution_Mode);//Math.random()*(Vmax-(-Vmax))+(-Vmax);
    	}
    	}
    
    	public void YvelocityIndividual() {
    	for (int i = 0; i <Vysize(); i++)
    	{
    	Vy[i]=PSO_Read_Write_txt.random_generate_or_read2(Execution_Mode);//Math.random()*(Vmax-(-Vmax))+(-Vmax);
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
    
    
    public double getVx(int index){
    	return Vx[index];
    }
    
    
   
    public double getVy(int index){
    	return Vy[index];
    }
   
   
    public void setVx(int index, double value) {
        Vx[index] = value;
        fitness = 0;
    }
  
    public void setVy(int index, double value) {
        Vy[index] = value;
        fitness = 0;
    }
 
   
    /* Public methods */
    public int Vxsize() {
        return Vx.length;
    }
    public int Vysize() {
        return Vy.length;
    }
   
 
  
  
   
// Cache

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
}

