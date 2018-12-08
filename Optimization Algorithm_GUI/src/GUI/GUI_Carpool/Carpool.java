package GUI.GUI_Carpool;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;

import GUI.I_Set_Path_and_environment;
import GUI.I_Set_Paths_for_Current_Simulation_Example;

	public class Carpool extends JFrame implements ActionListener
	{
		
	static  Carpool frm=new Carpool();
                                          
	static   JButton btn1=new JButton("Set_Path_and_environment");             											 //I.	Set Paths for Current Simulation Example
	static JButton btn2=new JButton("Set and Define Locations");																					 // II.	Set and Define Locations
	static JButton btn3=new JButton("Compute Distance");																							 //  III.    Compute Distance
/*	static JButton btn4=new JButton("Set Parameters to Randomly Generate Data of Drivers");									 // IV.    Set Parameters to Randomly Generate Data of Drivers
	static JButton btn5=new JButton("Set Parameters to Randomly Generate Data of Passengers");								 //V.    Set Parameters to Randomly Generate Data of Passengers
	static JButton btn6=new JButton("Generate Data of Drivers Randomly");																 //VI    Generate Data of Drivers Randomly
	static JButton btn7=new JButton("Generate Data of Passengers Randomly");															 //VII   Generate Data of Passengers Randomly
	static JButton btn8=new JButton("Set passenger filter parameters and Set_a_Delta_TransactionFee");																			 //VIII  Set passenger filter parameters
	static JButton btn9=new JButton("Generate Bids for Drivers");											 //IX    Generate Bids for Drivers based on Enumeration
*/	
	static JButton btn16=new JButton("Single model");											 
	static JButton btn17=new JButton("multi-hop model");											
	
	static JButton btn10=new JButton("Select Algorithm Type to Solve the Problem");													 // X     Select Algorithm Type to Solve the Problem
	static JButton btn11=new JButton("Set_Parameters_and_Weights_for_the_Selected_Algorithm");														 //XI    Set Parameters for the Selected Algorithm
	static JButton btn12=new JButton("Run the selected Algorithm");																			 // XII    Run the selected Algorithm
	static JButton btn13=new JButton("Compare the Simulation Results for the Current Simulation Example ");			 // XIII   Compare the Simulation Results for the Current Simulation Example 
	static JButton btn14=new JButton("Show ALL_data ");			 // XIII   Compare the Simulation Results for the Current Simulation Example 
	static JButton btn15=new JButton("Exit");			 // XIII   Compare the Simulation Results for the Current Simulation Example 
	 
	static String Algorithm="CPLEX";
	static String data_mode;
	
	   public static void main()
	   {
		   
		   frm.setSize(700,700);
		      frm.setLayout(null);
		      frm.setTitle("Optimization Algorithm");
		      
		      btn1.setBounds(40,10,600,40);
		      btn1.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
		      
		      btn2.setBounds(40,60,600,40);
		      btn2.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
		      
		      btn3.setBounds(40,110,600,40);
		      btn3.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
	/*	      
		      btn4.setBounds(40,160,600,40);
		      btn4.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
		      
		      btn5.setBounds(40,210,600,40);
		      btn5.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
		      
		      btn6.setBounds(40,260,600,40);
		      btn6.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
		      
		      btn7.setBounds(40,310,600,40);
		      btn7.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
		      
		      btn8.setBounds(40,360,600,40);
		      btn8.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
		      
		      btn9.setBounds(40,410,600,40);
		      btn9.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
	*/	      
		      btn16.setBounds(40,160,280,40);
		      btn16.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
		      
		      btn17.setBounds(350,160,280,40);
		      btn17.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
		      
		      btn10.setBounds(40,260,600,40);
		      btn10.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
		      
		      btn11.setBounds(40,310,600,40);
		      btn11.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
		      
		      
		      btn12.setBounds(40,360,600,40);
		      btn12.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
		      
		      
		      btn13.setBounds(40,410,600,40);
		      btn13.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
		      
		      btn14.setBounds(40,460,600,40);
		      btn14.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
		      
		      btn15.setBounds(40,560,600,40);
		      btn15.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
		      
		      btn1.addActionListener(frm);               // ��frm�Vbtn���U      
		      frm.add(btn1);
		 
		      btn2.addActionListener(frm);               // ��frm�Vbtn���U      
		      frm.add(btn2);
		      
		      btn3.addActionListener(frm);               // ��frm�Vbtn���U      
		      frm.add(btn3);
		      
	/*	      btn4.addActionListener(frm);               // ��frm�Vbtn���U      
		      frm.add(btn4);
		      
		      btn5.addActionListener(frm);               // ��frm�Vbtn���U      
		      frm.add(btn5);
		      
		      btn6.addActionListener(frm);               // ��frm�Vbtn���U      
		      frm.add(btn6);
		      
		      btn7.addActionListener(frm);               // ��frm�Vbtn���U      
		      frm.add(btn7);
		      
		      btn8.addActionListener(frm);               // ��frm�Vbtn���U      
		      frm.add(btn8);
		      
		      btn9.addActionListener(frm);               // ��frm�Vbtn���U      
		      frm.add(btn9);
		*/      
		      btn16.addActionListener(frm);               // ��frm�Vbtn���U      
		      frm.add(btn16);
		      
		      btn17.addActionListener(frm);               // ��frm�Vbtn���U      
		      frm.add(btn17);
		      
		      btn10.addActionListener(frm);               // ��frm�Vbtn���U      
		      frm.add(btn10);
		      
		      btn11.addActionListener(frm);               // ��frm�Vbtn���U      
		      frm.add(btn11);
		      
		      btn12.addActionListener(frm);               // ��frm�Vbtn���U      
		      frm.add(btn12);
		      
		      btn13.addActionListener(frm);               // ��frm�Vbtn���U      
		      frm.add(btn13);
		      
		      btn14.addActionListener(frm);               // ��frm�Vbtn���U      
		      frm.add(btn14);
		      
		      btn15.addActionListener(frm);               // ��frm�Vbtn���U      
		      frm.add(btn15);
		      
		      if(GUI.main.getmethod()==1){
		    	  frm.remove(btn2);
		    	  frm.remove(btn3);
		      }
		      frm.setVisible(true);  
	   }
	   
	   public void actionPerformed(ActionEvent e)
	   { 
		 //  Button btn=(Button) e.getSource();  // ���o�ƥ�ӷ�������
		      if(e.getSource().equals(btn1)){                       // �p�G�O���Ubtn1���s
		    	  I_Set_Path_and_environment.main();
		      }
		      else if(e.getSource().equals(btn2)){                  // �p�G�O���Ubtn2���s
		         II_Set_and_Define_Locations.main();
		      }
		      else if(e.getSource().equals(btn3)){                  // �p�G�O���Ubtn2���s
		    	  III_Compute_Distance.main();
			      }
	  /*    else if(e.getSource().equals(btn4)){                  // �p�G�O���Ubtn2���s
		    	  IV_Set_Parameters_to_Randomly_Generate_Data_of_Drivers.main();
			      }
		      else if(e.getSource().equals(btn5)){                  // �p�G�O���Ubtn2���s
		    	  V_Set_Parameters_to_Randomly_Generate_Data_of_Passengers.main();
			      }
		      else if(e.getSource().equals(btn6)){                  // �p�G�O���Ubtn2���s
		    	  VI_Generate_Data_of_Drivers_Randomly.main();
			      }
		      else if(e.getSource().equals(btn7)){                  // �p�G�O���Ubtn2���s
		    	  VII_Generate_Data_of_Passengers_Randomly.main();
			      }
		      else if(e.getSource().equals(btn8)){                  // �p�G�O���Ubtn2���s
		    	  VIII_Set_passenger_filter_parameters.main();
			      }
		      else if(e.getSource().equals(btn9)){                  // �p�G�O���Ubtn2���s
		    	  IX_Generate_Bids_for_Drivers.main();
			      }
	*/	     
		      else if(e.getSource().equals(btn16)){                  // �p�G�O���Ubtn2���s
		    	  Single_mode.main();
		    	  data_mode="Single_mode";
			      }
		      else if(e.getSource().equals(btn17)){                  // �p�G�O���Ubtn2���s
		    	    multi_hop_mode.main();
		    	    data_mode="multi_hop_mode";
			      }
		//      else if(e.getSource().equals(btn11)){                  // �p�G�O���Ubtn2���s
		 //   	  XI_Set_Parameters_and_Weights_for_the_Selected_Algorithm.main();
		//	      }
		      else if(e.getSource().equals(btn10)){                  // �p�G�O���Ubtn2���s
		    	  X_Select_Algorithm_Type_to_Solve_the_Problem.main();
			      }
		      else if(e.getSource().equals(btn11)){                  // �p�G�O���Ubtn2���s
		    	  XI_Set_Parameters_and_Weights_for_the_Selected_Algorithm.main();
			      }
		      else if(e.getSource().equals(btn12) && Algorithm!=null){                  // �p�G�O���Ubtn2���s
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
