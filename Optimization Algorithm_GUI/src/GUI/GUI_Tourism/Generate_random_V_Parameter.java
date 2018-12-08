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

import Generate_random_data.Read_Generate_random_Tourism_V_Parameter;
import Input_Output_txt.Tourism.Write_Tourism_Parameter;

public class Generate_random_V_Parameter implements ActionListener  {
	
	JFrame frm = new JFrame("Set_V_Parameter");
	JLabel lab1 = new JLabel();
	JLabel lab2 = new JLabel();
	JLabel lab3 = new JLabel();
	JLabel lab4 = new JLabel();
	JLabel lab5 = new JLabel();
	
	
	JTextField txf1 = new JTextField();
	JTextField txf2 = new JTextField();
	JTextField txf3 = new JTextField();
	JTextField txf4 = new JTextField();
	JTextField txf5 = new JTextField();
	JTextField txf6 = new JTextField();

	JButton btn1 = new JButton("SAVE");


	Generate_random_V_Parameter() {
		
		Read_Generate_random_Tourism_V_Parameter.main();
		frm.setSize(600,500); // 設定視窗的大小為 200*150
		frm.setLocation(100, 50); // 設定視窗位置為(100,50)
		frm.setLayout(null);

		lab1.setText("下限 :");
		lab1.setBackground(Color.white);
		// lab1.setAlignment(Label.CENTER);
		lab1.setForeground(Color.blue);
		lab1.setLocation(250, 10); // �]�w���Ҧ�m
		lab1.setSize(180, 120); // �]�w���Ҥj�p
		lab1.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
		frm.add(lab1);

		lab2.setText("上限");
		lab2.setBackground(Color.white);
		// lab2.setAlignment(Label.CENTER);
		lab2.setForeground(Color.blue);
		lab2.setLocation(450, 10); // �]�w���Ҧ�m
		lab2.setSize(180, 120); // �]�w���Ҥj�p
		lab2.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
		frm.add(lab2);

		lab3.setText("Vaik :");
		lab3.setBackground(Color.white);
		// lab2.setAlignment(Label.CENTER);
		lab3.setForeground(Color.blue);
		lab3.setLocation(60, 60); // �]�w���Ҧ�m
		lab3.setSize(180, 120); // �]�w���Ҥj�p
		lab3.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
		frm.add(lab3);

		lab4.setText("Vhim :");
		lab4.setBackground(Color.white);
		// lab2.setAlignment(Label.CENTER);
		lab4.setForeground(Color.blue);
		lab4.setLocation(60, 110); // �]�w���Ҧ�m
		lab4.setSize(180, 120); // �]�w���Ҥj�p
		lab4.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
		frm.add(lab4);
		
		lab5.setText("Vtit :");
		lab5.setBackground(Color.white);
		// lab2.setAlignment(Label.CENTER);
		lab5.setForeground(Color.blue);
		lab5.setLocation(60, 160); // �]�w���Ҧ�m
		lab5.setSize(200, 120); // �]�w���Ҥj�p
		lab5.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
		frm.add(lab5);
		
	
		
		txf1.setBounds(250, 110, 100, 20);
		txf1.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
		txf1.setText(String.valueOf(Read_Generate_random_Tourism_V_Parameter.Vaik_bot() ));
		frm.add(txf1);

		txf2.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
		txf2.setText(String.valueOf(Read_Generate_random_Tourism_V_Parameter.Vaik_top() ));
		txf2.setBounds(450, 110, 100, 20);
		frm.add(txf2);

		txf3.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
		txf3.setText(String.valueOf(Read_Generate_random_Tourism_V_Parameter.Vhim_bot() ));
		txf3.setBounds(250, 160, 100, 20);
		frm.add(txf3);

		txf4.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
		txf4.setText(String.valueOf(Read_Generate_random_Tourism_V_Parameter.Vhim_top()));
		txf4.setBounds(450, 160, 100, 20);
		frm.add(txf4);
		
		txf5.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
		txf5.setText(String.valueOf(Read_Generate_random_Tourism_V_Parameter.Vtit_bot() ));
		txf5.setBounds(250, 210, 100, 20);
		frm.add(txf5);
		
		txf6.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
		txf6.setText(String.valueOf(Read_Generate_random_Tourism_V_Parameter.Vtit_top() ));
		txf6.setBounds(450, 210, 100, 20);
		frm.add(txf6);

	
		
		btn1.setBounds(80, 250, 120, 30);
		btn1.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
		btn1.addActionListener(this);
		frm.add(btn1);

		
		
		frm.setVisible(true); // 設定視窗為可見
	}

	public static void main() {
		new Generate_random_V_Parameter();
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(btn1)) {
			try {
				Write_Tourism_Parameter.saveTourism_V_Parameter(txf1.getText(),
						txf2.getText(),txf3.getText(),txf4.getText(),txf5.getText(),
						txf6.getText());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		frm.setVisible(false);
	}
	
}
