package Algorithm_Tourism.PSO2_Tourism;

 
public class Algorithm extends PSO2_Tourism {

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
			System.out.println("進行更改 速度跟粒子");

		for (int i = 0; i < pop.size(); i++) {
			Individual invid = pop.getIndividual(i);
			V_Individual Vinvid = pop.getV_Individual(i);
			P_Individual Pinvid = pop.getP_Individual(i);
			G_Individual Ginvid = pop.getG_Individual();
			double r1 = PSO_Read_Write_txt
					.random_generate_or_read1(Execution_Mode);
			double r2 = PSO_Read_Write_txt
					.random_generate_or_read1(Execution_Mode);
			if (Print_Mode == 1) {
				System.out.println("第" + i + "個");
				System.out.println("r1=" + r1 + "  r2=" + r2 + " w=" + w
						+ " c1=" + c1 + " c2=" + c2);
			}
			for (int d = 0; d < Vinvid.Vxasize(); d++) {
				if (Print_Mode == 1)
					System.out.print("Vxa=" + Vinvid.getVxa(d) + " ");
				Vinvid.setVxa(
						d,
						w
								* Vinvid.getVxa(d)
								+ (c1 * r1 * (Pinvid.getPxa(d) - invid.getXa(d)))
								+ c2 * r2 * (Ginvid.getGxa(d) - invid.getXa(d)));
				if (Vinvid.getVxa(d) > Vmax)
					Vinvid.setVxa(d, Vmax);
				if (Vinvid.getVxa(d) < -Vmax)
					Vinvid.setVxa(d, -Vmax);
				if (Print_Mode == 1)
					System.out.println("改為 Vxa=" + Vinvid.getVxa(d) + " ");

			}

			for (int d = 0; d < Vinvid.Vxhsize(); d++) {
				if (Print_Mode == 1)
					System.out.print("Vxh=" + Vinvid.getVxh(d) + " ");
				Vinvid.setVxh(
						d,
						w
								* Vinvid.getVxh(d)
								+ (c1 * r1 * (Pinvid.getPxh(d) - invid.getXh(d)))
								+ c2 * r2 * (Ginvid.getGxh(d) - invid.getXh(d)));
				if (Vinvid.getVxh(d) > Vmax)
					Vinvid.setVxh(d, Vmax);
				if (Vinvid.getVxh(d) < -Vmax)
					Vinvid.setVxh(d, -Vmax);
				if (Print_Mode == 1)
					System.out.println("改為 Vxh=" + Vinvid.getVxh(d) + " ");

			}

			for (int d = 0; d < Vinvid.Vxtsize(); d++) {
				if (Print_Mode == 1)
					System.out.print("Vxt=" + Vinvid.getVxt(d) + " ");
				Vinvid.setVxt(
						d,
						w
								* Vinvid.getVxt(d)
								+ (c1 * r1 * (Pinvid.getPxt(d) - invid.getXt(d)))
								+ c2 * r2 * (Ginvid.getGxt(d) - invid.getXt(d)));
				if (Vinvid.getVxt(d) > Vmax)
					Vinvid.setVxt(d, Vmax);
				if (Vinvid.getVxt(d) < -Vmax)
					Vinvid.setVxt(d, -Vmax);
				if (Print_Mode == 1)
					System.out.println("改為 Vxt=" + Vinvid.getVxt(d) + " ");

			}

			for (int d = 0; d < Vinvid.Vysize(); d++) {
				if (Print_Mode == 1)
					System.out.print("Vy=" + Vinvid.getVy(d) + " ");
				Vinvid.setVy(d,
						w * Vinvid.getVy(d)
								+ (c1 * r1 * (Pinvid.getPy(d) - invid.getY(d)))
								+ c2 * r2 * (Ginvid.getGy(d) - invid.getY(d)));
				if (Vinvid.getVy(d) > Vmax)
					Vinvid.setVy(d, Vmax);
				if (Vinvid.getVy(d) < -Vmax)
					Vinvid.setVy(d, -Vmax);
				if (Print_Mode == 1)
					System.out.println("改為 Vy=" + Vinvid.getVy(d) + " ");
			}
			newPopulation.saveV_Individual(i, Vinvid);
		}
		if (Print_Mode == 1)
			System.out.println("變更粒子");
		for (int i = 0; i < pop.size(); i++) {
			Individual invid = pop.getIndividual(i);
			V_Individual Vinvid = pop.getV_Individual(i);
			P_Individual Pinvid = pop.getP_Individual(i);
			G_Individual Ginvid = pop.getG_Individual();
			if (Print_Mode == 1)
				System.out.println("第" + i + "個");
			for (int d = 0; d < invid.Xasize(); d++) {
				double rsid = PSO_Read_Write_txt
						.random_generate_or_read1(Execution_Mode);
				if (Print_Mode == 1) {
					System.out.print("rsid=" + rsid);
					System.out.println(" S(Vx)=" + 1	/ (1 + Math.exp(-PSO_lamda*Vinvid.getVxa(d))));
				}
				if (rsid < 1 / (1 + Math.exp(-PSO_lamda*Vinvid.getVxa(d)))) {
					if (Print_Mode == 1)
						System.out.print("rsid<S(Vx)  X為1");
					invid.setXa(d, 1);
				} else {
					if (Print_Mode == 1)
						System.out.print("rsid>=S(Vx)  X為0");
					invid.setXa(d, 0);
				}
				if (Print_Mode == 1)
					System.out.println();

			}
			for (int d = 0; d < invid.Xhsize(); d++) {
				double rsid = PSO_Read_Write_txt
						.random_generate_or_read1(Execution_Mode);
				if (Print_Mode == 1) {
					System.out.print("rsid=" + rsid);
					System.out.println(" S(Vx)=" + 1	/ (1 + Math.exp(-PSO_lamda*Vinvid.getVxh(d))));
				}
				if (rsid < 1 / (1 + Math.exp(-PSO_lamda*Vinvid.getVxh(d)))) {
					if (Print_Mode == 1)
						System.out.print("rsid<S(Vx)  X為1");
					invid.setXh(d, 1);
				} else {
					if (Print_Mode == 1)
						System.out.print("rsid>=S(Vx)  X為0");
					invid.setXh(d, 0);
				}
				if (Print_Mode == 1)
					System.out.println();

			}
			for (int d = 0; d < invid.Xtsize(); d++) {
				double rsid = PSO_Read_Write_txt
						.random_generate_or_read1(Execution_Mode);
				if (Print_Mode == 1) {
					System.out.print("rsid=" + rsid);
					System.out.println(" S(Vx)=" + 1	/ (1 + Math.exp(-PSO_lamda*Vinvid.getVxt(d))));
				}
				if (rsid < 1 / (1 + Math.exp(-PSO_lamda*Vinvid.getVxt(d)))) {
					if (Print_Mode == 1)
						System.out.print("rsid<S(Vx)  X為1");
					invid.setXt(d, 1);
				} else {
					if (Print_Mode == 1)
						System.out.print("rsid>=S(Vx)  X為0");
					invid.setXt(d, 0);
				}
				if (Print_Mode == 1)
					System.out.println();

			}
			for (int d = 0; d < invid.Ysize(); d++) {
				double rsid = PSO_Read_Write_txt
						.random_generate_or_read1(Execution_Mode);
				if (Print_Mode == 1) {
					System.out.print("rsid=" + rsid);
					System.out.println(" S(Vy)=" + 1	/ (1 + Math.exp(-PSO_lamda*Vinvid.getVy(d))));
				}
				if (rsid < 1 / (1 + Math.exp(-PSO_lamda*Vinvid.getVy(d)))) {
					if (Print_Mode == 1)
						System.out.print("rsid<S(Vy)  Y為1");
					invid.setY(d, 1);
				} else {
					if (Print_Mode == 1)
						System.out.print("rsid>=S(Vy)  Y為0");
					invid.setY(d, 0);
				}
				if (Print_Mode == 1)
					System.out.println();
			}
			newPopulation.saveIndividual(i, invid);
		}
		return newPopulation;
	}

}
