package Algorithm_Carpool.FA_PSO_AB_NNH;

import java.util.Random;

public class G_Individual extends FA_PSO_AB_NNH{

    static int defaultGeneLengthX =P ;
    private double[]Gx=new double[defaultGeneLengthX];
    private int[] binaryGx = new int[D];
    private int[] GA = new int[defaultGeneLengthX];
	private int[] Grid = new int[defaultGeneLengthX];
	
    static int defaultGeneLengthY =P ;
    private double[] Gy = new double[defaultGeneLengthY];
    private int[] binaryGy = new int[P];
	private int[] GB = new int[defaultGeneLengthY*2];
	private int[] GSi = new int[defaultGeneLengthY];
    // Cache
    private double fitness = 0;
    private double fitness1 = 0;
      Random ran=new Random();
	
    public void XglobalIndividual() {
         defaultGeneLengthX =P ;
         Gx=new double[defaultGeneLengthX];
   	  	binaryGx = new int[D];
   	  	binaryGy = new int[P];
   	  	GA = new int[defaultGeneLengthX];
   	  	Grid= new int[defaultGeneLengthX];
    	for (int i = 0; i <P; i++)
    	{ 
    	Gx[i]=PSO_Read_Write_txt.random_generate_or_read2(Execution_Mode) ;
    	if(Md.get(i).size()>0){
			Grid[i]=(int) Math.round(((Md.get(i).size()-1)*(Gx[i]+Vmax))/(2*Vmax)+1);
		}
		else 
		{
			Grid[i]=0;
		}
    	}
    	GA=Convert_Function.Get_A(Grid);
		binaryGx=Convert_Function.Get_binaryX(GA);
		binaryGy=Convert_Function.Get_binaryY(GA);
    	}
    
    	public void YglobalIndividual() {
    	defaultGeneLengthY =P ;
    	Gy = new double[defaultGeneLengthY];
    	GB = new int[defaultGeneLengthY*2];
    	GSi = new int[defaultGeneLengthY];
    	Double[] si= new Double[defaultGeneLengthY];
    	for (int i = 0; i < P; i++)
    	{
    	Gy[i]=PSO_Read_Write_txt.random_generate_or_read2(Execution_Mode) ;
    	si[i]=Gy[i];
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
    	GSi=Si_p;
    			
    	GB=Convert_Function.Get_B(GA,GSi);
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
    public int getbinaryGx(int index) {
		return binaryGx[index];
	}

	public int getbinaryGy(int index) {
		return binaryGy[index];
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
	
	public int getGrid(int index) {
		return Grid[index];
	}

	public int getGSi(int index) {
		return GSi[index];
	}

	public void setGrid(int index, int value) {
		Grid[index] = value;
		fitness = 0;
		fitness1 = 0;
	}

	public void setGSi(int index, int value) {
		GSi[index] = value;
		fitness = 0;
		fitness1 = 0;
	}
	public int getGA(int index) {
		return GA[index];
	}

	public int getGB(int index) {
		return GB[index];
	}

	public void setGA(int index, int value) {
		GA[index] = value;
		fitness = 0;
		fitness1 = 0;
	}

	public void setGB(int index, int value) {
		GB[index] = value;
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
    public int binaryGxsize() {
		return binaryGx.length;
	}

	public int binaryGysize() {
		return binaryGy.length;
	}
	
	public int GAsize() {
		return GA.length;
	}

	public int GBsize() {
		return GB.length;
	}

	public void setfitness() {
		fitness = 0;
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

