package GUI.GUI_Double_Auction;

import java.awt.*;  
import java.awt.event.*;  
import java.io.File;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import GUI.I_Set_Paths_for_Current_Simulation_Example;

public class Select_multi_Algorithm_show_chart_DA extends Double_Auction implements ActionListener
{
	JFrame frm = new JFrame();
   static List lst=new List();   ;
   static List lst2=new List();  ;      
    JButton btn1=new JButton(">>");
    JButton btn2=new JButton("<<");
    JButton btn4=new JButton("Ok");
    JButton btn5=new JButton("Cancel");
   static JLabel lab1=new JLabel("Existing Algorithm");
   static JLabel lab2=new JLabel("Selected Algorithm");
     
   private static   ArrayList<String> lst_Select_Algorithm1= new ArrayList<String>();
   private static   ArrayList<String> lst_Select_Algorithm2 = new ArrayList<String>(); 
   
   
   Select_multi_Algorithm_show_chart_DA()
   {
	   lst.clear();
	   lst_Select_Algorithm1.clear();; 
	   
	  initialize_list();
	  frm.setLayout(null);
      frm.setTitle("Select_multi_Algorithm");
      frm.setSize(600,500);
  	  frm.setLocation(600,200); // 設定視窗位置為(100,50)
      
      lab1.setBounds(80,70,180,20);
      lab2.setBounds(360,70,180,20);
      lst.setBounds(50,90,190,140);
      lst2.setBounds(330,90,190,140);
      btn1.setBounds(260,150,50,50);
      btn2.setBounds(260,200,50,50);

      btn4.setBounds(200,300,80,40);
      btn5.setBounds(300,300,100,40);
      
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
	   	new Select_multi_Algorithm_show_chart_DA();
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
               	  
               	 lst_Select_Algorithm2.add(lst_Select_Algorithm1.get(lst.getSelectedIndex()));
               	 
                 System.out.println(lst_Select_Algorithm1.get(lst.getSelectedIndex()));
                 
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
         	 lst_Select_Algorithm2.remove(lst2.getSelectedIndex());
         	 
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
      
      
      public static ArrayList<String> lst_Select_Algorithm1(){
  		return (ArrayList<String>) lst_Select_Algorithm1;
  	}
      
      public static ArrayList<String>  lst_Select_Algorithm2(){
  		return (ArrayList<String>)  lst_Select_Algorithm2;
  	}
      
      public static void initialize_list(){
    	
    	  int k;

  		String fileName;

  		fileName = "output\\"+I_Set_Paths_for_Current_Simulation_Example.filename();

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
				File f2 = new File(CfileName+"Original_data.xls");
				if(f1.isDirectory() && f2.isFile()){
				  lst_Select_Algorithm1.add(filename[k]);
		         lst.add(filename[k]);
				}
			}
		}
    	  
    
 

    	}
}