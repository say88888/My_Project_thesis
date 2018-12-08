package Enumeration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import READ_TXT.Read_INPUT_TXT_filter;
import READ_TXT.Read_distance;

public class Enumeration {
	public static int d;

	public static void main() throws Exception {
	
		Read_INPUT_TXT_filter.loadData();				//讀取SQL資料
		Read_distance.Read_distance();								//讀取距離矩陣DistanceMatrix
		
		select_Neighborhood_rule1.main();			//根據 距離判斷 司機 分配哪些乘客
		
		for(int i=0;i<select_Neighborhood_rule1.DP().size();i++){
			for(int j=0;j<select_Neighborhood_rule1.DP().get(i).size();j++)
		System.out.print(select_Neighborhood_rule1.DP().get(i).get(j)+" ");
			System.out.println();} 
		
	
	for (d = 0; d < Read_INPUT_TXT_filter.getD(); d++) {
 	//	 if(select_Neighborhood.DP().get(d).size()==0)	//如果司機沒有分配到乘客的話就跳到下一位司機
 	//		continue;
 		    System.out.println(" step1 開始");
			step1_C.main();															//進行組合
			System.out.println(" step1 結束");
			
		    System.out.println(" step2 開始");
			step2_P.main();															//進行排列
			System.out.println(" step2 OK");
			
			System.out.println(" step3 開始");
			step3_select_P.main();											//判斷先上車後下車順序
			System.out.println(" step3 OK");		
			
			System.out.println(" step4 開始");
			step4_select_time.main();										//判斷時間是否符合
			System.out.println(" step4 OK");
			
			System.out.println(" step5 開始");
			step5_checkTXT.main();											//判斷第三、四步驟所對應的TXT
			System.out.println(" step5 OK");						//並產生投標資料
		} 
 		System.out.println(" step6 開始");
		step6_create_GA_input.main();								//將第五步產生投標資料統整為一個TXT
		System.out.println(" step6 OK");
	
		step7_check_Odj.main();								//將第五步產生投標資料統整為一個TXT
		System.out.println(" step7 OK");
		
		
		System.out.println("Enumeration程式結束");       
	}
}
