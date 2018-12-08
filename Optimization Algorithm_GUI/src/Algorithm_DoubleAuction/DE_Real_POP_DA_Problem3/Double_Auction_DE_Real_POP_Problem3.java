package Algorithm_DoubleAuction.DE_Real_POP_DA_Problem3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
 
import Input_Output_txt.Double_Auction.Output_EXCEL;
 
import Input_Output_txt.Double_Auction.Output_Result;
import Input_Output_txt.Double_Auction.Read_Double_Auction_Problem3;
import Input_Output_txt.Double_Auction.Read_Seller_Price_Parameter;
import Input_Output_txt.Double_Auction.Read_Sik_Parameter;
 
public class Double_Auction_DE_Real_POP_Problem3 {

	public static int Xsize = 0, Ysize = 0;
	public static int i1 = 0, i2 = 0;
	public static int Fittest_Iter;
	public static int N;
	public static int I;
	public static int K;
	public static double w;
	public static double c1;
	public static double c2;
	public static int Vmax;
	public static int Execution_Mode;
	public static int Write_Mode;
	public static int Print_Mode;
	public static int populationSize;
	public static double threshold;
	//public static int LP;
//	public static double Epsilon;
	public static int Iteration;
	public static int Iteration_Mode;
	public static double lamda;
	public static int Pmax;
	public static int PmaxNumbertimes;
//	public static double[] p;
//	public static double[] f;
//	public static double[] cr;
//	public static int[] s;
	public static int ka;
	public static double F;
	public static double F1;
	public static double F2;
	
	public static double K1;
	public static double CR;
	public static int[] GX;
	public static int[] GY;
	public static int[] GmX;
	public static int[] GmY;
	public static int[] dv;
	public static double Sfmin;
	public static int generationCount;
	public static StringBuilder SFminsb = new StringBuilder();
	public static StringBuilder sb = new StringBuilder();
	public static StringBuilder sb1 = new StringBuilder();
	public static int b;
	public static int n = 0;// 計算batch次數
	public static int knumber;
	//public static ArrayList<Double> successfulF = new ArrayList<Double>();
	//public static ArrayList<Double> successfulCR = new ArrayList<Double>();

	public static long time_write_to_TXT;
	public static long T_total_time;
	private static List<Integer> Original_temp_variables_iteration = new ArrayList<Integer>();
	private static List<Double> Original_temp_variables_fitness_function_value = new ArrayList<Double>();
	private static List<String> Original_temp_variables_violate_restrictions = new ArrayList<String>();
	
	private static List<String> Original_temp_variables_Global_best_X = new ArrayList<String>();
	private static List<String> Original_temp_variables_Global_best_Y = new ArrayList<String>();
	public static List<Integer> Iter = new ArrayList<Integer>();
	public static List<Integer> Ppopsize = new ArrayList<Integer>();
	public static double Global_fittest =-999999999;
	
	public static void main() throws IOException {
		Original_temp_variables_iteration = new ArrayList<Integer>();
		Original_temp_variables_fitness_function_value = new ArrayList<Double>();
		Original_temp_variables_violate_restrictions = new ArrayList<String>();
		Original_temp_variables_Global_best_X = new ArrayList<String>();
		Original_temp_variables_Global_best_Y = new ArrayList<String>();
		Fittest_Iter=0;
		Global_fittest =-999999999;
		time_write_to_TXT = 0;
		Sfmin=0;
		SFminsb = new StringBuilder();
		Xsize = 0;
		Ysize = 0;
		i1 = 0;
		knumber=0;
		i2 = 0;
		n = 0;
		sb = new StringBuilder();
		sb1 = new StringBuilder();
		Read_Double_Auction_Problem3.main();
		N = Read_Double_Auction_Problem3.getN();
		I = Read_Double_Auction_Problem3.getI();
		K = Read_Double_Auction_Problem3.getK();

		for (int i = 0; i < I; i++)
			for(int n=0;n< N;n++)
				for(int h=0;h<Read_Double_Auction_Problem3.getH(n);h++)
					for(int k=0;k<K;k++)
						Xsize += 1;
		for (int i = 0; i < N; i++)
			Ysize += Read_Double_Auction_Problem3.getH(i);

		GX = new int[Xsize];
		GY = new int[Ysize];
		GmX = new int[Xsize];
		GmY = new int[Ysize];
		dv=new int[Xsize];

		Read_Sik_Parameter.main();
		Read_Seller_Price_Parameter.main();
		DE_Read_Write_txt.Read_DEReal_Parameter(); 
		populationSize = DE_Read_Write_txt.NP();
	//	LP = DE_Read_Write_txt.LP();
	//	Epsilon = DE_Read_Write_txt.Epsilon();

		Iteration_Mode = DE_Read_Write_txt.Iteration_Mode();

		if (Iteration_Mode == 0 || Iteration_Mode==2) {
			Iteration = DE_Read_Write_txt.Iteration();
		} else {
			Iteration = Xsize + Ysize + K + 1 + I * K;
		}
		System.out.print(Iteration);
		
		Execution_Mode = DE_Read_Write_txt.Execution_Mode();
		Write_Mode = DE_Read_Write_txt.write_Mode();
		Vmax=DE_Read_Write_txt.Vmax();
		lamda=-DE_Read_Write_txt.lamda();
		Pmax=DE_Read_Write_txt.Pmax();
		int popsize=populationSize;
		for(int i=0;i<Pmax;i++){
			Iter.add(Iteration/Pmax);
			Ppopsize.add(popsize);
			popsize/=2;
		}
		
	//	F = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
		F= DE_Read_Write_txt.F();
		F1=DE_Read_Write_txt.F1();
		F2=DE_Read_Write_txt.F2();
		K1=DE_Read_Write_txt.K1();
		CR = 0.5;
		ka=DE_Read_Write_txt.Ka();
		
	/*	f = new double[6];
		cr = new double[6];
		p = new double[6];
		s = new int[6];
		for (int i = 0; i < 6; i++) {
			f[i] = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
			cr[i]= 0.5;
			p[i] = 0.1666;
		}*/
		PmaxNumbertimes=0;
		generationCount = 1;
		String str = "";
		long totalstartTime = System.currentTimeMillis();
		long startTime = System.currentTimeMillis();
		Population myPop = new Population(populationSize, true);
		long endTime = System.currentTimeMillis();
		
		double myPopFitnessN_1, Fittest;
		// F(X,Y)
		System.out.println();
		System.out.println("F2(X,Y)");
		DE_Data_print.print2(myPop, Print_Mode);
		System.out.print("Generation: " + generationCount + " F(x,y) Fittest: "
				+ myPop.getFittest().getFitness() + " F2(x,y) Fittest: "
				+ Global_fittest + " Y=");
		str += "Generation=" + generationCount + " Fitness Function= "
				+ Global_fittest;
		Fittest = Global_fittest;
		for (int i = 0; i < myPop.getFittest().Ysize(); i++) {
			System.out.print(GY[i]);
		}
			
		
		System.out.print("X=");
		for (int j = 0; j < myPop.getFittest().Xsize(); j++) {
			System.out.print(GX[j]);
		}
		System.out.print(" 執行時間: " + (endTime - startTime));
		 if(Iteration_Mode==2){
				String X1="",Y1="";
				for(int i=0;i<GX.length;i++)
						X1+=GX[i]+" ";
				for(int i=0;i<GY.length;i++)
						Y1+=GY[i]+" ";
	
		Original_temp_variables_iteration.add(generationCount);
		Original_temp_variables_fitness_function_value.add( Global_fittest);
		Original_temp_variables_violate_restrictions.add(String.valueOf(constraint(GX, GY)));
		Original_temp_variables_Global_best_X.add(X1);
		Original_temp_variables_Global_best_Y.add(Y1);
		 }
		str += " Time= " + (endTime - startTime) + "ms\r\n";
		System.out.println();
		myPopFitnessN_1 = Global_fittest;
		Sfmin = FitnessCalc.getSFmin(SFminsb);
		startTime = System.currentTimeMillis();

		myPop = Algorithm.evolvePopulation(myPop);
		endTime = System.currentTimeMillis();
		SFminsb = new StringBuilder();
		DE_Data_print.print2(myPop, Print_Mode);

		/*
		 * while (Math.abs(Global_fittest - myPopFitnessN_1) /
		 * Math.abs(myPopFitnessN_1) > threshold) {
		 */
		for(int p=0;p<Pmax;p++){
			if(p>0){
				b=0;
				PmaxNumbertimes=p;
				 myPop.Update_Population();
				}
		for (int t = 0; t <  Iter.get(p); t++) {
			 System.out.println("  F2(x,y) Fittest: = "+ Global_fittest +"   F2(x,y) Fittest 成長值 = "+Math.abs(Global_fittest-myPopFitnessN_1)/Math.abs(myPopFitnessN_1)+"     限制式 : " + constraint(GX, GY));
				
			 if(Iteration_Mode!=2){
			
			 if((Math.abs(Global_fittest-myPopFitnessN_1)/Math.abs(myPopFitnessN_1) > threshold) || constraint(GX, GY)==false || Global_fittest<=0) {
	

			/*	if (generationCount > LP)
					Function.Update_p_f_cr();*/

				generationCount++;
				 if(Math.abs(Global_fittest-myPopFitnessN_1)/Math.abs(myPopFitnessN_1) > 0){
					 Fittest_Iter=generationCount;
				 knumber=0;
			 }else{
				 knumber+=1;
			 }				System.out.print("Generation: " + generationCount
						+ " F(x,y) Fittest: " + myPop.getFittest().getFitness()
						+ " F2(x,y) Fittest: "
						+ Global_fittest + " Y=");
				str += "Generation=" + generationCount + " Fitness Function= "
						+ Global_fittest;
				Fittest = Global_fittest;
				for (int i = 0; i < myPop.getFittest().Ysize(); i++) {
					System.out.print(GY[i]);
				}
					
				
				System.out.print("X=");
				for (int j = 0; j < myPop.getFittest().Xsize(); j++) {
					System.out.print(GX[j]);
				}
				System.out.print(" 執行時間: " + (endTime - startTime));
				str += " Time= " + (endTime - startTime) + "ms\r\n";
				System.out.println();
				myPopFitnessN_1 = Global_fittest;
				Sfmin = FitnessCalc.getSFmin(SFminsb);
				startTime = System.currentTimeMillis();

				myPop = Algorithm.evolvePopulation(myPop);
				endTime = System.currentTimeMillis();
				SFminsb = new StringBuilder();
				DE_Data_print.print2(myPop, Print_Mode);

			} else {
				break;
			}
			 }else{						
				 generationCount++;
				 if(Math.abs(Global_fittest-myPopFitnessN_1)/Math.abs(myPopFitnessN_1) > 0){
					 Fittest_Iter=generationCount;
					 knumber=0;
				 }else{
					 knumber+=1;
				 }				System.out.print("Generation: " + generationCount
						+ " F(x,y) Fittest: " + myPop.getFittest().getFitness()
						+ " F2(x,y) Fittest: "
						+ Global_fittest + " Y=");
				str += "Generation=" + generationCount + " Fitness Function= "
						+ Global_fittest;
				Fittest = Global_fittest;
				for (int i = 0; i < myPop.getFittest().Ysize(); i++) {
					System.out.print(GY[i]);
				}
				System.out.println();
				int a=0;
				System.out.println("X=");
				for(int i=0;i<I;i++)
					for(int n=0;n<N;n++)
						for(int h=0;h<Read_Double_Auction_Problem3.getH(n);h++){
							for(int k=0;k<K;k++)
								System.out.print(GX[a++]);
							System.out.println();
						}
		/*		for (int j = 0; j < myPop.getFittest().Xsize(); j++) {
					System.out.print(GX[j]);
				}*/
				System.out.print(" 執行時間: " + (endTime - startTime));
				String X1="",Y1="";
				for(int i=0;i<GX.length;i++)
						X1+=GX[i]+" ";
				for(int i=0;i<GY.length;i++)
						Y1+=GY[i]+" ";
	
		Original_temp_variables_iteration.add(generationCount);
		Original_temp_variables_fitness_function_value.add( Global_fittest);
		Original_temp_variables_violate_restrictions.add(String.valueOf(constraint(GX, GY)));
		Original_temp_variables_Global_best_X.add(X1);
		Original_temp_variables_Global_best_Y.add(Y1);
				str += " Time= " + (endTime - startTime) + "ms\r\n";
				System.out.println();
				myPopFitnessN_1 = Global_fittest;
				Sfmin = FitnessCalc.getSFmin(SFminsb);
				startTime = System.currentTimeMillis();

				myPop = Algorithm.evolvePopulation(myPop);
				if (knumber >= ka) {
					for (int i = 0; i < dv.length; i++)
						dv[i] = (-1 + DE_Read_Write_txt.random_generate_or_read2(Execution_Mode, 3));
					for (int i = 0; i < Xsize; i++){
						GmX[i] = GX[i] + dv[i];
						if(GmX[i]>Read_Sik_Parameter.top())
							GmX[i]=Read_Sik_Parameter.top();
						if(GmX[i]<0)
							GmX[i]=0;
					}
						
					
					for (int i = 0; i < Ysize; i++)
						GmY[i] = GY[i];
				} else {
					for (int i = 0; i < Xsize; i++)
						GmX[i] = GX[i];
					for (int i = 0; i < Ysize; i++)
						GmY[i] = GY[i];
				}
			
				if (FitnessCalc.getFitnes(GmX, GmY) > Global_fittest) {
					System.err.println("----------------");
					Global_fittest = FitnessCalc.getFitnes(GmX, GmY);
					for (int i = 0; i < Xsize; i++)
						GX[i] = GmX[i];
					for (int i = 0; i < Ysize; i++)
						GY[i] = GmY[i];
				}
				endTime = System.currentTimeMillis();
				
				SFminsb = new StringBuilder();
				DE_Data_print.print2(myPop, Print_Mode);
				 
			 }
		}

		}
		System.out.println("Solution found!");
		System.out.println("Generation: " + generationCount);
		long totalendTime = System.currentTimeMillis();
		T_total_time = totalendTime - totalstartTime;
		System.out.println("執行時間 T_total_time=" + T_total_time + "ms");
		System.out.println("執行時間扣除寫檔時間  T_net="
				+ (T_total_time - time_write_to_TXT) + "ms");
	//	CheckConstraint.CheckConstraints();
		Output_Result.DE_Real_POP_Problem3(GY, GX, Fittest, Fittest_Iter, T_total_time,
				(T_total_time - time_write_to_TXT), str);
		String X1="",Y1="";
		for(int i=0;i<GX.length;i++)
			X1+=GX[i]+" ";
		for(int i=0;i<GY.length;i++)
			Y1+=GY[i]+" ";
		Output_EXCEL.main(N, I, K, X1, Y1, Fittest, Iteration, Fittest_Iter, T_total_time, (T_total_time-time_write_to_TXT),constraint(GX, GY));
		 if(Iteration_Mode==2)
		Output_EXCEL.Original_data(Original_temp_variables_iteration,Original_temp_variables_fitness_function_value,Original_temp_variables_violate_restrictions,Original_temp_variables_Global_best_X,Original_temp_variables_Global_best_Y);

	}

	public static double X(int i) {
		return GX[i];
	}

	public static double Y(int i) {
		return GY[i];
	}

	public static boolean constraint(int[] x, int[] y) {
		boolean right = true;
	
		int c = 0;
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
		
		int b = 0;
		for (int i = 0; i < N; i++)
			for (int j = 0; j < Y[i].length; j++)
				Y[i][j] = y[c++];

		for (int i = 0; i < I; i++)
			for(int n=0;n<X[i].length;n++)
				for(int h=0;h<X[i][n].length;h++)
					for(int k=0;k<X[i][n][h].length;k++)
						X[i][n][h][k]= x[b++];
		
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
}
