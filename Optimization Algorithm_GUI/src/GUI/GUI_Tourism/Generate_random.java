package GUI.GUI_Tourism;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;

import Generate_random_data.Generate_random_DA;
import Generate_random_data.Generate_random_Tourism;

public class Generate_random extends Tourism
implements ActionListener {
JFrame frm = new JFrame();
JButton btn5=new JButton("Set Parameter");
JButton btn9 = new JButton("Generate_random_DELTA.txt");
JButton btn10 = new JButton("Generate_random_PI.txt");
JButton btn1 = new JButton("Generate_random_Travel_Agents");
JButton btn2 = new JButton("Generate_random_Buyer");
JButton btn3 = new JButton("Generate_random_Hoteliers");
JButton btn6 = new JButton("Generate_random_Transportation");
JButton btn7 = new JButton("Generate_random_V");
JButton btn8 = new JButton("Generate_random_Parameter");
JButton btn4 = new JButton("EXIT");
Generate_random(){
	frm.setSize(500, 800); // 設定視窗的大小為 200*150
	frm.setLocation(150, 50); // 設定視窗位置為(100,50)
	frm.setTitle("Generate_random_Tourism");
	frm.setLayout(null);
	
	btn5.setBounds(50, 10, 370, 50);
	btn5.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
	
	btn9.setBounds(50, 70, 370, 50);
	btn9.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));

	btn10.setBounds(50, 130, 370, 50);
	btn10.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
	
	btn1.setBounds(50, 190, 370, 50);
	btn1.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));

	btn2.setBounds(50, 250, 370, 50);
	btn2.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
	
	btn3.setBounds(50, 310, 370, 50);
	btn3.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
	
	btn6.setBounds(50, 370, 370, 50);
	btn6.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
	
	btn7.setBounds(50, 430, 370, 50);
	btn7.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
	
	btn8.setBounds(50, 500, 370, 50);
	btn8.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
	
	btn4.setBounds(50, 560, 370, 50);
	btn4.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
	
	frm.add(btn5);
	btn5.addActionListener(this);
	frm.add(btn9);
	btn9.addActionListener(this);
	frm.add(btn10);
	btn10.addActionListener(this);
	frm.add(btn1);
	btn1.addActionListener(this);
	frm.add(btn2);
	btn2.addActionListener(this);
	frm.add(btn3);
	btn3.addActionListener(this);
	frm.add(btn6);
	btn6.addActionListener(this);
	frm.add(btn7);
	btn7.addActionListener(this);
	frm.add(btn8);
	btn8.addActionListener(this);
	frm.add(btn4);
	btn4.addActionListener(this);
	frm.setVisible(true);
}
	public static void main( ) {
		// TODO Auto-generated method stub
		new Generate_random();
	}
	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(btn5)) {
			Generate_random_Set_Parameter.main();
			System.out.println("Set Parameter OK");
		}
		if (e.getSource().equals(btn9)) {
			try {
				Generate_random_Tourism.Generate_Data_of_Tourism_DELTA();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("DELTA.txt Data RUN OK");
		}
		if (e.getSource().equals(btn10)) {
			try {
				Generate_random_Tourism.Generate_Data_of_Tourism_PI();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("PI.txt Data RUN OK");
		}
		if (e.getSource().equals(btn1)) {
			try {
				Generate_random_Tourism.Generate_Data_of_Tourism_travel_agents();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("travel_agents Data RUN OK");
		}
		if (e.getSource().equals(btn2)) {
			try {
				Generate_random_Tourism.Generate_Data_of_Tourism_buyer();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("buyer Data RUN OK");
		}
		if (e.getSource().equals(btn3)) {
			try {
				Generate_random_Tourism.Generate_Data_of_Tourism_hoteliers();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("hoteliers Data RUN OK");
		}
		if (e.getSource().equals(btn6)) {
			try {
				Generate_random_Tourism.Generate_Data_of_Tourism_transportation();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("transportation Data RUN OK");
		}
		if (e.getSource().equals(btn7)) {
			Generate_random_V.main();
		}
		if (e.getSource().equals(btn8)) {
			try {
				Generate_random_Tourism.make_Parameter();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("Parameter Data RUN OK");
		}
		if (e.getSource().equals(btn4)) {
			frm.setVisible(false);
		}
		
	}
}