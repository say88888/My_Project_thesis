package Algorithm_DoubleAuction.DE_DA_Porblem3;

import Input_Output_txt.Double_Auction.Read_Seller_Price_Parameter;
 
public class Population extends Double_Auction_DE_Problem3 {
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
		if (initialise) {

			// Loop and create individuals 循環並個體創建
			for (int i = 0; i < size(); i++) {
				Individual newIndividual = new Individual();
				newIndividual.XgenerateIndividual();
				newIndividual.YgenerateIndividual();
				saveIndividual(i, newIndividual);
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
			if (fittest1.getFitness1() < getIndividual(i).getFitness1()) {
				fittest1 = getIndividual(i);
				
				b=i;
			}
		}
		if(knumber>=ka){
		//	System.err.println("----------------1--------------");
			for(int i=0;i<dv.length;i++)
				dv[i]=DE_Read_Write_txt.random_generate_or_read2(Execution_Mode, 3)-1;
			for(int i=0;i<Xsize;i++){
				GmX[i]=fittest1.getX(i)+dv[i];
				if(GmX[i]>Read_Seller_Price_Parameter.top())
					GmX[i]=Read_Seller_Price_Parameter.top();
				if(GmX[i]<0)
					GmX[i]=0;
			}
			for(int i=0;i<Ysize;i++)
				GmY[i]=fittest1.getY(i);
		//	System.out.println("F= "+FitnessCalc.getFitnes(GmX, GmY));
			if(FitnessCalc.getFitnes(GmX, GmY)>fittest1.getFitness1()){
			//		System.err.println("----------------2--------------");
					for(int i=0;i<Xsize;i++)
						fittest1.setX(i, GmX[i]);
					for(int i=0;i<Ysize;i++)
						fittest1.setY(i, GmY[i]);
				
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

	public void saveP_Individual(int index, V_Individual indiv) {
		P_individuals[index] = indiv;
	}

	public void saveU_Individual(int index,U_Individual indiv) {
		U_individuals[index] = indiv;
	}

}
