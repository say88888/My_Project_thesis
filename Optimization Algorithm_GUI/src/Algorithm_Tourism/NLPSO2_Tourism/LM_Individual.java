package Algorithm_Tourism.NLPSO2_Tourism;

import java.util.Random;


public class LM_Individual extends NLPSO2_Tourism{

	static int defaultGeneLengthXa = Xasize;
	private double[] LMxa = new double[defaultGeneLengthXa];
	private int[] binaryLMxa = new int[defaultGeneLengthXa];
	static int defaultGeneLengthXh = Xhsize;
	private double[] LMxh = new double[defaultGeneLengthXh];
	private int[] binaryLMxh = new int[defaultGeneLengthXh];
	static int defaultGeneLengthXt = Xtsize;
	private double[] LMxt = new double[defaultGeneLengthXt];
	private int[] binaryLMxt = new int[defaultGeneLengthXt];
	static int defaultGeneLengthY = Ysize;
	private double[] LMy = new double[defaultGeneLengthY];
	private int[] binaryLMy = new int[defaultGeneLengthY];
	// Cache
	private double fitness = 0;
	private double fitness1 = 0;
	Random ran = new Random();

	public void XglobalIndividual() {
		defaultGeneLengthXa = Xasize;
		LMxa = new double[defaultGeneLengthXa];
		binaryLMxa = new int[defaultGeneLengthXa];
		for (int i = 0; i < LMxasize(); i++) {
			LMxa[i] = PSO_Read_Write_txt.random_generate_or_read2(Execution_Mode);
			double rsid = PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode);
			if (rsid < 1 / (1 + Math.exp(-PSO_lamda * LMxa[i]))) {
				binaryLMxa[i] = 1;
			} else {
				binaryLMxa[i] = 0;
			}
		}
		defaultGeneLengthXh = Xhsize;
		LMxh = new double[defaultGeneLengthXh];
		binaryLMxh = new int[defaultGeneLengthXh];
		for (int i = 0; i < LMxhsize(); i++) {
			LMxh[i] = PSO_Read_Write_txt.random_generate_or_read2(Execution_Mode);
			double rsid = PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode);
			if (rsid < 1 / (1 + Math.exp(-PSO_lamda * LMxh[i]))) {
				binaryLMxh[i] = 1;
			} else {
				binaryLMxh[i] = 0;
			}
		}
		defaultGeneLengthXt = Xtsize;
		LMxt = new double[defaultGeneLengthXt];
		binaryLMxt = new int[defaultGeneLengthXt];
		for (int i = 0; i < LMxtsize(); i++) {
			LMxt[i] = PSO_Read_Write_txt.random_generate_or_read2(Execution_Mode);
			double rsid = PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode);
			if (rsid < 1 / (1 + Math.exp(-PSO_lamda * LMxt[i]))) {
				binaryLMxt[i] = 1;
			} else {
				binaryLMxt[i] = 0;
			}
		}
	}

	public void YglobalIndividual() {
		defaultGeneLengthY = Ysize;
		LMy = new double[defaultGeneLengthY];
		binaryLMy = new int[defaultGeneLengthY];
		for (int i = 0; i < LMysize(); i++) {
			LMy[i] = PSO_Read_Write_txt.random_generate_or_read2(Execution_Mode);
			double rsid = PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode);
			if (rsid < 1 / (1 + Math.exp(-PSO_lamda * LMy[i]))) {
				binaryLMy[i] = 1;
			} else {
				binaryLMy[i] = 0;
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

	public double getLMxa(int index) {
		return LMxa[index];
	}
	public double getLMxh(int index) {
		return LMxh[index];
	}
	public double getLMxt(int index) {
		return LMxt[index];
	}
	public double getLMy(int index) {
		return LMy[index];
	}

	public void setLMxa(int index, double value) {
		LMxa[index] = value;
		fitness = 0;
		fitness1 = 0;
	}
	public void setLMxh(int index, double value) {
		LMxh[index] = value;
		fitness = 0;
		fitness1 = 0;
	}
	public void setLMxt(int index, double value) {
		LMxt[index] = value;
		fitness = 0;
		fitness1 = 0;
	}
	public void setLMy(int index, double value) {
		LMy[index] = value;
		fitness = 0;
		fitness1 = 0;
	}

	public int getbinaryLMxa(int index) {
		return binaryLMxa[index];
	}
	public int getbinaryLMxh(int index) {
		return binaryLMxh[index];
	}
	public int getbinaryLMxt(int index) {
		return binaryLMxt[index];
	}
	public int getbinaryLMy(int index) {
		return binaryLMy[index];
	}

	public void setbinaryLMxa(int index, int value) {
		binaryLMxa[index] = value;
		fitness = 0;
		fitness1 = 0;
	}
	public void setbinaryLMxh(int index, int value) {
		binaryLMxh[index] = value;
		fitness = 0;
		fitness1 = 0;
	}
	public void setbinaryLMxt(int index, int value) {
		binaryLMxt[index] = value;
		fitness = 0;
		fitness1 = 0;
	}
	public void setbinaryLMy(int index, int value) {
		binaryLMy[index] = value;
		fitness = 0;
		fitness1 = 0;
	}

	/* Public methods */
	public int LMxasize() {
		return LMxa.length;
	}
	public int LMxhsize() {
		return LMxh.length;
	}
	public int LMxtsize() {
		return LMxt.length;
	}
	public int LMysize() {
		return LMy.length;
	}
	public double getFitness1() {
		if (fitness == 0) {
			fitness = FitnessCalc.getLMFitness(this);

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
		for (int i = 0; i < LMysize(); i++) {
			geneString += getLMy(i);
		}
		geneString += ",";
		for (int i = 0; i < LMxasize(); i++) {
			geneString += getLMxa(i);
		}
		return geneString;
	}
}