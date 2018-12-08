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
import Generate_random_data.Generate_random_DA_Problem3;
import Input_Output_txt.Double_Auction.Read_Seller_Parameter_Buyer;
import Input_Output_txt.Double_Auction.Read_Seller_Price_Parameter;
import Input_Output_txt.Double_Auction.Write_Buyer_Sik_Seller_Parameter;

public class Set_Seller_Price extends Double_Auction implements ActionListener {
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
	
	Set_Seller_Price() {
		
		Read_Seller_Price_Parameter.main();
		frm.setSize(600, 400); // 設定視窗的大小為 200*150
		frm.setLocation(150, 100); // 設定視窗位置為(100,50)
		frm.setTitle("Set_Seller_Price");
		frm.setLayout(null);

		btn1.setBounds(50, 250, 100, 60);
		btn1.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));

		btn2.setBounds(170, 250, 100, 60);
		btn2.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));

		
		
		txf1.setBounds(220,150, 150, 40);
		txf1.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
		txf1.setText(String.valueOf(Read_Seller_Price_Parameter.bot()));
		frm.add(txf1);
		
		txf2.setBounds(400,150, 150, 40);
		txf2.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
		txf2.setText(String.valueOf(Read_Seller_Price_Parameter.top()));
		frm.add(txf2);
		
		
		lab1.setText("賣方價格設定:");
		lab1.setBackground(Color.white);
		// lab1.setAlignment(Label.CENTER);
		lab1.setForeground(Color.blue);
		lab1.setBounds(50, 100, 150, 120);
		lab1.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
		frm.add(lab1);
		
		lab2.setText("下限");
		lab2.setBackground(Color.white);
		// lab1.setAlignment(Label.CENTER);
		lab2.setForeground(Color.blue);
		lab2.setBounds(220, 50, 150, 120);
		lab2.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
		frm.add(lab2);
		
		lab3.setText("上限");
		lab3.setBackground(Color.white);
		// lab1.setAlignment(Label.CENTER);
		lab3.setForeground(Color.blue);
		lab3.setBounds(400, 50, 150, 120);
		lab3.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
		frm.add(lab3);
		
		frm.add(btn1);
		btn1.addActionListener(this);
		frm.add(btn2);
		btn2.addActionListener(this);

		frm.setVisible(true);

	}

	public static void main( ) {
		// TODO Auto-generated method stub
		new Set_Seller_Price();
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(btn1)) {
			try {
				 Write_Buyer_Sik_Seller_Parameter.saveSellerPriceParameter(Integer.parseInt(txf2.getText()),Integer.parseInt(txf1.getText()));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("SAVE OK");
		}
		if (e.getSource().equals(btn2)) {
			try {
				Generate_random_DA_Problem3.Generate_Data_of_Double_Auction_Seller();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("Seller Data RUN OK");
			 frm.setVisible(false);
		}
		 
		
	}
}
