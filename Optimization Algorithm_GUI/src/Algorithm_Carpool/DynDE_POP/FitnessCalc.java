package Algorithm_Carpool.DynDE_POP;
  
import Input_Output_txt.Carpool.Read_BPL_TXT;
import Input_Output_txt.Carpool.Read_CarpoolData_Generation_Mode;
import Input_Output_txt.Carpool.Read_file;
 
public class FitnessCalc extends DynDE_POP {

	static double getFitness(G_Individual individual) {

		double fitness = 0;
		 
		int[][] Y = new int[P][];
		for (int i = 0; i < P; i++)
			Y[i] = new int[Read_file.getHp(i)];
		int[][] X = new int[D][];
		for (int i = 0; i < D; i++)
			X[i] = new int[Read_file.getJd(i)];
		int b = 0,c=0;
		for (int i = 0; i < P; i++)
			for (int j = 0; j < Y[i].length; j++)
				Y[i][j] = individual.getbinaryGy(c++);
 
		for (int i = 0; i < D; i++)
			for (int j = 0; j < X[i].length; j++)
				X[i][j] = individual.getbinaryGx(b++);
		
		Object_Function.Function(X, Y);
		
		fitness = Fitness(X, Y);

		return fitness;
	}

	// F2(X,Y)
	static double getFitness1(Individual individual) {
		  double fitness = 0;
		  int[][] Y = new int[P][];
			for (int i = 0; i < P; i++)
				Y[i] = new int[Read_file.getHp(i)];
			int[][] X = new int[D][];
			for (int i = 0; i < D; i++)
				X[i] = new int[Read_file.getJd(i)];
			int b = 0,c=0;
			for (int i = 0; i < P; i++)
				for (int j = 0; j < Y[i].length; j++)
					Y[i][j] = individual.getbinaryY(c++);
	 
			for (int i = 0; i < D; i++)
				for (int j = 0; j < X[i].length; j++)
					X[i][j] = individual.getbinaryX(b++);

		 
	//F(X,Y)
	//if((st22==K)&&(st23>=0)&&(st24==Xsize)&&(st25==Xsize)&&(st26<=D)	){						
	Object_Function.Function(X, Y);
	
	if(constraint(X, Y)==true){
		  
		fitness=Fitness(X, Y);
		SFminsb.append(fitness+" ");
	}
	//U1(X,Y)
	else{
		double Sfmin;
		Sfmin=DynDE_POP.Sfmin;
		  
		    fitness=Sfmin+U1(X, Y);
		}
		return fitness;
	}

	static double getVFitness(V_Individual individual) {
		 double fitness = 0;
		 int[][] Y = new int[P][];
			for (int i = 0; i < P; i++)
				Y[i] = new int[Read_file.getHp(i)];
			int[][] X = new int[D][];
			for (int i = 0; i < D; i++)
				X[i] = new int[Read_file.getJd(i)];
			int b = 0,c=0;
			for (int i = 0; i < P; i++)
				for (int j = 0; j < Y[i].length; j++){
					double rsid = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
					if (rsid < 1 / (1 + Math.exp(-lamda*individual.getVy(c++)))){
						Y[i][j]=1;
					}
					else{
						Y[i][j]=0;
					}
				}
				

			for (int i = 0; i < D; i++)
				for (int j = 0; j < X[i].length; j++){
					double rsid = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
					if (rsid < 1 / (1 + Math.exp(-lamda*individual.getVx(b++)))){
						X[i][j]=1;
					}
					else{
						X[i][j]=0;
					}
				}
		 
	//F(X,Y)
	//if((st22==K)&&(st23>=0)&&(st24==Xsize)&&(st25==Xsize)&&(st26<=D)	){						
	Object_Function.Function(X, Y);
			
	if(constraint(X, Y)==true){
		  
		fitness=Fitness(X, Y);
		SFminsb.append(fitness+" ");
	}
	//U1(X,Y)
	else{
		double Sfmin;
		Sfmin=DynDE_POP.Sfmin;
		  
		    fitness=Sfmin+U1(X, Y);
		}
		return fitness;
	}

	static double getUFitness(U_Individual individual) {
		 double fitness = 0;
		 int[][] Y = new int[P][];
			for (int i = 0; i < P; i++)
				Y[i] = new int[Read_file.getHp(i)];
			int[][] X = new int[D][];
			for (int i = 0; i < D; i++)
				X[i] = new int[Read_file.getJd(i)];
			int b = 0,c=0;
			for (int i = 0; i < P; i++)
				for (int j = 0; j < Y[i].length; j++)
					Y[i][j] = individual.getbinaryUy(c++);
	 
			for (int i = 0; i < D; i++)
				for (int j = 0; j < X[i].length; j++)
					X[i][j] = individual.getbinaryUx(b++);

		 
	//F(X,Y)
	//if((st22==K)&&(st23>=0)&&(st24==Xsize)&&(st25==Xsize)&&(st26<=D)	){						
	Object_Function.Function(X, Y);
			
	if(constraint(X, Y)==true){
		  
		fitness=Fitness(X, Y);
		SFminsb.append(fitness+" ");
	}
	//U1(X,Y)
	else{
		double Sfmin;
		Sfmin=DynDE_POP.Sfmin;
		  
		    fitness=Sfmin+U1(X, Y);
		}
		return fitness;
	}

	static double getPlbestFitness(Plbest_Individual individual) {
		 
		int c = 0;
		double fitness = 0;
		int[][] Y = new int[P][];
		for (int i = 0; i < P; i++)
			Y[i] = new int[Read_file.getHp(i)];
		int[][] X = new int[D][];
		for (int i = 0; i < D; i++)
			X[i] = new int[Read_file.getJd(i)];
		for (int i = 0; i < P; i++)
			for (int j = 0; j < Y[i].length; j++)
				Y[i][j] = individual.getbinaryPy(c++);

		int b = 0;
		for (int i = 0; i < D; i++)
			for (int j = 0; j < X[i].length; j++)
				X[i][j] = individual.getbinaryPx(b++);

		Object_Function.Function(X, Y);
		
		if (constraint(X,Y) == true) {
			
			fitness = Fitness(X, Y);
			SFminsb.append(fitness + " ");
		}
		// U1(X,Y)
		else {
			double Sfmin;
			Sfmin = DynDE_POP.Sfmin;
			fitness = Sfmin+U1(X, Y);
		}
		return fitness;
	}
	
	static double getGFitness(G_Individual individual) {
		 
		int c = 0;
		double fitness = 0;
		int[][] Y = new int[P][];
		for (int i = 0; i < P; i++)
			Y[i] = new int[Read_file.getHp(i)];
		int[][] X = new int[D][];
		for (int i = 0; i < D; i++)
			X[i] = new int[Read_file.getJd(i)];
		for (int i = 0; i < P; i++)
			for (int j = 0; j < Y[i].length; j++)
				Y[i][j] = individual.getbinaryGy(c++);

		int b = 0;
		for (int i = 0; i < D; i++)
			for (int j = 0; j < X[i].length; j++)
				X[i][j] = individual.getbinaryGx(b++);

		Object_Function.Function(X, Y);
		
		if (constraint(X,Y) == true) {
			
			fitness = Fitness(X, Y);
			SFminsb.append(fitness + " ");
		}
		// U1(X,Y)
		else {
			double Sfmin;
			Sfmin = DynDE_POP.Sfmin;
			fitness = Sfmin+U1(X, Y);
		}
		return fitness;
	}
	static double Fitness(int[][] X, int[][] Y) {
		double fitness = 0, fitness2 = 0,fitness3=0,fitness4=0,fitness5=0,fitness6=0,fitness7=0;
		for (int p = 0; p < P; p++)
			for (int h = 0; h < Y[p].length; h++) {
				fitness += Y[p][h] * Read_file.getfph(p, h);
				fitness += Y[p][h] * Read_file.getTpm()
						* Read_file.getfph(p, h);
				fitness2 += Y[p][h];
				
				fitness5+=Y[p][h] * Read_file.getfph(p, h);
			}
		for (int d = 0; d < D; d++)
			for (int j = 0; j < X[d].length; j++) {
				fitness -= X[d][j]
						* (Read_file.getCdj(d, j) - Read_file.getOdj(d, j));
				fitness += X[d][j] * Read_file.getTdm()
						* (Read_file.getCdj(d, j) - Read_file.getOdj(d, j));
				fitness2 += X[d][j];
				
				fitness5+=X[d][j]* (Read_file.getCdj(d, j)) ;
			}
		
		if(fitness2>0) {
		fitness3 = (fitness/fitness2)*Omega_3;
		fitness4=Omega_4*(wp*Object_Function.get_aps()+Object_Function.get_ads()*wd);
		fitness5 = (fitness/fitness5)*Omega_5;
		fitness *= Omega_1;
		fitness2 *= Omega_2;
		fitness6=Omega_6*Object_Function.get_cp_all_actual();
		fitness7=Omega_7*((Object_Function.get_cp_p()*wp1)+(Object_Function.get_cp_d()*wd1));
		return fitness + fitness2 + fitness3 + fitness5+fitness6+fitness7;
		}
		else {
			return 0;
		}
	}
	static double U1(int[][] X, int[][] Y) {
		double fitness = 0 ;

		for (int k = 0; k < K; k++) {
			double s1 = 0, s2 = 0;
			for (int d = 0; d < D; d++) {
				for (int j = 0; j < X[d].length; j++)
					s1 += X[d][j] * Read_file.getqdjk(d, j, k);
			}
			for (int p = 0; p < P; p++) {
				for (int h = 0; h < Y[p].length; h++)
					s2 += Y[p][h] * Read_file.getSphk(p, h, k);
			}
			fitness += Math.min(s1 - s2, 0.0);

		}
		double s3 = 0, s4 = 0;
		for (int p = 0; p < P; p++) {
			for (int h = 0; h < Y[p].length; h++)
				s3 += Y[p][h] * Read_file.getfph(p, h);
		}
		for (int d = 0; d < D; d++) {
			for (int j = 0; j < X[d].length; j++)
				s4 += X[d][j]
						* (Read_file.getCdj(d, j) - Read_file.getOdj(d, j));
		}
		fitness += Math.min(s3 - s4, 0.0);

		for (int d = 0; d < D; d++) {
			for (int j = 0; j < X[d].length; j++) {
				double s5 = 0;
				for (int k = 0; k < K; k++)
					s5 += X[d][j] * Read_file.getqdjk(d, j, k);
				fitness += Math.min(Read_file.getadj(d, j) - s5, 0.0);

			}
		}
		for (int d = 0; d < D; d++) {
			for (int j = 0; j < X[d].length; j++) {
				double s6 = 0;
				for (int k = 0; k < K; k++)
					s6 += X[d][j] * Read_file.getWqdjk(d, j, k);
				fitness += Math.min(Read_file.getldj(d, j) - s6, 0.0);

			}
		}
		for (int d = 0; d < D; d++) {
			double s7 = 0;
			for (int j = 0; j < X[d].length; j++)
				s7 += X[d][j];
			fitness += Math.min(1 - s7, 0.0);
		}
		 
		//(2-14)
		fitness+=Math.min(Object_Function.get_aps()-(1-Epsilon1)*Object_Function.get_ads(),0.0);
		fitness+=Math.min((1+Epsilon2)*Object_Function.get_ads()-Object_Function.get_aps(),0.0);
		
		
		//(2-15)
		fitness+=Math.min(Object_Function.get_cp_p()-(1-Epsilon3)*Object_Function.get_cp_d(),0.0);
		fitness+=Math.min((1+Epsilon4)*Object_Function.get_cp_d()-Object_Function.get_cp_p(),0.0);
	
		
		if(Read_CarpoolData_Generation_Mode.mode().contains("multi_hop")){
	 
			for(int p=0;p<Read_BPL_TXT.Bpl().size();p++){
				int a=0;
			 
				for(int j=0;j<Read_BPL_TXT.Bpl().get(p).size();j++){
					double s8=0,s9=0;
					for(int k=0;k<Read_BPL_TXT.Bpl().get(p).get(j);k++){
						s8+=Y[p][a];
						s9+=(1-Y[p][a]);
						a+=1;
					}
					fitness-=Math.abs(s8*s9);
				}
			}
		 
			for(int p=0;p<Read_BPL_TXT.Bpl().size();p++){
				int a=0;
			 	double s11=0;
			 	for(int j=0;j<Read_BPL_TXT.Bpl().get(p).size();j++){
					double s10=1;
					for(int k=0;k<Read_BPL_TXT.Bpl().get(p).get(j);k++){
						s10*=Y[p][a];
						a+=1;
					}
					s11+=s10;
				}	fitness+=Math.min(1-s11,0);
			}
		}
		return fitness ;
	}
	static boolean constraint(int[][] X, int[][] Y) {
		boolean right = true;
		double st221 = 0, st222 = 0;
		for (int k = 0; k < K; k++) {
			for (int d = 0; d < D; d++)
				for (int j = 0; j < X[d].length; j++)
					st221 += X[d][j] * Read_file.getqdjk(d, j, k);

			for (int p = 0; p < P; p++)
				for (int h = 0; h < Y[p].length; h++)
					st222 += Y[p][h] * Read_file.getSphk(p, h, k);

			if (st221 < st222)
				right = false;

			st221 = 0;
			st222 = 0;
		}
		double st231 = 0, st232 = 0;

		for (int p = 0; p < P; p++)
			for (int h = 0; h < Y[p].length; h++)
				st231 += Y[p][h] * Read_file.getfph(p, h);
		for (int d = 0; d < D; d++)
			for (int j = 0; j < X[d].length; j++)
				st232 += X[d][j]* (Read_file.getCdj(d, j) - Read_file.getOdj(d, j));
		if (st231 < st232)
			right = false;

		double st241 = 0;
		for (int d = 0; d < D; d++)
			for (int j = 0; j < X[d].length; j++) {
				for (int k = 0; k < K; k++)
					st241 += X[d][j] * Read_file.getqdjk(d, j, k);
				if (st241 > Read_file.getadj(d, j))
					right = false;
				st241 = 0;
			}

		double st251 = 0;
		for (int d = 0; d < D; d++)
			for (int j = 0; j < X[d].length; j++) {
				for (int k = 0; k < K; k++)
					st251 += X[d][j] * Read_file.getWqdjk(d, j, k);
				if (st251 > Read_file.getldj(d, j))
					right = false;
				st251 = 0;
			}
		int st261 = 0;
		for (int d = 0; d < D; d++) {
			st261 = 0;
			for (int j = 0; j < X[d].length; j++) {
				st261 += X[d][j];
			}
			if (st261 > 1)
				right = false;
		}
		
		//(2-14)
		 if((Omega_4*(1-Epsilon1)*Object_Function.get_ads()) <= (Omega_4*Object_Function.get_aps())
					&& (Omega_4*Object_Function.get_aps()) >= (Omega_4*(1-Epsilon1)*Object_Function.get_ads())
					&& (Omega_4*Object_Function.get_aps()) <= (Omega_4*(1+Epsilon2)*Object_Function.get_ads()))
					 {}
					 else{
				 right=false;}
		//(2-15)
		 if((Omega_7*(1-Epsilon3)*Object_Function.get_cp_d()) <= (Omega_7*Object_Function.get_cp_p())
					&& (Omega_7*Object_Function.get_cp_p()) >= (Omega_7*(1-Epsilon3)*Object_Function.get_cp_d())
					&& (Omega_7*Object_Function.get_cp_p()) <= (Omega_7*(1+Epsilon4)*Object_Function.get_cp_d()))
					 {}
					 else{
				 right=false;}
		 
		if(Read_CarpoolData_Generation_Mode.mode().contains("multi_hop")){
		for(int p=0;p<Read_BPL_TXT.Bpl().size();p++){
			int a=0;
			for(int j=0;j<Read_BPL_TXT.Bpl().get(p).size();j++){
				double s8=0,s9=0;
				for(int k=0;k<Read_BPL_TXT.Bpl().get(p).get(j);k++){
					s8+=Y[p][a];
					s9+=(1-Y[p][a]);
					a+=1;
				}
				if((s8*s9)!=0)
					right = false;
			}
		}
		 
		for(int p=0;p<Read_BPL_TXT.Bpl().size();p++){
			int a=0;
			 double s11=0;
			for(int j=0;j<Read_BPL_TXT.Bpl().get(p).size();j++){
				double s10=1;
				for(int k=0;k<Read_BPL_TXT.Bpl().get(p).get(j);k++){
					s10*=Y[p][a];
					a+=1;
				}
				s11+=s10;
			}	
			if(s11>1)
				right = false;
		}
		}
		return right;
	}
	static double getSFmin(StringBuilder sb) {
		double SFmin;
		String[] a = sb.toString().split(" ");
		if (a.length == 1) {
			SFmin = 0;
		} else {
			SFmin = Double.parseDouble(a[0]);
			for (int i = 0; i < a.length; i++) 
				if (SFmin >= Double.parseDouble(a[i]))
					SFmin = Double.parseDouble(a[i]);
			
		}
		
		SFminsb = new StringBuilder();
		return SFmin;
	}
}
