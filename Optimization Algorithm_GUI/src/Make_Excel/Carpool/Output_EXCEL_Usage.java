package Make_Excel.Carpool;

import java.io.File;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import GUI.I_Set_Paths_for_Current_Simulation_Example;
import GUI.GUI_Carpool.X_Select_Algorithm_Type_to_Solve_the_Problem;
import jxl.CellView;
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

public class Output_EXCEL_Usage{

	private static WritableWorkbook workbook;
	private static WritableSheet sheet;
	private static ArrayList<String> test_data = new ArrayList<String>();
	public static void main(int Passenger_Seat, int Driver_Seat, double Raiot) 
	{
		try {
			CellView cellView = new CellView();
	        cellView.setAutosize(true); // 自動調整欄寬
			File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
		    f1.mkdir();
			// TODO Auto-generated method stub
			String name = "output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+".xls";
			File file = new File(name);
	
				
			// Excel获得文件
			Workbook wb = Workbook.getWorkbook(new File(name));
			// 打开一个文件的副本，并且指定数据写回到原文件
			 workbook = Workbook.createWorkbook(new File(name), wb);
			 sheet = workbook.getSheet(0);
			 
			test_data = new ArrayList<String>();
			data_test(Passenger_Seat,Driver_Seat,Raiot);
			
			int row=sheet.getRows()-1;
			int k=34;
			 for(int i=0;i<test_data.size();i++){
				 if((i+k)==32 || (i+k)==33 || (i+k)==34){
					 jxl.write.Number label1=new jxl.write.Number( (i+k), row, Double.parseDouble(test_data.get(i)),Format());
			          sheet.addCell(label1);
			          sheet.setColumnView( (i+k), cellView);
				 }
				 else{
					 sheet.addCell(new Label( (i+k), row, test_data.get(i),Format()));
					 sheet.setColumnView( (i+k), cellView);
				 }
			 }
			workbook.write();
			workbook.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public static CellFormat Format() throws WriteException{
		
		WritableFont myFont = new WritableFont(WritableFont.createFont("標楷體"), 14);        
        myFont.setColour(Colour.BLACK);            
        WritableCellFormat cellFormat = new WritableCellFormat();
        
        cellFormat.setFont(myFont); // 指定字型
        cellFormat.setBackground(Colour.WHITE); // 背景顏色
        cellFormat.setAlignment(Alignment.CENTRE); // 對齊方式
        
        
		return cellFormat;
	}

	public static void data_test(int Passenger_Seat, int Driver_Seat, double Raiot){
		DecimalFormat df = new DecimalFormat("##.###");
		test_data.add(String.valueOf(Passenger_Seat));
		test_data.add(String.valueOf(Driver_Seat));
		test_data.add(String.valueOf(df.format(Raiot)));
		Calendar cal = Calendar.getInstance();
		String toDay =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(cal.getTime());
		test_data.add(toDay);
	}
}
