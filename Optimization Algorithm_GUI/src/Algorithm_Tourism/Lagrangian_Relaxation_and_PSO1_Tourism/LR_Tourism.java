package Algorithm_Tourism.Lagrangian_Relaxation_and_PSO1_Tourism;

import java.io.IOException;

import Algorithm_Tourism.Lagrangain_Relaxation_Tourism.Functions;
import Algorithm_Tourism.Lagrangain_Relaxation_Tourism.Updata_Lambda;
import Input_Output_txt.Read_LR_Parameter;
 
import Input_Output_txt.Tourism.Output_Result;
import Input_Output_txt.Tourism.Read_Objective_Weight;
import Input_Output_txt.Tourism.Read_Tourism;
 
 
public class LR_Tourism extends LR_and_PSO1_Tourism{


	public static int i1 = 0, i2 = 0;
 
	public static double L;
	public static double c;
	public static int Print;
	public static double[] Lambda1; // λ
	public static double[] Lambda2; // λ
	public static double[] Lambda3; // λ
	public static double Lambda4;
	public static double[][] Lambda5;
	public static double[][] Lambda6;
	public static double[][] Lambda7;
	public static int[][] Xa;
	public static int[][] Xh;
	public static int[][] Xt;
	public static int[][] Y;
	public static int generationCount;
	public static StringBuilder sb = new StringBuilder();
	public static StringBuilder sb1 = new StringBuilder();
	public static double Omega_1,Omega_2;
	public static void main() throws IOException {
		// TODO Auto-generated method stub
		i1 = 0;
		i2 = 0;

		sb = new StringBuilder();
		sb1 = new StringBuilder();
		 Read_Tourism.main();
		 Read_Objective_Weight.main();
			Omega_1=Read_Objective_Weight.Omega_1();
			Omega_2=Read_Objective_Weight.Omega_2();
		Y = new int[Read_Tourism.N()][];
		for (int i = 0; i < Read_Tourism.N(); i++)
			Y[i] = new int[Read_Tourism.H(i)];

		Xa = new int[Read_Tourism.Ia()][];
		for (int i = 0; i < Read_Tourism.Ia(); i++)
			Xa[i] = new int[Read_Tourism.Ja(i)];
		Xh = new int[Read_Tourism.Ih()][];
		for (int i = 0; i < Read_Tourism.Ih(); i++)
			Xh[i] = new int[Read_Tourism.Jh(i)];
		Xt = new int[Read_Tourism.It()][];
		for (int i = 0; i < Read_Tourism.It(); i++)
			Xt[i] = new int[Read_Tourism.Jt(i)];
		Read_LR_Parameter.main();
		L = Read_LR_Parameter.L();
		c = Read_LR_Parameter.c();
		Print = Read_LR_Parameter.Print();

		Lambda1 = new double[Read_Tourism.K()];
		Lambda2 = new double[Read_Tourism.K()];
		Lambda3 = new double[Read_Tourism.K()];
		Lambda5 = new double[Read_Tourism.Ia()][Read_Tourism.K()];
		Lambda6 = new double[Read_Tourism.Ih()][Read_Tourism.M()];
		Lambda7= new double[Read_Tourism.It()][Read_Tourism.T()];
		for (int i = 0; i < Lambda1.length; i++){
			Lambda1[i] = 0;
			Lambda2[i] = 0;
			Lambda3[i] = 0;
		}
		Lambda4 = 0;
		for (int i = 0; i < Lambda5.length; i++)
			for (int j = 0; j < Lambda5[i].length; j++)
				Lambda5[i][j] = 0;
		for (int i = 0; i < Lambda6.length; i++)
			for (int j = 0; j < Lambda6[i].length; j++)
				Lambda6[i][j] = 0;
		for (int i = 0; i < Lambda7.length; i++)
			for (int j = 0; j < Lambda7[i].length; j++)
				Lambda7[i][j] = 0;
		generationCount = 1;
		// F(X,Y)
		System.out.println();
		System.out.println("F1(X,Y)");
		long totalstartTime = System.currentTimeMillis();
		long startTime = System.currentTimeMillis();
		Xa=Functions.Xa(Xa);
		Xh=Functions.Xh(Xh);
		Xt=Functions.Xt(Xt);
		Y=Functions.Y(Y);
		long endTime = System.currentTimeMillis();
		System.out.println("  F(X,Y)=  " + Functions.L(Xa,Xh,Xt, Y));
		double fintestN_1 = 0, fintestN = 0;
		Updata_Lambda.Updata_Lambda(Xa,Xh,Xt, Y);
		//Print_Lambda_g.main(Xa,Xh,Xt, Y);
		// System.out.println(Math.abs(Functions.L(X,
		// Y)-fintestN_1)/Math.abs(fintestN_1));
		while ( /* constraint(X, Y)==false */Functions.L(Xa,Xh,Xt, Y) - fintestN_1
				/ Functions.L(Xa,Xh,Xt, Y) > 0.0001) {
			/* for(int t=0;t<10;t++){ */
			fintestN_1 = Functions.L(Xa,Xh,Xt, Y);
			generationCount++;
			startTime = System.currentTimeMillis();
			Xa=Functions.Xa(Xa);
			Xh=Functions.Xh(Xh);
			Xt=Functions.Xt(Xt);
			Y=Functions.Y(Y);
			 endTime = System.currentTimeMillis();
			System.out.print("Y=");
			for (int i = 0; i < Y.length; i++)
				for (int j = 0; j < Y[i].length; j++) {
					System.out.print(Y[i][j]);
				}
			System.out.print(" Xa=");
			for (int i = 0; i < Xa.length; i++)
				for (int j = 0; j < Xa[i].length; j++) {
					System.out.print(Xa[i][j]);
				}
			System.out.print(" Xh=");
			for (int i = 0; i < Xh.length; i++)
				for (int j = 0; j < Xh[i].length; j++) {
					System.out.print(Xh[i][j]);
				}
			System.out.print(" Xt=");
			for (int i = 0; i < Xt.length; i++)
				for (int j = 0; j < Xt[i].length; j++) {
					System.out.print(Xt[i][j]);
				}
			System.out.println("  F(X,Y)=  " + Functions.L(Xa,Xh,Xt, Y));
			fintestN = Functions.L(Xa,Xh,Xt, Y);

			Updata_Lambda.Updata_Lambda(Xa,Xh,Xt, Y);

		}
		// System.out.println(Functions.L(X, Y) + " " + constraint(X, Y));
//		CheckConstraint.CheckConstraints(Xa,Xh,Xt, Y);
		System.out.println();
		long totalendTime = System.currentTimeMillis();

		Output_Result.LR(Y, Xa,Xh,Xt, fintestN, generationCount, totalendTime
				- totalstartTime);
		 Output_Result.LR_XY_Lambda(Y, Xa,Xh,Xt, Functions.L( Xa,Xh,Xt, Y), generationCount, totalendTime-totalstartTime );
		//Print_Lambda_g.main(X, Y);
	}

 
}
