package Make_Excel.Double_Auction;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import jxl.Cell;
import jxl.CellView;
import jxl.Sheet;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.CellFormat;
import jxl.format.Colour;
import jxl.write.Formula;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class Consolidation_excel_GUI_DA {
	private static ArrayList<String> title_data = new ArrayList<String>();
	private static List<List<String>> Consolidation_data = new ArrayList<List<String>>();
	 
	private static ArrayList<String> test_data = new ArrayList<String>();
	private static WritableWorkbook workbook;
	private static WritableSheet sheet1;
	
	private static ArrayList<String> Select_Algorithm = new ArrayList<String>();
	private static int math,math1,n1,n2;
	public static void main( ) {
		// TODO Auto-generated method stub
		
		Consolidation_data = new ArrayList<List<String>>();
		Consolidation_data = new ArrayList<List<String>>();
		Select_Algorithm = new ArrayList<String>();
		 math=0;
		 math1=0;
		System.out.println("math1= "+math1);
		 initialize_Select_Algorithm();
			System.out.println("math1= "+math1);
		String fileName;
		fileName = "output\\";
		
		try {
			Workbook book = Workbook.getWorkbook(new File(fileName+"Arrangement_excel.xls"));
			// 獲得第一個工作表對象
			Sheet sheet = book.getSheet(0);
			for(int i=0;i<sheet.getColumns();i++){
				Cell cell1 = sheet.getCell(i, 0);
				String result = cell1.getContents(); // 獲得單元格的內容
				if(result.contains("Fittest"))
					n1=i;
				if(result.contains("Generation"))
					n2=i;
			}
				
			
			for (int j = 1; j <= sheet.getRows(); j += math1) {

				test_data = new ArrayList<String>();

				Cell cell1 = sheet.getCell(0, j);
				String result = cell1.getContents(); // 獲得單元格的內容
				test_data.add(result);
				
				for(int l=0;l<math1;l++){
					cell1 = sheet.getCell(n1, j+l);
					result = cell1.getContents(); // 獲得單元格的內容
					test_data.add(result);
					cell1 = sheet.getCell(n2, j+l);
					result = cell1.getContents(); // 獲得單元格的內容
					test_data.add(result);
					}

				Consolidation_data.add(test_data);

			}
			book.close();

		} catch (Exception e) {
			System.out.println(e);
		}
		
    	for(int i=0;i<Consolidation_data.size();i++){
    		for(int j=0;j<Consolidation_data.get(i).size();j++)
    		{
    			System.out.print(Consolidation_data.get(i).get(j)+" ");
    		}
    		System.out.println();
    	}
		 
		CellView cellView = new CellView();
		cellView.setAutosize(true); // 自動調整欄寬
		try {
			workbook = Workbook.createWorkbook(new File(
					"output\\Consolidation.xls"));
			sheet1 = workbook.createSheet("My Sheet", 0);
			title_data = new ArrayList<String>();

			data_title();
			
			 
			 int a=0,AVERAGE1=2,AVERAGE2=(Consolidation_data.size()+2);
	//		for (int k = 0; k < 5; k++) {
				int B = 66; int A=65; int A1=65;
				int row = sheet1.getRows();
				for (int i = 0; i < title_data.size(); i++) {
					sheet1.addCell(new Label(i, row, title_data.get(i), Format()));
					sheet1.setColumnView(i, cellView);
				}
				
				for (int i = 0; i < Consolidation_data.size(); i++) {
					row = sheet1.getRows();
					for (int j = 0; j < Consolidation_data.get(a).size(); j++) {
						 if(j!=0 ){
							 jxl.write.Number label1=new jxl.write.Number(j, row, Double.parseDouble(Consolidation_data.get(a).get(j)),Format());
					          sheet1.addCell(label1);
					          sheet1.setColumnView(j, cellView);
						 }else{
							 sheet1.addCell(new Label(j, row, Consolidation_data.get(a).get(j),Format()));
							 sheet1.setColumnView(j, cellView);
						 }
					}a++;
				}
				row = sheet1.getRows();
				sheet1.addCell(new Label(0, row+1, "平均",Format()));
				 sheet1.setColumnView(0, cellView);
				 for(int i=0;i<math;i++){
					 if(i<25){
					 sheet1.addCell(new Formula(i+1, row+1, "AVERAGE("+(char)B+AVERAGE1+":"+(char)B+AVERAGE2+")",Format()));  
					 sheet1.setColumnView(i+1, cellView);
					 B+=1;
					 }
					 else{
					sheet1.addCell(new Formula(i+1, row+1, "AVERAGE("+(char)A+(char)A1+AVERAGE1+":"+(char)A+(char)A1+AVERAGE2+")",Format()));  
					 sheet1.setColumnView(i+1, cellView);
					 A1+=1;}
				 }
				 B = 66;
				 A1=65;
				 sheet1.addCell(new Label(0, row+2, "標準差",Format()));
				 sheet1.setColumnView(0, cellView);
				 for(int i=0;i<math;i++){
					 if(i<25){
					 sheet1.addCell(new Formula(i+1, row+2, "STDEV("+(char)B+AVERAGE1+":"+(char)B+AVERAGE2+")",Format()));  
					 sheet1.setColumnView(i+1, cellView);
					 B+=1;
					 }
					 else
					 {
						 sheet1.addCell(new Formula(i+1, row+2, "STDEV("+(char)A+(char)A1+AVERAGE1+":"+(char)A+(char)A1+AVERAGE2+")",Format()));  
						 sheet1.setColumnView(i+1, cellView);
						 A1+=1;
					 }
				 }
				 AVERAGE1+=14;
				 AVERAGE2+=14;
			

			workbook.write();
			workbook.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	 
	public static CellFormat Format() throws WriteException {

		WritableFont myFont = new WritableFont(WritableFont.createFont("標楷體"),
				14);
		myFont.setColour(Colour.BLACK);
		WritableCellFormat cellFormat = new WritableCellFormat();

		cellFormat.setFont(myFont); // 指定字型
		cellFormat.setBackground(Colour.WHITE); // 背景顏色
		cellFormat.setAlignment(Alignment.CENTRE); // 對齊方式

		return cellFormat;
	}

	static void data_title() {
		title_data.add("Project name");
		for(int i=0;i<Select_Algorithm.size();i++)
		{
				title_data.add(Select_Algorithm.get(i));
				title_data.add(Select_Algorithm.get(i));
				math+=2;
		}
	}
	
	static void initialize_Select_Algorithm(){
		String fileName;
		fileName = "output\\";
		try {
			Workbook book = Workbook.getWorkbook(new File(fileName+"Arrangement_excel.xls"));
			// 獲得第一個工作表對象
			Sheet sheet = book.getSheet(0);
			int Algoritm=0;
			for(int i=0;i<sheet.getColumns();i++){
				Cell cell1 = sheet.getCell(i, 0);
				String result = cell1.getContents(); // 獲得單元格的內容
				if(result.contains("Algorithm"))
					Algoritm=i;
			}
			
			for (int j = 1; j <= sheet.getRows(); j += 1) {

				Cell cell1 = sheet.getCell(Algoritm, j);
				String result = cell1.getContents(); // 獲得單元格的內容
				if(!Select_Algorithm.contains(result)){
				Select_Algorithm.add(result);
				math1+=1;
				}
			}
			book.close();

		} catch (Exception e) {
			System.out.println(e);
		}
		
		
	}
}
