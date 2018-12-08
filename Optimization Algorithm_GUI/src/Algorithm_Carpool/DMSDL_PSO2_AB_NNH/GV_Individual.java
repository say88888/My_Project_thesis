package Algorithm_Carpool.DMSDL_PSO2_AB_NNH;

import java.util.Random;

public class GV_Individual extends DMSDL_PSO2_AB_NNH{
    static int defaultGeneLengthX =P ;
    private double[]GVx=new double[defaultGeneLengthX];
    private int[] binaryGVx = new int[D];
    private int[] GVA = new int[defaultGeneLengthX];
	private int[] GVrid = new int[defaultGeneLengthX];
	
    static int defaultGeneLengthY =P ;
    private double[] GVy = new double[defaultGeneLengthY];
    private int[] binaryGVy = new int[P];
	private int[] GVB = new int[defaultGeneLengthY*2];
	private int[] GVSi = new int[defaultGeneLengthY];
    // Cache
    private double fitness = 0;
    private double fitness1 = 0;
      Random ran=new Random();
	
    public void XglobalIndividual() {
        defaultGeneLengthX =P ;
        GVx=new double[defaultGeneLengthX];
   	  	binaryGVx = new int[D];
   	  	binaryGVy = new int[P];
   	  	GVA = new int[defaultGeneLengthX];
   	  	GVrid= new int[defaultGeneLengthX];
    	for (int i = 0; i <P; i++)
    	{ 
    	GVx[i]=PSO_Read_Write_txt.random_generate_or_read2(Execution_Mode) ;
    	if(Md.get(i).size()>0){
			GVrid[i]=(int) Math.round(((Md.get(i).size()-1)*(GVx[i]+Vmax))/(2*Vmax)+1);
		}
		else 
		{
			GVrid[i]=0;
		}
    	}
    	GVA=Convert_Function.Get_A(GVrid);
		binaryGVx=Convert_Function.Get_binaryX(GVA);
		binaryGVy=Convert_Function.Get_binaryY(GVA);
    	}
    
    	public void YglobalIndividual() {
    	defaultGeneLengthY =P ;
    	GVy = new double[defaultGeneLengthY];
    	GVB = new int[defaultGeneLengthY*2];
    	GVSi = new int[defaultGeneLengthY];
    	Double[] si= new Double[defaultGeneLengthY];
    	for (int i = 0; i < P; i++)
    	{
    	GVy[i]=PSO_Read_Write_txt.random_generate_or_read2(Execution_Mode) ;
    	si[i]=GVy[i];
    	}
      	int[] Si_p=new int[P];
    		for(int i=0;i<P;i++)
    			Si_p[i]=i+1;
    		for(int i=0;i<P-1;i++)
    			for(int j=0;j<P-1;j++)
    			{
    				if(si[j]<si[j+1]){
    					double temp;
    					temp=si[j];
    					si[j]=si[j+1];
    					si[j+1]=temp;
    					int temp1;
    					temp1=Si_p[j];
    					Si_p[j]=Si_p[j+1];
    					Si_p[j+1]=temp1;
    				}
    			}
    	GVSi=Si_p;
    			
    	GVB=Convert_Function.Get_B(GVA,GVSi);
    	}
    	 

    	
    /* Getters and setters */
    // Use this if you want to create individuals with different gene lengths 如果你想創建具有不同基因的長度個體使用本
    public static void setDefaultGeneLengthX(int length) {
           defaultGeneLengthX = length;
       }
    public static void setDefaultGeneLengthY(int length) {
        defaultGeneLengthY = length;
    }     
    
    public double getGVx(int index){
    	return GVx[index];
    }
    public double getGVy(int index){
    	return GVy[index];
    }
    public void setGVx(int index, double value) {
        GVx[index] = value;
        fitness = 0;
        fitness1 = 0;
    }
    public void setGVy(int index, double value) {
        GVy[index] = value;
        fitness = 0;
        fitness1 = 0;
    }
    public int getbinaryGVx(int index) {
		return binaryGVx[index];
	}

	public int getbinaryGVy(int index) {
		return binaryGVy[index];
	}

	public void setbinaryGVx(int index, int value) {
		binaryGVx[index] = value;
		fitness = 0;
		fitness1 = 0;
	}

	public void setbinaryGVy(int index, int value) {
		binaryGVy[index] = value;
		fitness = 0;
		fitness1 = 0;
	}
	
	public int getGVrid(int index) {
		return GVrid[index];
	}

	public int getGVSi(int index) {
		return GVSi[index];
	}

	public void setGVrid(int index, int value) {
		GVrid[index] = value;
		fitness = 0;
		fitness1 = 0;
	}

	public void setGVSi(int index, int value) {
		GVSi[index] = value;
		fitness = 0;
		fitness1 = 0;
	}
	public int getGVA(int index) {
		return GVA[index];
	}

	public int getGVB(int index) {
		return GVB[index];
	}

	public void setGVA(int index, int value) {
		GVA[index] = value;
		fitness = 0;
		fitness1 = 0;
	}

	public void setGVB(int index, int value) {
		GVB[index] = value;
		fitness = 0;
		fitness1 = 0;
	}
   
    /* Public methods */
    public int GVxsize() {
        return GVx.length;
    }
    public int GVysize() {
        return GVy.length;
    }
    public int binaryGVxsize() {
		return binaryGVx.length;
	}

	public int binaryGVysize() {
		return binaryGVy.length;
	}
	
	public int GVAsize() {
		return GVA.length;
	}

	public int GVBsize() {
		return GVB.length;
	}

	public void setfitness() {
		fitness = 0;
	}
    
    public double getFitness1() {
        if (fitness == 0) {
           fitness = FitnessCalc.getGVFitness(this);
        }
        return fitness;
    } 
   
// Cache

@Override
public String toString() {
    String geneString = "";
    for (int i = 0; i < GVysize(); i++) {
        geneString += getGVy(i);
    }
    geneString+=",";
	for (int i = 0; i < GVxsize(); i++) {
		geneString += getGVx(i);
	}
    return geneString;
}
}

