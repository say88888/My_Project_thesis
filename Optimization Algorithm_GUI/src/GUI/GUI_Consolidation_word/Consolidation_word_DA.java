package GUI.GUI_Consolidation_word;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;


public class Consolidation_word_DA  implements ActionListener{
	JFrame frm = new JFrame();
	
	JButton btn1 = new JButton("Select_multi_Example");
	JButton btn2 = new JButton("Set_Parameters");
//	JButton btn3 = new JButton("Run the Parameters to Arrangement");
	JButton btn4 = new JButton("Consolidation_word");
	JButton btn5 = new JButton("Exit");
	
	Consolidation_word_DA() {

		
		frm.setSize(500, 500); // 設定視窗的大小為 200*150
		frm.setLocation(150, 150); // 設定視窗位置為(100,50)
		frm.setTitle("Consolidation_excel");
		frm.setLayout(null);
		
		btn1.setBounds(50, 60, 370, 40);
		btn1.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));

		btn2.setBounds(50, 140, 370, 40);
		btn2.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
		 
	//	btn3.setBounds(50, 220, 370, 40);
	//	btn3.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
		
		btn4.setBounds(50, 300, 370, 40);
		btn4.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
		
		btn5.setBounds(50, 380, 370, 40);
		btn5.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
		frm.add(btn1);
		btn1.addActionListener(this);
		frm.add(btn2);
		btn2.addActionListener(this);
	//	frm.add(btn3);
	//	btn3.addActionListener(this);
		frm.add(btn4);
		btn4.addActionListener(this);
		frm.add(btn5);
		btn5.addActionListener(this);
		frm.setVisible(true);
	}
    public static void main() 
    { 
    	new Consolidation_word_DA();
    	
    } 
    
    public void actionPerformed(ActionEvent e)   
	   {
    	JButton btn=(JButton) e.getSource();  
 	   if(btn==btn1){  
 		  Select_multi_Example.main();
	     }
 	  if(btn==btn2){  
  		 Set_Parameter.main();
       }
 	//  if(btn==btn3){  
 //		 Arrangement_excel_GUI.main();
  //    }
	  if(btn==btn4){  
			try {
				Create_word_table_DA.main();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	
	      }
	  if(btn==btn5){  
			 frm.setVisible(false);
	      }
	
	  }
    
}
