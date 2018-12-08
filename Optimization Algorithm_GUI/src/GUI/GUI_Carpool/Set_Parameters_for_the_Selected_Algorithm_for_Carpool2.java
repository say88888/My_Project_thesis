package GUI.GUI_Carpool;

import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.math.BigDecimal;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Input_Output_txt.Carpool.Write_Parameter_for_Carpool;


public class Set_Parameters_for_the_Selected_Algorithm_for_Carpool2 extends Carpool implements
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
	JTextField txf9 = new JTextField();
	JTextField txf10 = new JTextField();
	JTextField txf11 = new JTextField();
	JTextField txf12 = new JTextField();
	
	JTextField txf13 = new JTextField();
	JTextField txf14 = new JTextField();
	JTextField txf15 = new JTextField();
	JTextField txf16 = new JTextField();
	JTextField txf17 = new JTextField();
	JTextField txf20 = new JTextField();
	JTextField txf21 = new JTextField();
	JTextField txf22 = new JTextField();
	JTextField txf23 = new JTextField();
	JTextField txf24 = new JTextField();

	JTextField txf25 = new JTextField();
	JTextField txf26 = new JTextField();

	JTextField txf27 = new JTextField();
	JTextField txf28 = new JTextField();
	JTextField txf29 = new JTextField();
	JTextField txf30 = new JTextField();
	JTextField txf31 = new JTextField();
	JTextField txf32 = new JTextField();

	JTextField txf33 = new JTextField();
	JTextField txf34 = new JTextField();
	JTextField txf35 = new JTextField();
	
	JTextField txf36 = new JTextField();
	JTextField txf37 = new JTextField();
	JTextField txf38 = new JTextField();
	JTextField txf39 = new JTextField();
	
	JTextField txf40 = new JTextField();
	JTextField txf41 = new JTextField();
	JTextField txf42 = new JTextField();
	JTextField txf43 = new JTextField();
	JTextField txf44 = new JTextField();
	JTextField txf45 = new JTextField();
	JLabel lab1 = new JLabel();
	JLabel lab2 = new JLabel();
	JLabel lab3 = new JLabel();
	JLabel lab4 = new JLabel();
	JLabel lab5 = new JLabel();
	JLabel lab6 = new JLabel();
	JLabel lab7 = new JLabel();
	JLabel lab8 = new JLabel();
	JLabel lab9 = new JLabel();
	JLabel lab10 = new JLabel();
	JLabel lab11 = new JLabel();
	JLabel lab12 = new JLabel();

	JLabel lab13 = new JLabel();
	JLabel lab14 = new JLabel();
	 
	JLabel lab15 = new JLabel();
	JLabel lab16 = new JLabel();
	JLabel lab17 = new JLabel();
	JLabel lab18 = new JLabel();
	JLabel lab19 = new JLabel();

	JLabel lab20 = new JLabel();
	JLabel lab21 = new JLabel();
	JLabel lab22 = new JLabel();

	JLabel lab23 = new JLabel();
	JLabel lab24 = new JLabel();

	JLabel lab25 = new JLabel();
	JLabel lab26 = new JLabel();
	JLabel lab27 = new JLabel();
	JLabel lab28 = new JLabel();
	JLabel lab29 = new JLabel();
	JLabel lab30 = new JLabel();

	JLabel lab31 = new JLabel();
	JLabel lab32 = new JLabel();
	JLabel lab33 = new JLabel();
	JLabel lab34 = new JLabel();
	JLabel lab35 = new JLabel();
	
	JLabel lab36 = new JLabel();
	JLabel lab37 = new JLabel();
	JLabel lab38 = new JLabel();
	JLabel lab39 = new JLabel();
	JLabel lab40 = new JLabel();
	JLabel lab41 = new JLabel();
	
	JLabel lab42 = new JLabel();
	JLabel lab43 = new JLabel();
	JLabel lab44 = new JLabel();
	JLabel lab45 = new JLabel();
	JLabel lab46 = new JLabel();
	JLabel lab47 = new JLabel();
	JButton btn1 = new JButton("OK");
	JButton btn2 = new JButton("Exit");
	JComboBox box1=new JComboBox();
	
	Set_Parameters_for_the_Selected_Algorithm_for_Carpool2() {

		frm.setSize(950, 850); // 設定視窗的大小為 200*150
		frm.setLocation(400, 10); // 設定視窗位置為(100,50)
		frm.setTitle("XI_Set_Parameters_for_the_Selected_Algorithm");
		frm.setLayout(null);
		
		if (Algorithm.equals("FA_AB_NNH") || Algorithm.equals("FA_AB_2Si_ApproachI") || Algorithm.equals("FA_AB_2Si_ApproachII")
			|| Algorithm.equals("FA_PSO_AB_NNH") || Algorithm.equals("FA_PSO_AB_2Si_ApproachI") || Algorithm.equals("FA_PSO_AB_2Si_ApproachII")
			) {

			lab36.setText("Iteration");
			lab36.setBackground(Color.white);
			lab36.setAlignmentX(Label.CENTER);
			lab36.setForeground(Color.blue);
			lab36.setLocation(50, 20); // �]�w���Ҧ�m
			lab36.setSize(200, 20); // �]�w���Ҥj�p
			lab36.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab36);
			
			lab37.setText("Iteration_Mode");
			lab37.setBackground(Color.white);
			lab37.setAlignmentX(Label.CENTER);
			lab37.setForeground(Color.blue);
			lab37.setLocation(50, 60); // �]�w���Ҧ�m
			lab37.setSize(300, 20); // �]�w���Ҥj�p
			lab37.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab37);
			
			lab38.setText("0執行參數設定,1執行內定函式");
			lab38.setBackground(Color.white);
			lab38.setAlignmentX(Label.CENTER);
			lab38.setForeground(Color.blue);
			lab38.setLocation(450, 60); // �]�w���Ҧ�m
			lab38.setSize(300, 20); // �]�w���Ҥj�p
			lab38.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab38);
			
			lab1.setText("populationSize");
			lab1.setBackground(Color.white);
			lab1.setAlignmentX(Label.CENTER);
			lab1.setForeground(Color.blue);
			lab1.setLocation(50, 100); // �]�w���Ҧ�m
			lab1.setSize(250, 20); // �]�w���Ҥj�p
			lab1.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab1);

			lab2.setText("w");
			lab2.setBackground(Color.white);
			lab2.setAlignmentX(Label.CENTER);
			lab2.setForeground(Color.blue);
			lab2.setLocation(50, 140); // �]�w���Ҧ�m
			lab2.setSize(250, 20); // �]�w���Ҥj�p
			lab2.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab2);

			lab3.setText("c1");
			lab3.setBackground(Color.white);
			lab3.setAlignmentX(Label.CENTER);
			lab3.setForeground(Color.blue);
			lab3.setLocation(50, 180); // �]�w���Ҧ�m
			lab3.setSize(250, 20); // �]�w���Ҥj�p
			lab3.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab3);

			lab4.setText("c2");
			lab4.setBackground(Color.white);
			lab4.setAlignmentX(Label.CENTER);
			lab4.setForeground(Color.blue);
			lab4.setLocation(50, 220); // �]�w���Ҧ�m
			lab4.setSize(250, 20); // �]�w���Ҥj�p
			lab4.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab4);

			lab5.setText("Vmax");
			lab5.setBackground(Color.white);
			lab5.setAlignmentX(Label.CENTER);
			lab5.setForeground(Color.blue);
			lab5.setLocation(50, 260); // �]�w���Ҧ�m
			lab5.setSize(250, 20); // �]�w���Ҥj�p
			lab5.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab5);

			lab6.setText("Execution_Mode");
			lab6.setBackground(Color.white);
			lab6.setAlignmentX(Label.CENTER);
			lab6.setForeground(Color.blue);
			lab6.setLocation(50, 300); // �]�w���Ҧ�m
			lab6.setSize(250, 20); // �]�w���Ҥj�p
			lab6.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab6);

			lab20.setText("0不重複執行,1重複上一次執行");
			lab20.setBackground(Color.white);
			lab20.setAlignmentX(Label.CENTER);
			lab20.setForeground(Color.blue);
			lab20.setLocation(450, 300); // �]�w���Ҧ�m
			lab20.setSize(300, 20); // �]�w���Ҥj�p
			lab20.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab20);

			lab7.setText("Print_Mode");
			lab7.setBackground(Color.white);
			lab7.setAlignmentX(Label.CENTER);
			lab7.setForeground(Color.blue);
			lab7.setLocation(50, 340); // �]�w���Ҧ�m
			lab7.setSize(250, 20); // �]�w���Ҥj�p
			lab7.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab7);

			lab21.setText("0不顯示執行過程,1顯示執行過程");
			lab21.setBackground(Color.white);
			lab21.setAlignmentX(Label.CENTER);
			lab21.setForeground(Color.blue);
			lab21.setLocation(450, 340); // �]�w���Ҧ�m
			lab21.setSize(300, 20); // �]�w���Ҥj�p
			lab21.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab21);

			lab34.setText("Write_Mode");
			lab34.setBackground(Color.white);
			lab34.setAlignmentX(Label.CENTER);
			lab34.setForeground(Color.blue);
			lab34.setLocation(50, 380); // �]�w���Ҧ�m
			lab34.setSize(250, 20); // �]�w���Ҥj�p
			lab34.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab34);

			lab35.setText("0是執行Write_Mode,1是不執行Write_Mode");
			lab35.setBackground(Color.white);
			lab35.setAlignmentX(Label.CENTER);
			lab35.setForeground(Color.blue);
			lab35.setLocation(450, 380); // �]�w���Ҧ�m
			lab35.setSize(300, 20); // �]�w���Ҥj�p
			lab35.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab35);
			
			lab8.setText("threshold");
			lab8.setBackground(Color.white);
			lab8.setAlignmentX(Label.CENTER);
			lab8.setForeground(Color.blue);
			lab8.setLocation(50, 420); // �]�w���Ҧ�m
			lab8.setSize(250, 20); // �]�w���Ҥj�p
			lab8.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab8);
			
				if (Algorithm.equals("FA_PSO_AB_NNH")) {

					lab19.setText("β0");
					lab19.setBackground(Color.white);
					lab19.setAlignmentX(Label.CENTER);
					lab19.setForeground(Color.blue);
					lab19.setLocation(50, 460); // �]�w���Ҧ�m
					lab19.setSize(250, 20); // �]�w���Ҥj�p
					lab19.setFont(new Font("Serief", Font.ITALIC + Font.BOLD,
							18));
					frm.add(lab19);

					lab31.setText("γ");
					lab31.setBackground(Color.white);
					lab31.setAlignmentX(Label.CENTER);
					lab31.setForeground(Color.blue);
					lab31.setLocation(50, 500); // �]�w���Ҧ�m
					lab31.setSize(650, 20); // �]�w���Ҥj�p
					lab31.setFont(new Font("Serief", Font.ITALIC + Font.BOLD,
							18));
					frm.add(lab31);

					lab32.setText("α");
					lab32.setBackground(Color.white);
					lab32.setAlignmentX(Label.CENTER);
					lab32.setForeground(Color.blue);
					lab32.setLocation(50, 540); // �]�w���Ҧ�m
					lab32.setSize(650, 20); // �]�w���Ҥj�p
					lab32.setFont(new Font("Serief", Font.ITALIC + Font.BOLD,
							18));
					frm.add(lab32);

					Algorithm_Carpool.FA_PSO_AB_NNH.PSO_Read_Write_txt c2 = new Algorithm_Carpool.FA_PSO_AB_NNH.PSO_Read_Write_txt();
					c2.read_PSO_Parameter();
					txf36.setText(String.valueOf(c2.Iteration()));
					txf37.setText(String.valueOf(c2.Iteration_Mode()));
					txf1.setText(String.valueOf(c2.populationSize()));
					txf2.setText(String.valueOf(c2.w()));
					txf3.setText(String.valueOf(c2.c1()));
					txf4.setText(String.valueOf(c2.c2()));
					txf5.setText(String.valueOf(c2.Vmax()));
					txf6.setText(String.valueOf(c2.Execution_Mode()));
					txf7.setText(String.valueOf(c2.Print_Mode()));
					txf35.setText(String.valueOf(c2.Write_Mode()));
					txf8.setText(String.valueOf(String.valueOf(new BigDecimal(
							String.valueOf(c2.threshold())).toPlainString())));
					txf24.setText(String.valueOf(c2.B0()));
					txf33.setText(String.valueOf(c2.Gamma()));
					txf34.setText(String.valueOf(c2.Alpha()));

					txf24.setBounds(250, 460, 150, 20);
					txf33.setBounds(250, 500, 150, 20);
					txf34.setBounds(250, 540, 150, 20);

					frm.add(txf24);
					frm.add(txf33);
					frm.add(txf34);
				}
				if (Algorithm.equals("FA_PSO_AB_2Si_ApproachI")) {

					lab19.setText("β0");
					lab19.setBackground(Color.white);
					lab19.setAlignmentX(Label.CENTER);
					lab19.setForeground(Color.blue);
					lab19.setLocation(50, 460); // �]�w���Ҧ�m
					lab19.setSize(250, 20); // �]�w���Ҥj�p
					lab19.setFont(new Font("Serief", Font.ITALIC + Font.BOLD,
							18));
					frm.add(lab19);

					lab31.setText("γ");
					lab31.setBackground(Color.white);
					lab31.setAlignmentX(Label.CENTER);
					lab31.setForeground(Color.blue);
					lab31.setLocation(50, 500); // �]�w���Ҧ�m
					lab31.setSize(650, 20); // �]�w���Ҥj�p
					lab31.setFont(new Font("Serief", Font.ITALIC + Font.BOLD,
							18));
					frm.add(lab31);

					lab32.setText("α");
					lab32.setBackground(Color.white);
					lab32.setAlignmentX(Label.CENTER);
					lab32.setForeground(Color.blue);
					lab32.setLocation(50, 540); // �]�w���Ҧ�m
					lab32.setSize(650, 20); // �]�w���Ҥj�p
					lab32.setFont(new Font("Serief", Font.ITALIC + Font.BOLD,
							18));
					frm.add(lab32);

					Algorithm_Carpool.FA_PSO_AB_2Si_ApproachI.PSO_Read_Write_txt c2 = new Algorithm_Carpool.FA_PSO_AB_2Si_ApproachI.PSO_Read_Write_txt();
					c2.read_PSO_Parameter();
					txf36.setText(String.valueOf(c2.Iteration()));
					txf37.setText(String.valueOf(c2.Iteration_Mode()));
					txf1.setText(String.valueOf(c2.populationSize()));
					txf2.setText(String.valueOf(c2.w()));
					txf3.setText(String.valueOf(c2.c1()));
					txf4.setText(String.valueOf(c2.c2()));
					txf5.setText(String.valueOf(c2.Vmax()));
					txf6.setText(String.valueOf(c2.Execution_Mode()));
					txf7.setText(String.valueOf(c2.Print_Mode()));
					txf35.setText(String.valueOf(c2.Write_Mode()));
					txf8.setText(String.valueOf(String.valueOf(new BigDecimal(
							String.valueOf(c2.threshold())).toPlainString())));
					txf24.setText(String.valueOf(c2.B0()));
					txf33.setText(String.valueOf(c2.Gamma()));
					txf34.setText(String.valueOf(c2.Alpha()));

					txf24.setBounds(250, 460, 150, 20);
					txf33.setBounds(250, 500, 150, 20);
					txf34.setBounds(250, 540, 150, 20);

					frm.add(txf24);
					frm.add(txf33);
					frm.add(txf34);
				}
				if (Algorithm.equals("FA_PSO_AB_2Si_ApproachII")) {

					lab19.setText("β0");
					lab19.setBackground(Color.white);
					lab19.setAlignmentX(Label.CENTER);
					lab19.setForeground(Color.blue);
					lab19.setLocation(50, 460); // �]�w���Ҧ�m
					lab19.setSize(250, 20); // �]�w���Ҥj�p
					lab19.setFont(new Font("Serief", Font.ITALIC + Font.BOLD,
							18));
					frm.add(lab19);

					lab31.setText("γ");
					lab31.setBackground(Color.white);
					lab31.setAlignmentX(Label.CENTER);
					lab31.setForeground(Color.blue);
					lab31.setLocation(50, 500); // �]�w���Ҧ�m
					lab31.setSize(650, 20); // �]�w���Ҥj�p
					lab31.setFont(new Font("Serief", Font.ITALIC + Font.BOLD,
							18));
					frm.add(lab31);

					lab32.setText("α");
					lab32.setBackground(Color.white);
					lab32.setAlignmentX(Label.CENTER);
					lab32.setForeground(Color.blue);
					lab32.setLocation(50, 540); // �]�w���Ҧ�m
					lab32.setSize(650, 20); // �]�w���Ҥj�p
					lab32.setFont(new Font("Serief", Font.ITALIC + Font.BOLD,
							18));
					frm.add(lab32);

					Algorithm_Carpool.FA_PSO_AB_2Si_ApproachII.PSO_Read_Write_txt c2 = new Algorithm_Carpool.FA_PSO_AB_2Si_ApproachII.PSO_Read_Write_txt();
					c2.read_PSO_Parameter();
					txf36.setText(String.valueOf(c2.Iteration()));
					txf37.setText(String.valueOf(c2.Iteration_Mode()));
					txf1.setText(String.valueOf(c2.populationSize()));
					txf2.setText(String.valueOf(c2.w()));
					txf3.setText(String.valueOf(c2.c1()));
					txf4.setText(String.valueOf(c2.c2()));
					txf5.setText(String.valueOf(c2.Vmax()));
					txf6.setText(String.valueOf(c2.Execution_Mode()));
					txf7.setText(String.valueOf(c2.Print_Mode()));
					txf35.setText(String.valueOf(c2.Write_Mode()));
					txf8.setText(String.valueOf(String.valueOf(new BigDecimal(
							String.valueOf(c2.threshold())).toPlainString())));
					txf24.setText(String.valueOf(c2.B0()));
					txf33.setText(String.valueOf(c2.Gamma()));
					txf34.setText(String.valueOf(c2.Alpha()));

					txf24.setBounds(250, 460, 150, 20);
					txf33.setBounds(250, 500, 150, 20);
					txf34.setBounds(250, 540, 150, 20);

					frm.add(txf24);
					frm.add(txf33);
					frm.add(txf34);
				}
		
				if (Algorithm.equals("FA_AB_NNH")) {

					lab19.setText("β0");
					lab19.setBackground(Color.white);
					lab19.setAlignmentX(Label.CENTER);
					lab19.setForeground(Color.blue);
					lab19.setLocation(50, 140); // 
					lab19.setSize(250, 20); //
					lab19.setFont(new Font("Serief", Font.ITALIC + Font.BOLD,
							18));
					frm.add(lab19);

					lab31.setText("γ");
					lab31.setBackground(Color.white);
					lab31.setAlignmentX(Label.CENTER);
					lab31.setForeground(Color.blue);
					lab31.setLocation(50, 180); // 
					lab31.setSize(250, 20); //
					lab31.setFont(new Font("Serief", Font.ITALIC + Font.BOLD,
							18));
					frm.add(lab31);

					lab32.setText("α");
					lab32.setBackground(Color.white);
					lab32.setAlignmentX(Label.CENTER);
					lab32.setForeground(Color.blue);
					lab32.setLocation(50, 220); // �]�w���Ҧ�m
					lab32.setSize(250, 20); // �]�w���Ҥj�p
					lab32.setFont(new Font("Serief", Font.ITALIC + Font.BOLD,
							18));
					frm.add(lab32);

					lab45.setText("Vmax");
					lab45.setBackground(Color.white);
					lab45.setAlignmentX(Label.CENTER);
					lab45.setForeground(Color.blue);
					lab45.setLocation(50, 460); // �]�w���Ҧ�m
					lab45.setSize(250, 20); // �]�w���Ҥj�p
					lab45.setFont(new Font("Serief", Font.ITALIC + Font.BOLD,
							18));
					frm.add(lab45);
					
					Algorithm_Carpool.FA_AB_NNH.PSO_Read_Write_txt c2 = new Algorithm_Carpool.FA_AB_NNH.PSO_Read_Write_txt();
					c2.read_PSO_Parameter();
					
					txf36.setText(String.valueOf(c2.Iteration()));
					txf37.setText(String.valueOf(c2.Iteration_Mode()));
					txf1.setText(String.valueOf(c2.populationSize()));
					txf24.setText(String.valueOf(c2.B0()));
					txf33.setText(String.valueOf(c2.Gamma()));
					txf34.setText(String.valueOf(c2.Alpha()));
				//	txf5.setText(String.valueOf(c2.Vmax()));
					txf6.setText(String.valueOf(c2.Execution_Mode()));
					txf7.setText(String.valueOf(c2.Print_Mode()));
					txf35.setText(String.valueOf(c2.Write_Mode()));
					txf8.setText(String.valueOf(String.valueOf(new BigDecimal(
							String.valueOf(c2.threshold())).toPlainString())));
					
					txf41.setText(String.valueOf(c2.Vmax()));
					
					txf24.setBounds(250, 140, 150, 20);
					txf33.setBounds(250, 180, 150, 20);
					txf34.setBounds(250, 220, 150, 20);
					txf41.setBounds(250, 460, 150, 20);
					frm.remove(txf2);
					frm.remove(txf3);
					frm.remove(txf4);
					frm.remove(txf5);
					frm.remove(lab2);
					frm.remove(lab3);
					frm.remove(lab4);
					frm.remove(lab5);
					frm.add(txf24);
					frm.add(txf33);
					frm.add(txf34);
					frm.add(txf41);
				}
				if (Algorithm.equals("FA_AB_2Si_ApproachI")) {

					lab19.setText("β0");
					lab19.setBackground(Color.white);
					lab19.setAlignmentX(Label.CENTER);
					lab19.setForeground(Color.blue);
					lab19.setLocation(50, 140); // 
					lab19.setSize(250, 20); //
					lab19.setFont(new Font("Serief", Font.ITALIC + Font.BOLD,
							18));
					frm.add(lab19);

					lab31.setText("γ");
					lab31.setBackground(Color.white);
					lab31.setAlignmentX(Label.CENTER);
					lab31.setForeground(Color.blue);
					lab31.setLocation(50, 180); // 
					lab31.setSize(250, 20); //
					lab31.setFont(new Font("Serief", Font.ITALIC + Font.BOLD,
							18));
					frm.add(lab31);

					lab32.setText("α");
					lab32.setBackground(Color.white);
					lab32.setAlignmentX(Label.CENTER);
					lab32.setForeground(Color.blue);
					lab32.setLocation(50, 220); // �]�w���Ҧ�m
					lab32.setSize(250, 20); // �]�w���Ҥj�p
					lab32.setFont(new Font("Serief", Font.ITALIC + Font.BOLD,
							18));
					frm.add(lab32);

					lab45.setText("Vmax");
					lab45.setBackground(Color.white);
					lab45.setAlignmentX(Label.CENTER);
					lab45.setForeground(Color.blue);
					lab45.setLocation(50, 460); // �]�w���Ҧ�m
					lab45.setSize(250, 20); // �]�w���Ҥj�p
					lab45.setFont(new Font("Serief", Font.ITALIC + Font.BOLD,
							18));
					frm.add(lab45);
					
					Algorithm_Carpool.FA_AB_2Si_ApproachI.PSO_Read_Write_txt c2 = new Algorithm_Carpool.FA_AB_2Si_ApproachI.PSO_Read_Write_txt();
					c2.read_PSO_Parameter();
					
					txf36.setText(String.valueOf(c2.Iteration()));
					txf37.setText(String.valueOf(c2.Iteration_Mode()));
					txf1.setText(String.valueOf(c2.populationSize()));
					txf24.setText(String.valueOf(c2.B0()));
					txf33.setText(String.valueOf(c2.Gamma()));
					txf34.setText(String.valueOf(c2.Alpha()));
				//	txf5.setText(String.valueOf(c2.Vmax()));
					txf6.setText(String.valueOf(c2.Execution_Mode()));
					txf7.setText(String.valueOf(c2.Print_Mode()));
					txf35.setText(String.valueOf(c2.Write_Mode()));
					txf8.setText(String.valueOf(String.valueOf(new BigDecimal(
							String.valueOf(c2.threshold())).toPlainString())));
					
					txf41.setText(String.valueOf(c2.Vmax()));
					
					txf24.setBounds(250, 140, 150, 20);
					txf33.setBounds(250, 180, 150, 20);
					txf34.setBounds(250, 220, 150, 20);
					txf41.setBounds(250, 460, 150, 20);
					frm.remove(txf2);
					frm.remove(txf3);
					frm.remove(txf4);
					frm.remove(txf5);
					frm.remove(lab2);
					frm.remove(lab3);
					frm.remove(lab4);
					frm.remove(lab5);
					frm.add(txf24);
					frm.add(txf33);
					frm.add(txf34);
					frm.add(txf41);
				}
				if (Algorithm.equals("FA_AB_2Si_ApproachII")) {

					lab19.setText("β0");
					lab19.setBackground(Color.white);
					lab19.setAlignmentX(Label.CENTER);
					lab19.setForeground(Color.blue);
					lab19.setLocation(50, 140); // 
					lab19.setSize(250, 20); //
					lab19.setFont(new Font("Serief", Font.ITALIC + Font.BOLD,
							18));
					frm.add(lab19);

					lab31.setText("γ");
					lab31.setBackground(Color.white);
					lab31.setAlignmentX(Label.CENTER);
					lab31.setForeground(Color.blue);
					lab31.setLocation(50, 180); // 
					lab31.setSize(250, 20); //
					lab31.setFont(new Font("Serief", Font.ITALIC + Font.BOLD,
							18));
					frm.add(lab31);

					lab32.setText("α");
					lab32.setBackground(Color.white);
					lab32.setAlignmentX(Label.CENTER);
					lab32.setForeground(Color.blue);
					lab32.setLocation(50, 220); // �]�w���Ҧ�m
					lab32.setSize(250, 20); // �]�w���Ҥj�p
					lab32.setFont(new Font("Serief", Font.ITALIC + Font.BOLD,
							18));
					frm.add(lab32);

					lab45.setText("Vmax");
					lab45.setBackground(Color.white);
					lab45.setAlignmentX(Label.CENTER);
					lab45.setForeground(Color.blue);
					lab45.setLocation(50, 460); // �]�w���Ҧ�m
					lab45.setSize(250, 20); // �]�w���Ҥj�p
					lab45.setFont(new Font("Serief", Font.ITALIC + Font.BOLD,
							18));
					frm.add(lab45);
					
					Algorithm_Carpool.FA_AB_2Si_ApproachII.PSO_Read_Write_txt c2 = new Algorithm_Carpool.FA_AB_2Si_ApproachII.PSO_Read_Write_txt();
					c2.read_PSO_Parameter();
					
					txf36.setText(String.valueOf(c2.Iteration()));
					txf37.setText(String.valueOf(c2.Iteration_Mode()));
					txf1.setText(String.valueOf(c2.populationSize()));
					txf24.setText(String.valueOf(c2.B0()));
					txf33.setText(String.valueOf(c2.Gamma()));
					txf34.setText(String.valueOf(c2.Alpha()));
				//	txf5.setText(String.valueOf(c2.Vmax()));
					txf6.setText(String.valueOf(c2.Execution_Mode()));
					txf7.setText(String.valueOf(c2.Print_Mode()));
					txf35.setText(String.valueOf(c2.Write_Mode()));
					txf8.setText(String.valueOf(String.valueOf(new BigDecimal(
							String.valueOf(c2.threshold())).toPlainString())));
					
					txf41.setText(String.valueOf(c2.Vmax()));
					
					txf24.setBounds(250, 140, 150, 20);
					txf33.setBounds(250, 180, 150, 20);
					txf34.setBounds(250, 220, 150, 20);
					txf41.setBounds(250, 460, 150, 20);
					frm.remove(txf2);
					frm.remove(txf3);
					frm.remove(txf4);
					frm.remove(txf5);
					frm.remove(lab2);
					frm.remove(lab3);
					frm.remove(lab4);
					frm.remove(lab5);
					frm.add(txf24);
					frm.add(txf33);
					frm.add(txf34);
					frm.add(txf41);
				}
				txf36.setBounds(250, 20, 150, 20);
				txf37.setBounds(250, 60, 150, 20);
				txf1.setBounds(250, 100, 150, 20);
				txf2.setBounds(250, 140, 150, 20);
				txf3.setBounds(250, 180, 150, 20);
				txf4.setBounds(250, 220, 150, 20);
				txf5.setBounds(250, 260, 150, 20);
				txf6.setBounds(250, 300, 150, 20);
				txf7.setBounds(250,340, 150, 20);
				txf35.setBounds(250, 380, 150, 20);
				txf8.setBounds(250, 420, 150, 20);
				frm.add(txf36);
				frm.add(txf37);
				frm.add(txf1);
				frm.add(txf2);
				frm.add(txf3);
				frm.add(txf4);
				frm.add(txf5);
				frm.add(txf6);
				frm.add(txf7);
				frm.add(txf35);
				frm.add(txf8);

			frm.remove(lab9);
			frm.remove(lab10);
			frm.remove(lab11);
			frm.remove(txf9);
			frm.remove(txf10);
			frm.remove(txf11);
		}
		
		if (Algorithm.equals("DynDE_AB_NNH") || Algorithm.equals("DynDE_AB_2Si_ApproachI") || Algorithm.equals("DynDE_AB_2Si_ApproachII")) {

			lab18.setText("Iteration");
			lab18.setBackground(Color.white);
			lab18.setAlignmentX(Label.CENTER);
			lab18.setForeground(Color.blue);
			lab18.setLocation(50, 160); // �]�w���Ҧ�m
			lab18.setSize(250, 20); // �]�w���Ҥj�p
			lab18.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab18);

			lab37.setText("Iteration_Mode");
			lab37.setBackground(Color.white);
			lab37.setAlignmentX(Label.CENTER);
			lab37.setForeground(Color.blue);
			lab37.setLocation(50, 200); // �]�w���Ҧ�m
			lab37.setSize(300, 20); // �]�w���Ҥj�p
			lab37.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab37);

			lab38.setText("0執行參數設定,1執行內定函式");
			lab38.setBackground(Color.white);
			lab38.setAlignmentX(Label.CENTER);
			lab38.setForeground(Color.blue);
			lab38.setLocation(510, 200); // �]�w���Ҧ�m
			lab38.setSize(300, 20); // �]�w���Ҥj�p
			lab38.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab38);

			lab19.setText("NP");
			lab19.setBackground(Color.white);
			lab19.setAlignmentX(Label.CENTER);
			lab19.setForeground(Color.blue);
			lab19.setLocation(50, 240); // �]�w���Ҧ�m
			lab19.setSize(250, 20); // �]�w���Ҥj�p
			lab19.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab19);

			lab31.setText("LP");
			lab31.setBackground(Color.white);
			lab31.setAlignmentX(Label.CENTER);
			lab31.setForeground(Color.blue);
			lab31.setLocation(50, 280); // �]�w���Ҧ�m
			lab31.setSize(250, 20); // �]�w���Ҥj�p
			lab31.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab31);

			lab32.setText("ε");
			lab32.setBackground(Color.white);
			lab32.setAlignmentX(Label.CENTER);
			lab32.setForeground(Color.blue);
			lab32.setLocation(50, 320); // �]�w���Ҧ�m
			lab32.setSize(250, 20); // �]�w���Ҥj�p
			lab32.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab32);

			lab33.setText("Execution_Mode");
			lab33.setBackground(Color.white);
			lab33.setAlignmentX(Label.CENTER);
			lab33.setForeground(Color.blue);
			lab33.setLocation(50, 360); // �]�w���Ҧ�m
			lab33.setSize(250, 20); // �]�w���Ҥj�p
			lab33.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab33);

			lab6.setText("Write_Mode");
			lab6.setBackground(Color.white);
			lab6.setAlignmentX(Label.CENTER);
			lab6.setForeground(Color.blue);
			lab6.setLocation(50, 400); // �]�w���Ҧ�m
			lab6.setSize(250, 20); // �]�w���Ҥj�p
			lab6.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab6);
			
			
			txf23.setBounds(250, 160, 150, 20);
			txf37.setBounds(250, 200, 150, 20);
			txf24.setBounds(250, 240, 150, 20);
			txf33.setBounds(250, 280, 150, 20);
			txf34.setBounds(250, 320, 150, 20);
			txf6.setBounds(250, 360, 150, 20);
			txf7.setBounds(250, 400, 150, 20);
			frm.add(txf23);
			frm.add(txf37);
			frm.add(txf24);
			frm.add(txf33);
			frm.add(txf34);
			frm.add(txf6);
			frm.add(txf7);
			
			if(Algorithm.equals("DynDE_AB_NNH")){
				
				Algorithm_Carpool.DynDE_AB_NNH.DE_Read_Write_txt c1=new Algorithm_Carpool.DynDE_AB_NNH.DE_Read_Write_txt();
				c1.Read_NSDE_Parameter();
				txf23.setText(String.valueOf(c1.Iteration()));
				txf37.setText(String.valueOf(c1.Iteration_Mode()));
				txf24.setText(String.valueOf(c1.NP()));
		//		txf33.setText(String.valueOf(c1.LP()));
				 
				txf6.setText(String.valueOf(c1.Execution_Mode()));
				txf7.setText(String.valueOf(c1.write_Mode()));
				txf8.setText(String.valueOf(c1.Vmax()));
				txf9.setText(String.valueOf(c1.lamda()));
				txf10.setText(String.valueOf(c1.rcloud()));
				txf11.setText(String.valueOf(c1.Sigma()));
				lab34.setText("Vmax");
				lab34.setBackground(Color.white);
				lab34.setAlignmentX(Label.CENTER);
				lab34.setForeground(Color.blue);
				lab34.setLocation(50, 440); // �]�w���Ҧ�m
				lab34.setSize(250, 20); // �]�w���Ҥj�p
				lab34.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
				frm.add(lab34);

				lab35.setText("lamda");
				lab35.setBackground(Color.white);
				lab35.setAlignmentX(Label.CENTER);
				lab35.setForeground(Color.blue);
				lab35.setLocation(50, 480); // �]�w���Ҧ�m
				lab35.setSize(250, 20); // �]�w���Ҥj�p
				lab35.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
				frm.add(lab35);
				
				lab41.setText("rcloud");
				lab41.setBackground(Color.white);
				lab41.setAlignmentX(Label.CENTER);
				lab41.setForeground(Color.blue);
				lab41.setLocation(50, 520); // �]�w���Ҧ�m
				lab41.setSize(250, 20); // �]�w���Ҥj�p
				lab41.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
				frm.add(lab41);
				lab42.setText("σ");
				lab42.setBackground(Color.white);
				lab42.setAlignmentX(Label.CENTER);
				lab42.setForeground(Color.blue);
				lab42.setLocation(50, 560); // �]�w���Ҧ�m
				lab42.setSize(250, 20); // �]�w���Ҥj�p
				lab42.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
				frm.add(lab42);
				
				txf8.setBounds(250, 440, 150, 20);
				txf9.setBounds(250, 480, 150, 20);
				txf10.setBounds(250, 520, 150, 20);
				txf11.setBounds(250, 560, 150, 20);
				frm.add(txf8);
				frm.add(txf9);
				frm.add(txf10);
				frm.add(txf11);
				frm.remove(lab32);
			//	frm.remove(lab33);
				frm.remove(txf34);
				frm.remove(txf33);
				frm.remove(lab31);
			}
			if(Algorithm.equals("DynDE_AB_2Si_ApproachI")){
				
				Algorithm_Carpool.DynDE_AB_2Si_ApproachI.DE_Read_Write_txt c1=new Algorithm_Carpool.DynDE_AB_2Si_ApproachI.DE_Read_Write_txt();
				c1.Read_NSDE_Parameter();
				txf23.setText(String.valueOf(c1.Iteration()));
				txf37.setText(String.valueOf(c1.Iteration_Mode()));
				txf24.setText(String.valueOf(c1.NP()));
		//		txf33.setText(String.valueOf(c1.LP()));
				 
				txf6.setText(String.valueOf(c1.Execution_Mode()));
				txf7.setText(String.valueOf(c1.write_Mode()));
				txf8.setText(String.valueOf(c1.Vmax()));
				txf9.setText(String.valueOf(c1.lamda()));
				txf10.setText(String.valueOf(c1.rcloud()));
				txf11.setText(String.valueOf(c1.Sigma()));
				lab34.setText("Vmax");
				lab34.setBackground(Color.white);
				lab34.setAlignmentX(Label.CENTER);
				lab34.setForeground(Color.blue);
				lab34.setLocation(50, 440); // �]�w���Ҧ�m
				lab34.setSize(250, 20); // �]�w���Ҥj�p
				lab34.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
				frm.add(lab34);

				lab35.setText("lamda");
				lab35.setBackground(Color.white);
				lab35.setAlignmentX(Label.CENTER);
				lab35.setForeground(Color.blue);
				lab35.setLocation(50, 480); // �]�w���Ҧ�m
				lab35.setSize(250, 20); // �]�w���Ҥj�p
				lab35.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
				frm.add(lab35);
				
				lab41.setText("rcloud");
				lab41.setBackground(Color.white);
				lab41.setAlignmentX(Label.CENTER);
				lab41.setForeground(Color.blue);
				lab41.setLocation(50, 520); // �]�w���Ҧ�m
				lab41.setSize(250, 20); // �]�w���Ҥj�p
				lab41.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
				frm.add(lab41);
				lab42.setText("σ");
				lab42.setBackground(Color.white);
				lab42.setAlignmentX(Label.CENTER);
				lab42.setForeground(Color.blue);
				lab42.setLocation(50, 560); // �]�w���Ҧ�m
				lab42.setSize(250, 20); // �]�w���Ҥj�p
				lab42.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
				frm.add(lab42);
				
				txf8.setBounds(250, 440, 150, 20);
				txf9.setBounds(250, 480, 150, 20);
				txf10.setBounds(250, 520, 150, 20);
				txf11.setBounds(250, 560, 150, 20);
				frm.add(txf8);
				frm.add(txf9);
				frm.add(txf10);
				frm.add(txf11);
				frm.remove(lab32);
			//	frm.remove(lab33);
				frm.remove(txf34);
				frm.remove(txf33);
				frm.remove(lab31);
			}
	if(Algorithm.equals("DynDE_AB_2Si_ApproachII")){
		
		Algorithm_Carpool.DynDE_AB_2Si_ApproachII.DE_Read_Write_txt c1=new Algorithm_Carpool.DynDE_AB_2Si_ApproachII.DE_Read_Write_txt();
		c1.Read_NSDE_Parameter();
		txf23.setText(String.valueOf(c1.Iteration()));
		txf37.setText(String.valueOf(c1.Iteration_Mode()));
		txf24.setText(String.valueOf(c1.NP()));
//		txf33.setText(String.valueOf(c1.LP()));
		 
		txf6.setText(String.valueOf(c1.Execution_Mode()));
		txf7.setText(String.valueOf(c1.write_Mode()));
		txf8.setText(String.valueOf(c1.Vmax()));
		txf9.setText(String.valueOf(c1.lamda()));
		txf10.setText(String.valueOf(c1.rcloud()));
		txf11.setText(String.valueOf(c1.Sigma()));
		lab34.setText("Vmax");
		lab34.setBackground(Color.white);
		lab34.setAlignmentX(Label.CENTER);
		lab34.setForeground(Color.blue);
		lab34.setLocation(50, 440); // �]�w���Ҧ�m
		lab34.setSize(250, 20); // �]�w���Ҥj�p
		lab34.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
		frm.add(lab34);

		lab35.setText("lamda");
		lab35.setBackground(Color.white);
		lab35.setAlignmentX(Label.CENTER);
		lab35.setForeground(Color.blue);
		lab35.setLocation(50, 480); // �]�w���Ҧ�m
		lab35.setSize(250, 20); // �]�w���Ҥj�p
		lab35.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
		frm.add(lab35);
		
		lab41.setText("rcloud");
		lab41.setBackground(Color.white);
		lab41.setAlignmentX(Label.CENTER);
		lab41.setForeground(Color.blue);
		lab41.setLocation(50, 520); // �]�w���Ҧ�m
		lab41.setSize(250, 20); // �]�w���Ҥj�p
		lab41.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
		frm.add(lab41);
		lab42.setText("σ");
		lab42.setBackground(Color.white);
		lab42.setAlignmentX(Label.CENTER);
		lab42.setForeground(Color.blue);
		lab42.setLocation(50, 560); // �]�w���Ҧ�m
		lab42.setSize(250, 20); // �]�w���Ҥj�p
		lab42.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
		frm.add(lab42);
		
		txf8.setBounds(250, 440, 150, 20);
		txf9.setBounds(250, 480, 150, 20);
		txf10.setBounds(250, 520, 150, 20);
		txf11.setBounds(250, 560, 150, 20);
		frm.add(txf8);
		frm.add(txf9);
		frm.add(txf10);
		frm.add(txf11);
		frm.remove(lab32);
	//	frm.remove(lab33);
		frm.remove(txf34);
		frm.remove(txf33);
		frm.remove(lab31);
	}
		}
		
		btn1.setBounds(580, 10, 80, 40);
		btn1.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));

		btn2.setBounds(680, 10, 80, 40);
		btn2.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));

		frm.add(btn1);
		btn1.addActionListener(this);
		frm.add(btn2);
		btn2.addActionListener(this);
		frm.setVisible(true);
	}

	public static void main() {
		new Set_Parameters_for_the_Selected_Algorithm_for_Carpool2();
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(btn1)) {
			
			if (Algorithm.equals("DynDE_AB_NNH")) {
				try {
					Write_Parameter_for_Carpool.saveDynDE_AB_NNH(
							Integer.parseInt(txf23.getText()),
							Integer.parseInt(txf37.getText()),
							Integer.parseInt(txf24.getText()),
						//	Integer.parseInt(txf33.getText()),
						
							Integer.parseInt(txf6.getText()),
							Integer.parseInt(txf7.getText()),
							Integer.parseInt(txf8.getText()),
							Double.parseDouble(txf9.getText()),
							Double.parseDouble(txf10.getText()),
							Double.parseDouble(txf11.getText())
							);
				} catch (NumberFormatException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("DynDE_AB_2Si_ApproachI")) {
				try {
					Write_Parameter_for_Carpool.saveDynDE_AB_2Si_ApproachI(
							Integer.parseInt(txf23.getText()),
							Integer.parseInt(txf37.getText()),
							Integer.parseInt(txf24.getText()),
						//	Integer.parseInt(txf33.getText()),
						
							Integer.parseInt(txf6.getText()),
							Integer.parseInt(txf7.getText()),
							Integer.parseInt(txf8.getText()),
							Double.parseDouble(txf9.getText()),
							Double.parseDouble(txf10.getText()),
							Double.parseDouble(txf11.getText())
							);
				} catch (NumberFormatException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("DynDE_AB_2Si_ApproachII")) {
				try {
					Write_Parameter_for_Carpool.saveDynDE_AB_2Si_ApproachII(
							Integer.parseInt(txf23.getText()),
							Integer.parseInt(txf37.getText()),
							Integer.parseInt(txf24.getText()),
						//	Integer.parseInt(txf33.getText()),
						
							Integer.parseInt(txf6.getText()),
							Integer.parseInt(txf7.getText()),
							Integer.parseInt(txf8.getText()),
							Double.parseDouble(txf9.getText()),
							Double.parseDouble(txf10.getText()),
							Double.parseDouble(txf11.getText())
							);
				} catch (NumberFormatException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			if (Algorithm.equals("FA_PSO_AB_NNH")) {
				try {
					Write_Parameter_for_Carpool.saveFA_PSO_AB_NNH(
							Integer.parseInt(txf36.getText()),
							Integer.parseInt(txf37.getText()),
							Integer.parseInt(txf1.getText()),
							Double.parseDouble(txf2.getText()),
							Double.parseDouble(txf3.getText()),
							Double.parseDouble(txf4.getText()),
							Integer.parseInt(txf5.getText()),
							Integer.parseInt(txf6.getText()),
							Integer.parseInt(txf7.getText()),
							Integer.parseInt(txf35.getText()),
							Double.parseDouble(txf8.getText()),
							Double.parseDouble(txf24.getText()),
							Double.parseDouble(txf33.getText()),
							Double.parseDouble(txf34.getText()));
				} catch (NumberFormatException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}}
			if (Algorithm.equals("FA_PSO_AB_2Si_ApproachI")) {
				try {
					Write_Parameter_for_Carpool.saveFA_PSO_AB_2Si_ApproachI(
							Integer.parseInt(txf36.getText()),
							Integer.parseInt(txf37.getText()),
							Integer.parseInt(txf1.getText()),
							Double.parseDouble(txf2.getText()),
							Double.parseDouble(txf3.getText()),
							Double.parseDouble(txf4.getText()),
							Integer.parseInt(txf5.getText()),
							Integer.parseInt(txf6.getText()),
							Integer.parseInt(txf7.getText()),
							Integer.parseInt(txf35.getText()),
							Double.parseDouble(txf8.getText()),
							Double.parseDouble(txf24.getText()),
							Double.parseDouble(txf33.getText()),
							Double.parseDouble(txf34.getText()));
				} catch (NumberFormatException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}}
			if (Algorithm.equals("FA_PSO_AB_2Si_ApproachII")) {
				try {
					Write_Parameter_for_Carpool.saveFA_PSO_AB_2Si_ApproachII(
							Integer.parseInt(txf36.getText()),
							Integer.parseInt(txf37.getText()),
							Integer.parseInt(txf1.getText()),
							Double.parseDouble(txf2.getText()),
							Double.parseDouble(txf3.getText()),
							Double.parseDouble(txf4.getText()),
							Integer.parseInt(txf5.getText()),
							Integer.parseInt(txf6.getText()),
							Integer.parseInt(txf7.getText()),
							Integer.parseInt(txf35.getText()),
							Double.parseDouble(txf8.getText()),
							Double.parseDouble(txf24.getText()),
							Double.parseDouble(txf33.getText()),
							Double.parseDouble(txf34.getText()));
				} catch (NumberFormatException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}}
			
			if (Algorithm.equals("FA_AB_NNH")) {
				try {
					Write_Parameter_for_Carpool.saveFA_AB_NNH(
							Integer.parseInt(txf36.getText()),
							Integer.parseInt(txf37.getText()),
							Integer.parseInt(txf1.getText()),
					/*		Double.parseDouble(txf2.getText()),
							Double.parseDouble(txf3.getText()),
							Double.parseDouble(txf4.getText()),
							Integer.parseInt(txf5.getText()),*/
							Integer.parseInt(txf6.getText()),
							Integer.parseInt(txf7.getText()),
							Integer.parseInt(txf35.getText()),
							Double.parseDouble(txf8.getText()),
							Double.parseDouble(txf24.getText()),
							Double.parseDouble(txf33.getText()),
							Double.parseDouble(txf34.getText()),
							Double.parseDouble(txf41.getText())
							);
				} catch (NumberFormatException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("FA_AB_2Si_ApproachI")) {
				try {
					Write_Parameter_for_Carpool.saveFA_AB_2Si_ApproachI(
							Integer.parseInt(txf36.getText()),
							Integer.parseInt(txf37.getText()),
							Integer.parseInt(txf1.getText()),
					/*		Double.parseDouble(txf2.getText()),
							Double.parseDouble(txf3.getText()),
							Double.parseDouble(txf4.getText()),
							Integer.parseInt(txf5.getText()),*/
							Integer.parseInt(txf6.getText()),
							Integer.parseInt(txf7.getText()),
							Integer.parseInt(txf35.getText()),
							Double.parseDouble(txf8.getText()),
							Double.parseDouble(txf24.getText()),
							Double.parseDouble(txf33.getText()),
							Double.parseDouble(txf34.getText()),
							Double.parseDouble(txf41.getText())
							);
				} catch (NumberFormatException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("FA_AB_2Si_ApproachII")) {
				try {
					Write_Parameter_for_Carpool.saveFA_AB_2Si_ApproachII(
							Integer.parseInt(txf36.getText()),
							Integer.parseInt(txf37.getText()),
							Integer.parseInt(txf1.getText()),
					/*		Double.parseDouble(txf2.getText()),
							Double.parseDouble(txf3.getText()),
							Double.parseDouble(txf4.getText()),
							Integer.parseInt(txf5.getText()),*/
							Integer.parseInt(txf6.getText()),
							Integer.parseInt(txf7.getText()),
							Integer.parseInt(txf35.getText()),
							Double.parseDouble(txf8.getText()),
							Double.parseDouble(txf24.getText()),
							Double.parseDouble(txf33.getText()),
							Double.parseDouble(txf34.getText()),
							Double.parseDouble(txf41.getText())
							);
				} catch (NumberFormatException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		frm.setVisible(false);
	}
}
