package GUI.GUI_Batch;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import GUI.I_Set_Paths_for_Current_Simulation_Example;

public class Batch extends JFrame implements ActionListener{
	static  JFrame frm=new JFrame();
    
	static   JButton btn1=new JButton("	Set Paths for Current Simulation Example");             											 //I.	Set Paths for Current Simulation Example
	
	static JButton btn2=new JButton("Select Algorithm Type to Solve the Problem");													 // X     Select Algorithm Type to Solve the Problem
	static JButton btn3=new JButton("Set_Parameters_and_Weights_for_the_Selected_Algorithm");														 //XI    Set Parameters for the Selected Algorithm
	static JButton btn4=new JButton("Run the selected Algorithm");																			 // XII    Run the selected Algorithm
	//static JButton btn13=new JButton("Compare the Simulation Results for the Current Simulation Example ");			 // XIII   Compare the Simulation Results for the Current Simulation Example 
	static JButton btn5=new JButton("Exit");			 // XIII   Compare the Simulation Results for the Current Simulation Example 
	 
	private static Boolean Batch=false;
	
	   static int Algorithm=1;
	
	 Batch(){
		 
		 Batch=false;
		 frm.setSize(700,750);
	      frm.setLayout(null);
	      frm.setTitle("Batch");
	      
	      btn1.setBounds(40,40,600,40);
	      btn1.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
	      
	      btn2.setBounds(40,90,600,40);
	      btn2.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
	      
	      btn3.setBounds(40,140,600,40);
	      btn3.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
	      
	      btn4.setBounds(40,190,600,40);
	      btn4.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
	      
	     btn5.setBounds(40,240,600,40);
	      btn5.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
	     /*  
	      btn6.setBounds(40,290,600,40);
	      btn6.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
	      
	      btn7.setBounds(40,340,600,40);
	      btn7.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
	      
	      btn8.setBounds(40,390,600,40);
	      btn8.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
	      
	      btn9.setBounds(40,440,600,40);
	      btn9.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
	      
	      btn10.setBounds(40,490,600,40);
	      btn10.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
	      
	      btn11.setBounds(40,540,600,40);
	      btn11.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
	      
	      
	      btn12.setBounds(40,590,600,40);
	      btn12.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
	      
	      
	      btn13.setBounds(40,640,600,40);
	      btn13.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
	   
	      btn14.setBounds(40,690,600,40);
	      btn14.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
	         */
	      btn1.addActionListener(this);               // ��frm�Vbtn���U      
	      frm.add(btn1);
	 
	      btn2.addActionListener(this);               // ��frm�Vbtn���U      
	      frm.add(btn2);
	      
	      btn3.addActionListener(this);               // ��frm�Vbtn���U      
	      frm.add(btn3);
	      
	      btn4.addActionListener(this);               // ��frm�Vbtn���U      
	      frm.add(btn4);
	      
	   
	      
	      btn5.addActionListener(this);               // ��frm�Vbtn���U      
	      frm.add(btn5);
	      
	      if(GUI.main.getmethod()==1){
	    	  frm.remove(btn2);
	    	  frm.remove(btn3);
	      }
	      frm.setVisible(true);  
	 }
 
	
	   public static void main(/*String args[]*/)
	   {
		   new Batch();
		   
	   }
	   
	   public void actionPerformed(ActionEvent e)
	   { 
		 //  Button btn=(Button) e.getSource();  // ���o�ƥ�ӷ�������
		      if(e.getSource().equals(btn1)){                       // �p�G�O���Ubtn1���s
		         I_Set_Paths_for_Current_Simulation_Example.main();
		        
		      }
		      else if(e.getSource().equals(btn2)){                  // �p�G�O���Ubtn2���s
		         X_Select_Algorithm_Type_to_Solve_the_Problem.main();
		      }
		      else if(e.getSource().equals(btn3)){                  // �p�G�O���Ubtn2���s
		    	  //Batch_Set_Parameters_for_the_Selected_Algorithm.main();
		    	  Batch=true;
		    	  XI_Set_Parameters_and_Weights_for_the_Selected_Algorithm.main();
			      }
		      else if(e.getSource().equals(btn4)){                  // �p�G�O���Ubtn2���s
		    	  Batch=true;
		    	   XII_Run_the_selected_Algorithm_and_result_to_out.main();
			      }
		       else  if(e.getSource().equals(btn5))                          // �p�G�O���Ubtn3���s
		         System.exit(0);
		    	   }
	   
	   
		public static Boolean getBatch() {
			return Batch;
		}
	   
	}
