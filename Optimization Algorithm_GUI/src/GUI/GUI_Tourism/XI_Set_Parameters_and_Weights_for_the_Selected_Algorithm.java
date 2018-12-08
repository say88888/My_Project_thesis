package GUI.GUI_Tourism;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
 
public class XI_Set_Parameters_and_Weights_for_the_Selected_Algorithm extends Tourism

		implements ActionListener {
	JFrame frm = new JFrame();
	JButton btn1 = new JButton("Set_Weights_for_Objective_Function");
	JButton btn2 = new JButton("Set_Parameters_for_the_Selected_Algorithm");
	JButton btn3 = new JButton("Select_multi_Algorithm");
	XI_Set_Parameters_and_Weights_for_the_Selected_Algorithm() {

		if(!Algorithm.equals("Run_multi_Algorithm")){
			frm.setSize(500, 400); // 設定視窗的大小為 200*150
			frm.setLocation(150, 150); // 設定視窗位置為(100,50)
			frm.setTitle("Set_Weights_for_Objective_Function");
			frm.setLayout(null);
			
			btn1.setBounds(50, 130, 370, 60);
			btn1.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));

			btn2.setBounds(50, 230, 370, 60);
			btn2.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
			 
		 
			frm.add(btn1);
			btn1.addActionListener(this);
			frm.add(btn2);
			btn2.addActionListener(this);
			
			frm.setVisible(true);
			}
			else{
				
				frm.setSize(500, 400); // 設定視窗的大小為 200*150
				frm.setLocation(150, 150); // 設定視窗位置為(100,50)
				frm.setTitle("Set_Weights_for_Objective_Function");
				frm.setLayout(null);
				
				btn3.setBounds(50, 100, 370, 60);
				btn3.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
				 
				frm.add(btn3);
				btn3.addActionListener(this);
				frm.setVisible(true);
				
			}
	}

	public static void main() {
		// TODO Auto-generated method stub
		new XI_Set_Parameters_and_Weights_for_the_Selected_Algorithm();
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(btn1)) {
			Set_Weights_for_Objective_Function_Tourism.main();
		}
		if (e.getSource().equals(btn2)) {
			Set_Parameters_for_the_Selected_Algorithm_for_Tourism.main();
		}
		if (e.getSource().equals(btn3)) {
			Select_multi_Algorithm.main();
		}
		frm.setVisible(false);
	}
}
