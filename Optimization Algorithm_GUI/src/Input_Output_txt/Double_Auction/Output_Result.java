package Input_Output_txt.Double_Auction;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import GUI.I_Set_Paths_for_Current_Simulation_Example;
import GUI.GUI_Double_Auction.X_Select_Algorithm_Type_to_Solve_the_Problem;

public class Output_Result {
	
	public static void CPLEX(String y, String x, double Fittest, long time,String str) throws IOException  
	{	 
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\CPLEX");
	    f2.mkdir();
		FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\CPLEX\\Result.txt",false);
		fw2.write("Y="+y+"\r\n");
		fw2.write("X="+x+"\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("執行時間="+time+ "ms"+"\r\n");
		fw2.write("\r\n");
		fw2.close();
		String[] Y=y.split(" ");
		FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\CPLEX\\Y.txt",false);
		for(int i=0;i<Y.length;i++)
		fw1.write(Y[i]+"\r\n");
		fw1.close();
		String[] X=x.split(" ");
		FileWriter fw3 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\CPLEX\\X.txt",false);
		for(int i=0;i<X.length;i++)
		fw3.write(X[i]+"\r\n");
		fw3.close();
		FileWriter fw = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\CPLEX\\Generation_Time_Log.txt",false);
		fw.write(String.valueOf(str));
	fw.close();
	}
	public static void CPLEX_Vector(String y, String x, double Fittest, long time,String str, ArrayList<List<Integer>> A, ArrayList<Integer> B, ArrayList<Double> C) throws IOException  
	{	 
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\CPLEX_Vector");
	    f2.mkdir();
		FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\CPLEX_Vector\\Result.txt",false);
		fw2.write("Y="+y+"\r\n");
		fw2.write("X="+x+"\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("執行時間="+time+ "ms"+"\r\n");
		fw2.write("\r\n");
		fw2.close();
		String[] Y=y.split(" ");
		FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\CPLEX_Vector\\Y.txt",false);
		for(int i=0;i<Y.length;i++)
		fw1.write(Y[i]+"\r\n");
		fw1.close();
		String[] X=x.split(" ");
		FileWriter fw3 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\CPLEX_Vector\\X.txt",false);
		for(int i=0;i<X.length;i++)
		fw3.write(X[i]+"\r\n");
		fw3.close();
		FileWriter fw = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\CPLEX_Vector\\Generation_Time_Log.txt",false);
		fw.write(String.valueOf(str));
		fw.close();
		FileWriter fw6 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\CPLEX_Vector\\A_Vector.txt",false);
		for(int i=0;i<A.size();i++)
		for(int j=0;j<A.get(i).size();j++){
			fw6.write("i="+i+" j="+j+"  "+String.valueOf(A.get(i).get(j)));
			fw6.write("\r\n");
		}
		fw6.close();
		FileWriter fw7 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\CPLEX_Vector\\B_Vector.txt",false);
		for(int i=0;i<B.size();i++){
			fw7.write("i="+i+ "  "+String.valueOf(B.get(i)));
			fw7.write("\r\n");
		}
		fw7.close();
		FileWriter fw8 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\CPLEX_Vector\\C_Vector.txt",false);
		for(int i=0;i<C.size();i++){
			fw8.write("i="+i+ "  "+String.valueOf(C.get(i)));
			fw8.write("\r\n");
		}
		fw8.close();
	}
	public static void Genetic_Algorithm1(int[] y, int[] x, double Fittest,int generationCount, long total_time,long T_net,String str) throws IOException  
	{	 
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\GA1");
	    f2.mkdir();
    	FileWriter fw = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\GA1\\X.txt",false);
    	for(int i=0;i<x.length;i++)
			fw.write(String.valueOf(x[i]+"\r\n"));
    	fw.close();
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\GA1\\Y.txt",false);
    	for(int i=0;i<y.length;i++)
			fw1.write(String.valueOf(y[i]+"\r\n"));
    	fw1.close();
		FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\GA1\\Result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			fw2.write(y[i]+" ");
		fw2.write("\r\n");
		fw2.write("X=");
		for(int i=0;i<x.length;i++)
			fw2.write(x[i]+" ");
		fw2.write("\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("Generation="+generationCount+"\r\n");
		fw2.write("執行時間 T_total_time="+total_time+ "ms"+"\r\n");
		fw2.write("執行時間扣除寫檔時間  T_net="+T_net+ "ms"+"\r\n");
		fw2.write("\r\n");
		fw2.close();
		FileWriter fw3 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\GA1\\Generation_Time_Log.txt",false);
			fw3.write(String.valueOf(str));
    	fw3.close();
	}
	public static void Genetic_Algorithm2(int[] y, int[] x, double Fittest,int generationCount,  long total_time,long T_net,String str) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\GA2");
	    f2.mkdir();
    	FileWriter fw = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\GA2\\X.txt",false);
    	for(int i=0;i<x.length;i++)
			fw.write(String.valueOf(x[i]+"\r\n"));
    	fw.close();
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\GA2\\Y.txt",false);
    	for(int i=0;i<y.length;i++)
			fw1.write(String.valueOf(y[i]+"\r\n"));
    	fw1.close();
		FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\GA2\\Result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			fw2.write(y[i]+" ");
		fw2.write("\r\n");
		fw2.write("X=");
		for(int i=0;i<x.length;i++)
			fw2.write(x[i]+" ");
		fw2.write("\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("Generation="+generationCount+"\r\n");
		fw2.write("執行時間 T_total_time="+total_time+ "ms"+"\r\n");
		fw2.write("執行時間扣除寫檔時間  T_net="+T_net+ "ms"+"\r\n");
		fw2.write("\r\n");
		fw2.close();
		FileWriter fw3 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\GA2\\Generation_Time_Log.txt",false);
		fw3.write(String.valueOf(str));
	fw3.close();
	}
	
	public static void PSO1(int[] y, int[] x, double Fittest,int generationCount,  long total_time,long T_net,String str) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO1");
	    f2.mkdir();
    	FileWriter fw = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO1\\X.txt",false);
    	for(int i=0;i<x.length;i++)
			fw.write(String.valueOf(x[i]+"\r\n"));
    	fw.close();
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO1\\Y.txt",false);
    	for(int i=0;i<y.length;i++)
			fw1.write(String.valueOf(y[i]+"\r\n"));
    	fw1.close();
		FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO1\\Result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			fw2.write(y[i]+" ");
		fw2.write("\r\n");
		fw2.write("X=");
		for(int i=0;i<x.length;i++)
			fw2.write(x[i]+" ");
		fw2.write("\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("Generation="+generationCount+"\r\n");
		fw2.write("執行時間 T_total_time="+total_time+ "ms"+"\r\n");
		fw2.write("執行時間扣除寫檔時間  T_net="+T_net+ "ms"+"\r\n");
		fw2.write("\r\n");
		fw2.close();
		FileWriter fw3 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO1\\Generation_Time_Log.txt",false);
		fw3.write(String.valueOf(str));
	fw3.close();
	}
	public static void PSO1_Tanh(int[] y, int[] x, double Fittest,int generationCount,  long total_time,long T_net,String str) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO1_Tanh");
	    f2.mkdir();
    	FileWriter fw = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO1_Tanh\\X.txt",false);
    	for(int i=0;i<x.length;i++)
			fw.write(String.valueOf(x[i]+"\r\n"));
    	fw.close();
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO1_Tanh\\Y.txt",false);
    	for(int i=0;i<y.length;i++)
			fw1.write(String.valueOf(y[i]+"\r\n"));
    	fw1.close();
		FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO1_Tanh\\Result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			fw2.write(y[i]+" ");
		fw2.write("\r\n");
		fw2.write("X=");
		for(int i=0;i<x.length;i++)
			fw2.write(x[i]+" ");
		fw2.write("\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("Generation="+generationCount+"\r\n");
		fw2.write("執行時間 T_total_time="+total_time+ "ms"+"\r\n");
		fw2.write("執行時間扣除寫檔時間  T_net="+T_net+ "ms"+"\r\n");
		fw2.write("\r\n");
		fw2.close();
		FileWriter fw3 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO1_Tanh\\Generation_Time_Log.txt",false);
		fw3.write(String.valueOf(str));
	fw3.close();
	}
	public static void PSO1_P(int[] y, int[] x, double Fittest,int generationCount,  long total_time,long T_net,String str) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO1_P");
	    f2.mkdir();
    	FileWriter fw = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO1_P\\X.txt",false);
    	for(int i=0;i<x.length;i++)
			fw.write(String.valueOf(x[i]+"\r\n"));
    	fw.close();
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO1_P\\Y.txt",false);
    	for(int i=0;i<y.length;i++)
			fw1.write(String.valueOf(y[i]+"\r\n"));
    	fw1.close();
		FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO1_P\\Result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			fw2.write(y[i]+" ");
		fw2.write("\r\n");
		fw2.write("X=");
		for(int i=0;i<x.length;i++)
			fw2.write(x[i]+" ");
		fw2.write("\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("Generation="+generationCount+"\r\n");
		fw2.write("執行時間 T_total_time="+total_time+ "ms"+"\r\n");
		fw2.write("執行時間扣除寫檔時間  T_net="+T_net+ "ms"+"\r\n");
		fw2.write("\r\n");
		fw2.close();
		FileWriter fw3 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO1_P\\Generation_Time_Log.txt",false);
		fw3.write(String.valueOf(str));
	fw3.close();
	}
	public static void PSO2(int[] y, int[] x, double Fittest,int generationCount, long total_time,long T_net,String str) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO2");
	    f2.mkdir();
    	FileWriter fw = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO2\\X.txt",false);
    	for(int i=0;i<x.length;i++)
			fw.write(String.valueOf(x[i]+"\r\n"));
    	fw.close();
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO2\\Y.txt",false);
    	for(int i=0;i<y.length;i++)
			fw1.write(String.valueOf(y[i]+"\r\n"));
    	fw1.close();
		FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO2\\Result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			fw2.write(y[i]+" ");
		fw2.write("\r\n");
		fw2.write("X=");
		for(int i=0;i<x.length;i++)
			fw2.write(x[i]+" ");
		fw2.write("\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("Generation="+generationCount+"\r\n");
		fw2.write("執行時間 T_total_time="+total_time+ "ms"+"\r\n");
		fw2.write("執行時間扣除寫檔時間  T_net="+T_net+ "ms"+"\r\n");
		fw2.write("\r\n");
		fw2.close();
		FileWriter fw3 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO2\\Generation_Time_Log.txt",false);
		fw3.write(String.valueOf(str));
	fw3.close();
	}
	public static void PSO2_Tanh(int[] y, int[] x, double Fittest,int generationCount, long total_time,long T_net,String str) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO2_Tanh");
	    f2.mkdir();
    	FileWriter fw = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO2_Tanh\\X.txt",false);
    	for(int i=0;i<x.length;i++)
			fw.write(String.valueOf(x[i]+"\r\n"));
    	fw.close();
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO2_Tanh\\Y.txt",false);
    	for(int i=0;i<y.length;i++)
			fw1.write(String.valueOf(y[i]+"\r\n"));
    	fw1.close();
		FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO2_Tanh\\Result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			fw2.write(y[i]+" ");
		fw2.write("\r\n");
		fw2.write("X=");
		for(int i=0;i<x.length;i++)
			fw2.write(x[i]+" ");
		fw2.write("\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("Generation="+generationCount+"\r\n");
		fw2.write("執行時間 T_total_time="+total_time+ "ms"+"\r\n");
		fw2.write("執行時間扣除寫檔時間  T_net="+T_net+ "ms"+"\r\n");
		fw2.write("\r\n");
		fw2.close();
		FileWriter fw3 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO2_Tanh\\Generation_Time_Log.txt",false);
		fw3.write(String.valueOf(str));
	fw3.close();
	}
	public static void PSO2_P(int[] y, int[] x, double Fittest,int generationCount, long total_time,long T_net,String str) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO2_P");
	    f2.mkdir();
    	FileWriter fw = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO2_P\\X.txt",false);
    	for(int i=0;i<x.length;i++)
			fw.write(String.valueOf(x[i]+"\r\n"));
    	fw.close();
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO2_P\\Y.txt",false);
    	for(int i=0;i<y.length;i++)
			fw1.write(String.valueOf(y[i]+"\r\n"));
    	fw1.close();
		FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO2_P\\Result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			fw2.write(y[i]+" ");
		fw2.write("\r\n");
		fw2.write("X=");
		for(int i=0;i<x.length;i++)
			fw2.write(x[i]+" ");
		fw2.write("\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("Generation="+generationCount+"\r\n");
		fw2.write("執行時間 T_total_time="+total_time+ "ms"+"\r\n");
		fw2.write("執行時間扣除寫檔時間  T_net="+T_net+ "ms"+"\r\n");
		fw2.write("\r\n");
		fw2.close();
		FileWriter fw3 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO2_P\\Generation_Time_Log.txt",false);
		fw3.write(String.valueOf(str));
	fw3.close();
	}
	public static void PSO3(double[] y, double[] x, double Fittest,int generationCount, long total_time,long T_net,String str) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO3");
	    f2.mkdir();
    	FileWriter fw = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO3\\X.txt",false);
    	for(int i=0;i<x.length;i++)
			fw.write(String.valueOf(x[i]+"\r\n"));
    	fw.close();
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO3\\Y.txt",false);
    	for(int i=0;i<y.length;i++)
			fw1.write(String.valueOf(y[i]+"\r\n"));
    	fw1.close();
		FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO3\\Result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			fw2.write(y[i]+" ");
		fw2.write("\r\n");
		fw2.write("X=");
		for(int i=0;i<x.length;i++)
			fw2.write(x[i]+" ");
		fw2.write("\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("Generation="+generationCount+"\r\n");
		fw2.write("執行時間 T_total_time="+total_time+ "ms"+"\r\n");
		fw2.write("執行時間扣除寫檔時間  T_net="+T_net+ "ms"+"\r\n");
		fw2.write("\r\n");
		fw2.close();
		FileWriter fw3 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO3\\Generation_Time_Log.txt",false);
		fw3.write(String.valueOf(str));
	fw3.close();
	}
	public static void PSO4(double[] y, double[] x, double Fittest,int generationCount,  long total_time,long T_net,String str) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO4");
	    f2.mkdir();
    	FileWriter fw = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO4\\X.txt",false);
    	for(int i=0;i<x.length;i++)
			fw.write(String.valueOf(x[i]+"\r\n"));
    	fw.close();
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO4\\Y.txt",false);
    	for(int i=0;i<y.length;i++)
			fw1.write(String.valueOf(y[i]+"\r\n"));
    	fw1.close();
		FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO4\\Result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			fw2.write(y[i]+" ");
		fw2.write("\r\n");
		fw2.write("X=");
		for(int i=0;i<x.length;i++)
			fw2.write(x[i]+" ");
		fw2.write("\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("Generation="+generationCount+"\r\n");
		fw2.write("執行時間 T_total_time="+total_time+ "ms"+"\r\n");
		fw2.write("執行時間扣除寫檔時間  T_net="+T_net+ "ms"+"\r\n");
		fw2.write("\r\n");
		fw2.close();
		FileWriter fw3 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO4\\Generation_Time_Log.txt",false);
		fw3.write(String.valueOf(str));
	fw3.close();
	}
	public static void APSO1(int[] y, int[] x, double Fittest,int generationCount, long total_time,long T_net,String str) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\APSO1");
	    f2.mkdir();
    	FileWriter fw = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\APSO1\\X.txt",false);
    	for(int i=0;i<x.length;i++)
			fw.write(String.valueOf(x[i]+"\r\n"));
    	fw.close();
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\APSO1\\Y.txt",false);
    	for(int i=0;i<y.length;i++)
			fw1.write(String.valueOf(y[i]+"\r\n"));
    	fw1.close();
		FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\APSO1\\Result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			fw2.write(y[i]+" ");
		fw2.write("\r\n");
		fw2.write("X=");
		for(int i=0;i<x.length;i++)
			fw2.write(x[i]+" ");
		fw2.write("\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("Generation="+generationCount+"\r\n");
		fw2.write("執行時間 T_total_time="+total_time+ "ms"+"\r\n");
		fw2.write("執行時間扣除寫檔時間  T_net="+T_net+ "ms"+"\r\n");
		fw2.write("\r\n");
		fw2.close();
		FileWriter fw3 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\APSO1\\Generation_Time_Log.txt",false);
		fw3.write(String.valueOf(str));
	fw3.close();
	}
	public static void APSO2(int[] y, int[] x, double Fittest,int generationCount, long total_time,long T_net,String str) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\APSO2");
	    f2.mkdir();
    	FileWriter fw = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\APSO2\\X.txt",false);
    	for(int i=0;i<x.length;i++)
			fw.write(String.valueOf(x[i]+"\r\n"));
    	fw.close();
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\APSO2\\Y.txt",false);
    	for(int i=0;i<y.length;i++)
			fw1.write(String.valueOf(y[i]+"\r\n"));
    	fw1.close();
		FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\APSO2\\Result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			fw2.write(y[i]+" ");
		fw2.write("\r\n");
		fw2.write("X=");
		for(int i=0;i<x.length;i++)
			fw2.write(x[i]+" ");
		fw2.write("\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("Generation="+generationCount+"\r\n");
		fw2.write("執行時間 T_total_time="+total_time+ "ms"+"\r\n");
		fw2.write("執行時間扣除寫檔時間  T_net="+T_net+ "ms"+"\r\n");
		fw2.write("\r\n");
		fw2.close();
		FileWriter fw3 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\APSO2\\Generation_Time_Log.txt",false);
		fw3.write(String.valueOf(str));
	fw3.close();
	}
	public static void ALPSO(int[][] y, int[][] x, double Fittest,int generationCount,  long total_time,long T_net,String str) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\ALPSO");
	    f2.mkdir();
    	FileWriter fw = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\ALPSO\\X.txt",false);
    	for(int i=0;i<x.length;i++)
    		for(int j=0;j<x[i].length;j++)
			fw.write(String.valueOf(x[i][j]+"\r\n"));
    	fw.close();
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\ALPSO\\Y.txt",false);
    	for(int i=0;i<y.length;i++)
    		for(int j=0;j<y[i].length;j++)
			fw1.write(String.valueOf(y[i][j]+"\r\n"));
    	fw1.close();
		FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\ALPSO\\Result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			for(int j=0;j<y[i].length;j++)
			fw2.write(y[i][j]+" ");
		fw2.write("\r\n");
		fw2.write("X=");
		for(int i=0;i<x.length;i++)
			for(int j=0;j<x[i].length;j++)
			fw2.write(x[i][j]+" ");
		fw2.write("\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("Generation="+generationCount+"\r\n");
		fw2.write("執行時間 T_total_time="+total_time+ "ms"+"\r\n");
		fw2.write("執行時間扣除寫檔時間  T_net="+T_net+ "ms"+"\r\n");
		fw2.write("\r\n");
		fw2.close();
		FileWriter fw3 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\ALPSO\\Generation_Time_Log.txt",false);
		fw3.write(String.valueOf(str));
	fw3.close();
	}
	public static void ALPSO_P(int[][] y, int[][] x, double Fittest,int generationCount,  long total_time,long T_net,String str) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\ALPSO_P");
	    f2.mkdir();
    	FileWriter fw = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\ALPSO_P\\X.txt",false);
    	for(int i=0;i<x.length;i++)
    		for(int j=0;j<x[i].length;j++)
			fw.write(String.valueOf(x[i][j]+"\r\n"));
    	fw.close();
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\ALPSO_P\\Y.txt",false);
    	for(int i=0;i<y.length;i++)
    		for(int j=0;j<y[i].length;j++)
			fw1.write(String.valueOf(y[i][j]+"\r\n"));
    	fw1.close();
		FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\ALPSO_P\\Result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			for(int j=0;j<y[i].length;j++)
			fw2.write(y[i][j]+" ");
		fw2.write("\r\n");
		fw2.write("X=");
		for(int i=0;i<x.length;i++)
			for(int j=0;j<x[i].length;j++)
			fw2.write(x[i][j]+" ");
		fw2.write("\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("Generation="+generationCount+"\r\n");
		fw2.write("執行時間 T_total_time="+total_time+ "ms"+"\r\n");
		fw2.write("執行時間扣除寫檔時間  T_net="+T_net+ "ms"+"\r\n");
		fw2.write("\r\n");
		fw2.close();
		FileWriter fw3 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\ALPSO_P\\Generation_Time_Log.txt",false);
		fw3.write(String.valueOf(str));
	fw3.close();
	}
	public static void ALPSO_Tanh(int[][] y, int[][] x, double Fittest,int generationCount,  long total_time,long T_net,String str) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\ALPSO_Tanh");
	    f2.mkdir();
    	FileWriter fw = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\ALPSO_Tanh\\X.txt",false);
    	for(int i=0;i<x.length;i++)
    		for(int j=0;j<x[i].length;j++)
			fw.write(String.valueOf(x[i][j]+"\r\n"));
    	fw.close();
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\ALPSO_Tanh\\Y.txt",false);
    	for(int i=0;i<y.length;i++)
    		for(int j=0;j<y[i].length;j++)
			fw1.write(String.valueOf(y[i][j]+"\r\n"));
    	fw1.close();
		FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\ALPSO_Tanh\\Result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			for(int j=0;j<y[i].length;j++)
			fw2.write(y[i][j]+" ");
		fw2.write("\r\n");
		fw2.write("X=");
		for(int i=0;i<x.length;i++)
			for(int j=0;j<x[i].length;j++)
			fw2.write(x[i][j]+" ");
		fw2.write("\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("Generation="+generationCount+"\r\n");
		fw2.write("執行時間 T_total_time="+total_time+ "ms"+"\r\n");
		fw2.write("執行時間扣除寫檔時間  T_net="+T_net+ "ms"+"\r\n");
		fw2.write("\r\n");
		fw2.close();
		FileWriter fw3 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\ALPSO_Tanh\\Generation_Time_Log.txt",false);
		fw3.write(String.valueOf(str));
	fw3.close();
	}
	public static void LRPSO(int[][] y, int[][] x, double Fittest,int generationCount, long total_time,long T_net,String str) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LRPSO");
	    f2.mkdir();
    	FileWriter fw = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LRPSO\\X.txt",false);
    	for(int i=0;i<x.length;i++)
    		for(int j=0;j<x[i].length;j++)
			fw.write(String.valueOf(x[i][j]+"\r\n"));
    	fw.close();
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LRPSO\\Y.txt",false);
    	for(int i=0;i<y.length;i++)
    		for(int j=0;j<y[i].length;j++)
			fw1.write(String.valueOf(y[i][j]+"\r\n"));
    	fw1.close();
		FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LRPSO\\Result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			for(int j=0;j<y[i].length;j++)
			fw2.write(y[i][j]+" ");
		fw2.write("\r\n");
		fw2.write("X=");
		for(int i=0;i<x.length;i++)
			for(int j=0;j<x[i].length;j++)
			fw2.write(x[i][j]+" ");
		fw2.write("\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("Generation="+generationCount+"\r\n");
		fw2.write("執行時間 T_total_time="+total_time+ "ms"+"\r\n");
		fw2.write("執行時間扣除寫檔時間  T_net="+T_net+ "ms"+"\r\n");
		fw2.write("\r\n");
		fw2.close();
		FileWriter fw3 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LRPSO\\Generation_Time_Log.txt",false);
		fw3.write(String.valueOf(str));
	fw3.close();
	}
	public static void LRPSO_Tanh(int[][] y, int[][] x, double Fittest,int generationCount, long total_time,long T_net,String str) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LRPSO_Tanh");
	    f2.mkdir();
    	FileWriter fw = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LRPSO_Tanh\\X.txt",false);
    	for(int i=0;i<x.length;i++)
    		for(int j=0;j<x[i].length;j++)
			fw.write(String.valueOf(x[i][j]+"\r\n"));
    	fw.close();
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LRPSO_Tanh\\Y.txt",false);
    	for(int i=0;i<y.length;i++)
    		for(int j=0;j<y[i].length;j++)
			fw1.write(String.valueOf(y[i][j]+"\r\n"));
    	fw1.close();
		FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LRPSO_Tanh\\Result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			for(int j=0;j<y[i].length;j++)
			fw2.write(y[i][j]+" ");
		fw2.write("\r\n");
		fw2.write("X=");
		for(int i=0;i<x.length;i++)
			for(int j=0;j<x[i].length;j++)
			fw2.write(x[i][j]+" ");
		fw2.write("\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("Generation="+generationCount+"\r\n");
		fw2.write("執行時間 T_total_time="+total_time+ "ms"+"\r\n");
		fw2.write("執行時間扣除寫檔時間  T_net="+T_net+ "ms"+"\r\n");
		fw2.write("\r\n");
		fw2.close();
		FileWriter fw3 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LRPSO_Tanh\\Generation_Time_Log.txt",false);
		fw3.write(String.valueOf(str));
	fw3.close();
	}
	public static void LRPSO_P(int[][] y, int[][] x, double Fittest,int generationCount, long total_time,long T_net,String str) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LRPSO_P");
	    f2.mkdir();
    	FileWriter fw = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LRPSO_P\\X.txt",false);
    	for(int i=0;i<x.length;i++)
    		for(int j=0;j<x[i].length;j++)
			fw.write(String.valueOf(x[i][j]+"\r\n"));
    	fw.close();
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LRPSO_P\\Y.txt",false);
    	for(int i=0;i<y.length;i++)
    		for(int j=0;j<y[i].length;j++)
			fw1.write(String.valueOf(y[i][j]+"\r\n"));
    	fw1.close();
		FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LRPSO_P\\Result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			for(int j=0;j<y[i].length;j++)
			fw2.write(y[i][j]+" ");
		fw2.write("\r\n");
		fw2.write("X=");
		for(int i=0;i<x.length;i++)
			for(int j=0;j<x[i].length;j++)
			fw2.write(x[i][j]+" ");
		fw2.write("\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("Generation="+generationCount+"\r\n");
		fw2.write("執行時間 T_total_time="+total_time+ "ms"+"\r\n");
		fw2.write("執行時間扣除寫檔時間  T_net="+T_net+ "ms"+"\r\n");
		fw2.write("\r\n");
		fw2.close();
		FileWriter fw3 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LRPSO_P\\Generation_Time_Log.txt",false);
		fw3.write(String.valueOf(str));
	fw3.close();
	}
	public static void LR(int[][] y, int[][] x, double Fittest,int generationCount, long time) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR");
	    f2.mkdir();
    	FileWriter fw = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR\\X.txt",false);
    	for(int i=0;i<x.length;i++)
    		for(int j=0;j<x[i].length;j++)
			fw.write(String.valueOf(x[i][j]+"\r\n"));
    	fw.close();
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR\\Y.txt",false);
    	for(int i=0;i<y.length;i++)
    		for(int j=0;j<y[i].length;j++)
			fw1.write(String.valueOf(y[i][j]+"\r\n"));
    	fw1.close();
		FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR\\Result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			for(int j=0;j<y[i].length;j++)
			fw2.write(y[i][j]+" ");
		fw2.write("\r\n");
		fw2.write("X=");
		for(int i=0;i<x.length;i++)
			for(int j=0;j<x[i].length;j++)
			fw2.write(x[i][j]+" ");
		fw2.write("\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("Generation="+generationCount+"\r\n");
		fw2.write("執行時間="+time+ "ms"+"\r\n");
		fw2.write("\r\n");
		fw2.close();
	}
	public static void LR_and_PSO2(int[][] y, int[][] x, double Fittest,int generationCount,  long total_time,long T_net) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR_and_PSO2");
	    f2.mkdir();
    	FileWriter fw = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR_and_PSO2\\X.txt",false);
    	for(int i=0;i<x.length;i++)
    		for(int j=0;j<x[i].length;j++)
			fw.write(String.valueOf(x[i][j]+"\r\n"));
    	fw.close();
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR_and_PSO2\\Y.txt",false);
    	for(int i=0;i<y.length;i++)
    		for(int j=0;j<y[i].length;j++)
			fw1.write(String.valueOf(y[i][j]+"\r\n"));
    	fw1.close();
		FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR_and_PSO2\\Result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			for(int j=0;j<y[i].length;j++)
			fw2.write(y[i][j]+" ");
		fw2.write("\r\n");
		fw2.write("X=");
		for(int i=0;i<x.length;i++)
			for(int j=0;j<x[i].length;j++)
			fw2.write(x[i][j]+" ");
		fw2.write("\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("Generation="+generationCount+"\r\n");
		fw2.write("執行時間 T_total_time="+total_time+ "ms"+"\r\n");
		fw2.write("執行時間扣除寫檔時間  T_net="+T_net+ "ms"+"\r\n");
		fw2.write("\r\n");
		fw2.close();
	}
	public static void LR_and_PSO2_P(int[][] y, int[][] x, double Fittest,int generationCount,  long total_time,long T_net) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR_and_PSO2_P");
	    f2.mkdir();
    	FileWriter fw = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR_and_PSO2_P\\X.txt",false);
    	for(int i=0;i<x.length;i++)
    		for(int j=0;j<x[i].length;j++)
			fw.write(String.valueOf(x[i][j]+"\r\n"));
    	fw.close();
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR_and_PSO2_P\\Y.txt",false);
    	for(int i=0;i<y.length;i++)
    		for(int j=0;j<y[i].length;j++)
			fw1.write(String.valueOf(y[i][j]+"\r\n"));
    	fw1.close();
		FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR_and_PSO2_P\\Result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			for(int j=0;j<y[i].length;j++)
			fw2.write(y[i][j]+" ");
		fw2.write("\r\n");
		fw2.write("X=");
		for(int i=0;i<x.length;i++)
			for(int j=0;j<x[i].length;j++)
			fw2.write(x[i][j]+" ");
		fw2.write("\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("Generation="+generationCount+"\r\n");
		fw2.write("執行時間 T_total_time="+total_time+ "ms"+"\r\n");
		fw2.write("執行時間扣除寫檔時間  T_net="+T_net+ "ms"+"\r\n");
		fw2.write("\r\n");
		fw2.close();
	}
	public static void LR_and_PSO2_Tanh(int[][] y, int[][] x, double Fittest,int generationCount,  long total_time,long T_net) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR_and_PSO2_Tanh");
	    f2.mkdir();
    	FileWriter fw = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR_and_PSO2_Tanh\\X.txt",false);
    	for(int i=0;i<x.length;i++)
    		for(int j=0;j<x[i].length;j++)
			fw.write(String.valueOf(x[i][j]+"\r\n"));
    	fw.close();
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR_and_PSO2_Tanh\\Y.txt",false);
    	for(int i=0;i<y.length;i++)
    		for(int j=0;j<y[i].length;j++)
			fw1.write(String.valueOf(y[i][j]+"\r\n"));
    	fw1.close();
		FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR_and_PSO2_Tanh\\Result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			for(int j=0;j<y[i].length;j++)
			fw2.write(y[i][j]+" ");
		fw2.write("\r\n");
		fw2.write("X=");
		for(int i=0;i<x.length;i++)
			for(int j=0;j<x[i].length;j++)
			fw2.write(x[i][j]+" ");
		fw2.write("\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("Generation="+generationCount+"\r\n");
		fw2.write("執行時間 T_total_time="+total_time+ "ms"+"\r\n");
		fw2.write("執行時間扣除寫檔時間  T_net="+T_net+ "ms"+"\r\n");
		fw2.write("\r\n");
		fw2.close();
	}
	public static void LR_and_PSO1(int[][] y, int[][] x, double Fittest,int generationCount, long total_time,long T_net) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR_and_PSO1");
	    f2.mkdir();
    	FileWriter fw = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR_and_PSO1\\X.txt",false);
    	for(int i=0;i<x.length;i++)
    		for(int j=0;j<x[i].length;j++)
			fw.write(String.valueOf(x[i][j]+"\r\n"));
    	fw.close();
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR_and_PSO1\\Y.txt",false);
    	for(int i=0;i<y.length;i++)
    		for(int j=0;j<y[i].length;j++)
			fw1.write(String.valueOf(y[i][j]+"\r\n"));
    	fw1.close();
		FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR_and_PSO1\\Result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			for(int j=0;j<y[i].length;j++)
			fw2.write(y[i][j]+" ");
		fw2.write("\r\n");
		fw2.write("X=");
		for(int i=0;i<x.length;i++)
			for(int j=0;j<x[i].length;j++)
			fw2.write(x[i][j]+" ");
		fw2.write("\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("Generation="+generationCount+"\r\n");
		fw2.write("執行時間 T_total_time="+total_time+ "ms"+"\r\n");
		fw2.write("執行時間扣除寫檔時間  T_net="+T_net+ "ms"+"\r\n");
		fw2.write("\r\n");
		fw2.close();
	}
	public static void LR_and_PSO1_Tanh(int[][] y, int[][] x, double Fittest,int generationCount, long total_time,long T_net) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR_and_PSO1_Tanh");
	    f2.mkdir();
    	FileWriter fw = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR_and_PSO1_Tanh\\X.txt",false);
    	for(int i=0;i<x.length;i++)
    		for(int j=0;j<x[i].length;j++)
			fw.write(String.valueOf(x[i][j]+"\r\n"));
    	fw.close();
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR_and_PSO1_Tanh\\Y.txt",false);
    	for(int i=0;i<y.length;i++)
    		for(int j=0;j<y[i].length;j++)
			fw1.write(String.valueOf(y[i][j]+"\r\n"));
    	fw1.close();
		FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR_and_PSO1_Tanh\\Result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			for(int j=0;j<y[i].length;j++)
			fw2.write(y[i][j]+" ");
		fw2.write("\r\n");
		fw2.write("X=");
		for(int i=0;i<x.length;i++)
			for(int j=0;j<x[i].length;j++)
			fw2.write(x[i][j]+" ");
		fw2.write("\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("Generation="+generationCount+"\r\n");
		fw2.write("執行時間 T_total_time="+total_time+ "ms"+"\r\n");
		fw2.write("執行時間扣除寫檔時間  T_net="+T_net+ "ms"+"\r\n");
		fw2.write("\r\n");
		fw2.close();
	}
	public static void LR_and_PSO1_P(int[][] y, int[][] x, double Fittest,int generationCount, long total_time,long T_net) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR_and_PSO1_P");
	    f2.mkdir();
    	FileWriter fw = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR_and_PSO1_P\\X.txt",false);
    	for(int i=0;i<x.length;i++)
    		for(int j=0;j<x[i].length;j++)
			fw.write(String.valueOf(x[i][j]+"\r\n"));
    	fw.close();
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR_and_PSO1_P\\Y.txt",false);
    	for(int i=0;i<y.length;i++)
    		for(int j=0;j<y[i].length;j++)
			fw1.write(String.valueOf(y[i][j]+"\r\n"));
    	fw1.close();
		FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR_and_PSO1_P\\Result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			for(int j=0;j<y[i].length;j++)
			fw2.write(y[i][j]+" ");
		fw2.write("\r\n");
		fw2.write("X=");
		for(int i=0;i<x.length;i++)
			for(int j=0;j<x[i].length;j++)
			fw2.write(x[i][j]+" ");
		fw2.write("\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("Generation="+generationCount+"\r\n");
		fw2.write("執行時間 T_total_time="+total_time+ "ms"+"\r\n");
		fw2.write("執行時間扣除寫檔時間  T_net="+T_net+ "ms"+"\r\n");
		fw2.write("\r\n");
		fw2.close();
	}
	public static void CCPSO2(int[] y, int[] x, double Fittest,int generationCount, long total_time,long T_net) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\CCPSO2");
	    f2.mkdir();
    	FileWriter fw = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\CCPSO2\\X.txt",false);
    	for(int i=0;i<x.length;i++)
			fw.write(String.valueOf(x[i]+"\r\n"));
    	fw.close();
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\CCPSO2\\Y.txt",false);
    	for(int i=0;i<y.length;i++)
			fw1.write(String.valueOf(y[i]+"\r\n"));
    	fw1.close();
		FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\CCPSO2\\Result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			fw2.write(y[i]+" ");
		fw2.write("\r\n");
		fw2.write("X=");
		for(int i=0;i<x.length;i++)
			fw2.write(x[i]+" ");
		fw2.write("\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("Generation="+generationCount+"\r\n");
		fw2.write("執行時間 T_total_time="+total_time+ "ms"+"\r\n");
		fw2.write("執行時間扣除寫檔時間  T_net="+T_net+ "ms"+"\r\n");
		fw2.write("\r\n");
		fw2.close();
	}
	public static void CCPSO2_P(int[] y, int[] x, double Fittest,int generationCount, long total_time,long T_net) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\CCPSO2_P");
	    f2.mkdir();
    	FileWriter fw = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\CCPSO2_P\\X.txt",false);
    	for(int i=0;i<x.length;i++)
			fw.write(String.valueOf(x[i]+"\r\n"));
    	fw.close();
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\CCPSO2_P\\Y.txt",false);
    	for(int i=0;i<y.length;i++)
			fw1.write(String.valueOf(y[i]+"\r\n"));
    	fw1.close();
		FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\CCPSO2_P\\Result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			fw2.write(y[i]+" ");
		fw2.write("\r\n");
		fw2.write("X=");
		for(int i=0;i<x.length;i++)
			fw2.write(x[i]+" ");
		fw2.write("\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("Generation="+generationCount+"\r\n");
		fw2.write("執行時間 T_total_time="+total_time+ "ms"+"\r\n");
		fw2.write("執行時間扣除寫檔時間  T_net="+T_net+ "ms"+"\r\n");
		fw2.write("\r\n");
		fw2.close();
	}
	public static void CCPSO2_Tanh(int[] y, int[] x, double Fittest,int generationCount, long total_time,long T_net) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\CCPSO2_Tanh");
	    f2.mkdir();
    	FileWriter fw = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\CCPSO2_Tanh\\X.txt",false);
    	for(int i=0;i<x.length;i++)
			fw.write(String.valueOf(x[i]+"\r\n"));
    	fw.close();
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\CCPSO2_Tanh\\Y.txt",false);
    	for(int i=0;i<y.length;i++)
			fw1.write(String.valueOf(y[i]+"\r\n"));
    	fw1.close();
		FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\CCPSO2_Tanh\\Result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			fw2.write(y[i]+" ");
		fw2.write("\r\n");
		fw2.write("X=");
		for(int i=0;i<x.length;i++)
			fw2.write(x[i]+" ");
		fw2.write("\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("Generation="+generationCount+"\r\n");
		fw2.write("執行時間 T_total_time="+total_time+ "ms"+"\r\n");
		fw2.write("執行時間扣除寫檔時間  T_net="+T_net+ "ms"+"\r\n");
		fw2.write("\r\n");
		fw2.close();
	}
	public static void LR_XY_Lambda(int[][] y, int[][] x, double Fittest,int generationCount, long time,double[] Lambda1,double Lambda2,double[][] Lambda3,double[][] Lambda4) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path());
	    f2.mkdir();
	    File f3 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"LR_XY_Lambda");
	    f3.mkdir();
    	FileWriter fw = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"LR_XY_Lambda\\LR_X.txt",false);
    	for(int i=0;i<x.length;i++)
    		for(int j=0;j<x[i].length;j++)
			fw.write(String.valueOf(x[i][j]+"\r\n"));
    	fw.close();
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"LR_XY_Lambda\\LR_Y.txt",false);
    	for(int i=0;i<y.length;i++)
    		for(int j=0;j<y[i].length;j++)
			fw1.write(String.valueOf(y[i][j]+"\r\n"));
    	fw1.close();
	/*	FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR_and_PSO2\\Result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			for(int j=0;j<y[i].length;j++)
			fw2.write(y[i][j]+" ");
		fw2.write("\r\n");
		fw2.write("X=");
		for(int i=0;i<x.length;i++)
			for(int j=0;j<x[i].length;j++)
			fw2.write(x[i][j]+" ");
		fw2.write("\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("Generation="+generationCount+"\r\n");
		fw2.write("執行時間="+time+ "ms"+"\r\n");
		fw2.write("\r\n");
		fw2.close();*/
    	FileWriter fw3 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"LR_XY_Lambda\\Lambda1.txt",false);
    	for(int i=0;i<Lambda1.length;i++)
    			fw3.write(String.valueOf(Lambda1[i]+"\r\n"));
    	fw3.close();
    	FileWriter fw4 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"LR_XY_Lambda\\Lambda2.txt",false);
    			fw4.write(String.valueOf(Lambda2+"\r\n"));
    	fw4.close();
    	FileWriter fw5 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"LR_XY_Lambda\\Lambda3.txt",false);
    	for(int i=0;i<Lambda3.length;i++)
    		for(int j=0;j<Lambda3[i].length;j++)
    			fw5.write(String.valueOf(Lambda3[i][j]+"\r\n"));
    	fw5.close();
    	
    	FileWriter fw6 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"LR_XY_Lambda\\Lambda4.txt",false);
    	for(int i=0;i<Lambda4.length;i++)
    		for(int j=0;j<Lambda4[i].length;j++)
    			fw6.write(String.valueOf(Lambda4[i][j]+"\r\n"));
    	fw6.close();
	}
	
	public static void LR_XY_Lambda_DA(int[][] y, int[][] x, double Fittest,int generationCount, long time,double[] Lambda1,double Lambda2,double[][] Lambda3) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path());
	    f2.mkdir();
	    File f3 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"LR_XY_Lambda");
	    f3.mkdir();
    	FileWriter fw = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"LR_XY_Lambda\\LR_X.txt",false);
    	for(int i=0;i<x.length;i++)
    		for(int j=0;j<x[i].length;j++)
			fw.write(String.valueOf(x[i][j]+"\r\n"));
    	fw.close();
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"LR_XY_Lambda\\LR_Y.txt",false);
    	for(int i=0;i<y.length;i++)
    		for(int j=0;j<y[i].length;j++)
			fw1.write(String.valueOf(y[i][j]+"\r\n"));
    	fw1.close();
	/*	FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR_and_PSO2\\Result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			for(int j=0;j<y[i].length;j++)
			fw2.write(y[i][j]+" ");
		fw2.write("\r\n");
		fw2.write("X=");
		for(int i=0;i<x.length;i++)
			for(int j=0;j<x[i].length;j++)
			fw2.write(x[i][j]+" ");
		fw2.write("\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("Generation="+generationCount+"\r\n");
		fw2.write("執行時間="+time+ "ms"+"\r\n");
		fw2.write("\r\n");
		fw2.close();*/
    	FileWriter fw3 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"LR_XY_Lambda\\Lambda1.txt",false);
    	for(int i=0;i<Lambda1.length;i++)
    			fw3.write(String.valueOf(Lambda1[i]+"\r\n"));
    	fw3.close();
    	FileWriter fw4 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"LR_XY_Lambda\\Lambda2.txt",false);
    			fw4.write(String.valueOf(Lambda2+"\r\n"));
    	fw4.close();
    	FileWriter fw5 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"LR_XY_Lambda\\Lambda3.txt",false);
    	for(int i=0;i<Lambda3.length;i++)
    		for(int j=0;j<Lambda3[i].length;j++)
    			fw5.write(String.valueOf(Lambda3[i][j]+"\r\n"));
    	fw5.close();
	}
	public static void PSO_LS(int[] y, int[] x, double Fittest,int generationCount, long total_time,long T_net,String str) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO_LS");
	    f2.mkdir();
    	FileWriter fw = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO_LS\\X.txt",false);
    	for(int i=0;i<x.length;i++)
			fw.write(String.valueOf(x[i]+"\r\n"));
    	fw.close();
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO_LS\\Y.txt",false);
    	for(int i=0;i<y.length;i++)
			fw1.write(String.valueOf(y[i]+"\r\n"));
    	fw1.close();
		FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO_LS\\Result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			fw2.write(y[i]+" ");
		fw2.write("\r\n");
		fw2.write("X=");
		for(int i=0;i<x.length;i++)
			fw2.write(x[i]+" ");
		fw2.write("\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("Generation="+generationCount+"\r\n");
		fw2.write("執行時間 T_total_time="+total_time+ "ms"+"\r\n");
		fw2.write("執行時間扣除寫檔時間  T_net="+T_net+ "ms"+"\r\n");
		fw2.write("\r\n");
		fw2.close();
		FileWriter fw3 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO_LS\\Generation_Time_Log.txt",false);
		fw3.write(String.valueOf(str));
	fw3.close();
	}
	public static void PSO_TS(int[] y, int[] x, double Fittest,int generationCount, long total_time,long T_net,String str) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO_TS");
	    f2.mkdir();
    	FileWriter fw = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO_TS\\X.txt",false);
    	for(int i=0;i<x.length;i++)
			fw.write(String.valueOf(x[i]+"\r\n"));
    	fw.close();
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO_TS\\Y.txt",false);
    	for(int i=0;i<y.length;i++)
			fw1.write(String.valueOf(y[i]+"\r\n"));
    	fw1.close();
		FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO_TS\\Result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			fw2.write(y[i]+" ");
		fw2.write("\r\n");
		fw2.write("X=");
		for(int i=0;i<x.length;i++)
			fw2.write(x[i]+" ");
		fw2.write("\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("Generation="+generationCount+"\r\n");
		fw2.write("執行時間 T_total_time="+total_time+ "ms"+"\r\n");
		fw2.write("執行時間扣除寫檔時間  T_net="+T_net+ "ms"+"\r\n");
		fw2.write("\r\n");
		fw2.close();
		FileWriter fw3 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO_TS\\Generation_Time_Log.txt",false);
		fw3.write(String.valueOf(str));
	fw3.close();
	}
	public static void TS_DA(double[] y, double[] x, double Fittest ,long total_time) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\TS_DA");
	    f2.mkdir();
    	FileWriter fw = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\TS_DA\\X.txt",false);
    	for(int i=0;i<x.length;i++)
			fw.write(String.valueOf(x[i]+"\r\n"));
    	fw.close();
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\TS_DA\\Y.txt",false);
    	for(int i=0;i<y.length;i++)
			fw1.write(String.valueOf(y[i]+"\r\n"));
    	fw1.close();
		FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\TS_DA\\Result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			fw2.write(y[i]+" ");
		fw2.write("\r\n");
		fw2.write("X=");
		for(int i=0;i<x.length;i++)
			fw2.write(x[i]+" ");
		fw2.write("\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		
		fw2.write("執行時間 T_total_time="+total_time+ "ms"+"\r\n");
	
		fw2.write("\r\n");
		fw2.close();
		

	}
	public static void DE(int[] y, int[] x, double Fittest,int generationCount, long total_time,long T_net,String str) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path());
	    f2.mkdir();
    	FileWriter fw = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\X.txt",false);
    	for(int i=0;i<x.length;i++)
			fw.write(String.valueOf(x[i]+"\r\n"));
    	fw.close();
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\Y.txt",false);
    	for(int i=0;i<y.length;i++)
			fw1.write(String.valueOf(y[i]+"\r\n"));
    	fw1.close();
		FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\Result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			fw2.write(y[i]+" ");
		fw2.write("\r\n");
		fw2.write("X=");
		for(int i=0;i<x.length;i++)
			fw2.write(x[i]+" ");
		fw2.write("\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("Generation="+generationCount+"\r\n");
		fw2.write("執行時間 T_total_time="+total_time+ "ms"+"\r\n");
		fw2.write("執行時間扣除寫檔時間  T_net="+T_net+ "ms"+"\r\n");
		fw2.write("\r\n");
		fw2.close();
		FileWriter fw3 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\Generation_Time_Log.txt",false);
		fw3.write(String.valueOf(str));
	fw3.close();
	}
	public static void DE_DA_Real(int[] y, int[] x, double Fittest,int generationCount, long total_time,long T_net,String str) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path());
	    f2.mkdir();
    	FileWriter fw = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\X.txt",false);
    	for(int i=0;i<x.length;i++)
			fw.write(String.valueOf(x[i]+"\r\n"));
    	fw.close();
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\Y.txt",false);
    	for(int i=0;i<y.length;i++)
			fw1.write(String.valueOf(y[i]+"\r\n"));
    	fw1.close();
		FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\Result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			fw2.write(y[i]+" ");
		fw2.write("\r\n");
		fw2.write("X=");
		for(int i=0;i<x.length;i++)
			fw2.write(x[i]+" ");
		fw2.write("\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("Generation="+generationCount+"\r\n");
		fw2.write("執行時間 T_total_time="+total_time+ "ms"+"\r\n");
		fw2.write("執行時間扣除寫檔時間  T_net="+T_net+ "ms"+"\r\n");
		fw2.write("\r\n");
		fw2.close();
		FileWriter fw3 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\Generation_Time_Log.txt",false);
		fw3.write(String.valueOf(str));
	fw3.close();
	}
	public static void DE_Real_Problem3(int[] y, int[] x, double Fittest,int generationCount, long total_time,long T_net,String str) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path());
	    f2.mkdir();
    	FileWriter fw = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\X.txt",false);
    	for(int i=0;i<x.length;i++)
			fw.write(String.valueOf(x[i]+"\r\n"));
    	fw.close();
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\Y.txt",false);
    	for(int i=0;i<y.length;i++)
			fw1.write(String.valueOf(y[i]+"\r\n"));
    	fw1.close();
		FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\Result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			fw2.write(y[i]+" ");
		fw2.write("\r\n");
		fw2.write("X=");
		for(int i=0;i<x.length;i++)
			fw2.write(x[i]+" ");
		fw2.write("\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("Generation="+generationCount+"\r\n");
		fw2.write("執行時間 T_total_time="+total_time+ "ms"+"\r\n");
		fw2.write("執行時間扣除寫檔時間  T_net="+T_net+ "ms"+"\r\n");
		fw2.write("\r\n");
		fw2.close();
		FileWriter fw3 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\Generation_Time_Log.txt",false);
		fw3.write(String.valueOf(str));
	fw3.close();
	}
	public static void DE_Real_POP_Problem3(int[] y, int[] x, double Fittest,int generationCount, long total_time,long T_net,String str) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path());
	    f2.mkdir();
    	FileWriter fw = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\X.txt",false);
    	for(int i=0;i<x.length;i++)
			fw.write(String.valueOf(x[i]+"\r\n"));
    	fw.close();
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\Y.txt",false);
    	for(int i=0;i<y.length;i++)
			fw1.write(String.valueOf(y[i]+"\r\n"));
    	fw1.close();
		FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\Result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			fw2.write(y[i]+" ");
		fw2.write("\r\n");
		fw2.write("X=");
		for(int i=0;i<x.length;i++)
			fw2.write(x[i]+" ");
		fw2.write("\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("Generation="+generationCount+"\r\n");
		fw2.write("執行時間 T_total_time="+total_time+ "ms"+"\r\n");
		fw2.write("執行時間扣除寫檔時間  T_net="+T_net+ "ms"+"\r\n");
		fw2.write("\r\n");
		fw2.close();
		FileWriter fw3 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\Generation_Time_Log.txt",false);
		fw3.write(String.valueOf(str));
	fw3.close();
	}
	public static void NSDE_DA(int[] y, int[] x, double Fittest,int generationCount, long total_time,long T_net,String str) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path());
	    f2.mkdir();
    	FileWriter fw = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\X.txt",false);
    	for(int i=0;i<x.length;i++)
			fw.write(String.valueOf(x[i]+"\r\n"));
    	fw.close();
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\Y.txt",false);
    	for(int i=0;i<y.length;i++)
			fw1.write(String.valueOf(y[i]+"\r\n"));
    	fw1.close();
		FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\Result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			fw2.write(y[i]+" ");
		fw2.write("\r\n");
		fw2.write("X=");
		for(int i=0;i<x.length;i++)
			fw2.write(x[i]+" ");
		fw2.write("\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("Generation="+generationCount+"\r\n");
		fw2.write("執行時間 T_total_time="+total_time+ "ms"+"\r\n");
		fw2.write("執行時間扣除寫檔時間  T_net="+T_net+ "ms"+"\r\n");
		fw2.write("\r\n");
		fw2.close();
		FileWriter fw3 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\Generation_Time_Log.txt",false);
		fw3.write(String.valueOf(str));
	fw3.close();
	}
	public static void L_SHADE_DA(int[] y, int[] x, double Fittest,int generationCount, long total_time,long T_net,String str) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path());
	    f2.mkdir();
    	FileWriter fw = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\X.txt",false);
    	for(int i=0;i<x.length;i++)
			fw.write(String.valueOf(x[i]+"\r\n"));
    	fw.close();
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\Y.txt",false);
    	for(int i=0;i<y.length;i++)
			fw1.write(String.valueOf(y[i]+"\r\n"));
    	fw1.close();
		FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\Result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			fw2.write(y[i]+" ");
		fw2.write("\r\n");
		fw2.write("X=");
		for(int i=0;i<x.length;i++)
			fw2.write(x[i]+" ");
		fw2.write("\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("Generation="+generationCount+"\r\n");
		fw2.write("執行時間 T_total_time="+total_time+ "ms"+"\r\n");
		fw2.write("執行時間扣除寫檔時間  T_net="+T_net+ "ms"+"\r\n");
		fw2.write("\r\n");
		fw2.close();
		FileWriter fw3 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\Generation_Time_Log.txt",false);
		fw3.write(String.valueOf(str));
	fw3.close();
	}
	public static void NSDE_DA_Problem3(int[] y, int[] x, double Fittest,int generationCount, long total_time,long T_net,String str) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path());
	    f2.mkdir();
    	FileWriter fw = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\X.txt",false);
    	for(int i=0;i<x.length;i++)
			fw.write(String.valueOf(x[i]+"\r\n"));
    	fw.close();
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\Y.txt",false);
    	for(int i=0;i<y.length;i++)
			fw1.write(String.valueOf(y[i]+"\r\n"));
    	fw1.close();
		FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\Result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			fw2.write(y[i]+" ");
		fw2.write("\r\n");
		fw2.write("X=");
		for(int i=0;i<x.length;i++)
			fw2.write(x[i]+" ");
		fw2.write("\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("Generation="+generationCount+"\r\n");
		fw2.write("執行時間 T_total_time="+total_time+ "ms"+"\r\n");
		fw2.write("執行時間扣除寫檔時間  T_net="+T_net+ "ms"+"\r\n");
		fw2.write("\r\n");
		fw2.close();
		FileWriter fw3 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\Generation_Time_Log.txt",false);
		fw3.write(String.valueOf(str));
	fw3.close();
	}
	public static void SaNSDE_DA(int[] y, int[] x, double Fittest,int generationCount, long total_time,long T_net,String str) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path());
	    f2.mkdir();
    	FileWriter fw = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\X.txt",false);
    	for(int i=0;i<x.length;i++)
			fw.write(String.valueOf(x[i]+"\r\n"));
    	fw.close();
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\Y.txt",false);
    	for(int i=0;i<y.length;i++)
			fw1.write(String.valueOf(y[i]+"\r\n"));
    	fw1.close();
		FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\Result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			fw2.write(y[i]+" ");
		fw2.write("\r\n");
		fw2.write("X=");
		for(int i=0;i<x.length;i++)
			fw2.write(x[i]+" ");
		fw2.write("\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("Generation="+generationCount+"\r\n");
		fw2.write("執行時間 T_total_time="+total_time+ "ms"+"\r\n");
		fw2.write("執行時間扣除寫檔時間  T_net="+T_net+ "ms"+"\r\n");
		fw2.write("\r\n");
		fw2.close();
		FileWriter fw3 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\Generation_Time_Log.txt",false);
		fw3.write(String.valueOf(str));
	fw3.close();
	}
	public static void SaNSDE_DA_Problem3(int[] y, int[] x, double Fittest,int generationCount, long total_time,long T_net,String str) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path());
	    f2.mkdir();
    	FileWriter fw = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\X.txt",false);
    	for(int i=0;i<x.length;i++)
			fw.write(String.valueOf(x[i]+"\r\n"));
    	fw.close();
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\Y.txt",false);
    	for(int i=0;i<y.length;i++)
			fw1.write(String.valueOf(y[i]+"\r\n"));
    	fw1.close();
		FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\Result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			fw2.write(y[i]+" ");
		fw2.write("\r\n");
		fw2.write("X=");
		for(int i=0;i<x.length;i++)
			fw2.write(x[i]+" ");
		fw2.write("\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("Generation="+generationCount+"\r\n");
		fw2.write("執行時間 T_total_time="+total_time+ "ms"+"\r\n");
		fw2.write("執行時間扣除寫檔時間  T_net="+T_net+ "ms"+"\r\n");
		fw2.write("\r\n");
		fw2.close();
		FileWriter fw3 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\Generation_Time_Log.txt",false);
		fw3.write(String.valueOf(str));
	fw3.close();
	}
	public static void Heuristic_PSO_DA(int[] y, int[] x, double Fittest,int generationCount, long total_time,long T_net,String str) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\Heuristic_PSO_DA");
	    f2.mkdir();
    	FileWriter fw = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\Heuristic_PSO_DA\\X.txt",false);
    	for(int i=0;i<x.length;i++)
			fw.write(String.valueOf(x[i]+"\r\n"));
    	fw.close();
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\Heuristic_PSO_DA\\Y.txt",false);
    	for(int i=0;i<y.length;i++)
			fw1.write(String.valueOf(y[i]+"\r\n"));
    	fw1.close();
		FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\Heuristic_PSO_DA\\Result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			fw2.write(y[i]+" ");
		fw2.write("\r\n");
		fw2.write("X=");
		for(int i=0;i<x.length;i++)
			fw2.write(x[i]+" ");
		fw2.write("\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("Generation="+generationCount+"\r\n");
		fw2.write("執行時間 T_total_time="+total_time+ "ms"+"\r\n");
		fw2.write("執行時間扣除寫檔時間  T_net="+T_net+ "ms"+"\r\n");
		fw2.write("\r\n");
		fw2.close();
		FileWriter fw3 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\Heuristic_PSO_DA\\Generation_Time_Log.txt",false);
		fw3.write(String.valueOf(str));
	fw3.close();
		

	}
	
	public static void FA(int[] y, int[] x, double Fittest,int generationCount, long total_time,long T_net,String str) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\FA");
	    f2.mkdir();
    	FileWriter fw = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\FA\\X.txt",false);
    	for(int i=0;i<x.length;i++)
			fw.write(String.valueOf(x[i]+"\r\n"));
    	fw.close();
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\FA\\Y.txt",false);
    	for(int i=0;i<y.length;i++)
			fw1.write(String.valueOf(y[i]+"\r\n"));
    	fw1.close();
		FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\FA\\Result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			fw2.write(y[i]+" ");
		fw2.write("\r\n");
		fw2.write("X=");
		for(int i=0;i<x.length;i++)
			fw2.write(x[i]+" ");
		fw2.write("\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("Generation="+generationCount+"\r\n");
		fw2.write("執行時間 T_total_time="+total_time+ "ms"+"\r\n");
		fw2.write("執行時間扣除寫檔時間  T_net="+T_net+ "ms"+"\r\n");
		fw2.write("\r\n");
		fw2.close();
		FileWriter fw3 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\FA\\Generation_Time_Log.txt",false);
		fw3.write(String.valueOf(str));
	fw3.close();
	}
	public static void FA_PSO(int[] y, int[] x, double Fittest,int generationCount, long total_time,long T_net,String str) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\FA_PSO");
	    f2.mkdir();
    	FileWriter fw = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\FA_PSO\\X.txt",false);
    	for(int i=0;i<x.length;i++)
			fw.write(String.valueOf(x[i]+"\r\n"));
    	fw.close();
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\FA_PSO\\Y.txt",false);
    	for(int i=0;i<y.length;i++)
			fw1.write(String.valueOf(y[i]+"\r\n"));
    	fw1.close();
		FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\FA_PSO\\Result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			fw2.write(y[i]+" ");
		fw2.write("\r\n");
		fw2.write("X=");
		for(int i=0;i<x.length;i++)
			fw2.write(x[i]+" ");
		fw2.write("\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("Generation="+generationCount+"\r\n");
		fw2.write("執行時間 T_total_time="+total_time+ "ms"+"\r\n");
		fw2.write("執行時間扣除寫檔時間  T_net="+T_net+ "ms"+"\r\n");
		fw2.write("\r\n");
		fw2.close();
		FileWriter fw3 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\FA_PSO\\Generation_Time_Log.txt",false);
		fw3.write(String.valueOf(str));
	fw3.close();
	}
 	

	public static void DMS_L_PSO(int[] y, int[] x, double Fittest,int generationCount, long total_time,long T_net,String str) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path());
	    f2.mkdir();
    	FileWriter fw = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\X.txt",false);
    	for(int i=0;i<x.length;i++)
			fw.write(String.valueOf(x[i]+"\r\n"));
    	fw.close();
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\Y.txt",false);
    	for(int i=0;i<y.length;i++)
			fw1.write(String.valueOf(y[i]+"\r\n"));
    	fw1.close();
		FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\Result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			fw2.write(y[i]+" ");
		fw2.write("\r\n");
		fw2.write("X=");
		for(int i=0;i<x.length;i++)
			fw2.write(x[i]+" ");
		fw2.write("\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("Generation="+generationCount+"\r\n");
		fw2.write("執行時間 T_total_time="+total_time+ "ms"+"\r\n");
		fw2.write("執行時間扣除寫檔時間  T_net="+T_net+ "ms"+"\r\n");
		fw2.write("\r\n");
		fw2.close();
		FileWriter fw3 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\Generation_Time_Log.txt",false);
		fw3.write(String.valueOf(str));
		fw3.close();
	}
	public static void DMSDL_PSO(int[] y, int[] x, double Fittest,int generationCount, long total_time,long T_net,String str) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path());
	    f2.mkdir();
    	FileWriter fw = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\X.txt",false);
    	for(int i=0;i<x.length;i++)
			fw.write(String.valueOf(x[i]+"\r\n"));
    	fw.close();
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\Y.txt",false);
    	for(int i=0;i<y.length;i++)
			fw1.write(String.valueOf(y[i]+"\r\n"));
    	fw1.close();
		FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\Result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			fw2.write(y[i]+" ");
		fw2.write("\r\n");
		fw2.write("X=");
		for(int i=0;i<x.length;i++)
			fw2.write(x[i]+" ");
		fw2.write("\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("Generation="+generationCount+"\r\n");
		fw2.write("執行時間 T_total_time="+total_time+ "ms"+"\r\n");
		fw2.write("執行時間扣除寫檔時間  T_net="+T_net+ "ms"+"\r\n");
		fw2.write("\r\n");
		fw2.close();
		FileWriter fw3 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\Generation_Time_Log.txt",false);
		fw3.write(String.valueOf(str));
		fw3.close();
	}

	public static void ALPSO2_NEW(int[] y, int[] x, double Fittest,int generationCount, long total_time,long T_net,String str) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path());
	    f2.mkdir();
    	FileWriter fw = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\X.txt",false);
    	for(int i=0;i<x.length;i++)
			fw.write(String.valueOf(x[i]+"\r\n"));
    	fw.close();
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\Y.txt",false);
    	for(int i=0;i<y.length;i++)
			fw1.write(String.valueOf(y[i]+"\r\n"));
    	fw1.close();
		FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\Result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			fw2.write(y[i]+" ");
		fw2.write("\r\n");
		fw2.write("X=");
		for(int i=0;i<x.length;i++)
			fw2.write(x[i]+" ");
		fw2.write("\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("Generation="+generationCount+"\r\n");
		fw2.write("執行時間 T_total_time="+total_time+ "ms"+"\r\n");
		fw2.write("執行時間扣除寫檔時間  T_net="+T_net+ "ms"+"\r\n");
		fw2.write("\r\n");
		fw2.close();
		FileWriter fw3 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\Generation_Time_Log.txt",false);
		fw3.write(String.valueOf(str));
		fw3.close();
	}
	public static void ALPSO2_NEW_PrematureConvegence1(int[] y, int[] x, double Fittest,int generationCount, long total_time,long T_net,String str) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path());
	    f2.mkdir();
    	FileWriter fw = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\X.txt",false);
    	for(int i=0;i<x.length;i++)
			fw.write(String.valueOf(x[i]+"\r\n"));
    	fw.close();
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\Y.txt",false);
    	for(int i=0;i<y.length;i++)
			fw1.write(String.valueOf(y[i]+"\r\n"));
    	fw1.close();
		FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\Result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			fw2.write(y[i]+" ");
		fw2.write("\r\n");
		fw2.write("X=");
		for(int i=0;i<x.length;i++)
			fw2.write(x[i]+" ");
		fw2.write("\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("Generation="+generationCount+"\r\n");
		fw2.write("執行時間 T_total_time="+total_time+ "ms"+"\r\n");
		fw2.write("執行時間扣除寫檔時間  T_net="+T_net+ "ms"+"\r\n");
		fw2.write("\r\n");
		fw2.close();
		FileWriter fw3 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\Generation_Time_Log.txt",false);
		fw3.write(String.valueOf(str));
		fw3.close();
	}
	
	public static void NLPSO2(int[] y, int[] x, double Fittest,int generationCount, long total_time,long T_net,String str) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path());
	    f2.mkdir();
    	FileWriter fw = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\X.txt",false);
    	for(int i=0;i<x.length;i++)
			fw.write(String.valueOf(x[i]+"\r\n"));
    	fw.close();
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\Y.txt",false);
    	for(int i=0;i<y.length;i++)
			fw1.write(String.valueOf(y[i]+"\r\n"));
    	fw1.close();
		FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\Result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			fw2.write(y[i]+" ");
		fw2.write("\r\n");
		fw2.write("X=");
		for(int i=0;i<x.length;i++)
			fw2.write(x[i]+" ");
		fw2.write("\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("Generation="+generationCount+"\r\n");
		fw2.write("執行時間 T_total_time="+total_time+ "ms"+"\r\n");
		fw2.write("執行時間扣除寫檔時間  T_net="+T_net+ "ms"+"\r\n");
		fw2.write("\r\n");
		fw2.close();
		FileWriter fw3 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\Generation_Time_Log.txt",false);
		fw3.write(String.valueOf(str));
		fw3.close();
	}
	public static void DynDE(int[] y, int[] x, double Fittest,int generationCount, long total_time,long T_net,String str) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path());
	    f2.mkdir();
    	FileWriter fw = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\X.txt",false);
    	for(int i=0;i<x.length;i++)
			fw.write(String.valueOf(x[i]+"\r\n"));
    	fw.close();
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\Y.txt",false);
    	for(int i=0;i<y.length;i++)
			fw1.write(String.valueOf(y[i]+"\r\n"));
    	fw1.close();
		FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\Result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			fw2.write(y[i]+" ");
		fw2.write("\r\n");
		fw2.write("X=");
		for(int i=0;i<x.length;i++)
			fw2.write(x[i]+" ");
		fw2.write("\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("Generation="+generationCount+"\r\n");
		fw2.write("執行時間 T_total_time="+total_time+ "ms"+"\r\n");
		fw2.write("執行時間扣除寫檔時間  T_net="+T_net+ "ms"+"\r\n");
		fw2.write("\r\n");
		fw2.close();
		FileWriter fw3 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\Generation_Time_Log.txt",false);
		fw3.write(String.valueOf(str));
		fw3.close();
	}
	public static void DynDE_POP(int[] y, int[] x, double Fittest,int generationCount, long total_time,long T_net,String str) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path());
	    f2.mkdir();
    	FileWriter fw = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\X.txt",false);
    	for(int i=0;i<x.length;i++)
			fw.write(String.valueOf(x[i]+"\r\n"));
    	fw.close();
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\Y.txt",false);
    	for(int i=0;i<y.length;i++)
			fw1.write(String.valueOf(y[i]+"\r\n"));
    	fw1.close();
		FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\Result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			fw2.write(y[i]+" ");
		fw2.write("\r\n");
		fw2.write("X=");
		for(int i=0;i<x.length;i++)
			fw2.write(x[i]+" ");
		fw2.write("\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("Generation="+generationCount+"\r\n");
		fw2.write("執行時間 T_total_time="+total_time+ "ms"+"\r\n");
		fw2.write("執行時間扣除寫檔時間  T_net="+T_net+ "ms"+"\r\n");
		fw2.write("\r\n");
		fw2.close();
		FileWriter fw3 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\Generation_Time_Log.txt",false);
		fw3.write(String.valueOf(str));
		fw3.close();
	}
	public static void CLPSO2(int[] y, int[] x, double Fittest,int generationCount, long total_time,long T_net,String str) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\CLPSO2");
	    f2.mkdir();
    	FileWriter fw = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\CLPSO2\\X.txt",false);
    	for(int i=0;i<x.length;i++)
			fw.write(String.valueOf(x[i]+"\r\n"));
    	fw.close();
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\CLPSO2\\Y.txt",false);
    	for(int i=0;i<y.length;i++)
			fw1.write(String.valueOf(y[i]+"\r\n"));
    	fw1.close();
		FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\CLPSO2\\Result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			fw2.write(y[i]+" ");
		fw2.write("\r\n");
		fw2.write("X=");
		for(int i=0;i<x.length;i++)
			fw2.write(x[i]+" ");
		fw2.write("\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("Generation="+generationCount+"\r\n");
		fw2.write("執行時間 T_total_time="+total_time+ "ms"+"\r\n");
		fw2.write("執行時間扣除寫檔時間  T_net="+T_net+ "ms"+"\r\n");
		fw2.write("\r\n");
		fw2.close();
		FileWriter fw3 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\CLPSO2\\Generation_Time_Log.txt",false);
		fw3.write(String.valueOf(str));
	fw3.close();
	}
	
	public static void CC_CLPSO2(int[] y, int[] x, double Fittest,int generationCount, long total_time,long T_net) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\CC-CLPSO2");
	    f2.mkdir();
    	FileWriter fw = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\CC-CLPSO2\\X.txt",false);
    	for(int i=0;i<x.length;i++)
			fw.write(String.valueOf(x[i]+"\r\n"));
    	fw.close();
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\CC-CLPSO2\\Y.txt",false);
    	for(int i=0;i<y.length;i++)
			fw1.write(String.valueOf(y[i]+"\r\n"));
    	fw1.close();
		FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\CC-CLPSO2\\Result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			fw2.write(y[i]+" ");
		fw2.write("\r\n");
		fw2.write("X=");
		for(int i=0;i<x.length;i++)
			fw2.write(x[i]+" ");
		fw2.write("\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("Generation="+generationCount+"\r\n");
		fw2.write("執行時間 T_total_time="+total_time+ "ms"+"\r\n");
		fw2.write("執行時間扣除寫檔時間  T_net="+T_net+ "ms"+"\r\n");
		fw2.write("\r\n");
		fw2.close();
	}
	
	public static void L_SHADE_CCPSO2(int[] y, int[] x, double Fittest,int generationCount, long total_time,long T_net) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\L_SHADE_CCPSO2");
	    f2.mkdir();
    	FileWriter fw = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\L_SHADE_CCPSO2\\X.txt",false);
    	for(int i=0;i<x.length;i++)
			fw.write(String.valueOf(x[i]+"\r\n"));
    	fw.close();
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\L_SHADE_CCPSO2\\Y.txt",false);
    	for(int i=0;i<y.length;i++)
			fw1.write(String.valueOf(y[i]+"\r\n"));
    	fw1.close();
		FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\L_SHADE_CCPSO2\\Result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			fw2.write(y[i]+" ");
		fw2.write("\r\n");
		fw2.write("X=");
		for(int i=0;i<x.length;i++)
			fw2.write(x[i]+" ");
		fw2.write("\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("Generation="+generationCount+"\r\n");
		fw2.write("執行時間 T_total_time="+total_time+ "ms"+"\r\n");
		fw2.write("執行時間扣除寫檔時間  T_net="+T_net+ "ms"+"\r\n");
		fw2.write("\r\n");
		fw2.close();
	}
	
	public static void PSO2_problem2(int[] y, int[] x,double[] rb,double[] rs, double Fittest,int generationCount, long total_time,long T_net,String str) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO2");
	    f2.mkdir();
    	FileWriter fw = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO2\\X.txt",false);
    	for(int i=0;i<x.length;i++)
			fw.write(String.valueOf(x[i]+"\r\n"));
    	fw.close();
    	FileWriter fw4 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO2\\rs.txt",false);
    	for(int i=0;i<rs.length;i++)
    		fw4.write(String.valueOf(rs[i]+"\r\n"));
    	fw4.close();
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO2\\Y.txt",false);
    	for(int i=0;i<y.length;i++)
			fw1.write(String.valueOf(y[i]+"\r\n"));
    	fw1.close();
    	FileWriter fw5 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO2\\rb.txt",false);
    	for(int i=0;i<rb.length;i++)
			fw5.write(String.valueOf(rb[i]+"\r\n"));
    	fw5.close();
		FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO2\\Result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			fw2.write(y[i]+" ");
		fw2.write("\r\n");
		fw2.write("X=");
		for(int i=0;i<x.length;i++)
			fw2.write(x[i]+" ");
		fw2.write("\r\n");
		fw2.write("rb=");
		for(int i=0;i<rb.length;i++)
			fw2.write(rb[i]+" ");
		fw2.write("\r\n");
		fw2.write("rs=");
		for(int i=0;i<rs.length;i++)
			fw2.write(rs[i]+" ");
		fw2.write("\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("Generation="+generationCount+"\r\n");
		fw2.write("執行時間 T_total_time="+total_time+ "ms"+"\r\n");
		fw2.write("執行時間扣除寫檔時間  T_net="+T_net+ "ms"+"\r\n");
		fw2.write("\r\n");
		fw2.close();
		FileWriter fw3 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO2\\Generation_Time_Log.txt",false);
		fw3.write(String.valueOf(str));
	fw3.close();
	}
	public static void PSO2_problem4(int[] y, int[] x,double r, double Fittest,int generationCount, long total_time,long T_net,String str) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO2");
	    f2.mkdir();
    	FileWriter fw = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO2\\X.txt",false);
    	for(int i=0;i<x.length;i++)
			fw.write(String.valueOf(x[i]+"\r\n"));
    	fw.close();
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO2\\Y.txt",false);
    	for(int i=0;i<y.length;i++)
			fw1.write(String.valueOf(y[i]+"\r\n"));
    	fw1.close();
    	FileWriter fw5 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO2\\r.txt",false);
		fw5.write(String.valueOf(r+"\r\n"));
    	fw5.close();
		FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO2\\Result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			fw2.write(y[i]+" ");
		fw2.write("\r\n");
		fw2.write("X=");
		for(int i=0;i<x.length;i++)
			fw2.write(x[i]+" ");
		fw2.write("\r\n");
		fw2.write("r=");
		fw2.write(r+" ");
		fw2.write("\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("Generation="+generationCount+"\r\n");
		fw2.write("執行時間 T_total_time="+total_time+ "ms"+"\r\n");
		fw2.write("執行時間扣除寫檔時間  T_net="+T_net+ "ms"+"\r\n");
		fw2.write("\r\n");
		fw2.close();
		FileWriter fw3 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO2\\Generation_Time_Log.txt",false);
		fw3.write(String.valueOf(str));
	fw3.close();
	}
	public static void DE_DA_Real_problem2(int[] y, int[] x,double[] rb,double[] rs, double Fittest,int generationCount, long total_time,long T_net,String str) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path());
	    f2.mkdir();
    	FileWriter fw = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\X.txt",false);
    	for(int i=0;i<x.length;i++)
			fw.write(String.valueOf(x[i]+"\r\n"));
    	fw.close();
    	FileWriter fw4 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\rs.txt",false);
    	for(int i=0;i<rs.length;i++)
			fw4.write(String.valueOf(rs[i]+"\r\n"));
    	fw4.close();
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\Y.txt",false);
    	for(int i=0;i<y.length;i++)
			fw1.write(String.valueOf(y[i]+"\r\n"));
    	fw1.close();
    	FileWriter fw5 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\rb.txt",false);
    	for(int i=0;i<rb.length;i++)
			fw5.write(String.valueOf(rb[i]+"\r\n"));
    	fw5.close();
		FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\Result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			fw2.write(y[i]+" ");
		fw2.write("\r\n");
		fw2.write("X=");
		for(int i=0;i<x.length;i++)
			fw2.write(x[i]+" ");
		fw2.write("\r\n");
		fw2.write("rb=");
		for(int i=0;i<rb.length;i++)
			fw2.write(rb[i]+" ");
		fw2.write("\r\n");
		fw2.write("rs=");
		for(int i=0;i<rs.length;i++)
			fw2.write(rs[i]+" ");
		fw2.write("\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("Generation="+generationCount+"\r\n");
		fw2.write("執行時間 T_total_time="+total_time+ "ms"+"\r\n");
		fw2.write("執行時間扣除寫檔時間  T_net="+T_net+ "ms"+"\r\n");
		fw2.write("\r\n");
		fw2.close();
		FileWriter fw3 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\Generation_Time_Log.txt",false);
		fw3.write(String.valueOf(str));
	fw3.close();
	}
	public static void DE_DA_Real_problem4(int[] y, int[] x,double r, double Fittest,int generationCount, long total_time,long T_net,String str) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path());
	    f2.mkdir();
    	FileWriter fw = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\X.txt",false);
    	for(int i=0;i<x.length;i++)
			fw.write(String.valueOf(x[i]+"\r\n"));
    	fw.close();
    	 
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\Y.txt",false);
    	for(int i=0;i<y.length;i++)
			fw1.write(String.valueOf(y[i]+"\r\n"));
    	fw1.close();
    	FileWriter fw5 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\r.txt",false);
			fw5.write(String.valueOf(r+"\r\n"));
    	fw5.close();
		FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\Result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			fw2.write(y[i]+" ");
		fw2.write("\r\n");
		fw2.write("X=");
		for(int i=0;i<x.length;i++)
			fw2.write(x[i]+" ");
		fw2.write("\r\n");
		fw2.write("r=");
			fw2.write(r+" ");
		fw2.write("\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("Generation="+generationCount+"\r\n");
		fw2.write("執行時間 T_total_time="+total_time+ "ms"+"\r\n");
		fw2.write("執行時間扣除寫檔時間  T_net="+T_net+ "ms"+"\r\n");
		fw2.write("\r\n");
		fw2.close();
		FileWriter fw3 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\Generation_Time_Log.txt",false);
		fw3.write(String.valueOf(str));
	fw3.close();
	}
	public static void CCPSO2_problem2(int[] y, int[] x, double[] rb,double[] rs,double Fittest,int generationCount, long total_time,long T_net) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\CCPSO2");
	    f2.mkdir();
    	FileWriter fw = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\CCPSO2\\X.txt",false);
    	for(int i=0;i<x.length;i++)
			fw.write(String.valueOf(x[i]+"\r\n"));
    	fw.close();
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\CCPSO2\\Y.txt",false);
    	for(int i=0;i<y.length;i++)
			fw1.write(String.valueOf(y[i]+"\r\n"));
    	fw1.close();
    	FileWriter fw3 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\CCPSO2\\rs.txt",false);
    	for(int i=0;i<rs.length;i++)
			fw3.write(String.valueOf(rs[i]+"\r\n"));
    	fw3.close();
    	FileWriter fw4 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\CCPSO2\\rb.txt",false);
    	for(int i=0;i<rb.length;i++)
			fw4.write(String.valueOf(rb[i]+"\r\n"));
    	fw4.close();
		FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\CCPSO2\\Result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			fw2.write(y[i]+" ");
		fw2.write("\r\n");
		fw2.write("X=");
		for(int i=0;i<x.length;i++)
			fw2.write(x[i]+" ");
		fw2.write("\r\n");
		fw2.write("rb=");
		for(int i=0;i<rb.length;i++)
			fw2.write(rb[i]+" ");
		fw2.write("\r\n");
		fw2.write("rs=");
		for(int i=0;i<rs.length;i++)
			fw2.write(rs[i]+" ");
		fw2.write("\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("Generation="+generationCount+"\r\n");
		fw2.write("執行時間 T_total_time="+total_time+ "ms"+"\r\n");
		fw2.write("執行時間扣除寫檔時間  T_net="+T_net+ "ms"+"\r\n");
		fw2.write("\r\n");
		fw2.close();
	}
	public static void CCPSO2_problem4(int[] y, int[] x, double r,double Fittest,int generationCount, long total_time,long T_net) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\CCPSO2");
	    f2.mkdir();
    	FileWriter fw = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\CCPSO2\\X.txt",false);
    	for(int i=0;i<x.length;i++)
			fw.write(String.valueOf(x[i]+"\r\n"));
    	fw.close();
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\CCPSO2\\Y.txt",false);
    	for(int i=0;i<y.length;i++)
			fw1.write(String.valueOf(y[i]+"\r\n"));
    	fw1.close();
    	FileWriter fw3 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\CCPSO2\\r.txt",false);
			fw3.write(String.valueOf(r+"\r\n"));
    	fw3.close();
    	
		FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\CCPSO2\\Result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			fw2.write(y[i]+" ");
		fw2.write("\r\n");
		fw2.write("X=");
		for(int i=0;i<x.length;i++)
			fw2.write(x[i]+" ");
		fw2.write("\r\n");
		fw2.write("r=");
			fw2.write(r+" ");
		fw2.write("\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("Generation="+generationCount+"\r\n");
		fw2.write("執行時間 T_total_time="+total_time+ "ms"+"\r\n");
		fw2.write("執行時間扣除寫檔時間  T_net="+T_net+ "ms"+"\r\n");
		fw2.write("\r\n");
		fw2.close();
	}
	public static void L_SHADE_CCPSO2_problem2(int[] y, int[] x, double[] rb,double[] rs,double Fittest,int generationCount, long total_time,long T_net) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\L_SHADE_CCPSO2");
	    f2.mkdir();
    	FileWriter fw = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\L_SHADE_CCPSO2\\X.txt",false);
    	for(int i=0;i<x.length;i++)
			fw.write(String.valueOf(x[i]+"\r\n"));
    	fw.close();
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\L_SHADE_CCPSO2\\Y.txt",false);
    	for(int i=0;i<y.length;i++)
			fw1.write(String.valueOf(y[i]+"\r\n"));
    	fw1.close();
    	FileWriter fw3 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\L_SHADE_CCPSO2\\rs.txt",false);
    	for(int i=0;i<rs.length;i++)
			fw3.write(String.valueOf(rs[i]+"\r\n"));
    	fw3.close();
    	FileWriter fw4 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\L_SHADE_CCPSO2\\rb.txt",false);
    	for(int i=0;i<rb.length;i++)
			fw4.write(String.valueOf(rb[i]+"\r\n"));
    	fw4.close();
		FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\L_SHADE_CCPSO2\\Result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			fw2.write(y[i]+" ");
		fw2.write("\r\n");
		fw2.write("X=");
		for(int i=0;i<x.length;i++)
			fw2.write(x[i]+" ");
		fw2.write("\r\n");
		fw2.write("rb=");
		for(int i=0;i<rb.length;i++)
			fw2.write(rb[i]+" ");
		fw2.write("\r\n");
		fw2.write("rs=");
		for(int i=0;i<rs.length;i++)
			fw2.write(rs[i]+" ");
		fw2.write("\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("Generation="+generationCount+"\r\n");
		fw2.write("執行時間 T_total_time="+total_time+ "ms"+"\r\n");
		fw2.write("執行時間扣除寫檔時間  T_net="+T_net+ "ms"+"\r\n");
		fw2.write("\r\n");
		fw2.close();
	}
	public static void L_SHADE_CCPSO2_problem4(int[] y, int[] x, double r,double Fittest,int generationCount, long total_time,long T_net) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\L_SHADE_CCPSO2");
	    f2.mkdir();
    	FileWriter fw = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\L_SHADE_CCPSO2\\X.txt",false);
    	for(int i=0;i<x.length;i++)
			fw.write(String.valueOf(x[i]+"\r\n"));
    	fw.close();
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\L_SHADE_CCPSO2\\Y.txt",false);
    	for(int i=0;i<y.length;i++)
			fw1.write(String.valueOf(y[i]+"\r\n"));
    	fw1.close();
    	FileWriter fw3 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\L_SHADE_CCPSO2\\r.txt",false);
			fw3.write(String.valueOf(r+"\r\n"));
    	fw3.close();
    	
		FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\L_SHADE_CCPSO2\\Result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			fw2.write(y[i]+" ");
		fw2.write("\r\n");
		fw2.write("X=");
		for(int i=0;i<x.length;i++)
			fw2.write(x[i]+" ");
		fw2.write("\r\n");
		fw2.write("r=");
			fw2.write(r+" ");
		fw2.write("\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("Generation="+generationCount+"\r\n");
		fw2.write("執行時間 T_total_time="+total_time+ "ms"+"\r\n");
		fw2.write("執行時間扣除寫檔時間  T_net="+T_net+ "ms"+"\r\n");
		fw2.write("\r\n");
		fw2.close();
	}
	public static void NSDE_DA_problem2(int[] y, int[] x,double[] rb,double[] rs, double Fittest,int generationCount, long total_time,long T_net,String str) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path());
	    f2.mkdir();
    	FileWriter fw = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\X.txt",false);
    	for(int i=0;i<x.length;i++)
			fw.write(String.valueOf(x[i]+"\r\n"));
    	fw.close();
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\Y.txt",false);
    	for(int i=0;i<y.length;i++)
			fw1.write(String.valueOf(y[i]+"\r\n"));
    	fw1.close();
    	FileWriter fw4 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\rs.txt",false);
    	for(int i=0;i<rs.length;i++)
			fw4.write(String.valueOf(rs[i]+"\r\n"));
    	fw4.close();
    	FileWriter fw5 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\rb.txt",false);
    	for(int i=0;i<rb.length;i++)
			fw5.write(String.valueOf(rb[i]+"\r\n"));
    	fw5.close();
		FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\Result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			fw2.write(y[i]+" ");
		fw2.write("\r\n");
		fw2.write("X=");
		for(int i=0;i<x.length;i++)
			fw2.write(x[i]+" ");
		fw2.write("\r\n");
		fw2.write("rb=");
		for(int i=0;i<rb.length;i++)
			fw2.write(rb[i]+" ");
		fw2.write("\r\n");
		fw2.write("rs=");
		for(int i=0;i<rs.length;i++)
			fw2.write(rs[i]+" ");
		fw2.write("\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("Generation="+generationCount+"\r\n");
		fw2.write("執行時間 T_total_time="+total_time+ "ms"+"\r\n");
		fw2.write("執行時間扣除寫檔時間  T_net="+T_net+ "ms"+"\r\n");
		fw2.write("\r\n");
		fw2.close();
		FileWriter fw3 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\Generation_Time_Log.txt",false);
		fw3.write(String.valueOf(str));
	fw3.close();
	}
	public static void NSDE_DA_problem4(int[] y, int[] x,double r, double Fittest,int generationCount, long total_time,long T_net,String str) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path());
	    f2.mkdir();
    	FileWriter fw = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\X.txt",false);
    	for(int i=0;i<x.length;i++)
			fw.write(String.valueOf(x[i]+"\r\n"));
    	fw.close();
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\Y.txt",false);
    	for(int i=0;i<y.length;i++)
			fw1.write(String.valueOf(y[i]+"\r\n"));
    	fw1.close();
    	FileWriter fw4 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\r.txt",false);
			fw4.write(String.valueOf(r+"\r\n"));
    	fw4.close();
   		FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\Result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			fw2.write(y[i]+" ");
		fw2.write("\r\n");
		fw2.write("X=");
		for(int i=0;i<x.length;i++)
			fw2.write(x[i]+" ");
		fw2.write("\r\n");
		fw2.write("r=");
		fw2.write(r+" ");
		fw2.write("\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("Generation="+generationCount+"\r\n");
		fw2.write("執行時間 T_total_time="+total_time+ "ms"+"\r\n");
		fw2.write("執行時間扣除寫檔時間  T_net="+T_net+ "ms"+"\r\n");
		fw2.write("\r\n");
		fw2.close();
		FileWriter fw3 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\Generation_Time_Log.txt",false);
		fw3.write(String.valueOf(str));
	fw3.close();
	}
	//-----------------------------以下為編寫 Batch 的資料-----------------------
	public static void PSO1_Batch(int n,int[] y, int[] x, double Fittest,int generationCount, long total_time,long T_net) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO1_Batch");
	    f2.mkdir();
	    File f3 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO1_Batch\\PSO1_Batch"+n);
	    f3.mkdir();
    	FileWriter fw = new FileWriter( "output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO1_Batch\\PSO1_Batch"+n+"\\X.txt",false);
    	for(int i=0;i<x.length;i++)
			fw.write(String.valueOf(x[i]+"\r\n"));
    	fw.close();
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO1_Batch\\PSO1_Batch"+n+"\\Y.txt",false);
    	for(int i=0;i<y.length;i++)
			fw1.write(String.valueOf(y[i]+"\r\n"));
    	fw1.close();
		FileWriter fw2 = new FileWriter( "output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO1_Batch\\PSO1_Batch"+n+"\\result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			fw2.write(y[i]+" ");
		fw2.write("\r\n");
		fw2.write("X=");
		for(int i=0;i<x.length;i++)
			fw2.write(x[i]+" ");
		fw2.write("\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("Generation="+generationCount+"\r\n");
		fw2.write("執行時間 T_total_time="+total_time+ "ms"+"\r\n");
		fw2.write("執行時間扣除寫檔時間  T_net="+T_net+ "ms"+"\r\n");
		fw2.write("\r\n");
		fw2.close();
	}
	public static void PSO1_Tanh_Batch(int n,int[] y, int[] x, double Fittest,int generationCount, long total_time,long T_net) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO1_Tanh_Batch");
	    f2.mkdir();
	    File f3 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO1_Tanh_Batch\\PSO1_Tanh_Batch"+n);
	    f3.mkdir();
    	FileWriter fw = new FileWriter( "output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO1_Tanh_Batch\\PSO1_Tanh_Batch"+n+"\\X.txt",false);
    	for(int i=0;i<x.length;i++)
			fw.write(String.valueOf(x[i]+"\r\n"));
    	fw.close();
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO1_Tanh_Batch\\PSO1_Tanh_Batch"+n+"\\Y.txt",false);
    	for(int i=0;i<y.length;i++)
			fw1.write(String.valueOf(y[i]+"\r\n"));
    	fw1.close();
		FileWriter fw2 = new FileWriter( "output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO1_Tanh_Batch\\PSO1_Tanh_Batch"+n+"\\result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			fw2.write(y[i]+" ");
		fw2.write("\r\n");
		fw2.write("X=");
		for(int i=0;i<x.length;i++)
			fw2.write(x[i]+" ");
		fw2.write("\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("Generation="+generationCount+"\r\n");
		fw2.write("執行時間 T_total_time="+total_time+ "ms"+"\r\n");
		fw2.write("執行時間扣除寫檔時間  T_net="+T_net+ "ms"+"\r\n");
		fw2.write("\r\n");
		fw2.close();
	}
	public static void PSO1_P_Batch(int n,int[] y, int[] x, double Fittest,int generationCount, long total_time,long T_net) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO1_P_Batch");
	    f2.mkdir();
	    File f3 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO1_P_Batch\\PSO1_P_Batch"+n);
	    f3.mkdir();
    	FileWriter fw = new FileWriter( "output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO1_P_Batch\\PSO1_P_Batch"+n+"\\X.txt",false);
    	for(int i=0;i<x.length;i++)
			fw.write(String.valueOf(x[i]+"\r\n"));
    	fw.close();
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO1_P_Batch\\PSO1_P_Batch"+n+"\\Y.txt",false);
    	for(int i=0;i<y.length;i++)
			fw1.write(String.valueOf(y[i]+"\r\n"));
    	fw1.close();
		FileWriter fw2 = new FileWriter( "output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO1_P_Batch\\PSO1_P_Batch"+n+"\\result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			fw2.write(y[i]+" ");
		fw2.write("\r\n");
		fw2.write("X=");
		for(int i=0;i<x.length;i++)
			fw2.write(x[i]+" ");
		fw2.write("\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("Generation="+generationCount+"\r\n");
		fw2.write("執行時間 T_total_time="+total_time+ "ms"+"\r\n");
		fw2.write("執行時間扣除寫檔時間  T_net="+T_net+ "ms"+"\r\n");
		fw2.write("\r\n");
		fw2.close();
	}
	public static void PSO2_Batch(int n,int[] y, int[] x, double Fittest,int generationCount, long total_time,long T_net) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO2_Batch");
	    f2.mkdir();
	    File f3 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO2_Batch\\PSO2_Batch"+n);
	    f3.mkdir();
    	FileWriter fw = new FileWriter( "output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO2_Batch\\PSO2_Batch"+n+"\\X.txt",false);
    	for(int i=0;i<x.length;i++)
			fw.write(String.valueOf(x[i]+"\r\n"));
    	fw.close();
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO2_Batch\\PSO2_Batch"+n+"\\Y.txt",false);
    	for(int i=0;i<y.length;i++)
			fw1.write(String.valueOf(y[i]+"\r\n"));
    	fw1.close();
		FileWriter fw2 = new FileWriter( "output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO2_Batch\\PSO2_Batch"+n+"\\result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			fw2.write(y[i]+" ");
		fw2.write("\r\n");
		fw2.write("X=");
		for(int i=0;i<x.length;i++)
			fw2.write(x[i]+" ");
		fw2.write("\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("Generation="+generationCount+"\r\n");
		fw2.write("執行時間 T_total_time="+total_time+ "ms"+"\r\n");
		fw2.write("執行時間扣除寫檔時間  T_net="+T_net+ "ms"+"\r\n");
		fw2.write("\r\n");
		fw2.close();
	}
	public static void PSO2_Tanh_Batch(int n,int[] y, int[] x, double Fittest,int generationCount, long total_time,long T_net) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO2_Tanh_Batch");
	    f2.mkdir();
	    File f3 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO2_Tanh_Batch\\PSO2_Tanh_Batch"+n);
	    f3.mkdir();
    	FileWriter fw = new FileWriter( "output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO2_Tanh_Batch\\PSO2_Tanh_Batch"+n+"\\X.txt",false);
    	for(int i=0;i<x.length;i++)
			fw.write(String.valueOf(x[i]+"\r\n"));
    	fw.close();
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO2_Tanh_Batch\\PSO2_Tanh_Batch"+n+"\\Y.txt",false);
    	for(int i=0;i<y.length;i++)
			fw1.write(String.valueOf(y[i]+"\r\n"));
    	fw1.close();
		FileWriter fw2 = new FileWriter( "output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO2_Tanh_Batch\\PSO2_Tanh_Batch"+n+"\\result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			fw2.write(y[i]+" ");
		fw2.write("\r\n");
		fw2.write("X=");
		for(int i=0;i<x.length;i++)
			fw2.write(x[i]+" ");
		fw2.write("\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("Generation="+generationCount+"\r\n");
		fw2.write("執行時間 T_total_time="+total_time+ "ms"+"\r\n");
		fw2.write("執行時間扣除寫檔時間  T_net="+T_net+ "ms"+"\r\n");
		fw2.write("\r\n");
		fw2.close();
	}
	public static void PSO2_P_Batch(int n,int[] y, int[] x, double Fittest,int generationCount, long total_time,long T_net) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO2_P_Batch");
	    f2.mkdir();
	    File f3 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO2_P_Batch\\PSO2_P_Batch"+n);
	    f3.mkdir();
    	FileWriter fw = new FileWriter( "output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO2_P_Batch\\PSO2_P_Batch"+n+"\\X.txt",false);
    	for(int i=0;i<x.length;i++)
			fw.write(String.valueOf(x[i]+"\r\n"));
    	fw.close();
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO2_P_Batch\\PSO2_P_Batch"+n+"\\Y.txt",false);
    	for(int i=0;i<y.length;i++)
			fw1.write(String.valueOf(y[i]+"\r\n"));
    	fw1.close();
		FileWriter fw2 = new FileWriter( "output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO2_P_Batch\\PSO2_P_Batch"+n+"\\result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			fw2.write(y[i]+" ");
		fw2.write("\r\n");
		fw2.write("X=");
		for(int i=0;i<x.length;i++)
			fw2.write(x[i]+" ");
		fw2.write("\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("Generation="+generationCount+"\r\n");
		fw2.write("執行時間 T_total_time="+total_time+ "ms"+"\r\n");
		fw2.write("執行時間扣除寫檔時間  T_net="+T_net+ "ms"+"\r\n");
		fw2.write("\r\n");
		fw2.close();
	}
	public static void PSO3_Batch(int n,double[] y, double[] x, double Fittest,int generationCount,  long total_time,long T_net) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO3_Batch");
	    f2.mkdir();
	    File f3 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO3_Batch\\PSO3_Batch"+n);
	    f3.mkdir();
    	FileWriter fw = new FileWriter( "output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO3_Batch\\PSO3_Batch"+n+"\\X.txt",false);
    	for(int i=0;i<x.length;i++)
			fw.write(String.valueOf(x[i]+"\r\n"));
    	fw.close();
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO3_Batch\\PSO3_Batch"+n+"\\Y.txt",false);
    	for(int i=0;i<y.length;i++)
			fw1.write(String.valueOf(y[i]+"\r\n"));
    	fw1.close();
		FileWriter fw2 = new FileWriter( "output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO3_Batch\\PSO3_Batch"+n+"\\result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			fw2.write(y[i]+" ");
		fw2.write("\r\n");
		fw2.write("X=");
		for(int i=0;i<x.length;i++)
			fw2.write(x[i]+" ");
		fw2.write("\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("Generation="+generationCount+"\r\n");
		fw2.write("執行時間 T_total_time="+total_time+ "ms"+"\r\n");
		fw2.write("執行時間扣除寫檔時間  T_net="+T_net+ "ms"+"\r\n");
		fw2.write("\r\n");
		fw2.close();
	}
	public static void PSO4_Batch(int n,double[] y, double[] x, double Fittest,int generationCount, long total_time,long T_net) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO4_Batch");
	    f2.mkdir();
	    File f3 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO4_Batch\\PSO4_Batch"+n);
	    f3.mkdir();
    	FileWriter fw = new FileWriter( "output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO4_Batch\\PSO4_Batch"+n+"\\X.txt",false);
    	for(int i=0;i<x.length;i++)
			fw.write(String.valueOf(x[i]+"\r\n"));
    	fw.close();
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO4_Batch\\PSO4_Batch"+n+"\\Y.txt",false);
    	for(int i=0;i<y.length;i++)
			fw1.write(String.valueOf(y[i]+"\r\n"));
    	fw1.close();
		FileWriter fw2 = new FileWriter( "output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO4_Batch\\PSO4_Batch"+n+"\\result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			fw2.write(y[i]+" ");
		fw2.write("\r\n");
		fw2.write("X=");
		for(int i=0;i<x.length;i++)
			fw2.write(x[i]+" ");
		fw2.write("\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("Generation="+generationCount+"\r\n");
		fw2.write("執行時間 T_total_time="+total_time+ "ms"+"\r\n");
		fw2.write("執行時間扣除寫檔時間  T_net="+T_net+ "ms"+"\r\n");
		fw2.write("\r\n");
		fw2.close();
	}
	public static void APSO1_Batch(int n,int[] y, int[] x, double Fittest,int generationCount,  long total_time,long T_net) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\APSO1_Batch");
	    f2.mkdir();
	    File f3 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\APSO1_Batch\\APSO1_Batch"+n);
	    f3.mkdir();
    	FileWriter fw = new FileWriter( "output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\APSO1_Batch\\APSO1_Batch"+n+"\\X.txt",false);
    	for(int i=0;i<x.length;i++)
			fw.write(String.valueOf(x[i]+"\r\n"));
    	fw.close();
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\APSO1_Batch\\APSO1_Batch"+n+"\\Y.txt",false);
    	for(int i=0;i<y.length;i++)
			fw1.write(String.valueOf(y[i]+"\r\n"));
    	fw1.close();
		FileWriter fw2 = new FileWriter( "output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\APSO1_Batch\\APSO1_Batch"+n+"\\result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			fw2.write(y[i]+" ");
		fw2.write("\r\n");
		fw2.write("X=");
		for(int i=0;i<x.length;i++)
			fw2.write(x[i]+" ");
		fw2.write("\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("Generation="+generationCount+"\r\n");
		fw2.write("執行時間 T_total_time="+total_time+ "ms"+"\r\n");
		fw2.write("執行時間扣除寫檔時間  T_net="+T_net+ "ms"+"\r\n");
		fw2.write("\r\n");
		fw2.close();
	}
	
	public static void APSO2_Batch(int n,int[] y, int[] x, double Fittest,int generationCount,  long total_time,long T_net) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\APSO2_Batch");
	    f2.mkdir();
	    File f3 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\APSO2_Batch\\APSO2_Batch"+n);
	    f3.mkdir();
    	FileWriter fw = new FileWriter( "output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\APSO2_Batch\\APSO2_Batch"+n+"\\X.txt",false);
    	for(int i=0;i<x.length;i++)
			fw.write(String.valueOf(x[i]+"\r\n"));
    	fw.close();
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\APSO2_Batch\\APSO2_Batch"+n+"\\Y.txt",false);
    	for(int i=0;i<y.length;i++)
			fw1.write(String.valueOf(y[i]+"\r\n"));
    	fw1.close();
		FileWriter fw2 = new FileWriter( "output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\APSO2_Batch\\APSO2_Batch"+n+"\\result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			fw2.write(y[i]+" ");
		fw2.write("\r\n");
		fw2.write("X=");
		for(int i=0;i<x.length;i++)
			fw2.write(x[i]+" ");
		fw2.write("\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("Generation="+generationCount+"\r\n");
		fw2.write("執行時間 T_total_time="+total_time+ "ms"+"\r\n");
		fw2.write("執行時間扣除寫檔時間  T_net="+T_net+ "ms"+"\r\n");
		fw2.write("\r\n");
		fw2.close();
	}
	public static void ALPSO_Batch(int n,int[][] y, int[][] x, double Fittest,int generationCount,  long total_time,long T_net) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\ALPSO_Batch");
	    f2.mkdir();
	    File f3 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\ALPSO_Batch\\ALPSO_Batch"+n);
	    f3.mkdir();
    	FileWriter fw = new FileWriter( "output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\ALPSO_Batch\\ALPSO_Batch"+n+"\\X.txt",false);
    	for(int i=0;i<x.length;i++)
    		for(int j=0;j<x[i].length;j++)
			fw.write(String.valueOf(x[i][j]+"\r\n"));
    	fw.close();
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\ALPSO_Batch\\ALPSO_Batch"+n+"\\Y.txt",false);
    	for(int i=0;i<y.length;i++)
    		for(int j=0;j<y[i].length;j++)
			fw1.write(String.valueOf(y[i][j]+"\r\n"));
    	fw1.close();
		FileWriter fw2 = new FileWriter( "output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\ALPSO_Batch\\ALPSO_Batch"+n+"\\result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			for(int j=0;j<y[i].length;j++)
			fw2.write(y[i][j]+" ");
		fw2.write("\r\n");
		fw2.write("X=");
		for(int i=0;i<x.length;i++)
			for(int j=0;j<x[i].length;j++)
			fw2.write(x[i][j]+" ");
		fw2.write("\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("Generation="+generationCount+"\r\n");
		fw2.write("執行時間 T_total_time="+total_time+ "ms"+"\r\n");
		fw2.write("執行時間扣除寫檔時間  T_net="+T_net+ "ms"+"\r\n");
		fw2.write("\r\n");
		fw2.close();
	}
	public static void ALPSO_Tanh_Batch(int n,int[][] y, int[][] x, double Fittest,int generationCount,  long total_time,long T_net) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\ALPSO_Tanh_Batch");
	    f2.mkdir();
	    File f3 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\ALPSO_Tanh_Batch\\ALPSO_Tanh_Batch"+n);
	    f3.mkdir();
    	FileWriter fw = new FileWriter( "output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\ALPSO_Tanh_Batch\\ALPSO_Tanh_Batch"+n+"\\X.txt",false);
    	for(int i=0;i<x.length;i++)
    		for(int j=0;j<x[i].length;j++)
			fw.write(String.valueOf(x[i][j]+"\r\n"));
    	fw.close();
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\ALPSO_Tanh_Batch\\ALPSO_Tanh_Batch"+n+"\\Y.txt",false);
    	for(int i=0;i<y.length;i++)
    		for(int j=0;j<y[i].length;j++)
			fw1.write(String.valueOf(y[i][j]+"\r\n"));
    	fw1.close();
		FileWriter fw2 = new FileWriter( "output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\ALPSO_Tanh_Batch\\ALPSO_Tanh_Batch"+n+"\\result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			for(int j=0;j<y[i].length;j++)
			fw2.write(y[i][j]+" ");
		fw2.write("\r\n");
		fw2.write("X=");
		for(int i=0;i<x.length;i++)
			for(int j=0;j<x[i].length;j++)
			fw2.write(x[i][j]+" ");
		fw2.write("\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("Generation="+generationCount+"\r\n");
		fw2.write("執行時間 T_total_time="+total_time+ "ms"+"\r\n");
		fw2.write("執行時間扣除寫檔時間  T_net="+T_net+ "ms"+"\r\n");
		fw2.write("\r\n");
		fw2.close();
	}
	public static void ALPSO_P_Batch(int n,int[][] y, int[][] x, double Fittest,int generationCount,  long total_time,long T_net) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\ALPSO_P_Batch");
	    f2.mkdir();
	    File f3 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\ALPSO_P_Batch\\ALPSO_P_Batch"+n);
	    f3.mkdir();
    	FileWriter fw = new FileWriter( "output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\ALPSO_P_Batch\\ALPSO_P_Batch"+n+"\\X.txt",false);
    	for(int i=0;i<x.length;i++)
    		for(int j=0;j<x[i].length;j++)
			fw.write(String.valueOf(x[i][j]+"\r\n"));
    	fw.close();
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\ALPSO_P_Batch\\ALPSO_P_Batch"+n+"\\Y.txt",false);
    	for(int i=0;i<y.length;i++)
    		for(int j=0;j<y[i].length;j++)
			fw1.write(String.valueOf(y[i][j]+"\r\n"));
    	fw1.close();
		FileWriter fw2 = new FileWriter( "output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\ALPSO_P_Batch\\ALPSO_P_Batch"+n+"\\result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			for(int j=0;j<y[i].length;j++)
			fw2.write(y[i][j]+" ");
		fw2.write("\r\n");
		fw2.write("X=");
		for(int i=0;i<x.length;i++)
			for(int j=0;j<x[i].length;j++)
			fw2.write(x[i][j]+" ");
		fw2.write("\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("Generation="+generationCount+"\r\n");
		fw2.write("執行時間 T_total_time="+total_time+ "ms"+"\r\n");
		fw2.write("執行時間扣除寫檔時間  T_net="+T_net+ "ms"+"\r\n");
		fw2.write("\r\n");
		fw2.close();
	}
	public static void CCPSO2_Batch(int n,int[] y, int[] x, double Fittest,int generationCount,  long total_time,long T_net) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\CCPSO2_Batch");
	    f2.mkdir();
	    File f3 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\CCPSO2_Batch\\CCPSO2_Batch"+n);
	    f3.mkdir();
    	FileWriter fw = new FileWriter( "output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\CCPSO2_Batch\\CCPSO2_Batch"+n+"\\X.txt",false);
    	for(int i=0;i<x.length;i++)
			fw.write(String.valueOf(x[i]+"\r\n"));
    	fw.close();
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\CCPSO2_Batch\\CCPSO2_Batch"+n+"\\Y.txt",false);
    	for(int i=0;i<y.length;i++)
			fw1.write(String.valueOf(y[i]+"\r\n"));
    	fw1.close();
		FileWriter fw2 = new FileWriter( "output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\CCPSO2_Batch\\CCPSO2_Batch"+n+"\\result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			fw2.write(y[i]+" ");
		fw2.write("\r\n");
		fw2.write("X=");
		for(int i=0;i<x.length;i++)
			fw2.write(x[i]+" ");
		fw2.write("\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("Generation="+generationCount+"\r\n");
		fw2.write("執行時間 T_total_time="+total_time+ "ms"+"\r\n");
		fw2.write("執行時間扣除寫檔時間  T_net="+T_net+ "ms"+"\r\n");
		fw2.write("\r\n");
		fw2.close();
	}
	public static void CCPSO2_P_Batch(int n,int[] y, int[] x, double Fittest,int generationCount,  long total_time,long T_net) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\CCPSO2_P_Batch");
	    f2.mkdir();
	    File f3 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\CCPSO2_P_Batch\\CCPSO2_P_Batch"+n);
	    f3.mkdir();
    	FileWriter fw = new FileWriter( "output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\CCPSO2_P_Batch\\CCPSO2_P_Batch"+n+"\\X.txt",false);
    	for(int i=0;i<x.length;i++)
			fw.write(String.valueOf(x[i]+"\r\n"));
    	fw.close();
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\CCPSO2_P_Batch\\CCPSO2_P_Batch"+n+"\\Y.txt",false);
    	for(int i=0;i<y.length;i++)
			fw1.write(String.valueOf(y[i]+"\r\n"));
    	fw1.close();
		FileWriter fw2 = new FileWriter( "output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\CCPSO2_P_Batch\\CCPSO2_P_Batch"+n+"\\result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			fw2.write(y[i]+" ");
		fw2.write("\r\n");
		fw2.write("X=");
		for(int i=0;i<x.length;i++)
			fw2.write(x[i]+" ");
		fw2.write("\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("Generation="+generationCount+"\r\n");
		fw2.write("執行時間 T_total_time="+total_time+ "ms"+"\r\n");
		fw2.write("執行時間扣除寫檔時間  T_net="+T_net+ "ms"+"\r\n");
		fw2.write("\r\n");
		fw2.close();
	}
	public static void LRPSO_Batch(int n,int[][] y, int[][] x, double Fittest,int generationCount,  long total_time,long T_net) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LRPSO_Batch");
	    f2.mkdir();
	    File f3 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LRPSO_Batch\\LRPSO_Batch"+n);
	    f3.mkdir();
    	FileWriter fw = new FileWriter( "output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LRPSO_Batch\\LRPSO_Batch"+n+"\\X.txt",false);
    	for(int i=0;i<x.length;i++)
    		for(int j=0;j<x[i].length;j++)
			fw.write(String.valueOf(x[i][j]+"\r\n"));
    	fw.close();
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LRPSO_Batch\\LRPSO_Batch"+n+"\\Y.txt",false);
    	for(int i=0;i<y.length;i++)
    		for(int j=0;j<y[i].length;j++)
			fw1.write(String.valueOf(y[i][j]+"\r\n"));
    	fw1.close();
		FileWriter fw2 = new FileWriter( "output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LRPSO_Batch\\LRPSO_Batch"+n+"\\result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			for(int j=0;j<y[i].length;j++)
			fw2.write(y[i][j]+" ");
		fw2.write("\r\n");
		fw2.write("X=");
		for(int i=0;i<x.length;i++)
			for(int j=0;j<x[i].length;j++)
			fw2.write(x[i][j]+" ");
		fw2.write("\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("Generation="+generationCount+"\r\n");
		fw2.write("執行時間 T_total_time="+total_time+ "ms"+"\r\n");
		fw2.write("執行時間扣除寫檔時間  T_net="+T_net+ "ms"+"\r\n");
		fw2.write("\r\n");
		fw2.close();
	}
	public static void LRPSO_Tanh_Batch(int n,int[][] y, int[][] x, double Fittest,int generationCount,  long total_time,long T_net) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LRPSO_Tanh_Batch");
	    f2.mkdir();
	    File f3 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LRPSO_Tanh_Batch\\LRPSO_Tanh_Batch"+n);
	    f3.mkdir();
    	FileWriter fw = new FileWriter( "output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LRPSO_Tanh_Batch\\LRPSO_Tanh_Batch"+n+"\\X.txt",false);
    	for(int i=0;i<x.length;i++)
    		for(int j=0;j<x[i].length;j++)
			fw.write(String.valueOf(x[i][j]+"\r\n"));
    	fw.close();
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LRPSO_Tanh_Batch\\LRPSO_Tanh_Batch"+n+"\\Y.txt",false);
    	for(int i=0;i<y.length;i++)
    		for(int j=0;j<y[i].length;j++)
			fw1.write(String.valueOf(y[i][j]+"\r\n"));
    	fw1.close();
		FileWriter fw2 = new FileWriter( "output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LRPSO_Tanh_Batch\\LRPSO_Tanh_Batch"+n+"\\result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			for(int j=0;j<y[i].length;j++)
			fw2.write(y[i][j]+" ");
		fw2.write("\r\n");
		fw2.write("X=");
		for(int i=0;i<x.length;i++)
			for(int j=0;j<x[i].length;j++)
			fw2.write(x[i][j]+" ");
		fw2.write("\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("Generation="+generationCount+"\r\n");
		fw2.write("執行時間 T_total_time="+total_time+ "ms"+"\r\n");
		fw2.write("執行時間扣除寫檔時間  T_net="+T_net+ "ms"+"\r\n");
		fw2.write("\r\n");
		fw2.close();
	}
	public static void LRPSO_P_Batch(int n,int[][] y, int[][] x, double Fittest,int generationCount,  long total_time,long T_net) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LRPSO_P_Batch");
	    f2.mkdir();
	    File f3 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LRPSO_P_Batch\\LRPSO_P_Batch"+n);
	    f3.mkdir();
    	FileWriter fw = new FileWriter( "output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LRPSO_P_Batch\\LRPSO_P_Batch"+n+"\\X.txt",false);
    	for(int i=0;i<x.length;i++)
    		for(int j=0;j<x[i].length;j++)
			fw.write(String.valueOf(x[i][j]+"\r\n"));
    	fw.close();
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LRPSO_P_Batch\\LRPSO_P_Batch"+n+"\\Y.txt",false);
    	for(int i=0;i<y.length;i++)
    		for(int j=0;j<y[i].length;j++)
			fw1.write(String.valueOf(y[i][j]+"\r\n"));
    	fw1.close();
		FileWriter fw2 = new FileWriter( "output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LRPSO_P_Batch\\LRPSO_P_Batch"+n+"\\result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			for(int j=0;j<y[i].length;j++)
			fw2.write(y[i][j]+" ");
		fw2.write("\r\n");
		fw2.write("X=");
		for(int i=0;i<x.length;i++)
			for(int j=0;j<x[i].length;j++)
			fw2.write(x[i][j]+" ");
		fw2.write("\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("Generation="+generationCount+"\r\n");
		fw2.write("執行時間 T_total_time="+total_time+ "ms"+"\r\n");
		fw2.write("執行時間扣除寫檔時間  T_net="+T_net+ "ms"+"\r\n");
		fw2.write("\r\n");
		fw2.close();
	}
	public static void LR_and_PSO2_Batch(int n,int[][] y, int[][] x, double Fittest,int generationCount,  long total_time,long T_net) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR_and_PSO2_Batch");
	    f2.mkdir();
	    File f3 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR_and_PSO2_Batch\\LR_and_PSO2_Batch"+n);
	    f3.mkdir();
    	FileWriter fw = new FileWriter( "output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR_and_PSO2_Batch\\LR_and_PSO2_Batch"+n+"\\X.txt",false);
    	for(int i=0;i<x.length;i++)
    		for(int j=0;j<x[i].length;j++)
			fw.write(String.valueOf(x[i][j]+"\r\n"));
    	fw.close();
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR_and_PSO2_Batch\\LR_and_PSO2_Batch"+n+"\\Y.txt",false);
    	for(int i=0;i<y.length;i++)
    		for(int j=0;j<y[i].length;j++)
			fw1.write(String.valueOf(y[i][j]+"\r\n"));
    	fw1.close();
		FileWriter fw2 = new FileWriter( "output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR_and_PSO2_Batch\\LR_and_PSO2_Batch"+n+"\\result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			for(int j=0;j<y[i].length;j++)
			fw2.write(y[i][j]+" ");
		fw2.write("\r\n");
		fw2.write("X=");
		for(int i=0;i<x.length;i++)
			for(int j=0;j<x[i].length;j++)
			fw2.write(x[i][j]+" ");
		fw2.write("\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("Generation="+generationCount+"\r\n");
		fw2.write("執行時間 T_total_time="+total_time+ "ms"+"\r\n");
		fw2.write("執行時間扣除寫檔時間  T_net="+T_net+ "ms"+"\r\n");
		fw2.write("\r\n");
		fw2.close();
	}
	public static void LR_and_PSO2_Tanh_Batch(int n,int[][] y, int[][] x, double Fittest,int generationCount,  long total_time,long T_net) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR_and_PSO2_Tanh_Batch");
	    f2.mkdir();
	    File f3 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR_and_PSO2_Tanh_Batch\\LR_and_PSO2_Tanh_Batch"+n);
	    f3.mkdir();
    	FileWriter fw = new FileWriter( "output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR_and_PSO2_Tanh_Batch\\LR_and_PSO2_Tanh_Batch"+n+"\\X.txt",false);
    	for(int i=0;i<x.length;i++)
    		for(int j=0;j<x[i].length;j++)
			fw.write(String.valueOf(x[i][j]+"\r\n"));
    	fw.close();
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR_and_PSO2_Tanh_Batch\\LR_and_PSO2_Tanh_Batch"+n+"\\Y.txt",false);
    	for(int i=0;i<y.length;i++)
    		for(int j=0;j<y[i].length;j++)
			fw1.write(String.valueOf(y[i][j]+"\r\n"));
    	fw1.close();
		FileWriter fw2 = new FileWriter( "output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR_and_PSO2_Tanh_Batch\\LR_and_PSO2_Tanh_Batch"+n+"\\result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			for(int j=0;j<y[i].length;j++)
			fw2.write(y[i][j]+" ");
		fw2.write("\r\n");
		fw2.write("X=");
		for(int i=0;i<x.length;i++)
			for(int j=0;j<x[i].length;j++)
			fw2.write(x[i][j]+" ");
		fw2.write("\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("Generation="+generationCount+"\r\n");
		fw2.write("執行時間 T_total_time="+total_time+ "ms"+"\r\n");
		fw2.write("執行時間扣除寫檔時間  T_net="+T_net+ "ms"+"\r\n");
		fw2.write("\r\n");
		fw2.close();
	}
	public static void LR_and_PSO2_P_Batch(int n,int[][] y, int[][] x, double Fittest,int generationCount,  long total_time,long T_net) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR_and_PSO2_P_Batch");
	    f2.mkdir();
	    File f3 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR_and_PSO2_P_Batch\\LR_and_PSO2_P_Batch"+n);
	    f3.mkdir();
    	FileWriter fw = new FileWriter( "output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR_and_PSO2_P_Batch\\LR_and_PSO2_P_Batch"+n+"\\X.txt",false);
    	for(int i=0;i<x.length;i++)
    		for(int j=0;j<x[i].length;j++)
			fw.write(String.valueOf(x[i][j]+"\r\n"));
    	fw.close();
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR_and_PSO2_P_Batch\\LR_and_PSO2_P_Batch"+n+"\\Y.txt",false);
    	for(int i=0;i<y.length;i++)
    		for(int j=0;j<y[i].length;j++)
			fw1.write(String.valueOf(y[i][j]+"\r\n"));
    	fw1.close();
		FileWriter fw2 = new FileWriter( "output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR_and_PSO2_P_Batch\\LR_and_PSO2_P_Batch"+n+"\\result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			for(int j=0;j<y[i].length;j++)
			fw2.write(y[i][j]+" ");
		fw2.write("\r\n");
		fw2.write("X=");
		for(int i=0;i<x.length;i++)
			for(int j=0;j<x[i].length;j++)
			fw2.write(x[i][j]+" ");
		fw2.write("\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("Generation="+generationCount+"\r\n");
		fw2.write("執行時間 T_total_time="+total_time+ "ms"+"\r\n");
		fw2.write("執行時間扣除寫檔時間  T_net="+T_net+ "ms"+"\r\n");
		fw2.write("\r\n");
		fw2.close();
	}
	public static void LR_and_PSO1_Batch(int n,int[][] y, int[][] x, double Fittest,int generationCount,  long total_time,long T_net) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR_and_PSO1_Batch");
	    f2.mkdir();
	    File f3 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR_and_PSO1_Batch\\LR_and_PSO1_Batch"+n);
	    f3.mkdir();
    	FileWriter fw = new FileWriter( "output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR_and_PSO1_Batch\\LR_and_PSO1_Batch"+n+"\\X.txt",false);
    	for(int i=0;i<x.length;i++)
    		for(int j=0;j<x[i].length;j++)
			fw.write(String.valueOf(x[i][j]+"\r\n"));
    	fw.close();
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR_and_PSO1_Batch\\LR_and_PSO1_Batch"+n+"\\Y.txt",false);
    	for(int i=0;i<y.length;i++)
    		for(int j=0;j<y[i].length;j++)
			fw1.write(String.valueOf(y[i][j]+"\r\n"));
    	fw1.close();
		FileWriter fw2 = new FileWriter( "output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR_and_PSO1_Batch\\LR_and_PSO1_Batch"+n+"\\result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			for(int j=0;j<y[i].length;j++)
			fw2.write(y[i][j]+" ");
		fw2.write("\r\n");
		fw2.write("X=");
		for(int i=0;i<x.length;i++)
			for(int j=0;j<x[i].length;j++)
			fw2.write(x[i][j]+" ");
		fw2.write("\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("Generation="+generationCount+"\r\n");
		fw2.write("執行時間 T_total_time="+total_time+ "ms"+"\r\n");
		fw2.write("執行時間扣除寫檔時間  T_net="+T_net+ "ms"+"\r\n");
		fw2.write("\r\n");
		fw2.close();
	}
	public static void LR_and_PSO1_Tanh_Batch(int n,int[][] y, int[][] x, double Fittest,int generationCount,  long total_time,long T_net) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR_and_PSO1_Tanh_Batch");
	    f2.mkdir();
	    File f3 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR_and_PSO1_Tanh_Batch\\LR_and_PSO1_Tanh_Batch"+n);
	    f3.mkdir();
    	FileWriter fw = new FileWriter( "output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR_and_PSO1_Tanh_Batch\\LR_and_PSO1_Tanh_Batch"+n+"\\X.txt",false);
    	for(int i=0;i<x.length;i++)
    		for(int j=0;j<x[i].length;j++)
			fw.write(String.valueOf(x[i][j]+"\r\n"));
    	fw.close();
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR_and_PSO1_Tanh_Batch\\LR_and_PSO1_Tanh_Batch"+n+"\\Y.txt",false);
    	for(int i=0;i<y.length;i++)
    		for(int j=0;j<y[i].length;j++)
			fw1.write(String.valueOf(y[i][j]+"\r\n"));
    	fw1.close();
		FileWriter fw2 = new FileWriter( "output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR_and_PSO1_Tanh_Batch\\LR_and_PSO1_Tanh_Batch"+n+"\\result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			for(int j=0;j<y[i].length;j++)
			fw2.write(y[i][j]+" ");
		fw2.write("\r\n");
		fw2.write("X=");
		for(int i=0;i<x.length;i++)
			for(int j=0;j<x[i].length;j++)
			fw2.write(x[i][j]+" ");
		fw2.write("\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("Generation="+generationCount+"\r\n");
		fw2.write("執行時間 T_total_time="+total_time+ "ms"+"\r\n");
		fw2.write("執行時間扣除寫檔時間  T_net="+T_net+ "ms"+"\r\n");
		fw2.write("\r\n");
		fw2.close();
	}
	public static void LR_and_PSO1_P_Batch(int n,int[][] y, int[][] x, double Fittest,int generationCount,  long total_time,long T_net) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR_and_PSO1_P_Batch");
	    f2.mkdir();
	    File f3 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR_and_PSO1_P_Batch\\LR_and_PSO1_P_Batch"+n);
	    f3.mkdir();
    	FileWriter fw = new FileWriter( "output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR_and_PSO1_P_Batch\\LR_and_PSO1_P_Batch"+n+"\\X.txt",false);
    	for(int i=0;i<x.length;i++)
    		for(int j=0;j<x[i].length;j++)
			fw.write(String.valueOf(x[i][j]+"\r\n"));
    	fw.close();
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR_and_PSO1_P_Batch\\LR_and_PSO1_P_Batch"+n+"\\Y.txt",false);
    	for(int i=0;i<y.length;i++)
    		for(int j=0;j<y[i].length;j++)
			fw1.write(String.valueOf(y[i][j]+"\r\n"));
    	fw1.close();
		FileWriter fw2 = new FileWriter( "output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR_and_PSO1_P_Batch\\LR_and_PSO1_P_Batch"+n+"\\result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			for(int j=0;j<y[i].length;j++)
			fw2.write(y[i][j]+" ");
		fw2.write("\r\n");
		fw2.write("X=");
		for(int i=0;i<x.length;i++)
			for(int j=0;j<x[i].length;j++)
			fw2.write(x[i][j]+" ");
		fw2.write("\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("Generation="+generationCount+"\r\n");
		fw2.write("執行時間 T_total_time="+total_time+ "ms"+"\r\n");
		fw2.write("執行時間扣除寫檔時間  T_net="+T_net+ "ms"+"\r\n");
		fw2.write("\r\n");
		fw2.close();
	}
	public static void PSO_LS_Batch(int n,int[] y, int[] x, double Fittest,int generationCount,  long total_time,long T_net) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO_LS_Batch");
	    f2.mkdir();
	    File f3 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO_LS_Batch\\PSO_LS_Batch"+n);
	    f3.mkdir();
    	FileWriter fw = new FileWriter( "output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO_LS_Batch\\PSO_LS_Batch"+n+"\\X.txt",false);
    	for(int i=0;i<x.length;i++)
			fw.write(String.valueOf(x[i]+"\r\n"));
    	fw.close();
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO_LS_Batch\\PSO_LS_Batch"+n+"\\Y.txt",false);
    	for(int i=0;i<y.length;i++)
			fw1.write(String.valueOf(y[i]+"\r\n"));
    	fw1.close();
		FileWriter fw2 = new FileWriter( "output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO_LS_Batch\\PSO_LS_Batch"+n+"\\result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			fw2.write(y[i]+" ");
		fw2.write("\r\n");
		fw2.write("X=");
		for(int i=0;i<x.length;i++)
			fw2.write(x[i]+" ");
		fw2.write("\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("Generation="+generationCount+"\r\n");
		fw2.write("執行時間 T_total_time="+total_time+ "ms"+"\r\n");
		fw2.write("執行時間扣除寫檔時間  T_net="+T_net+ "ms"+"\r\n");
		fw2.write("\r\n");
		fw2.close();
	}
	public static void PSO_TS_Batch(int n,int[] y, int[] x, double Fittest,int generationCount,  long total_time,long T_net) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO_TS_Batch");
	    f2.mkdir();
	    File f3 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO_TS_Batch\\PSO_TS_Batch"+n);
	    f3.mkdir();
    	FileWriter fw = new FileWriter( "output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO_TS_Batch\\PSO_TS_Batch"+n+"\\X.txt",false);
    	for(int i=0;i<x.length;i++)
			fw.write(String.valueOf(x[i]+"\r\n"));
    	fw.close();
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO_TS_Batch\\PSO_TS_Batch"+n+"\\Y.txt",false);
    	for(int i=0;i<y.length;i++)
			fw1.write(String.valueOf(y[i]+"\r\n"));
    	fw1.close();
		FileWriter fw2 = new FileWriter( "output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO_TS_Batch\\PSO_TS_Batch"+n+"\\result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			fw2.write(y[i]+" ");
		fw2.write("\r\n");
		fw2.write("X=");
		for(int i=0;i<x.length;i++)
			fw2.write(x[i]+" ");
		fw2.write("\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("Generation="+generationCount+"\r\n");
		fw2.write("執行時間 T_total_time="+total_time+ "ms"+"\r\n");
		fw2.write("執行時間扣除寫檔時間  T_net="+T_net+ "ms"+"\r\n");
		fw2.write("\r\n");
		fw2.close();
	}
	public static void savePSO1_Batch_Parameter(int n,int populationSize,double w,double c1,double c2,int Vmax,int Execution_Mode,int  Print_Mode, int Write_Mode,double threshold ) throws IOException{

		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO1_Batch");
	    f2.mkdir();
	    File f3 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO1_Batch\\PSO1_Batch"+n);
	    f3.mkdir();
		 FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO1_Batch\\PSO1_Batch"+n+"\\PSO_Parameter.txt");
			fw2.write("populationSize="+populationSize+"\r\n");
			fw2.write("w="+w+"\r\n");
			fw2.write("c1="+c1+"\r\n");
			fw2.write("c2="+c2+  "\r\n");
			fw2.write("Vmax="+Vmax+  "\r\n");
			fw2.write("Execution_Mode="+Execution_Mode+  "\r\n");
			fw2.write("Print_Mode="+Print_Mode+  "\r\n");
			fw2.write("Write_Mode="+Write_Mode+  "\r\n");
			fw2.write("threshold="+new BigDecimal(String.valueOf(threshold))+  "\r\n");

			//fw2.write("\r\n");
			fw2.close();
	 }
	public static void savePSO1_Tanh_Batch_Parameter(int n,int populationSize,double w,double c1,double c2,int Vmax,int Execution_Mode,int  Print_Mode, int Write_Mode,double threshold ) throws IOException{

		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO1_Tanh_Batch");
	    f2.mkdir();
	    File f3 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO1_Tanh_Batch\\PSO1_Tanh_Batch"+n);
	    f3.mkdir();
		 FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO1_Tanh_Batch\\PSO1_Tanh_Batch"+n+"\\PSO_Parameter.txt");
			fw2.write("populationSize="+populationSize+"\r\n");
			fw2.write("w="+w+"\r\n");
			fw2.write("c1="+c1+"\r\n");
			fw2.write("c2="+c2+  "\r\n");
			fw2.write("Vmax="+Vmax+  "\r\n");
			fw2.write("Execution_Mode="+Execution_Mode+  "\r\n");
			fw2.write("Print_Mode="+Print_Mode+  "\r\n");
			fw2.write("Write_Mode="+Write_Mode+  "\r\n");
			fw2.write("threshold="+new BigDecimal(String.valueOf(threshold))+  "\r\n");

			//fw2.write("\r\n");
			fw2.close();
	 }
	public static void savePSO1_P_Batch_Parameter(int n,int populationSize,double w,double c1,double c2,int Vmax,int Execution_Mode,int  Print_Mode, int Write_Mode,double threshold ) throws IOException{

		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO1_P_Batch");
	    f2.mkdir();
	    File f3 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO1_P_Batch\\PSO1_P_Batch"+n);
	    f3.mkdir();
		 FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO1_P_Batch\\PSO1_P_Batch"+n+"\\PSO_Parameter.txt");
			fw2.write("populationSize="+populationSize+"\r\n");
			fw2.write("w="+w+"\r\n");
			fw2.write("c1="+c1+"\r\n");
			fw2.write("c2="+c2+  "\r\n");
			fw2.write("Vmax="+Vmax+  "\r\n");
			fw2.write("Execution_Mode="+Execution_Mode+  "\r\n");
			fw2.write("Print_Mode="+Print_Mode+  "\r\n");
			fw2.write("Write_Mode="+Write_Mode+  "\r\n");
			fw2.write("threshold="+new BigDecimal(String.valueOf(threshold))+  "\r\n");

			//fw2.write("\r\n");
			fw2.close();
	 }
	public static void savePSO2_Batch_Parameter(int n,int populationSize,double w,double c1,double c2,int Vmax,int Execution_Mode,int  Print_Mode, int Write_Mode,double threshold ) throws IOException{
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO2_Batch");
	    f2.mkdir();
	    File f3 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO2_Batch\\PSO2_Batch"+n);
	    f3.mkdir();
		 FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO2_Batch\\PSO2_Batch"+n+"\\PSO_Parameter.txt");
			fw2.write("populationSize="+populationSize+"\r\n");
			fw2.write("w="+w+"\r\n");
			fw2.write("c1="+c1+"\r\n");
			fw2.write("c2="+c2+  "\r\n");
			fw2.write("Vmax="+Vmax+  "\r\n");
			fw2.write("Execution_Mode="+Execution_Mode+  "\r\n");
			fw2.write("Print_Mode="+Print_Mode+  "\r\n");
			fw2.write("Write_Mode="+Write_Mode+  "\r\n");
			
			fw2.write("threshold="+new BigDecimal(String.valueOf(threshold))+  "\r\n");

			//fw2.write("\r\n");
			fw2.close();
	 }
	public static void savePSO2_Tanh_Batch_Parameter(int n,int populationSize,double w,double c1,double c2,int Vmax,int Execution_Mode,int  Print_Mode, int Write_Mode,double threshold ) throws IOException{
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO2_Tanh_Batch");
	    f2.mkdir();
	    File f3 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO2_Tanh_Batch\\PSO2_Tanh_Batch"+n);
	    f3.mkdir();
		 FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO2_Tanh_Batch\\PSO2_Tanh_Batch"+n+"\\PSO_Parameter.txt");
			fw2.write("populationSize="+populationSize+"\r\n");
			fw2.write("w="+w+"\r\n");
			fw2.write("c1="+c1+"\r\n");
			fw2.write("c2="+c2+  "\r\n");
			fw2.write("Vmax="+Vmax+  "\r\n");
			fw2.write("Execution_Mode="+Execution_Mode+  "\r\n");
			fw2.write("Print_Mode="+Print_Mode+  "\r\n");
			fw2.write("Write_Mode="+Write_Mode+  "\r\n");
			
			fw2.write("threshold="+new BigDecimal(String.valueOf(threshold))+  "\r\n");

			//fw2.write("\r\n");
			fw2.close();
	 }
	public static void savePSO3_Batch_Parameter(int n,int populationSize,double w,double c1,double c2,int Vmax,int Execution_Mode,int  Print_Mode,double threshold ) throws IOException{
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO3_Batch");
	    f2.mkdir();
	    File f3 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO3_Batch\\PSO3_Batch"+n);
	    f3.mkdir();
		 FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO3_Batch\\PSO3_Batch"+n+"\\PSO_Parameter.txt");
			fw2.write("populationSize="+populationSize+"\r\n");
			fw2.write("w="+w+"\r\n");
			fw2.write("c1="+c1+"\r\n");
			fw2.write("c2="+c2+  "\r\n");
			fw2.write("Vmax="+Vmax+  "\r\n");
			fw2.write("Execution_Mode="+Execution_Mode+  "\r\n");
			fw2.write("Print_Mode="+Print_Mode+  "\r\n");
			fw2.write("threshold="+new BigDecimal(String.valueOf(threshold))+  "\r\n");

			//fw2.write("\r\n");
			fw2.close();
	 }
	public static void savePSO4_Batch_Parameter(int n,int populationSize,double w,double c1,double c2,int Vmax,int Execution_Mode,int  Print_Mode,double threshold ,double epsilon,double micro) throws IOException{
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO4_Batch");
	    f2.mkdir();
	    File f3 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO4_Batch\\PSO4_Batch"+n);
	    f3.mkdir();
		 FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO4_Batch\\PSO4_Batch"+n+"\\PSO_Parameter.txt");
			fw2.write("populationSize="+populationSize+"\r\n");
			fw2.write("w="+w+"\r\n");
			fw2.write("c1="+c1+"\r\n");
			fw2.write("c2="+c2+  "\r\n");
			fw2.write("Vmax="+Vmax+  "\r\n");
			fw2.write("Execution_Mode="+Execution_Mode+  "\r\n");
			fw2.write("Print_Mode="+Print_Mode+  "\r\n");
			fw2.write("threshold="+new BigDecimal(String.valueOf(threshold))+  "\r\n");
			fw2.write("epsilon="+new BigDecimal(String.valueOf(epsilon))+  "\r\n");
			fw2.write("micro="+new BigDecimal(String.valueOf(micro))+  "\r\n");

			//fw2.write("\r\n");
			fw2.close();
	 }
	public static void saveAPSO1_Batch_Parameter(int n,int populationSize,double w,double c1,double c2,int Vmax,int Execution_Mode,int  Print_Mode,double threshold ) throws IOException{

		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\APSO1_Batch");
	    f2.mkdir();
	    File f3 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\APSO1_Batch\\APSO1_Batch"+n);
	    f3.mkdir();
		 FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\APSO1_Batch\\APSO1_Batch"+n+"\\PSO_Parameter.txt");
			fw2.write("populationSize="+populationSize+"\r\n");
			fw2.write("w="+w+"\r\n");
			fw2.write("c1="+c1+"\r\n");
			fw2.write("c2="+c2+  "\r\n");
			fw2.write("Vmax="+Vmax+  "\r\n");
			fw2.write("Execution_Mode="+Execution_Mode+  "\r\n");
			fw2.write("Print_Mode="+Print_Mode+  "\r\n");
			fw2.write("threshold="+new BigDecimal(String.valueOf(threshold))+  "\r\n");

			//fw2.write("\r\n");
			fw2.close();
	 }
	
	public static void saveAPSO2_Batch_Parameter(int n,int populationSize,double w,double c1,double c2,int Vmax,int Execution_Mode,int  Print_Mode,double threshold ) throws IOException{
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\APSO2_Batch");
	    f2.mkdir();
	    File f3 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\APSO2_Batch\\APSO2_Batch"+n);
	    f3.mkdir();
		 FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\APSO2_Batch\\APSO2_Batch"+n+"\\PSO_Parameter.txt");
			fw2.write("populationSize="+populationSize+"\r\n");
			fw2.write("w="+w+"\r\n");
			fw2.write("c1="+c1+"\r\n");
			fw2.write("c2="+c2+  "\r\n");
			fw2.write("Vmax="+Vmax+  "\r\n");
			fw2.write("Execution_Mode="+Execution_Mode+  "\r\n");
			fw2.write("Print_Mode="+Print_Mode+  "\r\n");
			fw2.write("threshold="+new BigDecimal(String.valueOf(threshold))+  "\r\n");

			//fw2.write("\r\n");
			fw2.close();
	 }
	public static void saveALPSO_Batch_Parameter(int n,int populationSize,double w,double c1,double c2,int Vmax,int Execution_Mode,int  Print_Mode,double threshold ) throws IOException{

		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\ALPSO_Batch");
	    f2.mkdir();
	    File f3 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\ALPSO_Batch\\ALPSO_Batch"+n);
	    f3.mkdir();
		 FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\ALPSO_Batch\\ALPSO_Batch"+n+"\\PSO_Parameter.txt");
			fw2.write("populationSize="+populationSize+"\r\n");
			fw2.write("w="+w+"\r\n");
			fw2.write("c1="+c1+"\r\n");
			fw2.write("c2="+c2+  "\r\n");
			fw2.write("Vmax="+Vmax+  "\r\n");
			fw2.write("Execution_Mode="+Execution_Mode+  "\r\n");
			fw2.write("Print_Mode="+Print_Mode+  "\r\n");
			fw2.write("threshold="+new BigDecimal(String.valueOf(threshold))+  "\r\n");

			//fw2.write("\r\n");
			fw2.close();
	 }
	public static void saveALPSO_Tanh_Batch_Parameter(int n,int populationSize,double w,double c1,double c2,int Vmax,int Execution_Mode,int  Print_Mode,double threshold ) throws IOException{

		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\ALPSO_Tanh_Batch");
	    f2.mkdir();
	    File f3 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\ALPSO_Tanh_Batch\\ALPSO_Tanh_Batch"+n);
	    f3.mkdir();
		 FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\ALPSO_Tanh_Batch\\ALPSO_Tanh_Batch"+n+"\\PSO_Parameter.txt");
			fw2.write("populationSize="+populationSize+"\r\n");
			fw2.write("w="+w+"\r\n");
			fw2.write("c1="+c1+"\r\n");
			fw2.write("c2="+c2+  "\r\n");
			fw2.write("Vmax="+Vmax+  "\r\n");
			fw2.write("Execution_Mode="+Execution_Mode+  "\r\n");
			fw2.write("Print_Mode="+Print_Mode+  "\r\n");
			fw2.write("threshold="+new BigDecimal(String.valueOf(threshold))+  "\r\n");

			//fw2.write("\r\n");
			fw2.close();
	 }
	public static void saveALPSO_P_Batch_Parameter(int n,int populationSize,double w,double c1,double c2,int Vmax,int Execution_Mode,int  Print_Mode,double threshold ) throws IOException{

		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\ALPSO_P_Batch");
	    f2.mkdir();
	    File f3 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\ALPSO_P_Batch\\ALPSO_P_Batch"+n);
	    f3.mkdir();
		 FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\ALPSO_P_Batch\\ALPSO_P_Batch"+n+"\\PSO_Parameter.txt");
			fw2.write("populationSize="+populationSize+"\r\n");
			fw2.write("w="+w+"\r\n");
			fw2.write("c1="+c1+"\r\n");
			fw2.write("c2="+c2+  "\r\n");
			fw2.write("Vmax="+Vmax+  "\r\n");
			fw2.write("Execution_Mode="+Execution_Mode+  "\r\n");
			fw2.write("Print_Mode="+Print_Mode+  "\r\n");
			fw2.write("threshold="+new BigDecimal(String.valueOf(threshold))+  "\r\n");

			//fw2.write("\r\n");
			fw2.close();
	 }
	public static void saveCCPSO2_Batch_Parameter(int n,int populationSize,double w,double c1,double c2,int Vmax,int Execution_Mode,int  Print_Mode,double threshold ) throws IOException{

		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\CCPSO2_Batch");
	    f2.mkdir();
	    File f3 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\CCPSO2_Batch\\CCPSO2_Batch"+n);
	    f3.mkdir();
		 FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\CCPSO2_Batch\\CCPSO2_Batch"+n+"\\PSO_Parameter.txt");
			fw2.write("populationSize="+populationSize+"\r\n");
			fw2.write("w="+w+"\r\n");
			fw2.write("c1="+c1+"\r\n");
			fw2.write("c2="+c2+  "\r\n");
			fw2.write("Vmax="+Vmax+  "\r\n");
			fw2.write("Execution_Mode="+Execution_Mode+  "\r\n");
			fw2.write("Print_Mode="+Print_Mode+  "\r\n");
			fw2.write("threshold="+new BigDecimal(String.valueOf(threshold))+  "\r\n");

			//fw2.write("\r\n");
			fw2.close();
	 }
	public static void saveCCPSO2_P_Batch_Parameter(int n,int populationSize,double w,double c1,double c2,int Vmax,int Execution_Mode,int  Print_Mode,double threshold ) throws IOException{

		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\CCPSO2_P_Batch");
	    f2.mkdir();
	    File f3 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\CCPSO2_P_Batch\\CCPSO2_P_Batch"+n);
	    f3.mkdir();
		 FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\CCPSO2_P_Batch\\CCPSO2_P_Batch"+n+"\\PSO_Parameter.txt");
			fw2.write("populationSize="+populationSize+"\r\n");
			fw2.write("w="+w+"\r\n");
			fw2.write("c1="+c1+"\r\n");
			fw2.write("c2="+c2+  "\r\n");
			fw2.write("Vmax="+Vmax+  "\r\n");
			fw2.write("Execution_Mode="+Execution_Mode+  "\r\n");
			fw2.write("Print_Mode="+Print_Mode+  "\r\n");
			fw2.write("threshold="+new BigDecimal(String.valueOf(threshold))+  "\r\n");

			//fw2.write("\r\n");
			fw2.close();
	 }
	public static void saveLRPSO_Batch_Parameter(int n,int populationSize,double w,double c1,double c2,int Vmax,int Execution_Mode,int  Print_Mode,double threshold ) throws IOException{

		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LRPSO_Batch");
	    f2.mkdir();
	    File f3 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LRPSO_Batch\\ALPSO_Batch"+n);
	    f3.mkdir();
		 FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LRPSO_Batch\\LRPSO_Batch"+n+"\\PSO_Parameter.txt");
			fw2.write("populationSize="+populationSize+"\r\n");
			fw2.write("w="+w+"\r\n");
			fw2.write("c1="+c1+"\r\n");
			fw2.write("c2="+c2+  "\r\n");
			fw2.write("Vmax="+Vmax+  "\r\n");
			fw2.write("Execution_Mode="+Execution_Mode+  "\r\n");
			fw2.write("Print_Mode="+Print_Mode+  "\r\n");
			fw2.write("threshold="+new BigDecimal(String.valueOf(threshold))+  "\r\n");

			//fw2.write("\r\n");
			fw2.close();
	 }
	public static void saveLRPSO_Tanh_Batch_Parameter(int n,int populationSize,double w,double c1,double c2,int Vmax,int Execution_Mode,int  Print_Mode,double threshold ) throws IOException{

		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LRPSO_Tanh_Batch");
	    f2.mkdir();
	    File f3 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LRPSO_Tanh_Batch\\LRPSO_Tanh_Batch"+n);
	    f3.mkdir();
		 FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LRPSO_Tanh_Batch\\LRPSO_Tanh_Batch"+n+"\\PSO_Parameter.txt");
			fw2.write("populationSize="+populationSize+"\r\n");
			fw2.write("w="+w+"\r\n");
			fw2.write("c1="+c1+"\r\n");
			fw2.write("c2="+c2+  "\r\n");
			fw2.write("Vmax="+Vmax+  "\r\n");
			fw2.write("Execution_Mode="+Execution_Mode+  "\r\n");
			fw2.write("Print_Mode="+Print_Mode+  "\r\n");
			fw2.write("threshold="+new BigDecimal(String.valueOf(threshold))+  "\r\n");

			//fw2.write("\r\n");
			fw2.close();
	 }
	public static void saveLRPSO_P_Batch_Parameter(int n,int populationSize,double w,double c1,double c2,int Vmax,int Execution_Mode,int  Print_Mode,double threshold ) throws IOException{

		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LRPSO_P_Batch");
	    f2.mkdir();
	    File f3 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LRPSO_P_Batch\\LRPSO_P_Batch"+n);
	    f3.mkdir();
		 FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LRPSO_P_Batch\\LRPSO_P_Batch"+n+"\\PSO_Parameter.txt");
			fw2.write("populationSize="+populationSize+"\r\n");
			fw2.write("w="+w+"\r\n");
			fw2.write("c1="+c1+"\r\n");
			fw2.write("c2="+c2+  "\r\n");
			fw2.write("Vmax="+Vmax+  "\r\n");
			fw2.write("Execution_Mode="+Execution_Mode+  "\r\n");
			fw2.write("Print_Mode="+Print_Mode+  "\r\n");
			fw2.write("threshold="+new BigDecimal(String.valueOf(threshold))+  "\r\n");

			//fw2.write("\r\n");
			fw2.close();
	 }
	public static void saveLR_and_PSO2_Batch_Parameter(int n,int populationSize,double w,double c1,double c2,int Vmax,int Execution_Mode,int  Print_Mode,int  Write_Mode,double threshold ) throws IOException{

		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR_and_PSO2_Batch");
	    f2.mkdir();
	    File f3 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR_and_PSO2_Batch\\LR_and_PSO2_Batch"+n);
	    f3.mkdir();
		 FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR_and_PSO2_Batch\\LR_and_PSO2_Batch"+n+"\\PSO_Parameter.txt");
			fw2.write("populationSize="+populationSize+"\r\n");
			fw2.write("w="+w+"\r\n");
			fw2.write("c1="+c1+"\r\n");
			fw2.write("c2="+c2+  "\r\n");
			fw2.write("Vmax="+Vmax+  "\r\n");
			fw2.write("Execution_Mode="+Execution_Mode+  "\r\n");
			fw2.write("Print_Mode="+Print_Mode+  "\r\n");
			fw2.write("Write_Mode="+Write_Mode+  "\r\n");
			fw2.write("threshold="+new BigDecimal(String.valueOf(threshold))+  "\r\n");

			//fw2.write("\r\n");
			fw2.close();
	 }
	public static void saveLR_and_PSO2_Tanh_Batch_Parameter(int n,int populationSize,double w,double c1,double c2,int Vmax,int Execution_Mode,int  Print_Mode,int  Write_Mode,double threshold ) throws IOException{

		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR_and_PSO2_Tanh_Batch");
	    f2.mkdir();
	    File f3 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR_and_PSO2_Tanh_Batch\\LR_and_PSO2_Tanh_Batch"+n);
	    f3.mkdir();
		 FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR_and_PSO2_Tanh_Batch\\LR_and_PSO2_Tanh_Batch"+n+"\\PSO_Parameter.txt");
			fw2.write("populationSize="+populationSize+"\r\n");
			fw2.write("w="+w+"\r\n");
			fw2.write("c1="+c1+"\r\n");
			fw2.write("c2="+c2+  "\r\n");
			fw2.write("Vmax="+Vmax+  "\r\n");
			fw2.write("Execution_Mode="+Execution_Mode+  "\r\n");
			fw2.write("Print_Mode="+Print_Mode+  "\r\n");
			fw2.write("Write_Mode="+Write_Mode+  "\r\n");
			fw2.write("threshold="+new BigDecimal(String.valueOf(threshold))+  "\r\n");

			//fw2.write("\r\n");
			fw2.close();
	 }
	public static void saveLR_and_PSO2_P_Batch_Parameter(int n,int populationSize,double w,double c1,double c2,int Vmax,int Execution_Mode,int  Print_Mode,int  Write_Mode,double threshold ) throws IOException{

		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR_and_PSO2_P_Batch");
	    f2.mkdir();
	    File f3 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR_and_PSO2_P_Batch\\LR_and_PSO2_P_Batch"+n);
	    f3.mkdir();
		 FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR_and_PSO2_P_Batch\\LR_and_PSO2_P_Batch"+n+"\\PSO_Parameter.txt");
			fw2.write("populationSize="+populationSize+"\r\n");
			fw2.write("w="+w+"\r\n");
			fw2.write("c1="+c1+"\r\n");
			fw2.write("c2="+c2+  "\r\n");
			fw2.write("Vmax="+Vmax+  "\r\n");
			fw2.write("Execution_Mode="+Execution_Mode+  "\r\n");
			fw2.write("Print_Mode="+Print_Mode+  "\r\n");
			fw2.write("Write_Mode="+Write_Mode+  "\r\n");
			fw2.write("threshold="+new BigDecimal(String.valueOf(threshold))+  "\r\n");

			//fw2.write("\r\n");
			fw2.close();
	 }
	public static void saveLR_and_PSO1_Batch_Parameter(int n,int populationSize,double w,double c1,double c2,int Vmax,int Execution_Mode,int  Print_Mode,int Write_Mode,double threshold ) throws IOException{

		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR_and_PSO1_Batch");
	    f2.mkdir();
	    File f3 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR_and_PSO1_Batch\\LR_and_PSO1_Batch"+n);
	    f3.mkdir();
		 FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR_and_PSO1_Batch\\LR_and_PSO1_Batch"+n+"\\PSO_Parameter.txt");
			fw2.write("populationSize="+populationSize+"\r\n");
			fw2.write("w="+w+"\r\n");
			fw2.write("c1="+c1+"\r\n");
			fw2.write("c2="+c2+  "\r\n");
			fw2.write("Vmax="+Vmax+  "\r\n");
			fw2.write("Execution_Mode="+Execution_Mode+  "\r\n");
			fw2.write("Print_Mode="+Print_Mode+  "\r\n");
			fw2.write("Write_Mode="+Write_Mode+  "\r\n");
			fw2.write("threshold="+new BigDecimal(String.valueOf(threshold))+  "\r\n");

			//fw2.write("\r\n");
			fw2.close();
	 }
	public static void saveLR_and_PSO1_Tanh_Batch_Parameter(int n,int populationSize,double w,double c1,double c2,int Vmax,int Execution_Mode,int  Print_Mode,int Write_Mode,double threshold ) throws IOException{

		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR_and_PSO1_Tanh_Batch");
	    f2.mkdir();
	    File f3 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR_and_PSO1_Tanh_Batch\\LR_and_PSO1_Tanh_Batch"+n);
	    f3.mkdir();
		 FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR_and_PSO1_Tanh_Batch\\LR_and_PSO1_Tanh_Batch"+n+"\\PSO_Parameter.txt");
			fw2.write("populationSize="+populationSize+"\r\n");
			fw2.write("w="+w+"\r\n");
			fw2.write("c1="+c1+"\r\n");
			fw2.write("c2="+c2+  "\r\n");
			fw2.write("Vmax="+Vmax+  "\r\n");
			fw2.write("Execution_Mode="+Execution_Mode+  "\r\n");
			fw2.write("Print_Mode="+Print_Mode+  "\r\n");
			fw2.write("Write_Mode="+Write_Mode+  "\r\n");
			fw2.write("threshold="+new BigDecimal(String.valueOf(threshold))+  "\r\n");

			//fw2.write("\r\n");
			fw2.close();
	 }
	public static void saveLR_and_PSO1_P_Batch_Parameter(int n,int populationSize,double w,double c1,double c2,int Vmax,int Execution_Mode,int  Print_Mode,int Write_Mode,double threshold ) throws IOException{

		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR_and_PSO1_P_Batch");
	    f2.mkdir();
	    File f3 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR_and_PSO1_P_Batch\\LR_and_PSO1_P_Batch"+n);
	    f3.mkdir();
		 FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR_and_PSO1_P_Batch\\LR_and_PSO1_P_Batch"+n+"\\PSO_Parameter.txt");
			fw2.write("populationSize="+populationSize+"\r\n");
			fw2.write("w="+w+"\r\n");
			fw2.write("c1="+c1+"\r\n");
			fw2.write("c2="+c2+  "\r\n");
			fw2.write("Vmax="+Vmax+  "\r\n");
			fw2.write("Execution_Mode="+Execution_Mode+  "\r\n");
			fw2.write("Print_Mode="+Print_Mode+  "\r\n");
			fw2.write("Write_Mode="+Write_Mode+  "\r\n");
			fw2.write("threshold="+new BigDecimal(String.valueOf(threshold))+  "\r\n");

			//fw2.write("\r\n");
			fw2.close();
	 }
	public static void savePSO_LS_Batch_Parameter(int n,int populationSize,double w,double c1,double c2,int Vmax,int Execution_Mode,int  Print_Mode,double threshold ) throws IOException{
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO_LS_Batch");
	    f2.mkdir();
	    File f3 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO_LS_Batch\\PSO_LS_Batch"+n);
	    f3.mkdir();
		 FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO_LS_Batch\\PSO_LS_Batch"+n+"\\PSO_Parameter.txt");
			fw2.write("populationSize="+populationSize+"\r\n");
			fw2.write("w="+w+"\r\n");
			fw2.write("c1="+c1+"\r\n");
			fw2.write("c2="+c2+  "\r\n");
			fw2.write("Vmax="+Vmax+  "\r\n");
			fw2.write("Execution_Mode="+Execution_Mode+  "\r\n");
			fw2.write("Print_Mode="+Print_Mode+  "\r\n");
			fw2.write("threshold="+new BigDecimal(String.valueOf(threshold))+  "\r\n");

			//fw2.write("\r\n");
			fw2.close();
	 }
	public static void savePSO_TS_Batch_Parameter(int n,int populationSize,double w,double c1,double c2,int Vmax,int Execution_Mode,int  Print_Mode,int Write_Mode,double threshold ) throws IOException{
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO_TS_Batch");
	    f2.mkdir();
	    File f3 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO_TS_Batch\\PSO_TS_Batch"+n);
	    f3.mkdir();
		 FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO_TS_Batch\\PSO_TS_Batch"+n+"\\PSO_Parameter.txt");
			fw2.write("populationSize="+populationSize+"\r\n");
			fw2.write("w="+w+"\r\n");
			fw2.write("c1="+c1+"\r\n");
			fw2.write("c2="+c2+  "\r\n");
			fw2.write("Vmax="+Vmax+  "\r\n");
			fw2.write("Execution_Mode="+Execution_Mode+  "\r\n");
			fw2.write("Print_Mode="+Print_Mode+  "\r\n");
			fw2.write("Write_Mode="+Write_Mode+  "\r\n");
			
			fw2.write("threshold="+new BigDecimal(String.valueOf(threshold))+  "\r\n");

			//fw2.write("\r\n");
			fw2.close();
	 }
	public static void CPLEX_LP(String y, String x, double Fittest, long time,String str) throws IOException  
	{	 
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\CPLEX_LP");
	    f2.mkdir();
		FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\CPLEX_LP\\Result.txt",false);
		fw2.write("Y="+y+"\r\n");
		fw2.write("X="+x+"\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("執行時間="+time+ "ms"+"\r\n");
		fw2.write("\r\n");
		fw2.close();
		String[] Y=y.split(" ");
		FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\CPLEX_LP\\Y.txt",false);
		for(int i=0;i<Y.length;i++)
		fw1.write(Y[i]+"\r\n");
		fw1.close();
		String[] X=x.split(" ");
		FileWriter fw3 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\CPLEX_LP\\X.txt",false);
		for(int i=0;i<X.length;i++)
		fw3.write(X[i]+"\r\n");
		fw3.close();
		FileWriter fw = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\CPLEX_LP\\Generation_Time_Log.txt",false);
		fw.write(String.valueOf(str));
		fw.close();
	}
 

	}
