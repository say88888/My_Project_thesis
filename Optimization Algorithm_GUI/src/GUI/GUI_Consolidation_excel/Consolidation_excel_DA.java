package GUI.GUI_Consolidation_excel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import Make_Excel.Double_Auction.Arrangement_excel_GUI_DA;
import Make_Excel.Double_Auction.Consolidation_excel_GUI_DA;


public class Consolidation_excel_DA  implements ActionListener{
	JFrame frm = new JFrame();
	
	JButton btn1 = new JButton("Select_multi_Example_Arrangement_excel");
	JButton btn2 = new JButton("Select_multi_Algorithm_Arrangement_excel");
	JButton btn3 = new JButton("Run the Parameters to Arrangement");
	JButton btn4 = new JButton("Consolidation_excel");
	JButton btn5 = new JButton("Exit");
	
	Consolidation_excel_DA() {

		
		frm.setSize(500, 500); // 設定視窗的大小為 200*150
		frm.setLocation(150, 150); // 設定視窗位置為(100,50)
		frm.setTitle("Consolidation_excel");
		frm.setLayout(null);
		
		btn1.setBounds(50, 60, 370, 40);
		btn1.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));

		btn2.setBounds(50, 140, 370, 40);
		btn2.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
		 
		btn3.setBounds(50, 220, 370, 40);
		btn3.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
		
		btn4.setBounds(50, 300, 370, 40);
		btn4.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
		
		btn5.setBounds(50, 380, 370, 40);
		btn5.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
		frm.add(btn1);
		btn1.addActionListener(this);
		frm.add(btn2);
		btn2.addActionListener(this);
		frm.add(btn3);
		btn3.addActionListener(this);
		frm.add(btn4);
		btn4.addActionListener(this);
		frm.add(btn5);
		btn5.addActionListener(this);
		frm.setVisible(true);
	}
    public static void main( ) 
    { 
    	new Consolidation_excel_DA();
    	
    } 
    
    public void actionPerformed(ActionEvent e)   
	   {
    	JButton btn=(JButton) e.getSource();  
 	   if(btn==btn1){  
 		  Select_multi_Example_Arrangement_excel.main();
	     }
 	  if(btn==btn2){  
 		 Select_multi_Algorithm_Arrangement_excel.main();
      }
 	  if(btn==btn3){  
 		 Arrangement_excel_GUI_DA.main();
      }
	  if(btn==btn4){  
		  Consolidation_excel_GUI_DA.main();
	      }
	  if(btn==btn5){  
			 frm.setVisible(false);
	      }
	
	  }
    
}
