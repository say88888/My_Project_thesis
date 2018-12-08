package GUI.GUI_Tourism;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import GUI.I_Set_Paths_for_Current_Simulation_Example;


public class Tourism extends JFrame implements ActionListener {
	
static  JFrame frm=new JFrame();
    
	static   JButton btn1=new JButton("Set Paths for Current Simulation Example");             											 //I.	Set Paths for Current Simulation Example
		
	static JButton btn2=new JButton("Run the Generate_random_Tourism ");														
	static JButton btn3=new JButton("Select Algorithm Type to Solve the_Problem ");	
	static JButton btn4=new JButton("Set_Parameters_for_the_Selected_Algorithm ");	
	static JButton btn5=new JButton("Run the selected Algorithm ");	
	static JButton btn6=new JButton("Compare the Simulation Results for the Current Simulation Example ");	
	static JButton btn7=new JButton("Exit ");		
	
	static String Algorithm="CPLEX";
	Tourism(){
		 
		 frm.setSize(700,750);
	      frm.setLayout(null);
	      frm.setTitle("Tourism");
	      
	      btn1.setBounds(40,40,600,40);
	      btn1.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
	      btn1.addActionListener(this);               // ��frm�Vbtn���U      
	      frm.add(btn1);
	      
	      btn2.setBounds(40,90,600,40);
	      btn2.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
	      btn2.addActionListener(this);               // ��frm�Vbtn���U      
	      frm.add(btn2);
	      
	     btn3.setBounds(40,140,600,40);
	      btn3.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
	      btn3.addActionListener(this);               // ��frm�Vbtn���U      
	      frm.add(btn3);
	      
	      btn4.setBounds(40,190,600,40);
	      btn4.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
	      btn4.addActionListener(this);               // ��frm�Vbtn���U      
	      frm.add(btn4);
	      
	      btn5.setBounds(40,240,600,40);
	      btn5.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
	      btn5.addActionListener(this);               // ��frm�Vbtn���U      
	      frm.add(btn5);
	      
	      btn6.setBounds(40,290,600,40);
	      btn6.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
	      btn6.addActionListener(this);               // ��frm�Vbtn���U      
	      frm.add(btn6);
	      
	   
	      
	      btn7.setBounds(40,500,600,40);
	      btn7.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
	      btn7.addActionListener(this);               // ��frm�Vbtn���U      
	      frm.add(btn7);
	      frm.setVisible(true);  
	}
 
 public static void main(/*String args[]*/)
 {
	   new Tourism();
	   
 }
 
 public void actionPerformed(ActionEvent e)
 { 
	   if(e.getSource().equals(btn1)){                       // �p�G�O���Ubtn1���s
	         I_Set_Paths_for_Current_Simulation_Example.main();
	      }
	  
	   if(e.getSource().equals(btn2)){                       // �p�G�O���Ubtn1���s
		   Select_Generate_random_method.main();
	      }
	   if(e.getSource().equals(btn3)){                       // �p�G�O���Ubtn1���s
		   X_Select_Algorithm_Type_to_Solve_the_Problem.main();
	      }
	   if(e.getSource().equals(btn4)){                       // �p�G�O���Ubtn1���s
		   XI_Set_Parameters_and_Weights_for_the_Selected_Algorithm.main();
	      }
	   if(e.getSource().equals(btn5)){                       // �p�G�O���Ubtn1���s
		   XII_Run_the_selected_Algorithm_and_result_to_out.main();
	      }
	   if(e.getSource().equals(btn6)){                       // �p�G�O���Ubtn1���s
		   XIII_Compare_the_Simulation_Results_for_the_Current_Simulation_Example.main();
	      }
	   if(e.getSource().equals(btn7)){                       // �p�G�O���Ubtn1���s
		   frm.setVisible(false);  
	      }
 }
 
}

