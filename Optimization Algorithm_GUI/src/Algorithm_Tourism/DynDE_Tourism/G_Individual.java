package Algorithm_Tourism.DynDE_Tourism;

 import java.util.Random;

public class G_Individual extends DynDE_Tourism{

	static int defaultGeneLengthXa = Xasize;
	private double[] Gxa = new double[defaultGeneLengthXa];
	private int[] binaryGxa = new int[defaultGeneLengthXa];
	static int defaultGeneLengthXh = Xhsize;
	private double[] Gxh = new double[defaultGeneLengthXh];
	private int[] binaryGxh = new int[defaultGeneLengthXh];
	static int defaultGeneLengthXt = Xtsize;
	private double[] Gxt = new double[defaultGeneLengthXt];
	private int[] binaryGxt = new int[defaultGeneLengthXt];
	static int defaultGeneLengthY = Ysize;
	private double[] Gy = new double[defaultGeneLengthY];
	private int[] binaryGy = new int[defaultGeneLengthY];
    
    // Cache
    private double fitness = 0;
    private double fitness1 = 0;
      Random ran=new Random();
	
    public void XglobalIndividual() {
    	defaultGeneLengthXa = Xasize;
		Gxa = new double[defaultGeneLengthXa];
		binaryGxa = new int[defaultGeneLengthXa];
		for (int i = 0; i < Gxasize(); i++) {
			Gxa[i] = DE_Read_Write_txt.random_generate_or_read4(Execution_Mode);
			double rsid = DE_Read_Write_txt
					.random_generate_or_read1(Execution_Mode);
			if (rsid < 1 / (1 + Math.exp(-lamda * Gxa[i]))) {
				binaryGxa[i] = 1;
			} else {
				binaryGxa[i] = 0;
			}
		}
		defaultGeneLengthXh = Xhsize;
		Gxh = new double[defaultGeneLengthXh];
		binaryGxh = new int[defaultGeneLengthXh];
		for (int i = 0; i < Gxhsize(); i++) {
			Gxh[i] = DE_Read_Write_txt.random_generate_or_read4(Execution_Mode);
			double rsid = DE_Read_Write_txt
					.random_generate_or_read1(Execution_Mode);
			if (rsid < 1 / (1 + Math.exp(-lamda * Gxh[i]))) {
				binaryGxh[i] = 1;
			} else {
				binaryGxh[i] = 0;
			}
		}
		defaultGeneLengthXt = Xtsize;
		Gxt = new double[defaultGeneLengthXt];
		binaryGxt = new int[defaultGeneLengthXt];
		for (int i = 0; i < Gxtsize(); i++) {
			Gxt[i] = DE_Read_Write_txt.random_generate_or_read4(Execution_Mode);
			double rsid = DE_Read_Write_txt
					.random_generate_or_read1(Execution_Mode);
			if (rsid < 1 / (1 + Math.exp(-lamda * Gxt[i]))) {
				binaryGxt[i] = 1;
			} else {
				binaryGxt[i] = 0;
			}
		}
    	}
    
    	public void YglobalIndividual() {
    		defaultGeneLengthY = Ysize;
    		Gy = new double[defaultGeneLengthY];
    		binaryGy = new int[defaultGeneLengthY];
    		for (int i = 0; i < Gysize(); i++) {
    			Gy[i] = DE_Read_Write_txt.random_generate_or_read4(Execution_Mode);
    			double rsid = DE_Read_Write_txt
    					.random_generate_or_read1(Execution_Mode);
    			if (rsid < 1 / (1 + Math.exp(-lamda * Gy[i]))) {
    				binaryGy[i] = 1;
    			} else {
    				binaryGy[i] = 0;
    			}
    		}

    	}
    	 

    	
    /* Getters and setters */
    // Use this if you want to create individuals with different gene lengths 如果你想創建具有不同基因的長度個體使用本
    public static void setDefaultGeneLengthXa(int length) {
           defaultGeneLengthXa = length;
      }
    public static void setDefaultGeneLengthXh(int length) {
        defaultGeneLengthXh = length;
    }
    public static void setDefaultGeneLengthXt(int length) {
        defaultGeneLengthXt = length;
    }
    public static void setDefaultGeneLengthY(int length) {
        defaultGeneLengthY = length;
    }     
    
    
    public double getGxa(int index){
    	return Gxa[index];
    }
    public double getGxh(int index){
    	return Gxh[index];
    }
    public double getGxt(int index){
    	return Gxt[index];
    }
    public double getGy(int index){
    	return Gy[index];
    }
   
    public int getbinaryGxa(int index){
    	return binaryGxa[index];
    }
    public int getbinaryGxh(int index){
    	return binaryGxh[index];
    }
    public int getbinaryGxt(int index){
    	return binaryGxt[index];
    }
    public int getbinaryGy(int index){
    	return binaryGy[index];
    }
   
    public void setGxa(int index, double value) {
        Gxa[index] = value;
        fitness = 0;
        fitness1 = 0;
    }
    public void setGxh(int index, double value) {
        Gxh[index] = value;
        fitness = 0;
        fitness1 = 0;
    }
    public void setGxt(int index, double value) {
        Gxt[index] = value;
        fitness = 0;
        fitness1 = 0;
    }
    public void setGy(int index, double value) {
        Gy[index] = value;
        fitness = 0;
        fitness1 = 0;
    }
 
    public void setbinaryGxa(int index, int value) {
    	binaryGxa[index] = value;
        fitness = 0;
        fitness1 = 0;
    }
    public void setbinaryGxh(int index, int value) {
    	binaryGxh[index] = value;
        fitness = 0;
        fitness1 = 0;
    }
    public void setbinaryGxt(int index, int value) {
    	binaryGxt[index] = value;
        fitness = 0;
        fitness1 = 0;
    }
    public void setbinaryGy(int index, int value) {
    	binaryGy[index] = value;
        fitness = 0;
        fitness1 = 0;
    }
    
   
    /* Public methods */
    public int Gxasize() {
        return Gxa.length;
    }
    public int Gxhsize() {
        return Gxh.length;
    }
    public int Gxtsize() {
        return Gxt.length;
    }
    public int Gysize() {
        return Gy.length;
    }
    public double getFitness()   {
        if (fitness1 == 0) {
           fitness1 = FitnessCalc.getFitness(this);
        
        }
        return fitness1;
    } 
    public double getFitness1()   {
        if (fitness == 0) {
           fitness = FitnessCalc.getGFitness(this);
        
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
    for (int i = 0; i < Gysize(); i++) {
        geneString += getGy(i);
    }
    geneString+=",";
	for (int i = 0; i < Gxasize(); i++) {
		geneString += getGxa(i);
	}
    return geneString;
}
}

