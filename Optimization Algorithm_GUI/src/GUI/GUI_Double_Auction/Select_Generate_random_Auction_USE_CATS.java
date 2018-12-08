package GUI.GUI_Double_Auction;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Input_Output_txt.Double_Auction.Read_Set_intput_CATS_Buyer_Parameter;
import Input_Output_txt.Double_Auction.Write_Set_intput_CATS_Parameter;

public class Select_Generate_random_Auction_USE_CATS extends Double_Auction implements ActionListener {
	JFrame frm = new JFrame();
	JButton btn1 = new JButton("Single_Auction");
	JButton btn2 = new JButton("Double_Auction");
	JButton btn3 = new JButton("Exit");
	
	Select_Generate_random_Auction_USE_CATS() {
		// TODO Auto-generated method stub
		
		frm.setSize(350, 350); // 設定視窗的大小為 200*150
		frm.setLocation(150, 100); // 設定視窗位置為(100,50)
		frm.setTitle("Generate_random_Auction_USE_CATS");
		frm.setLayout(null);
		
		btn1.setBounds(50, 40, 250, 60);
		btn1.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));

		btn2.setBounds(50, 130, 250, 60);
		btn2.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
		

		btn3.setBounds(50, 220, 250, 60);
		btn3.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
		
		frm.add(btn1);
		btn1.addActionListener(this);
		frm.add(btn2);
		btn2.addActionListener(this);
		frm.add(btn3);
		btn3.addActionListener(this);
		frm.setVisible(true);
	}

	public static void main( ) {
		// TODO Auto-generated method stub
		new Select_Generate_random_Auction_USE_CATS();
	}
	
	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(btn1)) {

			Single_Auction_USE_CATS.main();
			
			System.out.println("Single_Auction");
		}
		if (e.getSource().equals(btn2)) {
					
			Double_Auction_USE_CATS.main();
			System.out.println("Double_Auction");
		}
		if (e.getSource().equals(btn3)) {
		
			 frm.setVisible(false);
			System.out.println("Exit");
		}
	}
	
	
}
