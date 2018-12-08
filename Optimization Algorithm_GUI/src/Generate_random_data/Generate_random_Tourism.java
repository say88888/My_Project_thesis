package Generate_random_data;

import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Random;

import GUI.I_Set_Paths_for_Current_Simulation_Example;
import carpool_Alogorithm_MOD.Calculate_the_function;

public class Generate_random_Tourism {
	
	private static int[][] DELTA; // DELTA.txt
	
	private static int[][] PI; // PI.txt
	
	private static int Ia; // 旅行社投標數
	private static int[] Ia_J;
	private static int K; // 景點
	private static int K_top; // 景點容量
	private static int[][] travel_agents_Bid;

	private static int N; // 買方
	private static int[] N_H; // 買方
	private static double buyer_bot_price;// 買方底價價格
	private static int[][] BuyerBid;
	
	private static int Ih;	//旅館
	private static int[] Ih_J;
//	private static int[] m;
	private static int M_top;	//旅館數量上限
	private static int M;
	private static int[][] hoteliersBid;
	
	private static int It;	//運輸者
	private static int[] It_J;
//	private static int[] t;
	private static int T_top;	//運輸數量上限
	private static int T;
	private static int[][] transportationBid;
	
	private static int[][] vaik;
	private static int[][] vhim;
	private static int[][] vtit;
	
	public static void Generate_Data_of_Tourism_DELTA()
			throws IOException {
		
		Read_Generate_random_Tourism.main();
		
		K=Read_Generate_random_Tourism.K();
		M=Read_Generate_random_Tourism.M();
		DELTA=new int[K][M];
		Random r = new Random();
		
		for(int i=0;i<K;i++)
			for(int j=0;j<M;j++)
				DELTA[i][j]=r.nextInt(2);
		
		make_DELTA();
	}
	
	public static void Generate_Data_of_Tourism_PI()
			throws IOException {
		
		Read_Generate_random_Tourism.main();
		
		K=Read_Generate_random_Tourism.K();
		T=Read_Generate_random_Tourism.T();
		PI=new int[K][T];
		Random r = new Random();
		
		for(int i=0;i<K;i++)
			for(int j=0;j<T;j++)
				PI[i][j]=r.nextInt(2);
		
		make_PI();
	}
	
	public static void Generate_Data_of_Tourism_travel_agents()
			throws IOException {
		
		Read_Generate_random_Tourism.main();
		Ia=Read_Generate_random_Tourism.Ia();
		K=Read_Generate_random_Tourism.K();
		K_top=Read_Generate_random_Tourism.K_top();
		Ia_J = new int[Ia];
		int Ik = 0;
		for (int i = 0; i < Ia; i++) {
			Ia_J[i] = (int) Calculate_the_function.random(1, 1);
			Ik += Ia_J[i];
		}

		travel_agents_Bid = new int[Ik][K + 1];
		int n = 0;
		for (int i = 0; i < Ik; i++) {
			while (n < 1) {
				int t = 0;
				for (int j = 0; j < K; j++) {
					if (Math.random() < 0.5) {
						travel_agents_Bid[i][j] = (int) (Math.random() * K_top) + 1;
						t += travel_agents_Bid[i][j];
						n++;
					} else {
						travel_agents_Bid[i][j] = 0;
					}
					travel_agents_Bid[i][K] = t	* (int) Calculate_the_function.random(20, 40);
				}
			}
			n = 0;
		}
		make_travel_agentsBid();
	}

	public static void Generate_Data_of_Tourism_buyer() throws IOException {

		Read_Generate_random_Tourism.main();
		N=Read_Generate_random_Tourism.N();
		buyer_bot_price=Read_Generate_random_Tourism.buyer_bot_price();
		N_H = new int[N];
		int Nk = 0;
		for (int i = 0; i < N; i++) {
			N_H[i] = (int) Calculate_the_function.random(1, 1); // 每個買方產生一個標
			Nk += N_H[i]; // 計算總投標數
		}

		int[] travel_agents_totalQuantity = new int[K];
		for (int i = 0; i < K; i++) {
			int total = 0;
			for (int j = 0; j < travel_agents_Bid.length; j++)
				total += travel_agents_Bid[j][i]; // 計算賣方人數數量
			travel_agents_totalQuantity[i] = total; // 存放每個景點的總人數
		}

		BuyerBid = new int[Nk][K + 1];
		Random r = new Random();
		for (int i = 0; i < Nk; i++) {
			int n = 0;
			while (n < 1) {
				int t = 0;
				for (int j = 0; j < K; j++) {
					if (Math.random() < 0.5	&& travel_agents_totalQuantity[j] != 0) {
						BuyerBid[i][j] = r	.nextInt(travel_agents_totalQuantity[j] + 1);
						t += BuyerBid[i][j];
						n++;
					} else {
						BuyerBid[i][j] = 0;
					}
				}
				BuyerBid[i][K] = (int) (t* Calculate_the_function.random(20, 40) + buyer_bot_price);
			}
		}
		make_buyerBid();
	}
	
	public static void Generate_Data_of_Tourism_hoteliers() throws IOException {

		Read_Generate_random_Tourism.main();
		Ih=Read_Generate_random_Tourism.Ih();
		M_top=Read_Generate_random_Tourism.M_top();
		Ih_J=new int[Ih];
		int Ik=0;
		for(int i=0;i<Ih;i++){
			Ih_J[i]=(int)Calculate_the_function.random(1,1);
			Ik+=Ih_J[i];
		}
	
		Random r = new Random();
		
/*		m =new int[K];
		for(int i=0;i<K;i++){
			for(int j=0;j<M;j++)
				m[i]+=DELTA[i][j];
		}
*/		
		int[] travel_agents_totalQuantity=new int[K];
		for(int i=0;i<K;i++){
			int total=0;
			for(int j=0;j<travel_agents_Bid.length;j++)
				total+=travel_agents_Bid[j][i];				//計算賣方人數數量
			travel_agents_totalQuantity[i]=total;		//存放每個景點的總人數
		}
		
		hoteliersBid=new int[Ik][M+1];
		for(int i=0;i<Ik;i++){
			int n=0;
			while(n<1){
				int t=0,q=0;
				for(int j=0;j<K;j++){
						if(Math.random()<0.5 && travel_agents_totalQuantity[j]!=0 ){
							hoteliersBid[i][q]= r.nextInt(travel_agents_totalQuantity[j]+1);
							t+= hoteliersBid[i][q];
							n++;
						}else{
							hoteliersBid[i][q]=0;
						}
						q+=1;
				}
				hoteliersBid[i][M]=t*(int)Calculate_the_function.random(20,40);
			}
		}
		make_hoteliersBid();
	}
	public static void Generate_Data_of_Tourism_transportation() throws IOException {

		Read_Generate_random_Tourism.main();
		It=Read_Generate_random_Tourism.It();
		T_top=Read_Generate_random_Tourism.T_top();
		It_J=new int[It];
		int Ik=0;
		for(int i=0;i<It;i++){
			It_J[i]=(int)Calculate_the_function.random(1,1);
			Ik+=It_J[i];
		}
	
		Random r = new Random();
		
/*		t =new int[K];
		for(int i=0;i<K;i++){
			for(int j=0;j<T;j++)
				t[i]+=PI[i][j];
		}
	*/	
		int[] travel_agents_totalQuantity=new int[K];
		for(int i=0;i<K;i++){
			int total=0;
			for(int j=0;j<travel_agents_Bid.length;j++)
				total+=travel_agents_Bid[j][i];			//計算賣方人數數量
			travel_agents_totalQuantity[i]=total;		//存放每個景點的總人數
		}
		
		transportationBid=new int[Ik][T+1];
		for(int i=0;i<Ik;i++){
			int n=0;
			while(n<1){
				int p=0,q=0;
				for(int j=0;j<K;j++){
					if(Math.random()<0.5 && travel_agents_totalQuantity[j]!=0){
						transportationBid[i][q]= r.nextInt(travel_agents_totalQuantity[j]+1);
						p+= transportationBid[i][q];
						n++;
					}else{
						transportationBid[i][q]=0;
					}
					q+=1;
				}
				transportationBid[i][T]=p*(int)Calculate_the_function.random(20,40);
			}
		}
		make_transportationBid();
	}
	
	public static void Generate_Data_of_Tourism_Vaik() throws IOException {
		vaik=new int[Ia][K];
		Read_Generate_random_Tourism_V_Parameter.main();
		Random r = new Random();
		for(int i=0;i<vaik.length;i++)
			for(int j=0;j<vaik[i].length;j++)
				vaik[i][j]=r.nextInt((Read_Generate_random_Tourism_V_Parameter.Vaik_top()+1)-Read_Generate_random_Tourism_V_Parameter.Vaik_bot())+ Read_Generate_random_Tourism_V_Parameter.Vaik_bot();
			
		make_vaik();
	}
	
	public static void Generate_Data_of_Tourism_Vhim() throws IOException {
		vhim=new int[Ih][M];
		Read_Generate_random_Tourism_V_Parameter.main();
		Random r = new Random();
		for(int i=0;i<vhim.length;i++)
			for(int j=0;j<vhim[i].length;j++)
				vhim[i][j]=r.nextInt((Read_Generate_random_Tourism_V_Parameter.Vhim_top()+1)-Read_Generate_random_Tourism_V_Parameter.Vhim_bot())+ Read_Generate_random_Tourism_V_Parameter.Vhim_bot();
			
		make_vhim();
	}
	
	public static void Generate_Data_of_Tourism_Vtit() throws IOException {
		vtit=new int[It][T];
		
		Random r = new Random();
		for(int i=0;i<vtit.length;i++)
			for(int j=0;j<vtit[i].length;j++)
				vtit[i][j]=r.nextInt((Read_Generate_random_Tourism_V_Parameter.Vtit_top()+1)-Read_Generate_random_Tourism_V_Parameter.Vtit_bot())+ Read_Generate_random_Tourism_V_Parameter.Vtit_bot();
			
		make_vtit();
	}

	public static void make_DELTA() throws IOException
	{
		FileWriter fw2 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path()+"\\Tourism\\DELTA.txt");
		for(int i=0;i<DELTA.length;i++){
			for(int j=0;j<DELTA[i].length;j++)
				fw2.write(String.valueOf(DELTA[i][j]) + " ");
			fw2.write("\r\n");
		}
		fw2.close();
	}
	public static void make_PI() throws IOException
	{
		FileWriter fw2 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path()+"\\Tourism\\PI.txt");
		for(int i=0;i<PI.length;i++){
			for(int j=0;j<PI[i].length;j++)
				fw2.write(String.valueOf(PI[i][j]) + " ");
			fw2.write("\r\n");
		}
		fw2.close();
	}
	public static void make_travel_agentsBid() throws IOException
	{
		FileWriter fw2 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path()+"\\Tourism\\Travel_AgentsBid.txt");
		for(int i=0;i<travel_agents_Bid.length;i++){
			for(int j=0;j<travel_agents_Bid[i].length;j++)
				fw2.write(String.valueOf(travel_agents_Bid[i][j]) + " ");
			fw2.write("\r\n");
		}
		fw2.close();
	}
	public static void make_buyerBid() throws IOException
	{
		FileWriter fw2 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path()+"\\Tourism\\BuyerBid.txt");
		for(int i=0;i<BuyerBid.length;i++){
			for(int j=0;j<BuyerBid[i].length;j++)
				fw2.write(String.valueOf(BuyerBid[i][j]) + " ");
			fw2.write("\r\n");
		}
		fw2.close();
	}
	public static void make_hoteliersBid() throws IOException
	{
		FileWriter fw2 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path()+"\\Tourism\\HoteliersBid.txt");
		for(int i=0;i<hoteliersBid.length;i++){
			for(int j=0;j<hoteliersBid[i].length;j++)
				fw2.write(String.valueOf(hoteliersBid[i][j]) + " ");
			fw2.write("\r\n");
		}
		fw2.close();
	}
	public static void make_transportationBid() throws IOException
	{
		FileWriter fw2 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path()+"\\Tourism\\TransportationBid.txt");
		for(int i=0;i<transportationBid.length;i++){
			for(int j=0;j<transportationBid[i].length;j++)
				fw2.write(String.valueOf(transportationBid[i][j]) + " ");
			fw2.write("\r\n");
		}
		fw2.close();
	}
	public static void make_vhim() throws IOException
	{
		FileWriter fw2 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path()+"\\Tourism\\vhim.txt");
		for(int i=0;i<vhim.length;i++){
			for(int j=0;j<vhim[i].length;j++)
				fw2.write(String.valueOf(vhim[i][j]) + " ");
			fw2.write("\r\n");
		}
		fw2.close();
	}
	public static void make_vaik() throws IOException
	{
		FileWriter fw2 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path()+"\\Tourism\\vaik.txt");
		for(int i=0;i<vaik.length;i++){
			for(int j=0;j<vaik[i].length;j++)
				fw2.write(String.valueOf(vaik[i][j]) + " ");
			fw2.write("\r\n");
		}
		fw2.close();
	}
	public static void make_vtit() throws IOException
	{
		FileWriter fw2 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path()+"\\Tourism\\vtit.txt");
		for(int i=0;i<vtit.length;i++){
			for(int j=0;j<vtit[i].length;j++)
				fw2.write(String.valueOf(vtit[i][j]) + " ");
			fw2.write("\r\n");
		}
		fw2.close();
	}
	public static void make_Parameter() throws IOException
	{
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(1);
		FileWriter fw2 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path()+"\\Tourism\\Parameter.txt");
		fw2.write(String.valueOf(N) + "\r\n");
		for(int i=0;i<N;i++)
			fw2.write(String.valueOf(N_H[i]) +" ");
		fw2.write("\r\n");
		fw2.write(String.valueOf(Ia) + "\r\n");
		for(int i=0;i<Ia;i++)
			fw2.write(String.valueOf(Ia_J[i]) + " ");
		fw2.write("\r\n");
		fw2.write(String.valueOf(Read_Generate_random_Tourism.K()) + "\r\n");
		fw2.write(String.valueOf(Ih) + "\r\n");
		for(int i=0;i<Ih;i++)
			fw2.write(String.valueOf(Ih_J[i]) + " ");
		fw2.write("\r\n");
		fw2.write(String.valueOf(M) + "\r\n");
	/*	for(int i=0;i<Read_Generate_random_Tourism.K();i++)
			fw2.write(String.valueOf(m[i]) + " ");
			fw2.write("\r\n");*/
		fw2.write(String.valueOf(It) + "\r\n");	
		for(int i=0;i<It;i++)
			fw2.write(String.valueOf(It_J[i]) + " ");
		fw2.write("\r\n");
		fw2.write(String.valueOf(T) + "\r\n");
/*		for(int i=0;i<Read_Generate_random_Tourism.K();i++)
			fw2.write(String.valueOf(t[i]) + " ");
			fw2.write("\r\n");*/
		fw2.write(String.valueOf(nf.format(Calculate_the_function.random(0,1))) + "\r\n");
		fw2.write(String.valueOf(nf.format(Calculate_the_function.random(0,1))) + "\r\n");
		
		fw2.close();
	}
}
