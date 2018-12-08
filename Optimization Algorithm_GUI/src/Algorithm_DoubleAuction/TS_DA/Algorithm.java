package Algorithm_DoubleAuction.TS_DA;

import java.io.IOException;
import java.util.ArrayList;

import Algorithm_Carpool.PSO1.PSO_Read_Write_txt;
import Algorithm_DoubleAuction.PSO2_DA.Double_Auction_PSO2;
import Input_Output_txt.Read_TS_Parameter;
import Input_Output_txt.Double_Auction.Read_Double_Auction;

public class Algorithm extends TS_DA{
	
	public static void	initialization() throws IOException
	{
		X_Nup = new ArrayList<Integer>();
		X_Ndn = new ArrayList<Integer>();
		Y_Nup = new ArrayList<Integer>();
		Y_Ndn = new ArrayList<Integer>();
		X_M = new ArrayList<Integer>();
		Y_M = new ArrayList<Integer>();

		X_D0 = new ArrayList<Integer>();
		Y_D0 = new ArrayList<Integer>();
		X_IP_UP = new ArrayList<Double>();
		Y_IP_UP = new ArrayList<Double>();
		X_IP_DN = new ArrayList<Double>();
		Y_IP_DN = new ArrayList<Double>();

		X_G = new ArrayList<Integer>();
		Y_G = new ArrayList<Integer>();
		X_Gp = new ArrayList<Integer>();
		Y_Gp = new ArrayList<Integer>();
		X_Gs = new ArrayList<Integer>();
		Y_Gs = new ArrayList<Integer>();

		X_Tabu = new ArrayList<Integer>();
		Y_Tabu = new ArrayList<Integer>();
		
		X_R_UP = new ArrayList<Integer>();
		X_R_DN = new ArrayList<Integer>();
		Y_R_UP = new ArrayList<Integer>();
		Y_R_DN = new ArrayList<Integer>();

		Read_Double_Auction.main();
		Read_TS_Parameter.main();
		
		Iteration=Read_TS_Parameter.Iteration();
		x0 = Read_TS_Parameter.x0();
		Epsilon = Read_TS_Parameter.Epsilon();
		d0 = Read_TS_Parameter.d0();
		gp = Read_TS_Parameter.gp();
		gs = Read_TS_Parameter.gs();

		
		N = Read_Double_Auction.getN();
		I = Read_Double_Auction.getI();
		K = Read_Double_Auction.getK();
		
		X_Nup.clear();
		X_Ndn.clear();
		X_M.clear();
		Y_Nup.clear();
		Y_Ndn.clear();
		Y_M.clear();
		

		double k1,k3;
		m=K+1+I*K+1;
		Xsize=0;
		Ysize=0;
		
		for (int i = 0; i < I; i++)
			Xsize += Read_Double_Auction.getJ(i);
		for (int i = 0; i < N; i++)
			Ysize += Read_Double_Auction.getH(i);
		
		XTabuTenure_UP=new double[Xsize];
		XTabuTenure_DN=new double[Xsize];
		XAspire_UP=new double[Xsize];
		XAspire_DN=new double[Xsize];
		XMaxtenure=new double[Xsize];
		
		X_GR_UP=new double[Xsize];
		X_GR_DN=new double[Xsize];
		
		YTabuTenure_UP=new double[Ysize];
		YTabuTenure_DN=new double[Ysize];
		YAspire_UP=new double[Ysize];
		YAspire_DN=new double[Ysize];
		YMaxtenure=new double[Ysize];
		
		Y_GR_UP=new double[Ysize];
		Y_GR_DN=new double[Ysize];
		
		Iteration_Mode=Read_TS_Parameter.Iteration_Mode();
		if(Iteration_Mode==0){
		Iteration=Read_TS_Parameter.Iteration();
		}else{Iteration=Xsize+Ysize+K+1+Xsize+Xsize;} 
		
		if(Read_TS_Parameter.tabu_tenure_model()==1){
			System.out.println("tabu_tenure_model= "+Read_TS_Parameter.tabu_tenure_model());
			k1=Math.random();		
			while(true)
			{
				k3=Math.random();
				if(1>k3 && k3>k1)
					break;
			}
			Mintenure=k1*m;
			Maxtenure=k3*m;
			
			System.out.println("ClearMaxIter= "+ClearMaxIter);
			System.out.println("Mintenure= "+Mintenure);
			System.out.println("Maxtenure= "+Maxtenure);
			
		}else if(Read_TS_Parameter.tabu_tenure_model()==2)
		{
			System.out.println("tabu_tenure_model= "+Read_TS_Parameter.tabu_tenure_model());
		
			Mintenure=Read_TS_Parameter.MinTenure();
			Maxtenure=Read_TS_Parameter.MaxTenure();
			ClearMaxIter=Read_TS_Parameter.ClearMaxIter();
			System.out.println("ClearMaxIter= "+ClearMaxIter);
			System.out.println("Mintenure= "+Mintenure);
			System.out.println("Maxtenure= "+Maxtenure);
			
		}
		
		for (int i = 0; i < Xsize; i++){
		
			XTabuTenure_UP[i]=Mintenure;
			XTabuTenure_DN[i]=Mintenure;
			XAspire_UP[i]=-999999;
			XAspire_DN[i]=-999999;
			XMaxtenure[i]=Maxtenure;
		}
		for (int i = 0; i < Ysize; i++){
			YTabuTenure_UP[i]=Mintenure;
			YTabuTenure_DN[i]=Mintenure;
			YAspire_UP[i]=-999999;
			YAspire_DN[i]=-999999;
			YMaxtenure[i]=Maxtenure;
		}
		
		X=new double[Xsize];
		Y=new double[Ysize];
		X_LP=new double[Xsize];
		Y_LP=new double[Ysize];
		X_goalvalue=new double[Xsize];
		Y_goalvalue=new double[Ysize];
		
		//更新M
		for(int i=0;i<Xsize;i++)
			X_M.add(1);
		for(int i=0;i<Ysize;i++)
			Y_M.add(1);

	/*for(int i=0;i<X_goalvalue.length;i++)
		if(X_goalvalue[i]==1)
			X_Nup.add(i);
		else
			X_Ndn.add(i);

	for(int i=0;i<Y_goalvalue.length;i++)
		if(Y_goalvalue[i]==1)
			Y_Nup.add(i);
		else
			Y_Ndn.add(i);
	*/
	}

	
	public static boolean constraint(double[] x, double[] y) {
		boolean right = true;
		double st221 = 0, st222 = 0;
		int c = 0;
		double[][] Y = new double[N][];
		for (int i = 0; i < N; i++)
			Y[i] = new double[Read_Double_Auction.getH(i)];
		double[][] X = new double[I][];
		for (int i = 0; i < I; i++)
			X[i] = new double[Read_Double_Auction.getJ(i)];
		int b = 0;
		for (int i = 0; i < N; i++)
			for (int j = 0; j < Y[i].length; j++)
				Y[i][j] = y[c++];

		for (int i = 0; i < I; i++)
			for (int j = 0; j < X[i].length; j++)
				X[i][j] =  x[b++];
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
		
		if (Fitness<x0+Epsilon)
			right = false;
		
		return right;
		
	}
	public static boolean checkInteger(double[] x, double[] y) {
		
		boolean MIP_feasible  = true;

		for(int i=0;i<Xsize;i++)
			if(x[i]%1!=0){
				MIP_feasible =false;
				break;
			}
		
		for(int i=0;i<Ysize;i++)
			if(y[i]%1!=0){
				MIP_feasible =false;
				break;
			}
		
		return MIP_feasible ;

	}
	
	public static boolean Step3_check_LP_goal_condition_infeasible(double[] x, double[] y) {
		
		boolean right = false;

		for(int i=0;i<Xsize;i++)
		{
			if(X_LP[i]<X_goalvalue[i] && X_Nup.contains(i))
			{
				right=true;
			}
			else if(X_LP[i]>X_goalvalue[i] && X_Ndn.contains(i))
			{
				right=true;
			}
		}
		
		for(int i=0;i<Ysize;i++)
		{
			if(Y_LP[i]<Y_goalvalue[i] && Y_Nup.contains(i))
			{
			right=true;
			}
			else if(Y_LP[i]>Y_goalvalue[i] && Y_Ndn.contains(i))
			{
			right=true;
			}
	}
		return right;
	}
	
	public static double Fitness(double[] x, double[] y) {
		 int c = 0;
		 double[][] Y = new double[N][];
			for (int i = 0; i < N; i++)
				Y[i] = new double[Read_Double_Auction.getH(i)];
			double[][] X = new double[I][];
			for (int i = 0; i < I; i++)
				X[i] = new double[Read_Double_Auction.getJ(i)];
			int b = 0;
			for (int i = 0; i < N; i++)
				for (int j = 0; j < Y[i].length; j++)
					Y[i][j] =y[c++];

			for (int i = 0; i < I; i++)
				for (int j = 0; j < X[i].length; j++)
					X[i][j] = x[b++];
			
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
	
	public static void	initialization_TabuTenure()
	{
		double k1,k3;

		if(Read_TS_Parameter.tabu_tenure_model()==1){
			k1=Math.random();
			
			while(true)
			{
				k3=Math.random();
				if(1>k3 && k3>k1)
					break;
			}
			Mintenure=k1*m;
			Maxtenure=k3*m;
		}else if(Read_TS_Parameter.tabu_tenure_model()==2)
		{
			Mintenure=Read_TS_Parameter.MinTenure();
			Maxtenure=Read_TS_Parameter.MaxTenure();
		}
		
		for (int i = 0; i < Xsize; i++){
		
			XTabuTenure_UP[i]=Mintenure;
			XTabuTenure_DN[i]=Mintenure;
			XAspire_UP[i]=-999999;
			XAspire_DN[i]=-999999;
			XMaxtenure[i]=Maxtenure;
		}
		for (int i = 0; i < Ysize; i++){
			YTabuTenure_UP[i]=Mintenure;
			YTabuTenure_DN[i]=Mintenure;
			YAspire_UP[i]=-999999;
			YAspire_DN[i]=-999999;
			YMaxtenure[i]=Maxtenure;
		}
	}

}
