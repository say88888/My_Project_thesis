package Algorithm_Carpool.CC_CLPSO2_AB_2Si_ApproachII;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import GUI.I_Set_Paths_for_Current_Simulation_Example;
import GUI.GUI_Carpool.X_Select_Algorithm_Type_to_Solve_the_Problem;

public class PSO_Read_Write_txt extends CC_CLPSO2_AB_2Si_ApproachII{
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
	private static double Pc;
	private static String[][] Parameter = new String[13][2];

	public static void read_PSO_Parameter() {

		String str;
		int d = 0;
		try {
			FileReader PBr = new FileReader(I_Set_Paths_for_Current_Simulation_Example.path()+"\\PSO_Parameter\\"+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\PSO_Parameter.txt");
			BufferedReader br = new BufferedReader(PBr);
			while ((str = br.readLine()) != null) { // 每次讀一行
				Parameter[d++] = str.split("="); // 將此行以空白(white space)切成字串陣列,
													// 存入 Vector暫存
			}
			br.close(); // 關檔
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
		Pc=Double.parseDouble(Parameter[12][1]);
	}

	public static int read_from_evolution_log() {
		try {
			BufferedReader in = new BufferedReader(new FileReader(I_Set_Paths_for_Current_Simulation_Example.path()+ "\\PSO_Parameter\\"+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\evolution_log.txt"));
			String str;
			String[] y = null;
			// double xxx1;
			while ((str = in.readLine()) != null) { // readLine()依序讀取檔案內的一行文字
				y = str.split(" ");
			}
			in.close();
			xxx1 = Integer.parseInt(y[i1++]);
		} catch (Exception ext) {
		}
		return xxx1;
	}

	public static void write_to_evolution_log(StringBuilder sb) {
		try {
			if (GUI.main.getmethod() != 2) {
				FileWriter fw = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path()	+ "\\PSO_Parameter\\"+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\evolution_log.txt",
						false);
				PrintWriter pw = new PrintWriter(fw);
				pw.print(sb);
				pw.flush();
				pw.close();
				fw.close();
			} else {
				File f1 = new File("output\\"+ I_Set_Paths_for_Current_Simulation_Example.filename());
				f1.mkdir();
				File f2 = new File("output\\"+ I_Set_Paths_for_Current_Simulation_Example.filename()+ "\\"+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"_Batch");
				f2.mkdir();
				File f3 = new File("output\\"+ I_Set_Paths_for_Current_Simulation_Example.filename()+ "\\"+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"_Batch\\"+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"_Batch" + n);
				f3.mkdir();
				FileWriter fw = new FileWriter("output\\"+ I_Set_Paths_for_Current_Simulation_Example.filename()+ "\\"+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"_Batch\\"+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"_Batch" + n	+ "\\evolution_log.txt", false);
				PrintWriter pw = new PrintWriter(fw);
				pw.print(sb);
				pw.flush();
				pw.close();
				fw.close();
			}

		} catch (Exception ext) {
		}
	}

	public static double read_from_evolution_log1() {
		try {
			BufferedReader in = new BufferedReader(new FileReader(I_Set_Paths_for_Current_Simulation_Example.path()+ "\\PSO_Parameter\\"+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\evolution_log1.txt"));
			String str;
			String[] y = null;
			// double xxx1;
			while ((str = in.readLine()) != null) { // readLine()依序讀取檔案內的一行文字
				y = str.split(" ");
			}
			in.close();
			xxx2 = Double.parseDouble(y[i2++]);
		} catch (Exception ext) {
		}
		return xxx2;
	}

	public static void write_to_evolution_log1(StringBuilder sb) {
		try {
			if (GUI.main.getmethod() != 2) {
				FileWriter fw = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path()	+ "\\PSO_Parameter\\"+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\evolution_log1.txt",	false);
				PrintWriter pw = new PrintWriter(fw);
				pw.print(sb);
				pw.flush();
				pw.close();
				fw.close();
			} else {
				File f1 = new File("output\\"+ I_Set_Paths_for_Current_Simulation_Example.filename());
				f1.mkdir();
				File f2 = new File("output\\"+ I_Set_Paths_for_Current_Simulation_Example.filename()+ "\\"+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"_Batch");
				f2.mkdir();
				File f3 = new File("output\\"+ I_Set_Paths_for_Current_Simulation_Example.filename()+ "\\"+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"_Batch\\"+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"_Batch" + n);
				f3.mkdir();
				FileWriter fw = new FileWriter("output\\"+ I_Set_Paths_for_Current_Simulation_Example.filename()+ "\\"+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"_Batch\\"+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"_Batch" + n	+ "\\evolution_log1.txt", false);
				PrintWriter pw = new PrintWriter(fw);
				pw.print(sb);
				pw.flush();
				pw.close();
				fw.close();
			}
		} catch (Exception ext) {
		}
	}

	public static List<List<Integer>> read_from_evolution_log2() {
		try {
			BufferedReader in = new BufferedReader(new FileReader(I_Set_Paths_for_Current_Simulation_Example.path()+ "\\PSO_Parameter\\"+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\evolution_log2.txt"));
			String str;
			String[] y = null;
			// double xxx1;
			 
			while ((str = in.readLine()) != null) { // readLine()依序讀取檔案內的一行文字
				List<Integer> n1 = new ArrayList<Integer>();
				String tempArray[]=str.split(" ");
				for(int i=0;i<tempArray.length;i++)
					
					n1.add( Integer.parseInt(tempArray[i]));
				
				n3.add(n1);
				 
			}
			in.close();
			 
		
		} catch (Exception ext) {
		}
		 return n3;
	}

	public static void write_to_evolution_log2(List<List<Integer>> n3) {
		try {
			if (GUI.main.getmethod() != 2) {
				FileWriter fw = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path()	+ "\\PSO_Parameter\\"+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\evolution_log2.txt",	false);
				for(int i=0;i<n3.size();i++){
					for(int j=0;j<n3.get(i).size();j++)
						fw.write(n3.get(i).get(j)+" ");
					fw.write("\r\n");
				}
				fw.close();
			} else {
				File f1 = new File("output\\"+ I_Set_Paths_for_Current_Simulation_Example.filename());
				f1.mkdir();
				File f2 = new File("output\\"+ I_Set_Paths_for_Current_Simulation_Example.filename()+ "\\"+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"_Batch");
				f2.mkdir();
				File f3 = new File("output\\"+ I_Set_Paths_for_Current_Simulation_Example.filename()+ "\\"+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"_Batch\\"+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"_Batch" + n);
				f3.mkdir();
				FileWriter fw = new FileWriter("output\\"+ I_Set_Paths_for_Current_Simulation_Example.filename()+ "\\"+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"_Batch\\"+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"_Batch" + n	+ "\\evolution_log2.txt", false);
				for(int i=0;i<n3.size();i++){
					for(int j=0;j<n3.get(i).size();j++)
						fw.write(n3.get(i).get(j)+" ");
					fw.write("\r\n");
				}
				fw.close();
			}
		} catch (Exception ext) {
		}
	}
	public static int read_from_evolution_log3() {
		try {
			BufferedReader in = new BufferedReader(new FileReader(I_Set_Paths_for_Current_Simulation_Example.path()+ "\\PSO_Parameter\\"+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\evolution_log3.txt"));
			String str;
			String[] y = null;
			// double xxx1;
			while ((str = in.readLine()) != null) { // readLine()依序讀取檔案內的一行文字
				y = str.split(" ");
			}
			in.close();
			xxx1 = Integer.parseInt(y[i3++]);
		} catch (Exception ext) {
		}
		return xxx1;
	}

	public static void write_to_evolution_log3(StringBuilder sb) {
		try {
			if (GUI.main.getmethod() != 2) {
				FileWriter fw = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path()	+ "\\PSO_Parameter\\"+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\evolution_log3.txt",
						false);
				PrintWriter pw = new PrintWriter(fw);
				pw.print(sb);
				pw.flush();
				pw.close();
				fw.close();
			} else {
				File f1 = new File("output\\"+ I_Set_Paths_for_Current_Simulation_Example.filename());
				f1.mkdir();
				File f2 = new File("output\\"+ I_Set_Paths_for_Current_Simulation_Example.filename()+ "\\"+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"_Batch");
				f2.mkdir();
				File f3 = new File("output\\"+ I_Set_Paths_for_Current_Simulation_Example.filename()+ "\\"+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"_Batch\\"+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"_Batch" + n);
				f3.mkdir();
				FileWriter fw = new FileWriter("output\\"+ I_Set_Paths_for_Current_Simulation_Example.filename()+ "\\"+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"_Batch\\"+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"_Batch" + n	+ "\\evolution_log3.txt", false);
				PrintWriter pw = new PrintWriter(fw);
				pw.print(sb);
				pw.flush();
				pw.close();
				fw.close();
			}

		} catch (Exception ext) {
		}
	}
	public static int read_from_evolution_log4() {
		try {
			BufferedReader in = new BufferedReader(new FileReader(I_Set_Paths_for_Current_Simulation_Example.path()+ "\\PSO_Parameter\\"+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\evolution_log2.txt"));
			String str;
			String[] y = null;
			// double xxx1;
			while ((str = in.readLine()) != null) { // readLine()依序讀取檔案內的一行文字
				y = str.split(" ");
			}
			in.close();
			xxx1 = Integer.parseInt(y[i4++]);
		} catch (Exception ext) {
		}
		return xxx1;
	}

	public static void write_to_evolution_log4(StringBuilder sb) {
		try {
			if (GUI.main.getmethod() != 2) {
				FileWriter fw = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path()	+ "\\PSO_Parameter\\"+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\evolution_log2.txt",
						false);
				PrintWriter pw = new PrintWriter(fw);
				pw.print(sb);
				pw.flush();
				pw.close();
				fw.close();
			} else {
				File f1 = new File("output\\"+ I_Set_Paths_for_Current_Simulation_Example.filename());
				f1.mkdir();
				File f2 = new File("output\\"+ I_Set_Paths_for_Current_Simulation_Example.filename()+ "\\"+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"_Batch");
				f2.mkdir();
				File f3 = new File("output\\"+ I_Set_Paths_for_Current_Simulation_Example.filename()+ "\\"+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"_Batch\\"+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"_Batch" + n);
				f3.mkdir();
				FileWriter fw = new FileWriter("output\\"+ I_Set_Paths_for_Current_Simulation_Example.filename()+ "\\"+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"_Batch\\"+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"_Batch" + n	+ "\\evolution_log2.txt", false);
				PrintWriter pw = new PrintWriter(fw);
				pw.print(sb);
				pw.flush();
				pw.close();
				fw.close();
			}

		} catch (Exception ext) {
		}
	}
	public static int random_generate_or_read(int Execution_Mode) {
		int xxx1;
		if (Execution_Mode == 0) {
			Random ran = new Random();
			xxx1 = ran.nextInt(2);
			
			//write_to_evolution_log(sb);
			if(Write_Mode==0){
				long totalstartTime = System.currentTimeMillis();
				sb.append(xxx1 + " ");
				write_to_evolution_log(sb);
				long totalendTime = System.currentTimeMillis();
				time_write_to_TXT+=(totalendTime-totalstartTime);
				}
			return xxx1;
		} else {
			return read_from_evolution_log();
		}
	}

	public static double random_generate_or_read1(int Execution_Mode) {
		double xxx1;
		if (Execution_Mode == 0) {
			xxx1 = Math.random();
			
			//write_to_evolution_log1(sb1);
			if(Write_Mode==0){
				long totalstartTime = System.currentTimeMillis();
				sb1.append(xxx1 + " ");
				write_to_evolution_log1(sb1);
				long totalendTime = System.currentTimeMillis();
				time_write_to_TXT+=(totalendTime-totalstartTime);
				}
			return xxx1;
		} else {
			return read_from_evolution_log1();
		}
	}

	public static double random_generate_or_read2(int Execution_Mode) {
		double xxx1;
		if (Execution_Mode == 0) {
			xxx1 = Math.random() * (Vmax - (-Vmax)) + (-Vmax);
			
			//write_to_evolution_log1(sb1);
			if(Write_Mode==0){
				long totalstartTime = System.currentTimeMillis();
				sb1.append(xxx1 + " ");
				write_to_evolution_log1(sb1);
				long totalendTime = System.currentTimeMillis();
				time_write_to_TXT+=(totalendTime-totalstartTime);
				}
			return xxx1;
		} else {
			return read_from_evolution_log1();
		}
	}

	public static double random_generate_or_read3(int Execution_Mode) {
		double xxx1;
		if (Execution_Mode == 0) {
			Random ran = new Random();
			xxx1 = ran.nextGaussian();
			
			//write_to_evolution_log1(sb1);
			if(Write_Mode==0){
				long totalstartTime = System.currentTimeMillis();
				sb1.append(xxx1 + " ");
				write_to_evolution_log1(sb1);
				long totalendTime = System.currentTimeMillis();
				time_write_to_TXT+=(totalendTime-totalstartTime);
				}
			return xxx1;
		} else {
			return read_from_evolution_log1();
		}
	}
	public static void random_generate_or_read4(int Execution_Mode) {

		if (Execution_Mode == 0) {
			Random ran = new Random();
			s = ran.nextInt(S.length);
			if(Write_Mode==0){
				long totalstartTime = System.currentTimeMillis();
				sb3.append(s + " ");
				write_to_evolution_log3(sb3);
				long totalendTime = System.currentTimeMillis();
				time_write_to_TXT+=(totalendTime-totalstartTime);
				}
			
			// s = random_generate_or_read5(Execution_Mode);//ran.nextInt(S.length);  //隨機從S中挑選一個，當作每群的個數
			List<Integer> n1 = new ArrayList<Integer>();
			for (int i = 0; i < Xsize + Ysize; i++)
				n1.add(i);						//將X、Y維度分別給編號
			 n3 = new ArrayList<List<Integer>>();
			while (n1.size() > 0) {
				List<Integer> n2 = new ArrayList<Integer>();
				if(n1.size()>=S[s]){							//如果尚未挑選的編號數量>=每群的個數
					for (int i = 0; i < S[s]; i++) {
						int j =  ran.nextInt( n1.size());
						
						//write_to_evolution_log4(sb2);
						//int j =random_generate_or_read6(Execution_Mode, n1.size());// ran.nextInt(n1.size());	//隨機從挑選編號
						n2.add(n1.get(j));						//將挑選出來的編號存進矩陣
						//sb2.append( j + " ");
						if(Write_Mode==0){
							long totalstartTime = System.currentTimeMillis();
							sb2.append(j + " ");
							write_to_evolution_log4(sb2);
							long totalendTime = System.currentTimeMillis();
							time_write_to_TXT+=(totalendTime-totalstartTime);
							}
						
						n1.remove(j);							//將剛剛挑選出來的編號 移除，避免重複挑選
					}
				}else{												//如果尚未挑選的編號數量<每群的個數
					int n=n1.size();							
					for(int i=0;i<n;i++){			
						int j =  ran.nextInt( n1.size());
						
						//write_to_evolution_log4(sb2);
						//int j = random_generate_or_read6(Execution_Mode, n1.size());//ran.nextInt(n1.size());	//將剩餘的編號個數，隨機挑選
						n2.add(n1.get(j));						//並存放矩陣內
						//sb2.append(j + " ");
						
						if(Write_Mode==0){
							long totalstartTime = System.currentTimeMillis();
							sb2.append(j + " ");
							write_to_evolution_log4(sb2);
							long totalendTime = System.currentTimeMillis();
							time_write_to_TXT+=(totalendTime-totalstartTime);
							}
						n1.remove(j);							//將剛剛挑選出來的編號 移除，避免重複挑選
					}
				}
				n3.add(n2);
			}
			for(int i=0;i<n3.size();i++){
				for(int j=0;j<n3.get(i).size();j++)
					System.out.print(n3.get(i).get(j)+" ");
				System.out.println();
			}
			//write_to_evolution_log4(sb2);
			//write_to_evolution_log2(n3);				//將分群的結果存入TXT
		} else {
			// n3=read_from_evolution_log2();		//讀取分群的結果
				s = read_from_evolution_log3(); //隨機從S中挑選一個，當作每群的個數
				List<Integer> n1 = new ArrayList<Integer>();
				for (int i = 0; i < Xsize + Ysize; i++)
					n1.add(i);						//將X、Y維度分別給編號
				 n3 = new ArrayList<List<Integer>>();
				while (n1.size() > 0) {
					List<Integer> n2 = new ArrayList<Integer>();
					if(n1.size()>=S[s]){							//如果尚未挑選的編號數量>=每群的個數
						for (int i = 0; i < S[s]; i++) {
							int j =read_from_evolution_log4();	//隨機從挑選編號
							n2.add(n1.get(j));						//將挑選出來的編號存進矩陣
							n1.remove(j);							//將剛剛挑選出來的編號 移除，避免重複挑選
						}
					}else{												//如果尚未挑選的編號數量<每群的個數
						int n=n1.size();							
						for(int i=0;i<n;i++){					
							int j = read_from_evolution_log4();//將剩餘的編號個數，隨機挑選
							n2.add(n1.get(j));						//並存放矩陣內
							n1.remove(j);							//將剛剛挑選出來的編號 移除，避免重複挑選
						}
					}
					n3.add(n2);
				}
				for(int i=0;i<n3.size();i++){
					for(int j=0;j<n3.get(i).size();j++)
						System.out.print(n3.get(i).get(j)+" ");
					System.out.println();
				}
		}
	}
	  public static int Iteration() {
			return Iteration;
	}
	public static int Iteration_Mode(){
			return Iteration_Mode;
	}
	public static int populationSize() {
		return populationSize;
	}

	public static double w() {
		return w;
	}

	public static double c1() {
		return c1;
	}

	public static double c2() {
		return c2;
	}

	public static int Vmax() {
		return Vmax;
	}

	public static int Execution_Mode() {
		return Execution_Mode;
	}

	public static int Print_Mode() {
		return Print_Mode;
	}
	public static int Write_Mode() {
		return Write_Mode;
	}
	public static double threshold() {
		return threshold;
	}
	public static double PSO_lamda() {
		return PSO_lamda;
	}
	
	public static double Pc() {
		return Pc;
	}
	

}
