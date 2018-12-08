package GUI.GUI_Carpool;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Generate_random_data.distance;

public class III_Compute_Distance implements ActionListener {
  JFrame frm=new JFrame(" III_Compute_Distance");
  JLabel lab1=new JLabel();
  JButton btn1=new JButton("Exit");
  
	public III_Compute_Distance() {
		try {
			distance.main( );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	frm.setSize(400,350); // 設定視窗的大小為 200*150
    	frm.setLocation(100,50); // 設定視窗位置為(100,50)
    	  frm.setLayout(null);

    	 lab1.setText("計算距離結束");
  	     lab1.setBackground(Color.white);
  	     //lab1.setAlignment(Label.CENTER);
  	     lab1.setForeground(Color.blue);
  	     lab1.setBounds(100, 30, 200, 200);
  	     lab1.setFont(new Font("Serief",Font.ITALIC+Font.BOLD,25));
  	     frm.add(lab1);
    	  
    	  btn1.setBounds(120,200,150,40);
	      btn1.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
	      btn1.addActionListener( this); 
	      frm.add(btn1);
	      
    	frm.setVisible(true); // 設定視窗為可見
	}
    public static void main( ) 
    { 	
    	new III_Compute_Distance();
    }
 
	public void actionPerformed(ActionEvent e) {
		JButton btn=(JButton) e.getSource();  
 	   if(btn==btn1){         
	    	  frm.setVisible(false);
	      }
	} 
}
