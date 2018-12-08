package Algorithm_Tourism.NLPSO2_Tourism;

import java.util.Random;

public class SM_Individual extends NLPSO2_Tourism {

	static int defaultGeneLengthXa = Xasize;
	private double[] SMxa = new double[defaultGeneLengthXa];
	static int defaultGeneLengthXh = Xhsize;
	private double[] SMxh = new double[defaultGeneLengthXh];
	static int defaultGeneLengthXt = Xtsize;
	private double[] SMxt = new double[defaultGeneLengthXt];
	static int defaultGeneLengthY = Ysize;
	private double[] SMy = new double[defaultGeneLengthY];

	// Cache
	private double fitness = 0;
	Random ran = new Random();

	public void XglobalIndividual() {
		for (int i = 0; i < SMxasize(); i++) {
			SMxa[i] = PSO_Read_Write_txt.random_generate_or_read2(Execution_Mode);
		}
		for (int i = 0; i < SMxhsize(); i++) {
			SMxh[i] = PSO_Read_Write_txt.random_generate_or_read2(Execution_Mode);
		}
		for (int i = 0; i < SMxtsize(); i++) {
			SMxt[i] = PSO_Read_Write_txt.random_generate_or_read2(Execution_Mode);
		}
	}

	public void YglobalIndividual() {
		for (int i = 0; i < SMysize(); i++)
		{
			SMy[i] = PSO_Read_Write_txt.random_generate_or_read2(Execution_Mode);// Math.random()*(Vmax-(-Vmax))+(-Vmax);
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

	public static void setDefaultGeneLengthXta(int length) {
		defaultGeneLengthXt = length;
	}

	public static void setDefaultGeneLengthY(int length) {
		defaultGeneLengthY = length;
	}

	public double getSMxa(int index) {
		return SMxa[index];
	}

	public double getSMxh(int index) {
		return SMxh[index];
	}

	public double getSMxt(int index) {
		return SMxt[index];
	}

	public double getSMy(int index) {
		return SMy[index];
	}

	public void setSMxa(int index, double value) {
		SMxa[index] = value;
		fitness = 0;
	}

	public void setSMxh(int index, double value) {
		SMxh[index] = value;
		fitness = 0;
	}

	public void setSMxt(int index, double value) {
		SMxt[index] = value;
		fitness = 0;
	}

	public void setSMy(int index, double value) {
		SMy[index] = value;
		fitness = 0;
	}

	/* Public methods */
	public int SMxasize() {
		return SMxa.length;
	}

	public int SMxhsize() {
		return SMxh.length;
	}

	public int SMxtsize() {
		return SMxt.length;
	}

	public int SMysize() {
		return SMy.length;
	}

	public void setfitness() {
		fitness = 0;
	}

	// Cache

	@Override
	public String toString() {
		String geneString = "";
		for (int i = 0; i < SMysize(); i++) {
			geneString += getSMy(i);
		}
		geneString += ",";
		for (int i = 0; i < SMxasize(); i++) {
			geneString += getSMxa(i);
		}
		return geneString;
	}
}
