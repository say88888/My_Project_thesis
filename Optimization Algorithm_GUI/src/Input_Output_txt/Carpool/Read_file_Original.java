package Input_Output_txt.Carpool;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

import GUI.I_Set_Paths_for_Current_Simulation_Example;

public class Read_file_Original {
	private static String[][] Parameter1;
	private static String[][] DriverBids1;
	private static String[][] PassengerBids1;
	private static int P;
	private static int D;
	private static int[] Hp;
	private static int[] Jd;
	private static int K;
	private static double Tdm;
	private static double Tpm;
	private static int[][][] qdjk;
	private static double[][] Cdj;
	private static double[][] Odj;
	private static int[][] adj;
	private static int[][][] Sphk;
	private static double[][] fph;
	private static int[][][] Wqdjk;
	private static int[][] ldj;

	public static void loadData( ) throws IOException {

		int a = 0, b = 0, c = 0;

		String str;
		// String Parameter1 [][]; //二維陣列
		Vector<String[]> str_vec = new Vector<String[]>(); // 暫存
		try {
			FileReader PBr = new FileReader(I_Set_Paths_for_Current_Simulation_Example.path()+"\\Carpool_Original\\Parameter.txt");
			BufferedReader br = new BufferedReader(PBr);
			while ((str = br.readLine()) != null) { // 每次讀一行
				str_vec.add(str.split("\\s")); // 將此行以空白(white space)切成字串陣列, 存入
												// Vector暫存
			}
			br.close(); // 關檔
			Parameter1 = new String[str_vec.size()][]; // 產生二維陣列,
														// 依據暫存的size(txt檔的行數)
			for (int i = 0; i < str_vec.size(); i++)
				Parameter1[i] = str_vec.elementAt(i); // 將暫存區每一個元素(一行裡的字串陣列)放入二維陣列

			// System.out.println("Parameter:");

			// 印出二維陣列內容
			for (int i = 0; i < Parameter1.length; i++) {
				for (int j = 0; j < Parameter1[i].length; j++) {
					// System.out.print(Parameter1[i][j] + " ");
					a++;
				}
				// System.out.println();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		String str1;
		// String DriverBids1 [][]; //二維陣列
		Vector<String[]> str_vec1 = new Vector<String[]>(); // 暫存
		try {
			FileReader PBr = new FileReader(I_Set_Paths_for_Current_Simulation_Example.path()+"\\Carpool_Original\\DriverBids.txt");
			BufferedReader br = new BufferedReader(PBr);
			while ((str1 = br.readLine()) != null) { // 每次讀一行
				str_vec1.add(str1.split("\\s")); // 將此行以空白(white space)切成字串陣列,
													// 存入 Vector暫存
			}
			br.close(); // 關檔
			DriverBids1 = new String[str_vec1.size()][]; // 產生二維陣列,
															// 依據暫存的size(txt檔的行數)
			for (int i = 0; i < str_vec1.size(); i++)
				DriverBids1[i] = str_vec1.elementAt(i); // 將暫存區每一個元素(一行裡的字串陣列)放入二維陣列
			// System.out.println("DriverBids:");
			// 印出二維陣列內容
			for (int i = 0; i < DriverBids1.length; i++) {
				for (int j = 0; j < DriverBids1[i].length; j++) {
					// System.out.print(DriverBids1[i][j] + " ");
					b++;
					// DriverBids[i][j] =Integer.parseInt(DriverBids1[i][j]);
				}
				// System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		String str2;
		//
		// String PassengerBids1 [][]; //二維陣列
		Vector<String[]> str_vec2 = new Vector<String[]>(); // 暫存
		try {
			FileReader PBr = new FileReader(  I_Set_Paths_for_Current_Simulation_Example.path()+"\\Carpool_Original\\PassengerBids.txt");
			BufferedReader br = new BufferedReader(PBr);
			while ((str2 = br.readLine()) != null) { // 每次讀一行
				str_vec2.add(str2.split("\\s")); // 將此行以空白(white space)切成字串陣列,
													// 存入 Vector暫存
			}
			br.close(); // 關檔
			PassengerBids1 = new String[str_vec2.size()][]; // 產生二維陣列,
															// 依據暫存的size(txt檔的行數)
			for (int i = 0; i < str_vec2.size(); i++)
				PassengerBids1[i] = str_vec2.elementAt(i); // 將暫存區每一個元素(一行裡的字串陣列)放入二維陣列
			// System.out.println("PassengerBids:");
			// 印出二維陣列內容
			for (int i = 0; i < PassengerBids1.length; i++) {
				for (int j = 0; j < PassengerBids1[i].length; j++) {
					// System.out.print(PassengerBids1[i][j] + " ");
					c++;
					// PassengerBids[i][j]
					// =Integer.parseInt(PassengerBids1[i][j]);
				}
				// System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		String[] Par = new String[a];
		String[] Dri = new String[b];
		String[] Pas = new String[c];
		;
		int s1 = 0, s2 = 0, s3 = 0;
		for (int i = 0; i < Parameter1.length; i++) {
			for (int j = 0; j < Parameter1[i].length; j++) {
				Par[s1++] = Parameter1[i][j];
			}
		}
		for (int i = 0; i < DriverBids1.length; i++) {
			for (int j = 0; j < DriverBids1[i].length; j++) {
				Dri[s2++] = DriverBids1[i][j];
			}
		}
		for (int i = 0; i < PassengerBids1.length; i++) {
			for (int j = 0; j < PassengerBids1[i].length; j++) {
				Pas[s3++] = PassengerBids1[i][j];
			}
		}
		P = Integer.parseInt(Par[0]);
		// System.out.println(P);
		Hp = new int[P];
		int w = 0;

		for (int i = 1; i < 1 + P; i++) {

			int q = Integer.parseInt(Par[i]);
			Hp[w++] = q;

		}
		/*
		 * for(int i=0;i<Hp.length;i++) System.out.println(Hp[i]);
		 */
		D = Integer.parseInt(Par[P + 1]);
		Jd = new int[D];
		int w1 = 0;
		for (int i = P + 2; i < P + 2 + D; i++) {
			int q = Integer.parseInt(Par[i]);
			Jd[w1++] = q;
		}
		K = Integer.parseInt(Par[P + D + 2]);
		Tdm = Double.parseDouble(Par[P + D + 3]);
		Tpm = Double.parseDouble(Par[P + D + 4]);

		qdjk = new int[D][][];
		for (int i = 0; i < D; i++)
			qdjk[i] = new int[Jd[i]][K];
		int w2 = 0;
		for (int e = 0; e < D; e++) {
			for (int j = 0; j < Jd[e]; j++) {
				for (int i = 0; i < K; i++) {
					int q = Integer.parseInt(Dri[w2++]);
					qdjk[e][j][i] = q;
				}
				w2 = w2 + K + 4;
			}
		}
		
		Cdj = new double[D][];
		for (int i = 0; i < D; i++)
			Cdj[i] = new double[Jd[i]];
		int w3 = K;
		for (int i = 0; i < D; i++) {
			for (int j = 0; j < Jd[i]; j++) {
				double q = Double.parseDouble(Dri[w3]);
				Cdj[i][j] = q;
				w3 = w3 + 2 * K + 4;
			}
		}
		
		int w9=K+1;
		Odj=new double[D][];
		for(int i=0;i<D;i++)
			Odj[i]=new double[Jd[i]];
		for(int i=0;i<D;i++){
			for(int j=0;j<Jd[i];j++){
				double q = Double.parseDouble(Dri[w9]);
				Odj[i][j] = q;
				w9 = w9 + 2 * K + 4;
			}
		}
		
		 
		adj = new int[D][];
		for (int i = 0; i < D; i++)
			adj[i] = new int[Jd[i]];
		int w4 = K + 2;
		for (int i = 0; i < D; i++) {
			for (int j = 0; j < Jd[i]; j++) {

				int q = Integer.parseInt(Dri[w4]);
				adj[i][j] = q;
				w4 = w4 + 2 * K + 4;

			}
		}

	
		Wqdjk = new int[D][][];
		for (int i = 0; i < D; i++)
			Wqdjk[i] = new int[Jd[i]][K];
		int w7 = K + 3;
		for (int e = 0; e < D; e++) {
			for (int j = 0; j < Jd[e]; j++) {
				for (int i = 0; i < K; i++) {
					int q = Integer.parseInt(Dri[w7++]);
					Wqdjk[e][j][i] = q;
				}
				w7 += 4 + K;
			}
		}

		 
		
		ldj = new int[D][];
		for (int i = 0; i < D; i++)
			ldj[i] = new int[Jd[i]];
		int w8 = 2 * K + 3;
		for (int i = 0; i < D; i++) {
			for (int j = 0; j < Jd[i]; j++) {

				int q = Integer.parseInt(Dri[w8]);
				ldj[i][j] = q;
				w8 = w8 + 2 * K + 4;
			}
		}
		 

		Sphk = new int[P][][];
		for (int i = 0; i < P; i++)
			Sphk[i] = new int[Hp[i]][K];
		int w5 = 0;
		for (int i = 0; i < P; i++) {
			for (int j = 0; j < Hp[i]; j++) {
				for (int k = 0; k < K; k++) {
					int q = Integer.parseInt(Pas[w5++]);
					Sphk[i][j][k] = q;
				}
				w5 += 1;
			}
		}

		fph = new double[P][];
		for (int i = 0; i < P; i++)
			fph[i] = new double[Hp[i]];
		int w6 = K;
		for (int i = 0; i < P; i++) {
			for (int j = 0; j < Hp[i]; j++) {
				double q = Double.parseDouble(Pas[w6]);
				fph[i][j] = q;
				w6 = w6 + K + 1;
			}
		}
		
	/*	System.out.println("Parameter:");
		System.out.println(P);
		for(int i=0;i<P;i++)
			System.out.print(Hp[i]+" ");
		System.out.println();
		System.out.println(D);
		for(int i=0;i<D;i++)
			System.out.print(Jd[i]+" ");
		System.out.println();
		System.out.println(K);
		System.out.println(Tdm);
		System.out.println(Tpm);
		System.out.println("DriverBids:");
		for(int i=0;i<D;i++){
			for(int j=0;j<Jd[i];j++){
				for(int k=0;k<K;k++)
					System.out.print(qdjk[i][j][k]+" ");
				System.out.print(Cdj[i][j]+" "+Odj[i][j]+" "+adj[i][j]+" ");
				for(int k=0;k<K;k++)
					System.out.print(Wqdjk[i][j][k]+" ");
				System.out.println(ldj[i][j]);
			}
		}
		System.out.println("PassengerBids:");
		for(int i=0;i<P;i++){
			for(int j=0;j<Hp[i];j++){
				for(int k=0;k<K;k++)
					System.out.print(Sphk[i][j][k]+" ");
				System.out.println(fph[i][j]);
			}
		}*/
		

	}

	public static int getP() {
		return P;
	}

	public static int getD() {
		return D;
	}

	public static int getHp(int i) {
		return Hp[i];
	}

	public static int getJd(int i) {
		return Jd[i];
	}

	public static int getK() {
		return K;
	}

	public static double getTdm() {
		return Tdm;
	}

	public static double getTpm() {
		return Tpm;
	}

	public static int getqdjk(int i, int j, int k) {
		return qdjk[i][j][k];
	}

	public static int getWqdjk(int i, int j, int k) {
		return Wqdjk[i][j][k];
	}

	public static double getCdj(int i, int j) {
		return Cdj[i][j];
	}
	public static double getOdj(int i, int j) {
		return Odj[i][j];
	}
	public static int getadj(int i, int j) {
		return adj[i][j];
	}

	public static int getldj(int i, int j) {
		return ldj[i][j];
	}

	public static int getSphk(int i, int j, int k) {
		return Sphk[i][j][k];
	}

	public static double getfph(int i, int j) {
		return fph[i][j];
	}

}
