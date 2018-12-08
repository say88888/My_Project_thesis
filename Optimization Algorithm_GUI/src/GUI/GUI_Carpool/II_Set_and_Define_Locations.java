package GUI.GUI_Carpool;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import Generate_random_data.Read_Generate_random;
import Input_Output_txt.Carpool.Read_example_Location;
import Input_Output_txt.Carpool.Write_Location;


 
public class II_Set_and_Define_Locations extends Carpool{

    private DefaultTableModel tableModel;   //表格模型對象
    private JTable table;
    private JTextField latTextField;
    private JTextField lngTextField;
    private JTextField locationTextField;
    JFileChooser jfc = new JFileChooser();// 文件選擇器
    
    public II_Set_and_Define_Locations()
    {
        super();
        setTitle("表格");
        setBounds(100,100,900,600);
      //  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        String[] columnNames ={"緯度","經度","地址"};  //列名
        try {
			Read_Generate_random.main();
		} catch (ParseException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
        Object [][]tableVales= new String[Read_Generate_random.N()][3];//數據
        for(int i=0;i<tableVales.length;i++){
        	tableVales[i][0]=String.valueOf(Read_Generate_random.lat(i));
        	tableVales[i][1]=String.valueOf(Read_Generate_random.lng(i));
        	tableVales[i][2]=Read_Generate_random.location(i);
    	}
        
        tableModel = new DefaultTableModel(tableVales,columnNames);
        table = new JTable(tableModel);
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
                latTextField.setText(oa.toString());  
                lngTextField.setText(ob.toString());
                locationTextField.setText(oc.toString());
            }
        });
        
        scrollPane.setViewportView(table);
        final JPanel panel = new JPanel();
        getContentPane().add(panel,BorderLayout.SOUTH);
        panel.add(new JLabel("緯度: "));
        latTextField = new JTextField("",10);
        panel.add(latTextField);
        panel.add(new JLabel("經度: "));
        lngTextField = new JTextField("",10);
        panel.add(lngTextField);
        panel.add(new JLabel("地址: "));
        locationTextField = new JTextField("",10);
        panel.add(locationTextField);
        final JButton addButton = new JButton("添加");   //添加按鈕
        addButton.addActionListener(new ActionListener(){//添加事件
            public void actionPerformed(ActionEvent e){
                String []rowValues = {latTextField.getText(),lngTextField.getText(),locationTextField.getText()};
                tableModel.addRow(rowValues);  //添加一行
                try {
					Write_Location.write_Location(tableModel);//寫入TXT
				} catch (IOException e1) {
					e1.printStackTrace();
				}
						//(tableModel.getValueAt(i,j))	
            }
        });
        panel.add(addButton);  
        
        final JButton updateButton = new JButton("修改");   //修改按鈕
        updateButton.addActionListener(new ActionListener(){//添加事件
            public void actionPerformed(ActionEvent e){
                int selectedRow = table.getSelectedRow();//獲得選中行的索引
                if(selectedRow!= -1)   //是否存在選中行
                {
                    //修改指定的值：
                    tableModel.setValueAt(latTextField.getText(), selectedRow, 0);
                    tableModel.setValueAt(lngTextField.getText(), selectedRow, 1);
                    tableModel.setValueAt(locationTextField.getText(),selectedRow,2);
                    try {
    					Write_Location.write_Location(tableModel);//寫入TXT
    				} catch (IOException e1) {
    					e1.printStackTrace();
    				}
                }
            }
        });
        panel.add(updateButton);
        
        final JButton delButton = new JButton("删除");
        delButton.addActionListener(new ActionListener(){//添加事件
            public void actionPerformed(ActionEvent e){
                int selectedRow = table.getSelectedRow();//獲得選中行的索引
                if(selectedRow!=-1)  //存在選中行
                {
                    tableModel.removeRow(selectedRow);  //刪除行
                    try {
    					Write_Location.write_Location(tableModel);//寫入TXT
    				} catch (IOException e1) {
    					e1.printStackTrace();
    				}
                }
            }
        });
        panel.add(delButton);
        final JButton clearButton = new JButton("清除");
        clearButton.addActionListener(new ActionListener(){//添加事件
            public void actionPerformed(ActionEvent e){
              tableModel.setNumRows(0);
              try {
					Write_Location.write_Location(tableModel);//寫入TXT
				} catch (IOException e1) {
					e1.printStackTrace();
				}
            }
        });
        panel.add(clearButton);
        jfc.setCurrentDirectory(new File(System.getProperty("user.dir"))); //取得當前專案路徑
        final JButton exampleButton = new JButton("範例");
        exampleButton.addActionListener(new ActionListener(){//添加事件
            public void actionPerformed(ActionEvent e){
             // tableModel.setNumRows(0);
            	  jfc.setFileSelectionMode(0);// 設定只能選擇到資料夾 
  	            int state = jfc.showOpenDialog(null);  
  	            if (state == 1) {  
  	                return;  
  	            } else {  
  	                File f = jfc.getSelectedFile();// f為選擇到的目錄
  	                System.out.println(f.getAbsolutePath());   
  	                try {
						Read_example_Location.main(f.getAbsolutePath());
					} catch (ParseException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
  	            }  
  	          tableModel.setNumRows(0);
  	            for(int i=0;i<Read_example_Location.N();i++){
  	          String []rowValues = {String.valueOf(Read_example_Location.lat(i)),String.valueOf(Read_example_Location.lng(i)),Read_example_Location.location(i)};
              tableModel.addRow(rowValues);  //添加一行
              }
  	      try {
				Write_Location.write_Location(tableModel);//寫入TXT
			} catch (IOException e1) {
				e1.printStackTrace();
			}
            }
        });
        panel.add(exampleButton);
    }
   
    public static void main() {
        // TODO Auto-generated method stub
    	II_Set_and_Define_Locations jTableDefaultTableModelTest = new II_Set_and_Define_Locations();
        jTableDefaultTableModelTest.setVisible(true);
    }

}