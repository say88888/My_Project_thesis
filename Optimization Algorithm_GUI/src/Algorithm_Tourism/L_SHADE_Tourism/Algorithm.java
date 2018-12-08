package Algorithm_Tourism.L_SHADE_Tourism;

import java.util.List;
import java.util.Random;
 
public class Algorithm extends L_SHADE_Tourism {

	// Evolve a population 演變人口
	public static Population evolvePopulation(Population pop) {
		Population newPopulation = new Population(pop.size(), false);

		//計算F、CR
	//	Function.Algorithm3();
		
		// 突變V
		for (int i = 0; i < pop.size(); i++) {
 			int ri= DE_Read_Write_txt.random_generate_or_read2(Execution_Mode,H);
			CR[i]=DE_Read_Write_txt.random_generate_or_read3(Execution_Mode)*0.1+MCR[ri];
			F[i]=DE_Read_Write_txt.random_generate_or_read7(Execution_Mode)*0.1+MF[ri];
			double pmin=2.0/populationSize;
			double pi;
			if(pmin>0.2){
				 pi=DE_Read_Write_txt.random_generate_or_read5(Execution_Mode)*(pmin-0.2)+0.2;
			}else{
				 pi=DE_Read_Write_txt.random_generate_or_read5(Execution_Mode)*(0.2-pmin)+pmin;
			}
			
 			int r1 = 0, r2 = 0,pbest=0;
			while (r1 == i || r2 == i ||  r1 == r2 ) {// 取r1,r2,r3,r4
				pbest = DE_Read_Write_txt.random_generate_or_read2(Execution_Mode,(int)(populationSize*pi)+1);
				r1 = DE_Read_Write_txt.random_generate_or_read2(Execution_Mode,populationSize);
				r2 = DE_Read_Write_txt.random_generate_or_read2(Execution_Mode,populationSize+pop.getAsize());
				
			}

			Individual invid = pop.getIndividual(i);
			Individual invid1 = pop.getIndividual(r1);
			Individual invid2;
			if(r2<populationSize)
				invid2 = pop.getIndividual(r2);
			else
				invid2 = pop.getA_Individual(r2-populationSize);
			Individual invidpbest = pop.getIndividual(pbest);
			
			V_Individual newPinvid=new V_Individual();
			
			
			newPinvid =Function.Algorithm1_1(F[i],invid, invid1, invid2, invidpbest);
			
			//交叉U
			U_Individual newGinvid=new U_Individual();
			newGinvid=Function.Algorithm2(i, invid, newPinvid);
			newPopulation.saveU_Individual(i, newGinvid);
		 
		}	
		List<Individual> A=pop.getA( );
		//貪婪選擇
		for(int i=0;i<pop.size();i++){
		 
			U_Individual Ginvid=pop.getU_Individual(i);
			Individual invid = pop.getIndividual(i);
			
			for(int d=0;d<invid.Xasize();d++){
				double rsid = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
				if (rsid < 1 / (1 + Math.exp(-lamda*invid.getXa(d)))){
					invid.setbinaryXa(d, 1);
				}
				else{
					invid.setbinaryXa(d, 0);
				}
			}
			for(int d=0;d<invid.Xhsize();d++){
				double rsid = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
				if (rsid < 1 / (1 + Math.exp(-lamda*invid.getXh(d)))){
					invid.setbinaryXh(d, 1);
				}
				else{
					invid.setbinaryXh(d, 0);
				}
			}
			for(int d=0;d<invid.Xtsize();d++){
				double rsid = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
				if (rsid < 1 / (1 + Math.exp(-lamda*invid.getXt(d)))){
					invid.setbinaryXt(d, 1);
				}
				else{
					invid.setbinaryXt(d, 0);
				}
			}
			for(int d=0;d<invid.Ysize();d++){
				double rsid = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
				if (rsid < 1 / (1 + Math.exp(-lamda*invid.getY(d)))){
					invid.setbinaryY(d, 1);
				}
				else{
					invid.setbinaryY(d, 0);
				}
			}
			
			for(int d=0;d<Ginvid.Uxasize();d++){
				double rsid = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
				if (rsid < 1 / (1 + Math.exp(-lamda*Ginvid.getUxa(d)))){
					Ginvid.setbinaryUxa(d, 1);
				}
				else{
					Ginvid.setbinaryUxa(d, 0);
				}
			}
			for(int d=0;d<Ginvid.Uxhsize();d++){
				double rsid = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
				if (rsid < 1 / (1 + Math.exp(-lamda*Ginvid.getUxh(d)))){
					Ginvid.setbinaryUxh(d, 1);
				}
				else{
					Ginvid.setbinaryUxh(d, 0);
				}
			}
			for(int d=0;d<Ginvid.Uxtsize();d++){
				double rsid = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
				if (rsid < 1 / (1 + Math.exp(-lamda*Ginvid.getUxt(d)))){
					Ginvid.setbinaryUxt(d, 1);
				}
				else{
					Ginvid.setbinaryUxt(d, 0);
				}
			}
			for(int d=0;d<Ginvid.Uysize();d++){
				
				double rsid = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
				if (rsid < 1 / (1 + Math.exp(-lamda*Ginvid.getUy(d)))){
					Ginvid.setbinaryUy(d, 1);
				}
				else{
					Ginvid.setbinaryUy(d, 0);
				}
			}
			
			if(Ginvid.getFitness1()>invid.getFitness1()){
				A.add(invid);
				SCR.add(CR[i]);
				SF.add(F[i]);
				for(int d=0;d<invid.Xasize();d++){
					invid.setXa(d, Ginvid.getUxa(d));
					invid.setbinaryXa(d, Ginvid.getbinaryUxa(d));
				}
				for(int d=0;d<invid.Xhsize();d++){
					invid.setXh(d, Ginvid.getUxh(d));
					invid.setbinaryXh(d, Ginvid.getbinaryUxh(d));
				}
				for(int d=0;d<invid.Xtsize();d++){
					invid.setXt(d, Ginvid.getUxt(d));
					invid.setbinaryXt(d, Ginvid.getbinaryUxt(d));
				}
				for(int d=0;d<invid.Ysize();d++){
					invid.setY(d, Ginvid.getUy(d));
					invid.setbinaryY(d, Ginvid.getbinaryUy(d));
				}
				
				ferc.add(Math.abs(Ginvid.getFitness1()-invid.getFitness1()));
				
			}
			newPopulation.saveIndividual(i, invid);
			
		}
		while(A.size()>populationSize){
			A.remove(DE_Read_Write_txt.random_generate_or_read2(Execution_Mode,A.size()));
		}
		newPopulation.saveA_Individual(A);
		 
		Function.Update_MCR_MF();
		if( Function.Update_NP()==true){
			Individual tmp=new Individual();
			for (int i=populationSize-1;i>=0;i=i-1)
			{
				for (int j=0;j<i;j=j+1)
				{
					Individual a=newPopulation.getIndividual(j);
					Individual a2=newPopulation.getIndividual(i);
					if (a.getFitness1()<a2.getFitness1()) 
					{
						tmp=a;
						newPopulation.saveIndividual(j, a2);
						newPopulation.saveIndividual(i, tmp);
					}
				}
			}	 
			
			while(A.size()>populationSize){
				A.remove(DE_Read_Write_txt.random_generate_or_read2(Execution_Mode,A.size()));
			}
			newPopulation.saveA_Individual(A);
		}
		
		return newPopulation;
	}
}
