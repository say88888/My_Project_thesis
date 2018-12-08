package GUI.GUI_Carpool;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Input_Output_txt.Carpool.Read_Requirements_QuantityBounds;
import Input_Output_txt.Carpool.Write_Requirements_QuantityBoumds;

public class Set_Requirements_QuantityBounds implements ActionListener {
	JFrame frm = new JFrame("Set_Requirements_Quantity");
	 
	JLabel lab1 = new JLabel();
	JLabel lab2 = new JLabel();
	JLabel lab3 = new JLabel();
	JTextField txf1 = new JTextField();
	JTextField txf2 = new JTextField();
	JButton btn1 = new JButton("SAVE");
	JButton btn2 = new JButton("Cancel");
	
	Set_Requirements_QuantityBounds() {

		Read_Requirements_QuantityBounds.main();
		frm.setSize(400, 250); // 設定視窗的大小為 200*150
		frm.setLocation(100, 50); // 設定視窗位置為(100,50)
		frm.setLayout(null);

		lab1.setText("每位乘客要求的數量:");
		lab1.setBackground(Color.white);
		// lab1.setAlignment(Label.CENTER);
		lab1.setForeground(Color.blue);
		lab1.setLocation(30, 10); // �]�w���Ҧ�m
		lab1.setSize(200, 50); // �]�w���Ҥj�p
		lab1.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
		frm.add(lab1);
		

		lab2.setText("下限");
		lab2.setBackground(Color.white);
		// lab1.setAlignment(Label.CENTER);
		lab2.setForeground(Color.blue);
		lab2.setLocation(60, 0); // �]�w���Ҧ�m
		lab2.setSize(180, 160); // �]�w���Ҥj�p
		lab2.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
		frm.add(lab2);
		

		lab3.setText("上限");
		lab3.setBackground(Color.white);
		// lab1.setAlignment(Label.CENTER);
		lab3.setForeground(Color.blue);
		lab3.setLocation(180, 0); // �]�w���Ҧ�m
		lab3.setSize(180, 160); // �]�w���Ҥj�p
		lab3.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
		frm.add(lab3);

		txf1.setBounds(60, 100, 90, 20);
		txf1.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
		txf1.setText(String.valueOf(Read_Requirements_QuantityBounds.Requirements_Quantity_lower()));
		frm.add(txf1);

		txf2.setBounds(180, 100, 90, 20);
		txf2.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
		txf2.setText(String.valueOf(Read_Requirements_QuantityBounds.Requirements_Quantity_higher()));
		frm.add(txf2);
		
		btn1.setBounds(50, 150, 100, 30);
		btn1.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
		btn1.addActionListener(this);
		frm.add(btn1);

		btn2.setBounds(180, 150, 100, 30);
		btn2.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
		btn2.addActionListener(this);
		frm.add(btn2);
		
		frm.setVisible(true); // 設定視窗為可見
	}

	 
	
	public static void main( ) {
		new Set_Requirements_QuantityBounds();
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(btn1)) {
			try {
				Write_Requirements_QuantityBoumds.saveRequirements_Quantity(Integer.parseInt(txf1.getText()),Integer.parseInt(txf2.getText()));
			} catch (NumberFormatException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			 System.out.println("SAVE OK");
		}
		if (e.getSource().equals(btn2)) {
				frm.setVisible(false);
		}
	
	}
}
