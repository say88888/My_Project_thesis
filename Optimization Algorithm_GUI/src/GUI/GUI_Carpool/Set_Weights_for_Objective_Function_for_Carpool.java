package GUI.GUI_Carpool;

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

import Input_Output_txt.Carpool.Read_Objective_Weight;
import Input_Output_txt.Carpool.Write_Objective_Function_Parameters;

public class Set_Weights_for_Objective_Function_for_Carpool extends Carpool implements
		ActionListener {
	
	JFrame frm = new JFrame();

	JTextField txf1 = new JTextField();
	JTextField txf2 = new JTextField();
	JTextField txf3 = new JTextField();
	JTextField txf4 = new JTextField();
	JTextField txf5 = new JTextField();
	JTextField txf6 = new JTextField();
	JTextField txf7 = new JTextField();
	JTextField txf8 = new JTextField();
	JTextField txf17 = new JTextField();
	JTextField txf18 = new JTextField();
	
	
	JLabel lab1 = new JLabel();
	JLabel lab2 = new JLabel();
	JLabel lab3= new JLabel();
	JLabel lab4 = new JLabel();
	JLabel lab5 = new JLabel();
	JLabel lab6 = new JLabel();
	JLabel lab7 = new JLabel();
	JLabel lab8 = new JLabel();
	JLabel lab17 = new JLabel();
	JLabel lab18 = new JLabel();
	
	
	JLabel lab9 = new JLabel();
	JLabel lab10 = new JLabel();
	JLabel lab11= new JLabel();
	JLabel lab12 = new JLabel();
	JLabel lab13 = new JLabel();
	JLabel lab14 = new JLabel();
	JLabel lab15 = new JLabel();
	JLabel lab16 = new JLabel();

	JTextField txf9 = new JTextField();
	JTextField txf10 = new JTextField();
	JTextField txf11 = new JTextField();
	JTextField txf12 = new JTextField();
	JTextField txf13 = new JTextField();
	JTextField txf14 = new JTextField();
	JTextField txf15 = new JTextField();
	JTextField txf16 = new JTextField();
	
	
	JButton btn1 = new JButton("OK");
	JButton btn2 = new JButton("Exit");

	Set_Weights_for_Objective_Function_for_Carpool() {

		frm.setSize(950, 530); // 設定視窗的大小為 200*150
		frm.setLocation(150, 150); // 設定視窗位置為(100,50)
		frm.setTitle("Set_Weights_for_Objective_Function");
		frm.setLayout(null);

		btn1.setBounds(350, 430, 80, 40);
		btn1.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));

		btn2.setBounds(450, 430, 80, 40);
		btn2.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));

		frm.add(btn1);
		btn1.addActionListener(this);
		frm.add(btn2);
		btn2.addActionListener(this);
		
		if (!Algorithm.equals("LR")){

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
			
			lab3.setText("Ω3");
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
			
			lab9.setText("乘客cp值wp: ");
			lab9.setBackground(Color.white);
			lab9.setAlignmentX(Label.CENTER);
			lab9.setForeground(Color.blue);
			lab9.setLocation(180, 140); // �]�w���Ҧ�m
			lab9.setSize(250, 40); // �]�w���Ҥj�p
			lab9.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab9);
			
			lab10.setText("司機cp值wd: ");
			lab10.setBackground(Color.white);
			lab10.setAlignmentX(Label.CENTER);
			lab10.setForeground(Color.blue);
			lab10.setLocation(380, 140); // �]�w���Ҧ�m
			lab10.setSize(250, 40); // �]�w���Ҥj�p
			lab10.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab10);
			
			lab11.setText("Epsilon1 : ");
			lab11.setBackground(Color.white);
			lab11.setAlignmentX(Label.CENTER);
			lab11.setForeground(Color.blue);
			lab11.setLocation(580, 140); // �]�w���Ҧ�m
			lab11.setSize(250, 40); // �]�w���Ҥj�p
			lab11.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab11);
			
			lab12.setText("Epsilon2 : ");
			lab12.setBackground(Color.white);
			lab12.setAlignmentX(Label.CENTER);
			lab12.setForeground(Color.blue);
			lab12.setLocation(760, 140); // �]�w���Ҧ�m
			lab12.setSize(250, 40); // �]�w���Ҥj�p
			lab12.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab12);
			
			
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

			lab13.setText("乘客cp值wp: ");
			lab13.setBackground(Color.white);
			lab13.setAlignmentX(Label.CENTER);
			lab13.setForeground(Color.blue);
			lab13.setLocation(180, 260); // �]�w���Ҧ�m
			lab13.setSize(250, 40); // �]�w���Ҥj�p
			lab13.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab13);
			
			lab14.setText("司機cp值wd: ");
			lab14.setBackground(Color.white);
			lab14.setAlignmentX(Label.CENTER);
			lab14.setForeground(Color.blue);
			lab14.setLocation(380, 260); // �]�w���Ҧ�m
			lab14.setSize(250, 40); // �]�w���Ҥj�p
			lab14.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab14);
			
			lab15.setText("Epsilon3 : ");
			lab15.setBackground(Color.white);
			lab15.setAlignmentX(Label.CENTER);
			lab15.setForeground(Color.blue);
			lab15.setLocation(580, 260); // �]�w���Ҧ�m
			lab15.setSize(250, 40); // �]�w���Ҥj�p
			lab15.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab15);
			
			lab16.setText("Epsilon4 : ");
			lab16.setBackground(Color.white);
			lab16.setAlignmentX(Label.CENTER);
			lab16.setForeground(Color.blue);
			lab16.setLocation(760, 260); // �]�w���Ҧ�m
			lab16.setSize(250, 40); // �]�w���Ҥj�p
			lab16.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab16);
			
			
			lab8.setText("Ω8");
			lab8.setBackground(Color.white);
			lab8.setAlignmentX(Label.CENTER);
			lab8.setForeground(Color.blue);
			lab8.setLocation(50, 300); // �]�w���Ҧ�m
			lab8.setSize(250, 40); // �]�w���Ҥj�p
			lab8.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab8);
	
			if(X_Select_Algorithm_Type_to_Solve_the_Problem.method().equals("PSO_LS_WaitingTime")){
			lab17.setText("Ω9");
			lab17.setBackground(Color.white);
			lab17.setAlignmentX(Label.CENTER);
			lab17.setForeground(Color.blue);
			lab17.setLocation(50, 340); // �]�w���Ҧ�m
			lab17.setSize(250, 40); // �]�w���Ҥj�p
			lab17.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab17);
			
			lab18.setText("Ω10");
			lab18.setBackground(Color.white);
			lab18.setAlignmentX(Label.CENTER);
			lab18.setForeground(Color.blue);
			lab18.setLocation(50, 380); // �]�w���Ҧ�m
			lab18.setSize(250, 40); // �]�w���Ҥj�p
			lab18.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab18);
			}
			
			Read_Objective_Weight c1 = new Read_Objective_Weight();
			c1.main();
			txf1.setText(String.valueOf(c1.Omega_1()));
			txf2.setText(String.valueOf(c1.Omega_2()));
			txf3.setText(String.valueOf(c1.Omega_3()));
			txf4.setText(String.valueOf(c1.Omega_4()));
			txf5.setText(String.valueOf(c1.Omega_5()));
			txf6.setText(String.valueOf(c1.Omega_6()));
			txf7.setText(String.valueOf(c1.Omega_7()));
			txf8.setText(String.valueOf(c1.Omega_8()));
			txf17.setText(String.valueOf(c1.Omega_9()));
			txf18.setText(String.valueOf(c1.Omega_10()));
		

			
			txf1.setBounds(100, 20, 60, 40);
			txf2.setBounds(100, 60, 60, 40);
			txf3.setBounds(100, 100, 60, 40);
			txf4.setBounds(100, 140, 60, 40);
			txf5.setBounds(100, 180, 60, 40);
			txf6.setBounds(100, 220, 60, 40);
			txf7.setBounds(100, 260, 60, 40);
			txf8.setBounds(100, 300, 60, 40);
			txf17.setBounds(100, 340, 60, 40);
			txf18.setBounds(100, 380, 60, 40);
			
			frm.add(txf1);
			frm.add(txf2);
			frm.add(txf3);
			frm.add(txf4);
			frm.add(txf5);
			frm.add(txf6);
			frm.add(txf7);
			frm.add(txf8);
			frm.add(txf17);
			frm.add(txf18);
			
			txf9.setText(String.valueOf(c1.wp()));
			txf10.setText(String.valueOf(c1.wd()));
			txf11.setText(String.valueOf(c1.Epsilon1()));
			txf12.setText(String.valueOf(c1.Epsilon2()));
			txf9.setBounds(300, 140, 60, 40);
			txf10.setBounds(500, 140, 60, 40);
			txf11.setBounds(680, 140, 60, 40);
			txf12.setBounds(860, 140, 60, 40);
			frm.add(txf9);
			frm.add(txf10);
			frm.add(txf11);
			frm.add(txf12);
			
			txf13.setText(String.valueOf(c1.wp1()));
			txf14.setText(String.valueOf(c1.wd1()));
			txf15.setText(String.valueOf(c1.Epsilon3()));
			txf16.setText(String.valueOf(c1.Epsilon4()));
			txf13.setBounds(300, 260, 60, 40);
			txf14.setBounds(500, 260, 60, 40);
			txf15.setBounds(680, 260, 60, 40);
			txf16.setBounds(860, 260, 60, 40);
			frm.add(txf13);
			frm.add(txf14);
			frm.add(txf15);
			frm.add(txf16);
			
		} else {
			lab1.setText("Not have,Thanks");
			lab1.setBackground(Color.white);
			lab1.setAlignmentX(Label.CENTER);
			lab1.setForeground(Color.blue);
			lab1.setLocation(100, 150); // �]�w���Ҧ�m
			lab1.setSize(250, 20); // �]�w���Ҥj�p
			lab1.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab1);
			frm.remove(btn1);
		}
		
		frm.setVisible(true);
	}

	public static void main( ) {
		// TODO Auto-generated method stub
		new Set_Weights_for_Objective_Function_for_Carpool();
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(btn1)) {
			try {
				Write_Objective_Function_Parameters.saveObjective_Omega(
						Double.parseDouble(txf1.getText()),
						Double.parseDouble(txf2.getText()),
						Double.parseDouble(txf3.getText()),
						Double.parseDouble(txf4.getText()),
						Double.parseDouble(txf9.getText()),
						Double.parseDouble(txf10.getText()),
						Double.parseDouble(txf11.getText()),
						Double.parseDouble(txf12.getText()),
						Double.parseDouble(txf5.getText()),
						Double.parseDouble(txf6.getText()),
						Double.parseDouble(txf7.getText()),		
						Double.parseDouble(txf13.getText()),	
						Double.parseDouble(txf14.getText()),	
						Double.parseDouble(txf15.getText()),	
						Double.parseDouble(txf16.getText()),	
						Double.parseDouble(txf8.getText()),
						Double.parseDouble(txf17.getText()),	
						Double.parseDouble(txf18.getText())
						);
				
			} catch (NumberFormatException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		frm.setVisible(false);
	}
}
