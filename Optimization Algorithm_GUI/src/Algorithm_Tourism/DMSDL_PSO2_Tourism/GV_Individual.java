package Algorithm_Tourism.DMSDL_PSO2_Tourism;

import java.util.Random;
 
public class GV_Individual extends DMSDL_PSO2_Tourism{

	static int defaultGeneLengthXa = Xasize;
	private int[] GVxa = new int[defaultGeneLengthXa];
	static int defaultGeneLengthXh = Xhsize;
	private int[] GVxh = new int[defaultGeneLengthXh];
	static int defaultGeneLengthXt = Xtsize;
	private int[] GVxt = new int[defaultGeneLengthXt];
	static int defaultGeneLengthY = Ysize;
	private int[] GVy = new int[defaultGeneLengthY];

	// Cache
	private double fitness = 0;
	private double fitness1 = 0;
	Random ran = new Random();

	public void XglobalIndividual() {
		for (int i = 0; i < GVxasize(); i++) {

			GVxa[i] = PSO_Read_Write_txt.random_generate_or_read(Execution_Mode);
		}
		for (int i = 0; i < GVxhsize(); i++) {

			GVxh[i] = PSO_Read_Write_txt.random_generate_or_read(Execution_Mode);
		}
		for (int i = 0; i < GVxtsize(); i++) {

			GVxt[i] = PSO_Read_Write_txt.random_generate_or_read(Execution_Mode);
		}
	}

	public void YglobalIndividual() {
		for (int i = 0; i < GVysize(); i++) {
			GVy[i] = PSO_Read_Write_txt.random_generate_or_read(Execution_Mode);
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

	public int getGVxa(int index) {
		return GVxa[index];
	}

	public int getGVxh(int index) {
		return GVxh[index];
	}

	public int getGVxt(int index) {
		return GVxt[index];
	}

	public int getGVy(int index) {
		return GVy[index];
	}

	public void setGVxa(int index, int value) {
		GVxa[index] = value;
		fitness = 0;
		fitness1 = 0;
	}

	public void setGVxh(int index, int value) {
		GVxh[index] = value;
		fitness = 0;
		fitness1 = 0;
	}

	public void setGVxt(int index, int value) {
		GVxt[index] = value;
		fitness = 0;
		fitness1 = 0;
	}

	public void setGVy(int index, int value) {
		GVy[index] = value;
		fitness = 0;
		fitness1 = 0;
	}

	/* Public methods */
	public int GVxasize() {
		return GVxa.length;
	}

	public int GVxhsize() {
		return GVxh.length;
	}

	public int GVxtsize() {
		return GVxt.length;
	}

	public int GVysize() {
		return GVy.length;
	}

	public double getFitness1() {
        if (fitness == 0) {
           fitness = FitnessCalc.getGVFitness(this);
        
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
    for (int i = 0; i < GVysize(); i++) {
        geneString += getGVy(i);
    }
    geneString+=",";
	for (int i = 0; i < GVxasize(); i++) {
		geneString += getGVxa(i);
	}
    return geneString;
}
}
