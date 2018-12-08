package GUI.GUI_Tourism;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


public class Select_Generate_random_method extends Tourism
implements ActionListener {
JFrame frm = new JFrame();
JButton btn1 = new JButton("Generate_random");
//JButton btn2 = new JButton("Generate_random_DA_Buyer");
//JButton btn3 = new JButton("Generate_random_DA_Seller");

Select_Generate_random_method(){
	frm.setSize(500, 400); // 設定視窗的大小為 200*150
	frm.setLocation(150, 150); // 設定視窗位置為(100,50)
	frm.setTitle("Generate_random_Tourism");
	frm.setLayout(null);
	
	btn1.setBounds(50, 70, 370, 60);
	btn1.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));

/*	btn2.setBounds(50, 170, 370, 60);
	btn2.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
	
	btn3.setBounds(50, 270, 370, 60);
	btn3.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
	*/
	frm.add(btn1);
	btn1.addActionListener(this);
/*	frm.add(btn2);
	btn2.addActionListener(this);
	frm.add(btn3);
	btn3.addActionListener(this);*/
	frm.setVisible(true);
	
}
	public static void main(  ) {
		// TODO Auto-generated method stub
		new Select_Generate_random_method();
	}
	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(btn1)) {
			Generate_random.main();
		}
	/*	if (e.getSource().equals(btn2)) {
			Generate_random_Double_Auction_Buyer.main();
		}
		if (e.getSource().equals(btn3)) {
			Generate_random_Double_Auction_Seller.main();
		}*/
		frm.setVisible(false);
	}
}

