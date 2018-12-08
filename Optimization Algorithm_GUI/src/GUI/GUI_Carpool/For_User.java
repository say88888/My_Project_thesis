package GUI.GUI_Carpool;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import GUI.I_Set_Paths_for_Current_Simulation_Example;

public class For_User extends JFrame implements ActionListener{
	
	static  JFrame frm=new JFrame();
	
	static   JButton btn1=new JButton("Set Paths for Current Simulation Example");             											 //I.	Set Paths for Current Simulation Example
	
	static JButton btn6=new JButton("Generate Data in PHP");																 //VI    Generate Data of Drivers Randomly

	static JButton btn2=new JButton("Set and Define Locations");																					 // II.	Set and Define Locations
	static JButton btn3=new JButton("Compute Distance");																							 //  III.    Compute Distance
	
	static JButton btn8=new JButton("Set passenger filter parameters and Set_a_Delta_TransactionFee");																			 //VIII  Set passenger filter parameters
	static JButton btn9=new JButton(" Generate Bids for Drivers");											 //IX    Generate Bids for Drivers based on Enumeration
	static JButton btn10=new JButton("Select Algorithm Type to Solve the Problem");													 // X     Select Algorithm Type to Solve the Problem
	static JButton btn11=new JButton("Set_Parameters_and_Weights_for_the_Selected_Algorithm");														 //XI    Set Parameters for the Selected Algorithm
	static JButton btn12=new JButton("Run the selected Algorithm");																			 // XII    Run the selected Algorithm
	static JButton btn13=new JButton("Compare the Simulation Results for the Current Simulation Example ");			 // XIII   Compare the Simulation Results for the Current Simulation Example 
	static JButton btn14=new JButton("Show ALL_data ");			 // XIII   Compare the Simulation Results for the Current Simulation Example 
	static JButton btn15=new JButton("Exit");			 // XIII   Compare the Simulation Results for the Current Simulation Example 
	 
	   static int Algorithm=1;
	   
	   For_User(){
		 
		   frm.setSize(700,800);
		      frm.setLayout(null);
		      frm.setTitle("Optimization Algorithm");
		      
		      btn1.setBounds(40,10,600,40);
		      btn1.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
		      
		      btn6.setBounds(40,60,600,40);
		      btn6.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
		      
		      btn2.setBounds(40,160,600,40);
		      btn2.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
		      
		      btn3.setBounds(40,210,600,40);
		      btn3.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
		      
		      
		      btn8.setBounds(40,360,600,40);
		      btn8.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
		      
		      btn9.setBounds(40,410,600,40);
		      btn9.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
		      
		      btn10.setBounds(40,460,600,40);
		      btn10.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
		      
		      btn11.setBounds(40,510,600,40);
		      btn11.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
		      
		      
		      btn12.setBounds(40,560,600,40);
		      btn12.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
		      
		      
		      btn13.setBounds(40,610,600,40);
		      btn13.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
		      
		      btn14.setBounds(40,660,600,40);
		      btn14.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
		      
		      btn15.setBounds(40,710,600,40);
		      btn15.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
		      
		      btn1.addActionListener(this);               // ��frm�Vbtn���U      
		      frm.add(btn1);
		 
		      btn2.addActionListener(this);               // ��frm�Vbtn���U      
		      frm.add(btn2);
		      
		      btn3.addActionListener(this);               // ��frm�Vbtn���U      
		      frm.add(btn3);
		      
		      btn6.addActionListener(this);               // ��frm�Vbtn���U      
		      frm.add(btn6);
		    
		      btn8.addActionListener(this);               // ��frm�Vbtn���U      
		      frm.add(btn8);
		      
		      btn9.addActionListener(this);               // ��frm�Vbtn���U      
		      frm.add(btn9);
		      
		      btn10.addActionListener(this);               // ��frm�Vbtn���U      
		      frm.add(btn10);
		      
		      btn11.addActionListener(this);               // ��frm�Vbtn���U      
		      frm.add(btn11);
		      
		      btn12.addActionListener(this);               // ��frm�Vbtn���U      
		      frm.add(btn12);
		      
		      btn13.addActionListener(this);               // ��frm�Vbtn���U      
		      frm.add(btn13);
		      
		      btn14.addActionListener(this);               // ��frm�Vbtn���U      
		      frm.add(btn14);
		      
		      btn15.addActionListener(this);               // ��frm�Vbtn���U      
		      frm.add(btn15);
		      
		      frm.setVisible(true);  
		   
		 }
	   
	   
	   public static void main(/*String args[]*/)
	   {
		   new For_User();
	   }
	   
	   public void actionPerformed(ActionEvent e)
	   { 
		      if(e.getSource().equals(btn1)){                       // �p�G�O���Ubtn1���s
			         I_Set_Paths_for_Current_Simulation_Example.main();
			      }
			      else if(e.getSource().equals(btn2)){                  // �p�G�O���Ubtn2���s
			         II_Set_and_Define_Locations.main();
			      }
			      else if(e.getSource().equals(btn3)){                  // �p�G�O���Ubtn2���s
			    	  III_Compute_Distance.main();
				      }
			      else if(e.getSource().equals(btn6)){                  // �p�G�O���Ubtn2���s
			    	  Generate_Data_in_PHP.main();
				      }
			      else if(e.getSource().equals(btn8)){                  // �p�G�O���Ubtn2���s
			    	  VIII_Set_passenger_filter_parameters.main();
				      }
			      else if(e.getSource().equals(btn9)){                  // �p�G�O���Ubtn2���s
			    	  IX_Generate_Bids_for_Drivers.main();
				      }
			      else if(e.getSource().equals(btn10)){                  // �p�G�O���Ubtn2���s
			    	  X_Select_Algorithm_Type_to_Solve_the_Problem.main();
				      }
			      else if(e.getSource().equals(btn11)){                  // �p�G�O���Ubtn2���s
			    	  XI_Set_Parameters_and_Weights_for_the_Selected_Algorithm.main();
				      }
			      else if(e.getSource().equals(btn12) && Algorithm!=0){                  // �p�G�O���Ubtn2���s
			    	  XII_Run_the_selected_Algorithm_and_result_to_out_for_Carpool.main();
				      }
			      else if(e.getSource().equals(btn13)){                  // �p�G�O���Ubtn2���s
			    	  XIII_Compare_the_Simulation_Results_for_the_Current_Simulation_Example.main();
				      }
			      else if(e.getSource().equals(btn14)){
			    	 XIV_Show_ALL_data.main();
			      }
			       else  if(e.getSource().equals(btn15))                          // �p�G�O���Ubtn3���s
			         System.exit(0);
			}
 
}
