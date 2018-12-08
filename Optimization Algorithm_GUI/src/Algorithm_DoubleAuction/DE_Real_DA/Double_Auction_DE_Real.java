package Algorithm_DoubleAuction.DE_Real_DA;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Input_Output_txt.Double_Auction.Output_EXCEL;
 
import Input_Output_txt.Double_Auction.Output_Result;
import Input_Output_txt.Double_Auction.Read_Double_Auction;
import Input_Output_txt.Double_Auction.Read_Omega;
 
public class Double_Auction_DE_Real {

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
	public static double Epsilon;
	public static int Iteration;
	public static int Iteration_Mode;
	public static double lamda;
//	public static double[] p;
//	public static double[] f;
//	public static double[] cr;
//	public static int[] s;
	public static double F;
	public static double CR;
	public static int[] GX;
	public static int[] GY;
	public static double Sfmin;
	public static int generationCount;
	public static StringBuilder SFminsb = new StringBuilder();
	public static StringBuilder sb = new StringBuilder();
	public static StringBuilder sb1 = new StringBuilder();
	public static int b;
	public static int n = 0;// 計算batch次數
	//public static ArrayList<Double> successfulF = new ArrayList<Double>();
	//public static ArrayList<Double> successfulCR = new ArrayList<Double>();

	public static long time_write_to_TXT;
	public static long T_total_time;
	private static List<Integer> Original_temp_variables_iteration = new ArrayList<Integer>();
	private static List<Double> Original_temp_variables_fitness_function_value = new ArrayList<Double>();
	private static List<String> Original_temp_variables_violate_restrictions = new ArrayList<String>();
	
	private static List<String> Original_temp_variables_Global_best_X = new ArrayList<String>();
	private static List<String> Original_temp_variables_Global_best_Y = new ArrayList<String>();
	
	public static double Global_fittest =-999999999;
	
	public static double Omega1,Omega2,Omega3,Omega4;
	
	public static List<String> Original_temp_variables_Global_best_rs = new ArrayList<String>();
	public static List<String> Original_temp_variables_Global_best_rb = new ArrayList<String>();
	public static List<String> Original_temp_variables_Global_best_r = new ArrayList<String>();
	public static double[] rs;
	public static double[] rb;
	public static double r;
	public static void main() throws IOException {
		Original_temp_variables_iteration = new ArrayList<Integer>();
		Original_temp_variables_fitness_function_value = new ArrayList<Double>();
		Original_temp_variables_violate_restrictions = new ArrayList<String>();
		Original_temp_variables_Global_best_X = new ArrayList<String>();
		Original_temp_variables_Global_best_Y = new ArrayList<String>();
		Original_temp_variables_Global_best_rs = new ArrayList<String>();
		Original_temp_variables_Global_best_rb = new ArrayList<String>();
		Original_temp_variables_Global_best_r = new ArrayList<String>();
		r=0;
		Fittest_Iter=0;
		Global_fittest =-999999999;
		time_write_to_TXT = 0;
		Sfmin=0;
		SFminsb = new StringBuilder();
		Xsize = 0;
		Ysize = 0;
		i1 = 0;
		i2 = 0;
		n = 0;
		sb = new StringBuilder();
		sb1 = new StringBuilder();
		Read_Double_Auction.main();
		N = Read_Double_Auction.getN();
		I = Read_Double_Auction.getI();
		K = Read_Double_Auction.getK();

		Read_Omega.main();
		Omega1=Read_Omega.Omega_1();
		Omega2=Read_Omega.Omega_2();
		Omega3=Read_Omega.Omega_3();
		Omega4=Read_Omega.Omega_4();
		
		for (int i = 0; i < I; i++)
			Xsize += Read_Double_Auction.getJ(i);
		for (int i = 0; i < N; i++)
			Ysize += Read_Double_Auction.getH(i);

		GX = new int[Xsize];
		GY = new int[Ysize];

		if(Omega2==1 || Omega3==1){
			rs=new double[Xsize];
			rb=new double[Ysize];
		}
		
		DE_Read_Write_txt.Read_DEReal_Parameter(); 
		populationSize = DE_Read_Write_txt.NP();
	//	LP = DE_Read_Write_txt.LP();
		Epsilon = DE_Read_Write_txt.Epsilon();

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
		F = DE_Read_Write_txt.random_generate_or_read5(Execution_Mode);
		CR = 0.5;
	/*	f = new double[6];
		cr = new double[6];
		p = new double[6];
		s = new int[6];
		for (int i = 0; i < 6; i++) {
			f[i] = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
			cr[i]= 0.5;
			p[i] = 0.1666;
		}*/
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
		if(Omega2==1 || Omega3==1){
			System.out.print(" rs=");
			for (int j = 0; j < myPop.getFittest().rssize(); j++) {
				System.out.print(rs[j]+" ");
			}
			System.out.print(" rb=");
			for (int j = 0; j < myPop.getFittest().rbsize(); j++) {
				System.out.print(rb[j]+" ");
			}
		}
		if(Omega4==1){
			System.out.print(" r= ");
			System.out.print(r+" ");
		}
			
		System.out.print(" 執行時間: " + (endTime - startTime));
		 if(Iteration_Mode==2){
				String X1="",Y1="",rs1="",rb1="",r1="";
				for(int i=0;i<GX.length;i++)
						X1+=GX[i]+" ";
				for(int i=0;i<GY.length;i++)
						Y1+=GY[i]+" ";
				if(Omega2==1 || Omega3==1){
					for (int i = 0; i < GX.length; i++)
						rs1 += rs[i] + " ";
					for (int i = 0; i < GY.length; i++)
						rb1 += rb[i] + " ";
				}
				if(Omega4==1)
					r1+=r;
				
		Original_temp_variables_iteration.add(generationCount);
		Original_temp_variables_fitness_function_value.add( Global_fittest);
		Original_temp_variables_violate_restrictions.add(String.valueOf(constraint( )));
		Original_temp_variables_Global_best_X.add(X1);
		Original_temp_variables_Global_best_Y.add(Y1);
		if(Omega2==1|| Omega3==1){
			Original_temp_variables_Global_best_rs.add(rs1);
			Original_temp_variables_Global_best_rb.add(rb1);
		}
		if(Omega4==1)
			Original_temp_variables_Global_best_r.add(r1);
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
		for (int t = 0; t < Iteration; t++) {
			 System.out.println("  F2(x,y) Fittest: = "+ Global_fittest +"   F2(x,y) Fittest 成長值 = "+Math.abs(Global_fittest-myPopFitnessN_1)/Math.abs(myPopFitnessN_1)+"     限制式 : " + constraint( ));
				
			 if(Iteration_Mode!=2){
			
			 if((Math.abs(Global_fittest-myPopFitnessN_1)/Math.abs(myPopFitnessN_1) > threshold) || constraint( )==false || Global_fittest<=0) {
	

			/*	if (generationCount > LP)
					Function.Update_p_f_cr();*/

				generationCount++;
			//	 if(Math.abs(Global_fittest-myPopFitnessN_1)/Math.abs(myPopFitnessN_1) > 0)
				//	 Fittest_Iter=generationCount;
				System.out.print("Generation: " + generationCount
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
				if(Omega2==1 || Omega3==1){
					System.out.print(" rs=");
					for (int j = 0; j < myPop.getFittest().rssize(); j++) {
						System.out.print(rs[j]+" ");
					}
					System.out.print(" rb=");
					for (int j = 0; j < myPop.getFittest().rbsize(); j++) {
						System.out.print(rb[j]+" ");
					}
				}
				if(Omega4==1){
					System.out.print(" r= ");
					System.out.print(r+" ");
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
		//		 if(Math.abs(Global_fittest-myPopFitnessN_1)/Math.abs(myPopFitnessN_1) > 0)
			//		 Fittest_Iter=generationCount;
				System.out.print("Generation: " + generationCount
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
				if(Omega2==1 || Omega3==1){
					System.out.print(" rs=");
					for (int j = 0; j < myPop.getFittest().rssize(); j++) {
						System.out.print(rs[j]+" ");
					}
					System.out.print(" rb=");
					for (int j = 0; j < myPop.getFittest().rbsize(); j++) {
						System.out.print(rb[j]+" ");
					}
				}
				if(Omega4==1){
					System.out.print(" r= ");
					System.out.print(r+" ");
				}
				System.out.print(" 執行時間: " + (endTime - startTime));
				String X1="",Y1="",rs1="",rb1="",r1="";
				for(int i=0;i<GX.length;i++)
						X1+=GX[i]+" ";
				for(int i=0;i<GY.length;i++)
						Y1+=GY[i]+" ";
				if(Omega2==1 || Omega3==1){
					for (int i = 0; i < GX.length; i++)
						rs1 += rs[i] + " ";
					for (int i = 0; i < GY.length; i++)
						rb1 += rb[i] + " ";
				}
				if(Omega4==1)
					r1+=r;
				
		Original_temp_variables_iteration.add(generationCount);
		Original_temp_variables_fitness_function_value.add( Global_fittest);
		Original_temp_variables_violate_restrictions.add(String.valueOf(constraint( )));
		Original_temp_variables_Global_best_X.add(X1);
		Original_temp_variables_Global_best_Y.add(Y1);
		if(Omega2==1|| Omega3==1){
			Original_temp_variables_Global_best_rs.add(rs1);
			Original_temp_variables_Global_best_rb.add(rb1);
		}
		if(Omega4==1)
			Original_temp_variables_Global_best_r.add(r1);
				str += " Time= " + (endTime - startTime) + "ms\r\n";
				System.out.println();
				myPopFitnessN_1 = Global_fittest;
				Sfmin = FitnessCalc.getSFmin(SFminsb);
				startTime = System.currentTimeMillis();

				myPop = Algorithm.evolvePopulation(myPop);
				endTime = System.currentTimeMillis();
				SFminsb = new StringBuilder();
				DE_Data_print.print2(myPop, Print_Mode);
				 
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
		if(Omega1==1)
			Output_Result.DE_DA_Real(GY, GX, Fittest, Fittest_Iter, T_total_time,
				(T_total_time - time_write_to_TXT), str);
		else if(Omega2==1 || Omega3==1)
			Output_Result.DE_DA_Real_problem2(GY, GX, rb,rs,Fittest, Fittest_Iter, T_total_time,
					(T_total_time - time_write_to_TXT), str);
		else if(Omega4==1)
			Output_Result.DE_DA_Real_problem4(GY, GX, r,Fittest, Fittest_Iter, T_total_time,
					(T_total_time - time_write_to_TXT), str);
		String X1="",Y1="",rs1="",rb1="",r1="";
		for(int i=0;i<GX.length;i++)
				X1+=GX[i]+" ";
		for(int i=0;i<GY.length;i++)
				Y1+=GY[i]+" ";
		if(Omega2==1 || Omega3==1){
			for (int i = 0; i < GX.length; i++)
				rs1 += rs[i] + " ";
			for (int i = 0; i < GY.length; i++)
				rb1 += rb[i] + " ";
		}
		if(Omega4==1)
			r1+=r;
		if (Omega1 == 1) {
			Output_EXCEL.main(N, I, K, X1, Y1, Fittest, Iteration, Fittest_Iter, T_total_time, (T_total_time - time_write_to_TXT), constraint());
			if (Iteration_Mode == 2)
				Output_EXCEL.Original_data(Original_temp_variables_iteration, Original_temp_variables_fitness_function_value
						, Original_temp_variables_violate_restrictions, Original_temp_variables_Global_best_X
						, Original_temp_variables_Global_best_Y);
		} else if (Omega2 == 1 || Omega3 == 1) {
			Output_EXCEL.main2(N, I, K, X1, Y1, rs1, rb1, Fittest, Iteration, Fittest_Iter, T_total_time
					, (T_total_time - time_write_to_TXT), constraint());
			if (Iteration_Mode == 2)
				Output_EXCEL.Original_data2(Original_temp_variables_iteration, Original_temp_variables_fitness_function_value
						, Original_temp_variables_violate_restrictions, Original_temp_variables_Global_best_X
						, Original_temp_variables_Global_best_Y, Original_temp_variables_Global_best_rs
						, Original_temp_variables_Global_best_rb);
		} else if (Omega4 == 1) {
			Output_EXCEL.main3(N, I, K, X1, Y1, r1, Fittest, Iteration, Fittest_Iter, T_total_time
					, (T_total_time - time_write_to_TXT), constraint());
			if (Iteration_Mode == 2)
				Output_EXCEL.Original_data3(Original_temp_variables_iteration, Original_temp_variables_fitness_function_value
						, Original_temp_variables_violate_restrictions, Original_temp_variables_Global_best_X
						, Original_temp_variables_Global_best_Y, Original_temp_variables_Global_best_r);
		}
	}

	public static double X(int i) {
		return GX[i];
	}

	public static double Y(int i) {
		return GY[i];
	}

	public static boolean constraint() {
		boolean right = true;
		int c = 0;
		int[][] y = new int[N][];
		for (int i = 0; i < N; i++)
			y[i] = new int[Read_Double_Auction.getH(i)];
		int[][] x = new int[I][];
		for (int i = 0; i < I; i++)
			x[i] = new int[Read_Double_Auction.getJ(i)];
		int b = 0;
		for (int i = 0; i < N; i++)
			for (int j = 0; j < y[i].length; j++)
				y[i][j] = GY[c++];

		for (int i = 0; i < I; i++)
			for (int j = 0; j < x[i].length; j++)
				x[i][j] = GX[b++];
		
		if(Omega1==1)
			right = FitnessCalc.constraint(x, y);
		if(Omega2==1 || Omega3==1){
			 c = 0;
			double[][] rb1 = new double[N][];
			for (int i = 0; i < N; i++)
				rb1[i] = new double[Read_Double_Auction.getH(i)];
			double[][] rs1 = new double[I][];
			for (int i = 0; i < I; i++)
				rs1[i] = new double[Read_Double_Auction.getJ(i)];
			b = 0;
			for (int i = 0; i < N; i++)
				for (int j = 0; j < rb1[i].length; j++)
					rb1[i][j] = rb[c++];

			for (int i = 0; i < I; i++)
				for (int j = 0; j < rs1[i].length; j++)
					rs1[i][j] = rs[b++];
			
			if(Omega2==1)
				right = FitnessCalc.constraint2(x, y,rs1,rb1);
			if(Omega3==1)
				right = FitnessCalc.constraint3(x, y,rs1,rb1);
		}
		 if(Omega4==1){
			 right =FitnessCalc.constraint4(x, y, r);
		 }
		 
		return right;
	}
}
