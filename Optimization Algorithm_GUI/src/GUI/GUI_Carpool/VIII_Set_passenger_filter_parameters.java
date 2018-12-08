package GUI.GUI_Carpool;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import READ_TXT.Read_filter_and_detour_rate;

public class VIII_Set_passenger_filter_parameters implements ActionListener {
	JFrame frm = new JFrame("VIII_Set_passenger_filter_parameters");

	JButton btn1 = new JButton("Set_passenger_filter_parameters");
	JButton btn2 = new JButton("Set_a_Delta_TransactionFee");
	JButton btn3 = new JButton("Exit");

	VIII_Set_passenger_filter_parameters() {
		Read_filter_and_detour_rate.main();
		frm.setSize(400, 350); // 設定視窗的大小為 200*150
		frm.setLocation(100, 50); // 設定視窗位置為(100,50)
		frm.setLayout(null);

		btn1.setBounds(50, 70, 300, 50);
		btn1.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
		btn1.addActionListener(this);
		frm.add(btn1);

		btn2.setBounds(50, 150,300, 50);
	     btn2.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
	     btn2.addActionListener( this); 
	 	 frm.add(btn2);
	 	 
	 	btn3.setBounds(50, 210,150, 50);
	     btn3.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
	     btn3.addActionListener( this); 
	 	 frm.add(btn3);
	 	 
	 	
	 	 
		frm.setVisible(true); // 設定視窗為可見
	}

	public static void main() {
		new VIII_Set_passenger_filter_parameters();
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(btn1)) {
			Set_passenger_filter_parameters.main();
		}else if(e.getSource().equals(btn2)){
			Set_Alpha_Delta_TransactionFee_Epsilon.main();
		}
		
		if(e.getSource().equals(btn3)){
		frm.setVisible(false);}
	}
}
