package GUI.GUI_Carpool;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


public class Single_mode extends Carpool implements ActionListener{
	
	 JFrame frm = new JFrame();
	
	static JButton btn4=new JButton("Set Parameters to Randomly Generate Data of Drivers");								
	static JButton btn5=new JButton("Set Parameters to Randomly Generate Data of Passengers");												
	static JButton btn6=new JButton("Generate Data of Drivers Randomly");																
	static JButton btn7=new JButton("Generate Data of Passengers Randomly");													
	static JButton btn8=new JButton("Set passenger filter parameters and Set_a_Delta_TransactionFee");																	
	static JButton btn9=new JButton("Generate Bids for Drivers");										
	
	static JButton btn15=new JButton("Exit");	
	
	Single_mode() {
		// TODO Auto-generated method stub

			   	frm.setSize(700,550);
			    frm.setLayout(null);
			      frm.setTitle("Single_mode");
			    
			      btn4.setBounds(40,60,600,40);
			      btn4.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
			      
			      btn5.setBounds(40,110,600,40);
			      btn5.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
			      	      
			      btn6.setBounds(40,160,600,40);
			      btn6.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
			      
			      btn7.setBounds(40,210,600,40);
			      btn7.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
			      
			      btn8.setBounds(40,260,600,40);
			      btn8.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
			      
			      btn9.setBounds(40,310,600,40);
			      btn9.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
			     
			      btn15.setBounds(40,410,600,40);
			      btn15.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
			      
			      btn4.addActionListener(this);               // ��frm�Vbtn���U      
			      frm.add(btn4);
			      
			      btn5.addActionListener(this);               // ��frm�Vbtn���U      
			      frm.add(btn5);
			      	      
			      btn6.addActionListener(this);               // ��frm�Vbtn���U      
			      frm.add(btn6);
			      
			      btn7.addActionListener(this);               // ��frm�Vbtn���U      
			      frm.add(btn7);
			      
			      btn8.addActionListener(this);               // ��frm�Vbtn���U      
			      frm.add(btn8);
			      
			      btn9.addActionListener(this);               // ��frm�Vbtn���U      
			      frm.add(btn9);
			      
			      btn15.addActionListener(this);               // ��frm�Vbtn���U      
			      frm.add(btn15);
			      
			      frm.setVisible(true);  
		   }	
	
	  public static void main() 
	  { 
	  	new Single_mode();
	  } 
	
	
		public void actionPerformed(ActionEvent e)
			{ 
		 //  Button btn=(Button) e.getSource();  // ���o�ƥ�ӷ�������
		  
		    if(e.getSource().equals(btn4)){                  // �p�G�O���Ubtn2���s
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
		      else  if(e.getSource().equals(btn15))                          // �p�G�O���Ubtn3���s
		    	  frm.setVisible(false);
		    
		    }
	   
}
