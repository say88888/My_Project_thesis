package Algorithm_DoubleAuction.DE_DA;

import java.util.Random;

public class Algorithm extends Double_Auction_DE {

	// Evolve a population 演變人口
	public static Population evolvePopulation(Population pop) {
		Population newPopulation = new Population(pop.size(), false);

	
	
		// 選擇策略
		int strategy = Function.select_strategy();
	
		//計算F、CR
		Function.Algorithm3();
	
		// 突變V
		for (int i = 0; i < pop.size(); i++) {
			int r1 = 0, r2 = 0, r3 = 0, r4 = 0, r5=0;
			while (r1 == i || r2 == i || r3 == i || r4 == i || r5 == i|| r1 == r2
					|| r1 == r3 || r1 == r4 || r1 == r5 || r2 == r3 || r2 == r4 || r2 == r5 || r3 == r4 
					|| r3 == r5 || r1 == b || r2 == b || r3 ==b || r4 == b || r5 == b) {// 取r1,r2,r3,r4
				r1 = DE_Read_Write_txt.random_generate_or_read2(Execution_Mode,populationSize);
				r2 = DE_Read_Write_txt.random_generate_or_read2(Execution_Mode,populationSize);
				r3 = DE_Read_Write_txt.random_generate_or_read2(Execution_Mode,populationSize);
				r4 = DE_Read_Write_txt.random_generate_or_read2(Execution_Mode,populationSize);
				r5 = DE_Read_Write_txt.random_generate_or_read2(Execution_Mode,populationSize);
			}
 
			Individual invid = pop.getIndividual(i);
			Individual invid1 = pop.getIndividual(r1);
			Individual invid2 = pop.getIndividual(r2);
			Individual invid3 = pop.getIndividual(r3);
			Individual invid4 = pop.getIndividual(r4);
			Individual invid5 = pop.getIndividual(r5);
			Individual invidb = pop.getIndividual(b);
			V_Individual newPinvid=new V_Individual();
			
			if(strategy==1)
				newPinvid =Function.Algorithm1_1(F[strategy-1][i], invid1, invid2, invid3);
			else if(strategy==2)
				newPinvid =Function.Algorithm1_2(F[strategy-1][i], invidb, invid2, invid3);
			else if(strategy==3)
				newPinvid =Function.Algorithm1_3(F[strategy-1][i], invid1, invid2, invid3, invid4, invid5);
			else if(strategy==4)
				newPinvid =Function.Algorithm1_4(F[strategy-1][i], invidb, invid1, invid2, invid3, invid4);
			else if(strategy==5)
				newPinvid =Function.Algorithm1_5(F[strategy-1][i], invid, invidb, invid1, invid2);
			else
				newPinvid = Function.Algorithm1_6(F[strategy-1][i], invid,invidb, invid1, invid2, invid3, invid4);
				
		
			//交叉U
			U_Individual newGinvid=new U_Individual();
			newGinvid=Function.Algorithm2(i, strategy, invid, newPinvid);
			newPopulation.saveU_Individual(i, newGinvid);
		 
		}
	
		//貪婪選擇
		for(int i=0;i<pop.size();i++){
			U_Individual Ginvid=newPopulation.getU_Individual(i);
			Individual invid = pop.getIndividual(i);
			if(Ginvid.getFitness1()>invid.getFitness1()){
				
				for(int d=0;d<invid.Xsize();d++)
					invid.setX(d, Ginvid.getUx(d));
				for(int d=0;d<invid.Ysize();d++)
					invid.setY(d, Ginvid.getUy(d));
				s[strategy-1]+=1;
				if(!successfulF.contains(F[strategy-1][i]))
					successfulF.add(F[strategy-1][i]);
				if(!successfulCR.contains(CR[strategy-1][i]))
					successfulCR.add(CR[strategy-1][i]);
			}
			newPopulation.saveIndividual(i, invid);
		}
		
		return newPopulation;
	}
}
