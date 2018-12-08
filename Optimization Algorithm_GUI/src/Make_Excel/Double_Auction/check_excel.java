package Make_Excel.Double_Auction;

import java.io.File;
import java.util.ArrayList;

import jxl.Cell;
import jxl.CellView;
import jxl.Sheet;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.CellFormat;
import jxl.format.Colour;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class check_excel {
	private static ArrayList<String> test_data = new ArrayList<String>();
	private static ArrayList<String> title_data = new ArrayList<String>();
	private static WritableWorkbook workbook;
	private static WritableSheet sheet1;

	public static void main( ) {
		// TODO Auto-generated method stub
		int k, m = 0;

		String fileName;

		fileName = "output\\";

		String[] filename, Pfilename, Dfilename;
		String CfileName, line, line1, line2, line3, DfileName;
		CellView cellView = new CellView();
        cellView.setAutosize(true); // 自動調整欄寬
		try {
			 workbook = Workbook.createWorkbook(new File(
					"output\\test.xls"));
			 sheet1 = workbook.createSheet("My Sheet", 0);
			 title_data = new ArrayList<String>();
			 
			 data_title();
			 int row=sheet1.getRows();
			 for(int i=0;i<title_data.size();i++){
				 sheet1.addCell(new Label(i, row, title_data.get(i),Format()));
				 sheet1.setColumnView(i, cellView);
			 }
		 
		
			 
		
		File f = new File(fileName);
		if (f.isDirectory()) {
			filename = f.list();
			System.out.println("開始讀檔...");

			for (k = 0; k < filename.length; k++) {
				// ---------------------
				CfileName = fileName + "\\" + filename[k] + "\\";
				System.out.println(CfileName);
				try {
					Workbook book = Workbook.getWorkbook(new File(CfileName
							+ filename[k] + ".xls"));
					// 獲得第一個工作表對象
					Sheet sheet = book.getSheet(0);
					for(int j=1;j<=sheet.getRows();j++){
					test_data = new ArrayList<String>();
					for (int i = 0; i < sheet.getColumns(); i++) {
						Cell cell1 = sheet.getCell(i, j);
						String result = cell1.getContents(); // 獲得單元格的內容
						test_data.add(result);
					}
					
					  row=sheet1.getRows();
					 for(int i=0;i<test_data.size();i++){
						 if(i==8 || i==11 || i==12 ){
							 jxl.write.Number label1=new jxl.write.Number(i, row, Double.parseDouble(test_data.get(i)),Format());
					          sheet1.addCell(label1);
					          sheet1.setColumnView(i, cellView);
						 }
					     else if(  i==9 ||  i==10  )
					     {
					    	 jxl.write.Number label1=new jxl.write.Number(i, row,Integer.parseInt(test_data.get(i)),Format());
					          sheet1.addCell(label1);
					          sheet1.setColumnView(i, cellView);
					     }
						 else{
							 sheet1.addCell(new Label(i, row, test_data.get(i),Format()));
							 sheet1.setColumnView(i, cellView);
						 }
					 }
					}
					book.close();
				} catch (Exception e) {
					System.out.println(e);
				}

				/*
				 * File Cf = new File(CfileName); if (Cf.isDirectory()) {
				 * Pfilename = Cf.list(); for (j = 0; j < Pfilename.length; j++)
				 * { // System.out.println(Pfilename); }
				 * 
				 * } else { System.out.println("Error 子目錄錯誤"); }
				 */
				// }
			}
		} else {
			System.out.println("Error 目錄錯誤");
		}workbook.write();
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
	public static void data_title(){
		title_data.add("Project name");
		title_data.add("Data Generation Mode");
		title_data.add("N");
		title_data.add("I");
		title_data.add("K");
		title_data.add("Algorithm");
		title_data.add("X");
		title_data.add("Y");
		title_data.add("Fittest");
		title_data.add("Iteration");
		title_data.add("Generation");
		title_data.add("T_total(ms)");
		title_data.add("T_net(ms)");
	}
}
