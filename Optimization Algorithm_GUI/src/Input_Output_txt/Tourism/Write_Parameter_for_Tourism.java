package Input_Output_txt.Tourism;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;

import GUI.I_Set_Paths_for_Current_Simulation_Example;
import GUI.GUI_Tourism.X_Select_Algorithm_Type_to_Solve_the_Problem;

public class Write_Parameter_for_Tourism {

	public static void saveGA1(int Iteration, int Iteration_Mode, double initialPopulationRate, double crossoverRate
			, double mutationRate, int tournamentSize, int populationSize, double threshold, int Execution_Mode, int Print_Mode
			, int SA_Mode, int Write_Mode, double T, double Factor_T, int R1, int R2, int R3, int R4, int R5, int R6, int R7) throws IOException
	{

		FileWriter fw2 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path() + "\\GA_Parameter\\GA1\\GA_Parameter.txt");
		fw2.write("Iteration=" + Iteration + "\r\n");
		fw2.write("Iteration_Mode=" + Iteration_Mode + "\r\n");
		fw2.write("initialPopulationRate=" + initialPopulationRate + "\r\n");
		fw2.write("crossoverRate=" + crossoverRate + "\r\n");
		fw2.write("mutationRate=" + mutationRate + "\r\n");
		fw2.write("tournamentSize=" + tournamentSize + "\r\n");
		fw2.write("populationSize=" + populationSize + "\r\n");
		fw2.write("threshold=" + new BigDecimal(String.valueOf(threshold)) + "\r\n");
		fw2.write("Execution_Mode=" + Execution_Mode + "\r\n");
		fw2.write("Print_Mode=" + Print_Mode + "\r\n");
		fw2.write("SA_Mode=" + SA_Mode + "\r\n");
		fw2.write("Write_Mode=" + Write_Mode + "\r\n");
		fw2.write("T=" + T + "\r\n");
		fw2.write("Factor_T=" + Factor_T + "\r\n");
		// fw2.write("\r\n");
		fw2.close();
		FileWriter fw1 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path() + "\\GA_Parameter\\GA1\\Tourism_Penalty.txt");
		fw1.write(R1 + " " + R2 + " " + R3 + " " + R4 + " " + R5 + " " + R6 + " " + R7);
		fw1.close();
	}

	public static void saveGA2(int Iteration, int Iteration_Mode, double initialPopulationRate, double crossoverRate, double mutationRate, int tournamentSize, int populationSize, double threshold, int Execution_Mode, int Print_Mode, int SA_Mode, int Write_Mode, double T, double Factor_T) throws IOException
	{
		FileWriter fw2 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path() + "\\GA_Parameter\\GA2\\GA_Parameter.txt");
		fw2.write("Iteration=" + Iteration + "\r\n");
		fw2.write("Iteration_Mode=" + Iteration_Mode + "\r\n");
		fw2.write("initialPopulationRate=" + initialPopulationRate + "\r\n");
		fw2.write("crossoverRate=" + crossoverRate + "\r\n");
		fw2.write("mutationRate=" + mutationRate + "\r\n");
		fw2.write("tournamentSize=" + tournamentSize + "\r\n");
		fw2.write("populationSize=" + populationSize + "\r\n");
		fw2.write("threshold=" + new BigDecimal(String.valueOf(threshold)) + "\r\n");
		fw2.write("Execution_Mode=" + Execution_Mode + "\r\n");
		fw2.write("Print_Mode=" + Print_Mode + "\r\n");
		fw2.write("SA_Mode=" + SA_Mode + "\r\n");
		fw2.write("Write_Mode=" + Write_Mode + "\r\n");
		fw2.write("T=" + T + "\r\n");
		fw2.write("Factor_T=" + Factor_T + "\r\n");
		// fw2.write("\r\n");
		fw2.close();
	}

	public static void savePSO1(int Iteration, int Iteration_Mode, int populationSize, double w, double c1, double c2
			, int Vmax, int Execution_Mode, int Print_Mode, int Write_Mode, double threshold, double PSO_lamda
			, int R1, int R2, int R3, int R4, int R5, int R6, int R7) throws IOException {

		FileWriter fw2 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path() + "\\PSO_Parameter\\PSO1\\PSO_Parameter.txt");
		fw2.write("Iteration=" + Iteration + "\r\n");
		fw2.write("Iteration_Mode=" + Iteration_Mode + "\r\n");
		fw2.write("populationSize=" + populationSize + "\r\n");
		fw2.write("w=" + w + "\r\n");
		fw2.write("c1=" + c1 + "\r\n");
		fw2.write("c2=" + c2 + "\r\n");
		fw2.write("Vmax=" + Vmax + "\r\n");
		fw2.write("Execution_Mode=" + Execution_Mode + "\r\n");
		fw2.write("Print_Mode=" + Print_Mode + "\r\n");
		fw2.write("Write_Mode=" + Write_Mode + "\r\n");

		fw2.write("threshold=" + new BigDecimal(String.valueOf(threshold)) + "\r\n");
		fw2.write("PSO_lamda=" + PSO_lamda + "\r\n");
		// fw2.write("\r\n");
		fw2.close();

		FileWriter fw = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path() + "\\PSO_Parameter\\PSO1\\Tourism_Penalty.txt");
		fw.write(R1 + " " + R2 + " " + R3 + " " + R4 + " " + R5 + " " + R6 + " " + R7);
		fw.close();
	}

	public static void savePSO2(int Iteration, int Iteration_Mode, int populationSize, double w, double c1, double c2, int Vmax, int Execution_Mode, int Print_Mode, int Write_Mode, double threshold, double PSO_lamda) throws IOException {

		FileWriter fw2 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path() + "\\PSO_Parameter\\PSO2\\PSO_Parameter.txt");
		fw2.write("Iteration=" + Iteration + "\r\n");
		fw2.write("Iteration_Mode=" + Iteration_Mode + "\r\n");
		fw2.write("populationSize=" + populationSize + "\r\n");
		fw2.write("w=" + w + "\r\n");
		fw2.write("c1=" + c1 + "\r\n");
		fw2.write("c2=" + c2 + "\r\n");
		fw2.write("Vmax=" + Vmax + "\r\n");
		fw2.write("Execution_Mode=" + Execution_Mode + "\r\n");
		fw2.write("Print_Mode=" + Print_Mode + "\r\n");
		fw2.write("Write_Mode=" + Write_Mode + "\r\n");

		fw2.write("threshold=" + new BigDecimal(String.valueOf(threshold)) + "\r\n");
		fw2.write("PSO_lamda=" + PSO_lamda + "\r\n");

		// fw2.write("\r\n");
		fw2.close();

	}

	public static void savePSO3(int Iteration, int Iteration_Mode, int populationSize, double w, double c1, double c2, int Vmax, int Execution_Mode, int Print_Mode, int Write_Mode, double threshold) throws IOException {

		FileWriter fw2 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path() + "\\PSO_Parameter\\PSO3\\PSO_Parameter.txt");
		fw2.write("Iteration=" + Iteration + "\r\n");
		fw2.write("Iteration_Mode=" + Iteration_Mode + "\r\n");
		fw2.write("populationSize=" + populationSize + "\r\n");
		fw2.write("w=" + w + "\r\n");
		fw2.write("c1=" + c1 + "\r\n");
		fw2.write("c2=" + c2 + "\r\n");
		fw2.write("Vmax=" + Vmax + "\r\n");
		fw2.write("Execution_Mode=" + Execution_Mode + "\r\n");
		fw2.write("Print_Mode=" + Print_Mode + "\r\n");
		fw2.write("Write_Mode=" + Write_Mode + "\r\n");

		fw2.write("threshold=" + new BigDecimal(String.valueOf(threshold)) + "\r\n");

		// fw2.write("\r\n");
		fw2.close();

	}

	public static void savePSO4(int Iteration, int Iteration_Mode, int populationSize, double w, double c1, double c2, int Vmax, int Execution_Mode, int Print_Mode, int Write_Mode, double threshold, double epsilon, double micro) throws IOException {

		FileWriter fw2 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path() + "\\PSO_Parameter\\PSO4\\PSO_Parameter.txt");
		fw2.write("Iteration=" + Iteration + "\r\n");
		fw2.write("Iteration_Mode=" + Iteration_Mode + "\r\n");
		fw2.write("populationSize=" + populationSize + "\r\n");
		fw2.write("w=" + w + "\r\n");
		fw2.write("c1=" + c1 + "\r\n");
		fw2.write("c2=" + c2 + "\r\n");
		fw2.write("Vmax=" + Vmax + "\r\n");
		fw2.write("Execution_Mode=" + Execution_Mode + "\r\n");
		fw2.write("Print_Mode=" + Print_Mode + "\r\n");
		fw2.write("Write_Mode=" + Write_Mode + "\r\n");

		fw2.write("threshold=" + new BigDecimal(String.valueOf(threshold)) + "\r\n");
		fw2.write("epsilon=" + new BigDecimal(String.valueOf(epsilon)) + "\r\n");
		fw2.write("micro=" + new BigDecimal(String.valueOf(micro)) + "\r\n");
		// fw2.write("\r\n");
		fw2.close();

	}

	public static void saveAPSO1(int Iteration, int Iteration_Mode, int populationSize, double w, double c1, double c2, int Vmax, int Execution_Mode, int Print_Mode, int Write_Mode, double threshold, int R1, int R2, int R3, int R4, int R5, int R6, int R7, int Adaptive_Mode_1, int Adaptive_Mode_2, double Mu, double Sigma_max, double Sigma_min, double G) throws IOException {

		FileWriter fw2 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path() + "\\PSO_Parameter\\APSO1\\PSO_Parameter.txt");
		fw2.write("Iteration=" + Iteration + "\r\n");
		fw2.write("Iteration_Mode=" + Iteration_Mode + "\r\n");
		fw2.write("populationSize=" + populationSize + "\r\n");
		fw2.write("w=" + w + "\r\n");
		fw2.write("c1=" + c1 + "\r\n");
		fw2.write("c2=" + c2 + "\r\n");
		fw2.write("Vmax=" + Vmax + "\r\n");
		fw2.write("Execution_Mode=" + Execution_Mode + "\r\n");
		fw2.write("Print_Mode=" + Print_Mode + "\r\n");
		fw2.write("Write_Mode=" + Write_Mode + "\r\n");

		fw2.write("threshold=" + new BigDecimal(String.valueOf(threshold)) + "\r\n");

		// fw2.write("\r\n");
		fw2.close();
		FileWriter fw3 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path() + "\\PSO_Parameter\\APSO1\\Adaptive.txt");
		fw3.write("Adaptive_Mode_1=" + Adaptive_Mode_1 + "\r\n");
		fw3.write("Adaptive_Mode_2=" + Adaptive_Mode_2 + "\r\n");
		fw3.write("Mu=" + Mu + "\r\n");
		fw3.write("Sigma_max=" + Sigma_max + "\r\n");
		fw3.write("Sigma_min=" + Sigma_min + "\r\n");
		fw3.write("G=" + G + "\r\n");
		fw3.close();
		FileWriter fw = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path() + "\\PSO_Parameter\\APSO1\\Tourism_Penalty.txt");
		fw.write(R1 + " " + R2 + " " + R3 + " " + R4 + " " + R5 + " " + R6 + " " + R7);
		fw.close();
	}

	public static void saveAPSO2(int Iteration, int Iteration_Mode, int populationSize, double w, double c1, double c2, int Vmax, int Execution_Mode, int Print_Mode, int Write_Mode, double threshold, int Adaptive_Mode_1, int Adaptive_Mode_2, double Mu, double Sigma_max, double Sigma_min, double G) throws IOException {

		FileWriter fw2 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path() + "\\PSO_Parameter\\APSO2\\PSO_Parameter.txt");
		fw2.write("Iteration=" + Iteration + "\r\n");
		fw2.write("Iteration_Mode=" + Iteration_Mode + "\r\n");
		fw2.write("populationSize=" + populationSize + "\r\n");
		fw2.write("w=" + w + "\r\n");
		fw2.write("c1=" + c1 + "\r\n");
		fw2.write("c2=" + c2 + "\r\n");
		fw2.write("Vmax=" + Vmax + "\r\n");
		fw2.write("Execution_Mode=" + Execution_Mode + "\r\n");
		fw2.write("Print_Mode=" + Print_Mode + "\r\n");
		fw2.write("Write_Mode=" + Write_Mode + "\r\n");
		fw2.write("threshold=" + new BigDecimal(String.valueOf(threshold)) + "\r\n");

		// fw2.write("\r\n");
		fw2.close();
		FileWriter fw3 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path() + "\\PSO_Parameter\\APSO2\\Adaptive.txt");
		fw3.write("Adaptive_Mode_1=" + Adaptive_Mode_1 + "\r\n");
		fw3.write("Adaptive_Mode_2=" + Adaptive_Mode_2 + "\r\n");
		fw3.write("Mu=" + Mu + "\r\n");
		fw3.write("Sigma_max=" + Sigma_max + "\r\n");
		fw3.write("Sigma_min=" + Sigma_min + "\r\n");
		fw3.write("G=" + G + "\r\n");
		fw3.close();
	}

	public static void saveALPSO(int Iteration, int Iteration_Mode, int populationSize, double w, double c1, double c2, int Vmax, int Execution_Mode, int Print_Mode, int Write_Mode, double threshold, int R1, int R2, int R3, int R4, int R5, int R6, int R7, double Epsilonh, int Print) throws IOException {

		FileWriter fw2 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path() + "\\PSO_Parameter\\ALPSO\\PSO_Parameter.txt");
		fw2.write("Iteration=" + Iteration + "\r\n");
		fw2.write("Iteration_Mode=" + Iteration_Mode + "\r\n");
		fw2.write("populationSize=" + populationSize + "\r\n");
		fw2.write("w=" + w + "\r\n");
		fw2.write("c1=" + c1 + "\r\n");
		fw2.write("c2=" + c2 + "\r\n");
		fw2.write("Vmax=" + Vmax + "\r\n");
		fw2.write("Execution_Mode=" + Execution_Mode + "\r\n");
		fw2.write("Print_Mode=" + Print_Mode + "\r\n");
		fw2.write("Write_Mode=" + Write_Mode + "\r\n");
		fw2.write("threshold=" + new BigDecimal(String.valueOf(threshold)) + "\r\n");

		// fw2.write("\r\n");
		fw2.close();

		FileWriter fw = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path() + "\\PSO_Parameter\\ALPSO\\Tourism_Penalty.txt");
		fw.write(R1 + " " + R2 + " " + R3 + " " + R4 + " " + R5 + " " + R6 + " " + R7);
		fw.close();
		FileWriter fw1 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path() + "\\PSO_Parameter\\ALPSO\\ALPSO__Parameter.txt");
		fw1.write("Epsilonh=" + Epsilonh + "\r\n");
		fw1.write("Print=" + Print + "\r\n");
		fw1.close();

	}

	public static void saveLRPSO(int Iteration, int Iteration_Mode, int populationSize, double w, double c1, double c2, int Vmax, int Execution_Mode, int Print_Mode, int Write_Mode, double threshold, double L, double c, int Print) throws IOException {

		FileWriter fw2 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path() + "\\PSO_Parameter\\LRPSO\\PSO_Parameter.txt");
		fw2.write("Iteration=" + Iteration + "\r\n");
		fw2.write("Iteration_Mode=" + Iteration_Mode + "\r\n");
		fw2.write("populationSize=" + populationSize + "\r\n");
		fw2.write("w=" + w + "\r\n");
		fw2.write("c1=" + c1 + "\r\n");
		fw2.write("c2=" + c2 + "\r\n");
		fw2.write("Vmax=" + Vmax + "\r\n");
		fw2.write("Execution_Mode=" + Execution_Mode + "\r\n");
		fw2.write("Print_Mode=" + Print_Mode + "\r\n");
		fw2.write("Write_Mode=" + Write_Mode + "\r\n");
		fw2.write("threshold=" + new BigDecimal(String.valueOf(threshold)) + "\r\n");

		// fw2.write("\r\n");
		fw2.close();

		FileWriter fw1 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path() + "\\PSO_Parameter\\LRPSO\\LRPSO_Parameter.txt");
		fw1.write("L=" + L + "\r\n");
		fw1.write("c=" + c + "\r\n");
		fw1.write("Print=" + Print + "\r\n");
		fw1.close();
	}

	public static void saveLR(double L, double c, int Print, double threshold) throws IOException {

		// fw2.write("\r\n");

		FileWriter fw1 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path() + "\\LR\\LR_Parameter.txt");
		fw1.write("L=" + L + "\r\n");
		fw1.write("c=" + c + "\r\n");
		fw1.write("Print=" + Print + "\r\n");
		fw1.write("threshold=" + threshold + "\r\n");
		fw1.close();
	}

	public static void saveLR_and_PSO2(int Iteration, int Iteration_Mode, int populationSize, double w, double c1, double c2, int Vmax, int Execution_Mode, int Print_Mode, int Write_Mode, double threshold, double L, double c, int Print) throws IOException {

		FileWriter fw2 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path() + "\\PSO_Parameter\\LR_and_PSO2\\PSO_Parameter.txt");
		fw2.write("Iteration=" + Iteration + "\r\n");
		fw2.write("Iteration_Mode=" + Iteration_Mode + "\r\n");
		fw2.write("populationSize=" + populationSize + "\r\n");
		fw2.write("w=" + w + "\r\n");
		fw2.write("c1=" + c1 + "\r\n");
		fw2.write("c2=" + c2 + "\r\n");
		fw2.write("Vmax=" + Vmax + "\r\n");
		fw2.write("Execution_Mode=" + Execution_Mode + "\r\n");
		fw2.write("Print_Mode=" + Print_Mode + "\r\n");
		fw2.write("Write_Mode=" + Write_Mode + "\r\n");
		fw2.write("threshold=" + new BigDecimal(String.valueOf(threshold)) + "\r\n");

		// fw2.write("\r\n");
		fw2.close();

		FileWriter fw1 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path() + "\\PSO_Parameter\\LR_and_PSO2\\LR_Parameter.txt");
		fw1.write("L=" + L + "\r\n");
		fw1.write("c=" + c + "\r\n");
		fw1.write("Print=" + Print + "\r\n");
		fw1.close();
	}

	public static void saveLR_and_PSO1(int Iteration, int Iteration_Mode, int populationSize, double w, double c1, double c2, int Vmax, int Execution_Mode, int Print_Mode, int Write_Mode, double threshold, int R1, int R2, int R3, int R4, int R5, int R6, int R7, double L, double c, int Print) throws IOException {

		FileWriter fw2 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path() + "\\PSO_Parameter\\LR_and_PSO1\\PSO_Parameter.txt");
		fw2.write("Iteration=" + Iteration + "\r\n");
		fw2.write("Iteration_Mode=" + Iteration_Mode + "\r\n");
		fw2.write("populationSize=" + populationSize + "\r\n");
		fw2.write("w=" + w + "\r\n");
		fw2.write("c1=" + c1 + "\r\n");
		fw2.write("c2=" + c2 + "\r\n");
		fw2.write("Vmax=" + Vmax + "\r\n");
		fw2.write("Execution_Mode=" + Execution_Mode + "\r\n");
		fw2.write("Print_Mode=" + Print_Mode + "\r\n");
		fw2.write("Write_Mode=" + Write_Mode + "\r\n");
		fw2.write("threshold=" + new BigDecimal(String.valueOf(threshold)) + "\r\n");

		// fw2.write("\r\n");
		fw2.close();

		FileWriter fw = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path() + "\\PSO_Parameter\\LR_and_PSO1\\Tourism_Penalty.txt");
		fw.write(R1 + " " + R2 + " " + R3 + " " + R4 + " " + R5 + " " + R6 + " " + R7);
		fw.close();

		FileWriter fw1 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path() + "\\PSO_Parameter\\LR_and_PSO1\\LR_Parameter.txt");
		fw1.write("L=" + L + "\r\n");
		fw1.write("c=" + c + "\r\n");
		fw1.write("Print=" + Print + "\r\n");
		fw1.close();

	}

	public static void saveCCPSO2(int Iteration, int Iteration_Mode, int populationSize, double w, double c1, double c2, int Vmax, int Execution_Mode, int Print_Mode, int Write_Mode, double threshold, double PSO_lamda, double Alpha1, double Alpha2, double Alpha3) throws IOException {

		FileWriter fw2 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path() + "\\PSO_Parameter\\CCPSO2\\PSO_Parameter.txt");
		fw2.write("Iteration=" + Iteration + "\r\n");
		fw2.write("Iteration_Mode=" + Iteration_Mode + "\r\n");
		fw2.write("populationSize=" + populationSize + "\r\n");
		fw2.write("w=" + w + "\r\n");
		fw2.write("c1=" + c1 + "\r\n");
		fw2.write("c2=" + c2 + "\r\n");
		fw2.write("Vmax=" + Vmax + "\r\n");
		fw2.write("Execution_Mode=" + Execution_Mode + "\r\n");
		fw2.write("Print_Mode=" + Print_Mode + "\r\n");
		fw2.write("Write_Mode=" + Write_Mode + "\r\n");
		fw2.write("threshold=" + new BigDecimal(String.valueOf(threshold)) + "\r\n");
		fw2.write("PSO_lamda=" + PSO_lamda + "\r\n");
		fw2.write("Alpha1=" + Alpha1 + "\r\n");
		fw2.write("Alpha2=" + Alpha2 + "\r\n");
		fw2.write("Alpha3=" + Alpha3 + "\r\n");

		// fw2.write("\r\n");
		fw2.close();

	}

	public static void savePSO_LS(int Iteration, int Iteration_Mode, int populationSize, double w, double c1, double c2, int Vmax, int Execution_Mode, int Print_Mode, int Write_Mode, double threshold, int Local_Search_Mode) throws IOException {

		FileWriter fw2 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path() + "\\PSO_Parameter\\PSO_LS\\PSO_Parameter.txt");
		fw2.write("Iteration=" + Iteration + "\r\n");
		fw2.write("Iteration_Mode=" + Iteration_Mode + "\r\n");
		fw2.write("populationSize=" + populationSize + "\r\n");
		fw2.write("w=" + w + "\r\n");
		fw2.write("c1=" + c1 + "\r\n");
		fw2.write("c2=" + c2 + "\r\n");
		fw2.write("Vmax=" + Vmax + "\r\n");
		fw2.write("Execution_Mode=" + Execution_Mode + "\r\n");
		fw2.write("Print_Mode=" + Print_Mode + "\r\n");
		fw2.write("Write_Mode=" + Write_Mode + "\r\n");
		fw2.write("threshold=" + new BigDecimal(String.valueOf(threshold)) + "\r\n");
		fw2.write("Local_Search_Mode=" + new BigDecimal(String.valueOf(Local_Search_Mode)) + "\r\n");

		// fw2.write("\r\n");
		fw2.close();

	}

	public static void savePSO_TS(int Iteration, int Iteration_Mode, int populationSize, double w, double c1, double c2, int Vmax, int Execution_Mode, int Print_Mode, int Write_Mode, double threshold) throws IOException {

		FileWriter fw2 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path() + "\\PSO_Parameter\\PSO_TS\\PSO_Parameter.txt");
		fw2.write("Iteration=" + Iteration + "\r\n");
		fw2.write("Iteration_Mode=" + Iteration_Mode + "\r\n");
		fw2.write("populationSize=" + populationSize + "\r\n");
		fw2.write("w=" + w + "\r\n");
		fw2.write("c1=" + c1 + "\r\n");
		fw2.write("c2=" + c2 + "\r\n");
		fw2.write("Vmax=" + Vmax + "\r\n");
		fw2.write("Execution_Mode=" + Execution_Mode + "\r\n");
		fw2.write("Print_Mode=" + Print_Mode + "\r\n");
		fw2.write("Write_Mode=" + Write_Mode + "\r\n");
		fw2.write("threshold=" + new BigDecimal(String.valueOf(threshold)) + "\r\n");

		// fw2.write("\r\n");
		fw2.close();

	}

	public static void save_Batch_PSO1(int Iteration, int Iteration_Mode, int lowpopulationSize, int UppopulationSize
			, int StpopulationSize, double loww, double Upw, double Stw, double lowc1, double Upc1, double Stc1, double lowc2
			, double Upc2, double Stc2, int Vmax, int Execution_Mode, int Print_Mode, int Write_Mode, double threshold
			, int R1, int R2, int R3, int R4, int R5, int R6, int R7) throws IOException {

		FileWriter fw2 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path() + "\\PSO_Parameter\\PSO1\\Batch_PSO_Parameter.txt");
		fw2.write("Iteration=" + Iteration + "\r\n");
		fw2.write("Iteration_Mode=" + Iteration_Mode + "\r\n");
		fw2.write("populationSize=" + lowpopulationSize + " " + UppopulationSize + " " + StpopulationSize + "\r\n");
		fw2.write("w=" + loww + " " + Upw + " " + Stw + "\r\n");
		fw2.write("c1=" + lowc1 + " " + Upc1 + " " + Stc1 + "\r\n");
		fw2.write("c2=" + lowc2 + " " + Upc2 + " " + Stc2 + "\r\n");
		fw2.write("Vmax=" + Vmax + "\r\n");
		fw2.write("Execution_Mode=" + Execution_Mode + "\r\n");
		fw2.write("Print_Mode=" + Print_Mode + "\r\n");
		fw2.write("Write_Mode=" + Write_Mode + "\r\n");
		fw2.write("threshold=" + new BigDecimal(String.valueOf(threshold)) + "\r\n");

		// fw2.write("\r\n");
		fw2.close();

		FileWriter fw = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path() + "\\PSO_Parameter\\PSO1\\Tourism_Penalty.txt");
		fw.write(R1 + " " + R2 + " " + R3 + " " + R4 + " " + R5 + " " + R6 + " " + R7);
		fw.close();
	}

	public static void save_Batch_PSO2(int Iteration, int Iteration_Mode, int lowpopulationSize, int UppopulationSize, int StpopulationSize, double loww, double Upw, double Stw, double lowc1, double Upc1, double Stc1, double lowc2, double Upc2, double Stc2, int Vmax, int Execution_Mode, int Print_Mode, int Write_Mode, double threshold) throws IOException {

		FileWriter fw2 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path() + "\\PSO_Parameter\\PSO2\\Batch_PSO_Parameter.txt");
		fw2.write("Iteration=" + Iteration + "\r\n");
		fw2.write("Iteration_Mode=" + Iteration_Mode + "\r\n");
		fw2.write("populationSize=" + lowpopulationSize + " " + UppopulationSize + " " + StpopulationSize + "\r\n");
		fw2.write("w=" + loww + " " + Upw + " " + Stw + "\r\n");
		fw2.write("c1=" + lowc1 + " " + Upc1 + " " + Stc1 + "\r\n");
		fw2.write("c2=" + lowc2 + " " + Upc2 + " " + Stc2 + "\r\n");
		fw2.write("Vmax=" + Vmax + "\r\n");
		fw2.write("Execution_Mode=" + Execution_Mode + "\r\n");
		fw2.write("Print_Mode=" + Print_Mode + "\r\n");
		fw2.write("Write_Mode=" + Write_Mode + "\r\n");
		fw2.write("threshold=" + new BigDecimal(String.valueOf(threshold)) + "\r\n");

		// fw2.write("\r\n");
		fw2.close();
	}

	public static void save_Batch_PSO3(int Iteration, int Iteration_Mode, int lowpopulationSize, int UppopulationSize, int StpopulationSize, double loww, double Upw, double Stw, double lowc1, double Upc1, double Stc1, double lowc2, double Upc2, double Stc2, int Vmax, int Execution_Mode, int Print_Mode, int Write_Mode, double threshold) throws IOException {

		FileWriter fw2 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path() + "\\PSO_Parameter\\PSO3\\Batch_PSO_Parameter.txt");
		fw2.write("Iteration=" + Iteration + "\r\n");
		fw2.write("Iteration_Mode=" + Iteration_Mode + "\r\n");
		fw2.write("populationSize=" + lowpopulationSize + " " + UppopulationSize + " " + StpopulationSize + "\r\n");
		fw2.write("w=" + loww + " " + Upw + " " + Stw + "\r\n");
		fw2.write("c1=" + lowc1 + " " + Upc1 + " " + Stc1 + "\r\n");
		fw2.write("c2=" + lowc2 + " " + Upc2 + " " + Stc2 + "\r\n");
		fw2.write("Vmax=" + Vmax + "\r\n");
		fw2.write("Execution_Mode=" + Execution_Mode + "\r\n");
		fw2.write("Print_Mode=" + Print_Mode + "\r\n");
		fw2.write("Write_Mode=" + Write_Mode + "\r\n");
		fw2.write("threshold=" + new BigDecimal(String.valueOf(threshold)) + "\r\n");

		// fw2.write("\r\n");
		fw2.close();

	}

	public static void save_Batch_PSO4(int Iteration, int Iteration_Mode, int lowpopulationSize, int UppopulationSize, int StpopulationSize, double loww, double Upw, double Stw, double lowc1, double Upc1, double Stc1, double lowc2, double Upc2, double Stc2, int Vmax, int Execution_Mode, int Print_Mode, int Write_Mode, double threshold, double epsilon, double micro) throws IOException {

		FileWriter fw2 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path() + "\\PSO_Parameter\\PSO4\\Batch_PSO_Parameter.txt");
		fw2.write("Iteration=" + Iteration + "\r\n");
		fw2.write("Iteration_Mode=" + Iteration_Mode + "\r\n");
		fw2.write("Iteration=" + Iteration + "\r\n");
		fw2.write("Iteration_Mode=" + Iteration_Mode + "\r\n");
		fw2.write("populationSize=" + lowpopulationSize + " " + UppopulationSize + " " + StpopulationSize + "\r\n");
		fw2.write("w=" + loww + " " + Upw + " " + Stw + "\r\n");
		fw2.write("c1=" + lowc1 + " " + Upc1 + " " + Stc1 + "\r\n");
		fw2.write("c2=" + lowc2 + " " + Upc2 + " " + Stc2 + "\r\n");
		fw2.write("Vmax=" + Vmax + "\r\n");
		fw2.write("Execution_Mode=" + Execution_Mode + "\r\n");
		fw2.write("Print_Mode=" + Print_Mode + "\r\n");
		fw2.write("Write_Mode=" + Write_Mode + "\r\n");
		fw2.write("threshold=" + new BigDecimal(String.valueOf(threshold)) + "\r\n");
		fw2.write("epsilon=" + new BigDecimal(String.valueOf(epsilon)) + "\r\n");
		fw2.write("micro=" + new BigDecimal(String.valueOf(micro)) + "\r\n");
		// fw2.write("\r\n");
		fw2.close();

	}

	public static void save_Batch_APSO1(int Iteration, int Iteration_Mode, int lowpopulationSize, int UppopulationSize, int StpopulationSize, double loww, double Upw, double Stw, double lowc1, double Upc1, double Stc1, double lowc2, double Upc2, double Stc2, int Vmax, int Execution_Mode, int Print_Mode, int Write_Mode, double threshold, int R1, int R2, int R3, int R4, int R5, int Adaptive_Mode_1,
			int Adaptive_Mode_2, double Mu, double Sigma_max, double Sigma_min, double G) throws IOException {

		FileWriter fw2 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path() + "\\PSO_Parameter\\APSO1\\Batch_PSO_Parameter.txt");
		fw2.write("Iteration=" + Iteration + "\r\n");
		fw2.write("Iteration_Mode=" + Iteration_Mode + "\r\n");
		fw2.write("populationSize=" + lowpopulationSize + " " + UppopulationSize + " " + StpopulationSize + "\r\n");
		fw2.write("w=" + loww + " " + Upw + " " + Stw + "\r\n");
		fw2.write("c1=" + lowc1 + " " + Upc1 + " " + Stc1 + "\r\n");
		fw2.write("c2=" + lowc2 + " " + Upc2 + " " + Stc2 + "\r\n");
		fw2.write("Vmax=" + Vmax + "\r\n");
		fw2.write("Execution_Mode=" + Execution_Mode + "\r\n");
		fw2.write("Print_Mode=" + Print_Mode + "\r\n");
		fw2.write("Write_Mode=" + Write_Mode + "\r\n");
		fw2.write("threshold=" + new BigDecimal(String.valueOf(threshold)) + "\r\n");

		// fw2.write("\r\n");
		fw2.close();

		FileWriter fw = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path() + "\\PSO_Parameter\\APSO1\\Tourism_Penalty.txt");
		fw.write(R1 + " " + R2 + " " + R3 + " " + R4 + " " + R5);
		fw.close();

		FileWriter fw3 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path() + "\\PSO_Parameter\\APSO1\\Adaptive.txt");
		fw3.write("Adaptive_Mode_1=" + Adaptive_Mode_1 + "\r\n");
		fw3.write("Adaptive_Mode_2=" + Adaptive_Mode_2 + "\r\n");
		fw3.write("Mu=" + Mu + "\r\n");
		fw3.write("Sigma_max=" + Sigma_max + "\r\n");
		fw3.write("Sigma_min=" + Sigma_min + "\r\n");
		fw3.write("G=" + G + "\r\n");
		fw3.close();
	}

	public static void save_Batch_APSO2(int Iteration, int Iteration_Mode, int lowpopulationSize, int UppopulationSize, int StpopulationSize, double loww, double Upw, double Stw, double lowc1, double Upc1, double Stc1, double lowc2, double Upc2, double Stc2, int Vmax, int Execution_Mode, int Print_Mode, int Write_Mode, double threshold, int Adaptive_Mode_1, int Adaptive_Mode_2, double Mu,
			double Sigma_max, double Sigma_min, double G) throws IOException {

		FileWriter fw2 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path() + "\\PSO_Parameter\\APSO2\\Batch_PSO_Parameter.txt");
		fw2.write("Iteration=" + Iteration + "\r\n");
		fw2.write("Iteration_Mode=" + Iteration_Mode + "\r\n");
		fw2.write("populationSize=" + lowpopulationSize + " " + UppopulationSize + " " + StpopulationSize + "\r\n");
		fw2.write("w=" + loww + " " + Upw + " " + Stw + "\r\n");
		fw2.write("c1=" + lowc1 + " " + Upc1 + " " + Stc1 + "\r\n");
		fw2.write("c2=" + lowc2 + " " + Upc2 + " " + Stc2 + "\r\n");
		fw2.write("Vmax=" + Vmax + "\r\n");
		fw2.write("Execution_Mode=" + Execution_Mode + "\r\n");
		fw2.write("Print_Mode=" + Print_Mode + "\r\n");
		fw2.write("Write_Mode=" + Write_Mode + "\r\n");
		fw2.write("threshold=" + new BigDecimal(String.valueOf(threshold)) + "\r\n");

		// fw2.write("\r\n");
		fw2.close();

		FileWriter fw3 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path() + "\\PSO_Parameter\\APSO2\\Adaptive.txt");
		fw3.write("Adaptive_Mode_1=" + Adaptive_Mode_1 + "\r\n");
		fw3.write("Adaptive_Mode_2=" + Adaptive_Mode_2 + "\r\n");
		fw3.write("Mu=" + Mu + "\r\n");
		fw3.write("Sigma_max=" + Sigma_max + "\r\n");
		fw3.write("Sigma_min=" + Sigma_min + "\r\n");
		fw3.write("G=" + G + "\r\n");
		fw3.close();
	}

	public static void save_Batch_ALPSO(int Iteration, int Iteration_Mode, int lowpopulationSize, int UppopulationSize, int StpopulationSize, double loww, double Upw, double Stw, double lowc1, double Upc1, double Stc1, double lowc2, double Upc2, double Stc2, int Vmax, int Execution_Mode, int Print_Mode, int Write_Mode, double threshold, int R1, int R2, int R3, int R4, int R5, double Epsilonh,
			int Print) throws IOException {

		FileWriter fw2 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path() + "\\PSO_Parameter\\ALPSO\\Batch_PSO_Parameter.txt");
		fw2.write("Iteration=" + Iteration + "\r\n");
		fw2.write("Iteration_Mode=" + Iteration_Mode + "\r\n");
		fw2.write("populationSize=" + lowpopulationSize + " " + UppopulationSize + " " + StpopulationSize + "\r\n");
		fw2.write("w=" + loww + " " + Upw + " " + Stw + "\r\n");
		fw2.write("c1=" + lowc1 + " " + Upc1 + " " + Stc1 + "\r\n");
		fw2.write("c2=" + lowc2 + " " + Upc2 + " " + Stc2 + "\r\n");
		fw2.write("Vmax=" + Vmax + "\r\n");
		fw2.write("Execution_Mode=" + Execution_Mode + "\r\n");
		fw2.write("Print_Mode=" + Print_Mode + "\r\n");
		fw2.write("Write_Mode=" + Write_Mode + "\r\n");
		fw2.write("threshold=" + new BigDecimal(String.valueOf(threshold)) + "\r\n");

		// fw2.write("\r\n");
		fw2.close();

		FileWriter fw = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path() + "\\PSO_Parameter\\ALPSO\\Tourism_Penalty.txt");
		fw.write(R1 + " " + R2 + " " + R3 + " " + R4 + " " + R5);
		fw.close();

		FileWriter fw1 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path() + "\\PSO_Parameter\\ALPSO\\ALPSO__Parameter.txt");
		fw1.write("Epsilonh=" + Epsilonh + "\r\n");
		fw1.write("Print=" + Print + "\r\n");
		fw1.close();
	}

	public static void save_Batch_LRPSO(int Iteration, int Iteration_Mode, int lowpopulationSize, int UppopulationSize, int StpopulationSize, double loww, double Upw, double Stw, double lowc1, double Upc1, double Stc1, double lowc2, double Upc2, double Stc2, int Vmax, int Execution_Mode, int Print_Mode, int Write_Mode, double threshold, double L, double c, int Print) throws IOException {

		FileWriter fw2 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path() + "\\PSO_Parameter\\LRPSO\\Batch_PSO_Parameter.txt");
		fw2.write("Iteration=" + Iteration + "\r\n");
		fw2.write("Iteration_Mode=" + Iteration_Mode + "\r\n");
		fw2.write("populationSize=" + lowpopulationSize + " " + UppopulationSize + " " + StpopulationSize + "\r\n");
		fw2.write("w=" + loww + " " + Upw + " " + Stw + "\r\n");
		fw2.write("c1=" + lowc1 + " " + Upc1 + " " + Stc1 + "\r\n");
		fw2.write("c2=" + lowc2 + " " + Upc2 + " " + Stc2 + "\r\n");
		fw2.write("Vmax=" + Vmax + "\r\n");
		fw2.write("Execution_Mode=" + Execution_Mode + "\r\n");
		fw2.write("Print_Mode=" + Print_Mode + "\r\n");
		fw2.write("Write_Mode=" + Write_Mode + "\r\n");
		fw2.write("threshold=" + new BigDecimal(String.valueOf(threshold)) + "\r\n");

		// fw2.write("\r\n");
		fw2.close();

		FileWriter fw1 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path() + "\\PSO_Parameter\\LRPSO\\LRPSO_Parameter.txt");
		fw1.write("L=" + L + "\r\n");
		fw1.write("c=" + c + "\r\n");
		fw1.write("Print=" + Print + "\r\n");
		fw1.close();
	}

	public static void save_Batch_LR_and_PSO2(int Iteration, int Iteration_Mode, int lowpopulationSize, int UppopulationSize, int StpopulationSize, double loww, double Upw, double Stw, double lowc1, double Upc1, double Stc1, double lowc2, double Upc2, double Stc2, int Vmax, int Execution_Mode, int Print_Mode, int Write_Mode, double threshold, double L, double c, int Print) throws IOException {

		FileWriter fw2 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path() + "\\PSO_Parameter\\LR_and_PSO2\\Batch_PSO_Parameter.txt");
		fw2.write("Iteration=" + Iteration + "\r\n");
		fw2.write("Iteration_Mode=" + Iteration_Mode + "\r\n");
		fw2.write("populationSize=" + lowpopulationSize + " " + UppopulationSize + " " + StpopulationSize + "\r\n");
		fw2.write("w=" + loww + " " + Upw + " " + Stw + "\r\n");
		fw2.write("c1=" + lowc1 + " " + Upc1 + " " + Stc1 + "\r\n");
		fw2.write("c2=" + lowc2 + " " + Upc2 + " " + Stc2 + "\r\n");
		fw2.write("Vmax=" + Vmax + "\r\n");
		fw2.write("Execution_Mode=" + Execution_Mode + "\r\n");
		fw2.write("Print_Mode=" + Print_Mode + "\r\n");
		fw2.write("Write_Mode=" + Write_Mode + "\r\n");
		fw2.write("threshold=" + new BigDecimal(String.valueOf(threshold)) + "\r\n");

		// fw2.write("\r\n");
		fw2.close();

		FileWriter fw1 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path() + "\\PSO_Parameter\\LR_and_PSO2\\LR_Parameter.txt");
		fw1.write("L=" + L + "\r\n");
		fw1.write("c=" + c + "\r\n");
		fw1.write("Print=" + Print + "\r\n");
		fw1.close();
	}

	public static void save_Batch_LR_and_PSO1(int Iteration, int Iteration_Mode, int lowpopulationSize, int UppopulationSize, int StpopulationSize, double loww, double Upw, double Stw, double lowc1, double Upc1, double Stc1, double lowc2, double Upc2, double Stc2, int Vmax, int Execution_Mode, int Print_Mode, int Write_Mode, double threshold, int R1, int R2, int R3, int R4, int R5, double L,
			double c, int Print) throws IOException {

		FileWriter fw2 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path() + "\\PSO_Parameter\\LR_and_PSO1\\Batch_PSO_Parameter.txt");
		fw2.write("Iteration=" + Iteration + "\r\n");
		fw2.write("Iteration_Mode=" + Iteration_Mode + "\r\n");
		fw2.write("populationSize=" + lowpopulationSize + " " + UppopulationSize + " " + StpopulationSize + "\r\n");
		fw2.write("w=" + loww + " " + Upw + " " + Stw + "\r\n");
		fw2.write("c1=" + lowc1 + " " + Upc1 + " " + Stc1 + "\r\n");
		fw2.write("c2=" + lowc2 + " " + Upc2 + " " + Stc2 + "\r\n");
		fw2.write("Vmax=" + Vmax + "\r\n");
		fw2.write("Execution_Mode=" + Execution_Mode + "\r\n");
		fw2.write("Print_Mode=" + Print_Mode + "\r\n");
		fw2.write("Write_Mode=" + Write_Mode + "\r\n");
		fw2.write("threshold=" + new BigDecimal(String.valueOf(threshold)) + "\r\n");

		// fw2.write("\r\n");
		fw2.close();

		FileWriter fw = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path() + "\\PSO_Parameter\\LR_and_PSO1\\Tourism_Penalty.txt");
		fw.write(R1 + " " + R2 + " " + R3 + " " + R4 + " " + R5);
		fw.close();

		FileWriter fw1 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path() + "\\PSO_Parameter\\LR_and_PSO1\\LR_Parameter.txt");
		fw1.write("L=" + L + "\r\n");
		fw1.write("c=" + c + "\r\n");
		fw1.write("Print=" + Print + "\r\n");
		fw1.close();
	}

	public static void save_Batch_CCPSO2(int Iteration, int Iteration_Mode, int lowpopulationSize, int UppopulationSize, int StpopulationSize, double loww, double Upw, double Stw, double lowc1, double Upc1, double Stc1, double lowc2, double Upc2, double Stc2, int Vmax, int Execution_Mode, int Print_Mode, int Write_Mode, double threshold) throws IOException {

		FileWriter fw2 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path() + "\\PSO_Parameter\\CCPSO2\\Batch_PSO_Parameter.txt");
		fw2.write("populationSize=" + lowpopulationSize + " " + UppopulationSize + " " + StpopulationSize + "\r\n");
		fw2.write("w=" + loww + " " + Upw + " " + Stw + "\r\n");
		fw2.write("c1=" + lowc1 + " " + Upc1 + " " + Stc1 + "\r\n");
		fw2.write("c2=" + lowc2 + " " + Upc2 + " " + Stc2 + "\r\n");
		fw2.write("Vmax=" + Vmax + "\r\n");
		fw2.write("Execution_Mode=" + Execution_Mode + "\r\n");
		fw2.write("Print_Mode=" + Print_Mode + "\r\n");
		fw2.write("Write_Mode=" + Write_Mode + "\r\n");
		fw2.write("threshold=" + new BigDecimal(String.valueOf(threshold)) + "\r\n");

		// fw2.write("\r\n");
		fw2.close();
	}

	public static void save_Batch_PSO_LS(int Iteration, int Iteration_Mode, int lowpopulationSize, int UppopulationSize, int StpopulationSize, double loww, double Upw, double Stw, double lowc1, double Upc1, double Stc1, double lowc2, double Upc2, double Stc2, int Vmax, int Execution_Mode, int Print_Mode, int Write_Mode, double threshold, int Local_Search_Mode) throws IOException {

		FileWriter fw2 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path() + "\\PSO_Parameter\\PSO_LS\\Batch_PSO_Parameter.txt");
		fw2.write("Iteration=" + Iteration + "\r\n");
		fw2.write("Iteration_Mode=" + Iteration_Mode + "\r\n");
		fw2.write("populationSize=" + lowpopulationSize + " " + UppopulationSize + " " + StpopulationSize + "\r\n");
		fw2.write("w=" + loww + " " + Upw + " " + Stw + "\r\n");
		fw2.write("c1=" + lowc1 + " " + Upc1 + " " + Stc1 + "\r\n");
		fw2.write("c2=" + lowc2 + " " + Upc2 + " " + Stc2 + "\r\n");
		fw2.write("Vmax=" + Vmax + "\r\n");
		fw2.write("Execution_Mode=" + Execution_Mode + "\r\n");
		fw2.write("Print_Mode=" + Print_Mode + "\r\n");
		fw2.write("Write_Mode=" + Write_Mode + "\r\n");
		fw2.write("threshold=" + new BigDecimal(String.valueOf(threshold)) + "\r\n");
		fw2.write("Local_Search_Mode=" + new BigDecimal(String.valueOf(Local_Search_Mode)) + "\r\n");

		// fw2.write("\r\n");
		fw2.close();
	}

	public static void save_Batch_PSO_TS(int Iteration, int Iteration_Mode, int lowpopulationSize, int UppopulationSize, int StpopulationSize, double loww, double Upw, double Stw, double lowc1, double Upc1, double Stc1, double lowc2, double Upc2, double Stc2, int Vmax, int Execution_Mode, int Print_Mode, int Write_Mode, double threshold) throws IOException {

		FileWriter fw2 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path() + "\\PSO_Parameter\\PSO_TS\\Batch_PSO_Parameter.txt");
		fw2.write("Iteration=" + Iteration + "\r\n");
		fw2.write("Iteration_Mode=" + Iteration_Mode + "\r\n");
		fw2.write("populationSize=" + lowpopulationSize + " " + UppopulationSize + " " + StpopulationSize + "\r\n");
		fw2.write("w=" + loww + " " + Upw + " " + Stw + "\r\n");
		fw2.write("c1=" + lowc1 + " " + Upc1 + " " + Stc1 + "\r\n");
		fw2.write("c2=" + lowc2 + " " + Upc2 + " " + Stc2 + "\r\n");
		fw2.write("Vmax=" + Vmax + "\r\n");
		fw2.write("Execution_Mode=" + Execution_Mode + "\r\n");
		fw2.write("Print_Mode=" + Print_Mode + "\r\n");
		fw2.write("Write_Mode=" + Write_Mode + "\r\n");
		fw2.write("threshold=" + new BigDecimal(String.valueOf(threshold)) + "\r\n");

		// fw2.write("\r\n");
		fw2.close();
	}

	public static void saveTS(int Iteration, int Iteration_Mode, double x0, double Epsilon, int d0, int gp, int gs, int tabu_tenure_model, double ClearMaxIter, double MinTenure, double MaxTenure) throws IOException {

		// fw2.write("\r\n");

		FileWriter fw1 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path() + "\\TS\\TS_Parameter.txt");
		fw1.write("Iteration=" + Iteration + "\r\n");
		fw1.write("Iteration_Mode=" + Iteration_Mode + "\r\n");
		fw1.write("x0=" + x0 + "\r\n");
		fw1.write("Epsilon=" + Epsilon + "\r\n");
		fw1.write("d0=" + d0 + "\r\n");
		fw1.write("gp=" + gp + "\r\n");
		fw1.write("gs=" + gs + "\r\n");
		fw1.write("tabu_tenure_model=" + tabu_tenure_model + "\r\n");
		fw1.write("ClearMaxIter=" + ClearMaxIter + "\r\n");
		fw1.write("MinTenure=" + MinTenure + "\r\n");
		fw1.write("MaxTenure=" + MaxTenure + "\r\n");

		fw1.close();
	}

	public static void saveDE(int Iteration, int Iteration_Mode, int LP, int NP, double Epsilon, int Execution_Mode, int Write_Mode) throws IOException {

		FileWriter fw1 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path() + "\\DE_Parameter" + X_Select_Algorithm_Type_to_Solve_the_Problem.path() + "\\DE_Parameter.txt");
		fw1.write("Iteration=" + Iteration + "\r\n");
		fw1.write("Iteration_Mode=" + Iteration_Mode + "\r\n");
		fw1.write("LP=" + LP + "\r\n");
		fw1.write("NP=" + NP + "\r\n");
		fw1.write("Epsilon=" + Epsilon + "\r\n");
		fw1.write("Execution_Mode=" + Execution_Mode + "\r\n");
		fw1.write("Write_Mode=" + Write_Mode + "\r\n");
		fw1.close();
	}

	public static void saveDE_strategy1(int Iteration, int Iteration_Mode, int LP, int NP, double Epsilon, int Execution_Mode, int Write_Mode) throws IOException {

		FileWriter fw1 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path() + "\\DE_Parameter" + X_Select_Algorithm_Type_to_Solve_the_Problem.path() + "\\DE_Parameter.txt");
		fw1.write("Iteration=" + Iteration + "\r\n");
		fw1.write("Iteration_Mode=" + Iteration_Mode + "\r\n");
		fw1.write("LP=" + LP + "\r\n");
		fw1.write("NP=" + NP + "\r\n");
		fw1.write("Epsilon=" + Epsilon + "\r\n");
		fw1.write("Execution_Mode=" + Execution_Mode + "\r\n");
		fw1.write("Write_Mode=" + Write_Mode + "\r\n");
		fw1.close();
	}

	public static void saveDE_strategy2(int Iteration, int Iteration_Mode, int LP, int NP, double Epsilon, int Execution_Mode, int Write_Mode) throws IOException {

		FileWriter fw1 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path() + "\\DE_Parameter" + X_Select_Algorithm_Type_to_Solve_the_Problem.path() + "\\DE_Parameter.txt");
		fw1.write("Iteration=" + Iteration + "\r\n");
		fw1.write("Iteration_Mode=" + Iteration_Mode + "\r\n");
		fw1.write("LP=" + LP + "\r\n");
		fw1.write("NP=" + NP + "\r\n");
		fw1.write("Epsilon=" + Epsilon + "\r\n");
		fw1.write("Execution_Mode=" + Execution_Mode + "\r\n");
		fw1.write("Write_Mode=" + Write_Mode + "\r\n");
		fw1.close();
	}

	public static void saveDE_strategy3(int Iteration, int Iteration_Mode, int LP, int NP, double Epsilon, int Execution_Mode, int Write_Mode) throws IOException {

		FileWriter fw1 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path() + "\\DE_Parameter" + X_Select_Algorithm_Type_to_Solve_the_Problem.path() + "\\DE_Parameter.txt");
		fw1.write("Iteration=" + Iteration + "\r\n");
		fw1.write("Iteration_Mode=" + Iteration_Mode + "\r\n");
		fw1.write("LP=" + LP + "\r\n");
		fw1.write("NP=" + NP + "\r\n");
		fw1.write("Epsilon=" + Epsilon + "\r\n");
		fw1.write("Execution_Mode=" + Execution_Mode + "\r\n");
		fw1.write("Write_Mode=" + Write_Mode + "\r\n");
		fw1.close();
	}

	public static void saveDE_strategy4(int Iteration, int Iteration_Mode, int LP, int NP, double Epsilon, int Execution_Mode, int Write_Mode) throws IOException {

		FileWriter fw1 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path() + "\\DE_Parameter" + X_Select_Algorithm_Type_to_Solve_the_Problem.path() + "\\DE_Parameter.txt");
		fw1.write("Iteration=" + Iteration + "\r\n");
		fw1.write("Iteration_Mode=" + Iteration_Mode + "\r\n");
		fw1.write("LP=" + LP + "\r\n");
		fw1.write("NP=" + NP + "\r\n");
		fw1.write("Epsilon=" + Epsilon + "\r\n");
		fw1.write("Execution_Mode=" + Execution_Mode + "\r\n");
		fw1.write("Write_Mode=" + Write_Mode + "\r\n");
		fw1.close();
	}

	public static void saveDE_strategy5(int Iteration, int Iteration_Mode, int LP, int NP, double Epsilon, int Execution_Mode, int Write_Mode) throws IOException {

		FileWriter fw1 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path() + "\\DE_Parameter" + X_Select_Algorithm_Type_to_Solve_the_Problem.path() + "\\DE_Parameter.txt");
		fw1.write("Iteration=" + Iteration + "\r\n");
		fw1.write("Iteration_Mode=" + Iteration_Mode + "\r\n");
		fw1.write("LP=" + LP + "\r\n");
		fw1.write("NP=" + NP + "\r\n");
		fw1.write("Epsilon=" + Epsilon + "\r\n");
		fw1.write("Execution_Mode=" + Execution_Mode + "\r\n");
		fw1.write("Write_Mode=" + Write_Mode + "\r\n");
		fw1.close();
	}

	public static void saveDE_strategy6(int Iteration, int Iteration_Mode, int LP, int NP, double Epsilon, int Execution_Mode, int Write_Mode) throws IOException {

		FileWriter fw1 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path() + "\\DE_Parameter" + X_Select_Algorithm_Type_to_Solve_the_Problem.path() + "\\DE_Parameter.txt");
		fw1.write("Iteration=" + Iteration + "\r\n");
		fw1.write("Iteration_Mode=" + Iteration_Mode + "\r\n");
		fw1.write("LP=" + LP + "\r\n");
		fw1.write("NP=" + NP + "\r\n");
		fw1.write("Epsilon=" + Epsilon + "\r\n");
		fw1.write("Execution_Mode=" + Execution_Mode + "\r\n");
		fw1.write("Write_Mode=" + Write_Mode + "\r\n");
		fw1.close();
	}

	public static void saveDE_Real(int Iteration, int Iteration_Mode, int LP, int NP, double Epsilon, int Execution_Mode, int Write_Mode, int Vmax, double lamda) throws IOException {

		FileWriter fw1 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path() + "\\DE_Parameter" + X_Select_Algorithm_Type_to_Solve_the_Problem.path() + "\\DE_Parameter.txt");
		fw1.write("Iteration=" + Iteration + "\r\n");
		fw1.write("Iteration_Mode=" + Iteration_Mode + "\r\n");
		fw1.write("LP=" + LP + "\r\n");
		fw1.write("NP=" + NP + "\r\n");
		fw1.write("Epsilon=" + Epsilon + "\r\n");
		fw1.write("Execution_Mode=" + Execution_Mode + "\r\n");
		fw1.write("Write_Mode=" + Write_Mode + "\r\n");
		fw1.write("Vmax=" + Vmax + "\r\n");
		fw1.write("lamda=" + lamda + "\r\n");
		fw1.close();
	}

	public static void saveDE_strategy1_Real(int Iteration, int Iteration_Mode, int LP, int NP, double Epsilon, int Execution_Mode, int Write_Mode, int Vmax, double lamda) throws IOException {

		FileWriter fw1 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path() + "\\DE_Parameter" + X_Select_Algorithm_Type_to_Solve_the_Problem.path() + "\\DE_Parameter.txt");
		fw1.write("Iteration=" + Iteration + "\r\n");
		fw1.write("Iteration_Mode=" + Iteration_Mode + "\r\n");
		fw1.write("LP=" + LP + "\r\n");
		fw1.write("NP=" + NP + "\r\n");
		fw1.write("Epsilon=" + Epsilon + "\r\n");
		fw1.write("Execution_Mode=" + Execution_Mode + "\r\n");
		fw1.write("Write_Mode=" + Write_Mode + "\r\n");
		fw1.write("Vmax=" + Vmax + "\r\n");
		fw1.write("lamda=" + lamda + "\r\n");
		fw1.close();
	}

	public static void saveDE_strategy2_Real(int Iteration, int Iteration_Mode, int LP, int NP, double Epsilon, int Execution_Mode, int Write_Mode, int Vmax, double lamda) throws IOException {

		FileWriter fw1 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path() + "\\DE_Parameter" + X_Select_Algorithm_Type_to_Solve_the_Problem.path() + "\\DE_Parameter.txt");
		fw1.write("Iteration=" + Iteration + "\r\n");
		fw1.write("Iteration_Mode=" + Iteration_Mode + "\r\n");
		fw1.write("LP=" + LP + "\r\n");
		fw1.write("NP=" + NP + "\r\n");
		fw1.write("Epsilon=" + Epsilon + "\r\n");
		fw1.write("Execution_Mode=" + Execution_Mode + "\r\n");
		fw1.write("Write_Mode=" + Write_Mode + "\r\n");
		fw1.write("Vmax=" + Vmax + "\r\n");
		fw1.write("lamda=" + lamda + "\r\n");
		fw1.close();
	}

	public static void saveDE_strategy3_Real(int Iteration, int Iteration_Mode, int LP, int NP, double Epsilon, int Execution_Mode, int Write_Mode, int Vmax, double lamda) throws IOException {

		FileWriter fw1 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path() + "\\DE_Parameter" + X_Select_Algorithm_Type_to_Solve_the_Problem.path() + "\\DE_Parameter.txt");
		fw1.write("Iteration=" + Iteration + "\r\n");
		fw1.write("Iteration_Mode=" + Iteration_Mode + "\r\n");
		fw1.write("LP=" + LP + "\r\n");
		fw1.write("NP=" + NP + "\r\n");
		fw1.write("Epsilon=" + Epsilon + "\r\n");
		fw1.write("Execution_Mode=" + Execution_Mode + "\r\n");
		fw1.write("Write_Mode=" + Write_Mode + "\r\n");
		fw1.write("Vmax=" + Vmax + "\r\n");
		fw1.write("lamda=" + lamda + "\r\n");
		fw1.close();
	}

	public static void saveDE_strategy4_Real(int Iteration, int Iteration_Mode, int LP, int NP, double Epsilon, int Execution_Mode, int Write_Mode, int Vmax, double lamda) throws IOException {

		FileWriter fw1 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path() + "\\DE_Parameter" + X_Select_Algorithm_Type_to_Solve_the_Problem.path() + "\\DE_Parameter.txt");
		fw1.write("Iteration=" + Iteration + "\r\n");
		fw1.write("Iteration_Mode=" + Iteration_Mode + "\r\n");
		fw1.write("LP=" + LP + "\r\n");
		fw1.write("NP=" + NP + "\r\n");
		fw1.write("Epsilon=" + Epsilon + "\r\n");
		fw1.write("Execution_Mode=" + Execution_Mode + "\r\n");
		fw1.write("Write_Mode=" + Write_Mode + "\r\n");
		fw1.write("Vmax=" + Vmax + "\r\n");
		fw1.write("lamda=" + lamda + "\r\n");
		fw1.close();
	}

	public static void saveDE_strategy5_Real(int Iteration, int Iteration_Mode, int LP, int NP, double Epsilon, int Execution_Mode, int Write_Mode, int Vmax, double lamda) throws IOException {

		FileWriter fw1 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path() + "\\DE_Parameter" + X_Select_Algorithm_Type_to_Solve_the_Problem.path() + "\\DE_Parameter.txt");
		fw1.write("Iteration=" + Iteration + "\r\n");
		fw1.write("Iteration_Mode=" + Iteration_Mode + "\r\n");
		fw1.write("LP=" + LP + "\r\n");
		fw1.write("NP=" + NP + "\r\n");
		fw1.write("Epsilon=" + Epsilon + "\r\n");
		fw1.write("Execution_Mode=" + Execution_Mode + "\r\n");
		fw1.write("Write_Mode=" + Write_Mode + "\r\n");
		fw1.write("Vmax=" + Vmax + "\r\n");
		fw1.write("lamda=" + lamda + "\r\n");
		fw1.close();
	}

	public static void saveDE_strategy6_Real(int Iteration, int Iteration_Mode, int LP, int NP, double Epsilon, int Execution_Mode, int Write_Mode, int Vmax, double lamda) throws IOException {

		FileWriter fw1 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path() + "\\DE_Parameter" + X_Select_Algorithm_Type_to_Solve_the_Problem.path() + "\\DE_Parameter.txt");
		fw1.write("Iteration=" + Iteration + "\r\n");
		fw1.write("Iteration_Mode=" + Iteration_Mode + "\r\n");
		fw1.write("LP=" + LP + "\r\n");
		fw1.write("NP=" + NP + "\r\n");
		fw1.write("Epsilon=" + Epsilon + "\r\n");
		fw1.write("Execution_Mode=" + Execution_Mode + "\r\n");
		fw1.write("Write_Mode=" + Write_Mode + "\r\n");
		fw1.write("Vmax=" + Vmax + "\r\n");
		fw1.write("lamda=" + lamda + "\r\n");
		fw1.close();
	}

	public static void saveNSDE(int Iteration, int Iteration_Mode, int LP, int NP, int Execution_Mode, int Write_Mode, int Vmax, double lamda) throws IOException {

		FileWriter fw1 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path() + "\\DE_Parameter" + X_Select_Algorithm_Type_to_Solve_the_Problem.path() + "\\DE_Parameter.txt");
		fw1.write("Iteration=" + Iteration + "\r\n");
		fw1.write("Iteration_Mode=" + Iteration_Mode + "\r\n");
		fw1.write("LP=" + LP + "\r\n");
		fw1.write("NP=" + NP + "\r\n");

		fw1.write("Execution_Mode=" + Execution_Mode + "\r\n");
		fw1.write("Write_Mode=" + Write_Mode + "\r\n");
		fw1.write("Vmax=" + Vmax + "\r\n");
		fw1.write("lamda=" + lamda + "\r\n");
		fw1.close();
	}

	public static void saveSaNSDE(int Iteration, int Iteration_Mode, int LP, int NP, int Execution_Mode, int Write_Mode, int Vmax, double lamda) throws IOException {

		FileWriter fw1 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path() + "\\DE_Parameter" + X_Select_Algorithm_Type_to_Solve_the_Problem.path() + "\\DE_Parameter.txt");
		fw1.write("Iteration=" + Iteration + "\r\n");
		fw1.write("Iteration_Mode=" + Iteration_Mode + "\r\n");
		fw1.write("LP=" + LP + "\r\n");
		fw1.write("NP=" + NP + "\r\n");

		fw1.write("Execution_Mode=" + Execution_Mode + "\r\n");
		fw1.write("Write_Mode=" + Write_Mode + "\r\n");
		fw1.write("Vmax=" + Vmax + "\r\n");
		fw1.write("lamda=" + lamda + "\r\n");
		fw1.close();
	}

	public static void saveDECC(int Iteration, int Iteration_Mode,
			int NP, int LP, int FEs, int Execution_Mode, int Write_Mode,
			int Vmax, double lamda) throws IOException {

		FileWriter fw1 = new FileWriter(
				I_Set_Paths_for_Current_Simulation_Example.path()
						+ "\\DE_Parameter"
						+ X_Select_Algorithm_Type_to_Solve_the_Problem.path()
						+ "\\DE_Parameter.txt");
		fw1.write("Iteration=" + Iteration + "\r\n");
		fw1.write("Iteration_Mode=" + Iteration_Mode + "\r\n");
		fw1.write("NP=" + NP + "\r\n");
		fw1.write("LP=" + LP + "\r\n");
		fw1.write("FEs=" + FEs + "\r\n");
		fw1.write("Execution_Mode=" + Execution_Mode + "\r\n");
		fw1.write("Write_Mode=" + Write_Mode + "\r\n");
		fw1.write("Vmax=" + Vmax + "\r\n");
		fw1.write("lamda=" + lamda + "\r\n");
		fw1.close();
	}

	public static void saveDE_Real_POP(int Iteration, int Iteration_Mode, int NP,
			int LP, double Epsilon, int Execution_Mode, int Write_Mode,
			int Vmax, double lamda, int Pmax) throws IOException {

		FileWriter fw1 = new FileWriter(
				I_Set_Paths_for_Current_Simulation_Example.path()
						+ "\\DE_Parameter"
						+ X_Select_Algorithm_Type_to_Solve_the_Problem.path()
						+ "\\DE_Parameter.txt");
		fw1.write("Iteration=" + Iteration + "\r\n");
		fw1.write("Iteration_Mode=" + Iteration_Mode + "\r\n");
		fw1.write("NP=" + NP + "\r\n");
		fw1.write("LP=" + LP + "\r\n");
		fw1.write("Epsilon=" + Epsilon + "\r\n");
		fw1.write("Execution_Mode=" + Execution_Mode + "\r\n");
		fw1.write("Write_Mode=" + Write_Mode + "\r\n");
		fw1.write("Vmax=" + Vmax + "\r\n");
		fw1.write("lamda=" + lamda + "\r\n");
		fw1.write("Pmax=" + Pmax + "\r\n");
		fw1.close();
	}

	public static void saveDE_Real_POP_NEW(int Iteration, int Iteration_Mode, int NP,
			int LP, double Epsilon, int Execution_Mode, int Write_Mode,
			int Vmax, double lamda, int Pmax, double Pi) throws IOException {

		FileWriter fw1 = new FileWriter(
				I_Set_Paths_for_Current_Simulation_Example.path()
						+ "\\DE_Parameter"
						+ X_Select_Algorithm_Type_to_Solve_the_Problem.path()
						+ "\\DE_Parameter.txt");
		fw1.write("Iteration=" + Iteration + "\r\n");
		fw1.write("Iteration_Mode=" + Iteration_Mode + "\r\n");
		fw1.write("NP=" + NP + "\r\n");
		fw1.write("LP=" + LP + "\r\n");
		fw1.write("Epsilon=" + Epsilon + "\r\n");
		fw1.write("Execution_Mode=" + Execution_Mode + "\r\n");
		fw1.write("Write_Mode=" + Write_Mode + "\r\n");
		fw1.write("Vmax=" + Vmax + "\r\n");
		fw1.write("lamda=" + lamda + "\r\n");
		fw1.write("Pmax=" + Pmax + "\r\n");
		fw1.write("Pi=" + Pi + "\r\n");
		fw1.close();
	}

	public static void saveDynDE(int Iteration, int Iteration_Mode,
			int NP, int Execution_Mode, int Write_Mode,
			int Vmax, double lamda, double rcloud, double Sigma) throws IOException {

		FileWriter fw1 = new FileWriter(
				I_Set_Paths_for_Current_Simulation_Example.path()
						+ "\\DE_Parameter"
						+ X_Select_Algorithm_Type_to_Solve_the_Problem.path()
						+ "\\DE_Parameter.txt");
		fw1.write("Iteration=" + Iteration + "\r\n");
		fw1.write("Iteration_Mode=" + Iteration_Mode + "\r\n");
		fw1.write("NP=" + NP + "\r\n");
		// fw1.write("LP=" + LP + "\r\n");

		fw1.write("Execution_Mode=" + Execution_Mode + "\r\n");
		fw1.write("Write_Mode=" + Write_Mode + "\r\n");
		fw1.write("Vmax=" + Vmax + "\r\n");
		fw1.write("lamda=" + lamda + "\r\n");
		fw1.write("rcloud=" + rcloud + "\r\n");
		fw1.write("Sigma=" + Sigma + "\r\n");
		fw1.close();
	}

	public static void saveDynDE_POP(int Iteration, int Iteration_Mode,
			int NP, int Execution_Mode, int Write_Mode,
			int Vmax, double lamda, double rcloud, double Sigma, int Pmax,
			int S, int Mode1, int Mode2, int Mode3, int Mode4) throws IOException {

		FileWriter fw1 = new FileWriter(
				I_Set_Paths_for_Current_Simulation_Example.path()
						+ "\\DE_Parameter"
						+ X_Select_Algorithm_Type_to_Solve_the_Problem.path()
						+ "\\DE_Parameter.txt");
		fw1.write("Iteration=" + Iteration + "\r\n");
		fw1.write("Iteration_Mode=" + Iteration_Mode + "\r\n");
		fw1.write("NP=" + NP + "\r\n");
		// fw1.write("LP=" + LP + "\r\n");

		fw1.write("Execution_Mode=" + Execution_Mode + "\r\n");
		fw1.write("Write_Mode=" + Write_Mode + "\r\n");
		fw1.write("Vmax=" + Vmax + "\r\n");
		fw1.write("lamda=" + lamda + "\r\n");
		fw1.write("rcloud=" + rcloud + "\r\n");
		fw1.write("Sigma=" + Sigma + "\r\n");
		fw1.write("Pmax=" + Pmax + "\r\n");
		fw1.write("S=" + S + "\r\n");
		fw1.write("Mode1=" + Mode1 + "\r\n");
		fw1.write("Mode2=" + Mode2 + "\r\n");
		fw1.write("Mode3=" + Mode3 + "\r\n");
		fw1.write("Mode4=" + Mode4 + "\r\n");
		fw1.close();
	}

	public static void saveALPSO2_NEW(int Iteration, int Iteration_Mode, int populationSize, double w, double c1, double c2, int Vmax, int Execution_Mode, int Print_Mode, int Write_Mode, double threshold, double PSO_lamda, double Prob_candidate, int Local_Search_Iteration) throws IOException {

		FileWriter fw2 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path() + "\\PSO_Parameter" + X_Select_Algorithm_Type_to_Solve_the_Problem.path() + "PSO_Parameter.txt");
		fw2.write("Iteration=" + Iteration + "\r\n");
		fw2.write("Iteration_Mode=" + Iteration_Mode + "\r\n");
		fw2.write("populationSize=" + populationSize + "\r\n");
		fw2.write("w=" + w + "\r\n");
		fw2.write("c1=" + c1 + "\r\n");
		fw2.write("c2=" + c2 + "\r\n");
		fw2.write("Vmax=" + Vmax + "\r\n");
		fw2.write("Execution_Mode=" + Execution_Mode + "\r\n");
		fw2.write("Print_Mode=" + Print_Mode + "\r\n");
		fw2.write("Write_Mode=" + Write_Mode + "\r\n");

		fw2.write("threshold=" + new BigDecimal(String.valueOf(threshold)) + "\r\n");
		fw2.write("PSO_lamda=" + new BigDecimal(String.valueOf(PSO_lamda)) + "\r\n");
		fw2.write("Prob_candidate=" + Prob_candidate + "\r\n");
		fw2.write("Local_Search_Iteration=" + Local_Search_Iteration + "\r\n");

		// fw2.write("\r\n");
		fw2.close();

	}

	public static void saveALPSO2_NEW_PrematureConvegence1(int Iteration, int Iteration_Mode, int populationSize, double w, double c1, double c2, int Vmax, int Execution_Mode, int Print_Mode, int Write_Mode, double threshold, double PSO_lamda, double Prob_candidate, int Local_Search_Iteration) throws IOException {

		FileWriter fw2 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path() + "\\PSO_Parameter" + X_Select_Algorithm_Type_to_Solve_the_Problem.path() + "PSO_Parameter.txt");
		fw2.write("Iteration=" + Iteration + "\r\n");
		fw2.write("Iteration_Mode=" + Iteration_Mode + "\r\n");
		fw2.write("populationSize=" + populationSize + "\r\n");
		fw2.write("w=" + w + "\r\n");
		fw2.write("c1=" + c1 + "\r\n");
		fw2.write("c2=" + c2 + "\r\n");
		fw2.write("Vmax=" + Vmax + "\r\n");
		fw2.write("Execution_Mode=" + Execution_Mode + "\r\n");
		fw2.write("Print_Mode=" + Print_Mode + "\r\n");
		fw2.write("Write_Mode=" + Write_Mode + "\r\n");

		fw2.write("threshold=" + new BigDecimal(String.valueOf(threshold)) + "\r\n");
		fw2.write("PSO_lamda=" + new BigDecimal(String.valueOf(PSO_lamda)) + "\r\n");
		fw2.write("Prob_candidate=" + Prob_candidate + "\r\n");
		fw2.write("Local_Search_Iteration=" + Local_Search_Iteration + "\r\n");
		// fw2.write("\r\n");
		fw2.close();

	}

	public static void saveDMS_L_PSO2(int Iteration, int Iteration_Mode, int populationSize, double w, double c1, double c2, int Vmax, int Execution_Mode, int Print_Mode, int Write_Mode, double threshold, double PSO_lamda, int R, int L, int Local_Search_Iteration) throws IOException {

		FileWriter fw2 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path() + "\\PSO_Parameter" + X_Select_Algorithm_Type_to_Solve_the_Problem.path() + "PSO_Parameter.txt");
		fw2.write("Iteration=" + Iteration + "\r\n");
		fw2.write("Iteration_Mode=" + Iteration_Mode + "\r\n");
		fw2.write("populationSize=" + populationSize + "\r\n");
		fw2.write("w=" + w + "\r\n");
		fw2.write("c1=" + c1 + "\r\n");
		fw2.write("c2=" + c2 + "\r\n");
		fw2.write("Vmax=" + Vmax + "\r\n");
		fw2.write("Execution_Mode=" + Execution_Mode + "\r\n");
		fw2.write("Print_Mode=" + Print_Mode + "\r\n");
		fw2.write("Write_Mode=" + Write_Mode + "\r\n");

		fw2.write("threshold=" + new BigDecimal(String.valueOf(threshold)) + "\r\n");
		fw2.write("PSO_lamda=" + new BigDecimal(String.valueOf(PSO_lamda)) + "\r\n");
		fw2.write("R=" + R + "\r\n");
		fw2.write("L=" + L + "\r\n");
		fw2.write("Local_Search_Iteration=" + Local_Search_Iteration + "\r\n");

		// fw2.write("\r\n");
		fw2.close();

	}

	public static void saveDMSDL_PSO2(int Iteration, int Iteration_Mode, int populationSize, double w, double c1, double c2, int Vmax, int Execution_Mode, int Print_Mode, int Write_Mode, double threshold, double PSO_lamda, int R, int L, int Local_Search_Iteration) throws IOException {

		FileWriter fw2 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path() + "\\PSO_Parameter" + X_Select_Algorithm_Type_to_Solve_the_Problem.path() + "PSO_Parameter.txt");
		fw2.write("Iteration=" + Iteration + "\r\n");
		fw2.write("Iteration_Mode=" + Iteration_Mode + "\r\n");
		fw2.write("populationSize=" + populationSize + "\r\n");
		fw2.write("w=" + w + "\r\n");
		fw2.write("c1=" + c1 + "\r\n");
		fw2.write("c2=" + c2 + "\r\n");
		fw2.write("Vmax=" + Vmax + "\r\n");
		fw2.write("Execution_Mode=" + Execution_Mode + "\r\n");
		fw2.write("Print_Mode=" + Print_Mode + "\r\n");
		fw2.write("Write_Mode=" + Write_Mode + "\r\n");

		fw2.write("threshold=" + new BigDecimal(String.valueOf(threshold)) + "\r\n");
		fw2.write("PSO_lamda=" + new BigDecimal(String.valueOf(PSO_lamda)) + "\r\n");
		fw2.write("R=" + R + "\r\n");
		fw2.write("L=" + L + "\r\n");
		fw2.write("Local_Search_Iteration=" + Local_Search_Iteration + "\r\n");

		// fw2.write("\r\n");
		fw2.close();

	}

	public static void saveNLPSO2(int Iteration, int Iteration_Mode, int populationSize, double w, double c1, int Vmax, int Execution_Mode, int Print_Mode, int Write_Mode, double threshold, double PSO_lamda, double prand, double psm, double Rfl, double Rfu) throws IOException {

		FileWriter fw2 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path() + "\\PSO_Parameter" + X_Select_Algorithm_Type_to_Solve_the_Problem.path() + "PSO_Parameter.txt");
		fw2.write("Iteration=" + Iteration + "\r\n");
		fw2.write("Iteration_Mode=" + Iteration_Mode + "\r\n");
		fw2.write("populationSize=" + populationSize + "\r\n");
		fw2.write("w=" + w + "\r\n");
		fw2.write("c1=" + c1 + "\r\n");
		// fw2.write("c2="+c2+ "\r\n");
		fw2.write("Vmax=" + Vmax + "\r\n");
		fw2.write("Execution_Mode=" + Execution_Mode + "\r\n");
		fw2.write("Print_Mode=" + Print_Mode + "\r\n");
		fw2.write("Write_Mode=" + Write_Mode + "\r\n");

		fw2.write("threshold=" + new BigDecimal(String.valueOf(threshold)) + "\r\n");
		fw2.write("PSO_lamda=" + new BigDecimal(String.valueOf(PSO_lamda)) + "\r\n");
		fw2.write("prand=" + prand + "\r\n");
		fw2.write("psm=" + psm + "\r\n");
		fw2.write("Rfl=" + Rfl + "\r\n");
		fw2.write("Rfu=" + Rfu + "\r\n");
		// fw2.write("\r\n");
		fw2.close();

	}

	public static void saveCLPSO2(int Iteration, int Iteration_Mode,
			int populationSize, double w, double c1, double c2, int Vmax,
			int Execution_Mode, int Print_Mode, int Write_Mode,
			double threshold, double PSO_lamda, double Pc) throws IOException {

		FileWriter fw2 = new FileWriter(
				I_Set_Paths_for_Current_Simulation_Example.path()
						+ "\\PSO_Parameter\\CLPSO2\\PSO_Parameter.txt");
		fw2.write("Iteration=" + Iteration + "\r\n");
		fw2.write("Iteration_Mode=" + Iteration_Mode + "\r\n");
		fw2.write("populationSize=" + populationSize + "\r\n");
		fw2.write("w=" + w + "\r\n");
		fw2.write("c1=" + c1 + "\r\n");
		fw2.write("c2=" + c2 + "\r\n");
		fw2.write("Vmax=" + Vmax + "\r\n");
		fw2.write("Execution_Mode=" + Execution_Mode + "\r\n");
		fw2.write("Print_Mode=" + Print_Mode + "\r\n");
		fw2.write("Write_Mode=" + Write_Mode + "\r\n");

		fw2.write("threshold=" + new BigDecimal(String.valueOf(threshold))
				+ "\r\n");
		fw2.write("PSO_lamda=" + new BigDecimal(String.valueOf(PSO_lamda))
				+ "\r\n");
		fw2.write("Pc=" + Pc + "\r\n");
		// fw2.write("\r\n");
		fw2.close();

	}

	public static void saveCC_CLPSO2(int Iteration, int Iteration_Mode,
			int populationSize, double w, double c1, double c2, int Vmax,
			int Execution_Mode, int Print_Mode, int Write_Mode,
			double threshold, double PSO_lamda, double Pc) throws IOException {

		FileWriter fw2 = new FileWriter(
				I_Set_Paths_for_Current_Simulation_Example.path()
						+ "\\PSO_Parameter\\CC-CLPSO2\\PSO_Parameter.txt");
		fw2.write("Iteration=" + Iteration + "\r\n");
		fw2.write("Iteration_Mode=" + Iteration_Mode + "\r\n");
		fw2.write("populationSize=" + populationSize + "\r\n");
		fw2.write("w=" + w + "\r\n");
		fw2.write("c1=" + c1 + "\r\n");
		fw2.write("c2=" + c2 + "\r\n");
		fw2.write("Vmax=" + Vmax + "\r\n");
		fw2.write("Execution_Mode=" + Execution_Mode + "\r\n");
		fw2.write("Print_Mode=" + Print_Mode + "\r\n");
		fw2.write("Write_Mode=" + Write_Mode + "\r\n");

		fw2.write("threshold=" + new BigDecimal(String.valueOf(threshold))
				+ "\r\n");
		fw2.write("PSO_lamda=" + new BigDecimal(String.valueOf(PSO_lamda))
				+ "\r\n");
		fw2.write("Pc=" + Pc + "\r\n");
		// fw2.write("\r\n");
		fw2.close();

	}

	public static void saveFA_PSO(int Iteration, int Iteration_Mode,
			int populationSize, double w, double c1, double c2, int Vmax,
			int Execution_Mode, int Print_Mode, int Write_Mode,
			double threshold, double B0, double Gamma, double Alpha)
			throws IOException {

		FileWriter fw2 = new FileWriter(
				I_Set_Paths_for_Current_Simulation_Example.path()
						+ "\\FA\\FA_PSO\\FA_Parameter.txt");
		fw2.write("Iteration=" + Iteration + "\r\n");
		fw2.write("Iteration_Mode=" + Iteration_Mode + "\r\n");
		fw2.write("populationSize=" + populationSize + "\r\n");
		fw2.write("w=" + w + "\r\n");
		fw2.write("c1=" + c1 + "\r\n");
		fw2.write("c2=" + c2 + "\r\n");
		fw2.write("Vmax=" + Vmax + "\r\n");
		fw2.write("Execution_Mode=" + Execution_Mode + "\r\n");
		fw2.write("Print_Mode=" + Print_Mode + "\r\n");
		fw2.write("Write_Mode=" + Write_Mode + "\r\n");
		fw2.write("threshold=" + new BigDecimal(String.valueOf(threshold))
				+ "\r\n");
		fw2.write("B0=" + B0 + "\r\n");
		fw2.write("Gamma=" + Gamma + "\r\n");
		fw2.write("Alpha=" + Alpha + "\r\n");
		// fw2.write("\r\n");
		fw2.close();

	}

	public static void saveFA(int Iteration, int Iteration_Mode,
			int populationSize, int Execution_Mode, int Print_Mode,
			int Write_Mode, double threshold, double B0, double Gamma,
			double Alpha) throws IOException {

		FileWriter fw2 = new FileWriter(
				I_Set_Paths_for_Current_Simulation_Example.path()
						+ "\\FA\\FA\\FA_Parameter.txt");
		fw2.write("Iteration=" + Iteration + "\r\n");
		fw2.write("Iteration_Mode=" + Iteration_Mode + "\r\n");
		fw2.write("populationSize=" + populationSize + "\r\n");
		/*
		 * fw2.write("w="+w+"\r\n"); fw2.write("c1="+c1+"\r\n");
		 * fw2.write("c2="+c2+ "\r\n"); fw2.write("Vmax="+Vmax+ "\r\n");
		 */
		fw2.write("B0=" + B0 + "\r\n");
		fw2.write("Gamma=" + Gamma + "\r\n");
		fw2.write("Alpha=" + Alpha + "\r\n");
		fw2.write("Execution_Mode=" + Execution_Mode + "\r\n");
		fw2.write("Print_Mode=" + Print_Mode + "\r\n");
		fw2.write("Write_Mode=" + Write_Mode + "\r\n");
		fw2.write("threshold=" + new BigDecimal(String.valueOf(threshold))
				+ "\r\n");

		// fw2.write("\r\n");
		fw2.close();

	}


	public static void saveL_SHADE(int Iteration, int Iteration_Mode,
			int NP, int LP,  int Execution_Mode, int Write_Mode,
			int Vmax, double lamda,int H,double Max_NFE,int Nmin,double MCR,double MF) throws IOException {

		FileWriter fw1 = new FileWriter(
				I_Set_Paths_for_Current_Simulation_Example.path()
						+ "\\DE_Parameter"
						+ X_Select_Algorithm_Type_to_Solve_the_Problem.path()
						+ "\\DE_Parameter.txt");
		fw1.write("Iteration=" + Iteration + "\r\n");
		fw1.write("Iteration_Mode=" + Iteration_Mode + "\r\n");
		fw1.write("NP=" + NP + "\r\n");
		fw1.write("LP=" + LP + "\r\n");
		
		fw1.write("Execution_Mode=" + Execution_Mode + "\r\n");
		fw1.write("Write_Mode=" + Write_Mode + "\r\n");
		fw1.write("Vmax=" + Vmax + "\r\n");
		fw1.write("lamda=" + lamda + "\r\n");
		fw1.write("H=" + H + "\r\n");
		fw1.write("Max_NFE=" + Max_NFE + "\r\n");
		fw1.write("Nmin=" + Nmin + "\r\n");
		fw1.write("MCR=" + MCR + "\r\n");
		fw1.write("MF=" + MF + "\r\n");
		fw1.close();
	}

	public static void saveL_SHADE_CCPSO2(int Iteration, int Iteration_Mode,
			int populationSize, double w, double c1, double c2, int Vmax,
			int Execution_Mode, int Print_Mode, int Write_Mode,
			double threshold, double PSO_lamda, double Alpha1, double Alpha2,
			double Alpha3,int H) throws IOException {

		FileWriter fw2 = new FileWriter(
				I_Set_Paths_for_Current_Simulation_Example.path()
						+ "\\PSO_Parameter\\L_SHADE_CCPSO2\\PSO_Parameter.txt");
		fw2.write("Iteration=" + Iteration + "\r\n");
		fw2.write("Iteration_Mode=" + Iteration_Mode + "\r\n");
		fw2.write("populationSize=" + populationSize + "\r\n");
		fw2.write("w=" + w + "\r\n");
		fw2.write("c1=" + c1 + "\r\n");
		fw2.write("c2=" + c2 + "\r\n");
		fw2.write("Vmax=" + Vmax + "\r\n");
		fw2.write("Execution_Mode=" + Execution_Mode + "\r\n");
		fw2.write("Print_Mode=" + Print_Mode + "\r\n");
		fw2.write("Write_Mode=" + Write_Mode + "\r\n");
		fw2.write("threshold=" + new BigDecimal(String.valueOf(threshold))
				+ "\r\n");
		fw2.write("PSO_lamda=" + new BigDecimal(String.valueOf(PSO_lamda))
				+ "\r\n");
		fw2.write("Alpha1=" + new BigDecimal(String.valueOf(Alpha1)) + "\r\n");
		fw2.write("Alpha2=" + new BigDecimal(String.valueOf(Alpha2)) + "\r\n");
		fw2.write("Alpha3=" + new BigDecimal(String.valueOf(Alpha3)) + "\r\n");
		fw2.write("H=" + H + "\r\n");
		// fw2.write("\r\n");
		fw2.close();

	}
	
	public static void saveNSDE_POP(int Iteration, int Iteration_Mode,
			int NP, int LP,  int Execution_Mode, int Write_Mode,
			int Vmax, double lamda,int Pmax) throws IOException {

		FileWriter fw1 = new FileWriter(
				I_Set_Paths_for_Current_Simulation_Example.path()
						+ "\\DE_Parameter"
						+ X_Select_Algorithm_Type_to_Solve_the_Problem.path()
						+ "\\DE_Parameter.txt");
		fw1.write("Iteration=" + Iteration + "\r\n");
		fw1.write("Iteration_Mode=" + Iteration_Mode + "\r\n");
		fw1.write("NP=" + NP + "\r\n");
		fw1.write("LP=" + LP + "\r\n");
		
		fw1.write("Execution_Mode=" + Execution_Mode + "\r\n");
		fw1.write("Write_Mode=" + Write_Mode + "\r\n");
		fw1.write("Vmax=" + Vmax + "\r\n");
		fw1.write("lamda=" + lamda + "\r\n");
		fw1.write("Pmax=" + Pmax + "\r\n");
		fw1.close();
	}
	public static void saveSaNSDE_POP(int Iteration, int Iteration_Mode,
			int NP, int LP,  int Execution_Mode, int Write_Mode,
			int Vmax, double lamda,int Pmax) throws IOException {

		FileWriter fw1 = new FileWriter(
				I_Set_Paths_for_Current_Simulation_Example.path()
						+ "\\DE_Parameter"
						+ X_Select_Algorithm_Type_to_Solve_the_Problem.path()
						+ "\\DE_Parameter.txt");
		fw1.write("Iteration=" + Iteration + "\r\n");
		fw1.write("Iteration_Mode=" + Iteration_Mode + "\r\n");
		fw1.write("NP=" + NP + "\r\n");
		fw1.write("LP=" + LP + "\r\n");
		
		fw1.write("Execution_Mode=" + Execution_Mode + "\r\n");
		fw1.write("Write_Mode=" + Write_Mode + "\r\n");
		fw1.write("Vmax=" + Vmax + "\r\n");
		fw1.write("lamda=" + lamda + "\r\n");
		fw1.write("Pmax=" + Pmax + "\r\n");
		fw1.close();
	}
	public static void saveDECC_POP(int Iteration, int Iteration_Mode,
			int NP, int LP,int FEs,  int Execution_Mode, int Write_Mode,
			int Vmax, double lamda,int Pmax) throws IOException {

		FileWriter fw1 = new FileWriter(
				I_Set_Paths_for_Current_Simulation_Example.path()
						+ "\\DE_Parameter"
						+ X_Select_Algorithm_Type_to_Solve_the_Problem.path()
						+ "\\DE_Parameter.txt");
		fw1.write("Iteration=" + Iteration + "\r\n");
		fw1.write("Iteration_Mode=" + Iteration_Mode + "\r\n");
		fw1.write("NP=" + NP + "\r\n");
		fw1.write("LP=" + LP + "\r\n");
		fw1.write("FEs=" + FEs + "\r\n");
		fw1.write("Execution_Mode=" + Execution_Mode + "\r\n");
		fw1.write("Write_Mode=" + Write_Mode + "\r\n");
		fw1.write("Vmax=" + Vmax + "\r\n");
		fw1.write("lamda=" + lamda + "\r\n");
		fw1.write("Pmax=" + Pmax + "\r\n");
		
		fw1.close();
	}
	public static void saveNSDE_POP_NEW(int Iteration, int Iteration_Mode,
			int NP, int LP,  int Execution_Mode, int Write_Mode,
			int Vmax, double lamda,int Pmax,double Pi) throws IOException {

		FileWriter fw1 = new FileWriter(
				I_Set_Paths_for_Current_Simulation_Example.path()
						+ "\\DE_Parameter"
						+ X_Select_Algorithm_Type_to_Solve_the_Problem.path()
						+ "\\DE_Parameter.txt");
		fw1.write("Iteration=" + Iteration + "\r\n");
		fw1.write("Iteration_Mode=" + Iteration_Mode + "\r\n");
		fw1.write("NP=" + NP + "\r\n");
		fw1.write("LP=" + LP + "\r\n");
		
		fw1.write("Execution_Mode=" + Execution_Mode + "\r\n");
		fw1.write("Write_Mode=" + Write_Mode + "\r\n");
		fw1.write("Vmax=" + Vmax + "\r\n");
		fw1.write("lamda=" + lamda + "\r\n");
		fw1.write("Pmax=" + Pmax + "\r\n");
		fw1.write("Pi=" + Pi + "\r\n");
		fw1.close();
	}
	public static void saveSaNSDE_POP_NEW(int Iteration, int Iteration_Mode,
			int NP, int LP,  int Execution_Mode, int Write_Mode,
			int Vmax, double lamda,int Pmax,double Pi) throws IOException {

		FileWriter fw1 = new FileWriter(
				I_Set_Paths_for_Current_Simulation_Example.path()
						+ "\\DE_Parameter"
						+ X_Select_Algorithm_Type_to_Solve_the_Problem.path()
						+ "\\DE_Parameter.txt");
		fw1.write("Iteration=" + Iteration + "\r\n");
		fw1.write("Iteration_Mode=" + Iteration_Mode + "\r\n");
		fw1.write("NP=" + NP + "\r\n");
		fw1.write("LP=" + LP + "\r\n");
		
		fw1.write("Execution_Mode=" + Execution_Mode + "\r\n");
		fw1.write("Write_Mode=" + Write_Mode + "\r\n");
		fw1.write("Vmax=" + Vmax + "\r\n");
		fw1.write("lamda=" + lamda + "\r\n");
		fw1.write("Pmax=" + Pmax + "\r\n");
		fw1.write("Pi=" + Pi + "\r\n");
		fw1.close();
	}
	public static void saveDECC_POP_NEW(int Iteration, int Iteration_Mode,
			int NP, int LP,int FEs,  int Execution_Mode, int Write_Mode,
			int Vmax, double lamda,int Pmax,double Pi) throws IOException {

		FileWriter fw1 = new FileWriter(
				I_Set_Paths_for_Current_Simulation_Example.path()
						+ "\\DE_Parameter"
						+ X_Select_Algorithm_Type_to_Solve_the_Problem.path()
						+ "\\DE_Parameter.txt");
		fw1.write("Iteration=" + Iteration + "\r\n");
		fw1.write("Iteration_Mode=" + Iteration_Mode + "\r\n");
		fw1.write("NP=" + NP + "\r\n");
		fw1.write("LP=" + LP + "\r\n");
		fw1.write("FEs=" + FEs + "\r\n");
		fw1.write("Execution_Mode=" + Execution_Mode + "\r\n");
		fw1.write("Write_Mode=" + Write_Mode + "\r\n");
		fw1.write("Vmax=" + Vmax + "\r\n");
		fw1.write("lamda=" + lamda + "\r\n");
		fw1.write("Pmax=" + Pmax + "\r\n");
		fw1.write("Pi=" + Pi + "\r\n");
		
		fw1.close();
	}
	
}
