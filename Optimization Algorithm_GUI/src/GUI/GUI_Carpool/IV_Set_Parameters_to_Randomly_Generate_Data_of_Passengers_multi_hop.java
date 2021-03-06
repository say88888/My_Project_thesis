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

 
public class IV_Set_Parameters_to_Randomly_Generate_Data_of_Passengers_multi_hop  implements ActionListener {
	  JFrame frm=new JFrame("IV_Set_Parameters_to_Randomly_Generate_Data_of_Passengers");
	  JLabel lab1=new JLabel();
	  JLabel lab2=new JLabel();
	  JLabel lab3=new JLabel();
	 
	  JTextField txf1=new JTextField();
	  JTextField txf2=new JTextField();
	  JTextField txf3=new JTextField();
	  JTextField txf4=new JTextField();
	  JTextField txf5=new JTextField();
	  JTextField txf6=new JTextField();
	  JTextField txf7=new JTextField();
	  JTextField txf8=new JTextField();
	  JTextField txf9=new JTextField();
	  JTextField txf10=new JTextField();
	  JTextField txf11=new JTextField();
	  JTextField txf12=new JTextField();
	  JTextField txf13=new JTextField();
		JButton btn1=new JButton("SAVE");
		
		 JLabel lab4=new JLabel();
		 JLabel lab5=new JLabel();
		 JLabel lab6=new JLabel();
		 JLabel lab7=new JLabel();  
		 JLabel lab8=new JLabel();  
		 JLabel lab9=new JLabel();  
		 JLabel lab10=new JLabel();  	
		 JLabel lab11=new JLabel();  	
		public IV_Set_Parameters_to_Randomly_Generate_Data_of_Passengers_multi_hop() {
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
			
			frm.setSize(550,600); // 設定視窗的大小為 200*150
	    	frm.setLocation(100,50); // 設定視窗位置為(100,50)
	    	 frm.setLayout(null);
	    	 lab1.setText("乘客數量:");
	 	     lab1.setBackground(Color.white);
	 	     //lab1.setAlignment(Label.CENTER);
	 	     lab1.setForeground(Color.blue);
	 	     lab1.setBounds(50, 10, 150, 120);
	 	     lab1.setFont(new Font("Serief",Font.ITALIC+Font.BOLD,18));
	 	     frm.add(lab1);
	 	    
	 	    lab2.setText("時間參數 :");
		     lab2.setBackground(Color.white);
		     //lab2.setAlignment(Label.CENTER);
		     lab2.setForeground(Color.blue);
		     lab2.setBounds(50, 110, 150, 120);
		     lab2.setFont(new Font("Serief",Font.ITALIC+Font.BOLD,18));
		     frm.add(lab2);
	
		     txf1.setBounds(150, 50, 150, 40);
		     txf1.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
		     txf1.setText(String.valueOf(Read_Generate_random_multi_hop.P()));
	 	     frm.add(txf1);
	 	     
	 	    txf2.setBounds(150, 150, 80, 40);
	 	    txf2.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
	 	    txf2.setText(String.valueOf(Read_Generate_random_multi_hop.PTimeRandom(0)));
		     frm.add(txf2);
		     
		     txf3.setBounds(240, 150, 80, 40);
		     txf3.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
		     txf3.setText(String.valueOf(Read_Generate_random_multi_hop.PTimeRandom(1)));
		     frm.add(txf3);
		     
		     txf4.setBounds(330, 150, 80, 40);
		     txf4.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
		     txf4.setText(String.valueOf(Read_Generate_random_multi_hop.PTimeRandom(2)));
		     frm.add(txf4);
		     
		     txf5.setBounds(420, 150, 80, 40);
		     txf5.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
		     txf5.setText(String.valueOf(Read_Generate_random_multi_hop.PTimeRandom(3)));
		     frm.add(txf5);
		     
		     txf6.setBounds(300, 200, 80, 40);
		     txf6.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
		     txf6.setText(String.valueOf(Read_Generate_random_multi_hop.Bpl_Lower()));
		     frm.add(txf6);
		     
		     txf11.setBounds(420, 200, 80, 40);
		     txf11.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
		     txf11.setText(String.valueOf(Read_Generate_random_multi_hop.Bpl_Upper()));
		     frm.add(txf11);
		     
		     txf7.setBounds(300, 250, 80, 40);
		     txf7.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
		     txf7.setText(String.valueOf(Read_Generate_random_multi_hop.PassengerDistance()));
		     frm.add(txf7);
		    
		     txf8.setBounds(300, 300, 80, 40);
		     txf8.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
		     txf8.setText(String.valueOf(Read_Generate_random_OilConsumptionBounds.PassengerOilConsumptionBounds(0)));
		     frm.add(txf8);
		     
		     txf9.setBounds(390, 300, 80, 40);
		     txf9.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
		     txf9.setText(String.valueOf(Read_Generate_random_OilConsumptionBounds.PassengerOilConsumptionBounds(1)));
		     frm.add(txf9);
		      
		     txf10.setBounds(100, 350, 80, 40);
		     txf10.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
		     txf10.setText(String.valueOf(Read_Generate_random_OilConsumptionBounds.Passenger_OilPrice()));
		     frm.add(txf10);
		     
		     txf12.setBounds(350, 400, 80, 40);
		     txf12.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
		     txf12.setText(String.valueOf(Read_Generate_random_multi_hop.No_of_Additional_Passengers()));
		     frm.add(txf12);
		     
		     txf13.setBounds(400, 450, 80, 40);
		     txf13.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
		     txf13.setText(String.valueOf(Read_Generate_random_multi_hop.No_of_Additional_Passengers_distance()));
		     frm.add(txf13);
		     
		      lab4.setText("搭車提早時間");
		 	     lab4.setBackground(Color.white);
		 	     //lab1.setAlignment(Label.CENTER);
		 	     lab4.setForeground(Color.blue);
		 	     lab4.setBounds(150, 60, 200, 120);
		 	     lab4.setFont(new Font("Serief",Font.ITALIC+Font.BOLD,18));
		 	     frm.add(lab4);
		 	     
		 	    lab5.setText("搭車延遲時間");
		 	     lab5.setBackground(Color.white);
		 	     //lab1.setAlignment(Label.CENTER);
		 	     lab5.setForeground(Color.blue);
		 	     lab5.setBounds(350, 60, 200, 120);
		 	     lab5.setFont(new Font("Serief",Font.ITALIC+Font.BOLD,18));
		 	     frm.add(lab5);
		 	     
		 	     lab6.setText("想要的 BPL 上下限");
		 	     lab6.setBackground(Color.white);
		 	     //lab1.setAlignment(Label.CENTER);
		 	     lab6.setForeground(Color.blue);
		 	     lab6.setBounds(40, 160, 250, 120);
		 	     lab6.setFont(new Font("Serief",Font.ITALIC+Font.BOLD,18));
		 	     frm.add(lab6);
		 	     
		 	    lab7.setText("乘客自身最少行駛距離(以上)");
		 	     lab7.setBackground(Color.white);
		 	     //lab1.setAlignment(Label.CENTER);
		 	     lab7.setForeground(Color.blue);
		 	     lab7.setBounds(40, 210, 250, 120);
		 	     lab7.setFont(new Font("Serief",Font.ITALIC+Font.BOLD,18));
		 	     frm.add(lab7);
		 	     
		 	    lab8.setText("油耗數每公里消耗多少毫升");
		 	     lab8.setBackground(Color.white);
		 	     //lab1.setAlignment(Label.CENTER);
		 	     lab8.setForeground(Color.blue);
		 	     lab8.setBounds(40, 260, 250, 120);
		 	     lab8.setFont(new Font("Serief",Font.ITALIC+Font.BOLD,18));
		 	     frm.add(lab8);
		 	     
		 	    lab9.setText("油價");
		 	     lab9.setBackground(Color.white);
		 	     //lab1.setAlignment(Label.CENTER);
		 	     lab9.setForeground(Color.blue);
		 	     lab9.setBounds(40, 330, 250, 80);
		 	     lab9.setFont(new Font("Serief",Font.ITALIC+Font.BOLD,18));
		 	     frm.add(lab9);
		 	     
		 	     lab10.setText("No_of_Additional_Passengers");
		 	     lab10.setBackground(Color.white);
		 	     //lab1.setAlignment(Label.CENTER);
		 	     lab10.setForeground(Color.blue);
		 	     lab10.setBounds(40, 380, 300, 80);
		 	     lab10.setFont(new Font("Serief",Font.ITALIC+Font.BOLD,18));
		 	     frm.add(lab10);
		 	     
		 	    lab11.setText("No_of_Additional_Passengers_distance");
		 	     lab11.setBackground(Color.white);
		 	     //lab.setAlignment(Label.CENTER);
		 	     lab11.setForeground(Color.blue);
		 	     lab11.setBounds(40, 430, 350, 80);
		 	     lab11.setFont(new Font("Serief",Font.ITALIC+Font.BOLD,18));
		 	     frm.add(lab11);
		 	     
			     btn1.setBounds(150,520,150,40);
			      btn1.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
			      btn1.addActionListener( this); 
			      frm.add(btn1);
			      
	    	 frm.setVisible(true); // 設定視窗為可見
	    	 
		}
    public static void main() 
    { 
    	new IV_Set_Parameters_to_Randomly_Generate_Data_of_Passengers_multi_hop();	
    } 
    public void actionPerformed(ActionEvent e)
	   {
	 
	  if( e.getSource().equals(btn1)){
		 try {
			Write_Driver_Passenger_data_multi_hop.savepassenger_data(txf1.getText(), txf2.getText(),txf3.getText(),txf4.getText()
					, txf5.getText(),txf6.getText(),txf11.getText(),txf7.getText(),txf8.getText(),txf9.getText(),txf10.getText(),txf12.getText(),txf13.getText());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	  }
	  frm.setVisible(false);
	   }
}
