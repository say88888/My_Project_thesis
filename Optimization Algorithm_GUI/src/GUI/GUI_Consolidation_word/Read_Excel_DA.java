package GUI.GUI_Consolidation_word;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class Read_Excel_DA {
	
	private static List<List<String>> Consolidation_Algorithm_mean_value = new ArrayList<List<String>>();
	private static List<List<String>> Consolidation_Algorithm = new ArrayList<List<String>>();
	
	private static ArrayList<String> lst_Path2 = new ArrayList<String>();

	private static String Example;
	

	private static ArrayList<String> Consolidation_N = new ArrayList<String>();
	private static ArrayList<String> Consolidation_I= new ArrayList<String>();
	private static ArrayList<String> Consolidation_K= new ArrayList<String>();
		
	public static void main() {
		// TODO Auto-generated method stub
		
		Consolidation_N.clear();
		Consolidation_I.clear();
		Consolidation_K.clear();
		Consolidation_Algorithm_mean_value.clear();
		Consolidation_Algorithm.clear();
		
		lst_Path2=Select_multi_Example.lst_Path2();
		
		for(int i=0;i<lst_Path2.size();i++){
		 Read_Excel(lst_Path2.get(i));
		 split_Example();
		}
		
		System.out.println("---------");
		System.out.println(Consolidation_Algorithm_mean_value);
		System.out.println("---------");
	}
	
	      
	      public static List<List<String>>  Consolidation_Algorithm_mean_value(){
	  		return Consolidation_Algorithm_mean_value;
	  	}
	      public static List<List<String>>  Consolidation_Algorithm(){
	  		return Consolidation_Algorithm;
	  	}
	      
	      public static ArrayList<String>  Consolidation_N(){
		  		return Consolidation_N;
		  	}
	      public static ArrayList<String>  Consolidation_I(){
			  		return Consolidation_I;
			 }
	      public static ArrayList<String>  Consolidation_K(){
			  		return Consolidation_K;
			 }
	      
	      
	static void Read_Excel(String lst_Path){
		String fileName;
		fileName = "output\\";
		ArrayList<String> Algorithm = new ArrayList<String>();
		ArrayList<String> Algorithm_mean_value = new ArrayList<String>();

		try {
			Workbook book = Workbook.getWorkbook(new File(fileName+lst_Path));
			// 獲得第一個工作表對象
			Sheet sheet = book.getSheet(0);
			int coloumNum=sheet.getRow(0).length;
			
			System.out.print("coloumNum="+coloumNum);
		
			for (int j = 1; j < coloumNum; j += 1) {

				Cell cell1 = sheet.getCell(j, 0);
				String result = cell1.getContents(); // 獲得單元格的內容
				result=result.trim();
				if(!Algorithm.contains(result)){
				Algorithm.add(result);
				}
				
				cell1 = sheet.getCell(j,sheet.getRows()-2);
				result = cell1.getContents(); // 獲得單元格的內容
				result=result.trim();
				Algorithm_mean_value.add(result);
				
				cell1 = sheet.getCell(0,1);
				result = cell1.getContents(); // 獲得單元格的內容
				result=result.trim();
				Example=result;
			}
			Consolidation_Algorithm_mean_value.add(Algorithm_mean_value);
			Consolidation_Algorithm.add(Algorithm);
			book.close();

		} catch (Exception e) {
			System.out.println(e);
		}
		
		System.out.println();
		for(int j=0;j<Algorithm.size();j++)
			System.out.println("Algorithm="+Algorithm.get(j));
		
		System.out.println();
		for(int j=0;j<Algorithm_mean_value.size();j++)
			System.out.println("Algorithm_mean_value="+Algorithm_mean_value.get(j));
		
		System.out.println();
		System.out.println("Example_Path="+Example);
	}
	
	
	static void split_Example(){
		
		Pattern p = Pattern.compile("\\d{1,}");//这个2是指连续数字的最少个数
        String u = Example;
        java.util.regex.Matcher m = p.matcher(u);
        int i = 0;
       ArrayList<String> math = new ArrayList<String>();
        while (m.find()) {
        	math.add(m.group());
            System.out.println(m.group());
            i++;
        }
        System.out.println(i);
        
        System.out.println(math);
        
    	Consolidation_N.add(math.get(0));
		Consolidation_I.add(math.get(1));
		Consolidation_K.add(math.get(2));
	}
	
}
