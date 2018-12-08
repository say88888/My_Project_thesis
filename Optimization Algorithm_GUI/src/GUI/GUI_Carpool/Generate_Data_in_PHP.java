package GUI.GUI_Carpool;

import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFrame;

import Enumeration.Enumeration;
import Enumeration.Passenger_filter;
import GUI.I_Set_Paths_for_Current_Simulation_Example;


public class Generate_Data_in_PHP  implements ActionListener{
	JFrame frm=new JFrame();
	
	   JButton btn0=new JButton("Clear SQL_input_random");
	   JButton btn1=new JButton("Clear Location");
	   JButton btn2=new JButton("Generate_Data_in_PHP ");


	   Generate_Data_in_PHP() {
		   frm.setSize(650,450); // 設定視窗的大小為 200*150
		   frm.setLocation(400,50); // 設定視窗位置為(100,50)
		      frm.setTitle("Generate_Data_in_PHP");
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
	            
		         frm.setVisible(true); // 設定視窗為可見	
	          
	}
	   
public static void main() 
{       
			new Generate_Data_in_PHP() ;
} 


	public void actionPerformed(ActionEvent e)   
	   {
		File f=new File(System.getProperty("user.dir"));
	JButton btn=(JButton) e.getSource();  
	   if(btn==btn0){     
		 
		   Delete_Data_GA_input.delAllFile(f.getAbsolutePath()+"\\input\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\SQL_input_random");

	   }
	   
	   if(btn==btn1){     
		   
		   FileWriter fw2;
		try {
			fw2 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path()+"\\Generate_random\\location",false);
			fw2.write("");
			fw2.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
	   }
	   
	   if(btn==btn2){     
				try {
					Show_JavaFX_PHP.main();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	      }
	   
	   }
}
