package Algorithm_Tourism.DMSDL_PSO2_Tourism;

import java.util.Random;



public class Vim_Individual extends DMSDL_PSO2_Tourism{

	static int defaultGeneLengthXa = Xasize;
	private double[] Vimxa = new double[defaultGeneLengthXa];
	static int defaultGeneLengthXh = Xhsize;
	private double[] Vimxh = new double[defaultGeneLengthXh];
	static int defaultGeneLengthXt = Xtsize;
	private double[] Vimxt = new double[defaultGeneLengthXt];
	static int defaultGeneLengthY = Ysize;
	private double[] Vimy = new double[defaultGeneLengthY];
  
    // Cache
    private double fitness = 0;
      Random ran=new Random();
	
    public void XvelocityIndividual() {
    	for (int i = 0; i < Vimxasize(); i++) {
			Vimxa[i] = PSO_Read_Write_txt.random_generate_or_read2(Execution_Mode);
		}
		for (int i = 0; i < Vimxhsize(); i++) {
			Vimxh[i] = PSO_Read_Write_txt.random_generate_or_read2(Execution_Mode);
		}
		for (int i = 0; i < Vimxtsize(); i++) {
			Vimxt[i] = PSO_Read_Write_txt.random_generate_or_read2(Execution_Mode);
		}
    	}
    
    	public void YvelocityIndividual() {
    	for (int i = 0; i <Vimysize(); i++)
    	{
    	Vimy[i]=PSO_Read_Write_txt.random_generate_or_read2(Execution_Mode);//Math.random()*(Vmax-(-Vmax))+(-Vmax);
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

    	public static void setDefaultGeneLengthXta(int length) {
    		defaultGeneLengthXt = length;
    	}

    	public static void setDefaultGeneLengthY(int length) {
    		defaultGeneLengthY = length;
    	}

    	public double getVimxa(int index) {
    		return Vimxa[index];
    	}

    	public double getVimxh(int index) {
    		return Vimxh[index];
    	}

    	public double getVimxt(int index) {
    		return Vimxt[index];
    	}

    	public double getVimy(int index) {
    		return Vimy[index];
    	}

    	public void setVimxa(int index, double value) {
    		Vimxa[index] = value;
    		fitness = 0;
    	}

    	public void setVimxh(int index, double value) {
    		Vimxh[index] = value;
    		fitness = 0;
    	}

    	public void setVimxt(int index, double value) {
    		Vimxt[index] = value;
    		fitness = 0;
    	}

    	public void setVimy(int index, double value) {
    		Vimy[index] = value;
    		fitness = 0;
    	}

    	/* Public methods */
    	public int Vimxasize() {
    		return Vimxa.length;
    	}

    	public int Vimxhsize() {
    		return Vimxh.length;
    	}

    	public int Vimxtsize() {
    		return Vimxt.length;
    	}

    	public int Vimysize() {
    		return Vimy.length;
    	}
 
    	public void setfitness() {
    		fitness = 0;
    	}

    	// Cache

    	@Override
    	public String toString() {
    		String geneString = "";
    		for (int i = 0; i < Vimysize(); i++) {
    			geneString += getVimy(i);
    		}
    		geneString += ",";
    		for (int i = 0; i < Vimxasize(); i++) {
    			geneString += getVimxa(i);
    		}
    		return geneString;
    	}
    }

