package Make_Excel.Carpool;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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

public class Output_EXCEL_DriverBids extends carpool_results_test{

	private static WritableWorkbook workbook;
	private static WritableSheet sheet;
	private static ArrayList<String> test_data = new ArrayList<String>();
	public static void main(int[] Xd, int[] Xj,int[] Xdj,double[][] DriverBids,boolean Adjust_model) 
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
			 sheet = workbook.getSheet(2);
			 
			test_data = new ArrayList<String>();
			data_test(Xd,Xj,Xdj,DriverBids,Adjust_model);
			
			int row=sheet.getRows()+1;
			int k=0;
			
			 for(int i=0;i<test_data.size();i++){
				 
				 
				 if( k==2 || k==3 || k==4 || k==6 || k==8 || k==9 || k==10 || k==12){
					 jxl.write.Number label1=new jxl.write.Number(k, row, Double.parseDouble(test_data.get(i)),Format());
			          sheet.addCell(label1);
			          sheet.setColumnView(k, cellView);
				 }
				 else{
					 sheet.addCell(new Label(k, row, test_data.get(i),Format()));
					 sheet.setColumnView(k, cellView);
				 	}
				 k++;
					 if(k>13){k=0; row++;}
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

	public static void data_test(int[] Xd, int[] Xj,int[] Xdj,double[][] DriverBids,boolean Adjust_model){
		String str;
		ArrayList<String> Xtxt = new ArrayList<String>();
		Xtxt.clear();
		try {
			FileReader PBr = new FileReader("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+
					
					X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"X.txt");
			
			BufferedReader br = new BufferedReader(PBr);
			while ((str = br.readLine()) != null) { // 每次讀一行
				Xtxt.add(str);// 將此行以空白(white space)切成字串陣列, 存入 Vector暫存
			}
			br.close(); // 關檔
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		int math=0;
		if(Adjust_model==false){
		for (int i = 0; i < Read_Carpool_file.getD(); i++){
			for(int j=0;j<Read_Carpool_file.getJd(i);j++){
				test_data.add(I_Set_Paths_for_Current_Simulation_Example.filename());
				test_data.add(X_Select_Algorithm_Type_to_Solve_the_Problem.method);
				test_data.add(String.valueOf(Xd[math]));
				test_data.add(String.valueOf(Xj[math]));
				test_data.add(String.valueOf(Xdj[math]));
				test_data.add(Read_INPUT_TXT_filter.getD_ID(i));
				test_data.add(String.valueOf(Xj[math]));
				 String qdjk="";      	 
  	        	 for(int k=0;k<Read_Carpool_file.getK();k++)
  	        		 qdjk+=String.valueOf(Read_Carpool_file.getqdjk(i,j,k))+"  ";    	 
  	        	test_data.add(qdjk);
  	        	test_data.add(String.valueOf(Read_Carpool_file.getCdj(i,j)));
  	        	test_data.add(String.valueOf(Read_Carpool_file.getOdj(i,j)));
  	        	test_data.add(String.valueOf(Read_Carpool_file.getadj(i,j)));
  	        	 String Wqdjk="";
  	        	 for(int k=0;k<Read_Carpool_file.getK();k++)
  	        		Wqdjk+=String.valueOf(Read_Carpool_file.getWqdjk(i,j,k))+"  ";
  	        	test_data.add(Wqdjk);
  	        	test_data.add(String.valueOf(Read_Carpool_file.getldj(i,j)));
				Calendar cal = Calendar.getInstance();
				String toDay =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(cal.getTime());
				test_data.add(toDay);
				math++;
				}	
			}
		}else{
			for (int i = 0; i < Read_Carpool_file.getD(); i++){
				for(int j=0;j<Read_Carpool_file.getJd(i);j++){
					if(Integer.parseInt(Xtxt.get(math))==0){
					test_data.add(I_Set_Paths_for_Current_Simulation_Example.filename());
					test_data.add(X_Select_Algorithm_Type_to_Solve_the_Problem.method);
					test_data.add(String.valueOf(Xd[math]));
					test_data.add(String.valueOf(Xj[math]));
					test_data.add(String.valueOf(Xdj[math]));
			
					test_data.add(Read_INPUT_TXT_filter.getD_ID(i));
					test_data.add(String.valueOf(Xj[math]));
					 String qdjk="";      	 
	  	        	 for(int k=0;k<Read_Carpool_file.getK();k++)
	  	        		 qdjk+=String.valueOf(Read_Carpool_file.getqdjk(i,j,k))+"  ";    	 
	  	        	test_data.add(qdjk);
	  	        	test_data.add(String.valueOf(Read_Carpool_file.getCdj(i,j)));
	  	        	test_data.add(String.valueOf(Read_Carpool_file.getOdj(i,j)));
	  	        	test_data.add(String.valueOf(Read_Carpool_file.getadj(i,j)));
	  	        	 String Wqdjk="";
	  	        	 for(int k=0;k<Read_Carpool_file.getK();k++)
	  	        		Wqdjk+=String.valueOf(Read_Carpool_file.getWqdjk(i,j,k))+"  ";
	  	        	test_data.add(Wqdjk);
	  	        	test_data.add(String.valueOf(Read_Carpool_file.getldj(i,j)));
					Calendar cal = Calendar.getInstance();
					String toDay =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(cal.getTime());
					test_data.add(toDay);
					math++;}
					else
					{
						test_data.add(I_Set_Paths_for_Current_Simulation_Example.filename());
						test_data.add(X_Select_Algorithm_Type_to_Solve_the_Problem.method);
						test_data.add(String.valueOf(Xd[math]));
						test_data.add(String.valueOf(Xj[math]));
						test_data.add(String.valueOf(Xdj[math]));
						
						test_data.add(Read_INPUT_TXT_filter.getD_ID(i));
						test_data.add(String.valueOf(Xj[math]));
						 String qdjk="";  
						 for(int l=0;l<K+1;l++){
								if(l+1<(P+1))
									qdjk+=String.valueOf((int)DriverBids[i][l])+" ";
								else {
									test_data.add(qdjk);
									test_data.add(String.valueOf((int)DriverBids[i][l]));
								}
							}
						 test_data.add(String.valueOf(determine_XObj.getOdj(i)));
						 test_data.add(String.valueOf(Read_Carpool_file.getadj(i,j)));
						 String Wqdjk="";
		  	        	 for(int k=0;k<Read_Carpool_file.getK();k++)
		  	        		Wqdjk+=String.valueOf(DriverBids[i][k]*Read_Carpool_file.getWqdjk(i, j, k));    	 
		  	        	test_data.add(Wqdjk);
		  	        	test_data.add(String.valueOf(Read_Carpool_file.getldj(i,j)));
		  	        	Calendar cal = Calendar.getInstance();
						String toDay =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(cal.getTime());
						test_data.add(toDay);
						math++;
					}
				}	
			}
		}
	}

}
