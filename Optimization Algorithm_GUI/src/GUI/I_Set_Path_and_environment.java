package GUI;

import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class I_Set_Path_and_environment extends Frame implements ActionListener  {
	JFrame frm = new JFrame();
	JButton btn1 = new JButton("I_Set_Paths_for_Current_Simulation_Example");
	JButton btn2 = new JButton("I_Set_environment_for_Current_Simulation_Example");
	
	I_Set_Path_and_environment() {

		frm.setSize(500, 400); // 設定視窗的大小為 200*150
		frm.setLocation(150, 150); // 設定視窗位置為(100,50)
		frm.setTitle("Set_Weights_for_Objective_Function");
		frm.setLayout(null);
		
		btn1.setBounds(50, 80, 370, 60);
		btn1.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));

		btn2.setBounds(50, 180, 370, 60);
		btn2.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
		 
		 
		frm.add(btn1);
		btn1.addActionListener(this);
		frm.add(btn2);
		btn2.addActionListener(this);
		frm.setVisible(true);
	
	}
	public static void main( ) {
		// TODO Auto-generated method stub
		new I_Set_Path_and_environment();
	}
	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(btn1)) {
			I_Set_Paths_for_Current_Simulation_Example.main();
		}
		if (e.getSource().equals(btn2)) {
			I_Set_environment_for_Current_Simulation_Example.main();
		}
	
		frm.setVisible(false);
	}
}
