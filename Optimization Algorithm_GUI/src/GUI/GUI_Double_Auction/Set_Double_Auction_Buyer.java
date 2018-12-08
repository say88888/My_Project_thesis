package GUI.GUI_Double_Auction;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Generate_random_data.Read_Generata_random_Double_Auction_Buyer;
import Input_Output_txt.Double_Auction.Write_Double_Auction_Parameter;

public class Set_Double_Auction_Buyer implements ActionListener  {
	
	JFrame frm = new JFrame("Set_Double_action");
	JLabel lab1 = new JLabel();
	JLabel lab2 = new JLabel();
	JLabel lab3 = new JLabel();
	JLabel lab4 = new JLabel();

	JTextField txf1 = new JTextField();
	JTextField txf2 = new JTextField();
	JTextField txf3 = new JTextField();
	JTextField txf4 = new JTextField();
	JButton btn1 = new JButton("SAVE");

	JLabel lab5 = new JLabel();
	JLabel lab6 = new JLabel();
	JLabel lab7 = new JLabel();
	JLabel lab8 = new JLabel();

	Set_Double_Auction_Buyer() {
		
		try {
			Read_Generata_random_Double_Auction_Buyer.main();
		} catch (ParseException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		frm.setSize(400, 450); // 設定視窗的大小為 200*150
		frm.setLocation(100, 50); // 設定視窗位置為(100,50)
		frm.setLayout(null);

		lab1.setText("物品種類 :");
		lab1.setBackground(Color.white);
		// lab1.setAlignment(Label.CENTER);
		lab1.setForeground(Color.blue);
		lab1.setLocation(60, 20); // �]�w���Ҧ�m
		lab1.setSize(150, 120); // �]�w���Ҥj�p
		lab1.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
		frm.add(lab1);

		lab2.setText("物品上限 :");
		lab2.setBackground(Color.white);
		// lab2.setAlignment(Label.CENTER);
		lab2.setForeground(Color.blue);
		lab2.setLocation(60, 90); // �]�w���Ҧ�m
		lab2.setSize(150, 120); // �]�w���Ҥj�p
		lab2.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
		frm.add(lab2);

		lab3.setText("隨機挑選物品數量 :");
		lab3.setBackground(Color.white);
		// lab2.setAlignment(Label.CENTER);
		lab3.setForeground(Color.blue);
		lab3.setLocation(60, 160); // �]�w���Ҧ�m
		lab3.setSize(180, 120); // �]�w���Ҥj�p
		lab3.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
		frm.add(lab3);

		lab4.setText("底價價格 :");
		lab4.setBackground(Color.white);
		// lab2.setAlignment(Label.CENTER);
		lab4.setForeground(Color.blue);
		lab4.setLocation(60, 230); // �]�w���Ҧ�m
		lab4.setSize(180, 120); // �]�w���Ҥj�p
		lab4.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
		frm.add(lab4);
		
		txf1.setBounds(180, 70, 100, 20);
		txf1.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
		txf1.setText(String.valueOf(Read_Generata_random_Double_Auction_Buyer.K() ));
		frm.add(txf1);

		txf2.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
		txf2.setText(String.valueOf(Read_Generata_random_Double_Auction_Buyer.K_top() ));
		txf2.setBounds(180, 140, 100, 20);
		frm.add(txf2);

		txf3.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
		txf3.setText(String.valueOf(Read_Generata_random_Double_Auction_Buyer.M()));
		txf3.setBounds(240, 210, 100, 20);
		frm.add(txf3);

		txf4.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
		txf4.setText(String.valueOf(Read_Generata_random_Double_Auction_Buyer.Buyerprice()));
		txf4.setBounds(240, 280, 100, 20);
		frm.add(txf4);
		
		btn1.setBounds(80, 350, 120, 30);
		btn1.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
		btn1.addActionListener(this);
		frm.add(btn1);

		
		
		frm.setVisible(true); // 設定視窗為可見
	}

	public static void main() {
		new Set_Double_Auction_Buyer();
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(btn1)) {
			try {
				Write_Double_Auction_Parameter.saveDouble_action_Buyer_Parameter(txf1.getText(),
						txf2.getText(),txf3.getText(),txf4.getText());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		frm.setVisible(false);
	}
	
}
