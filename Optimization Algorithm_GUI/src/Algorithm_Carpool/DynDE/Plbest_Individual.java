package Algorithm_Carpool.DynDE;

import java.util.Random;

public class Plbest_Individual extends DynDE {

	static int defaultGeneLengthX = Xsize;
	private double[] Px = new double[defaultGeneLengthX];
	private int[] binaryPx = new int[defaultGeneLengthX];

	static int defaultGeneLengthY = Ysize;
	private double[] Py = new double[defaultGeneLengthY];
	private int[] binaryPy = new int[defaultGeneLengthY];
	// Cache
	private double fitness = 0;
	private double fitness1 = 0;
	Random ran = new Random();

	public void XglobalIndividual() {
		defaultGeneLengthX = Xsize;
		Px = new double[defaultGeneLengthX];
		binaryPx = new int[defaultGeneLengthX];
		for (int i = 0; i < Pxsize(); i++) {

			Px[i] = DE_Read_Write_txt.random_generate_or_read4(Execution_Mode);
			double rsid = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
			if (rsid < 1 / (1 + Math.exp(-lamda * Px[i]))) {
				binaryPx[i] = 1;
			} else {
				binaryPx[i] = 0;
			}
		}
	}

	public void YglobalIndividual() {
		defaultGeneLengthY = Ysize;
		Py = new double[defaultGeneLengthY];
		binaryPy = new int[defaultGeneLengthY];
		for (int i = 0; i < Pysize(); i++) {
			Py[i] = DE_Read_Write_txt.random_generate_or_read4(Execution_Mode);
			double rsid = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
			if (rsid < 1 / (1 + Math.exp(-lamda * Py[i]))) {
				binaryPy[i] = 1;
			} else {
				binaryPy[i] = 0;
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

	public double getPx(int index) {
		return Px[index];
	}

	public double getPy(int index) {
		return Py[index];
	}

	public void setPx(int index, double value) {
		Px[index] = value;
		fitness = 0;
		fitness1 = 0;
	}

	public void setPy(int index, double value) {
		Py[index] = value;
		fitness = 0;
		fitness1 = 0;
	}

	public int getbinaryPx(int index) {
		return binaryPx[index];
	}

	public int getbinaryPy(int index) {
		return binaryPy[index];
	}

	public void setbinaryPx(int index, int value) {
		binaryPx[index] = value;
		fitness = 0;
		fitness1 = 0;
	}

	public void setbinaryPy(int index, int value) {
		binaryPy[index] = value;
		fitness = 0;
		fitness1 = 0;
	}

	/* Public methods */
	public int Pxsize() {
		return Px.length;
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
		for (int i = 0; i < Pxsize(); i++) {
			geneString += getPx(i);
		}
		return geneString;
	}

	 
}