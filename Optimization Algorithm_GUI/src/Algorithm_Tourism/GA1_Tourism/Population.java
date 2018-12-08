package Algorithm_Tourism.GA1_Tourism;

 
public class Population extends GA1_Tourism {
	Individual[] individuals;

	/*
	 * Constructors 構造函數
	 */
	// Create a population 創建一個人口
	public Population(int populationSize, boolean initialise) {
		individuals = new Individual[populationSize];
		// Initialise population 人口初始化
		if (initialise) {
			// Loop and create individuals 循環並個體創建
			for (int i = 0; i < size(); i++) {
				Individual newIndividual = new Individual();

				newIndividual.XgenerateIndividual();
				newIndividual.YgenerateIndividual();
				saveIndividual(i, newIndividual);
			}
			// GA.sb.append("\r\n");
		}
	}

	 

	/* Getters */
	public Individual getIndividual(int index) {
		return individuals[index];
	}

	/*
	 * public void print(){ System.out.println("----------------"); for (int i =
	 * 0; i < populationSize; i++) {
	 * 
	 * String[] xy=getIndividual(i).toString().split(",");
	 * System.out.println(i+" Y="+xy[0]); System.out.println("  X="+xy[1]);
	 * System.out.println("  fitness="+getIndividual(i).getFitness());
	 * 
	 * } System.out.println(); }
	 */
	 
	
	public Individual getFittest1()   {
		Individual fittest1 = individuals[0];
		// Loop through individuals to find fittest 通過個體循環找到優勝劣汰
		for (int i = 0; i < size(); i++) {
			if (fittest1.getFitness1() <= getIndividual(i).getFitness1()) {
				fittest1 = getIndividual(i);
			}
		}
		return fittest1;
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
}
