package Algorithm_Carpool.PSO_LS_SetBased;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import READ_TXT.Read_INPUT_TXT_filter;

public class E_Individual extends PSO_LS_SetBased{

	static int defaultGeneLengthA = D;

	static int defaultGeneLengthB = P;
	private int[][] EA = new int[defaultGeneLengthA][defaultGeneLengthB];
	private int[][] EB= new int[defaultGeneLengthA][2*defaultGeneLengthB];
	private int[] a=new int[defaultGeneLengthB];
	// Cache
	private double fitness = 0;
	private double fitness1 = 0;
	Random ran = new Random();

	public void AglobalIndividual() {
		int[] seat=new int[D];
		int[] Weight_Limit=new int[D];
		for (int i = 0; i < P; i++) {
			int k=Alist.get(i).get(PSO_Read_Write_txt.random_generate_or_readA(Execution_Mode,i)) ; 
			if(k!=0){
				seat[k-1]+=1;
				Weight_Limit[k-1]+=Read_INPUT_TXT_filter.getweight(i);
			if((seat[k-1]<=Read_INPUT_TXT_filter.getP_NUMBER(k-1)&&(Weight_Limit[k-1]<=Read_INPUT_TXT_filter.getWeight_Limit(k-1))))
				a[i] = k ;
			}
			else
				a[i]=0;
			}
		for (int d = 0; d < D; d++){
			for (int p = 0; p < P; p++) {
				if (a[p] == (d + 1)){
					EA[d][p] = 1;
				}else
					EA[d][p] = 0;
			}
		}
	}

	public void BglobalIndividual() {
		Local_Serch.BuildTour(EA);
	
		for (int i = 0; i < M.size(); i++) 
			for (int j = 0; j < M.get(i).size();j++) 
				EB[i][j] = M.get(i).get(j);
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

	public int getEA(int index,int index1) {
		return EA[index][index1];
	}

	public int getEB(int index,int index1) {
		return EB[index][index1];
	}

	public void setEA(int index,int index1,int value) {
		EA[index][index1] = value;
		fitness = 0;
		fitness1 = 0;
	}

	public void setEB(int index,int index1, int value) {
		EB[index][index1] = value;
		fitness = 0;
		fitness1 = 0;
	}

	/* Public methods */
	public int EAsize() {
		return EA.length;
	}
	public int EAsize1(int i) {
		return EA[i].length;
	}
	
	public int EBsize() {
		return EB.length;
	}
	
	public int EBsize1(int i) {
		return EB[i].length;
	}

	public double getFitness1() {
		if (fitness == 0) {
			fitness = FitnessCalc.getEFitness1(this);
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
		for (int i = 0; i < D; i++)
			for (int j = 0; i < P; j++){ 
			geneString += getEB(i,j);
		}
		geneString += ",";
		for (int i = 0; i < D; i++) 
			for (int j = 0; j < P; j++) 
			{
			geneString += getEA(i,j);
			}
		return geneString;
	}
}

