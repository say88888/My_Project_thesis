package GUI.GUI_Carpool;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;

import Generate_random_data.Generate_Data_of_Passengers_Randomly_multi_hop;

public class VI_Generate_Data_of_Passenger_Randomly_multi_hop  implements ActionListener{
	
	   JFrame frm=new JFrame();
	   Label lab=new Label();
	   
	   JButton btn1=new JButton("Run");
	   JButton btn2 = new JButton("Exit");
	   
		Checkbox ckb1 = new Checkbox("Run_Passenger_Randomly");
	   
	   VI_Generate_Data_of_Passenger_Randomly_multi_hop() {
		   frm.setSize(500,300); // 設定視窗的大小為 200*150
	    	frm.setLocation(400,50); // 設定視窗位置為(100,50)
		      frm.setTitle("VI_Generate_Data_of_Passenger_Randomly_multi_hop");
	    	  frm.setLayout(null);
	    	  
	    	CheckboxGroup grp = new CheckboxGroup();
	    	ckb1.setCheckboxGroup(grp);
	    
	    	  
			ckb1.setBounds(60, 50, 200, 40);
			
				frm.add(ckb1);
			
	           btn1.setBounds(60,200,80,40);
	   	       btn1.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
	             frm.add(btn1);
	             btn1.addActionListener( this);
	             
	             btn2.setBounds(160,200,80,40);
		   	     btn2.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
		         frm.add(btn2);
		         btn2.addActionListener( this);
		             
		             
	             frm.setVisible(true); // 設定視窗為可見	
	             
	             
	             
	}
 public static void main() 
 {       
 	
 	 new VI_Generate_Data_of_Passenger_Randomly_multi_hop();
 } 
 
	public void actionPerformed(ActionEvent e)   
	   {
 	JButton btn=(JButton) e.getSource();  
	if (ckb1.getState()==true &&btn == btn1) {
		try {
			Generate_Data_of_Passengers_Randomly_multi_hop.Generate_Data_of_Passengers_Randomly();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("乘客已建立");
		
	}
 	 
	if (btn == btn2) {
		frm.setVisible(false);
	}
	   }
}
