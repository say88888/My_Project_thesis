package Input_Output_txt.Tourism;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import GUI.I_Set_Paths_for_Current_Simulation_Example;
import GUI.Read_Classroom_and_Serial_number;
import GUI.GUI_Tourism.X_Select_Algorithm_Type_to_Solve_the_Problem;
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

public class Output_EXCEL {

	private static WritableWorkbook workbook;
	private static WritableSheet sheet;
	private static ArrayList<String> title_data = new ArrayList<String>();
	private static ArrayList<String> test_data = new ArrayList<String>();
	
	private static ArrayList<String> title_data_original = new ArrayList<String>();
	private static ArrayList<List<String>> test_data_original = new ArrayList<List<String>>();
	public static void main(int N,int Ia,int Ih,int It,int K,double Omega1,double Omega2,String Xa,String Xh,String Xt,String Y,double Fittest,int Iteration,int Generation,long T_total,long T_net ,boolean violate_restrictions) {
		try {
			CellView cellView = new CellView();
	        cellView.setAutosize(true); // 自動調整欄寬
			File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
		    f1.mkdir();
			// TODO Auto-generated method stub
			String name = "output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+".xls";
			File file = new File(name);
			if (!file.exists()) {// 先判斷目錄存不存在
				// file.mkdirs();
			
				 workbook = Workbook.createWorkbook(new File(
						 name));
				 sheet = workbook.createSheet("My Sheet", 0);
				 title_data = new ArrayList<String>();
				 
				 data_title();
				 int row=sheet.getRows();
				 for(int i=0;i<title_data.size();i++){
					 sheet.addCell(new Label(i, row, title_data.get(i),Format()));
					 sheet.setColumnView(i, cellView);
				 }
			} else {
		
				// Excel获得文件
				Workbook wb = Workbook.getWorkbook(new File(name));
				// 打开一个文件的副本，并且指定数据写回到原文件
				 workbook = Workbook.createWorkbook(new File(name), wb);

				 sheet = workbook.getSheet(0);
				
			}
			 
			test_data = new ArrayList<String>();
			data_test(N, Ia,Ih,It, K,Omega1,Omega2, Xa,Xh,Xt, Y, Fittest, Iteration, Generation, T_total, T_net,violate_restrictions);
			int row=sheet.getRows();
			 for(int i=0;i<test_data.size();i++){
				 if(i==13 || i==16 || i==17 ){
					 jxl.write.Number label1=new jxl.write.Number(i, row, Double.parseDouble(test_data.get(i)),Format());
			          sheet.addCell(label1);
			          sheet.setColumnView(i, cellView);
				 }
			     else if(  i==13 ||  i==14  )
			     {
			    	 jxl.write.Number label1=new jxl.write.Number(i, row,Integer.parseInt(test_data.get(i)),Format());
			          sheet.addCell(label1);
			          sheet.setColumnView(i, cellView);
			     }
				 else{
					 sheet.addCell(new Label(i, row, test_data.get(i),Format()));
					 sheet.setColumnView(i, cellView);
				 }
			 }
		//	sheet.addCell(new Label(0,sheet.getRows() , "测试数据",Format()));
		//	sheet.addCell(new Label(1,sheet.getRows() , "第二页的1234",Format()));
		
			workbook.write();
			workbook.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	

	
	
	public static void Original_data(List<Integer> original_temp_variables_iteration ,List<Double> original_temp_variables_fitness_function_value,List<String> original_temp_variables_violate_restrictions
			,List<String> original_temp_variables_Global_best_Xa,List<String> original_temp_variables_Global_best_Xh,List<String> original_temp_variables_Global_best_Xt,List<String> original_temp_variables_Global_best_Y) 
	{
		try {
			CellView cellView = new CellView();
	        cellView.setAutosize(true); // 自動調整欄寬
			File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
		    f1.mkdir();
			// TODO Auto-generated method stub
			String name = "output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+X_Select_Algorithm_Type_to_Solve_the_Problem.method+"\\"+"Original_data.xls";
			File file = new File(name);
			if (!file.exists()) {// 先判斷目錄存不存在
				// file.mkdirs();
				
				 workbook = Workbook.createWorkbook(new File(
						 name));
				 sheet = workbook.createSheet("My Sheet", 0);
				 
				 title_data_original = new ArrayList<String>();
				 
				 data_title_original();
				 int row=sheet.getRows();
				 for(int i=0;i<title_data_original.size();i++){
					 sheet.addCell(new Label(i, row, title_data_original.get(i),Format()));
					 sheet.setColumnView(i, cellView);
				 }
				 
			} else {
				
				// Excel获得文件
				Workbook wb = Workbook.getWorkbook(new File(name));
				// 打开一个文件的副本，并且指定数据写回到原文件
				 workbook = Workbook.createWorkbook(new File(name), wb);
				 
				// sheet = workbook.getSheet(workbook.getNumberOfSheets());
				 sheet = workbook.createSheet("My Sheet"+workbook.getNumberOfSheets(), workbook.getNumberOfSheets());
				 title_data_original = new ArrayList<String>();
				 
				 data_title_original();
				 int row=sheet.getRows();
				 for(int i=0;i<title_data_original.size();i++){
					 sheet.addCell(new Label(i, row, title_data_original.get(i),Format()));
					 sheet.setColumnView(i, cellView);
				 }
			}
	
			test_data_original = new ArrayList<List<String>>();
			data_test_original(original_temp_variables_iteration , original_temp_variables_fitness_function_value,original_temp_variables_violate_restrictions
					,original_temp_variables_Global_best_Xa,original_temp_variables_Global_best_Xh,original_temp_variables_Global_best_Xt,original_temp_variables_Global_best_Y);
			int row=sheet.getRows();
			int b=0,c=0;
			 for(int i=0;i<test_data_original.size();i++){
				 b+=1;
				 if(b>65535){
					 c+=6;
					 b=0;
					 for(int k=0;k<title_data_original.size();k++){
						 sheet.addCell(new Label(c+k, 0, title_data_original.get(k),Format()));
						 sheet.setColumnView(c, cellView);
					 }
					 row=1;
				 }
				 for(int j=0;j<test_data_original.get(i).size();j++){
					 if( j==1){
						 jxl.write.Number label1=new jxl.write.Number(j+c, row, Double.parseDouble(test_data_original.get(i).get(j)),Format());
				          sheet.addCell(label1);
				          sheet.setColumnView(j+c, cellView);
					 }
				     else if(j==0)
				     {
				    	 jxl.write.Number label1=new jxl.write.Number(j+c, row,Integer.parseInt(test_data_original.get(i).get(j)),Format());
				          sheet.addCell(label1);
				          sheet.setColumnView(j+c, cellView);
				     }
					 else{
						 sheet.addCell(new Label(j+c, row, test_data_original.get(i).get(j),Format()));
						 sheet.setColumnView(j+c, cellView);
					 } 
				 }
				 row+=1;
				
				
			 }
			 cellView.setAutosize(true);
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
	public static void data_title(){
		title_data.add("Project name");
		title_data.add("N");
		title_data.add("Ia");
		title_data.add("Ih");
		title_data.add("It");
		title_data.add("K");
		title_data.add("Omega1");
		title_data.add("Omega2");
		title_data.add("Algorithm");
		title_data.add("Xa");
		title_data.add("Xh");
		title_data.add("Xt");
		title_data.add("Y");
		title_data.add("Fittest");
		title_data.add("Iteration");
		title_data.add("Generation");
		title_data.add("T_total(ms)");
		title_data.add("T_net(ms)");
		title_data.add("violate_constraints");
		title_data.add("教室");
		title_data.add("電腦編號");
	}
	
	public static void data_test(int N,int Ia,int Ih,int It,int K,double Omega1,double Omega2,String Xa,String Xh,String Xt,String Y,double Fittest,int Iteration,int Generation,long T_total,long T_net,boolean violate_restrictions){
		Read_Classroom_and_Serial_number.main();
		test_data.add(I_Set_Paths_for_Current_Simulation_Example.filename());
		test_data.add(String.valueOf(N));
		test_data.add(String.valueOf(Ia));
		test_data.add(String.valueOf(Ih));
		test_data.add(String.valueOf(It));
		test_data.add(String.valueOf(K));
		test_data.add(String.valueOf(Omega1));
		test_data.add(String.valueOf(Omega2));
		test_data.add(X_Select_Algorithm_Type_to_Solve_the_Problem.method);
		test_data.add(Xa);
		test_data.add(Xh);
		test_data.add(Xt);
		test_data.add(Y);
		test_data.add(String.valueOf(Fittest));
		test_data.add(String.valueOf(Iteration));
		test_data.add(String.valueOf(Generation));
		test_data.add(String.valueOf(T_total));
		test_data.add(String.valueOf(T_net));
		test_data.add(String.valueOf(violate_restrictions));
		test_data.add(Read_Classroom_and_Serial_number.getClassroom());
		test_data.add(Read_Classroom_and_Serial_number.getSerial_number());
	}

	public static void data_test_original(List<Integer> original_temp_variables_iteration ,List<Double> original_temp_variables_fitness_function_value,List<String> original_temp_variables_violate_restrictions
			,List<String> original_temp_variables_Global_best_Xa,List<String> original_temp_variables_Global_best_Xh,List<String> original_temp_variables_Global_best_Xt,List<String> original_temp_variables_Global_best_Y){
		
		for(int i=0;i<original_temp_variables_violate_restrictions.size();i++){
			ArrayList<String> data4 = new ArrayList<String>();
			data4.add(String.valueOf(original_temp_variables_iteration.get(i)));
			data4.add(String.valueOf(original_temp_variables_fitness_function_value.get(i)));
			data4.add(original_temp_variables_violate_restrictions.get(i));
			data4.add(original_temp_variables_Global_best_Xa.get(i));
			data4.add(original_temp_variables_Global_best_Xh.get(i));
			data4.add(original_temp_variables_Global_best_Xt.get(i));
			data4.add(original_temp_variables_Global_best_Y.get(i));
			test_data_original.add(data4);
		}
	}
	
	public static void data_title_original(){
		title_data_original.add("Iteration");
		title_data_original.add("Fitness function value");
		title_data_original.add("Violate_constraints");
		title_data_original.add("Global best_Xa");
		title_data_original.add("Global best_Xh");
		title_data_original.add("Global best_Xt");
		title_data_original.add("Global best_Y");
	
	}

}
