package Algorithm_DoubleAuction.DE_Real_POP_DA_Problem3;

import java.util.Random;

import Input_Output_txt.Double_Auction.Read_Seller_Price_Parameter;
import Input_Output_txt.Double_Auction.Read_Sik_Parameter;
 
public class Individual extends Double_Auction_DE_Real_POP_Problem3{

	static int defaultGeneLengthX = Xsize;
	private int[] X = new int[defaultGeneLengthX];
	private int[] binaryX = new int[defaultGeneLengthX];
	static int defaultGeneLengthY =Ysize ;
    private double[] Y = new double[defaultGeneLengthY];
    private int[] binaryY = new int[defaultGeneLengthY];
	// Cache
	private double fitness = 0;
	private double fitness1 = 0;
	Random ran = new Random();

	public void XgenerateIndividual() {
		defaultGeneLengthX = Xsize;
		X = new int[defaultGeneLengthX];
 		for (int i = 0; i < Xsize(); i++) {
			X[i] = DE_Read_Write_txt.random_generate_or_read2(Execution_Mode,Read_Sik_Parameter.top()+1);
		//	X[i] = (int)DE_Read_Write_txt.random_generate_or_read1(Execution_Mode)*Read_Seller_Price_Parameter.top();
			
		}
	}

	public void YgenerateIndividual() {
		defaultGeneLengthY = Ysize;
		Y = new double[defaultGeneLengthY];
		binaryY = new int[defaultGeneLengthY];
		for (int i = 0; i < Ysize(); i++) {
			Y[i] = DE_Read_Write_txt.random_generate_or_read4(Execution_Mode);
			double rsid = DE_Read_Write_txt
					.random_generate_or_read1(Execution_Mode);
			if (rsid < 1 / (1 + Math.exp(-lamda * Y[i]))) {
				binaryY[i] = 1;
			} else {
				binaryY[i] = 0;
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

	public int getX(int index) {
		return X[index];
	}

	public double getY(int index) {
		return Y[index];
	}

	public void setX(int index, int value) {
		X[index] = value;
		fitness = 0;
		fitness1 = 0;
	}

	public void setY(int index, double value) {
		Y[index] = value;
		fitness = 0;
		fitness1 = 0;
	}

	public int getbinaryX(int index) {
		return binaryX[index];
	}

	public int getbinaryY(int index) {
		return binaryY[index];
	}

	public void setbinaryX(int index, int value) {
		binaryX[index] = value;
		fitness = 0;
		fitness1 = 0;
	}

	public void setbinaryY(int index, int value) {
		binaryY[index] = value;
		fitness = 0;
		fitness1 = 0;
	}

	/* Public methods */
	public int Xsize() {
		return X.length;
	}

	public int Ysize() {
		return Y.length;
	}

	public double getFitness() {
		if (fitness1 == 0) {
			fitness1 = FitnessCalc.getFitness(this);

		}
		return fitness1;
	}

	public double getFitness1() {
		if (fitness == 0) {
			fitness = FitnessCalc.getFitness1(this);

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
		for (int i = 0; i < Xsize(); i++) {
			geneString += getX(i);
		}
		return geneString;
	}
}
