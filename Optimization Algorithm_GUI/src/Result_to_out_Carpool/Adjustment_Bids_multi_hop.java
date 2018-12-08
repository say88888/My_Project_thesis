package Result_to_out_Carpool;

import READ_TXT.Read_INPUT_TXT_filter;


public class Adjustment_Bids_multi_hop extends carpool_results_test{
	//--------------------------------------------------------------------------
		//--------------------演算做法2----------------------------------------------
		public static  double[][] JudgeBIds2(double[][] DriverBids) throws Exception
		{
			Read_INPUT_TXT_filter.loadData();
			int i, j, m = 0, l = 0, k = 0, q, z = 0;
			int KD[] = new int[D];
			int KP[] = new int[K];
			double XDcost[] = new double[D];
			double bids[][] = new double[D][K];
			double Bids1[][] = new double[D][K];

			for (j = 0; j <= K - 1; j++) {
				// -------判斷是哪個地點司機重複載到的乘客加入矩陣----------
				if (m > 1)
					break;
				else
					m = 0;
				for (i = 0; i <= D - 1; i++) {
					if (DriverBids[i][j] == 1) {
						KD[m] = i;
						KP[m] = j;
						m++;
					}
					// 如果出現重複載到乘客則將重複的司機投標資料紀錄下來，其他為變為0------------
					if (m > 1) {
						q = 0;
						for (l = 0; l < D; l++) 
						{
							for (k = 0; k < K; k++) 
							{
								if (l == KD[q]) 
								{
									bids[l][k] = DriverBids[l][k];
									z++;
								} else
									bids[l][k] = 0;
							}
							if (z > 1) 
							{
								q++;
								z = 0;
							}
						}
					}
				}
			}
			// ------------------------算出每個司機總體成本
			for (j = 0; j < m; j++) {
				for (int y = 0; y < D; y++) {
					for (int n = 0; n < K; n++)
						Bids1[y][n] = bids[y][n];
				}
				for (i = 0; i < D; i++) {
					if (i != KD[j])
						Bids1[i][KP[j]] = 0;
				}
				XDcost[j] = Algorithm_for_Adjustment_cost.Cost(Bids1);// 帶入Cost演算函式
				System.out.println("-----------------------總成本"+XDcost[j]); // 輸出此司機總體成本
			}
			// ----------將總體成本較大的乘客去掉由總體成本低的去載-----------
			for (l = m - 1; l >= 0; l--) {
				if (XDcost[0] <= XDcost[l] && XDcost[l] != 0) {
					DriverBids[KD[l]][KP[l]] -= Read_INPUT_TXT_filter.getseat(KP[l]);

				} else if (XDcost[0] > XDcost[l] && XDcost[l] != 0) {
					DriverBids[KD[0]][KP[0]] -= Read_INPUT_TXT_filter.getseat(KP[0]);
					XDcost[0] = XDcost[l];
				}
			}
			
			//--輸出矩陣--------------------
			for(i=0;i<D;i++){
				for(j=0;j<K;j++){
					System.out.print(DriverBids[i][j]+" ");
			}
				System.out.println();
			}
			
			return DriverBids;
		}
		//-----------------------------------------------------------
		}
