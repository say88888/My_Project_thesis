package GUI.GUI_Tourism;

import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.math.BigDecimal;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Input_Output_txt.Read_ALPSO_Parameter;
import Input_Output_txt.Read_LRPSO_Parameter;
import Input_Output_txt.Read_LR_Parameter;
import Input_Output_txt.Read_LR_and_PSO1_Parameter;
import Input_Output_txt.Read_LR_and_PSO2_Parameter;
import Input_Output_txt.Read_TS_Parameter;
import Input_Output_txt.Tourism.Read_Adaptive;
import Input_Output_txt.Tourism.Read_DE_Parameter;
import Input_Output_txt.Tourism.Write_Parameter_for_Tourism;

public class Set_Parameters_for_the_Selected_Algorithm_for_Tourism extends Tourism implements
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
	JTextField txf18 = new JTextField();
	JTextField txf19 = new JTextField();

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
	JLabel lab41= new JLabel();
	JLabel lab42 = new JLabel();
	JLabel lab43= new JLabel();
	JLabel lab44 = new JLabel();
	JButton btn1 = new JButton("OK");
	JButton btn2 = new JButton("Exit");

	
	Set_Parameters_for_the_Selected_Algorithm_for_Tourism() {

		frm.setSize(950, 850); // 設定視窗的大小為 200*150
		frm.setLocation(400, 10); // 設定視窗位置為(100,50)
		frm.setTitle("XI_Set_Parameters_for_the_Selected_Algorithm frm");
		frm.setLayout(null);

		if (Algorithm.equals("CPLEX")) {

			lab1.setText("CPLEX is not have,Thanks");
			lab1.setBackground(Color.white);
			lab1.setAlignmentX(Label.CENTER);
			lab1.setForeground(Color.blue);
			lab1.setLocation(300, 300); // �]�w���Ҧ�m
			lab1.setSize(250, 20); // �]�w���Ҥj�p
			lab1.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab1);
		}

		if (Algorithm.equals("GA1") || Algorithm.equals("GA2")) {
			
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
			lab37.setSize(200, 20); // �]�w���Ҥj�p
			lab37.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab37);
			
			lab38.setText("0執行參數設定,1執行內定函式");
			lab38.setBackground(Color.white);
			lab38.setAlignmentX(Label.CENTER);
			lab38.setForeground(Color.blue);
			lab38.setLocation(410, 60); // �]�w���Ҧ�m
			lab38.setSize(300, 20); // �]�w���Ҥj�p
			lab38.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab38);
			
			lab1.setText("initialPopulationRate");
			lab1.setBackground(Color.white);
			lab1.setAlignmentX(Label.CENTER);
			lab1.setForeground(Color.blue);
			lab1.setLocation(50, 100); // �]�w���Ҧ�m
			lab1.setSize(200, 20); // �]�w���Ҥj�p
			lab1.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab1);

			lab2.setText("crossoverRate");
			lab2.setBackground(Color.white);
			lab2.setAlignmentX(Label.CENTER);
			lab2.setForeground(Color.blue);
			lab2.setLocation(50, 140); // �]�w���Ҧ�m
			lab2.setSize(200, 20); // �]�w���Ҥj�p
			lab2.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab2);

			lab3.setText("mutationRate");
			lab3.setBackground(Color.white);
			lab3.setAlignmentX(Label.CENTER);
			lab3.setForeground(Color.blue);
			lab3.setLocation(50, 180); // �]�w���Ҧ�m
			lab3.setSize(200, 20); // �]�w���Ҥj�p
			lab3.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab3);

			lab4.setText("tournamentSize");
			lab4.setBackground(Color.white);
			lab4.setAlignmentX(Label.CENTER);
			lab4.setForeground(Color.blue);
			lab4.setLocation(50, 220); // �]�w���Ҧ�m
			lab4.setSize(200, 20); // �]�w���Ҥj�p
			lab4.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab4);

			lab5.setText("populationSize");
			lab5.setBackground(Color.white);
			lab5.setAlignmentX(Label.CENTER);
			lab5.setForeground(Color.blue);
			lab5.setLocation(50, 260); // �]�w���Ҧ�m
			lab5.setSize(200, 20); // �]�w���Ҥj�p
			lab5.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab5);

			lab6.setText("threshold");
			lab6.setBackground(Color.white);
			lab6.setAlignmentX(Label.CENTER);
			lab6.setForeground(Color.blue);
			lab6.setLocation(50, 300); // �]�w���Ҧ�m
			lab6.setSize(200, 20); // �]�w���Ҥj�p
			lab6.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab6);

			lab7.setText("Execution_Mode");
			lab7.setBackground(Color.white);
			lab7.setAlignmentX(Label.CENTER);
			lab7.setForeground(Color.blue);
			lab7.setLocation(50, 340); // �]�w���Ҧ�m
			lab7.setSize(200, 20); // �]�w���Ҥj�p
			lab7.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab7);

			lab20.setText("0不重複執行,1重複上一次執行");
			lab20.setBackground(Color.white);
			lab20.setAlignmentX(Label.CENTER);
			lab20.setForeground(Color.blue);
			lab20.setLocation(410, 340); // �]�w���Ҧ�m
			lab20.setSize(300, 20); // �]�w���Ҥj�p
			lab20.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab20);

			lab8.setText("Print_Mode");
			lab8.setBackground(Color.white);
			lab8.setAlignmentX(Label.CENTER);
			lab8.setForeground(Color.blue);
			lab8.setLocation(50, 380); // �]�w���Ҧ�m
			lab8.setSize(200, 20); // �]�w���Ҥj�p
			lab8.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab8);

			lab21.setText("0不顯示執行過程,1顯示執行過程");
			lab21.setBackground(Color.white);
			lab21.setAlignmentX(Label.CENTER);
			lab21.setForeground(Color.blue);
			lab21.setLocation(410, 380); // �]�w���Ҧ�m
			lab21.setSize(300, 20); // �]�w���Ҥj�p
			lab21.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab21);

			lab9.setText("SA_Mode");
			lab9.setBackground(Color.white);
			lab9.setAlignmentX(Label.CENTER);
			lab9.setForeground(Color.blue);
			lab9.setLocation(50, 420); // �]�w���Ҧ�m
			lab9.setSize(250, 20); // �]�w���Ҥj�p
			lab9.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab9);

			lab22.setText("1是執行SA_Mode,0是不執行SA_Mode");
			lab22.setBackground(Color.white);
			lab22.setAlignmentX(Label.CENTER);
			lab22.setForeground(Color.blue);
			lab22.setLocation(410, 420); // �]�w���Ҧ�m
			lab22.setSize(300, 20); // �]�w���Ҥj�p
			lab22.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab22);

			lab23.setText("Write_Mode");
			lab23.setBackground(Color.white);
			lab23.setAlignmentX(Label.CENTER);
			lab23.setForeground(Color.blue);
			lab23.setLocation(50, 460); // �]�w���Ҧ�m
			lab23.setSize(200, 20); // �]�w���Ҥj�p
			lab23.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab23);
			
			lab24.setText("0是執行Write_Mode,1是不執行Write_Mode");
			lab24.setBackground(Color.white);
			lab24.setAlignmentX(Label.CENTER);
			lab24.setForeground(Color.blue);
			lab24.setLocation(410, 460); // �]�w���Ҧ�m
			lab24.setSize(300, 20); // �]�w���Ҥj�p
			lab24.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab24);
			
			lab10.setText("T");
			lab10.setBackground(Color.white);
			lab10.setAlignmentX(Label.CENTER);
			lab10.setForeground(Color.blue);
			lab10.setLocation(50, 500); // �]�w���Ҧ�m
			lab10.setSize(200, 20); // �]�w���Ҥj�p
			lab10.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab10);

			lab11.setText("Factor_T");
			lab11.setBackground(Color.white);
			lab11.setAlignmentX(Label.CENTER);
			lab11.setForeground(Color.blue);
			lab11.setLocation(50, 540); // �]�w���Ҧ�m
			lab11.setSize(200, 20); // �]�w���Ҥj�p
			lab11.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab11);

			lab15.setText("R1k");
			lab15.setBackground(Color.white);
			lab15.setAlignmentX(Label.CENTER);
			lab15.setForeground(Color.blue);
			lab15.setLocation(50, 580); // �]�w���Ҧ�m
			lab15.setSize(200, 20); // �]�w���Ҥj�p
			lab15.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab15);

			lab16.setText("R2k");
			lab16.setBackground(Color.white);
			lab16.setAlignmentX(Label.CENTER);
			lab16.setForeground(Color.blue);
			lab16.setLocation(50, 620); // �]�w���Ҧ�m
			lab16.setSize(200, 20); // �]�w���Ҥj�p
			lab16.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab16);

			lab17.setText("R3k");
			lab17.setBackground(Color.white);
			lab17.setAlignmentX(Label.CENTER);
			lab17.setForeground(Color.blue);
			lab17.setLocation(50, 660); // �]�w���Ҧ�m
			lab17.setSize(200, 20); // �]�w���Ҥj�p
			lab17.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab17);

			lab18.setText("R4");
			lab18.setBackground(Color.white);
			lab18.setAlignmentX(Label.CENTER);
			lab18.setForeground(Color.blue);
			lab18.setLocation(430, 540); // �]�w���Ҧ�m
			lab18.setSize(200, 20); // �]�w���Ҥj�p
			lab18.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab18);

			lab19.setText("R5ik");
			lab19.setBackground(Color.white);
			lab19.setAlignmentX(Label.CENTER);
			lab19.setForeground(Color.blue);
			lab19.setLocation(430, 580); // �]�w���Ҧ�m
			lab19.setSize(200, 20); // �]�w���Ҥj�p
			lab19.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab19);
			
			lab41.setText("R6im");
			lab41.setBackground(Color.white);
			lab41.setAlignmentX(Label.CENTER);
			lab41.setForeground(Color.blue);
			lab41.setLocation(430, 620); // �]�w���Ҧ�m
			lab41.setSize(200, 20); //]�w���Ҥj�p
			lab41.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab41);

			lab42.setText("R7it");
			lab42.setBackground(Color.white);
			lab42.setAlignmentX(Label.CENTER);
			lab42.setForeground(Color.blue);
			lab42.setLocation(430, 660); // �]�w���Ҧ�m
			lab42.setSize(200, 20); // �]�w���Ҥj�p
			lab42.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab42);
			
			if (Algorithm.equals("GA1")) {

				Algorithm_Tourism.GA1_Tourism.GA_Read_Write_txt c1 = new Algorithm_Tourism.GA1_Tourism.GA_Read_Write_txt();

				try {
					c1.read_GA_Parameters();

					txf36.setText(String.valueOf(c1.Iteration()));
					txf37.setText(String.valueOf(c1.Iteration_Mode()));
					txf1.setText(String.valueOf(c1.initialPopulationRate()));
					txf2.setText(String.valueOf(c1.crossoverRate()));
					txf3.setText(String.valueOf(c1.mutationRate()));
					txf4.setText(String.valueOf(c1.tournamentSize()));
					txf5.setText(String.valueOf(c1.populationSize()));
					txf6.setText(String.valueOf(String.valueOf(new BigDecimal(
							String.valueOf(c1.threshold())).toPlainString())));
					txf7.setText(String.valueOf(c1.Execution_Mode()));
					txf8.setText(String.valueOf(c1.Print_Mode()));
					txf9.setText(String.valueOf(c1.SA_Mode()));
					txf35.setText(String.valueOf(c1.Write_Mode()));
					txf10.setText(String.valueOf(c1.T()));
					txf11.setText(String.valueOf(c1.Factor_T()));

					txf20.setText(String.valueOf(c1.R1()));
					txf21.setText(String.valueOf(c1.R2()));
					txf22.setText(String.valueOf(c1.R3()));
					txf23.setText(String.valueOf(c1.R4()));
					txf24.setText(String.valueOf(c1.R5()));
					txf39.setText(String.valueOf(c1.R6()));
					txf40.setText(String.valueOf(c1.R7()));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				txf36.setBounds(250, 20, 150, 20);
				txf37.setBounds(250, 60, 150, 20);
				txf1.setBounds(250, 100, 150, 20);
				txf2.setBounds(250, 140, 150, 20);
				txf3.setBounds(250, 180, 150, 20);
				txf4.setBounds(250, 220, 150, 20);
				txf5.setBounds(250, 260, 150, 20);
				txf6.setBounds(250, 300, 150, 20);
				txf7.setBounds(250, 340, 150, 20);
				txf8.setBounds(250, 380, 150, 20);
				txf9.setBounds(250, 420, 150, 20);
				txf35.setBounds(250, 460, 150, 20);
				txf10.setBounds(250, 500, 150, 20);
				txf11.setBounds(250, 540, 150, 20);
				txf20.setBounds(250, 580, 150, 20);
				txf21.setBounds(250, 620, 150, 20);
				txf22.setBounds(250, 660, 150, 20);
				txf23.setBounds(510, 540, 150, 20);
				txf24.setBounds(510, 580, 150, 20);
				txf39.setBounds(510, 620, 150, 20);
				txf40.setBounds(510, 660, 150, 20);
				frm.add(txf36);
				frm.add(txf37);
				frm.add(txf1);
				frm.add(txf2);
				frm.add(txf3);
				frm.add(txf4);
				frm.add(txf5);
				frm.add(txf6);
				frm.add(txf7);
				frm.add(txf8);
				frm.add(txf9);
				frm.add(txf35);
				frm.add(txf10);
				frm.add(txf11);
				frm.add(txf20);
				frm.add(txf21);
				frm.add(txf22);
				frm.add(txf23);
				frm.add(txf24);
				frm.add(txf39);
				frm.add(txf40);
			} else {
				Algorithm_Tourism.GA2_Tourism.GA_Read_Write_txt c2 = new Algorithm_Tourism.GA2_Tourism.GA_Read_Write_txt();
				try {
					c2.read_GA_Parameters();
					txf36.setText(String.valueOf(c2.Iteration()));
					txf37.setText(String.valueOf(c2.Iteration_Mode()));
					txf1.setText(String.valueOf(c2.initialPopulationRate()));
					txf2.setText(String.valueOf(c2.crossoverRate()));
					txf3.setText(String.valueOf(c2.mutationRate()));
					txf4.setText(String.valueOf(c2.tournamentSize()));
					txf5.setText(String.valueOf(c2.populationSize()));
					txf6.setText(String.valueOf(String.valueOf(new BigDecimal(
							String.valueOf(c2.threshold())).toPlainString())));
					txf7.setText(String.valueOf(c2.Execution_Mode()));
					txf8.setText(String.valueOf(c2.Print_Mode()));
					txf9.setText(String.valueOf(c2.SA_Mode()));
					txf35.setText(String.valueOf(c2.Write_Mode()));
					txf10.setText(String.valueOf(c2.T()));
					txf11.setText(String.valueOf(c2.Factor_T()));

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				txf36.setBounds(250, 20, 150, 20);
				txf37.setBounds(250, 60, 150, 20);
				txf1.setBounds(250, 100, 150, 20);
				txf2.setBounds(250, 140, 150, 20);
				txf3.setBounds(250, 180, 150, 20);
				txf4.setBounds(250, 220, 150, 20);
				txf5.setBounds(250, 260, 150, 20);
				txf6.setBounds(250, 300, 150, 20);
				txf7.setBounds(250, 340, 150, 20);
				txf8.setBounds(250, 380, 150, 20);
				txf9.setBounds(250, 420, 150, 20);
				txf35.setBounds(250, 460, 150, 20);
				txf10.setBounds(250, 500, 150, 20);
				txf11.setBounds(250, 540, 150, 20);
				frm.add(txf36);
				frm.add(txf37);
				frm.add(txf1);
				frm.add(txf2);
				frm.add(txf3);
				frm.add(txf4);
				frm.add(txf5);
				frm.add(txf6);
				frm.add(txf7);
				frm.add(txf8);
				frm.add(txf9);
				frm.add(txf35);
				frm.add(txf10);
				frm.add(txf11);
				frm.remove(lab15);
				frm.remove(lab16);
				frm.remove(lab17);
				frm.remove(lab18);
				frm.remove(lab19);
				frm.remove(lab41);
				frm.remove(lab42);
			}
		}

		else if (Algorithm.equals("PSO1") || Algorithm.equals("PSO2") || Algorithm.equals("ALPSO")  || Algorithm.equals("ALPSO") 
				|| Algorithm.equals("ALPSO") || Algorithm.equals("LR_and_PSO1") 	|| Algorithm.equals("CCPSO2")   || Algorithm.equals("PSO_TS_DA")
				|| Algorithm.equals("FA_PSO")|| Algorithm.equals("FA") || Algorithm.equals("ALPSO2_NEW") || Algorithm.equals("ALPSO2_NEW_PrematureConvegence1") 
				|| Algorithm.equals("DMS-L-PSO")   || Algorithm.equals("DMSDL-PSO")   || Algorithm.equals("NLPSO2") 
				|| Algorithm.equals("CLPSO2") || Algorithm.equals("CC-CLPSO2") 	|| Algorithm.equals("L_SHADE_CCPSO2")  ) {

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

			
		
			if (Algorithm.equals("PSO1")) {

				lab15.setText("R1k");
				lab15.setBackground(Color.white);
				lab15.setAlignmentX(Label.CENTER);
				lab15.setForeground(Color.blue);
				lab15.setLocation(50, 460); // �]�w���Ҧ�m
				lab15.setSize(250, 20); // �]�w���Ҥj�p
				lab15.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
				frm.add(lab15);

				lab16.setText("R2k");
				lab16.setBackground(Color.white);
				lab16.setAlignmentX(Label.CENTER);
				lab16.setForeground(Color.blue);
				lab16.setLocation(50, 500); // �]�w���Ҧ�m
				lab16.setSize(250, 20); // �]�w���Ҥj�p
				lab16.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
				frm.add(lab16);

				lab17.setText("R3k");
				lab17.setBackground(Color.white);
				lab17.setAlignmentX(Label.CENTER);
				lab17.setForeground(Color.blue);
				lab17.setLocation(50, 540); // �]�w���Ҧ�m
				lab17.setSize(250, 20); // �]�w���Ҥj�p
				lab17.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
				frm.add(lab17);

				lab18.setText("R4");
				lab18.setBackground(Color.white);
				lab18.setAlignmentX(Label.CENTER);
				lab18.setForeground(Color.blue);
				lab18.setLocation(50, 580); // �]�w���Ҧ�m
				lab18.setSize(250, 20); // �]�w���Ҥj�p
				lab18.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
				frm.add(lab18);

				lab19.setText("R5ik");
				lab19.setBackground(Color.white);
				lab19.setAlignmentX(Label.CENTER);
				lab19.setForeground(Color.blue);
				lab19.setLocation(430, 500); // �]�w���Ҧ�m
				lab19.setSize(250, 20); // �]�w���Ҥj�p
				lab19.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
				frm.add(lab19);
				
				lab41.setText("R6im");
				lab41.setBackground(Color.white);
				lab41.setAlignmentX(Label.CENTER);
				lab41.setForeground(Color.blue);
				lab41.setLocation(430, 540); // �]�w���Ҧ�m
				lab41.setSize(250, 20); // �]�w���Ҥj�p
				lab41.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
				frm.add(lab41);

				lab42.setText("R7it");
				lab42.setBackground(Color.white);
				lab42.setAlignmentX(Label.CENTER);
				lab42.setForeground(Color.blue);
				lab42.setLocation(430, 580); // �]�w���Ҧ�m
				lab42.setSize(250, 20); // �]�w���Ҥj�p
				lab42.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
				frm.add(lab42);
				
				lab25.setText("PSO_lamda");
				lab25.setBackground(Color.white);
				lab25.setAlignmentX(Label.CENTER);
				lab25.setForeground(Color.blue);
				lab25.setLocation(420, 420); // �]�w���Ҧ�m
				lab25.setSize(250, 20); // �]�w���Ҥj�p
				lab25.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
				frm.add(lab25);
				
					Algorithm_Tourism.PSO1_Tourism.PSO_Read_Write_txt c1 = new Algorithm_Tourism.PSO1_Tourism.PSO_Read_Write_txt();
					Read_Adaptive c2 = new Read_Adaptive();
					c1.read_PSO_Parameter();
					c2.read_Adaptive();
					
					txf36.setText(String.valueOf(c1.Iteration()));
					txf37.setText(String.valueOf(c1.Iteration_Mode()));
					txf1.setText(String.valueOf(c1.populationSize()));
					txf2.setText(String.valueOf(c1.w()));
					txf3.setText(String.valueOf(c1.c1()));
					txf4.setText(String.valueOf(c1.c2()));
					txf5.setText(String.valueOf(c1.Vmax()));
					txf6.setText(String.valueOf(c1.Execution_Mode()));
					txf7.setText(String.valueOf(c1.Print_Mode()));
					txf35.setText(String.valueOf(c1.Write_Mode()));
					txf8.setText(String.valueOf(String.valueOf(new BigDecimal(
							String.valueOf(c1.threshold())).toPlainString())));
					txf17.setText(String.valueOf(c1.PSO_lamda()));
					
					txf20.setText(String.valueOf(c1.R1()));
					txf21.setText(String.valueOf(c1.R2()));
					txf22.setText(String.valueOf(c1.R3()));
					txf23.setText(String.valueOf(c1.R4()));
					txf24.setText(String.valueOf(c1.R5()));
					txf39.setText(String.valueOf(c1.R6()));
					txf40.setText(String.valueOf(c1.R7()));
				
				txf36.setBounds(250, 20, 150, 20);
				txf37.setBounds(250, 60, 150, 20);
				txf1.setBounds(250, 100, 150, 20);
				txf2.setBounds(250, 140, 150, 20);
				txf3.setBounds(250, 180, 150, 20);
				txf4.setBounds(250, 220, 150, 20);
				txf5.setBounds(250, 260, 150, 20);
				txf6.setBounds(250, 300, 150, 20);
				txf7.setBounds(250, 340, 150, 20);
				txf35.setBounds(250, 380, 150, 20);
				txf8.setBounds(250, 420, 150, 20);
				txf17.setBounds(520, 420, 150, 20);
				txf20.setBounds(250, 460, 150, 20);
				txf21.setBounds(250, 500, 150, 20);
				txf22.setBounds(250, 540, 150, 20);
				txf23.setBounds(250, 580, 150, 20);
				txf24.setBounds(510, 500, 150, 20);
				txf39.setBounds(510, 540, 150, 20);
				txf40.setBounds(510, 580, 150, 20);
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
				frm.add(txf17);
				frm.add(txf20);
				frm.add(txf21);
				frm.add(txf22);
				frm.add(txf23);
				frm.add(txf24);
				frm.add(txf39);
				frm.add(txf40);
				frm.add(txf32);
				
			} else {
					
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
			//	txf17.setBounds(520, 420, 150, 20);
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
		//		frm.add(txf17);
				if (Algorithm.equals("PSO2")) {
					lab41.setText("PSO_lamda");
					lab41.setBackground(Color.white);
					lab41.setAlignmentX(Label.CENTER);
					lab41.setForeground(Color.blue);
					lab41.setLocation(450, 260); // �]�w���Ҧ�m
					lab41.setSize(250, 20); // �]�w���Ҥj�p
					lab41.setFont(new Font("Serief", Font.ITALIC + Font.BOLD,
							18));
					frm.add(lab41);
					

					Algorithm_Tourism.PSO2_Tourism.PSO_Read_Write_txt c2 = new Algorithm_Tourism.PSO2_Tourism.PSO_Read_Write_txt();

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
					txf8.setText(String.valueOf(String
							.valueOf(new BigDecimal(String.valueOf(c2
									.threshold())).toPlainString())));
					txf39.setText(String.valueOf(c2.PSO_lamda()));
					txf39.setBounds(600, 260, 150, 20);
					frm.add(txf39);
				}
				if (Algorithm.equals("ALPSO")){
					lab15.setText("R1k");
					lab15.setBackground(Color.white);
					lab15.setAlignmentX(Label.CENTER);
					lab15.setForeground(Color.blue);
					lab15.setLocation(50, 460); // �]�w���Ҧ�m
					lab15.setSize(250, 20); // �]�w���Ҥj�p
					lab15.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
					frm.add(lab15);

					lab16.setText("R2k");
					lab16.setBackground(Color.white);
					lab16.setAlignmentX(Label.CENTER);
					lab16.setForeground(Color.blue);
					lab16.setLocation(50, 500); // �]�w���Ҧ�m
					lab16.setSize(250, 20); // �]�w���Ҥj�p
					lab16.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
					frm.add(lab16);

					lab17.setText("R3k");
					lab17.setBackground(Color.white);
					lab17.setAlignmentX(Label.CENTER);
					lab17.setForeground(Color.blue);
					lab17.setLocation(50, 540); // �]�w���Ҧ�m
					lab17.setSize(250, 20); // �]�w���Ҥj�p
					lab17.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
					frm.add(lab17);

					lab18.setText("R4");
					lab18.setBackground(Color.white);
					lab18.setAlignmentX(Label.CENTER);
					lab18.setForeground(Color.blue);
					lab18.setLocation(430, 460); // �]�w���Ҧ�m
					lab18.setSize(250, 20); // �]�w���Ҥj�p
					lab18.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
					frm.add(lab18);

					lab19.setText("R5ik");
					lab19.setBackground(Color.white);
					lab19.setAlignmentX(Label.CENTER);
					lab19.setForeground(Color.blue);
					lab19.setLocation(430, 500); // �]�w���Ҧ�m
					lab19.setSize(250, 20); // �]�w���Ҥj�p
					lab19.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
					frm.add(lab19);
					
					lab41.setText("R6im");
					lab41.setBackground(Color.white);
					lab41.setAlignmentX(Label.CENTER);
					lab41.setForeground(Color.blue);
					lab41.setLocation(430, 540); // �]�w���Ҧ�m
					lab41.setSize(250, 20); // �]�w���Ҥj�p
					lab41.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
					frm.add(lab41);

					lab42.setText("R7it");
					lab42.setBackground(Color.white);
					lab42.setAlignmentX(Label.CENTER);
					lab42.setForeground(Color.blue);
					lab42.setLocation(430, 580); // �]�w���Ҧ�m
					lab42.setSize(250, 20); // �]�w���Ҥj�p
					lab42.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
					frm.add(lab42);
					
					lab31.setText("εh");
					lab31.setBackground(Color.white);
					lab31.setAlignmentX(Label.CENTER);
					lab31.setForeground(Color.blue);
					lab31.setLocation(50, 580); // �]�w���Ҧ�m
					lab31.setSize(650, 20); // �]�w���Ҥj�p
					lab31.setFont(new Font("Serief", Font.ITALIC
							+ Font.BOLD, 18));
					frm.add(lab31);
					
					lab32.setText("Print_Mode");
					lab32.setBackground(Color.white);
					lab32.setAlignmentX(Label.CENTER);
					lab32.setForeground(Color.blue);
					lab32.setLocation(50, 620); // �]�w���Ҧ�m
					lab32.setSize(650, 20); // �]�w���Ҥj�p
					lab32.setFont(new Font("Serief", Font.ITALIC
							+ Font.BOLD, 18));
					frm.add(lab32);
					
					lab33.setText("0不顯示λ、θ、g過程,1顯示 過程");
					lab33.setBackground(Color.white);
					lab33.setAlignmentX(Label.CENTER);
					lab33.setForeground(Color.blue);
					lab33.setLocation(480, 620); // �]�w���Ҧ�m
					lab33.setSize(300, 20); // �]�w���Ҥj�p
					lab33.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
					frm.add(lab33);
					
				 
					Read_ALPSO_Parameter.main();
					Algorithm_Tourism.Lagrangian_PSO_Tourism.PSO_Read_Write_txt c1 = new Algorithm_Tourism.Lagrangian_PSO_Tourism.PSO_Read_Write_txt();
					Read_Adaptive c2 = new Read_Adaptive();
					c1.read_PSO_Parameter();
					c2.read_Adaptive();
					txf36.setText(String.valueOf(c1.Iteration()));
					txf37.setText(String.valueOf(c1.Iteration_Mode()));
					txf1.setText(String.valueOf(c1.populationSize()));
					txf2.setText(String.valueOf(c1.w()));
					txf3.setText(String.valueOf(c1.c1()));
					txf4.setText(String.valueOf(c1.c2()));
					txf5.setText(String.valueOf(c1.Vmax()));
					txf6.setText(String.valueOf(c1.Execution_Mode()));
					txf7.setText(String.valueOf(c1.Print_Mode()));
					txf35.setText(String.valueOf(c1.Write_Mode()));
					txf8.setText(String.valueOf(String.valueOf(new BigDecimal(
							String.valueOf(c1.threshold())).toPlainString())));

					txf20.setText(String.valueOf(c1.R1()));
					txf21.setText(String.valueOf(c1.R2()));
					txf22.setText(String.valueOf(c1.R3()));
					txf23.setText(String.valueOf(c1.R4()));
					txf24.setText(String.valueOf(c1.R5()));
					txf39.setText(String.valueOf(c1.R6()));
					txf40.setText(String.valueOf(c1.R7()));
					txf33.setText(String.valueOf(Read_ALPSO_Parameter.Epsilonh()));
					txf34.setText(String.valueOf(Read_ALPSO_Parameter.Print()));
						
					txf20.setBounds(250, 460, 150, 20);
					txf21.setBounds(250, 500, 150, 20);
					txf22.setBounds(250, 540, 150, 20);
					txf23.setBounds(510, 460, 150, 20);
					txf24.setBounds(510, 500, 150, 20);
					txf39.setBounds(510, 540, 150, 20);
					txf40.setBounds(510, 580, 150, 20);
					txf33.setBounds(250, 580, 150, 20);
					txf34.setBounds(250, 620, 150, 20);
				frm.add(txf20);
				frm.add(txf21);
				frm.add(txf22);
				frm.add(txf23);
				frm.add(txf24);
				frm.add(txf39);
				frm.add(txf40);
				frm.add(txf33);
				frm.add(txf34);
				}
				
				else if (Algorithm.equals("LRPSO")){
	

					lab19.setText("L");
					lab19.setBackground(Color.white);
					lab19.setAlignmentX(Label.CENTER);
					lab19.setForeground(Color.blue);
					lab19.setLocation(50, 460); // �]�w���Ҧ�m
					lab19.setSize(250, 20); // �]�w���Ҥj�p
					lab19.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
					frm.add(lab19);
					
					lab31.setText("c");
					lab31.setBackground(Color.white);
					lab31.setAlignmentX(Label.CENTER);
					lab31.setForeground(Color.blue);
					lab31.setLocation(50, 500); // �]�w���Ҧ�m
					lab31.setSize(650, 20); // �]�w���Ҥj�p
					lab31.setFont(new Font("Serief", Font.ITALIC
							+ Font.BOLD, 18));
					frm.add(lab31);
					
					lab32.setText("Print_Mode");
					lab32.setBackground(Color.white);
					lab32.setAlignmentX(Label.CENTER);
					lab32.setForeground(Color.blue);
					lab32.setLocation(50, 540); // �]�w���Ҧ�m
					lab32.setSize(650, 20); // �]�w���Ҥj�p
					lab32.setFont(new Font("Serief", Font.ITALIC
							+ Font.BOLD, 18));
					frm.add(lab32);
					
					lab33.setText("0不顯示λ、θ、g過程,1顯示 過程");
					lab33.setBackground(Color.white);
					lab33.setAlignmentX(Label.CENTER);
					lab33.setForeground(Color.blue);
					lab33.setLocation(480, 540); // �]�w���Ҧ�m
					lab33.setSize(300, 20); // �]�w���Ҥj�p
					lab33.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
					frm.add(lab33);
					
					Read_LRPSO_Parameter.main();
					Algorithm_Tourism.Lagrangian_RelaxationPSO_Tourism.PSO_Read_Write_txt c1 = new Algorithm_Tourism.Lagrangian_RelaxationPSO_Tourism.PSO_Read_Write_txt();
					
					c1.read_PSO_Parameter();
					txf36.setText(String.valueOf(c1.Iteration()));
					txf37.setText(String.valueOf(c1.Iteration_Mode()));
					txf1.setText(String.valueOf(c1.populationSize()));
					txf2.setText(String.valueOf(c1.w()));
					txf3.setText(String.valueOf(c1.c1()));
					txf4.setText(String.valueOf(c1.c2()));
					txf5.setText(String.valueOf(c1.Vmax()));
					txf6.setText(String.valueOf(c1.Execution_Mode()));
					txf7.setText(String.valueOf(c1.Print_Mode()));
					txf35.setText(String.valueOf(c1.Write_Mode()));
					txf8.setText(String.valueOf(String.valueOf(new BigDecimal(
							String.valueOf(c1.threshold())).toPlainString())));

	
					txf24.setText(String.valueOf(Read_LRPSO_Parameter.L()));
					txf33.setText(String.valueOf(Read_LRPSO_Parameter.c()));
					txf34.setText(String.valueOf(Read_LRPSO_Parameter.Print()));
						
		
					txf24.setBounds(250, 460, 150, 20);
					txf33.setBounds(250, 500, 150, 20);
					txf34.setBounds(250, 540, 150, 20);
					

				frm.add(txf24);
				frm.add(txf33);
				frm.add(txf34);
				}
				else if (Algorithm.equals("LR_and_PSO2")){
					
					lab19.setText("L");
					lab19.setBackground(Color.white);
					lab19.setAlignmentX(Label.CENTER);
					lab19.setForeground(Color.blue);
					lab19.setLocation(50, 460); // �]�w���Ҧ�m
					lab19.setSize(250, 20); // �]�w���Ҥj�p
					lab19.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
					frm.add(lab19);
					
					lab31.setText("c");
					lab31.setBackground(Color.white);
					lab31.setAlignmentX(Label.CENTER);
					lab31.setForeground(Color.blue);
					lab31.setLocation(50, 500); // �]�w���Ҧ�m
					lab31.setSize(650, 20); // �]�w���Ҥj�p
					lab31.setFont(new Font("Serief", Font.ITALIC
							+ Font.BOLD, 18));
					frm.add(lab31);
					
					lab32.setText("Print_Mode");
					lab32.setBackground(Color.white);
					lab32.setAlignmentX(Label.CENTER);
					lab32.setForeground(Color.blue);
					lab32.setLocation(50, 540); // �]�w���Ҧ�m
					lab32.setSize(650, 20); // �]�w���Ҥj�p
					lab32.setFont(new Font("Serief", Font.ITALIC
							+ Font.BOLD, 18));
					frm.add(lab32);
					
					lab33.setText("0不顯示λ、θ、g過程,1顯示 過程");
					lab33.setBackground(Color.white);
					lab33.setAlignmentX(Label.CENTER);
					lab33.setForeground(Color.blue);
					lab33.setLocation(480, 540); // �]�w���Ҧ�m
					lab33.setSize(300, 20); // �]�w���Ҥj�p
					lab33.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
					frm.add(lab33);
					
					Read_LR_and_PSO2_Parameter.main();
					Algorithm_Tourism.Lagrangian_Relaxation_and_PSO2_Tourism.PSO_Read_Write_txt c1 = new Algorithm_Tourism.Lagrangian_Relaxation_and_PSO2_Tourism.PSO_Read_Write_txt();
					
					c1.read_PSO_Parameter();
					txf36.setText(String.valueOf(c1.Iteration()));
					txf37.setText(String.valueOf(c1.Iteration_Mode()));
					txf1.setText(String.valueOf(c1.populationSize()));
					txf2.setText(String.valueOf(c1.w()));
					txf3.setText(String.valueOf(c1.c1()));
					txf4.setText(String.valueOf(c1.c2()));
					txf5.setText(String.valueOf(c1.Vmax()));
					txf6.setText(String.valueOf(c1.Execution_Mode()));
					txf7.setText(String.valueOf(c1.Print_Mode()));
					txf35.setText(String.valueOf(c1.Write_Mode()));
					txf8.setText(String.valueOf(String.valueOf(new BigDecimal(
							String.valueOf(c1.threshold())).toPlainString())));

	
					txf24.setText(String.valueOf(Read_LR_and_PSO2_Parameter.L()));
					txf33.setText(String.valueOf(Read_LR_and_PSO2_Parameter.c()));
					txf34.setText(String.valueOf(Read_LR_and_PSO2_Parameter.Print()));
						
		
					txf24.setBounds(250, 460, 150, 20);
					txf33.setBounds(250, 500, 150, 20);
					txf34.setBounds(250, 540, 150, 20);
					

				frm.add(txf24);
				frm.add(txf33);
				frm.add(txf34);
				}
				
				if (Algorithm.equals("LR_and_PSO1")){
					lab15.setText("R1k");
					lab15.setBackground(Color.white);
					lab15.setAlignmentX(Label.CENTER);
					lab15.setForeground(Color.blue);
					lab15.setLocation(50, 460); // �]�w���Ҧ�m
					lab15.setSize(250, 20); // �]�w���Ҥj�p
					lab15.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
					frm.add(lab15);

					lab16.setText("R2k");
					lab16.setBackground(Color.white);
					lab16.setAlignmentX(Label.CENTER);
					lab16.setForeground(Color.blue);
					lab16.setLocation(50, 500); // �]�w���Ҧ�m
					lab16.setSize(250, 20); // �]�w���Ҥj�p
					lab16.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
					frm.add(lab16);

					lab17.setText("R3k");
					lab17.setBackground(Color.white);
					lab17.setAlignmentX(Label.CENTER);
					lab17.setForeground(Color.blue);
					lab17.setLocation(50, 540); // �]�w���Ҧ�m
					lab17.setSize(250, 20); // �]�w���Ҥj�p
					lab17.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
					frm.add(lab17);

					lab18.setText("R4");
					lab18.setBackground(Color.white);
					lab18.setAlignmentX(Label.CENTER);
					lab18.setForeground(Color.blue);
					lab18.setLocation(430, 460); // �]�w���Ҧ�m
					lab18.setSize(250, 20); // �]�w���Ҥj�p
					lab18.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
					frm.add(lab18);

					lab19.setText("R5ik");
					lab19.setBackground(Color.white);
					lab19.setAlignmentX(Label.CENTER);
					lab19.setForeground(Color.blue);
					lab19.setLocation(430, 500); // �]�w���Ҧ�m
					lab19.setSize(250, 20); // �]�w���Ҥj�p
					lab19.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
					frm.add(lab19);
					
					lab18.setText("R4");
					lab18.setBackground(Color.white);
					lab18.setAlignmentX(Label.CENTER);
					lab18.setForeground(Color.blue);
					lab18.setLocation(430, 460); // �]�w���Ҧ�m
					lab18.setSize(250, 20); // �]�w���Ҥj�p
					lab18.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
					frm.add(lab18);

					lab19.setText("R5ik");
					lab19.setBackground(Color.white);
					lab19.setAlignmentX(Label.CENTER);
					lab19.setForeground(Color.blue);
					lab19.setLocation(430, 500); // �]�w���Ҧ�m
					lab19.setSize(250, 20); // �]�w���Ҥj�p
					lab19.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
					frm.add(lab19);
					
					lab41.setText("R6im");
					lab41.setBackground(Color.white);
					lab41.setAlignmentX(Label.CENTER);
					lab41.setForeground(Color.blue);
					lab41.setLocation(430, 540); // �]�w���Ҧ�m
					lab41.setSize(250, 20); // �]�w���Ҥj�p
					lab41.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
					frm.add(lab41);

					lab42.setText("R7it");
					lab42.setBackground(Color.white);
					lab42.setAlignmentX(Label.CENTER);
					lab42.setForeground(Color.blue);
					lab42.setLocation(430, 580); // �]�w���Ҧ�m
					lab42.setSize(250, 20); // �]�w���Ҥj�p
					lab42.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
					frm.add(lab42);
					
					lab20.setText("L");
					lab20.setBackground(Color.white);
					lab20.setAlignmentX(Label.CENTER);
					lab20.setForeground(Color.blue);
					lab20.setLocation(50, 580); // �]�w���Ҧ�m
					lab20.setSize(250, 20); // �]�w���Ҥj�p
					lab20.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
					frm.add(lab20);
					
					lab31.setText("c");
					lab31.setBackground(Color.white);
					lab31.setAlignmentX(Label.CENTER);
					lab31.setForeground(Color.blue);
					lab31.setLocation(50, 620); // �]�w���Ҧ�m
					lab31.setSize(250, 20); // �]�w���Ҥj�p
					lab31.setFont(new Font("Serief", Font.ITALIC
							+ Font.BOLD, 18));
					frm.add(lab31);
					
					lab32.setText("Print_Mode");
					lab32.setBackground(Color.white);
					lab32.setAlignmentX(Label.CENTER);
					lab32.setForeground(Color.blue);
					lab32.setLocation(50, 660); // �]�w���Ҧ�m
					lab32.setSize(250, 20); // �]�w���Ҥj�p
					lab32.setFont(new Font("Serief", Font.ITALIC
							+ Font.BOLD, 18));
					frm.add(lab32);
					
					lab33.setText("0不顯示λ、θ、g過程,1顯示 過程");
					lab33.setBackground(Color.white);
					lab33.setAlignmentX(Label.CENTER);
					lab33.setForeground(Color.blue);
					lab33.setLocation(450, 660); // �]�w���Ҧ�m
					lab33.setSize(300, 20); // �]�w���Ҥj�p
					lab33.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
					frm.add(lab33);
					
					Read_LR_and_PSO1_Parameter.main();
					Algorithm_Tourism.Lagrangian_Relaxation_and_PSO1_Tourism.PSO_Read_Write_txt c1 = new Algorithm_Tourism.Lagrangian_Relaxation_and_PSO1_Tourism.PSO_Read_Write_txt();
					Read_Adaptive c2 = new Read_Adaptive();
					c1.read_PSO_Parameter();
					c2.read_Adaptive();
					txf36.setText(String.valueOf(c1.Iteration()));
					txf37.setText(String.valueOf(c1.Iteration_Mode()));
					txf1.setText(String.valueOf(c1.populationSize()));
					txf2.setText(String.valueOf(c1.w()));
					txf3.setText(String.valueOf(c1.c1()));
					txf4.setText(String.valueOf(c1.c2()));
					txf5.setText(String.valueOf(c1.Vmax()));
					txf6.setText(String.valueOf(c1.Execution_Mode()));
					txf7.setText(String.valueOf(c1.Print_Mode()));
					txf35.setText(String.valueOf(c1.Write_Mode()));
					txf8.setText(String.valueOf(String.valueOf(new BigDecimal(
							String.valueOf(c1.threshold())).toPlainString())));

				
					txf20.setText(String.valueOf(c1.R1()));
					txf21.setText(String.valueOf(c1.R2()));
					txf22.setText(String.valueOf(c1.R3()));
					txf23.setText(String.valueOf(c1.R4()));
					txf24.setText(String.valueOf(c1.R5()));
					txf39.setText(String.valueOf(c1.R6()));
					txf40.setText(String.valueOf(c1.R7()));
					txf32.setText(String.valueOf(Read_LR_and_PSO1_Parameter.L()));
					txf33.setText(String.valueOf(Read_LR_and_PSO1_Parameter.c()));
					txf34.setText(String.valueOf(Read_LR_and_PSO1_Parameter.Print()));
						
					txf20.setBounds(250, 460, 150, 20);
					txf21.setBounds(250, 500, 150, 20);
					txf22.setBounds(250, 540, 150, 20);
					txf23.setBounds(510, 460, 150, 20);
					txf24.setBounds(510, 500, 150, 20);
					txf39.setBounds(510, 540, 150, 20);
					txf40.setBounds(510, 580, 150, 20);
					txf32.setBounds(250, 580, 150, 20);
					txf33.setBounds(250, 620, 150, 20);
					txf34.setBounds(250, 660, 150, 20);
					
				frm.add(txf20);
				frm.add(txf21);
				frm.add(txf22);
				frm.add(txf23);
				frm.add(txf24);
				frm.add(txf39);
				frm.add(txf40);
				frm.add(txf32);
				frm.add(txf33);
				frm.add(txf34);
				}
				
				if (Algorithm.equals("CCPSO2")) {
					lab41.setText("PSO_lamda");
					lab41.setBackground(Color.white);
					lab41.setAlignmentX(Label.CENTER);
					lab41.setForeground(Color.blue);
					lab41.setLocation(450, 260); // �]�w���Ҧ�m
					lab41.setSize(250, 20); // �]�w���Ҥj�p
					lab41.setFont(new Font("Serief", Font.ITALIC + Font.BOLD,
							18));
					frm.add(lab41);
					
					lab42.setText("Alpha1");
					lab42.setBackground(Color.white);
					lab42.setAlignmentX(Label.CENTER);
					lab42.setForeground(Color.blue);
					lab42.setLocation(50, 460); // �]�w���Ҧ�m
					lab42.setSize(250, 20); // �]�w���Ҥj�p
					lab42.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
					frm.add(lab42);
					
					lab43.setText("Alpha2");
					lab43.setBackground(Color.white);
					lab43.setAlignmentX(Label.CENTER);
					lab43.setForeground(Color.blue);
					lab43.setLocation(50, 500); // �]�w���Ҧ�m
					lab43.setSize(250, 20); // �]�w���Ҥj�p
					lab43.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
					frm.add(lab43);
					
					lab44.setText("Alpha3");
					lab44.setBackground(Color.white);
					lab44.setAlignmentX(Label.CENTER);
					lab44.setForeground(Color.blue);
					lab44.setLocation(50, 540); // �]�w���Ҧ�m
					lab44.setSize(250, 20); // �]�w���Ҥj�p
					lab44.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
					frm.add(lab44);
					
					Algorithm_Tourism.CCPSO2_Tourism.PSO_Read_Write_txt c2 = new Algorithm_Tourism.CCPSO2_Tourism.PSO_Read_Write_txt();
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
					txf8.setText(String.valueOf(String.valueOf(new BigDecimal(String.valueOf(c2.threshold())).toPlainString())));
					txf39.setText(String.valueOf(c2.PSO_lamda()));
					
					txf40.setText(String.valueOf(c2.Alpha1()));
					txf41.setText(String.valueOf(c2.Alpha2()));
					txf42.setText(String.valueOf(c2.Alpha3()));
					txf40.setBounds(250, 460, 150, 20);
					txf41.setBounds(250, 500, 150, 20);
					txf42.setBounds(250, 540, 150, 20);
 					frm.add(txf40);
					frm.add(txf41);
					frm.add(txf42);
					txf39.setBounds(600, 260, 150, 20);
					frm.add(txf39);
				} 
				if (Algorithm.equals("FA_PSO")) {

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

					Algorithm_Tourism.FA_PSO_Tourism.PSO_Read_Write_txt c2 = new Algorithm_Tourism.FA_PSO_Tourism.PSO_Read_Write_txt();
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
				if (Algorithm.equals("FA")) {

					lab19.setText("β0");
					lab19.setBackground(Color.white);
					lab19.setAlignmentX(Label.CENTER);
					lab19.setForeground(Color.blue);
					lab19.setLocation(50, 140); // �]�w���Ҧ�m
					lab19.setSize(250, 20); // �]�w���Ҥj�p
					lab19.setFont(new Font("Serief", Font.ITALIC + Font.BOLD,
							18));
					frm.add(lab19);

					lab31.setText("γ");
					lab31.setBackground(Color.white);
					lab31.setAlignmentX(Label.CENTER);
					lab31.setForeground(Color.blue);
					lab31.setLocation(50, 180); // �]�w���Ҧ�m
					lab31.setSize(250, 20); // �]�w���Ҥj�p
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

				 
					Algorithm_Tourism.FA_Tourism.PSO_Read_Write_txt c2 = new Algorithm_Tourism.FA_Tourism.PSO_Read_Write_txt();
					c2.read_PSO_Parameter();
					txf36.setText(String.valueOf(c2.Iteration()));
					txf37.setText(String.valueOf(c2.Iteration_Mode()));
					txf1.setText(String.valueOf(c2.populationSize()));
					txf24.setText(String.valueOf(c2.B0()));
					txf33.setText(String.valueOf(c2.Gamma()));
					txf34.setText(String.valueOf(c2.Alpha()));
					// txf5.setText(String.valueOf(c2.Vmax()));
					txf6.setText(String.valueOf(c2.Execution_Mode()));
					txf7.setText(String.valueOf(c2.Print_Mode()));
					txf35.setText(String.valueOf(c2.Write_Mode()));
					txf8.setText(String.valueOf(String.valueOf(new BigDecimal(
							String.valueOf(c2.threshold())).toPlainString())));

					txf24.setBounds(250, 140, 150, 20);
					txf33.setBounds(250, 180, 150, 20);
					txf34.setBounds(250, 220, 150, 20);
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
				}
				if (Algorithm.equals("ALPSO2_NEW")) {

					lab41.setText("PSO_lamda");
					lab41.setBackground(Color.white);
					lab41.setAlignmentX(Label.CENTER);
					lab41.setForeground(Color.blue);
					lab41.setLocation(450, 260); // �]�w���Ҧ�m
					lab41.setSize(250, 20); // �]�w���Ҥj�p
					lab41.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
					frm.add(lab41);
					
					lab19.setText("Prob_candidate");
					lab19.setBackground(Color.white);
					lab19.setAlignmentX(Label.CENTER);
					lab19.setForeground(Color.blue);
					lab19.setLocation(50, 460); // �]�w���Ҧ�m
					lab19.setSize(250, 20); // �]�w���Ҥj�p
					lab19.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
					frm.add(lab19);
					
					lab20.setText("Local_Search_Iteration");
					lab20.setBackground(Color.white);
					lab20.setAlignmentX(Label.CENTER);
					lab20.setForeground(Color.blue);
					lab20.setLocation(50, 500); // �]�w���Ҧ�m
					lab20.setSize(250, 20); // �]�w���Ҥj�p
					lab20.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
					frm.add(lab20);
					
					Algorithm_Tourism.ALPSO2_NEW_Tourism.PSO_Read_Write_txt c2 = new Algorithm_Tourism.ALPSO2_NEW_Tourism.PSO_Read_Write_txt();

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
					txf8.setText(String.valueOf(String
							.valueOf(new BigDecimal(String.valueOf(c2
									.threshold())).toPlainString())));
					txf39.setText(String.valueOf(c2.PSO_lamda()));
					txf40.setText(String.valueOf(c2.Prob_candidate()));
					txf41.setText(String.valueOf(c2.Local_Search_Iteration()));
					txf39.setBounds(600, 260, 150, 20);
					txf40.setBounds(250, 460, 150, 20);
					txf41.setBounds(250, 500, 150, 20);
					frm.add(txf39);
					frm.add(txf40);
					frm.add(txf41);
				}
				if (Algorithm.equals("ALPSO2_NEW_PrematureConvegence1")) {

					lab41.setText("PSO_lamda");
					lab41.setBackground(Color.white);
					lab41.setAlignmentX(Label.CENTER);
					lab41.setForeground(Color.blue);
					lab41.setLocation(450, 260); // �]�w���Ҧ�m
					lab41.setSize(250, 20); // �]�w���Ҥj�p
					lab41.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
					frm.add(lab41);
					
					lab19.setText("Prob_candidate");
					lab19.setBackground(Color.white);
					lab19.setAlignmentX(Label.CENTER);
					lab19.setForeground(Color.blue);
					lab19.setLocation(50, 460); // �]�w���Ҧ�m
					lab19.setSize(250, 20); // �]�w���Ҥj�p
					lab19.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
					frm.add(lab19);
					
					lab20.setText("Local_Search_Iteration");
					lab20.setBackground(Color.white);
					lab20.setAlignmentX(Label.CENTER);
					lab20.setForeground(Color.blue);
					lab20.setLocation(50, 500); // �]�w���Ҧ�m
					lab20.setSize(250, 20); // �]�w���Ҥj�p
					lab20.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
					frm.add(lab20);
					
					Algorithm_Tourism.ALPSO2_NEW_PrematureConvegence1_Tourism.PSO_Read_Write_txt c2 = new Algorithm_Tourism.ALPSO2_NEW_PrematureConvegence1_Tourism.PSO_Read_Write_txt();

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
					txf8.setText(String.valueOf(String
							.valueOf(new BigDecimal(String.valueOf(c2
									.threshold())).toPlainString())));
					txf39.setText(String.valueOf(c2.PSO_lamda()));
					txf40.setText(String.valueOf(c2.Prob_candidate()));
					txf41.setText(String.valueOf(c2.Local_Search_Iteration()));
					
					txf39.setBounds(600, 260, 150, 20);
					txf40.setBounds(250, 460, 150, 20);
					txf41.setBounds(250, 500, 150, 20);
					frm.add(txf39);
					frm.add(txf40);
					frm.add(txf41);
				}
				if (Algorithm.equals("DMS-L-PSO") ) {


					lab41.setText("PSO_lamda");
					lab41.setBackground(Color.white);
					lab41.setAlignmentX(Label.CENTER);
					lab41.setForeground(Color.blue);
					lab41.setLocation(450, 260); // �]�w���Ҧ�m
					lab41.setSize(250, 20); // �]�w���Ҥj�p
					lab41.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
					frm.add(lab41);
					
					lab19.setText("R");
					lab19.setBackground(Color.white);
					lab19.setAlignmentX(Label.CENTER);
					lab19.setForeground(Color.blue);
					lab19.setLocation(50, 460); // �]�w���Ҧ�m
					lab19.setSize(250, 20); // �]�w���Ҥj�p
					lab19.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
					frm.add(lab19);
					
					lab20.setText("L");
					lab20.setBackground(Color.white);
					lab20.setAlignmentX(Label.CENTER);
					lab20.setForeground(Color.blue);
					lab20.setLocation(50, 500); // �]�w���Ҧ�m
					lab20.setSize(250, 20); // �]�w���Ҥj�p
					lab20.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
					frm.add(lab20);
					
					lab21.setText("Local_Search_Iteration");
					lab21.setBackground(Color.white);
					lab21.setAlignmentX(Label.CENTER);
					lab21.setForeground(Color.blue);
					lab21.setLocation(50, 540); // �]�w���Ҧ�m
					lab21.setSize(250, 20); // �]�w���Ҥj�p
					lab21.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
					frm.add(lab21);
					
					Algorithm_Tourism.DMS_L_PSO2_Tourism.PSO_Read_Write_txt c2 = new Algorithm_Tourism.DMS_L_PSO2_Tourism.PSO_Read_Write_txt();

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
					txf8.setText(String.valueOf(String
							.valueOf(new BigDecimal(String.valueOf(c2
									.threshold())).toPlainString())));
					txf39.setText(String.valueOf(c2.PSO_lamda()));
					txf40.setText(String.valueOf(c2.R()));
					txf41.setText(String.valueOf(c2.L()));
					txf42.setText(String.valueOf(c2.Local_Search_Iteration()));
					txf39.setBounds(600, 260, 150, 20);
					txf40.setBounds(250, 460, 150, 20);
					txf41.setBounds(250, 500, 150, 20);
					txf42.setBounds(250, 540, 150, 20);
					frm.add(txf39);
					frm.add(txf40);
					frm.add(txf41);
					frm.add(txf42);
				}
				if (Algorithm.equals("DMSDL-PSO")) {

					lab41.setText("PSO_lamda");
					lab41.setBackground(Color.white);
					lab41.setAlignmentX(Label.CENTER);
					lab41.setForeground(Color.blue);
					lab41.setLocation(450, 260); // �]�w���Ҧ�m
					lab41.setSize(250, 20); // �]�w���Ҥj�p
					lab41.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
					frm.add(lab41);
					
					
					lab19.setText("R");
					lab19.setBackground(Color.white);
					lab19.setAlignmentX(Label.CENTER);
					lab19.setForeground(Color.blue);
					lab19.setLocation(50, 460); // �]�w���Ҧ�m
					lab19.setSize(250, 20); // �]�w���Ҥj�p
					lab19.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
					frm.add(lab19);
					
					lab20.setText("L");
					lab20.setBackground(Color.white);
					lab20.setAlignmentX(Label.CENTER);
					lab20.setForeground(Color.blue);
					lab20.setLocation(50, 500); // �]�w���Ҧ�m
					lab20.setSize(250, 20); // �]�w���Ҥj�p
					lab20.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
					frm.add(lab20);
					
					lab21.setText("Local_Search_Iteration");
					lab21.setBackground(Color.white);
					lab21.setAlignmentX(Label.CENTER);
					lab21.setForeground(Color.blue);
					lab21.setLocation(50, 540); // �]�w���Ҧ�m
					lab21.setSize(250, 20); // �]�w���Ҥj�p
					lab21.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
					frm.add(lab21);
					
					Algorithm_Tourism.DMSDL_PSO2_Tourism.PSO_Read_Write_txt c2 = new Algorithm_Tourism.DMSDL_PSO2_Tourism.PSO_Read_Write_txt();

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
					txf8.setText(String.valueOf(String
							.valueOf(new BigDecimal(String.valueOf(c2
									.threshold())).toPlainString())));
					txf39.setText(String.valueOf(c2.PSO_lamda()));
					txf40.setText(String.valueOf(c2.R()));
					txf41.setText(String.valueOf(c2.L()));
					txf42.setText(String.valueOf(c2.Local_Search_Iteration()));
					
					txf39.setBounds(600, 260, 150, 20);
					txf40.setBounds(250, 460, 150, 20);
					txf41.setBounds(250, 500, 150, 20);
					txf42.setBounds(250, 540, 150, 20);
					
					frm.add(txf39);
					frm.add(txf40);
					frm.add(txf41);
					frm.add(txf42);
				}
				if (Algorithm.equals("NLPSO2") ) {


					lab41.setText("PSO_lamda");
					lab41.setBackground(Color.white);
					lab41.setAlignmentX(Label.CENTER);
					lab41.setForeground(Color.blue);
					lab41.setLocation(450, 260); // �]�w���Ҧ�m
					lab41.setSize(250, 20); // �]�w���Ҥj�p
					lab41.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
					frm.add(lab41);
					
					lab19.setText("prand");
					lab19.setBackground(Color.white);
					lab19.setAlignmentX(Label.CENTER);
					lab19.setForeground(Color.blue);
					lab19.setLocation(50, 460); // �]�w���Ҧ�m
					lab19.setSize(250, 20); // �]�w���Ҥj�p
					lab19.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
					frm.add(lab19);
					
					lab20.setText("psm");
					lab20.setBackground(Color.white);
					lab20.setAlignmentX(Label.CENTER);
					lab20.setForeground(Color.blue);
					lab20.setLocation(50, 500); // �]�w���Ҧ�m
					lab20.setSize(250, 20); // �]�w���Ҥj�p
					lab20.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
					frm.add(lab20);
					
					lab21.setText("Rfl");
					lab21.setBackground(Color.white);
					lab21.setAlignmentX(Label.CENTER);
					lab21.setForeground(Color.blue);
					lab21.setLocation(50, 540); // �]�w���Ҧ�m
					lab21.setSize(250, 20); // �]�w���Ҥj�p
					lab21.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
					frm.add(lab21);
					
					lab22.setText("Rfu");
					lab22.setBackground(Color.white);
					lab22.setAlignmentX(Label.CENTER);
					lab22.setForeground(Color.blue);
					lab22.setLocation(50, 580); // �]�w���Ҧ�m
					lab22.setSize(250, 20); // �]�w���Ҥj�p
					lab22.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
					frm.add(lab22);
					
					Algorithm_Tourism.NLPSO2_Tourism.PSO_Read_Write_txt c2 = new Algorithm_Tourism.NLPSO2_Tourism.PSO_Read_Write_txt();

					c2.read_PSO_Parameter();
					
					txf36.setText(String.valueOf(c2.Iteration()));
					txf37.setText(String.valueOf(c2.Iteration_Mode()));
					txf1.setText(String.valueOf(c2.populationSize()));
					txf2.setText(String.valueOf(c2.w()));
					txf3.setText(String.valueOf(c2.c1()));
		//			txf4.setText(String.valueOf(c2.c2()));
					txf5.setText(String.valueOf(c2.Vmax()));
					txf6.setText(String.valueOf(c2.Execution_Mode()));
					txf7.setText(String.valueOf(c2.Print_Mode()));
					txf35.setText(String.valueOf(c2.Write_Mode()));
					txf8.setText(String.valueOf(String
							.valueOf(new BigDecimal(String.valueOf(c2
									.threshold())).toPlainString())));
					txf39.setText(String.valueOf(c2.PSO_lamda()));
					txf40.setText(String.valueOf(c2.prand()));
					txf41.setText(String.valueOf(c2.psm()));
					txf42.setText(String.valueOf(c2.Rfl()));
					txf43.setText(String.valueOf(c2.Rfu()));
					txf39.setBounds(600, 260, 150, 20);
					txf40.setBounds(250, 460, 150, 20);
					txf41.setBounds(250, 500, 150, 20);
					txf42.setBounds(250, 540, 150, 20);
					txf43.setBounds(250, 580, 150, 20);
					frm.add(txf39);
					frm.add(txf40);
					frm.add(txf41);
					frm.add(txf42);
					frm.add(txf43);
					frm.remove(txf4);
					frm.remove(lab4);
				}
				if (Algorithm.equals("CLPSO2")) {

					lab41.setText("PSO_lamda");
					lab41.setBackground(Color.white);
					lab41.setAlignmentX(Label.CENTER);
					lab41.setForeground(Color.blue);
					lab41.setLocation(450, 260); // �]�w���Ҧ�m
					lab41.setSize(250, 20); // �]�w���Ҥj�p
					lab41.setFont(new Font("Serief", Font.ITALIC + Font.BOLD,
							18));
					frm.add(lab41);

					lab42.setText("Pc");
					lab42.setBackground(Color.white);
					lab42.setAlignmentX(Label.CENTER);
					lab42.setForeground(Color.blue);
					lab42.setLocation(50, 480); // �]�w���Ҧ�m
					lab42.setSize(200, 20); // �]�w���Ҥj�p
					lab42.setFont(new Font("Serief", Font.ITALIC + Font.BOLD,
							18));
					frm.add(lab42);
					
					Algorithm_Tourism.CLPSO2_Tourism.PSO_Read_Write_txt c2 = new Algorithm_Tourism.CLPSO2_Tourism.PSO_Read_Write_txt();

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
					txf39.setText(String.valueOf(c2.PSO_lamda()));
					txf40.setText(String.valueOf(c2.Pc()));

					txf39.setBounds(600, 260, 150, 20);
					frm.add(txf39);
					txf40.setBounds(250, 480, 150, 20);
					frm.add(txf40);
				}
				if (Algorithm.equals("CC-CLPSO2")) {

					lab41.setText("PSO_lamda");
					lab41.setBackground(Color.white);
					lab41.setAlignmentX(Label.CENTER);
					lab41.setForeground(Color.blue);
					lab41.setLocation(450, 260); // �]�w���Ҧ�m
					lab41.setSize(250, 20); // �]�w���Ҥj�p
					lab41.setFont(new Font("Serief", Font.ITALIC + Font.BOLD,
							18));
					frm.add(lab41);

					lab42.setText("Pc");
					lab42.setBackground(Color.white);
					lab42.setAlignmentX(Label.CENTER);
					lab42.setForeground(Color.blue);
					lab42.setLocation(50, 480); // �]�w���Ҧ�m
					lab42.setSize(200, 20); // �]�w���Ҥj�p
					lab42.setFont(new Font("Serief", Font.ITALIC + Font.BOLD,
							18));
					frm.add(lab42);
					
					Algorithm_Tourism.CC_CLPSO2_Tourism.PSO_Read_Write_txt c2 = new Algorithm_Tourism.CC_CLPSO2_Tourism.PSO_Read_Write_txt();

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
					txf39.setText(String.valueOf(c2.PSO_lamda()));
					txf40.setText(String.valueOf(c2.Pc()));

					txf39.setBounds(600, 260, 150, 20);
					frm.add(txf39);
					txf40.setBounds(250, 480, 150, 20);
					frm.add(txf40);
				}
				if (Algorithm.equals("L_SHADE_CCPSO2")) {

					lab41.setText("PSO_lamda");
					lab41.setBackground(Color.white);
					lab41.setAlignmentX(Label.CENTER);
					lab41.setForeground(Color.blue);
					lab41.setLocation(450, 260); // �]�w���Ҧ�m
					lab41.setSize(250, 20); // �]�w���Ҥj�p
					lab41.setFont(new Font("Serief", Font.ITALIC + Font.BOLD,
							18));
					frm.add(lab41);

					lab42.setText("Alpha1");
					lab42.setBackground(Color.white);
					lab42.setAlignmentX(Label.CENTER);
					lab42.setForeground(Color.blue);
					lab42.setLocation(50, 460); // �]�w���Ҧ�m
					lab42.setSize(250, 20); // �]�w���Ҥj�p
					lab42.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
					frm.add(lab42);

					lab43.setText("Alpha2");
					lab43.setBackground(Color.white);
					lab43.setAlignmentX(Label.CENTER);
					lab43.setForeground(Color.blue);
					lab43.setLocation(50, 500); // �]�w���Ҧ�m
					lab43.setSize(250, 20); // �]�w���Ҥj�p
					lab43.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
					frm.add(lab43);

					lab44.setText("Alpha3");
					lab44.setBackground(Color.white);
					lab44.setAlignmentX(Label.CENTER);
					lab44.setForeground(Color.blue);
					lab44.setLocation(50, 540); // �]�w���Ҧ�m
					lab44.setSize(250, 20); // �]�w���Ҥj�p
					lab44.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
					frm.add(lab44);

					lab15.setText("H");
					lab15.setBackground(Color.white);
					lab15.setAlignmentX(Label.CENTER);
					lab15.setForeground(Color.blue);
					lab15.setLocation(50, 580); // �]�w���Ҧ�m
					lab15.setSize(250, 20); // �]�w���Ҥj�p
					lab15.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
					frm.add(lab15);
					
					Algorithm_Tourism.L_SHADE_CCPSO2_Tourism.PSO_Read_Write_txt c2 = new Algorithm_Tourism.L_SHADE_CCPSO2_Tourism.PSO_Read_Write_txt();
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
					txf39.setText(String.valueOf(c2.PSO_lamda()));

					txf40.setText(String.valueOf(c2.Alpha1()));
					txf41.setText(String.valueOf(c2.Alpha2()));
					txf42.setText(String.valueOf(c2.Alpha3()));
					txf43.setText(String.valueOf(c2.H()));
					txf40.setBounds(250, 460, 150, 20);
					txf41.setBounds(250, 500, 150, 20);
					txf42.setBounds(250, 540, 150, 20);
					txf43.setBounds(250, 580, 150, 20);
					frm.add(txf40);
					frm.add(txf41);
					frm.add(txf42);
					frm.add(txf43);
					txf39.setBounds(600, 260, 150, 20);
					frm.add(txf39);
				}
			}

			frm.remove(lab9);
			frm.remove(lab10);
			frm.remove(lab11);
			frm.remove(txf9);
			frm.remove(txf10);
			frm.remove(txf11);
		}

		
		if (Algorithm.equals("LR")) {
			
			lab19.setText("L");
			lab19.setBackground(Color.white);
			lab19.setAlignmentX(Label.CENTER);
			lab19.setForeground(Color.blue);
			lab19.setLocation(50, 340); // �]�w���Ҧ�m
			lab19.setSize(250, 20); // �]�w���Ҥj�p
			lab19.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab19);
			
			lab31.setText("c");
			lab31.setBackground(Color.white);
			lab31.setAlignmentX(Label.CENTER);
			lab31.setForeground(Color.blue);
			lab31.setLocation(50, 380); // �]�w���Ҧ�m
			lab31.setSize(650, 20); // �]�w���Ҥj�p
			lab31.setFont(new Font("Serief", Font.ITALIC
					+ Font.BOLD, 18));
			frm.add(lab31);
			
			lab32.setText("Print_Mode");
			lab32.setBackground(Color.white);
			lab32.setAlignmentX(Label.CENTER);
			lab32.setForeground(Color.blue);
			lab32.setLocation(50, 420); // �]�w���Ҧ�m
			lab32.setSize(650, 20); // �]�w���Ҥj�p
			lab32.setFont(new Font("Serief", Font.ITALIC
					+ Font.BOLD, 18));
			frm.add(lab32);
	
			lab33.setText("0不顯示λ、θ、g過程,1顯示 過程");
			lab33.setBackground(Color.white);
			lab33.setAlignmentX(Label.CENTER);
			lab33.setForeground(Color.blue);
			lab33.setLocation(480, 420); // �]�w���Ҧ�m
			lab33.setSize(300, 20); // �]�w���Ҥj�p
			lab33.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab33);
		
			
			lab6.setText("threshold");
			lab6.setBackground(Color.white);
			lab6.setAlignmentX(Label.CENTER);
			lab6.setForeground(Color.blue);
			lab6.setLocation(50, 460); // �]�w���Ҧ�m
			lab6.setSize(650, 20); // �]�w���Ҥj�p
			lab6.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab6);
			
			Read_LR_Parameter.main();
			
			txf24.setText(String.valueOf(Read_LR_Parameter.L()));
			txf33.setText(String.valueOf(Read_LR_Parameter.c()));
			txf34.setText(String.valueOf(Read_LR_Parameter.Print()));
			txf6.setText(String.valueOf(String.valueOf(new BigDecimal(
					String.valueOf(Read_LR_Parameter.threshold())).toPlainString())));
			txf24.setBounds(250, 340, 150, 20);
			txf33.setBounds(250, 380, 150, 20);
			txf34.setBounds(250, 420, 150, 20);
			txf6.setBounds(250, 460, 150, 20);
			frm.add(txf24);
			frm.add(txf33);
			frm.add(txf34);
			frm.add(txf6);
		}
		
	if (Algorithm.equals("TS_DA")) {
		
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
			lab38.setLocation(410, 200); // �]�w���Ҧ�m
			lab38.setSize(300, 20); // �]�w���Ҥj�p
			lab38.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab38);
			
			lab19.setText("x0");
			lab19.setBackground(Color.white);
			lab19.setAlignmentX(Label.CENTER);
			lab19.setForeground(Color.blue);
			lab19.setLocation(50, 240); // �]�w���Ҧ�m
			lab19.setSize(250, 20); // �]�w���Ҥj�p
			lab19.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab19);
			
			lab31.setText("Epsilon");
			lab31.setBackground(Color.white);
			lab31.setAlignmentX(Label.CENTER);
			lab31.setForeground(Color.blue);
			lab31.setLocation(50, 280); // �]�w���Ҧ�m
			lab31.setSize(250, 20); // �]�w���Ҥj�p
			lab31.setFont(new Font("Serief", Font.ITALIC
					+ Font.BOLD, 18));
			frm.add(lab31);
			
			lab32.setText("d0");
			lab32.setBackground(Color.white);
			lab32.setAlignmentX(Label.CENTER);
			lab32.setForeground(Color.blue);
			lab32.setLocation(50, 320); // �]�w���Ҧ�m
			lab32.setSize(250, 20); // �]�w���Ҥj�p
			lab32.setFont(new Font("Serief", Font.ITALIC
					+ Font.BOLD, 18));
			frm.add(lab32);
	
			lab33.setText("gp");
			lab33.setBackground(Color.white);
			lab33.setAlignmentX(Label.CENTER);
			lab33.setForeground(Color.blue);
			lab33.setLocation(50, 360); // �]�w���Ҧ�m
			lab33.setSize(250, 20); // �]�w���Ҥj�p
			lab33.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab33);
			
			lab6.setText("gs");
			lab6.setBackground(Color.white);
			lab6.setAlignmentX(Label.CENTER);
			lab6.setForeground(Color.blue);
			lab6.setLocation(50, 400); // �]�w���Ҧ�m
			lab6.setSize(250, 20); // �]�w���Ҥj�p
			lab6.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab6);
			
			lab7.setText("tabu_tenure_model");
			lab7.setBackground(Color.white);
			lab7.setAlignmentX(Label.CENTER);
			lab7.setForeground(Color.blue);
			lab7.setLocation(50, 440); // �]�w���Ҧ�m
			lab7.setSize(250, 20); // �]�w���Ҥj�p
			lab7.setFont(new Font("Serief", Font.ITALIC
					+ Font.BOLD, 18));
			frm.add(lab7);
			
			lab11.setText("1 執行內部設定的值 2執行下面設定的值");
			lab11.setBackground(Color.white);
			lab11.setAlignmentX(Label.CENTER);
			lab11.setForeground(Color.blue);
			lab11.setLocation(410, 440); // �]�w���Ҧ�m
			lab11.setSize(350, 20); // �]�w���Ҥj�p
			lab11.setFont(new Font("Serief", Font.ITALIC
					+ Font.BOLD, 18));
			frm.add(lab11);
			
			lab8.setText("ClearMaxIter");
			lab8.setBackground(Color.white);
			lab8.setAlignmentX(Label.CENTER);
			lab8.setForeground(Color.blue);
			lab8.setLocation(50, 480); // �]�w���Ҧ�m
			lab8.setSize(250, 20); // �]�w���Ҥj�p
			lab8.setFont(new Font("Serief", Font.ITALIC
					+ Font.BOLD, 18));
			frm.add(lab8);
	
			lab9.setText("MinTenure");
			lab9.setBackground(Color.white);
			lab9.setAlignmentX(Label.CENTER);
			lab9.setForeground(Color.blue);
			lab9.setLocation(50, 520); // �]�w���Ҧ�m
			lab9.setSize(250, 20); // �]�w���Ҥj�p
			lab9.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab9);
			
			lab10.setText("MaxTenure");
			lab10.setBackground(Color.white);
			lab10.setAlignmentX(Label.CENTER);
			lab10.setForeground(Color.blue);
			lab10.setLocation(50, 560); // �]�w���Ҧ�m
			lab10.setSize(250, 20); // �]�w���Ҥj�p
			lab10.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab10);
			
			Read_TS_Parameter.main();
			txf23.setText(String.valueOf(Read_TS_Parameter.Iteration()));
			txf37.setText(String.valueOf(Read_TS_Parameter.Iteration_Mode()));
			txf24.setText(String.valueOf(Read_TS_Parameter.x0()));
			txf33.setText(String.valueOf(Read_TS_Parameter.Epsilon()));
			txf34.setText(String.valueOf(Read_TS_Parameter.d0()));
			txf6.setText(String.valueOf(Read_TS_Parameter.gp()));	
			txf7.setText(String.valueOf(Read_TS_Parameter.gs()));	
			txf8.setText(String.valueOf(Read_TS_Parameter.tabu_tenure_model()));	
			txf9.setText(String.valueOf(Read_TS_Parameter.ClearMaxIter()));	
			txf10.setText(String.valueOf(Read_TS_Parameter.MinTenure()));	
			txf11.setText(String.valueOf(Read_TS_Parameter.MaxTenure()));	
			
			
			txf23.setBounds(250, 160, 150, 20);
			txf37.setBounds(250, 200, 150, 20);
			txf24.setBounds(250, 240, 150, 20);
			txf33.setBounds(250, 280, 150, 20);
			txf34.setBounds(250, 320, 150, 20);
			txf6.setBounds(250, 360, 150, 20);
			txf7.setBounds(250, 400, 150, 20);
			txf8.setBounds(250, 440, 150, 20);
			txf9.setBounds(250, 480, 150, 20);
			txf10.setBounds(250, 520, 150, 20);
			txf11.setBounds(250, 560, 150, 20);
			frm.add(txf23);
			frm.add(txf37);
			frm.add(txf24);
			frm.add(txf33);
			frm.add(txf34);
			frm.add(txf6);
			frm.add(txf7);
			frm.add(txf8);
			frm.add(txf9);
			frm.add(txf10);
			frm.add(txf11);
			
		}
	if (Algorithm.equals("DE_Tourism") || Algorithm.equals("DE_Tourism_strategy1") || Algorithm.equals("DE_Tourism_strategy2")  || Algorithm.equals("DE_Tourism_strategy3")
			|| Algorithm.equals("DE_Tourism_strategy4") || Algorithm.equals("DE_Tourism_strategy5") || Algorithm.equals("DE_Tourism_strategy6") ||
			Algorithm.equals("DE_Tourism_Real") || Algorithm.equals("DE_Tourism_strategy1_Real") || Algorithm.equals("DE_Tourism_strategy2_Real") 
			|| Algorithm.equals("DE_Tourism_strategy3_Real")|| Algorithm.equals("DE_Tourism_strategy4_Real") || Algorithm.equals("DE_Tourism_strategy5_Real") 
			|| Algorithm.equals("DE_Tourism_strategy6_Real") || Algorithm.equals("NSDE") || Algorithm.equals("SaNSDE") || Algorithm.equals("DECC") || Algorithm.equals("DE_Real_POP") 
			|| Algorithm.equals("DE_strategy1_Real_POP") || Algorithm.equals("DE_strategy2_Real_POP") || Algorithm.equals("DE_strategy3_Real_POP")
			|| Algorithm.equals("DE_strategy4_Real_POP") || Algorithm.equals("DE_strategy5_Real_POP") || Algorithm.equals("DE_strategy6_Real_POP") 
			|| Algorithm.equals("DE_Real_POP_NEW") || Algorithm.equals("DE_strategy1_Real_POP_NEW") || Algorithm.equals("DE_strategy2_Real_POP_NEW")
			|| Algorithm.equals("DE_strategy3_Real_POP_NEW") || Algorithm.equals("DE_strategy4_Real_POP_NEW") || Algorithm.equals("DE_strategy5_Real_POP_NEW")
			|| Algorithm.equals("DE_strategy6_Real_POP_NEW") || Algorithm.equals("DynDE")  || Algorithm.equals("DynDE_POP") || Algorithm.equals("L-SHADE") 
			|| Algorithm.equals("NSDE_POP") || Algorithm.equals("SaNSDE_POP") || Algorithm.equals("DECC_POP")  || Algorithm.equals("NSDE_POP_NEW") 
			|| Algorithm.equals("SaNSDE_POP_NEW") || Algorithm.equals("DECC_POP_NEW")) {
		
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
		lab31.setFont(new Font("Serief", Font.ITALIC
				+ Font.BOLD, 18));
		frm.add(lab31);
		
		lab32.setText("ε");
		lab32.setBackground(Color.white);
		lab32.setAlignmentX(Label.CENTER);
		lab32.setForeground(Color.blue);
		lab32.setLocation(50, 320); // �]�w���Ҧ�m
		lab32.setSize(250, 20); // �]�w���Ҥj�p
		lab32.setFont(new Font("Serief", Font.ITALIC
				+ Font.BOLD, 18));
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
		
		if (Algorithm.equals("DE_Tourism") || Algorithm.equals("DE_Tourism_strategy1") || Algorithm.equals("DE_Tourism_strategy2")  || Algorithm.equals("DE_Tourism_strategy3")
				|| Algorithm.equals("DE_Tourism_strategy4") || Algorithm.equals("DE_Tourism_strategy5") || Algorithm.equals("DE_Tourism_strategy6")){
		Read_DE_Parameter.main();
		txf23.setText(String.valueOf(Read_DE_Parameter.Iteration()));
		txf37.setText(String.valueOf(Read_DE_Parameter.Iteration_Mode()));
		txf24.setText(String.valueOf(Read_DE_Parameter.NP()));
		txf33.setText(String.valueOf(Read_DE_Parameter.LP()));
		txf34.setText(String.valueOf(Read_DE_Parameter.Epsilon()));
		txf6.setText(String.valueOf(Read_DE_Parameter.Execution_Mode()));	
		txf7.setText(String.valueOf(Read_DE_Parameter.write_Mode()));	
		}
		if (Algorithm.equals("DE_Tourism_Real") || Algorithm.equals("DE_Tourism_strategy1_Real") || Algorithm.equals("DE_Tourism_strategy2_Real") 
				|| Algorithm.equals("DE_Tourism_strategy3_Real")|| Algorithm.equals("DE_Tourism_strategy4_Real") || Algorithm.equals("DE_Tourism_strategy5_Real") 
				|| Algorithm.equals("DE_Tourism_strategy6_Real")) {
			Algorithm_Tourism.DE_Real_Tourism.DE_Read_Write_txt c1 = new Algorithm_Tourism.DE_Real_Tourism.DE_Read_Write_txt();
			c1.Read_DEReal_Parameter();
			txf23.setText(String.valueOf(c1.Iteration()));
			txf37.setText(String.valueOf(c1.Iteration_Mode()));
			txf24.setText(String.valueOf(c1.NP()));
			txf33.setText(String.valueOf(c1.LP()));
			txf34.setText(String.valueOf(c1.Epsilon()));
			txf6.setText(String.valueOf(c1.Execution_Mode()));
			txf7.setText(String.valueOf(c1.write_Mode()));
			txf8.setText(String.valueOf(c1.Vmax()));
			txf9.setText(String.valueOf(c1.lamda()));
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

			txf8.setBounds(250, 440, 150, 20);
			txf9.setBounds(250, 480, 150, 20);
			frm.add(txf8);
			frm.add(txf9);
			
		}
		if (Algorithm.equals("DE_Real_POP") || Algorithm.equals("DE_strategy1_Real_POP") || Algorithm.equals("DE_strategy2_Real_POP")
				|| Algorithm.equals("DE_strategy3_Real_POP") || Algorithm.equals("DE_strategy4_Real_POP") || Algorithm.equals("DE_strategy5_Real_POP")
				|| Algorithm.equals("DE_strategy6_Real_POP")) {

			Algorithm_Tourism.DE_Real_POP_Tourism.DE_Read_Write_txt c1 = new Algorithm_Tourism.DE_Real_POP_Tourism.DE_Read_Write_txt();
			c1.Read_DEReal_Parameter();
			txf23.setText(String.valueOf(c1.Iteration()));
			txf37.setText(String.valueOf(c1.Iteration_Mode()));
			txf24.setText(String.valueOf(c1.NP()));
			txf33.setText(String.valueOf(c1.LP()));
			txf34.setText(String.valueOf(c1.Epsilon()));
			txf6.setText(String.valueOf(c1.Execution_Mode()));
			txf7.setText(String.valueOf(c1.write_Mode()));
			txf8.setText(String.valueOf(c1.Vmax()));
			txf9.setText(String.valueOf(c1.lamda()));
			txf10.setText(String.valueOf(c1.Pmax()));
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

			lab36.setText("Pmax");
			lab36.setBackground(Color.white);
			lab36.setAlignmentX(Label.CENTER);
			lab36.setForeground(Color.blue);
			lab36.setLocation(450, 160); // �]�w���Ҧ�m
			lab36.setSize(250, 20); // �]�w���Ҥj�p
			lab36.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab36);

			txf8.setBounds(250, 440, 150, 20);
			txf9.setBounds(250, 480, 150, 20);
			txf10.setBounds(550, 160, 150, 20);
			frm.add(txf8);
			frm.add(txf9);
			frm.add(txf10);
		}
		if (Algorithm.equals("DE_Real_POP_NEW") || Algorithm.equals("DE_strategy1_Real_POP_NEW") || Algorithm.equals("DE_strategy2_Real_POP_NEW")
				|| Algorithm.equals("DE_strategy3_Real_POP_NEW") || Algorithm.equals("DE_strategy4_Real_POP_NEW") || Algorithm.equals("DE_strategy5_Real_POP_NEW")
				|| Algorithm.equals("DE_strategy6_Real_POP_NEW")) {

			Algorithm_Tourism.DE_Real_POP_NEW_Tourism.DE_Read_Write_txt c1 = new Algorithm_Tourism.DE_Real_POP_NEW_Tourism.DE_Read_Write_txt();
			c1.Read_DEReal_Parameter();
			txf23.setText(String.valueOf(c1.Iteration()));
			txf37.setText(String.valueOf(c1.Iteration_Mode()));
			txf24.setText(String.valueOf(c1.NP()));
			txf33.setText(String.valueOf(c1.LP()));
			txf34.setText(String.valueOf(c1.Epsilon()));
			txf6.setText(String.valueOf(c1.Execution_Mode()));
			txf7.setText(String.valueOf(c1.write_Mode()));
			txf8.setText(String.valueOf(c1.Vmax()));
			txf9.setText(String.valueOf(c1.lamda()));
			txf10.setText(String.valueOf(c1.Pmax()));
			txf11.setText(String.valueOf(c1.Pi()));
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

			lab36.setText("Pmax");
			lab36.setBackground(Color.white);
			lab36.setAlignmentX(Label.CENTER);
			lab36.setForeground(Color.blue);
			lab36.setLocation(450, 160); // �]�w���Ҧ�m
			lab36.setSize(250, 20); // �]�w���Ҥj�p
			lab36.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab36);

			lab20.setText("百分比π ");
			lab20.setBackground(Color.white);
			lab20.setAlignmentX(Label.CENTER);
			lab20.setForeground(Color.blue);
			lab20.setLocation(450, 240); // �]�w���Ҧ�m
			lab20.setSize(250, 20); // �]�w���Ҥj�p
			lab20.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab20);
			txf8.setBounds(250, 440, 150, 20);
			txf9.setBounds(250, 480, 150, 20);
			txf10.setBounds(550, 160, 150, 20);
			txf11.setBounds(550, 240, 150, 20);
			frm.add(txf8);
			frm.add(txf9);
			frm.add(txf10);
			frm.add(txf11);
		}
		if (Algorithm.equals("NSDE") ) {
			Algorithm_Tourism.NSDE_Tourism.DE_Read_Write_txt c1 = new Algorithm_Tourism.NSDE_Tourism.DE_Read_Write_txt();
			c1.Read_NSDE_Parameter();
			txf23.setText(String.valueOf(c1.Iteration()));
			txf37.setText(String.valueOf(c1.Iteration_Mode()));
			txf24.setText(String.valueOf(c1.NP()));
			txf33.setText(String.valueOf(c1.LP()));
		//	txf34.setText(String.valueOf(c1.Epsilon()));
			txf6.setText(String.valueOf(c1.Execution_Mode()));
			txf7.setText(String.valueOf(c1.write_Mode()));
			txf8.setText(String.valueOf(c1.Vmax()));
			txf9.setText(String.valueOf(c1.lamda()));
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

			txf8.setBounds(250, 440, 150, 20);
			txf9.setBounds(250, 480, 150, 20);
			frm.add(txf8);
			frm.add(txf9);
			frm.remove(txf34);
			frm.remove(lab32);
		}
		if (Algorithm.equals("NSDE_POP")) {

			Algorithm_Tourism.NSDE_POP_Tourism.DE_Read_Write_txt c1 = new Algorithm_Tourism.NSDE_POP_Tourism.DE_Read_Write_txt();
			c1.Read_NSDE_Parameter();
			txf23.setText(String.valueOf(c1.Iteration()));
			txf37.setText(String.valueOf(c1.Iteration_Mode()));
			txf24.setText(String.valueOf(c1.NP()));
			txf33.setText(String.valueOf(c1.LP()));

			txf6.setText(String.valueOf(c1.Execution_Mode()));
			txf7.setText(String.valueOf(c1.write_Mode()));
			txf8.setText(String.valueOf(c1.Vmax()));
			txf9.setText(String.valueOf(c1.lamda()));
			txf10.setText(String.valueOf(c1.Pmax()));

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

			lab36.setText("Pmax");
			lab36.setBackground(Color.white);
			lab36.setAlignmentX(Label.CENTER);
			lab36.setForeground(Color.blue);
			lab36.setLocation(450, 160); // �]�w���Ҧ�m
			lab36.setSize(250, 20); // �]�w���Ҥj�p
			lab36.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab36);

			txf8.setBounds(250, 440, 150, 20);
			txf9.setBounds(250, 480, 150, 20);
			txf10.setBounds(550, 160, 150, 20);
			frm.add(txf8);
			frm.add(txf9);
			frm.add(txf10);
			frm.remove(lab32);
			frm.remove(txf34);
		}
		if (Algorithm.equals("NSDE_POP_NEW")) {

			Algorithm_Tourism.NSDE_POP_NEW_Tourism.DE_Read_Write_txt c1 = new Algorithm_Tourism.NSDE_POP_NEW_Tourism.DE_Read_Write_txt();
			c1.Read_NSDE_Parameter();
			txf23.setText(String.valueOf(c1.Iteration()));
			txf37.setText(String.valueOf(c1.Iteration_Mode()));
			txf24.setText(String.valueOf(c1.NP()));
			txf33.setText(String.valueOf(c1.LP()));

			txf6.setText(String.valueOf(c1.Execution_Mode()));
			txf7.setText(String.valueOf(c1.write_Mode()));
			txf8.setText(String.valueOf(c1.Vmax()));
			txf9.setText(String.valueOf(c1.lamda()));
			txf10.setText(String.valueOf(c1.Pmax()));
			txf11.setText(String.valueOf(c1.Pi()));
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

			lab36.setText("Pmax");
			lab36.setBackground(Color.white);
			lab36.setAlignmentX(Label.CENTER);
			lab36.setForeground(Color.blue);
			lab36.setLocation(450, 160); // �]�w���Ҧ�m
			lab36.setSize(250, 20); // �]�w���Ҥj�p
			lab36.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab36);

			lab20.setText("百分比π ");
			lab20.setBackground(Color.white);
			lab20.setAlignmentX(Label.CENTER);
			lab20.setForeground(Color.blue);
			lab20.setLocation(450, 240); // �]�w���Ҧ�m
			lab20.setSize(250, 20); // �]�w���Ҥj�p
			lab20.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab20);
			txf8.setBounds(250, 440, 150, 20);
			txf9.setBounds(250, 480, 150, 20);
			txf10.setBounds(550, 160, 150, 20);
			txf11.setBounds(550, 240, 150, 20);
			frm.add(txf8);
			frm.add(txf9);
			frm.add(txf10);
			frm.add(txf11);
			frm.remove(lab32);
			frm.remove(txf34);
		}
		if (Algorithm.equals("SaNSDE") ) {
			Algorithm_Tourism.SaNSDE_Tourism.DE_Read_Write_txt c1 = new Algorithm_Tourism.SaNSDE_Tourism.DE_Read_Write_txt();
			c1.Read_SaNSDE_Parameter();
			txf23.setText(String.valueOf(c1.Iteration()));
			txf37.setText(String.valueOf(c1.Iteration_Mode()));
			txf24.setText(String.valueOf(c1.NP()));
			txf33.setText(String.valueOf(c1.LP()));
		//	txf34.setText(String.valueOf(c1.Epsilon()));
			txf6.setText(String.valueOf(c1.Execution_Mode()));
			txf7.setText(String.valueOf(c1.write_Mode()));
			txf8.setText(String.valueOf(c1.Vmax()));
			txf9.setText(String.valueOf(c1.lamda()));
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

			txf8.setBounds(250, 440, 150, 20);
			txf9.setBounds(250, 480, 150, 20);
			frm.add(txf8);
			frm.add(txf9);
			frm.remove(txf34);
			frm.remove(lab32);
		}
		if (Algorithm.equals("SaNSDE_POP")) {

			Algorithm_Tourism.SaNSDE_POP_Tourism.DE_Read_Write_txt c1 = new Algorithm_Tourism.SaNSDE_POP_Tourism.DE_Read_Write_txt();
			c1.Read_SaNSDE_Parameter();
			txf23.setText(String.valueOf(c1.Iteration()));
			txf37.setText(String.valueOf(c1.Iteration_Mode()));
			txf24.setText(String.valueOf(c1.NP()));
			txf33.setText(String.valueOf(c1.LP()));

			txf6.setText(String.valueOf(c1.Execution_Mode()));
			txf7.setText(String.valueOf(c1.write_Mode()));
			txf8.setText(String.valueOf(c1.Vmax()));
			txf9.setText(String.valueOf(c1.lamda()));
			txf10.setText(String.valueOf(c1.Pmax()));
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

			lab36.setText("Pmax");
			lab36.setBackground(Color.white);
			lab36.setAlignmentX(Label.CENTER);
			lab36.setForeground(Color.blue);
			lab36.setLocation(450, 160); // �]�w���Ҧ�m
			lab36.setSize(250, 20); // �]�w���Ҥj�p
			lab36.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab36);

			txf8.setBounds(250, 440, 150, 20);
			txf9.setBounds(250, 480, 150, 20);
			txf10.setBounds(550, 160, 150, 20);
			frm.add(txf8);
			frm.add(txf9);
			frm.add(txf10);
			frm.remove(lab32);
			frm.remove(txf34);
		}
		if (Algorithm.equals("SaNSDE_POP_NEW")) {

			Algorithm_Tourism.SaNSDE_POP_NEW_Tourism.DE_Read_Write_txt c1 = new Algorithm_Tourism.SaNSDE_POP_NEW_Tourism.DE_Read_Write_txt();
			c1.Read_SaNSDE_Parameter();
			txf23.setText(String.valueOf(c1.Iteration()));
			txf37.setText(String.valueOf(c1.Iteration_Mode()));
			txf24.setText(String.valueOf(c1.NP()));
			txf33.setText(String.valueOf(c1.LP()));

			txf6.setText(String.valueOf(c1.Execution_Mode()));
			txf7.setText(String.valueOf(c1.write_Mode()));
			txf8.setText(String.valueOf(c1.Vmax()));
			txf9.setText(String.valueOf(c1.lamda()));
			txf10.setText(String.valueOf(c1.Pmax()));
			txf11.setText(String.valueOf(c1.Pi()));
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

			lab36.setText("Pmax");
			lab36.setBackground(Color.white);
			lab36.setAlignmentX(Label.CENTER);
			lab36.setForeground(Color.blue);
			lab36.setLocation(450, 160); // �]�w���Ҧ�m
			lab36.setSize(250, 20); // �]�w���Ҥj�p
			lab36.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab36);
			lab20.setText("百分比π ");
			lab20.setBackground(Color.white);
			lab20.setAlignmentX(Label.CENTER);
			lab20.setForeground(Color.blue);
			lab20.setLocation(450, 240); // �]�w���Ҧ�m
			lab20.setSize(250, 20); // �]�w���Ҥj�p
			lab20.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab20);
			txf8.setBounds(250, 440, 150, 20);
			txf9.setBounds(250, 480, 150, 20);
			txf10.setBounds(550, 160, 150, 20);
			txf11.setBounds(550, 240, 150, 20);
			frm.add(txf8);
			frm.add(txf9);
			frm.add(txf10);
			frm.add(txf11);
			frm.remove(lab32);
			frm.remove(txf34);
		}
		if (Algorithm.equals("DECC")) {

			Algorithm_Tourism.DECC_Tourism.DE_Read_Write_txt c1 = new Algorithm_Tourism.DECC_Tourism.DE_Read_Write_txt();
			c1.Read_DECC_Parameter();
			txf23.setText(String.valueOf(c1.Iteration()));
			txf37.setText(String.valueOf(c1.Iteration_Mode()));
			txf24.setText(String.valueOf(c1.NP()));
			txf33.setText(String.valueOf(c1.LP()));
			txf1.setText(String.valueOf(c1.FEs()));
			txf6.setText(String.valueOf(c1.Execution_Mode()));
			txf7.setText(String.valueOf(c1.write_Mode()));
			txf8.setText(String.valueOf(c1.Vmax()));
			txf9.setText(String.valueOf(c1.lamda()));

			lab1.setText("FEs");
			lab1.setBackground(Color.white);
			lab1.setAlignmentX(Label.CENTER);
			lab1.setForeground(Color.blue);
			lab1.setLocation(50, 320); // �]�w���Ҧ�m
			lab1.setSize(250, 20); // �]�w���Ҥj�p
			lab1.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab1);

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

			txf1.setBounds(250, 320, 150, 20);
			txf8.setBounds(250, 440, 150, 20);
			txf9.setBounds(250, 480, 150, 20);
			frm.add(txf1);
			frm.add(txf8);
			frm.add(txf9);

			frm.remove(lab32);
			frm.remove(txf34);
		}
		if (Algorithm.equals("DECC_POP")) {

			Algorithm_Tourism.DECC_POP_Tourism.DE_Read_Write_txt c1 = new Algorithm_Tourism.DECC_POP_Tourism.DE_Read_Write_txt();
			c1.Read_DECC_Parameter();
			txf23.setText(String.valueOf(c1.Iteration()));
			txf37.setText(String.valueOf(c1.Iteration_Mode()));
			txf24.setText(String.valueOf(c1.NP()));
			txf33.setText(String.valueOf(c1.LP()));
			txf1.setText(String.valueOf(c1.FEs()));
			txf6.setText(String.valueOf(c1.Execution_Mode()));
			txf7.setText(String.valueOf(c1.write_Mode()));
			txf8.setText(String.valueOf(c1.Vmax()));
			txf9.setText(String.valueOf(c1.lamda()));
			txf10.setText(String.valueOf(c1.Pmax()));
			lab1.setText("FEs");
			lab1.setBackground(Color.white);
			lab1.setAlignmentX(Label.CENTER);
			lab1.setForeground(Color.blue);
			lab1.setLocation(50, 320); // �]�w���Ҧ�m
			lab1.setSize(250, 20); // �]�w���Ҥj�p
			lab1.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab1);

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
			lab36.setText("Pmax");
			lab36.setBackground(Color.white);
			lab36.setAlignmentX(Label.CENTER);
			lab36.setForeground(Color.blue);
			lab36.setLocation(450, 160); // �]�w���Ҧ�m
			lab36.setSize(250, 20); // �]�w���Ҥj�p
			lab36.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab36);
			txf1.setBounds(250, 320, 150, 20);
			txf8.setBounds(250, 440, 150, 20);
			txf9.setBounds(250, 480, 150, 20);
			txf10.setBounds(550, 160, 150, 20);
			frm.add(txf1);
			frm.add(txf8);
			frm.add(txf9);
			frm.add(txf10);
			frm.remove(lab32);
			frm.remove(txf34);
		}
		if (Algorithm.equals("DECC_POP_NEW")) {

			Algorithm_Tourism.DECC_POP_NEW_Tourism.DE_Read_Write_txt c1 = new Algorithm_Tourism.DECC_POP_NEW_Tourism.DE_Read_Write_txt();
			c1.Read_DECC_Parameter();
			txf23.setText(String.valueOf(c1.Iteration()));
			txf37.setText(String.valueOf(c1.Iteration_Mode()));
			txf24.setText(String.valueOf(c1.NP()));
			txf33.setText(String.valueOf(c1.LP()));
			txf1.setText(String.valueOf(c1.FEs()));
			txf6.setText(String.valueOf(c1.Execution_Mode()));
			txf7.setText(String.valueOf(c1.write_Mode()));
			txf8.setText(String.valueOf(c1.Vmax()));
			txf9.setText(String.valueOf(c1.lamda()));
			txf10.setText(String.valueOf(c1.Pmax()));
			txf11.setText(String.valueOf(c1.Pi()));
			lab1.setText("FEs");
			lab1.setBackground(Color.white);
			lab1.setAlignmentX(Label.CENTER);
			lab1.setForeground(Color.blue);
			lab1.setLocation(50, 320); // �]�w���Ҧ�m
			lab1.setSize(250, 20); // �]�w���Ҥj�p
			lab1.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab1);

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
			lab36.setText("Pmax");
			lab36.setBackground(Color.white);
			lab36.setAlignmentX(Label.CENTER);
			lab36.setForeground(Color.blue);
			lab36.setLocation(450, 160); // �]�w���Ҧ�m
			lab36.setSize(250, 20); // �]�w���Ҥj�p
			lab36.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab36);
			lab20.setText("百分比π ");
			lab20.setBackground(Color.white);
			lab20.setAlignmentX(Label.CENTER);
			lab20.setForeground(Color.blue);
			lab20.setLocation(450, 240); // �]�w���Ҧ�m
			lab20.setSize(250, 20); // �]�w���Ҥj�p
			lab20.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab20);
			txf1.setBounds(250, 320, 150, 20);
			txf8.setBounds(250, 440, 150, 20);
			txf9.setBounds(250, 480, 150, 20);
			txf10.setBounds(550, 160, 150, 20);
			txf11.setBounds(550, 240, 150, 20);
			frm.add(txf1);
			frm.add(txf8);
			frm.add(txf9);
			frm.add(txf10);
			frm.add(txf11);
			frm.remove(lab32);
			frm.remove(txf34);
		}
		if(Algorithm.equals("DynDE")){
			
			Algorithm_Tourism.DynDE_Tourism.DE_Read_Write_txt c1=new Algorithm_Tourism.DynDE_Tourism.DE_Read_Write_txt();
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
		if(Algorithm.equals("DynDE_POP")){
			
			Algorithm_Tourism.DynDE_POP_Tourism.DE_Read_Write_txt c1=new Algorithm_Tourism.DynDE_POP_Tourism.DE_Read_Write_txt();
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
			
			txf12.setText(String.valueOf(c1.Pmax()));
			
			txf13.setText(String.valueOf(c1.S()));
			txf14.setText(String.valueOf(c1.Mode1()));
			txf15.setText(String.valueOf(c1.Mode2()));
			txf16.setText(String.valueOf(c1.Mode3()));
			txf17.setText(String.valueOf(c1.Mode4()));
			
			lab1.setText("NP (每群數量) ");
			lab1.setBackground(Color.white);
			lab1.setAlignmentX(Label.CENTER);
			lab1.setForeground(Color.blue);
			lab1.setLocation(50, 240); // �]�w���Ҧ�m
			lab1.setSize(250, 20); // �]�w���Ҥj�p
			lab1.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab1);
			
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
			
			lab12.setText("Pmax");
			lab12.setBackground(Color.white);
			lab12.setAlignmentX(Label.CENTER);
			lab12.setForeground(Color.blue);
			lab12.setLocation(450, 160); // �]�w���Ҧ�m
			lab12.setSize(250, 20); // �]�w���Ҥj�p
			lab12.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab12);
			
			lab13.setText("S(群數)  ");
			lab13.setBackground(Color.white);
			lab13.setAlignmentX(Label.CENTER);
			lab13.setForeground(Color.blue);
			lab13.setLocation(450, 280); // �]�w���Ҧ�m
			lab13.setSize(250, 20); // �]�w���Ҥj�p
			lab13.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab13);
			
			lab2.setText("Mode1+Mode2+Mode3+Mode4=S");
			lab2.setBackground(Color.white);
			lab2.setAlignmentX(Label.CENTER);
			lab2.setForeground(Color.blue);
			lab2.setLocation(450, 320); // �]�w���Ҧ�m
			lab2.setSize(300, 20); // �]�w���Ҥj�p
			lab2.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab2);
			
			
			lab14.setText("No of Swarms with Mode1");
			lab14.setBackground(Color.white);
			lab14.setAlignmentX(Label.CENTER);
			lab14.setForeground(Color.blue);
			lab14.setLocation(450, 360); // �]�w���Ҧ�m
			lab14.setSize(250, 20); // �]�w���Ҥj�p
			lab14.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab14);
			
			lab15.setText("No of Swarms with Mode2");
			lab15.setBackground(Color.white);
			lab15.setAlignmentX(Label.CENTER);
			lab15.setForeground(Color.blue);
			lab15.setLocation(450, 400); // �]�w���Ҧ�m
			lab15.setSize(250, 20); // �]�w���Ҥj�p
			lab15.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab15);
			
			lab16.setText("No of Swarms with Mode3");
			lab16.setBackground(Color.white);
			lab16.setAlignmentX(Label.CENTER);
			lab16.setForeground(Color.blue);
			lab16.setLocation(450, 440); // �]�w���Ҧ�m
			lab16.setSize(250, 20); // �]�w���Ҥj�p
			lab16.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab16);
			
			lab17.setText("No of Swarms with Mode4");
			lab17.setBackground(Color.white);
			lab17.setAlignmentX(Label.CENTER);
			lab17.setForeground(Color.blue);
			lab17.setLocation(450, 480); // �]�w���Ҧ�m
			lab17.setSize(250, 20); // �]�w���Ҥj�p
			lab17.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab17);
			
			txf8.setBounds(250, 440, 150, 20);
			txf9.setBounds(250, 480, 150, 20);
			txf10.setBounds(250, 520, 150, 20);
			txf11.setBounds(250, 560, 150, 20);
			txf12.setBounds(700, 160, 150, 20);
			txf13.setBounds(700, 280, 150, 20);
			txf14.setBounds(700, 360, 150, 20);
			txf15.setBounds(700, 400, 150, 20);
			txf16.setBounds(700, 440, 150, 20);
			txf17.setBounds(700, 480, 150, 20);
			frm.add(txf8);
			frm.add(txf9);
			frm.add(txf10);
			frm.add(txf11);
			frm.add(txf12);
			frm.add(txf13);
			frm.add(txf14);
			frm.add(txf15);
			frm.add(txf16);
			frm.add(txf17);
			frm.remove(lab32);
			frm.remove(lab19);
		//	frm.remove(lab33);
			frm.remove(txf34);
			frm.remove(txf33);
			frm.remove(lab31);
		}
		if (Algorithm.equals("L-SHADE")) {

			Algorithm_Tourism.L_SHADE_Tourism.DE_Read_Write_txt c1 = new Algorithm_Tourism.L_SHADE_Tourism.DE_Read_Write_txt();
			c1.Read_L_SHADE_Parameter();
			txf23.setText(String.valueOf(c1.Iteration()));
			txf37.setText(String.valueOf(c1.Iteration_Mode()));
			txf24.setText(String.valueOf(c1.NP()));
			txf33.setText(String.valueOf(c1.LP()));

			txf6.setText(String.valueOf(c1.Execution_Mode()));
			txf7.setText(String.valueOf(c1.write_Mode()));
			txf8.setText(String.valueOf(c1.Vmax()));
			txf9.setText(String.valueOf(c1.lamda()));
			
			txf10.setText(String.valueOf(c1.H()));
			txf11.setText(String.valueOf(c1.Max_NFE()));
			txf12.setText(String.valueOf(c1.Nmin()));
			txf13.setText(String.valueOf(c1.MCR()));
			txf14.setText(String.valueOf(c1.MF()));
			
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

			lab41.setText("H");
			lab41.setBackground(Color.white);
			lab41.setAlignmentX(Label.CENTER);
			lab41.setForeground(Color.blue);
			lab41.setLocation(50, 520); // �]�w���Ҧ�m
			lab41.setSize(250, 20); // �]�w���Ҥj�p
			lab41.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab41);
			
			lab42.setText("Max_NFE");
			lab42.setBackground(Color.white);
			lab42.setAlignmentX(Label.CENTER);
			lab42.setForeground(Color.blue);
			lab42.setLocation(50, 560); // �]�w���Ҧ�m
			lab42.setSize(250, 20); // �]�w���Ҥj�p
			lab42.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab42);
			
			lab12.setText("Nmin");
			lab12.setBackground(Color.white);
			lab12.setAlignmentX(Label.CENTER);
			lab12.setForeground(Color.blue);
			lab12.setLocation(50, 600); // �]�w���Ҧ�m
			lab12.setSize(250, 20); // �]�w���Ҥj�p
			lab12.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab12);
			
			lab13.setText("MCR");
			lab13.setBackground(Color.white);
			lab13.setAlignmentX(Label.CENTER);
			lab13.setForeground(Color.blue);
			lab13.setLocation(50, 640); // �]�w���Ҧ�m
			lab13.setSize(250, 20); // �]�w���Ҥj�p
			lab13.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab13);
			
			lab14.setText("MF");
			lab14.setBackground(Color.white);
			lab14.setAlignmentX(Label.CENTER);
			lab14.setForeground(Color.blue);
			lab14.setLocation(50, 680); // �]�w���Ҧ�m
			lab14.setSize(250, 20); // �]�w���Ҥj�p
			lab14.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
			frm.add(lab14);				
			
			txf8.setBounds(250, 440, 150, 20);
			txf9.setBounds(250, 480, 150, 20);
			frm.add(txf8);
			frm.add(txf9);
			txf10.setBounds(250, 520, 150, 20);
			txf11.setBounds(250, 560, 150, 20);
			txf12.setBounds(250, 600, 150, 20);
			txf13.setBounds(250, 640, 150, 20);
			txf14.setBounds(250, 680, 150, 20);
			frm.add(txf10);
			frm.add(txf11);
			frm.add(txf12);
			frm.add(txf13);
			frm.add(txf14);
			frm.remove(lab32);
			frm.remove(txf34);
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
		new Set_Parameters_for_the_Selected_Algorithm_for_Tourism();
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(btn1)) {
			if (Algorithm.equals("GA1")) {
				try {
					Write_Parameter_for_Tourism.saveGA1(
							Integer.parseInt(txf36.getText()),
							Integer.parseInt(txf37.getText()),
							Double.parseDouble(txf1.getText()),
							Double.parseDouble(txf2.getText()),
							Double.parseDouble(txf3.getText()),
							Integer.parseInt(txf4.getText()),
							Integer.parseInt(txf5.getText()),
							Double.parseDouble(txf6.getText()),
							Integer.parseInt(txf7.getText()),
							Integer.parseInt(txf8.getText()),
							Integer.parseInt(txf9.getText()),
							Integer.parseInt(txf35.getText()),
							Double.parseDouble(txf10.getText()),
							Double.parseDouble(txf11.getText()),
							Integer.parseInt(txf20.getText()),
							Integer.parseInt(txf21.getText()),
							Integer.parseInt(txf22.getText()),
							Integer.parseInt(txf23.getText()),
							Integer.parseInt(txf24.getText()),
							Integer.parseInt(txf39.getText()),
							Integer.parseInt(txf40.getText()));
				} catch (NumberFormatException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		} else if (Algorithm.equals("GA2")) {
				try {
					Write_Parameter_for_Tourism.saveGA2(
							Integer.parseInt(txf36.getText()),
							Integer.parseInt(txf37.getText()),
							Double.parseDouble(txf1.getText()),
							Double.parseDouble(txf2.getText()),
							Double.parseDouble(txf3.getText()),
							Integer.parseInt(txf4.getText()),
							Integer.parseInt(txf5.getText()),
							Double.parseDouble(txf6.getText()),
							Integer.parseInt(txf7.getText()),
							Integer.parseInt(txf8.getText()),
							Integer.parseInt(txf9.getText()),
							Integer.parseInt(txf35.getText()),
							Double.parseDouble(txf10.getText()),
							Double.parseDouble(txf11.getText()));
				} catch (NumberFormatException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					}

			else if (Algorithm.equals("PSO1")) {

				try {
					Write_Parameter_for_Tourism.savePSO1(
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
								Double.parseDouble(txf17.getText()),
								Integer.parseInt(txf20.getText()),
								Integer.parseInt(txf21.getText()),
								Integer.parseInt(txf22.getText()),
								Integer.parseInt(txf23.getText()),
								Integer.parseInt(txf24.getText()),
								Integer.parseInt(txf39.getText()),
								Integer.parseInt(txf40.getText()));
				} catch (NumberFormatException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			else if (Algorithm.equals("PSO2")) {
				try {
					Write_Parameter_for_Tourism.savePSO2(
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
								Double.parseDouble(txf39.getText())
								);
				} catch (NumberFormatException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}else if (Algorithm.equals("ALPSO")) {
				try {
					Write_Parameter_for_Tourism.saveALPSO(
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
								Integer.parseInt(txf20.getText()),
								Integer.parseInt(txf21.getText()),
								Integer.parseInt(txf22.getText()),
								Integer.parseInt(txf23.getText()),
								Integer.parseInt(txf24.getText()),
								Integer.parseInt(txf39.getText()),
								Integer.parseInt(txf40.getText()),
								Double.parseDouble(txf33.getText()),
								Integer.parseInt(txf34.getText()));
				} catch (NumberFormatException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			else if (Algorithm.equals("LRPSO")) {
				try {
					Write_Parameter_for_Tourism.saveLRPSO(
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
								Integer.parseInt(txf34.getText()));
				} catch (NumberFormatException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
						}
			else if (Algorithm.equals("LR")) {
				try {
					Write_Parameter_for_Tourism.saveLR(
								Double.parseDouble(txf24.getText()),
								Double.parseDouble(txf33.getText()),
								Integer.parseInt(txf34.getText()),Double.parseDouble(txf6.getText()));
				} catch (NumberFormatException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
				else if (Algorithm.equals("LR_and_PSO2")) {
				try {	
					Write_Parameter_for_Tourism.saveLR_and_PSO2(
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
								Integer.parseInt(txf34.getText()));
				} catch (NumberFormatException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			if (Algorithm.equals("LR_and_PSO1")) {
				try {
					Write_Parameter_for_Tourism.saveLR_and_PSO1(
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
								Integer.parseInt(txf20.getText()),
								Integer.parseInt(txf21.getText()),
								Integer.parseInt(txf22.getText()),
								Integer.parseInt(txf23.getText()),
								Integer.parseInt(txf24.getText()),
								Integer.parseInt(txf39.getText()),
								Integer.parseInt(txf40.getText()),
							Double.parseDouble(txf32.getText()),
							Double.parseDouble(txf33.getText()),
							Integer.parseInt(txf34.getText()));
				} catch (NumberFormatException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			else if (Algorithm.equals("CCPSO2")) {
				try {
					Write_Parameter_for_Tourism.saveCCPSO2(
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
								Double.parseDouble(txf39.getText()),
								Double.parseDouble(txf40.getText()),
								Double.parseDouble(txf41.getText()),
								Double.parseDouble(txf42.getText())
								);
				} catch (NumberFormatException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}	
			else if (Algorithm.equals("FA_PSO")) {
				try {
					Write_Parameter_for_Tourism.saveFA_PSO(
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
				}
			}
			else if (Algorithm.equals("FA")) {
				try {
					Write_Parameter_for_Tourism.saveFA(
							Integer.parseInt(txf36.getText()),
							Integer.parseInt(txf37.getText()),
							Integer.parseInt(txf1.getText()),
						 
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
				}
			}
			else if (Algorithm.equals("TS_DA")) {
				try {
					Write_Parameter_for_Tourism.saveTS(
								Integer.parseInt(txf23.getText()),
								Integer.parseInt(txf37.getText()),
								Double.parseDouble(txf24.getText()),
								Double.parseDouble(txf33.getText()),
								Integer.parseInt(txf34.getText()),
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
				}else if (Algorithm.equals("DE_Tourism")) {
				try {
					Write_Parameter_for_Tourism.saveDE(
								Integer.parseInt(txf23.getText()),
								Integer.parseInt(txf37.getText()),
								Integer.parseInt(txf24.getText()),
								Integer.parseInt(txf33.getText()),
								Double.parseDouble(txf34.getText()),
								Integer.parseInt(txf6.getText()),
								Integer.parseInt(txf7.getText())
								); 
				} catch (NumberFormatException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}else if (Algorithm.equals("DE_Tourism_strategy1")) {
				try {

					Write_Parameter_for_Tourism.saveDE_strategy1(
								Integer.parseInt(txf23.getText()),
								Integer.parseInt(txf37.getText()),
								Integer.parseInt(txf24.getText()),
								Integer.parseInt(txf33.getText()),
								Double.parseDouble(txf34.getText()),
								Integer.parseInt(txf6.getText()),
								Integer.parseInt(txf7.getText())
								);
				} catch (NumberFormatException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}else if (Algorithm.equals("DE_Tourism_strategy2")) {
				try {
					Write_Parameter_for_Tourism.saveDE_strategy2(
								Integer.parseInt(txf23.getText()),
								Integer.parseInt(txf37.getText()),
								Integer.parseInt(txf24.getText()),
								Integer.parseInt(txf33.getText()),
								Double.parseDouble(txf34.getText()),
								Integer.parseInt(txf6.getText()),
								Integer.parseInt(txf7.getText())
								);
				} catch (NumberFormatException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}else if (Algorithm.equals("DE_Tourism_strategy3")) {
				try {
					Write_Parameter_for_Tourism.saveDE_strategy3(
								Integer.parseInt(txf23.getText()),
								Integer.parseInt(txf37.getText()),
								Integer.parseInt(txf24.getText()),
								Integer.parseInt(txf33.getText()),
								Double.parseDouble(txf34.getText()),
								Integer.parseInt(txf6.getText()),
								Integer.parseInt(txf7.getText())
								);
				} catch (NumberFormatException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}else if (Algorithm.equals("DE_Tourism_strategy4")) {
				try {
					Write_Parameter_for_Tourism.saveDE_strategy4(
								Integer.parseInt(txf23.getText()),
								Integer.parseInt(txf37.getText()),
								Integer.parseInt(txf24.getText()),
								Integer.parseInt(txf33.getText()),
								Double.parseDouble(txf34.getText()),
								Integer.parseInt(txf6.getText()),
								Integer.parseInt(txf7.getText())
								);
				} catch (NumberFormatException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}else if (Algorithm.equals("DE_Tourism_strategy5")) {
				try {
					Write_Parameter_for_Tourism.saveDE_strategy5(
								Integer.parseInt(txf23.getText()),
								Integer.parseInt(txf37.getText()),
								Integer.parseInt(txf24.getText()),
								Integer.parseInt(txf33.getText()),
								Double.parseDouble(txf34.getText()),
								Integer.parseInt(txf6.getText()),
								Integer.parseInt(txf7.getText())
								);
				} catch (NumberFormatException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}else if (Algorithm.equals("DE_Tourism_strategy6")) {
			try {
				Write_Parameter_for_Tourism.saveDE_strategy6(
							Integer.parseInt(txf23.getText()),
							Integer.parseInt(txf37.getText()),
							Integer.parseInt(txf24.getText()),
							Integer.parseInt(txf33.getText()),
							Double.parseDouble(txf34.getText()),
							Integer.parseInt(txf6.getText()),
							Integer.parseInt(txf7.getText())
							);
			} catch (NumberFormatException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if (Algorithm.equals("PSO_TS")) {
			try {
				Write_Parameter_for_Tourism.savePSO_TS(
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
							Double.parseDouble(txf8.getText())
							);
			} catch (NumberFormatException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
			}else if (Algorithm.equals("DE_Tourism_Real")) {
				try {
					Write_Parameter_for_Tourism.saveDE_Real(
								Integer.parseInt(txf23.getText()),
								Integer.parseInt(txf37.getText()),
								Integer.parseInt(txf24.getText()),
								Integer.parseInt(txf33.getText()),
								Double.parseDouble(txf34.getText()),
								Integer.parseInt(txf6.getText()),
								Integer.parseInt(txf7.getText()),
								Integer.parseInt(txf8.getText()),
								Double.parseDouble(txf9.getText())
								); 
				} catch (NumberFormatException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			else if (Algorithm.equals("DE_Tourism_strategy1_Real")) {
				try {
					Write_Parameter_for_Tourism.saveDE_strategy1_Real(
								Integer.parseInt(txf23.getText()),
								Integer.parseInt(txf37.getText()),
								Integer.parseInt(txf24.getText()),
								Integer.parseInt(txf33.getText()),
								Double.parseDouble(txf34.getText()),
								Integer.parseInt(txf6.getText()),
								Integer.parseInt(txf7.getText()),
								Integer.parseInt(txf8.getText()),
								Double.parseDouble(txf9.getText())
								); 
				} catch (NumberFormatException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			else if (Algorithm.equals("DE_Tourism_strategy2_Real")) {
				try {
					Write_Parameter_for_Tourism.saveDE_strategy2_Real(
								Integer.parseInt(txf23.getText()),
								Integer.parseInt(txf37.getText()),
								Integer.parseInt(txf24.getText()),
								Integer.parseInt(txf33.getText()),
								Double.parseDouble(txf34.getText()),
								Integer.parseInt(txf6.getText()),
								Integer.parseInt(txf7.getText()),
								Integer.parseInt(txf8.getText()),
								Double.parseDouble(txf9.getText())
								); 
				} catch (NumberFormatException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			else if (Algorithm.equals("DE_Tourism_strategy3_Real")) {
				try {
					Write_Parameter_for_Tourism.saveDE_strategy3_Real(
								Integer.parseInt(txf23.getText()),
								Integer.parseInt(txf37.getText()),
								Integer.parseInt(txf24.getText()),
								Integer.parseInt(txf33.getText()),
								Double.parseDouble(txf34.getText()),
								Integer.parseInt(txf6.getText()),
								Integer.parseInt(txf7.getText()),
								Integer.parseInt(txf8.getText()),
								Double.parseDouble(txf9.getText())
								); 
				} catch (NumberFormatException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			else if (Algorithm.equals("DE_Tourism_strategy4_Real")) {
				try {
					Write_Parameter_for_Tourism.saveDE_strategy4_Real(
								Integer.parseInt(txf23.getText()),
								Integer.parseInt(txf37.getText()),
								Integer.parseInt(txf24.getText()),
								Integer.parseInt(txf33.getText()),
								Double.parseDouble(txf34.getText()),
								Integer.parseInt(txf6.getText()),
								Integer.parseInt(txf7.getText()),
								Integer.parseInt(txf8.getText()),
								Double.parseDouble(txf9.getText())
								); 
				} catch (NumberFormatException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			else if (Algorithm.equals("DE_Tourism_strategy5_Real")) {
				try {
					Write_Parameter_for_Tourism.saveDE_strategy5_Real(
								Integer.parseInt(txf23.getText()),
								Integer.parseInt(txf37.getText()),
								Integer.parseInt(txf24.getText()),
								Integer.parseInt(txf33.getText()),
								Double.parseDouble(txf34.getText()),
								Integer.parseInt(txf6.getText()),
								Integer.parseInt(txf7.getText()),
								Integer.parseInt(txf8.getText()),
								Double.parseDouble(txf9.getText())
								); 
				} catch (NumberFormatException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			else if (Algorithm.equals("DE_Tourism_strategy6_Real")) {
				try {
					Write_Parameter_for_Tourism.saveDE_strategy6_Real(
								Integer.parseInt(txf23.getText()),
								Integer.parseInt(txf37.getText()),
								Integer.parseInt(txf24.getText()),
								Integer.parseInt(txf33.getText()),
								Double.parseDouble(txf34.getText()),
								Integer.parseInt(txf6.getText()),
								Integer.parseInt(txf7.getText()),
								Integer.parseInt(txf8.getText()),
								Double.parseDouble(txf9.getText())
								); 
				} catch (NumberFormatException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			else if (Algorithm.equals("NSDE")) {
				try {
					Write_Parameter_for_Tourism.saveNSDE(
								Integer.parseInt(txf23.getText()),
								Integer.parseInt(txf37.getText()),
								Integer.parseInt(txf24.getText()),
								Integer.parseInt(txf33.getText()),
								
								Integer.parseInt(txf6.getText()),
								Integer.parseInt(txf7.getText()),
								Integer.parseInt(txf8.getText()),
								Double.parseDouble(txf9.getText())
								); 
				} catch (NumberFormatException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			else if (Algorithm.equals("SaNSDE")) {
				try {
					Write_Parameter_for_Tourism.saveSaNSDE(
								Integer.parseInt(txf23.getText()),
								Integer.parseInt(txf37.getText()),
								Integer.parseInt(txf24.getText()),
								Integer.parseInt(txf33.getText()),
								
								Integer.parseInt(txf6.getText()),
								Integer.parseInt(txf7.getText()),
								Integer.parseInt(txf8.getText()),
								Double.parseDouble(txf9.getText())
								); 
				} catch (NumberFormatException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			else if (Algorithm.equals("DECC")) {
				try {
					Write_Parameter_for_Tourism.saveDECC(
							Integer.parseInt(txf23.getText()),
							Integer.parseInt(txf37.getText()),
							Integer.parseInt(txf24.getText()),
							Integer.parseInt(txf33.getText()),
							Integer.parseInt(txf1.getText()),
							Integer.parseInt(txf6.getText()),
							Integer.parseInt(txf7.getText()),
							Integer.parseInt(txf8.getText()),
							Double.parseDouble(txf9.getText()));
				} catch (NumberFormatException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else if (Algorithm.equals("DE_Real_POP") || Algorithm.equals("DE_strategy1_Real_POP") || Algorithm.equals("DE_strategy2_Real_POP")
					|| Algorithm.equals("DE_strategy3_Real_POP") || Algorithm.equals("DE_strategy4_Real_POP") || Algorithm.equals("DE_strategy5_Real_POP")
					|| Algorithm.equals("DE_strategy6_Real_POP")) {
				try {
					Write_Parameter_for_Tourism.saveDE_Real_POP(
							Integer.parseInt(txf23.getText()),
							Integer.parseInt(txf37.getText()),
							Integer.parseInt(txf24.getText()),
							Integer.parseInt(txf33.getText()),
							Double.parseDouble(txf34.getText()),
							Integer.parseInt(txf6.getText()),
							Integer.parseInt(txf7.getText()),
							Integer.parseInt(txf8.getText()),
							Double.parseDouble(txf9.getText()),
							Integer.parseInt(txf10.getText())
							);
				} catch (NumberFormatException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else if (Algorithm.equals("DE_Real_POP_NEW") || Algorithm.equals("DE_strategy1_Real_POP_NEW") || Algorithm.equals("DE_strategy2_Real_POP_NEW")
					|| Algorithm.equals("DE_strategy3_Real_POP_NEW") || Algorithm.equals("DE_strategy4_Real_POP_NEW") || Algorithm.equals("DE_strategy5_Real_POP_NEW")
					|| Algorithm.equals("DE_strategy6_Real_POP_NEW")) {
				try {
					Write_Parameter_for_Tourism.saveDE_Real_POP_NEW(
							Integer.parseInt(txf23.getText()),
							Integer.parseInt(txf37.getText()),
							Integer.parseInt(txf24.getText()),
							Integer.parseInt(txf33.getText()),
							Double.parseDouble(txf34.getText()),
							Integer.parseInt(txf6.getText()),
							Integer.parseInt(txf7.getText()),
							Integer.parseInt(txf8.getText()),
							Double.parseDouble(txf9.getText()),
							Integer.parseInt(txf10.getText()),
							Double.parseDouble(txf11.getText())
							);
				} catch (NumberFormatException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("DynDE")) {
				try {
					Write_Parameter_for_Tourism.saveDynDE(
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
			if (Algorithm.equals("DynDE_POP")) {
				try {
					Write_Parameter_for_Tourism.saveDynDE_POP(
							Integer.parseInt(txf23.getText()),
							Integer.parseInt(txf37.getText()),
							Integer.parseInt(txf24.getText()),
						//	Integer.parseInt(txf33.getText()),
						
							Integer.parseInt(txf6.getText()),
							Integer.parseInt(txf7.getText()),
							Integer.parseInt(txf8.getText()),
							Double.parseDouble(txf9.getText()),
							Double.parseDouble(txf10.getText()),
							Double.parseDouble(txf11.getText()),
							Integer.parseInt(txf12.getText()),
							Integer.parseInt(txf13.getText()),
							Integer.parseInt(txf14.getText()),
							Integer.parseInt(txf15.getText()),
							Integer.parseInt(txf16.getText()),
							Integer.parseInt(txf17.getText())
							);
				} catch (NumberFormatException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("ALPSO2_NEW")) {
				try {
					Write_Parameter_for_Tourism.saveALPSO2_NEW(
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
								Double.parseDouble(txf39.getText()),
								Double.parseDouble(txf40.getText()),
								Integer.parseInt(txf41.getText())
								);
					}
					catch (NumberFormatException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			if (Algorithm.equals("ALPSO2_NEW_PrematureConvegence1")) {
				try {
					Write_Parameter_for_Tourism.saveALPSO2_NEW_PrematureConvegence1(
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
								Double.parseDouble(txf39.getText()),
								Double.parseDouble(txf40.getText()),
								Integer.parseInt(txf41.getText())
								);
					}
					catch (NumberFormatException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			if (Algorithm.equals("DMS-L-PSO")) {
				try {
					Write_Parameter_for_Tourism.saveDMS_L_PSO2(
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
								Double.parseDouble(txf39.getText()),
								Integer.parseInt(txf40.getText()),
								Integer.parseInt(txf41.getText()),
								Integer.parseInt(txf42.getText())
								);
					}
					catch (NumberFormatException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			if (Algorithm.equals("DMSDL-PSO")) {
				try {
					Write_Parameter_for_Tourism.saveDMSDL_PSO2(
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
								Double.parseDouble(txf39.getText()),
								Integer.parseInt(txf40.getText()),
								Integer.parseInt(txf41.getText()),
								Integer.parseInt(txf42.getText())
								);
					}
					catch (NumberFormatException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			if (Algorithm.equals("NLPSO2")) {
				try {
					Write_Parameter_for_Tourism.saveNLPSO2(
								Integer.parseInt(txf36.getText()),
								Integer.parseInt(txf37.getText()),
								Integer.parseInt(txf1.getText()),
								Double.parseDouble(txf2.getText()),
								Double.parseDouble(txf3.getText()),
							//	Double.parseDouble(txf4.getText()),
								Integer.parseInt(txf5.getText()),
								Integer.parseInt(txf6.getText()),
								Integer.parseInt(txf7.getText()),
								Integer.parseInt(txf35.getText()),
								Double.parseDouble(txf8.getText()),
								Double.parseDouble(txf39.getText()),
								Double.parseDouble(txf40.getText()),
								Double.parseDouble(txf41.getText()),
								Double.parseDouble(txf42.getText()),
								Double.parseDouble(txf43.getText())
								);
					}
					catch (NumberFormatException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			if (Algorithm.equals("CLPSO2")) {
				try {
					Write_Parameter_for_Tourism.saveCLPSO2(
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
							Double.parseDouble(txf39.getText()),
							Double.parseDouble(txf40.getText()));
				} catch (NumberFormatException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("CC-CLPSO2")) {
				try {
					Write_Parameter_for_Tourism.saveCC_CLPSO2(
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
							Double.parseDouble(txf39.getText()),
							Double.parseDouble(txf40.getText()));
				} catch (NumberFormatException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			 if (Algorithm.equals("L-SHADE")) {
				try {
					Write_Parameter_for_Tourism.saveL_SHADE(
							Integer.parseInt(txf23.getText()),
							Integer.parseInt(txf37.getText()),
							Integer.parseInt(txf24.getText()),
							Integer.parseInt(txf33.getText()),

							Integer.parseInt(txf6.getText()),
							Integer.parseInt(txf7.getText()),
							Integer.parseInt(txf8.getText()),
							Double.parseDouble(txf9.getText()),
							Integer.parseInt(txf10.getText()),
							Double.parseDouble(txf11.getText()),
							Integer.parseInt(txf12.getText()),
							Double.parseDouble(txf13.getText()),
							Double.parseDouble(txf14.getText())
							);
				} catch (NumberFormatException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			 if (Algorithm.equals("L_SHADE_CCPSO2")) {
					try {
						Write_Parameter_for_Tourism.saveL_SHADE_CCPSO2(
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
								Double.parseDouble(txf39.getText()),
								Double.parseDouble(txf40.getText()),
								Double.parseDouble(txf41.getText()),
								Double.parseDouble(txf42.getText()),
								Integer.parseInt(txf43.getText())
								);
					} catch (NumberFormatException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			 if (Algorithm.equals("NSDE_POP")) {
					try {
						Write_Parameter_for_Tourism.saveNSDE_POP(
								Integer.parseInt(txf23.getText()),
								Integer.parseInt(txf37.getText()),
								Integer.parseInt(txf24.getText()),
								Integer.parseInt(txf33.getText()),

								Integer.parseInt(txf6.getText()),
								Integer.parseInt(txf7.getText()),
								Integer.parseInt(txf8.getText()),
								Double.parseDouble(txf9.getText()),
								Integer.parseInt(txf10.getText()));
					} catch (NumberFormatException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			 if (Algorithm.equals("SaNSDE_POP")) {
					try {
						Write_Parameter_for_Tourism.saveSaNSDE_POP(
								Integer.parseInt(txf23.getText()),
								Integer.parseInt(txf37.getText()),
								Integer.parseInt(txf24.getText()),
								Integer.parseInt(txf33.getText()),

								Integer.parseInt(txf6.getText()),
								Integer.parseInt(txf7.getText()),
								Integer.parseInt(txf8.getText()),
								Double.parseDouble(txf9.getText()),
								Integer.parseInt(txf10.getText()));
					} catch (NumberFormatException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			 if (Algorithm.equals("DECC_POP")) {
					try {
						Write_Parameter_for_Tourism.saveDECC_POP(
								Integer.parseInt(txf23.getText()),
								Integer.parseInt(txf37.getText()),
								Integer.parseInt(txf24.getText()),
								Integer.parseInt(txf33.getText()),
								Integer.parseInt(txf1.getText()),
								Integer.parseInt(txf6.getText()),
								Integer.parseInt(txf7.getText()),
								Integer.parseInt(txf8.getText()),
								Double.parseDouble(txf9.getText()),
								Integer.parseInt(txf10.getText()));
					} catch (NumberFormatException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			 if (Algorithm.equals("NSDE_POP_NEW")) {
					try {
						Write_Parameter_for_Tourism.saveNSDE_POP_NEW(
								Integer.parseInt(txf23.getText()),
								Integer.parseInt(txf37.getText()),
								Integer.parseInt(txf24.getText()),
								Integer.parseInt(txf33.getText()),

								Integer.parseInt(txf6.getText()),
								Integer.parseInt(txf7.getText()),
								Integer.parseInt(txf8.getText()),
								Double.parseDouble(txf9.getText()),
								Integer.parseInt(txf10.getText()),
								Double.parseDouble(txf11.getText()));
					} catch (NumberFormatException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			 if (Algorithm.equals("SaNSDE_POP_NEW")) {
					try {
						Write_Parameter_for_Tourism.saveSaNSDE_POP_NEW(
								Integer.parseInt(txf23.getText()),
								Integer.parseInt(txf37.getText()),
								Integer.parseInt(txf24.getText()),
								Integer.parseInt(txf33.getText()),

								Integer.parseInt(txf6.getText()),
								Integer.parseInt(txf7.getText()),
								Integer.parseInt(txf8.getText()),
								Double.parseDouble(txf9.getText()),
								Integer.parseInt(txf10.getText()),
								Double.parseDouble(txf11.getText()));
					} catch (NumberFormatException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			 if (Algorithm.equals("DECC_POP_NEW")) {
					try {
						Write_Parameter_for_Tourism.saveDECC_POP_NEW(
								Integer.parseInt(txf23.getText()),
								Integer.parseInt(txf37.getText()),
								Integer.parseInt(txf24.getText()),
								Integer.parseInt(txf33.getText()),
								Integer.parseInt(txf1.getText()),
								Integer.parseInt(txf6.getText()),
								Integer.parseInt(txf7.getText()),
								Integer.parseInt(txf8.getText()),
								Double.parseDouble(txf9.getText()),
								Integer.parseInt(txf10.getText()),
								Double.parseDouble(txf11.getText()));
					} catch (NumberFormatException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
		}
		frm.setVisible(false);
	}
}
