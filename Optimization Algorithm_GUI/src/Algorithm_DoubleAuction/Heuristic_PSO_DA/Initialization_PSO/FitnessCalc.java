package Algorithm_DoubleAuction.Heuristic_PSO_DA.Initialization_PSO;

 
import Input_Output_txt.Double_Auction.Read_Double_Auction;
 

public class FitnessCalc extends Initialzation_PSO2 {

	static double getFitness(G_Individual individual) {

		double fitness = 0;
		int c = 0;
		int[] Y = new int[Read_Double_Auction.getH(N)];
		int[][] X = new int[I][];
		for (int i = 0; i < I; i++)
			X[i] = new int[Read_Double_Auction.getJ(i)];
		int b = 0;
		for (int i = 0; i < Y.length; i++)
			Y[i] = individual.getGy(i);

		for (int i = 0; i < I; i++)
			for (int j = 0; j < X[i].length; j++)
				X[i][j] = individual.getGx(b++);

		fitness = Fitness(X, Y);

		return fitness;
	}

	// F2(X,Y)
	static double getFitness1(Individual individual) {
		  double fitness = 0;
		  int c = 0;
			int[] Y = new int[Read_Double_Auction.getH(N)];
			 
			int[][] X = new int[I][];
			for (int i = 0; i < I; i++)
				X[i] = new int[Read_Double_Auction.getJ(i)];
			int b = 0;
			for (int i = 0; i < Y.length; i++)
				Y[i] = individual.getY(i);

			for (int i = 0; i < I; i++)
				for (int j = 0; j < X[i].length; j++)
					X[i][j] = individual.getX(b++);

		 
	//F(X,Y)
	//if((st22==K)&&(st23>=0)&&(st24==Xsize)&&(st25==Xsize)&&(st26<=D)	){						
	if(constraint(X, Y)==true){
		  
		fitness=Fitness(X, Y);
		SFminsb.append(fitness+" ");
	}
	//U1(X,Y)
	else{
		double Sfmin;
		Sfmin=Initialzation_PSO2.Sfmin;
		  
		    fitness=Sfmin+U1(X, Y);
		}
		return fitness;
	}

	static double getPFitness(P_Individual individual) {
		 double fitness = 0;
		  int c = 0;
			int[] Y = new int[Read_Double_Auction.getH(N)];
			
			int[][] X = new int[I][];
			for (int i = 0; i < I; i++)
				X[i] = new int[Read_Double_Auction.getJ(i)];
			int b = 0;
			for (int i = 0; i < Y.length; i++)
				Y[i] = individual.getPy(i);

			for (int i = 0; i < I; i++)
				for (int j = 0; j < X[i].length; j++)
					X[i][j] = individual.getPx(b++);

		 
	//F(X,Y)
	//if((st22==K)&&(st23>=0)&&(st24==Xsize)&&(st25==Xsize)&&(st26<=D)	){						
	if(constraint(X, Y)==true){
		  
		fitness=Fitness(X, Y);
		SFminsb.append(fitness+" ");
	}
	//U1(X,Y)
	else{
		double Sfmin;
		Sfmin=Initialzation_PSO2.Sfmin;
		  
		    fitness=Sfmin+U1(X, Y);
		}
		return fitness;
	}

	static double getGFitness(G_Individual individual) {
		 double fitness = 0;
		  int c = 0;
			int[] Y = new int[Read_Double_Auction.getH(N)];
			
			int[][] X = new int[I][];
			for (int i = 0; i < I; i++)
				X[i] = new int[Read_Double_Auction.getJ(i)];
			int b = 0;
			for (int i = 0; i < Y.length; i++)
				Y[i]= individual.getGy(i);

			for (int i = 0; i < I; i++)
				for (int j = 0; j < X[i].length; j++)
					X[i][j] = individual.getGx(b++);

		 
	//F(X,Y)
	//if((st22==K)&&(st23>=0)&&(st24==Xsize)&&(st25==Xsize)&&(st26<=D)	){						
	if(constraint(X, Y)==true){
		  
		fitness=Fitness(X, Y);
		SFminsb.append(fitness+" ");
	}
	//U1(X,Y)
	else{
		double Sfmin;
		Sfmin=Initialzation_PSO2.Sfmin;
		  
		    fitness=Sfmin+U1(X, Y);
		}
		return fitness;
	}

	static double getEFitness1(E_Individual individual) {
	 
		 double fitness = 0;
		  int c = 0;
			int[] Y = new int[Read_Double_Auction.getH(N)];
	
			int[][] X = new int[I][];
			for (int i = 0; i < I; i++)
				X[i] = new int[Read_Double_Auction.getJ(i)];
			int b = 0;
			for (int i = 0; i < Y.length; i++)
				Y[i]= individual.getEy(i);

			for (int i = 0; i < I; i++)
				for (int j = 0; j < X[i].length; j++)
					X[i][j] = individual.getEx(b++);

		 
	//F(X,Y)
	//if((st22==K)&&(st23>=0)&&(st24==Xsize)&&(st25==Xsize)&&(st26<=D)	){						
	if(constraint(X, Y)==true){
		  
		fitness=Fitness(X, Y);
		SFminsb.append(fitness+" ");
	}
	//U1(X,Y)
	else{
		double Sfmin;
		Sfmin=Initialzation_PSO2.Sfmin;
		  
		    fitness=Sfmin+U1(X, Y);
		}
		return fitness;
	}

	static double Fitness(int[][] X, int[] Y) {
		double fitness = 0 ;
		for (int h = 0; h < Y.length; h++)
			fitness += Y[h] * (Read_Double_Auction.getPnh(N, h)+(Read_Double_Auction.getTbm()*Read_Double_Auction.getPnh(N, h)));
			 
			
		for (int i = 0; i < I; i++)
			for (int j = 0; j < X[i].length; j++) {
				fitness -= X[i][j]* (Read_Double_Auction.getPij(i, j)-(Read_Double_Auction.getTsm()*Read_Double_Auction.getPij(i, j)));
				 
			}

		return fitness;
	}
	static double U1(int[][] X, int[] Y) {
		double fitness = 0 ;

		for (int k = 0; k < K; k++) {
			double s1 = 0, s2 = 0;
			for (int i = 0; i < I; i++) {
				for (int j = 0; j < X[i].length; j++)
					s1 += X[i][j] * Read_Double_Auction.getqijk(i, j, k);
			}
			
				for (int h = 0; h < Y.length; h++)
					s2 += Y[h] * Read_Double_Auction.getdnhk(N,h,k);
			
			fitness += Math.min(s1 - s2, 0.0);

		}
		double s3 = 0, s4 = 0;
		
		for (int h = 0; h < Y.length; h++)
			s3 += Y[h] * Read_Double_Auction.getPnh(N, h);
		
		for (int i = 0; i < I; i++) {
			for (int j = 0; j < X[i].length; j++)
				s4 += X[i][j]	*	Read_Double_Auction.getPij(i, j);
		}
		fitness += Math.min(s3 - s4, 0.0);

		for (int i = 0; i < I; i++) {
			for (int k = 0; k < K; k++){
				double s5 = 0;
				for (int j = 0; j < X[i].length; j++) 
					s5 += X[i][j] * Read_Double_Auction.getqijk(i, j, k);
				fitness += Math.min(Read_Double_Auction.getSik(i, k)- s5, 0.0);

			}
		}
		 
		return fitness ;
	}
	static boolean constraint(int[][] X, int[] Y) {
		boolean right = true;
		double st221 = 0, st222 = 0;
		for (int k = 0; k < K; k++) {
			for (int i = 0; i < I; i++)
				for (int j = 0; j < X[i].length; j++)
					st221 += X[i][j] * Read_Double_Auction.getqijk(i, j, k);

			
				for (int h = 0; h < Y.length; h++)
					st222 += Y[h] * Read_Double_Auction.getdnhk(N, h, k);

			if (st221 < st222)
				right = false;

			st221 = 0;
			st222 = 0;
		}
		double st231 = 0, st232 = 0;

		
			for (int h = 0; h < Y.length; h++)
				st231 += Y[h] * Read_Double_Auction.getPnh(N, h);
		for (int i = 0; i < I; i++)
			for (int j = 0; j < X[i].length; j++)
				st232 += X[i][j]* Read_Double_Auction.getPij(i, j);
		if (st231 < st232)
			right = false;

		double st241 = 0;
		for (int i = 0; i < I; i++)
			for (int k = 0; k < K; k++){
				for (int j = 0; j < X[i].length; j++)
					st241 += X[i][j] * Read_Double_Auction.getqijk(i, j, k);
				if (st241 > Read_Double_Auction.getSik(i, k))
					right = false;
				st241 = 0;
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
