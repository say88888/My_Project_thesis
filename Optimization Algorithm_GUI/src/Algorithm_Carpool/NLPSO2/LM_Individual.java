package Algorithm_Carpool.NLPSO2;

import java.util.Random;


public class LM_Individual extends NLPSO2{

	static int defaultGeneLengthX = Xsize;
	private double[] LMx = new double[defaultGeneLengthX];
	private int[] binaryLMx = new int[defaultGeneLengthX];

	static int defaultGeneLengthY = Ysize;
	private double[] LMy = new double[defaultGeneLengthY];
	private int[] binaryLMy = new int[defaultGeneLengthY];
	// Cache
	private double fitness = 0;
	private double fitness1 = 0;
	Random ran = new Random();

	public void XglobalIndividual() {
		defaultGeneLengthX = Xsize;
		LMx = new double[defaultGeneLengthX];
		binaryLMx = new int[defaultGeneLengthX];
		for (int i = 0; i < LMxsize(); i++) {

			LMx[i] = PSO_Read_Write_txt.random_generate_or_read2(Execution_Mode);
			double rsid = PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode);
			if (rsid < 1 / (1 + Math.exp(-PSO_lamda * LMx[i]))) {
				binaryLMx[i] = 1;
			} else {
				binaryLMx[i] = 0;
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
	public static void setDefaultGeneLengthX(int length) {
		defaultGeneLengthX = length;
	}

	public static void setDefaultGeneLengthY(int length) {
		defaultGeneLengthY = length;
	}

	public double getLMx(int index) {
		return LMx[index];
	}

	public double getLMy(int index) {
		return LMy[index];
	}

	public void setLMx(int index, double value) {
		LMx[index] = value;
		fitness = 0;
		fitness1 = 0;
	}

	public void setLMy(int index, double value) {
		LMy[index] = value;
		fitness = 0;
		fitness1 = 0;
	}

	public int getbinaryLMx(int index) {
		return binaryLMx[index];
	}

	public int getbinaryLMy(int index) {
		return binaryLMy[index];
	}

	public void setbinaryLMx(int index, int value) {
		binaryLMx[index] = value;
		fitness = 0;
		fitness1 = 0;
	}

	public void setbinaryLMy(int index, int value) {
		binaryLMy[index] = value;
		fitness = 0;
		fitness1 = 0;
	}

	/* Public methods */
	public int LMxsize() {
		return LMx.length;
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
		for (int i = 0; i < LMxsize(); i++) {
			geneString += getLMx(i);
		}
		return geneString;
	}
}