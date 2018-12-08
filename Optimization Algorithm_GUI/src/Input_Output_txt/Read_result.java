package Input_Output_txt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import GUI.I_Set_Paths_for_Current_Simulation_Example;


public class Read_result {

	private static String CPLEX_X;
	private static String CPLEX_Y;
	private static String CPLEX_Fittest;
	private static String CPLEX_time;

	private static String GA1_X;
	private static String GA1_Y;
	private static String GA1_Fittest;
	private static String GA1_Generation;
	private static String GA1_time;
	
	private static String GA2_X;
	private static String GA2_Y;
	private static String GA2_Fittest;
	private static String GA2_Generation;
	private static String GA2_time;
	
	private static String PSO1_X;
	private static String PSO1_Y;
	private static String PSO1_Fittest;
	private static String PSO1_Generation;
	private static String PSO1_time;
	
	private static String PSO2_X;
	private static String PSO2_Y;
	private static String PSO2_Fittest;
	private static String PSO2_Generation;
	private static String PSO2_time;
	
	private static String PSO3_X;
	private static String PSO3_Y;
	private static String PSO3_Fittest;
	private static String PSO3_Generation;
	private static String PSO3_time;
	
	private static String PSO4_X;
	private static String PSO4_Y;
	private static String PSO4_Fittest;
	private static String PSO4_Generation;
	private static String PSO4_time;
	
	private static String APSO1_X;
	private static String APSO1_Y;
	private static String APSO1_Fittest;
	private static String APSO1_Generation;
	private static String APSO1_time;
	
	private static String APSO2_X;
	private static String APSO2_Y;
	private static String APSO2_Fittest;
	private static String APSO2_Generation;
	private static String APSO2_time;
	
	private static String ALPSO_X;
	private static String ALPSO_Y;
	private static String ALPSO_Fittest;
	private static String ALPSO_Generation;
	private static String ALPSO_time;
	
	public static void read_CPLEX()throws IOException{

		String[][] CPLEX=new 	String[11][2];
		String line;
		int d=0;
		        FileReader CPLEXfr = new FileReader("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\CPLEX\\result.txt");
		        BufferedReader CPLEXbr = new BufferedReader(CPLEXfr);
		        while ((line=CPLEXbr.readLine())!=null ) {
		            CPLEX[d++]=line.split("=");
		        } 
		        CPLEXfr.close();
		        CPLEX_Y=CPLEX[0][1];
		        CPLEX_X=CPLEX[1][1];
		        CPLEX_Fittest=CPLEX[2][1];
		        CPLEX_time=CPLEX[3][1];
	}
	
	public static void read_GA1()throws IOException{

		String[][] GA1=new 	String[11][2];
		String line;
		int d=0;
		        FileReader GA1fr = new FileReader("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\GA1\\result.txt");
		        BufferedReader GA1br = new BufferedReader(GA1fr);
		        while ((line=GA1br.readLine())!=null ) {
		        	GA1[d++]=line.split("=");
		        } 
		        GA1fr.close();
		        GA1_Y=GA1[0][1];
		        GA1_X=GA1[1][1];
		        GA1_Fittest=GA1[2][1];
		        GA1_Generation=GA1[3][1];
		        GA1_time=GA1[4][1];
	}
	
	public static void read_GA2()throws IOException{
	
		String[][] GA2=new 	String[11][2];
		String line;
		int d=0;
		        FileReader GA2fr = new FileReader("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\GA2\\result.txt");
		        BufferedReader GA2br = new BufferedReader(GA2fr);
		        while ((line=GA2br.readLine())!=null ) {
		        	GA2[d++]=line.split("=");
		        } 
		        GA2fr.close();
		        GA2_Y=GA2[0][1];
		        GA2_X=GA2[1][1];
		        GA2_Fittest=GA2[2][1];
		        GA2_Generation=GA2[3][1];
		        GA2_time=GA2[4][1];
	}
	public static void read_PSO1()throws IOException{

		String[][] PSO1=new 	String[11][2];
		String line;
		int d=0;
		        FileReader PSO1fr = new FileReader("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO1\\result.txt");
		        BufferedReader PSO1br = new BufferedReader(PSO1fr);
		        while ((line=PSO1br.readLine())!=null ) {
		        	PSO1[d++]=line.split("=");
		        } 
		        PSO1fr.close();
		        PSO1_Y=PSO1[0][1];
		        PSO1_X=PSO1[1][1];
		        PSO1_Fittest=PSO1[2][1];
		        PSO1_Generation=PSO1[3][1];
		        PSO1_time=PSO1[4][1];
	}
	
	public static void read_PSO2()throws IOException{

		String[][] PSO2=new 	String[11][2];
		String line;
		int d=0;
		        FileReader PSO2fr = new FileReader("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO2\\result.txt");
		        BufferedReader PSO2br = new BufferedReader(PSO2fr);
		        while ((line=PSO2br.readLine())!=null ) {
		        	PSO2[d++]=line.split("=");
		        } 
		        PSO2fr.close();
		        PSO2_Y=PSO2[0][1];
		        PSO2_X=PSO2[1][1];
		        PSO2_Fittest=PSO2[2][1];
		        PSO2_Generation=PSO2[3][1];
		        PSO2_time=PSO2[4][1];
	}
	public static void read_PSO3()throws IOException{

		String[][] PSO3=new 	String[11][2];
		String line;
		int d=0;
		        FileReader PSO3fr = new FileReader("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO3\\result.txt");
		        BufferedReader PSO3br = new BufferedReader(PSO3fr);
		        while ((line=PSO3br.readLine())!=null ) {
		        	PSO3[d++]=line.split("=");
		        } 
		        PSO3fr.close();
		        PSO3_Y=PSO3[0][1];
		        PSO3_X=PSO3[1][1];
		        PSO3_Fittest=PSO3[2][1];
		        PSO3_Generation=PSO3[3][1];
		        PSO3_time=PSO3[4][1];
	}
	public static void read_PSO4()throws IOException{

		String[][] PSO4=new 	String[11][2];
		String line;
		int d=0;
		        FileReader PSO4fr = new FileReader("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\PSO4\\result.txt");
		        BufferedReader PSO4br = new BufferedReader(PSO4fr);
		        while ((line=PSO4br.readLine())!=null ) {
		        	PSO4[d++]=line.split("=");
		        } 
		        PSO4fr.close();
		        PSO4_Y=PSO4[0][1];
		        PSO4_X=PSO4[1][1];
		        PSO4_Fittest=PSO4[2][1];
		        PSO4_Generation=PSO4[3][1];
		        PSO4_time=PSO4[4][1];
	}
	public static void read_APSO1()throws IOException{

		String[][] APSO1=new 	String[11][2];
		String line;
		int d=0;
		        FileReader APSO1fr = new FileReader("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\APSO1\\result.txt");
		        BufferedReader APSO1br = new BufferedReader(APSO1fr);
		        while ((line=APSO1br.readLine())!=null ) {
		        	APSO1[d++]=line.split("=");
		        } 
		        APSO1fr.close();
		        APSO1_Y=APSO1[0][1];
		        APSO1_X=APSO1[1][1];
		        APSO1_Fittest=APSO1[2][1];
		        APSO1_Generation=APSO1[3][1];
		        APSO1_time=APSO1[4][1];
	}
	public static void read_APSO2()throws IOException{

		String[][] APSO2=new 	String[11][2];
		String line;
		int d=0;
		        FileReader APSO2fr = new FileReader("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\APSO2\\result.txt");
		        BufferedReader APSO2br = new BufferedReader(APSO2fr);
		        while ((line=APSO2br.readLine())!=null ) {
		        	APSO2[d++]=line.split("=");
		        } 
		        APSO2fr.close();
		        APSO2_Y=APSO2[0][1];
		        APSO2_X=APSO2[1][1];
		        APSO2_Fittest=APSO2[2][1];
		        APSO2_Generation=APSO2[3][1];
		        APSO2_time=APSO2[4][1];
	}
	public static void read_ALPSO()throws IOException{

		String[][] LAPSO=new 	String[11][2];
		String line;
		int d=0;
		        FileReader LAPSOfr = new FileReader("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\ALPSO\\result.txt");
		        BufferedReader LAPSObr = new BufferedReader(LAPSOfr);
		        while ((line=LAPSObr.readLine())!=null ) {
		        	LAPSO[d++]=line.split("=");
		        } 
		        LAPSOfr.close();
		        ALPSO_Y=LAPSO[0][1];
		        ALPSO_X=LAPSO[1][1];
		        ALPSO_Fittest=LAPSO[2][1];
		        ALPSO_Generation=LAPSO[3][1];
		        ALPSO_time=LAPSO[4][1];
	}
	
	public static String getCPLEX_X() {
		return CPLEX_X;
	}
	public static String getCPLEX_Y() {
		return CPLEX_Y;
	}
	public static String getCPLEX_Fittest() {
		return CPLEX_Fittest;
	}
	public static String getCPLEX_time() {
		return CPLEX_time;
	}
	public static String getGA1_X() {
		return GA1_X;
	}
	public static String getGA1_Y() {
		return GA1_Y;
	}
	public static String getGA1_Fittest() {
		return GA1_Fittest;
	}
	public static String getGA1_Generation() {
		return GA1_Generation;
	}
	public static String getGA1_time() {
		return GA1_time;
	}
	public static String getGA2_X() {
		return GA2_X;
	}
	public static String getGA2_Y() {
		return GA2_Y;
	}
	public static String getGA2_Fittest() {
		return GA2_Fittest;
	}
	public static String getGA2_Generation() {
		return GA2_Generation;
	}
	public static String getGA2_time() {
		return GA2_time;
	}
	public static String getPSO1_X() {
		return PSO1_X;
	}
	public static String getPSO1_Y() {
		return PSO1_Y;
	}
	public static String getPSO1_Fittest() {
		return PSO1_Fittest;
	}
	public static String getPSO1_Generation() {
		return PSO1_Generation;
	}
	public static String getPSO1_time() {
		return PSO1_time;
	}
	public static String getPSO2_X() {
		return PSO2_X;
	}
	public static String getPSO2_Y() {
		return PSO2_Y;
	}
	public static String getPSO2_Fittest() {
		return PSO2_Fittest;
	}
	public static String getPSO2_Generation() {
		return PSO2_Generation;
	}
	public static String getPSO2_time() {
		return PSO2_time;
	}
	public static String getPSO3_X() {
		return PSO3_X;
	}
	public static String getPSO3_Y() {
		return PSO3_Y;
	}
	public static String getPSO3_Fittest() {
		return PSO3_Fittest;
	}
	public static String getPSO3_Generation() {
		return PSO3_Generation;
	}
	public static String getPSO3_time() {
		return PSO3_time;
	}
	public static String getPSO4_X() {
		return PSO4_X;
	}
	public static String getPSO4_Y() {
		return PSO4_Y;
	}
	public static String getPSO4_Fittest() {
		return PSO4_Fittest;
	}
	public static String getPSO4_Generation() {
		return PSO4_Generation;
	}
	public static String getPSO4_time() {
		return PSO4_time;
	}
	public static String getAPSO1_X() {
		return APSO1_X;
	}
	public static String getAPSO1_Y() {
		return APSO1_Y;
	}
	public static String getAPSO1_Fittest() {
		return APSO1_Fittest;
	}
	public static String getAPSO1_Generation() {
		return APSO1_Generation;
	}
	public static String getAPSO1_time() {
		return APSO1_time;
	}
	public static String getAPSO2_X() {
		return APSO2_X;
	}
	public static String getAPSO2_Y() {
		return APSO2_Y;
	}
	public static String getAPSO2_Fittest() {
		return APSO2_Fittest;
	}
	public static String getAPSO2_Generation() {
		return APSO2_Generation;
	}
	public static String getAPSO2_time() {
		return APSO2_time;
	}
	public static String getALPSO_X() {
		return ALPSO_X;
	}
	public static String getALPSO_Y() {
		return ALPSO_Y;
	}
	public static String getALPSO_Fittest() {
		return ALPSO_Fittest;
	}
	public static String getALPSO_Generation() {
		return ALPSO_Generation;
	}
	public static String getALPSO_time() {
		return ALPSO_time;
	}
}
