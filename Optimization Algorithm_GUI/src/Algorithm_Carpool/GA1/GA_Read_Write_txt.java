package Algorithm_Carpool.GA1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import GUI.I_Set_Paths_for_Current_Simulation_Example;


public class GA_Read_Write_txt extends GA1 {
	private static double xxx1;

	private static double xxx2;
	private static int Iteration;
	private static int Iteration_Mode;
	private static double initialPopulationRate;
	private static double crossoverRate;
	private static double mutationRate;
	private static int tournamentSize;
	private static int populationSize;
     private static double  threshold;
     private static int Execution_Mode;
     private static int Print_Mode;
     private static int SA_Mode;
     private static int Write_Mode;
     private static double T;
     private static double Factor_T;
     
     private static int R1;
 	private static int R2;
 	private static int R3;
 	private static int R4;
 	private static int R5;
	public static void read_GA_Parameters()throws IOException{
		String[][] GAP=new 	String[14][2];
		String line;
		int d=0;
		        FileReader GAPfr = new FileReader(I_Set_Paths_for_Current_Simulation_Example.path()+"\\GA_Parameter\\GA1\\GA_Parameter.txt");
		        BufferedReader GAPbr = new BufferedReader(GAPfr);
		        while ((line=GAPbr.readLine())!=null ) {
		            GAP[d++]=line.split("=");
		        }
		  
		        GAPfr.close();
		 
		        String[] GAR=new 	String[5];
				String line1;
				FileReader GARfr = new FileReader(I_Set_Paths_for_Current_Simulation_Example.path()+"\\GA_Parameter\\GA1\\Penalty.txt");
		        BufferedReader GARbr = new BufferedReader(GARfr);
		        while ((line=GARbr.readLine())!=null ) {
		            GAR=line.split(" ");
		        }
		  
		        GARfr.close();
		        Iteration=Integer.parseInt(GAP[0][1]);
		        Iteration_Mode=Integer.parseInt(GAP[1][1]);
		        initialPopulationRate=Double.parseDouble(GAP[2][1]);
		        crossoverRate=Double.parseDouble(GAP[3][1]);
		        mutationRate=Double.parseDouble(GAP[4][1]);
		        tournamentSize=Integer.parseInt(GAP[5][1]);
		        populationSize =Integer.parseInt(GAP[6][1]);
		        threshold =Double.parseDouble(GAP[7][1]);
		        Execution_Mode=Integer.parseInt(GAP[8][1]);
		        Print_Mode=Integer.parseInt(GAP[9][1]);
		        SA_Mode=Integer.parseInt(GAP[10][1]);
		        Write_Mode=Integer.parseInt(GAP[11][1]);
		        T=Double.parseDouble(GAP[12][1]);
		        Factor_T=Double.parseDouble(GAP[13][1]);
		        
		        R1=Integer.parseInt(GAR[0]);
		        R2=Integer.parseInt(GAR[1]);
		        R3=Integer.parseInt(GAR[2]);
		        R4=Integer.parseInt(GAR[3]);
		        R5=Integer.parseInt(GAR[4]);
		        
		       // System.out.println(Execution_Mode);
	}
	public static double read_from_evolution_log()
	{	
		try {
			BufferedReader in = new BufferedReader(new FileReader(I_Set_Paths_for_Current_Simulation_Example.path()+"\\GA_Parameter\\GA1\\evolution_log.txt"));
					String str;String [] y = null;
				//	double xxx1;
			while ((str = in.readLine()) != null) { // readLine()依序讀取檔案內的一行文字
			y=str.split(" ");		
			}
			in.close();
			xxx1=Double.parseDouble(y[i1++]);} catch (Exception ext) {
		}
		return xxx1;
	}

	public static void write_to_evolution_log(StringBuilder sb) 
	{
		try {
			FileWriter fw = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path()+"\\GA_Parameter\\GA1\\evolution_log.txt", false);
			PrintWriter pw = new PrintWriter(fw);
			pw.print(sb);
			pw.flush();
			pw.close();
		} catch (Exception ext) {
		}
	}
	public static double read_from_evolution_log1()
	  {
	  	try {
	  		BufferedReader in = new BufferedReader(new FileReader(I_Set_Paths_for_Current_Simulation_Example.path()+"\\GA_Parameter\\GA1\\evolution_log1.txt"));
	  				String str;String [] y = null;
	  			//	double xxx1;
	  		while ((str = in.readLine()) != null) { // readLine()依序讀取檔案內的一行文字
	  		y=str.split(" ");
	  				
	  		}
	  		in.close();
	  		xxx2=Double.parseDouble(y[i2++]);} catch (Exception ext) {
	  	}
	  	return xxx2;
	  }
	public static void write_to_evolution_log1(StringBuilder sb) 
	  {
	  	try {
	  		FileWriter fw = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path()+"\\GA_Parameter\\GA1\\evolution_log1.txt", false);
	  		PrintWriter pw = new PrintWriter(fw);
	  		pw.print(sb);
	  		pw.flush();
	  		pw.close();
	  	} catch (Exception ext) {
	  	}
	  }

	public static int  Iteration(){
		return Iteration;
	}
	public static int  Iteration_Mode(){
		return Iteration_Mode;
	}
	
	public static double initialPopulationRate(){
		return initialPopulationRate;
	}
	public static double crossoverRate(){
		return crossoverRate;
	}
	public static double mutationRate(){
		return mutationRate;
	}
	public static int  tournamentSize(){
		return tournamentSize;
	}
	public static int  populationSize(){
		return populationSize;
	}
	public static double threshold(){
		return threshold;
	}
	public static int  Execution_Mode(){
		return Execution_Mode;
	}
	public static int  Print_Mode(){
		return Print_Mode;
	}
	public static int SA_Mode(){
		return SA_Mode;
	}
	public static int Write_Mode(){
		return Write_Mode;
	}
	public static double T(){
		return T;
	}
	public static double Factor_T(){
		return Factor_T;
	}
	public static int R1(){
		return R1;
	}
	public static int R2(){
		return R2;
	}
	public static int R3(){
		return R3;
	}
	public static int R4(){
		return R4;
	}
	public static int R5(){
		return R5;
	}
}
