package Algorithm_DoubleAuction.NSDE_POP_DA;

import java.util.Collections;
import java.util.Random;
 
import GUI.GUI_Double_Auction.X_Select_Algorithm_Type_to_Solve_the_Problem;

 
public class Function extends Double_Auction_NSDE_POP{
	static V_Individual Algorithm1_1(double F,Individual individual_r1,Individual individual_r2,Individual individual_r3) {
		
		V_Individual V=new V_Individual();
		if(DE_Read_Write_txt.random_generate_or_read1(Execution_Mode)<0.5){
			for(int i=0;i<Xsize;i++)
				V.setVx(i, individual_r1.getX(i)+(individual_r2.getX(i)-individual_r3.getX(i))*(DE_Read_Write_txt.random_generate_or_read3(Execution_Mode) * 0.5 + 0.5));
			for(int i=0;i<Ysize;i++)
				V.setVy(i, individual_r1.getY(i)+(individual_r2.getY(i)-individual_r3.getY(i))*(DE_Read_Write_txt.random_generate_or_read3(Execution_Mode) * 0.5 + 0.5));
		}	
		else{
			for(int i=0;i<Xsize;i++)
				V.setVx(i, individual_r1.getX(i)+(individual_r2.getX(i)-individual_r3.getX(i))*(Math.tan(Math.PI*(DE_Read_Write_txt.random_generate_or_read5(Execution_Mode)-0.5))));
			for(int i=0;i<Ysize;i++)
				V.setVy(i, individual_r1.getY(i)+(individual_r2.getY(i)-individual_r3.getY(i))*(Math.tan(Math.PI*(DE_Read_Write_txt.random_generate_or_read5(Execution_Mode)-0.5))));
		}
			

		for(int i=0;i<Xsize;i++){
			if (V.getVx(i) > Vmax)
				V.setVx(i, Vmax);
			if (V.getVx(i) < -Vmax)
				V.setVx(i, -Vmax);
		}
		for(int i=0;i<Ysize;i++){
			if (V.getVy(i) > Vmax)
				V.setVy(i, Vmax);
			if (V.getVy(i) < -Vmax)
				V.setVy(i, -Vmax);
		}
		return V;
	}

	
/*	static void Update_p_f_cr( ) {
		
		// Update p、 f、cr
		
		
			if (successfulF.size() != 0){
				Collections.sort(successfulF);
				if (successfulF.size() % 2 != 0)
					f = successfulF.get((successfulF.size() + 1) / 2-1);
				else
					f = (successfulF.get(successfulF.size() / 2-1) + successfulF.get((successfulF.size() / 2) )) / 2;
			
			}else
				f = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
			
			if (successfulCR.size() != 0){
				Collections.sort(successfulCR);
				if (successfulCR.size() % 2 != 0)
					cr = successfulCR	.get((successfulCR.size() + 1) / 2-1);
				else
					cr = (successfulCR.get(successfulCR.size() / 2-1) + successfulCR.get((successfulCR.size() / 2) )) / 2;
			}else
				cr = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
			
	//	generationCount=0;
	//	susuccessfulF = new ArrayList<Double>();
	//	successfulCR = new ArrayList<Double>();
	}

	*/

	 static U_Individual Algorithm2(int j,Individual indiv,V_Individual P_indiv) {
			
			 
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
	 
	/* static void Algorithm3() {
			Random r = new Random();
			double c=DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
			while (c == 0.25 || c==0.5 || c==0.75) {
				c = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
			}
			
			
				for(int i=0;i<populationSize;i++){
					c=4*c*(1-c);
					F[i]=f+0.2*(c-0.5);
					while(F[i] >1.5 || F[i]<0){
						c=4*c*(1-c);
						F[i]=f+0.2*(c-0.5);
					}
				}
			
			
				for(int i=0;i<populationSize;i++){
					c=4*c*(1-c);
					CR[i]=cr+0.1*(c-0.5);
					while(CR[i] >1 || CR[i]<0){
						c=4*c*(1-c);
						CR[i]=cr+0.1*(c-0.5);
					}
				}
		}*/
	 
}
