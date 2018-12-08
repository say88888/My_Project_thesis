package GUI.GUI_Batch;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Font;
import java.awt.Frame;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class X_Select_Algorithm_Type_to_Solve_the_Problem extends Batch implements ActionListener
{
	
	  static  JFrame frm=new  JFrame();
	  
	  JButton btn1=new JButton("Sure");
	  JButton btn2=new JButton("Exit");	
	
	     Checkbox ckb1=new Checkbox("CPLEX");
	     Checkbox ckb2=new Checkbox("GA1");
	     Checkbox ckb3=new Checkbox("GA2");
	     Checkbox ckb4=new Checkbox("PSO1");
	     Checkbox ckb5=new Checkbox("PSO2");
	     Checkbox  ckb6=new Checkbox("PSO3");
	     Checkbox  ckb7=new Checkbox("PSO4");
	     Checkbox  ckb8=new Checkbox("APSO1");
	     Checkbox  ckb9=new Checkbox("APSO2");
	     Checkbox  ckb10=new Checkbox("ALPSO");
	     Checkbox  ckb11=new Checkbox("LRPSO");
	     Checkbox  ckb12=new Checkbox("LR");
	     Checkbox  ckb13=new Checkbox("LR_and_PSO2");
	     Checkbox  ckb14=new Checkbox("LR_and_PSO1");
	     Checkbox  ckb15=new Checkbox("CCPSO2");
	     Checkbox  ckb16=new Checkbox("PSO_LS");
	     Checkbox  ckb17=new Checkbox("CPLEX_LP");
	     Checkbox  ckb18=new Checkbox("TS_DA");
	     Checkbox  ckb19=new Checkbox("DE_DA");
	     Checkbox  ckb20=new Checkbox("DE_DA_strategy1");
	     Checkbox  ckb21=new Checkbox("DE_DA_strategy2");
	     Checkbox  ckb22=new Checkbox("DE_DA_strategy3");
	     Checkbox  ckb23=new Checkbox("DE_DA_strategy4");
	     Checkbox  ckb24=new Checkbox("DE_DA_strategy5");
	     Checkbox  ckb25=new Checkbox("DE_DA_strategy6");
	     Checkbox  ckb26=new Checkbox("PSO_TS_DA");
	     public  static String path1;
	     public static String method;
	   X_Select_Algorithm_Type_to_Solve_the_Problem(){
		   CheckboxGroup grp=new CheckboxGroup(); 
	    	 
	    	frm.setSize(560,520); // 設定視窗的大小為 200*150
	    	frm.setLocation(400,50); // 設定視窗位置為(100,50)
		      frm.setTitle("X_Select_Algorithm_Type_to_Solve_the_Problem");
	    	  frm.setLayout(null);
	    	 
	    	  ckb1.setBounds(40,40,140,40);
	          ckb2.setBounds(40,80,140,40);
	          ckb3.setBounds(40,120,140,40);
	          ckb4.setBounds(40,160,140,40);
	          ckb5.setBounds(40,200,140,40);
	          ckb6.setBounds(40,240,140,40);
	          ckb7.setBounds(40,280,140,40);
	          ckb8.setBounds(200,80,140,40);
	          ckb9.setBounds(200,120,140,40);
	          ckb10.setBounds(200,160,140,40);
	          ckb11.setBounds(200,200,140,40);
	          ckb12.setBounds(200,240,140,40);
	          ckb13.setBounds(200,280,140,40);
	          ckb14.setBounds(200,320,140,40);
	          ckb15.setBounds(200,360,140,40);
	          ckb16.setBounds(40,320,140,40);
	          ckb17.setBounds(200,40,140,40);
	          ckb18.setBounds(200,80,140,40);
	          ckb19.setBounds(200,120,140,40);
	          ckb20.setBounds(360,40,140,40);
	          ckb21.setBounds(360,80,140,40);
	          ckb22.setBounds(360,120,140,40);
	          ckb23.setBounds(360,160,140,40);
	          ckb24.setBounds(360,200,140,40);
	          ckb25.setBounds(360,240,140,40);
	          ckb26.setBounds(40,320,140,40);
	          ckb1.setCheckboxGroup(grp);          
	          ckb2.setCheckboxGroup(grp);           
	          ckb3.setCheckboxGroup(grp);
	          ckb4.setCheckboxGroup(grp);
	          ckb5.setCheckboxGroup(grp);
	          ckb6.setCheckboxGroup(grp);
	          ckb7.setCheckboxGroup(grp);
	          ckb8.setCheckboxGroup(grp);
	          ckb9.setCheckboxGroup(grp);
	          ckb10.setCheckboxGroup(grp);
	          ckb11.setCheckboxGroup(grp);
	          ckb12.setCheckboxGroup(grp);
	          ckb13.setCheckboxGroup(grp);
	          ckb14.setCheckboxGroup(grp);
	          ckb15.setCheckboxGroup(grp);
	          ckb16.setCheckboxGroup(grp);
	          ckb17.setCheckboxGroup(grp);
	          ckb18.setCheckboxGroup(grp);
	          ckb19.setCheckboxGroup(grp);
	          ckb20.setCheckboxGroup(grp);
	          ckb21.setCheckboxGroup(grp);
	          ckb22.setCheckboxGroup(grp);
	          ckb23.setCheckboxGroup(grp);
	          ckb24.setCheckboxGroup(grp);
	          ckb25.setCheckboxGroup(grp);
	          ckb26.setCheckboxGroup(grp);
	          frm.add(ckb1);
	          frm.add(ckb2);
	          frm.add(ckb3);
	          frm.add(ckb4);
	          frm.add(ckb5);
	          frm.add(ckb6);
	          frm.add(ckb7);
	          frm.add(ckb8);
	          frm.add(ckb9);
	          frm.add(ckb10);
	          frm.add(ckb11);
	          frm.add(ckb12);
	          frm.add(ckb13);
	          frm.add(ckb14);
	          frm.add(ckb15);
	          frm.add(ckb16);
	          frm.add(ckb17);
	          frm.add(ckb18);
	          frm.add(ckb19);
	          frm.add(ckb20);
	          frm.add(ckb21);
	          frm.add(ckb22);
	          frm.add(ckb23);
	          frm.add(ckb24);
	          frm.add(ckb25);
	          frm.add(ckb26);
	          if(GUI.main.getmethod()==2){
	        	  frm.remove(ckb1);
	        	  frm.remove(ckb2);
	        	  frm.remove(ckb3);
	        	  frm.remove(ckb16);
	        	  frm.remove(ckb17);
	        	  frm.remove(ckb18);
	        	  frm.remove(ckb19);
	        	  frm.remove(ckb20);
	        	  frm.remove(ckb21);
	        	  frm.remove(ckb22);
	        	  frm.remove(ckb23);
	        	  frm.remove(ckb24);
	        	  frm.remove(ckb25);
	        	  frm.remove(ckb26);
	          }
	          if(GUI.main.getmethod()==1){
	        	  frm.remove(ckb17);
	        	  frm.remove(ckb18);
	        	  frm.remove(ckb19);
	        	  frm.remove(ckb20);
	        	  frm.remove(ckb21);
	        	  frm.remove(ckb22);
	        	  frm.remove(ckb23);
	        	  frm.remove(ckb24);
	        	  frm.remove(ckb25);
	        	  frm.remove(ckb26);
	          }
	          if(GUI.main.getmethod()==4){
	        	 
	        	  frm.remove(ckb6);
	        	  frm.remove(ckb7);
	        	  frm.remove(ckb8);
	        	  frm.remove(ckb9);
	        	  frm.remove(ckb16);
	          }
	    	 btn1.setBounds(40,420,80,40);
		      btn1.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
		      
		      btn2.setBounds(170,420,80,40);
		      btn2.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
	    	
		      frm.add(btn1);
		      btn1.addActionListener(this); 
		      frm.add(btn2);
		      btn2.addActionListener(this); 
		
	    	frm.setVisible(true); // 設定視窗為可見
	   }
    public static void main() 
    { 
    	new X_Select_Algorithm_Type_to_Solve_the_Problem();
    	  
    }
    
    
    public void actionPerformed(ActionEvent e)   
	   {
    	  JButton btn=(JButton) e.getSource();  
    	
	 	 if(ckb1.getState()==true && btn==btn1 )  
    	 {
    		 System.out.println("CPLEX");
    		 Algorithm=1;
    		 path1="\\CPLEX\\";
    		 method="CPLEX";
    	 }	 
    	if(ckb2.getState()==true && btn==btn1 )  
    	{
    		 System.out.println("GA1");
    		 Algorithm=2;
    		 path1="\\GA1\\";
    		 method="GA1";
    	}		 
    	if(ckb3.getState()==true && btn==btn1 )  
    	{
    		 System.out.println("GA2");
    		 Algorithm=3;
    		 path1="\\GA2\\";
    		 method="GA2";
    	}		 
    	if(ckb4.getState()==true && btn==btn1 )  
    	{
    		 System.out.println("PSO1");
    		 Algorithm=4;
    		 path1="\\PSO1\\";
    		 method="PSO1";
    	}
    	
    	if(ckb5.getState()==true && btn==btn1 )  
    	{
    		 System.out.println("PSO2");
    		 Algorithm=5;
    		 path1="\\PSO2\\";
    		 method="PSO2";
    	}
    	if(ckb6.getState()==true && btn==btn1 )  
    	{
    		 System.out.println("PSO3");
    		 Algorithm=6;
    		 path1="\\PSO3\\";
    		 method="PSO3";
    	}
    	if(ckb7.getState()==true && btn==btn1 )  
    	{
    		 System.out.println("PSO4");
    		 Algorithm=7;
    		 path1="\\PSO4\\";
    		 method="PSO4";
    	}
    	if(ckb8.getState()==true && btn==btn1 )  
    	{
    		 System.out.println("APSO1");
    		 Algorithm=8;
    		 path1="\\APSO1\\";
    		 method="APSO1";
    	}
    	if(ckb9.getState()==true && btn==btn1 )  
    	{
    		 System.out.println("APSO2");
    		 Algorithm=9;
    		 path1="\\APSO2\\";
    		 method="APSO2";
    	}
    	if(ckb10.getState()==true && btn==btn1 )  
    	{
    		 System.out.println("ALPSO");
    		 Algorithm=10;
    		 path1="\\ALPSO\\";
    		 method="ALPSO";
    	}
    	
    	if(ckb11.getState()==true && btn==btn1 )  
    	{
    		 System.out.println("LRPSO");
    		 Algorithm=11;
    		 path1="\\LRPSO\\";
    		 method="LRPSO";
    	}
    	if(ckb12.getState()==true && btn==btn1 )  
    	{
    		 System.out.println("LR");
    		 Algorithm=12;
    		 path1="\\LR\\";
    		 method="LR";
    	}
    	
    	if(ckb13.getState()==true && btn==btn1 )  
    	{
    		 System.out.println("LR+PSO2");
    		 Algorithm=13;
    		 path1="\\LR_and_PSO2\\";
    		 method="LR_and_PSO2";
    	}
    	if(ckb14.getState()==true && btn==btn1 )  
    	{
    		 System.out.println("LR+PSO1");
    		 Algorithm=14;
    		 path1="\\LR_and_PSO1\\";
    		 method="LR_and_PSO1";
    	}
     	if(ckb15.getState()==true && btn==btn1 )  
    	{
    		 System.out.println("CCPSO2");
    		 Algorithm=15;
    		 path1="\\CCPSO2\\";
    		 method="CCPSO2";
    	}
     	if(ckb16.getState()==true && btn==btn1 )  
    	{
    		 System.out.println("PSO_LS");
    		 Algorithm=16;
    		 path1="\\PSO_LS\\";
    		 method="PSO_LS";
    	}
     	if(ckb17.getState()==true && btn==btn1 )  
    	{
    		 System.out.println("CPLEX_LP");
    		 Algorithm=17;
    		 path1="\\CPLEX_LP\\";
    		 method="CPLEX_LP";
    	}
     	
     	if(ckb18.getState()==true && btn==btn1 )  
    	{
    		 System.out.println("TS_DA");
    		 Algorithm=18;
    		 path1="\\TS_DA\\";
    		 method="TS_DA";
    	}
     	if(ckb19.getState()==true && btn==btn1 )  
    	{
    		 System.out.println("DE_DA");
    		 Algorithm=19;
    		 path1="\\DE_DA\\";
    		 method="DE_DA";
    	}
     	
    	if(ckb20.getState()==true && btn==btn1 )  
    	{
    		 System.out.println("DE_DA_strategy1");
    		 Algorithm=20;
    		 path1="\\DE_DA_strategy1\\";
    		 method="DE_DA_strategy1";
    	}
    	
    	if(ckb21.getState()==true && btn==btn1 )  
    	{
    		 System.out.println("DE_DA_strategy2");
    		 Algorithm=21;
    		 path1="\\DE_DA_strategy2\\";
    		 method="DE_DA_strategy2";
    	}
    	
    	if(ckb22.getState()==true && btn==btn1 )  
    	{
    		 System.out.println("DE_DA_strategy3");
    		 Algorithm=22;
    		 path1="\\DE_DA_strategy3\\";
    		 method="DE_DA_strategy3";
    	}
    	
    	if(ckb23.getState()==true && btn==btn1 )  
    	{
    		 System.out.println("DE_DA_strategy4");
    		 Algorithm=23;
    		 path1="\\DE_DA_strategy4\\";
    		 method="DE_DA_strategy4";
    	}
    	
    	if(ckb24.getState()==true && btn==btn1 )  
    	{
    		 System.out.println("DE_DA_strategy5");
    		 Algorithm=24;
    		 path1="\\DE_DA_strategy5\\";
    		 method="DE_DA_strategy5";
    	}
    	
    	if(ckb25.getState()==true && btn==btn1 )  
    	{
    		 System.out.println("DE_DA_strategy6");
    		 Algorithm=25;
    		 path1="\\DE_DA_strategy6\\";
    		 method="DE_DA_strategy6";
    	}
    	
      	if(ckb26.getState()==true && btn==btn1 )  
    	{
    		 System.out.println("PSO_TS_DA");
    		 Algorithm=26;
    		 path1="\\PSO_TS_DA\\";
    		 method="PSO_TS_DA";
    	}
	    	  frm.setVisible(false);
	   }
    
    public static String path(){
    	return path1;
    }
    public static String method(){
    	return method;
    }
    
}
