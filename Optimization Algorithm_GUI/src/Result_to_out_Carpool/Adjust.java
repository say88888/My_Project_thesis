package Result_to_out_Carpool;

import java.util.ArrayList;
import java.util.List;

import READ_TXT.Read_INPUT_TXT_filter;

public class Adjust  extends carpool_results_test{

	private static 	List<Integer> Record_D=new ArrayList<Integer>();	
	private static 	List<Integer> Record_K=new ArrayList<Integer>();	
	
	private static 	List<Double> Record_Cost=new ArrayList<Double>();	
	
	private static double[][] Ju_Bids;
	private static double[][] Ju_Bids1;
	private static double[][] Ju_Bids2;
	
	private static int Recorder_number;
	
	public static void JudgeBIds_main(double[][] Bids) throws Exception
	{

		Read_INPUT_TXT_filter.loadData();
		
		System.out.println("---------發現到有重複載客----------");
		
		Ju_Bids = new double[D][K];
		Ju_Bids1 = new double[D][K];
		Ju_Bids2 = new double[D][K];
		Record_D.clear();
		Record_K.clear();
		for(int i=0;i<D;i++)
			for(int j=0;j<K;j++)
				Ju_Bids[i][j]=Bids[i][j];
				
		JudgeBIds_step1() ;
		
		JudgeBIds_step2() ;
		
		JudgeBIds_step3() ;
	}
	
	 static void JudgeBIds_step1() throws Exception
	{
			int m=0;
			// -------判斷是哪個地點司機重複載到的乘客加入矩陣----------
		ok:for (int j = 0; j < K ; j++) {
				m = 0;  //表示此點幾個人載
				Record_D.clear();
				Record_K.clear();
				for (int i = 0; i < D ; i++) {
					if (Ju_Bids[i][j] == 1) {
						Record_D.add(i);
						Record_K.add(j);
						m++;
					}
				}
				if(m>1)
				{
					Recorder_number=m;
					break ok;
				}
			}
	}
	 
	 static void JudgeBIds_step2() throws Exception
	{
		 Record_Cost.clear();
		 //判斷哪位司機
		 	int k=0,l=0;
	 ok: for (int i = 0; i < D; i++) 
			{
				for (int j = 0; j < K; j++) 
				{
					if (i == Record_D.get(k)) 
					{
						Ju_Bids1[i][j] = Ju_Bids[i][j];
						l++;
					} else
						Ju_Bids1[i][j] = 0;
				}
				if(l>0)
				{
					k++;
					l=0;
					if(k==Recorder_number){break ok;}
				}
			}
		 	
			System.out.println("--------Ju_Bids1 的標----------");
			for (int i = 0; i < D; i++) {
				for (int j = 0; j < K; j++){
					System.out.print(Ju_Bids1[i][j]+" ");
				}
				System.out.println();
			}
			
			// ------------------------算出每個司機總體成本------------------------
			for (k = 0; k < Recorder_number; k++) {
				for (int i = 0; i < D; i++) {
					for (int j = 0; j < K; j++)
						Ju_Bids2[i][j] = Ju_Bids1[i][j];
				}
				for (int i = 0; i < D; i++) {
					if (i !=Record_D.get(k))
						Ju_Bids2[i][Record_K.get(k)] = 0;
				}
				System.out.println("--------Ju_Bids2 的標----------");
				for (int i = 0; i < D; i++) {
					for (int j = 0; j < K; j++){
						System.out.print(Ju_Bids2[i][j]+" ");
					}
					System.out.println();
				}
				double cost=Algorithm_for_Adjustment_cost.Cost(Ju_Bids2);// 帶入Cost演算函式
				System.out.println("-----------------------總成本"+ cost ); // 輸出此司機總體成本
				Record_Cost.add(cost);
			}
	}
	 
	 static void JudgeBIds_step3() throws Exception
	{
			// ----------將總體成本較大的乘客去掉由總體成本低的去載-----------
		 
		 System.out.println("JudgeBIds_step3()");
		 System.out.println("Recorder_number= "+Recorder_number);
		 
		 int Min_D=Record_D.get(0);
		 double Min_Cost=Record_Cost.get(0);
		 
			for (int i = Recorder_number -1; i >0; i--) {
				
				 System.out.println("Min_Cost= "+Min_Cost +"Record_Cost.get(i) ="+Record_Cost.get(i));
				
				if (Min_Cost < Record_Cost.get(i) && Record_Cost.get(i) != 0) {
					
					Ju_Bids[Record_D.get(i)][Record_K.get(i)] -= Read_INPUT_TXT_filter.getseat(Record_K.get(i));
					
				} else if (Min_Cost >= Record_Cost.get(i) && Record_Cost.get(i) != 0) {
					
					Ju_Bids[Min_D][Record_K.get(0)] -= Read_INPUT_TXT_filter.getseat(Record_K.get(0));
					
					Min_D=Record_D.get(i);
					Min_Cost=Record_Cost.get(i);
				}
				
				System.out.println("Min_Cost= "+Min_Cost);
			}
			
			System.out.println();
	}
	 
	 public static double[][] getJudgeBIds()
	{
		 return Ju_Bids;
	}
	 
}
