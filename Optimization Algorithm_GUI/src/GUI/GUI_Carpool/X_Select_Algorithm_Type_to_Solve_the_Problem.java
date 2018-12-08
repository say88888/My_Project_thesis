package GUI.GUI_Carpool;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class X_Select_Algorithm_Type_to_Solve_the_Problem  extends Carpool   implements ActionListener{
	
	 static JFrame frame = new JFrame("TabbedPaneFrame");
	 
     static Checkbox ckb1=new Checkbox("CPLEX");
     static Checkbox ckb2=new Checkbox("GA1");
     static Checkbox ckb3=new Checkbox("GA2");
     static Checkbox ckb4=new Checkbox("PSO1");
     static Checkbox ckb5=new Checkbox("PSO2");
     static Checkbox  ckb6=new Checkbox("PSO3");
     static Checkbox  ckb7=new Checkbox("PSO4");
     static Checkbox  ckb8=new Checkbox("APSO1");
     static Checkbox  ckb9=new Checkbox("APSO2");
     static Checkbox  ckb10=new Checkbox("ALPSO");
     static Checkbox  ckb11=new Checkbox("LRPSO");
     static Checkbox  ckb12=new Checkbox("LR");
     static Checkbox  ckb13=new Checkbox("LR_and_PSO2");
     static Checkbox  ckb14=new Checkbox("LR_and_PSO1");
     static Checkbox  ckb15=new Checkbox("CCPSO2");
     static Checkbox  ckb16=new Checkbox("PSO_LS");
   
     static  Checkbox  ckb28=new Checkbox("PSO1_P");
     static Checkbox  ckb29=new Checkbox("PSO2_P");
     static Checkbox  ckb30=new Checkbox("APSO1_P");
     static Checkbox  ckb31=new Checkbox("APSO2_P");
     static Checkbox  ckb32=new Checkbox("ALPSO_P");
     static Checkbox  ckb33=new Checkbox("LRPSO_P");
     static Checkbox  ckb34=new Checkbox("LR_and_PSO2_P");
     static Checkbox  ckb35=new Checkbox("LR_and_PSO1_P");
     static Checkbox  ckb36=new Checkbox("CCPSO2_P");
     
     static Checkbox  ckb19=new Checkbox("DE_Carpool");
     static Checkbox  ckb20=new Checkbox("DE_Carpool_strategy1");
     static Checkbox  ckb21=new Checkbox("DE_Carpool_strategy2");
     static Checkbox  ckb22=new Checkbox("DE_Carpool_strategy3");
     static Checkbox  ckb23=new Checkbox("DE_Carpool_strategy4");
     static Checkbox  ckb24=new Checkbox("DE_Carpool_strategy5");
     static Checkbox  ckb25=new Checkbox("DE_Carpool_strategy6");
     
     static Checkbox  ckb42=new Checkbox("FA_PSO");
     static Checkbox  ckb43=new Checkbox("FA");
     static Checkbox  ckb52=new Checkbox("SaNSDE");
     static Checkbox  ckb53=new Checkbox("DECC");
     
     static Checkbox  ckb44=new Checkbox("DE_Carpool_Real");
     static Checkbox  ckb45=new Checkbox("DE_Carpool_strategy1_Real");
     static  Checkbox ckb46=new Checkbox("DE_Carpool_strategy2_Real");
     static Checkbox  ckb47=new Checkbox("DE_Carpool_strategy3_Real");
     static Checkbox  ckb48=new Checkbox("DE_Carpool_strategy4_Real");
     static Checkbox  ckb49=new Checkbox("DE_Carpool_strategy5_Real");
     static Checkbox  ckb50=new Checkbox("DE_Carpool_strategy6_Real");
     static Checkbox  ckb51=new Checkbox("NSDE_Carpool");
	 
     static Checkbox  ckb54=new Checkbox("DE_Carpool_Real_POP");
     static Checkbox  ckb55=new Checkbox("DE_Carpool_strategy1_Real_POP");
     static  Checkbox ckb56=new Checkbox("DE_Carpool_strategy2_Real_POP");
     static Checkbox  ckb57=new Checkbox("DE_Carpool_strategy3_Real_POP");
     static Checkbox  ckb58=new Checkbox("DE_Carpool_strategy4_Real_POP");
     static Checkbox  ckb59=new Checkbox("DE_Carpool_strategy5_Real_POP");
     static Checkbox  ckb60=new Checkbox("DE_Carpool_strategy6_Real_POP");
     static Checkbox  ckb61=new Checkbox("NSDE_Carpool_POP");
     static Checkbox  ckb62=new Checkbox("SaNSDE_POP");
     static Checkbox  ckb63=new Checkbox("DECC_POP");
     
     static Checkbox  ckb64=new Checkbox("DE_Carpool_Real_POP_NEW");
     static Checkbox  ckb65=new Checkbox("DE_Carpool_strategy1_Real_POP_NEW");
     static Checkbox  ckb66=new Checkbox("DE_Carpool_strategy2_Real_POP_NEW");
     static Checkbox  ckb67=new Checkbox("DE_Carpool_strategy3_Real_POP_NEW");
     static Checkbox  ckb68=new Checkbox("DE_Carpool_strategy4_Real_POP_NEW");
     static Checkbox  ckb69=new Checkbox("DE_Carpool_strategy5_Real_POP_NEW");
     static  Checkbox  ckb70=new Checkbox("DE_Carpool_strategy6_Real_POP_NEW");
     static  Checkbox  ckb71=new Checkbox("NSDE_POP_NEW");
     static  Checkbox  ckb72=new Checkbox("SaNSDE_POP_NEW");
     static  Checkbox  ckb73=new Checkbox("DECC_POP_NEW");
     
     static  Checkbox  ckb74=new Checkbox("PSO_LS_WaitingTime");
     static  Checkbox  ckb75=new Checkbox("PSO_LS_SetBased");
     
     static  Checkbox  ckb76=new Checkbox("DMS-L-PSO");
     static  Checkbox  ckb77=new Checkbox("DMSDL-PSO");
     static  Checkbox  ckb78=new Checkbox("ALPSO2_NEW");
     static  Checkbox  ckb79=new Checkbox("ALPSO2_NEW_PrematureConvegence1");
    
     static  Checkbox  ckb80=new Checkbox("NLPSO2");
     
     static  Checkbox  ckb81=new Checkbox("DynDE");
     static  Checkbox  ckb82=new Checkbox("DynDE_POP");
     
     static  Checkbox  ckb83=new Checkbox("CLPSO2");
     static  Checkbox  ckb84=new Checkbox("CC-CLPSO2");
     
     static  Checkbox  ckb85=new Checkbox("L-SHADE");
     static  Checkbox  ckb86=new Checkbox("L_SHADE_CCPSO2");
     
     static  Checkbox  ckb87=new Checkbox("DE_Real_AB_NNH");
     static  Checkbox  ckb88=new Checkbox("DE_Real_strategy1_AB_NNH");
     static  Checkbox  ckb89=new Checkbox("DE_Real_strategy2_AB_NNH");
     static  Checkbox  ckb90=new Checkbox("DE_Real_strategy3_AB_NNH");
     static  Checkbox  ckb91=new Checkbox("DE_Real_strategy4_AB_NNH");
     static  Checkbox  ckb92=new Checkbox("DE_Real_strategy5_AB_NNH");
     static  Checkbox  ckb93=new Checkbox("DE_Real_strategy6_AB_NNH");
     
     static  Checkbox  ckb94=new Checkbox("DE_Real_AB_2Si_ApproachI");
     static  Checkbox  ckb95=new Checkbox("DE_Real_AB_2Si_ApproachII");
     
     static  Checkbox  ckb96=new Checkbox("CCPSO2_AB_NNH");
     static  Checkbox  ckb97=new Checkbox("CCPSO2_AB_2Si_ApproachI");
     static  Checkbox  ckb98=new Checkbox("CCPSO2_AB_2Si_ApproachII");
     
     static  Checkbox  ckb99=new Checkbox("PSO2_AB_NNH");
     static  Checkbox  ckb100=new Checkbox("PSO2_AB_2Si_ApproachI");
     static  Checkbox  ckb101=new Checkbox("PSO2_AB_2Si_ApproachII");
     
     static  Checkbox  ckb102=new Checkbox("CC-CLPSO2_AB_NNH");
     static  Checkbox  ckb103=new Checkbox("CC-CLPSO2_AB_2Si_ApproachI");
     static  Checkbox  ckb104=new Checkbox("CC-CLPSO2_AB_2Si_ApproachII");
     
     static  Checkbox  ckb105=new Checkbox("DMSDL-PSO_AB_NNH");
     static  Checkbox  ckb106=new Checkbox("DMSDL-PSO_AB_2Si_ApproachI");
     static  Checkbox  ckb107=new Checkbox("DMSDL-PSO_AB_2Si_ApproachII");
     
     static  Checkbox  ckb108=new Checkbox("ALPSO2_NEW_PrematureConvegence1_AB_NNH");
     static  Checkbox  ckb109=new Checkbox("ALPSO2_NEW_PrematureConvegence1_AB_2Si_ApproachI");
     static  Checkbox  ckb110=new Checkbox("ALPSO2_NEW_PrematureConvegence1_AB_2Si_ApproachII");
     
     static  Checkbox  ckb111=new Checkbox("NSDE_AB_NNH");
     static  Checkbox  ckb112=new Checkbox("NSDE_AB_2Si_ApproachI");
     static  Checkbox  ckb113=new Checkbox("NSDE_AB_2Si_ApproachII");
     
     static  Checkbox  ckb114=new Checkbox("SaNSDE_AB_NNH");
     static  Checkbox  ckb115=new Checkbox("SaNSDE_AB_2Si_ApproachI");
     static  Checkbox  ckb116=new Checkbox("SaNSDE_AB_2Si_ApproachII");
     
     static  Checkbox  ckb117=new Checkbox("DynDE_AB_NNH");
     static  Checkbox  ckb118=new Checkbox("DynDE_AB_2Si_ApproachI");
     static  Checkbox  ckb119=new Checkbox("DynDE_AB_2Si_ApproachII");
     
     static  Checkbox  ckb120=new Checkbox("FA_AB_NNH");
     static  Checkbox  ckb121=new Checkbox("FA_AB_2Si_ApproachI");
     static  Checkbox  ckb122=new Checkbox("FA_AB_2Si_ApproachII");
     
     static  Checkbox  ckb123=new Checkbox("FA_PSO_AB_NNH");
     static  Checkbox  ckb124=new Checkbox("FA_PSO_AB_2Si_ApproachI");
     static  Checkbox  ckb125=new Checkbox("FA_PSO_AB_2Si_ApproachII");
     static  Checkbox  ckb999=new Checkbox("Run_multi_Algorithm"); 
    
	static JButton btn1=new JButton("Sure");
	static JButton btn2=new JButton("Exit");	
	static  CheckboxGroup grp=new CheckboxGroup();
	
    public static String path1;
    public static String method;
    public static boolean Advance_bid;
    
    public static int Set_Parameter=1;
    
    public X_Select_Algorithm_Type_to_Solve_the_Problem() {
        
        initUI();
    }
    
    private void initUI() {
  	 
  	  
         frame.setSize(950, 600);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
         frame.setVisible(true);
          
        JTabbedPane tbp = new JTabbedPane();
        
        tbp.addTab("CPLEX",createPanel_CPLEX("First panel"));
        tbp.addTab("GA", createPane2_GA("Second panel"));
        tbp.addTab("PSO_and_LR", createPanel3_PSO_and_LR("Third panel"));
        tbp.addTab("DE", createPanel4_DE("Four panel"));
        tbp.addTab("FA", createPanel5_FA("Five panel"));
        tbp.addTab("Run_multi_Algorithm", createPanel6("Six panel"));
        tbp.addTab("AB_DE_Real", createPanel7("Seven panel"));
        tbp.addTab("AB_PSO", createPanel8("eight panel"));
        setTitle("JTabbedPane");

        createLayout(tbp);
        
        btn1.setBounds(140,480,80,40);
        btn1.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
        btn2.setBounds(280,480,80,40);
        btn2.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
        frame.add(btn1);
        btn1.addActionListener(this); 
        frame.add(btn2);
        btn2.addActionListener(this); 
        
       frame.getContentPane().add(tbp);
    }
    private JPanel createPanel_CPLEX(String text) {
  	 
  	   ckb1.setCheckboxGroup(grp);          
  	   ckb1.setBounds(40,20,140,40);
     
      JPanel panel = new JPanel();

      panel.setLayout(null);
      panel.add(ckb1);
      
      return panel;
  }
    
    private JPanel createPane2_GA(String text) {
   
   	   ckb2.setCheckboxGroup(grp);          
   	   ckb3.setCheckboxGroup(grp);    
   	   ckb2.setBounds(40,20,140,40);
   	   ckb3.setBounds(40,60,140,40);
      
       JPanel panel = new JPanel();

       panel.setLayout(null);
       panel.add(ckb2);
       panel.add(ckb3);
       
       return panel;
   }
    
    private JPanel createPanel3_PSO_and_LR(String text) {
 	 
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
 	   ckb28.setCheckboxGroup(grp);
	   ckb29.setCheckboxGroup(grp);
	   ckb30.setCheckboxGroup(grp);          
	   ckb31.setCheckboxGroup(grp);      
	   ckb32.setCheckboxGroup(grp);          
	   ckb33.setCheckboxGroup(grp);      
	   ckb34.setCheckboxGroup(grp);
	   ckb35.setCheckboxGroup(grp);      
	   ckb36.setCheckboxGroup(grp);
	   ckb74.setCheckboxGroup(grp);
	   ckb75.setCheckboxGroup(grp);
	   ckb76.setCheckboxGroup(grp);
	   ckb77.setCheckboxGroup(grp);
	   ckb78.setCheckboxGroup(grp);
	   ckb79.setCheckboxGroup(grp);
	   ckb80.setCheckboxGroup(grp);
	   ckb83.setCheckboxGroup(grp);
	   ckb84.setCheckboxGroup(grp);
	   ckb86.setCheckboxGroup(grp);
 	  ckb4.setBounds(40,20,100,40);
      ckb5.setBounds(40,60,100,40);
      ckb6.setBounds(40,100,100,40);
      ckb7.setBounds(40,140,100,40);
      ckb8.setBounds(40,180,100,40);
      ckb9.setBounds(40,220,100,40);
      ckb10.setBounds(40,260,100,40);
      ckb11.setBounds(40,300,100,40);
      ckb78.setBounds(40,340,100,40);
      ckb79.setBounds(40,380,250,40);
      ckb12.setBounds(140,20,100,40);
      ckb13.setBounds(140,60,100,40);
      ckb14.setBounds(140,100,100,40);
      ckb15.setBounds(140,140,100,40);
      ckb16.setBounds(140,180,100,40);
      ckb74.setBounds(140,220,100,40);
      ckb75.setBounds(140,260,100,40);
      ckb28.setBounds(260,20,100,40);
      ckb29.setBounds(260,60,100,40);
      ckb30.setBounds(260,180,100,40);
      ckb31.setBounds(260,220,100,40);
      ckb32.setBounds(260,260,100,40);
      ckb33.setBounds(260,300,100,40);
      ckb34.setBounds(360,60,140,40);
      ckb35.setBounds(360,100,140,40);
      ckb36.setBounds(360,140,180,40);
    
      ckb76.setBounds(500,20,100,40);
      ckb77.setBounds(500,60,100,40);
      ckb80.setBounds(500,100,100,40);
      ckb83.setBounds(500,180,100,40);
      ckb84.setBounds(500,220,100,40);
      ckb86.setBounds(500,260,140,40);
     JPanel panel = new JPanel();

     panel.setLayout(null);
     panel.add(ckb4);
     panel.add(ckb5);
     panel.add(ckb6);
     panel.add(ckb7);
     panel.add(ckb8);
     panel.add(ckb9);
     panel.add(ckb10);
     panel.add(ckb11);
     panel.add(ckb12);
     panel.add(ckb13);
     panel.add(ckb14);
     panel.add(ckb15);
     panel.add(ckb16);
     panel.add(ckb28);
     panel.add(ckb29);
     panel.add(ckb30);
     panel.add(ckb31);
     panel.add(ckb32);
     panel.add(ckb33);
     panel.add(ckb34);
     panel.add(ckb35);
     panel.add(ckb36);
     panel.add(ckb74);
     panel.add(ckb75);
     panel.add(ckb76);
     panel.add(ckb77);
     panel.add(ckb78);
     panel.add(ckb79);
     panel.add(ckb80);
     panel.add(ckb83);
     panel.add(ckb84);
     panel.add(ckb86);
     return panel;
 }
    private JPanel createPanel4_DE(String text) {
 	
 	   ckb19.setCheckboxGroup(grp);       
	   ckb20.setCheckboxGroup(grp);           
	   ckb21.setCheckboxGroup(grp);
 	   ckb22.setCheckboxGroup(grp);       
	   ckb23.setCheckboxGroup(grp);           
	   ckb24.setCheckboxGroup(grp);
 	   ckb25.setCheckboxGroup(grp);       
 	   ckb44.setCheckboxGroup(grp);          
	   ckb45.setCheckboxGroup(grp);      
	   ckb46.setCheckboxGroup(grp);          
	   ckb47.setCheckboxGroup(grp);      
	   ckb48.setCheckboxGroup(grp);
	   ckb49.setCheckboxGroup(grp);      
	   ckb50.setCheckboxGroup(grp);
	   ckb51.setCheckboxGroup(grp);
	   ckb52.setCheckboxGroup(grp);
	   ckb53.setCheckboxGroup(grp);
	   ckb54.setCheckboxGroup(grp);          
	   ckb55.setCheckboxGroup(grp);      
	   ckb56.setCheckboxGroup(grp);
	   ckb57.setCheckboxGroup(grp);      
	   ckb58.setCheckboxGroup(grp);
	   ckb59.setCheckboxGroup(grp);
	   ckb60.setCheckboxGroup(grp);
	   ckb61.setCheckboxGroup(grp);
	   ckb81.setCheckboxGroup(grp);
	   ckb82.setCheckboxGroup(grp);
	   ckb19.setBounds(40,20,140,40);
	   ckb20.setBounds(40,60,140,40);
	   ckb21.setBounds(40,100,140,40);
	   ckb22.setBounds(40,140,140,40);
	   ckb23.setBounds(40,180,140,40);
	   ckb24.setBounds(40,220,140,40);
	   ckb25.setBounds(40,260,140,40);
	   ckb81.setBounds(40,300,140,40);
	   ckb82.setBounds(40,340,140,40);
	   ckb44.setBounds(220,20,140,40);
	   ckb45.setBounds(220,60,140,40);
	   ckb46.setBounds(220,100,180,40);
	   ckb47.setBounds(220,140,180,40);
	   ckb48.setBounds(220,180,180,40);
	   ckb49.setBounds(220,220,180,40);
	   ckb50.setBounds(220,260,180,40);
	   ckb51.setBounds(220,300,180,40);
	   ckb52.setBounds(220,340,180,40);
	   ckb53.setBounds(220,380,180,40);
	   ckb54.setBounds(430,20,220,40);
	   ckb55.setBounds(430,60,220,40);
	   ckb56.setBounds(430,100,220,40);
	   ckb57.setBounds(430,140,220,40);
	   ckb58.setBounds(430,180,220,40);
	   ckb59.setBounds(430,220,220,40);
	   ckb60.setBounds(430,260,220,40);
	   ckb61.setBounds(430,300,220,40);
	   ckb62.setBounds(430,340,180,40);
	   ckb63.setBounds(430,380,180,40);
	   ckb64.setBounds(650,20,260,40);
	   ckb65.setBounds(650,60,260,40);
	   ckb66.setBounds(650,100,260,40);
	   ckb67.setBounds(650,140,260,40);
	   ckb68.setBounds(650,180,260,40);
	   ckb69.setBounds(650,220,260,40);
	   ckb70.setBounds(650,260,260,40);
	   ckb71.setBounds(650,300,260,40);
	   ckb72.setBounds(650,340,260,40);
	   ckb73.setBounds(650,380,260,40);
	   ckb62.setCheckboxGroup(grp);
	   ckb63.setCheckboxGroup(grp);
	   ckb64.setCheckboxGroup(grp);          
	   ckb65.setCheckboxGroup(grp);      
	   ckb66.setCheckboxGroup(grp);
	   ckb67.setCheckboxGroup(grp);      
	   ckb68.setCheckboxGroup(grp);
	   ckb69.setCheckboxGroup(grp);
	   ckb70.setCheckboxGroup(grp);
	   ckb71.setCheckboxGroup(grp);
	   ckb72.setCheckboxGroup(grp);
	   ckb73.setCheckboxGroup(grp);
	   
	   ckb85.setCheckboxGroup(grp);
	   ckb85.setBounds(650,420,260,40);
	   
     JPanel panel = new JPanel();
     panel.setLayout(null);
     panel.add(ckb19);
     panel.add(ckb20);
     panel.add(ckb21);
     panel.add(ckb22);
     panel.add(ckb23);
     panel.add(ckb24);
     panel.add(ckb25);
     panel.add(ckb44);
     panel.add(ckb45);
     panel.add(ckb46);
     panel.add(ckb47);
     panel.add(ckb48);
     panel.add(ckb49);
     panel.add(ckb50);
     panel.add(ckb51);
     panel.add(ckb52);
     panel.add(ckb53);
     panel.add(ckb54);
     panel.add(ckb55);
     panel.add(ckb56);
     panel.add(ckb57);
     panel.add(ckb58);
     panel.add(ckb59);
     panel.add(ckb60);
     panel.add(ckb61);
     panel.add(ckb62);
     panel.add(ckb63);
     panel.add(ckb64);
     panel.add(ckb65);
     panel.add(ckb66);
     panel.add(ckb67);
     panel.add(ckb68);
     panel.add(ckb69);
     panel.add(ckb70);
     panel.add(ckb71);
     panel.add(ckb72);
     panel.add(ckb73);
     panel.add(ckb81);
     panel.add(ckb82);
     panel.add(ckb85);
     return panel;
 }
    private JPanel createPanel5_FA(String text) {
  	  
  	  ckb42.setCheckboxGroup(grp);          
 	  ckb43.setCheckboxGroup(grp);           
  	  ckb42.setBounds(40,40,140,40);
      ckb43.setBounds(40,80,140,40);
      JPanel panel = new JPanel();
      panel.setLayout(null);
      panel.add(ckb42);
      panel.add(ckb43);
            
      return panel;
  }
    private JPanel createPanel6(String text) {
   	  
   	  ckb999.setCheckboxGroup(grp);              
   	  ckb999.setBounds(40,40,140,40);
       JPanel panel = new JPanel();
       panel.setLayout(null);
       panel.add(ckb999);
             
       return panel;
   }
    
    private JPanel createPanel7(String text) {
     	  
     	  ckb87.setCheckboxGroup(grp);              
     	  ckb87.setBounds(40,40,140,40);
     	  ckb88.setCheckboxGroup(grp);              
    	  ckb88.setBounds(40,80,200,40);
    	  ckb89.setCheckboxGroup(grp);              
    	  ckb89.setBounds(40,120,200,40);
    	  ckb90.setCheckboxGroup(grp);              
    	  ckb90.setBounds(40,160,200,40);
    	  ckb91.setCheckboxGroup(grp);              
    	  ckb91.setBounds(40,200,200,40);
    	  ckb92.setCheckboxGroup(grp);              
    	  ckb92.setBounds(40,240,200,40);
    	  ckb93.setCheckboxGroup(grp);              
    	  ckb93.setBounds(40,280,200,40);             
     	  ckb94.setCheckboxGroup(grp);              
     	  ckb94.setBounds(40,360,200,40);
     	  ckb95.setCheckboxGroup(grp);              
     	  ckb95.setBounds(40,400,200,40);
     	  ckb111.setCheckboxGroup(grp);              
    	  ckb111.setBounds(240,40,140,40);
    	  ckb112.setCheckboxGroup(grp);              
    	  ckb112.setBounds(240,80,200,40);
    	  ckb113.setCheckboxGroup(grp);              
    	  ckb113.setBounds(240,120,200,40);
    	  ckb114.setCheckboxGroup(grp);              
    	  ckb114.setBounds(240,160,140,40);
    	  ckb115.setCheckboxGroup(grp);              
    	  ckb115.setBounds(240,200,200,40);
    	  ckb116.setCheckboxGroup(grp);              
    	  ckb116.setBounds(240,240,200,40);
    	  ckb117.setCheckboxGroup(grp);              
    	  ckb117.setBounds(240,280,200,40);
    	  ckb118.setCheckboxGroup(grp);              
    	  ckb118.setBounds(240,320,200,40);
    	  ckb119.setCheckboxGroup(grp);              
    	  ckb119.setBounds(240,360,200,40);
    	
         JPanel panel = new JPanel();
         panel.setLayout(null);
         panel.add(ckb87);
         panel.add(ckb88);
         panel.add(ckb89);
         panel.add(ckb90);
         panel.add(ckb91);
         panel.add(ckb92);
         panel.add(ckb93);
         panel.add(ckb94);
         panel.add(ckb95);
        panel.add(ckb111);
         panel.add(ckb112);
         panel.add(ckb113);
         panel.add(ckb114);
         panel.add(ckb115);
         panel.add(ckb116);
         panel.add(ckb117);
         panel.add(ckb118);
         panel.add(ckb119);
       
         return panel;
     }
    
    private JPanel createPanel8(String text) {
     	  
      ckb99.setCheckboxGroup(grp);              
   	  ckb99.setBounds(40,40,200,40);
   	  ckb100.setCheckboxGroup(grp);              
   	  ckb100.setBounds(40,80,200,40);
   	  ckb101.setCheckboxGroup(grp);              
   	  ckb101.setBounds(40,120,200,40);
   	  ckb96.setCheckboxGroup(grp);              
  	  ckb96.setBounds(40,160,200,40);
  	  ckb97.setCheckboxGroup(grp);              
  	  ckb97.setBounds(40,200,200,40);
  	  ckb98.setCheckboxGroup(grp);              
  	  ckb98.setBounds(40,240,200,40);
  	  ckb102.setCheckboxGroup(grp);              
   	  ckb102.setBounds(40,280,200,40);
   	  ckb103.setCheckboxGroup(grp);              
   	  ckb103.setBounds(40,320,200,40);
   	  ckb104.setCheckboxGroup(grp);              
   	  ckb104.setBounds(40,360,200,40);
   	  ckb105.setCheckboxGroup(grp);              
  	  ckb105.setBounds(500,40,200,40);
  	  ckb106.setCheckboxGroup(grp);              
  	  ckb106.setBounds(500,80,200,40);
  	  ckb107.setCheckboxGroup(grp);              
  	  ckb107.setBounds(500,120,200,40);
  	  ckb108.setCheckboxGroup(grp);              
  	  ckb108.setBounds(500,160,300,40);
  	  ckb109.setCheckboxGroup(grp);              
  	  ckb109.setBounds(500,200,400,40);
  	  ckb110.setCheckboxGroup(grp);              
  	  ckb110.setBounds(500,240,400,40);
  	  ckb120.setCheckboxGroup(grp);              
	  ckb120.setBounds(270,40,140,40);
	  ckb121.setCheckboxGroup(grp);              
	  ckb121.setBounds(270,80,200,40);
	  ckb122.setCheckboxGroup(grp);              
	  ckb122.setBounds(270,120,200,40);
	  ckb123.setCheckboxGroup(grp);              
	  ckb123.setBounds(270,160,140,40);
	  ckb124.setCheckboxGroup(grp);              
	  ckb124.setBounds(270,200,200,40);
	  ckb125.setCheckboxGroup(grp);              
	  ckb125.setBounds(270,240,200,40);
         JPanel panel = new JPanel();
         panel.setLayout(null);
         panel.add(ckb96);
         panel.add(ckb97);
         panel.add(ckb98);
         panel.add(ckb99);
         panel.add(ckb100);
         panel.add(ckb101);
         panel.add(ckb102);
         panel.add(ckb103);
         panel.add(ckb104);
         panel.add(ckb105);
         panel.add(ckb106);
         panel.add(ckb107);
         panel.add(ckb108);
         panel.add(ckb109);
         panel.add(ckb110);
         panel.add(ckb120);
         panel.add(ckb121);
         panel.add(ckb122);
         panel.add(ckb123);
         panel.add(ckb124);
         panel.add(ckb125);
         return panel;
     }
    
    
    private void createLayout(JComponent... arg) {
        
        Container pane = getContentPane();
        GroupLayout gl = new GroupLayout(pane);
        pane.setLayout(gl);        
        
        gl.setAutoCreateContainerGaps(true);
        gl.setAutoCreateGaps(true);        

        gl.setHorizontalGroup(gl.createSequentialGroup()
                .addComponent(arg[0])
        );

        gl.setVerticalGroup(gl.createParallelGroup()
                .addComponent(arg[0])
        );

        pack();
    }    

    public static void main() {
    	frame = new JFrame("TabbedPaneFrame");
        EventQueue.invokeLater(() -> {
            X_Select_Algorithm_Type_to_Solve_the_Problem ex = new X_Select_Algorithm_Type_to_Solve_the_Problem();
            ex.setVisible(false);
        });
    }
    
    public void actionPerformed(ActionEvent e) 
    {
    	Set_Parameter=1;
    	
    JButton btn=(JButton) e.getSource();  
   	 if(ckb1.getState()==true && btn==btn1 )  
	 {
		 System.out.println("CPLEX");
		 Algorithm="CPLEX";
		 path1="\\CPLEX\\";
		 method="CPLEX";
		 Advance_bid=true;
	 }	 
	if(ckb2.getState()==true && btn==btn1 )  
	{
		 System.out.println("GA1");
		 Algorithm="GA1";
		 path1="\\GA1\\";
		 method="GA1";
		 Advance_bid=true;
	}		 
	if(ckb3.getState()==true && btn==btn1 )  
	{
		 System.out.println("GA2");
		 Algorithm="GA2";
		 path1="\\GA2\\";
		 method="GA2";
		 Advance_bid=true;
	}		 
	if(ckb4.getState()==true && btn==btn1 )  
	{
		 System.out.println("PSO1");
		 Algorithm="PSO1";
		 path1="\\PSO1\\";
		 method="PSO1";
		 Advance_bid=true;
	}
	
	if(ckb5.getState()==true && btn==btn1 )  
	{
		 System.out.println("PSO2");
		 Algorithm="PSO2";
		 path1="\\PSO2\\";
		 method="PSO2";
		 Advance_bid=true;
	}
	if(ckb6.getState()==true && btn==btn1 )  
	{
		 System.out.println("PSO3");
		 Algorithm="PSO3";
		 path1="\\PSO3\\";
		 method="PSO3";
		 Advance_bid=true;
	}
	if(ckb7.getState()==true && btn==btn1 )  
	{
		 System.out.println("PSO4");
		 Algorithm="PSO4";
		 path1="\\PSO4\\";
		 method="PSO4";
		 Advance_bid=true;
	}
	if(ckb8.getState()==true && btn==btn1 )  
	{
		 System.out.println("APSO1");
		 Algorithm="APSO1";
		 path1="\\APSO1\\";
		 method="APSO1";
		 Advance_bid=true;
	}
	if(ckb9.getState()==true && btn==btn1 )  
	{
		 System.out.println("APSO2");
		 Algorithm="APSO2";
		 path1="\\APSO2\\";
		 method="APSO2";
		 Advance_bid=true;
	}
	if(ckb10.getState()==true && btn==btn1 )  
	{
		 System.out.println("ALPSO");
		 Algorithm="ALPSO";
		 path1="\\ALPSO\\";
		 method="ALPSO";
		 Advance_bid=true;
	}
	
	if(ckb11.getState()==true && btn==btn1 )  
	{
		 System.out.println("LRPSO");
		 Algorithm="LRPSO";
		 path1="\\LRPSO\\";
		 method="LRPSO";
		 Advance_bid=true;
	}
	if(ckb12.getState()==true && btn==btn1 )  
	{
		 System.out.println("LR");
		 Algorithm="LR";
		 path1="\\LR\\";
		 method="LR";
		 Advance_bid=true;
	}
	
	if(ckb13.getState()==true && btn==btn1 )  
	{
		 System.out.println("LR+PSO2");
		 Algorithm="LR_and_PSO2";
		 path1="\\LR_and_PSO2\\";
		 method="LR_and_PSO2";
		 Advance_bid=true;
	}
	if(ckb14.getState()==true && btn==btn1 )  
	{
		 System.out.println("LR+PSO1");
		 Algorithm="LR_and_PSO1";
		 path1="\\LR_and_PSO1\\";
		 method="LR_and_PSO1";
		 Advance_bid=true;
	}
 	if(ckb15.getState()==true && btn==btn1 )  
	{
		 System.out.println("CCPSO2");
		 Algorithm="CCPSO2";
		 path1="\\CCPSO2\\";
		 method="CCPSO2";
		 Advance_bid=true;
	}
 	if(ckb16.getState()==true && btn==btn1 )  
	{
		 System.out.println("PSO_LS");
		 Algorithm="PSO_LS";
		 path1="\\PSO_LS\\";
		 method="PSO_LS";
		 Advance_bid=false;
	}
 	
	if(ckb28.getState()==true && btn==btn1 )  
	{
		 System.out.println("PSO1_P");
		 Algorithm="PSO1_P";
		 path1="\\PSO1_P\\";
		 method="PSO1_P";
		 Advance_bid=true;
	}
	
	if(ckb29.getState()==true && btn==btn1 )  
	{
		 System.out.println("PSO2_P");
		 Algorithm="PSO2_P";
		 path1="\\PSO2_P\\";
		 method="PSO2_P";
		 Advance_bid=true;
	}
	if(ckb30.getState()==true && btn==btn1 )  
	{
		 System.out.println("APSO1_P");
		 Algorithm="APSO1_P";
		 path1="\\APSO1_P\\";
		 method="APSO1_P";
		 Advance_bid=true;
	}
	
	if(ckb31.getState()==true && btn==btn1 )  
	{
		 System.out.println("APSO2_P");
		 Algorithm="APSO2_P";
		 path1="\\APSO2_P\\";
		 method="APSO2_P";
		 Advance_bid=true;
	}
	if(ckb32.getState()==true && btn==btn1 )  
	{
		 System.out.println("ALPSO_P");
		 Algorithm="ALPSO_P";
		 path1="\\ALPSO_P\\";
		 method="ALPSO_P";
		 Advance_bid=true;
	}
	
	if(ckb33.getState()==true && btn==btn1 )  
	{
		 System.out.println("LRPSO_P");
		 Algorithm="LRPSO_P";
		 path1="\\LRPSO_P\\";
		 method="LRPSO_P";
		 Advance_bid=true;
	}
	
	if(ckb34.getState()==true && btn==btn1 )  
	{
		 System.out.println("LR_and_PSO2_P");
		 Algorithm="LR_and_PSO2_P";
		 path1="\\LR_and_PSO2_P\\";
		 method="LR_and_PSO2_P";
		 Advance_bid=true;
	}
	
	if(ckb35.getState()==true && btn==btn1 )  
	{
		 System.out.println("LR_and_PSO1_P");
		 Algorithm="LR_and_PSO1_P";
		 path1="\\LR_and_PSO1_P\\";
		 method="LR_and_PSO1_P";
		 Advance_bid=true;
	}
	
  	if(ckb36.getState()==true && btn==btn1 )  
	{
		 System.out.println("CCPSO2_P");
		 Algorithm="CCPSO2_P";
		 path1="\\CCPSO2_P\\";
		 method="CCPSO2_P";
		 Advance_bid=true;
	}
  	
	if(ckb19.getState()==true && btn==btn1 )  
	{
		 System.out.println("DE_Carpool");
		 Algorithm="DE_Carpool";
		 path1="\\DE_Carpool\\";
		 method="DE_Carpool";
		 Advance_bid=true;
	}
 	
	if(ckb20.getState()==true && btn==btn1 )  
	{
		 System.out.println("DE_Carpool_strategy1");
		 Algorithm="DE_Carpool_strategy1";
		 path1="\\DE_Carpool_strategy1\\";
		 method="DE_Carpool_strategy1";
		 Advance_bid=true;
	}
	
	if(ckb21.getState()==true && btn==btn1 )  
	{
		 System.out.println("DE_Carpool_strategy2");
		 Algorithm="DE_Carpool_strategy2";
		 path1="\\DE_Carpool_strategy2\\";
		 method="DE_Carpool_strategy2";
		 Advance_bid=true;
	}
	
	if(ckb22.getState()==true && btn==btn1 )  
	{
		 System.out.println("DE_Carpool_strategy3");
		 Algorithm="DE_Carpool_strategy3";
		 path1="\\DE_Carpool_strategy3\\";
		 method="DE_Carpool_strategy3";
		 Advance_bid=true;
	}
	
	if(ckb23.getState()==true && btn==btn1 )  
	{
		 System.out.println("DE_Carpool_strategy4");
		 Algorithm="DE_Carpool_strategy4";
		 path1="\\DE_Carpool_strategy4\\";
		 method="DE_Carpool_strategy4";
		 Advance_bid=true;
	}
	
	if(ckb24.getState()==true && btn==btn1 )  
	{
		 System.out.println("DE_Carpool_strategy5");
		 Algorithm="DE_Carpool_strategy5";
		 path1="\\DE_Carpool_strategy5\\";
		 method="DE_Carpool_strategy5";
		 Advance_bid=true;
	}
	
	if(ckb25.getState()==true && btn==btn1 )  
	{
		 System.out.println("DE_Carpool_strategy6");
		 Algorithm="DE_Carpool_strategy6";
		 path1="\\DE_Carpool_strategy6\\";
		 method="DE_Carpool_strategy6";
		 Advance_bid=true;
	}
	if(ckb44.getState()==true && btn==btn1 )  
	{
		 System.out.println("DE_Carpool_Real");
		 Algorithm="DE_Carpool_Real";
		 path1="\\DE_Carpool_Real\\";
		 method="DE_Carpool_Real";
		 Advance_bid=true;
	}
 	
	if(ckb45.getState()==true && btn==btn1 )  
	{
		 System.out.println("DE_Carpool_strategy1_Real");
		 Algorithm="DE_Carpool_strategy1_Real";
		 path1="\\DE_Carpool_strategy1_Real\\";
		 method="DE_Carpool_strategy1_Real";
		 Advance_bid=true;
	}
	
	if(ckb46.getState()==true && btn==btn1 )  
	{
		 System.out.println("DE_Carpool_strategy2_Real");
		 Algorithm="DE_Carpool_strategy2_Real";
		 path1="\\DE_Carpool_strategy2_Real\\";
		 method="DE_Carpool_strategy2_Real";
		 Advance_bid=true;
	}
	
	if(ckb47.getState()==true && btn==btn1 )  
	{
		 System.out.println("DE_Carpool_strategy3_Real");
		 Algorithm="DE_Carpool_strategy3_Real";
		 path1="\\DE_Carpool_strategy3_Real\\";
		 method="DE_Carpool_strategy3_Real";
		 Advance_bid=true;
	}
	
	if(ckb48.getState()==true && btn==btn1 )  
	{
		 System.out.println("DE_Carpool_strategy4_Real");
		 Algorithm="DE_Carpool_strategy4_Real";
		 path1="\\DE_Carpool_strategy4_Real\\";
		 method="DE_Carpool_strategy4_Real";
		 Advance_bid=true;
	}
	
	if(ckb49.getState()==true && btn==btn1 )  
	{
		 System.out.println("DE_Carpool_strategy5_Real");
		 Algorithm="DE_Carpool_strategy5_Real";
		 path1="\\DE_Carpool_strategy5_Real\\";
		 method="DE_Carpool_strategy5_Real";
		 Advance_bid=true;
	}
	
	if(ckb50.getState()==true && btn==btn1 )  
	{
		 System.out.println("DE_Carpool_strategy6_Real");
		 Algorithm="DE_Carpool_strategy6_Real";
		 path1="\\DE_Carpool_strategy6_Real\\";
		 method="DE_Carpool_strategy6_Real";
		 Advance_bid=true;
	}
	if(ckb51.getState()==true && btn==btn1 )  
	{
		 System.out.println("NSDE_Carpool");
		 Algorithm="NSDE_Carpool";
		 path1="\\NSDE_Carpool\\";
		 method="NSDE_Carpool";
		 Advance_bid=true;
	}
	
	if(ckb42.getState()==true && btn==btn1 )  
	{
		 System.out.println("FA_PSO");
		 Algorithm="FA_PSO";
		 path1="\\FA_PSO\\";
		 method="FA_PSO";
		 Advance_bid=true;
	}
  	if(ckb43.getState()==true && btn==btn1 )  
	{
		 System.out.println("FA");
		 Algorithm="FA";
		 path1="\\FA\\";
		 method="FA";
		 Advance_bid=true;
	}
  	
  	if(ckb52.getState()==true && btn==btn1 )  
	{
		 System.out.println("SaNSDE");
		 Algorithm="SaNSDE";
		 path1="\\SaNSDE\\";
		 method="SaNSDE";
		 Advance_bid=true;
	}
  	
  	if(ckb53.getState()==true && btn==btn1 )  
	{
		 System.out.println("DECC");
		 Algorithm="DECC";
		 path1="\\DECC\\";
		 method="DECC";
		 Advance_bid=true;
	}
	if(ckb54.getState()==true && btn==btn1 )  
 	{
 		 System.out.println("DE_Carpool_Real_POP");
 		 Algorithm="DE_Real_POP";
 		 path1="\\DE_Real_POP\\";
 		 method="DE_Real_POP";
 		 Advance_bid=true;
 	}
    	if(ckb55.getState()==true && btn==btn1 )  
 	{
 		 System.out.println("DE_Carpool_strategy1_Real_POP");
 		 Algorithm="DE_strategy1_Real_POP";
 		 path1="\\DE_strategy1_Real_POP\\";
 		 method="DE_strategy1_Real_POP";
 		 Advance_bid=true;
 	}
 	
 	if(ckb56.getState()==true && btn==btn1 )  
 	{
 		 System.out.println("DE_Carpool_strategy2_Real_POP");
 		 Algorithm="DE_strategy2_Real_POP";
 		 path1="\\DE_strategy2_Real_POP\\";
 		 method="DE_strategy2_Real_POP";
 		 Advance_bid=true;
 	}
 	
 	if(ckb57.getState()==true && btn==btn1 )  
 	{
 		 System.out.println("DE_Carpool_strategy3_Real_POP");
 		 Algorithm="DE_strategy3_Real_POP";
 		 path1="\\DE_strategy3_Real_POP\\";
 		 method="DE_strategy3_Real_POP";
 		 Advance_bid=true;
 	}
 	
 	if(ckb58.getState()==true && btn==btn1 )  
 	{
 		 System.out.println("DE_Carpool_strategy4_Real_POP");
 		 Algorithm="DE_strategy4_Real_POP";
 		 path1="\\DE_strategy4_Real_POP\\";
 		 method="DE_strategy4_Real_POP";
 		 Advance_bid=true;
 	}
 	
 	if(ckb59.getState()==true && btn==btn1 )  
 	{
 		 System.out.println("DE_Carpool_strategy5_Real_POP");
 		 Algorithm="DE_strategy5_Real_POP";
 		 path1="\\DE_strategy5_Real_POP\\";
 		 method="DE_strategy5_Real_POP";
 		 Advance_bid=true;
 	}
 	
 	if(ckb60.getState()==true && btn==btn1 )  
 	{
 		 System.out.println("DE_Carpool_strategy6_Real_POP");
 		 Algorithm="DE_strategy6_Real_POP";
 		 path1="\\DE_strategy6_Real_POP\\";
 		 method="DE_strategy6_Real_POP";
 		 Advance_bid=true;
 	}
 	if(ckb61.getState()==true && btn==btn1 )  
 	{
 		 System.out.println("NSDE_POP");
 		 Algorithm="NSDE_POP";
 		 path1="\\NSDE_POP\\";
 		 method="NSDE_POP";
 		 Advance_bid=true;
 	}
	if(ckb62.getState()==true && btn==btn1 )  
 	{
 		 System.out.println("SaNSDE_POP");
 		 Algorithm="SaNSDE_POP";
 		 path1="\\SaNSDE_POP\\";
 		 method="SaNSDE_POP";
 		 Advance_bid=true;
 	}
 	if(ckb63.getState()==true && btn==btn1 )  
 	{
 		 System.out.println("DECC_POP");
 		 Algorithm="DECC_POP";
 		 path1="\\DECC_POP\\";
 		 method="DECC_POP";
 		 Advance_bid=true;
 	}
 	if(ckb64.getState()==true && btn==btn1 )  
 	{
 		 System.out.println("DE_Carpool_Real_POP_NEW");
 		 Algorithm="DE_Real_POP_NEW";
 		 path1="\\DE_Real_POP_NEW\\";
 		 method="DE_Real_POP_NEW";
 		 Advance_bid=true;
 	}
    	if(ckb65.getState()==true && btn==btn1 )  
 	{
 		 System.out.println("DE_Carpool_strategy1_Real_POP_NEW");
 		 Algorithm="DE_strategy1_Real_POP_NEW";
 		 path1="\\DE_strategy1_Real_POP_NEW\\";
 		 method="DE_strategy1_Real_POP_NEW";
 		 Advance_bid=true;
 	}
 	
 	if(ckb66.getState()==true && btn==btn1 )  
 	{
 		 System.out.println("DE_Carpool_strategy2_Real_POP_NEW");
 		 Algorithm="DE_strategy2_Real_POP_NEW";
 		 path1="\\DE_strategy2_Real_POP_NEW\\";
 		 method="DE_strategy2_Real_POP_NEW";
 		 Advance_bid=true;
 	}
 	
 	if(ckb67.getState()==true && btn==btn1 )  
 	{
 		 System.out.println("DE_Carpool_strategy3_Real_POP_NEW");
 		 Algorithm="DE_strategy3_Real_POP_NEW";
 		 path1="\\DE_strategy3_Real_POP_NEW\\";
 		 method="DE_strategy3_Real_POP_NEW";
 		 Advance_bid=true;
 	}
 	
 	if(ckb68.getState()==true && btn==btn1 )  
 	{
 		 System.out.println("DE_Carpool_strategy4_Real_POP_NEW");
 		 Algorithm="DE_strategy4_Real_POP_NEW";
 		 path1="\\DE_strategy4_Real_POP_NEW\\";
 		 method="DE_strategy4_Real_POP_NEW";
 		 Advance_bid=true;
 	}
 	
 	if(ckb69.getState()==true && btn==btn1 )  
 	{
 		 System.out.println("DE_Carpool_strategy6_Real_POP_NEW");
 		 Algorithm="DE_strategy5_Real_POP_NEW";
 		 path1="\\DE_strategy5_Real_POP_NEW\\";
 		 method="DE_strategy5_Real_POP_NEW";
 		 Advance_bid=true;
 	}
 	
 	if(ckb70.getState()==true && btn==btn1 )  
 	{
 		 System.out.println("DE_Carpool_strategy6_Real_POP_NEW");
 		 Algorithm="DE_strategy6_Real_POP_NEW";
 		 path1="\\DE_strategy6_Real_POP_NEW\\";
 		 method="DE_strategy6_Real_POP_NEW";
 		 Advance_bid=true;
 	}
 	if(ckb71.getState()==true && btn==btn1 )  
 	{
 		 System.out.println("NSDE_POP_NEW");
 		 Algorithm="NSDE_POP_NEW";
 		 path1="\\NSDE_POP_NEW\\";
 		 method="NSDE_POP_NEW";
 		 Advance_bid=true;
 	}
 	if(ckb72.getState()==true && btn==btn1 )  
 	{
 		 System.out.println("SaNSDE_POP_NEW");
 		 Algorithm="SaNSDE_POP_NEW";
 		 path1="\\SaNSDE_POP_NEW\\";
 		 method="SaNSDE_POP_NEW";
 		 Advance_bid=true;
 	}
 	if(ckb73.getState()==true && btn==btn1 )  
 	{
 		 System.out.println("DECC_POP_NEW");
 		 Algorithm="DECC_POP_NEW";
 		 path1="\\DECC_POP_NEW\\";
 		 method="DECC_POP_NEW";
 		 Advance_bid=true;
 	}
 	if(ckb74.getState()==true && btn==btn1 )  
 	{
 		 System.out.println("PSO_LS_WaitingTime");
 		 Algorithm="PSO_LS_WaitingTime";
 		 path1="\\PSO_LS_WaitingTime\\";
 		 method="PSO_LS_WaitingTime";
 		 Advance_bid=false;
 	}
 	if(ckb75.getState()==true && btn==btn1 )  
 	{
 		 System.out.println("PSO_LS_SetBased");
 		 Algorithm="PSO_LS_SetBased";
 		 path1="\\PSO_LS_SetBased\\";
 		 method="PSO_LS_SetBased";
 		 Advance_bid=false;
 	}
 	if(ckb76.getState()==true && btn==btn1 )  
 	{
 		 System.out.println("DMS-L-PSO");
 		 Algorithm="DMS-L-PSO";
 		 path1="\\DMS-L-PSO\\";
 		 method="DMS-L-PSO";
 		 Advance_bid=true;
 	}
 	if(ckb77.getState()==true && btn==btn1 )  
 	{
 		 System.out.println("DMSDL-PSO");
 		 Algorithm="DMSDL-PSO";
 		 path1="\\DMSDL-PSO\\";
 		 method="DMSDL-PSO";
 		 Advance_bid=true;
 	}
 	if(ckb78.getState()==true && btn==btn1 )  
 	{
 		 System.out.println("ALPSO2_NEW");
 		 Algorithm="ALPSO2_NEW";
 		 path1="\\ALPSO2_NEW\\";
 		 method="ALPSO2_NEW";
 		 Advance_bid=true;
 	}
 	if(ckb79.getState()==true && btn==btn1 )  
 	{
 		 System.out.println("ALPSO2_NEW_PrematureConvegence1");
 		 Algorithm="ALPSO2_NEW_PrematureConvegence1";
 		 path1="\\ALPSO2_NEW_PrematureConvegence1\\";
 		 method="ALPSO2_NEW_PrematureConvegence1";
 		 Advance_bid=true;
 	}
	if(ckb80.getState()==true && btn==btn1 )  
 	{
 		 System.out.println("NLPSO2");
 		 Algorithm="NLPSO2";
 		 path1="\\NLPSO2\\";
 		 method="NLPSO2";
 		 Advance_bid=true;
 	}
	if(ckb81.getState()==true && btn==btn1 )  
 	{
 		 System.out.println("DynDE");
 		 Algorithm="DynDE";
 		 path1="\\DynDE\\";
 		 method="DynDE";
 		 Advance_bid=true;
 	}
	if(ckb82.getState()==true && btn==btn1 )  
 	{
 		 System.out.println("DynDE_POP");
 		 Algorithm="DynDE_POP";
 		 path1="\\DynDE_POP\\";
 		 method="DynDE_POP";
 		 Advance_bid=true;
 	}
	if(ckb83.getState()==true && btn==btn1 )  
 	{
 		 System.out.println("CLPSO2");
 		 Algorithm="CLPSO2";
 		 path1="\\CLPSO2\\";
 		 method="CLPSO2";
 		 Advance_bid=true;
 	}
	if(ckb84.getState()==true && btn==btn1 )  
 	{
 		 System.out.println("CC-CLPSO2");
 		 Algorithm="CC-CLPSO2";
 		 path1="\\CC-CLPSO2\\";
 		 method="CC-CLPSO2";
 		 Advance_bid=true;
 	}
	
	if(ckb85.getState()==true && btn==btn1 )  
 	{
 		 System.out.println("L-SHADE");
 		 Algorithm="L-SHADE";
 		 path1="\\L-SHADE\\";
 		 method="L-SHADE";
 		 Advance_bid=true;
 	}
	
	if(ckb86.getState()==true && btn==btn1 )  
 	{
 		 System.out.println("L_SHADE_CCPSO2");
 		 Algorithm="L_SHADE_CCPSO2";
 		 path1="\\L_SHADE_CCPSO2\\";
 		 method="L_SHADE_CCPSO2";
 		 Advance_bid=true;
 	}
	
	if(ckb87.getState()==true && btn==btn1 )  
 	{
 		 System.out.println("DE_Real_AB_NNH");
 		 Algorithm="DE_Real_AB_NNH";
 		 path1="\\DE_Real_AB_NNH\\";
 		 method="DE_Real_AB_NNH";
 		 Advance_bid=false;
 	}
	if(ckb88.getState()==true && btn==btn1 )  
 	{
 		 System.out.println("DE_Real_strategy1_AB_NNH");
 		 Algorithm="DE_Real_strategy1_AB_NNH";
 		 path1="\\DE_Real_strategy1_AB_NNH\\";
 		 method="DE_Real_strategy1_AB_NNH";
 		 Advance_bid=false;
 	}
	if(ckb89.getState()==true && btn==btn1 )  
 	{
 		 System.out.println("DE_Real_strategy2_AB_NNH");
 		 Algorithm="DE_Real_strategy2_AB_NNH";
 		 path1="\\DE_Real_strategy2_AB_NNH\\";
 		 method="DE_Real_strategy2_AB_NNH";
 		 Advance_bid=false;
 	}
	if(ckb90.getState()==true && btn==btn1 )  
 	{
 		 System.out.println("DE_Real_strategy3_AB_NNH");
 		 Algorithm="DE_Real_strategy3_AB_NNH";
 		 path1="\\DE_Real_strategy3_AB_NNH\\";
 		 method="DE_Real_strategy3_AB_NNH";
 		 Advance_bid=false;
 	}
	if(ckb91.getState()==true && btn==btn1 )  
 	{
 		 System.out.println("DE_Real_strategy4_AB_NNH");
 		 Algorithm="DE_Real_strategy4_AB_NNH";
 		 path1="\\DE_Real_strategy4_AB_NNH\\";
 		 method="DE_Real_strategy4_AB_NNH";
 		 Advance_bid=false;
 	}
	if(ckb92.getState()==true && btn==btn1 )  
 	{
 		 System.out.println("DE_Real_strategy5_AB_NNH");
 		 Algorithm="DE_Real_strategy5_AB_NNH";
 		 path1="\\DE_Real_strategy5_AB_NNH\\";
 		 method="DE_Real_strategy5_AB_NNH";
 		 Advance_bid=false;
 	}
	if(ckb93.getState()==true && btn==btn1 )  
 	{
 		 System.out.println("DE_Real_strategy6_AB_NNH");
 		 Algorithm="DE_Real_strategy6_AB_NNH";
 		 path1="\\DE_Real_strategy6_AB_NNH\\";
 		 method="DE_Real_strategy6_AB_NNH";
 		 Advance_bid=false;
 	}
	if(ckb94.getState()==true && btn==btn1 )  
 	{
 		 System.out.println("DE_Real_AB_2Si_ApproachI");
 		 Algorithm="DE_Real_AB_2Si_ApproachI";
 		 path1="\\DE_Real_AB_2Si_ApproachI\\";
 		 method="DE_Real_AB_2Si_ApproachI";
 		 Advance_bid=false;
 	}
	if(ckb95.getState()==true && btn==btn1 )  
 	{
 		 System.out.println("DE_Real_AB_2Si_ApproachII");
 		 Algorithm="DE_Real_AB_2Si_ApproachII";
 		 path1="\\DE_Real_AB_2Si_ApproachII\\";
 		 method="DE_Real_AB_2Si_ApproachII";
 		 Advance_bid=false;
 	}
	if(ckb96.getState()==true && btn==btn1 )  
 	{
 		 System.out.println("CCPSO2_AB_NNH");
 		 Algorithm="CCPSO2_AB_NNH";
 		 path1="\\CCPSO2_AB_NNH\\";
 		 method="CCPSO2_AB_NNH";
 		 Advance_bid=false;
 	}
	if(ckb97.getState()==true && btn==btn1 )  
 	{
 		 System.out.println("CCPSO2_AB_2Si_ApproachI");
 		 Algorithm="CCPSO2_AB_2Si_ApproachI";
 		 path1="\\CCPSO2_AB_2Si_ApproachI\\";
 		 method="CCPSO2_AB_2Si_ApproachI";
 		 Advance_bid=false;
 	}
	if(ckb98.getState()==true && btn==btn1 )  
 	{
 		 System.out.println("CCPSO2_AB_2Si_ApproachII");
 		 Algorithm="CCPSO2_AB_2Si_ApproachII";
 		 path1="\\CCPSO2_AB_2Si_ApproachII\\";
 		 method="CCPSO2_AB_2Si_ApproachII";
 		 Advance_bid=false;
 	}
	
	if(ckb99.getState()==true && btn==btn1 )  
 	{
 		 System.out.println("PSO2_AB_NNH");
 		 Algorithm="PSO2_AB_NNH";
 		 path1="\\PSO2_AB_NNH\\";
 		 method="PSO2_AB_NNH";
 		 Advance_bid=false;
 	}
	if(ckb100.getState()==true && btn==btn1 )  
 	{
 		 System.out.println("PSO2_AB_2Si_ApproachI");
 		 Algorithm="PSO2_AB_2Si_ApproachI";
 		 path1="\\PSO2_AB_2Si_ApproachI\\";
 		 method="PSO2_AB_2Si_ApproachI";
 		 Advance_bid=false;
 	}
	
	if(ckb101.getState()==true && btn==btn1 )  
 	{
 		 System.out.println("PSO2_AB_2Si_ApproachII");
 		 Algorithm="PSO2_AB_2Si_ApproachII";
 		 path1="\\PSO2_AB_2Si_ApproachII\\";
 		 method="PSO2_AB_2Si_ApproachII";
 		 Advance_bid=false;
 	}
	if(ckb102.getState()==true && btn==btn1 )  
 	{
 		 System.out.println("CC-CLPSO2_AB_NNH");
 		 Algorithm="CC-CLPSO2_AB_NNH";
 		 path1="\\CC-CLPSO2_AB_NNH\\";
 		 method="CC-CLPSO2_AB_NNH";
 		 Advance_bid=false;
 	}
	if(ckb103.getState()==true && btn==btn1 )  
 	{
 		 System.out.println("CC-CLPSO2_AB_2Si_ApproachI");
 		 Algorithm="CC-CLPSO2_AB_2Si_ApproachI";
 		 path1="\\CC-CLPSO2_AB_2Si_ApproachI\\";
 		 method="CC-CLPSO2_AB_2Si_ApproachI";
 		 Advance_bid=false;
 	}
	if(ckb104.getState()==true && btn==btn1 )  
 	{
 		 System.out.println("CC-CLPSO2_AB_2Si_ApproachII");
 		 Algorithm="CC-CLPSO2_AB_2Si_ApproachII";
 		 path1="\\CC-CLPSO2_AB_2Si_ApproachII\\";
 		 method="CC-CLPSO2_AB_2Si_ApproachII";
 		 Advance_bid=false;
 	}
	if(ckb105.getState()==true && btn==btn1 )  
 	{
 		 System.out.println("DMSDL-PSO_AB_NNH");
 		 Algorithm="DMSDL-PSO_AB_NNH";
 		 path1="\\DMSDL-PSO_AB_NNH\\";
 		 method="DMSDL-PSO_AB_NNH";
 		 Advance_bid=false;
 	}
	if(ckb106.getState()==true && btn==btn1 )  
 	{
 		 System.out.println("DMSDL-PSO_AB_2Si_ApproachI");
 		 Algorithm="DMSDL-PSO_AB_2Si_ApproachI";
 		 path1="\\DMSDL-PSO_AB_2Si_ApproachI\\";
 		 method="DMSDL-PSO_AB_2Si_ApproachI";
 		 Advance_bid=false;
 	}
	if(ckb107.getState()==true && btn==btn1 )  
 	{
 		 System.out.println("DMSDL-PSO_AB_2Si_ApproachII");
 		 Algorithm="DMSDL-PSO_AB_2Si_ApproachII";
 		 path1="\\DMSDL-PSO_AB_2Si_ApproachII\\";
 		 method="DMSDL-PSO_AB_2Si_ApproachII";
 		 Advance_bid=false;
 	}
	if(ckb108.getState()==true && btn==btn1 )  
 	{
 		 System.out.println("ALPSO2_NEW_PrematureConvegence1_AB_NNH");
 		 Algorithm="ALPSO2_NEW_PrematureConvegence1_AB_NNH";
 		 path1="\\ALPSO2_NEW_PrematureConvegence1_AB_NNH\\";
 		 method="ALPSO2_NEW_PrematureConvegence1_AB_NNH";
 		 Advance_bid=false;
 	}
	if(ckb109.getState()==true && btn==btn1 )  
 	{
 		 System.out.println("ALPSO2_NEW_PrematureConvegence1_AB_2Si_ApproachI");
 		 Algorithm="ALPSO2_NEW_PrematureConvegence1_AB_2Si_ApproachI";
 		 path1="\\ALPSO2_NEW_PrematureConvegence1_AB_2Si_ApproachI\\";
 		 method="ALPSO2_NEW_PrematureConvegence1_AB_2Si_ApproachI";
 		 Advance_bid=false;
 	}
	if(ckb110.getState()==true && btn==btn1 )  
 	{
 		 System.out.println("ALPSO2_NEW_PrematureConvegence1_AB_2Si_ApproachII");
 		 Algorithm="ALPSO2_NEW_PrematureConvegence1_AB_2Si_ApproachII";
 		 path1="\\ALPSO2_NEW_PrematureConvegence1_AB_2Si_ApproachII\\";
 		 method="ALPSO2_NEW_PrematureConvegence1_AB_2Si_ApproachII";
 		 Advance_bid=false;
 	}
	if(ckb111.getState()==true && btn==btn1 )  
 	{
 		 System.out.println("NSDE_AB_NNH");
 		 Algorithm="NSDE_AB_NNH";
 		 path1="\\NSDE_AB_NNH\\";
 		 method="NSDE_AB_NNH";
 		 Advance_bid=false;
 	}
	if(ckb112.getState()==true && btn==btn1 )  
 	{
 		 System.out.println("NSDE_AB_2Si_ApproachI");
 		 Algorithm="NSDE_AB_2Si_ApproachI";
 		 path1="\\NSDE_AB_2Si_ApproachI\\";
 		 method="NSDE_AB_2Si_ApproachI";
 		 Advance_bid=false;
 	}
	if(ckb113.getState()==true && btn==btn1 )  
 	{
 		 System.out.println("NSDE_AB_2Si_ApproachII");
 		 Algorithm="NSDE_AB_2Si_ApproachII";
 		 path1="\\NSDE_AB_2Si_ApproachII\\";
 		 method="NSDE_AB_2Si_ApproachII";
 		 Advance_bid=false;
 	}
	if(ckb114.getState()==true && btn==btn1 )  
 	{
 		 System.out.println("SaNSDE_AB_NNH");
 		 Algorithm="SaNSDE_AB_NNH";
 		 path1="\\SaNSDE_AB_NNH\\";
 		 method="SaNSDE_AB_NNH";
 		 Advance_bid=false;
 	}
	if(ckb115.getState()==true && btn==btn1 )  
 	{
 		 System.out.println("SaNSDE_AB_2Si_ApproachI");
 		 Algorithm="SaNSDE_AB_2Si_ApproachI";
 		 path1="\\SaNSDE_AB_2Si_ApproachI\\";
 		 method="SaNSDE_AB_2Si_ApproachI";
 		 Advance_bid=false;
 	}
	if(ckb116.getState()==true && btn==btn1 )  
 	{
 		 System.out.println("SaNSDE_AB_2Si_ApproachII");
 		 Algorithm="SaNSDE_AB_2Si_ApproachII";
 		 path1="\\SaNSDE_AB_2Si_ApproachII\\";
 		 method="SaNSDE_AB_2Si_ApproachII";
 		 Advance_bid=false;
 	}
	if(ckb117.getState()==true && btn==btn1 )  
 	{
 		 System.out.println("DynDE_AB_NNH");
 		 Algorithm="DynDE_AB_NNH";
 		 path1="\\DynDE_AB_NNH\\";
 		 method="DynDE_AB_NNH";
 		 Advance_bid=false;
 		Set_Parameter=2;
 	}
	
	if(ckb118.getState()==true && btn==btn1 )  
 	{
 		 System.out.println("DynDE_AB_2Si_ApproachI");
 		 Algorithm="DynDE_AB_2Si_ApproachI";
 		 path1="\\DynDE_AB_2Si_ApproachI\\";
 		 method="DynDE_AB_2Si_ApproachI";
 		 Advance_bid=false;
 		Set_Parameter=2;
 	}
	if(ckb119.getState()==true && btn==btn1 )  
 	{
 		 System.out.println("DynDE_AB_2Si_ApproachII");
 		 Algorithm="DynDE_AB_2Si_ApproachII";
 		 path1="\\DynDE_AB_2Si_ApproachII\\";
 		 method="DynDE_AB_2Si_ApproachII";
 		 Advance_bid=false;
 		Set_Parameter=2;
 	}

	if(ckb120.getState()==true && btn==btn1 )  
 	{
 		 System.out.println("FA_AB_NNH");
 		 Algorithm="FA_AB_NNH";
 		 path1="\\FA_AB_NNH\\";
 		 method="FA_AB_NNH";
 		 Advance_bid=false;
 		Set_Parameter=2;
 	}
	if(ckb121.getState()==true && btn==btn1 )  
 	{
 		 System.out.println("FA_AB_2Si_ApproachI");
 		 Algorithm="FA_AB_2Si_ApproachI";
 		 path1="\\FA_AB_2Si_ApproachI\\";
 		 method="FA_AB_2Si_ApproachI";
 		 Advance_bid=false;
 		Set_Parameter=2;
 	}
	if(ckb122.getState()==true && btn==btn1 )  
 	{
 		 System.out.println("FA_AB_2Si_ApproachII");
 		 Algorithm="FA_AB_2Si_ApproachII";
 		 path1="\\FA_AB_2Si_ApproachII\\";
 		 method="FA_AB_2Si_ApproachII";
 		 Advance_bid=false;
 		Set_Parameter=2;
 	}
	if(ckb123.getState()==true && btn==btn1 )  
 	{
 		 System.out.println("FA_PSO_AB_NNH");
 		 Algorithm="FA_PSO_AB_NNH";
 		 path1="\\FA_PSO_AB_NNH\\";
 		 method="FA_PSO_AB_NNH";
 		 Advance_bid=false;
 		Set_Parameter=2;
 	}
	if(ckb124.getState()==true && btn==btn1 )  
 	{
 		 System.out.println("FA_PSO_AB_2Si_ApproachI");
 		 Algorithm="FA_PSO_AB_2Si_ApproachI";
 		 path1="\\FA_PSO_AB_2Si_ApproachI\\";
 		 method="FA_PSO_AB_2Si_ApproachI";
 		 Advance_bid=false;
 		Set_Parameter=2;
 	}
	if(ckb125.getState()==true && btn==btn1 )  
 	{
 		 System.out.println("FA_PSO_AB_2Si_ApproachII");
 		 Algorithm="FA_PSO_AB_2Si_ApproachII";
 		 path1="\\FA_PSO_AB_2Si_ApproachII\\";
 		 method="FA_PSO_AB_2Si_ApproachII";
 		 Advance_bid=false;
 		Set_Parameter=2;
 	}

 	if(ckb999.getState()==true && btn==btn1 )  
 	{
  		 System.out.println("Run_multi_Algorithm");
 		 Algorithm="Run_multi_Algorithm";
 	}
 
    	frame.setVisible(false);
    }
    
    public static String path(){
    	return path1;
    }
    public static String method(){
    	return method;
    }
    public static boolean Advance_bid(){
    	return Advance_bid;
    }
    public static int Set_Parameter(){
    	return Set_Parameter;
    }
    
    
    public static void Setpath(String Path){
    		path1=Path;
    }
    public static void Setmethod(String Method){
    		method=Method;
    }
    public static void SetAdvance_bid(boolean index){
    	Advance_bid=index;
    }
}