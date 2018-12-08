package Algorithm_Carpool.PSO_LS_WaitingTime;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import READ_TXT.Read_INPUT_TXT_filter;

public class Individual extends PSO_LS_WaitingTime {

	static int defaultGeneLengthA = P;

	static int defaultGeneLengthB = P;
	private int[] A = new int[defaultGeneLengthB];
	private int[] B = new int[2*defaultGeneLengthB];

	// Cache
	private double fitness = 0;
	Random ran = new Random();

	public void AgenerateIndividual() {
		int[] seat=new int[D];
		int[] Weight_Limit=new int[D];
		for (int i = 0; i < Asize(); i++) {
			int k=Alist.get(i).get(PSO_Read_Write_txt.random_generate_or_readA(Execution_Mode,i)) ; 
			if(k!=0){
				seat[k-1]+=1;
				Weight_Limit[k-1]+=Read_INPUT_TXT_filter.getweight(i);
			if((seat[k-1]<=Read_INPUT_TXT_filter.getP_NUMBER(k-1)&&(Weight_Limit[k-1]<=Read_INPUT_TXT_filter.getWeight_Limit(k-1))))
				A[i] = k ;
			}
			else
				A[i]=0;
		}
	}

	public void BgenerateIndividual() {
		Local_Serch.NNH(A);
		for (int i = 0; i < Bstring.size(); i++) 
				B[i] = Bstring.get(i);
		
	}

	/* Getters and setters */
	// Use this if you want to create individuals with different gene lengths
	// 如果你想創建具有不同基因的長度個體使用本
	public static void setDefaultGeneLengthA(int length) {
		defaultGeneLengthA = length;
	}

	public static void setDefaultGeneLengthB(int length) {
		defaultGeneLengthB = length;
	}

	public int getA(int index) {
		return A[index];
	}

	public int getB(int index) {
		return B[index];
	}

	public void setA(int index, int value) {
		A[index] = value;
		fitness = 0;
	}

	public void setB(int index, int value) {
		B[index] = value;
		fitness = 0;
	}

	/* Public methods */
	public int Asize() {
		return A.length;
	}

	public int Bsize() {
		return B.length;
	}

	public double getFitness() {
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
		for (int i = 0; i < Bsize(); i++) {
			geneString += getB(i);
		}
		geneString += ",";
		for (int i = 0; i < Asize(); i++) {
			geneString += getA(i);
		}
		return geneString;
	}
}
