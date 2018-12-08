package Algorithm_Tourism.DE_Tourism;

 import java.util.Random;

public class U_Individual extends DE_Tourism {

	static int defaultGeneLengthXa = Xasize;
	private int[] Uxa = new int[defaultGeneLengthXa];
	static int defaultGeneLengthXh = Xhsize;
	private int[] Uxh = new int[defaultGeneLengthXh];
	static int defaultGeneLengthXt = Xtsize;
	private int[] Uxt = new int[defaultGeneLengthXt];
	static int defaultGeneLengthY = Ysize;
	private int[] Uy = new int[defaultGeneLengthY];

	// Cache
	private double fitness = 0;
	private double fitness1 = 0;
	Random ran = new Random();

	public void XglobalIndividual() {
		defaultGeneLengthXa = Xasize;
		Uxa = new int[defaultGeneLengthXa];
		for (int i = 0; i < Uxasize(); i++)
		{
			Uxa[i] = DE_Read_Write_txt.random_generate_or_read(Execution_Mode);
		}
		defaultGeneLengthXh = Xhsize;
		Uxh = new int[defaultGeneLengthXh];
		for (int i = 0; i < Uxhsize(); i++)
		{
			Uxh[i] = DE_Read_Write_txt.random_generate_or_read(Execution_Mode);
		}
		defaultGeneLengthXt = Xtsize;
		Uxt = new int[defaultGeneLengthXt];
		for (int i = 0; i < Uxtsize(); i++)
		{
			Uxt[i] = DE_Read_Write_txt.random_generate_or_read(Execution_Mode);
		}
	}

	public void YglobalIndividual() {
		defaultGeneLengthY = Ysize;
		Uy = new int[defaultGeneLengthY];
		for (int i = 0; i < Uysize(); i++)
		{
			Uy[i] = DE_Read_Write_txt.random_generate_or_read(Execution_Mode);
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

	public int getUxa(int index) {
		return Uxa[index];
	}

	public int getUxh(int index) {
		return Uxh[index];
	}

	public int getUxt(int index) {
		return Uxt[index];
	}

	public int getUy(int index) {
		return Uy[index];
	}

	public void setUxa(int index, int value) {
		Uxa[index] = value;
		fitness = 0;
		fitness1 = 0;
	}

	public void setUxh(int index, int value) {
		Uxh[index] = value;
		fitness = 0;
		fitness1 = 0;
	}

	public void setUxt(int index, int value) {
		Uxt[index] = value;
		fitness = 0;
		fitness1 = 0;
	}

	public void setUy(int index, int value) {
		Uy[index] = value;
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
