package Algorithm_Carpool.PSO_LS_SetBased;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import READ_TXT.Read_INPUT_TXT_filter;

public class Individual extends PSO_LS_SetBased {

	static int defaultGeneLengthA = D;

	static int defaultGeneLengthB = P;
	private int[][] A = new int[defaultGeneLengthA][defaultGeneLengthB];
	private int[][] B= new int[defaultGeneLengthA][2*defaultGeneLengthB];
	
	private int[] a=new int[defaultGeneLengthB];
	// Cache
	private double fitness = 0;
	Random ran = new Random();

	public void AgenerateIndividual() {
		double random_or_heuristic=PSO_Read_Write_txt.random_generate_or_read5(Execution_Mode);
		if(random_or_heuristic<random_or_heuristic_prob){
			for (int d = 0; d < D; d++){
				for (int p = 0; p < P; p++) {
					A[d][p]=PSO_Read_Write_txt.random_generate_or_read3(Execution_Mode);
				}
			}
			Local_Serch.NNH(A);
			for (int i = 0; i < M.size(); i++) 
				for (int j = 0; j < M.get(i).size();j++) 
					B[i][j] = M.get(i).get(j);
		}
		else
		{
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
						A[d][p] = 1;
					}else
						A[d][p] = 0;
				}
			}
			Local_Serch.BuildTour(A);
			for (int i = 0; i < Pi_id.size(); i++) {
				for (int j = 0; j < Pi_id.get(i).size();j++){
					B[i][j] = Pi_id.get(i).get(j);
				}
			}
			
			
			for (int d = 0; d < D; d++)
				for (int p = 0; p < P; p++) 
					A[d][p]=0;
				
			for (int i = 0; i < Pi_id.size(); i++) 
				for (int j = 0; j < Pi_id.get(i).size();j++)
				if(Pi_id.get(i).get(j)>0)
				{
					A[i][Pi_id.get(i).get(j)-1]=1;
				}
		}
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

	public int getA(int index,int index1) {
		return A[index][index1];
	}

	public int getB(int index,int index1) {
		return B[index][index1];
	}

	public void setA(int index,int index1,int value) {
		A[index][index1] = value;
		fitness = 0;
	}

	public void setB(int index,int index1, int value) {
		B[index][index1] = value;
		fitness = 0;
	}

	/* Public methods */
	public int Asize() {
		return A.length;
	}
	public int Asize1(int i) {
		return A[i].length;
	}
	
	public int Bsize() {
		return B.length;
	}
	
	public int Bsize1(int i) {
		return B[i].length;
	}
	
	public double getFitness() {
		if (fitness == 0) {
			fitness = FitnessCalc.getFitness(this);

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
			for (int j = 0; j < P; j++){ 
			geneString += getB(i,j);
		}
		geneString += ",";
		for (int i = 0; i < D; i++) 
			for (int j = 0; j < P; j++) 
			{
			geneString += getA(i,j);
			}
		return geneString;
	}
}
