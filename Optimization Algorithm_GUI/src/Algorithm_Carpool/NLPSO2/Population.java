package Algorithm_Carpool.NLPSO2;

import java.util.ArrayList;
import java.util.List;
 
public class Population extends NLPSO2 {
	Individual[] individuals;
	P_Individual[] P_individuals;
	G_Individual[] G_individuals;
	V_Individual[] V_individuals;
	Plbest_Individual[] Plbest_individuals;
	Pworst_Individual[] Pworst_individuals;
	SM_Individual[] SM_individuals;
	U_Individual[] U_individuals;
	LM_Individual[] LM_individuals;
	/*
	 * Constructors 構造函數
	 */
	// Create a population 創建一個人口
	public Population(int populationSize, boolean initialise) {
		individuals = new Individual[populationSize];
		P_individuals = new P_Individual[populationSize];
		G_individuals = new G_Individual[1];
		SM_individuals = new SM_Individual[populationSize];
		V_individuals = new V_Individual[populationSize];
		Plbest_individuals =new Plbest_Individual[n3.size()];
		Pworst_individuals =new Pworst_Individual[n3.size()];
		U_individuals = new U_Individual[1];
		LM_individuals  = new LM_Individual[n3.size()];
		// Initialise population 人口初始化
		if (initialise) {
			G_Individual newGIndividual = new G_Individual();
			newGIndividual.XglobalIndividual();
			newGIndividual.YglobalIndividual();
			saveG_Individual(  newGIndividual);
		
			U_Individual newUIndividual = new U_Individual();
			newUIndividual.XglobalIndividual();
			newUIndividual.YglobalIndividual();
			saveU_Individual( newUIndividual);
			
			for(int i=0;i<n3.size();i++){
				
				Plbest_Individual newPlbestIndividual = new Plbest_Individual();
				newPlbestIndividual.XglobalIndividual();
				newPlbestIndividual.YglobalIndividual();
				savePlbest_Individual(i, newPlbestIndividual);
				
				Pworst_Individual newPworstIndividual = new Pworst_Individual();
				newPworstIndividual.XpreviousIndividual();
				newPworstIndividual.YpreviousIndividual();
				savePworst_Individual(i, newPworstIndividual);
				
				LM_Individual newLMIndividual = new LM_Individual();
				newLMIndividual.XglobalIndividual();
				newLMIndividual.YglobalIndividual();
				saveLM_Individual(i, newLMIndividual);
				
			}
			// Loop and create individuals 循環並個體創建
			for (int i = 0; i < size(); i++) {
				Individual newIndividual = new Individual();
				newIndividual.XgenerateIndividual();
				newIndividual.YgenerateIndividual();
				saveIndividual(i, newIndividual);
		
				P_Individual newPIndividual = new P_Individual();
				newPIndividual.XpreviousIndividual();
				newPIndividual.YpreviousIndividual();
				saveP_Individual(i, newPIndividual);
				
	
				V_Individual newVIndividual = new V_Individual();
				newVIndividual.XvelocityIndividual();
				newVIndividual.YvelocityIndividual();
				saveV_Individual(i, newVIndividual);
				
			 
				SM_Individual newSMIndividual = new SM_Individual();
				newSMIndividual.XglobalIndividual();
				newSMIndividual.YglobalIndividual();
				saveSM_Individual(i, newSMIndividual);
				
				
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
	
	public Plbest_Individual getPlbest_Individual(int index) {
		return Plbest_individuals[index];
	}
	public Pworst_Individual getPworst_Individual(int index) {
		return Pworst_individuals[index];
	}
	public G_Individual getG_Individual(  ) {
		return G_individuals[0];
	}
	public SM_Individual getSM_Individual( int index ) {
		return SM_individuals[index];
	}
	public V_Individual getV_Individual(int index) {
		return V_individuals[index];
	}
 
	public LM_Individual getLM_Individual( int index) {
		return LM_individuals[index];
	}
	
	public U_Individual getU_Individual( ) {
		return U_individuals[0];
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
	public void savePlbest_Individual(int index, Plbest_Individual indiv) {
		Plbest_individuals[index] = indiv;
	}
	public void savePworst_Individual(int index, Pworst_Individual indiv) {
		Pworst_individuals[index] = indiv;
	}
	public void saveLM_Individual(int index, LM_Individual invid) {
		 
		LM_individuals[index]=invid;
	}
	public void saveG_Individual(  G_Individual indiv) {
		G_individuals[0] = indiv;
	}
	public void saveSM_Individual(int index, SM_Individual indiv) {
		SM_individuals[index] = indiv;
	}
	public void saveV_Individual(int index, V_Individual indiv) {
		V_individuals[index] = indiv;
	}
 
	public void saveU_Individual(U_Individual indiv) {
		U_individuals[0] = indiv;
	}
}
