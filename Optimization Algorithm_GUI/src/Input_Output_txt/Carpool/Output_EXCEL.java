package Input_Output_txt.Carpool;

import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import GUI.I_Set_Paths_for_Current_Simulation_Example;
import GUI.Read_Classroom_and_Serial_number;
import GUI.GUI_Carpool.X_Select_Algorithm_Type_to_Solve_the_Problem;
import READ_TXT.Read_filter_and_detour_rate;
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
	private static WritableSheet sheet1,sheet,sheet2,sheet3;
	private static ArrayList<String> title_data = new ArrayList<String>();
	private static ArrayList<String> title_data1 = new ArrayList<String>();
	private static ArrayList<String> title_data2 = new ArrayList<String>();
	private static ArrayList<String> title_data3 = new ArrayList<String>();	
	private static ArrayList<String> title_data4 = new ArrayList<String>();
	private static ArrayList<String> test_data = new ArrayList<String>();
 
 
	private static ArrayList<List<String>> test_data1 = new ArrayList<List<String>>();
	
	public static void main(int D,int P,double Omega1,double Omega2,double Omega3
			,double Omega4,double Omega5,double Omega6,double Omega7,double Omega8
			,String X,String Y,double Fittest,int Iteration,int Generation,long T_total,long T_net ,boolean violate_restrictions) 
	{
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
				 sheet1 = workbook.createSheet("RideSharingDetails", 1);
				 sheet2 = workbook.createSheet("DriverBids", 2);
				 sheet3 = workbook.createSheet("PassengerBids", 3);
				 
				 title_data = new ArrayList<String>();
				 
				 data_title();
				 int row=sheet.getRows();
				 for(int i=0;i<title_data.size();i++){
					 sheet.addCell(new Label(i, row, title_data.get(i),Format()));
					 sheet.setColumnView(i, cellView);
				 }
				 
				 data_title1();
				  row=sheet1.getRows();
				 for(int i=0;i<title_data1.size();i++){
					 sheet1.addCell(new Label(i, row, title_data1.get(i),Format()));
					 sheet1.setColumnView(i, cellView);
				 }
				 
				 data_title2();
				  row=sheet2.getRows();
				 for(int i=0;i<title_data2.size();i++){
					 sheet2.addCell(new Label(i, row, title_data2.get(i),Format()));
					 sheet2.setColumnView(i, cellView);
				 }
				 data_title3();
				  row=sheet3.getRows();
				 for(int i=0;i<title_data3.size();i++){
					 sheet3.addCell(new Label(i, row, title_data3.get(i),Format()));
					 sheet3.setColumnView(i, cellView);
				 }
			} else {
				
				// Excel获得文件
				Workbook wb = Workbook.getWorkbook(new File(name));
				// 打开一个文件的副本，并且指定数据写回到原文件
				 workbook = Workbook.createWorkbook(new File(name), wb);

				 sheet = workbook.getSheet(0);
				
			}
			 
			test_data = new ArrayList<String>();
			data_test(D,P,Omega1,Omega2,Omega3
					,Omega4,Omega5,Omega6,Omega7,Omega8
					,X,Y,Fittest,Iteration,Generation,T_total,T_net,violate_restrictions);
			int row=sheet.getRows();
			 for(int i=0;i<test_data.size();i++){
				 if( i==4 || i==5 || i==7 || i==8 || i==9 || i==10 || i==11 || i==12 || i==13 || i==14 || i==17){
					 jxl.write.Number label1=new jxl.write.Number(i, row, Double.parseDouble(test_data.get(i)),Format());
			          sheet.addCell(label1);
			          sheet.setColumnView(i, cellView);
				 }
			     else if( i==18 ||  i==19 ||  i==20 ||  i==21 )
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
			 cellView.setAutosize(true);
			workbook.write();
			workbook.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static void Original_data(List<Integer> original_temp_variables_iteration ,List<Double> original_temp_variables_fitness_function_value,List<String> original_temp_variables_violate_restrictions
			,List<String> original_temp_variables_Global_best_X,List<String> original_temp_variables_Global_best_Y) 
	{
		try {
			CellView cellView = new CellView();
	        cellView.setAutosize(true); // 自動調整欄寬
			File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
		    f1.mkdir();
			// TODO Auto-generated method stub
			String name = "output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+X_Select_Algorithm_Type_to_Solve_the_Problem.method()+"\\"+"Original_data.xls";
			File file = new File(name);
			if (!file.exists()) {// 先判斷目錄存不存在
				// file.mkdirs();
				
				 workbook = Workbook.createWorkbook(new File(
						 name));
				 sheet = workbook.createSheet("My Sheet", 0);
				 
				 title_data4 = new ArrayList<String>();
				 
				 data_title4();
				 int row=sheet.getRows();
				 for(int i=0;i<title_data4.size();i++){
					 sheet.addCell(new Label(i, row, title_data4.get(i),Format()));
					 sheet.setColumnView(i, cellView);
				 }
				 
			} else {
				
				// Excel获得文件
				Workbook wb = Workbook.getWorkbook(new File(name));
				// 打开一个文件的副本，并且指定数据写回到原文件
				 workbook = Workbook.createWorkbook(new File(name), wb);
				 
				// sheet = workbook.getSheet(workbook.getNumberOfSheets());
				 sheet = workbook.createSheet("My Sheet"+workbook.getNumberOfSheets(), workbook.getNumberOfSheets());
				 title_data4 = new ArrayList<String>();
				 
				 data_title4();
				 int row=sheet.getRows();
				 for(int i=0;i<title_data4.size();i++){
					 sheet.addCell(new Label(i, row, title_data4.get(i),Format()));
					 sheet.setColumnView(i, cellView);
				 }
			}
	
			test_data1 = new ArrayList<List<String>>();
			data_test1(original_temp_variables_iteration , original_temp_variables_fitness_function_value,original_temp_variables_violate_restrictions
					,original_temp_variables_Global_best_X,original_temp_variables_Global_best_Y);
			int row=sheet.getRows();
			int b=0,c=0;
			 for(int i=0;i<test_data1.size();i++){
				 b+=1;
				 if(b>65535){
					 c+=6;
					 b=0;
					 for(int k=0;k<title_data4.size();k++){
						 sheet.addCell(new Label(c+k, 0, title_data4.get(k),Format()));
						 sheet.setColumnView(c, cellView);
					 }
					 row=1;
				 }
				 for(int j=0;j<test_data1.get(i).size();j++){
					 if( j==1){
						 jxl.write.Number label1=new jxl.write.Number(j+c, row, Double.parseDouble(test_data1.get(i).get(j)),Format());
				          sheet.addCell(label1);
				          sheet.setColumnView(j+c, cellView);
					 }
				     else if(j==0)
				     {
				    	 jxl.write.Number label1=new jxl.write.Number(j+c, row,Integer.parseInt(test_data1.get(i).get(j)),Format());
				          sheet.addCell(label1);
				          sheet.setColumnView(j+c, cellView);
				     }
					 else{
						 sheet.addCell(new Label(j+c, row, test_data1.get(i).get(j),Format()));
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
	public static void data_test(int D,int P,double Omega1,double Omega2,double Omega3
			,double Omega4,double Omega5,double Omega6,double Omega7,double Omega8
			,String X,String Y,double Fittest,int Iteration,int Generation,long T_total,long T_net,boolean violate_restrictions ){
	
		Read_filter_and_detour_rate.main();
		Read_CarpoolData_Generation_Mode.main();
		Read_Classroom_and_Serial_number.main();
		test_data.add(I_Set_Paths_for_Current_Simulation_Example.filename());
		test_data.add(String.valueOf(D));
		test_data.add(String.valueOf(P));
		test_data.add(Read_CarpoolData_Generation_Mode.mode());
		test_data.add(String.valueOf(Read_filter_and_detour_rate.getfilter_rate()));
		test_data.add(String.valueOf(Read_filter_and_detour_rate.getdetour_rate()));
		test_data.add(X_Select_Algorithm_Type_to_Solve_the_Problem.method);
		test_data.add(String.valueOf(Omega1));
		test_data.add(String.valueOf(Omega2));
		test_data.add(String.valueOf(Omega3));
		test_data.add(String.valueOf(Omega4));
		test_data.add(String.valueOf(Omega5));
		test_data.add(String.valueOf(Omega6));
		test_data.add(String.valueOf(Omega7));
		test_data.add(String.valueOf(Omega8));
		test_data.add(X);
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
	
	public static void data_test1(List<Integer> original_temp_variables_iteration ,List<Double> original_temp_variables_fitness_function_value,List<String> original_temp_variables_violate_restrictions
			,List<String> original_temp_variables_Global_best_X,List<String> original_temp_variables_Global_best_Y){
	
		for(int i=0;i<original_temp_variables_violate_restrictions.size();i++){
			ArrayList<String> data4 = new ArrayList<String>();
			data4.add(String.valueOf(original_temp_variables_iteration.get(i)));
			data4.add(String.valueOf(original_temp_variables_fitness_function_value.get(i)));
			data4.add(original_temp_variables_violate_restrictions.get(i));
			data4.add(original_temp_variables_Global_best_X.get(i));
			data4.add(original_temp_variables_Global_best_Y.get(i));
			test_data1.add(data4);
		
		}
	}
	
	public static void data_title1(){
		title_data1.add("Project name");
		title_data1.add("Algorithm");
		title_data1.add("上下車順序");
		title_data1.add("B(共乘前距離)");
		title_data1.add("r(共乘後距離)");
		title_data1.add("(r-B)/B");
		title_data1.add("投標金額");
		title_data1.add("Reward");
		title_data1.add("Reward/投標金額");
		title_data1.add("Reward2");
		title_data1.add("Reward2/投標金額");
		title_data1.add("Reward3");
		title_data1.add("Reward3/投標金額");
		title_data1.add("Reward4");
		title_data1.add("Reward4/投標金額");
		title_data1.add("distance");
		title_data1.add("time");
		title_data1.add("共乘前後比率");
		title_data1.add("建檔時間");
	
	}
	public static void data_title2(){
		title_data2.add("Project name");
		title_data2.add("Algorithm");
		title_data2.add("Xd");
		title_data2.add("Xj");
		title_data2.add("X");
		title_data2.add("D_ID");
		title_data2.add("第幾個標");
		title_data2.add("qdjk");
		title_data2.add("Cdj");
		title_data2.add("Odj");
		title_data2.add("adj");
		title_data2.add("Wqdjk");
		title_data2.add("ldj");
		title_data2.add("建檔時間");
	}
	public static void data_title3(){
		title_data3.add("Project name");
		title_data3.add("Algorithm");
		title_data3.add("Yp");
		title_data3.add("Yh");
		title_data3.add("Y");
		title_data3.add("P_ID");
		title_data3.add("第幾個標");
		title_data3.add("Sphk");
		title_data3.add("fph");
		title_data3.add("建檔時間");
	}
	
	public static void data_title4(){
		title_data4.add("Iteration");
		title_data4.add("Fitness Function Value");
		title_data4.add("Violate_constraints");
		title_data4.add("Global best_X");
		title_data4.add("Global best_Y");
	
	}
	
}
