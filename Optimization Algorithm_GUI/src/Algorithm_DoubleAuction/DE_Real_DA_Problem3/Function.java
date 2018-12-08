package Algorithm_DoubleAuction.DE_Real_DA_Problem3;

import java.util.Collections;
import java.util.Random;
 


import GUI.GUI_Double_Auction.X_Select_Algorithm_Type_to_Solve_the_Problem;
import Input_Output_txt.Double_Auction.Read_Sik_Parameter;

 
public class Function extends Double_Auction_DE_Real_Problem3{
	static V_Individual Algorithm1_1(Individual individual_r1,Individual individual_r2,Individual individual_r3) {
		
		V_Individual V=new V_Individual();
		for(int i=0;i<Xsize;i++)
			V.setVx(i, (int)(individual_r1.getX(i)+F*(individual_r2.getX(i)-individual_r3.getX(i))));
		
		for(int i=0;i<Ysize;i++)
			V.setVy(i, individual_r1.getY(i)+F*(individual_r2.getY(i)-individual_r3.getY(i)));
		
		
		for(int i=0;i<Xsize;i++){
			if (V.getVx(i) > Read_Sik_Parameter.top())
				V.setVx(i, Read_Sik_Parameter.top());
			if (V.getVx(i) < 0)
				V.setVx(i, 0);
		}
		for(int i=0;i<Ysize;i++){
			if (V.getVy(i) > Vmax)
				V.setVy(i, Vmax);
			if (V.getVy(i) < -Vmax)
				V.setVy(i, -Vmax);
		}
		for (int i = 0; i < Ysize; i++) {
			double rsid = DE_Read_Write_txt
					.random_generate_or_read1(Execution_Mode);
			if (rsid < 1 / (1 + Math.exp(-lamda * V.getVy(i)))) {
				V.setbinaryVy(i, 1);
			} else {
				V.setbinaryVy(i, 0);
			}
		}
		return V;
	}

	static V_Individual Algorithm1_2( Individual individual_b,Individual individual_r1,Individual individual_r2) {
		V_Individual V=new V_Individual();
		for(int i=0;i<Xsize;i++)
			V.setVx(i, (int)(individual_b.getX(i)+F*(individual_r1.getX(i)-individual_r2.getX(i))));
		
		for(int i=0;i<Ysize;i++)
			V.setVy(i, individual_b.getY(i)+F*(individual_r1.getY(i)-individual_r2.getY(i)));
		
		for(int i=0;i<Xsize;i++){
			if (V.getVx(i) > Read_Sik_Parameter.top())
				V.setVx(i, Read_Sik_Parameter.top());
			if (V.getVx(i) < 0)
				V.setVx(i, 0);
		}
		for(int i=0;i<Ysize;i++){
			if (V.getVy(i) > Vmax)
				V.setVy(i, Vmax);
			if (V.getVy(i) < -Vmax)
				V.setVy(i, -Vmax);
		}
		for (int i = 0; i < Ysize; i++) {
			double rsid = DE_Read_Write_txt
					.random_generate_or_read1(Execution_Mode);
			if (rsid < 1 / (1 + Math.exp(-lamda * V.getVy(i)))) {
				V.setbinaryVy(i, 1);
			} else {
				V.setbinaryVy(i, 0);
			}
		}
		return V;
	}
	
	static V_Individual Algorithm1_3(Individual individual_r1,Individual individual_r2,Individual individual_r3,Individual individual_r4,Individual individual_r5) {
		V_Individual V=new V_Individual();
		for(int i=0;i<Xsize;i++)
			V.setVx(i, (int)(individual_r5.getX(i)+F1*(individual_r1.getX(i)-individual_r2.getX(i))+F2*(individual_r3.getX(i)-individual_r4.getX(i))));
		
		for(int i=0;i<Ysize;i++)
			V.setVy(i, individual_r5.getY(i)+F1*(individual_r1.getY(i)-individual_r2.getY(i))+F2*(individual_r3.getY(i)-individual_r4.getY(i)));
		
		for(int i=0;i<Xsize;i++){
			if (V.getVx(i) > Read_Sik_Parameter.top())
				V.setVx(i, Read_Sik_Parameter.top());
			if (V.getVx(i) < 0)
				V.setVx(i, 0);
		}
		for(int i=0;i<Ysize;i++){
			if (V.getVy(i) > Vmax)
				V.setVy(i, Vmax);
			if (V.getVy(i) < -Vmax)
				V.setVy(i, -Vmax);
		}
		for (int i = 0; i < Ysize; i++) {
			double rsid = DE_Read_Write_txt
					.random_generate_or_read1(Execution_Mode);
			if (rsid < 1 / (1 + Math.exp(-lamda * V.getVy(i)))) {
				V.setbinaryVy(i, 1);
			} else {
				V.setbinaryVy(i, 0);
			}
		}
		return V;
	}
	
	static V_Individual Algorithm1_4(Individual individual_b,Individual individual_r1,Individual individual_r2,Individual individual_r3,Individual individual_r4) {
		V_Individual V=new V_Individual();
		for(int i=0;i<Xsize;i++)
			V.setVx(i, (int)(individual_b.getX(i)+F1*(individual_r1.getX(i)-individual_r2.getX(i))+F2*(individual_r3.getX(i)-individual_r4.getX(i))));
		
		for(int i=0;i<Ysize;i++)
			V.setVy(i, individual_b.getY(i)+F1*(individual_r1.getY(i)-individual_r2.getY(i))+F2*(individual_r3.getY(i)-individual_r4.getY(i)));
	
		for(int i=0;i<Xsize;i++){
			if (V.getVx(i) > Read_Sik_Parameter.top())
				V.setVx(i, Read_Sik_Parameter.top());
			if (V.getVx(i) < 0)
				V.setVx(i, 0);
		}
		for(int i=0;i<Ysize;i++){
			if (V.getVy(i) > Vmax)
				V.setVy(i, Vmax);
			if (V.getVy(i) < -Vmax)
				V.setVy(i, -Vmax);
		}
		for (int i = 0; i < Ysize; i++) {
			double rsid = DE_Read_Write_txt
					.random_generate_or_read1(Execution_Mode);
			if (rsid < 1 / (1 + Math.exp(-lamda * V.getVy(i)))) {
				V.setbinaryVy(i, 1);
			} else {
				V.setbinaryVy(i, 0);
			}
		}
		return V;
	}
	
	static V_Individual Algorithm1_5(Individual individual,Individual individual_r1,Individual individual_r2,Individual individual_r3) {
		V_Individual V=new V_Individual();
		for(int i=0;i<Xsize;i++)
			V.setVx(i, (int)(individual_r1.getX(i)+K1*(individual_r3.getX(i)-individual.getX(i))+F*(individual_r1.getX(i)-individual_r2.getX(i))));
		
		for(int i=0;i<Ysize;i++)
			V.setVy(i, individual_r1.getY(i)+K1*(individual_r3.getY(i)-individual.getY(i))+F*(individual_r1.getY(i)-individual_r2.getY(i)));
	
		for(int i=0;i<Xsize;i++){
			if (V.getVx(i) > Read_Sik_Parameter.top())
				V.setVx(i, Read_Sik_Parameter.top());
			if (V.getVx(i) < 0)
				V.setVx(i, 0);
		}
		for(int i=0;i<Ysize;i++){
			if (V.getVy(i) > Vmax)
				V.setVy(i, Vmax);
			if (V.getVy(i) < -Vmax)
				V.setVy(i, -Vmax);
		}
		for (int i = 0; i < Ysize; i++) {
			double rsid = DE_Read_Write_txt
					.random_generate_or_read1(Execution_Mode);
			if (rsid < 1 / (1 + Math.exp(-lamda * V.getVy(i)))) {
				V.setbinaryVy(i, 1);
			} else {
				V.setbinaryVy(i, 0);
			}
		}
		return V;
	}
	
	static V_Individual Algorithm1_6( Individual individual,Individual individual_b,Individual individual_r1,Individual individual_r2,Individual individual_r3) {
		V_Individual V=new V_Individual();
		for(int i=0;i<Xsize;i++)
			V.setVx(i, (int)(individual_r3.getX(i)+F1*(individual_b.getX(i)-individual_r2.getX(i))+F2*(individual.getX(i)-individual_r1.getX(i)) ));
		
		for(int i=0;i<Ysize;i++)
			V.setVy(i, individual_r3.getY(i)+F1*(individual_b.getY(i)-individual_r2.getY(i))+F2*(individual.getY(i)-individual_r1.getY(i)));
	
		for(int i=0;i<Xsize;i++){
			if (V.getVx(i) > Read_Sik_Parameter.top())
				V.setVx(i, Read_Sik_Parameter.top());
			if (V.getVx(i) < 0)
				V.setVx(i, 0);
		}
		for(int i=0;i<Ysize;i++){
			if (V.getVy(i) > Vmax)
				V.setVy(i, Vmax);
			if (V.getVy(i) < -Vmax)
				V.setVy(i, -Vmax);
		}
		for (int i = 0; i < Ysize; i++) {
			double rsid = DE_Read_Write_txt
					.random_generate_or_read1(Execution_Mode);
			if (rsid < 1 / (1 + Math.exp(-lamda * V.getVy(i)))) {
				V.setbinaryVy(i, 1);
			} else {
				V.setbinaryVy(i, 0);
			}
		}
		return V;
	}

/*	static void Update_p_f_cr( ) {
		// 計算S總和
		int S = 0;
		for (int i = 0; i < 6; i++)
			S += s[i];
		// Update p、 f、cr
		for (int i = 0; i < 6; i++) {
			p[i] = s[i] / (Epsilon + S);
			if (successfulF.size() != 0){
				Collections.sort(successfulF);
				if (successfulF.size() % 2 != 0)
					f[i] = successfulF.get((successfulF.size() + 1) / 2-1);
				else
					f[i] = (successfulF.get(successfulF.size() / 2-1) + successfulF.get((successfulF.size() / 2) )) / 2;
			
			}else
				f[i] = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
			
			if (successfulCR.size() != 0){
				Collections.sort(successfulCR);
				if (successfulCR.size() % 2 != 0)
					cr[i] = successfulCR	.get((successfulCR.size() + 1) / 2-1);
				else
					cr[i] = (successfulCR.get(successfulCR.size() / 2-1) + successfulCR.get((successfulCR.size() / 2) )) / 2;
			}else
				cr[i] = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
			}
	//	generationCount=0;
	//	susuccessfulF = new ArrayList<Double>();
	//	successfulCR = new ArrayList<Double>();
	}
*/
	 static int select_strategy() {
			int strategy = 0;
			String Select_Algorithm_Type=X_Select_Algorithm_Type_to_Solve_the_Problem.method();
			
			if(Select_Algorithm_Type.equals("DE_DA_Real")){
				System.out.println("DE_DA_Real");
			double strategy_R =DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
			if (strategy_R <= (1/6))
				strategy = 1;
			else if (strategy_R <= (2/6))
				strategy = 2;
			else if (strategy_R <= (3/6))
				strategy = 3;
			else if (strategy_R <= (4/6))
				strategy = 4;
			else if (strategy_R <= (5/6))
				strategy = 5;
			else
				strategy = 6;
			}
			else if(Select_Algorithm_Type.equals("DE_DA_strategy1_Real")){
				System.out.println("DE_DA_strategy1_Real");
				strategy = 1;
			}
			else if(Select_Algorithm_Type.equals("DE_DA_strategy2_Real")){
				System.out.println("DE_DA_strategy2_Real");
				strategy = 2;
			}
			else if(Select_Algorithm_Type.equals("DE_DA_strategy3_Real")){
				System.out.println("DE_DA_strategy3_Real");
				strategy = 3;
			}
			else if(Select_Algorithm_Type.equals("DE_DA_strategy4_Real")){
				System.out.println("DE_DA_strategy4_Real");
				strategy = 4;
			}
			else if(Select_Algorithm_Type.equals("DE_DA_strategy5_Real")){
				System.out.println("DE_DA_strategy5_Real");
				strategy = 5;
			}
			else if(Select_Algorithm_Type.equals("DE_DA_strategy6_Real")){
				System.out.println("DE_DA_strategy6_Real");
				strategy = 6;
			}
			
			return strategy;
		}

	 static U_Individual Algorithm2(int j,int strategy,Individual indiv,V_Individual P_indiv) {
			
			 
			int a= DE_Read_Write_txt.random_generate_or_read2(Execution_Mode,Xsize);
			
			U_Individual U=new U_Individual();
			for(int i=0;i<Xsize;i++)
				U.setUx(i, indiv.getX(i));
			for(int i=0;i<Ysize;i++)
				U.setUy(i, indiv.getY(i));
			
			for(int i=0;i<Xsize;i++)
				if(DE_Read_Write_txt.random_generate_or_read1(Execution_Mode)<CR || i==a)
					U.setUx(i,P_indiv.getVx(i));
				
			  a= DE_Read_Write_txt.random_generate_or_read2(Execution_Mode,Ysize);
			for(int i=0;i<Ysize;i++)
				if(DE_Read_Write_txt.random_generate_or_read1(Execution_Mode)<CR || i==a)
					U.setUy(i,P_indiv.getVy(i));
			
			return U;
		}
	 

	 
}
