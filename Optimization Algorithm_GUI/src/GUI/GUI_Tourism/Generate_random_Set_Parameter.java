package GUI.GUI_Tourism;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Generate_random_data.Read_Generate_random_Tourism;
import Input_Output_txt.Tourism.Write_Tourism_Parameter;

public class Generate_random_Set_Parameter implements ActionListener  {
	
	JFrame frm = new JFrame("Set_Tourism_Parameter");
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
	
	JButton btn1 = new JButton("SAVE");


	Generate_random_Set_Parameter() {
		
		Read_Generate_random_Tourism.main();
		
		frm.setSize(400,700); // 設定視窗的大小為 200*150
		frm.setLocation(100, 50); // 設定視窗位置為(100,50)
		frm.setLayout(null);

		lab1.setText("買方數量(N) :");
		lab1.setBackground(Color.white);
		// lab1.setAlignment(Label.CENTER);
		lab1.setForeground(Color.blue);
		lab1.setLocation(60, 10); // �]�w���Ҧ�m
		lab1.setSize(180, 120); // �]�w���Ҥj�p
		lab1.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
		frm.add(lab1);

		lab2.setText("買方底價價格 :");
		lab2.setBackground(Color.white);
		// lab2.setAlignment(Label.CENTER);
		lab2.setForeground(Color.blue);
		lab2.setLocation(60, 60); // �]�w���Ҧ�m
		lab2.setSize(180, 120); // �]�w���Ҥj�p
		lab2.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
		frm.add(lab2);

		lab3.setText("旅行社業者數量(Ia) :");
		lab3.setBackground(Color.white);
		// lab2.setAlignment(Label.CENTER);
		lab3.setForeground(Color.blue);
		lab3.setLocation(60, 110); // �]�w���Ҧ�m
		lab3.setSize(180, 120); // �]�w���Ҥj�p
		lab3.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
		frm.add(lab3);

		lab4.setText("景點數量(K):");
		lab4.setBackground(Color.white);
		// lab2.setAlignment(Label.CENTER);
		lab4.setForeground(Color.blue);
		lab4.setLocation(60, 160); // �]�w���Ҧ�m
		lab4.setSize(180, 120); // �]�w���Ҥj�p
		lab4.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
		frm.add(lab4);
		
		lab5.setText("景點人數上限(K_top):");
		lab5.setBackground(Color.white);
		// lab2.setAlignment(Label.CENTER);
		lab5.setForeground(Color.blue);
		lab5.setLocation(60, 210); // �]�w���Ҧ�m
		lab5.setSize(200, 120); // �]�w���Ҥj�p
		lab5.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
		frm.add(lab5);
		
		lab6.setText("旅館業者數量(Ih):");
		lab6.setBackground(Color.white);
		// lab2.setAlignment(Label.CENTER);
		lab6.setForeground(Color.blue);
		lab6.setLocation(60, 260); // �]�w���Ҧ�m
		lab6.setSize(200, 120); // �]�w���Ҥj�p
		lab6.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
		frm.add(lab6);
		
		lab7.setText("旅館數量(M):");
		lab7.setBackground(Color.white);
		// lab2.setAlignment(Label.CENTER);
		lab7.setForeground(Color.blue);
		lab7.setLocation(60, 310); // �]�w���Ҧ�m
		lab7.setSize(200, 120); // �]�w���Ҥj�p
		lab7.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
		frm.add(lab7);
		
		lab8.setText("旅館可容上限(M_top):");
		lab8.setBackground(Color.white);
		// lab2.setAlignment(Label.CENTER);
		lab8.setForeground(Color.blue);
		lab8.setLocation(60, 360); // �]�w���Ҧ�m
		lab8.setSize(200, 120); // �]�w���Ҥj�p
		lab8.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
		frm.add(lab8);
		
		lab9.setText("運輸業者數量(It):");
		lab9.setBackground(Color.white);
		// lab2.setAlignment(Label.CENTER);
		lab9.setForeground(Color.blue);
		lab9.setLocation(60, 410); // �]�w���Ҧ�m
		lab9.setSize(200, 120); // �]�w���Ҥj�p
		lab9.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
		frm.add(lab9);
		
		lab10.setText("運輸數量(T):");
		lab10.setBackground(Color.white);
		// lab2.setAlignment(Label.CENTER);
		lab10.setForeground(Color.blue);
		lab10.setLocation(60, 460); // �]�w���Ҧ�m
		lab10.setSize(200, 120); // �]�w���Ҥj�p
		lab10.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
		frm.add(lab10);
		
		lab11.setText("運輸可容上限(T_top):");
		lab11.setBackground(Color.white);
		// lab2.setAlignment(Label.CENTER);
		lab11.setForeground(Color.blue);
		lab11.setLocation(60, 510); // �]�w���Ҧ�m
		lab11.setSize(200, 120); // �]�w���Ҥj�p
		lab11.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
		frm.add(lab11);
		
		txf1.setBounds(250, 60, 100, 20);
		txf1.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
		txf1.setText(String.valueOf(Read_Generate_random_Tourism.N() ));
		frm.add(txf1);

		txf2.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
		txf2.setText(String.valueOf(Read_Generate_random_Tourism.buyer_bot_price() ));
		txf2.setBounds(250, 110, 100, 20);
		frm.add(txf2);

		txf3.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
		txf3.setText(String.valueOf(Read_Generate_random_Tourism.Ia()));
		txf3.setBounds(250, 160, 100, 20);
		frm.add(txf3);

		txf4.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
		txf4.setText(String.valueOf(Read_Generate_random_Tourism.K()));
		txf4.setBounds(250, 210, 100, 20);
		frm.add(txf4);
		
		txf5.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
		txf5.setText(String.valueOf(Read_Generate_random_Tourism.K_top()));
		txf5.setBounds(250, 260, 100, 20);
		frm.add(txf5);
		
		txf6.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
		txf6.setText(String.valueOf(Read_Generate_random_Tourism.Ih() ));
		txf6.setBounds(250, 310, 100, 20);
		frm.add(txf6);

		txf7.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
		txf7.setText(String.valueOf(Read_Generate_random_Tourism.M() ));
		txf7.setBounds(250, 360, 100, 20);
		frm.add(txf7);
		
		txf8.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
		txf8.setText(String.valueOf(Read_Generate_random_Tourism.M_top() ));
		txf8.setBounds(250, 410, 100, 20);
		frm.add(txf8);

		txf9.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
		txf9.setText(String.valueOf( Read_Generate_random_Tourism.It() ));
		txf9.setBounds(250, 460, 100, 20);
		frm.add(txf9);
		
		txf10.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
		txf10.setText( String.valueOf(Read_Generate_random_Tourism.T() ));
		txf10.setBounds(250, 510, 100, 20);
		frm.add(txf10);
		
		txf11.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
		txf11.setText(String.valueOf(Read_Generate_random_Tourism.T_top() ));
		txf11.setBounds(250, 560, 100, 20);
		frm.add(txf11);
		
		btn1.setBounds(80, 610, 120, 30);
		btn1.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
		btn1.addActionListener(this);
		frm.add(btn1);

		
		
		frm.setVisible(true); // 設定視窗為可見
	}

	public static void main() {
		new Generate_random_Set_Parameter();
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(btn1)) {
			try {
				Write_Tourism_Parameter.saveTourism_Parameter(txf1.getText(),
						txf2.getText(),txf3.getText(),txf4.getText(),txf5.getText(),
						txf6.getText(),txf7.getText(),txf8.getText(),txf9.getText(),
						txf10.getText(),txf11.getText());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		frm.setVisible(false);
	}
	
}
