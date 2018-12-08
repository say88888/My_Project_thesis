package Algorithm_Tourism.SaNSDE_Tourism;

 import java.util.ArrayList;
public class Algorithm extends SaNSDE_Tourism {

	// Evolve a population 演變人口
		public static Population evolvePopulation(Population pop)   {
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
					if(strategy.get(i)==1)
						ns1+=1;
					else
						ns2+=1;
					
					CRrec.add(CR[i]);
					frec.add(Ginvid.getFitness1()-invid.getFitness1());
				}
				newPopulation.saveIndividual(i, invid);
			}
			
			return newPopulation;
		}
	}
