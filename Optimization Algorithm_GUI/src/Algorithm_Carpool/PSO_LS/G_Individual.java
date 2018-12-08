package Algorithm_Carpool.PSO_LS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import READ_TXT.Read_INPUT_TXT_filter;

public class G_Individual extends PSO_LS {

	static int defaultGeneLengthA = P;

	static int defaultGeneLengthB = P;
	private int[] GA = new int[defaultGeneLengthB];
	private int[] GB = new int[2 * defaultGeneLengthB];

	// Cache
	private double fitness = 0;
	private double fitness1 = 0;
	Random ran = new Random();

	public void AglobalIndividual() {
		int[] seat=new int[D];
		int[] Weight_Limit=new int[D];
		for (int i = 0; i < GAsize(); i++) {
			int k=Alist.get(i).get(PSO_Read_Write_txt.random_generate_or_readA(Execution_Mode,i)) ;
			if(k!=0){
				seat[k-1]+=1;
				Weight_Limit[k-1]+=Read_INPUT_TXT_filter.getweight(i);
			if((seat[k-1]<=Read_INPUT_TXT_filter.getP_NUMBER(k-1)&&(Weight_Limit[k-1]<=Read_INPUT_TXT_filter.getWeight_Limit(k-1))))
				GA[i] = k ;
			}
			else
				GA[i]=0;
		}
	}

	public void BglobalIndividual() {
		Local_Serch.NNH(GA);
		for (int i = 0; i < Bstring.size(); i++) 
			GB[i] = Bstring.get(i);
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

	public int getGA(int index) {
		return GA[index];
	}

	public int getGB(int index) {
		return GB[index];
	}

	public void setGA(int index, int value) {
		GA[index] = value;
		fitness = 0;
		fitness1 = 0;
	}

	public void setGB(int index, int value) {
		GB[index] = value;
		fitness = 0;
		fitness1 = 0;
	}

	/* Public methods */
	public int GAsize() {
		return GA.length;
	}

	public int GBsize() {
		return GB.length;
	}

	public double getFitness() {
		if (fitness1 == 0) {
			fitness1 = FitnessCalc.getFitness(this);

		}
		return fitness1;
	}

	public double getFitness1() {
		if (fitness == 0) {
			fitness = FitnessCalc.getGFitness(this);

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
		for (int i = 0; i < GBsize(); i++) {
			geneString += getGB(i);
		}
		geneString += ",";
		for (int i = 0; i < GAsize(); i++) {
			geneString += getGA(i);
		}
		return geneString;
	}
}
