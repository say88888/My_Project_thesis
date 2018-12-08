package Algorithm_Tourism.PSO1_Tourism;

 
 
public class E_Individual extends PSO1_Tourism{

	static int defaultGeneLengthXa = Xasize;
	private int[] Exa = new int[defaultGeneLengthXa];

	static int defaultGeneLengthXh = Xhsize;
	private int[] Exh = new int[defaultGeneLengthXh];

	static int defaultGeneLengthXt = Xtsize;
	private int[] Ext = new int[defaultGeneLengthXt];

	static int defaultGeneLengthY = Ysize;
	private int[] Ey = new int[defaultGeneLengthY];

	// Cache
	private double fitness = 0;
	 

	public void XglobalIndividual() {
		for (int i = 0; i < Exasize(); i++) {
			Exa[i] = PSO_Read_Write_txt.random_generate_or_read(Execution_Mode);

		}
		for (int i = 0; i < Exhsize(); i++) {
			Exh[i] = PSO_Read_Write_txt.random_generate_or_read(Execution_Mode);

		}
		for (int i = 0; i < Extsize(); i++) {
			Ext[i] = PSO_Read_Write_txt.random_generate_or_read(Execution_Mode);

		}
	}

	public void YglobalIndividual() {
		for (int i = 0; i < Eysize(); i++) {
			Ey[i] = PSO_Read_Write_txt.random_generate_or_read(Execution_Mode);

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

	public int getExa(int index) {
		return Exa[index];
	}

	public int getExh(int index) {
		return Exh[index];
	}

	public int getExt(int index) {
		return Ext[index];
	}

	public int getEy(int index) {
		return Ey[index];
	}

	public void setExa(int index, int value) {
		Exa[index] = value;
		fitness = 0;
	}

	public void setExh(int index, int value) {
		Exh[index] = value;
		fitness = 0;
	}

	public void setExt(int index, int value) {
		Ext[index] = value;
		fitness = 0;
	}

	public void setEy(int index, int value) {
		Ey[index] = value;
		fitness = 0;
	}

	/* Public methods */
	public int Exasize() {
		return Exa.length;
	}

	public int Exhsize() {
		return Exh.length;
	}

	public int Extsize() {
		return Ext.length;
	}

	public int Eysize() {
		return Ey.length;
	}

	public double getFitness()   {
		if (fitness == 0) {
			fitness = FitnessCalc.getEFitness1(this);

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
		for (int i = 0; i < Eysize(); i++) {
			geneString += getEy(i);
		}
		geneString += ",";
		for (int i = 0; i < Exasize(); i++) {
			geneString += getExa(i);
		}
		return geneString;
	}
}
