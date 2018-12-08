package Algorithm_Carpool.Lagrangian_Relaxation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Input_Output_txt.Read_LR_Parameter;
import Input_Output_txt.Carpool.Output_EXCEL;
import Input_Output_txt.Carpool.Output_Result;
import Input_Output_txt.Carpool.Read_Objective_Weight;
import Input_Output_txt.Carpool.Read_file;


public class LR {
	
	public static int P;
	public static int D;
	public static int K;
	
	public static int Print_Mode;

	public static double L;
	public static double c;
	public static int Print;
	public static double[] Lambda1; //λ
	public static double Lambda2;
	public static double[][] Lambda3;
	public static double[][] Lambda4;
 
	private static int[][] X;
	private static int[][] Y;

	public static 	int generationCount ;
	public static double Omega_1,Omega_2,Omega_3,Omega_4,Omega_5,Omega_6,Omega_7,Omega_8;
	
	private static List<Integer> Original_temp_variables_iteration = new ArrayList<Integer>();
	private static List<Double> Original_temp_variables_fitness_function_value = new ArrayList<Double>();
	private static List<String> Original_temp_variables_violate_restrictions = new ArrayList<String>();
	
	private static List<String> Original_temp_variables_Global_best_X = new ArrayList<String>();
	private static List<String> Original_temp_variables_Global_best_Y = new ArrayList<String>();
	public static void main( ) throws IOException {
		Original_temp_variables_iteration = new ArrayList<Integer>();
		Original_temp_variables_fitness_function_value = new ArrayList<Double>();
		Original_temp_variables_violate_restrictions = new ArrayList<String>();
		Original_temp_variables_Global_best_X = new ArrayList<String>();
		Original_temp_variables_Global_best_Y = new ArrayList<String>();
		Read_Objective_Weight.main();
		Omega_1=Read_Objective_Weight.Omega_1();
		Omega_2=Read_Objective_Weight.Omega_2();
		Omega_3=Read_Objective_Weight.Omega_3();
		Omega_4=Read_Objective_Weight.Omega_4();
		Omega_5=Read_Objective_Weight.Omega_5();
		Omega_6=Read_Objective_Weight.Omega_6();
		Omega_7=Read_Objective_Weight.Omega_7();
		Omega_8=Read_Objective_Weight.Omega_8();
		Read_file.loadData();
		P = Read_file.getP();
		D = Read_file.getD();
		K = Read_file.getK();
		
		Y = new int[P][];
	
		for (int i = 0; i < P; i++){
			Y[i] = new int[Read_file.getHp(i)];
		}
		X = new int[D][];
		for (int i = 0; i <D; i++){
			X[i] = new int[Read_file.getJd(i)];
		}
		
		Lambda1=new double[K];
		Lambda3 = new double[D][];
		Lambda4 = new double[D][];
		
		Read_LR_Parameter.main();
		L=Read_LR_Parameter.L();
		c=Read_LR_Parameter.c();
		Print=Read_LR_Parameter.Print();

			for (int i = 0; i < D; i++){
				Lambda3[i] = new double[Read_file.getJd(i)];
				Lambda4[i] = new double[Read_file.getJd(i)];
			}
			 
			for(int i=0;i<Lambda1.length;i++)
				Lambda1[i]=0;
			Lambda2=0;
			for(int i=0;i<D;i++)
				for(int j=0;j<Lambda3[i].length;j++){
					Lambda3[i][j] = 0;
					Lambda4[i][j] = 0;
				}
		
		 generationCount = 1;
		// F(X,Y)
		System.out.println();
		System.out.println("F1(X,Y)");
		Print_Lambda_g.main(X, Y);
		
		long totalstartTime = System.currentTimeMillis();
		long startTime = System.currentTimeMillis();
		X=Functions.Xdj(X);
		Y=Functions.Yph(Y);
		long endTime = System.currentTimeMillis();
		
		for(int i=0;i<Y.length;i++)
			for(int j=0;j<Y[i].length;j++){
				System.out.print(Y[i][j]);
			}
		System.out.print("X=");
		for(int i=0;i<X.length;i++)
			for(int j=0;j<X[i].length;j++){
				System.out.print(X[i][j]);
			}
		System.out.println("  F(X,Y)=  "+Functions.L(X, Y));
		
		 Updata_Lambda.Updata_Lambda(X, Y);
		 Print_Lambda_g.main(X, Y);
		 
		 while (constraint(X, Y)==false)
		 {	
			 generationCount++;
				 startTime = System.currentTimeMillis();
				X=Functions.Xdj(X);
				Y=Functions.Yph(Y);
				 endTime = System.currentTimeMillis();
				System.out.print("Y=");
				for(int i=0;i<Y.length;i++)
					for(int j=0;j<Y[i].length;j++){
						System.out.print(Y[i][j]);
					}
				System.out.print("X=");
				for(int i=0;i<X.length;i++)
					for(int j=0;j<X[i].length;j++){
						System.out.print(X[i][j]);
					}
			
				System.out.println("  F(X,Y)=  "+Functions.L(X, Y));
				System.out.print(" 執行時間: "+(endTime-startTime));
				String X1="",Y1="";
				for(int i=0;i<X.length;i++)
						X1+=X[i]+" ";
				for(int i=0;i<Y.length;i++)
						Y1+=Y[i]+" ";
	
				Original_temp_variables_iteration.add(generationCount);
				Original_temp_variables_fitness_function_value.add(Functions.L(X, Y));
				Original_temp_variables_violate_restrictions.add(String.valueOf(constraint(X, Y)));
				Original_temp_variables_Global_best_X.add(X1);
				Original_temp_variables_Global_best_Y.add(Y1);
				System.out.println();
				 Updata_Lambda.Updata_Lambda(X, Y);
				 Print_Lambda_g.main(X, Y);
		 }
		 
		System.out.println();
		 CheckConstraint.CheckConstraints(X, Y);
		 long totalendTime = System.currentTimeMillis();
		 
		 Output_Result.LR(Y, X, Functions.L(X, Y), generationCount, totalendTime-totalstartTime);
		 String X1="",Y1="";
		 for(int i=0;i<X.length;i++)
				for(int j=0;j<X[i].length;j++)
					X1+=X[i][j]+" ";
			for(int i=0;i<Y.length;i++)
				for(int j=0;j<Y[i].length;j++)
					Y1+=Y[i][j]+" ";
			Output_EXCEL.main(D,P,Omega_1,Omega_2,Omega_3,Omega_4,Omega_5,Omega_6,Omega_7,Omega_8 ,X1, Y1, Functions.L(X, Y), 0, generationCount, totalendTime-totalstartTime, totalendTime-totalstartTime,constraint(X, Y));
	
		//	Output_EXCEL.Original_data(Original_temp_variables_iteration,Original_temp_variables_fitness_function_value,Original_temp_variables_violate_restrictions,Original_temp_variables_Global_best_X,Original_temp_variables_Global_best_Y);
				
		 
	}

	public static int X(int i,int j) {
		return X[i][j];
	}

	public static int Y(int i,int j) {
		return Y[i][j];
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
		return right;
	}
}
