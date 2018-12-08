package Algorithm_DoubleAuction.L_SHADE_CCPSO2_DA;

public class Algorithm extends Double_Auction_L_SHADE_CCPSO2 {
 
	// Evolve a population 演變人口
	public static Population evolvePopulation(Population pop) {

		Population newPopulation = new Population(pop.size(), false);

		E_Individual Einvid = pop.getE_Individual();
		newPopulation.saveE_Individual(Einvid);	 

		for (int j = 0; j < n3.size(); j++) {
			for (int i = 0; i < pop.size(); i++) {
				
				Individual invid = pop.getIndividual(i);
				P_Individual Pinvid = pop.getP_Individual(i);
				G_Individual Ginvid = pop.getG_Individual();
				
				Individual newinvid = new Individual();
				P_Individual newPinvid = new P_Individual();
				
				for(int d=0;d<Xsize;d++){
					newinvid.setX(d, Ginvid.getGx(d));
					newPinvid.setPx(d, Ginvid.getGx(d));
					if(Omega2==1 || Omega3==1){
						newinvid.setrs(d, Ginvid.getGrs(d));
						newPinvid.setPrs(d, Ginvid.getGrs(d));
					}
				}
				for(int d=0;d<Ysize;d++){
					newinvid.setY(d, Ginvid.getGy(d));
					newPinvid.setPy(d, Ginvid.getGy(d));
					if(Omega2==1 || Omega3==1){
						newinvid.setrb(d, Ginvid.getGrb(d));
						newPinvid.setPrb(d, Ginvid.getGrb(d));
					}
				}
				if(Omega4==1){
					newinvid.setr(Ginvid.getGr());
					newPinvid.setPr(Ginvid.getGr());
				}
					
 				for(int k=0;k<n3.get(j).size();k++){
					if(n3.get(j).get(k)<Xsize){
						for(int d=0;d<Xsize;d++){
							if(d == n3.get(j).get(k)){
								newinvid.setX(d, invid.getX(d));
								newPinvid.setPx(d, Pinvid.getPx(d));
							}
						}
					}else if(n3.get(j).get(k)<Xsize+Ysize){
						for(int d=0;d<Ysize;d++){
							if(d == n3.get(j).get(k)-Xsize){
								newinvid.setY(d, invid.getY(d));
								newPinvid.setPy(d, Pinvid.getPy(d));
							}
						}
					}
					if(Omega2==1 || Omega3==1){
						if(n3.get(j).get(k)>=Xsize+Ysize && n3.get(j).get(k)<2*Xsize+Ysize){
							for(int d=0;d<Xsize;d++){
								if(d == n3.get(j).get(k)-Xsize+Ysize){
									newinvid.setrs(d, invid.getrs(d));
									newPinvid.setPrs(d, Pinvid.getPrs(d));
								}
							}
						}else if(n3.get(j).get(k)>=2*Xsize+Ysize ){
							for(int d=0;d<Ysize;d++){
								if(d == n3.get(j).get(k)-2*Xsize+Ysize){
									newinvid.setrb(d, invid.getrb(d));
									newPinvid.setPrb(d, Pinvid.getPrb(d));
								}
							}
							
						}
					}
					if(Omega4==1){
						if(n3.get(j).get(k)>=Xsize+Ysize ){
							newinvid.setr(invid.getr());
							newPinvid.setPr( Pinvid.getPr());
						}
					}
				}
				if(newinvid.getFitness()>newPinvid.getFitness()){
					SAlpha1.add(Alpha1[i]);
					SAlpha2.add(Alpha2[i]);
					SAlpha3.add(Alpha3[i]);
					ferc.add(Math.abs(newinvid.getFitness()-newPinvid.getFitness()));
					for (int k = 0; k < n3.get(j).size(); k++) {
						if (n3.get(j).get(k) < Xsize) {
							for (int d = 0; d < Xsize; d++)						//如果F(b(j,Pj.xi)) > F(b(j,Pj.yi))時
								if(d == n3.get(j).get(k))
									newPinvid.setPx(d, newinvid.getX(d));							//b(j,Pj.xi))取代b(j<Pj.yi)
						} else if(n3.get(j).get(k)<Xsize+Ysize){
							for (int d = 0; d < Ysize; d++)
								if (d == n3.get(j).get(k) - Xsize) 
									newPinvid.setPy(d, newinvid.getY(d));
						}
						if(Omega2==1 || Omega3==1){
							if(n3.get(j).get(k)>=Xsize+Ysize && n3.get(j).get(k)<2*Xsize+Ysize){
								for(int d=0;d<Xsize;d++)
									if(d == n3.get(j).get(k)-Xsize+Ysize)
										newPinvid.setPrs(d,newinvid.getrs(d));
							}else if(n3.get(j).get(k)>=2*Xsize+Ysize ){
								for(int d=0;d<Ysize;d++)
									if(d == n3.get(j).get(k)-2*Xsize+Ysize)
										newPinvid.setPrb(d, newinvid.getrb(d));
							}
						}
						if(Omega4==1){
							if(n3.get(j).get(k)>=Xsize+Ysize )
								newPinvid.setPr( newinvid.getr());
						}
					}
					
				}
				newPopulation.saveP_Individual(i, newPinvid);
				P_Individual Pinvid1 = pop.getP_Individual(i);
				P_Individual newPinvid1 = new P_Individual();
				for(int d=0;d<Xsize;d++){
					newPinvid1.setPx(d, Ginvid.getGx(d));
					if(Omega2==1 || Omega3==1){
						newPinvid1.setPrs(d, Ginvid.getGrs(d));
					}
				}
				for(int d=0;d<Ysize;d++){
					newPinvid1.setPy(d, Ginvid.getGy(d));
					if(Omega2==1 || Omega3==1){
						newPinvid1.setPrb(d, Ginvid.getGrb(d));
					}
				}
				if(Omega4==1){
					newPinvid1.setPr(Ginvid.getGr());
				}
				
 				for(int k=0;k<n3.get(j).size();k++){
					if(n3.get(j).get(k)<Xsize){
						for(int d=0;d<Xsize;d++){
							if(d == n3.get(j).get(k)){
								newPinvid1.setPx(d, Pinvid1.getPx(d));
							}
						}
					}else if(n3.get(j).get(k)<Xsize+Ysize){
						for(int d=0;d<Ysize;d++){
							if(d == n3.get(j).get(k)-Xsize){
								newPinvid1.setPy(d, Pinvid1.getPy(d));
							}
						}
					}
					if(Omega2==1 || Omega3==1){
						if(n3.get(j).get(k)>=Xsize+Ysize && n3.get(j).get(k)<2*Xsize+Ysize){
							for(int d=0;d<Xsize;d++){
								if(d == n3.get(j).get(k)-Xsize+Ysize){
									newPinvid1.setPrs(d, Pinvid1.getPrs(d));
								}
							}
						}else if(n3.get(j).get(k)>=2*Xsize+Ysize ){
							for(int d=0;d<Ysize;d++){
								if(d == n3.get(j).get(k)-2*Xsize+Ysize){
									newPinvid1.setPrb(d, Pinvid1.getPrb(d));
								}
							}
						}
					}
					if(Omega4==1){
						if(n3.get(j).get(k)>=Xsize+Ysize ){
							newPinvid1.setPr( Pinvid1.getPr());
						}
					}
				} 
				if (newPinvid1.getFitness() > Ginvid.getFitness1()) {		//比較F(b(j,Pj.yi)) > F(b(j,Pj.^yi))
					for (int k = 0; k < n3.get(j).size(); k++) {
						if (n3.get(j).get(k) < Xsize) {
							for (int d = 0; d < Xsize; d++)						//如果F(b(j,Pj.xi)) > F(b(j,Pj.yi))時
								if(d == n3.get(j).get(k))
									Ginvid.setGx(d, newPinvid1.getPx(d));							//b(j,Pj.xi))取代b(j<Pj.yi)
						} else if(n3.get(j).get(k)<Xsize+Ysize){
							for (int d = 0; d < Ysize; d++)
								if (d == n3.get(j).get(k) - Xsize) 
									Ginvid.setGy(d, newPinvid1.getPy(d));
						}
						if(Omega2==1 || Omega3==1){
							if(n3.get(j).get(k)>=Xsize+Ysize && n3.get(j).get(k)<2*Xsize+Ysize){
								for(int d=0;d<Xsize;d++)
									if(d == n3.get(j).get(k)-Xsize+Ysize)
										Ginvid.setGrs(d, newPinvid1.getPrs(d));
							}else if(n3.get(j).get(k)>=2*Xsize+Ysize ){
								for(int d=0;d<Ysize;d++)
									if(d == n3.get(j).get(k)-2*Xsize+Ysize)
										Ginvid.setGrb(d, newPinvid1.getPrb(d));
							}
						}
						if(Omega4==1){
							if(n3.get(j).get(k)>=Xsize+Ysize ){
								Ginvid.setGr( newPinvid1.getPr());
							}
						}
					}
				}
				newPopulation.saveG_Individual(Ginvid);
				
			}
		}
			Function.Update_Alpha();
			
			if (Print_Mode == 1)
				System.out.println("進行更改 速度跟粒子");

			for (int i = 0; i < pop.size(); i++) {
				Individual invid = pop.getIndividual(i);
				V_Individual Vinvid = pop.getV_Individual(i);
				P_Individual Pinvid = pop.getP_Individual(i);
				G_Individual Ginvid = pop.getG_Individual();
				int rr=PSO_Read_Write_txt.random_generate_or_read5(Execution_Mode, H);
				Alpha1[i]=PSO_Read_Write_txt.random_generate_or_read3(Execution_Mode)*0.1+MAlpha1[rr];
				Alpha2[i]=PSO_Read_Write_txt.random_generate_or_read3(Execution_Mode)*0.1+MAlpha2[rr];
				Alpha3[i]=PSO_Read_Write_txt.random_generate_or_read3(Execution_Mode)*0.1+MAlpha3[rr];

				for (int d = 0; d < Vinvid.Vxsize(); d++) {	//變更X速度
					if (Print_Mode == 1)
						System.out.print("Vx=" + Vinvid.getVx(d) + " ");
					Vinvid.setVx(d,PSO_Read_Write_txt.random_generate_or_read3(Execution_Mode)*Alpha3[i]
							*Math.abs(Pinvid.getPx(d)-Ginvid.getGx(d))+(Alpha1[i]*Pinvid.getPx(d)+Alpha2[i]*Ginvid.getGx(d)));
					if (Vinvid.getVx(d) > Vmax)
						Vinvid.setVx(d, Vmax);
					if (Vinvid.getVx(d) < -Vmax)
						Vinvid.setVx(d, -Vmax);
					if (Print_Mode == 1)
						System.out.println("改為 Vx=" + Vinvid.getVx(d) + " ");
					if(Omega2==1 || Omega3==1){
						Vinvid.setVrs(d,w*Vinvid.getVrs(d)+c1*PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode)
								*(Pinvid.getPrs(d)-invid.getrs(d))+c2*PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode)
								*(Ginvid.getGrs(d)-invid.getrs(d)));
					//	Vinvid.setVrs(d,PSO_Read_Write_txt.random_generate_or_read3(Execution_Mode)*Alpha3*Math.abs(Pinvid.getPrs(d)-Ginvid.getGrs(d))+(Alpha1*Pinvid.getPrs(d)+Alpha2*Ginvid.getGrs(d)));
						if(Vinvid.getVrs(d)> 1.0)
							Vinvid.setVrs(d,1.0);
						if(Vinvid.getVrs(d)<-1)
							Vinvid.setVrs(d,-1);
					}
				}

				for (int d = 0; d < Vinvid.Vysize(); d++) {	//變更Y速度
					if (Print_Mode == 1)
						System.out.print("Vy=" + Vinvid.getVy(d) + " ");
					Vinvid.setVy(d,PSO_Read_Write_txt.random_generate_or_read3(Execution_Mode)*Alpha3[i]
							*Math.abs(Pinvid.getPy(d)-Ginvid.getGy(d))+(Alpha1[i]*Pinvid.getPy(d)+Alpha2[i]*Ginvid.getGy(d)));
					if (Vinvid.getVy(d) > Vmax)
						Vinvid.setVy(d, Vmax);
					if (Vinvid.getVy(d) < -Vmax)
						Vinvid.setVy(d, -Vmax);
					if (Print_Mode == 1)
						System.out.println("改為 Vy=" + Vinvid.getVy(d) + " ");
					if(Omega2==1 || Omega3==1){
						Vinvid.setVrb(d,w*Vinvid.getVrb(d)+c1*PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode)
								*(Pinvid.getPrb(d)-invid.getrb(d))+c2*PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode)
								*(Ginvid.getGrb(d)-invid.getrb(d)));
				//		Vinvid.setVrb(d,PSO_Read_Write_txt.random_generate_or_read3(Execution_Mode)*Alpha3*Math.abs(Pinvid.getPrb(d)-Ginvid.getGrb(d))+(Alpha1*Pinvid.getPrb(d)+Alpha2*Ginvid.getGrb(d)));
						if(Vinvid.getVrb(d)> 1.0)
							Vinvid.setVrb(d,1.0);
						if(Vinvid.getVrb(d)<-1)
							Vinvid.setVrb(d,-1);
					}
				}
				if(Omega4==1){
					Vinvid.setVr(w*Vinvid.getVr()+c1*PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode)
							*(Pinvid.getPr()-invid.getr())+c2*PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode)
							*(Ginvid.getGr()-invid.getr()));
				//	Vinvid.setVr(PSO_Read_Write_txt.random_generate_or_read3(Execution_Mode)*Alpha3*Math.abs(Pinvid.getPr()-Ginvid.getGr())+(Alpha1*Pinvid.getPr()+Alpha2*Ginvid.getGr()));
					if(Vinvid.getVr()> 1.0)
						Vinvid.setVr(1.0);
					if(Vinvid.getVr()<-1)
						Vinvid.setVr(-1);
				}
				newPopulation.saveV_Individual(i, Vinvid);
			}
			if (Print_Mode == 1)
				System.out.println("變更粒子");
			for (int i = 0; i < pop.size(); i++) {
				Individual invid = pop.getIndividual(i);
				V_Individual Vinvid = pop.getV_Individual(i);
				P_Individual Pinvid = pop.getP_Individual(i);
				G_Individual Ginvid = pop.getG_Individual();
				if (Print_Mode == 1)
					System.out.println("第" + i + "個");
				for (int d = 0; d < invid.Xsize(); d++) {		//變更X粒子
					double rsid = PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode);
					if (Print_Mode == 1) {
						System.out.print("rsid=" + rsid);
						System.out.println(" S(Vx)=" + 1	/ (1 + Math.exp(-PSO_lamda*Vinvid.getVx(d))));
					}
					if (rsid < 1 / (1 + Math.exp(-PSO_lamda*Vinvid.getVx(d)))) {
						if (Print_Mode == 1)
							System.out.print("rsid<S(Vx)  X為1");
						invid.setX(d, 1);
					} else {
						if (Print_Mode == 1)
							System.out.print("rsid>=S(Vx)  X為0");
						invid.setX(d, 0);
					}
					if (Print_Mode == 1)
						System.out.println();
					
					 if(Omega2==1 || Omega3==1){
						 invid.setrs(d, Vinvid.getVrs(d)+invid.getrs(d));
						
					 }
				}
				for (int d = 0; d < invid.Ysize(); d++) {	//變更Y粒子
					double rsid = PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode);
					if (Print_Mode == 1) {
						System.out.print("rsid=" + rsid);
						System.out.println(" S(Vy)=" + 1	/ (1 + Math.exp(-PSO_lamda*Vinvid.getVy(d))));
					}
					if (rsid < 1 / (1 + Math.exp(-PSO_lamda*Vinvid.getVy(d)))) {
						if (Print_Mode == 1)
							System.out.print("rsid<S(Vy)  Y為1");
						invid.setY(d, 1);
					} else {
						if (Print_Mode == 1)
							System.out.print("rsid>=S(Vy)  Y為0");
						invid.setY(d, 0);
					}
					if (Print_Mode == 1)
						System.out.println();
					 if(Omega2==1 || Omega3==1){
						 invid.setrb(d, Vinvid.getVrb(d)+invid.getrb(d));	
					 }					 
				}
				 if(Omega4==1 )
					 invid.setr(Vinvid.getVr()+invid.getr());
				 
				newPopulation.saveIndividual(i, invid);
			}
		
		return newPopulation;
	}

}
