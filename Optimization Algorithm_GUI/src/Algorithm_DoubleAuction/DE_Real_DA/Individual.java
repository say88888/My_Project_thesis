package Algorithm_DoubleAuction.DE_Real_DA;

import java.util.Random;
 
public class Individual extends Double_Auction_DE_Real{

	static int defaultGeneLengthX = Xsize;
	private double[] X = new double[defaultGeneLengthX];
	private int[] binaryX = new int[defaultGeneLengthX];
	private double[] rs = new double[defaultGeneLengthX];
	static int defaultGeneLengthY = Ysize;
	private double[] Y = new double[defaultGeneLengthY];
	private int[] binaryY = new int[defaultGeneLengthY];
	private double[] rb = new double[defaultGeneLengthY];
	private double r;
	// Cache
	private double fitness = 0;
	private double fitness1 = 0;
	Random ran = new Random();

	public void XgenerateIndividual() {
		defaultGeneLengthX = Xsize;
		X = new double[defaultGeneLengthX];
		binaryX = new int[defaultGeneLengthX];
		for (int i = 0; i < Xsize(); i++) {
			X[i] = DE_Read_Write_txt.random_generate_or_read4(Execution_Mode);
			double rsid = DE_Read_Write_txt
					.random_generate_or_read1(Execution_Mode);
			if (rsid < 1 / (1 + Math.exp(-lamda * X[i]))) {
				binaryX[i] = 1;
			} else {
				binaryX[i] = 0;
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

	public void rsgenerateIndividual() {
		defaultGeneLengthX = Xsize;
		rs = new double[defaultGeneLengthX];
		for (int i = 0; i < rssize(); i++) {
			rs[i] = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
		}
	}
	public void rbgenerateIndividual() {
		defaultGeneLengthY = Ysize;
		rb = new double[defaultGeneLengthY];
		for (int i = 0; i < rbsize(); i++) {
			rb[i] = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
		}
	}
	public void rgenerateIndividual() {
			r = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
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

	public double getX(int index) {
		return X[index];
	}

	public double getY(int index) {
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
	
	public void setX(int index, double value) {
		X[index] = value;
		fitness = 0;
		fitness1 = 0;
	}

	public void setY(int index, double value) {
		Y[index] = value;
		fitness = 0;
		fitness1 = 0;
	}

	public void setrs(int index, double value) {
		rs[index] = value;
		fitness = 0;
		fitness1 = 0;
	}

	public void setrb(int index, double value) {
		rb[index] = value;
		fitness = 0;
		fitness1 = 0;
	}
	
	public void setr(double value) {
		r = value;
		fitness = 0;
		fitness1 = 0;
	}
	
	public int getbinaryX(int index) {
		return binaryX[index];
	}

	public int getbinaryY(int index) {
		return binaryY[index];
	}

	public void setbinaryX(int index, int value) {
		binaryX[index] = value;
		fitness = 0;
		fitness1 = 0;
	}

	public void setbinaryY(int index, int value) {
		binaryY[index] = value;
		fitness = 0;
		fitness1 = 0;
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
		if (fitness1 == 0) {
			fitness1 = FitnessCalc.getFitness(this);

		}
		return fitness1;
	}

	public double getFitness1() {
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
