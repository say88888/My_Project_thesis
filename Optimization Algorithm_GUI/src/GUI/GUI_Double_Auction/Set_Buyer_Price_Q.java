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

import Generate_random_data.Generate_random_DA_Seller;
import Input_Output_txt.Double_Auction.Read_Seller_Parameter_Buyer;
import Input_Output_txt.Double_Auction.Write_Buyer_Sik_Seller_Parameter;

public class Set_Buyer_Price_Q extends Double_Auction implements ActionListener {
	JFrame frm = new JFrame();
	JLabel lab1 = new JLabel();
	JLabel lab2 = new JLabel();
	JLabel lab3 = new JLabel();
	JLabel lab4 = new JLabel();
	JLabel lab5 = new JLabel();
	JLabel lab6 = new JLabel();
	JButton btn1 = new JButton("SAVE");
	JButton btn2 = new JButton("RUN");
	JTextField txf1 = new JTextField();
	JTextField txf2 = new JTextField();
	JTextField txf3 = new JTextField();
	JTextField txf4 = new JTextField();
	JTextField txf5 = new JTextField();
	
	Set_Buyer_Price_Q() {
		
		Read_Seller_Parameter_Buyer.main();
		frm.setSize(600, 550); // 設定視窗的大小為 200*150
		frm.setLocation(150, 100); // 設定視窗位置為(100,50)
		frm.setTitle("Set_Buyer_Price_Q");
		frm.setLayout(null);

		btn1.setBounds(50, 420, 100, 60);
		btn1.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));

		btn2.setBounds(170, 420, 100, 60);
		btn2.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));

		txf1.setBounds(220, 70, 150, 40);
		txf1.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
		txf1.setText(String.valueOf(Read_Seller_Parameter_Buyer.Q()));
		frm.add(txf1);

		txf2.setBounds(220,120, 150, 40);
		txf2.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
		txf2.setText(String.valueOf(Read_Seller_Parameter_Buyer.price()));
		frm.add(txf2);
		
		txf3.setBounds(220,170, 150, 40);
		txf3.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
		txf3.setText(String.valueOf(Read_Seller_Parameter_Buyer.R()));
		frm.add(txf3);
		
		txf4.setBounds(220,270, 150, 40);
		txf4.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
		txf4.setText(String.valueOf(Read_Seller_Parameter_Buyer.botprice()));
		frm.add(txf4);
		
		txf5.setBounds(400,270, 150, 40);
		txf5.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
		txf5.setText(String.valueOf(Read_Seller_Parameter_Buyer.topprice()));
		frm.add(txf5);
		
		lab1.setText("隨機挑取賣方數量:");
		lab1.setBackground(Color.white);
		// lab1.setAlignment(Label.CENTER);
		lab1.setForeground(Color.blue);
		lab1.setBounds(50, 30, 200, 120);
		lab1.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
		frm.add(lab1);
		
		lab2.setText("買賣方價差:");
		lab2.setBackground(Color.white);
		// lab1.setAlignment(Label.CENTER);
		lab2.setForeground(Color.blue);
		lab2.setBounds(50, 80, 150, 120);
		lab2.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
		frm.add(lab2);

		lab3.setText("重複標數:");
		lab3.setBackground(Color.white);
		// lab1.setAlignment(Label.CENTER);
		lab3.setForeground(Color.blue);
		lab3.setBounds(50, 130, 150, 120);
		lab3.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
		frm.add(lab3);
		
		lab4.setText("重複價差:");
		lab4.setBackground(Color.white);
		// lab1.setAlignment(Label.CENTER);
		lab4.setForeground(Color.blue);
		lab4.setBounds(50, 230, 150, 120);
		lab4.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
		frm.add(lab4);
		
		lab5.setText("下限");
		lab5.setBackground(Color.white);
		// lab1.setAlignment(Label.CENTER);
		lab5.setForeground(Color.blue);
		lab5.setBounds(220, 180, 150, 120);
		lab5.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
		frm.add(lab5);
		
		lab6.setText("上限");
		lab6.setBackground(Color.white);
		// lab1.setAlignment(Label.CENTER);
		lab6.setForeground(Color.blue);
		lab6.setBounds(400, 180, 150, 120);
		lab6.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
		frm.add(lab6);
		
		frm.add(btn1);
		btn1.addActionListener(this);
		frm.add(btn2);
		btn2.addActionListener(this);

		frm.setVisible(true);

	}

	public static void main( ) {
		// TODO Auto-generated method stub
		new Set_Buyer_Price_Q();
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(btn1)) {
			try {
				 Write_Buyer_Sik_Seller_Parameter.saveSellerParameter(Integer.parseInt(txf1.getText()),Integer.parseInt(txf2.getText()),Integer.parseInt(txf3.getText()),Integer.parseInt(txf4.getText()),Integer.parseInt(txf5.getText()));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("SAVE OK");
		}
		if (e.getSource().equals(btn2)) {
			try {
				Generate_random_DA_Seller.Generate_Data_of_Double_Auction_Buyer();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("Buyer Data RUN OK");
			 frm.setVisible(false);
		}
		 
		
	}
}
