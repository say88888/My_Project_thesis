package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class I_Set_environment_for_Current_Simulation_Example extends Frame implements ActionListener 
{
	 JFrame frm=new JFrame("I_Set_environment_for_Current_Simulation_Example");
	  JLabel lab1=new JLabel();
	  JLabel lab2=new JLabel();
	  JLabel lab3=new JLabel();
	  JTextField txf1=new JTextField();
	  JTextField txf2=new JTextField();
	  JButton btn1 =new JButton("SAVE");
	  JButton btn2 =new JButton("Cancel");
	  static String Classroom;
	  static String Serial_number;
	I_Set_environment_for_Current_Simulation_Example(){
		Read_Classroom_and_Serial_number.main(); 
		
		frm.setSize(400, 350); // 設定視窗的大小為 200*150
		frm.setLocation(400, 200); // 設定視窗位置為(100,50)
		 frm.setTitle("I_Set_environment_for_Current_Simulation_Example");
		frm.setVisible(true); // 設定視窗為可見
		frm.setLayout(null);

		 lab1.setText("Classroom:");
	     lab1.setBackground(Color.white);
	     //lab1.setAlignment(Label.CENTER);
	     lab1.setForeground(Color.blue);
	     lab1.setLocation(60,20);       // �]�w���Ҧ�m
	     lab1.setSize(150,120);          // �]�w���Ҥj�p
	     lab1.setFont(new Font("Serief",Font.ITALIC+Font.BOLD,18));
	     frm.add(lab1);
	     lab2.setText("Serial_number:");
	     lab2.setBackground(Color.white);
	     //lab2.setAlignment(Label.CENTER);
	     lab2.setForeground(Color.blue);
	     lab2.setLocation(60,90);       // �]�w���Ҧ�m
	     lab2.setSize(150,120);          // �]�w���Ҥj�p
	     lab2.setFont(new Font("Serief",Font.ITALIC+Font.BOLD,18));
	     frm.add(lab2);
	  
	     txf1.setBounds(230,70,100,20);
	     txf1.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
	      txf1.setText(Read_Classroom_and_Serial_number.getClassroom());
	     frm.add(txf1);
	     txf2.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
	     txf2.setText(Read_Classroom_and_Serial_number.getSerial_number());
	     txf2.setBounds(230,140,100,20);
	     frm.add(txf2);
		  
		btn1.setBounds(60, 190, 100, 40);
		btn1.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
		frm.add(btn1);
		btn1.addActionListener(this);
		
		btn2.setBounds(190, 190, 100, 40);
		btn2.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
		frm.add(btn2);
	  
		btn2.addActionListener(this);
		frm.setVisible(true);
		
		Classroom=Read_Classroom_and_Serial_number.getClassroom();
		Serial_number=Read_Classroom_and_Serial_number.getSerial_number();
		
	}
	public static void main(   ) {
	
		new I_Set_environment_for_Current_Simulation_Example();
	}

	public void actionPerformed(ActionEvent e)  
	{
		 if (e.getSource().equals(btn1)) {

			 try {
				Write_Classroom_Serial_number.saveClassroom_Serial_number(txf1.getText(), txf2.getText());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			 
			 Classroom=txf1.getText();
			 Serial_number=txf2.getText();
			 
		}
		frm.setVisible(false);
	}
	public static String path(){
		return Classroom;
	}
	public static String filename(){
		return Serial_number;
	}
}
