package GUI.GUI_Carpool;

import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import GUI.I_Set_Paths_for_Current_Simulation_Example;
import Generate_random_data.File_funtion;
import Heuristic_method_multi_hop_for_Original_Passenger.Heuristic_multi_hop;

public class X_Copy_the_initial_data_before_splitting_multi_hop  implements ActionListener{
	JFrame frm=new JFrame();
	   Label lab=new Label();
	   JButton btn1=new JButton("Copy_to_SQL_input_random_Original");
	   JButton btn2=new JButton("Copy_to_SQL_input_random_filter_Original");
	   JButton btn4=new JButton("Run_Heuristic_method_multi_hop");
	   JButton btn5=new JButton("Exit");

	   X_Copy_the_initial_data_before_splitting_multi_hop() {
		   frm.setSize(600,600); // 設定視窗的大小為 200*150
	    	frm.setLocation(400,50); // 設定視窗位置為(100,50)
		      frm.setTitle("X_Copy_the_initial_data_before_splitting_multi_hop");
	    	  frm.setLayout(null);
	          lab.setText("Copy_the_initial_data_before_splitting_multi_hop");
	    
	          // lab1.setAlignment(Label.CENTER);
	          	lab.setForeground(Color.blue);
	          	lab.setLocation(50, 30); // �]�w���Ҧ�m
	          	lab.setSize(550,40); // �]�w���Ҥj�p
	          	lab.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
	          	frm.add(lab);
	    	
	            btn1.setBounds(50,100,400,40);
	   	        btn1.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
	            frm.add(btn1);
	            btn1.addActionListener( this);
	           
		           
		         btn2.setBounds(50,170,400,40);
		   	     btn2.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
		         frm.add(btn2);
		         btn2.addActionListener( this);
		           
		      
		        btn4.setBounds(50,310,400,40);
		   	    btn4.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
		        frm.add(btn4);
		        btn4.addActionListener( this);     
		        
		        btn5.setBounds(50,410,400,40);
		   	    btn5.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
		        frm.add(btn5);
		        btn5.addActionListener( this);    
		        
		  
					
				
		         frm.setVisible(true); // 設定視窗為可見	
	             
	}
public static void main() 
{       
			new X_Copy_the_initial_data_before_splitting_multi_hop() ;
} 


	public void actionPerformed(ActionEvent e)   
	   {
	JButton btn=(JButton) e.getSource();  
	
	   if(btn==btn1){     
		   
			
			String oldfile=I_Set_Paths_for_Current_Simulation_Example.path()+"\\SQL_input_random\\Original_passenger_initial_itinerary";
			String newfile=I_Set_Paths_for_Current_Simulation_Example.path()+"\\SQL_input_random_original\\Original_passenger_initial_itinerary";
			File_funtion.copyFile(oldfile, newfile);
			
			oldfile=I_Set_Paths_for_Current_Simulation_Example.path()+"\\SQL_input_random\\Original_passenger_initial_itinerary";
			newfile=I_Set_Paths_for_Current_Simulation_Example.path()+"\\SQL_input_random_original\\passenger_initial_itinerary";
			File_funtion.copyFile(oldfile, newfile);
			
			oldfile=I_Set_Paths_for_Current_Simulation_Example.path()+"\\SQL_input_random\\passenger_data";
			newfile=I_Set_Paths_for_Current_Simulation_Example.path()+"\\SQL_input_random_original\\passenger_data";
			File_funtion.copyFile(oldfile, newfile);
			
			oldfile=I_Set_Paths_for_Current_Simulation_Example.path()+"\\SQL_input_random\\passenger_calendar";
			newfile=I_Set_Paths_for_Current_Simulation_Example.path()+"\\SQL_input_random_original\\passenger_calendar";
			File_funtion.copyFile(oldfile, newfile);
			
			 oldfile=I_Set_Paths_for_Current_Simulation_Example.path()+"\\SQL_input_random\\driver_initial_itinerary";
			 newfile=I_Set_Paths_for_Current_Simulation_Example.path()+"\\SQL_input_random_original\\driver_initial_itinerary";
			File_funtion.copyFile(oldfile, newfile);
			
			oldfile=I_Set_Paths_for_Current_Simulation_Example.path()+"\\SQL_input_random\\driver_calendar";
			newfile=I_Set_Paths_for_Current_Simulation_Example.path()+"\\SQL_input_random_original\\driver_calendar";
			File_funtion.copyFile(oldfile, newfile);
			
			oldfile=I_Set_Paths_for_Current_Simulation_Example.path()+"\\SQL_input_random\\driver_data";
			newfile=I_Set_Paths_for_Current_Simulation_Example.path()+"\\SQL_input_random_original\\driver_data";
			File_funtion.copyFile(oldfile, newfile);
			
			oldfile=I_Set_Paths_for_Current_Simulation_Example.path()+"\\SQL_input_random\\car_data";
			newfile=I_Set_Paths_for_Current_Simulation_Example.path()+"\\SQL_input_random_original\\car_data";
			File_funtion.copyFile(oldfile, newfile);
			
			//File_funtion.delFile(oldfile);
			
			System.out.println("File_copy");
	   }
	   
	   if(btn==btn2){     
		   String oldfile=I_Set_Paths_for_Current_Simulation_Example.path()+"\\SQL_input_random_original\\passenger_initial_itinerary";
			String newfile=I_Set_Paths_for_Current_Simulation_Example.path()+"\\SQL_input_random_filter_original\\passenger_initial_itinerary";
			File_funtion.copyFile(oldfile, newfile);
			
			oldfile=I_Set_Paths_for_Current_Simulation_Example.path()+"\\SQL_input_random_original\\driver_initial_itinerary";
			newfile=I_Set_Paths_for_Current_Simulation_Example.path()+"\\SQL_input_random_filter_original\\driver_initial_itinerary";
			File_funtion.copyFile(oldfile, newfile);
			
			oldfile=I_Set_Paths_for_Current_Simulation_Example.path()+"\\SQL_input_random_original\\passenger_data";
			newfile=I_Set_Paths_for_Current_Simulation_Example.path()+"\\SQL_input_random_filter_original\\passenger_data";
			File_funtion.copyFile(oldfile, newfile);
			
			oldfile=I_Set_Paths_for_Current_Simulation_Example.path()+"\\SQL_input_random_original\\car_data";
			newfile=I_Set_Paths_for_Current_Simulation_Example.path()+"\\SQL_input_random_filter_original\\car_data";
			File_funtion.copyFile(oldfile, newfile);
			
			//File_funtion.delFile(oldfile);
			
			System.out.println("File_copy");
	   }
	   
	   
	   else if(btn==btn4){
		   
			String oldfile=I_Set_Paths_for_Current_Simulation_Example.path()+"\\Carpool";
			String newfile=I_Set_Paths_for_Current_Simulation_Example.path()+"\\Carpool_original";
			File_funtion.copyFolder(oldfile, newfile);
		
		   
		   try {
				Heuristic_multi_hop.main();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	   }
	   else if(btn==btn5){
	   frm.setVisible(false);
	   }
	   }
}
