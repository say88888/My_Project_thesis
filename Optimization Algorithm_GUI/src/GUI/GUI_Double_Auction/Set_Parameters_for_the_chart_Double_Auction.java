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

import Input_Output_txt.Read_Parameters_for_the_chart;
import Input_Output_txt.Write_Parameters_for_the_chart;

public class Set_Parameters_for_the_chart_Double_Auction implements ActionListener {
	JFrame frm = new JFrame("Set_Parameters_for_the_chart");
	JLabel lab1 = new JLabel();
	JLabel lab2 = new JLabel();
	JLabel lab3 = new JLabel();
	JLabel lab4 = new JLabel();

	JTextField txf1 = new JTextField();
	JTextField txf2 = new JTextField();
	JTextField txf3 = new JTextField();
	JTextField txf4 = new JTextField();
	JButton btn1 = new JButton("SAVE");
	JButton btn2 = new JButton("Select_multi_Algorithm_show_chart");
	JButton btn3 = new JButton("Drawing");
	JButton btn4 = new JButton("Exit");
	JLabel lab5 = new JLabel();
	JLabel lab6 = new JLabel();
	JLabel lab7 = new JLabel();
	JLabel lab8 = new JLabel();


	Set_Parameters_for_the_chart_Double_Auction() {
		Read_Parameters_for_the_chart.main();
		frm.setSize(500, 420); // 設定視窗的大小為 200*150
		frm.setLocation(100, 50); // 設定視窗位置為(100,50)
		frm.setLayout(null);

		lab1.setText("Start:");
		lab1.setBackground(Color.white);
		// lab1.setAlignment(Label.CENTER);
		lab1.setForeground(Color.blue);
		lab1.setLocation(60, 20); // �]�w���Ҧ�m
		lab1.setSize(150, 120); // �]�w���Ҥj�p
		lab1.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
		frm.add(lab1);

		lab2.setText("End:");
		lab2.setBackground(Color.white);
		// lab2.setAlignment(Label.CENTER);
		lab2.setForeground(Color.blue);
		lab2.setLocation(60, 90); // �]�w���Ҧ�m
		lab2.setSize(150, 120); // �]�w���Ҥj�p
		lab2.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
		frm.add(lab2);

		lab3.setText("Interval:");
		lab3.setBackground(Color.white);
		// lab2.setAlignment(Label.CENTER);
		lab3.setForeground(Color.blue);
		lab3.setLocation(60, 160); // �]�w���Ҧ�m
		lab3.setSize(150, 120); // �]�w���Ҥj�p
		lab3.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
		frm.add(lab3);
		
		txf1.setBounds(150, 70, 100, 20);
		txf1.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
		txf1.setText(Read_Parameters_for_the_chart.Start());
		frm.add(txf1);

		txf2.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
		txf2.setText(Read_Parameters_for_the_chart.End());
		txf2.setBounds(150, 140, 100, 20);
		frm.add(txf2);

		txf3.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
		txf3.setText(Read_Parameters_for_the_chart.Interval());
		txf3.setBounds(150, 210, 100, 20);
		frm.add(txf3);
		
		btn1.setBounds(60, 250, 80, 30);
		btn1.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
		btn1.addActionListener(this);
		frm.add(btn1);

		btn2.setBounds(180, 250, 80, 30);
		btn2.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
		btn2.addActionListener(this);
		frm.add(btn2);
		
		btn3.setBounds(300, 250, 80, 30);
		btn3.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
		btn3.addActionListener(this);
		frm.add(btn3);
		
		btn4.setBounds(180, 300, 80, 30);
		btn4.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
		btn4.addActionListener(this);
		frm.add(btn4);
		
		lab5.setText("開始的點");
		lab5.setBackground(Color.white);
		// lab1.setAlignment(Label.CENTER);
		lab5.setForeground(Color.blue);
		lab5.setLocation(80, -10); // �]�w���Ҧ�m
		lab5.setSize(250, 120); // �]�w���Ҥj�p
		lab5.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
		frm.add(lab5);

		lab6.setText("結束的點");
		lab6.setBackground(Color.white);
		// la1.setAlignment(Label.CENTER);
		lab6.setForeground(Color.blue);
		lab6.setLocation(80, 60); // �]�w���Ҧ�m
		lab6.setSize(250, 120); // �]�w���Ҥj�p
		lab6.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
		frm.add(lab6);

		lab7.setText("要間的隔數值");
		lab7.setBackground(Color.white);
		// lab1.setAlignment(Label.CENTER);
		lab7.setForeground(Color.blue);
		lab7.setLocation(80, 130); // �]�w���Ҧ�m
		lab7.setSize(250, 120); // �]�w���Ҥj�p
		lab7.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
		frm.add(lab7);
		
		frm.setVisible(true); // 設定視窗為可見
	}

	public static void main() {
		new Set_Parameters_for_the_chart_Double_Auction();
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(btn1)) {
			try {
				Write_Parameters_for_the_chart.save_Parameters_for_the_chart(txf1.getText(),
						txf2.getText(),txf3.getText());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getSource().equals(btn2)) {
			Select_multi_Algorithm_show_chart_DA.main();
		}
		if (e.getSource().equals(btn3)) {
	
			 XYLineAndShapeRendererDemo_DA.main();
		}
		if (e.getSource().equals(btn4)) {
			
			frm.setVisible(false);
		}
		
	
	}
}
