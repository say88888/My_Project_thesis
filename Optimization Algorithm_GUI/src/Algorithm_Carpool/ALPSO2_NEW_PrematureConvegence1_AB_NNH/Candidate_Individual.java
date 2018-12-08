package Algorithm_Carpool.ALPSO2_NEW_PrematureConvegence1_AB_NNH;

import java.util.Random;

public class Candidate_Individual extends ALPSO2_NEW_PrematureConvegence1_AB_NNH{

    static int defaultGeneLengthX =P ;
    private double[] X = new double[defaultGeneLengthX];
    private int[] binaryX = new int[D];
    private int[] A = new int[defaultGeneLengthX];
	private int[] rid = new int[defaultGeneLengthX];
	
    static int defaultGeneLengthY =P ;
    private double[] Y = new double[defaultGeneLengthY];
	private int[] binaryY = new int[P];
	private int[] B = new int[defaultGeneLengthY*2];
	private int[] Si = new int[defaultGeneLengthY];
    // Cache
    private double fitness = 0;
      Random ran=new Random();
	
    public void XgenerateIndividual() {
    	  defaultGeneLengthX =P ;
    	  X = new double[defaultGeneLengthX];
    	  binaryX = new int[D];
    	  binaryY = new int[P];
    	  A = new int[defaultGeneLengthX];
    	  rid= new int[defaultGeneLengthX];
    	for (int i = 0; i <P; i++)
    	{ 
    	X[i]= PSO_Read_Write_txt.random_generate_or_read2(Execution_Mode) ;
    	if(Md.get(i).size()>0){
			rid[i]=(int) Math.round(((Md.get(i).size()-1)*(X[i]+Vmax))/(2*Vmax)+1);
		}
		else 
		{
			rid[i]=0;
		}
    	}
    	A=Convert_Function.Get_A(rid);
		binaryX=Convert_Function.Get_binaryX(A);
		binaryY=Convert_Function.Get_binaryY(A);
    	}
    
    	public void YgenerateIndividual() {
    	defaultGeneLengthY =P ;
    	Y = new double[defaultGeneLengthY];
		B = new int[defaultGeneLengthY*2];
		Si = new int[defaultGeneLengthY];
		double[] si= new double[defaultGeneLengthY];
    	for (int i = 0; i < P; i++)
    	{
    	Y[i]=PSO_Read_Write_txt.random_generate_or_read2(Execution_Mode) ;
    	si[i]=Y[i];
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
		Si=Si_p;
			
		B=Convert_Function.Get_B(A,Si);
    	}
    	

    	
    /* Getters and setters */
    // Use this if you want to create individuals with different gene lengths 如果你想創建具有不同基因的長度個體使用本
    public static void setDefaultGeneLengthX(int length) {
           defaultGeneLengthX = length;
       }
    public static void setDefaultGeneLengthY(int length) {
        defaultGeneLengthY = length;
    }     
    
    public double getX(int index) {
        return X[index];
    }
 
    public double getY(int index) {
        return Y[index];
    }
  
    public void setX(int index, double value) {
        X[index] = value;
        fitness = 0;
    }
 
    public void setY(int index, double value) {
        Y[index] = value;
        fitness = 0;
    }
    public int getbinaryX(int index) {
		return binaryX[index];
	}

	public int getbinaryY(int index) {
		return binaryY[index];
	}
	public void setbinaryX(int index, int value) {
		binaryX[index] = value;
		fitness = 0;
	}

	public void setbinaryY(int index, int value) {
		binaryY[index] = value;
		fitness = 0;
	}
	public int getrid(int index) {
		return rid[index];
	}

	public int getSi(int index) {
		return Si[index];
	}

	public void setrid(int index, int value) {
		rid[index] = value;
		fitness = 0;
	}

	public void setSi(int index, int value) {
		Si[index] = value;
		fitness = 0;
	}

	public int getA(int index) {
		return A[index];
	}

	public int getB(int index) {
		return B[index];
	}

	public void setA(int index, int value) {
		A[index] = value;
		fitness = 0;
	}

	public void setB(int index, int value) {
		B[index] = value;
		fitness = 0;
	}
    /* Public methods */
    public int Xsize() {
        return X.length;
    }
    public int Ysize() {
        return Y.length;
    }
    public int binaryXsize() {
		return binaryX.length;
	}

	public int binaryYsize() {
		return binaryY.length;
	}
	public int Asize() {
		return A.length;
	}
	public int Bsize() {
		return B.length;
	}
	
    public double getFitness() {
    	
        if (fitness == 0) {
           fitness = FitnessCalc.getFitness1(this);
        
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
    for (int i = 0; i < Ysize(); i++) {
        geneString += getY(i);
    }
    geneString+=",";
	for (int i = 0; i < Xsize(); i++) {
		geneString += getX(i);
	}
    return geneString;
}
}

