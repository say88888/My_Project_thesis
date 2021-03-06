package Make_Excel.Carpool;

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

public class Consolidation_excel {
	private static ArrayList<String> title_data = new ArrayList<String>();
	private static List<List<String>> Consolidation_data = new ArrayList<List<String>>();
	 
	private static ArrayList<String> test_data = new ArrayList<String>();
	private static WritableWorkbook workbook;
	private static WritableSheet sheet1;
	private static int math,math1;
	public static void main( String[] args) {
		// TODO Auto-generated method stub
		Consolidation_data = new ArrayList<List<String>>();

		 math=37;
		 math1=18;
		
		String fileName;

		fileName = "output\\";

		String[] filename, Pfilename, Dfilename;
		String CfileName, line, line1, line2, line3, DfileName;
		
    	File f = new File(fileName);
    	if (f.isDirectory()) {
			filename = f.list();
			System.out.println("開始讀檔...");

			for (int k = 0; k < filename.length; k++) {
				// ---------------------
				CfileName = fileName + "\\" + filename[k] + "\\";
				System.out.println(CfileName);
		try {
			Workbook book = Workbook.getWorkbook(new File(CfileName));
			// 獲得第一個工作表對象
			Sheet sheet = book.getSheet(0);

			for (int j = 2; j <= sheet.getRows(); j += math1) {

				test_data = new ArrayList<String>();

				Cell cell1 = sheet.getCell(0, j);
				String result = cell1.getContents(); // 獲得單元格的內容
				test_data.add(result);
				cell1 = sheet.getCell(17, 1);
				result = cell1.getContents(); // 獲得單元格的內容
				test_data.add(result);
				
				for(int l=0;l<math1;l++){
				cell1 = sheet.getCell(17, j+l);
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
    	
   /* 	for(int i=0;i<Consolidation_data.size();i++){
    		for(int j=0;j<Consolidation_data.get(i).size();j++)
    		{
    			System.out.print(Consolidation_data.get(i).get(j)+" ");
    		}
    		System.out.println();
    	}
    */	
		CellView cellView = new CellView();
		cellView.setAutosize(true); // 自動調整欄寬
		try {
			workbook = Workbook.createWorkbook(new File(
					"output\\Consolidation.xls"));
			sheet1 = workbook.createSheet("My Sheet", 0);
			title_data = new ArrayList<String>();

			data_title();
			
			 
			 int a=0,AVERAGE1=2,AVERAGE2=11;
	//		for (int k = 0; k < 5; k++) {
				int B = 66; int A=65; int A1=65;
				int row = sheet1.getRows();
				for (int i = 0; i < title_data.size(); i++) {
					sheet1.addCell(new Label(i, row, title_data.get(i), Format()));
					sheet1.setColumnView(i, cellView);
				}
				
				for (int i = 0; i < 10; i++) {
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
	//		}

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

	public static void data_title() {
		title_data.add("Project name");
		title_data.add(" CPLEX ");
		title_data.add(" PSO2 ");
		title_data.add(" PSO2 ");
		title_data.add("CCPSO2");
		title_data.add("CCPSO2");
		title_data.add("DE_Real");
		title_data.add("DE_Real");
		title_data.add("DE_strategy1_Real");
		title_data.add("DE_strategy1_Real");
		title_data.add("DE_strategy2_Real");
		title_data.add("DE_strategy2_Real");
		title_data.add("DE_strategy3_Real");
		title_data.add("DE_strategy3_Real");
		title_data.add("DE_strategy4_Real");
		title_data.add("DE_strategy4_Real");
		title_data.add("DE_strategy5_Real");
		title_data.add("DE_strategy5_Real");
		title_data.add("DE_strategy6_Real");
		title_data.add("DE_strategy6_Real");
		title_data.add("NSDE");
		title_data.add("NSDE");
		title_data.add("SaNSDE");
		title_data.add("SaNSDE");
		title_data.add("DECC");
		title_data.add("DECC");
		title_data.add("DMS-L-PSO");
		title_data.add("DMS-L-PSO");
		title_data.add("DMSDL-PSO");
		title_data.add("DMSDL-PSO");
		title_data.add("ALPSO2_NEW");
		title_data.add("ALPSO2_NEW");
		title_data.add("ALPSO2_NEW_PrematureConvegence1");
		title_data.add("ALPSO2_NEW_PrematureConvegence1");
		title_data.add("FA_PSO");
		title_data.add("FA_PSO");
		title_data.add("FA");
		title_data.add("FA");
	}
}
