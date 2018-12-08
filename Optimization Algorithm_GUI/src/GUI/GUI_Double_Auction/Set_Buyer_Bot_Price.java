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

import Generate_random_data.Generate_random_DA;
import Input_Output_txt.Double_Auction.Read_Buyer_Parameter;
import Input_Output_txt.Double_Auction.Write_Buyer_Sik_Seller_Parameter;

public class Set_Buyer_Bot_Price extends Double_Auction implements ActionListener {
	JFrame frm = new JFrame();
	JLabel lab1 = new JLabel();
	JButton btn1 = new JButton("SAVE");
	JButton btn2 = new JButton("RUN");
	JTextField txf1 = new JTextField();

	Set_Buyer_Bot_Price() {
		
		Read_Buyer_Parameter.main();
		frm.setSize(400, 300); // 設定視窗的大小為 200*150
		frm.setLocation(150, 150); // 設定視窗位置為(100,50)
		frm.setTitle("Set_Buyer_Bot_Price");
		frm.setLayout(null);

		btn1.setBounds(50, 170, 100, 60);
		btn1.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));

		btn2.setBounds(170, 170, 100, 60);
		btn2.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));

		txf1.setBounds(200, 70, 150, 40);
		txf1.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
		txf1.setText(String.valueOf(Read_Buyer_Parameter.price()));
		frm.add(txf1);

		lab1.setText("買方底限價格:");
		lab1.setBackground(Color.white);
		// lab1.setAlignment(Label.CENTER);
		lab1.setForeground(Color.blue);
		lab1.setBounds(50, 30, 150, 120);
		lab1.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
		frm.add(lab1);

		frm.add(btn1);
		btn1.addActionListener(this);
		frm.add(btn2);
		btn2.addActionListener(this);

		frm.setVisible(true);

	}

	public static void main( ) {
		// TODO Auto-generated method stub
		new Set_Buyer_Bot_Price();
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(btn1)) {
			try {
				 Write_Buyer_Sik_Seller_Parameter.saveBuyerParameter(Integer.parseInt(txf1.getText()));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("SAVE OK");
		}
		if (e.getSource().equals(btn2)) {
			try {
				Generate_random_DA
						.Generate_Data_of_Double_Auction_Buyer();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("Buyer Data RUN OK");
			 frm.setVisible(false);
		}
		 
		
	}
}