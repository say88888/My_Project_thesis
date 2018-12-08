package Algorithm_DoubleAuction.DE_Real_DA;

import java.util.Random;

public class V_Individual extends Double_Auction_DE_Real {

	static int defaultGeneLengthX = Xsize;
	private double[] Vx = new double[defaultGeneLengthX];
	private double[] Vrs = new double[defaultGeneLengthX];
	static int defaultGeneLengthY = Ysize;
	private double[] Vy = new double[defaultGeneLengthY];
	private double[] Vrb = new double[defaultGeneLengthY];
	private double Vr;
	// Cache
	private double fitness = 0;
	Random ran = new Random();

	public void XpreviousIndividual() {
		for (int i = 0; i < Vxsize(); i++) {
			 Vx[i] = DE_Read_Write_txt.random_generate_or_read4(Execution_Mode);
		}
	}

	public void YpreviousIndividual() {
		for (int i = 0; i < Vysize(); i++) {
			Vy[i] = DE_Read_Write_txt.random_generate_or_read4(Execution_Mode);
		}
	}

	public void rspreviousIndividual() {
		for (int i = 0; i < Vrssize(); i++) {
			 Vrs[i] = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
		}
	}
	
	public void rbpreviousIndividual() {
		for (int i = 0; i < Vrbsize(); i++) {
			Vrb[i] = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
		}
	}
	
	public void rpreviousIndividual() {
			 Vr = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
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

	public double getVx(int index) {
		return Vx[index];
	}

	public double getVy(int index) {
		return Vy[index];
	}

	public double getVrs(int index) {
		return Vrs[index];
	}

	public double getVrb(int index) {
		return Vrb[index];
	}
	
	public double getVr() {
		return Vr;
	}
	
	public void setVx(int index, double value) {
		Vx[index] = value;
		fitness = 0;
	}

	public void setVy(int index, double value) {
		Vy[index] = value;
		fitness = 0;
	}

	public void setVrs(int index, double value) {
		Vrs[index] = value;
		fitness = 0;
	}

	public void setVrb(int index, double value) {
		Vrb[index] = value;
		fitness = 0;
	}
	
	public void setVr(double value) {
		Vr = value;
		fitness = 0;
	}
	/* Public methods */
	public int Vxsize() {
		return Vx.length;
	}

	public int Vysize() {
		return Vy.length;
	}

	public int Vrssize() {
		return Vrs.length;
	}

	public int Vrbsize() {
		return Vrb.length;
	}
	
	public double getFitness() {
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
		for (int i = 0; i < Vxsize(); i++) {
			geneString += getVx(i);
		}
		return geneString;
	}
}
