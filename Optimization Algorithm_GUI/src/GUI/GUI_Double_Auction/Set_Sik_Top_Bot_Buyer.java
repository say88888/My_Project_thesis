package GUI.GUI_Double_Auction;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Generate_random_data.Generate_random_DA_Buyer;
import Input_Output_txt.Double_Auction.Read_Sik_Parameter;
import Input_Output_txt.Double_Auction.Write_Buyer_Sik_Seller_Parameter;

public class Set_Sik_Top_Bot_Buyer extends Double_Auction implements ActionListener {
	JFrame frm = new JFrame();
	JLabel lab1 = new JLabel();
	JLabel lab2 = new JLabel();
	JButton btn1 = new JButton("SAVE");
	JButton btn2 = new JButton("RUN");
	JTextField txf1 = new JTextField();
	JTextField txf2 = new JTextField();
	Set_Sik_Top_Bot_Buyer() {
		Read_Sik_Parameter.main();
		frm.setSize(400, 300); // 設定視窗的大小為 200*150
		frm.setLocation(150, 150); // 設定視窗位置為(100,50)
		frm.setTitle("Set_Sik_Top_Bot");
		frm.setLayout(null);

		btn1.setBounds(50, 170, 100, 60);
		btn1.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));

		btn2.setBounds(170, 170, 100, 60);
		btn2.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));

		txf1.setBounds(200, 70, 150, 40);
		txf1.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
		txf1.setText(String.valueOf(Read_Sik_Parameter.top()));
		frm.add(txf1);

		txf2.setBounds(200, 120, 150, 40);
		txf2.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
		txf2.setText(String.valueOf(Read_Sik_Parameter.bot()));
		frm.add(txf2);
		
		lab1.setText("Sik上限:");
		lab1.setBackground(Color.white);
		// lab1.setAlignment(Label.CENTER);
		lab1.setForeground(Color.blue);
		lab1.setBounds(50, 30, 150, 120);
		lab1.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
		frm.add(lab1);

		lab2.setText("Sik下限:");
		lab2.setBackground(Color.white);
		// lab2.setAlignment(Label.CENTER);
		lab2.setForeground(Color.blue);
		lab2.setBounds(50, 80, 150, 120);
		lab2.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
		frm.add(lab2);

		
		frm.add(btn1);
		btn1.addActionListener(this);
		frm.add(btn2);
		btn2.addActionListener(this);

		frm.setVisible(true);

	}

	public static void main(  ) {
		// TODO Auto-generated method stub
		new Set_Sik_Top_Bot_Buyer();
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(btn1)) {
			try {
				 Write_Buyer_Sik_Seller_Parameter.saveSikParameter(Integer.parseInt(txf1.getText()),Integer.parseInt(txf2.getText()));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("SAVE OK");
		}
		if (e.getSource().equals(btn2)) {
			try {
				Generate_random_DA_Buyer
						.Generate_Data_of_Double_Auction_Sik();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("Sik RUN OK");
			frm.setVisible(false);
		}
		 
		// 
	}
}