package GUI.GUI_Tourism;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;

import GUI.I_Set_Paths_for_Current_Simulation_Example;
import Input_Output_txt.Read_result;

public class XIII_Compare_the_Simulation_Results_for_the_Current_Simulation_Example extends Tourism implements ActionListener{
	  JFrame frm=new JFrame();
	
	   Label lab1=new Label();
	    Label lab2=new Label();
	    Label lab3=new Label();
	    Label lab4=new Label();   
	    Label lab5=new Label();
	    Label lab6=new Label();
	    Label lab7=new Label();   
	    Label lab8=new Label();
	    Label lab9=new Label();   
	    Label lab10=new Label();
	    Label lab11=new Label(); 
	    Label lab12=new Label();
	    Label lab13=new Label(); 
	    Label lab14=new Label();
	    Label lab15=new Label(); 
	    Label lab16=new Label();
	    Label lab17=new Label(); 
	    Label lab18=new Label();
	    Label lab19=new Label(); 
	    Label lab20=new Label();
	    Label lab21=new Label(); 
	    Label lab22=new Label();
	    Label lab23=new Label(); 
	    Label lab24=new Label();
	    Label lab25=new Label();
	    Label lab26=new Label(); 
	    Label lab27=new Label();
	    Label lab28=new Label(); 
	    Label lab29=new Label(); 
	    Label lab30=new Label(); 
	    Label lab31=new Label();
	    Label lab32=new Label(); 
	    Label lab33=new Label();
	    Label lab34=new Label(); 
	    Label lab35=new Label();
	    Label lab36=new Label(); 
	    Label lab37=new Label();
	    Label lab38=new Label(); 
	    Label lab39=new Label();
	    Label lab40=new Label(); 
	    Label lab41=new Label();
	    
	    Label lab42=new Label();
	    Label lab43=new Label(); 
	    Label lab44=new Label();
	    Label lab45=new Label(); 
	    Label lab46=new Label();
	    Label lab47=new Label();
	    
	    Label lab48=new Label();
	    Label lab49=new Label(); 
	    Label lab50=new Label();
	    Label lab51=new Label(); 
	    Label lab52=new Label();
	    Label lab53=new Label();
	    
	    Label lab54=new Label();
	    Label lab55=new Label(); 
	    Label lab56=new Label();
	    Label lab57=new Label(); 
	    Label lab58=new Label();
	    Label lab59=new Label();
	    
	    JButton btn1=new JButton("Exit");

	  XIII_Compare_the_Simulation_Results_for_the_Current_Simulation_Example(){
			frm.setSize(1300,850); // 設定視窗的大小為 200*150
	    	frm.setLocation(50,50); // 設定視窗位置為(100,50)
	    	frm.setTitle("XIII_Compare_the_Simulation_Results_for_the_Current_Simulation_Example");
	   	 	frm.setLayout(null);
		 
	   	 	lab1.setText("CPLEX");
	   	 	lab1.setBackground(Color.white);
	   	 	lab1.setAlignment(Label.CENTER);
	   	 	lab1.setForeground(Color.blue);
	   	 	lab1.setLocation(200,100);       // �]�w���Ҧ�m
	   	 	lab1.setSize(400,20);          // �]�w���Ҥj�p
	   	 	lab1.setFont(new Font("Serief",Font.ITALIC+Font.BOLD,18));
	   	 	frm.add(lab1);
	   	 	
	   	 	lab6.setText("GA1");
	   	 	lab6.setBackground(Color.white);
	   	 	lab6.setAlignment(Label.CENTER);
	   	 	lab6.setForeground(Color.blue);
	   	 	lab6.setLocation(50,300);       // �]�w���Ҧ�m
	   	 	lab6.setSize(300,20);          // �]�w���Ҥj�p
	   	 	lab6.setFont(new Font("Serief",Font.ITALIC+Font.BOLD,18));
	   	 	frm.add(lab6);
	   	 	
	   	 	lab11.setText("GA2");
	   	 	lab11.setBackground(Color.white);
	     	lab11.setAlignment(Label.CENTER);
	     	lab11.setForeground(Color.blue);
	     	lab11.setLocation(350,300);       // �]�w���Ҧ�m
	     	lab11.setSize(300,20);          // �]�w���Ҥj�p
	     	lab11.setFont(new Font("Serief",Font.ITALIC+Font.BOLD,18));
	     	frm.add(lab11);
	     
			lab16.setText("PSO1");
			lab16.setBackground(Color.white);
			lab16.setAlignment(Label.CENTER);
			lab16.setForeground(Color.blue);
			lab16.setLocation(650,300);       // �]�w���Ҧ�m
			lab16.setSize(300,20);          // �]�w���Ҥj�p
			lab16.setFont(new Font("Serief",Font.ITALIC+Font.BOLD,18));
			frm.add(lab16);
			     
			  lab21.setText("PSO2");
			  lab21.setBackground(Color.white);
			  lab21.setAlignment(Label.CENTER);
			  lab21.setForeground(Color.blue);
			  lab21.setLocation(950,300);       // �]�w���Ҧ�m
			  lab21.setSize(300,20);          // �]�w���Ҥj�p
			  lab21.setFont(new Font("Serief",Font.ITALIC+Font.BOLD,18));
			  frm.add(lab21);
			    
			lab30.setText("PSO3");
		   	 lab30.setBackground(Color.white);
		   	 lab30.setAlignment(Label.CENTER);
		   	 lab30.setForeground(Color.blue);
		   	 lab30.setLocation(50,500);       // �]�w���Ҧ�m
		   	 lab30.setSize(300,20);          // �]�w���Ҥj�p
		   	 lab30.setFont(new Font("Serief",Font.ITALIC+Font.BOLD,18));
		   	 frm.add(lab30);
		   	 
		   	lab36.setText("PSO4");
		   	lab36.setBackground(Color.white);
		   	lab36.setAlignment(Label.CENTER);
		   	lab36.setForeground(Color.blue);
		   	lab36.setLocation(350,500);       // �]�w���Ҧ�m
		   	lab36.setSize(300,20);          // �]�w���Ҥj�p
		   	lab36.setFont(new Font("Serief",Font.ITALIC+Font.BOLD,18));
		   	 frm.add(lab36);
		   	 
		   	lab42.setText("APSO1");
		   	lab42.setBackground(Color.white);
		   	lab42.setAlignment(Label.CENTER);
		   	lab42.setForeground(Color.blue);
		   	lab42.setLocation(650,500);       // �]�w���Ҧ�m
		   	lab42.setSize(300,20);          // �]�w���Ҥj�p
		   	lab42.setFont(new Font("Serief",Font.ITALIC+Font.BOLD,18));
		   	 frm.add(lab42);
		   	 
		   	lab48.setText("APSO2");
		   	lab48.setBackground(Color.white);
		   	lab48.setAlignment(Label.CENTER);
		   	lab48.setForeground(Color.blue);
		   	lab48.setLocation(950,500);       // �]�w���Ҧ�m
		   	lab48.setSize(300,20);          // �]�w���Ҥj�p
		   	lab48.setFont(new Font("Serief",Font.ITALIC+Font.BOLD,18));
		   	 frm.add(lab48);
		   	 
		   	lab54.setText("ALPSO");
		   	lab54.setBackground(Color.white);
		   	lab54.setAlignment(Label.CENTER);
		   	lab54.setForeground(Color.blue);
		   	lab54.setLocation(800,100);       // �]�w���Ҧ�m
		   	lab54.setSize(400,20);          // �]�w���Ҥj�p
		   	lab54.setFont(new Font("Serief",Font.ITALIC+Font.BOLD,18));
		   	 frm.add(lab54);
		   	 
		  Read_result c1=new Read_result();
	    	String fileName = "output\\"+I_Set_Paths_for_Current_Simulation_Example.filename();
	    
			String[] filename;
			String CfileName;
			File f = new File(fileName);
			if (f.isDirectory()) {
				filename = f.list();
				 
				for (int k = 0; k < filename.length; k++) {
					// ---------------------
					CfileName = fileName + "\\" + filename[k] + "\\";
					File Cf = new File(CfileName);
					if (Cf.isDirectory()) {
					
					try{
					if(filename[k].equals("CPLEX")){
							c1.read_CPLEX();
							
						     
						     lab2.setText("X=   "+ c1.getCPLEX_X());
						     lab2.setBackground(Color.white);
						     lab2.setAlignment(Label.CENTER);
						     lab2.setForeground(Color.blue);
						     lab2.setLocation(200,130);       // �]�w���Ҧ�m
						     lab2.setSize(450,20);          // �]�w���Ҥj�p
						     lab2.setFont(new Font("Serief",Font.ITALIC+Font.BOLD,18));
						     frm.add(lab2);
					   	 	
						     lab3.setText("Y=   "+ c1.getCPLEX_Y());
						     lab3.setBackground(Color.white);
						     lab3.setAlignment(Label.CENTER);
						     lab3.setForeground(Color.blue);
						     lab3.setLocation(200,160);       // �]�w���Ҧ�m
						     lab3.setSize(450,20);          // �]�w���Ҥj�p
						     lab3.setFont(new Font("Serief",Font.ITALIC+Font.BOLD,18));
						     frm.add(lab3);
						     
						     lab4.setText("Fittest=    "+ c1.getCPLEX_Fittest());
						     lab4.setBackground(Color.white);
						     lab4.setAlignment(Label.CENTER);
						     lab4.setForeground(Color.blue);
						     lab4.setLocation(200,190);       // �]�w���Ҧ�m
						     lab4.setSize(400,20);          // �]�w���Ҥj�p
						     lab4.setFont(new Font("Serief",Font.ITALIC+Font.BOLD,18));
						     frm.add(lab4);
						     
						     lab5.setText("Time=   "+ c1.getCPLEX_time());
						     lab5.setBackground(Color.white);
						     lab5.setAlignment(Label.CENTER);
						     lab5.setForeground(Color.blue);
						     lab5.setLocation(200,220);       // �]�w���Ҧ�m
						     lab5.setSize(400,20);          // �]�w���Ҥj�p
						     lab5.setFont(new Font("Serief",Font.ITALIC+Font.BOLD,18));
						     frm.add(lab5);
						     
						}
					if(filename[k].equals("GA1")){
							c1.read_GA1();
						
						     
						     lab7.setText(c1.getGA1_X());
						     lab7.setBackground(Color.white);
						     lab7.setAlignment(Label.CENTER);
						     lab7.setForeground(Color.blue);
						     lab7.setLocation(50,330);       // �]�w���Ҧ�m
						     lab7.setSize(300,20);          // �]�w���Ҥj�p
						     lab7.setFont(new Font("Serief",Font.ITALIC+Font.BOLD,18));
						     frm.add(lab7);
					   	 	
						     lab8.setText(c1.getGA1_Y());
						     lab8.setBackground(Color.white);
						     lab8.setAlignment(Label.CENTER);
						     lab8.setForeground(Color.blue);
						     lab8.setLocation(50,360);       // �]�w���Ҧ�m
						     lab8.setSize(300,20);          // �]�w���Ҥj�p
						     lab8.setFont(new Font("Serief",Font.ITALIC+Font.BOLD,18));
						     frm.add(lab8);
						     
						     lab9.setText(c1.getGA1_Fittest());
						     lab9.setBackground(Color.white);
						     lab9.setAlignment(Label.CENTER);
						     lab9.setForeground(Color.blue);
						     lab9.setLocation(50,390);       // �]�w���Ҧ�m
						     lab9.setSize(300,20);          // �]�w���Ҥj�p
						     lab9.setFont(new Font("Serief",Font.ITALIC+Font.BOLD,18));
						     frm.add(lab9);
						     
						     lab10.setText(c1.getGA1_time());
						     lab10.setBackground(Color.white);
						     lab10.setAlignment(Label.CENTER);
						     lab10.setForeground(Color.blue);
						     lab10.setLocation(50,420);       // �]�w���Ҧ�m
						     lab10.setSize(300,20);          // �]�w���Ҥj�p
						     lab10.setFont(new Font("Serief",Font.ITALIC+Font.BOLD,18));
						     frm.add(lab10);
						     
						     lab26.setText(c1.getGA1_Generation()+"  times");
						     lab26.setBackground(Color.white);
						     lab26.setAlignment(Label.CENTER);
						     lab26.setForeground(Color.blue);
						     lab26.setLocation(50,450);       // �]�w���Ҧ�m
						     lab26.setSize(300,20);          // �]�w���Ҥj�p
						     lab26.setFont(new Font("Serief",Font.ITALIC+Font.BOLD,18));
						     frm.add(lab26);
						}
					if(filename[k].equals("GA2")){
							c1.read_GA2();
							   
						    
						     
						     lab12.setText(c1.getGA2_X());
						     lab12.setBackground(Color.white);
						     lab12.setAlignment(Label.CENTER);
						     lab12.setForeground(Color.blue);
						     lab12.setLocation(350,330);       // �]�w���Ҧ�m
						     lab12.setSize(300,20);          // �]�w���Ҥj�p
						     lab12.setFont(new Font("Serief",Font.ITALIC+Font.BOLD,18));
						     frm.add(lab12);
					   	 	
						     lab13.setText(c1.getGA2_Y());
						     lab13.setBackground(Color.white);
						     lab13.setAlignment(Label.CENTER);
						     lab13.setForeground(Color.blue);
						     lab13.setLocation(350,360);       // �]�w���Ҧ�m
						     lab13.setSize(300,20);          // �]�w���Ҥj�p
						     lab13.setFont(new Font("Serief",Font.ITALIC+Font.BOLD,18));
						     frm.add(lab13);
						     
						     lab14.setText(c1.getGA2_Fittest());
						     lab14.setBackground(Color.white);
						     lab14.setAlignment(Label.CENTER);
						     lab14.setForeground(Color.blue);
						     lab14.setLocation(350,390);       // �]�w���Ҧ�m
						     lab14.setSize(300,20);          // �]�w���Ҥj�p
						     lab14.setFont(new Font("Serief",Font.ITALIC+Font.BOLD,18));
						     frm.add(lab14);
						     
						     lab15.setText(c1.getGA2_time());
						     lab15.setBackground(Color.white);
						     lab15.setAlignment(Label.CENTER);
						     lab15.setForeground(Color.blue);
						     lab15.setLocation(350,420);       // �]�w���Ҧ�m
						     lab15.setSize(300,20);          // �]�w���Ҥj�p
						     lab15.setFont(new Font("Serief",Font.ITALIC+Font.BOLD,18));
						     frm.add(lab15);
						     lab27.setText(c1.getGA2_Generation()+"  times");
						     lab27.setBackground(Color.white);
						     lab27.setAlignment(Label.CENTER);
						     lab27.setForeground(Color.blue);
						     lab27.setLocation(350,450);       // �]�w���Ҧ�m
						     lab27.setSize(300,20);          // �]�w���Ҥj�p
						     lab27.setFont(new Font("Serief",Font.ITALIC+Font.BOLD,18));
						     frm.add(lab27);
						}
					if(filename[k].equals("PSO1")){
							c1.read_PSO1();
					
							     
							     lab17.setText(c1.getPSO1_X());
							     lab17.setBackground(Color.white);
							     lab17.setAlignment(Label.CENTER);
							     lab17.setForeground(Color.blue);
							     lab17.setLocation(650,330);       // �]�w���Ҧ�m
							     lab17.setSize(300,20);          // �]�w���Ҥj�p
							     lab17.setFont(new Font("Serief",Font.ITALIC+Font.BOLD,18));
							     frm.add(lab17);
						   	 	
							     lab18.setText(c1.getPSO1_Y());
							     lab18.setBackground(Color.white);
							     lab18.setAlignment(Label.CENTER);
							     lab18.setForeground(Color.blue);
							     lab18.setLocation(650,360);       // �]�w���Ҧ�m
							     lab18.setSize(300,20);          // �]�w���Ҥj�p
							     lab18.setFont(new Font("Serief",Font.ITALIC+Font.BOLD,18));
							     frm.add(lab18);
							     
							     lab19.setText(c1.getPSO1_Fittest());
							     lab19.setBackground(Color.white);
							     lab19.setAlignment(Label.CENTER);
							     lab19.setForeground(Color.blue);
							     lab19.setLocation(650,390);       // �]�w���Ҧ�m
							     lab19.setSize(300,20);          // �]�w���Ҥj�p
							     lab19.setFont(new Font("Serief",Font.ITALIC+Font.BOLD,18));
							     frm.add(lab19);
							     
							     lab20.setText(c1.getPSO1_time());
							     lab20.setBackground(Color.white);
							     lab20.setAlignment(Label.CENTER);
							     lab20.setForeground(Color.blue);
							     lab20.setLocation(650,420);       // �]�w���Ҧ�m
							     lab20.setSize(300,20);          // �]�w���Ҥj�p
							     lab20.setFont(new Font("Serief",Font.ITALIC+Font.BOLD,18));
							     frm.add(lab20);
							     
							     lab28.setText(c1.getPSO1_Generation()+"  times");
							     lab28.setBackground(Color.white);
							     lab28.setAlignment(Label.CENTER);
							     lab28.setForeground(Color.blue);
							     lab28.setLocation(650,450);       // �]�w���Ҧ�m
							     lab28.setSize(300,20);          // �]�w���Ҥj�p
							     lab28.setFont(new Font("Serief",Font.ITALIC+Font.BOLD,18));
							     frm.add(lab28);
						}
						if(filename[k].equals("PSO2")){
							c1.read_PSO2();
						
							     
							     lab22.setText(c1.getPSO2_X());
							     lab22.setBackground(Color.white);
							     lab22.setAlignment(Label.CENTER);
							     lab22.setForeground(Color.blue);
							     lab22.setLocation(950,330);       // �]�w���Ҧ�m
							     lab22.setSize(300,20);          // �]�w���Ҥj�p
							     lab22.setFont(new Font("Serief",Font.ITALIC+Font.BOLD,18));
							     frm.add(lab22);
						   	 	
							     lab23.setText(c1.getPSO2_Y());
							     lab23.setBackground(Color.white);
							     lab23.setAlignment(Label.CENTER);
							     lab23.setForeground(Color.blue);
							     lab23.setLocation(950,360);       // �]�w���Ҧ�m
							     lab23.setSize(300,20);          // �]�w���Ҥj�p
							     lab23.setFont(new Font("Serief",Font.ITALIC+Font.BOLD,18));
							     frm.add(lab23);
							     
							     lab24.setText(c1.getPSO2_Fittest());
							     lab24.setBackground(Color.white);
							     lab24.setAlignment(Label.CENTER);
							     lab24.setForeground(Color.blue);
							     lab24.setLocation(950,390);       // �]�w���Ҧ�m
							     lab24.setSize(300,20);          // �]�w���Ҥj�p
							     lab24.setFont(new Font("Serief",Font.ITALIC+Font.BOLD,18));
							     frm.add(lab24);
							     
							     lab25.setText(c1.getPSO2_time());
							     lab25.setBackground(Color.white);
							     lab25.setAlignment(Label.CENTER);
							     lab25.setForeground(Color.blue);
							     lab25.setLocation(950,420);       // �]�w���Ҧ�m
							     lab25.setSize(300,20);          // �]�w���Ҥj�p
							     lab25.setFont(new Font("Serief",Font.ITALIC+Font.BOLD,18));
							     frm.add(lab25);
							     
							     lab29.setText(c1.getPSO2_Generation()+"  times");
							     lab29.setBackground(Color.white);
							     lab29.setAlignment(Label.CENTER);
							     lab29.setForeground(Color.blue);
							     lab29.setLocation(950,450);       // �]�w���Ҧ�m
							     lab29.setSize(300,20);          // �]�w���Ҥj�p
							     lab29.setFont(new Font("Serief",Font.ITALIC+Font.BOLD,18));
							     frm.add(lab29);
							     
						}
						if(filename[k].equals("PSO3")){
							c1.read_PSO3();					
							     
							     lab31.setText(c1.getPSO3_X());
							     lab31.setBackground(Color.white);
							     lab31.setAlignment(Label.CENTER);
							     lab31.setForeground(Color.blue);
							     lab31.setLocation(50,530);       // �]�w���Ҧ�m
							     lab31.setSize(300,20);          // �]�w���Ҥj�p
							     lab31.setFont(new Font("Serief",Font.ITALIC+Font.BOLD,18));
							     frm.add(lab31);
						   	 	
							     lab32.setText(c1.getPSO3_Y());
							     lab32.setBackground(Color.white);
							     lab32.setAlignment(Label.CENTER);
							     lab32.setForeground(Color.blue);
							     lab32.setLocation(50,560);       // �]�w���Ҧ�m
							     lab32.setSize(300,20);          // �]�w���Ҥj�p
							     lab32.setFont(new Font("Serief",Font.ITALIC+Font.BOLD,18));
							     frm.add(lab32);
							     
							     lab33.setText(c1.getPSO3_Fittest());
							     lab33.setBackground(Color.white);
							     lab33.setAlignment(Label.CENTER);
							     lab33.setForeground(Color.blue);
							     lab33.setLocation(50,590);       // �]�w���Ҧ�m
							     lab33.setSize(300,20);          // �]�w���Ҥj�p
							     lab33.setFont(new Font("Serief",Font.ITALIC+Font.BOLD,18));
							     frm.add(lab33);
							     
							     lab34.setText(c1.getPSO3_time());
							     lab34.setBackground(Color.white);
							     lab34.setAlignment(Label.CENTER);
							     lab34.setForeground(Color.blue);
							     lab34.setLocation(50,620);       // �]�w���Ҧ�m
							     lab34.setSize(300,20);          // �]�w���Ҥj�p
							     lab34.setFont(new Font("Serief",Font.ITALIC+Font.BOLD,18));
							     frm.add(lab34);
							     
							     lab35.setText(c1.getPSO3_Generation()+"  times");
							     lab35.setBackground(Color.white);
							     lab35.setAlignment(Label.CENTER);
							     lab35.setForeground(Color.blue);
							     lab35.setLocation(50,650);       // �]�w���Ҧ�m
							     lab35.setSize(300,20);          // �]�w���Ҥj�p
							     lab35.setFont(new Font("Serief",Font.ITALIC+Font.BOLD,18));
							     frm.add(lab35);
							     
						}
						if(filename[k].equals("PSO4")){
							c1.read_PSO4();					
							     
							     lab37.setText(c1.getPSO4_X());
							     lab37.setBackground(Color.white);
							     lab37.setAlignment(Label.CENTER);
							     lab37.setForeground(Color.blue);
							     lab37.setLocation(350,530);       // �]�w���Ҧ�m
							     lab37.setSize(300,20);          // �]�w���Ҥj�p
							     lab37.setFont(new Font("Serief",Font.ITALIC+Font.BOLD,18));
							     frm.add(lab37);
						   	 	
							     lab38.setText(c1.getPSO4_Y());
							     lab38.setBackground(Color.white);
							     lab38.setAlignment(Label.CENTER);
							     lab38.setForeground(Color.blue);
							     lab38.setLocation(350,560);       // �]�w���Ҧ�m
							     lab38.setSize(300,20);          // �]�w���Ҥj�p
							     lab38.setFont(new Font("Serief",Font.ITALIC+Font.BOLD,18));
							     frm.add(lab38);
							     
							     lab39.setText(c1.getPSO4_Fittest());
							     lab39.setBackground(Color.white);
							     lab39.setAlignment(Label.CENTER);
							     lab39.setForeground(Color.blue);
							     lab39.setLocation(350,590);       // �]�w���Ҧ�m
							     lab39.setSize(300,20);          // �]�w���Ҥj�p
							     lab39.setFont(new Font("Serief",Font.ITALIC+Font.BOLD,18));
							     frm.add(lab39);
							     
							     lab40.setText(c1.getPSO4_time());
							     lab40.setBackground(Color.white);
							     lab40.setAlignment(Label.CENTER);
							     lab40.setForeground(Color.blue);
							     lab40.setLocation(350,620);       // �]�w���Ҧ�m
							     lab40.setSize(300,20);          // �]�w���Ҥj�p
							     lab40.setFont(new Font("Serief",Font.ITALIC+Font.BOLD,18));
							     frm.add(lab40);
							     
							     lab41.setText(c1.getPSO4_Generation()+"  times");
							     lab41.setBackground(Color.white);
							     lab41.setAlignment(Label.CENTER);
							     lab41.setForeground(Color.blue);
							     lab41.setLocation(350,650);       // �]�w���Ҧ�m
							     lab41.setSize(300,20);          // �]�w���Ҥj�p
							     lab41.setFont(new Font("Serief",Font.ITALIC+Font.BOLD,18));
							     frm.add(lab41);
							     
						}
						if(filename[k].equals("APSO1")){
							c1.read_APSO1();					
							     
							     lab43.setText(c1.getAPSO1_X());
							     lab43.setBackground(Color.white);
							     lab43.setAlignment(Label.CENTER);
							     lab43.setForeground(Color.blue);
							     lab43.setLocation(650,530);       // �]�w���Ҧ�m
							     lab43.setSize(300,20);          // �]�w���Ҥj�p
							     lab43.setFont(new Font("Serief",Font.ITALIC+Font.BOLD,18));
							     frm.add(lab43);
						   	 	
							     lab44.setText(c1.getAPSO1_Y());
							     lab44.setBackground(Color.white);
							     lab44.setAlignment(Label.CENTER);
							     lab44.setForeground(Color.blue);
							     lab44.setLocation(650,560);       // �]�w���Ҧ�m
							     lab44.setSize(300,20);          // �]�w���Ҥj�p
							     lab44.setFont(new Font("Serief",Font.ITALIC+Font.BOLD,18));
							     frm.add(lab44);
							     
							     lab45.setText(c1.getAPSO1_Fittest());
							     lab45.setBackground(Color.white);
							     lab45.setAlignment(Label.CENTER);
							     lab45.setForeground(Color.blue);
							     lab45.setLocation(650,590);       // �]�w���Ҧ�m
							     lab45.setSize(300,20);          // �]�w���Ҥj�p
							     lab45.setFont(new Font("Serief",Font.ITALIC+Font.BOLD,18));
							     frm.add(lab45);
							     
							     lab46.setText(c1.getAPSO1_time());
							     lab46.setBackground(Color.white);
							     lab46.setAlignment(Label.CENTER);
							     lab46.setForeground(Color.blue);
							     lab46.setLocation(650,620);       // �]�w���Ҧ�m
							     lab46.setSize(300,20);          // �]�w���Ҥj�p
							     lab46.setFont(new Font("Serief",Font.ITALIC+Font.BOLD,18));
							     frm.add(lab46);
							     
							     lab47.setText(c1.getAPSO1_Generation()+"  times");
							     lab47.setBackground(Color.white);
							     lab47.setAlignment(Label.CENTER);
							     lab47.setForeground(Color.blue);
							     lab47.setLocation(650,650);       // �]�w���Ҧ�m
							     lab47.setSize(300,20);          // �]�w���Ҥj�p
							     lab47.setFont(new Font("Serief",Font.ITALIC+Font.BOLD,18));
							     frm.add(lab47);
							     
						}
						if(filename[k].equals("APSO2")){
							c1.read_APSO2();					
							     
							     lab49.setText(c1.getAPSO2_X());
							     lab49.setBackground(Color.white);
							     lab49.setAlignment(Label.CENTER);
							     lab49.setForeground(Color.blue);
							     lab49.setLocation(950,530);       // �]�w���Ҧ�m
							     lab49.setSize(300,20);          // �]�w���Ҥj�p
							     lab49.setFont(new Font("Serief",Font.ITALIC+Font.BOLD,18));
							     frm.add(lab49);
						   	 	
							     lab50.setText(c1.getAPSO2_Y());
							     lab50.setBackground(Color.white);
							     lab50.setAlignment(Label.CENTER);
							     lab50.setForeground(Color.blue);
							     lab50.setLocation(950,560);       // �]�w���Ҧ�m
							     lab50.setSize(300,20);          // �]�w���Ҥj�p
							     lab50.setFont(new Font("Serief",Font.ITALIC+Font.BOLD,18));
							     frm.add(lab50);
							     
							     lab51.setText(c1.getAPSO2_Fittest());
							     lab51.setBackground(Color.white);
							     lab51.setAlignment(Label.CENTER);
							     lab51.setForeground(Color.blue);
							     lab51.setLocation(950,590);       // �]�w���Ҧ�m
							     lab51.setSize(300,20);          // �]�w���Ҥj�p
							     lab51.setFont(new Font("Serief",Font.ITALIC+Font.BOLD,18));
							     frm.add(lab51);
							     
							     lab52.setText(c1.getAPSO2_time());
							     lab52.setBackground(Color.white);
							     lab52.setAlignment(Label.CENTER);
							     lab52.setForeground(Color.blue);
							     lab52.setLocation(950,620);       // �]�w���Ҧ�m
							     lab52.setSize(300,20);          // �]�w���Ҥj�p
							     lab52.setFont(new Font("Serief",Font.ITALIC+Font.BOLD,18));
							     frm.add(lab52);
							     
							     lab53.setText(c1.getAPSO2_Generation()+"  times");
							     lab53.setBackground(Color.white);
							     lab53.setAlignment(Label.CENTER);
							     lab53.setForeground(Color.blue);
							     lab53.setLocation(950,650);       // �]�w���Ҧ�m
							     lab53.setSize(300,20);          // �]�w���Ҥj�p
							     lab53.setFont(new Font("Serief",Font.ITALIC+Font.BOLD,18));
							     frm.add(lab53);
							     
						}
						if(filename[k].equals("ALPSO")){
							c1.read_ALPSO();;
							
						     
						     lab55.setText("X=   "+ c1.getALPSO_X());
						     lab55.setBackground(Color.white);
						     lab55.setAlignment(Label.CENTER);
						     lab55.setForeground(Color.blue);
						     lab55.setLocation(800,130);       // �]�w���Ҧ�m
						     lab55.setSize(450,20);          // �]�w���Ҥj�p
						     lab55.setFont(new Font("Serief",Font.ITALIC+Font.BOLD,18));
						     frm.add(lab55);
					   	 	
						     lab56.setText("Y=   "+ c1.getALPSO_Y());
						     lab56.setBackground(Color.white);
						     lab56.setAlignment(Label.CENTER);
						     lab56.setForeground(Color.blue);
						     lab56.setLocation(800,160);       // �]�w���Ҧ�m
						     lab56.setSize(450,20);          // �]�w���Ҥj�p
						     lab56.setFont(new Font("Serief",Font.ITALIC+Font.BOLD,18));
						     frm.add(lab56);
						     
						     lab57.setText("Fittest=    "+ c1.getALPSO_Fittest());
						     lab57.setBackground(Color.white);
						     lab57.setAlignment(Label.CENTER);
						     lab57.setForeground(Color.blue);
						     lab57.setLocation(800,190);       // �]�w���Ҧ�m
						     lab57.setSize(400,20);          // �]�w���Ҥj�p
						     lab57.setFont(new Font("Serief",Font.ITALIC+Font.BOLD,18));
						     frm.add(lab57);
						     
						     lab58.setText("Time=   "+ c1.getALPSO_time());
						     lab58.setBackground(Color.white);
						     lab58.setAlignment(Label.CENTER);
						     lab58.setForeground(Color.blue);
						     lab58.setLocation(800,220);       // �]�w���Ҧ�m
						     lab58.setSize(400,20);          // �]�w���Ҥj�p
						     lab58.setFont(new Font("Serief",Font.ITALIC+Font.BOLD,18));
						     frm.add(lab58);
						     
						     lab59.setText(c1.getALPSO_Generation()+"  times");
						     lab59.setBackground(Color.white);
						     lab59.setAlignment(Label.CENTER);
						     lab59.setForeground(Color.blue);
						     lab59.setLocation(800,250);       // �]�w���Ҧ�m
						     lab59.setSize(400,20);          // �]�w���Ҥj�p
						     lab59.setFont(new Font("Serief",Font.ITALIC+Font.BOLD,18));
						     frm.add(lab59);
						     
						}
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					} else {
						System.out.println("Error 子目錄錯誤");
					}
				}
			} else {
				System.out.println("Error 目錄錯誤");
			}
	   
		     
		     btn1.setBounds(610,700,80,40);
	  	      btn1.setFont(new Font("Serief",Font.BOLD+Font.ITALIC,18));
	           frm.add(btn1);
	           btn1.addActionListener(this);
	    	 frm.setVisible(true); // 設定視窗為可見
	  }
    public static void main( ) 
    { 
    	new XIII_Compare_the_Simulation_Results_for_the_Current_Simulation_Example();
    	
    } 
    
    public void actionPerformed(ActionEvent e)   
	   {
    	JButton btn=(JButton) e.getSource();  
 	   if(btn==btn1){  
 	
	    	  frm.setVisible(false);
	      }
	   }
    
}
