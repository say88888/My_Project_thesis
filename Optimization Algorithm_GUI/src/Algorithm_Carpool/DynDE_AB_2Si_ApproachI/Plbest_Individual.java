package Algorithm_Carpool.DynDE_AB_2Si_ApproachI;

import java.util.Random;

public class Plbest_Individual extends DynDE_AB_2Si_ApproachI{

    static int defaultGeneLengthX =P ;
    private double[]Px=new double[defaultGeneLengthX];
	private int[] binaryPx = new int[D];
	private int[] PA = new int[defaultGeneLengthX];
	private int[] Prid = new int[defaultGeneLengthX];
    static int defaultGeneLengthY =2*P ;
    private double[] Py = new double[defaultGeneLengthY];
    private int[] binaryPy = new int[P];
	private int[] PB = new int[defaultGeneLengthY];
	private int[] PSi = new int[defaultGeneLengthY];
    // Cache
    private double fitness = 0;
      Random ran=new Random();
	
    public void XglobalIndividual() {
    	   defaultGeneLengthX =P ;
    	   Px=new double[defaultGeneLengthX];
    	  binaryPx = new int[D];
     	  binaryPy = new int[P];
     	  PA = new int[defaultGeneLengthX];
     	  Prid= new int[defaultGeneLengthX];
    	for (int i = 0; i <Pxsize(); i++)
    	{ 
    	Px[i]=DE_Read_Write_txt.random_generate_or_read4(Execution_Mode) ;
    	if(Md.get(i).size()>0){
			Prid[i]=(int) Math.round(((Md.get(i).size()-1)*(Px[i]+Vmax))/(2*Vmax)+1);
		}
		else 
		{
			Prid[i]=0;
		}
    	}
    	PA=Convert_Function.Get_A(Prid);
		binaryPx=Convert_Function.Get_binaryX(PA);
		binaryPy=Convert_Function.Get_binaryY(PA);
    	}
    
    	public void YglobalIndividual() {
    		defaultGeneLengthY =2*P ;
        	Py = new double[defaultGeneLengthY];
    		PB = new int[defaultGeneLengthY];
    		PSi = new int[defaultGeneLengthY];
    		Double[] si= new Double[defaultGeneLengthY];
    	for (int i = 0; i <defaultGeneLengthY; i++)
    	{
    	Py[i]=DE_Read_Write_txt.random_generate_or_read4(Execution_Mode) ;
    	si[i]=Py[i];
    	}
    
		//Step3  If the value of passenger location d+ is less than the value of passenger location d-, swap the values of passenger location d+ and the value of passenger location d-.
    	int[] Si_p=new int[defaultGeneLengthY];
    	for(int i=0;i<P;i++) {
			Si_p[i]=i+1;
			Si_p[i+P]=-(i+1);
			}
		for(int i=0;i<defaultGeneLengthY-1;i++)
			for(int j=0;j<defaultGeneLengthY-1;j++)
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
		PSi=Si_p;
			
		PB=Convert_Function.Get_B(PA,PSi);
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
 
    public int getbinaryPx(int index) {
		return binaryPx[index];
	}

	public int getbinaryPy(int index) {
		return binaryPy[index];
	}
	public void setbinaryPx(int index, int value) {
		binaryPx[index] = value;
		fitness = 0;
	}

	public void setbinaryPy(int index, int value) {
		binaryPy[index] = value;
		fitness = 0;
	}
	public int getPrid(int index) {
		return Prid[index];
	}

	public int getPSi(int index) {
		return PSi[index];
	}

	public void setPrid(int index, int value) {
		Prid[index] = value;
		fitness = 0;
	}

	public void setPSi(int index, int value) {
		PSi[index] = value;
		fitness = 0;
	}

	public int getPA(int index) {
		return PA[index];
	}

	public int getPB(int index) {
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
    public int Pxsize() {
        return Px.length;
    }
    public int Pysize() {
        return Py.length;
    }
    public int binaryPxsize() {
		return binaryPx.length;
	}

	public int binaryPysize() {
		return binaryPy.length;
	}
	public int PAsize() {
		return PA.length;
	}
	public int PBsize() {
		return PB.length;
	}
    public double getFitness() {
        if (fitness == 0) {
           fitness = FitnessCalc.getPlbestFitness(this);
        
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

