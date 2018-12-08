package GUI.GUI_Carpool;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.IOException;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;




import READ_TXT.Read_INPUT_TXT_filter;
import Result_to_out_Carpool.Read_Carpool_file;

public class show_SQL_input_random_filter_data extends JFrame {

	private DefaultTableModel XtableModel,YtableModel,ZtableModel; // 表格模型對象
	private JTable X,Y,Z;
	 private JLabel Xid=new JLabel("Driver_initial_itinerary");
	 private JLabel Yid=new JLabel("Passenger_initial_itinerary");
	 private JLabel Zid=new JLabel("Car_data");
	 Container contentPane;
	  Container mainFrameCP = null;
	  
	public show_SQL_input_random_filter_data() throws ParseException {
		super();
		setTitle("表格");
		setBounds(50, 100, 1300, 600);
		contentPane = getContentPane();
		GridBagLayout gdb = new GridBagLayout();
		GridBagConstraints c;
		contentPane.setLayout(gdb);
		
		try {
			Read_INPUT_TXT_filter.loadData();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			Read_Carpool_file.loadData();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String[] XcolumnNames={"D_ID","行程","發車時間","延遲發車時間","到達時間","延遲到達時間"
				,"發車地緯度","發車地經度","發車地名稱"
				,"目的地緯度","目的地經度","目的地名稱","延遲時間"};
		
		Object[][] XtableVales = new String[Read_INPUT_TXT_filter.getD()][13];// 數據
	
		 for(int i=0;i<Read_INPUT_TXT_filter.getD();i++){
			 System.out.println(i);
			 XtableVales[i][0]=String.valueOf(Read_INPUT_TXT_filter.getD_ID(i));
			 XtableVales[i][1]=String.valueOf(Read_INPUT_TXT_filter.getD_itinerary_ID(i));
			 XtableVales[i][2]=String.valueOf(Read_INPUT_TXT_filter.getD_F_D_Time(i));
			 XtableVales[i][3]=String.valueOf(Read_INPUT_TXT_filter.getD_S_D_Time(i));
			 XtableVales[i][4]=String.valueOf(Read_INPUT_TXT_filter.getD_F_A_Time(i));
			 XtableVales[i][5]=String.valueOf(Read_INPUT_TXT_filter.getD_S_A_Time(i));
			 XtableVales[i][6]=String.valueOf(Read_INPUT_TXT_filter.getD_S_LAT(i));
			 XtableVales[i][7]=String.valueOf(Read_INPUT_TXT_filter.getD_S_LNG(i));
			 XtableVales[i][8]=String.valueOf(Read_INPUT_TXT_filter.getD_S_PLACE(i));
			 XtableVales[i][9]=String.valueOf(Read_INPUT_TXT_filter.getD_D_LAT(i));
			 XtableVales[i][10]=String.valueOf(Read_INPUT_TXT_filter.getD_D_LNG(i));
			 XtableVales[i][11]=String.valueOf(Read_INPUT_TXT_filter.getD_D_ADDRESS(i));
	//		 XtableVales[i][12]=String.valueOf(Read_INPUT_TXT_filter.X(i));
	    	}

		XtableModel = new DefaultTableModel(XtableVales, XcolumnNames);
		X = new JTable(XtableModel);
		JScrollPane XscrollPane = new JScrollPane(X); // 支持滾動
		XscrollPane.setPreferredSize(new Dimension(1250, 100));
		
		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.gridheight = 1;
		c.gridwidth = 5;
		c.fill = GridBagConstraints.HORIZONTAL;
		gdb.setConstraints(Xid, c);
		contentPane.add(Xid);
		
		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 1;
		c.gridheight = 1;
		c.gridwidth = 5;
		c.fill = GridBagConstraints.HORIZONTAL;
		gdb.setConstraints(XscrollPane, c);
		contentPane.add(XscrollPane);
		//getContentPane().add(XscrollPane, BorderLayout.LINE_START);
		XscrollPane.setViewportView(X);
		
		String[] YcolumnNames={"P_ID","行程","搭車時間","延遲搭車時間","下車時間","延遲下車時間"
				,"搭車地緯度","搭車地經度","搭車地名稱"
				,"下車地緯度","下車地經度","下車地名稱","競標金額","需求座位數","需求重量"};
		Object[][] YtableVales = new String[Read_INPUT_TXT_filter.getP()][15];// 數據
	
		 for(int i=0;i<Read_INPUT_TXT_filter.getP();i++){
			 YtableVales[i][0]=String.valueOf(Read_INPUT_TXT_filter.getP_ID(i));
			 YtableVales[i][1]=String.valueOf(Read_INPUT_TXT_filter.getP_itinerary_ID(i));
			 YtableVales[i][2]=String.valueOf(Read_INPUT_TXT_filter.getP_F_R_Time(i));
			 YtableVales[i][3]=String.valueOf(Read_INPUT_TXT_filter.getP_D_R_Time(i));
			 YtableVales[i][4]=String.valueOf(Read_INPUT_TXT_filter.getP_F_A_Time(i));
			 YtableVales[i][5]=String.valueOf(Read_INPUT_TXT_filter.getP_D_A_Time(i));
			 YtableVales[i][6]=String.valueOf(Read_INPUT_TXT_filter.getP_R_LAT(i));
			 YtableVales[i][7]=String.valueOf(Read_INPUT_TXT_filter.getP_R_LNG(i));
			 YtableVales[i][8]=String.valueOf(Read_INPUT_TXT_filter.getP_R_PLACE(i));
			 YtableVales[i][9]=String.valueOf(Read_INPUT_TXT_filter.getP_D_LAT(i));
			 YtableVales[i][10]=String.valueOf(Read_INPUT_TXT_filter.getP_D_LNG(i));
			 YtableVales[i][11]=String.valueOf(Read_INPUT_TXT_filter.getP_D_ADDRESS(i));
			 YtableVales[i][12]=String.valueOf(Read_INPUT_TXT_filter.getfph(i));
			 YtableVales[i][13]=String.valueOf(Read_INPUT_TXT_filter.getseat(i));
			 YtableVales[i][14]=String.valueOf(Read_INPUT_TXT_filter.getweight(i));
	    	}

		 YtableModel = new DefaultTableModel(YtableVales, YcolumnNames);
		Y = new JTable(YtableModel);
		JScrollPane YscrollPane = new JScrollPane(Y); // 支持滾動
		YscrollPane.setPreferredSize(new Dimension(1250, 100));
		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 3;
		c.gridheight = 1;
		c.gridwidth = 5;
		c.fill = GridBagConstraints.HORIZONTAL;
		gdb.setConstraints(Yid, c);
		contentPane.add(Yid);
		
		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 4;
		c.gridheight = 1;
		c.gridwidth = 5;
		c.fill = GridBagConstraints.HORIZONTAL;
		gdb.setConstraints(YscrollPane, c);
		contentPane.add(YscrollPane);
	//	getContentPane().add(YscrollPane, BorderLayout.LINE_END);
		YscrollPane.setViewportView(Y);
		
		
		String[] ZcolumnNames={"D_ID","車子號碼","車子座位數","車子油耗量","總里程數","車齡"
				,"車子顏色","車子載重限制"};
		
		Object[][] ZtableVales = new String[Read_INPUT_TXT_filter.getD()][8];// 數據
	
		 for(int i=0;i<Read_INPUT_TXT_filter.getD();i++){
			 ZtableVales[i][0]=String.valueOf(Read_INPUT_TXT_filter.getD_ID(i));
			 ZtableVales[i][1]=String.valueOf(Read_INPUT_TXT_filter.getLicense_Plate(i));
			 ZtableVales[i][2]=String.valueOf(Read_INPUT_TXT_filter.getP_NUMBER(i));
			 ZtableVales[i][3]=String.valueOf(Read_INPUT_TXT_filter.getDriverOilConsumption(i));
			 ZtableVales[i][4]=String.valueOf(Read_INPUT_TXT_filter.getVehicle_Displacement(i));
			 ZtableVales[i][5]=String.valueOf(Read_INPUT_TXT_filter.getVehicle_Age(i));
			 ZtableVales[i][6]=String.valueOf(Read_INPUT_TXT_filter.getVehicle_Color(i));
			 ZtableVales[i][7]=String.valueOf(Read_INPUT_TXT_filter.getWeight_Limit(i));
	    	}

		 ZtableModel = new DefaultTableModel(ZtableVales, ZcolumnNames);
		Z = new JTable(ZtableModel);
		JScrollPane ZscrollPane = new JScrollPane(Z); // 支持滾動
		ZscrollPane.setPreferredSize(new Dimension(1250, 100));
		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 5;
		c.gridheight = 1;
		c.gridwidth = 5;
		c.fill = GridBagConstraints.HORIZONTAL;
		gdb.setConstraints(Zid, c);
		contentPane.add(Zid);
		
		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 6;
		c.gridheight = 1;
		c.gridwidth = 5;
		c.fill = GridBagConstraints.HORIZONTAL;
		gdb.setConstraints(ZscrollPane, c);
		contentPane.add(ZscrollPane);
	//	getContentPane().add(YscrollPane, BorderLayout.LINE_END);
		ZscrollPane.setViewportView(Z);
		
	
	pack();
	}

	 
	public static void main( ) throws ParseException {
		// TODO Auto-generated method stub
		show_SQL_input_random_filter_data jTableDefaultTableModelTest = new show_SQL_input_random_filter_data();
		jTableDefaultTableModelTest.setVisible(true);
	}
	
}