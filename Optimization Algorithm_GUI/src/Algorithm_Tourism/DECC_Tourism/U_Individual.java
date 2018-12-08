package Algorithm_Tourism.DECC_Tourism;

import java.util.Random;
 
public class U_Individual extends DECC_Tourism{

	static int defaultGeneLengthXa = Xasize;
	private double[] Uxa = new double[defaultGeneLengthXa];
	private int[] binaryUxa = new int[defaultGeneLengthXa];
	static int defaultGeneLengthXh = Xhsize;
	private double[] Uxh = new double[defaultGeneLengthXh];
	private int[] binaryUxh = new int[defaultGeneLengthXh];
	static int defaultGeneLengthXt = Xtsize;
	private double[] Uxt = new double[defaultGeneLengthXt];
	private int[] binaryUxt = new int[defaultGeneLengthXt];
	static int defaultGeneLengthY = Ysize;
	private double[] Uy = new double[defaultGeneLengthY];
	private int[] binaryUy = new int[defaultGeneLengthY];
	// Cache
	private double fitness = 0;
	private double fitness1 = 0;
	Random ran = new Random();

	public void XglobalIndividual() {
		defaultGeneLengthXa = Xasize;
		Uxa = new double[defaultGeneLengthXa];
		binaryUxa = new int[defaultGeneLengthXa];
		for (int i = 0; i < Uxasize(); i++) {
			Uxa[i] = DE_Read_Write_txt.random_generate_or_read4(Execution_Mode);
			double rsid = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
			if (rsid < 1 / (1 + Math.exp(-lamda * Uxa[i]))) {
				binaryUxa[i] = 1;
			} else {
				binaryUxa[i] = 0;
			}
		}

		defaultGeneLengthXh = Xhsize;
		Uxh = new double[defaultGeneLengthXh];
		binaryUxh = new int[defaultGeneLengthXh];
		for (int i = 0; i < Uxhsize(); i++) {
			Uxh[i] = DE_Read_Write_txt.random_generate_or_read4(Execution_Mode);
			double rsid = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
			if (rsid < 1 / (1 + Math.exp(-lamda * Uxh[i]))) {
				binaryUxh[i] = 1;
			} else {
				binaryUxh[i] = 0;
			}
		}

		defaultGeneLengthXt = Xtsize;
		Uxt = new double[defaultGeneLengthXt];
		binaryUxt = new int[defaultGeneLengthXt];
		for (int i = 0; i < Uxtsize(); i++) {

			Uxt[i] = DE_Read_Write_txt.random_generate_or_read4(Execution_Mode);
			double rsid = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
			if (rsid < 1 / (1 + Math.exp(-lamda * Uxt[i]))) {
				binaryUxt[i] = 1;
			} else {
				binaryUxt[i] = 0;
			}
		}
	}

	public void YglobalIndividual() {
		defaultGeneLengthY = Ysize;
		Uy = new double[defaultGeneLengthY];
		binaryUy = new int[defaultGeneLengthY];
		for (int i = 0; i < Uysize(); i++) {
			Uy[i] = DE_Read_Write_txt.random_generate_or_read4(Execution_Mode);
			double rsid = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
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

	public double getUxa(int index) {
		return Uxa[index];
	}

	public double getUxh(int index) {
		return Uxh[index];
	}

	public double getUxt(int index) {
		return Uxt[index];
	}

	public double getUy(int index) {
		return Uy[index];
	}

	public int getbinaryUxa(int index) {
		return binaryUxa[index];
	}

	public int getbinaryUxh(int index) {
		return binaryUxh[index];
	}

	public int getbinaryUxt(int index) {
		return binaryUxt[index];
	}

	public int getbinaryUy(int index) {
		return binaryUy[index];
	}
	
	public void setUxa(int index, double value) {
		Uxa[index] = value;
		fitness = 0;
		fitness1 = 0;
	}

	public void setUxh(int index, double value) {
		Uxh[index] = value;
		fitness = 0;
		fitness1 = 0;
	}

	public void setUxt(int index, double value) {
		Uxt[index] = value;
		fitness = 0;
		fitness1 = 0;
	}

	public void setUy(int index, double value) {
		Uy[index] = value;
		fitness = 0;
		fitness1 = 0;
	}

	public void setbinaryUxa(int index, int value) {
		binaryUxa[index] = value;
		fitness = 0;
		fitness1 = 0;
	}

	public void setbinaryUxh(int index, int value) {
		binaryUxh[index] = value;
		fitness = 0;
		fitness1 = 0;
	}

	public void setbinaryUxt(int index, int value) {
		binaryUxt[index] = value;
		fitness = 0;
		fitness1 = 0;
	}

	public void setbinaryUy(int index, int value) {
		binaryUy[index] = value;
		fitness = 0;
		fitness1 = 0;
	}
	
	/* Public methods */
	public int Uxasize() {
		return Uxa.length;
	}

	public int Uxhsize() {
		return Uxh.length;
	}

	public int Uxtsize() {
		return Uxt.length;
	}

	public int Uysize() {
		return Uy.length;
	}

	public double getFitness1()   {
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
		for (int i = 0; i < Uxasize(); i++) {
			geneString += getUxa(i);
		}
		return geneString;
	}
}
