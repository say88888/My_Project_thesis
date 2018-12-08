package Algorithm_DoubleAuction.DE_Real_DA_Problem3;

public class Algorithm extends Double_Auction_DE_Real_Problem3 {

	// Evolve a population 演變人口
	public static Population evolvePopulation(Population pop) {
		Population newPopulation = new Population(pop.size(), false);

		// 選擇策略
		int strategy = Function.select_strategy();

		// 計算F、CR
		// Function.Algorithm3();

		// 突變V
		for (int i = 0; i < pop.size(); i++) {
			int r1 = 0, r2 = 0, r3 = 0, r4 = 0, r5 = 0;
			while (r1 == i || r2 == i || r3 == i || r4 == i || r5 == i || r1 == r2
					|| r1 == r3 || r1 == r4 || r1 == r5 || r2 == r3 || r2 == r4 || r2 == r5 || r3 == r4
					|| r3 == r5 || r1 == b || r2 == b || r3 == b || r4 == b || r5 == b) {// 取r1,r2,r3,r4
				r1 = DE_Read_Write_txt.random_generate_or_read2(Execution_Mode, populationSize);
				r2 = DE_Read_Write_txt.random_generate_or_read2(Execution_Mode, populationSize);
				r3 = DE_Read_Write_txt.random_generate_or_read2(Execution_Mode, populationSize);
				r4 = DE_Read_Write_txt.random_generate_or_read2(Execution_Mode, populationSize);
				r5 = DE_Read_Write_txt.random_generate_or_read2(Execution_Mode, populationSize);
			}

			Individual invid = pop.getIndividual(i);
			Individual invid1 = pop.getIndividual(r1);
			Individual invid2 = pop.getIndividual(r2);
			Individual invid3 = pop.getIndividual(r3);
			Individual invid4 = pop.getIndividual(r4);
			Individual invid5 = pop.getIndividual(r5);
			Individual invidb = pop.getIndividual(b);
			
			V_Individual newPinvid = new V_Individual();
			
			V_Individual newPinvid1 = new V_Individual();
			V_Individual newPinvid2 = new V_Individual();
			V_Individual newPinvid3 = new V_Individual();
			V_Individual newPinvid4 = new V_Individual();
			V_Individual newPinvid5 = new V_Individual();
			V_Individual newPinvid6 = new V_Individual();
			
		
				newPinvid1 = Function.Algorithm1_1(invid1, invid2, invid3);
				newPinvid2 = Function.Algorithm1_2(invidb, invid1, invid2);
				newPinvid3 = Function.Algorithm1_3( invid1, invid2, invid3, invid4, invid5);
				newPinvid4 = Function.Algorithm1_4(invidb, invid1, invid2, invid3, invid4);
				newPinvid5 = Function.Algorithm1_5(invid, invid1, invid2, invid3);
				newPinvid6 = Function.Algorithm1_6(invid, invidb, invid1, invid2, invid3);

				double max=newPinvid1.getFitness();
				newPinvid=newPinvid1;
				if(newPinvid2.getFitness()>max){
					newPinvid=newPinvid2;
					max=newPinvid2.getFitness();
				}
				if(newPinvid3.getFitness()>max){
					newPinvid=newPinvid3;
					max=newPinvid3.getFitness();
				}
				if(newPinvid4.getFitness()>max){
					newPinvid=newPinvid4;
					max=newPinvid4.getFitness();
				}
				if(newPinvid5.getFitness()>max){
					newPinvid=newPinvid5;
					max=newPinvid5.getFitness();
				}
				if(newPinvid6.getFitness()>max){
					newPinvid=newPinvid6;
					max=newPinvid6.getFitness();
				}
				
			// 交叉U
			U_Individual newGinvid = new U_Individual();
			newGinvid = Function.Algorithm2(i, strategy, invid, newPinvid);
			newPopulation.saveU_Individual(i, newGinvid);

		}

		// 貪婪選擇
		for (int i = 0; i < pop.size(); i++) {
			U_Individual Ginvid = pop.getU_Individual(i);
			Individual invid = pop.getIndividual(i);
			
			for (int d = 0; d < invid.Xsize(); d++) {
				double rsid = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
				if (rsid < 1 / (1 + Math.exp(-lamda * invid.getX(d)))) {
					invid.setbinaryX(d, 1);
				}
				else {
					invid.setbinaryX(d, 0);
				}
			}
			for (int d = 0; d < invid.Ysize(); d++) {
				double rsid = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
				if (rsid < 1 / (1 + Math.exp(-lamda * invid.getY(d)))) {
					invid.setbinaryY(d, 1);
				}
				else {
					invid.setbinaryY(d, 0);
				}
			}
			
			for (int d = 0; d < Ginvid.Uxsize(); d++) {
				double rsid = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
				if (rsid < 1 / (1 + Math.exp(-lamda * Ginvid.getUx(d)))) {
					Ginvid.setbinaryUx(d, 1);
				}
				else {
					Ginvid.setbinaryUx(d, 0);
				}
			}
			for (int d = 0; d < Ginvid.Uysize(); d++) {
				double rsid = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
				if (rsid < 1 / (1 + Math.exp(-lamda * Ginvid.getUy(d)))) {
					Ginvid.setbinaryUy(d, 1);
				}
				else {
					Ginvid.setbinaryUy(d, 0);
				}
			}

			if (Ginvid.getFitness1() > invid.getFitness1()) {
				for (int d = 0; d < invid.Xsize(); d++) {
					invid.setX(d, Ginvid.getUx(d));
					invid.setbinaryX(d, Ginvid.getbinaryUx(d));
				}

				for (int d = 0; d < invid.Ysize(); d++) {
					invid.setY(d, Ginvid.getUy(d));
					invid.setbinaryY(d, Ginvid.getbinaryUy(d));
				}
			}newPopulation.saveIndividual(i, invid);
		}
		return newPopulation;
	}
}
