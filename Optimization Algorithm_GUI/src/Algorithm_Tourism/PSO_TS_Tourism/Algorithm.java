package Algorithm_Tourism.PSO_TS_Tourism;

  
public class Algorithm extends PSO_TS_Tourism {

	// Evolve a population 演變人口
	public static Population evolvePopulation(Population pop)   {
		Population newPopulation = new Population(pop.size(), false);
		if (Print_Mode == 1) {
			System.out.println("比較F(X,Y)  F(Px,Py)");
		}
		E_Individual Einvid = pop.getE_Individual();
		// System.err.println(Einvid.Exsize());
		newPopulation.saveE_Individual(Einvid);

		for (int i = 0; i < pop.size(); i++) {

			Individual invid = pop.getIndividual(i);
			P_Individual Pinvid = pop.getP_Individual(i);
			if (Print_Mode == 0) {
				if (invid.getFitness() > Pinvid.getFitness()) {
					for (int d = 0; d < invid.Xasize(); d++)
						Pinvid.setPxa(d, invid.getXa(d));
					for (int d = 0; d < invid.Xhsize(); d++)
						Pinvid.setPxh(d, invid.getXh(d));
					for (int d = 0; d < invid.Xtsize(); d++)
						Pinvid.setPxt(d, invid.getXt(d));
					for (int d = 0; d < invid.Ysize(); d++)
						Pinvid.setPy(d, invid.getY(d));
				}
			} else {
				System.out.print("第" + i + "個 ");
				System.out.print(" X=");
				for (int d = 0; d < invid.Xasize(); d++)
					System.out.print(invid.getXa(d));
				System.out.print(" Y=");
				for (int d = 0; d < invid.Ysize(); d++)
					System.out.print(invid.getY(d));
				System.out.print(" Px=");
				for (int d = 0; d < Pinvid.Pxasize(); d++)
					System.out.print(Pinvid.getPxa(d));
				System.out.print(" Py=");
				for (int d = 0; d < Pinvid.Pysize(); d++)
					System.out.print(Pinvid.getPy(d));

				if (invid.getFitness() > Pinvid.getFitness()) {
					System.out.println(" F(X,Y)=" + invid.getFitness()
							+ " F(Px,Py)=" + Pinvid.getFitness()
							+ "F(X,Y)>F(Px,Py) Px=X,Py=Y");
					for (int d = 0; d < invid.Xasize(); d++)
						Pinvid.setPxa(d, invid.getXa(d));
					for (int d = 0; d < invid.Xhsize(); d++)
						Pinvid.setPxh(d, invid.getXh(d));
					for (int d = 0; d < invid.Xtsize(); d++)
						Pinvid.setPxt(d, invid.getXt(d));
					for (int d = 0; d < invid.Ysize(); d++)
						Pinvid.setPy(d, invid.getY(d));

				} else {
					System.out.println(" F(X,Y)=" + invid.getFitness()
							+ " F(Px,Py)=" + Pinvid.getFitness()
							+ " F(X,Y) <= F(Px,Py) Px,Py不變");
				}
			}
			newPopulation.saveP_Individual(i, Pinvid);
		}
		if (Print_Mode == 1)
			System.out.println("比較F(Px,Py) F(Gx,Gy)");
		for (int j = 0; j < pop.size(); j++) {
			G_Individual Ginvid = pop.getG_Individual();
			P_Individual Pinvid1 = pop.getP_Individual(j);
			if (Print_Mode == 0) {
				if (Pinvid1.getFitness() > Ginvid.getFitness1()) {
					for (int d = 0; d < Ginvid.Gxasize(); d++)
						Ginvid.setGxa(d, Pinvid1.getPxa(d));
					for (int d = 0; d < Ginvid.Gxhsize(); d++)
						Ginvid.setGxh(d, Pinvid1.getPxh(d));
					for (int d = 0; d < Ginvid.Gxtsize(); d++)
						Ginvid.setGxt(d, Pinvid1.getPxt(d));
					for (int d = 0; d < Ginvid.Gysize(); d++)
						Ginvid.setGy(d, Pinvid1.getPy(d));
				}
			} else {
				System.out.print("第" + j + "個 ");
				System.out.print(" Px=");
				for (int d = 0; d < Pinvid1.Pxasize(); d++)
					System.out.print(Pinvid1.getPxa(d));
				System.out.print(" Py=");
				for (int d = 0; d < Pinvid1.Pysize(); d++)
					System.out.print(Pinvid1.getPy(d));
				System.out.print(" Gx=");
				for (int d = 0; d < Ginvid.Gxasize(); d++)
					System.out.print(Ginvid.getGxa(d));
				System.out.print(" Gy=");
				for (int d = 0; d < Ginvid.Gysize(); d++)
					System.out.print(Ginvid.getGy(d));
				if (Pinvid1.getFitness() > Ginvid.getFitness1()) {
					System.out.println(" F(Px,Py)=" + Pinvid1.getFitness()
							+ " F(Gx,Gy)=" + Ginvid.getFitness1()
							+ "F(Px,Py)>F(Gx,Gy) Gx=Px,Gy=Py");
					for (int d = 0; d < Ginvid.Gxasize(); d++)
						Ginvid.setGxa(d, Pinvid1.getPxa(d));
					for (int d = 0; d < Ginvid.Gxhsize(); d++)
						Ginvid.setGxh(d, Pinvid1.getPxh(d));
					for (int d = 0; d < Ginvid.Gxtsize(); d++)
						Ginvid.setGxt(d, Pinvid1.getPxt(d));
					for (int d = 0; d < Ginvid.Gysize(); d++)
						Ginvid.setGy(d, Pinvid1.getPy(d));
				} else {
					System.out.println(" F(Px,Py)=" + Pinvid1.getFitness()
							+ " F(Gx,Gy)=" + Ginvid.getFitness1()
							+ " F(Px,Py) <= F(Gx,Gy) Gx,Gy不變");
				}
			}
			newPopulation.saveG_Individual(Ginvid);
		}
		if (Print_Mode == 1)
			System.out.println("變更粒子");
		for (int i = 0; i < pop.size(); i++) {
			for (int j = 0; j < pop.size(); j++) {
				if (i != j) {
					Individual invid = pop.getIndividual(i);
					Individual invid1 = pop.getIndividual(j);
					if (Print_Mode == 1)
						System.out.println("第" + i + "個");
					 
						int rs1 = PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode, invid.Xasize());//隨機產生一個範圍
						int rs2 = PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode, invid.Xasize());
						if (rs1 > rs2) {												//根據此範圍兩個粒子進行相互交換
							for (int d = rs2; d < rs1; d++) 
								invid.setXa(d, invid1.getXa(d));
						}else{
							for (int d = rs1; d < rs2; d++) 
								invid.setXa(d, invid1.getXa(d));
						}
						 rs1 = PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode, invid.Xhsize());//隨機產生一個範圍
						 rs2 = PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode, invid.Xhsize());
						if (rs1 > rs2) {												//根據此範圍兩個粒子進行相互交換
							for (int d = rs2; d < rs1; d++) 
								invid.setXh(d, invid1.getXh(d));
						}else{
							for (int d = rs1; d < rs2; d++) 
								invid.setXh(d, invid1.getXh(d));
						}
						
						 rs1 = PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode, invid.Xtsize());//隨機產生一個範圍
						 rs2 = PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode, invid.Xtsize());
						if (rs1 > rs2) {												//根據此範圍兩個粒子進行相互交換
							for (int d = rs2; d < rs1; d++) 
								invid.setXt(d, invid1.getXt(d));
						}else{
							for (int d = rs1; d < rs2; d++) 
								invid.setXt(d, invid1.getXt(d));
						}
						int rs3 = PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode, invid.Ysize());
						int rs4 = PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode, invid.Ysize());
						if (rs3 > rs4) {
							for (int d = rs4; d < rs3; d++) 
								invid.setY(d, invid1.getY(d));
						}else{
							for (int d = rs3; d < rs4; d++) 
								invid.setY(d, invid1.getY(d));
						}
						 
						newPopulation.saveIndividual(i, invid);
					}
				}
			}
 
		return newPopulation;
	}

}
