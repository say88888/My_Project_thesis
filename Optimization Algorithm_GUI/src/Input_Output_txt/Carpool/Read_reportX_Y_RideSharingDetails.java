package Input_Output_txt.Carpool;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import GUI.I_Set_Paths_for_Current_Simulation_Example;
import GUI.GUI_Carpool.X_Select_Algorithm_Type_to_Solve_the_Problem;

public class Read_reportX_Y_RideSharingDetails {
	private static int[] Xd;
	private static int[] Xj;
	private static int[] X;
	private static int X_length;
	private static int[] Yp;
	private static int[] Yh;
	private static int[] Y;
	private static int Y_length;
	private static String[][] onoff;
	private static double[][] B;
	private static double[][] r;
	private static double[][] Br;
	private static double[][] Bids;
	private static double[][] reward;
	private static double[][] reback;
	private static double[][] reward2;
	private static double[][] reback2;
	private static double[][] reward3;
	private static double[][] reback3;
	private static double[][] reward4;
	private static double[][] reback4;
	private static double[][] distance;
	private static int[][] time;
	private static double[][] distance_Ratio;
	
	private static int n,n1;
	private static ArrayList<Integer> k1 = new ArrayList<Integer>();
	
	public static void main( ) throws IOException {
	 
		String str;
		Vector<String[]> str_vec = new Vector<String[]>(); // 暫存
		int k = 0;

		FileReader ReportXfr = new FileReader("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"ReportX.txt");
		BufferedReader ReportXbr = new BufferedReader(ReportXfr);
		while ((str = ReportXbr.readLine()) != null) {
			k++;
			str_vec.add(str.split(" "));
		}
		ReportXfr.close();
		Xd = new int[k];
		Xj = new int[k];
		X = new int[k];
		X_length=k;
		String Parameter[][] = new String[str_vec.size()][]; // 產生二維陣列,
																// 依據暫存的size(txt檔的行數)
		for (int i = 0; i < str_vec.size(); i++)
			Parameter[i] = str_vec.elementAt(i); // 將暫存區每一個元素(一行裡的字串陣列)放入二維陣列
		for (int i = 0; i < Parameter.length; i++) {
			for (int j = 0; j < Parameter[i].length; j++) {
				Xd[i] = Integer.parseInt(Parameter[i][0]);
				Xj[i] = Integer.parseInt(Parameter[i][1]);
				X[i] = Integer.parseInt(Parameter[i][2]);
			}
		}

		String str1;
		Vector<String[]> str_vec1 = new Vector<String[]>(); // 暫存
		k = 0;

		FileReader ReportYfr = new FileReader("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"ReportY.txt");
		
		BufferedReader ReportYbr = new BufferedReader(ReportYfr);
		while ((str1 = ReportYbr.readLine()) != null) {
			k++;
			str_vec1.add(str1.split(" "));
		}
		ReportYfr.close();
		Yp = new int[k];
		Yh = new int[k];
		Y = new int[k];
		Y_length=k;
		String Parameter1[][] = new String[str_vec1.size()][]; // 產生二維陣列,
																// 依據暫存的size(txt檔的行數)

		for (int i = 0; i < str_vec1.size(); i++)
			Parameter1[i] = str_vec1.elementAt(i); // 將暫存區每一個元素(一行裡的字串陣列)放入二維陣列
		for (int i = 0; i < Parameter1.length; i++) {
			for (int j = 0; j < Parameter1[i].length; j++) {
				Yp[i] = Integer.parseInt(Parameter1[i][0]);
				Yh[i] = Integer.parseInt(Parameter1[i][1]);
				Y[i] = Integer.parseInt(Parameter1[i][2]);
			}
		}

		String str2;
		Vector<String[]> str_vec2 = new Vector<String[]>(); // 暫存
		k = 0;
		n=0;
		n1=0;
		 k1.clear();
		
		FileReader RideSharingDetailsfr = new FileReader(
				"output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"RideSharingDetails.txt");
		BufferedReader RideSharingDetailsbr = new BufferedReader(
				RideSharingDetailsfr);
		while ((str2 = RideSharingDetailsbr.readLine()) != null) {

			if (str2.equals("--------------------------------------------------------------------------------------------")) {
				n++;
				k1.add(k);
				k = 0;
			} else {
				n1++;
				k++;
				str_vec2.add(str2.split(" "));
			}
		}
		RideSharingDetailsfr.close();
		;
		onoff = new String[n][];
		B = new double[n][];
		r = new double[n][];
		Br = new double[n][];
		Bids = new double[n][];
		reward = new double[n][];
		reback = new double[n][];
		reward2 = new double[n][];
		reback2 = new double[n][];
		reward3 = new double[n][];
		reback3 = new double[n][];
		reward4 = new double[n][];
		reback4 = new double[n][];
		distance = new double[n][];
		time = new int[n][];
		distance_Ratio=new double[n][];
		for (int i = 0; i < n; i++) {
			onoff[i] = new String[k1.get(i)];
			B[i] = new double[k1.get(i)];
			r[i] = new double[k1.get(i)];
			Br[i] = new double[k1.get(i)];
			Bids[i] = new double[k1.get(i)];
			reward[i] = new double[k1.get(i)];
			reback[i] = new double[k1.get(i)];
			reward2[i] = new double[k1.get(i)];
			reback2[i] = new double[k1.get(i)];
			reward3[i] = new double[k1.get(i)];
			reback3[i] = new double[k1.get(i)];
			reward4[i] = new double[k1.get(i)];
			reback4[i] = new double[k1.get(i)];
			distance[i] = new double[k1.get(i)];
			time[i] = new int[k1.get(i)];
			distance_Ratio[i]=new double[k1.get(i)];
		}
		String Parameter2[][] = new String[str_vec2.size()][]; // 產生二維陣列,
																// 依據暫存的size(txt檔的行數)
		for (int i = 0; i < str_vec2.size(); i++)
			Parameter2[i] = str_vec2.elementAt(i); // 將暫存區每一個元素(一行裡的字串陣列)放入二維陣列

		int p = 0;
		for (int j = 0; j < onoff.length; j++) {
			for (int i = 0; i < onoff[j].length; i++) {

				onoff[j][i] = Parameter2[p][0];
				B[j][i] = Double.parseDouble(Parameter2[p][1]);
				r[j][i] = Double.parseDouble(Parameter2[p][2]);
				Br[j][i] = Double.parseDouble(Parameter2[p][3]);
				Bids[j][i] = Double.parseDouble(Parameter2[p][4]);
				reward[j][i] = Double.parseDouble(Parameter2[p][5]);
				reback[j][i] = Double.parseDouble(Parameter2[p][6]);
				reward2[j][i] = Double.parseDouble(Parameter2[p][7]);
				reback2[j][i] = Double.parseDouble(Parameter2[p][8]);
				reward3[j][i] = Double.parseDouble(Parameter2[p][9]);
				reback3[j][i] = Double.parseDouble(Parameter2[p][10]);
				reward4[j][i] = Double.parseDouble(Parameter2[p][11]);
				reback4[j][i] = Double.parseDouble(Parameter2[p][12]);
				distance[j][i] = Double.parseDouble(Parameter2[p][13]);
				time[j][i] = Integer.parseInt(Parameter2[p][14]);
				distance_Ratio[j][i]=Double.parseDouble(Parameter2[p][15]);
				p++;
			}
		}

	}

	public static int Xd(int i) {
		return Xd[i];
	}

	public static int Xj(int i) {
		return Xj[i];
	}

	public static int X(int i) {
		return X[i];
	}
	public static int X_length() {
		return X_length;
	}
	public static int Yp(int i) {
		return Yp[i];
	}

	public static int Yh(int i) {
		return Yh[i];
	}

	public static int Y(int i) {
		return Y[i];
	}
	public static int Y_length() {
		return Y_length;
	}
	public static String onoff(int i, int j) {
		return onoff[i][j];
	}

	public static double B(int i, int j) {
		return B[i][j];
	}

	public static double r(int i, int j) {
		return r[i][j];
	}

	public static double Br(int i, int j) {
		return Br[i][j];
	}

	public static double Bids(int i, int j) {
		return Bids[i][j];
	}

	public static double reward(int i, int j) {
		return reward[i][j];
	}

	public static double reback(int i, int j) {
		return reback[i][j];
	}
	public static double reward2(int i, int j) {
		return reward2[i][j];
	}

	public static double reback2(int i, int j) {
		return reback2[i][j];
	}
	public static double reward3(int i, int j) {
		return reward3[i][j];
	}

	public static double reback3(int i, int j) {
		return reback3[i][j];
	}
	public static double reward4(int i, int j) {
		return reward4[i][j];
	}

	public static double reback4(int i, int j) {
		return reback4[i][j];
	}
	public static double distance(int i, int j) {
		return distance[i][j];
	}

	public static int time(int i, int j) {
		return time[i][j];
	}
	public static double distance_Ratio(int i, int j) {
		return distance_Ratio[i][j];
	}
	
	public static int n(){
		return n;
	}
	public static int n1(){
		return n1;
	}
	public static ArrayList<Integer> k1(){
		return k1;
	}

}
