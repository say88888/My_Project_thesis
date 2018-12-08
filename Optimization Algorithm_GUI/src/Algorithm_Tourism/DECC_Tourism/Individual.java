package Algorithm_Tourism.DECC_Tourism;

import java.util.Random;
 
public class Individual extends DECC_Tourism{

	static int defaultGeneLengthXa = Xasize;
	private double[] Xa = new double[defaultGeneLengthXa];
	private int[] binaryXa = new int[defaultGeneLengthXa];
	
	static int defaultGeneLengthXh = Xhsize;
	private double[] Xh = new double[defaultGeneLengthXh];
	private int[] binaryXh = new int[defaultGeneLengthXh];

	static int defaultGeneLengthXt = Xtsize;
	private double[] Xt = new double[defaultGeneLengthXt];
	private int[] binaryXt = new int[defaultGeneLengthXt];

	static int defaultGeneLengthY = Ysize;
	private double[] Y = new double[defaultGeneLengthY];
	private int[] binaryY = new int[defaultGeneLengthY];
	// Cache
	private double fitness = 0,fitness1 = 0;
	Random ran = new Random();

	public void XgenerateIndividual() {
		defaultGeneLengthXa = Xasize;
		Xa = new double[defaultGeneLengthXa];
		binaryXa = new int[defaultGeneLengthXa];
		for (int i = 0; i < Xasize(); i++) {
			Xa[i] = DE_Read_Write_txt.random_generate_or_read4(Execution_Mode);
			double rsid = DE_Read_Write_txt
					.random_generate_or_read1(Execution_Mode);
			if (rsid < 1 / (1 + Math.exp(-lamda * Xa[i]))) {
				binaryXa[i] = 1;
			} else {
				binaryXa[i] = 0;
			}
		}
	
		defaultGeneLengthXh = Xhsize;
		Xh = new double[defaultGeneLengthXh];
		binaryXh = new int[defaultGeneLengthXh];
		for (int i = 0; i < Xhsize(); i++) {
			Xh[i] = DE_Read_Write_txt.random_generate_or_read4(Execution_Mode);
			double rsid = DE_Read_Write_txt
					.random_generate_or_read1(Execution_Mode);
			if (rsid < 1 / (1 + Math.exp(-lamda * Xh[i]))) {
				binaryXh[i] = 1;
			} else {
				binaryXh[i] = 0;
			}
		}
	
		defaultGeneLengthXt = Xtsize;
		Xt = new double[defaultGeneLengthXt];
		binaryXt = new int[defaultGeneLengthXt];
		for (int i = 0; i < Xtsize(); i++) {
			Xt[i] = DE_Read_Write_txt.random_generate_or_read4(Execution_Mode);
			double rsid = DE_Read_Write_txt
					.random_generate_or_read1(Execution_Mode);
			if (rsid < 1 / (1 + Math.exp(-lamda * Xt[i]))) {
				binaryXt[i] = 1;
			} else {
				binaryXt[i] = 0;
			}
		}
	}

	public void YgenerateIndividual() {
		defaultGeneLengthY = Ysize;
		Y = new double[defaultGeneLengthY];
		binaryY = new int[defaultGeneLengthY];
		for (int i = 0; i < Ysize(); i++) {
			Y[i] = DE_Read_Write_txt.random_generate_or_read4(Execution_Mode);
			double rsid = DE_Read_Write_txt
					.random_generate_or_read1(Execution_Mode);
			if (rsid < 1 / (1 + Math.exp(-lamda * Y[i]))) {
				binaryY[i] = 1;
			} else {
				binaryY[i] = 0;
			}
		}

	}

	/* Getters and setters */
	// Use this if you want to create individuals with different gene lengths
	// 如果你想創建具有不同基因的長度個體使用本
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

	public double getXa(int index) {
		return Xa[index];
	}

	public double getXh(int index) {
		return Xh[index];
	}

	public double getXt(int index) {
		return Xt[index];
	}

	public double getY(int index) {
		return Y[index];
	}
	
	public int getbinaryXa(int index) {
		return binaryXa[index];
	}

	public int getbinaryXh(int index) {
		return binaryXh[index];
	}

	public int getbinaryXt(int index) {
		return binaryXt[index];
	}

	public int getbinaryY(int index) {
		return binaryY[index];
	}

	public void setXa(int index, double value) {
		Xa[index] = value;
		fitness = 0;
		fitness1 = 0;
	}

	public void setXh(int index, double value) {
		Xh[index] = value;
		fitness = 0;
		fitness1 = 0;
	}

	public void setXt(int index, double value) {
		Xt[index] = value;
		fitness = 0;
		fitness1 = 0;
	}

	public void setY(int index, double value) {
		Y[index] = value;
		fitness = 0;
		fitness1 = 0;
	}
	
	public void setbinaryXa(int index, int value) {
		binaryXa[index] = value;
		fitness = 0;
		fitness1 = 0;
	}

	public void setbinaryXh(int index, int value) {
		binaryXh[index] = value;
		fitness = 0;
		fitness1 = 0;
	}

	public void setbinaryXt(int index, int value) {
		binaryXt[index] = value;
		fitness = 0;
		fitness1 = 0;
	}

	public void setbinaryY(int index, int value) {
		binaryY[index] = value;
		fitness = 0;
		fitness1 = 0;
	}
	/* Public methods */
	public int Xasize() {
		return Xa.length;
	}

	public int Xhsize() {
		return Xh.length;
	}

	public int Xtsize() {
		return Xt.length;
	}

	public int Ysize() {
		return Y.length;
	}

	public  double getFitness()     {
        if (fitness1 == 0) {
           fitness1 = FitnessCalc.getFitness(this);
      
        }
        return fitness1;
    }
    public  double getFitness1()     {
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
		geneString += ",";
		for (int i = 0; i < Xasize(); i++) {
			geneString += getXa(i);
		}
		return geneString;
	}
}
