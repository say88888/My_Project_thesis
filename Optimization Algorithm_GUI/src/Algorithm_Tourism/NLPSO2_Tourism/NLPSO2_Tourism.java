package Algorithm_Tourism.NLPSO2_Tourism;

  import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
  



 import Algorithm_Tourism.Function_Vector; 
import Input_Output_txt.Tourism.Output_A_B_C_txt;
import Input_Output_txt.Tourism.Output_EXCEL;
import Input_Output_txt.Tourism.Output_Result;
import Input_Output_txt.Tourism.Read_Group_Size;
import Input_Output_txt.Tourism.Read_Objective_Weight;
import Input_Output_txt.Tourism.Read_Tourism;
 

public class NLPSO2_Tourism {

	public static int Xasize = 0, Xhsize = 0, Xtsize = 0, Ysize = 0;
	public static int i1 = 0, i2 = 0;
	public static int Fittest_Iter;
	public static double myPopFitnessN_1;
	public static int N,Ia,Ih,It,K;
	public static double w;
	public static double c1;
	public static double prand;
	public static double psm;
	public static double Rfl;
	public static double Rfu;
	public static int Vmax;
	public static int Execution_Mode;
	public static int Print_Mode;
	public static int Write_Mode;
	public static int populationSize;
	public static double threshold;
	public static double PSO_lamda;
	private static int Iteration;
	private static int Iteration_Mode;
	public static int Local_Search_Iteration;
	public static double Omega_1,Omega_2;
	public static int[] Xa;
	public static int[] Xh;
	public static int[] Xt;
	public static int[] Y;	
	public static double Sfmin;
	public static int generationCount;
	public static StringBuilder SFminsb = new StringBuilder();
	public static StringBuilder sb = new StringBuilder();
	public static StringBuilder sb1 = new StringBuilder();
	public static StringBuilder sb2 = new StringBuilder();
	public static int n = 0;// 計算batch次數
 
	public static double F;
 
	public static long time_write_to_TXT;
	public static long T_total_time;
	
	public static int[] S;
	public static int s;
	public static List<List<Integer>> n3 = new ArrayList<List<Integer>>();


	private static List<Integer> Original_temp_variables_iteration = new ArrayList<Integer>();
	private static List<Double> Original_temp_variables_fitness_function_value = new ArrayList<Double>();
	private static List<String> Original_temp_variables_violate_restrictions = new ArrayList<String>();

	private static List<String> Original_temp_variables_Global_best_Xa = new ArrayList<String>();
	private static List<String> Original_temp_variables_Global_best_Xh = new ArrayList<String>();
	private static List<String> Original_temp_variables_Global_best_Xt = new ArrayList<String>();
	private static List<String> Original_temp_variables_Global_best_Y = new ArrayList<String>();
	public static ArrayList<List<Integer>> A = new ArrayList<List<Integer>>();
	public static ArrayList<Integer> B = new ArrayList<Integer>();
	public static ArrayList<Double> C = new ArrayList<Double>();

	public static void main() throws IOException {
		Original_temp_variables_iteration = new ArrayList<Integer>();
		Original_temp_variables_fitness_function_value = new ArrayList<Double>();
		Original_temp_variables_violate_restrictions = new ArrayList<String>();
		Original_temp_variables_Global_best_Xa = new ArrayList<String>();
		Original_temp_variables_Global_best_Xh = new ArrayList<String>();
		Original_temp_variables_Global_best_Xt = new ArrayList<String>();
		Original_temp_variables_Global_best_Y = new ArrayList<String>();
		Xasize = 0;
		Xhsize = 0;
		Xtsize = 0;
		Ysize = 0;
		Fittest_Iter = 0;
		time_write_to_TXT = 0;
		i1 = 0;
		i2 = 0;
		n = 0;
		sb = new StringBuilder();
		sb1 = new StringBuilder();
		sb2 = new StringBuilder();
		Read_Tourism.main();
		N = Read_Tourism.N();
		Ia = Read_Tourism.Ia();
		Ih = Read_Tourism.Ih();
		It = Read_Tourism.It();
		K = Read_Tourism.K();
		Read_Objective_Weight.main();
		Omega_1 = Read_Objective_Weight.Omega_1();
		Omega_2 = Read_Objective_Weight.Omega_2();

		A = new ArrayList<List<Integer>>();
		B = new ArrayList<Integer>();
		C = new ArrayList<Double>();
		A = Function_Vector.A_Vector();
		B = Function_Vector.B_Vector();
		C = Function_Vector.C_Vector(Omega_1, Omega_2);

		for (int i = 0; i < Read_Tourism.Ia(); i++)
			Xasize += Read_Tourism.Ja(i);
		for (int i = 0; i < Read_Tourism.Ih(); i++)
			Xhsize += Read_Tourism.Jh(i);
		for (int i = 0; i < Read_Tourism.It(); i++)
			Xtsize += Read_Tourism.Jt(i);
		for (int i = 0; i < Read_Tourism.N(); i++)
			Ysize += Read_Tourism.H(i);

		Xa = new int[Xasize];
		Xh = new int[Xhsize];
		Xt = new int[Xtsize];
		Y = new int[Ysize];

		PSO_Read_Write_txt.read_PSO_Parameter();
 
		Iteration_Mode = PSO_Read_Write_txt.Iteration_Mode();
		if (Iteration_Mode == 0 || Iteration_Mode == 2) {
			Iteration = PSO_Read_Write_txt.Iteration();
		} else {
			Iteration = Xasize + Xhsize + Xtsize + Ysize + Read_Tourism.K()
					+ 1 + Read_Tourism.Ia() * Read_Tourism.K()
					+ Read_Tourism.Ih() * Read_Tourism.M()
					+ Read_Tourism.It() * Read_Tourism.T();
		}
		populationSize = PSO_Read_Write_txt.populationSize();
		w = PSO_Read_Write_txt.w();
		c1 = PSO_Read_Write_txt.c1();
	 
		Vmax = PSO_Read_Write_txt.Vmax();
		Execution_Mode = PSO_Read_Write_txt.Execution_Mode();
		Print_Mode = PSO_Read_Write_txt.Print_Mode();
		Write_Mode = PSO_Read_Write_txt.Write_Mode();
		threshold = PSO_Read_Write_txt.threshold();
		PSO_lamda = PSO_Read_Write_txt.PSO_lamda();
		prand=PSO_Read_Write_txt.prand();
		psm=PSO_Read_Write_txt.psm();
		Rfl=PSO_Read_Write_txt.Rfl();
		Rfu=PSO_Read_Write_txt.Rfu();
		
		F = PSO_Read_Write_txt.random_generate_or_read2(Execution_Mode);
	  
		Read_Group_Size.main();
		S = new int[Read_Group_Size.S().size()];
		for (int i = 0; i < Read_Group_Size.S().size(); i++)
			S[i] = Read_Group_Size.S().get(i);
		long totalstartTime = System.currentTimeMillis();
		n3 = new ArrayList<List<Integer>>();
		// 進行分群
		PSO_Read_Write_txt.random_generate_or_read4(Execution_Mode);

		String str = "";
		long startTime = System.currentTimeMillis();
		Population myPop = new Population(populationSize, true);
		long endTime = System.currentTimeMillis();
		generationCount = 1;
		double Fittest;
		// F(X,Y)
		System.out.println();
		System.out.println("F2(X,Y)");
		PSO_Data_print.print2(myPop, Print_Mode);
		System.out.print("Generation: " + generationCount + " F(x,y) Fittest: " + myPop.getFittest().getFitness()
				+ " F2(x,y) Fittest: " + myPop.getFittest().getFitness1() + " Y=");
		str += "Generation=" + generationCount + " Fitness Function= " + myPop.getFittest().getFitness1();
		Fittest = myPop.getFittest().getFitness1();
		for (int i = 0; i < myPop.getFittest().Gysize(); i++) {
			Y[i] = myPop.getFittest().getGy(i);
			System.out.print(Y[i]);
		}
		System.out.print("Xa=");
		for (int j = 0; j < myPop.getFittest().Gxasize(); j++) {
			Xa[j] = myPop.getFittest().getGxa(j);
			System.out.print(Xa[j]);
		}
		System.out.print("Xh=");
		for (int j = 0; j < myPop.getFittest().Gxhsize(); j++) {
			Xh[j] = myPop.getFittest().getGxh(j);
			System.out.print(Xh[j]);
		}
		System.out.print("Xt=");
		for (int j = 0; j < myPop.getFittest().Gxtsize(); j++) {
			Xt[j] = myPop.getFittest().getGxt(j);
			System.out.print(Xt[j]);
		}
		System.out.print(" 執行時間: " + (endTime - startTime));

		if (Iteration_Mode == 2) {
			String Xa1 = "", Xh1 = "", Xt1 = "", Y1 = "";
			for (int i = 0; i < Xa.length; i++)
				Xa1 += Xa[i] + " ";
			for (int i = 0; i < Xh.length; i++)
				Xh1 += Xh[i] + " ";
			for (int i = 0; i < Xt.length; i++)
				Xt1 += Xt[i] + " ";
			for (int i = 0; i < Y.length; i++)
				Y1 += Y[i] + " ";

			Original_temp_variables_iteration.add(generationCount);
			Original_temp_variables_fitness_function_value.add(myPop.getFittest().getFitness1());
			Original_temp_variables_violate_restrictions.add(String.valueOf(constraint(Xa, Xh, Xt, Y)));
			Original_temp_variables_Global_best_Xa.add(Xa1);
			Original_temp_variables_Global_best_Xh.add(Xh1);
			Original_temp_variables_Global_best_Xt.add(Xt1);
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
		PSO_Data_print.print2(myPop, Print_Mode);

		for (int iter = 1; iter < Iteration; iter++) {

			if(myPop.getFittest().getFitness1() != myPopFitnessN_1){
				myPop=Algorithm.evolvePopulation_UpLM(myPop);
				myPop=Algorithm.evolvePopulation_Algorithm2(myPop);
			}
			System.out.println("  F2(x,y) Fittest: = " + myPop.getFittest().getFitness1()
					+ "   F2(x,y) Fittest 成長值 = "
					+ Math.abs(myPop.getFittest().getFitness1() - myPopFitnessN_1) / Math.abs(myPopFitnessN_1)
					+ "     限制式 : " + constraint(Xa, Xh, Xt, Y));
			// L_right = false;
			if (Iteration_Mode != 2) {

				if ((Math.abs(myPop.getFittest().getFitness1() - myPopFitnessN_1)
						/ Math.abs(myPopFitnessN_1) > threshold) || constraint(Xa, Xh, Xt, Y) == false
						|| myPop.getFittest().getFitness1() <= 0) {

					generationCount++;
					if ((Math.abs(myPop.getFittest().getFitness1() - myPopFitnessN_1)
							/ Math.abs(myPopFitnessN_1) > threshold))
						Fittest_Iter = generationCount;

					System.out.print(
							"Generation: " + generationCount + " F(x,y) Fittest: " + myPop.getFittest().getFitness()
									+ " F2(x,y) Fittest: " + myPop.getFittest().getFitness1() + " Y=");
					str += "Generation=" + generationCount + " Fitness Function= "
							+ myPop.getFittest().getFitness1();
					Fittest = myPop.getFittest().getFitness1();
					for (int i = 0; i < myPop.getFittest().Gysize(); i++) {
						Y[i] = myPop.getFittest().getGy(i);
						System.out.print(Y[i]);
					}
					System.out.print("Xa=");
					for (int j = 0; j < myPop.getFittest().Gxasize(); j++) {
						Xa[j] = myPop.getFittest().getGxa(j);
						System.out.print(Xa[j]);
					}
					System.out.print("Xh=");
					for (int j = 0; j < myPop.getFittest().Gxhsize(); j++) {
						Xh[j] = myPop.getFittest().getGxh(j);
						System.out.print(Xh[j]);
					}
					System.out.print("Xt=");
					for (int j = 0; j < myPop.getFittest().Gxtsize(); j++) {
						Xt[j] = myPop.getFittest().getGxt(j);
						System.out.print(Xt[j]);
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
					PSO_Data_print.print2(myPop, Print_Mode);

				} else {
					break;
				}
			} else {

				generationCount++;

				if ((Math.abs(myPop.getFittest().getFitness1() - myPopFitnessN_1)
						/ Math.abs(myPopFitnessN_1) > threshold))
					Fittest_Iter = generationCount;

				System.out.print(
						"Generation: " + generationCount + " F(x,y) Fittest: " + myPop.getFittest().getFitness()
								+ " F2(x,y) Fittest: " + myPop.getFittest().getFitness1() + " Y=");
				str += "Generation=" + generationCount + " Fitness Function= " + myPop.getFittest().getFitness1();
				Fittest = myPop.getFittest().getFitness1();
				for (int i = 0; i < myPop.getFittest().Gysize(); i++) {
					Y[i] = myPop.getFittest().getGy(i);
					System.out.print(Y[i]);
				}
				System.out.print("Xa=");
				for (int j = 0; j < myPop.getFittest().Gxasize(); j++) {
					Xa[j] = myPop.getFittest().getGxa(j);
					System.out.print(Xa[j]);
				}
				System.out.print("Xh=");
				for (int j = 0; j < myPop.getFittest().Gxhsize(); j++) {
					Xh[j] = myPop.getFittest().getGxh(j);
					System.out.print(Xh[j]);
				}
				System.out.print("Xt=");
				for (int j = 0; j < myPop.getFittest().Gxtsize(); j++) {
					Xt[j] = myPop.getFittest().getGxt(j);
					System.out.print(Xt[j]);
				}
				System.out.print(" 執行時間: " + (endTime - startTime));
				String Xa1 = "", Xh1 = "", Xt1 = "", Y1 = "";
				for (int i = 0; i < Xa.length; i++)
					Xa1 += Xa[i] + " ";
				for (int i = 0; i < Xh.length; i++)
					Xh1 += Xh[i] + " ";
				for (int i = 0; i < Xt.length; i++)
					Xt1 += Xt[i] + " ";
				for (int i = 0; i < Y.length; i++)
					Y1 += Y[i] + " ";

				Original_temp_variables_iteration.add(generationCount);
				Original_temp_variables_fitness_function_value.add(myPop.getFittest().getFitness1());
				Original_temp_variables_violate_restrictions.add(String.valueOf(constraint(Xa, Xh, Xt, Y)));
				Original_temp_variables_Global_best_Xa.add(Xa1);
				Original_temp_variables_Global_best_Xh.add(Xh1);
				Original_temp_variables_Global_best_Xt.add(Xt1);
				Original_temp_variables_Global_best_Y.add(Y1);
				str += " Time= " + (endTime - startTime) + "ms\r\n";
				System.out.println();
				myPopFitnessN_1 = myPop.getFittest().getFitness1();
				Sfmin = FitnessCalc.getSFmin(SFminsb);
				startTime = System.currentTimeMillis();

				myPop = Algorithm.evolvePopulation(myPop);

				endTime = System.currentTimeMillis();
				SFminsb = new StringBuilder();
				PSO_Data_print.print2(myPop, Print_Mode);
			}

		}

		System.out.println("Solution found!");
		System.out.println("Generation: " + generationCount);
		long totalendTime = System.currentTimeMillis();
		T_total_time = totalendTime - totalstartTime;
		System.out.println("執行時間 T_total_time=" + T_total_time + "ms");
		System.out.println("執行時間扣除寫檔時間  T_net=" + (T_total_time - time_write_to_TXT) + "ms");
		CheckConstraint.CheckConstraints();
 		Output_Result.Tourism(Y, Xa, Xh, Xt, Fittest, generationCount, T_total_time,
				(T_total_time - time_write_to_TXT), str);
		String Xa1 = "", Xh1 = "", Xt1 = "", Y1 = "";
		for (int i = 0; i < Xa.length; i++)
			Xa1 += Xa[i] + " ";
		for (int i = 0; i < Xh.length; i++)
			Xh1 += Xh[i] + " ";
		for (int i = 0; i < Xt.length; i++)
			Xt1 += Xt[i] + " ";
		for (int i = 0; i < Y.length; i++)
			Y1 += Y[i] + " ";
		Output_EXCEL.main(N, Ia, Ih, It, K, Omega_1, Omega_2, Xa1, Xh1, Xt1, Y1, Fittest, Iteration, Fittest_Iter, T_total_time, (T_total_time - time_write_to_TXT), constraint(Xa, Xh, Xt, Y));

		if (Iteration_Mode == 2)
			Output_EXCEL.Original_data(Original_temp_variables_iteration, Original_temp_variables_fitness_function_value, Original_temp_variables_violate_restrictions, Original_temp_variables_Global_best_Xa
					, Original_temp_variables_Global_best_Xh, Original_temp_variables_Global_best_Xt, Original_temp_variables_Global_best_Y);

		Output_A_B_C_txt.A_B_C_txt(A, B, C);

	}

	public static double Xa(int i) {
		return Xa[i];
	}

	public static double Xh(int i) {
		return Xh[i];
	}

	public static double Xt(int i) {
		return Xt[i];
	}

	public static double Y(int i) {
		return Y[i];
	}

	static boolean constraint(int[] xa, int[] xh, int[] xt, int[] y) {
		boolean right = true;

		int[][] Y = new int[Read_Tourism.N()][];
		for (int i = 0; i < Read_Tourism.N(); i++)
			Y[i] = new int[Read_Tourism.H(i)];

		int[][] Xa = new int[Read_Tourism.Ia()][];
		for (int i = 0; i < Read_Tourism.Ia(); i++)
			Xa[i] = new int[Read_Tourism.Ja(i)];

		int[][] Xh = new int[Read_Tourism.Ih()][];
		for (int i = 0; i < Read_Tourism.Ih(); i++)
			Xh[i] = new int[Read_Tourism.Jh(i)];

		int[][] Xt = new int[Read_Tourism.It()][];
		for (int i = 0; i < Read_Tourism.It(); i++)
			Xt[i] = new int[Read_Tourism.Jt(i)];

		int b = 0;
		for (int i = 0; i < Y.length; i++)
			for (int j = 0; j < Y[i].length; j++)
				Y[i][j] = y[b++];
		b = 0;
		for (int i = 0; i < Xa.length; i++)
			for (int j = 0; j < Xa[i].length; j++)
				Xa[i][j] = xa[b++];
		b = 0;
		for (int i = 0; i < Xh.length; i++)
			for (int j = 0; j < Xh[i].length; j++)
				Xh[i][j] = xh[b++];
		b = 0;
		for (int i = 0; i < Xt.length; i++)
			for (int j = 0; j < Xt[i].length; j++)
				Xt[i][j] = xt[b++];

		right = Function_Vector.constraint(Xa, Xh, Xt, Y, A, B);

		return right;
	}
}
