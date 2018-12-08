package Algorithm_Carpool.DynDE_AB_2Si_ApproachII;
 
public class Population extends DynDE_AB_2Si_ApproachII {
	Individual[] individuals;
	V_Individual[] P_individuals;
	U_Individual[] U_individuals;
	Plbest_Individual[] Plbest_individuals;
	G_Individual[] G_individuals;
	/*
	 * Constructors 構造函數
	 */
	// Create a population 創建一個人口
	public Population(int populationSize, boolean initialise) {
		individuals = new Individual[populationSize];
		P_individuals = new V_Individual[populationSize];
		U_individuals = new U_Individual[populationSize];
		Plbest_individuals = new Plbest_Individual[n3.size()];
		G_individuals = new G_Individual[1];
		// Initialise population 人口初始化
		if (initialise) {

			G_Individual newGIndividual = new G_Individual();
			newGIndividual.XglobalIndividual();
			newGIndividual.YglobalIndividual();
			saveG_Individual(  newGIndividual);
			
			// Loop and create individuals 循環並個體創建
			for (int i = 0; i < n3.size(); i++) {

				Plbest_Individual newPlbestIndividual = new Plbest_Individual();
				newPlbestIndividual.XglobalIndividual();
				newPlbestIndividual.YglobalIndividual();
				savePlbest_Individual(i, newPlbestIndividual);
				
			}

			for (int i = 0; i < size(); i++) {
				Individual newIndividual = new Individual();
				newIndividual.XgenerateIndividual();
				newIndividual.YgenerateIndividual();
				saveIndividual(i, newIndividual);

				V_Individual newV_Individual = new V_Individual();
				newV_Individual.XpreviousIndividual();
				newV_Individual.YpreviousIndividual();
				saveP_Individual(i, newV_Individual);

				U_Individual newU_Individual = new U_Individual();
				newU_Individual.XglobalIndividual();
				newU_Individual.YglobalIndividual();
				saveU_Individual(i, newU_Individual);
			}

		}
	}

	/* Getters */
	public Individual getIndividual(int index) {
		return individuals[index];
	}

	public V_Individual getP_Individual(int index) {
		return P_individuals[index];
	}
	
	public Plbest_Individual getPlbest_Individual(int index) {
		return Plbest_individuals[index];
	}
	
	
	public U_Individual getU_Individual(int index) {
		return U_individuals[index];
	}
	public G_Individual getG_Individual(  ) {
		return G_individuals[0];
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

	public void saveP_Individual(int index, V_Individual indiv) {
		P_individuals[index] = indiv;
	}

	public void saveU_Individual(int index, U_Individual indiv) {
		U_individuals[index] = indiv;
	}
	
	public void savePlbest_Individual(int index, Plbest_Individual indiv) {
		Plbest_individuals[index] = indiv;
	}
	public void saveG_Individual(  G_Individual indiv) {
		G_individuals[0] = indiv;
	}
}
