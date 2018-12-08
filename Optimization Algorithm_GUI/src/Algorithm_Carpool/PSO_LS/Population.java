package Algorithm_Carpool.PSO_LS;

import java.util.ArrayList;
 
public class Population extends PSO_LS {
	Individual[] individuals;
	P_Individual[] P_individuals;
	G_Individual[] G_individuals;
	E_Individual[] E_individuals;
	V_Individual[] V_individuals;
	/*
	 * Constructors 構造函數
	 */
	// Create a population 創建一個人口
	public Population(int populationSize, boolean initialise) {
		individuals = new Individual[populationSize];
		P_individuals = new P_Individual[populationSize];
		G_individuals = new G_Individual[1];
		E_individuals = new E_Individual[1];
		V_individuals = new V_Individual[populationSize];
		// Initialise population 人口初始化
		if (initialise) {
			G_Individual newGIndividual = new G_Individual();
			 
			newGIndividual.AglobalIndividual();
			newGIndividual.BglobalIndividual();
			saveG_Individual(  newGIndividual);
			
			E_Individual newEIndividual = new E_Individual();
		 
			newEIndividual.AglobalIndividual();
			newEIndividual.BglobalIndividual();
			saveE_Individual(  newEIndividual);
			
			// Loop and create individuals 循環並個體創建
			for (int i = 0; i < size(); i++) {
				Individual newIndividual = new Individual();
			 
				newIndividual.AgenerateIndividual();
				newIndividual.BgenerateIndividual();
				saveIndividual(i, newIndividual);
		
				P_Individual newPIndividual = new P_Individual();
			 
				newPIndividual.ApreviousIndividual();
				newPIndividual.BpreviousIndividual();
				saveP_Individual(i, newPIndividual);
				
			
				
				V_Individual newVIndividual = new V_Individual();
				newVIndividual.XvelocityIndividual();
				newVIndividual.YvelocityIndividual();
				saveV_Individual(i, newVIndividual);
			}
		
		}
	}




	/* Getters */
	public Individual getIndividual(int index) {
		return individuals[index];
	}
	public P_Individual getP_Individual(int index) {
		return P_individuals[index];
	}
	public G_Individual getG_Individual(  ) {
		return G_individuals[0];
	}
	public E_Individual getE_Individual(  ) {
		return E_individuals[0];
	}
	public V_Individual getV_Individual(int index) {
		return V_individuals[index];
	}
	public G_Individual getFittest() {
		G_Individual fittest = G_individuals[0];
		// Loop through individuals to find fittest 通過個體循環找到優勝劣汰
	/*	for (int i = 0; i < size(); i++) {
			if (fittest.getFitness() <= getG_Individual(i).getFitness()) {
				fittest = getG_Individual(i);
			}
		}*/
		return fittest;
	}





	/* Public methods 公共方法 */
	// Get population size 獲取種群大小
	public int size() {
		return individuals.length;
	}

	// Save individual 保存個體
	public void saveIndividual(int index, Individual indiv) {
		individuals[index] = indiv;
	}
	public void saveP_Individual(int index, P_Individual indiv) {
		P_individuals[index] = indiv;
	}
	public void saveG_Individual(  G_Individual indiv) {
		G_individuals[0] = indiv;
	}
	public void saveE_Individual(  E_Individual indiv) {
		E_individuals[0] = indiv;
	}
	public void saveV_Individual(int index, V_Individual indiv) {
		V_individuals[index] = indiv;
	}
}
