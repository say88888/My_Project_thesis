package Algorithm_Tourism.GA2_Tourism;

 
public class Individual extends GA2_Tourism{

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
	private double fitness1 = 0;
	static StringBuilder sb = new StringBuilder();

	public void XgenerateIndividual() {
		for (int i = 0; i < Xasize(); i++) {
			if ((double) (random_generate_or_read(Execution_Mode)) < initialPopulationRate)
				Xa[i] = 0;
			else
				Xa[i] = 1;
		}
		for (int i = 0; i < Xhsize(); i++) {
			if ((double) (random_generate_or_read(Execution_Mode)) < initialPopulationRate)
				Xh[i] = 0;
			else
				Xh[i] = 1;
		}
		for (int i = 0; i < Xtsize(); i++) {
			if ((double) (random_generate_or_read(Execution_Mode)) < initialPopulationRate)
				Xt[i] = 0;
			else
				Xt[i] = 1;
		}
	}

	public void YgenerateIndividual() {
		for (int i = 0; i < Ysize(); i++) {
			if ((double) (random_generate_or_read(Execution_Mode)) < initialPopulationRate)
				Y[i] = 0;
			else
				Y[i] = 1;
		}

	}

	public double random_generate_or_read(int Execution_Mode) {
		double xxx1;
		if (Execution_Mode == 0) {
			xxx1 = Math.random();
			sb.append(xxx1 + " ");
			// GA_Read_Write_txt.write_to_evolution_log(sb);
			// Write_to_txt.write_to_evolution_log(sb);
			if (Write_Mode == 0) {
				long totalstartTime = System.currentTimeMillis();
				GA_Read_Write_txt.write_to_evolution_log(sb);
				long totalendTime = System.currentTimeMillis();
				time_write_to_TXT += (totalendTime - totalstartTime);
			}

			return xxx1;
		} else {
			return GA_Read_Write_txt.read_from_evolution_log();
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
		fitness1 = 0;
	}

	public void setXh(int index, int value) {
		Xh[index] = value;
		fitness = 0;
		fitness1 = 0;
	}

	public void setXt(int index, int value) {
		Xt[index] = value;
		fitness = 0;
		fitness1 = 0;
	}

	public void setY(int index, int value) {
		Y[index] = value;
		fitness = 0;
		fitness1 = 0;
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
		if (fitness1 == 0) {
			fitness1 = FitnessCalc.getFitness_Function(this);

		}
		return fitness1;
	}

	public double getFitness2()   {
		if (fitness == 0) {
			fitness = FitnessCalc.getFitness_Function2(this);

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
