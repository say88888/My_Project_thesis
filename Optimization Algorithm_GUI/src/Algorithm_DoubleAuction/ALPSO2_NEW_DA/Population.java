package Algorithm_DoubleAuction.ALPSO2_NEW_DA;
 
public class Population extends ALPSO2_NEW {
	Individual[] individuals;
	P_Individual[] P_individuals;
	G_Individual[] G_individuals;
	V_Individual[] V_individuals;
	GV_Individual[] GV_individuals;
	Candidate_Individual[] Candidate_Individual;
	CandidateV_Individual[] CandidateV_Individual;
	/*
	 * Constructors 構造函數
	 */
	// Create a population 創建一個人口
	public Population(int populationSize, boolean initialise) {
		individuals = new Individual[populationSize];
		P_individuals = new P_Individual[populationSize];
		G_individuals = new G_Individual[1];
		V_individuals = new V_Individual[populationSize];
		GV_individuals = new GV_Individual[1];
		Candidate_Individual= new Candidate_Individual[populationSize];
		CandidateV_Individual = new CandidateV_Individual[populationSize];
		// Initialise population 人口初始化
		if (initialise) {
			G_Individual newGIndividual = new G_Individual();
			newGIndividual.XglobalIndividual();
			newGIndividual.YglobalIndividual();
			saveG_Individual(  newGIndividual);
			
			GV_Individual newGVIndividual = new GV_Individual();
			newGVIndividual.XvelocityIndividual();
			newGVIndividual.XvelocityIndividual();
			saveGV_Individual(newGVIndividual);
			
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
				
				
				Candidate_Individual newCandidate_Individual = new Candidate_Individual();
				newCandidate_Individual.XgenerateIndividual();
				newCandidate_Individual.YgenerateIndividual();
				saveCandidate_Individual(i, newCandidate_Individual);
				
				CandidateV_Individual newCandidateV_Individual = new CandidateV_Individual();
				newCandidateV_Individual.XvelocityIndividual();
				newCandidateV_Individual.YvelocityIndividual();
				saveCandidateV_Individual(i, newCandidateV_Individual);
				
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

	public V_Individual getV_Individual(int index) {
		return V_individuals[index];
	}
	
	public GV_Individual getGV_Individual() {
		return GV_individuals[0];
	}
	
	public Candidate_Individual getCandidate_Individual(int index) {
		return Candidate_Individual[index];
	}
	public CandidateV_Individual getCandidateV_Individual(int index) {
		return CandidateV_Individual[index];
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

	public void saveV_Individual(int index, V_Individual indiv) {
		V_individuals[index] = indiv;
	}
	
	public void saveGV_Individual(  GV_Individual indiv) {
		GV_individuals[0] = indiv;
	}
	
	public void saveCandidate_Individual(int index, Candidate_Individual indiv) {
		Candidate_Individual[index] = indiv;
	}
	
	public void saveCandidateV_Individual(int index, CandidateV_Individual indiv) {
		CandidateV_Individual[index] = indiv;
	}
}
