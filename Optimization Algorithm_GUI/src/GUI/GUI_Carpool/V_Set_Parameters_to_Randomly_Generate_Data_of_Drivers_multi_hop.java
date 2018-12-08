package GUI.GUI_Carpool;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Generate_random_data.Read_Generate_random_OilConsumptionBounds;
import Generate_random_data.Read_Generate_random_multi_hop;
import Input_Output_txt.Carpool.Write_Driver_Passenger_data_multi_hop;

public class V_Set_Parameters_to_Randomly_Generate_Data_of_Drivers_multi_hop  implements ActionListener {
	  JFrame frm=new JFrame("V_Set_Parameters_to_Randomly_Generate_Data_of_Drivers");
	  JLabel lab1=new JLabel();
	  JLabel lab2=new JLabel();
	  JLabel lab3=new JLabel();
	
	  JTextField txf2=new JTextField();
	  JTextField txf3=new JTextField();
	  JTextField txf4=new JTextField();
	  JTextField txf5=new JTextField();
	  JTextField txf6=new JTextField();
	  JTextField txf7=new JTextField();
	  JTextField txf9=new JTextField();
	  JTextField txf10=new JTextField();
	  JTextField txf11=new JTextField();
	  JTextField txf12=new JTextField();
	  JTextField txf13=new JTextField();
	  JLabel lab4=new JLabel();
	  JLabel lab5=new JLabel();
	  JLabel lab6=new JLabel();
	  JLabel lab7=new JLabel();
	  JLabel lab8=new JLabel();
	  JLabel lab9=new JLabel();
	  JLabel lab10=new JLabel();
	  JLabel lab11=new JLabel();	
	  JLabel lab12=new JLabel();	
	  JLabel lab13=new JLabel();	
	  JLabel lab14=new JLabel();	
	JButton btn1=new JButton("SAVE");
	public V_Set_Parameters_to_Randomly_Generate_Data_of_Drivers_multi_hop() {
		
		try {
			Read_Generate_random_multi_hop.main();
		} catch (ParseException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Read_Generate_random_OilConsumptionBounds.main();
		} catch (ParseException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		frm.setSize(650,650); // 設定視窗的大小為 200*150
    	frm.setLocation(100,50); // 設定視窗位置為(100,50)
    	 frm.setLayout(null);
    	 
 	     
 	    lab2.setText("時間參數 :");
	     lab2.setBackground(Color.white);
	     //lab2.setAlignment(Label.CENTER);
	     lab2.setForeground(Color.blue);
	     lab2.setBounds(50, 110, 150, 120);
	     lab2.setFont(new Font("Serief",Font.ITALIC+Font.BOLD,18));
	     frm.add(lab2);
	     
	     lab3.setText("油耗參數 :");
	     lab3.setBackground(Color.white);
	     //lab3.setAlignment(Label.CENTER);
	     lab3.setForeground(Color.blue);
	     lab3.setBounds(40, 210, 150, 120);
	     lab3.setFont(new Font("Serief",Font.ITALIC+Font.BOLD,18));
	     frm.add(lab3);
	     
	     txf2.setBounds(150, 150, 80, 40);
	     txf2.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
	     txf2.setText(String.valueOf(Read_Generate_random_multi_hop.DTimeRandon(0)));
	     frm.add(txf2);
	     
	     txf3.setBounds(240, 150, 80, 40);
	     txf3.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
	     txf3.setText(String.valueOf(Read_Generate_random_multi_hop.DTimeRandon(1)));
	     frm.add(txf3);
	     
	     txf4.setBounds(330, 150, 80, 40);
	     txf4.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
	     txf4.setText(String.valueOf(Read_Generate_random_multi_hop.DTimeRandon(2)));
	     frm.add(txf4);
	     
	     txf5.setBounds(420, 150, 80, 40);
	     txf5.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
	     txf5.setText(String.valueOf(Read_Generate_random_multi_hop.DTimeRandon(3)));
	     frm.add(txf5);
	     
	     txf6.setBounds(150, 250, 80, 40);
	     txf6.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
	     txf6.setText(String.valueOf(Read_Generate_random_OilConsumptionBounds.DriverOilConsumptionBounds(0)));
	     frm.add(txf6);
	     
	     txf7.setBounds(240, 250, 80, 40);
	     txf7.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
	     txf7.setText(String.valueOf(Read_Generate_random_OilConsumptionBounds.DriverOilConsumptionBounds(1)));
	     frm.add(txf7);
	     
	     txf10.setBounds(450, 250, 80, 40);
	     txf10.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
	     txf10.setText(String.valueOf(Read_Generate_random_OilConsumptionBounds.Driver_OilPrice()));
	     frm.add(txf10);

	     
	     txf11.setBounds(350, 300, 80, 40);
	     txf11.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
	     txf11.setText(String.valueOf(Read_Generate_random_multi_hop.Route_rate()));
	     frm.add(txf11);
	     
	     txf9.setBounds(350, 350, 80, 40);
	     txf9.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
	     txf9.setText(String.valueOf(Read_Generate_random_multi_hop.DriversDistance()));
	     frm.add(txf9);
	     
	     txf12.setBounds(350, 410, 80, 40);
	     txf12.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
	     txf12.setText(String.valueOf(Read_Generate_random_multi_hop.No_of_Additional_Drivers()));
	     frm.add(txf12);
	     
	     txf13.setBounds(400, 470, 80, 40);
	     txf13.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
	     txf13.setText(String.valueOf(Read_Generate_random_multi_hop.No_of_Additional_Drivers_distance()));
	     frm.add(txf13);
	     
	      lab4.setText("發車的提早時間");
	 	     lab4.setBackground(Color.white);
	 	     //lab1.setAlignment(Label.CENTER);
	 	     lab4.setForeground(Color.blue);
	 	     lab4.setBounds(150,60, 200, 120);
	 	     lab4.setFont(new Font("Serief",Font.ITALIC+Font.BOLD,18));
	 	     frm.add(lab4);
	      
	      lab5.setText("發車的延遲時間");
	 	     lab5.setBackground(Color.white);
	 	     //lab1.setAlignment(Label.CENTER);
	 	     lab5.setForeground(Color.blue);
	 	     lab5.setBounds(350,60, 200, 120);
	 	     lab5.setFont(new Font("Serief",Font.ITALIC+Font.BOLD,18));
	 	     frm.add(lab5);
	      
	 	   lab6.setText("油耗數每公里消耗多少毫升");
	 	     lab6.setBackground(Color.white);
	 	     //lab1.setAlignment(Label.CENTER);
	 	     lab6.setForeground(Color.blue);
	 	     lab6.setBounds(150,160, 250, 120);
	 	     lab6.setFont(new Font("Serief",Font.ITALIC+Font.BOLD,18));
	 	     frm.add(lab6);
	 	 
	 	    lab12.setText("限制每位司機繞道值");
	 		lab12.setBackground(Color.white);
	 			 	   //lab1.setAlignment(Label.CENTER);
	 		lab12.setForeground(Color.blue);
	 		lab12.setBounds(40,260, 250, 120);
	 		lab12.setFont(new Font("Serief",Font.ITALIC+Font.BOLD,18));
	 		frm.add(lab12);
	 	     
		    lab8.setText("限制每位司機起訖最少距離");
		 	lab8.setBackground(Color.white);
		 	   //lab1.setAlignment(Label.CENTER);
		 	lab8.setForeground(Color.blue);
		 	lab8.setBounds(40,310, 250, 120);
		 	lab8.setFont(new Font("Serief",Font.ITALIC+Font.BOLD,18));
		 	frm.add(lab8);
	 	    
		 	 lab10.setText("公尺");
			 lab10.setBackground(Color.white);
			 	   //lab1.setAlignment(Label.CENTER);
			 lab10.setForeground(Color.blue);
			 lab10.setBounds(450,310, 250, 120);
			 lab10.setFont(new Font("Serief",Font.ITALIC+Font.BOLD,18));
			 frm.add(lab10);
		     
			 btn1.setBounds(150,550,150,40);
		      btn1.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
		      btn1.addActionListener( this); 
		      frm.add(btn1);
		      
		      lab11.setText("油價 :");
			     lab11.setBackground(Color.white);
			     //lab3.setAlignment(Label.CENTER);
			     lab11.setForeground(Color.blue);
			     lab11.setBounds(380, 210, 150, 120);
			     lab11.setFont(new Font("Serief",Font.ITALIC+Font.BOLD,18));
			     frm.add(lab11);
	      
			      lab13.setText("No_of_Additional_Drivers :");
				     lab13.setBackground(Color.white);
				     //lab3.setAlignment(Label.CENTER);
				     lab13.setForeground(Color.blue);
				     lab13.setBounds(40, 370, 300, 120);
				     lab13.setFont(new Font("Serief",Font.ITALIC+Font.BOLD,18));
				     frm.add(lab13);
		      
				     lab14.setText("No_of_Additional_Drivers_distance :");
				     lab14.setBackground(Color.white);
				     //lab3.setAlignment(Label.CENTER);
				     lab14.setForeground(Color.blue);
				     lab14.setBounds(40, 430, 350, 120);
				     lab14.setFont(new Font("Serief",Font.ITALIC+Font.BOLD,18));
				     frm.add(lab14);
				     
    	 frm.setVisible(true); // 設定視窗為可見
    	 
	}
    public static void main( ) 
    { 
    	new V_Set_Parameters_to_Randomly_Generate_Data_of_Drivers_multi_hop();
    	
    } 
    public void actionPerformed(ActionEvent e)
	   {
	 
	  if( e.getSource().equals(btn1)){
		 try {
			Write_Driver_Passenger_data_multi_hop.savedriver_data(txf2.getText(),txf3.getText(),txf4.getText(), txf5.getText(),
					txf6.getText(), txf7.getText(),txf9.getText(),txf10.getText(),txf11.getText(),txf12.getText(),txf13.getText());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	  }
	  frm.setVisible(false);
	   }
}
