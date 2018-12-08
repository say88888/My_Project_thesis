package GUI.GUI_Carpool;

import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;

import Enumeration.Enumeration;
import Enumeration.Passenger_filter;
import Heuristic_method.Heuristic;


public class IX_Generate_Bids_for_Drivers  implements ActionListener{
	JFrame frm=new JFrame();
	   Label lab=new Label();
	   Label lab1=new Label();
	   JButton btn0=new JButton("Run_delete_data_Folder and GAinput_Folder");
	   JButton btn1=new JButton("Run_the_ passenger_filter");
	   JButton btn2=new JButton("Run_Enumeration");
	   JButton btn3=new JButton("Exit");
	   JButton btn4=new JButton("Run_Heuristic_method");
	   JButton btn5=new JButton("Run_the_ passenger_filter");
	   IX_Generate_Bids_for_Drivers() {
		   frm.setSize(700,400); // 設定視窗的大小為 200*150
	    	frm.setLocation(400,50); // 設定視窗位置為(100,50)
		      frm.setTitle("IX_Generate_Bids_for_Drivers");
	    	  frm.setLayout(null);
	    	  
	    	  btn0.setBounds(40,80,250,40);
	   	      btn0.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
	          frm.add(btn0);
	          btn0.addActionListener( this);
	           
	           btn1.setBounds(40,150,250,40);
	   	       btn1.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
	            frm.add(btn1);
	            btn1.addActionListener( this);
	            
	            btn5.setBounds(340,150,250,40);
		   	    btn5.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
		        frm.add(btn5);
		        btn5.addActionListener( this);
	
		         btn2.setBounds(40,220,250,40);
		   	     btn2.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
		         frm.add(btn2);
		         btn2.addActionListener( this);
		           
		         btn4.setBounds(340,220,250,40);
		   	     btn4.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
		         frm.add(btn4);
		         btn4.addActionListener( this);
		         
		           btn3.setBounds(40,290,250,40);
		   	       btn3.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
		           frm.add(btn3);
		           btn3.addActionListener( this);     
		      
		        lab.setText("Enumeration_method");
				// lab1.setAlignment(Label.CENTER);
				lab.setForeground(Color.blue);
				lab.setLocation(40, 30); // �]�w���Ҧ�m
				lab.setSize(200,40); // �]�w���Ҥj�p
				lab.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
				frm.add(lab);   
				
				lab1.setText("Heuristic_method");
				// lab1.setAlignment(Label.CENTER);
				lab1.setForeground(Color.blue);
				lab1.setLocation(340, 30); // �]�w���Ҧ�m
				lab1.setSize(200, 40); // �]�w���Ҥj�p
				lab1.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
				frm.add(lab1);
		           
		         frm.setVisible(true); // 設定視窗為可見	
	             
	}
public static void main() 
{       
			new IX_Generate_Bids_for_Drivers() ;
} 


	public void actionPerformed(ActionEvent e)   
	   {
	JButton btn=(JButton) e.getSource();  
	   if(btn==btn0){     
		   Delete_Data_GA_input.main();
	      }
	
	   if(btn==btn1){     
		   
		   try {
			Passenger_filter.main();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	      }
	   
	   else if(btn==btn2){
		   
		   try {
				Enumeration.main();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	   }
	   else if(btn==btn4){
		   
		   try {
				Heuristic.main();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	   }
	   else if(btn==btn5){
		   
		   try {
			   Passenger_filter.main();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	   }
	   else if(btn==btn3){
	   frm.setVisible(false);
	   }
	   }
}
