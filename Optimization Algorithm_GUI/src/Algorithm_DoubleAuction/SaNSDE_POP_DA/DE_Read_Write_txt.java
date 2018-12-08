package Algorithm_DoubleAuction.SaNSDE_POP_DA;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Random;

import GUI.I_Set_Paths_for_Current_Simulation_Example;
import GUI.GUI_Double_Auction.X_Select_Algorithm_Type_to_Solve_the_Problem;

public class DE_Read_Write_txt extends Double_Auction_SaNSDE_POP {
	private static int xxx1;
	private static double xxx2;

	public static double lamda;
	public static int Iteration,LP,NP,Execution_Mode,write_Mode,Iteration_Mode,Vmax,Pmax;

private static String[][] Parameter = new String[9][2];
	
	public static void Read_SaNSDE_Parameter( ) {
		// TODO Auto-generated method stub
		String str;
		int d = 0;
		
		try {
			FileReader PBr = new FileReader(
					I_Set_Paths_for_Current_Simulation_Example.path()
							+ "\\DE_Parameter"+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"\\DE_Parameter.txt");
			BufferedReader br = new BufferedReader(PBr);
			while ((str = br.readLine()) != null) { // 每次讀一行
				Parameter[d++] = str.split("=| "); // 將此行以空白(white space)切成字串陣列,
													// 存入 Vector暫存
			}
			br.close(); // 關檔
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
		Iteration=Integer.parseInt(Parameter[0][1]);
		Iteration_Mode=Integer.parseInt(Parameter[1][1]);
		NP = Integer.parseInt(Parameter[2][1]);
		LP = Integer.parseInt(Parameter[3][1]);
		Execution_Mode= Integer.parseInt(Parameter[4][1]);
		write_Mode=Integer.parseInt(Parameter[5][1]);
		Vmax=Integer.parseInt(Parameter[6][1]);
		lamda=Double.parseDouble(Parameter[7][1]);
		Pmax=Integer.parseInt(Parameter[8][1]);
	}
	
	public static int read_from_evolution_log() {
		try {
			BufferedReader in = new BufferedReader(new FileReader(
					I_Set_Paths_for_Current_Simulation_Example.path()
							+ "\\DE_Parameter"
							+ X_Select_Algorithm_Type_to_Solve_the_Problem
									.path() + "\\evolution_log.txt"));
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
				FileWriter fw = new FileWriter(
						I_Set_Paths_for_Current_Simulation_Example.path()
								+ "\\DE_Parameter"
								+ X_Select_Algorithm_Type_to_Solve_the_Problem.path()
								+ "\\evolution_log.txt", false);
				PrintWriter pw = new PrintWriter(fw);
				pw.print(sb);
				pw.flush();
				pw.close();
				fw.close();
			} else {
				File f1 = new File("output\\"
						+ I_Set_Paths_for_Current_Simulation_Example.filename());
				f1.mkdir();
				File f2 = new File("output\\"
						+ I_Set_Paths_for_Current_Simulation_Example.filename()
						+ "\\DE_Batch");
				f2.mkdir();
				File f3 = new File("output\\"
						+ I_Set_Paths_for_Current_Simulation_Example.filename()
						+ "\\DE_Batch\\DE_Batch" + n);
				f3.mkdir();
				FileWriter fw = new FileWriter("output\\"
						+ I_Set_Paths_for_Current_Simulation_Example.filename()
						+ "\\DE_Batch\\DE_Batch" + n + "\\evolution_log.txt",
						false);
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
			BufferedReader in = new BufferedReader(new FileReader(
					I_Set_Paths_for_Current_Simulation_Example.path()
							+ "\\DE_Parameter"
							+ X_Select_Algorithm_Type_to_Solve_the_Problem
									.path() + "\\evolution_log1.txt"));
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
				FileWriter fw = new FileWriter(
						I_Set_Paths_for_Current_Simulation_Example.path()
								+ "\\DE_Parameter"
								+ X_Select_Algorithm_Type_to_Solve_the_Problem.path()
								+ "\\evolution_log1.txt", false);
				PrintWriter pw = new PrintWriter(fw);
				pw.print(sb);
				pw.flush();
				pw.close();
				fw.close();
			} else {
				File f1 = new File("output\\"
						+ I_Set_Paths_for_Current_Simulation_Example.filename());
				f1.mkdir();
				File f2 = new File("output\\"
						+ I_Set_Paths_for_Current_Simulation_Example.filename()
						+ "\\DE_Batch");
				f2.mkdir();
				File f3 = new File("output\\"
						+ I_Set_Paths_for_Current_Simulation_Example.filename()
						+ "\\DE_Batch\\DE_Batch" + n);
				f3.mkdir();
				FileWriter fw = new FileWriter("output\\"
						+ I_Set_Paths_for_Current_Simulation_Example.filename()
						+ "\\DE_Batch\\DE_Batch" + n + "\\evolution_log1.txt",
						false);
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

			// s+=xxx1+" ";

			// PSO_Read_Write_txt.write_to_evolution_log(sb);
			if (Write_Mode == 0) {
				long totalstartTime = System.currentTimeMillis();
				sb.append(xxx1 + " ");
				write_to_evolution_log(sb);
				long totalendTime = System.currentTimeMillis();
				time_write_to_TXT += (totalendTime - totalstartTime);
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

			if (Write_Mode == 0) {
				long totalstartTime = System.currentTimeMillis();
				sb1.append(xxx1 + " ");
				write_to_evolution_log1(sb1);
				long totalendTime = System.currentTimeMillis();
				time_write_to_TXT += (totalendTime - totalstartTime);
			}
			return xxx1;
		} else {
			return read_from_evolution_log1();
		}
	}

	public static int random_generate_or_read2(int Execution_Mode, int size) {
		int xxx1;
		if (Execution_Mode == 0) {
			Random ran = new Random();
			xxx1 = ran.nextInt(size);

			// s+=xxx1+" ";

			// PSO_Read_Write_txt.write_to_evolution_log(sb);
			if (Write_Mode == 0) {
				long totalstartTime = System.currentTimeMillis();
				sb.append(xxx1 + " ");
				write_to_evolution_log(sb);
				long totalendTime = System.currentTimeMillis();
				time_write_to_TXT += (totalendTime - totalstartTime);
			}
			return xxx1;
		} else {
			return read_from_evolution_log();
		}
	}

	public static double random_generate_or_read3(int Execution_Mode) {
		double xxx1;
		if (Execution_Mode == 0) {
			Random ran = new Random();
			xxx1 = ran.nextGaussian();
			// write_to_evolution_log1(sb1);
			if (Write_Mode == 0) {

				long totalstartTime = System.currentTimeMillis();
				sb1.append(xxx1 + " ");
				write_to_evolution_log1(sb1);
				long totalendTime = System.currentTimeMillis();
				time_write_to_TXT += (totalendTime - totalstartTime);
			}
			return xxx1;
		} else {
			return read_from_evolution_log1();
		}
	}

	public static double random_generate_or_read4(int Execution_Mode) {
		double xxx1;
		if (Execution_Mode == 0) {
			xxx1 = Math.random() * (Vmax - (-Vmax)) + (-Vmax);

			// write_to_evolution_log1(sb1);
			if (Write_Mode == 0) {
				long totalstartTime = System.currentTimeMillis();
				sb1.append(xxx1 + " ");
				write_to_evolution_log1(sb1);
				long totalendTime = System.currentTimeMillis();
				time_write_to_TXT += (totalendTime - totalstartTime);
			}
			return xxx1;
		} else {
			return read_from_evolution_log1();
		}
	}

	public static double random_generate_or_read5(int Execution_Mode) {
		double xxx1;
		if (Execution_Mode == 0) {
			Random ran = new Random();
			
			 xxx1 = Math.random();
			while(xxx1==0||xxx1 ==1){
				xxx1 = Math.random();
			}
			
			// write_to_evolution_log1(sb1);
			if (Write_Mode == 0) {

				long totalstartTime = System.currentTimeMillis();
				sb1.append(xxx1 + " ");
				write_to_evolution_log1(sb1);
				long totalendTime = System.currentTimeMillis();
				time_write_to_TXT += (totalendTime - totalstartTime);
			}
			return xxx1;
		} else {
			return read_from_evolution_log1();
		}
	}
	
	public static double random_generate_or_read6(int Execution_Mode) {
		double xxx1;
		if (Execution_Mode == 0) {
			xxx1 = Math.random() * 2;

			// write_to_evolution_log1(sb1);
			if (Write_Mode == 0) {
				long totalstartTime = System.currentTimeMillis();
				sb1.append(xxx1 + " ");
				write_to_evolution_log1(sb1);
				long totalendTime = System.currentTimeMillis();
				time_write_to_TXT += (totalendTime - totalstartTime);
			}
			return xxx1;
		} else {
			return read_from_evolution_log1();
		}
	}
	
	public static int Iteration() {
		return Iteration;
	}
	public static int Iteration_Mode() {
		return Iteration_Mode;
	}
	public static int NP() {
		return NP;
	}
	public static int LP() {
		return LP;
	}
	
	public static int Execution_Mode() {
		return Execution_Mode;
	}
	public static int write_Mode() {
		return write_Mode;
	}
	public static int Vmax() {
		return Vmax;
	}
	public static double lamda() {
		return lamda;
	}
	public static int Pmax() {
		return Pmax;
	}
}
