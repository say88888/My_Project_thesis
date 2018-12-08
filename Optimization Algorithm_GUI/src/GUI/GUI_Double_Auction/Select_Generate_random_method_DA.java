package GUI.GUI_Double_Auction;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;

import Algorithm_DoubleAuction.DE_Real_DA_Problem3.Double_Auction_DE_Real_Problem3;
import Cplex.CPLEX_DA_Problem3;
import Input_Output_txt.Double_Auction.Write_Data_Generation_Mode;
 

public class Select_Generate_random_method_DA extends Double_Auction
implements ActionListener {
JFrame frm = new JFrame();
JButton btn1 = new JButton("Generate_random_DA");
JButton btn2 = new JButton("Generate_random_DA_Buyer");
JButton btn3 = new JButton("Generate_random_DA_Seller");
JButton btn4 = new JButton("Generate_random_DA_USE_CATS");
JButton btn5 = new JButton("Generate_random_DA_Problem3");

Select_Generate_random_method_DA(){
	frm.setSize(500, 600); // 設定視窗的大小為 200*150
	frm.setLocation(150, 100); // 設定視窗位置為(100,50)
	frm.setTitle("Generate_random_Double_Auction");
	frm.setLayout(null);
	
	btn1.setBounds(50, 70, 370, 60);
	btn1.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));

	btn2.setBounds(50, 170, 370, 60);
	btn2.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
	
	btn3.setBounds(50, 270, 370, 60);
	btn3.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
	
	btn4.setBounds(50, 370, 370, 60);
	btn4.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
	
	btn5.setBounds(50, 470, 370, 60);
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
	public static void main(  ) {
		// TODO Auto-generated method stub
		new Select_Generate_random_method_DA();
	}
	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(btn1)) {
			 Generate_random_Double_Auction.main();
			 
			 String mode="Generate_random_DA";
			 try {
				Write_Data_Generation_Mode.saveGeneration_Mode(mode);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getSource().equals(btn2)) {
			Generate_random_Double_Auction_Buyer.main();
			
			String mode="Generate_random_DA_Buyer";
			 try {
				Write_Data_Generation_Mode.saveGeneration_Mode(mode);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getSource().equals(btn3)) {
			Generate_random_Double_Auction_Seller.main();
			
			String mode="Generate_random_DA_Seller";
			 try {
				Write_Data_Generation_Mode.saveGeneration_Mode(mode);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getSource().equals(btn4)) {
			Select_Generate_random_Auction_USE_CATS.main();
			
			String mode="Generate_random_DA_USE_CATS";
			 try {
				Write_Data_Generation_Mode.saveGeneration_Mode(mode);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getSource().equals(btn5)) {
			Generate_random_Double_Auction_Problem3.main();
			
			String mode="Generate_random_DA_Problem3";
			 try {
				
				Write_Data_Generation_Mode.saveGeneration_Mode(mode);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		frm.setVisible(false);
	}
}
