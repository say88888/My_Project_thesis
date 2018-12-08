package Algorithm_Tourism.ALPSO2_NEW_PrematureConvegence1_Tourism;

import java.util.Random;

public class GV_Individual extends ALPSO2_NEW_PrematureConvegence1_Tourism {

	static int defaultGeneLengthXa = Xasize;
	private double[] GVxa = new double[defaultGeneLengthXa];
	static int defaultGeneLengthXh = Xhsize;
	private double[] GVxh = new double[defaultGeneLengthXh];
	static int defaultGeneLengthXt = Xtsize;
	private double[] GVxt = new double[defaultGeneLengthXt];
	static int defaultGeneLengthY = Ysize;
	private double[] GVy = new double[defaultGeneLengthY];

	// Cache
	private double fitness = 0;
	Random ran = new Random();

	public void XvelocityIndividual() {
		for (int i = 0; i < GVxasize(); i++)
		{
			GVxa[i] = PSO_Read_Write_txt.random_generate_or_read2(Execution_Mode);// Math.random()*(GVmax-(-GVmax))+(-GVmax);
		}
		for (int i = 0; i < GVxhsize(); i++)
		{
			GVxh[i] = PSO_Read_Write_txt.random_generate_or_read2(Execution_Mode);// Math.random()*(GVmax-(-GVmax))+(-GVmax);
		}
		for (int i = 0; i < GVxtsize(); i++)
		{
			GVxt[i] = PSO_Read_Write_txt.random_generate_or_read2(Execution_Mode);// Math.random()*(GVmax-(-GVmax))+(-GVmax);
		}
	}

	public void YvelocityIndividual() {
		for (int i = 0; i < GVysize(); i++)
		{
			GVy[i] = PSO_Read_Write_txt.random_generate_or_read2(Execution_Mode);// Math.random()*(GVmax-(-GVmax))+(-GVmax);
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

	public double getGVxa(int index) {
		return GVxa[index];
	}
	public double getGVxh(int index) {
		return GVxh[index];
	}
	public double getGVxt(int index) {
		return GVxt[index];
	}
	public double getGVy(int index) {
		return GVy[index];
	}

	public void setGVxa(int index, double value) {
		GVxa[index] = value;
		fitness = 0;
	}
	public void setGVxh(int index, double value) {
		GVxh[index] = value;
		fitness = 0;
	}
	public void setGVxt(int index, double value) {
		GVxt[index] = value;
		fitness = 0;
	}
	public void setGVy(int index, double value) {
		GVy[index] = value;
		fitness = 0;
	}

	/* Public methods */
	public int GVxasize() {
		return GVxa.length;
	}
	public int GVxhsize() {
		return GVxh.length;
	}
	public int GVxtsize() {
		return GVxt.length;
	}
	public int GVysize() {
		return GVy.length;
	}

	// Cache

	@Override
	public String toString() {
		String geneString = "";
		for (int i = 0; i < GVysize(); i++) {
			geneString += getGVy(i);
		}
		geneString += ",";
		for (int i = 0; i < GVxasize(); i++) {
			geneString += getGVxa(i);
		}
		return geneString;
	}
}
