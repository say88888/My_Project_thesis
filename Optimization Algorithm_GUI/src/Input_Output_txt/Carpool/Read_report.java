package Input_Output_txt.Carpool;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

import GUI.GUI_Generate_Report.Generate_Report;

public class Read_report {

	private static String[] Case;      // 問題
	private static String[] drivers;         // 司機數
	private static String[] passengers;  // 乘客數
	private static String[] route_and_cost;  // 決策前整體路徑及成本
	private static String[] route_and_cost_B;  // 決策後整體路徑及成本
	
	private static String[] abc; // [(a)+(b)]/(c)
	private static String[] ad; //  [a/d]
	
	private static String[] math; // 整體共乘人數
	
	private static String[] seat; // 整體座位數
	
	private static String[] use; // 計算出整體使用率的值
	
	private static int N;
	
	public static void main()throws IOException{

		String[][] report;
		String str;
		Vector<String []> str_vec = new Vector<String []>(); //暫存
		int d=0;
		int i,j,k=0;
		
		Generate_Report.lst_path1();
		Generate_Report.lst_path2();
		Generate_Report.select_Algorithm();
		
		for(int a=0;a<Generate_Report.select_Algorithm().size();a++){
			
		if(Generate_Report.lst_path2().size()>0){
			
			
		for(int l=0;l<Generate_Report.lst_path2().size();l++){
		
		        FileReader  reportfr = new FileReader( Generate_Report.lst_path2().get(l)+"\\"+Generate_Report.select_Algorithm().get(a)+"\\"+Generate_Report.select_Algorithm().get(a)+".txt");
		        BufferedReader  reportbr = new BufferedReader( reportfr);
		        while ((str= reportbr.readLine())!=null ) {
		        	k++;
		        	 str_vec.add(str.split(" "));
		        } 
		        reportfr.close();
		}
		
		}
 
		}
		
		        N=k;
		    
		        report = new String [str_vec.size()][]; //產生二維陣列, 依據暫存的size(txt檔的行數)
				for (i = 0; i < str_vec.size(); i++)
					 report[i] = str_vec.elementAt(i); //將暫存區每一個元素(一行裡的字串陣列)放入二維陣列
				
			
				Case=new String [k];    
				 drivers=new String [k];        
				 passengers=new String [k]; 
				 route_and_cost=new String [k]; 
				 route_and_cost_B=new String [k]; 
				 abc=new String [k];
				 ad=new String [k];
				 math=new String [k];
				 seat=new String [k]; 
				 use=new String [k];
				
				for (i = 0; i < report.length; i++) {
					for (j = 0; j <= report[i].length-1; j++){
						Case[i]=report[i][0];      // 問題
					 drivers[i]=report[i][1];         // 司機數
					 passengers[i]=report[i][2];  // 乘客數
					 route_and_cost[i]=report[i][3];  // 決策前整體路徑及成本
					 route_and_cost_B[i]=report[i][4];  // 決策後整體路徑及成本
					 abc[i]=report[i][5]; // [(a)+(b)]/(c)
					 ad[i]=report[i][6]; //  [a/d]
					 math[i]=report[i][7]; // 整體共乘人數
					 seat[i]=report[i][8]; // 整體座位數
					 use[i]=report[i][9]; // 計算出整體使用率的值
						}
					}
	}
	
	public static int N()
	{
		return N;
	}
	
	public static String Case(int i)
	{
		return Case[i];
	}
	public static String drivers(int i)
	{
		return drivers[i];
	}
	public static String passengers(int i)
	{
		return passengers[i];
	}
	public static String route_and_cost(int i)
	{
		return route_and_cost[i];
	}
	public static String route_and_cost_B(int i)
	{
		return route_and_cost_B[i];
	}
	public static String abc(int i)
	{
		return abc[i];
	}
	public static String ad(int i)
	{
		return ad[i];
	}
	public static String math(int i)
	{
		return math[i];
	}
	public static String seat(int i)
	{
		return seat[i];
	}
	public static String use(int i)
	{
		return use[i];
	}
	
}
