package Algorithm_Carpool.APSO1;


public class Algorithm extends APSO1 {

	private static double[] di;
	private static double dg,dmax,dmin,f;
	// Evolve a population 演變人口
	public static Population evolvePopulation(Population pop) {
		Population newPopulation = new Population(pop.size(), false);
		if(Print_Mode==1){
			System.out.println("比較F(X,Y)  F(Px,Py)");
		}
		E_Individual Einvid = pop.getE_Individual( );
		//System.err.println(Einvid.Exsize());
		newPopulation.saveE_Individual(  Einvid);
		if(Adaptive_Mode_1==1)
		AdaptivePSO(pop,newPopulation);
		if(Adaptive_Mode_2==1)
		Adaptive2PSO(pop,newPopulation);
		for (int i = 0; i < pop.size(); i++) {

			Individual invid = pop.getIndividual(i);
			P_Individual Pinvid = pop.getP_Individual(i);
			if(Print_Mode==0){
				if (invid.getFitness() > Pinvid.getFitness()) {
					for (int d = 0; d < invid.Xsize(); d++)
						Pinvid.setPx(d, invid.getX(d));
					for (int d = 0; d < invid.Ysize(); d++)
						Pinvid.setPy(d, invid.getY(d));
				}
			}else{
				System.out.print("第"+i+"個 " );
				System.out.print(" X=");
				for (int d = 0; d < invid.Xsize(); d++)
					System.out.print(invid.getX(d));
				System.out.print(" Y=");
				for (int d = 0; d < invid.Ysize(); d++)
					System.out.print(invid.getY(d));
				System.out.print(" Px=");
				for(int d=0;d<Pinvid.Pxsize();d++)
					System.out.print(Pinvid.getPx(d));
				System.out.print(" Py=");
				for(int d=0;d<Pinvid.Pysize();d++)
					System.out.print(Pinvid.getPy(d));
				
				if (invid.getFitness() > Pinvid.getFitness()) {	
					System.out.println(" F(X,Y)="+invid.getFitness()+" F(Px,Py)="+Pinvid.getFitness()+"F(X,Y)>F(Px,Py) Px=X,Py=Y" );
					for (int d = 0; d < invid.Xsize(); d++)
						Pinvid.setPx(d, invid.getX(d));
					for (int d = 0; d < invid.Ysize(); d++)
						Pinvid.setPy(d, invid.getY(d));
					
				}else{
					System.out.println(" F(X,Y)="+invid.getFitness()+" F(Px,Py)="+Pinvid.getFitness()+" F(X,Y) <= F(Px,Py) Px,Py不變");					
				}
			}
			newPopulation.saveP_Individual(i, Pinvid);
		}
		if(Print_Mode==1)
			System.out.println("比較F(Px,Py) F(Gx,Gy)");
		for (int j = 0; j < pop.size(); j++) {
			G_Individual Ginvid = pop.getG_Individual();
			P_Individual Pinvid1 = pop.getP_Individual(j);
			if(Print_Mode==0){
				if (Pinvid1.getFitness() > Ginvid.getFitness1()) {
					for (int d = 0; d < Ginvid.Gxsize(); d++)
						Ginvid.setGx(d, Pinvid1.getPx(d));
					for (int d = 0; d < Ginvid.Gysize(); d++)
						Ginvid.setGy(d, Pinvid1.getPy(d));
				}
			}else{
				System.out.print("第"+j+"個 " );
				System.out.print(" Px=");
				for (int d = 0; d < Pinvid1.Pxsize(); d++)
					System.out.print(Pinvid1.getPx(d));
				System.out.print(" Py=");
				for (int d = 0; d < Pinvid1.Pysize(); d++)
					System.out.print(Pinvid1.getPy(d));
				System.out.print(" Gx=");
				for(int d=0;d<Ginvid.Gxsize();d++)
					System.out.print(Ginvid.getGx(d));
				System.out.print(" Gy=");
				for(int d=0;d<Ginvid.Gysize();d++)
					System.out.print(Ginvid.getGy(d));
				if (Pinvid1.getFitness() > Ginvid.getFitness1()) {
					System.out.println(" F(Px,Py)="+Pinvid1.getFitness()+" F(Gx,Gy)="+Ginvid.getFitness1()+"F(Px,Py)>F(Gx,Gy) Gx=Px,Gy=Py" );
					for (int d = 0; d < Ginvid.Gxsize(); d++)
						Ginvid.setGx(d, Pinvid1.getPx(d));
					for (int d = 0; d < Ginvid.Gysize(); d++)
						Ginvid.setGy(d, Pinvid1.getPy(d));
				}
				else{
					System.out.println(" F(Px,Py)="+Pinvid1.getFitness()+" F(Gx,Gy)="+Ginvid.getFitness1()+" F(Px,Py) <= F(Gx,Gy) Gx,Gy不變");					
				}
			}
			newPopulation.saveG_Individual(Ginvid);
		}
		if(Print_Mode==1)
			System.out.println("進行更改 速度跟粒子");
			
		for (int i = 0; i < pop.size(); i++) {
			Individual invid = pop.getIndividual(i);
			V_Individual Vinvid = pop.getV_Individual(i);
			P_Individual Pinvid = pop.getP_Individual(i);
			G_Individual Ginvid = pop.getG_Individual();
			double r1 = PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode);
			double r2 = PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode);
			if(Print_Mode==1){
				System.out.println("第"+i+"個");
				System.out.println("r1="+r1+"  r2="+r2+" w="+w+" c1="+c1+" c2="+c2);
				}
			for (int d = 0; d < Vinvid.Vxsize(); d++) {
				if(Print_Mode==1)
					System.out.print("Vx="+Vinvid.getVx(d)+" ");
				Vinvid.setVx(d,w * Vinvid.getVx(d)+ (c1 * r1 * (Pinvid.getPx(d) - invid.getX(d)))+ c2 * r2 * (Ginvid.getGx(d) - invid.getX(d)));
				if (Vinvid.getVx(d) > Vmax)
					Vinvid.setVx(d, Vmax);
				if (Vinvid.getVx(d) < -Vmax)
					Vinvid.setVx(d, -Vmax);
				if(Print_Mode==1)
					System.out.println("改為 Vx="+Vinvid.getVx(d)+" ");
				
			}

			for (int d = 0; d < Vinvid.Vysize(); d++) {
				if(Print_Mode==1)
					System.out.print("Vy="+Vinvid.getVy(d)+" ");
				Vinvid.setVy(d,w * Vinvid.getVy(d)+ (c1 * r1 * (Pinvid.getPy(d) - invid.getY(d)))+ c2 * r2 * (Ginvid.getGy(d) - invid.getY(d)));
				if (Vinvid.getVy(d) > Vmax)
					Vinvid.setVy(d, Vmax);
				if (Vinvid.getVy(d) < -Vmax)
					Vinvid.setVy(d, -Vmax);
				if(Print_Mode==1)
					System.out.println("改為 Vy="+Vinvid.getVy(d)+" ");
			}
			newPopulation.saveV_Individual(i, Vinvid);
		}
		if(Print_Mode==1)
			System.out.println("變更粒子");
		for(int i=0;i<pop.size();i++){
			Individual invid = pop.getIndividual(i);
			V_Individual Vinvid = pop.getV_Individual(i);
			P_Individual Pinvid = pop.getP_Individual(i);
			G_Individual Ginvid = pop.getG_Individual();
			if(Print_Mode==1)
				System.out.println("第"+i+"個");
			for(int d=0;d<invid.Xsize();d++){
			double rsid = PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode);
			if(Print_Mode==1){
				System.out.print("rsid="+rsid  );
				System.out.println(" S(Vx)="+1 / (1 + Math.exp(-PSO_lamda*Vinvid.getVx(d))) );
			}
			if (rsid < 1 / (1 + Math.exp(-PSO_lamda*Vinvid.getVx(d)))){
				if(Print_Mode==1)
					System.out.print("rsid<S(Vx)  X為1");
				invid.setX(d, 1);
			}
			else{
				if(Print_Mode==1)
					System.out.print("rsid>=S(Vx)  X為0");
				invid.setX(d, 0);
			}
			 if(Print_Mode==1)
				 System.out.println();
 
		}
			for(int d=0;d<invid.Ysize();d++){
				double rsid = PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode);
				if(Print_Mode==1){
					System.out.print("rsid="+rsid  );
					System.out.println(" S(Vy)="+1 / (1 + Math.exp(-PSO_lamda*Vinvid.getVy(d)))  );
				}
				if (rsid < 1 / (1 + Math.exp(-PSO_lamda*Vinvid.getVy(d)))){
					if(Print_Mode==1)
						System.out.print("rsid<S(Vy)  Y為1");
					invid.setY(d, 1);
				}
				else{
					if(Print_Mode==1)
						System.out.print("rsid>=S(Vy)  Y為0");
					invid.setY(d, 0);
				}
				 if(Print_Mode==1)
					 System.out.println();
			}newPopulation.saveIndividual(i, invid);
		}
		return newPopulation;
	}
	
	static Population AdaptivePSO(Population pop, Population newPopulation){
		  di=new double[pop.size()];
		for(int i=0;i<pop.size();i++){
			double s=0;
			Individual invid = pop.getIndividual(i);
			for(int j=0;j<pop.size();j++){
				if(i!=j){
				Individual invid2 = pop.getIndividual(j);
				double s1=0;
				
					for(int k=0;k<invid.Xsize();k++)
						s1+=Math.pow((invid.getX(k)-invid2.getX(k)),2);
					for(int k=0;k<invid.Ysize();k++)
						s1+=Math.pow((invid.getY(k)-invid2.getY(k)),2);
					s+=Math.sqrt(s1);
				}
			}
			di[i]=(s/(pop.size()-1)) ;
		}
		
		  dmax=di[0];
		  dmin=di[0];
		for(int i=0;i<pop.size();i++){
			if(di[i]>=dmax)
				dmax=di[i];
			if(di[i]<=dmin)
				dmin=di[i];
		}
		
	 
		Individual invid1 = pop.getIndividual(0);
		double m=invid1.getFitness();
		int n=0;
		for (int i = 0; i < pop.size(); i++) {
			Individual invid = pop.getIndividual(i);
				if (invid.getFitness() >= m) {
					m=invid.getFitness();
					n=i;
				}
		}
		
		double s=0;
		//G_Individual Ginvid = pop.getG_Individual();
		Individual invid = pop.getIndividual(n);
		for(int j=0;j<pop.size();j++){
			Individual invid2 = pop.getIndividual(j);
			double s1=0;
				if(j!=n){
				for(int k=0;k<invid.Xsize();k++)
					s1+=Math.pow((invid.getX(k)-invid2.getX(k)),2);
				for(int k=0;k<invid.Ysize();k++)
					s1+=Math.pow((invid.getY(k)-invid2.getY(k)),2);
				s+=Math.sqrt(s1);
			}
		}
		dg=(s/(pop.size()-1)) ;
		
		System.err.println("dg="+dg+" dmax= "+dmax+" dmin= "+dmin+" ");
		f=(dg-dmin)/(dmax-dmin);
		System.err.print(" f= "+ f+" ");
		 
		w=1/(1+1.5*Math.exp(-2.6*f));
		System.err.print("w= "+w+" ");
		if(Us1(f)>Us2(f) && Us1(f)>Us3(f) && Us1(f)>Us4(f)){
			c1+=0.1;
			c2-=0.1;
			System.err.print(" 狀態為 1 ");
		}
		if(Us2(f)>Us1(f) && Us2(f)>Us3(f) && Us2(f)>Us4(f)){
			c1+=0.01;
			c2-=0.01;
			System.err.print(" 狀態為  2 ");
		}
		if(Us3(f)>Us1(f) && Us3(f)>Us2(f) && Us3(f)>Us4(f)){
			c1+=0.01;
			c2+=0.01;
			RandomGaussian.main(pop, newPopulation);
			System.err.print(" 狀態為  3 ");
		}
		if(Us4(f)>Us1(f) && Us4(f)>Us2(f) && Us4(f)>Us3(f)){
			c1-=0.1;
			c2+=0.1;
			System.err.print(" 狀態為  4 ");
		}
		System.err.println("c1= "+c1+" c2= "+c2);
		return newPopulation;
	}
	
	static Population Adaptive2PSO(Population pop, Population newPopulation){
		  di=new double[pop.size()];
		for(int i=0;i<pop.size();i++){
			double s=0;
			V_Individual Vinvid = pop.getV_Individual(i);
			for(int j=0;j<pop.size();j++){
				V_Individual Vinvid2 = pop.getV_Individual(j);
				double s1=0;
				if(i!=j){
					for(int k=0;k<Vinvid.Vxsize();k++)
						s1+=Math.pow((Vinvid.getVx(k)-Vinvid2.getVx(k)),2);
					for(int k=0;k<Vinvid.Vysize();k++)
						s1+=Math.pow((Vinvid.getVy(k)-Vinvid2.getVy(k)),2);
					s+=Math.sqrt(s1);
				}
			}
			di[i]=(s/(pop.size()-1));
		}
		
		  dmax=di[0];
		  dmin=di[0];
		for(int i=0;i<pop.size();i++){
			if(di[i]>=dmax)
				dmax=di[i];
			if(di[i]<=dmin)
				dmin=di[i];
		}
		Individual invid1 = pop.getIndividual(0);
		double m=invid1.getFitness();
		int n=0;
		for (int i = 0; i < pop.size(); i++) {
			Individual invid = pop.getIndividual(i);
				if (invid.getFitness() >= m) {
					m=invid.getFitness();
					n=i;
				}
		}
	
		double s=0;
		V_Individual Vinvid = pop.getV_Individual(n);
		for(int j=0;j<pop.size();j++){
			V_Individual Vinvid2 = pop.getV_Individual(j);
			double s1=0;
				if(j!=n){
				for(int k=0;k<Vinvid.Vxsize();k++)
					s1+=Math.pow((Vinvid.getVx(k)-Vinvid2.getVx(k)),2);
				for(int k=0;k<Vinvid.Vysize();k++)
					s1+=Math.pow((Vinvid.getVy(k)-Vinvid2.getVy(k)),2);
				s+=Math.sqrt(s1);
			}
		}
		dg=(s/(pop.size()-1)) ;
		
		System.err.println("dg="+dg+" dmax= "+dmax+" dmin= "+dmin+" ");
		f=(dg-dmin)/(dmax-dmin);
		System.err.print(" f= "+ f+" ");
		 
		w=1/(1+1.5*Math.exp(-2.6*f));
		System.out.print("w= "+ w+" ");
		if(Us1(f)>Us2(f) && Us1(f)>Us3(f) && Us1(f)>Us4(f)){
			c1+=0.1;
			c2-=0.1;
			System.err.print(" 狀態為 1 ");
		}
		if(Us2(f)>Us1(f) && Us2(f)>Us3(f) && Us2(f)>Us4(f)){
			c1+=0.01;
			c2-=0.01;
			System.err.print(" 狀態為 2 ");
		}
		if(Us3(f)>Us1(f) && Us3(f)>Us2(f) && Us3(f)>Us4(f)){
			c1+=0.01;
			c2+=0.01;
			System.err.print(" 狀態為 3 ");
			RandomGaussian.main(pop, newPopulation);
		}
		if(Us4(f)>Us1(f) && Us4(f)>Us2(f) && Us4(f)>Us3(f)){
			c1-=0.1;
			c2+=0.1;
			System.err.print(" 狀態為 4 ");
		}
		System.err.println("c1= "+c1+" c2= "+c2);
		return newPopulation;
	}
	 static double Us1(double f){
	    	double a=0;
			if(0<=f && f<=0.4)
				a=0;
			if(0.4<f && f<=0.6)
				a=5*f-2;
			if(0.6<f && f<=0.7)
				a=1;
			if(0.7<f && f<=0.8)
				a=-10*f+8;
			if(0.8<f && f<=1)
				a=0;
			return a;
		}
		static double Us2(double f){
			double a=0;
			if(0<=f && f<=0.2)
				a=0;
			if(0.2<f && f<=0.3)
				a=-10*f-2;
			if(0.3<f && f<=0.4)
				a=1;
			if(0.4<f && f<=0.6)
				a=-5*f+3;
			if(0.6<f && f<=1)
				a=0;
			return a;
		}
		static double Us3(double f){
			double a=0;
			if(0<=f && f<=0.1)
				a=1;
			if(0.1<f && f<=0.3)
				a=-5*f+1.5;
			if(0.3<f && f<=1)
				a=0;
			
			return a;
		}
		static double Us4(double f){
			double a=0;
			if(0<=f && f<=0.7)
				a=0;
			if(0.7<f && f<=0.9)
				a=5*f-3.5;
			if(0.9<f && f<=1)
				a=1;
			return a;
		}
}
