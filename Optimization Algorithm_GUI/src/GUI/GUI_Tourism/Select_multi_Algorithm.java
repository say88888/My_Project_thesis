package GUI.GUI_Tourism;

import java.awt.*;  
import java.awt.event.*;  
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Select_multi_Algorithm extends Tourism implements ActionListener
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
	   static JLabel lab3=new JLabel();
	   
	  	JButton btn6=new JButton("重置");
	   	JButton btn7=new JButton("儲存 lst2 的演算法");
	   	JButton btn8=new JButton("讀取儲存的演算法");
	   
	 	JTextField txf1 = new JTextField();
	   private static   ArrayList<String> lst_Select_Algorithm1= new ArrayList<String>();
	   private static   ArrayList<String> lst_Select_Algorithm2 = new ArrayList<String>(); 
	   
	   private static int repeat=1;
	   Select_multi_Algorithm()
	   {
		   lst.clear();
		   lst_Select_Algorithm1.clear();; 
		   
		  initialize_list();
		  frm.setLayout(null);
	      frm.setTitle("Select_multi_Algorithm");
	      frm.setSize(700,500);
	  	  frm.setLocation(600,200); // 設定視窗位置為(100,50)
	      
	  	   lab1.setBounds(80,70,180,20);
	       lab2.setBounds(420,70,180,20);
	       lst.setBounds(50,90,250,140);
	       lst2.setBounds(400,90,250,140);
	       btn1.setBounds(320,100,50,50);
	       btn2.setBounds(320,180,50,50);

	       btn4.setBounds(250,320,80,40);
	       btn5.setBounds(350,320,100,40);
	       
	       btn6.setBounds(100,10,120,40);
	       btn7.setBounds(300,10,150,40);
	       btn8.setBounds(500,10,150,40);
	       
	       lab3.setText("重複跑批次 :");
	 	  lab3.setBackground(Color.white);
	 		// lab1.setAlignment(Label.CENTER);
	 	  lab3.setForeground(Color.blue);
	 	  lab3.setLocation(180, 260); // �]�w���Ҧ�m
	 	  lab3.setSize(250, 40); // �]�w���Ҥj�p
	 	  lab3.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 18));
	 	  frm.add(lab3);
	 		
	       txf1.setBounds(320, 270, 50, 20);
	       txf1.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
	       txf1.setText("1");
	       frm.add(txf1);

	       
	    //   btn1.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
	       btn1.addActionListener(this);
	     //  btn2.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
	       btn2.addActionListener(this);
	       btn4.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
	       btn4.addActionListener(this);
	       btn5.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
	       btn5.addActionListener(this);
	       btn6.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
	       btn6.addActionListener(this);
	       btn7.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
	       btn7.addActionListener(this);
	       btn8.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
	       btn8.addActionListener(this);
	       frm.add(lab1);   
	       frm.add(lab2); 
	       frm.add(lst);   
	       frm.add(lst2);
	       frm.add(btn1);  
	       frm.add(btn2);      
	       frm.add(btn4);   
	       frm.add(btn5);  
	       frm.add(btn6);   
	       frm.add(btn7);  
	       frm.add(btn8);  
	       frm.setVisible(true);  
	   }
	   
	   public static void main() 
	   { 
			// TODO Auto-generated method stub
		   	new Select_multi_Algorithm();
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
            //   	 lst.remove(lst.getSelectedItem());
               
               }
         }  
      else if (btn==btn2)            
         {
         	if (lst2.getSelectedIndex()>-1){
         		
         		//System.out.println(lst2.getSelectedIndex());
         //	   lst.add(lst2.getSelectedItem());
         	  //System.out.println(lst2.getSelectedItem());
         	  
         //	 lst_Select_Algorithm1.add(lst_Select_Algorithm2.get(lst2.getSelectedIndex()));
         	 
         	//  System.out.println(lst_Select_Algorithm2.get(lst2.getSelectedIndex()));
         	 lst_Select_Algorithm2.remove(lst2.getSelectedIndex());
         	 
               lst2.remove(lst2.getSelectedItem());
         	}
         }
   
      	if (btn==btn4) {
      	   	repeat=Integer.parseInt(txf1.getText());
    	  frm.setVisible(false);  
		}
      
         if (btn==btn5) {
    	  frm.setVisible(false);  
		}
         if (btn==btn6) {
         	lst2.clear();
         	lst_Select_Algorithm2.clear();
         	 
    		}
          
          if (btn==btn7) {
         	 
         	 try {
 				saveSelect_Algorithm2 ();
 			} catch (IOException e1) {
 				// TODO Auto-generated catch block
 				e1.printStackTrace();
 			}
         	 
    		}
          
          if (btn==btn8) {
         	 Read_Select_Algorithm();
    		}
   }
      
      
      public static ArrayList<String> lst_Select_Algorithm1(){
  		return (ArrayList<String>) lst_Select_Algorithm1;
  	}
      
      public static ArrayList<String>  lst_Select_Algorithm2(){
  		return (ArrayList<String>)  lst_Select_Algorithm2;
  	}
      public static int  repeat(){
    		return  repeat;
    	}
      public static void initialize_list(){
    	  
    	  lst_Select_Algorithm1.add("CPLEX");
          lst.add("CPLEX");
          lst_Select_Algorithm1.add("GA1");
          lst.add("GA1");
          lst_Select_Algorithm1.add("GA2");
          lst.add("GA2");
          lst_Select_Algorithm1.add("PSO1");
          lst.add("PSO1");
          lst_Select_Algorithm1.add("PSO2");
          lst.add("PSO2");
          lst_Select_Algorithm1.add("ALPSO");
          lst.add("ALPSO");
          lst_Select_Algorithm1.add("LRPSO");
          lst.add("LRPSO");
          lst_Select_Algorithm1.add("LR");
          lst.add("LR");
          lst_Select_Algorithm1.add("LR_and_PSO2");
          lst.add("LR_and_PSO2");
          lst_Select_Algorithm1.add("LR_and_PSO1");
          lst.add("LR_and_PSO1");
          lst_Select_Algorithm1.add("CCPSO2");
          lst.add("CCPSO2");
          
          lst_Select_Algorithm1.add("DE_Tourism");
          lst.add("DE_Tourism");
          lst_Select_Algorithm1.add("DE_Tourism_strategy1");
          lst.add("DE_Tourism_strategy1");
          lst_Select_Algorithm1.add("DE_Tourism_strategy2");
          lst.add("DE_Tourism_strategy2");
          lst_Select_Algorithm1.add("DE_Tourism_strategy3");
          lst.add("DE_Tourism_strategy3");
          lst_Select_Algorithm1.add("DE_Tourism_strategy4");
          lst.add("DE_Tourism_strategy4");
          lst_Select_Algorithm1.add("DE_Tourism_strategy5");
          lst.add("DE_Tourism_strategy5");
          lst_Select_Algorithm1.add("DE_Tourism_strategy6");
          lst.add("DE_Tourism_strategy6");
          
          lst_Select_Algorithm1.add("DE_Tourism_Real");
          lst.add("DE_Tourism_Real");
          lst_Select_Algorithm1.add("DE_Tourism_strategy1_Real");
          lst.add("DE_Tourism_strategy1_Real");
          lst_Select_Algorithm1.add("DE_Tourism_strategy2_Real");
          lst.add("DE_Tourism_strategy2_Real");
          lst_Select_Algorithm1.add("DE_Tourism_strategy3_Real");
          lst.add("DE_Tourism_strategy3_Real");
          lst_Select_Algorithm1.add("DE_Tourism_strategy4_Real");
          lst.add("DE_Tourism_strategy4_Real");
          lst_Select_Algorithm1.add("DE_Tourism_strategy5_Real");
          lst.add("DE_Tourism_strategy5_Real");
          lst_Select_Algorithm1.add("DE_Tourism_strategy6_Real");
          lst.add("DE_Tourism_strategy6_Real");
          lst_Select_Algorithm1.add("NSDE");
          lst.add("NSDE");
          lst_Select_Algorithm1.add("SaNSDE");
          lst.add("SaNSDE");
         
          lst_Select_Algorithm1.add("DE_Real_POP");
          lst.add("DE_Reall_POP");
          lst_Select_Algorithm1.add("DE_strategy1_Real_POP");
          lst.add("DE_strategy1_Real_POP");
          lst_Select_Algorithm1.add("DE_strategy2_Real_POP");
          lst.add("DE_strategy2_Real_POP");
          lst_Select_Algorithm1.add("DE_strategy3_Real_POP");
          lst.add("DE_strategy3_Real_POP");
          lst_Select_Algorithm1.add("DE_strategy4_Real_POP");
          lst.add("DE_strategy4_Real_POP");
          lst_Select_Algorithm1.add("DE_strategy5_Real_POP");
          lst.add("DE_strategy5_Real_POP");
          lst_Select_Algorithm1.add("DE_strategy6_Real_POP");
          lst.add("DE_strategy6_Real_POP");

          lst_Select_Algorithm1.add("NSDE_POP");
          lst.add("NSDE_POP");
          lst_Select_Algorithm1.add("SaNSDE_POP");
          lst.add("SaNSDE_POP");
          lst_Select_Algorithm1.add("DECC_POP");
          lst.add("DECC_POP");
          
          lst_Select_Algorithm1.add("DE_Real_POP_NEW");
          lst.add("DE_Reall_POP_NEW");
          lst_Select_Algorithm1.add("DE_strategy1_Real_POP_NEW");
          lst.add("DE_strategy1_Real_POP_NEW");
          lst_Select_Algorithm1.add("DE_strategy2_Real_POP_NEW");
          lst.add("DE_strategy2_Real_POP_NEW");
          lst_Select_Algorithm1.add("DE_strategy3_Real_POP_NEW");
          lst.add("DE_strategy3_Real_POP_NEW");
          lst_Select_Algorithm1.add("DE_strategy4_Real_POP_NEW");
          lst.add("DE_strategy4_Real_POP_NEW");
          lst_Select_Algorithm1.add("DE_strategy5_Real_POP_NEW");
          lst.add("DE_strategy5_Real_POP_NEW");
          lst_Select_Algorithm1.add("DE_strategy6_Real_POP_NEW");
          lst.add("DE_strategy6_Real_POP_NEW");
          
          lst_Select_Algorithm1.add("NSDE_POP_NEW");
          lst.add("NSDE_POP_NEW");
          lst_Select_Algorithm1.add("SaNSDE_POP_NEW");
          lst.add("SaNSDE_POP_NEW");
          lst_Select_Algorithm1.add("DECC_POP_NEW");
          lst.add("DECC_POP_NEW");
          
          lst_Select_Algorithm1.add("DynDE");
          lst.add("DynDE");
          lst_Select_Algorithm1.add("DynDE_POP");
          lst.add("DynDE_POP");
          lst_Select_Algorithm1.add("ALPSO2_NEW");
          lst.add("ALPSO2_NEW");
          lst_Select_Algorithm1.add("ALPSO2_NEW_PrematureConvegence1");
          lst.add("ALPSO2_NEW_PrematureConvegence1");
          
          lst_Select_Algorithm1.add("DMS-L-PSO");
          lst.add("DMS-L-PSO");
          lst_Select_Algorithm1.add("DMSDL-PSO");
          lst.add("DMSDL-PSO");
          lst_Select_Algorithm1.add("NLPSO2");
          lst.add("NLPSO2");
          lst_Select_Algorithm1.add("CLPSO2");
          lst.add("CLPSO2");
          lst_Select_Algorithm1.add("CC-CLPSO2");
          lst.add("CC-CLPSO2");
          lst_Select_Algorithm1.add("DECC");
          lst.add("DECC");
          lst_Select_Algorithm1.add("FA_PSO");
          lst.add("FA_PSO");
          lst_Select_Algorithm1.add("FA");
          lst.add("FA");
          
          lst_Select_Algorithm1.add("L-SHADE");
          lst.add("L-SHADE");
          
          lst_Select_Algorithm1.add("L_SHADE_CCPSO2");
          lst.add("L_SHADE_CCPSO2");
      }
      
      public static void saveSelect_Algorithm2 ( ) throws IOException{

  		 FileWriter fw2 = new FileWriter("Select_Algorithm_Double_Auction.txt");
  		 for(int i=0;i<lst_Select_Algorithm2.size();i++){
  			fw2.write(lst_Select_Algorithm2.get(i)+"\r\n");
  		 }
  			fw2.close();
  	}
      
  	public static void Read_Select_Algorithm( ) {
		// TODO Auto-generated method stub
		String str;
		
		int i,j,k=0;
		lst_Select_Algorithm2.clear();
		lst2.clear();
		// TODO Auto-generated method stub
		try {
			FileReader PBr = new FileReader("Select_Algorithm_Double_Auction.txt");
			BufferedReader br = new BufferedReader(PBr);
			while ((str = br.readLine()) != null) { //每次讀一行
				k++;
				lst_Select_Algorithm2.add(str); //將此行以空白(white space)切成字串陣列, 存入 Vector暫存 
				lst2.add(str);
		}
		br.close(); //關檔
		} catch (Exception e) {
		e.printStackTrace();
		}
	
	}
      
      
}