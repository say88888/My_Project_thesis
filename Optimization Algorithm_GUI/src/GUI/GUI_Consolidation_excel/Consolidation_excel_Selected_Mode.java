package GUI.GUI_Consolidation_excel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Consolidation_excel_Selected_Mode
		implements ActionListener {
	JFrame frm = new JFrame();
	JButton btn1 = new JButton("Carpool");
	JButton btn2 = new JButton("Double_Auction");
	
	Consolidation_excel_Selected_Mode() {

		frm.setSize(500, 400); // 設定視窗的大小為 200*150
		frm.setLocation(150, 150); // 設定視窗位置為(100,50)
		frm.setTitle("Consolidation_excel_Selected_Mode");
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
		new Consolidation_excel_Selected_Mode();
	}
	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(btn1)) {
			Consolidation_excel.main();
		}
		if (e.getSource().equals(btn2)) {
			Consolidation_excel_DA.main();
		}
		
		frm.setVisible(false);
	}
}
