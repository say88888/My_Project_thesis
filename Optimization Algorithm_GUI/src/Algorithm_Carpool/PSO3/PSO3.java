package Algorithm_Carpool.PSO3;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.NumberFormat;

import Input_Output_txt.Batch.Read_PSO_Batch_Parameter;
import Input_Output_txt.Carpool.Output_Result;
import Input_Output_txt.Carpool.Read_file;
import carpool_Alogorithm_MOD.Print_input;
 
public class PSO3 {

	public static int Xsize = 0, Ysize = 0;
	public static int  i1=0,i2=0;
	
	public static int P;
	public static int D;
	public static int K;
	public static double w;
	public static double c1;
	public static double c2;
	public static int Vmax;
	public static int Execution_Mode;
	public static int Print_Mode;
	public static int Write_Mode;
	public static int populationSize;
	public static double threshold;
	private static double[] X;
	private static double[] Y;
	private static int[] X_Batch;
	private static int[] Y_Batch;
	public static double Sfmin;
	public static StringBuilder SFminsb = new StringBuilder();
	public static StringBuilder sb = new StringBuilder();
	public static StringBuilder sb1 = new StringBuilder();
	public static int n=0;//計算batch次數
	
	public static long time_write_to_TXT;
	public static long T_total_time;
	
	public static void main(  ) throws IOException {
		 Xsize=0;
		 Ysize=0;
		 time_write_to_TXT=0;
		 i1=0;
		 i2=0;
		 n=0;
		 sb=new StringBuilder();
		 sb1=new StringBuilder();
		Read_file.loadData();
		P = Read_file.getP();
		D = Read_file.getD();
		K = Read_file.getK();
		for (int i = 0; i < D; i++)
			Xsize += Read_file.getJd(i);
		for (int i = 0; i < P; i++)
			Ysize += Read_file.getHp(i);
		X = new double[Xsize];
		Y = new double[Ysize];
		
		X_Batch = new int[Xsize];
		Y_Batch = new int[Ysize];
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(3);		
	
		if(GUI.main.getmethod()!=2){
		PSO_Read_Write_txt.read_PSO_Parameter();
		populationSize=PSO_Read_Write_txt.populationSize();
		w=PSO_Read_Write_txt.w();
		c1=PSO_Read_Write_txt.c1();
		c2=PSO_Read_Write_txt.c2();
		Vmax=PSO_Read_Write_txt.Vmax();
		Execution_Mode=PSO_Read_Write_txt.Execution_Mode();
		Print_Mode=PSO_Read_Write_txt.Print_Mode();
		Write_Mode=PSO_Read_Write_txt.Write_Mode();
		threshold=PSO_Read_Write_txt.threshold();
	
		String str="";
		long totalstartTime = System.currentTimeMillis();
		long startTime = System.currentTimeMillis();
		Population myPop = new Population(populationSize, true);
		long endTime = System.currentTimeMillis();
		int generationCount = 1;
		double myPopFitnessN_1,Fittest;
		// F(X,Y)
		System.out.println();
		System.out.println("F3(X,Y)");
		PSO_Data_print.print2(myPop,Print_Mode);
		System.out.print("Generation: " + generationCount +  " F(x,y) Fittest: "+ myPop.getFittest().getFitness() + " F3(x,y) Fittest: "+ myPop.getFittest().getFitness1() + " Y=");
		str+="Generation=" + generationCount + " Fitness Function= "+ myPop.getFittest().getFitness1();
		Fittest=myPop.getFittest().getFitness1() ;
		for (int i = 0; i < myPop.getFittest().Gysize(); i++) {
			Y[i] = myPop.getFittest().getGy(i);
			Y[i]=Double.parseDouble(nf.format(Y[i]));
			System.out.print(Y[i]+" ");
		}
		System.out.print("X=");
		for (int j = 0; j < myPop.getFittest().Gxsize(); j++) {
			X[j] = myPop.getFittest().getGx(j);
			X[j]=Double.parseDouble(nf.format(X[j]));
			System.out.print(X[j]+" ");
		}
		System.out.print(" 執行時間: "+(endTime-startTime));
		str+=" Time= "+(endTime-startTime)+"ms\r\n";
		System.out.println();
		myPopFitnessN_1 = myPop.getFittest().getFitness1();
		
		Sfmin = FitnessCalc.getSFmin(SFminsb);
		startTime = System.currentTimeMillis();
		myPop = Algorithm.evolvePopulation(myPop);
		endTime = System.currentTimeMillis();
		 SFminsb = new StringBuilder();
		 PSO_Data_print.print2(myPop,Print_Mode);
		
	while ((myPop.getFittest().getFitness1()-myPopFitnessN_1)/Math.abs(myPopFitnessN_1) > threshold) {
	//	for(int t=0;t<100;t++){
			generationCount++;
			
			System.out.print("Generation: " + generationCount +  " F(x,y) Fittest: "+ myPop.getFittest().getFitness() + " F3(x,y) Fittest: "+ myPop.getFittest().getFitness1() + " Y=");
			str+="Generation=" + generationCount + " Fitness Function= "+ myPop.getFittest().getFitness1();
			Fittest=myPop.getFittest().getFitness1() ;
			for (int i = 0; i < myPop.getFittest().Gysize(); i++) {
				Y[i] = myPop.getFittest().getGy(i);
				Y[i]=Double.parseDouble(nf.format(Y[i]));
				System.out.print(Y[i]+" ");
			}
			System.out.print("X=");
			for (int j = 0; j < myPop.getFittest().Gxsize(); j++) {
				X[j] = myPop.getFittest().getGx(j);
				X[j]=Double.parseDouble(nf.format(X[j]));
				System.out.print(X[j]+" ");
			}
			System.out.print(" 執行時間: "+(endTime-startTime));
			str+=" Time= "+(endTime-startTime)+"ms\r\n";
			System.out.println();
			myPopFitnessN_1 = myPop.getFittest().getFitness1();
			Sfmin = FitnessCalc.getSFmin(SFminsb);
			startTime = System.currentTimeMillis();
			myPop = Algorithm.evolvePopulation(myPop);
			endTime = System.currentTimeMillis();
			SFminsb = new StringBuilder();
			PSO_Data_print.print2(myPop,Print_Mode);
		
		}
		
		System.out.println("Solution found!");
		System.out.println("Generation: " + generationCount);
		long totalendTime = System.currentTimeMillis();
		T_total_time=totalendTime - totalstartTime;
		System.out.println("執行時間 T_total_time=" + T_total_time+"ms");
		System.out.println("執行時間扣除寫檔時間  T_net=" + (T_total_time-time_write_to_TXT)+"ms");
		CheckConstraint.CheckConstraints();
		Print_input.main(Print_Mode);
		Output_Result.PSO3(Y, X, Fittest, generationCount,T_total_time, (T_total_time-time_write_to_TXT),str);
		}else{
			Read_PSO_Batch_Parameter.main();
			 
			long Time_Batch = 0;
			int generationCount_Batch = 0,k=-9999;
			double Fittest_Batch=-999999999;
			
			int populationSize_Batch=0;
			double w_Batch=0,c1_Batch=0,c2_Batch=0;
			
			
			Vmax=Read_PSO_Batch_Parameter.Vmax();
			Execution_Mode=Read_PSO_Batch_Parameter.Execution_Mode();
			Print_Mode=Read_PSO_Batch_Parameter.Print_Mode();
			threshold=Read_PSO_Batch_Parameter.threshold();
		  
			for(populationSize=Read_PSO_Batch_Parameter.lowpopulationSize();populationSize<=Read_PSO_Batch_Parameter.UppopulationSize();populationSize+=Read_PSO_Batch_Parameter.StpopulationSize()){
				for(w=Read_PSO_Batch_Parameter.loww();w<=Read_PSO_Batch_Parameter.Upw();w+=Read_PSO_Batch_Parameter.Stw()){
					for(c1=Read_PSO_Batch_Parameter.lowc1();c1<=Read_PSO_Batch_Parameter.Upc1();c1+=Read_PSO_Batch_Parameter.Stc1()){
						for(c2=Read_PSO_Batch_Parameter.lowc2();c2<=Read_PSO_Batch_Parameter.Upc2();c2+=Read_PSO_Batch_Parameter.Stc2()){
					 n++;
					 sb=new StringBuilder();
					 sb1=new StringBuilder();
					 	System.out.println("PSO2_Batch"+n);
						System.out.println("populationSize="+populationSize);
						System.out.println("w="+w);
						System.out.println("c1="+c1);
						System.out.println("c2="+c2);
						System.out.println("Vmax="+Vmax);
						System.out.println("Execution_Mode="+Execution_Mode);
						System.out.println("Print_Mode="+Print_Mode);
						System.out.println("threshold="+new BigDecimal(String.valueOf(threshold)));
			long totalstartTime = System.currentTimeMillis();
			Population myPop = new Population(populationSize, true);
			int generationCount = 1;
			double myPopFitnessN_1,Fittest;
			// F(X,Y)
			System.out.println();
			System.out.println("F2(X,Y)");
			PSO_Data_print.print2(myPop,Print_Mode);
			System.out.print("Generation: " + generationCount +  " F(x,y) Fittest: "+ myPop.getFittest().getFitness() + " F3(x,y) Fittest: "+ myPop.getFittest().getFitness1() + " Y=");
			Fittest=myPop.getFittest().getFitness1() ;
			for (int i = 0; i < myPop.getFittest().Gysize(); i++) {
				Y[i] = myPop.getFittest().getGy(i);
				Y[i]=Double.parseDouble(nf.format(Y[i]));
				System.out.print(Y[i]);
			}
			System.out.print("X=");
			for (int j = 0; j < myPop.getFittest().Gxsize(); j++) {
				X[j] = myPop.getFittest().getGx(j);
				X[j]=Double.parseDouble(nf.format(X[j]));
				System.out.print(X[j]);
			}
			System.out.println();
			myPopFitnessN_1 = myPop.getFittest().getFitness1();
			
			Sfmin = FitnessCalc.getSFmin(SFminsb);
			myPop = Algorithm.evolvePopulation(myPop);
			 SFminsb = new StringBuilder();
			 PSO_Data_print.print2(myPop,Print_Mode);
			
		while ((myPop.getFittest().getFitness1()-myPopFitnessN_1)/Math.abs(myPopFitnessN_1) > threshold) {
		//	for(int t=0;t<100;t++){
				generationCount++;
				
				System.out.print("Generation: " + generationCount +  " F(x,y) Fittest: "+ myPop.getFittest().getFitness() + " F3(x,y) Fittest: "+ myPop.getFittest().getFitness1() + " Y=");
				Fittest=myPop.getFittest().getFitness1() ;
				for (int i = 0; i < myPop.getFittest().Gysize(); i++) {
					Y[i] = myPop.getFittest().getGy(i);
					Y[i]=Double.parseDouble(nf.format(Y[i]));
					System.out.print(Y[i]);
				}
				System.out.print("X=");
				for (int j = 0; j < myPop.getFittest().Gxsize(); j++) {
					X[j] = myPop.getFittest().getGx(j);
					X[j]=Double.parseDouble(nf.format(X[j]));
					System.out.print(X[j]);
				}
				System.out.println();
				myPopFitnessN_1 = myPop.getFittest().getFitness1();
				Sfmin = FitnessCalc.getSFmin(SFminsb);
				myPop = Algorithm.evolvePopulation(myPop);
				SFminsb = new StringBuilder();
				PSO_Data_print.print2(myPop,Print_Mode);
			
			}
			
			System.out.println("Solution found!");
			System.out.println("Generation: " + generationCount);
			long totalendTime = System.currentTimeMillis();
			T_total_time=totalendTime - totalstartTime;
			System.out.println("執行時間 T_total_time=" + T_total_time+"ms");
			System.out.println("執行時間扣除寫檔時間  T_net=" + (T_total_time-time_write_to_TXT)+"ms");
			CheckConstraint.CheckConstraints();
			Print_input.main(Print_Mode);
			Output_Result.savePSO3_Batch_Parameter(n,populationSize,w,c1,c2, Vmax, Execution_Mode, Print_Mode, threshold );
			Output_Result.PSO3_Batch(n,Y, X, Fittest, generationCount,T_total_time, (T_total_time-time_write_to_TXT));
			System.out.println();
			if(Fittest>Fittest_Batch){
				Fittest_Batch=Fittest;
				k=n;
			}
	 
						}
					}
				}
			}
			System.out.println(k);
			//Output_Result.PSO2_Batch_best(Y_Batch, X_Batch, Fittest_Batch, generationCount_Batch,Time_Batch);
			//Output_Result.savePSO2_Batch_Parameter(populationSize_Batch,w_Batch,c1_Batch,c2_Batch, Vmax, Execution_Mode, Print_Mode, threshold );
		}
	}

	public static double X(int i) {
		return X[i];
	}

	public static double Y(int i) {
		return Y[i];
	}

}
