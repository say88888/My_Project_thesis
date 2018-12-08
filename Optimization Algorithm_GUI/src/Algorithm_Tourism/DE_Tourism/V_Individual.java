package Algorithm_Tourism.DE_Tourism;

 import java.util.Random;

public class V_Individual extends DE_Tourism {

	static int defaultGeneLengthXa = Xasize;
	private int[] Vxa = new int[defaultGeneLengthXa];
	static int defaultGeneLengthXh = Xhsize;
	private int[] Vxh = new int[defaultGeneLengthXh];
	static int defaultGeneLengthXt = Xtsize;
	private int[] Vxt = new int[defaultGeneLengthXt];
	static int defaultGeneLengthY = Ysize;
	private int[] Vy = new int[defaultGeneLengthY];

	// Cache
	private double fitness = 0;
	Random ran = new Random();

	public void XpreviousIndividual() {
		defaultGeneLengthXa = Xasize;
		Vxa = new int[defaultGeneLengthXa];
		for (int i = 0; i < Vxasize(); i++) {
			Vxa[i] = DE_Read_Write_txt.random_generate_or_read(Execution_Mode);
		}
		defaultGeneLengthXh = Xhsize;
		Vxh = new int[defaultGeneLengthXh];
		for (int i = 0; i < Vxhsize(); i++) {
			Vxh[i] = DE_Read_Write_txt.random_generate_or_read(Execution_Mode);
		}
		defaultGeneLengthXt = Xtsize;
		Vxt = new int[defaultGeneLengthXt];
		for (int i = 0; i < Vxtsize(); i++) {
			Vxt[i] = DE_Read_Write_txt.random_generate_or_read(Execution_Mode);
		}
	}

	public void YpreviousIndividual() {
		defaultGeneLengthY = Ysize;
		Vy = new int[defaultGeneLengthY];
		for (int i = 0; i < Vysize(); i++) {
			Vy[i] = DE_Read_Write_txt.random_generate_or_read(Execution_Mode);
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

	public static void setDefaultGeneLengthXta(int length) {
		defaultGeneLengthXt = length;
	}

	public static void setDefaultGeneLengthY(int length) {
		defaultGeneLengthY = length;
	}

	public int getVxa(int index) {
		return Vxa[index];
	}

	public int getVxh(int index) {
		return Vxh[index];
	}

	public int getVxt(int index) {
		return Vxt[index];
	}

	public int getVy(int index) {
		return Vy[index];
	}

	public void setVxa(int index, int value) {
		Vxa[index] = value;
		fitness = 0;
	}

	public void setVxh(int index, int value) {
		Vxh[index] = value;
		fitness = 0;
	}

	public void setVxt(int index, int value) {
		Vxt[index] = value;
		fitness = 0;
	}

	public void setVy(int index, int value) {
		Vy[index] = value;
		fitness = 0;
	}

	/* Public methods */
	public int Vxasize() {
		return Vxa.length;
	}

	public int Vxhsize() {
		return Vxh.length;
	}

	public int Vxtsize() {
		return Vxt.length;
	}

	public int Vysize() {
		return Vy.length;
	}

	public double getFitness()   {
		if (fitness == 0) {
			fitness = FitnessCalc.getVFitness(this);

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
		for (int i = 0; i < Vysize(); i++) {
			geneString += getVy(i);
		}
		geneString += ",";
		for (int i = 0; i < Vxasize(); i++) {
			geneString += getVxa(i);
		}
		return geneString;
	}
}
