package Algorithm_Carpool.PSO_LS_SetBased;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import READ_TXT.Read_INPUT_TXT_filter;

public class G_Individual extends PSO_LS_SetBased {

	static int defaultGeneLengthA = D;

	static int defaultGeneLengthB = P;
	private int[][] GA = new int[defaultGeneLengthA][defaultGeneLengthB];
	private int[][] GB = new int[defaultGeneLengthA][2*defaultGeneLengthB];
	private int[] a=new int[defaultGeneLengthB];
	// Cache
	private double fitness = 0;
	private double fitness1 = 0;
	Random ran = new Random();

	public void AglobalIndividual() {
		double random_or_heuristic=PSO_Read_Write_txt.random_generate_or_read5(Execution_Mode);
		if(random_or_heuristic<random_or_heuristic_prob){
			for (int d = 0; d < D; d++){
				for (int p = 0; p < P; p++) {
					GA[d][p]=PSO_Read_Write_txt.random_generate_or_read3(Execution_Mode);
				}
			}
			Local_Serch.NNH(GA);
			for (int i = 0; i < M.size(); i++) 
				for (int j = 0; j < M.get(i).size();j++) 
					GB[i][j] = M.get(i).get(j);
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
						GA[d][p] = 1;
					}else
						GA[d][p] = 0;
				}
			}
			
			Local_Serch.BuildTour(GA);
			for (int i = 0; i < Pi_id.size(); i++) 
				for (int j = 0; j < Pi_id.get(i).size();j++)
					GB[i][j] = Pi_id.get(i).get(j);
			
			for (int d = 0; d < D; d++)
				for (int p = 0; p < P; p++) 
					GA[d][p]=0;
				
			for (int i = 0; i < Pi_id.size(); i++) 
				for (int j = 0; j < Pi_id.get(i).size();j++)
				if(Pi_id.get(i).get(j)>0)
				{
					GA[i][Pi_id.get(i).get(j)-1]=1;
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

	public int getGA(int index,int index1) {
		return GA[index][index1];
	}

	public int getGB(int index,int index1) {
		return GB[index][index1];
	}

	public void setGA(int index,int index1,int value) {
		GA[index][index1] = value;
		fitness = 0;
		fitness1 = 0;
	}

	public void setGB(int index,int index1, int value) {
		GB[index][index1] = value;
		fitness = 0;
		fitness1 = 0;
	}

	/* Public methods */
	public int GAsize() {
		return GA.length;
	}
	public int GAsize1(int i) {
		return GA[i].length;
	}
	
	public int GBsize() {
		return GB.length;
	}
	
	public int GBsize1(int i){
		return GB[i].length;
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
		for (int i = 0; i < D; i++)
			for (int j = 0; i < P; j++){ 
			geneString += getGB(i,j);
		}
		geneString += ",";
		for (int i = 0; i < D; i++) 
			for (int j = 0; j < P; j++) 
			{
			geneString += getGA(i,j);
			}
		return geneString;
	}
	
}
