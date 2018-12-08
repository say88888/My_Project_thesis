package Make_Excel.Carpool;

import java.io.File;
import java.util.ArrayList;

import GUI.GUI_Consolidation_excel.Select_multi_Algorithm_Arrangement_excel;
import GUI.GUI_Consolidation_excel.Select_multi_Example_Arrangement_excel;
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

public class Arrangement_excel_GUI {
	private static ArrayList<String> test_data = new ArrayList<String>();
	private static ArrayList<String> title_data = new ArrayList<String>();
	private static WritableWorkbook workbook;
	private static WritableSheet sheet1;
	
	private static ArrayList<String> lst_Select_Algorithm2 = new ArrayList<String>();
	private static ArrayList<String> lst_Path2 = new ArrayList<String>();
	
	public static void main() {
		// TODO Auto-generated method stub
		
		 lst_Select_Algorithm2=Select_multi_Algorithm_Arrangement_excel.lst_Select_Algorithm2();
		 lst_Path2=Select_multi_Example_Arrangement_excel.lst_Path2();
		 
		int k;

		String fileName;

		fileName = "output\\";

		CellView cellView = new CellView();
        cellView.setAutosize(true); // 自動調整欄寬
		try {
			 workbook = Workbook.createWorkbook(new File(
					"output\\Arrangement_excel.xls"));
			 sheet1 = workbook.createSheet("My Sheet", 0);
			 title_data = new ArrayList<String>();
			 
			 data_title();
			 int row=sheet1.getRows();
			 for(int i=0;i<title_data.size();i++){
				 sheet1.addCell(new Label(i, row, title_data.get(i),Format()));
				 sheet1.setColumnView(i, cellView);
			 }
	
			 
	//	File f = new File(fileName);
	//	if (f.isDirectory()) {
	//		filename = f.list();
			System.out.println("開始讀檔...");

	//		for (k = 0; k < filename.length; k++) {
			for (k = 0; k < lst_Path2.size(); k++) {
				// ---------------------
	//			CfileName = fileName + "\\" + filename[k] + "\\";
	//			System.out.println(CfileName);
				try {
					Workbook book = Workbook.getWorkbook(new File(fileName+lst_Path2.get(k)+"\\"+lst_Path2.get(k)+ ".xls"));
	//						+ filename[k] + ".xls"));
					// 獲得第一個工作表對象
					Sheet sheet = book.getSheet(0);
					for(int j=1;j<=sheet.getRows();j++){
					test_data = new ArrayList<String>();
					Cell cell1 = sheet.getCell(6, j);
					String result = cell1.getContents(); // 獲得單元格的內容
					if(lst_Select_Algorithm2.contains(result)){
					for (int i = 0; i < sheet.getColumns(); i++) {
						Cell cell11 = sheet.getCell(i, j);
						String result1 = cell11.getContents(); // 獲得單元格的內容
						test_data.add(result1);
					}
					}
					
					  row=sheet1.getRows();
					 for(int i=0;i<test_data.size();i++){
						 if(i==4 || i==5 || i==7 || i==8 || i==9 || i==10 || i==11 || i==12 || i==13 || i==14 || i==17  || i==25 || i==26 || i==27 || i==28 || i==29 || i==30 || i==31 || i==32  || i==33  || i==36 ){
							 jxl.write.Number label1=new jxl.write.Number(i, row, Double.parseDouble(test_data.get(i)),Format());
					          sheet1.addCell(label1);
					          sheet1.setColumnView(i, cellView);
						 }
					     else if( i==18 ||  i==19 ||  i==20 ||  i==21 ||  i==34 ||  i==35)
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
			}
	//	} else {
	//		System.out.println("Error 目錄錯誤");
	//	}
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
	public static void data_title(){
		title_data.add("Project name");
		title_data.add("D");
		title_data.add("P");
		title_data.add("Data Generation Mode");
		title_data.add("Passenger_filter");
		title_data.add("detour_rate");
		title_data.add("Algorithm");
		title_data.add("Omega1");
		title_data.add("Omega2");
		title_data.add("Omega3");
		title_data.add("Omega4");
		title_data.add("Omega5");
		title_data.add("Omega6");
		title_data.add("Omega7");
		title_data.add("Omega8");
		title_data.add("X");
		title_data.add("Y");
		title_data.add("Fittest");
		title_data.add("Iteration");
		title_data.add("Generation");
		title_data.add("T_total(ms)");
		title_data.add("T_net(ms)");
		title_data.add("violate_constraints");
		title_data.add("教室");
		title_data.add("電腦編號");
		title_data.add("V-1");
		title_data.add("V-2");
		title_data.add("V-3");
		title_data.add("V-4");
		title_data.add("W-1 ");
		title_data.add("W-2");
		title_data.add("W-3");
		title_data.add("W-4");
		title_data.add("ShchmeI");
		title_data.add("乘客成功人數");
		title_data.add("司機全部座位");
		title_data.add("比率");
		title_data.add("建檔時間");
	}
}
