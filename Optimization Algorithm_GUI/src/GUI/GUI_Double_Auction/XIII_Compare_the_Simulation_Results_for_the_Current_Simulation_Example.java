package GUI.GUI_Double_Auction;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;

import GUI.I_Set_Paths_for_Current_Simulation_Example;
import Input_Output_txt.Read_result;

public class XIII_Compare_the_Simulation_Results_for_the_Current_Simulation_Example extends Double_Auction implements ActionListener{
	JFrame frm = new JFrame();
	JButton btn1 = new JButton("Compare_the_Simulation_Results_for_the_Current_Simulation_Example");
	
	JButton btn2 = new JButton("Set_Parameters_for_the_chart");
	
	XIII_Compare_the_Simulation_Results_for_the_Current_Simulation_Example() {

		
		frm.setSize(500, 400); // 設定視窗的大小為 200*150
		frm.setLocation(150, 150); // 設定視窗位置為(100,50)
		frm.setTitle("Set_Weights_for_Objective_Function");
		frm.setLayout(null);
		
		btn1.setBounds(50, 80, 370, 60);
		btn1.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));

		btn2.setBounds(50, 180, 370, 60);
		btn2.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
		 
		 
		frm.add(btn1);
		btn1.addActionListener(this);
		frm.add(btn2);
		btn2.addActionListener(this);
		frm.setVisible(true);
		
	}
    public static void main( ) 
    { 
    	new XIII_Compare_the_Simulation_Results_for_the_Current_Simulation_Example();
    	
    } 
    
    public void actionPerformed(ActionEvent e)   
	   {
    	JButton btn=(JButton) e.getSource();  
 	   if(btn==btn1){  
 		  Compare_the_Simulation_Results_for_the_Current_Simulation_Example.main();
	     }
 	  if(btn==btn2){  
 		 Set_Parameters_for_the_chart_Double_Auction.main();
      }
 	   
	  }
    
}
