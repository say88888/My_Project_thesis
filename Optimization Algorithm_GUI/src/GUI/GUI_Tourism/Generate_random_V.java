package GUI.GUI_Tourism;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;

import Generate_random_data.Generate_random_DA;
import Generate_random_data.Generate_random_Tourism;

public class Generate_random_V extends Tourism
implements ActionListener {
JFrame frm = new JFrame();
JButton btn5=new JButton("Set Parameter");
JButton btn1 = new JButton("Generate_random_Vaik");
JButton btn2 = new JButton("Generate_random_Vhim");
JButton btn3 = new JButton("Generate_random_Vtit");

JButton btn4 = new JButton("EXIT");
Generate_random_V(){
	frm.setSize(500, 600); // 設定視窗的大小為 200*150
	frm.setLocation(150, 50); // 設定視窗位置為(100,50)
	frm.setTitle("Generate_random_Double_Auction");
	frm.setLayout(null);
	
	btn5.setBounds(50, 10, 370, 50);
	btn5.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
	
	btn1.setBounds(50, 70, 370, 50);
	btn1.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));

	btn2.setBounds(50, 130, 370, 50);
	btn2.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
	
	btn3.setBounds(50, 190, 370, 50);
	btn3.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
	
	btn4.setBounds(50, 410, 370, 50);
	btn4.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
	
	frm.add(btn5);
	btn5.addActionListener(this);
	frm.add(btn1);
	btn1.addActionListener(this);
	frm.add(btn2);
	btn2.addActionListener(this);
	frm.add(btn3);
	btn3.addActionListener(this);

	frm.add(btn4);
	btn4.addActionListener(this);
	frm.setVisible(true);
}
	public static void main( ) {
		// TODO Auto-generated method stub
		new Generate_random_V();
	}
	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(btn5)) {
			Generate_random_V_Parameter.main();
			System.out.println("Set Parameter OK");
		}
		if (e.getSource().equals(btn1)) {
			try {
				Generate_random_Tourism.Generate_Data_of_Tourism_Vaik();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("Vaik Data RUN OK");
		}
		if (e.getSource().equals(btn2)) {
			try {
				Generate_random_Tourism.Generate_Data_of_Tourism_Vhim();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("Vhim Data RUN OK");
		}
		if (e.getSource().equals(btn3)) {
			try {
				Generate_random_Tourism.Generate_Data_of_Tourism_Vtit();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("Vtit Data RUN OK");
		}
		
		if (e.getSource().equals(btn4)) {
			frm.setVisible(false);
		}
		
	}
}