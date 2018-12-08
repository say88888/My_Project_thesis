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

import Input_Output_txt.Carpool.Write_filter_TransactionFee_Parameter;
import READ_TXT.Read_filter_and_detour_rate;

public class Set_passenger_filter_parameters implements ActionListener{  
	  JFrame frm=new JFrame("Set_passenger_filter_parameters");
	  JLabel lab1=new JLabel();
	  JLabel lab2=new JLabel();
	  JLabel lab3=new JLabel();
	  JTextField txf1=new JTextField();
	  JTextField txf2=new JTextField();
	  JTextField txf3=new JTextField();
	  JButton btn1 =new JButton("SAVE");
	  
	  JLabel lab4=new JLabel();
	  JLabel lab5=new JLabel();
	  JLabel lab6=new JLabel();
	  
	  JLabel lab7=new JLabel();
	  JLabel lab8=new JLabel();
	  JLabel lab9=new JLabel();
	  
	  Set_passenger_filter_parameters() {
		Read_filter_and_detour_rate.main();
  	frm.setSize(400,350); // 設定視窗的大小為 200*150
  	frm.setLocation(100,50); // 設定視窗位置為(100,50)
  	frm.setLayout(null);
  	
  	 lab1.setText("passenger_filter:");
	     lab1.setBackground(Color.white);
	     //lab1.setAlignment(Label.CENTER);
	     lab1.setForeground(Color.blue);
	     lab1.setLocation(60,20);       // �]�w���Ҧ�m
	     lab1.setSize(150,120);          // �]�w���Ҥj�p
	     lab1.setFont(new Font("Serief",Font.ITALIC+Font.BOLD,18));
	     frm.add(lab1);
	    lab2.setText("detour_rate:");
	     lab2.setBackground(Color.white);
	     //lab2.setAlignment(Label.CENTER);
	     lab2.setForeground(Color.blue);
	     lab2.setLocation(60,90);       // �]�w���Ҧ�m
	     lab2.setSize(150,120);          // �]�w���Ҥj�p
	     lab2.setFont(new Font("Serief",Font.ITALIC+Font.BOLD,18));
	     frm.add(lab2);
	  
	     txf1.setBounds(230,70,100,20);
	     txf1.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
	      txf1.setText(String.valueOf(Read_filter_and_detour_rate.getfilter_rate()));
	     frm.add(txf1);
	     txf2.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
	     txf2.setText(String.valueOf(Read_filter_and_detour_rate.getdetour_rate()));
	     txf2.setBounds(230,140,100,20);
	     frm.add(txf2);
	    
	     btn1.setBounds(80, 270,120, 30);
	     btn1.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
	     btn1.addActionListener( this); 
	 	 frm.add(btn1);
	 	 
	 	 
  	 lab4.setText("過濾乘客參數值 建議 1 ~ 3");
	     lab4.setBackground(Color.white);
	     //lab1.setAlignment(Label.CENTER);
	     lab4.setForeground(Color.blue);
	     lab4.setLocation(80,-10);       // �]�w���Ҧ�m
	     lab4.setSize(250,120);          // �]�w���Ҥj�p
	     lab4.setFont(new Font("Serief",Font.ITALIC+Font.BOLD,18));
	     frm.add(lab4);
	     
  	 lab5.setText("共乘繞道參數值 建議 1 ~ 3");
	     lab5.setBackground(Color.white);
	     //lab1.setAlignment(Label.CENTER);
	     lab5.setForeground(Color.blue);
	     lab5.setLocation(80,60);       // �]�w���Ҧ�m
	     lab5.setSize(250,120);          // �]�w���Ҥj�p
	     lab5.setFont(new Font("Serief",Font.ITALIC+Font.BOLD,18));
	     frm.add(lab5);
	     
	    
	     
	     
	     
  	 frm.setVisible(true); // 設定視窗為可見
	}
  public static void main( ) 
  { 
  	new Set_passenger_filter_parameters();
  } 
	public void actionPerformed(ActionEvent e)
	   {
	 
	  if( e.getSource().equals(btn1)){
		 try {
			Write_filter_TransactionFee_Parameter.savefilter(txf1.getText(),txf2.getText());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	  }
	  frm.setVisible(false);
	   }
}
