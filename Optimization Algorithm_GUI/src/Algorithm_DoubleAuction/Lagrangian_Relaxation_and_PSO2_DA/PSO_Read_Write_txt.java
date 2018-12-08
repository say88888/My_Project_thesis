package Algorithm_DoubleAuction.Lagrangian_Relaxation_and_PSO2_DA;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Random;

import GUI.I_Set_Paths_for_Current_Simulation_Example;

public class PSO_Read_Write_txt extends Double_Auction_LR_and_PSO2{
	private static int xxx1;

	private static double xxx2;
	private static int Iteration;
	private static int Iteration_Mode;
	private static int populationSize;
	private static double w;
	private static double c1;
	private static double c2;
	private static int Vmax;
	private static int Execution_Mode;
	private static int Print_Mode;
	private static int Write_Mode;
	private static double threshold;
	private static double PSO_lamda;
	
	private static String[][] Parameter=new String[12][2];
 
	//static String s ;
	public static void read_PSO_Parameter( ) {
		 
		String str;
		int d=0;
	 	try {
			FileReader PBr = new FileReader(I_Set_Paths_for_Current_Simulation_Example.path()+"\\PSO_Parameter\\LR_and_PSO2\\PSO_Parameter.txt");
			BufferedReader br = new BufferedReader(PBr);
			while ((str = br.readLine()) != null) { //每次讀一行 
				Parameter[d++]=str.split("="); //將此行以空白(white space)切成字串陣列, 存入 Vector暫存 
		}
		br.close(); //關檔
		} catch (Exception e) {
		e.printStackTrace();
		}
	  

	 	Iteration=Integer.parseInt(Parameter[0][1]);
	 	Iteration_Mode=Integer.parseInt(Parameter[1][1]);
		populationSize=Integer.parseInt(Parameter[2][1]);
		w=Double.parseDouble(Parameter[3][1]);
		c1=Double.parseDouble(Parameter[4][1]);
		c2=Double.parseDouble(Parameter[5][1]);
		Vmax=Integer.parseInt(Parameter[6][1]);
		Execution_Mode=Integer.parseInt(Parameter[7][1]);
		Print_Mode=Integer.parseInt(Parameter[8][1]);
		Write_Mode=Integer.parseInt(Parameter[9][1]);
		threshold=Double.parseDouble(Parameter[10][1]);
		PSO_lamda=Double.parseDouble(Parameter[11][1]);
	 
	}
	public static int read_from_evolution_log()
	{ 
		try {
			BufferedReader in = new BufferedReader(new FileReader(I_Set_Paths_for_Current_Simulation_Example.path()+"\\PSO_Parameter\\LR_and_PSO2\\evolution_log.txt"));
					String str;String [] y = null;
				//	double xxx1;
			while ((str = in.readLine()) != null) { // readLine()依序讀取檔案內的一行文字
			y=str.split(" ");		
			}
			in.close();
			xxx1=Integer.parseInt(y[i1++]);} catch (Exception ext) {
		}
		return xxx1;
	}

	public static void write_to_evolution_log(StringBuilder sb) 
	{
		try {
			if(GUI.main.getmethod()!=2){
			FileWriter fw = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path()+"\\PSO_Parameter\\LR_and_PSO2\\evolution_log.txt", false);
			PrintWriter pw = new PrintWriter(fw);
			pw.print(sb);
			pw.flush();
			pw.close();
			 fw.close();
			}else{
				File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
			    f1.mkdir();
			    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR_and_PSO2_Batch");
			    f2.mkdir();
			    File f3 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR_and_PSO2_Batch\\LR_and_PSO2_Batch"+n);
			    f3.mkdir();
				FileWriter fw = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR_and_PSO2_Batch\\LR_and_PSO2_Batch"+n+"\\evolution_log.txt", false);
				PrintWriter pw = new PrintWriter(fw);
				pw.print(sb);
				pw.flush();
				pw.close();
				 fw.close();
			}
			 
		} catch (Exception ext) {
		}
	}
	public static double read_from_evolution_log1()
	  { 
	  	try {
	  		BufferedReader in = new BufferedReader(new FileReader(I_Set_Paths_for_Current_Simulation_Example.path()+"\\PSO_Parameter\\LR_and_PSO2\\evolution_log1.txt"));
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
	  		if(GUI.main.getmethod()!=2){
				FileWriter fw = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path()+"\\PSO_Parameter\\LR_and_PSO2\\evolution_log1.txt", false);
				PrintWriter pw = new PrintWriter(fw);
				pw.print(sb);
				pw.flush();
				pw.close();
				 fw.close();
				}else{
					File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
				    f1.mkdir();
				    File f2 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR_and_PSO2_Batch");
				    f2.mkdir();
				    File f3 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR_and_PSO2_Batch\\LR_and_PSO2_Batch"+n);
				    f3.mkdir();
					FileWriter fw = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\LR_and_PSO2_Batch\\LR_and_PSO2_Batch"+n+"\\evolution_log1.txt", false);
					PrintWriter pw = new PrintWriter(fw);
					pw.print(sb);
					pw.flush();
					pw.close();
					 fw.close();
				}
	  	} catch (Exception ext) {
	  	}
	  }
	public static int random_generate_or_read(int Execution_Mode) 
	{
	int xxx1; 
	if (Execution_Mode == 0)
	{Random ran=new Random();
	xxx1=ran.nextInt(2);

	 //s+=xxx1+" ";
	
//	PSO_Read_Write_txt.write_to_evolution_log(sb);
	//write_to_evolution_log(sb);
	if(Write_Mode==0){
		long totalstartTime = System.currentTimeMillis();
		sb.append(xxx1 + " ");
		write_to_evolution_log(sb);
		long totalendTime = System.currentTimeMillis();
		time_write_to_TXT+=(totalendTime-totalstartTime);
		}
	return xxx1;
	}
	else
	{
	return read_from_evolution_log();
	}
	}
	  public static double random_generate_or_read1(int Execution_Mode) 
	  {
	  double xxx1; 
	  if (Execution_Mode == 0)
	  {
	  xxx1=Math.random();
	 
	  //write_to_evolution_log1(sb1);
	  if(Write_Mode==0){
			long totalstartTime = System.currentTimeMillis();
			 sb1.append(xxx1 + " ");
			write_to_evolution_log1(sb1);
			long totalendTime = System.currentTimeMillis();
			time_write_to_TXT+=(totalendTime-totalstartTime);
			}
	  return xxx1;
	  }
	  else
	  {
	  return read_from_evolution_log1();
	  }
	  }
	  public static double random_generate_or_read2(int Execution_Mode) 
	  {
	  double xxx1; 
	  if (Execution_Mode == 0)
	  {
	  xxx1=Math.random()*(Vmax-(-Vmax))+(-Vmax);
	  
	  //write_to_evolution_log1(sb1);
	  if(Write_Mode==0){
			long totalstartTime = System.currentTimeMillis();
			sb1.append(xxx1 + " ");
			write_to_evolution_log1(sb1);
			long totalendTime = System.currentTimeMillis();
			time_write_to_TXT+=(totalendTime-totalstartTime);
			}
	  return xxx1;
	  }
	  else
	  {
	  return read_from_evolution_log1();
	  }
	  }
	  public static int Iteration() {
			return Iteration;
	}
	public static int Iteration_Mode(){
			return Iteration_Mode;
	}
	public static int populationSize(){
		return populationSize;
	}
	public static double w(){
		return w;
	}
	public static double c1(){
		return c1;
	}
	public static double c2(){
		return c2;
	}
	public static int Vmax(){
		return Vmax;
	}
	public static int Execution_Mode(){
		return Execution_Mode;
	}
	public static int Print_Mode(){
		return Print_Mode;
	}
	public static int Write_Mode(){
		return Write_Mode;
	}
	public static double threshold(){
		return threshold;
	}
	public static double PSO_lamda(){
		return PSO_lamda;
	}
	 
	
}
