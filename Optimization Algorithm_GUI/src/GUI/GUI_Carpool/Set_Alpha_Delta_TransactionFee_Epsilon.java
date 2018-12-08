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

import Input_Output_txt.Carpool.Read_TransactionFee;
import Input_Output_txt.Carpool.Write_filter_TransactionFee_Parameter;

public class Set_Alpha_Delta_TransactionFee_Epsilon extends Carpool  implements ActionListener {
	JFrame frm = new JFrame("Set_a_Delta_TransactionFee");
	JLabel lab1 = new JLabel();
	JLabel lab2 = new JLabel();
	JLabel lab3 = new JLabel();
	JLabel lab4 = new JLabel();
	
	JTextField txf1 = new JTextField();
	JTextField txf2 = new JTextField();
	JTextField txf3 = new JTextField();
	JTextField txf4 = new JTextField();
	JTextField txf5 = new JTextField();
	
	JButton btn1 = new JButton("SAVE");

	JLabel lab5 = new JLabel();
	JLabel lab6 = new JLabel();
	JLabel lab7 = new JLabel();
	JLabel lab8 = new JLabel();
	JLabel lab9 = new JLabel();
	JLabel lab10 = new JLabel();
	
	Set_Alpha_Delta_TransactionFee_Epsilon() {
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

		lab2.setText("Delta :");
		lab2.setBackground(Color.white);
		// lab2.setAlignment(Label.CENTER);
		lab2.setForeground(Color.blue);
		lab2.setLocation(80, 90); // �]�w���Ҧ�m
		lab2.setSize(150, 120); // �]�w���Ҥj�p
		lab2.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
		frm.add(lab2);

		lab3.setText("Tdm :");
		lab3.setBackground(Color.white);
		// lab2.setAlignment(Label.CENTER);
		lab3.setForeground(Color.blue);
		lab3.setLocation(80, 160); // �]�w���Ҧ�m
		lab3.setSize(150, 120); // �]�w���Ҥj�p
		lab3.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
		frm.add(lab3);

		lab4.setText("Tpm :");
		lab4.setBackground(Color.white);
		// lab2.setAlignment(Label.CENTER);
		lab4.setForeground(Color.blue);
		lab4.setLocation(80, 230); // �]�w���Ҧ�m
		lab4.setSize(150, 120); // �]�w���Ҥj�p
		lab4.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
		frm.add(lab4);
		
		
		txf1.setBounds(180, 70, 100, 20);
		txf1.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
		txf1.setText(String.valueOf(Read_TransactionFee.Alpha()));
		frm.add(txf1);

		txf2.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
		txf2.setText(String.valueOf(Read_TransactionFee.Delta()));
		txf2.setBounds(180, 140, 100, 20);
		frm.add(txf2);

		txf3.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
		txf3.setText(String.valueOf(Read_TransactionFee.Tdm()));
		txf3.setBounds(180, 210, 100, 20);
		frm.add(txf3);

		txf4.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
		txf4.setText(String.valueOf(Read_TransactionFee.Tpm()));
		txf4.setBounds(180, 280, 100, 20);
		frm.add(txf4);
		
		txf5.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
		txf5.setText(String.valueOf(Read_TransactionFee.Theta()));
		txf5.setBounds(180, 350, 100, 20);
	
		
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

		lab6.setText("利潤成本分配參數 0~1");
		lab6.setBackground(Color.white);
		// la1.setAlignment(Label.CENTER);
		lab6.setForeground(Color.blue);
		lab6.setLocation(80, 60); // �]�w���Ҧ�m
		lab6.setSize(250, 120); // �]�w���Ҥj�p
		lab6.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
		frm.add(lab6);

		lab7.setText("司機手續費");
		lab7.setBackground(Color.white);
		// lab1.setAlignment(Label.CENTER);
		lab7.setForeground(Color.blue);
		lab7.setLocation(80, 130); // �]�w���Ҧ�m
		lab7.setSize(250, 120); // �]�w���Ҥj�p
		lab7.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
		frm.add(lab7);

		lab8.setText("乘客手續費");
		lab8.setBackground(Color.white);
		// lab1.setAlignment(Label.CENTER);
		lab8.setForeground(Color.blue);
		lab8.setLocation(80, 200); // �]�w���Ҧ�m
		lab8.setSize(250, 120); // �]�w���Ҥj�p
		lab8.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
		frm.add(lab8);
		
		lab8.setText("乘客手續費");
		lab8.setBackground(Color.white);
		// lab1.setAlignment(Label.CENTER);
		lab8.setForeground(Color.blue);
		lab8.setLocation(80, 200); // �]�w���Ҧ�m
		lab8.setSize(250, 120); // �]�w���Ҥj�p
		lab8.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
		frm.add(lab8);
		
		if(data_mode.equals("multi_hop_mode")){
		frm.setSize(400, 500);	
			
		lab9.setText("Theta: ");
		lab9.setBackground(Color.white);
		// lab2.setAlignment(Label.CENTER);
		lab9.setForeground(Color.blue);
		lab9.setLocation(80, 300); // �]�w���Ҧ�m
		lab9.setSize(150, 120); // �]�w���Ҥj�p
		lab9.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
		frm.add(lab9);
		
		frm.add(txf5);
		
		lab10.setText("Cdj 的 Theta成本");
		lab10.setBackground(Color.white);
		// lab1.setAlignment(Label.CENTER);
		lab10.setForeground(Color.blue);
		lab10.setLocation(80, 270); // �]�w���Ҧ�m
		lab10.setSize(250, 120); // �]�w���Ҥj�p
		lab10.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
		frm.add(lab10);
		
		btn1.setBounds(100, 390, 120, 30);
		btn1.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
		}
		frm.setVisible(true); // 設定視窗為可見
	}

	public static void main() {
		new Set_Alpha_Delta_TransactionFee_Epsilon();
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(btn1)) {
			try {
				Write_filter_TransactionFee_Parameter.saveTransactionFee(txf1.getText(),
						txf2.getText(),txf3.getText(),txf4.getText(),txf5.getText());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		frm.setVisible(false);
	}
}
