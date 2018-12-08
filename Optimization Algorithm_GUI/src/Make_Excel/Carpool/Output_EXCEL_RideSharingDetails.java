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

public class Output_EXCEL_RideSharingDetails {

	private static WritableWorkbook workbook;
	private static WritableSheet sheet;
	private static WritableSheet sheet1;
	private static ArrayList<String> test_data = new ArrayList<String>();
	public static void main(int Xd, int Xj,String up_down,double B,double r,
	double Br,double driverBids, double reward1,double reward2,double reward3,double reward4,double  distance,int time,double Ratio,boolean Nextrow) 
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
			 sheet = workbook.getSheet(1);
			 sheet1= workbook.getSheet(0);
			test_data = new ArrayList<String>();
			data_test(Xd,Xj,up_down,B,r,Br,driverBids,reward1,reward2,reward3,reward4,distance,time,Ratio);
			
			int row=sheet.getRows();
			if(Nextrow==true){row+=1;}
			
			 for(int i=0;i<test_data.size();i++){
				 if( i==3 || i==4 || i==5 || i==6 || i==7 || i==8 || i==9 || i==10 || i==11 || i==12 || i==13 ||  i==14 ||  i==15 ||  i==16 || i==17){
					 jxl.write.Number label1=new jxl.write.Number(i, row, Double.parseDouble(test_data.get(i)),Format());
			          sheet.addCell(label1);
			          sheet.setColumnView(i, cellView);
				 }
				 else{
					 sheet.addCell(new Label(i, row, test_data.get(i),Format()));
					 sheet.setColumnView(i, cellView);
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

	public static void data_test(int Xd, int Xj,String up_down,double B,double r,
			double Br,double driverBids, double reward1,double reward2,double reward3,double reward4,double  distance,int time,double Ratio ){
		DecimalFormat df = new DecimalFormat("##.###");
		test_data.add(I_Set_Paths_for_Current_Simulation_Example.filename());
		test_data.add(X_Select_Algorithm_Type_to_Solve_the_Problem.method);
		String str;
		str="("+String.valueOf(Xd)+","+String.valueOf(Xj)+")"+ up_down;
		test_data.add(str);
		test_data.add(String.valueOf(B));
		test_data.add(String.valueOf(r));
		test_data.add(String.valueOf(df.format(Br)));
		test_data.add(String.valueOf(df.format(driverBids)));
		test_data.add(String.valueOf(df.format(reward1)));
		test_data.add(String.valueOf(df.format(reward1/driverBids)));
		test_data.add(String.valueOf(df.format(reward2)));
		test_data.add(String.valueOf(df.format(reward2/driverBids)));
		test_data.add(String.valueOf(df.format(reward3)));
		test_data.add(String.valueOf(df.format(reward3/driverBids)));
		test_data.add(String.valueOf(df.format(reward4)));
		test_data.add(String.valueOf(df.format(reward4/driverBids)));
		test_data.add(String.valueOf(df.format(distance)));
		test_data.add(String.valueOf(time));
		test_data.add(String.valueOf(df.format(Ratio)));
		Calendar cal = Calendar.getInstance();
		String toDay =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(cal.getTime());
		test_data.add(toDay);
		
	}
}
