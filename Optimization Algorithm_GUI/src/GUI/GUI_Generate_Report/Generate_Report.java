package GUI.GUI_Generate_Report;

import java.awt.*;  
import java.awt.event.*;  
import java.io.File;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Generate_Report extends JFrame implements ItemListener, ActionListener
{
   static Generate_Report frm=new Generate_Report();
   static List lst=new List();   
   static List lst2=new List();       
   static JTextField txt1=new JTextField();
   static JButton btn1=new JButton(">>");
   static JButton btn2=new JButton("<<");
   static JButton btn3=new JButton("Set Root Path for Existing Examples");
   static JButton btn4=new JButton("Ok");
   static JButton btn5=new JButton("Cancel");
   static JLabel lab1=new JLabel("Existing Examples");
   static JLabel lab2=new JLabel("Selected Examples");
   
   static Checkbox ckb1=new Checkbox("CPLEX");
   static Checkbox ckb2=new Checkbox("GA1");
   static Checkbox ckb3=new Checkbox("GA2");
   static Checkbox ckb4=new Checkbox("PSO1");
   static Checkbox ckb5=new Checkbox("PSO2");
   
   static JFileChooser jfc = new JFileChooser();// 文件選擇器
   static String path;
   static String filename;
   
   private static   ArrayList<String> lst_path1 = new ArrayList<String>(); 
   private static   ArrayList<String> lst_path2 = new ArrayList<String>(); 
   
   private static   ArrayList<String>select_Algorithm = new ArrayList<String>();
   
   
   public static void main()
   {
	 frm.setLayout(null);
      frm.setTitle("Generate Report");
      frm.setSize(600,500);
  	  frm.setLocation(600,200); // 設定視窗位置為(100,50)
 
      //txt1.setBounds(20,50,100,20);
      
      lab1.setBounds(130,120,150,20);
      lab2.setBounds(330,120,150,20);
      lst.setBounds(130,140,100,140);
      lst2.setBounds(330,140,100,140);
      btn1.setBounds(260,150,50,50);
      btn2.setBounds(260,200,50,50);
      btn3.setBounds(130,60,300,40);
      btn4.setBounds(200,300,80,40);
      btn5.setBounds(300,300,100,40);
      lst.addItemListener(frm);   
      
   //   btn1.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
      btn1.addActionListener(frm);
    //  btn2.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
      btn2.addActionListener(frm);
      btn3.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
      btn3.addActionListener(frm);
      btn4.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
      btn4.addActionListener(frm);
      btn5.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
      btn5.addActionListener(frm);
      frm.add(lab1);   
      frm.add(lab2); 
      frm.add(lst);   
      frm.add(lst2);
      frm.add(btn1);  
      frm.add(btn2);   
      frm.add(btn3);   
      frm.add(btn4);   
      frm.add(btn5);  
    
  	jfc.setCurrentDirectory(new File(System.getProperty("user.dir"))); //取得當前專案路徑
	 
    CheckboxGroup grp=new CheckboxGroup(); 
    
	ckb1.setBounds(40,40,140,40);
    ckb2.setBounds(40,80,140,40);
    ckb3.setBounds(40,120,140,40);
    ckb4.setBounds(40,160,140,40);
    ckb5.setBounds(40,200,140,40);
    
    ckb1.setCheckboxGroup(grp);          
    ckb2.setCheckboxGroup(grp);           
    ckb3.setCheckboxGroup(grp);
    ckb4.setCheckboxGroup(grp);
    ckb5.setCheckboxGroup(grp);

    frm.add(ckb1);
    frm.add(ckb2);
    frm.add(ckb3);
    frm.add(ckb4);
    frm.add(ckb5);
      
      frm.setVisible(true);  
   }
   public void itemStateChanged(ItemEvent e)  // �ƥ�B�z���{���X
   {
      String color=lst.getSelectedItem();  // ���o�Q������ﶵ�W��
      if(color=="yellow")          // �p�G�ﶵ�W�٬�yellow
         frm.setBackground(Color.yellow);
      else if(color=="orange")    // �p�G�ﶵ�W�٬�orange
         frm.setBackground(Color.orange);
      else if(color=="pink")      // �p�G�ﶵ�W�٬�pink
         frm.setBackground(Color.pink);   
      else if(color=="cyan")      // �p�G�ﶵ�W�٬�cyan
         frm.setBackground(Color.cyan);
      frm.setTitle("you select "+color);   // �]�w����frm�����D
   }
      public void actionPerformed(ActionEvent e)
   {
      JButton btn=(JButton) e.getSource();  // ���o�ƥ�ӷ�����
      if (btn==btn1)
         {
               if (lst.getSelectedIndex()>-1)
               {
            	   //System.out.println(lst.getSelectedIndex());
               	  lst2.add(lst.getSelectedItem());
               	 // System.out.println(lst.getSelectedItem());
               	  
               	 lst_path2.add(lst_path1.get(lst.getSelectedIndex()));
               	 
                 //System.out.println(lst_path1.get(lst.getSelectedIndex()));
                 
            	 lst_path1.remove(lst.getSelectedIndex());
               	 lst.remove(lst.getSelectedItem());
               
               }
         }  
      else if (btn==btn2)            
         {
         	if (lst2.getSelectedIndex()>-1){
         		
         		//System.out.println(lst2.getSelectedIndex());
         	   lst.add(lst2.getSelectedItem());
         	  //System.out.println(lst2.getSelectedItem());
         	  
         	 lst_path1.add(lst_path2.get(lst2.getSelectedIndex()));
         	 
         	//  System.out.println(lst_path2.get(lst2.getSelectedIndex()));
         	 lst_path2.remove(lst2.getSelectedIndex());
         	 
               lst2.remove(lst2.getSelectedItem());
         	}
         }
      else   if (btn==btn3) {
   		     jfc.setFileSelectionMode(1);// 設定只能選擇到資料夾 
   	            int state = jfc.showOpenDialog(null);  
   	            if (state == 1) {  
   	                return;  
   	            } else {  
   	                File f = jfc.getSelectedFile();// f為選擇到的目錄
   	                path=f.getAbsolutePath();
   	                filename=f.getName();
   	                //System.out.println(f.getAbsolutePath());  
   	               // System.out.println(f.getName());
   	                lst.add(f.getName());
   	             lst_path1.add(f.getAbsolutePath());
   	           //  System.out.print(lst_path1.get(0));
   	            }  
   		}
      
      else   if (btn==btn4) {
    	  
    	  select_Algorithm.clear();
    	  
    	  if(ckb1.getState()==true)
    		  select_Algorithm.add("CPLEX");
    	  
    	  else if(ckb2.getState()==true)
    		  select_Algorithm.add("GA1");
    	  
    	  else if(ckb3.getState()==true)
    		  select_Algorithm.add("GA2");
    	  
    	  else if(ckb4.getState()==true)
    		  select_Algorithm.add("PSO1");
    	  
    	  else if(ckb5.getState()==true)
    		  select_Algorithm.add("PSO2");
    	  
    	  	show_report.main();
		}
      
      else   if (btn==btn5) {
	
    	  frm.setVisible(false);  
		}
      
   }
      
      
      public static ArrayList<String> lst_path1(){
  		return (ArrayList<String>) lst_path1;
  	}
      
      public static ArrayList<String>  lst_path2(){
  		return (ArrayList<String>)  lst_path2;
  	}
      
      public static ArrayList<String>  select_Algorithm(){
    		return (ArrayList<String>)  select_Algorithm;
    	}
}