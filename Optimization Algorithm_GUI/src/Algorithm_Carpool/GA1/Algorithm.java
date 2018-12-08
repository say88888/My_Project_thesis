package Algorithm_Carpool.GA1;

 
public class Algorithm extends GA1{
	  /* GA parameters */
//  private static final double uniformRate = 0.5;
  //private static final double mutationRate = 0.015;
  //private static final int tournamentSize = 5;
  private static final boolean elitism = false;
  static StringBuilder sb1 = new StringBuilder();
 
	
  /* Public methods */
  
  // Evolve a population 演變人口
  public static Population evolvePopulation(Population pop) {
      Population newPopulation = new Population(pop.size(), false);

      // Keep our best individual 留住我們最好的個體
      if (elitism) {
          newPopulation.saveIndividual(0, pop.getFittest1());
      }

      // Crossover population 交叉人口
      int elitismOffset;
      if (elitism) {
          elitismOffset = 1;
      } else {
          elitismOffset = 0;
      }
      // Loop over the population size and create new individuals with 循環以上的人口規模和創造新的個體
      // crossover 交叉
      for (int i = elitismOffset; i < pop.size(); i++) {
    	  if(Print_Mode==0){
    		   Individual indiv1 = tournamentSelection(pop);
    		   Individual indiv2 = tournamentSelection(pop);
    		   Individual newIndiv = crossover(indiv1, indiv2);
    		   newPopulation.saveIndividual(i, newIndiv);
    	  }
    	  else{
    	sb2.append("\n"+"\\----tournamentSelection----//"+"\n"+"I="+i+"\n");
    	System.out.println();
    	System.out.println("\\----tournamentSelection----//");
    	System.out.println("I="+i);
          Individual indiv1 = tournamentSelection(pop);
          sb2.append("indiv1="+indiv1 +" \n");
          System.out.println(" indiv1="+indiv1);
          Individual indiv2 = tournamentSelection(pop);
          sb2.append("\nindiv2="+indiv2 +"\n");
          System.out.println(" indiv2="+indiv2);
          sb2.append("\\----Crossover----//");
          System.out.println("\\----Crossover----//");
          Individual newIndiv = crossover(indiv1, indiv2);
          newPopulation.saveIndividual(i, newIndiv);
          sb2.append("\nnewPopulation="+ newPopulation.getIndividual(i));
          System.out.println("newPopulation="+ newPopulation.getIndividual(i));
    	  }
      }

      // Mutate population 人口發生突變
      for (int i = elitismOffset; i < newPopulation.size(); i++) {
    	  if(Print_Mode==0)
          mutate(newPopulation.getIndividual(i));
    	  else{
    		  System.out.println("\\----Mutate population----//");
    		  System.out.println("I="+i);
    		  sb2.append("\r\n\\----Mutate population----//"+"\n"+"I="+i);
    		  mutate(newPopulation.getIndividual(i));
  	          sb2.append("\n"+newPopulation.getIndividual(i)+" " );
  	          System.out.println(newPopulation.getIndividual(i));
  	        //System.out.println(newPopulation.getFittest2().getFitness2());
    	  }
      }
      
      return newPopulation;
  }

  // Crossover individuals 交叉個體
  private static Individual crossover(Individual indiv1, Individual indiv2) {
      Individual newSol = new Individual();
      // Loop through genes 通過基因循環
      if(Print_Mode==0){
      for (int i = 0; i < indiv1.Ysize(); i++) {
          // Crossover
          if (random_generate_or_read1(Execution_Mode) <= crossoverRate) {
              newSol.setY(i, indiv1.getY(i));
          } else {
              newSol.setY(i, indiv2.getY(i));
          }
      }
      for (int i = 0; i < indiv1.Xsize(); i++) {
          // Crossover
          if (random_generate_or_read1(Execution_Mode)<= crossoverRate) {
              newSol.setX(i, indiv1.getX(i));
          } else {
              newSol.setX(i, indiv2.getX(i));
          }
      }
      }
      else{
      for (int i = 0; i < indiv1.Ysize(); i++) {
              // Crossover
    	  double random;
    	  random=random_generate_or_read1(Execution_Mode);
    	  if (random <= crossoverRate) {
            	  sb2.append("\r\nY  Crossover Random="+random+"<="+crossoverRate);
            	  System.out.println("Y  Crossover Random="+random+"<="+crossoverRate);
                  newSol.setY(i, indiv1.getY(i));
    }
    	  else {
            	  sb2.append("\r\nY  Crossover Random="+random+">="+crossoverRate);
            	  System.out.println("Y  Crossover Random="+random+">="+crossoverRate);
                  newSol.setY(i, indiv2.getY(i));
              }
     }
    for (int i = 0; i < indiv1.Xsize(); i++) {
              // Crossover
    	 double random;
   	  random=random_generate_or_read1(Execution_Mode);
      if (random<= crossoverRate) {
    	  sb2.append("\r\nX  Crossover Random="+random+"<="+crossoverRate);
    	  System.out.println("X  Crossover Random="+random+"<="+crossoverRate);
                  newSol.setX(i, indiv1.getX(i));
              } else {
              sb2.append("\r\nX  Crossover Random="+random+">="+crossoverRate);
              System.out.println("X  Crossover Random="+random+">="+crossoverRate);
                  newSol.setX(i, indiv2.getX(i));
              }
          }
          }
      return newSol;
      
  }

  // Mutate an individual 發生突變的個體
  private static void mutate(Individual indiv) {
      // Loop through genes 通過基因循環
	  if(Print_Mode==0){
      for (int i = 0; i < indiv.Ysize(); i++) {
          if (random_generate_or_read1(Execution_Mode)/*Math.random()*/ <= mutationRate) {
              // Create random gene 創建隨機基因
              byte gene = (byte) Math.round(random_generate_or_read1(Execution_Mode)/*Math.random()*/);
              indiv.setY(i, gene);
          }
      } for (int i = 0; i < indiv.Xsize(); i++) {
          if (random_generate_or_read1(Execution_Mode)/*Math.random()*/ <= mutationRate) {
              // Create random gene 創建隨機基因
              byte gene = (byte) Math.round(random_generate_or_read1(Execution_Mode)/*Math.random()*/);
              indiv.setX(i, gene);
          }
      }
	  }
	  else
	  {	
		  for (int i = 0; i < indiv.Ysize(); i++) {
			  double random;
		   	  random=random_generate_or_read1(Execution_Mode);
		   	  sb2.append("\nY  Mutate Random=");
		   	System.out.print("Y  Mutate Random=");
	          if (random <= mutationRate) {
	              // Create random gene 創建隨機基因
	        	  byte gene = (byte) Math.round(random/*Math.random()*/);
	              sb2.append(random+" <="+ mutationRate + "  "+" Y突變為" +gene);
	              System.out.println(random+" <="+ mutationRate + "  "+" Y突變為" +gene);
	              indiv.setY(i, gene);
	          }
	          else{
	        	sb2.append(random+" >"+ mutationRate+" " +"Y不變");
	          System.out.println(random+" >"+ mutationRate+" " +"Y不變");}
		  }
		 
		  for (int i = 0; i < indiv.Xsize(); i++) { 
			  double random;
	   	  random=random_generate_or_read1(Execution_Mode);
	   	 sb2.append("\n"+"X  Mutate Random=");
	   	 System.out.print("X  Mutate Random=");
	          if (random<= mutationRate) {
	              // Create random gene 創建隨機基因
	        	  byte gene = (byte) Math.round(random/*Math.random()*/);
	              sb2.append(random+" <="+ mutationRate+" " +"X突變為"+gene);
	              System.out.println(random+" <="+ mutationRate+" " +"X突變為"+gene);
	              indiv.setX(i, gene);
	          }  else{
	          sb2.append(random+" >"+ mutationRate+" " +"X不變");
	          System.out.println(random+" >"+ mutationRate+" " +"X不變");}
	      }
	  }
  }

  // Select individuals for crossover 對於交叉個體選擇
  private static Individual tournamentSelection(Population pop) {
      // Create a tournament population 創建一個人口巡迴賽
      Population tournament = new Population(tournamentSize, false);
      // For each place in the tournament get a random individual 對於在比賽中的每個地方得到一個隨機個體
      for (int i = 0; i < tournamentSize; i++) {
    	  if(Print_Mode==0){
          int randomId = (int) (random_generate_or_read1(Execution_Mode)* pop.size());
          tournament.saveIndividual(i, pop.getIndividual(randomId));}
    	  else{
    		  double random;
    		  random=random_generate_or_read1(Execution_Mode);
    		  int randomId = (int) (random * pop.size());
    		    tournament.saveIndividual(i, pop.getIndividual(randomId));
               sb2.append( random +"\r");
               System.out.print(random +" ");
    	  }
      }
      // Get the fittest 獲取優勝劣汰
      Individual fittest = tournament.getFittest1();
      return fittest;
  }
  
  

  public static double random_generate_or_read1(int Execution_Mode) 
  {
  double xxx1; 
  if (Execution_Mode == 0)
  {
  xxx1=Math.random();
  sb1.append(xxx1 + " ");
 // GA_Read_Write_txt.write_to_evolution_log1(sb1);
	if(Write_Mode==0){
	long totalstartTime = System.currentTimeMillis();
	GA_Read_Write_txt.write_to_evolution_log1(sb1);
	long totalendTime = System.currentTimeMillis();
	time_write_to_TXT+=(totalendTime-totalstartTime);
	}
  
  return xxx1;
  }
  else
  {
  return GA_Read_Write_txt.read_from_evolution_log1();
  }
  }
}
 

