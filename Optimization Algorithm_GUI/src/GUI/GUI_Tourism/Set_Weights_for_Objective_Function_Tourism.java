package GUI.GUI_Tourism;

import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Input_Output_txt.Tourism.Read_Objective_Weight;
import Input_Output_txt.Tourism.Write_Objective_Weight;

public class Set_Weights_for_Objective_Function_Tourism extends Tourism implements
		ActionListener {
	JFrame frm = new JFrame();

	JTextField txf1 = new JTextField();
	JTextField txf2 = new JTextField();
/*	JTextField txf3 = new JTextField();
	JTextField txf4 = new JTextField();
	JTextField txf5 = new JTextField();
	JTextField txf6 = new JTextField();
	JTextField txf7 = new JTextField();
	JTextField txf8 = new JTextField();
*/
	JLabel lab1 = new JLabel();
	JLabel lab2 = new JLabel();
/*	JLabel lab3 = new JLabel();
	JLabel lab4 = new JLabel();
	JLabel lab5 = new JLabel();
	JLabel lab6 = new JLabel();
	JLabel lab7 = new JLabel();
	JLabel lab8 = new JLabel();
*/
	JButton btn1 = new JButton("OK");
	JButton btn2 = new JButton("Exit");

	Set_Weights_for_Objective_Function_Tourism() {

		frm.setSize(400, 400); // 設定視窗的大小為 200*150
		frm.setLocation(150, 150); // 設定視窗位置為(100,50)
		frm.setTitle("Set_Weights_for_Objective_Function");
		frm.setLayout(null);

		btn1.setBounds(280, 20, 80, 40);
		btn1.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));

		btn2.setBounds(280, 60, 80, 40);
		btn2.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));

		frm.add(btn1);
		btn1.addActionListener(this);
		frm.add(btn2);
		btn2.addActionListener(this);

	

			lab1.setText("Ω1");
			lab1.setBackground(Color.white);
			lab1.setAlignmentX(Label.CENTER);
			lab1.setForeground(Color.blue);
			lab1.setLocation(50, 20); // �]�w���Ҧ�m
			lab1.setSize(250, 40); // �]�w���Ҥj�p
			lab1.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab1);

			lab2.setText("Ω2");
			lab2.setBackground(Color.white);
			lab2.setAlignmentX(Label.CENTER);
			lab2.setForeground(Color.blue);
			lab2.setLocation(50, 60); // �]�w���Ҧ�m
			lab2.setSize(250, 40); // �]�w���Ҥj�p
			lab2.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab2);

	/*		lab3.setText("Ω3");
			lab3.setBackground(Color.white);
			lab3.setAlignmentX(Label.CENTER);
			lab3.setForeground(Color.blue);
			lab3.setLocation(50, 100); // �]�w���Ҧ�m
			lab3.setSize(250, 40); // �]�w���Ҥj�p
			lab3.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab3);

			lab4.setText("Ω4");
			lab4.setBackground(Color.white);
			lab4.setAlignmentX(Label.CENTER);
			lab4.setForeground(Color.blue);
			lab4.setLocation(50, 140); // �]�w���Ҧ�m
			lab4.setSize(250, 40); // �]�w���Ҥj�p
			lab4.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab4);

			lab5.setText("Ω5");
			lab5.setBackground(Color.white);
			lab5.setAlignmentX(Label.CENTER);
			lab5.setForeground(Color.blue);
			lab5.setLocation(50, 180); // �]�w���Ҧ�m
			lab5.setSize(250, 40); // �]�w���Ҥj�p
			lab5.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab5);

			lab6.setText("Ω6");
			lab6.setBackground(Color.white);
			lab6.setAlignmentX(Label.CENTER);
			lab6.setForeground(Color.blue);
			lab6.setLocation(50, 220); // �]�w���Ҧ�m
			lab6.setSize(250, 40); // �]�w���Ҥj�p
			lab6.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab6);

			lab7.setText("Ω7");
			lab7.setBackground(Color.white);
			lab7.setAlignmentX(Label.CENTER);
			lab7.setForeground(Color.blue);
			lab7.setLocation(50, 260); // �]�w���Ҧ�m
			lab7.setSize(250, 40); // �]�w���Ҥj�p
			lab7.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab7);

			lab8.setText("Ω8");
			lab8.setBackground(Color.white);
			lab8.setAlignmentX(Label.CENTER);
			lab8.setForeground(Color.blue);
			lab8.setLocation(50, 300); // �]�w���Ҧ�m
			lab8.setSize(250, 40); // �]�w���Ҥj�p
			lab8.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab8);
*/
			Read_Objective_Weight c1 = new Read_Objective_Weight();
			c1.main();
			txf1.setText(String.valueOf(c1.Omega_1()));
			txf2.setText(String.valueOf(c1.Omega_2()));
	/*		txf3.setText(String.valueOf(c1.Omega_3()));
			txf4.setText(String.valueOf(c1.Omega_4()));
			txf5.setText(String.valueOf(c1.Omega_5()));
			txf6.setText(String.valueOf(c1.Omega_6()));
			txf7.setText(String.valueOf(c1.Omega_7()));
			txf8.setText(String.valueOf(c1.Omega_8()));*/
			txf1.setBounds(100, 20, 150, 40);
			txf2.setBounds(100, 60, 150, 40);
	/*		txf3.setBounds(100, 100, 150, 40);
			txf4.setBounds(100, 140, 150, 40);
			txf5.setBounds(100, 180, 150, 40);
			txf6.setBounds(100, 220, 150, 40);
			txf7.setBounds(100, 260, 150, 40);
			txf8.setBounds(100, 300, 150, 40);*/
			frm.add(txf1);
			frm.add(txf2);
		/*	frm.add(txf3);
			frm.add(txf4);
			frm.add(txf5);
			frm.add(txf6);
			frm.add(txf7);
			frm.add(txf8);*/

		frm.setVisible(true);
	}

	public static void main() {
		// TODO Auto-generated method stub
		new Set_Weights_for_Objective_Function_Tourism();
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(btn1)) {
			try {
				Write_Objective_Weight.saveObjective_Weight_Tourism(
						Double.parseDouble(txf1.getText()),
						Double.parseDouble(txf2.getText())
					);
			} catch (NumberFormatException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		frm.setVisible(false);
	}
}
