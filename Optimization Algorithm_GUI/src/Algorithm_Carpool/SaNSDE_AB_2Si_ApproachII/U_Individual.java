package Algorithm_Carpool.SaNSDE_AB_2Si_ApproachII;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
 
public class U_Individual extends SaNSDE_AB_2Si_ApproachII{

	static int defaultGeneLengthX = P;
	private double[] Ux = new double[defaultGeneLengthX];
	private int[] binaryUx = new int[D];
	private int[] UA = new int[defaultGeneLengthX];
	private int[] Urid = new int[defaultGeneLengthX];

	static int defaultGeneLengthY = 2*P;
	private double[] Uy = new double[defaultGeneLengthY];
	private int[] binaryUy = new int[P];
	private int[] UB = new int[defaultGeneLengthY];
	private int[] Usi = new int[defaultGeneLengthY];
	// Cache
	private double fitness = 0;
	private double fitness1 = 0;
	Random ran = new Random();

	public void XglobalIndividual() {
		defaultGeneLengthX = P;
		Ux = new double[defaultGeneLengthX];
		binaryUx = new int[D];
		binaryUy = new int[P];
		UA = new int[defaultGeneLengthX];
		UB = new int[defaultGeneLengthY*2];
		Urid = new int[defaultGeneLengthX];
		
		for (int i = 0; i < Uxsize(); i++) {
			Ux[i] = DE_Read_Write_txt.random_generate_or_read4(Execution_Mode);
			if(Md.get(i).size()>0){
				Urid[i]=(int) Math.round(((Md.get(i).size()-1)*(Ux[i]+Vmax))/(2*Vmax)+1);
			}
			else 
			{
				Urid[i]=0;
			}
		}
		UA=Convert_Function.Get_A(Urid);
		binaryUx=Convert_Function.Get_binaryX(UA);
		binaryUy=Convert_Function.Get_binaryY(UA);
	}

	public void YglobalIndividual() {
		defaultGeneLengthY = 2*P;
		Uy = new double[defaultGeneLengthY];
		Usi = new int[defaultGeneLengthY];
		Double[] si= new Double[defaultGeneLengthY];
		for (int i = 0; i < defaultGeneLengthY; i++) {
			Uy[i] = DE_Read_Write_txt.random_generate_or_read4(Execution_Mode);
			si[i]=Uy[i];
			}
		
		//Step2  If the value of passenger location d+ is less than the value of passenger location d-, swap the values of passenger location d+ and the value of passenger location d-.
		for(int i=0;i<P;i++)
		{
			if(si[i]<si[i+P])
			{
				double temp;
				temp=si[i];
				si[i]=si[i+P];
				si[i+P]=temp;
			}
		}
		//Step3  If the value of passenger location d+ is less than the value of passenger location d-, swap the values of passenger location d+ and the value of passenger location d-.
		int[] Si_p=new int[defaultGeneLengthY];
		for(int i=0;i<P;i++) {
			Si_p[i]=i+1;
			Si_p[i+P]=-(i+1);
		}
		for(int i=0;i<defaultGeneLengthY-1;i++)
			for(int j=0;j<defaultGeneLengthY-1;j++)
			{
				if(si[j]<si[j+1]){
					double temp;
					temp=si[j];
					si[j]=si[j+1];
					si[j+1]=temp;
					int temp1;
					temp1=Si_p[j];
					Si_p[j]=Si_p[j+1];
					Si_p[j+1]=temp1;
				}
			}
		Usi=Si_p;
			
		UB=Convert_Function.Get_B(UA,Usi);
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

	public double getUx(int index) {
		return Ux[index];
	}

	public double getUy(int index) {
		return Uy[index];
	}

	public void setUx(int index, double value) {
		Ux[index] = value;
		fitness = 0;
		fitness1 = 0;
	}

	public void setUy(int index, double value) {
		Uy[index] = value;
		fitness = 0;
		fitness1 = 0;
	}

	public int getbinaryUx(int index) {
		return binaryUx[index];
	}

	public int getbinaryUy(int index) {
		return binaryUy[index];
	}

	public void setbinaryUx(int index, int value) {
		binaryUx[index] = value;
		fitness = 0;
		fitness1 = 0;
	}

	public void setbinaryUy(int index, int value) {
		binaryUy[index] = value;
		fitness = 0;
		fitness1 = 0;
	}
	
	public int getUrid(int index) {
		return Urid[index];
	}

	public int getUsi(int index) {
		return Usi[index];
	}

	public void setUrid(int index, int value) {
		Urid[index] = value;
		fitness = 0;
		fitness1 = 0;
	}

	public void setUsi(int index, int value) {
		Usi[index] = value;
		fitness = 0;
		fitness1 = 0;
	}
	public int getUA(int index) {
		return UA[index];
	}

	public int getUB(int index) {
		return UB[index];
	}

	public void setUA(int index, int value) {
		UA[index] = value;
		fitness = 0;
		fitness1 = 0;
	}

	public void setUB(int index, int value) {
		UB[index] = value;
		fitness = 0;
		fitness1 = 0;
	}
	/* Public methods */
	public int Uxsize() {
		return Ux.length;
	}

	public int Uysize() {
		return Uy.length;
	}
	
	public int binaryUxsize() {
		return binaryUx.length;
	}

	public int binaryUysize() {
		return binaryUy.length;
	}
	
	public int UAsize() {
		return UA.length;
	}

	public int UBsize() {
		return UB.length;
	}
	
	
	public double getFitness1() {
		if (fitness == 0) {
			fitness = FitnessCalc.getUFitness(this);
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
		for (int i = 0; i < Uysize(); i++) {
			geneString += getUy(i);
		}
		geneString += ",";
		for (int i = 0; i < Uxsize(); i++) {
			geneString += getUx(i);
		}
		return geneString;
	}
}