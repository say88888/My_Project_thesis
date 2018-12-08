package Algorithm_Tourism.CC_CLPSO2_Tourism;

import java.util.Random;
 
public class V_Individual extends CC_CLPSO2_Tourism{

	static int defaultGeneLengthXa = Xasize;
	private double[] Vxa = new double[defaultGeneLengthXa];
	static int defaultGeneLengthXh = Xhsize;
	private double[] Vxh = new double[defaultGeneLengthXh];
	static int defaultGeneLengthXt = Xtsize;
	private double[] Vxt = new double[defaultGeneLengthXt];
	static int defaultGeneLengthY = Ysize;
	private double[] Vy = new double[defaultGeneLengthY];

	// Cache
	private double fitness = 0;
	Random ran = new Random();

	public void XvelocityIndividual() {
		for (int i = 0; i < Vxasize(); i++) {
			Vxa[i] = PSO_Read_Write_txt
					.random_generate_or_read2(Execution_Mode);// Math.random()*(Vmax-(-Vmax))+(-Vmax);
		}
		for (int i = 0; i < Vxhsize(); i++) {
			Vxh[i] = PSO_Read_Write_txt
					.random_generate_or_read2(Execution_Mode);// Math.random()*(Vmax-(-Vmax))+(-Vmax);
		}
		for (int i = 0; i < Vxtsize(); i++) {
			Vxt[i] = PSO_Read_Write_txt
					.random_generate_or_read2(Execution_Mode);// Math.random()*(Vmax-(-Vmax))+(-Vmax);
		}
	}

	public void YvelocityIndividual() {
		for (int i = 0; i < Vysize(); i++) {
			Vy[i] = PSO_Read_Write_txt.random_generate_or_read2(Execution_Mode);// Math.random()*(Vmax-(-Vmax))+(-Vmax);
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

	public double getVxa(int index) {
		return Vxa[index];
	}

	public double getVxh(int index) {
		return Vxh[index];
	}

	public double getVxt(int index) {
		return Vxt[index];
	}

	public double getVy(int index) {
		return Vy[index];
	}

	public void setVxa(int index, double value) {
		Vxa[index] = value;
		fitness = 0;
	}

	public void setVxh(int index, double value) {
		Vxh[index] = value;
		fitness = 0;
	}

	public void setVxt(int index, double value) {
		Vxt[index] = value;
		fitness = 0;
	}

	public void setVy(int index, double value) {
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
