package Algorithm_DoubleAuction.DE_DA;

import java.util.Random;

public class V_Individual extends Double_Auction_DE {

	static int defaultGeneLengthX = Xsize;
	private int[] Vx = new int[defaultGeneLengthX];
	static int defaultGeneLengthY = Ysize;
	private int[] Vy = new int[defaultGeneLengthY];

	// Cache
	private double fitness = 0;
	Random ran = new Random();

	public void XpreviousIndividual() {
		for (int i = 0; i < Vxsize(); i++) {
			 Vx[i] = DE_Read_Write_txt.random_generate_or_read(Execution_Mode);
		}
		
	}

	public void YpreviousIndividual() {
		for (int i = 0; i < Vysize(); i++) {
			Vy[i] = DE_Read_Write_txt.random_generate_or_read(Execution_Mode);
		}

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

	public int getVx(int index) {
		return Vx[index];
	}

	public int getVy(int index) {
		return Vy[index];
	}

	public void setVx(int index, int value) {
		Vx[index] = value;
		fitness = 0;
	}

	public void setVy(int index, int value) {
		Vy[index] = value;
		fitness = 0;
	}

	/* Public methods */
	public int Vxsize() {
		return Vx.length;
	}

	public int Vysize() {
		return Vy.length;
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
