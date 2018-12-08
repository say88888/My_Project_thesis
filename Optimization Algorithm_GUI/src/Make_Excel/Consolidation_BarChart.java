package Make_Excel;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;

import GUI.GUI_Consolidation_BarChart.Select_multi_Algorithm_Arrangement_excel;
import GUI.GUI_Consolidation_BarChart.Select_multi_Example_Arrangement_excel;
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

public class Consolidation_BarChart {
	
	private static ArrayList<String> title_data = new ArrayList<String>();
	private static WritableWorkbook workbook;
	private static WritableSheet sheet1;

	private static ArrayList<String> lst_Select_Algorithm2 = new ArrayList<String>();
	private static ArrayList<String> lst_Path2 = new ArrayList<String>();
	private static String Example;
	private static ArrayList<String> colum = new ArrayList<String>();
	private static List<List<String>> Consolidation_Algorithm_mean_value = new ArrayList<List<String>>();
	private static List<List<String>> Consolidation_Algorithm = new ArrayList<List<String>>();
	
	public static void main( ) {
		// TODO Auto-generated method stub
		int k, m = 0;
		 lst_Select_Algorithm2=Select_multi_Algorithm_Arrangement_excel.lst_Select_Algorithm2();
		 lst_Path2=Select_multi_Example_Arrangement_excel.lst_Path2();
		 colum.clear();
		 title_data.clear();
		String fileName;

		fileName = "output\\";

		String[] filename, Pfilename, Dfilename;
		String CfileName, line, line1, line2, line3, DfileName;
		CellView cellView = new CellView();
        cellView.setAutosize(true); // 自動調整欄寬
		try {
			 workbook = Workbook.createWorkbook(new File(
					"output\\Consolidation_BarChart.xls"));
			 sheet1 = workbook.createSheet("My Sheet", 0);
			 title_data = new ArrayList<String>();
			 
			 for(int i=0;i<lst_Path2.size();i++)
				 Read_Excel(lst_Path2.get(i),i);
			 
		//		 System.out.println("colum="+colum);
				 
			 data_title();
			 
			 int row=sheet1.getRows();
			 for(int i=0;i<title_data.size();i++){
				 sheet1.addCell(new Label(i, 0, title_data.get(i),Format()));
				 sheet1.setColumnView(i, cellView);
			 }
			 
			 for(int i=0;i<lst_Select_Algorithm2.size();i++){
				 row=sheet1.getRows();
				 sheet1.addCell(new Label(0, row, lst_Select_Algorithm2.get(i),Format()));
				 sheet1.setColumnView(0, cellView);
			 }
			
			 
			
			for (k = 0; k < lst_Path2.size(); k++) {
				row=1;
	  				
					for(int i=0;i < lst_Select_Algorithm2.size();i++){
						
			  //  		System.out.println(Consolidation_Algorithm.get(k)+" ----- "+ lst_Select_Algorithm2.get(i));
			    		
						if(Consolidation_Algorithm.get(k).contains(lst_Select_Algorithm2.get(i))){
							
							for(int l=0;l<Consolidation_Algorithm.get(k).size();l++){
								if(Consolidation_Algorithm.get(k).get(l).equals(lst_Select_Algorithm2.get(i)))
								{
									if(Consolidation_Algorithm_mean_value.get(k).size()%2==0)
			      					{
										String value=Consolidation_Algorithm_mean_value.get(k).get(l*2);
										jxl.write.Number label1=new jxl.write.Number(k+1,row++, Double.parseDouble(value),Format());
										sheet1.addCell(label1);
										sheet1.setColumnView(k+1, cellView);
			      					}
									else
									{
			      						if(l==0){
		      								String value=Consolidation_Algorithm_mean_value.get(k).get(0);
		      								jxl.write.Number label1=new jxl.write.Number(k+1,row++, Double.parseDouble(value),Format());
											sheet1.addCell(label1);
											sheet1.setColumnView(k+1, cellView);
		      								}
		      						else{
		      								String value=Consolidation_Algorithm_mean_value.get(k).get(l*2-1);
		      						//		tableRowTwo.getCell(k1).setText(s+"/"+s1);
		      								jxl.write.Number label1=new jxl.write.Number(k+1,row++, Double.parseDouble(value),Format());
											sheet1.addCell(label1);
											sheet1.setColumnView(k+1, cellView);
		      								
		      								}
									}
								}
							}
						}
						}
				
				}
		
		
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
		
		title_data.add("Algorithm");
		for(int i=0;i<colum.size();i++)
			title_data.add(colum.get(i));
		
	}
	
	static void Read_Excel(String lst_Path,int i){
		String fileName;
		fileName = "output\\";
		ArrayList<String> Algorithm = new ArrayList<String>();
		ArrayList<String> Algorithm_mean_value = new ArrayList<String>();

		try {
			Workbook book = Workbook.getWorkbook(new File(fileName+lst_Path));
			// 獲得第一個工作表對象
			Sheet sheet = book.getSheet(0);
			int coloumNum=sheet.getRow(0).length;
			
			System.out.println("coloumNum="+coloumNum);
			System.out.println(" sheet.getRows()="+ sheet.getRows());
			
			for (int j = 1; j < coloumNum; j += 1) {

				Cell cell1 = sheet.getCell(j, 0);
				String result = cell1.getContents(); // 獲得單元格的內容
				result=result.trim();
			//	result=result.replace("_Carpool",""); 
			//	result=result.replace("_DA",""); 
				if(!Algorithm.contains(result)){
				Algorithm.add(result);
				}
				
				cell1 = sheet.getCell(j, sheet.getRows()-2);
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
		
	//	System.out.println();
	//	for(int j=0;j<Algorithm.size();j++)
	//		System.out.println("Algorithm="+Algorithm.get(j));
		
	//	System.out.println();
	//	for(int j=0;j<Algorithm_mean_value.size();j++)
	//		System.out.println("Algorithm_mean_value="+Algorithm_mean_value.get(j));
		
	//	System.out.println();
	//	System.out.println("Example_Path="+Example);
		
		Split(Example,i);
		
	}
	
	static void Split(String Example,int i)
	{
		
		   if(Example.indexOf("pop")>-1){ 
        	//有
       // 	System.out.print("有");
              String[] tokens = Example.split("pop");
        //      System.out.println(tokens[1]);
              
              Pattern p = Pattern.compile("\\d{1,}");//这个2是指连续数字的最少个数
              String u = tokens[1];
              java.util.regex.Matcher m = p.matcher(u);
              int k = 0;
             ArrayList<String> math = new ArrayList<String>();
              while (m.find()) {
              	math.add(m.group());
         //         System.out.println(m.group());
                  k++;
              }
              
              colum.add("Pop"+math.get(0));
              System.out.println("Pop"+math.get(0));
        	} 
        	else{ 
        	//無 
      //  		System.out.print("沒有");
        		colum.add("PopX"+String.valueOf((i+1)));
        //		   System.out.println("PopX"+String.valueOf((i+1)));
        	} 
        
        System.out.println();
		
	}
}
