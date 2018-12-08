package GUI.GUI_Carpool;

import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFrame;

import Enumeration.Enumeration;
import Enumeration.Passenger_filter;


public class XIV_Show_ALL_data  implements ActionListener{
	JFrame frm=new JFrame();
	
	   JButton btn0=new JButton("show_SQL_input_random_filter_data");
	   JButton btn1=new JButton("show_Bids_data");
	   JButton btn2=new JButton("show_reportX_Y_RideSharingDetails");
	   JButton btn3=new JButton("show_Eqution_Value");
	   JButton btn4=new JButton("Show_JavaFX_GoogleMap");

	   XIV_Show_ALL_data() {
		   frm.setSize(650,450); // 設定視窗的大小為 200*150
		   frm.setLocation(400,50); // 設定視窗位置為(100,50)
		      frm.setTitle("XIV_See_ALL_data  ");
	    	  frm.setLayout(null);
	    	  
	    	  btn0.setBounds(80,50,350,40);
	   	      btn0.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
	          frm.add(btn0);
	          btn0.addActionListener( this);
	           
	           btn1.setBounds(80,120,350,40);
	   	       btn1.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
	            frm.add(btn1);
	            btn1.addActionListener( this);
	
		         btn2.setBounds(80,190,350,40);
		   	     btn2.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
		         frm.add(btn2);
		         btn2.addActionListener( this); 
		      
		         btn3.setBounds(80,260,350,40);
		   	     btn3.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
		         frm.add(btn3);
		         btn3.addActionListener( this); 
		         
		         btn4.setBounds(80,330,350,40);
		   	     btn4.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
		         frm.add(btn4);
		         btn4.addActionListener( this); 
		         
		         frm.setVisible(true); // 設定視窗為可見	
	             
	}
public static void main() 
{       
			new XIV_Show_ALL_data() ;
} 


	public void actionPerformed(ActionEvent e)   
	   {
	JButton btn=(JButton) e.getSource();  
	   if(btn==btn0){     
		   try {
			   show_SQL_input_random_filter_data.main();
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	      }
	
	   if(btn==btn1){     
		   
			try {
				show_Bids_data.main();
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	      }
	   
	   else if(btn==btn2){
		   
		   try {
			   show_reportX_Y_RideSharingDetails.main();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	   }
	   else if(btn==btn3){
		   
		   try {
			   show_Eqution_Value.main();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	   }
	   else if(btn==btn4){
		   try {
			   Show_JavaFX_GoogleMap.main();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	   }
	   }
}
