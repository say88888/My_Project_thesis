package Algorithm_Tourism.NLPSO2_Tourism;

import java.util.Random;

public class Plbest_Individual extends NLPSO2_Tourism {

	static int defaultGeneLengthXa = Xasize;
	private double[] Pxa = new double[defaultGeneLengthXa];
	private int[] binaryPxa = new int[defaultGeneLengthXa];
	static int defaultGeneLengthXh = Xhsize;
	private double[] Pxh = new double[defaultGeneLengthXh];
	private int[] binaryPxh = new int[defaultGeneLengthXh];
	static int defaultGeneLengthXt = Xtsize;
	private double[] Pxt = new double[defaultGeneLengthXt];
	private int[] binaryPxt = new int[defaultGeneLengthXt];
	static int defaultGeneLengthY = Ysize;
	private double[] Py = new double[defaultGeneLengthY];
	private int[] binaryPy = new int[defaultGeneLengthY];
	// Cache
	private double fitness = 0;
	private double fitness1 = 0;
	Random ran = new Random();

	public void XglobalIndividual() {
		defaultGeneLengthXa = Xasize;
		Pxa = new double[defaultGeneLengthXa];
		binaryPxa = new int[defaultGeneLengthXa];
		for (int i = 0; i < Pxasize(); i++) {
			Pxa[i] = PSO_Read_Write_txt.random_generate_or_read2(Execution_Mode);
			double rsid = PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode);
			if (rsid < 1 / (1 + Math.exp(-PSO_lamda * Pxa[i]))) {
				binaryPxa[i] = 1;
			} else {
				binaryPxa[i] = 0;
			}
		}
		defaultGeneLengthXh = Xhsize;
		Pxh = new double[defaultGeneLengthXh];
		binaryPxh = new int[defaultGeneLengthXh];
		for (int i = 0; i < Pxhsize(); i++) {
			Pxh[i] = PSO_Read_Write_txt.random_generate_or_read2(Execution_Mode);
			double rsid = PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode);
			if (rsid < 1 / (1 + Math.exp(-PSO_lamda * Pxh[i]))) {
				binaryPxh[i] = 1;
			} else {
				binaryPxh[i] = 0;
			}
		}
		defaultGeneLengthXt = Xtsize;
		Pxt = new double[defaultGeneLengthXt];
		binaryPxt = new int[defaultGeneLengthXt];
		for (int i = 0; i < Pxtsize(); i++) {
			Pxt[i] = PSO_Read_Write_txt.random_generate_or_read2(Execution_Mode);
			double rsid = PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode);
			if (rsid < 1 / (1 + Math.exp(-PSO_lamda * Pxt[i]))) {
				binaryPxt[i] = 1;
			} else {
				binaryPxt[i] = 0;
			}
		}
	}

	public void YglobalIndividual() {
		defaultGeneLengthY = Ysize;
		Py = new double[defaultGeneLengthY];
		binaryPy = new int[defaultGeneLengthY];
		for (int i = 0; i < Pysize(); i++) {
			Py[i] = PSO_Read_Write_txt.random_generate_or_read2(Execution_Mode);
			double rsid = PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode);
			if (rsid < 1 / (1 + Math.exp(-PSO_lamda * Py[i]))) {
				binaryPy[i] = 1;
			} else {
				binaryPy[i] = 0;
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

	public double getPxa(int index) {
		return Pxa[index];
	}
	public double getPxh(int index) {
		return Pxh[index];
	}
	public double getPxt(int index) {
		return Pxt[index];
	}
	public double getPy(int index) {
		return Py[index];
	}

	public void setPxa(int index, double value) {
		Pxa[index] = value;
		fitness = 0;
		fitness1 = 0;
	}
	public void setPxh(int index, double value) {
		Pxh[index] = value;
		fitness = 0;
		fitness1 = 0;
	}
	public void setPxt(int index, double value) {
		Pxt[index] = value;
		fitness = 0;
		fitness1 = 0;
	}
	public void setPy(int index, double value) {
		Py[index] = value;
		fitness = 0;
		fitness1 = 0;
	}

	public int getbinaryPxa(int index) {
		return binaryPxa[index];
	}
	public int getbinaryPxh(int index) {
		return binaryPxh[index];
	}
	public int getbinaryPxt(int index) {
		return binaryPxt[index];
	}
	public int getbinaryPy(int index) {
		return binaryPy[index];
	}

	public void setbinaryPxa(int index, int value) {
		binaryPxa[index] = value;
		fitness = 0;
		fitness1 = 0;
	}
	public void setbinaryPxh(int index, int value) {
		binaryPxh[index] = value;
		fitness = 0;
		fitness1 = 0;
	}
	public void setbinaryPxt(int index, int value) {
		binaryPxt[index] = value;
		fitness = 0;
		fitness1 = 0;
	}
	public void setbinaryPy(int index, int value) {
		binaryPy[index] = value;
		fitness = 0;
		fitness1 = 0;
	}

	/* Public methods */
	public int Pxasize() {
		return Pxa.length;
	}
	public int Pxhsize() {
		return Pxh.length;
	}
	public int Pxtsize() {
		return Pxt.length;
	}
	public int Pysize() {
		return Py.length;
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
		geneString += ",";
		for (int i = 0; i < Pxasize(); i++) {
			geneString += getPxa(i);
		}
		return geneString;
	}

	 
}