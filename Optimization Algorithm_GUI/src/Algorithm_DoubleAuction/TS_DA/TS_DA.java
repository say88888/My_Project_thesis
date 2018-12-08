package Algorithm_DoubleAuction.TS_DA;

import java.io.IOException;
import java.util.ArrayList;

import Cplex.CPLEX_DA_LP;
import Input_Output_txt.Double_Auction.Output_Result;

public class TS_DA {

	public static int N;
	public static int I;
	public static int K;

	protected static int Xsize = 0;
	protected static int Ysize = 0;

	protected static double[] X;
	protected static double[] Y;
	protected static double[] X_LP;
	protected static double[] Y_LP;
	protected static double[] X_goalvalue;
	protected static double[] Y_goalvalue;

	protected static double[] XTabuTenure_UP;
	protected static double[] XTabuTenure_DN;
	protected static double[] YTabuTenure_UP;
	protected static double[] YTabuTenure_DN;

	protected static double[] XMaxtenure;
	protected static double[] YMaxtenure;

	protected static double Iter = 0;
	protected static double Mintenure;
	protected static double Maxtenure;
	protected static double ClearMaxIter = 25;

	protected static double[] XAspire_UP;
	protected static double[] XAspire_DN;
	protected static double[] YAspire_UP;
	protected static double[] YAspire_DN;

	protected static double[] X_GR_UP;
	protected static double[] X_GR_DN;
	protected static double[] Y_GR_UP;
	protected static double[] Y_GR_DN;

	public static double Fitness;

	public static double m;

	public static double x0, Epsilon;
	public static int d0, gp, gs, Iteration,Iteration_Mode;
	public static boolean right;

	public static ArrayList<Integer> X_Nup = new ArrayList<Integer>();
	public static ArrayList<Integer> X_Ndn = new ArrayList<Integer>();
	public static ArrayList<Integer> Y_Nup = new ArrayList<Integer>();
	public static ArrayList<Integer> Y_Ndn = new ArrayList<Integer>();
	public static ArrayList<Integer> X_M = new ArrayList<Integer>();
	public static ArrayList<Integer> Y_M = new ArrayList<Integer>();

	public static ArrayList<Integer> X_D0 = new ArrayList<Integer>();
	public static ArrayList<Integer> Y_D0 = new ArrayList<Integer>();
	public static ArrayList<Double> X_IP_UP = new ArrayList<Double>();
	public static ArrayList<Double> Y_IP_UP = new ArrayList<Double>();
	public static ArrayList<Double> X_IP_DN = new ArrayList<Double>();
	public static ArrayList<Double> Y_IP_DN = new ArrayList<Double>();

	public static ArrayList<Integer> X_G = new ArrayList<Integer>();
	public static ArrayList<Integer> Y_G = new ArrayList<Integer>();
	public static ArrayList<Integer> X_Gp = new ArrayList<Integer>();
	public static ArrayList<Integer> Y_Gp = new ArrayList<Integer>();
	public static ArrayList<Integer> X_Gs = new ArrayList<Integer>();
	public static ArrayList<Integer> Y_Gs = new ArrayList<Integer>();

	public static ArrayList<Integer> X_Tabu = new ArrayList<Integer>();
	public static ArrayList<Integer> Y_Tabu = new ArrayList<Integer>();

	public static ArrayList<Integer> X_R_UP = new ArrayList<Integer>();
	public static ArrayList<Integer> X_R_DN = new ArrayList<Integer>();
	public static ArrayList<Integer> Y_R_UP = new ArrayList<Integer>();
	public static ArrayList<Integer> Y_R_DN = new ArrayList<Integer>();
 
	public static void main() throws IOException {
		// TODO Auto-generated method stub
		long startTime = System.currentTimeMillis();
		// 初始化
		System.out.println("Step0 Initialization");
		Algorithm.initialization();
		print.main();

		for (int i = 0; i < Iteration; i++) {
			right=false;
			System.out.println("第" + (i + 1) + "次迴圈");

			// solve LP
			System.out.println("Step1 Solve LP");
			CPLEX_DA_LP.main();
			// check 限制式
			System.out.println();
			System.out.println("Is(x'',y'') feasible? ");
			//判斷LP'solve有解
			if (right==true /*Algorithm.constraint(X_LP, Y_LP) == true*/) {
				System.out.println("Step2  Is(x'',y'')MIP feasible ? ");
				if (Algorithm.constraint(X_LP, Y_LP) == true
						&& Algorithm.checkInteger(X_LP, Y_LP) == true) // 判斷LP'是否為整數解
				{
					if ( /*Algorithm.Fitness(X_goalvalue, Y_goalvalue) */Fitness> x0) {
						for(int j=0;j<Xsize;j++)
							X[j]=X_LP[j];
						for(int j=0;j<Ysize;j++)
							Y[j]=Y_LP[j];
						System.out.println("Update x0"  );
						x0 =  Fitness;//Algorithm.Fitness(X_goalvalue, Y_goalvalue);
						System.out.println("x0=" + x0);
					}
					System.out.println("Initialization  tabu status"  );
					Algorithm.initialization_TabuTenure();
					System.out.println("Go to Step7");
				} else {
					System.out.println("Step3 Is LP' solution goal infeasible?");
					boolean goal_condition;
					goal_condition = Algorithm	.Step3_check_LP_goal_condition_infeasible(X_LP,Y_LP);

					if (goal_condition == true) {
						 
						System.out.println("Step4 goal_infeasible ");
						System.out.println("Create both Gp and Gs sets.");
						System.out.println("considering tabu status");
						System.out.println( "Update tabu tenures andaspiration");
						Step4_goal_infeasible.main(X_LP, Y_LP);
						System.out.println("Step6-1  Generate goal conditions and new LP' problem.");
						Step6_1.main();
						Iter++;
						if (Iter > ClearMaxIter) {
							Algorithm.initialization_TabuTenure();
							Iter = 0;
						}
					} else {
						System.out.println("Step5 integer infeasible");
						System.out.println("LP' is integer infeasible.");
						System.out.println("Create the set D0.");
						Step5_integer_infeasible.main(X_LP, Y_LP);
						System.out.println("Step6-2  Generate goal conditions and new LP' problem.");
						Step6_2.main();
					}
				}
			}else{
				System.out.println("End, optimalsolution hasbeen found.");
				break;
			}
			System.out.print("更新後的目標值");
			print.main();
			System.out.println();
		}
		System.out.println("x0=" + x0);
		System.out.print("X=");
		for(int j=0;j<Xsize;j++)
			System.out.print(X[j]+" ");
		System.out.println( );
		System.out.print("Y=");
		for(int j=0;j<Ysize;j++)
			System.out.print(Y[j]+" ");
		long endTime = System.currentTimeMillis();
		Output_Result.TS_DA(Y, X, x0, endTime-startTime);
	}

}
