package Algorithm_Carpool.DMSDL_PSO2;
 
public class Population extends DMSDL_PSO2 {
	Individual[] individuals;
	P_Individual[] P_individuals;
	G_Individual[] G_individuals;
	V_Individual[] V_individuals;
	Vim_Individual[] Vim_individuals;
	Plbest_Individual[] Plbest_individuals;
	GV_Individual[] GV_individuals;
	U_Individual[] U_individuals;
	/*
	 * Constructors 構造函數
	 */
	// Create a population 創建一個人口
	public Population(int populationSize, boolean initialise) {
		individuals = new Individual[populationSize];
		P_individuals = new P_Individual[populationSize];
		G_individuals = new G_Individual[1];
		GV_individuals = new GV_Individual[populationSize];
		V_individuals = new V_Individual[populationSize];
		Vim_individuals = new Vim_Individual[populationSize];
		U_individuals = new U_Individual[populationSize];
		Plbest_individuals = new Plbest_Individual[populationSize];
		// Initialise population 人口初始化
		if (initialise) {
			G_Individual newGIndividual = new G_Individual();
			newGIndividual.XglobalIndividual();
			newGIndividual.YglobalIndividual();
			saveG_Individual(  newGIndividual);
		
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
				
				Plbest_Individual newPlbestIndividual = new Plbest_Individual();
				newPlbestIndividual.XpreviousIndividual();
				newPlbestIndividual.YpreviousIndividual();
				savePlbest_Individual(i, newPlbestIndividual);
				
				V_Individual newVIndividual = new V_Individual();
				newVIndividual.XvelocityIndividual();
				newVIndividual.YvelocityIndividual();
				saveV_Individual(i, newVIndividual);
				
				Vim_Individual newVimIndividual = new Vim_Individual();
				newVimIndividual.XvelocityIndividual();
				newVimIndividual.YvelocityIndividual();
				saveVim_Individual(i, newVimIndividual);
				
				GV_Individual newGVIndividual = new GV_Individual();
				newGVIndividual.XglobalIndividual();
				newGVIndividual.YglobalIndividual();
				saveGV_Individual(i, newGVIndividual);
				
				U_Individual newUIndividual = new U_Individual();
				newUIndividual.XglobalIndividual();
				newUIndividual.YglobalIndividual();
				saveU_Individual(i, newUIndividual);
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
	public G_Individual getG_Individual(  ) {
		return G_individuals[0];
	}
	public GV_Individual getGV_Individual( int index ) {
		return GV_individuals[index];
	}
	public V_Individual getV_Individual(int index) {
		return V_individuals[index];
	}
	public Vim_Individual getVim_Individual(int index) {
		return Vim_individuals[index];
	}
	public U_Individual getU_Individual(int index) {
		return U_individuals[index];
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
	public void saveG_Individual(  G_Individual indiv) {
		G_individuals[0] = indiv;
	}
	public void saveGV_Individual(int index, GV_Individual indiv) {
		GV_individuals[index] = indiv;
	}
	public void saveV_Individual(int index, V_Individual indiv) {
		V_individuals[index] = indiv;
	}
	public void saveVim_Individual(int index, Vim_Individual indiv) {
		Vim_individuals[index] = indiv;
	}
	public void saveU_Individual(int index, U_Individual indiv) {
		U_individuals[index] = indiv;
	}
}
