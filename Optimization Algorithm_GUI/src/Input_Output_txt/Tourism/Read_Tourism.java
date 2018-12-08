package Input_Output_txt.Tourism;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

import GUI.I_Set_Paths_for_Current_Simulation_Example;

public class Read_Tourism {
 
	private static int N;
	private static int[] H;
	private static int Ia;
	private static int[] Ja;
	private static int K;
	private static int Ih;
	private static int[] Jh;
	private static int M;
//	private static int[] m;
	private static int It;
	private static int[] Jt;
	private static int T;
//	private static int[] t;
	private static double Tbm;
	private static double Tsm;
	
	private static int[][][] dnhk;
	private static int[][] Pbnh;
	
	private static int[][][] qijk;
	private static int[][] Paij;
	
	private static int[][][] uijm;
	private static int[][] Phij;
	
	private static int[][][] tijt;
	private static int[][] Ptij;
	
	private static int[][] Vaik;
	private static int[][] Vhim;
	private static int[][] Vtit;
	
	private static int[][] PI;
	private static int[][] DELTA;

	public static void main() throws IOException {

		String str;
		String[][] Parameter1;
		Vector<String[]> str_vec = new Vector<String[]>(); // 暫存
		try {
			FileReader PBr = new FileReader(I_Set_Paths_for_Current_Simulation_Example.path()+"\\Tourism\\Parameter.txt");
		//	FileReader PBr = new FileReader( "input\\Tourism_test\\Tourism\\Parameter.txt");
			BufferedReader br = new BufferedReader(PBr);
			while ((str = br.readLine()) != null) { // 每次讀一行
				str_vec.add(str.split("\\s")); // 將此行以空白(white space)切成字串陣列, 存入
			}
			br.close(); // 關檔
			Parameter1 = new String[str_vec.size()][]; // 產生二維陣列,	// 依據暫存的size(txt檔的行數)
			for (int i = 0; i < str_vec.size(); i++)
				Parameter1[i] = str_vec.elementAt(i); // 將暫存區每一個元素(一行裡的字串陣列)放入二維陣列
			
			N=Integer.parseInt(Parameter1[0][0]);
			H=new int[N];
			for(int i=0;i<N;i++)
				H[i]=Integer.parseInt(Parameter1[1][i]);
			Ia=Integer.parseInt(Parameter1[2][0]);
			Ja=new int[Ia];
			for(int i=0;i<Ia;i++)
				Ja[i]=Integer.parseInt(Parameter1[3][i]);
			K=Integer.parseInt(Parameter1[4][0]);
			Ih=Integer.parseInt(Parameter1[5][0]);
			Jh=new int[Ih];
			for(int i=0;i<Ih;i++)
				Jh[i]=Integer.parseInt(Parameter1[6][i]);
			M=Integer.parseInt(Parameter1[7][0]);
		/*	m=new int[M];
			for(int i=0;i<M;i++)
				m[i]=Integer.parseInt(Parameter1[8][i]);*/
			It=Integer.parseInt(Parameter1[8][0]);
			Jt=new int[It];
			for(int i=0;i<It;i++)
				Jt[i]=Integer.parseInt(Parameter1[9][i]);
			T=Integer.parseInt(Parameter1[10][0]);
		/*	t=new int[T];
			for(int i=0;i<T;i++)
				t[i]=Integer.parseInt(Parameter1[12][i]);*/
			Tbm=Double.parseDouble(Parameter1[11][0]);
			Tsm=Double.parseDouble(Parameter1[12][0]);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	/*	System.out.println(N);
		for(int i=0;i<N;i++)
			System.out.print(H[i]+" ");
		System.out.println();
		System.out.println(Ia);
		for(int i=0;i<Ia;i++)
			System.out.print(Ja[i]+" ");
		System.out.println();
		System.out.println(K);
		System.out.println(Ih);
		for(int i=0;i<Ih;i++)
			System.out.print(Jh[i]+" ");
		System.out.println();
		System.out.println(M);
		for(int i=0;i<M;i++)
			System.out.print(m[i]+" ");
		System.out.println();
		System.out.println(It);
		for(int i=0;i<It;i++)
			System.out.print(Jt[i]+" ");
		System.out.println();
		System.out.println(T);
		for(int i=0;i<T;i++)
			System.out.print(t[i]+" ");
		System.out.println();
		System.out.println(Tsm);
		System.out.println(Tbm);*/

		String str1;
		String BuyBids1 [][]; //二維陣列
		Vector<String[]> str_vec1 = new Vector<String[]>(); // 暫存
		try {
			FileReader PBr = new FileReader(I_Set_Paths_for_Current_Simulation_Example.path()+"\\Tourism\\BuyerBid.txt");
		//	FileReader PBr = new FileReader( "input\\Tourism_test\\Tourism\\BuyerBid.txt");
			BufferedReader br = new BufferedReader(PBr);
			while ((str1 = br.readLine()) != null) { // 每次讀一行
				str_vec1.add(str1.split("\\s")); // 將此行以空白(white space)切成字串陣列,
													// 存入 Vector暫存
			}
			br.close(); // 關檔
			BuyBids1 = new String[str_vec1.size()][]; // 產生二維陣列,	// 依據暫存的size(txt檔的行數)
			for (int i = 0; i < str_vec1.size(); i++)
				BuyBids1[i] = str_vec1.elementAt(i); // 將暫存區每一個元素(一行裡的字串陣列)放入二維陣列
			
			dnhk = new int[N][][];
			for (int i = 0; i < N; i++)
				dnhk[i] = new int[H[i]][K];
			Pbnh=new int[N][];
			for (int i = 0; i < N; i++)
				Pbnh[i] = new int[H[i]];
			int w = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < H[i]; j++) {
					for (int k = 0; k < K; k++) 
						dnhk[i][j][k] = Integer.parseInt(BuyBids1[w][k]);
					Pbnh[i][j]=Integer.parseInt(BuyBids1[w][K]);
					w += 1;
				}
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}

		String str2;
		String travel_agents [][]; //二維陣列
		Vector<String[]> str_vec2 = new Vector<String[]>(); // 暫存
		try {
			FileReader PBr = new FileReader(  I_Set_Paths_for_Current_Simulation_Example.path()+"\\Tourism\\travel_agentsBid.txt");
		//	FileReader PBr = new FileReader( "input\\Tourism_test\\Tourism\\travel_agentsBid.txt");
			BufferedReader br = new BufferedReader(PBr);
			while ((str2 = br.readLine()) != null) { // 每次讀一行
				str_vec2.add(str2.split("\\s")); // 將此行以空白(white space)切成字串陣列,
													// 存入 Vector暫存
			}
			br.close(); // 關檔
			travel_agents = new String[str_vec2.size()][]; // 產生二維陣列,
															// 依據暫存的size(txt檔的行數)
			for (int i = 0; i < str_vec2.size(); i++)
				travel_agents[i] = str_vec2.elementAt(i); // 將暫存區每一個元素(一行裡的字串陣列)放入二維陣列
			 
			qijk = new int[Ia][][];
			for (int i = 0; i < Ia; i++)
				qijk[i] = new int[Ja[i]][K];
			Paij=new int[Ia][];
			for (int i = 0; i < Ia; i++)
				Paij[i] = new int[Ja[i]];
			int w = 0;
			for (int i = 0; i < Ia; i++) {
				for (int j = 0; j <Ja[i]; j++) {
					for (int k = 0; k < K; k++) 
						qijk[i][j][k] = Integer.parseInt(travel_agents[w][k]);
					Paij[i][j]=Integer.parseInt(travel_agents[w][K]);
					w += 1;
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String str3;
		String HoteliersBid[][];
		Vector<String []> str_vec3 = new Vector<String []>(); //暫存
		
		// TODO Auto-generated method stub
		try {
			FileReader PBr3 = new FileReader(  I_Set_Paths_for_Current_Simulation_Example.path()+"\\Tourism\\HoteliersBid.txt");
		//	FileReader PBr3 = new FileReader(  "input\\Tourism_test\\Tourism\\HoteliersBid.txt");
			BufferedReader br3 = new BufferedReader(PBr3);
			while ((str3 = br3.readLine()) != null) { //每次讀一行
				str_vec3.add(str3.split(" ")); //將此行以空白(white space)切成字串陣列, 存入 Vector暫存 
			}
			br3.close(); //關檔
		
			HoteliersBid = new String [str_vec3.size()][]; //產生二維陣列, 依據暫存的size(txt檔的行數)
			for (int i = 0; i < str_vec3.size(); i++)
				HoteliersBid[i] = str_vec3.elementAt(i); //將暫存區每一個元素(一行裡的字串陣列)放入二維陣列
		
			uijm = new int[Ih][][];
			for (int i = 0; i < Ih; i++)
				uijm[i] = new int[Jh[i]][M];
			Phij=new int[Ih][];
			for (int i = 0; i < Ih; i++)
				Phij[i] = new int[Jh[i]];
			int w = 0;
			for (int i = 0; i < Ih; i++) {
				for (int j = 0; j <Jh[i]; j++) {
					for (int k = 0; k < M; k++) 
						uijm[i][j][k] = Integer.parseInt(HoteliersBid[w][k]);
					Phij[i][j]=Integer.parseInt(HoteliersBid[w][M]);
					w += 1;
				}
			}
	 
		} catch (Exception e) {
		e.printStackTrace();
		}
		
		String str4;
		String TransportationBid[][];
		Vector<String []> str_vec4 = new Vector<String []>(); //暫存
		// TODO Auto-generated method stub
		try {
			FileReader PBr4 = new FileReader(  I_Set_Paths_for_Current_Simulation_Example.path()+"\\Tourism\\TransportationBid.txt");
		//	FileReader PBr4 = new FileReader(  "input\\Tourism_test\\Tourism\\TransportationBid.txt");
			BufferedReader br4 = new BufferedReader(PBr4);
			while ((str4 = br4.readLine()) != null) { //每次讀一行
		str_vec4.add(str4.split(" ")); //將此行以空白(white space)切成字串陣列, 存入 Vector暫存 
		}
		br4.close(); //關檔
		
		TransportationBid = new String [str_vec4.size()][]; //產生二維陣列, 依據暫存的size(txt檔的行數)
		for (int i = 0; i < str_vec4.size(); i++)
			TransportationBid[i] = str_vec4.elementAt(i); //將暫存區每一個元素(一行裡的字串陣列)放入二維陣列
		
		tijt = new int[It][][];
		for (int i = 0; i < It; i++)
			tijt[i] = new int[Jt[i]][T];
		Ptij=new int[It][];
		for (int i = 0; i < It; i++)
			Ptij[i] = new int[Jt[i]];
		int w = 0;
		for (int i = 0; i < It; i++) {
			for (int j = 0; j <Jt[i]; j++) {
				for (int k = 0; k < T; k++) 
					tijt[i][j][k] = Integer.parseInt(TransportationBid[w][k]);
				Ptij[i][j]=Integer.parseInt(TransportationBid[w][T]);
				
				w += 1;
				
			}
		}
	
		} catch (Exception e) {
		e.printStackTrace();
		}
		 
		String str5;
		String vaik[][];
		Vector<String []> str_vec5 = new Vector<String []>(); //暫存
		// TODO Auto-generated method stub
		try {
			FileReader PBr5 = new FileReader(  I_Set_Paths_for_Current_Simulation_Example.path()+"\\Tourism\\vaik.txt");
		//	FileReader PBr5 = new FileReader(  "input\\Tourism_test\\Tourism\\vaik.txt");
			BufferedReader br5 = new BufferedReader(PBr5);
			while ((str5 = br5.readLine()) != null) { //每次讀一行
		str_vec5.add(str5.split(" ")); //將此行以空白(white space)切成字串陣列, 存入 Vector暫存 
		}
		br5.close(); //關檔
		
		vaik = new String [str_vec5.size()][]; //產生二維陣列, 依據暫存的size(txt檔的行數)
		for (int i = 0; i < str_vec5.size(); i++)
			vaik[i] = str_vec5.elementAt(i); //將暫存區每一個元素(一行裡的字串陣列)放入二維陣列
		
		Vaik=new int[Ia][K];
		for (int i = 0; i < Ia; i++) 
			for (int j = 0; j <K; j++) 
				Vaik[i][j] = Integer.parseInt(vaik[i][j]);
		
		} catch (Exception e) {
		e.printStackTrace();
		}

		String str6;
		String vhim[][];
		Vector<String []> str_vec6 = new Vector<String []>(); //暫存
		// TODO Auto-generated method stub
		try {
			FileReader PBr6 = new FileReader(  I_Set_Paths_for_Current_Simulation_Example.path()+"\\Tourism\\vhim.txt");
		//	FileReader PBr6 = new FileReader(  "input\\Tourism_test\\Tourism\\vhim.txt");
			BufferedReader br6 = new BufferedReader(PBr6);
			while ((str6 = br6.readLine()) != null) { //每次讀一行
		str_vec6.add(str6.split(" ")); //將此行以空白(white space)切成字串陣列, 存入 Vector暫存 
		}
		br6.close(); //關檔
		
		vhim = new String [str_vec6.size()][]; //產生二維陣列, 依據暫存的size(txt檔的行數)
		for (int i = 0; i < str_vec6.size(); i++)
			vhim[i] = str_vec6.elementAt(i); //將暫存區每一個元素(一行裡的字串陣列)放入二維陣列
		
		Vhim=new int[Ih][M];
		for (int i = 0; i < Ih; i++) 
			for (int j = 0; j <M; j++) 
				Vhim[i][j] = Integer.parseInt(vhim[i][j]);
		
		} catch (Exception e) {
		e.printStackTrace();
		}

		String str7;
		String vtit[][];
		Vector<String []> str_vec7 = new Vector<String []>(); //暫存
		// TODO Auto-generated method stub
		try {
			FileReader PBr7 = new FileReader(  I_Set_Paths_for_Current_Simulation_Example.path()+"\\Tourism\\vtit.txt");
		//	FileReader PBr7 = new FileReader(  "input\\Tourism_test\\Tourism\\vtit.txt");
			BufferedReader br7 = new BufferedReader(PBr7);
			while ((str7 = br7.readLine()) != null) { //每次讀一行
		str_vec7.add(str7.split(" ")); //將此行以空白(white space)切成字串陣列, 存入 Vector暫存 
		}
		br7.close(); //關檔
		
		vtit = new String [str_vec7.size()][]; //產生二維陣列, 依據暫存的size(txt檔的行數)
		for (int i = 0; i < str_vec7.size(); i++)
			vtit[i] = str_vec7.elementAt(i); //將暫存區每一個元素(一行裡的字串陣列)放入二維陣列
		
		Vtit=new int[It][T];
		for (int i = 0; i < It; i++) 
			for (int j = 0; j <T; j++) 
				Vtit[i][j] = Integer.parseInt(vtit[i][j]);
		
		} catch (Exception e) {
		e.printStackTrace();
		}
		
		String str8;
		String Pi[][];
		Vector<String []> str_vec8 = new Vector<String []>(); //暫存
		// TODO Auto-generated method stub
		try {
			FileReader PBr8 = new FileReader(  I_Set_Paths_for_Current_Simulation_Example.path()+"\\Tourism\\PI.txt");
		//	FileReader PBr8 = new FileReader(  "input\\Tourism_test\\Tourism\\PI.txt");
			BufferedReader br8 = new BufferedReader(PBr8);
			while ((str8 = br8.readLine()) != null) { //每次讀一行
		str_vec8.add(str8.split(" ")); //將此行以空白(white space)切成字串陣列, 存入 Vector暫存 
		}
		br8.close(); //關檔
		
		Pi= new String [str_vec8.size()][]; //產生二維陣列, 依據暫存的size(txt檔的行數)
		for (int i = 0; i < str_vec8.size(); i++)
			Pi[i] = str_vec8.elementAt(i); //將暫存區每一個元素(一行裡的字串陣列)放入二維陣列
		
		PI=new int[K][T];
		for (int i = 0; i < K; i++) 
			for (int j = 0; j <T; j++) 
				PI[i][j] = Integer.parseInt(Pi[i][j]);
	
		} catch (Exception e) {
		e.printStackTrace();
		}
		
		String str9;
		String Delta[][];
		Vector<String []> str_vec9 = new Vector<String []>(); //暫存
		// TODO Auto-generated method stub
		try {
			FileReader PBr9 = new FileReader(  I_Set_Paths_for_Current_Simulation_Example.path()+"\\Tourism\\DELTA.txt");
		//	FileReader PBr9 = new FileReader(  "input\\Tourism_test\\Tourism\\DELTA.txt");
			BufferedReader br9 = new BufferedReader(PBr9);
			while ((str9 = br9.readLine()) != null) { //每次讀一行
		str_vec9.add(str9.split(" ")); //將此行以空白(white space)切成字串陣列, 存入 Vector暫存 
		}
		br9.close(); //關檔
		
		Delta= new String [str_vec9.size()][]; //產生二維陣列, 依據暫存的size(txt檔的行數)
		for (int i = 0; i < str_vec9.size(); i++)
			Delta[i] = str_vec9.elementAt(i); //將暫存區每一個元素(一行裡的字串陣列)放入二維陣列
		
		DELTA=new int[K][M];
		for (int i = 0; i < K; i++) 
			for (int j = 0; j <M; j++) 
				DELTA[i][j] = Integer.parseInt(Delta[i][j]);
		
		} catch (Exception e) {
		e.printStackTrace();
		}
		
	}

	public static int N() {
		return N;
	}

	public static int H(int i) {
		return H[i];
	}

	public static int Ia() {
		return Ia;
	}
	
	public static int Ja(int i) {
		return Ja[i];
	}

	public static int K() {
		return K;
	}

	public static int Ih() {
		return Ih;
	}
	
	public static int Jh(int i) {
		return Jh[i];
	}
	
	public static int M() {
		return M;
	}
	
/*	public static int m(int i) {
		return m[i];
	}*/
	
	public static int It() {
		return It;
	}
	
	public static int Jt(int i) {
		return Jt[i];
	}
	
	public static int T() {
		return T;
	}
	
/*	public static int t(int i) {
		return t[i];
	}*/
	
	public static double Tbm() {
		return Tbm;
	}

	public static double Tsm() {
		return Tsm;
	}

	public static int dnhk(int i, int j, int k) {
		return dnhk[i][j][k];
	}

	public static int Pbnh(int i, int j) {
		return Pbnh[i][j];
	}
	
	public static int qijk(int i, int j, int k) {
		return qijk[i][j][k];
	}

	public static int Paij(int i, int j) {
		return Paij[i][j];
	}
 
	public static int uijm(int i, int j, int m) {
		return uijm[i][j][m];
	}

	public static int Phij(int i, int j) {
		return Phij[i][j];
	}

	public static int tijt(int i, int j, int t) {
		return tijt[i][j][t];
	}

	public static int Ptij(int i, int j) {
		return Ptij[i][j];
	}

	public static int Vaik(int i, int k) {
		return Vaik[i][k];
	}
	
	public static int Vhim(int i, int m) {
		return Vhim[i][m];
	}
	
	public static int Vtit(int i, int t) {
		return Vtit[i][t];
	}
 
	public static int PI(int k, int t) {
		return PI[k][t];
	}
	
	public static int DELTA(int k, int m) {
		return DELTA[k][m];
	}
	

}
