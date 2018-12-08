package Algorithm_DoubleAuction.DynDE_DA;

import java.util.Random;
 
public class U_Individual extends DynDE{

	static int defaultGeneLengthX = Xsize;
	private double[] Ux = new double[defaultGeneLengthX];
	private int[] binaryUx = new int[defaultGeneLengthX];

	static int defaultGeneLengthY = Ysize;
	private double[] Uy = new double[defaultGeneLengthY];
	private int[] binaryUy = new int[defaultGeneLengthY];
	// Cache
	private double fitness = 0;
	private double fitness1 = 0;
	Random ran = new Random();

	public void XglobalIndividual() {
		defaultGeneLengthX = Xsize;
		Ux = new double[defaultGeneLengthX];
		binaryUx = new int[defaultGeneLengthX];
		for (int i = 0; i < Uxsize(); i++) {

			Ux[i] = DE_Read_Write_txt.random_generate_or_read4(Execution_Mode);
			double rsid = DE_Read_Write_txt
					.random_generate_or_read1(Execution_Mode);
			if (rsid < 1 / (1 + Math.exp(-lamda * Ux[i]))) {
				binaryUx[i] = 1;
			} else {
				binaryUx[i] = 0;
			}
		}
	}

	public void YglobalIndividual() {
		defaultGeneLengthY = Ysize;
		Uy = new double[defaultGeneLengthY];
		binaryUy = new int[defaultGeneLengthY];
		for (int i = 0; i < Uysize(); i++) {
			Uy[i] = DE_Read_Write_txt.random_generate_or_read4(Execution_Mode);
			double rsid = DE_Read_Write_txt
					.random_generate_or_read1(Execution_Mode);
			if (rsid < 1 / (1 + Math.exp(-lamda * Uy[i]))) {
				binaryUy[i] = 1;
			} else {
				binaryUy[i] = 0;
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

	public double getUx(int index) {
		return Ux[index];
	}

	public double getUy(int index) {
		return Uy[index];
	}

	public void setUx(int index, double value) {
		Ux[index] = value;
		fitness = 0;
		fitness1 = 0;
	}

	public void setUy(int index, double value) {
		Uy[index] = value;
		fitness = 0;
		fitness1 = 0;
	}

	public int getbinaryUx(int index) {
		return binaryUx[index];
	}

	public int getbinaryUy(int index) {
		return binaryUy[index];
	}

	public void setbinaryUx(int index, int value) {
		binaryUx[index] = value;
		fitness = 0;
		fitness1 = 0;
	}

	public void setbinaryUy(int index, int value) {
		binaryUy[index] = value;
		fitness = 0;
		fitness1 = 0;
	}

	/* Public methods */
	public int Uxsize() {
		return Ux.length;
	}

	public int Uysize() {
		return Uy.length;
	}

	public double getFitness1() {
		if (fitness == 0) {
			fitness = FitnessCalc.getUFitness(this);

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
		for (int i = 0; i < Uysize(); i++) {
			geneString += getUy(i);
		}
		geneString += ",";
		for (int i = 0; i < Uxsize(); i++) {
			geneString += getUx(i);
		}
		return geneString;
	}
}