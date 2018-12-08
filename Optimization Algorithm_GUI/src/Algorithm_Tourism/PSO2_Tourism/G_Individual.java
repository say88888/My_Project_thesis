package Algorithm_Tourism.PSO2_Tourism;

 import java.util.Random;

public class G_Individual extends PSO2_Tourism {

	static int defaultGeneLengthXa = Xasize;
	private int[] Gxa = new int[defaultGeneLengthXa];
	static int defaultGeneLengthXh = Xhsize;
	private int[] Gxh = new int[defaultGeneLengthXh];
	static int defaultGeneLengthXt = Xtsize;
	private int[] Gxt = new int[defaultGeneLengthXt];
	static int defaultGeneLengthY = Ysize;
	private int[] Gy = new int[defaultGeneLengthY];

	// Cache
	private double fitness = 0;
	private double fitness1 = 0;
	Random ran = new Random();

	public void XglobalIndividual() {
		for (int i = 0; i < Gxasize(); i++) {

			Gxa[i] = PSO_Read_Write_txt.random_generate_or_read(Execution_Mode);
		}
		for (int i = 0; i < Gxhsize(); i++) {

			Gxh[i] = PSO_Read_Write_txt.random_generate_or_read(Execution_Mode);
		}
		for (int i = 0; i < Gxtsize(); i++) {

			Gxt[i] = PSO_Read_Write_txt.random_generate_or_read(Execution_Mode);
		}
	}

	public void YglobalIndividual() {
		for (int i = 0; i < Gysize(); i++) {
			Gy[i] = PSO_Read_Write_txt.random_generate_or_read(Execution_Mode);
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

	public int getGxa(int index) {
		return Gxa[index];
	}

	public int getGxh(int index) {
		return Gxh[index];
	}

	public int getGxt(int index) {
		return Gxt[index];
	}

	public int getGy(int index) {
		return Gy[index];
	}

	public void setGxa(int index, int value) {
		Gxa[index] = value;
		fitness = 0;
		fitness1 = 0;
	}

	public void setGxh(int index, int value) {
		Gxh[index] = value;
		fitness = 0;
		fitness1 = 0;
	}

	public void setGxt(int index, int value) {
		Gxt[index] = value;
		fitness = 0;
		fitness1 = 0;
	}

	public void setGy(int index, int value) {
		Gy[index] = value;
		fitness = 0;
		fitness1 = 0;
	}

	/* Public methods */
	public int Gxasize() {
		return Gxa.length;
	}

	public int Gxhsize() {
		return Gxh.length;
	}

	public int Gxtsize() {
		return Gxt.length;
	}

	public int Gysize() {
		return Gy.length;
	}

	public double getFitness()   {
		if (fitness1 == 0) {
			fitness1 = FitnessCalc.getFitness(this);

		}
		return fitness1;
	}

	public double getFitness1()   {
		if (fitness == 0) {
			fitness = FitnessCalc.getGFitness(this);

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
		for (int i = 0; i < Gysize(); i++) {
			geneString += getGy(i);
		}
		geneString += ",";
		for (int i = 0; i < Gxasize(); i++) {
			geneString += getGxa(i);
		}
		return geneString;
	}
}
