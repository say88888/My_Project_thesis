package Algorithm_Carpool.DECC_POP;

import java.util.ArrayList;
 
 
public class Function extends DECC_POP{
	static V_Individual Algorithm1_1(int j,double F,Individual individual_r1,Individual individual_r2,Individual individual_r3,Individual individual,Individual individual_b) {

		V_Individual V=new V_Individual();
		if(DE_Read_Write_txt.random_generate_or_read1(Execution_Mode)<p){
			for (int k = 0; k < n3.get(j).size(); k++) {	//根據分群來計算V
				if (n3.get(j).get(k) < Xsize) {
					int g=n3.get(j).get(k);
					V.setVx(g, individual_r1.getX(g)+F*(individual_r2.getX(g)-individual_r3.getX(g)));
				} else {
					int g=n3.get(j).get(k) - Xsize;
					V.setVy(g, individual_r1.getY(g)+F*(individual_r2.getY(g)-individual_r3.getY(g)));
				}
			}
			
			nf1+=1;
			strategy.add(1);
		}else{
			for (int k = 0; k < n3.get(j).size(); k++) {	//根據分群來計算V
				if (n3.get(j).get(k) < Xsize) {
					int g=n3.get(j).get(k);
					V.setVx(g, individual.getX(g)+F*(individual_b.getX(g)-individual.getX(g))+F*(individual_r1.getX(g)-individual_r2.getX(g)));
				} else {
					int g=n3.get(j).get(k) - Xsize;
					V.setVy(g, individual.getY(g)+F*(individual_b.getY(g)-individual.getY(g))+F*(individual_r1.getY(g)-individual_r2.getY(g)));
				}
			}
	
			nf2+=1;
			strategy.add(3);
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

	 

	static void Update_p_f_cr( ) {
		 
		// Update p、 f、cr
		p=(ns1*(ns2+nf2))/(ns2*(ns1+nf1)+ns1*(ns2+nf2));	//計算p
		 
		//計算CR
		for(int i=0;i<populationSize;i++){
			double sum=0;
			for(int k=0;k<frec.size();k++)
				sum+=frec.get(k);
			double sum1=0;
			for(int k=0;k<CRrec.size();k++){
				double w=frec.get(k);
				w/=sum;
				sum1+=w*CRrec.get(k);
			}
			CRm=sum1;
			CR[i]=DE_Read_Write_txt.random_generate_or_read3(Execution_Mode)*0.1+CRm;
		 
			//計算F
			if(DE_Read_Write_txt.random_generate_or_read1(Execution_Mode)<p)
				F[i]=DE_Read_Write_txt.random_generate_or_read3(Execution_Mode)*0.3+0.5;
			else
				F[i]=(Math.tan(Math.PI*(DE_Read_Write_txt.random_generate_or_read5(Execution_Mode)-0.5)));
		}
		ns1=0;
		ns2=0;
		nf1=0;
		nf2=0;
		CRrec = new ArrayList<Double>();
		frec = new ArrayList<Double>();
	}

	

	 static U_Individual Algorithm2(int i,int j,Individual indiv,V_Individual P_indiv) {
			
		 	U_Individual U=new U_Individual();
		 
			for (int k = 0; k < n3.get(i).size(); k++) {	 
				if (n3.get(i).get(k) < Xsize) {	//根據分群來計算Ux
					int g=n3.get(i).get(k);
					if(DE_Read_Write_txt.random_generate_or_read1(Execution_Mode)<CR[j])
						U.setUx(g,P_indiv.getVx(g));
					else
						U.setUx(g, indiv.getX(g));
				} else {									//根據分群來計算Uxy
					int g=n3.get(i).get(k) - Xsize;
					if(DE_Read_Write_txt.random_generate_or_read1(Execution_Mode)<CR[j] )
						U.setUy(g,P_indiv.getVy(g));
					else
						U.setUy(g, indiv.getY(g));
				}
			}
 
			return U;
		}
	 
	
	 
}
