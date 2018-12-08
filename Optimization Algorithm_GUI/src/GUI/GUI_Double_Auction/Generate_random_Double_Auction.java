package GUI.GUI_Double_Auction;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;

import Generate_random_data.Generate_random_DA;

public class Generate_random_Double_Auction extends Double_Auction
implements ActionListener {
JFrame frm = new JFrame();
JButton btn5=new JButton("Set Parameter");
JButton btn1 = new JButton("Generate_random_Seller");
JButton btn2 = new JButton("Generate_random_Buyer");
JButton btn3 = new JButton("Generate_random_Sik");
JButton btn4 = new JButton("EXIT");
Generate_random_Double_Auction(){
	frm.setSize(500, 600); // 設定視窗的大小為 200*150
	frm.setLocation(150, 50); // 設定視窗位置為(100,50)
	frm.setTitle("Generate_random_Double_Auction");
	frm.setLayout(null);
	
	btn5.setBounds(50, 10, 370, 60);
	btn5.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
	
	btn1.setBounds(50, 110, 370, 60);
	btn1.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));

	btn2.setBounds(50, 210, 370, 60);
	btn2.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
	
	btn3.setBounds(50, 310, 370, 60);
	btn3.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
	
	btn4.setBounds(50, 410, 370, 60);
	btn4.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
	
	frm.add(btn5);
	btn5.addActionListener(this);
	frm.add(btn1);
	btn1.addActionListener(this);
	frm.add(btn2);
	btn2.addActionListener(this);
	frm.add(btn3);
	btn3.addActionListener(this);
	frm.setVisible(true);
	frm.add(btn4);
	btn4.addActionListener(this);
	frm.setVisible(true);
}
	public static void main( ) {
		// TODO Auto-generated method stub
		new Generate_random_Double_Auction();
	}
	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(btn5)) {
			  Set_Double_action.main();
			System.out.println("Set Parameter OK");
		}
		if (e.getSource().equals(btn1)) {
			try {
				Generate_random_DA.Generate_Data_of_Double_Auction_Seller();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("Seller Data RUN OK");
		}
		if (e.getSource().equals(btn2)) {
			Set_Buyer_Bot_Price.main();
		}
		if (e.getSource().equals(btn3)) {
			Set_Sik_Top_Bot.main();
		}
		if (e.getSource().equals(btn4)) {
			frm.setVisible(false);
		}
		
	}
}