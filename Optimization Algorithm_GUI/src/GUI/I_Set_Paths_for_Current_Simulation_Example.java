package GUI;

import java.awt.Button;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class I_Set_Paths_for_Current_Simulation_Example extends Frame implements ActionListener 
{
	   JFrame frm = new JFrame();
	   JButton btn1 = new JButton("Select");
	   JFileChooser jfc = new JFileChooser();// 文件選擇器
	   static String path;
	   static String filename;
	   
	I_Set_Paths_for_Current_Simulation_Example(){
		 
		frm.setSize(200, 250); // 設定視窗的大小為 200*150
		frm.setLocation(400, 200); // 設定視窗位置為(100,50)
		 frm.setTitle("I_Set_Paths_for_Current_Simulation_Example");
		frm.setVisible(true); // 設定視窗為可見
		frm.setLayout(null);

		jfc.setCurrentDirectory(new File(System.getProperty("user.dir"))); //取得當前專案路徑
		  
		btn1.setBounds(50, 100, 100, 40);
		btn1.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
		frm.add(btn1);
	  
		btn1.addActionListener(this);
		frm.setVisible(true);
	}
	public static void main(   ) {
	
		new I_Set_Paths_for_Current_Simulation_Example();
	}

	public void actionPerformed(ActionEvent e)  
	{
		 if (e.getSource().equals(btn1)) {
		     jfc.setFileSelectionMode(1);// 設定只能選擇到資料夾 
	            int state = jfc.showOpenDialog(null);  
	            if (state == 1) {  
	                return;  
	            } else {  
	                File f = jfc.getSelectedFile();// f為選擇到的目錄
	                path=f.getAbsolutePath();
	                filename=f.getName();
	                System.out.println(f.getAbsolutePath());  
	                System.out.println(f.getName());
	            }  
		}
		frm.setVisible(false);
	}
	public static String path(){
		return path;
	}
	public static String filename(){
		return filename;
	}
	public static void Setpath(String Path){
		path=Path;
	}
	public static void setfilename(String Filename){
		 filename=Filename;
	}
}
