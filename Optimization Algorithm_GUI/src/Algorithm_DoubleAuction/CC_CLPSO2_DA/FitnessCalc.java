package Algorithm_DoubleAuction.CC_CLPSO2_DA;

 
import Input_Output_txt.Double_Auction.Read_Double_Auction;
 

public class FitnessCalc extends Double_Auction_CC_CLPSO2 {

	static double F(int[] x,int[] y) {

		 double fitness = 0;
		  int c = 0;
			int[][] Y = new int[N][];
			for (int i = 0; i < N; i++)
				Y[i] = new int[Read_Double_Auction.getH(i)];
			int[][] X = new int[I][];
			for (int i = 0; i < I; i++)
				X[i] = new int[Read_Double_Auction.getJ(i)];
			int b = 0;
			for (int i = 0; i < N; i++)
				for (int j = 0; j < Y[i].length; j++)
					Y[i][j] = y[c++];

			for (int i = 0; i < I; i++)
				for (int j = 0; j < X[i].length; j++)
					X[i][j] = x[b++];
				
	if(constraint(X, Y)==true){
		fitness=Fitness(X, Y);
		SFminsb.append(fitness+" ");
	}
	//U1(X,Y)
	else{
		double Sfmin;
		Sfmin=Double_Auction_CC_CLPSO2.Sfmin;
		    fitness=Sfmin+U1(X, Y);
		}
		return fitness;
	}
	
	static double getFitness(G_Individual individual) {

		double fitness = 0;
		int c = 0;
		int[][] Y = new int[N][];
		for (int i = 0; i < N; i++)
			Y[i] = new int[Read_Double_Auction.getH(i)];
		int[][] X = new int[I][];
		for (int i = 0; i < I; i++)
			X[i] = new int[Read_Double_Auction.getJ(i)];
		int b = 0;
		for (int i = 0; i < N; i++)
			for (int j = 0; j < Y[i].length; j++)
				Y[i][j] = individual.getGy(c++);

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
			int[][] Y = new int[N][];
			for (int i = 0; i < N; i++)
				Y[i] = new int[Read_Double_Auction.getH(i)];
			int[][] X = new int[I][];
			for (int i = 0; i < I; i++)
				X[i] = new int[Read_Double_Auction.getJ(i)];
			int b = 0;
			for (int i = 0; i < N; i++)
				for (int j = 0; j < Y[i].length; j++)
					Y[i][j] = individual.getY(c++);

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
		Sfmin=Double_Auction_CC_CLPSO2.Sfmin;
		    fitness=Sfmin+U1(X, Y);
		}
		return fitness;
	}

	static double getPFitness(P_Individual individual) {
		 double fitness = 0;
		  int c = 0;
			int[][] Y = new int[N][];
			for (int i = 0; i < N; i++)
				Y[i] = new int[Read_Double_Auction.getH(i)];
			int[][] X = new int[I][];
			for (int i = 0; i < I; i++)
				X[i] = new int[Read_Double_Auction.getJ(i)];
			int b = 0;
			for (int i = 0; i < N; i++)
				for (int j = 0; j < Y[i].length; j++)
					Y[i][j] = individual.getPy(c++);

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
		Sfmin=Double_Auction_CC_CLPSO2.Sfmin;
		  
		    fitness=Sfmin+U1(X, Y);
		}
		return fitness;
	}

	static double getGFitness(G_Individual individual) {
		 double fitness = 0;
		  int c = 0;
			int[][] Y = new int[N][];
			for (int i = 0; i < N; i++)
				Y[i] = new int[Read_Double_Auction.getH(i)];
			int[][] X = new int[I][];
			for (int i = 0; i < I; i++)
				X[i] = new int[Read_Double_Auction.getJ(i)];
			int b = 0;
			for (int i = 0; i < N; i++)
				for (int j = 0; j < Y[i].length; j++)
					Y[i][j] = individual.getGy(c++);

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
		Sfmin=Double_Auction_CC_CLPSO2.Sfmin;
		  
		    fitness=Sfmin+U1(X, Y);
		}
		return fitness;
	}

	static double getEFitness1(E_Individual individual) {
	 
		 double fitness = 0;
		  int c = 0;
			int[][] Y = new int[N][];
			for (int i = 0; i < N; i++)
				Y[i] = new int[Read_Double_Auction.getH(i)];
			int[][] X = new int[I][];
			for (int i = 0; i < I; i++)
				X[i] = new int[Read_Double_Auction.getJ(i)];
			int b = 0;
			for (int i = 0; i < N; i++)
				for (int j = 0; j < Y[i].length; j++)
					Y[i][j] = individual.getEy(c++);

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
		Sfmin=Double_Auction_CC_CLPSO2.Sfmin;
		  
		    fitness=Sfmin+U1(X, Y);
		}
		return fitness;
	}

	static double Fitness(int[][] X, int[][] Y) {
		double fitness = 0 ;
		for (int n = 0; n < N; n++)
			for (int h = 0; h < Y[n].length; h++) {
				fitness += Y[n][h] * (Read_Double_Auction.getPnh(n, h)+(Read_Double_Auction.getTbm()*Read_Double_Auction.getPnh(n, h)));
			 
			}
		for (int i = 0; i < I; i++)
			for (int j = 0; j < X[i].length; j++) {
				fitness -= X[i][j]* (Read_Double_Auction.getPij(i, j)-(Read_Double_Auction.getTsm()*Read_Double_Auction.getPij(i, j)));
				 
			}

		return fitness;
	}
	static double U1(int[][] X, int[][] Y) {
		double fitness = 0 ;

		for (int k = 0; k < K; k++) {
			double s1 = 0, s2 = 0;
			for (int i = 0; i < I; i++) {
				for (int j = 0; j < X[i].length; j++)
					s1 += X[i][j] * Read_Double_Auction.getqijk(i, j, k);
			}
			for (int n = 0; n < N; n++) {
				for (int h = 0; h < Y[n].length; h++)
					s2 += Y[n][h] * Read_Double_Auction.getdnhk(n,h,k);
			}
			fitness += Math.min(s1 - s2, 0.0);

		}
		double s3 = 0, s4 = 0;
		for (int n = 0; n < N; n++) {
			for (int h = 0; h < Y[n].length; h++)
				s3 += Y[n][h] * Read_Double_Auction.getPnh(n, h);
		}
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
	static boolean constraint(int[][] X, int[][] Y) {
		boolean right = true;
		double st221 = 0, st222 = 0;
		for (int k = 0; k < K; k++) {
			for (int i = 0; i < I; i++)
				for (int j = 0; j < X[i].length; j++)
					st221 += X[i][j] * Read_Double_Auction.getqijk(i, j, k);

			for (int n = 0; n < N; n++)
				for (int h = 0; h < Y[n].length; h++)
					st222 += Y[n][h] * Read_Double_Auction.getdnhk(n, h, k);

			if (st221 < st222)
				right = false;

			st221 = 0;
			st222 = 0;
		}
		double st231 = 0, st232 = 0;

		for (int n = 0; n < N; n++)
			for (int h = 0; h < Y[n].length; h++)
				st231 += Y[n][h] * Read_Double_Auction.getPnh(n, h);
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
