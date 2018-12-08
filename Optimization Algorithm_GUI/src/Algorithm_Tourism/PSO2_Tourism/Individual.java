package Algorithm_Tourism.PSO2_Tourism;

 import java.util.Random;

public class Individual extends PSO2_Tourism {

	static int defaultGeneLengthXa = Xasize;
	private int[] Xa = new int[defaultGeneLengthXa];

	static int defaultGeneLengthXh = Xhsize;
	private int[] Xh = new int[defaultGeneLengthXh];

	static int defaultGeneLengthXt = Xtsize;
	private int[] Xt = new int[defaultGeneLengthXt];

	static int defaultGeneLengthY = Ysize;
	private int[] Y = new int[defaultGeneLengthY];

	// Cache
	private double fitness = 0;
	Random ran = new Random();

	public void XgenerateIndividual() {
		for (int i = 0; i < Xasize(); i++) {
			Xa[i] = PSO_Read_Write_txt.random_generate_or_read(Execution_Mode);

		}
		for (int i = 0; i < Xhsize(); i++) {
			Xh[i] = PSO_Read_Write_txt.random_generate_or_read(Execution_Mode);

		}
		for (int i = 0; i < Xtsize(); i++) {
			Xt[i] = PSO_Read_Write_txt.random_generate_or_read(Execution_Mode);

		}
	}

	public void YgenerateIndividual() {
		for (int i = 0; i < Ysize(); i++) {
			Y[i] = PSO_Read_Write_txt.random_generate_or_read(Execution_Mode);

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

	public int getXa(int index) {
		return Xa[index];
	}

	public int getXh(int index) {
		return Xh[index];
	}

	public int getXt(int index) {
		return Xt[index];
	}

	public int getY(int index) {
		return Y[index];
	}

	public void setXa(int index, int value) {
		Xa[index] = value;
		fitness = 0;
	}

	public void setXh(int index, int value) {
		Xh[index] = value;
		fitness = 0;
	}

	public void setXt(int index, int value) {
		Xt[index] = value;
		fitness = 0;
	}

	public void setY(int index, int value) {
		Y[index] = value;
		fitness = 0;
	}

	/* Public methods */
	public int Xasize() {
		return Xa.length;
	}

	public int Xhsize() {
		return Xh.length;
	}

	public int Xtsize() {
		return Xt.length;
	}

	public int Ysize() {
		return Y.length;
	}

	public double getFitness()   {
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
		for (int i = 0; i < Xasize(); i++) {
			geneString += getXa(i);
		}
		return geneString;
	}
}
