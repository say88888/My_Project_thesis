package Algorithm_DoubleAuction.DE_Real_DA_Problem3;

import java.util.Random;

import Input_Output_txt.Double_Auction.Read_Seller_Price_Parameter;
import Input_Output_txt.Double_Auction.Read_Sik_Parameter;

public class V_Individual extends Double_Auction_DE_Real_Problem3 {

	static int defaultGeneLengthX = Xsize;
	private int[] Vx = new int[defaultGeneLengthX];
	static int defaultGeneLengthY = Ysize;
	private double[] Vy = new double[defaultGeneLengthY];
	private int[] binaryVy = new int[defaultGeneLengthY];

	// Cache
	private double fitness = 0;
	Random ran = new Random();

	public void XpreviousIndividual() {
		for (int i = 0; i < Vxsize(); i++) {
			 Vx[i] =  DE_Read_Write_txt.random_generate_or_read2(Execution_Mode,Read_Sik_Parameter.top()+1);
		}
		
	}

	public void YpreviousIndividual() {
		defaultGeneLengthY = Ysize;
		Vy = new double[defaultGeneLengthY];
		binaryVy = new int[defaultGeneLengthY];
		for (int i = 0; i < Vysize(); i++) {
			Vy[i] = DE_Read_Write_txt.random_generate_or_read4(Execution_Mode);
			double rsid = DE_Read_Write_txt
					.random_generate_or_read1(Execution_Mode);
			if (rsid < 1 / (1 + Math.exp(-lamda * Vy[i]))) {
				binaryVy[i] = 1;
			} else {
				binaryVy[i] = 0;
			}
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

	public double getVy(int index) {
		return Vy[index];
	}

	public void setVx(int index, int value) {
		Vx[index] = value;
		fitness = 0;
	}

	public void setVy(int index, double value) {
		Vy[index] = value;
		fitness = 0;
	}

	public int getbinaryVy(int index) {
		return binaryVy[index];
	}
	public void setbinaryVy(int index, int value) {
		binaryVy[index] = value;
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
