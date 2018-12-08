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

import Input_Output_txt.Double_Auction.Read_TransactionFee;
import Input_Output_txt.Double_Auction.Write_TransactionFee;
 

public class Set_Alpha_TransactionFee implements ActionListener{
	JFrame frm = new JFrame("Set_a_Delta_TransactionFee");
	JLabel lab1 = new JLabel();
	
	JTextField txf1 = new JTextField();
	 
	JButton btn1 = new JButton("SAVE");

	JLabel lab5 = new JLabel();
	JLabel lab6 = new JLabel();
	JLabel lab7 = new JLabel();
	JLabel lab8 = new JLabel();

	Set_Alpha_TransactionFee() {
		Read_TransactionFee.main();
		frm.setSize(400, 400); // 設定視窗的大小為 200*150
		frm.setLocation(100, 50); // 設定視窗位置為(100,50)
		frm.setLayout(null);

		lab1.setText("Alpha :");
		lab1.setBackground(Color.white);
		// lab1.setAlignment(Label.CENTER);
		lab1.setForeground(Color.blue);
		lab1.setLocation(80, 20); // �]�w���Ҧ�m
		lab1.setSize(150, 120); // �]�w���Ҥj�p
		lab1.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
		frm.add(lab1);

		
		
		txf1.setBounds(180, 70, 100, 20);
		txf1.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
		txf1.setText(String.valueOf(Read_TransactionFee.Alpha()));
		frm.add(txf1);

	
		
		btn1.setBounds(100, 320, 120, 30);
		btn1.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
		btn1.addActionListener(this);
		frm.add(btn1);

		lab5.setText("利潤成本分配參數 0~1");
		lab5.setBackground(Color.white);
		// lab1.setAlignment(Label.CENTER);
		lab5.setForeground(Color.blue);
		lab5.setLocation(80, -10); // �]�w���Ҧ�m
		lab5.setSize(250, 120); // �]�w���Ҥj�p
		lab5.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
		frm.add(lab5);

	
		
		frm.setVisible(true); // 設定視窗為可見
	}

	public static void main() {
		new Set_Alpha_TransactionFee();
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(btn1)) {
			try {
				Write_TransactionFee.saveTransactionFee(txf1.getText());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		frm.setVisible(false);
	}
}
