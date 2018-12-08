package Algorithm_DoubleAuction.L_SHADE_CCPSO2_DA;

import java.util.Random;
 
public class P_Individual extends Double_Auction_L_SHADE_CCPSO2{

	static int defaultGeneLengthX = Xsize;
	private int[] Px = new int[defaultGeneLengthX];
	private double[] Prs = new double[defaultGeneLengthX];
	static int defaultGeneLengthY = Ysize;
	private int[] Py = new int[defaultGeneLengthY];
	private double[] Prb = new double[defaultGeneLengthY];
	private double Pr;
	// Cache
	private double fitness = 0;
	Random ran = new Random();

	public void XpreviousIndividual() {
		for (int i = 0; i < Pxsize(); i++)
		{
			Px[i] = PSO_Read_Write_txt.random_generate_or_read(Execution_Mode);
		}
	}

	public void YpreviousIndividual() {
		for (int i = 0; i < Pysize(); i++)
		{
			Py[i] = PSO_Read_Write_txt.random_generate_or_read(Execution_Mode);
		}
	}

	public void rspreviousIndividual() {
		for (int i = 0; i < Prssize(); i++)
		{
			Prs[i] = PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode);
		}
	}

	public void rbpreviousIndividual() {
		for (int i = 0; i < Prbsize(); i++)
		{
			Prb[i] = PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode);
		}
	}

	public void rpreviousIndividual() {
		Pr = PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode);
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

	public int getPx(int index) {
		return Px[index];
	}

	public int getPy(int index) {
		return Py[index];
	}

	public double getPrs(int index) {
		return Prs[index];
	}

	public double getPrb(int index) {
		return Prb[index];
	}

	public double getPr() {
		return Pr;
	}

	public void setPx(int index, int value) {
		Px[index] = value;
		fitness = 0;
	}

	public void setPy(int index, int value) {
		Py[index] = value;
		fitness = 0;
	}

	public void setPrs(int index, double value) {
		Prs[index] = value;
		fitness = 0;
	}

	public void setPrb(int index, double value) {
		Prb[index] = value;
		fitness = 0;
	}

	public void setPr(double value) {
		Pr = value;
		fitness = 0;
	}

	/* Public methods */
	public int Pxsize() {
		return Px.length;
	}

	public int Pysize() {
		return Py.length;
	}

	public int Prssize() {
		return Prs.length;
	}

	public int Prbsize() {
		return Prb.length;
	}

	public double getFitness() {
		if (fitness == 0) {
			fitness = FitnessCalc.getPFitness(this);

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
