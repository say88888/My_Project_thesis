package Algorithm_DoubleAuction.L_SHADE_CCPSO2_DA;

import java.util.Random;

public class Individual extends Double_Auction_L_SHADE_CCPSO2{

	static int defaultGeneLengthX = Xsize;
	private int[] X = new int[defaultGeneLengthX];
	private double[] rs = new double[defaultGeneLengthX];
	static int defaultGeneLengthY = Ysize;
	private int[] Y = new int[defaultGeneLengthY];
	private double[] rb = new double[defaultGeneLengthY];
	private double r;
	// Cache
	private double fitness = 0;
	Random ran = new Random();

	public void XgenerateIndividual() {
		for (int i = 0; i < Xsize(); i++)
		{
			X[i] = PSO_Read_Write_txt.random_generate_or_read(Execution_Mode);
		}
	}

	public void YgenerateIndividual() {
		for (int i = 0; i < Ysize(); i++)
		{
			Y[i] = PSO_Read_Write_txt.random_generate_or_read(Execution_Mode);
		}
	}

	public void rsgenerateIndividual() {
		for (int i = 0; i < rssize(); i++)
		{
			rs[i] = PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode);
		}
	}

	public void rbgenerateIndividual() {
		for (int i = 0; i < rbsize(); i++)
		{
			rb[i] = PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode);
		}
	}

	public void rgenerateIndividual() {
		r = PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode);
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

	public int getX(int index) {
		return X[index];
	}

	public int getY(int index) {
		return Y[index];
	}

	public double getrs(int index) {
		return rs[index];
	}

	public double getrb(int index) {
		return rb[index];
	}

	public double getr() {
		return r;
	}

	public void setX(int index, int value) {
		X[index] = value;
		fitness = 0;
	}

	public void setY(int index, int value) {
		Y[index] = value;
		fitness = 0;
	}

	public void setrs(int index, double value) {
		rs[index] = value;
		fitness = 0;
	}

	public void setrb(int index, double value) {
		rb[index] = value;
		fitness = 0;
	}

	public void setr(double value) {
		r = value;
		fitness = 0;
	}

	/* Public methods */
	public int Xsize() {
		return X.length;
	}

	public int Ysize() {
		return Y.length;
	}

	public int rssize() {
		return rs.length;
	}

	public int rbsize() {
		return rb.length;
	}

	public double getFitness() {
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
		for (int i = 0; i < Xsize(); i++) {
			geneString += getX(i);
		}
		return geneString;
	}
}
