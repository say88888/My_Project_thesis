package Algorithm_Carpool.CC_CLPSO2_AB_2Si_ApproachII;

import java.util.Random;

public class E_Individual extends CC_CLPSO2_AB_2Si_ApproachII{

    static int defaultGeneLengthX =P ;
    private double[]Ex=new double[defaultGeneLengthX];
    private int[] binaryEx = new int[D];
    private int[] EA = new int[defaultGeneLengthX];
	private int[] Erid = new int[defaultGeneLengthX];
    
    static int defaultGeneLengthY =2*P ;
    private double[] Ey = new double[defaultGeneLengthY];
    private int[] binaryEy = new int[P];
	private int[] EB = new int[defaultGeneLengthY];
	private int[] ESi = new int[defaultGeneLengthY];
    // Cache
    private double fitness = 0;
    Random ran=new Random();
	
    public void XglobalIndividual() {
    	defaultGeneLengthX =P ;
    	Ex=new double[defaultGeneLengthX];
    	binaryEx = new int[D];
   	  	binaryEy = new int[P];
   	  	EA = new int[defaultGeneLengthX];
   	  	Erid= new int[defaultGeneLengthX];
    	for (int i = 0; i <Exsize(); i++)
    	{ 
    	Ex[i]=PSO_Read_Write_txt.random_generate_or_read2(Execution_Mode) ;
    	if(Md.get(i).size()>0){
			Erid[i]=(int) Math.round(((Md.get(i).size()-1)*(Ex[i]+Vmax))/(2*Vmax)+1);
		}
		else 
		{
			Erid[i]=0;
		}
    	}
    	}
    
    	public void YglobalIndividual() {
    	defaultGeneLengthY =2*P ;
    	Ey = new double[defaultGeneLengthY];
    	EB = new int[defaultGeneLengthY];
    	ESi = new int[defaultGeneLengthY];
    	Double[] si= new Double[defaultGeneLengthY];
    	for (int i = 0; i <Eysize(); i++)
    	{
    	Ey[i]=PSO_Read_Write_txt.random_generate_or_read2(Execution_Mode) ;
    	si[i]=Ey[i];
    	}
    	
    	//Step2  If the value of passenger location d+ is less than the value of passenger location d-, swap the values of passenger location d+ and the value of passenger location d-.
		for(int i=0;i<P;i++)
		{
			if(si[i]<si[i+P])
			{
				double temp;
				temp=si[i];
				si[i]=si[i+P];
				si[i+P]=temp;
			}
		}

		//Step3  If the value of passenger location d+ is less than the value of passenger location d-, swap the values of passenger location d+ and the value of passenger location d-.
     
    	int[] Si_p=new int[defaultGeneLengthY];
		for(int i=0;i<P;i++)
			Si_p[i]=i+1;
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
		ESi=Si_p;
			
		EB=Convert_Function.Get_B(EA,ESi);
    	}
    	 

    	
    /* Getters and setters */
    // Use this if you want to create individuals with different gene lengths 如果你想創建具有不同基因的長度個體使用本
    public static void setDefaultGeneLengthX(int length) {
           defaultGeneLengthX = length;
       }
    public static void setDefaultGeneLengthY(int length) {
        defaultGeneLengthY = length;
    }     
    
    
    public double getEx(int index){
    	return Ex[index];
    }
    
    
   
    public double getEy(int index){
    	return Ey[index];
    }
   
   
    public void setEx(int index, int value) {
        Ex[index] = value;
        fitness = 0;
    }
  
    public void setEy(int index, int value) {
        Ey[index] = value;
        fitness = 0;
    }
    public int getbinaryEx(int index) {
		return binaryEx[index];
	}

	public int getbinaryEy(int index) {
		return binaryEy[index];
	}
	
	public void setbinaryEx(int index, int value) {
		binaryEx[index] = value;
		fitness = 0;
	}

	public void setbinaryEy(int index, int value) {
		binaryEy[index] = value;
		fitness = 0;
	}
	public int getErid(int index) {
		return Erid[index];
	}

	public int getESi(int index) {
		return ESi[index];
	}

	public void setErid(int index, int value) {
		Erid[index] = value;
		fitness = 0;
	}

	public void setESi(int index, int value) {
		ESi[index] = value;
		fitness = 0;
	}

	public int getEA(int index) {
		return EA[index];
	}

	public int getEB(int index) {
		return EB[index];
	}

	public void setEA(int index, int value) {
		EA[index] = value;
		fitness = 0;
	}

	public void setEB(int index, int value) {
		EB[index] = value;
		fitness = 0;
	}
   
    /* Public methods */
    public int Exsize() {
        return Ex.length;
    }
    public int Eysize() {
        return Ey.length;
    }
    public int binaryExsize() {
		return binaryEx.length;
	}
	public int binaryEysize() {
		return binaryEy.length;
	}
	public int EAsize() {
		return EA.length;
	}
	public int EBsize() {
		return EB.length;
	}
   /* public double getFitness() {
        if (fitness1 == 0) {
           fitness1 = FitnessCalc.getFitness(this);
        
        }
        return fitness1;
    } */
    public double getFitness1() {
        if (fitness == 0) {
           fitness = FitnessCalc.getEFitness(this);
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
    for (int i = 0; i < Eysize(); i++) {
        geneString += getEy(i);
    }
    geneString+=",";
	for (int i = 0; i < Exsize(); i++) {
		geneString += getEx(i);
	}
    return geneString;
}
}

