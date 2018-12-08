package Heuristic_method;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Enumeration.select_Neighborhood_rule1;
import READ_TXT.Read_INPUT_TXT;
import READ_TXT.Read_INPUT_TXT_filter;

public class step2 extends Heuristic {
	private static List<List<Integer>> DP = new ArrayList<List<Integer>>();
	private static List<Integer> DPA1 = new ArrayList<Integer>();
	private static List<Integer> DPA2 = new ArrayList<Integer>();
	private static List<Integer> DPA345 = new ArrayList<Integer>();
	public static void main() throws IOException {
		String A1 = "true";
		Read_INPUT_TXT.loadData();
		Read_INPUT_TXT_filter.loadData();
		
		for (int i = 0; i < select_Neighborhood_rule1.DP().get(d).size() ; i++)
			for (int j = 0; j < Read_INPUT_TXT.getP(); j++) {
				if(select_Neighborhood_rule1.DP().get(d).get(i)-1!=j)
				if (Read_INPUT_TXT_filter.getP_ID(	select_Neighborhood_rule1.DP().get(d).get(i) - 1).equals(Read_INPUT_TXT.getP_ID(j)) ||  Read_INPUT_TXT_filter.getseat(select_Neighborhood_rule1.DP().get(d).get(i) - 1) != 1) {
					A1 = "false";
					break;
				}
			}
		
		System.out.println(A1);
		if (A1  == "true") {
			System.err.println("A1");
			step2_1.main();
		}
		
		if (A1 == "false") {
			System.err.println("A2");
			step2_2.main();
		}
	}
}