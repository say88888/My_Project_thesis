package Algorithm_Tourism.GA1_Tourism;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Algorithm_Tourism.Function_Vector;
import Input_Output_txt.Tourism.Output_Result;
import Input_Output_txt.Tourism.Read_Objective_Weight;
import Input_Output_txt.Tourism.Read_Tourism;
import carpool_Alogorithm_MOD.Print_input;

public class GA1_Tourism {

 
	public static int Xasize = 0, Xhsize = 0, Xtsize = 0, Ysize = 0;
 
	public static int  i1=0;
	public static int  i2=0;
	public static double initialPopulationRate;
	public static double crossoverRate;
	public static double mutationRate;
	public static int tournamentSize;
	public static int populationSize;
	public static double threshold;
	public static int Execution_Mode;
	public static int Print_Mode;
	public static int SA_Mode;
	public static int Write_Mode;
	public static double T;
	public static int Iteration;
	public static int Iteration_Mode;
	static StringBuilder sb2 = new StringBuilder();

	private static int[] Xa;
	private static int[] Xh;
	private static int[] Xt;
	private static int[] Y;
	public static double Omega_1,Omega_2;

	public static long time_write_to_TXT;
	public static long T_total_time;
	
	public static ArrayList<List<Integer>> A = new ArrayList<List<Integer>>();
	public static ArrayList<Integer> B = new ArrayList<Integer>();
	public static ArrayList<Double> C = new ArrayList<Double>();
	public static void main( ) throws IOException {
		Xasize = 0;
		Xhsize = 0;
		Xtsize = 0;
		Ysize = 0;
	 time_write_to_TXT=0;
		i1=0;
		i2=0;
 
		GA_Read_Write_txt.read_GA_Parameters();
		//Read_Objective_Weight.main();
		Read_Tourism.main();
		Read_Objective_Weight.main();
		Omega_1=Read_Objective_Weight.Omega_1();
		Omega_2=Read_Objective_Weight.Omega_2();
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
		Iteration_Mode=GA_Read_Write_txt.Iteration_Mode();
		if(Iteration_Mode==0){
		Iteration = GA_Read_Write_txt.Iteration();
		}else{
			Iteration = Xasize + Xhsize + Xtsize + Ysize + Read_Tourism.K()
					+ 1 + Read_Tourism.Ia() * Read_Tourism.K()
					+ Read_Tourism.Ih() * Read_Tourism.M()
					+ Read_Tourism.It() * Read_Tourism.T();
		}
		initialPopulationRate = GA_Read_Write_txt.initialPopulationRate();
		crossoverRate = GA_Read_Write_txt.crossoverRate();
		mutationRate = GA_Read_Write_txt.mutationRate();
		tournamentSize = GA_Read_Write_txt.tournamentSize();
		populationSize = GA_Read_Write_txt.populationSize();
		threshold = GA_Read_Write_txt.threshold();
		Execution_Mode = GA_Read_Write_txt.Execution_Mode();
		Print_Mode = GA_Read_Write_txt.Print_Mode();
		SA_Mode = GA_Read_Write_txt.SA_Mode();
		Write_Mode = GA_Read_Write_txt.Write_Mode();
		T = GA_Read_Write_txt.T();
		
		String str="";
		long totalstartTime = System.currentTimeMillis();
		long startTime = System.currentTimeMillis();
		Population myPop1 = new Population(populationSize, true);
		long endTime = System.currentTimeMillis();
		int generationCount1 = 1;
		double   myPop1FitnessN_1 ,Fittest;
		// Fitness Function 1: F1(x, y)
		System.out.println();
		System.out.println("Fitness Function 1: F1(x, y)");
		//str+="Fitness Function 1: F1(x, y)\r\n";
		myPop1FitnessN_1 = myPop1.getFittest1().getFitness1();
		GA_Data_print.print1(myPop1, Print_Mode);
		System.out.print("Generation: " + generationCount1 + " F(x,y) Fittest: "+ myPop1.getFittest1().getFitness() +" F1(x,y) Fittest: "+myPop1.getFittest1().getFitness1()+" "+" Y=");
		str+="Generation=" + generationCount1 + " Fitness Function= "+myPop1.getFittest1().getFitness1() ;
		Fittest=myPop1.getFittest1().getFitness1();
		for (int i = 0; i < myPop1.getFittest1().Ysize(); i++) {
			Y[i] = myPop1.getFittest1().getY(i);
			System.out.print(Y[i]);
		}
		System.out.print("Xa=");
		//str+="X=";
		for (int j = 0; j < myPop1.getFittest1().Xasize(); j++) {
			System.out.print(myPop1.getFittest1().getXa(j));
			Xa[j] = myPop1.getFittest1().getXa(j);
		//	str+=X1[j];
		}
		System.out.print(" Xh=");
		for (int j = 0; j < myPop1.getFittest1().Xhsize(); j++) {
			System.out.print(myPop1.getFittest1().getXh(j));
			Xh[j] = myPop1.getFittest1().getXh(j);
		//	str+=X1[j];
		}
		System.out.print(" Xt=");
		for (int j = 0; j < myPop1.getFittest1().Xtsize(); j++) {
			System.out.print(myPop1.getFittest1().getXt(j));
			Xt[j] = myPop1.getFittest1().getXt(j);
		//	str+=X1[j];
		}
		System.out.print(" 執行時間: "+(endTime-startTime));
		str+=" Time "+(endTime-startTime)+"ms\r\n";
		 startTime = System.currentTimeMillis();
		myPop1 = Algorithm.evolvePopulation(myPop1);
		
		GA_Data_print.print1(myPop1, Print_Mode);
		System.out.println();
		myPop1 = SA.SA_f1(myPop1FitnessN_1, myPop1, SA_Mode);
		 endTime = System.currentTimeMillis();
			for (int iter = 0; iter < Iteration; iter++) {
				if (((myPop1.getFittest1().getFitness1() - myPop1FitnessN_1)	/Math.abs(myPop1FitnessN_1) > threshold)	|| constraint(Xa,Xh,Xt, Y) == false) {
						myPop1FitnessN_1 = myPop1.getFittest1().getFitness1();
		generationCount1++;
		System.out.print("Generation: " + generationCount1 + " F(x,y) Fittest: "+ myPop1.getFittest1().getFitness() +" F1(x,y) Fittest: "+myPop1.getFittest1().getFitness1()+" "+" Y=");
		str+="Generation=" + generationCount1 + " Fitness Function= "+myPop1.getFittest1().getFitness1() ;
		Fittest=myPop1.getFittest1().getFitness1();
		for (int i = 0; i < myPop1.getFittest1().Ysize(); i++) {
			Y[i] = myPop1.getFittest1().getY(i);
			System.out.print(Y[i]);
		}
		System.out.print("Xa=");
		//str+="X=";
		for (int j = 0; j < myPop1.getFittest1().Xasize(); j++) {
			System.out.print(myPop1.getFittest1().getXa(j));
			Xa[j] = myPop1.getFittest1().getXa(j);
		//	str+=X1[j];
		}
		System.out.print(" Xh=");
		for (int j = 0; j < myPop1.getFittest1().Xhsize(); j++) {
			System.out.print(myPop1.getFittest1().getXh(j));
			Xh[j] = myPop1.getFittest1().getXh(j);
		//	str+=X1[j];
		}
		System.out.print(" Xt=");
		for (int j = 0; j < myPop1.getFittest1().Xtsize(); j++) {
			System.out.print(myPop1.getFittest1().getXt(j));
			Xt[j] = myPop1.getFittest1().getXt(j);
		//	str+=X1[j];
		}
			System.out.print(" 執行時間: "+(endTime-startTime));
			str+=" Time = "+(endTime-startTime)+"ms\r\n";
			 startTime = System.currentTimeMillis();
			
			myPop1 = Algorithm.evolvePopulation(myPop1);
			GA_Data_print.print1(myPop1, Print_Mode);
			System.out.println();
			myPop1 = SA.SA_f1(myPop1FitnessN_1, myPop1, SA_Mode);
			 endTime = System.currentTimeMillis();
		}else{break;}
			}

		GA_Data_print.print1(myPop1, Print_Mode);
		System.out.println("Solution found!");
		System.out.println("Generation: " + generationCount1);
		long totalendTime = System.currentTimeMillis();
		T_total_time=totalendTime - totalstartTime;
		System.out.println("執行時間 T_total_time=" + T_total_time+"ms");
		System.out.println("執行時間扣除寫檔時間  T_net=" + (T_total_time-time_write_to_TXT)+"ms");
		//str+="Solution found!\r\n"+"Generation: " + generationCount1+"\r\n"+"總執行時間="+(totalendTime-totalstartTime)+"ms";
		CheckConstraint.CheckConstraints1();
		Print_input.main(Print_Mode);
		Output_Result.Genetic_Algorithm1_Tourism(Y, Xa,Xh,Xt, Fittest, generationCount1, T_total_time, (T_total_time-time_write_to_TXT),str);
	}

 

	public static int Xa(int i) {
		return Xa[i];
	}
	public static int Xh(int i) {
		return Xh[i];
	}
	public static int Xt(int i) {
		return Xt[i];
	}
	public static int Y(int i) {
		return Y[i];
	}

	public static boolean constraint(int[] xa,int[] xh,int[] xt, int[] y)   {
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
		b=0;
		for (int i = 0; i < Xa.length; i++)
			for (int j = 0; j < Xa[i].length; j++)
				Xa[i][j] = xa[b++];
		b=0;
		for (int i = 0; i < Xh.length; i++)
			for (int j = 0; j < Xh[i].length; j++)
				Xh[i][j] = xh[b++];
		b=0;
		for (int i = 0; i < Xt.length; i++)
			for (int j = 0; j < Xt[i].length; j++)
				Xt[i][j] = xt[b++];
		right=Function_Vector.constraint(Xa,Xh,Xt,Y,A,B);
		
		return right;
	}
}
