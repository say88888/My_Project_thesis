package GUI.GUI_Carpool;
  
import java.awt.Dimension;  
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;  

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.jfree.chart.*;  
import org.jfree.chart.labels.StandardXYToolTipGenerator;  
import org.jfree.chart.plot.PlotOrientation;  
import org.jfree.chart.plot.XYPlot;  
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;  
import org.jfree.data.xy.*;  
import org.jfree.ui.ApplicationFrame;  
import org.jfree.ui.RefineryUtilities;  

import GUI.I_Set_Paths_for_Current_Simulation_Example;
import Input_Output_txt.Read_Parameters_for_the_chart;
  

class XYLineAndShapeRendererDemo_Carpool extends ApplicationFrame{  
	
    private static final long serialVersionUID = 1L;  
     
    private static List<Integer> Original_temp_variables_iteration = new ArrayList<Integer>();
	private static List<Double> Original_temp_variables_fitness_function_value = new ArrayList<Double>();
	
	private static WritableWorkbook workbook;
	private static WritableSheet sheet1;
	private static   ArrayList<String> lst_Select_Algorithm = new ArrayList<String>(); 
	
	private static List<Integer>  sheet1_length = new ArrayList<Integer>();
	
    public XYLineAndShapeRendererDemo_Carpool(String s)  
    {  
        super(s);  
        XYDataset xydataset = createDataset();  
        JFreeChart jfreechart = createChart(xydataset);  
        ChartPanel chartpanel = new ChartPanel(jfreechart);  
        chartpanel.setPreferredSize(new Dimension(500, 300));  
        setContentPane(chartpanel);  
    }  
     
    private static JFreeChart createChart(XYDataset xydataset)  
    {  
        JFreeChart jfreechart = ChartFactory.createXYLineChart("", "Evaluations", "Fithess value", xydataset, PlotOrientation.VERTICAL, true, true, false);  
        XYPlot xyplot = (XYPlot)jfreechart.getPlot();  
        XYLineAndShapeRenderer xylineandshaperenderer = new XYLineAndShapeRenderer();  
   //     xylineandshaperenderer.setSeriesLinesVisible(0, true);  //true 顯示線條 false 顯示線條
  //      xylineandshaperenderer.setSeriesShapesVisible(0, false);  //true 顯示圖示 false 顯示圖示
    //    xylineandshaperenderer.setSeriesLinesVisible(1, true);  
  //      xylineandshaperenderer.setSeriesShapesVisible(1,false);  
        xylineandshaperenderer.setToolTipGenerator(new StandardXYToolTipGenerator());  
        xylineandshaperenderer.setDefaultEntityRadius(6);  
        xyplot.setRenderer(xylineandshaperenderer);  
        
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        try {
			ChartUtilities.writeChartAsJPEG(byteArrayOutputStream, jfreechart, 500, 300);
		    FileOutputStream file=new FileOutputStream("d:/a.jpg");
	        file.write(byteArrayOutputStream.toByteArray());
	        file.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
        return jfreechart;  
    }  
     
    private static XYDataset createDataset()  
    {  
    	Read_Original_data_Excel();
    	Read_Parameters_for_the_chart.main();  	
    	
       
        XYSeriesCollection xyseriescollection = new XYSeriesCollection();  
        
        int Start=Integer.parseInt(Read_Parameters_for_the_chart.Start());
        int End=Integer.parseInt(Read_Parameters_for_the_chart.End());
        int Interval=Integer.parseInt(Read_Parameters_for_the_chart.Interval());
        
        int length=0;
        
        for(int x=0;x<lst_Select_Algorithm.size();x++){
        	
        XYSeries xyseries = new XYSeries(lst_Select_Algorithm.get(x));  
        
        for(int i=Start;i<End;i+=Interval)
        	xyseries.add(Original_temp_variables_iteration.get(length+i), Original_temp_variables_fitness_function_value.get(length+i));
        
        length+=sheet1_length.get(x);
        
        xyseriescollection.addSeries(xyseries);  
       /*
        XYSeries  = new XYSeries("Series 2");  
        xyseries1.add(1.0D, 7.2999999999999998D);  
        xyseries1.add(2D, 6.7999999999999998D);  
        xyseries1.add(3D, 9.5999999999999996D);  
        xyseries1.add(4D, 5.5999999999999996D);  
     
        XYSeries xyseries2 = new XYSeries("Series 3");  
        xyseries2.add(100D, 7.2999999999999998D);  
        xyseries2.add(200, 6.7999999999999998D);  
        xyseries2.add(300, 9.5999999999999996D);  
        xyseries2.add(400, 5.5999999999999996D);
       */ 
     

    //    xyseriescollection.addSeries(xyseries1);  
    //    xyseriescollection.addSeries(xyseries2);  
        }
        return xyseriescollection;  
    }  
     
    public static JPanel createDemoPanel()  
    {  
        JFreeChart jfreechart = createChart(createDataset());  
        return new ChartPanel(jfreechart);  
    }  
     
    public static void main()  
    {  
        XYLineAndShapeRendererDemo_Carpool xylineandshaperendererdemo1 = new XYLineAndShapeRendererDemo_Carpool("XYLineAndShapeRenderer Demo");  
        xylineandshaperendererdemo1.pack();
        RefineryUtilities.centerFrameOnScreen(xylineandshaperendererdemo1);  
        xylineandshaperendererdemo1.setVisible(true);  
    }
    
    static void Read_Original_data_Excel(){
    	
    	lst_Select_Algorithm=Select_multi_Algorithm_show_chart_Carpool.lst_Select_Algorithm2();
    
    	
		for(int x=0;x<lst_Select_Algorithm.size();x++){
    	
    	String CfileName="output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+lst_Select_Algorithm.get(x)
    			+"\\Original_data.xls";
    	try {
			Workbook book = Workbook.getWorkbook(new File(CfileName));
			// 獲得第一個工作表對象
			Sheet sheet = book.getSheet(0);
			
			sheet1_length.add(sheet.getRows());
			
			for (int j = 1; j <= sheet.getRows(); j ++) {
					Cell cell1 = sheet.getCell(0, j);
					String result = cell1.getContents(); // 獲得單元格的內容
				Original_temp_variables_iteration.add(Integer.parseInt(result));
				
				cell1 = sheet.getCell(1, j);
				result = cell1.getContents(); // 獲得單元格的內容
				Original_temp_variables_fitness_function_value.add(Double.parseDouble(result));
				
			}
			book.close();

		} catch (Exception e) {
			System.out.println(e);
		}
    }
    }
    
}  
