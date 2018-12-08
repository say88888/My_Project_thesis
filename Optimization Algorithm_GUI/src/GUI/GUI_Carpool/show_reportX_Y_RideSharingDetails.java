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

import Input_Output_txt.Carpool.Read_reportX_Y_RideSharingDetails;
import READ_TXT.Read_INPUT_TXT_filter;

public class show_reportX_Y_RideSharingDetails extends JFrame {

	private DefaultTableModel RideSharingDetailstableModel,XtableModel,YtableModel,passenger_carpooltableModel; // 表格模型對象
	private JTable RideSharingDetails,X,Y,passenger_carpool_table;
	 private JLabel Rid=new JLabel("RideSharingDetails");
	 private JLabel Xid=new JLabel("Report_X");
	 private JLabel Yid=new JLabel("Report_Y");
	 private JLabel passenger_carpool=new JLabel("乘客共乘");
	 Container contentPane;
	 Container mainFrameCP = null;
	  
	public show_reportX_Y_RideSharingDetails() throws ParseException {
		super();
		
		setTitle("表格");
		setBounds(50, 100, 1000, 700);
		contentPane = getContentPane();
		GridBagLayout gdb = new GridBagLayout();
		GridBagConstraints c;
		contentPane.setLayout(gdb);
		
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		String[] columnNames = { " ", "B(共乘前距離)", "r(共乘後距離)", "(r-B)/B","投標金額"
				, "Reward", "Reward/投標金額","Reward2", "Reward/投標金額2","Reward3"
				, "Reward/投標金額3","Reward4", "Reward/投標金額4", "distance", "time","共乘前後距離比率" }; // 列名
		
		try {
			Read_reportX_Y_RideSharingDetails.main();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			Read_INPUT_TXT_filter.loadData();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Object[][] tableVales = new String[Read_reportX_Y_RideSharingDetails.n1()+Read_reportX_Y_RideSharingDetails.n()][16];// 數據
		int n=0;
		 for(int i=0;i<Read_reportX_Y_RideSharingDetails.n();i++){
			 
			 for(int j=0;j<Read_reportX_Y_RideSharingDetails.k1().get(i);j++){
	        	tableVales[n][0]=String.valueOf(Read_reportX_Y_RideSharingDetails.onoff(i,j));
	        	tableVales[n][1]=String.valueOf(Read_reportX_Y_RideSharingDetails.B(i,j));
	        	tableVales[n][2]=String.valueOf(Read_reportX_Y_RideSharingDetails.r(i,j));
	        	tableVales[n][3]=String.valueOf(Read_reportX_Y_RideSharingDetails.Br(i,j));
	        	tableVales[n][4]=String.valueOf(Read_reportX_Y_RideSharingDetails.Bids(i,j));
	        	
	        	tableVales[n][5]=String.valueOf(Read_reportX_Y_RideSharingDetails.reward(i,j));
	        	tableVales[n][6]=String.valueOf(Read_reportX_Y_RideSharingDetails.reback(i,j));
	        	tableVales[n][7]=String.valueOf(Read_reportX_Y_RideSharingDetails.reward2(i,j));
	        	tableVales[n][8]=String.valueOf(Read_reportX_Y_RideSharingDetails.reback2(i,j));
	        	tableVales[n][9]=String.valueOf(Read_reportX_Y_RideSharingDetails.reward3(i,j));
	        	tableVales[n][10]=String.valueOf(Read_reportX_Y_RideSharingDetails.reback3(i,j));
	        	tableVales[n][11]=String.valueOf(Read_reportX_Y_RideSharingDetails.reward4(i,j));
	        	tableVales[n][12]=String.valueOf(Read_reportX_Y_RideSharingDetails.reback4(i,j));
	        	
	        	tableVales[n][13]=String.valueOf(Read_reportX_Y_RideSharingDetails.distance(i,j));
	        	tableVales[n][14]=String.valueOf(Read_reportX_Y_RideSharingDetails.time(i,j));
	        	tableVales[n][15]=String.valueOf(Read_reportX_Y_RideSharingDetails.distance_Ratio(i,j));
	        	n++;
			 } 
	        	n++;
	    	}

		 RideSharingDetailstableModel = new DefaultTableModel(tableVales, columnNames);
		RideSharingDetails = new JTable(RideSharingDetailstableModel);	
		 
		  
		JScrollPane scrollPane = new JScrollPane(RideSharingDetails); // 支持滾動
		scrollPane.setPreferredSize(new Dimension(1200, 350));
		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 3;
		c.gridheight = 1;
		c.gridwidth = 6;
		c.fill = GridBagConstraints.HORIZONTAL;
		gdb.setConstraints(Rid, c);
		contentPane.add(Rid);
		
		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 4;
		c.gridheight = 1;
		c.gridwidth = 6;
		c.fill = GridBagConstraints.HORIZONTAL;
		gdb.setConstraints(scrollPane, c);
		contentPane.add(scrollPane);
		
	//	getContentPane().add(scrollPane, BorderLayout.PAGE_END);
		scrollPane.setViewportView(RideSharingDetails);
		
		String[] XcolumnNames={"Xd","Xj","X"};
		Object[][] XtableVales = new String[Read_reportX_Y_RideSharingDetails.X_length()][3];// 數據
	
		 for(int i=0;i<XtableVales.length;i++){
			 XtableVales[i][0]=String.valueOf(Read_reportX_Y_RideSharingDetails.Xd(i));
			 XtableVales[i][1]=String.valueOf(Read_reportX_Y_RideSharingDetails.Xj(i));
			 XtableVales[i][2]=String.valueOf(Read_reportX_Y_RideSharingDetails.X(i));
	    	}

		 XtableModel = new DefaultTableModel(XtableVales, XcolumnNames);
		X = new JTable(XtableModel);
		JScrollPane XscrollPane = new JScrollPane(X); // 支持滾動
		XscrollPane.setPreferredSize(new Dimension(300, 250));
		
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
		c.gridwidth = 2;
		c.fill = GridBagConstraints.BOTH;
		gdb.setConstraints(XscrollPane, c);
		contentPane.add(XscrollPane);
		//getContentPane().add(XscrollPane, BorderLayout.LINE_START);
		XscrollPane.setViewportView(X);
		
		String[] YcolumnNames={"Yp","Yh","Y"};
		Object[][] YtableVales = new String[Read_reportX_Y_RideSharingDetails.Y_length()][3];// 數據
	
		 for(int i=0;i<YtableVales.length;i++){
			 YtableVales[i][0]=String.valueOf(Read_reportX_Y_RideSharingDetails.Yp(i));
			 YtableVales[i][1]=String.valueOf(Read_reportX_Y_RideSharingDetails.Yh(i));
			 YtableVales[i][2]=String.valueOf(Read_reportX_Y_RideSharingDetails.Y(i));
	    	}

		 YtableModel = new DefaultTableModel(YtableVales, YcolumnNames);
		Y = new JTable(YtableModel);
		JScrollPane YscrollPane = new JScrollPane(Y); // 支持滾動
		YscrollPane.setPreferredSize(new Dimension(300, 250));
		c = new GridBagConstraints();
		c.gridx = 2;
		c.gridy = 0;
		c.gridheight = 1;
		c.gridwidth = 5;
		c.fill = GridBagConstraints.HORIZONTAL;
		gdb.setConstraints(Yid, c);
		contentPane.add(Yid);
		
		c = new GridBagConstraints();
		c.gridx = 2;
		c.gridy = 1;
		c.gridheight = 1;
		c.gridwidth = 2;
		c.fill = GridBagConstraints.BOTH;
		gdb.setConstraints(YscrollPane, c);
		contentPane.add(YscrollPane);
	//	getContentPane().add(YscrollPane, BorderLayout.LINE_END);
		YscrollPane.setViewportView(Y);
		
		String[] carpool={"共乘乘客人數","整體乘客人數","成功共乘率"};
		Object[][] carpoolVales = new String[1][3];// 數據
		double totalcarpoolnum=Read_reportX_Y_RideSharingDetails.Y_length();
		double  carpoolnum=0;
		for(int i=0;i<Read_reportX_Y_RideSharingDetails.Y_length();i++)
			{
			if(Read_reportX_Y_RideSharingDetails.Y(i)>0){
				 int Yp = Read_reportX_Y_RideSharingDetails.Yp(i);
				 carpoolnum+=Read_INPUT_TXT_filter.getseat(Yp-1);
			}
			}
		double carpoolr =carpoolnum/totalcarpoolnum;
		carpoolVales[0][0]=String.valueOf((int)(carpoolnum));
		carpoolVales[0][1]=String.valueOf((int)totalcarpoolnum);
		carpoolVales[0][2]=String.valueOf(carpoolr);
	    	

		passenger_carpooltableModel = new DefaultTableModel(carpoolVales, carpool);
		passenger_carpool_table = new JTable(passenger_carpooltableModel);
		JScrollPane passenger_carpoolscrollPane = new JScrollPane(passenger_carpool_table); // 支持滾動
		passenger_carpoolscrollPane.setPreferredSize(new Dimension(250, 250));
		c = new GridBagConstraints();
		c.gridx = 4;
		c.gridy = 0;
		c.gridheight = 1;
		c.gridwidth = 5;
		c.fill = GridBagConstraints.HORIZONTAL;
		gdb.setConstraints(passenger_carpool, c);
		contentPane.add(passenger_carpool);
		
		c = new GridBagConstraints();
		c.gridx = 4;
		c.gridy = 1;
		c.gridheight = 1;
		c.gridwidth = 2;
		c.fill = GridBagConstraints.BOTH;
		gdb.setConstraints(passenger_carpoolscrollPane, c);
		contentPane.add(passenger_carpoolscrollPane);
		passenger_carpoolscrollPane.setViewportView(passenger_carpool_table);
		
		
		pack();
		

 

	}

	 
	public static void main( ) throws ParseException {
		// TODO Auto-generated method stub
		show_reportX_Y_RideSharingDetails jTableDefaultTableModelTest = new show_reportX_Y_RideSharingDetails();
		jTableDefaultTableModelTest.setVisible(true);
	}
	
}