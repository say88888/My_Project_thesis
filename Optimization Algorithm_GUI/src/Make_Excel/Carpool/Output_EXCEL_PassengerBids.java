package Make_Excel.Carpool;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;



import GUI.I_Set_Paths_for_Current_Simulation_Example;
import GUI.GUI_Carpool.X_Select_Algorithm_Type_to_Solve_the_Problem;
import READ_TXT.Read_INPUT_TXT_filter;
import Result_to_out_Carpool.Read_Carpool_file;
import Result_to_out_Carpool.carpool_results_test;
import Result_to_out_Carpool.determine_XObj;
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

public class Output_EXCEL_PassengerBids extends carpool_results_test{

	private static WritableWorkbook workbook;
	private static WritableSheet sheet;
	private static ArrayList<String> test_data = new ArrayList<String>();
	public static void main() 
	{
		try {
			CellView cellView = new CellView();
	        cellView.setAutosize(true); // 自動調整欄寬
			File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
		    f1.mkdir();
			// TODO Auto-generated method stub
			String name = "output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+".xls";

			// Excel获得文件
			Workbook wb = Workbook.getWorkbook(new File(name));
			// 打开一个文件的副本，并且指定数据写回到原文件
			 workbook = Workbook.createWorkbook(new File(name), wb);
			 sheet = workbook.getSheet(3);
			 
			test_data = new ArrayList<String>();
			data_test(Yp,Yh,Yph,PassengerBids);
			
			int row=sheet.getRows();
			int k=0;
			
			 for(int i=0;i<test_data.size();i++){
				 
				 if( k==2 || k==3 || k==4 || k==6 || k==8){
					 jxl.write.Number label1=new jxl.write.Number(k, row, Double.parseDouble(test_data.get(i)),Format());
			          sheet.addCell(label1);
			          sheet.setColumnView(k, cellView);
				 }else{
					 sheet.addCell(new Label(k, row, test_data.get(i),Format()));
					 sheet.setColumnView(k, cellView);
				 	}
					 k++;
					 if(k>9){k=0; row++;}
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

	public static void data_test(int[] Yp,int[] Yh,int[] Yph,double[][]PassengerBids){
		
		int math=0;
		for (int i = 0; i < Read_Carpool_file.getP(); i++){
			for(int j=0;j<Read_Carpool_file.getHp(i);j++){
				test_data.add(I_Set_Paths_for_Current_Simulation_Example.filename());
				test_data.add(X_Select_Algorithm_Type_to_Solve_the_Problem.method);
				test_data.add(String.valueOf(Yp[math]));
				test_data.add(String.valueOf(Yh[math]));
				test_data.add(String.valueOf(Yph[math]));
		
				test_data.add(Read_INPUT_TXT_filter.getP_ID(i));
				test_data.add(String.valueOf(Yh[math]));
				 String Sphk="";      	 
  	        	 for(int k=0;k<Read_Carpool_file.getK();k++)
  	        		Sphk+=String.valueOf(Read_Carpool_file.getSphk(i,j,k))+"  ";    	 
  	        	test_data.add(Sphk);
  	        	test_data.add(String.valueOf(Read_Carpool_file.getfph(i,j)));
				Calendar cal = Calendar.getInstance();
				String toDay =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(cal.getTime());
				test_data.add(toDay);
				math++;
				}	
			}	
	}

}
