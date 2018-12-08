package Algorithm_Carpool.PSO_LS;

import java.util.ArrayList;
import java.util.List;

public class Algorithm extends PSO_LS {

	// Evolve a population 演變人口
	public static Population evolvePopulation(Population pop) {
		Population newPopulation = new Population(pop.size(), false);
		if (Print_Mode == 1) {
			System.out.println("比較F(Astring,Bstring)  F(PAstring,PBstring)");
		}
		E_Individual Einvid = pop.getE_Individual();
		newPopulation.saveE_Individual(Einvid);

		for (int i = 0; i < pop.size(); i++) {

			Individual invid = pop.getIndividual(i);
			P_Individual Pinvid = pop.getP_Individual(i);
			if (Print_Mode == 1)  {
				System.out.print("第" + i + "個 ");
				System.out.print(" Astring=");
				for (int d = 0; d < invid.Asize(); d++)
					System.out.print(invid.getA(d));
				System.out.print(" Bstring=");
				for (int d = 0; d < invid.Bsize(); d++)
					System.out.print(invid.getB(d));
				System.out.print(" PAstring=");
				for (int d = 0; d < Pinvid.PAsize(); d++)
					System.out.print(Pinvid.getPA(d));
				System.out.print(" PBstring=");
				for (int d = 0; d < Pinvid.PBsize(); d++)
					System.out.print(Pinvid.getPB(d));
			}
			if (invid.getFitness() > Pinvid.getFitness()) {
				if (Print_Mode == 1)
					System.out.println(" F(Astring,Bstring)=" + invid.getFitness()	+ " F(PAstring,PBstring)=" + Pinvid.getFitness()	+ "F(Astring,Bstring)>F(PAstring,PBstring) PAstring=Astring,PBstring=Bstring");
				for (int d = 0; d < invid.Asize(); d++)
					Pinvid.setPA(d, invid.getA(d));
				for (int d = 0; d < invid.Bsize(); d++)
					Pinvid.setPB(d, invid.getB(d));
				} else {
					if (Print_Mode == 1)
						System.out.println(" F(Astring,Bstring)=" + invid.getFitness()	+ " F(PAstring,PBstring)=" + Pinvid.getFitness()	+ " F(Astring,Bstring) <= F(PAstring,PBstring) PAstring,PBstring不變");
				}
			
			if(Local_search_Mode== 1){
				
				Pinvid=Local_Serch.Two_Opt(pop, newPopulation, i);
					newPopulation.saveP_Individual(i, Pinvid);
				Pinvid=Local_Serch.Exchange(pop, newPopulation, i);
					newPopulation.saveP_Individual(i, Pinvid);
				Pinvid=Local_Serch.Reverse(pop, newPopulation, i);
					newPopulation.saveP_Individual(i, Pinvid);
			}
			
			newPopulation.saveP_Individual(i, Pinvid);
		}
		
		if (Print_Mode == 1)
			System.out.println("比較F(PAstring,PBstring) F(GAstring,GBstring)");
		for (int j = 0; j < pop.size(); j++) {
			G_Individual Ginvid = pop.getG_Individual();
			P_Individual Pinvid1 = pop.getP_Individual(j);
			if (Print_Mode == 1) {
				System.out.print("第" + j + "個 ");
				System.out.print(" PAstring=");
				for (int d = 0; d < Pinvid1.PAsize(); d++)
					System.out.print(Pinvid1.getPA(d));
				System.out.print(" PBstring=");
				for (int d = 0; d < Pinvid1.PBsize(); d++)
					System.out.print(Pinvid1.getPB(d));
				System.out.print(" GAstring=");
				for (int d = 0; d < Ginvid.GAsize(); d++)
					System.out.print(Ginvid.getGA(d));
				System.out.print(" GBstring=");
				for (int d = 0; d < Ginvid.GBsize(); d++)
					System.out.print(Ginvid.getGB(d));
			}
				if (Pinvid1.getFitness() > Ginvid.getFitness1()) {
					if (Print_Mode == 1)
					System.out.println(" F(PAstring,PBstring)=" + Pinvid1.getFitness()+ " F(GAstring,GBstring)=" + Ginvid.getFitness1()+ "F(PAstring,PBstring)>F(GAstring,GBstring) GAstring=PAstring,GBstring=PBstring");
					for (int d = 0; d < Ginvid.GAsize(); d++)
						Ginvid.setGA(d, Pinvid1.getPA(d));
					for (int d = 0; d < Ginvid.GBsize(); d++)
						Ginvid.setGB(d, Pinvid1.getPB(d));
				} else {
					if (Print_Mode == 1)
					System.out.println(" F(PAstring,PBstring)=" + Pinvid1.getFitness()+ " F(GAstring,GBstring)=" + Ginvid.getFitness1()	+ " F(PAstring,PBstring) <= F(GAstring,GAstring) GAstring,GBstring不變");
				}

			newPopulation.saveG_Individual(Ginvid);
		}

		if (Print_Mode == 1){
			System.out.println("變更粒子");
			System.out.println("變更Astring");
		}
		for (int i = 0; i < pop.size(); i++) {
			for (int j = 0; j < pop.size(); j++) {
				Individual invid = pop.getIndividual(i);
				Individual invid1 = pop.getIndividual(j);
				if (i != j) {
					 
					int rs = PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode); //隨機產生一個範圍
					int rs2 = PSO_Read_Write_txt	.random_generate_or_read1(Execution_Mode);
					if (Print_Mode == 1){
						System.out.print("第"+i+"個Astring=");
						for(int k=0;k<invid.Asize();k++)
							System.out.print(invid.getA(k));
						System.out.print(" 第"+j+"個Astring=");
						for(int k=0;k<invid1.Asize();k++)
							System.out.print(invid1.getA(k));
					}
					if (rs > rs2) {										//根據這個範圍 兩個A String互相交換
						if (Print_Mode == 1){
							System.out.print(" 從"+rs2+"到"+rs+"之間互換");
						}
						for (int d = rs2; d < rs; d++) 
							invid.setA(d, invid1.getA(d));
					}else{
						if (Print_Mode == 1){
							System.out.print(" 從"+rs+"到"+rs2+"之間互換");
						}
						for (int d = rs; d < rs2; d++) 
							invid.setA(d, invid1.getA(d));
					}
					if (Print_Mode == 1){
						System.out.print("   變更後的Astring=");
						for(int k=0;k<invid.Asize();k++)
							System.out.print(invid.getA(k));
						System.out.println();
					}
				newPopulation.saveIndividual(i, invid);
				}
			}
		}
		if (Print_Mode == 1)
			System.out.println(" 變更Bstring");
		for (int i = 0; i < pop.size(); i++) {
			Individual invid = pop.getIndividual(i);
			int[] A=new int[P];
			if (Print_Mode == 1)
				System.out.print(" 第"+i+"個Astring=");
			for(int j=0;j<A.length;j++){
				if (Print_Mode == 1)
					System.out.print(invid.getA(j));
				A[j]=invid.getA(j);
			}
				
			Local_Serch.NNH(A);
			
			for (int j = 0; j < Bstring.size();j++) 
					invid.setB(j, Bstring.get(j));
			if (Print_Mode == 1){
				System.out.print(" Local Serch後的Bstring=");
				for (int j = 0; j < Bstring.size();j++) 
					System.out.print(invid.getB(j));
				System.out.println();
			}
				
			newPopulation.saveIndividual(i, invid);
		}
		return newPopulation;
	}

}
