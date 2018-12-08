package Algorithm_DoubleAuction.SaNSDE_DA_Problem3;

import java.util.ArrayList;
import java.util.Random;
 
public class Algorithm extends Double_Auction_SaNSDE_Problem3 {

	// Evolve a population 演變人口
	public static Population evolvePopulation(Population pop) {
		Population newPopulation = new Population(pop.size(), false);

		//計算F、CR
	//	Function.Algorithm3();
		strategy = new ArrayList<Integer>();
		// 突變V
		for (int i = 0; i < pop.size(); i++) {
			int r1 = 0, r2 = 0, r3 = 0;
			while (r1 == i || r2 == i || r3 == i ||  r1 == r2
					|| r1 == r3 ||  r2 == r3 || r1 == b || r2 == b || r3 ==b ) {// 取r1,r2,r3,r4
				r1 = DE_Read_Write_txt.random_generate_or_read2(Execution_Mode,populationSize);
				r2 = DE_Read_Write_txt.random_generate_or_read2(Execution_Mode,populationSize);
				r3 = DE_Read_Write_txt.random_generate_or_read2(Execution_Mode,populationSize);
			
			}
 
			Individual invid = pop.getIndividual(i);
			Individual invid1 = pop.getIndividual(r1);
			Individual invid2 = pop.getIndividual(r2);
			Individual invid3 = pop.getIndividual(r3);
			Individual invidb = pop.getIndividual(b);
			V_Individual newPinvid=new V_Individual();
			
			
			newPinvid =Function.Algorithm1_1(F[i], invid1, invid2, invid3,invid,invidb);
			
		
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
				if (rsid < R) {
					invid.setIntegerX(d,  (int)Math.floor(invid.getX(d)));
				} else {
					invid.setIntegerX(d,  (int)Math.ceil(invid.getX(d)));
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
				if (rsid <R) {
					Ginvid.setIntegerUx(d, (int)Math.floor(Ginvid.getUx(d)));
				} else {
					Ginvid.setIntegerUx(d, (int)Math.ceil(Ginvid.getUx(d)));
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
					invid.setIntegerX(d, Ginvid.getIntegerUx(d));
				}
					
				for(int d=0;d<invid.Ysize();d++){
					invid.setY(d, Ginvid.getUy(d));
					invid.setbinaryY(d, Ginvid.getbinaryUy(d));
				}
					
				
				if(strategy.get(i)==1)
					ns1+=1;
				else
					ns2+=1;
				
				CRrec.add(CR[i]);
				frec.add(Ginvid.getFitness1()-invid.getFitness1());
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
