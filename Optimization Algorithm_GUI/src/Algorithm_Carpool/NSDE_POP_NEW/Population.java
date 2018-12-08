package Algorithm_Carpool.NSDE_POP_NEW;

public class Population extends NSDE_POP_NEW {
	Individual[] individuals;
	V_Individual[] P_individuals;
	U_Individual[] U_individuals;

	/*
	 * Constructors 構造函數
	 */
	// Create a population 創建一個人口
	public Population(int populationSize, boolean initialise) {
		individuals = new Individual[populationSize];
		P_individuals = new V_Individual[populationSize];
		U_individuals = new U_Individual[populationSize];
		// Initialise population 人口初始化
		if (PmaxNumbertimes == 0 && initialise ) {
			
			// Initialise population 人口初始化
		
				// Loop and create individuals 循環並個體創建
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

	public void Update_Population(boolean right) {
		
		
		if (PmaxNumbertimes != 0  ) {
		
			// Initialise population 人口初始化
				
				// Loop and create individuals 循環並個體創建
				for (int i = 0; i < size(); i++) {
					
					Individual newIndividual = getIndividual(i);
					Individual newIndividual2 = getIndividual(i+size());
					
					if(newIndividual2.getFitness1()>newIndividual.getFitness1())
						saveIndividual(i, newIndividual2);
					
				}
				
				if(right){
					
					int n=(int) (size()*Pi);
					for(int i=n;i<size();i++){
						Individual newIndiv = new Individual();
						newIndiv.XgenerateIndividual();
						newIndiv.YgenerateIndividual();
						saveIndividual(i, newIndiv);
												
					}
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

	public U_Individual getU_Individual(int index) {
		return U_individuals[index];
	}

	public Individual getFittest() {
		Individual fittest1 = individuals[0];
		// Loop through individuals to find fittest 通過個體循環找到優勝劣汰
		for (int i = 0; i < size(); i++) {
		
			if(getIndividual(i).getFitness1()>Global_fittest){
				fittest1 = getIndividual(i);
				b=i;
				Global_fittest=getIndividual(i).getFitness1();
				Fittest_Iter=generationCount;
				for(int d=0;d<getIndividual(i).Xsize();d++)
					GX[d]=getIndividual(i).getbinaryX(d);
				for(int d=0;d<getIndividual(i).Ysize();d++)
					GY[d]=getIndividual(i).getbinaryY(d);
			}
		/*	if (Global_fittest< fittest) {
				fittest1 = getIndividual(i);
				b=i;
				Global_fittest=fittest;
			}*/
		}
		return fittest1;
		 
	 
	}

	/* Public methods 公共方法 */
	// Get population size 獲取種群大小
	public int size() {
		return Ppopsize.get(PmaxNumbertimes);
	//	return individuals.length;
	}

	// Save individual 保存個體
	public void saveIndividual(int index, Individual indiv) {
		individuals[index] = indiv;
	}

	public void saveP_Individual(int index, V_Individual indiv) {
		P_individuals[index] = indiv;
	}

	public void saveU_Individual(int index,U_Individual indiv) {
		U_individuals[index] = indiv;
	}

}
