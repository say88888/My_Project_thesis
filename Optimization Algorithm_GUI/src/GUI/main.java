package GUI;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;

import GUI.GUI_Batch.Batch;
import GUI.GUI_Carpool.Carpool;
import GUI.GUI_Carpool.For_User;
import GUI.GUI_Consolidation_BarChart.Consolidation_BarChart_GUI;
import GUI.GUI_Consolidation_excel.Consolidation_excel_Selected_Mode;
import GUI.GUI_Consolidation_word.Consolidation_word_Selected_Mode;
import GUI.GUI_Double_Auction.Double_Auction;
import GUI.GUI_Generate_Report.Generate_Report;
import GUI.GUI_Tourism.Tourism;

public class main implements ActionListener {
	static JFrame frm = new JFrame("歡迎使用 ");
	static JButton btn1 = new JButton("Sure");
	static int method = 0;
	static Checkbox ckb1 = new Checkbox("Online");
	static Checkbox ckb2 = new Checkbox("Offline");
	static Checkbox ckb4 = new Checkbox("Batch");
	static Checkbox ckb6 = new Checkbox("For User");
	static Checkbox ckb7 = new Checkbox("Tourism");
	static Checkbox ckb5 = new Checkbox("Double_Auction");
	
	static JCheckBox ckb3 = new JCheckBox("Generate Report");
	static JCheckBox ckb8 = new JCheckBox("Consolidation_excel");
	static JCheckBox ckb9 = new JCheckBox("Consolidation_BarChart");
	static JCheckBox ckb10 = new JCheckBox("Consolidation_word");
	
	public static void main(String args[]) {		// TODO Auto-generated method stub
		new main();
	}

	main() {
		CheckboxGroup grp = new CheckboxGroup();
		frm.setSize(540, 350); // 設定視窗的大小為 200*150
		frm.setLocation(50, 50); // 設定視窗位置為(100,50)
		ckb1.setCheckboxGroup(grp);
		ckb2.setCheckboxGroup(grp);
		ckb5.setCheckboxGroup(grp);
		ckb4.setCheckboxGroup(grp);
		ckb6.setCheckboxGroup(grp);
		ckb7.setCheckboxGroup(grp);
		frm.setLayout(null);
		ckb1.setBounds(40, 60, 140, 40);
		ckb2.setBounds(40, 100, 140, 40);
		ckb3.setBounds(40, 20, 140, 40);
		ckb5.setBounds(180, 100, 140, 40);
		ckb4.setBounds(40, 140, 140, 40);
		ckb6.setBounds(40, 180, 140, 40);
		ckb7.setBounds(180, 140, 140, 40);
		ckb8.setBounds(320, 20, 140, 40);
		ckb9.setBounds(320, 60, 140, 40);
		ckb10.setBounds(320, 100, 140, 40);
		frm.add(ckb1);
		frm.add(ckb2);
		frm.add(ckb3);
		frm.add(ckb4);
		frm.add(ckb6);
		frm.add(ckb7);
		frm.add(ckb5);
		frm.add(ckb8);
		btn1.setBounds(180, 230, 140, 40);
		btn1.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));

		btn1.addActionListener(this);

		ckb3.setMnemonic(KeyEvent.VK_C);

		ckb3.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED)
					Generate_Report.main();
			}
		});
		frm.add(ckb3);
		
		ckb8.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED)
					Consolidation_excel_Selected_Mode.main();
			}
		});
		frm.add(ckb8);
		
		ckb9.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED)
					Consolidation_BarChart_GUI.main();
			}
		});
		frm.add(ckb9);
		
		ckb10.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED)
					Consolidation_word_Selected_Mode.main();
			}
		});
		frm.add(ckb10);
		
		frm.add(btn1);
		frm.setVisible(true); // 設定視窗為可見
	}

	public void actionPerformed(ActionEvent e) {

		if (ckb1.getState() && e.getSource().equals(btn1)) {
			method = 0;
			Carpool.main();
			try {
				Write_Batch_distance_MOD(method);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (ckb2.getState() && e.getSource().equals(btn1)) {
			method = 1;
			Carpool.main();
			try {
				Write_Batch_distance_MOD(method);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (ckb4.getState() && e.getSource().equals(btn1)) {
			method = 2;
			Batch.main();
		}

		if (ckb6.getState() && e.getSource().equals(btn1)) {
			method = 0;
			For_User.main();
		}
		if (ckb7.getState() && e.getSource().equals(btn1)) {
			method = 4;
			Tourism.main();
		}
		if (ckb5.getState() && e.getSource().equals(btn1)) {
			method = 3;
			Double_Auction.main();
		}
		frm.setVisible(false); // 設定視窗為不可見
	}
	

	public static int getmethod() {
		return method;
	}
	
	public static	void Write_Batch_distance_MOD(int method1) throws IOException{
		
		   FileWriter fw1 = new FileWriter("Read_Distance_MOD.txt");
		   
			if(method1==0)
			fw1.write("online");
			
		     if(method1==1)
				fw1.write("offline");
		     
		   fw1.close();
		   }
	
}
