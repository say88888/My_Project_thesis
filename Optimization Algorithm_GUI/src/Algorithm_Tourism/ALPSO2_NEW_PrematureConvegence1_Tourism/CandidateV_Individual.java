package Algorithm_Tourism.ALPSO2_NEW_PrematureConvegence1_Tourism;

import java.util.Random;

public class CandidateV_Individual extends ALPSO2_NEW_PrematureConvegence1_Tourism {

	static int defaultGeneLengthXa = Xasize;
	private double[] CandidateVxa = new double[defaultGeneLengthXa];
	static int defaultGeneLengthXh = Xhsize;
	private double[] CandidateVxh = new double[defaultGeneLengthXh];
	static int defaultGeneLengthXt = Xtsize;
	private double[] CandidateVxt = new double[defaultGeneLengthXt];
	static int defaultGeneLengthY = Ysize;
	private double[] CandidateVy = new double[defaultGeneLengthY];

	// Cache
	private double fitness = 0;
	Random ran = new Random();

	public void XvelocityIndividual() {
		for (int i = 0; i < CandidateVxasize(); i++)
		{
			CandidateVxa[i] = PSO_Read_Write_txt.random_generate_or_read2(Execution_Mode);// Math.random()*(Vmax-(-Vmax))+(-Vmax);
		}
		for (int i = 0; i < CandidateVxhsize(); i++)
		{
			CandidateVxh[i] = PSO_Read_Write_txt.random_generate_or_read2(Execution_Mode);// Math.random()*(Vmax-(-Vmax))+(-Vmax);
		}
		for (int i = 0; i < CandidateVxtsize(); i++)
		{
			CandidateVxt[i] = PSO_Read_Write_txt.random_generate_or_read2(Execution_Mode);// Math.random()*(Vmax-(-Vmax))+(-Vmax);
		}
	}

	public void YvelocityIndividual() {
		for (int i = 0; i < CandidateVysize(); i++)
		{
			CandidateVy[i] = PSO_Read_Write_txt.random_generate_or_read2(Execution_Mode);// Math.random()*(Vmax-(-Vmax))+(-Vmax);
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

	public double getCandidateVxa(int index) {
		return CandidateVxa[index];
	}
	public double getCandidateVxh(int index) {
		return CandidateVxh[index];
	}
	public double getCandidateVxt(int index) {
		return CandidateVxt[index];
	}
	public double getCandidateVy(int index) {
		return CandidateVy[index];
	}

	public void setCandidateVxa(int index, double value) {
		CandidateVxa[index] = value;
		fitness = 0;
	}
	public void setCandidateVxh(int index, double value) {
		CandidateVxh[index] = value;
		fitness = 0;
	}
	public void setCandidateVxt(int index, double value) {
		CandidateVxt[index] = value;
		fitness = 0;
	}
	public void setCandidateVy(int index, double value) {
		CandidateVy[index] = value;
		fitness = 0;
	}

	/* Public methods */
	public int CandidateVxasize() {
		return CandidateVxa.length;
	}
	public int CandidateVxhsize() {
		return CandidateVxh.length;
	}
	public int CandidateVxtsize() {
		return CandidateVxt.length;
	}
	public int CandidateVysize() {
		return CandidateVy.length;
	}

	// Cache

	@Override
	public String toString() {
		String geneString = "";
		for (int i = 0; i < CandidateVysize(); i++) {
			geneString += getCandidateVy(i);
		}
		geneString += ",";
		for (int i = 0; i < CandidateVxasize(); i++) {
			geneString += getCandidateVxa(i);
		}
		return geneString;
	}
}
