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
import Heuristic_method_multi_hop.Heuristic_multi_hop;
import Heuristic_method_multi_hop.Passenger_filter_multi_hop;


public class IX_Generate_Bids_for_Drivers_multi_hop  implements ActionListener{
	JFrame frm=new JFrame();
	   Label lab=new Label();
	   JButton btn1=new JButton("Run_the_ Passenger_filter");
	   JButton btn4=new JButton("Run_Heuristic_method_multi_hop");
	   JButton btn3=new JButton("Exit");

	   IX_Generate_Bids_for_Drivers_multi_hop() {
		   frm.setSize(400,400); // 設定視窗的大小為 200*150
	    	frm.setLocation(400,50); // 設定視窗位置為(100,50)
		      frm.setTitle("IX_Generate_Bids_for_Drivers");
	    	  frm.setLayout(null);
	    	       
	           btn1.setBounds(50,100,250,40);
	   	       btn1.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
	            frm.add(btn1);
	            btn1.addActionListener( this);
	           
		           
		         btn4.setBounds(50,170,250,40);
		   	     btn4.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
		         frm.add(btn4);
		         btn4.addActionListener( this);
		         
		           btn3.setBounds(50,240,250,40);
		   	       btn3.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
		           frm.add(btn3);
		           btn3.addActionListener( this);     
		      
		        lab.setText("Run_Heuristic_method_multi_hop");
				// lab1.setAlignment(Label.CENTER);
				lab.setForeground(Color.blue);
				lab.setLocation(50, 30); // �]�w���Ҧ�m
				lab.setSize(200,40); // �]�w���Ҥj�p
				lab.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
				frm.add(lab);
		           
		         frm.setVisible(true); // 設定視窗為可見	
	             
	}
public static void main() 
{       
			new IX_Generate_Bids_for_Drivers_multi_hop() ;
} 


	public void actionPerformed(ActionEvent e)   
	   {
	JButton btn=(JButton) e.getSource();  
	
	   if(btn==btn1){     
		   
		   try {
			  Passenger_filter_multi_hop.main();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		   System.out.println("OK");
	   }
	   
	   else if(btn==btn4){
		   
		   try {
				Heuristic_multi_hop.main();
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
