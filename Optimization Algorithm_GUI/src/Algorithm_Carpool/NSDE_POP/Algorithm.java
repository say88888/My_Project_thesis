package Algorithm_Carpool.NSDE_POP;

import java.util.Random;
 
public class Algorithm extends NSDE_POP {

	// Evolve a population 演變人口
	public static Population evolvePopulation(Population pop) {
		Population newPopulation = new Population(pop.size(), false);

		//計算F、CR
	//	Function.Algorithm3();
	
		// 突變V
		for (int i = 0; i < pop.size(); i++) {
			int r1 = 0, r2 = 0, r3 = 0;
			while (r1 == i || r2 == i || r3 == i ||  r1 == r2
					|| r1 == r3 ||  r2 == r3 ) {// 取r1,r2,r3,r4
				r1 = DE_Read_Write_txt.random_generate_or_read2(Execution_Mode,pop.size());
				r2 = DE_Read_Write_txt.random_generate_or_read2(Execution_Mode,pop.size());
				r3 = DE_Read_Write_txt.random_generate_or_read2(Execution_Mode,pop.size());
			
			}
 
			Individual invid = pop.getIndividual(i);
			Individual invid1 = pop.getIndividual(r1);
			Individual invid2 = pop.getIndividual(r2);
			Individual invid3 = pop.getIndividual(r3);
			
			V_Individual newPinvid=new V_Individual();
			
			
			newPinvid =Function.Algorithm1_1(F, invid1, invid2, invid3);
			
		
			//交叉U
			U_Individual newGinvid=new U_Individual();
			newGinvid=Function.Algorithm2(i, invid, newPinvid);
			newPopulation.saveU_Individual(i, newGinvid);
		 
		}
	
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
			}
			newPopulation.saveIndividual(i, invid);
		}
		
		return newPopulation;
	}
}
