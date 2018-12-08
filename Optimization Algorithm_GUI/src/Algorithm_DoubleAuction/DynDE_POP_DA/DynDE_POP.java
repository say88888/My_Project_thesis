package Algorithm_DoubleAuction.DynDE_POP_DA;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
 
 
import Input_Output_txt.Double_Auction.Output_EXCEL;
import Input_Output_txt.Double_Auction.Output_Result;
import Input_Output_txt.Double_Auction.Read_Double_Auction;
 
public class DynDE_POP {

	public static int Xsize = 0, Ysize = 0;
	public static int i1 = 0, i2 = 0;
	public static int Fittest_Iter;
	public static int N;
	public static int I;
	public static int K;

	public static int Vmax;
	public static int Execution_Mode;
	public static int Write_Mode;
	public static int Print_Mode;
	public static int populationSize;
	public static double threshold;
	public static int Pmax;
	public static int PmaxNumbertimes;
	//public static double Epsilon;
	public static int Iteration;
	public static int Iteration_Mode;
 	public static double lamda;
	public static double rcloud;
	public static double Sigma;
	public static double F;
	public static double CR;
	public static int S;
	public static int Mode1,Mode2,Mode3,Mode4;
	public static int[] GX;
	public static int[] GY;
	public static double Sfmin;
	public static int generationCount;
	public static StringBuilder SFminsb = new StringBuilder();
	public static StringBuilder sb = new StringBuilder();
	public static StringBuilder sb1 = new StringBuilder();
	public static StringBuilder sb2 = new StringBuilder();
	public static int b;
	public static int n = 0;// 計算batch次數
//	public static ArrayList<Double> successfulF = new ArrayList<Double>();
//	public static ArrayList<Double> successfulCR = new ArrayList<Double>();
 
//	public static int[] S;
	public static int s;
	public static List<List<Integer>> n3 = new ArrayList<List<Integer>>();
	
	public static long time_write_to_TXT;
	public static long T_total_time;
	 
	private static List<Integer> Original_temp_variables_iteration = new ArrayList<Integer>();
	private static List<Double> Original_temp_variables_fitness_function_value = new ArrayList<Double>();
	private static List<String> Original_temp_variables_violate_restrictions = new ArrayList<String>();
	
	private static List<String> Original_temp_variables_Global_best_X = new ArrayList<String>();
	private static List<String> Original_temp_variables_Global_best_Y = new ArrayList<String>();
	public static List<Integer> Iter = new ArrayList<Integer>();
	public static List<Integer> Ppopsize = new ArrayList<Integer>();
	public static List<Integer> Type = new ArrayList<Integer>();
	public static void main() throws IOException {
		Original_temp_variables_iteration = new ArrayList<Integer>();
		Original_temp_variables_fitness_function_value = new ArrayList<Double>();
		Original_temp_variables_violate_restrictions = new ArrayList<String>();
		Original_temp_variables_Global_best_X = new ArrayList<String>();
		Original_temp_variables_Global_best_Y = new ArrayList<String>();
		
		 
		Sfmin=0;
		SFminsb = new StringBuilder();
		Iter = new ArrayList<Integer>();
		Ppopsize = new ArrayList<Integer>();
		Type = new ArrayList<Integer>();
		time_write_to_TXT = 0;
		Xsize = 0;
		Ysize = 0;
		Fittest_Iter=0;
		i1 = 0;
		i2 = 0;
		n = 0;
		sb = new StringBuilder();
		sb1 = new StringBuilder();
		sb2 = new StringBuilder();
		Read_Double_Auction.main();
		N = Read_Double_Auction.getN();
		I = Read_Double_Auction.getI();
		K = Read_Double_Auction.getK();

		for (int i = 0; i < I; i++)
			Xsize += Read_Double_Auction.getJ(i);
		for (int i = 0; i < N; i++)
			Ysize += Read_Double_Auction.getH(i);

		GX = new int[Xsize];
		GY = new int[Ysize];

		DE_Read_Write_txt.Read_NSDE_Parameter(); 
		populationSize = DE_Read_Write_txt.NP();
		//Epsilon = DE_Read_Write_txt.Epsilon();

		Iteration_Mode = DE_Read_Write_txt.Iteration_Mode();

		if (Iteration_Mode == 0  || Iteration_Mode==2) {
			Iteration = DE_Read_Write_txt.Iteration();
		} else {
			Iteration = Xsize + Ysize + K + 1 + I * K;
		}
		System.out.print(Iteration);
		
		Execution_Mode = DE_Read_Write_txt.Execution_Mode();
		Write_Mode = DE_Read_Write_txt.write_Mode();
		rcloud=DE_Read_Write_txt.rcloud();
		Sigma=DE_Read_Write_txt.Sigma();
		 
		Vmax=DE_Read_Write_txt.Vmax();
		lamda=DE_Read_Write_txt.lamda();
 
	 
		Pmax=DE_Read_Write_txt.Pmax();
		S=DE_Read_Write_txt.S();
		Mode1=DE_Read_Write_txt.Mode1();
		Mode2=DE_Read_Write_txt.Mode2();
		Mode3=DE_Read_Write_txt.Mode3();
		Mode4=DE_Read_Write_txt.Mode4();
		
		for(int i=0;i<Mode1;i++)
 			Type.add(1);
 		for(int i=0;i<Mode2;i++)
 			Type.add(2);
 		for(int i=0;i<Mode3;i++)
 			Type.add(3);
 		for(int i=0;i<Mode4;i++)
 			Type.add(4);
 		n3 = new ArrayList<List<Integer>>();
		for(int i=0;i<S;i++){
			 List<Integer> n1 = new ArrayList<Integer>();
			for(int j=0;j<populationSize;j++)
				n1.add(j+i*populationSize);
			n3.add(n1);
		}
		System.out.println(n3);
		int popsize=populationSize;
		for(int i=0;i<Pmax;i++){
			Iter.add(Iteration/Pmax);
			Ppopsize.add(popsize);
			popsize/=2;
 		}
		PmaxNumbertimes=0;
		generationCount = 1;
		int totalpopsize=populationSize*S;
		String str = "";
		long totalstartTime = System.currentTimeMillis();
		long startTime = System.currentTimeMillis();
		Population myPop = new Population(totalpopsize, true);
		long endTime = System.currentTimeMillis();
		
		double myPopFitnessN_1, Fittest;
		// F(X,Y)
		System.out.println();
		System.out.println("F2(X,Y)");
		DE_Data_print.print2(myPop, Print_Mode);
		System.out.print("Generation: " + generationCount + " F(x,y) Fittest: "
				+ myPop.getFittest().getFitness() + " F2(x,y) Fittest: "
				+ myPop.getFittest().getFitness1() + " Y=");
		str += "Generation=" + generationCount + " Fitness Function= "
				+ myPop.getFittest().getFitness1();
		Fittest = myPop.getFittest().getFitness1();
		for (int i = 0; i < myPop.getFittest().Gysize(); i++) {
			GY[i]=myPop.getFittest().getbinaryGy(i);
			System.out.print(GY[i]);
		}
			
		
		System.out.print("X=");
		for (int j = 0; j < myPop.getFittest().Gxsize(); j++) {
			GX[j]=myPop.getFittest().getbinaryGx(j);
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
		Original_temp_variables_fitness_function_value.add( myPop.getFittest().getFitness1());
		Original_temp_variables_violate_restrictions.add(String.valueOf(constraint(GX, GY)));
		Original_temp_variables_Global_best_X.add(X1);
		Original_temp_variables_Global_best_Y.add(Y1);
		 }
		str += " Time= " + (endTime - startTime) + "ms\r\n";
		System.out.println();
		myPopFitnessN_1 = myPop.getFittest().getFitness1();
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
				PmaxNumbertimes=p;
				 myPop.Update_Population();
				}
		for (int t = 0; t < Iter.get(p); t++) {
			 System.out.println("  F2(x,y) Fittest: = "+ myPop.getFittest().getFitness1() +"   F2(x,y) Fittest 成長值 = "+Math.abs(myPop.getFittest().getFitness1()-myPopFitnessN_1)/Math.abs(myPopFitnessN_1)+"     限制式 : " + constraint(GX, GY));
				
			 if(Iteration_Mode!=2){
			 
			 if((Math.abs(myPop.getFittest().getFitness1()-myPopFitnessN_1)/Math.abs(myPopFitnessN_1) > threshold) || constraint(GX, GY)==false || myPop.getFittest().getFitness1()<=0) {
	

			/*	if (generationCount > LP)
					Function.Update_p_f_cr();*/

				generationCount++;
				if((Math.abs(myPop.getFittest().getFitness1()-myPopFitnessN_1)/Math.abs(myPopFitnessN_1) > threshold))
					Fittest_Iter=generationCount;
		
				System.out.print("Generation: " + generationCount
						+ " F(x,y) Fittest: " + myPop.getFittest().getFitness()
						+ " F2(x,y) Fittest: "
						+ myPop.getFittest().getFitness1() + " Y=");
				str += "Generation=" + generationCount + " Fitness Function= "
						+ myPop.getFittest().getFitness1();
				Fittest = myPop.getFittest().getFitness1();
				for (int i = 0; i < myPop.getFittest().Gysize(); i++) {
					GY[i]=myPop.getFittest().getbinaryGy(i);
					System.out.print(GY[i]);
				}
					
				
				System.out.print("X=");
				for (int j = 0; j < myPop.getFittest().Gxsize(); j++) {
					GX[j]=myPop.getFittest().getbinaryGx(j);
					System.out.print(GX[j]);
				}
				System.out.print(" 執行時間: " + (endTime - startTime));
				str += " Time= " + (endTime - startTime) + "ms\r\n";
				System.out.println();
				myPopFitnessN_1 = myPop.getFittest().getFitness1();
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
					if((Math.abs(myPop.getFittest().getFitness1()-myPopFitnessN_1)/Math.abs(myPopFitnessN_1) > threshold))
						Fittest_Iter=generationCount;
			
					System.out.print("Generation: " + generationCount
							+ " F(x,y) Fittest: " + myPop.getFittest().getFitness()
							+ " F2(x,y) Fittest: "
							+ myPop.getFittest().getFitness1() + " Y=");
					str += "Generation=" + generationCount + " Fitness Function= "
							+ myPop.getFittest().getFitness1();
					Fittest = myPop.getFittest().getFitness1();
					for (int i = 0; i < myPop.getFittest().Gysize(); i++) {
						GY[i]=myPop.getFittest().getbinaryGy(i);
						System.out.print(GY[i]);
					}
						
					
					System.out.print("X=");
					for (int j = 0; j < myPop.getFittest().Gxsize(); j++) {
						GX[j]=myPop.getFittest().getbinaryGx(j);
						System.out.print(GX[j]);
					}
					System.out.print(" 執行時間: " + (endTime - startTime));
					String X1="",Y1="";
					for(int i=0;i<GX.length;i++)
							X1+=GX[i]+" ";
					for(int i=0;i<GY.length;i++)
							Y1+=GY[i]+" ";
		
			Original_temp_variables_iteration.add(generationCount);
			Original_temp_variables_fitness_function_value.add( myPop.getFittest().getFitness1());
			Original_temp_variables_violate_restrictions.add(String.valueOf(constraint(GX, GY)));
			Original_temp_variables_Global_best_X.add(X1);
			Original_temp_variables_Global_best_Y.add(Y1);
					str += " Time= " + (endTime - startTime) + "ms\r\n";
					System.out.println();
					myPopFitnessN_1 = myPop.getFittest().getFitness1();
					Sfmin = FitnessCalc.getSFmin(SFminsb);
					startTime = System.currentTimeMillis();

					myPop = Algorithm.evolvePopulation(myPop);
					endTime = System.currentTimeMillis();
					SFminsb = new StringBuilder();
					DE_Data_print.print2(myPop, Print_Mode);}
		}
		}
		System.out.println("Solution found!");
		System.out.println("Generation: " + generationCount);
		long totalendTime = System.currentTimeMillis();
		T_total_time = totalendTime - totalstartTime;
		System.out.println("執行時間 T_total_time=" + T_total_time + "ms");
		System.out.println("執行時間扣除寫檔時間  T_net="
				+ (T_total_time - time_write_to_TXT) + "ms");
		CheckConstraint.CheckConstraints();
		Output_Result.DynDE_POP(GY, GX, Fittest, Fittest_Iter,T_total_time, (T_total_time-time_write_to_TXT),str);
		String X1="",Y1="";
		for(int i=0;i<GX.length;i++)
			X1+=GX[i]+" ";
		for(int i=0;i<GY.length;i++)
			Y1+=GY[i]+" ";
		Output_EXCEL.main(N, I, K, X1, Y1, Fittest, Iteration, Fittest_Iter, T_total_time,
				(T_total_time - time_write_to_TXT), constraint(GX, GY));
		if (Iteration_Mode == 2)
			Output_EXCEL.Original_data(Original_temp_variables_iteration,
					Original_temp_variables_fitness_function_value, Original_temp_variables_violate_restrictions,
					Original_temp_variables_Global_best_X, Original_temp_variables_Global_best_Y);
	
}

	public static double X(int i) {
		return GX[i];
	}

	public static double Y(int i) {
		return GY[i];
	}

	static boolean constraint(int[] x, int[] y) {
		boolean right = true;
		double st221 = 0, st222 = 0;
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
				st232 += X[i][j] * Read_Double_Auction.getPij(i, j);
		if (st231 < st232)
			right = false;

		double st241 = 0;
		for (int i = 0; i < I; i++)
			for (int k = 0; k < K; k++) {
				for (int j = 0; j < X[i].length; j++)
					st241 += X[i][j] * Read_Double_Auction.getqijk(i, j, k);
				if (st241 > Read_Double_Auction.getSik(i, k))
					right = false;
				st241 = 0;
			}

		return right;
	}
}
