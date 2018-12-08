package Algorithm_DoubleAuction.SaNSDE_DA;

import java.util.ArrayList;
 
 
public class Function extends Double_Auction_SaNSDE{
	static V_Individual Algorithm1_1(double F,Individual individual_r1,Individual individual_r2,Individual individual_r3,Individual individual,Individual individual_b) {
		
		V_Individual V=new V_Individual();
		if(DE_Read_Write_txt.random_generate_or_read1(Execution_Mode)<p){
			for(int i=0;i<Xsize;i++)
				V.setVx(i, individual_r1.getX(i)+F*(individual_r2.getX(i)-individual_r3.getX(i)));
			for(int i=0;i<Ysize;i++)
				V.setVy(i, individual_r1.getY(i)+F*(individual_r2.getY(i)-individual_r3.getY(i)));
			nf1+=1;
			strategy.add(1);
		}else{
			for(int i=0;i<Xsize;i++)
				V.setVx(i, individual.getX(i)+F*(individual_b.getX(i)-individual.getX(i))+F*(individual_r1.getX(i)-individual_r2.getX(i)));
			for(int i=0;i<Ysize;i++)
				V.setVy(i, individual.getY(i)+F*(individual_b.getY(i)-individual.getY(i))+F*(individual_r1.getY(i)-individual_r2.getY(i)));
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
		p=(ns1*(ns2+nf2))/(ns2*(ns1+nf1)+ns1*(ns2+nf2));
		 
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

	

	 static U_Individual Algorithm2(int j,Individual indiv,V_Individual P_indiv) {
			
			 
			int a= DE_Read_Write_txt.random_generate_or_read2(Execution_Mode,Xsize);
			
			U_Individual U=new U_Individual();
			for(int i=0;i<Xsize;i++)
				U.setUx(i, indiv.getX(i));
			for(int i=0;i<Ysize;i++)
				U.setUy(i, indiv.getY(i));
			
			for(int i=0;i<Xsize;i++)
				if(DE_Read_Write_txt.random_generate_or_read1(Execution_Mode)<CR[j] || i==a)
					U.setUx(i,P_indiv.getVx(i));
				
			  a= DE_Read_Write_txt.random_generate_or_read2(Execution_Mode,Ysize);
			for(int i=0;i<Ysize;i++)
				if(DE_Read_Write_txt.random_generate_or_read1(Execution_Mode)<CR[j] || i==a)
					U.setUy(i,P_indiv.getVy(i));
			
			return U;
		}
	 
	
	 
}
