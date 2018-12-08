package Algorithm_DoubleAuction.DE_Real_DA;

import GUI.GUI_Double_Auction.X_Select_Algorithm_Type_to_Solve_the_Problem;

public class Function extends Double_Auction_DE_Real {
	static V_Individual Algorithm1_1(double F, Individual individual_r1, Individual individual_r2, Individual individual_r3) {

		V_Individual V = new V_Individual();
		for (int i = 0; i < Xsize; i++)
			V.setVx(i, individual_r1.getX(i) + F * (individual_r2.getX(i) - individual_r3.getX(i)));

		for (int i = 0; i < Ysize; i++)
			V.setVy(i, individual_r1.getY(i) + F * (individual_r2.getY(i) - individual_r3.getY(i)));

		for (int i = 0; i < Xsize; i++) {
			if (V.getVx(i) > Vmax)
				V.setVx(i, Vmax);
			if (V.getVx(i) < -Vmax)
				V.setVx(i, -Vmax);
		}
		for (int i = 0; i < Ysize; i++) {
			if (V.getVy(i) > Vmax)
				V.setVy(i, Vmax);
			if (V.getVy(i) < -Vmax)
				V.setVy(i, -Vmax);
		}
		if (Omega2 == 1 || Omega3 == 1) {
			for (int i = 0; i < Xsize; i++){
				V.setVrs(i, individual_r1.getrs(i) + F * (individual_r2.getrs(i) - individual_r3.getrs(i)));
				if(V.getVrs(i)>1)
					V.setVrs(i, 1);
				if(V.getVrs(i)<0)
					V.setVrs(i, 0);
			}
			for (int i = 0; i < Ysize; i++){
				V.setVrb(i, individual_r1.getrb(i) + F * (individual_r2.getrb(i) - individual_r3.getrb(i)));
				if(V.getVrb(i)>1)
					V.setVrb(i, 1);
				if(V.getVrb(i)<0)
					V.setVrb(i, 0);
			}
		}
		if (Omega4 == 1){
			V.setVr(individual_r1.getr() + F * (individual_r2.getr() - individual_r3.getr()));
			if(V.getVr()>1)
				V.setVr( 1);
			if(V.getVr()<0)
				V.setVr( 0);
		}
		return V;
	}

	static V_Individual Algorithm1_2(double F, Individual individual_b, Individual individual_r2, Individual individual_r3) {
		V_Individual V = new V_Individual();
		for (int i = 0; i < Xsize; i++)
			V.setVx(i, individual_b.getX(i) + F * (individual_r2.getX(i) - individual_r3.getX(i)));

		for (int i = 0; i < Ysize; i++)
			V.setVy(i, individual_b.getY(i) + F * (individual_r2.getY(i) - individual_r3.getY(i)));

		for (int i = 0; i < Xsize; i++) {
			if (V.getVx(i) > Vmax)
				V.setVx(i, Vmax);
			if (V.getVx(i) < -Vmax)
				V.setVx(i, -Vmax);
		}
		for (int i = 0; i < Ysize; i++) {
			if (V.getVy(i) > Vmax)
				V.setVy(i, Vmax);
			if (V.getVy(i) < -Vmax)
				V.setVy(i, -Vmax);
		}
		if (Omega2 == 1 || Omega3 == 1) {
			for (int i = 0; i < Xsize; i++){
				V.setVrs(i, individual_b.getrs(i) + F * (individual_r2.getrs(i) - individual_r3.getrs(i)));
				if(V.getVrs(i)>1)
					V.setVrs(i, 1);
				if(V.getVrs(i)<0)
					V.setVrs(i, 0);
			}
			for (int i = 0; i < Ysize; i++){
				V.setVrb(i, individual_b.getrb(i) + F * (individual_r2.getrb(i) - individual_r3.getrb(i)));
				if(V.getVrb(i)>1)
					V.setVrb(i, 1);
				if(V.getVrb(i)<0)
					V.setVrb(i, 0);
			}
		}
		if (Omega4 == 1){
			V.setVr(individual_b.getr() + F * (individual_r2.getr() - individual_r3.getr()));
			if(V.getVr()>1)
				V.setVr( 1);
			if(V.getVr()<0)
				V.setVr( 0);
		}
		return V;
	}

	static V_Individual Algorithm1_3(double F, Individual individual_r1, Individual individual_r2, Individual individual_r3, Individual individual_r4, Individual individual_r5) {
		V_Individual V = new V_Individual();
		for (int i = 0; i < Xsize; i++)
			V.setVx(i, individual_r1.getX(i) + F * (individual_r2.getX(i) - individual_r3.getX(i)) + F * (individual_r4.getX(i) - individual_r5.getX(i)));

		for (int i = 0; i < Ysize; i++)
			V.setVy(i, individual_r1.getY(i) + F * (individual_r2.getY(i) - individual_r3.getY(i)) + F * (individual_r4.getY(i) - individual_r5.getY(i)));

		for (int i = 0; i < Xsize; i++) {
			if (V.getVx(i) > Vmax)
				V.setVx(i, Vmax);
			if (V.getVx(i) < -Vmax)
				V.setVx(i, -Vmax);
		}
		for (int i = 0; i < Ysize; i++) {
			if (V.getVy(i) > Vmax)
				V.setVy(i, Vmax);
			if (V.getVy(i) < -Vmax)
				V.setVy(i, -Vmax);
		}
		if (Omega2 == 1 || Omega3 == 1) {
			for (int i = 0; i < Xsize; i++){
				V.setVrs(i, individual_r1.getrs(i) + F * (individual_r2.getrs(i) - individual_r3.getrs(i)) 
						+ F * (individual_r4.getrs(i) - individual_r5.getrs(i)));
				if(V.getVrs(i)>1)
					V.setVrs(i, 1);
				if(V.getVrs(i)<0)
					V.setVrs(i, 0);
			}
			for (int i = 0; i < Ysize; i++){
				V.setVrb(i, individual_r1.getrb(i) + F * (individual_r2.getrb(i) - individual_r3.getrb(i)) 
						+ F * (individual_r4.getrb(i) - individual_r5.getrb(i)));
				if(V.getVrb(i)>1)
					V.setVrb(i, 1);
				if(V.getVrb(i)<0)
					V.setVrb(i, 0);
			}
		}
		if (Omega4 == 1){
			V.setVr(individual_r1.getr() + F * (individual_r2.getr() - individual_r3.getr()) 
					+ F * (individual_r4.getr() - individual_r5.getr()));
			if(V.getVr()>1)
				V.setVr( 1);
			if(V.getVr()<0)
				V.setVr( 0);
		}
		return V;
	}

	static V_Individual Algorithm1_4(double F, Individual individual_b, Individual individual_r1, Individual individual_r2, Individual individual_r3, Individual individual_r4) {
		V_Individual V = new V_Individual();
		for (int i = 0; i < Xsize; i++)
			V.setVx(i, individual_b.getX(i) + F * (individual_r1.getX(i) - individual_r2.getX(i)) + F * (individual_r3.getX(i) - individual_r4.getX(i)));

		for (int i = 0; i < Ysize; i++)
			V.setVy(i, individual_b.getY(i) + F * (individual_r1.getY(i) - individual_r2.getY(i)) + F * (individual_r3.getY(i) - individual_r4.getY(i)));

		for (int i = 0; i < Xsize; i++) {
			if (V.getVx(i) > Vmax)
				V.setVx(i, Vmax);
			if (V.getVx(i) < -Vmax)
				V.setVx(i, -Vmax);
		}
		for (int i = 0; i < Ysize; i++) {
			if (V.getVy(i) > Vmax)
				V.setVy(i, Vmax);
			if (V.getVy(i) < -Vmax)
				V.setVy(i, -Vmax);
		}
		if (Omega2 == 1 || Omega3 == 1) {
			for (int i = 0; i < Xsize; i++){
				V.setVrs(i, individual_b.getrs(i) + F * (individual_r1.getrs(i) - individual_r2.getrs(i)) 
						+ F * (individual_r3.getrs(i) - individual_r4.getrs(i)));
				if(V.getVrs(i)>1)
					V.setVrs(i, 1);
				if(V.getVrs(i)<0)
					V.setVrs(i, 0);
			}
			for (int i = 0; i < Ysize; i++){
				V.setVrb(i, individual_b.getrb(i) + F * (individual_r1.getrb(i) - individual_r2.getrb(i)) 
						+ F * (individual_r3.getrb(i) - individual_r4.getrb(i)));
				if(V.getVrb(i)>1)
					V.setVrb(i, 1);
				if(V.getVrb(i)<0)
					V.setVrb(i, 0);
			}
		}
		if (Omega4 == 1){
			V.setVr(individual_b.getr() + F * (individual_r1.getr() - individual_r2.getr()) 
					+ F * (individual_r3.getr() - individual_r4.getr()));
			if(V.getVr()>1)
				V.setVr( 1);
			if(V.getVr()<0)
				V.setVr( 0);
		}
		return V;
	}

	static V_Individual Algorithm1_5(double F, Individual individual, Individual individual_b, Individual individual_r1, Individual individual_r2) {
		V_Individual V = new V_Individual();
		for (int i = 0; i < Xsize; i++)
			V.setVx(i, individual.getX(i) + F * (individual_b.getX(i) - individual.getX(i)) + F * (individual_r1.getX(i) - individual_r2.getX(i)));

		for (int i = 0; i < Ysize; i++)
			V.setVy(i, individual.getY(i) + F * (individual_b.getY(i) - individual.getY(i)) + F * (individual_r1.getY(i) - individual_r2.getY(i)));

		for (int i = 0; i < Xsize; i++) {
			if (V.getVx(i) > Vmax)
				V.setVx(i, Vmax);
			if (V.getVx(i) < -Vmax)
				V.setVx(i, -Vmax);
		}
		for (int i = 0; i < Ysize; i++) {
			if (V.getVy(i) > Vmax)
				V.setVy(i, Vmax);
			if (V.getVy(i) < -Vmax)
				V.setVy(i, -Vmax);
		}
		if (Omega2 == 1 || Omega3 == 1) {
			for (int i = 0; i < Xsize; i++){
				V.setVrs(i, individual.getrs(i) + F * (individual_b.getrs(i) - individual.getrs(i)) 
						+ F * (individual_r1.getrs(i) - individual_r2.getrs(i)));
				if(V.getVrs(i)>1)
					V.setVrs(i, 1);
				if(V.getVrs(i)<0)
					V.setVrs(i, 0);
			}
			for (int i = 0; i < Ysize; i++){
				V.setVrb(i, individual.getrb(i) + F * (individual_b.getrb(i) - individual.getrb(i))
						+ F * (individual_r1.getrb(i) - individual_r2.getrb(i)));
				if(V.getVrb(i)>1)
					V.setVrb(i, 1);
				if(V.getVrb(i)<0)
					V.setVrb(i, 0);
			}
		}
		if (Omega4 == 1){
			V.setVr(individual.getr() + F * (individual_b.getr() - individual.getr()) 
					+ F * (individual_r1.getr() - individual_r2.getr()));
			if(V.getVr()>1)
				V.setVr( 1);
			if(V.getVr()<0)
				V.setVr( 0);
		}
		return V;
	}

	static V_Individual Algorithm1_6(double F, Individual individual, Individual individual_b, Individual individual_r1, Individual individual_r2, Individual individual_r3, Individual individual_r4) {
		V_Individual V = new V_Individual();
		for (int i = 0; i < Xsize; i++)
			V.setVx(i, individual.getX(i) + F * (individual_b.getX(i) - individual.getX(i)) + F * (individual_r1.getX(i) - individual_r2.getX(i)) + F * (individual_r3.getX(i) - individual_r4.getX(i)));

		for (int i = 0; i < Ysize; i++)
			V.setVy(i, individual.getY(i) + F * (individual_b.getY(i) - individual.getY(i)) + F * (individual_r1.getY(i) - individual_r2.getY(i)) + F * (individual_r3.getY(i) - individual_r4.getY(i)));

		for (int i = 0; i < Xsize; i++) {
			if (V.getVx(i) > Vmax)
				V.setVx(i, Vmax);
			if (V.getVx(i) < -Vmax)
				V.setVx(i, -Vmax);
		}
		for (int i = 0; i < Ysize; i++) {
			if (V.getVy(i) > Vmax)
				V.setVy(i, Vmax);
			if (V.getVy(i) < -Vmax)
				V.setVy(i, -Vmax);
		}
		if (Omega2 == 1 || Omega3 == 1) {
			for (int i = 0; i < Xsize; i++){
				V.setVrs(i, individual.getrs(i) + F * (individual_b.getrs(i) - individual.getrs(i)) 
						+ F * (individual_r1.getrs(i) - individual_r2.getrs(i))
						+ F * (individual_r3.getrs(i) - individual_r4.getrs(i)));
				if(V.getVrs(i)>1)
					V.setVrs(i, 1);
				if(V.getVrs(i)<0)
					V.setVrs(i, 0);
			}
			for (int i = 0; i < Ysize; i++){
				V.setVrb(i, individual.getrb(i) + F * (individual_b.getrb(i) - individual.getrb(i)) 
						+ F * (individual_r1.getrb(i) - individual_r2.getrb(i))
						+ F * (individual_r3.getrb(i) - individual_r4.getrb(i)));
				if(V.getVrb(i)>1)
					V.setVrb(i, 1);
				if(V.getVrb(i)<0)
					V.setVrb(i, 0);
			}
		}
		if (Omega4 == 1){
			V.setVr(individual.getr() + F * (individual_b.getr() - individual.getr()) 
					+ F * (individual_r1.getr() - individual_r2.getr())
					+ F * (individual_r3.getr() - individual_r4.getr()));
			if(V.getVr()>1)
				V.setVr( 1);
			if(V.getVr()<0)
				V.setVr( 0);
		}
		return V;
	}

	static int select_strategy() {
		int strategy = 0;
		String Select_Algorithm_Type = X_Select_Algorithm_Type_to_Solve_the_Problem.method();

		if (Select_Algorithm_Type.equals("DE_DA_Real")) {
			System.out.println("DE_DA_Real");
			double strategy_R = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
			if (strategy_R <= (1 / 6))
				strategy = 1;
			else if (strategy_R <= (2 / 6))
				strategy = 2;
			else if (strategy_R <= (3 / 6))
				strategy = 3;
			else if (strategy_R <= (4 / 6))
				strategy = 4;
			else if (strategy_R <= (5 / 6))
				strategy = 5;
			else
				strategy = 6;
		}
		else if (Select_Algorithm_Type.equals("DE_DA_strategy1_Real")) {
			System.out.println("DE_DA_strategy1_Real");
			strategy = 1;
		}
		else if (Select_Algorithm_Type.equals("DE_DA_strategy2_Real")) {
			System.out.println("DE_DA_strategy2_Real");
			strategy = 2;
		}
		else if (Select_Algorithm_Type.equals("DE_DA_strategy3_Real")) {
			System.out.println("DE_DA_strategy3_Real");
			strategy = 3;
		}
		else if (Select_Algorithm_Type.equals("DE_DA_strategy4_Real")) {
			System.out.println("DE_DA_strategy4_Real");
			strategy = 4;
		}
		else if (Select_Algorithm_Type.equals("DE_DA_strategy5_Real")) {
			System.out.println("DE_DA_strategy5_Real");
			strategy = 5;
		}
		else if (Select_Algorithm_Type.equals("DE_DA_strategy6_Real")) {
			System.out.println("DE_DA_strategy6_Real");
			strategy = 6;
		}

		return strategy;
	}

	static U_Individual Algorithm2(int j, int strategy, Individual indiv, V_Individual P_indiv) {

		int a = DE_Read_Write_txt.random_generate_or_read2(Execution_Mode, Xsize);

		U_Individual U = new U_Individual();
		for (int i = 0; i < Xsize; i++)
			U.setUx(i, indiv.getX(i));
		for (int i = 0; i < Ysize; i++)
			U.setUy(i, indiv.getY(i));
		if (Omega2 == 1 || Omega3 == 1) {
			for (int i = 0; i < Xsize; i++)
				U.setUrs(i, indiv.getrs(i));
			for (int i = 0; i < Ysize; i++)
				U.setUrb(i, indiv.getrb(i));
		}
		if (Omega4 == 1)
			U.setUr(indiv.getr());

		for (int i = 0; i < Xsize; i++)
			if (DE_Read_Write_txt.random_generate_or_read1(Execution_Mode) < CR || i == a){
				U.setUx(i, P_indiv.getVx(i));
				if (Omega2 == 1 || Omega3 == 1)
					U.setUrs(i, P_indiv.getVrs(i));
			}
		
		a = DE_Read_Write_txt.random_generate_or_read2(Execution_Mode, Ysize);
		for (int i = 0; i < Ysize; i++)
			if (DE_Read_Write_txt.random_generate_or_read1(Execution_Mode) < CR || i == a){
				U.setUy(i, P_indiv.getVy(i));
				if (Omega2 == 1 || Omega3 == 1)
					U.setUrb(i, P_indiv.getVrb(i));
			}
				
		if (Omega4 == 1)
			if (DE_Read_Write_txt.random_generate_or_read1(Execution_Mode) < CR)
				U.setUr(P_indiv.getVr());

		return U;
	}

}
