package GUI.GUI_Generate_Report;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Input_Output_txt.Carpool.Read_report;

 
public class show_report extends JFrame{

    private DefaultTableModel tableModel;   //表格模型對象
    private JTable table;
    private JTextField latTextField;
    private JTextField lngTextField;
    private JTextField locationTextField;
    JFileChooser jfc = new JFileChooser();// 文件選擇器
    
    public show_report()
    {
        super();
        setTitle("表格");
        setBounds(100,100,1200,800);
      //  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        String[] columnNames ={"Case","drivers","passengers","distance(km) / Cost without carpool","distance(km) / Cost with carpool"
        		,"[a+b]/c","[a/d]","Overall the number of carpool","Overall number of seats","Overall usage"};  //列名
       
        	try {
				Read_report.main();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
	
        
        Object [][]tableVales= new String[Read_report.N()][10];//數據
        
        
        for(int i=0;i<tableVales.length;i++){
        	tableVales[i][0]=Read_report.Case(i);
        	tableVales[i][1]=Read_report.drivers(i);
        	tableVales[i][2]=Read_report.drivers(i);
        	tableVales[i][3]=Read_report.route_and_cost(i);
        	tableVales[i][4]=Read_report.route_and_cost_B(i);
        	tableVales[i][5]=Read_report.abc(i);
        	tableVales[i][6]=Read_report.ad(i);
        	tableVales[i][7]=Read_report.math(i);
        	tableVales[i][8]=Read_report.seat(i);
        	tableVales[i][9]=Read_report.use(i);

    	}
        
        
        tableModel = new DefaultTableModel(tableVales,columnNames);
        table = new JTable(tableModel);
        
        //置中
        DefaultTableCellRenderer render = new DefaultTableCellRenderer();
        render.setHorizontalAlignment(SwingConstants.CENTER);
        for(int i=0;i<table.getColumnCount();i++)
        table.getColumn(table.getColumnName(i)).setCellRenderer(render);
        
        JScrollPane scrollPane = new JScrollPane(table);   //支持滾動
        getContentPane().add(scrollPane,BorderLayout.CENTER);
  
        //排序:
        //table.setRowSorter(new TableRowSorter(tableModel));
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  //單選
        table.addMouseListener(new MouseAdapter(){    //鼠標事件
            public void mouseClicked(MouseEvent e){
                int selectedRow = table.getSelectedRow(); //獲得選中行索引
                Object oa = tableModel.getValueAt(selectedRow, 0);
                Object ob = tableModel.getValueAt(selectedRow, 1);
                Object oc=tableModel.getValueAt(selectedRow, 2);
            }
        });
        
        table.setFont(new Font("Menu.font", Font.PLAIN, 16));
        table.setRowHeight(50);
        
    }
   
    public static void main() {
        // TODO Auto-generated method stub
    	show_report jTableDefaultTableModelTest = new show_report();
        jTableDefaultTableModelTest.setVisible(true);
    }

}