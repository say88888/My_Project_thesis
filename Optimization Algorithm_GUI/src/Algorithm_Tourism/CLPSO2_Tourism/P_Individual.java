package Algorithm_Tourism.CLPSO2_Tourism;

import java.util.Random;
 
public class P_Individual extends CLPSO2_Tourism{

	static int defaultGeneLengthXa = Xasize;
	private int[] Pxa = new int[defaultGeneLengthXa];
	static int defaultGeneLengthXh = Xhsize;
	private int[] Pxh = new int[defaultGeneLengthXh];
	static int defaultGeneLengthXt = Xtsize;
	private int[] Pxt = new int[defaultGeneLengthXt];
	static int defaultGeneLengthY = Ysize;
	private int[] Py = new int[defaultGeneLengthY];

	// Cache
	private double fitness = 0;
	Random ran = new Random();

	public void XpreviousIndividual() {
		for (int i = 0; i < Pxasize(); i++) {
			Pxa[i] = PSO_Read_Write_txt.random_generate_or_read(Execution_Mode);
		}
		for (int i = 0; i < Pxhsize(); i++) {
			Pxh[i] = PSO_Read_Write_txt.random_generate_or_read(Execution_Mode);
		}
		for (int i = 0; i < Pxtsize(); i++) {
			Pxt[i] = PSO_Read_Write_txt.random_generate_or_read(Execution_Mode);
		}
	}

	public void YpreviousIndividual() {
		for (int i = 0; i < Pysize(); i++) {
			Py[i] = PSO_Read_Write_txt.random_generate_or_read(Execution_Mode);
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

	public int getPxa(int index) {
		return Pxa[index];
	}

	public int getPxh(int index) {
		return Pxh[index];
	}

	public int getPxt(int index) {
		return Pxt[index];
	}

	public int getPy(int index) {
		return Py[index];
	}

	public void setPxa(int index, int value) {
		Pxa[index] = value;
		fitness = 0;
	}

	public void setPxh(int index, int value) {
		Pxh[index] = value;
		fitness = 0;
	}

	public void setPxt(int index, int value) {
		Pxt[index] = value;
		fitness = 0;
	}

	public void setPy(int index, int value) {
		Py[index] = value;
		fitness = 0;
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

	public double getFitness()   {
		if (fitness == 0) {
			fitness = FitnessCalc.getPFitness(this);

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
