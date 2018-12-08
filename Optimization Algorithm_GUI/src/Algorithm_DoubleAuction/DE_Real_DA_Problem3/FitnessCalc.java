package Algorithm_DoubleAuction.DE_Real_DA_Problem3;

import Input_Output_txt.Double_Auction.Read_Double_Auction_Problem3;
 
public class FitnessCalc extends Double_Auction_DE_Real_Problem3 {

	static double getFitness(Individual individual) {

		double fitness = 0;
		 
		int[][] Y = new int[N][];
		for (int i = 0; i < N; i++)
			Y[i] = new int[Read_Double_Auction_Problem3.getH(i)];
		
		int[][][][] X = new int[I][][][];
		for (int i = 0; i < I; i++)
			X[i] = new int[N][][];
		for(int i=0;i<I;i++)
			for(int n=0;n<N;n++)
				X[i][n]=new int[Read_Double_Auction_Problem3.getH(n)][];
		for(int i=0;i<I;i++)
			for(int n=0;n<N;n++)
				for(int h=0;h<Read_Double_Auction_Problem3.getH(n);h++)
				X[i][n][h]=new int[K];
		
		int b = 0,c=0;
		for (int i = 0; i < N; i++)
			for (int j = 0; j < Y[i].length; j++)
				Y[i][j] = individual.getbinaryY(c++);

		for (int i = 0; i < I; i++)
			for(int n=0;n< X[i].length;n++)
				for(int h=0;h<X[i][n].length;h++)
					for(int k=0;k<X[i][n][h].length;k++)
						X[i][n][h][k]= individual.getX(b++);
			
		fitness = Fitness(X, Y);

		return fitness;
	}

	// F2(X,Y)
	static double getFitness1(Individual individual) {
		  double fitness = 0;
		  int[][] Y = new int[N][];
			for (int i = 0; i < N; i++)
				Y[i] = new int[Read_Double_Auction_Problem3.getH(i)];
			
			int[][][][] X = new int[I][][][];
			for (int i = 0; i < I; i++)
				X[i] = new int[N][][];
			for(int i=0;i<I;i++)
				for(int n=0;n<N;n++)
					X[i][n]=new int[Read_Double_Auction_Problem3.getH(n)][];
			for(int i=0;i<I;i++)
				for(int n=0;n<N;n++)
					for(int h=0;h<Read_Double_Auction_Problem3.getH(n);h++)
					X[i][n][h]=new int[K];
			
			int b = 0,c=0;
			for (int i = 0; i < N; i++)
				for (int j = 0; j < Y[i].length; j++)
					Y[i][j] = individual.getbinaryY(c++);

			for (int i = 0; i < I; i++)
				for(int n=0;n< X[i].length;n++)
					for(int h=0;h<X[i][n].length;h++)
						for(int k=0;k<X[i][n][h].length;k++)
							X[i][n][h][k]= individual.getX(b++);
			 
		 
	//F(X,Y)
	//if((st22==K)&&(st23>=0)&&(st24==Xsize)&&(st25==Xsize)&&(st26<=D)	){						
	if(constraint(X, Y)==true){
		  
		fitness=Fitness(X, Y);
		SFminsb.append(fitness+" ");
	}
	//U1(X,Y)
	else{
		double Sfmin;
		Sfmin=Double_Auction_DE_Real_Problem3.Sfmin;
		  
		    fitness=Sfmin+U1(X, Y);
		}
		return fitness;
	}

	static double getVFitness(V_Individual individual) {
		 double fitness = 0;
		 int[][] Y = new int[N][];
			for (int i = 0; i < N; i++)
				Y[i] = new int[Read_Double_Auction_Problem3.getH(i)];
			
			int[][][][] X = new int[I][][][];
			for (int i = 0; i < I; i++)
				X[i] = new int[N][][];
			for(int i=0;i<I;i++)
				for(int n=0;n<N;n++)
					X[i][n]=new int[Read_Double_Auction_Problem3.getH(n)][];
			for(int i=0;i<I;i++)
				for(int n=0;n<N;n++)
					for(int h=0;h<Read_Double_Auction_Problem3.getH(n);h++)
					X[i][n][h]=new int[K];
			
			int b = 0,c=0;
			for (int i = 0; i < N; i++)
				for (int j = 0; j < Y[i].length; j++)
					Y[i][j] = individual.getbinaryVy(c++);

			for (int i = 0; i < I; i++)
				for(int n=0;n< X[i].length;n++)
					for(int h=0;h<X[i][n].length;h++)
						for(int k=0;k<X[i][n][h].length;k++)
							X[i][n][h][k]= individual.getVx(b++);
		 
	//F(X,Y)
	//if((st22==K)&&(st23>=0)&&(st24==Xsize)&&(st25==Xsize)&&(st26<=D)	){						
	if(constraint(X, Y)==true){
		  
		fitness=Fitness(X, Y);
		SFminsb.append(fitness+" ");
	}
	//U1(X,Y)
	else{
		double Sfmin;
		Sfmin=Double_Auction_DE_Real_Problem3.Sfmin;
		  
		    fitness=Sfmin+U1(X, Y);
		}
		return fitness;
	}

	static double getUFitness(U_Individual individual) {
		 double fitness = 0;
		 int[][] Y = new int[N][];
			for (int i = 0; i < N; i++)
				Y[i] = new int[Read_Double_Auction_Problem3.getH(i)];
			
			int[][][][] X = new int[I][][][];
			for (int i = 0; i < I; i++)
				X[i] = new int[N][][];
			for(int i=0;i<I;i++)
				for(int n=0;n<N;n++)
					X[i][n]=new int[Read_Double_Auction_Problem3.getH(n)][];
			for(int i=0;i<I;i++)
				for(int n=0;n<N;n++)
					for(int h=0;h<Read_Double_Auction_Problem3.getH(n);h++)
					X[i][n][h]=new int[K];
			
			int b = 0,c=0;
			for (int i = 0; i < N; i++)
				for (int j = 0; j < Y[i].length; j++)
					Y[i][j] = individual.getbinaryUy(c++);

			for (int i = 0; i < I; i++)
				for(int n=0;n< X[i].length;n++)
					for(int h=0;h<X[i][n].length;h++)
						for(int k=0;k<X[i][n][h].length;k++)
							X[i][n][h][k]= individual.getUx(b++);

		 
	//F(X,Y)
	//if((st22==K)&&(st23>=0)&&(st24==Xsize)&&(st25==Xsize)&&(st26<=D)	){						
	if(constraint(X, Y)==true){
		  
		fitness=Fitness(X, Y);
		SFminsb.append(fitness+" ");
	}
	//U1(X,Y)
	else{
		double Sfmin;
		Sfmin=Double_Auction_DE_Real_Problem3.Sfmin;
		  
		    fitness=Sfmin+U1(X, Y);
		}
		return fitness;
	}

	static double getFitnes(int[] x,int[] y) {
		  double fitness = 0;
		  int[][] Y = new int[N][];
			for (int i = 0; i < N; i++)
				Y[i] = new int[Read_Double_Auction_Problem3.getH(i)];
			
			int[][][][] X = new int[I][][][];
			for (int i = 0; i < I; i++)
				X[i] = new int[N][][];
			for(int i=0;i<I;i++)
				for(int n=0;n<N;n++)
					X[i][n]=new int[Read_Double_Auction_Problem3.getH(n)][];
			for(int i=0;i<I;i++)
				for(int n=0;n<N;n++)
					for(int h=0;h<Read_Double_Auction_Problem3.getH(n);h++)
					X[i][n][h]=new int[K];
			
			int b = 0,c=0;
			for (int i = 0; i < N; i++)
				for (int j = 0; j < Y[i].length; j++)
					Y[i][j] =y[c++];

			for (int i = 0; i < I; i++)
				for(int n=0;n< X[i].length;n++)
					for(int h=0;h<X[i][n].length;h++)
						for(int k=0;k<X[i][n][h].length;k++)
							X[i][n][h][k]= x[b++];
			 
		 
	//F(X,Y)
	//if((st22==K)&&(st23>=0)&&(st24==Xsize)&&(st25==Xsize)&&(st26<=D)	){						
	if(constraint(X, Y)==true){
		  
		fitness=Fitness(X, Y);
		SFminsb.append(fitness+" ");
	}
	//U1(X,Y)
	else{
		double Sfmin;
		Sfmin=Double_Auction_DE_Real_Problem3.Sfmin;
		  
		    fitness=Sfmin+U1(X, Y);
		}
		return fitness;
	}

	static double Fitness(int[][][][] X, int[][] Y) {
		double fitness = 0 ;
		for (int n = 0; n < N; n++)
			for (int h = 0; h < Y[n].length; h++) {
				fitness += Y[n][h] * (Read_Double_Auction_Problem3.getPnh(n, h)+(Read_Double_Auction_Problem3.getTbm()*Read_Double_Auction_Problem3.getPnh(n, h)));
			 
			}
		for (int i = 0; i < I; i++)
			for(int n=0;n < X[i].length;n++)
				for(int h=0;h<X[i][n].length;h++)
					for(int k=0;k<X[i][n][h].length;k++){
						fitness -= X[i][n][h][k]* (Read_Double_Auction_Problem3.getPij(i, k)-(Read_Double_Auction_Problem3.getTsm()*Read_Double_Auction_Problem3.getPij(i, k)));
			}

		return fitness;
	}
	static double U1(int[][][][] X, int[][] Y) {
		double fitness = 0 ;
		double s1 = 0, s2 = 0;
		for(int n=0;n<N;n++)
			for(int h=0;h<Read_Double_Auction_Problem3.getH(n);h++)
				for(int k=0;k<K;k++){
					s1=0;
					s2=0;
					for(int i=0;i<I;i++)
						s1+=X[i][n][h][k];
					s2=Y[n][h]*Read_Double_Auction_Problem3.getdnhk(n, h, k);
					fitness-=Math.abs(s1-s2);
				}
	
		double s3 = 0, s4 = 0;
		for(int n=0;n<N;n++)
			for(int h=0;h<Read_Double_Auction_Problem3.getH(n);h++){
				s3=0;
				s4=0;
				s3=Y[n][h]*Read_Double_Auction_Problem3.getPnh(n, h);
				for(int i=0;i<I;i++)
					for(int k=0;k<K;k++)
						s4+=X[i][n][h][k]*Read_Double_Auction_Problem3.getPij(i, k);
				fitness+= Math.min(s3 - s4, 0.0);
			}
	
		for (int i = 0; i < I; i++) {
			for (int k = 0; k < K; k++){
				double s5 = 0;
				for(int n=0;n<N;n++)
					for(int h=0;h<Read_Double_Auction_Problem3.getH(n);h++)
						s5+=X[i][n][h][k];
				fitness += Math.min(Read_Double_Auction_Problem3.getSik(i, k)- s5, 0.0);

			}
		}
		 
		return fitness ;
	}
	static boolean constraint(int[][][][] X, int[][] Y) {
		boolean right = true;
		
		for(int n=0;n<N;n++)
			for(int h=0;h<Read_Double_Auction_Problem3.getH(n);h++)
				for(int k=0;k<K;k++){
					double st221 = 0, st222 = 0;
					for(int i=0;i<I;i++)
						st221+=X[i][n][h][k];
					st222=Y[n][h]*Read_Double_Auction_Problem3.getdnhk(n, h, k);
					if(st221!=st222)
						right =false;
				}
		
		

		for(int n=0;n<N;n++)
			for(int h=0;h<Read_Double_Auction_Problem3.getH(n);h++){
				double st231 = 0, st232 = 0;
				st231=Y[n][h]*Read_Double_Auction_Problem3.getPnh(n, h);
				
				for(int i=0;i<I;i++)
					for(int k=0;k<K;k++)
						st232+=X[i][n][h][k]*Read_Double_Auction_Problem3.getPij(i, k);
				if(st231<st232)
					right=false;
			}
	
		
		for (int i = 0; i < I; i++)
			for (int k = 0; k < K; k++){
				double st241 = 0;
				for(int n=0;n<N;n++)
					for(int h=0;h<Read_Double_Auction_Problem3.getH(n);h++)
						st241+=X[i][n][h][k];
				if (st241 > Read_Double_Auction_Problem3.getSik(i, k))
					right = false;
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
