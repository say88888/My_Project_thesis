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
import Input_Output_txt.Double_Auction.Read_Set_intput_CATS_Seller_Parameter;
import Input_Output_txt.Double_Auction.Write_Set_intput_CATS_Parameter;

public class Set_CATS_Double_Auction_SellerParameter extends Double_Auction implements ActionListener {
	JFrame frm = new JFrame();
	JTextField txf1 = new JTextField();
	JTextField txf2 = new JTextField();
	JLabel lab1 = new JLabel();
	JLabel lab2 = new JLabel();
	JLabel lab3 = new JLabel();
	JButton btn1 = new JButton("SAVE");
	JButton btn2 = new JButton("Exit");
	JComboBox box1=new JComboBox();
	Set_CATS_Double_Auction_SellerParameter() {
		
		Read_Set_intput_CATS_Seller_Parameter.Double_Auction();
		
		frm.setSize(600, 550); // 設定視窗的大小為 200*150
		frm.setLocation(150, 100); // 設定視窗位置為(100,50)
		frm.setTitle("Set_Single_Auction_USE_CATS");
		frm.setLayout(null);
		
		lab1.setText("設定參數-d對應的值 : ");
		lab1.setBackground(Color.white);
		// lab1.setAlignment(Label.CENTER);
		lab1.setForeground(Color.blue);
		lab1.setBounds(50, 30, 200, 40);
		lab1.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
		frm.add(lab1);
		
		lab2.setText("設定參數-goods 的值 : ");
		lab2.setBackground(Color.white);
		// lab1.setAlignment(Label.CENTER);
		lab2.setForeground(Color.blue);
		lab2.setBounds(50, 130, 200, 40);
		lab2.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
		frm.add(lab2);
		
		lab3.setText("-bids參數對應的值 : ");
		lab3.setBackground(Color.white);
		// lab1.setAlignment(Label.CENTER);
		lab3.setForeground(Color.blue);
		lab3.setBounds(50, 210, 200, 40);
		lab3.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
		frm.add(lab3);
		
		
		String[] jiguan={"arbitrary","arbitrary-npv","arbitrary-upv","matching","paths","regions"
				,"regions-npv","regions-npv", "regions-upv","scheduling",
				"L1", "L2", "L3", "L4", "L5","L6", "L7", "L8"};
		
		box1=new JComboBox(jiguan);
		box1.setBounds(250, 30, 150, 40);
		box1.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
		frm.add(box1);
		
		txf1.setBounds(250, 130, 150, 40);
		txf1.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
		txf1.setText(String.valueOf(Read_Set_intput_CATS_Seller_Parameter.goods_value()));
		frm.add(txf1);

		txf2.setBounds(250,210, 150, 40);
		txf2.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
		txf2.setText(String.valueOf(Read_Set_intput_CATS_Seller_Parameter.bids_value()));
		frm.add(txf2);
		
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
		new Set_CATS_Double_Auction_SellerParameter();
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(btn1)) {
			  String value = (String) box1.getSelectedItem();
			try {
				Write_Set_intput_CATS_Parameter.save_Double_Seller_Parameter(value, Integer.parseInt(txf1.getText()), Integer.parseInt(txf2.getText()));
			}catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("SAVE OK");
		}
		if (e.getSource().equals(btn2)) {
		
			System.out.println("Exit");
			 frm.setVisible(false);
		}
		 
		
	}
}
