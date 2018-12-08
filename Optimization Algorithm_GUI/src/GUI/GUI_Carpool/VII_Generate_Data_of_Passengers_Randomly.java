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

import Generate_random_data.Generate_Data_of_Passengers_Randomly_many_to_many;
import Generate_random_data.Generate_Data_of_Passengers_Randomly_many_to_one;
import Generate_random_data.Generate_Data_of_Passengers_Randomly_one_to_many;
import Generate_random_data.Generate_Data_of_Passengers_Randomly_one_to_one;
import Generate_random_data.Generate_Data_of_Passengers_Sample;
import Input_Output_txt.Carpool.Read_Requirements_QuantityBounds;
import Input_Output_txt.Carpool.Write_CarpoolData_Generation_Mode;
import Input_Output_txt.Double_Auction.Write_Data_Generation_Mode;

public class VII_Generate_Data_of_Passengers_Randomly implements ActionListener {

	JFrame frm = new JFrame();
	Label lab = new Label();
	Label lab2 = new Label();

	JButton btn1 = new JButton("Set");
	JButton btn2 = new JButton("Run");
	JButton btn3 = new JButton("Exit");
	
	Checkbox ckb0 = new Checkbox("Run_Small example");
	Checkbox ckb1 = new Checkbox("Run_Randomly");
	Checkbox ckb2 = new Checkbox("Run_one_to_one");
	Checkbox ckb3 = new Checkbox("Run_one_to_many");
	Checkbox ckb4 = new Checkbox("Run_many_to_one");
	Checkbox ckb5 = new Checkbox("Run_many_to_many");
	 static String method;
	VII_Generate_Data_of_Passengers_Randomly() {
		frm.setSize(500, 400); // 設定視窗的大小為 200*150
		frm.setLocation(400, 50); // 設定視窗位置為(100,50)
		frm.setTitle("VI_Generate_Data_of_Passengers_Randomly");
		frm.setLayout(null);

		CheckboxGroup grp = new CheckboxGroup();
		ckb0.setCheckboxGroup(grp);
		ckb1.setCheckboxGroup(grp);
		ckb2.setCheckboxGroup(grp);
		ckb3.setCheckboxGroup(grp);
		ckb4.setCheckboxGroup(grp);
		ckb5.setCheckboxGroup(grp);

		ckb0.setBounds(60, 10, 200, 40);
		ckb1.setBounds(60, 60, 200, 40);
		ckb2.setBounds(60, 110, 200, 40);
		ckb3.setBounds(60, 160, 200, 40);
		ckb4.setBounds(60, 210, 200, 40);
		ckb5.setBounds(60, 260, 200, 40);

		frm.add(ckb0);
		frm.add(ckb1);
		frm.add(ckb2);
		frm.add(ckb3);
		frm.add(ckb4);
		frm.add(ckb5);

		btn1.setBounds(30, 300, 100, 40);
		btn1.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
		frm.add(btn1);
		btn1.addActionListener(this);
		
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

		new VII_Generate_Data_of_Passengers_Randomly();
	}

	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		if (ckb0.getState()==true &&btn == btn2) {
			try {
				Generate_Data_of_Passengers_Sample.Generate_Data_of_Passengers_Sample();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				Write_CarpoolData_Generation_Mode.saveGeneration_Mode("Same_place");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (ckb1.getState()==true &&btn == btn2) {
			try {
				Generate_Data_of_Passengers_Randomly_one_to_one.Generate_Data_of_Passengers_Randomly(0);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				Write_CarpoolData_Generation_Mode.saveGeneration_Mode("Passengers_Randomly");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (ckb2.getState()==true &&btn == btn2) {
			try {
				Generate_Data_of_Passengers_Randomly_one_to_one.Generate_Data_of_Passengers_Randomly(1);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			try {
				Write_CarpoolData_Generation_Mode.saveGeneration_Mode("One_to_one");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (ckb3.getState()==true &&btn == btn1) {
			Set_Requirements_QuantityBounds.main();
			method="one_to_many";
		}
		if (ckb4.getState()==true &&btn == btn1) {
			Set_Requirements_QuantityBounds.main();
			method="many_to_one";
		}
		if (ckb5.getState()==true &&btn == btn1) {
			Set_Requirements_QuantityBounds.main();
			method="many_to_many";
		}
		if (btn == btn3) {
			frm.setVisible(false);
		}
		if (btn==btn2) {
			Read_Requirements_QuantityBounds.main();
			if(ckb3.getState()==true){
				
					try {
						Generate_Data_of_Passengers_Randomly_one_to_many.Generate_Data_of_Passengers_Randomly_One_to_many(Read_Requirements_QuantityBounds.Requirements_Quantity_lower(),Read_Requirements_QuantityBounds.Requirements_Quantity_higher());
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					try {
						Write_CarpoolData_Generation_Mode.saveGeneration_Mode("One_to_many");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
			if(ckb4.getState()==true){
			
					try {
						Generate_Data_of_Passengers_Randomly_many_to_one.Generate_Data_of_Passengers_Randomly_many_to_one(Read_Requirements_QuantityBounds.Requirements_Quantity_lower(),Read_Requirements_QuantityBounds.Requirements_Quantity_higher());
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						Write_CarpoolData_Generation_Mode.saveGeneration_Mode("Many_to_one");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
			if(ckb5.getState()==true){
		
					try {
						Generate_Data_of_Passengers_Randomly_many_to_many.Generate_Data_of_Passengers_Randomly_many_to_many(Read_Requirements_QuantityBounds.Requirements_Quantity_lower(),Read_Requirements_QuantityBounds.Requirements_Quantity_higher());
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						Write_CarpoolData_Generation_Mode.saveGeneration_Mode("Many_to_many");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
			System.out.println("乘客已建立");
		}	
	}
	public static String method(){
    	return method;
    }
}
