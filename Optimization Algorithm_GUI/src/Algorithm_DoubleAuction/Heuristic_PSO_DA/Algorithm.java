package Algorithm_DoubleAuction.Heuristic_PSO_DA;

import java.io.IOException;

public class Algorithm extends Heuristic_PSO_DA {

	// Evolve a population 演變人口
	public static Population evolvePopulation(Population pop)
			throws IOException {
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
					for (int d = 0; d < invid.Xsize(); d++)
						Pinvid.setPx(d, invid.getX(d));
					for (int d = 0; d < invid.Ysize(); d++)
						Pinvid.setPy(d, invid.getY(d));
				}
			} else {
				System.out.print("第" + i + "個 ");
				System.out.print(" X=");
				for (int d = 0; d < invid.Xsize(); d++)
					System.out.print(invid.getX(d));
				System.out.print(" Y=");
				for (int d = 0; d < invid.Ysize(); d++)
					System.out.print(invid.getY(d));
				System.out.print(" Px=");
				for (int d = 0; d < Pinvid.Pxsize(); d++)
					System.out.print(Pinvid.getPx(d));
				System.out.print(" Py=");
				for (int d = 0; d < Pinvid.Pysize(); d++)
					System.out.print(Pinvid.getPy(d));

				if (invid.getFitness() > Pinvid.getFitness()) {
					System.out.println(" F(X,Y)=" + invid.getFitness()
							+ " F(Px,Py)=" + Pinvid.getFitness()
							+ "F(X,Y)>F(Px,Py) Px=X,Py=Y");
					for (int d = 0; d < invid.Xsize(); d++)
						Pinvid.setPx(d, invid.getX(d));
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
					for (int d = 0; d < Ginvid.Gxsize(); d++)
						Ginvid.setGx(d, Pinvid1.getPx(d));
					for (int d = 0; d < Ginvid.Gysize(); d++)
						Ginvid.setGy(d, Pinvid1.getPy(d));
				}
			} else {
				System.out.print("第" + j + "個 ");
				System.out.print(" Px=");
				for (int d = 0; d < Pinvid1.Pxsize(); d++)
					System.out.print(Pinvid1.getPx(d));
				System.out.print(" Py=");
				for (int d = 0; d < Pinvid1.Pysize(); d++)
					System.out.print(Pinvid1.getPy(d));
				System.out.print(" Gx=");
				for (int d = 0; d < Ginvid.Gxsize(); d++)
					System.out.print(Ginvid.getGx(d));
				System.out.print(" Gy=");
				for (int d = 0; d < Ginvid.Gysize(); d++)
					System.out.print(Ginvid.getGy(d));
				if (Pinvid1.getFitness() > Ginvid.getFitness1()) {
					System.out.println(" F(Px,Py)=" + Pinvid1.getFitness()
							+ " F(Gx,Gy)=" + Ginvid.getFitness1()
							+ "F(Px,Py)>F(Gx,Gy) Gx=Px,Gy=Py");
					for (int d = 0; d < Ginvid.Gxsize(); d++)
						Ginvid.setGx(d, Pinvid1.getPx(d));
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
		 
			if (Print_Mode == 1)
				System.out.println("第" + i + "個");
			
			Individual invid = pop.getIndividual(i);
			int j = PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode,
					invid.Ysize());// 隨機產生一個範圍
			Individual invid1 = pop.getIndividual(j);
		 
			for(int d=0;d<invid.Xsize();d++)
				invid.setX(d, invid.getX(d) | invid1.getX(d));
		 
			for(int d=0;d<invid.Ysize();d++)
				invid.setY(d, invid.getY(d) | invid1.getY(d));
		 
			newPopulation.saveIndividual(i, invid);

		}

		return newPopulation;
	}

}
