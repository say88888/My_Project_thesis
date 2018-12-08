package GUI.GUI_Carpool;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;

import Generate_random_data.Generate_Data_of_Driver_multi_hop;
import Input_Output_txt.Carpool.Write_CarpoolData_Generation_Mode;

public class VII_Generate_Data_of_Driver_Randomly_multi_hop implements ActionListener {

	JFrame frm = new JFrame();
	Label lab = new Label();
	Label lab2 = new Label();

	JButton btn2 = new JButton("Run");
	JButton btn3 = new JButton("Exit");
	
	Checkbox ckb2 = new Checkbox("Run_multi_hop");

	 static String method;
	VII_Generate_Data_of_Driver_Randomly_multi_hop() {
		frm.setSize(500, 400); // 設定視窗的大小為 200*150
		frm.setLocation(400, 50); // 設定視窗位置為(100,50)
		frm.setTitle("VII_Generate_Data_of_Driver_Randomly_multi_hop");
		frm.setLayout(null);

		CheckboxGroup grp = new CheckboxGroup();
		ckb2.setCheckboxGroup(grp);
		
		ckb2.setBounds(60, 110, 200, 40);
	
		frm.add(ckb2);
		
		btn2.setBounds(200, 300, 100, 40);
		btn2.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
		frm.add(btn2);
		btn2.addActionListener(this);
		
		btn3.setBounds(370, 300, 100, 40);
		btn3.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
		frm.add(btn3);
		btn3.addActionListener(this);

		frm.setVisible(true); // 設定視窗為可見

	}

	public static void main() {

		new VII_Generate_Data_of_Driver_Randomly_multi_hop();
	}

	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
	
	
		if (ckb2.getState()==true &&btn == btn2) {
				try {
					Generate_Data_of_Driver_multi_hop.main();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			try {
				Write_CarpoolData_Generation_Mode.saveGeneration_Mode("multi_hop");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("分割已建立");
		}
		if (btn == btn3) {
			frm.setVisible(false); // 設定視窗為可見
		System.out.println("Exit");
		}
			
			
			
		}	
	
	public static String method(){
    	return method;
    }
}
