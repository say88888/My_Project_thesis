package GUI.GUI_Consolidation_word;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class Set_Parameter  implements ActionListener {
	JFrame frm = new JFrame();
	JTextField txf1 = new JTextField();
	JLabel lab1 = new JLabel();
	JLabel lab2 = new JLabel();
	JLabel lab3 = new JLabel();
	JButton btn1 = new JButton("SAVE");
	JButton btn2 = new JButton("Exit");
	
	JComboBox box1=new JComboBox();
	JComboBox box2=new JComboBox();
	
	 private static String Particles;
	 private static String Column;
	 
	 private static String fontSize;
	Set_Parameter() {
		
		frm.setSize(600, 550); // 設定視窗的大小為 200*150
		frm.setLocation(150, 100); // 設定視窗位置為(100,50)
		frm.setTitle("Set_Single_Auction_USE_CATS");
		frm.setLayout(null);
		
		lab1.setText(" 產生的 table 類別 ");
		lab1.setBackground(Color.white);
		// lab1.setAlignment(Label.CENTER);
		lab1.setForeground(Color.blue);
		lab1.setBounds(50, 30, 200, 40);
		lab1.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
		frm.add(lab1);
		
	  	String[] jiguan={"Cost Savings","ShchmeI","W-1","W-2","W-3","W-4"
				,"比率","司機全部座位", "乘客成功人數"};
			
		box1=new JComboBox(jiguan);
		box1.setBounds(250, 30, 150, 40);
		box1.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
		frm.add(box1);
	  	 
		lab2.setText("Particles");
		lab2.setBackground(Color.white);
		// lab1.setAlignment(Label.CENTER);
		lab2.setForeground(Color.blue);
		lab2.setBounds(50, 130, 200, 40);
		lab2.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
		frm.add(lab2);
		
		txf1.setBounds(250, 130, 150, 40);
		txf1.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
		txf1.setText("");
		frm.add(txf1);
		
		lab3.setText(" 字型大小 ");
		lab3.setBackground(Color.white);
		// lab1.setAlignment(Label.CENTER);
		lab3.setForeground(Color.blue);
		lab3.setBounds(50, 230, 200, 40);
		lab3.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
		frm.add(lab3);
		
	 	String[] jiguan1={"8","9","10","11","12","13","14"};
			
		box2=new JComboBox(jiguan1);
		box2.setBounds(250, 230, 150, 40);
		box2.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
		frm.add(box2);
		
		btn1.setBounds(50, 420, 100, 40);
		btn1.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));

		btn2.setBounds(170, 420, 100, 40);
		btn2.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
		
		
		frm.add(btn1);
		btn1.addActionListener(this);
		frm.add(btn2);
		btn2.addActionListener(this);

		frm.setVisible(true);

	}

	public static void main( ) {
		// TODO Auto-generated method stub
		new Set_Parameter();
	}

    public static String  Column(){
  		return Column;
  	}
  public static String  Particles(){
	  		return Particles;
	 }
  public static String  fontSize(){
		return fontSize;
}
	
	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(btn1)) {
			  String value = (String) box1.getSelectedItem();
			  Column=value;
			  
			  Particles=txf1.getText();
			  
			  value = (String) box2.getSelectedItem();
			  fontSize=value;
			  
			System.out.println("SAVE OK");
		}
		if (e.getSource().equals(btn2)) {
		
			System.out.println("Exit");
			 frm.setVisible(false);
		}
		 
		
	}
}
