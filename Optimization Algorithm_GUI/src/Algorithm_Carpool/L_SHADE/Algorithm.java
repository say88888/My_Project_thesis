package Algorithm_Carpool.L_SHADE;

import java.util.List;
import java.util.Random;

 
public class Algorithm extends L_SHADE {

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
		

			int r1 = 0, r2 = 0, pbest = 0;
			while (r1 == i || r2 == i  ||  r1 == r2) {// 取r1,r2,r3,r4
				r1 = DE_Read_Write_txt.random_generate_or_read2(Execution_Mode,populationSize);
				r2 = DE_Read_Write_txt.random_generate_or_read2(Execution_Mode,populationSize+pop.getAsize());
				pbest = DE_Read_Write_txt.random_generate_or_read2(Execution_Mode,(int)(populationSize*pi)+1);
			}
 
			Individual invid = pop.getIndividual(i);
			Individual invid1 = pop.getIndividual(r1);
			Individual invid2 ;
			if(r2<populationSize)
				invid2=pop.getIndividual(r2);
			else
				invid2=pop.getA_Individual(r2-populationSize);
			Individual invidpbest = pop.getIndividual(pbest);
			
			V_Individual newPinvid=new V_Individual();
			
			
			newPinvid =Function.Algorithm1_1(F[i],invid,invid1, invid2, invidpbest);
			
		
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
			
			for(int d=0;d<invid.Xsize();d++){
				double rsid = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
				if (rsid < 1 / (1 + Math.exp(-lamda*invid.getX(d)))){
					invid.setbinaryX(d, 1);
				}
				else{
					invid.setbinaryX(d, 0);
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
			
			for(int d=0;d<Ginvid.Uxsize();d++){
				double rsid = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
				if (rsid < 1 / (1 + Math.exp(-lamda*Ginvid.getUx(d)))){
					Ginvid.setbinaryUx(d, 1);
				}
				else{
					Ginvid.setbinaryUx(d, 0);
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
				
				for(int d=0;d<invid.Xsize();d++){
					invid.setX(d, Ginvid.getUx(d));
					invid.setbinaryX(d, Ginvid.getbinaryUx(d));
				}
					
				for(int d=0;d<invid.Ysize();d++){
					invid.setY(d, Ginvid.getUy(d));
					invid.setbinaryY(d, Ginvid.getbinaryUy(d));
				}
			/*	if(!successfulF.contains(F[i]))
					successfulF.add(F[i]);
				if(!successfulCR.contains(CR[i]))
					successfulCR.add(CR[i]);*/
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
