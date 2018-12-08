package Algorithm_DoubleAuction.DE_DA_Porblem3;

import java.util.Collections;
import java.util.Random;

import GUI.GUI_Double_Auction.X_Select_Algorithm_Type_to_Solve_the_Problem;
import Input_Output_txt.Double_Auction.Read_Seller_Price_Parameter;

 
public class Function extends Double_Auction_DE_Problem3{
	static V_Individual Algorithm1_1(double F,Individual individual_r1,Individual individual_r2,Individual individual_r3) {
		 
			
		int[] YV1=new int[Ysize];	
		for(int i=0;i<Ysize;i++)
			YV1[i]=individual_r2.getY(i)^individual_r3.getY(i);
			
		
		int[] YI=new int[Ysize];
		for(int i=0;i<Ysize;i++)
			if(DE_Read_Write_txt.random_generate_or_read1(Execution_Mode)<F)
				YI[i]=1;
		
		for(int i=0;i<Ysize;i++)
			YV1[i]=YV1[i]&YI[i];
			
		V_Individual V=new V_Individual();
		for(int i=0;i<Xsize;i++)
			V.setVx(i, (int)(individual_r1.getX(i)+F*(individual_r2.getX(i)-individual_r3.getX(i))));
			
		for(int i=0;i<Xsize;i++){
			if (V.getVx(i) > Read_Seller_Price_Parameter.top())
				V.setVx(i, Read_Seller_Price_Parameter.top());
			if (V.getVx(i) < 0)
				V.setVx(i, 0);
		}
		
		for(int i=0;i<Ysize;i++)
			V.setVy(i, individual_r1.getY(i)^YV1[i]);
		return V;
	}

	static V_Individual Algorithm1_2( double F,Individual individual_b,Individual individual_r2,Individual individual_r3) {
		 
		
		
		int[] YV1=new int[Ysize];
		
		for(int i=0;i<Ysize;i++)
			YV1[i]=individual_r2.getY(i)^individual_r3.getY(i);
			
		
		int[] YI=new int[Ysize];
		for(int i=0;i<Ysize;i++)
			if(DE_Read_Write_txt.random_generate_or_read1(Execution_Mode)<F)
				YI[i]=1;
		
		for(int i=0;i<Ysize;i++)
			YV1[i]=YV1[i]&YI[i];
			
		 
		V_Individual V=new V_Individual();
		for(int i=0;i<Xsize;i++)
			V.setVx(i, (int)(individual_b.getX(i)+F*(individual_r2.getX(i)-individual_r3.getX(i))));
		
		for(int i=0;i<Xsize;i++){
			if (V.getVx(i) > Read_Seller_Price_Parameter.top())
				V.setVx(i, Read_Seller_Price_Parameter.top());
			if (V.getVx(i) < 0)
				V.setVx(i, 0);
		}
		for(int i=0;i<Ysize;i++)
			V.setVy(i, individual_b.getY(i)^YV1[i]);
		return V;
	}
	
	static V_Individual Algorithm1_3(double F,Individual individual_r1,Individual individual_r2,Individual individual_r3,Individual individual_r4,Individual individual_r5) {
		 
		int[] YV1=new int[Ysize];	
		int[] YV2=new int[Ysize];	
		for(int i=0;i<Ysize;i++){
			YV1[i]=individual_r2.getY(i)^individual_r3.getY(i);
			YV2[i]=individual_r4.getY(i)^individual_r5.getY(i);
		}
		int[] YI=new int[Ysize];
		for(int i=0;i<Ysize;i++)
			if(DE_Read_Write_txt.random_generate_or_read1(Execution_Mode)<F)
				YI[i]=1;
		
		for(int i=0;i<Ysize;i++){
			YV1[i]=YV1[i]&YI[i];
			YV2[i]=YV2[i]&YI[i];
		}
			
		V_Individual V=new V_Individual();
		int[] Vx=new int[Xsize];
		for(int i=0;i<Xsize;i++)
			V.setVx(i, (int)(individual_r1.getX(i)+F*(individual_r2.getX(i)-individual_r3.getX(i))+F*(individual_r4.getX(i)-individual_r5.getX(i))));
		for(int i=0;i<Xsize;i++){
			if (V.getVx(i) > Read_Seller_Price_Parameter.top())
				V.setVx(i, Read_Seller_Price_Parameter.top());
			if (V.getVx(i) < 0)
				V.setVx(i, 0);
		}
		int[] Vy=new int[Ysize];
		for(int i=0;i<Ysize;i++){
			Vy[i]=YV1[i]|YV2[i];
			V.setVy(i, Vy[i]^individual_r1.getY(i));
		}
		return V;
	}
	
	static V_Individual Algorithm1_4(double F,Individual individual_b,Individual individual_r1,Individual individual_r2,Individual individual_r3,Individual individual_r4) {
	 
		int[] YV1=new int[Ysize];	
		int[] YV2=new int[Ysize];	
		for(int i=0;i<Ysize;i++){
			YV1[i]=individual_r1.getY(i)^individual_r2.getY(i);
			YV2[i]=individual_r3.getY(i)^individual_r4.getY(i);
		}
		int[] YI=new int[Ysize];
		for(int i=0;i<Ysize;i++)
			if(DE_Read_Write_txt.random_generate_or_read1(Execution_Mode)<F)
				YI[i]=1;
		
		for(int i=0;i<Ysize;i++){
			YV1[i]=YV1[i]&YI[i];
			YV2[i]=YV2[i]&YI[i];
		}
			
		V_Individual V=new V_Individual();
		for(int i=0;i<Xsize;i++)
			V.setVx(i, (int)(individual_b.getX(i)+F*(individual_r1.getX(i)-individual_r2.getX(i))+F*(individual_r3.getX(i)-individual_r4.getX(i))));
		
		for(int i=0;i<Xsize;i++){
			if (V.getVx(i) > Read_Seller_Price_Parameter.top())
				V.setVx(i, Read_Seller_Price_Parameter.top());
			if (V.getVx(i) < 0)
				V.setVx(i, 0);
		}
		int[] Vy=new int[Ysize];
		for(int i=0;i<Ysize;i++){
			Vy[i]=YV1[i]|YV2[i];
			V.setVy(i, Vy[i]^individual_b.getY(i));
		}
		return V;
	}
	
	static V_Individual Algorithm1_5(double F,Individual individual,Individual individual_b,Individual individual_r1,Individual individual_r2) {
		 
		int[] YV1=new int[Ysize];	
		int[] YV2=new int[Ysize];	
		for(int i=0;i<Ysize;i++){
			YV1[i]=individual_b.getY(i)^individual.getY(i);
			YV2[i]=individual_r1.getY(i)^individual_r2.getY(i);
		}
		int[] YI=new int[Ysize];
		for(int i=0;i<Ysize;i++)
			if(DE_Read_Write_txt.random_generate_or_read1(Execution_Mode)<F)
				YI[i]=1;
		
		for(int i=0;i<Ysize;i++){
			YV1[i]=YV1[i]&YI[i];
			YV2[i]=YV2[i]&YI[i];
		}
			
		V_Individual V=new V_Individual();
		for(int i=0;i<Xsize;i++)
			V.setVx(i, (int)(individual.getX(i)+F*(individual_b.getX(i)-individual.getX(i))+F*(individual_r1.getX(i)-individual_r2.getX(i))));
		
		for(int i=0;i<Xsize;i++){
			if (V.getVx(i) > Read_Seller_Price_Parameter.top())
				V.setVx(i, Read_Seller_Price_Parameter.top());
			if (V.getVx(i) < 0)
				V.setVx(i, 0);
		}
		int[] Vy=new int[Ysize];
		for(int i=0;i<Ysize;i++){
			Vy[i]=YV1[i]|YV2[i];
			V.setVy(i, Vy[i]^individual.getY(i));
		}
		return V;
	}
	
	static V_Individual Algorithm1_6( double F,Individual individual,Individual individual_b,Individual individual_r1,Individual individual_r2,Individual individual_r3,Individual individual_r4) {
	 
		int[] YV1=new int[Ysize];
		int[] YV2=new int[Ysize];
		int[] YV3=new int[Ysize];
		
		for(int i=0;i<Ysize;i++){
			YV1[i]=individual_b.getY(i)^individual.getY(i);
			YV2[i]=individual_r1.getY(i)^individual_r2.getY(i);
			YV3[i]=individual_r3.getY(i)^individual_r4.getY(i);
		}
		
		int[] YI=new int[Ysize];
		for(int i=0;i<Ysize;i++)
			if(DE_Read_Write_txt.random_generate_or_read1(Execution_Mode)<F)
				YI[i]=1;
		
		for(int i=0;i<Ysize;i++){
			YV1[i]=YV1[i]&YI[i];
			YV2[i]=YV2[i]&YI[i];
			YV3[i]=YV3[i]&YI[i];
		}
	 
		V_Individual V=new V_Individual();
		for(int i=0;i<Xsize;i++)
			V.setVx(i, (int)(individual.getX(i)+F*(individual_b.getX(i)-individual.getX(i))+F*(individual_r1.getX(i)-individual_r2.getX(i))+F*(individual_r3.getX(i)-individual_r4.getX(i))));
		
		for(int i=0;i<Xsize;i++){
			if (V.getVx(i) > Read_Seller_Price_Parameter.top())
				V.setVx(i, Read_Seller_Price_Parameter.top());
			if (V.getVx(i) < 0)
				V.setVx(i, 0);
		}
		int[] Vy=new int[Ysize];
		for(int i=0;i<Ysize;i++){
			Vy[i]=YV1[i]|YV2[i];
			Vy[i]=Vy[i]|YV3[i];
			V.setVy(i, Vy[i]^individual.getY(i));
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
			
			if(Select_Algorithm_Type.equals("DE_DA")){
				System.out.println("DE_DA");
			double strategy_R =DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
			if (strategy_R <=  (1/6))
				strategy = 1;
			else if (strategy_R <=  (2/6))
				strategy = 2;
			else if (strategy_R <=  (3/6))
				strategy = 3;
			else if (strategy_R <= (4/6))
				strategy = 4;
			else if (strategy_R <=  (5/6))
				strategy = 5;
			else
				strategy = 6;
			}
			else if(Select_Algorithm_Type.equals("DE_DA_strategy1")){
				System.out.println("DE_DA_strategy1");
				strategy = 1;
			}
			else if(Select_Algorithm_Type.equals("DE_DA_strategy2")){
				System.out.println("DE_DA_strategy2");
				strategy = 2;
			}
			else if(Select_Algorithm_Type.equals("DE_DA_strategy3")){
				System.out.println("DE_DA_strategy3");
				strategy = 3;
			}
			else if(Select_Algorithm_Type.equals("DE_DA_strategy4")){
				System.out.println("DE_DA_strategy4");
				strategy = 4;
			}
			else if(Select_Algorithm_Type.equals("DE_DA_strategy5")){
				System.out.println("DE_DA_strategy5");
				strategy = 5;
			}
			else if(Select_Algorithm_Type.equals("DE_DA_strategy6")){
				System.out.println("DE_DA_strategy6");
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
				if(DE_Read_Write_txt.random_generate_or_read1(Execution_Mode)<CR|| i==a)
					U.setUx(i,P_indiv.getVx(i));
				
			  a= DE_Read_Write_txt.random_generate_or_read2(Execution_Mode,Ysize);
			for(int i=0;i<Ysize;i++)
				if(DE_Read_Write_txt.random_generate_or_read1(Execution_Mode)<CR|| i==a)
					U.setUy(i,P_indiv.getVy(i));
			
			return U;
		}
	 
/*	 static void Algorithm3() {
			Random r = new Random();
			double c=DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
			while (c == 0.25 || c==0.5 || c==0.75) {
				c = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
			}
			
			for(int k=0;k<6;k++)
				for(int i=0;i<populationSize;i++){
					c=4*c*(1-c);
					F[k][i]=f[k]+0.2*(c-0.5);
					while(F[k][i] >1.5 || F[k][i]<0){
						c=4*c*(1-c);
						F[k][i]=f[k]+0.2*(c-0.5);
					}
				}
			
			for(int k=0;k<6;k++)
				for(int i=0;i<populationSize;i++){
					c=4*c*(1-c);
					CR[k][i]=cr[k]+0.1*(c-0.5);
					while(CR[k][i] >1 || CR[k][i]<0){
						c=4*c*(1-c);
						CR[k][i]=cr[k]+0.1*(c-0.5);
					}
				}
		}*/
	 
}
