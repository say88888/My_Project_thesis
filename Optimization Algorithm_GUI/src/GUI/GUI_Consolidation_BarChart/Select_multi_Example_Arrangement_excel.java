package GUI.GUI_Consolidation_BarChart;

import java.awt.*;  
import java.awt.event.*;  
import java.io.File;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Select_multi_Example_Arrangement_excel implements ActionListener
{
	JFrame frm = new JFrame();
   static List lst=new List();
   static List lst2=new List();  ;      
    JButton btn1=new JButton(">>");
    JButton btn2=new JButton("<<");
    JButton btn4=new JButton("Ok");
    JButton btn5=new JButton("Cancel");
   static JLabel lab1=new JLabel(" Existing Examples");
   static JLabel lab2=new JLabel("Selected Examples");
     
   private static   ArrayList<String> lst_Path1= new ArrayList<String>();
   private static   ArrayList<String> lst_Path2 = new ArrayList<String>(); 
   
   
   Select_multi_Example_Arrangement_excel()
   {
	   lst=new List();
	   lst_Path1.clear();
	   
	  initialize_list();
	  frm.setLayout(null);
      frm.setTitle("Select_multi_Existing");
      frm.setSize(800,500);
  	  frm.setLocation(600,200); // 設定視窗位置為(100,50)
      
      lab1.setBounds(90,70,180,20);
      lab2.setBounds(460,70,180,20);
      lst.setBounds(50,90,280,200);
      lst2.setBounds(420,90,280,200);
      btn1.setBounds(350,150,50,50);
      btn2.setBounds(350,200,50,50);

      btn4.setBounds(280,300,80,40);
      btn5.setBounds(400,300,100,40);
      
   //   btn1.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
      btn1.addActionListener(this);
    //  btn2.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
      btn2.addActionListener(this);
      btn4.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
      btn4.addActionListener(this);
      btn5.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
      btn5.addActionListener(this);
      frm.add(lab1);   
      frm.add(lab2); 
      frm.add(lst);   
      frm.add(lst2);
      frm.add(btn1);  
      frm.add(btn2);      
      frm.add(btn4);   
      frm.add(btn5);  
     
      frm.setVisible(true);  
   }
   
   public static void main( ) 
   { 
		// TODO Auto-generated method stub
	   	new Select_multi_Example_Arrangement_excel();
   }
   
   
      public void actionPerformed(ActionEvent e)
   {
      JButton btn=(JButton) e.getSource();  // ���o�ƥ�ӷ�����
      if (btn==btn1)
         {
               if (lst.getSelectedIndex()>-1)
               {
            	  System.out.println(lst.getSelectedIndex());
               	  lst2.add(lst.getSelectedItem());
               	  System.out.println(lst.getSelectedItem());
               	  
               	lst_Path2.add(lst_Path1.get(lst.getSelectedIndex()));
               	 
                 System.out.println(lst_Path1.get(lst.getSelectedIndex()));
                 
           // 	 lst_Select_Algorithm1.remove(lst.getSelectedIndex());
           //    	 lst.remove(lst.getSelectedItem());
               
               }
         }  
      else if (btn==btn2)            
         {
         	if (lst2.getSelectedIndex()>-1){
         		
         		//System.out.println(lst2.getSelectedIndex());
         	//   lst.add(lst2.getSelectedItem());
         	  //System.out.println(lst2.getSelectedItem());
         	  
         	 //lst_Select_Algorithm1.add(lst_Select_Algorithm2.get(lst2.getSelectedIndex()));
         	 
         	//  System.out.println(lst_Select_Algorithm2.get(lst2.getSelectedIndex()));
         		lst_Path2.remove(lst2.getSelectedIndex());
         	 
             lst2.remove(lst2.getSelectedItem());
         	}
         }
   
      	if (btn==btn4) {
    	  frm.setVisible(false);  
		}
      
         if (btn==btn5) {
    	  frm.setVisible(false);  
		}
     
   }
      
      
      public static ArrayList<String> lst_Path1(){
  		return (ArrayList<String>) lst_Path1;
  	}
      
      public static ArrayList<String>  lst_Path2(){
  		return (ArrayList<String>)  lst_Path2;
  	}
      
      static void initialize_list(){
    	
    	  int k;

  		String fileName;

  		fileName = "output\\";

  		String[] filename;
  		String CfileName;
  		
  		File f = new File(fileName);
		if (f.isDirectory()) {
			filename = f.list();
			System.out.println("開始讀檔...");

			for (k = 0; k < filename.length; k++) {
				// ---------------------
				CfileName = fileName + "\\" + filename[k] + "\\";
				System.out.println(CfileName);
				File f1 = new File(CfileName);
			//	File f2 = new File(fileName + "\\" + filename[k]+"\\"+filename[k]+".xls");
				if(f1.isFile()  ){
				  lst_Path1.add(filename[k]);
		         lst.add(filename[k]);
				}
			}
		}
    	}
}