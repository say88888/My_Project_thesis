package Input_Output_txt.Tourism;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import GUI.I_Set_Paths_for_Current_Simulation_Example;
import GUI.GUI_Tourism.X_Select_Algorithm_Type_to_Solve_the_Problem;

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
 
	//-----------------------------以下為編寫旅遊的資料-------------------------
	
	public static void CPLEX_Tourism(String Y,String Xa,String Xh,String Xt, double Fittest, long total_time,String str, ArrayList<List<Integer>> A, ArrayList<Integer> B, ArrayList<Double> C) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\CPLEX");
	    f2.mkdir();
	    String[] xa=Xa.split(" ");
	    FileWriter fw = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\CPLEX\\Xa.txt",false);
    	for(int i=0;i<xa.length;i++)
			fw.write(String.valueOf(xa[i]+"\r\n"));
    	fw.close();
    	 String[] xh=Xh.split(" ");
    	FileWriter fw4 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\CPLEX\\Xh.txt",false);
    	for(int i=0;i<xh.length;i++)
			fw4.write(String.valueOf(xh[i]+"\r\n"));
    	fw4.close();
    	 String[] xt=Xt.split(" ");
    	FileWriter fw5 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\CPLEX\\Xt.txt",false);
    	for(int i=0;i<xt.length;i++)
			fw5.write(String.valueOf(xt[i]+"\r\n"));
    	fw5.close();
    	 String[] y=Y.split(" ");
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\CPLEX\\Y.txt",false);
    	for(int i=0;i<y.length;i++)
			fw1.write(String.valueOf(y[i]+"\r\n"));
    	fw1.close();
		FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\CPLEX\\Result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			fw2.write(y[i]+" ");
		fw2.write("\r\n");
		fw2.write("Xa=");
		for(int i=0;i<xa.length;i++)
			fw2.write(xa[i]+" ");
		fw2.write("\r\n");
		fw2.write("Xh=");
		for(int i=0;i<xh.length;i++)
			fw2.write(xh[i]+" ");
		fw2.write("\r\n");
		fw2.write("Xa=");
		for(int i=0;i<xt.length;i++)
			fw2.write(xt[i]+" ");
		fw2.write("\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("執行時間 T_total_time="+total_time+ "ms"+"\r\n");

		fw2.write("\r\n");
		fw2.close();
		FileWriter fw3 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\CPLEX\\Generation_Time_Log.txt",false);
		fw3.write(String.valueOf(str));
		fw3.close();
		FileWriter fw6 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\CPLEX\\A_Vector.txt",false);
		for(int i=0;i<A.size();i++)
			for(int j=0;j<A.get(i).size();j++){
				fw6.write("i="+i+" j="+j+"  "+String.valueOf(A.get(i).get(j)));
				fw6.write("\r\n");
			}
		fw6.close();
		FileWriter fw7 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\CPLEX\\B_Vector.txt",false);
		for(int i=0;i<B.size();i++){
				fw7.write("i="+i+ "  "+String.valueOf(B.get(i)));
				fw7.write("\r\n");
		}
		fw7.close();
		FileWriter fw8 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\CPLEX\\C_Vector.txt",false);
		for(int i=0;i<C.size();i++){
				fw8.write("i="+i+ "  "+String.valueOf(C.get(i)));
				fw8.write("\r\n");
		}
		fw8.close();
	}
	
	public static void Genetic_Algorithm1_Tourism(int[] y, int[] xa,int[] xh,int[] xt, double Fittest,int generationCount, long total_time,long T_net,String str) throws IOException  
	{	 
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\GA1");
	    f2.mkdir();
    	FileWriter fw = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\GA1\\Xa.txt",false);
    	for(int i=0;i<xa.length;i++)
			fw.write(String.valueOf(xa[i]+"\r\n"));
    	fw.close();
    	FileWriter fw4 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\GA1\\Xh.txt",false);
    	for(int i=0;i<xh.length;i++)
			fw4.write(String.valueOf(xh[i]+"\r\n"));
    	fw4.close();
    	FileWriter fw5 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\GA1\\Xt.txt",false);
    	for(int i=0;i<xt.length;i++)
			fw5.write(String.valueOf(xt[i]+"\r\n"));
    	fw5.close();
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\GA1\\Y.txt",false);
    	for(int i=0;i<y.length;i++)
			fw1.write(String.valueOf(y[i]+"\r\n"));
    	fw1.close();
		FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\GA1\\Result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			fw2.write(y[i]+" ");
		fw2.write("\r\n");
		fw2.write("Xa=");
		for(int i=0;i<xa.length;i++)
			fw2.write(xa[i]+" ");
		fw2.write("\r\n");
		fw2.write("Xh=");
		for(int i=0;i<xh.length;i++)
			fw2.write(xh[i]+" ");
		fw2.write("\r\n");
		fw2.write("Xa=");
		for(int i=0;i<xt.length;i++)
			fw2.write(xt[i]+" ");
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
	
	public static void Genetic_Algorithm2_Tourism(int[] y, int[] xa,int[] xh,int[] xt, double Fittest,int generationCount, long total_time,long T_net,String str) throws IOException  
	{	 
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\GA2");
	    f2.mkdir();
    	FileWriter fw = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\GA2\\Xa.txt",false);
    	for(int i=0;i<xa.length;i++)
			fw.write(String.valueOf(xa[i]+"\r\n"));
    	fw.close();
    	FileWriter fw4 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\GA2\\Xh.txt",false);
    	for(int i=0;i<xh.length;i++)
			fw4.write(String.valueOf(xh[i]+"\r\n"));
    	fw4.close();
    	FileWriter fw5 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\GA2\\Xt.txt",false);
    	for(int i=0;i<xt.length;i++)
			fw5.write(String.valueOf(xt[i]+"\r\n"));
    	fw5.close();
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\GA2\\Y.txt",false);
    	for(int i=0;i<y.length;i++)
			fw1.write(String.valueOf(y[i]+"\r\n"));
    	fw1.close();
		FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\GA2\\Result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			fw2.write(y[i]+" ");
		fw2.write("\r\n");
		fw2.write("Xa=");
		for(int i=0;i<xa.length;i++)
			fw2.write(xa[i]+" ");
		fw2.write("\r\n");
		fw2.write("Xh=");
		for(int i=0;i<xh.length;i++)
			fw2.write(xh[i]+" ");
		fw2.write("\r\n");
		fw2.write("Xa=");
		for(int i=0;i<xt.length;i++)
			fw2.write(xt[i]+" ");
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
	
	public static void PSO1_Tourism(int[] y, int[] xa,int[] xh,int[] xt, double Fittest,int generationCount, long total_time,long T_net,String str) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO1");
	    f2.mkdir();
    	FileWriter fw = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO1\\Xa.txt",false);
    	for(int i=0;i<xa.length;i++)
			fw.write(String.valueOf(xa[i]+"\r\n"));
    	fw.close();
    	FileWriter fw4 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO1\\Xh.txt",false);
    	for(int i=0;i<xh.length;i++)
			fw4.write(String.valueOf(xh[i]+"\r\n"));
    	fw4.close();
    	FileWriter fw5 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO1\\Xt.txt",false);
    	for(int i=0;i<xt.length;i++)
			fw5.write(String.valueOf(xt[i]+"\r\n"));
    	fw5.close();
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO1\\Y.txt",false);
    	for(int i=0;i<y.length;i++)
			fw1.write(String.valueOf(y[i]+"\r\n"));
    	fw1.close();
		FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO1\\Result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			fw2.write(y[i]+" ");
		fw2.write("\r\n");
		fw2.write("Xa=");
		for(int i=0;i<xa.length;i++)
			fw2.write(xa[i]+" ");
		fw2.write("\r\n");
		fw2.write("Xh=");
		for(int i=0;i<xh.length;i++)
			fw2.write(xh[i]+" ");
		fw2.write("\r\n");
		fw2.write("Xa=");
		for(int i=0;i<xt.length;i++)
			fw2.write(xt[i]+" ");
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
	
	public static void PSO2_Tourism(int[] y, int[] xa,int[] xh,int[] xt, double Fittest,int generationCount, long total_time,long T_net,String str) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO2");
	    f2.mkdir();
    	FileWriter fw = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO2\\Xa.txt",false);
    	for(int i=0;i<xa.length;i++)
			fw.write(String.valueOf(xa[i]+"\r\n"));
    	fw.close();
    	FileWriter fw4 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO2\\Xh.txt",false);
    	for(int i=0;i<xh.length;i++)
			fw4.write(String.valueOf(xh[i]+"\r\n"));
    	fw4.close();
    	FileWriter fw5 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO2\\Xt.txt",false);
    	for(int i=0;i<xt.length;i++)
			fw5.write(String.valueOf(xt[i]+"\r\n"));
    	fw5.close();
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO2\\Y.txt",false);
    	for(int i=0;i<y.length;i++)
			fw1.write(String.valueOf(y[i]+"\r\n"));
    	fw1.close();
		FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO2\\Result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			fw2.write(y[i]+" ");
		fw2.write("\r\n");
		fw2.write("Xa=");
		for(int i=0;i<xa.length;i++)
			fw2.write(xa[i]+" ");
		fw2.write("\r\n");
		fw2.write("Xh=");
		for(int i=0;i<xh.length;i++)
			fw2.write(xh[i]+" ");
		fw2.write("\r\n");
		fw2.write("Xa=");
		for(int i=0;i<xt.length;i++)
			fw2.write(xt[i]+" ");
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
	
	public static void PSO_TS_Tourism(int[] y, int[] xa,int[] xh,int[] xt, double Fittest,int generationCount, long total_time,long T_net,String str) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO_TS");
	    f2.mkdir();
    	FileWriter fw = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO_TS\\Xa.txt",false);
    	for(int i=0;i<xa.length;i++)
			fw.write(String.valueOf(xa[i]+"\r\n"));
    	fw.close();
    	FileWriter fw4 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO_TS\\Xh.txt",false);
    	for(int i=0;i<xh.length;i++)
			fw4.write(String.valueOf(xh[i]+"\r\n"));
    	fw4.close();
    	FileWriter fw5 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO_TS\\Xt.txt",false);
    	for(int i=0;i<xt.length;i++)
			fw5.write(String.valueOf(xt[i]+"\r\n"));
    	fw5.close();
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO_TS\\Y.txt",false);
    	for(int i=0;i<y.length;i++)
			fw1.write(String.valueOf(y[i]+"\r\n"));
    	fw1.close();
		FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO_TS\\Result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			fw2.write(y[i]+" ");
		fw2.write("\r\n");
		fw2.write("Xa=");
		for(int i=0;i<xa.length;i++)
			fw2.write(xa[i]+" ");
		fw2.write("\r\n");
		fw2.write("Xh=");
		for(int i=0;i<xh.length;i++)
			fw2.write(xh[i]+" ");
		fw2.write("\r\n");
		fw2.write("Xa=");
		for(int i=0;i<xt.length;i++)
			fw2.write(xt[i]+" ");
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
	
	public static void Tourism(int[] y, int[] xa,int[] xh,int[] xt, double Fittest,int generationCount, long total_time,long T_net,String str) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path());
	    f2.mkdir();
    	FileWriter fw = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\X.txt",false);
    	for(int i=0;i<xa.length;i++)
			fw.write(String.valueOf(xa[i]+"\r\n"));
    	fw.close();
    	FileWriter fw4 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\Xh.txt",false);
    	for(int i=0;i<xh.length;i++)
			fw4.write(String.valueOf(xh[i]+"\r\n"));
    	fw4.close();
    	FileWriter fw5 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\Xt.txt",false);
    	for(int i=0;i<xt.length;i++)
			fw5.write(String.valueOf(xt[i]+"\r\n"));
    	fw5.close();
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\Y.txt",false);
    	for(int i=0;i<y.length;i++)
			fw1.write(String.valueOf(y[i]+"\r\n"));
    	fw1.close();
		FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\Result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			fw2.write(y[i]+" ");
		fw2.write("\r\n");
		fw2.write("Xa=");
		for(int i=0;i<xa.length;i++)
			fw2.write(xa[i]+" ");
		fw2.write("\r\n");
		fw2.write("Xh=");
		for(int i=0;i<xh.length;i++)
			fw2.write(xh[i]+" ");
		fw2.write("\r\n");
		fw2.write("Xa=");
		for(int i=0;i<xt.length;i++)
			fw2.write(xt[i]+" ");
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
	
	public static void CCPSO2_Tourism(int[] y, int[] xa,int[] xh,int[] xt, double Fittest,int generationCount, long total_time,long T_net) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\CCPSO2");
	    f2.mkdir();
    	FileWriter fw = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\CCPSO2\\Xa.txt",false);
    	for(int i=0;i<xa.length;i++)
			fw.write(String.valueOf(xa[i]+"\r\n"));
    	fw.close();
    	FileWriter fw4 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\CCPSO2\\Xh.txt",false);
    	for(int i=0;i<xh.length;i++)
			fw4.write(String.valueOf(xh[i]+"\r\n"));
    	fw4.close();
    	FileWriter fw5 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\CCPSO2\\Xt.txt",false);
    	for(int i=0;i<xt.length;i++)
			fw5.write(String.valueOf(xt[i]+"\r\n"));
    	fw5.close();
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\CCPSO2\\Y.txt",false);
    	for(int i=0;i<y.length;i++)
			fw1.write(String.valueOf(y[i]+"\r\n"));
    	fw1.close();
		FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\CCPSO2\\Result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			fw2.write(y[i]+" ");
		fw2.write("\r\n");
		fw2.write("Xa=");
		for(int i=0;i<xa.length;i++)
			fw2.write(xa[i]+" ");
		fw2.write("\r\n");
		fw2.write("Xh=");
		for(int i=0;i<xh.length;i++)
			fw2.write(xh[i]+" ");
		fw2.write("\r\n");
		fw2.write("Xa=");
		for(int i=0;i<xt.length;i++)
			fw2.write(xt[i]+" ");
		fw2.write("\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("Generation="+generationCount+"\r\n");
		fw2.write("執行時間 T_total_time="+total_time+ "ms"+"\r\n");
		fw2.write("執行時間扣除寫檔時間  T_net="+T_net+ "ms"+"\r\n");
		fw2.write("\r\n");
		fw2.close();
		 
	}
	
	public static void LR(int[][] y, int[][] xa,int[][] xh,int[][] xt, double Fittest,int generationCount, long time) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR");
	    f2.mkdir();
    	FileWriter fw = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR\\Xa.txt",false);
    	for(int i=0;i<xa.length;i++)
    		for(int j=0;j<xa[i].length;j++)
			fw.write(String.valueOf(xa[i][j]+"\r\n"));
    	fw.close();
    	FileWriter fw3 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR\\Xh.txt",false);
    	for(int i=0;i<xh.length;i++)
    		for(int j=0;j<xh[i].length;j++)
			fw3.write(String.valueOf(xh[i][j]+"\r\n"));
    	fw3.close();
    	FileWriter fw4 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR\\Xt.txt",false);
    	for(int i=0;i<xt.length;i++)
    		for(int j=0;j<xt[i].length;j++)
			fw4.write(String.valueOf(xt[i][j]+"\r\n"));
    	fw4.close();
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
		fw2.write("Xa=");
		for(int i=0;i<xa.length;i++)
			for(int j=0;j<xa[i].length;j++)
			fw2.write(xa[i][j]+" ");
		fw2.write("\r\n");
		fw2.write("Xh=");
		for(int i=0;i<xh.length;i++)
			for(int j=0;j<xh[i].length;j++)
			fw2.write(xh[i][j]+" ");
		fw2.write("\r\n");
		fw2.write("Xt=");
		for(int i=0;i<xt.length;i++)
			for(int j=0;j<xt[i].length;j++)
			fw2.write(xt[i][j]+" ");
		fw2.write("\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("Generation="+generationCount+"\r\n");
		fw2.write("執行時間="+time+ "ms"+"\r\n");
		fw2.write("\r\n");
		fw2.close();
	}
	
	public static void LR_XY_Lambda (int[][] y, int[][] xa, int[][] xh, int[][] xt, double Fittest,int generationCount, long time ) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path());
	    f2.mkdir();
	    File f3 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"LR_XY_Lambda");
	    f3.mkdir();
    	FileWriter fw = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"LR_XY_Lambda\\LR_Xa.txt",false);
    	for(int i=0;i<xa.length;i++)
    		for(int j=0;j<xa[i].length;j++)
			fw.write(String.valueOf(xa[i][j]+"\r\n"));
    	fw.close();
    	FileWriter fw3 =new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"LR_XY_Lambda\\LR_Xh.txt",false);
    	for(int i=0;i<xh.length;i++)
    		for(int j=0;j<xh[i].length;j++)
			fw3.write(String.valueOf(xh[i][j]+"\r\n"));
    	fw3.close();
    	FileWriter fw4 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"LR_XY_Lambda\\LR_Xt.txt",false);
    	for(int i=0;i<xt.length;i++)
    		for(int j=0;j<xt[i].length;j++)
			fw4.write(String.valueOf(xt[i][j]+"\r\n"));
    	fw4.close();
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
    /*	FileWriter fw6 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"LR_XY_Lambda\\Lambda1.txt",false);
    	for(int i=0;i<Lambda1.length;i++)
    			fw6.write(String.valueOf(Lambda1[i]+"\r\n"));
    	fw6.close();
    	FileWriter fw7 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"LR_XY_Lambda\\Lambda2.txt",false);
    			fw7.write(String.valueOf(Lambda2+"\r\n"));
    	fw7.close();
    	FileWriter fw5 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"LR_XY_Lambda\\Lambda3.txt",false);
    	for(int i=0;i<Lambda3.length;i++)
    		for(int j=0;j<Lambda3[i].length;j++)
    			fw5.write(String.valueOf(Lambda3[i][j]+"\r\n"));
    	fw5.close();*/
	}
	
	public static void LR_and_PSO1_Tourism(int[] y, int[] xa, int[] xh, int[] xt, double Fittest,int generationCount, long total_time,long T_net) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR_and_PSO1");
	    f2.mkdir();
	    FileWriter fw = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR_and_PSO1\\Xa.txt",false);
    	for(int i=0;i<xa.length;i++)
			fw.write(String.valueOf(xa[i]+"\r\n"));
    	fw.close();
    	FileWriter fw3 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR_and_PSO1\\Xh.txt",false);
    	for(int i=0;i<xh.length;i++)
			fw3.write(String.valueOf(xh[i]+"\r\n"));
    	fw3.close();
    	FileWriter fw4 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR_and_PSO1\\Xt.txt",false);
    	for(int i=0;i<xt.length;i++)
			fw4.write(String.valueOf(xt[i]+"\r\n"));
    	fw4.close();
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR_and_PSO1\\Y.txt",false);
    	for(int i=0;i<y.length;i++)
			fw1.write(String.valueOf(y[i]+"\r\n"));
    	fw1.close();
		FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR_and_PSO1\\Result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			fw2.write(y[i]+" ");
		fw2.write("\r\n");
		fw2.write("Xa=");
		for(int i=0;i<xa.length;i++)
			fw2.write(xa[i]+" ");
		fw2.write("\r\n");
		fw2.write("Xh=");
		for(int i=0;i<xh.length;i++)
			fw2.write(xh[i]+" ");
		fw2.write("\r\n");
		fw2.write("Xt=");
		for(int i=0;i<xt.length;i++)
			fw2.write(xt[i]+" ");
		fw2.write("\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("Generation="+generationCount+"\r\n");
		fw2.write("執行時間 T_total_time="+total_time+ "ms"+"\r\n");
		fw2.write("執行時間扣除寫檔時間  T_net="+T_net+ "ms"+"\r\n");
		fw2.write("\r\n");
		fw2.close();
	}
	
	public static void LR_and_PSO2_Tourism(int[] y, int[] xa, int[] xh, int[] xt, double Fittest,int generationCount, long total_time,long T_net) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR_and_PSO2");
	    f2.mkdir();
	    FileWriter fw = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR_and_PSO2\\Xa.txt",false);
    	for(int i=0;i<xa.length;i++)
			fw.write(String.valueOf(xa[i]+"\r\n"));
    	fw.close();
    	FileWriter fw3 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR_and_PSO2\\Xh.txt",false);
    	for(int i=0;i<xh.length;i++)
			fw3.write(String.valueOf(xh[i]+"\r\n"));
    	fw3.close();
    	FileWriter fw4 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR_and_PSO2\\Xt.txt",false);
    	for(int i=0;i<xt.length;i++)
			fw4.write(String.valueOf(xt[i]+"\r\n"));
    	fw4.close();
    	FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR_and_PSO2\\Y.txt",false);
    	for(int i=0;i<y.length;i++)
			fw1.write(String.valueOf(y[i]+"\r\n"));
    	fw1.close();
		FileWriter fw2 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR_and_PSO2\\Result.txt",false);
		fw2.write("Y=");
		for(int i=0;i<y.length;i++)
			fw2.write(y[i]+" ");
		fw2.write("\r\n");
		fw2.write("Xa=");
		for(int i=0;i<xa.length;i++)
			fw2.write(xa[i]+" ");
		fw2.write("\r\n");
		fw2.write("Xh=");
		for(int i=0;i<xh.length;i++)
			fw2.write(xh[i]+" ");
		fw2.write("\r\n");
		fw2.write("Xt=");
		for(int i=0;i<xt.length;i++)
			fw2.write(xt[i]+" ");
		fw2.write("\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("Generation="+generationCount+"\r\n");
		fw2.write("執行時間 T_total_time="+total_time+ "ms"+"\r\n");
		fw2.write("執行時間扣除寫檔時間  T_net="+T_net+ "ms"+"\r\n");
		fw2.write("\r\n");
		fw2.close();
	}
	
	public static void LRPSO_Tourism(int[][] y, int[][] xa,int[][] xh,int[][] xt, double Fittest,int generationCount, long total_time,long T_net) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LRPSO");
	    f2.mkdir();
    	FileWriter fw = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LRPSO\\Xa.txt",false);
    	for(int i=0;i<xa.length;i++)
    		for(int j=0;j<xa[i].length;j++)
			fw.write(String.valueOf(xa[i][j]+"\r\n"));
    	fw.close();
    	FileWriter fw3 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LRPSO\\Xh.txt",false);
    	for(int i=0;i<xh.length;i++)
    		for(int j=0;j<xh[i].length;j++)
			fw3.write(String.valueOf(xh[i][j]+"\r\n"));
    	fw3.close();
    	FileWriter fw4 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LRPSO\\Xt.txt",false);
    	for(int i=0;i<xt.length;i++)
    		for(int j=0;j<xt[i].length;j++)
			fw4.write(String.valueOf(xt[i][j]+"\r\n"));
    	fw4.close();
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
		fw2.write("Xa=");
		for(int i=0;i<xa.length;i++)
			for(int j=0;j<xa[i].length;j++)
			fw2.write(xa[i][j]+" ");
		fw2.write("\r\n");
		fw2.write("Xh=");
		for(int i=0;i<xh.length;i++)
			for(int j=0;j<xh[i].length;j++)
			fw2.write(xh[i][j]+" ");
		fw2.write("\r\n");
		fw2.write("Xt=");
		for(int i=0;i<xt.length;i++)
			for(int j=0;j<xt[i].length;j++)
			fw2.write(xt[i][j]+" ");
		fw2.write("\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("Generation="+generationCount+"\r\n");
		fw2.write("執行時間 T_total_time="+total_time+ "ms"+"\r\n");
		fw2.write("執行時間扣除寫檔時間  T_net="+T_net+ "ms"+"\r\n");
		fw2.write("\r\n");
		fw2.close();
	}
	
	public static void ALPSO_Tourism(int[][] y, int[][] xa,int[][] xh,int[][] xt, double Fittest,int generationCount, long total_time,long T_net) throws IOException  
	{	
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
	    f1.mkdir();
	    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\ALPSO");
	    f2.mkdir();
    	FileWriter fw = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\ALPSO\\Xa.txt",false);
    	for(int i=0;i<xa.length;i++)
    		for(int j=0;j<xa[i].length;j++)
			fw.write(String.valueOf(xa[i][j]+"\r\n"));
    	fw.close();
    	FileWriter fw3 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\ALPSO\\Xh.txt",false);
    	for(int i=0;i<xh.length;i++)
    		for(int j=0;j<xh[i].length;j++)
			fw3.write(String.valueOf(xh[i][j]+"\r\n"));
    	fw3.close();
    	FileWriter fw4 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\ALPSO\\Xt.txt",false);
    	for(int i=0;i<xt.length;i++)
    		for(int j=0;j<xt[i].length;j++)
			fw4.write(String.valueOf(xt[i][j]+"\r\n"));
    	fw4.close();
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
		fw2.write("Xa=");
		for(int i=0;i<xa.length;i++)
			for(int j=0;j<xa[i].length;j++)
			fw2.write(xa[i][j]+" ");
		fw2.write("\r\n");
		fw2.write("Xh=");
		for(int i=0;i<xh.length;i++)
			for(int j=0;j<xh[i].length;j++)
			fw2.write(xh[i][j]+" ");
		fw2.write("\r\n");
		fw2.write("Xt=");
		for(int i=0;i<xt.length;i++)
			for(int j=0;j<xt[i].length;j++)
			fw2.write(xt[i][j]+" ");
		fw2.write("\r\n");
		fw2.write("Fittest="+Fittest+"\r\n");
		fw2.write("Generation="+generationCount+"\r\n");
		fw2.write("執行時間 T_total_time="+total_time+ "ms"+"\r\n");
		fw2.write("執行時間扣除寫檔時間  T_net="+T_net+ "ms"+"\r\n");
		fw2.write("\r\n");
		fw2.close();
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
