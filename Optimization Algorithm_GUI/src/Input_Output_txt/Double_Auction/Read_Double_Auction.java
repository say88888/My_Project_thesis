package Input_Output_txt.Double_Auction;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

import GUI.I_Set_Paths_for_Current_Simulation_Example;

public class Read_Double_Auction {
	private static String[][] Parameter1;
	private static String[][] DriverBids1;
	private static String[][] PassengerBids1;
 
	private static int N;
	
	private static int[] H;
	private static int I;
	private static int[] J;
	private static int K;
	
	private static double Tbm;
	private static double Tsm;
	
	private static int[][][] qijk;
	private static double[][] Pij;
	private static int[][] Sik;
	
	private static int[][][] dnhk;
	private static double[][] Pnh;
	

	public static void main() throws IOException {

		int a = 0, b = 0, c = 0;

		String str;
		// String Parameter1 [][]; //二維陣列
		Vector<String[]> str_vec = new Vector<String[]>(); // 暫存
		try {
			FileReader PBr = new FileReader(I_Set_Paths_for_Current_Simulation_Example.path()+"\\Double_Action\\Parameter_Double_Action.txt");
			//FileReader PBr = new FileReader( "input\\5N_5I_5K-1\\Double_Action\\Parameter_Double_Action.txt");
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
			FileReader PBr = new FileReader(I_Set_Paths_for_Current_Simulation_Example.path()+"\\Double_Action\\Seller_Double_Action.txt");
			//FileReader PBr = new FileReader( "input\\5N_5I_5K-1\\Double_Action\\Seller_Double_Action.txt");
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
			FileReader PBr = new FileReader(  I_Set_Paths_for_Current_Simulation_Example.path()+"\\Double_Action\\Buyer_Double_Action.txt");
			//FileReader PBr = new FileReader( "input\\5N_5I_5K-1\\Double_Action\\Buyer_Double_Action.txt");
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
		
		String str3;
		String st[][];
		Vector<String []> str_vec3 = new Vector<String []>(); //暫存
		int k1=0;
		// TODO Auto-generated method stub
		try {
			FileReader PBr3 = new FileReader(  I_Set_Paths_for_Current_Simulation_Example.path()+"\\Double_Action\\Sik.txt");
		//	FileReader PBr3 = new FileReader(  "input\\5N_5I_5K-1\\Double_Action\\Sik.txt");
			BufferedReader br3 = new BufferedReader(PBr3);
			while ((str3 = br3.readLine()) != null) { //每次讀一行
				k1++;
		str_vec3.add(str3.split(" ")); //將此行以空白(white space)切成字串陣列, 存入 Vector暫存 
		}
		br3.close(); //關檔
		} catch (Exception e) {
		e.printStackTrace();
		}
		
		st = new String [str_vec3.size()][]; //產生二維陣列, 依據暫存的size(txt檔的行數)
		for (int i = 0; i < str_vec3.size(); i++)
		st[i] = str_vec3.elementAt(i); //將暫存區每一個元素(一行裡的字串陣列)放入二維陣列
		
		String[] Par = new String[a];
		String[] Dri = new String[b];
		String[] Pas = new String[c];
		 
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
		N = Integer.parseInt(Par[0]);
		// System.out.println(N);
		H = new int[N];
		int w = 0;
		
		for (int i = 1; i < 1 + N; i++) {
			int q = Integer.parseInt(Par[i]);
			H[w++] = q;
		}
	 
		  // for(int i=0;i<Bnh.length;i++) System.out.println(Bnh[i]);
		  
		I = Integer.parseInt(Par[N + 1]);
		//System.out.println(I);
		J = new int[I];
		int w1 = 0;
		for (int i = N + 2; i < N + 2 + I; i++) {
			int q = Integer.parseInt(Par[i]);
			J[w1++] = q;
		}
		//  for(int i=0;i<Bij.length;i++) System.out.println(Bij[i]);
		K = Integer.parseInt(Par[N + I + 2]);
		//System.out.println(K);
		Tbm = Double.parseDouble(Par[N + I + 3]);
		//System.out.println(Tbm);
		Tsm = Double.parseDouble(Par[N + I + 4]);
		//System.out.println(Tsm);
		qijk = new int[I][][];
		for (int i = 0; i < I; i++)
			qijk[i] = new int[J[i]][K];
		int w2 = 0;
		for (int e = 0; e < I; e++) {
			for (int j = 0; j < J[e]; j++) {
				for (int i = 0; i < K; i++) {
					int q = Integer.parseInt(Dri[w2++]);
					qijk[e][j][i] = q;
				}
				w2 = w2 + 1 ;
			}
		}
		//for(int i=0;i<I;i++)for(int j=0;j<qijk[i].length;j++)for(int k=0;k<K;k++)System.out.println(qijk[i][j][k]);
		Pij = new double[I][];
		for (int i = 0; i < I; i++)
			Pij[i] = new double[J[i]];
		int w3 = K;
		for (int i = 0; i < I; i++) {
			for (int j = 0; j < J[i]; j++) {
				double q = Double.parseDouble(Dri[w3]);
				Pij[i][j] = q;
				w3 = w3 +  K+1 ;
			}
		}
		//for(int i=0;i<I;i++)for(int j=0;j<Pij[i].length;j++) System.out.println(Pij[i][j]);
	 
		Sik=new int[I][K];
		for(int i=0;i<I;i++)
			for(int k=0;k<K;k++)
				Sik[i][k]=Integer.parseInt(st[i][k]);
		//for(int i=0;i<I;i++)for(int j=0;j<Sik[i].length;j++) System.out.println(Sik[i][j]);
	/*	 
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
		 
*/
		dnhk = new int[N][][];
		for (int i = 0; i < N; i++)
			dnhk[i] = new int[H[i]][K];
		int w5 = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < H[i]; j++) {
				for (int k = 0; k < K; k++) {
					int q = Integer.parseInt(Pas[w5++]);
					dnhk[i][j][k] = q;
				}
				w5 += 1;
			}
		}
	//	for(int i=0;i<N;i++)for(int j=0;j<dnhk[i].length;j++)for(int k=0;k<K;k++)System.out.println(dnhk[i][j][k]);
		
		Pnh = new double[N][];
		for (int i = 0; i < N; i++)
			Pnh[i] = new double[H[i]];
		int w6 = K;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < H[i]; j++) {
				double q = Double.parseDouble(Pas[w6]);
				Pnh[i][j] = q;
				w6 = w6 + K + 1;
			}
		}
		//for(int i=0;i<N;i++)for(int j=0;j<Pnh[i].length;j++) System.out.println(Pnh[i][j]);
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

	public static int getN() {
		return N;
	}

	public static int getI() {
		return I;
	}

	public static int getH(int i) {
		return H[i];
	}

	public static int getJ(int i) {
		return J[i];
	}

	public static int getK() {
		return K;
	}

	public static double getTbm() {
		return Tbm;
	}

	public static double getTsm() {
		return Tsm;
	}

	public static int getqijk(int i, int j, int k) {
		return qijk[i][j][k];
	}

 

	public static double getPij(int i, int j) {
		return Pij[i][j];
	}
 
	public static int getSik(int i, int j) {
		return Sik[i][j];
	}

 

	public static int getdnhk(int i, int j, int k) {
		return dnhk[i][j][k];
	}

	public static double getPnh(int i, int j) {
		return Pnh[i][j];
	}

}
