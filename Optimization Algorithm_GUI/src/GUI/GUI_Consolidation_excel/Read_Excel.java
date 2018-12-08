package GUI.GUI_Consolidation_excel;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class Read_Excel {
	private static ArrayList<String> Algorithm = new ArrayList<String>();
	private static int math,math1;
	
	private static ArrayList<String> mean = new ArrayList<String>();
	private static List<List<String>> Consolidation_data = new ArrayList<List<String>>();
	private static ArrayList<String> test_data = new ArrayList<String>();
	
	public static void main() {
		// TODO Auto-generated method stub
		
		
		
	}
	
	static void initialize_Select_Algorithm(){
		String fileName;
		fileName = "output\\";
		try {
			Workbook book = Workbook.getWorkbook(new File(fileName+"Consolidation.xls"));
			// 獲得第一個工作表對象
			Sheet sheet = book.getSheet(0);

			for (int j = 1; j <= sheet.getRows(); j += 1) {

				Cell cell1 = sheet.getCell(6, j);
				String result = cell1.getContents(); // 獲得單元格的內容
				if(!Algorithm.contains(result)){
				Algorithm.add(result);
				math1+=1;
				}
			}
			book.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	static void Read_excel(int loc){
		String fileName;
		fileName = "output\\";
		
		try {
			Workbook book = Workbook.getWorkbook(new File(fileName+"Consolidation.xls"));
			// 獲得第一個工作表對象
			Sheet sheet = book.getSheet(0);

			for (int j = 1; j <= sheet.getRows(); j += math1) {

				test_data = new ArrayList<String>();

				Cell cell1 = sheet.getCell(0, j);
				String result = cell1.getContents(); // 獲得單元格的內容
				test_data.add(result);
				
				for(int l=0;l<math1;l++){
				cell1 = sheet.getCell(loc, j+l);
				result = cell1.getContents(); // 獲得單元格的內容
				test_data.add(result);
				cell1 = sheet.getCell(19, j+l);
				result = cell1.getContents(); // 獲得單元格的內容
				test_data.add(result);
				}
				Consolidation_data.add(test_data);
			}
			book.close();

		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
}
