package GUI.GUI_Double_Auction;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;

import GUI.I_Set_Paths_for_Current_Simulation_Example;
import Generate_random_data.File_funtion;
import Generate_random_data.Read_CATS_output_and_Genarate_data_for_SingleAuction;
import Input_Output_txt.Double_Auction.Read_Set_intput_CATS_Buyer_Parameter;

public class Single_Auction_USE_CATS  implements ActionListener {
	JFrame frm = new JFrame();
	JButton btn1 = new JButton("Set_Buyer_Parameter");
	JButton btn2 = new JButton("RUN_CATS.exe");
	JButton btn3 = new JButton("File_copy_and_delete");
	JButton btn4 = new JButton("Write_combinatorial auction.txt");
	JButton btn5 = new JButton("Rename_folder");
	JButton btn6 = new JButton("EXIT");
	
	Single_Auction_USE_CATS() {
		// TODO Auto-generated method stub
		Read_Set_intput_CATS_Buyer_Parameter.Single_Auction();
		frm.setSize(450, 610); // 設定視窗的大小為 200*150
		frm.setLocation(250, 100); // 設定視窗位置為(100,50)
		frm.setTitle("Generate_random_Double_Auction_USE_CATS");
		frm.setLayout(null);
		
		btn1.setBounds(50, 40, 300, 60);
		btn1.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));

		btn2.setBounds(50,130, 300, 60);
		btn2.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
		
		btn3.setBounds(50, 220, 300, 60);
		btn3.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
		
		btn4.setBounds(50, 310, 300, 60);
		btn4.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
		
		btn5.setBounds(50, 400, 300, 60);
		btn5.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
		
		btn6.setBounds(50, 490, 300, 60);
		btn6.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
		
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
		frm.add(btn6);
		btn6.addActionListener(this);
		frm.setVisible(true);
	}

	public static void main( ) {
		// TODO Auto-generated method stub
		new Single_Auction_USE_CATS();
	}
	
	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(btn1)) {
	
			Set_CATS_Single_Auction_BuyerParameter.main();
			System.out.println("Set_Buyer_Parameter");
		}
		
		if (e.getSource().equals(btn2)) {
						try {
							Run_Cats_Output_0000txt.Single_Auction_Buyer();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
			System.out.println("RUN_CATS OK");
		}
		
	if (e.getSource().equals(btn3)) {
		
		File f=new File(System.getProperty("user.dir"));
		
		String oldfile=f.getAbsolutePath()+"\\0000.txt";
		String newfile=I_Set_Paths_for_Current_Simulation_Example.path()+"\\CATS_Auction\\Single_Auction\\CATS_Buyerbids.txt";
		
		File_funtion.copyFile(oldfile, newfile);
		
		//File_funtion.delFile(oldfile);
		
		System.out.println("File_copy_and_delete");
		}
		
		if (e.getSource().equals(btn4)) {
		
			try {
				Read_CATS_output_and_Genarate_data_for_SingleAuction.main();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			System.out.println("Write_combinatorial auction.txt");
		}
		
	if (e.getSource().equals(btn5)) {
			
			try {
				Rename_folder.main();
			} catch (IOException | InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		if (e.getSource().equals(btn6)) {
			
			System.out.println("EXIT");
			 frm.setVisible(false);
		}
	}
}
