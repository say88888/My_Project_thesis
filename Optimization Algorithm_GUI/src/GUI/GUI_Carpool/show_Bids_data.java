package GUI.GUI_Carpool;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.text.ParseException;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import READ_TXT.Read_INPUT_TXT_filter;
import Result_to_out_Carpool.Read_Carpool_file;

public class show_Bids_data extends JFrame {

	private DefaultTableModel X1tableModel,Y1tableModel,Z1tableModel; // 表格模型對象
	private JTable X1,Y1,Z1;
	 private JLabel Xid1=new JLabel("觀看司機投標資訊");
	 private JLabel Yid1=new JLabel("觀看乘客投標資訊");
	 private JLabel Zid1=new JLabel("投標參數資訊");
	 Container contentPane;
	  Container mainFrameCP = null;
	
	  Object[][] X1tableVales = null;
	  Object[][] Y1tableVales = null;
	public show_Bids_data() throws ParseException {
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
		//以下為建立觀看投標資訊------------------------------------------------------------------------------------------------- 175~257 行-------------------------------
		JComboBox box=new JComboBox(); 
		box.setBounds(120,80,150,30); 
		String str[]=new String[Read_INPUT_TXT_filter.getD()+1] ;
		str[0]="選擇觀看第幾位";
		for(int i=1;i<Read_INPUT_TXT_filter.getD()+1;i++){
				str[i]="第 "+i+" 位" ; 
		}
		for(int i=0 ;i<str.length ;i++){box.addItem(str[i]);} 
		
		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 1;
		c.gridheight = 1;
		c.gridwidth = 5;
		c.fill = GridBagConstraints.HORIZONTAL;
		gdb.setConstraints(Xid1, c);
		contentPane.add(Xid1);
		
		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 2;
		c.gridheight = 1;
		c.gridwidth = 5;
		c.fill = GridBagConstraints.HORIZONTAL;
		gdb.setConstraints(box, c);
		contentPane.add(box); 
		
		 String[] X1columnNames={"D_ID","第幾個標","qdjk","Cdj","Odj","adj","Wqdjk","ldj"};
		
		box.addItemListener(new ItemListener() {
	        public void itemStateChanged(ItemEvent e) {
	         int index = box.getSelectedIndex();
	         if(e.getStateChange()==ItemEvent.SELECTED){   //未被選擇變成已選擇
	         if (index != 0) { // ==0表示选中的事第一个
	         //  String content = box.getSelectedItem().toString();
	            
	  	          X1tableVales= new String[Read_Carpool_file.getJd(index-1)][8];// 數據
	  	          X1tableModel.setNumRows(0);  //清除所有欄位的值
	  	  
	  	        String []rowValues=new String[8]; 
	  	          
	  	           for(int i=0;i<Read_Carpool_file.getJd(index-1);i++)
	  	        	 {
	  	        	 rowValues[0]= String.valueOf(Read_INPUT_TXT_filter.getD_ID(index-1));
	  	        	 rowValues[1]=String.valueOf(i+1);
	  	        	 String qdjk="";      	 
	  	        	 for(int j=0;j<Read_Carpool_file.getK();j++)
	  	        		 qdjk+=String.valueOf(Read_Carpool_file.getqdjk(index-1, i,j))+"  ";    	 
	  	        	 rowValues[2]= qdjk;     	
	  	        	 rowValues[3]=String.valueOf(Read_Carpool_file.getCdj(index-1,i));
	  	        	rowValues[4]=String.valueOf(Read_Carpool_file.getOdj(index-1,i));
	  	        	rowValues[5]=String.valueOf(Read_Carpool_file.getadj(index-1,i));
	  	        	 String Wqdjk="";
	  	        	 for(int j=0;j<Read_Carpool_file.getK();j++)
	  	        		Wqdjk+=String.valueOf(Read_Carpool_file.getWqdjk(index-1, i,j))+"  ";
	  	        	rowValues[6]=Wqdjk;
	  	        	rowValues[7]=String.valueOf(Read_Carpool_file.getldj(index-1,i));
	  	        	 
	  	        	X1tableModel.addRow(rowValues);
	  	        	 }
	         }
	      }
	         if(e.getStateChange()==ItemEvent.DESELECTED){
	             //已選擇變成未被選擇
	        	 X1tableModel.setNumRows(0);
	             } 
	       }
	     });
		
		X1tableModel = new DefaultTableModel(X1tableVales, X1columnNames);
	  	X1 = new JTable(X1tableModel);
  		JScrollPane X1scrollPane = new JScrollPane(X1); // 支持滾動
  		X1scrollPane.setPreferredSize(new Dimension(1250, 100));
  		
  		c = new GridBagConstraints();
  		c.gridx = 0;
  		c.gridy = 3;
  		c.gridheight = 1;
  		c.gridwidth = 5;
  		c.fill = GridBagConstraints.HORIZONTAL;
  		gdb.setConstraints(X1scrollPane, c);
  		contentPane.add(X1scrollPane);

	//----------------------------------------------------------------以下為觀看乘客投標資訊---------------
	JComboBox box1=new JComboBox(); 
	box1.setBounds(120,80,150,30); 
	String str1[]=new String[Read_INPUT_TXT_filter.getP()+1] ;
	str1[0]="選擇觀看第幾位";
	for(int i=1;i<Read_INPUT_TXT_filter.getP()+1;i++){
			str1[i]="第 "+i+" 位" ; 
	}
	for(int i=0 ;i<str1.length ;i++){box1.addItem(str1[i]);} 
	
	c = new GridBagConstraints();
	c.gridx = 0;
	c.gridy = 4;
	c.gridheight = 1;
	c.gridwidth = 5;
	c.fill = GridBagConstraints.HORIZONTAL;
	gdb.setConstraints(Yid1, c);
	contentPane.add(Yid1);
	
	c = new GridBagConstraints();
	c.gridx = 0;
	c.gridy = 5;
	c.gridheight = 1;
	c.gridwidth = 5;
	c.fill = GridBagConstraints.HORIZONTAL;
	gdb.setConstraints(box1, c);
	contentPane.add(box1); 
	
	 String[] Y1columnNames={"P_ID","第幾個標","Sphk","fph"};
	
	box1.addItemListener(new ItemListener() {
        public void itemStateChanged(ItemEvent e) {
         int index = box1.getSelectedIndex();
         if(e.getStateChange()==ItemEvent.SELECTED){   //未被選擇變成已選擇
         if (index != 0) { // ==0表示选中的事第一个
         //  String content = box.getSelectedItem().toString();
            
  	          Y1tableVales= new String[Read_Carpool_file.getHp(index-1)][4];// 數據
  	          Y1tableModel.setNumRows(0);
  	         
  	        String []rowValues=new String[4]; 
  	        
  	           for(int i=0;i<Read_Carpool_file.getHp(index-1);i++)
  	        	 { 
  	        	 rowValues[0]= String.valueOf(Read_INPUT_TXT_filter.getP_ID(index-1));
  	        	 rowValues[1]=String.valueOf(i+1);
  	        	 String Sphk="";  	        	 for(int j=0;j<Read_Carpool_file.getK();j++)
  	        		Sphk+=String.valueOf(Read_Carpool_file.getSphk(index-1, i,j))+"  ";
  	        	 rowValues[2]= Sphk;     	
  	        	 rowValues[3]=String.valueOf(Read_Carpool_file.getfph(index-1,i));
  	      	
  	        	Y1tableModel.addRow(rowValues);
  	        	 }
         }
      }
         if(e.getStateChange()==ItemEvent.DESELECTED){
             //已選擇變成未被選擇
        	 Y1tableModel.setNumRows(0);
             } 
       }
     });
	
	Y1tableModel = new DefaultTableModel(Y1tableVales, Y1columnNames);
  	Y1 = new JTable(Y1tableModel);
		JScrollPane Y1scrollPane = new JScrollPane(Y1); // 支持滾動
		Y1scrollPane.setPreferredSize(new Dimension(1250, 100));
		
		c = new GridBagConstraints();
c.gridx = 0;
c.gridy = 6;
c.gridheight = 1;
c.gridwidth = 5;
c.fill = GridBagConstraints.HORIZONTAL;
gdb.setConstraints(Y1scrollPane, c);
contentPane.add(Y1scrollPane);


	
String[] ZcolumnNames={"乘客數量(P)","個別投的標(Hp)","司機數量(D)","個別投的標(Jd)","座位數(K)","Tdm"
		,"Tpm"};

Object[][] ZtableVales = new String[1][7];// 數據

	 ZtableVales[0][0]=String.valueOf(Read_Carpool_file.getP());
	 String Hp="";
	 for(int j=0;j<Read_Carpool_file.getP();j++)
		 Hp+=String.valueOf(Read_Carpool_file.getHp(j))+" ";
	 ZtableVales[0][1]=Hp;
	 ZtableVales[0][2]=String.valueOf(Read_Carpool_file.getD());
	 String Jd="";
	 for(int j=0;j<Read_Carpool_file.getD();j++)
		 Jd+=String.valueOf(Read_Carpool_file.getJd(j))+" ";
	 ZtableVales[0][3]=Jd;
	 ZtableVales[0][4]=String.valueOf(Read_Carpool_file.getK());
	 ZtableVales[0][5]=String.valueOf(Read_Carpool_file.getTdm());
	 ZtableVales[0][6]=String.valueOf(Read_Carpool_file.getTpm());
	

Z1tableModel = new DefaultTableModel(ZtableVales, ZcolumnNames);
Z1 = new JTable(Z1tableModel);
JScrollPane ZscrollPane = new JScrollPane(Z1); // 支持滾動
ZscrollPane.setPreferredSize(new Dimension(1250, 100));

c = new GridBagConstraints();
c.gridx = 0;
c.gridy = 7;
c.gridheight = 1;
c.gridwidth = 5;
c.fill = GridBagConstraints.HORIZONTAL;
gdb.setConstraints(Zid1, c);
contentPane.add(Zid1);

c = new GridBagConstraints();
c.gridx = 0;
c.gridy = 8;
c.gridheight = 1;
c.gridwidth = 5;
c.fill = GridBagConstraints.HORIZONTAL;
gdb.setConstraints(ZscrollPane, c);
contentPane.add(ZscrollPane);
//getContentPane().add(XscrollPane, BorderLayout.LINE_START);
ZscrollPane.setViewportView(Z1);



	pack();
	}

	public static void main( ) throws ParseException {
		// TODO Auto-generated method stub
		show_Bids_data jTableDefaultTableModelTest = new show_Bids_data();
		jTableDefaultTableModelTest.setVisible(true);
	}
	
}
