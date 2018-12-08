package GUI.GUI_Carpool;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Input_Output_txt.Carpool.Read_Eqution_Value;


public class show_Eqution_Value extends JFrame {
	
	private DefaultTableModel tableModel;
	private JTable X;
	 private JLabel Xid=new JLabel("Driver_initial_itinerary");
	  
	public show_Eqution_Value() {
	super();
	
	Read_Eqution_Value.main();
	  	
		setTitle("表格");
		setBounds(50, 100, 700, 600);
	
		String[] columnNames = {"Eqution", "Value" }; // 列名
		Object[][] tableVales = new String[Read_Eqution_Value.n()][3];// 數據
		
		 for(int i=0;i<Read_Eqution_Value.n();i++){
			 tableVales[i][0]=Read_Eqution_Value.getEqution(i);
			 tableVales[i][1]=String.valueOf(Read_Eqution_Value.getValue(i));
	    	}
		 
			tableModel = new DefaultTableModel(tableVales, columnNames);
			X = new JTable(tableModel);
			JScrollPane XscrollPane = new JScrollPane(X); // 支持滾動
			XscrollPane.setPreferredSize(new Dimension(1250, 100));
			       
	        //置中
	        DefaultTableCellRenderer render = new DefaultTableCellRenderer();
	        render.setHorizontalAlignment(SwingConstants.CENTER);
	        for(int i=0;i<X.getColumnCount();i++)
	        X.getColumn(X.getColumnName(i)).setCellRenderer(render);
	        
	        JScrollPane scrollPane = new JScrollPane(X);   //支持滾動
	        getContentPane().add(scrollPane,BorderLayout.CENTER);

	}
	public static void main( ) {
		// TODO Auto-generated method stub
		show_Eqution_Value jTableDefaultTableModelTest = new show_Eqution_Value();
		jTableDefaultTableModelTest.setVisible(true);
	}
	
}
