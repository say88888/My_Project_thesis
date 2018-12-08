package GUI.GUI_Tourism;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class X_Select_Algorithm_Type_to_Solve_the_Problem extends Tourism implements ActionListener
{

	static JFrame frame = new JFrame();

	JButton btn1 = new JButton("Sure");
	JButton btn2 = new JButton("Exit");

	Checkbox ckb1 = new Checkbox("CPLEX");
	Checkbox ckb2 = new Checkbox("GA1");
	Checkbox ckb3 = new Checkbox("GA2");
	Checkbox ckb4 = new Checkbox("PSO1");
	Checkbox ckb5 = new Checkbox("PSO2");
	Checkbox ckb10 = new Checkbox("ALPSO");
	Checkbox ckb11 = new Checkbox("LRPSO");
	Checkbox ckb12 = new Checkbox("LR");
	Checkbox ckb13 = new Checkbox("LR_and_PSO2");
	Checkbox ckb14 = new Checkbox("LR_and_PSO1");
	Checkbox ckb15 = new Checkbox("CCPSO2");
	Checkbox ckb17 = new Checkbox("CPLEX_LP");

	Checkbox ckb19 = new Checkbox("DE");
	Checkbox ckb20 = new Checkbox("DE_strategy1");
	Checkbox ckb21 = new Checkbox("DE_strategy2");
	Checkbox ckb22 = new Checkbox("DE_strategy3");
	Checkbox ckb23 = new Checkbox("DE_strategy4");
	Checkbox ckb24 = new Checkbox("DE_strategy5");
	Checkbox ckb25 = new Checkbox("DE_strategy6");

	Checkbox ckb27 = new Checkbox("DE_Real");
	Checkbox ckb28 = new Checkbox("DE_strategy1_Real");
	Checkbox ckb29 = new Checkbox("DE_strategy2_Real");
	Checkbox ckb30 = new Checkbox("DE_strategy3_Real");
	Checkbox ckb31 = new Checkbox("DE_strategy4_Real");
	Checkbox ckb32 = new Checkbox("DE_strategy5_Real");
	Checkbox ckb33 = new Checkbox("DE_strategy6_Real");

	Checkbox ckb34 = new Checkbox("NSDE");
	Checkbox ckb35 = new Checkbox("SaNSDE");
	Checkbox ckb36 = new Checkbox("DECC");

	Checkbox ckb37 = new Checkbox("DE_Real_POP");
	Checkbox ckb38 = new Checkbox("DE_strategy1_Real_POP");
	Checkbox ckb39 = new Checkbox("DE_strategy2_Real_POP");
	Checkbox ckb40 = new Checkbox("DE_strategy3_Real_POP");
	Checkbox ckb41 = new Checkbox("DE_strategy4_Real_POP");
	Checkbox ckb42 = new Checkbox("DE_strategy5_Real_POP");
	Checkbox ckb43 = new Checkbox("DE_strategy6_Real_POP");

	Checkbox ckb44 = new Checkbox("DE_Real_POP_NEW");
	Checkbox ckb45 = new Checkbox("DE_strategy1_Real_POP_NEW");
	Checkbox ckb46 = new Checkbox("DE_strategy2_Real_POP_NEW");
	Checkbox ckb47 = new Checkbox("DE_strategy3_Real_POP_NEW");
	Checkbox ckb48 = new Checkbox("DE_strategy4_Real_POP_NEW");
	Checkbox ckb49 = new Checkbox("DE_strategy5_Real_POP_NEW");
	Checkbox ckb50 = new Checkbox("DE_strategy6_Real_POP_NEW");

	Checkbox ckb51 = new Checkbox("DynDE");
	Checkbox ckb52 = new Checkbox("DynDE_POP");

	Checkbox ckb53 = new Checkbox("ALPSO2_NEW");
	Checkbox ckb54 = new Checkbox("ALPSO2_NEW_PrematureConvegence1");

	Checkbox ckb55 = new Checkbox("DMS_L_PSO");
	Checkbox ckb56 = new Checkbox("DMSDL_PSO");
	Checkbox ckb57 = new Checkbox("NLPSO2");
	Checkbox ckb58 = new Checkbox("CLPSO2");

	Checkbox ckb59 = new Checkbox("CC-CLPSO2");

	Checkbox ckb60 = new Checkbox("FA_PSO");
	Checkbox ckb61 = new Checkbox("FA");

	Checkbox ckb62 = new Checkbox("L-SHADE");
	Checkbox ckb63 = new Checkbox("L_SHADE_CCPSO2");

	Checkbox ckb64 = new Checkbox("NSDE_POP");
	Checkbox ckb65 = new Checkbox("SaNSDE_POP");
	Checkbox ckb66 = new Checkbox("DECC_POP");

	Checkbox ckb67 = new Checkbox("NSDE_POP_NEW");
	Checkbox ckb68 = new Checkbox("SaNSDE_POP_NEW");
	Checkbox ckb69 = new Checkbox("DECC_POP_NEW");

	Checkbox ckb99 = new Checkbox("Select_multi_Algorithm");

	static CheckboxGroup grp = new CheckboxGroup();
	public static String path1;
	public static String method;

	public X_Select_Algorithm_Type_to_Solve_the_Problem() {
		initUI();
	}

	private void initUI() {

		frame.setSize(950, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		JTabbedPane tbp = new JTabbedPane();

		tbp.addTab("CPLEX", createPanel_CPLEX("First panel"));
		tbp.addTab("GA", createPane2_GA("Second panel"));
		tbp.addTab("PSO_and_LR", createPanel3_PSO_and_LR("Third panel"));
		tbp.addTab("DE", createPanel4_DE("Four panel"));
		tbp.addTab("FA", createPanel5_FA("Five panel"));
		tbp.addTab("Select_multi_Algorithm", createPanel6_Select_multi_Algorithm("Six panel"));
		setTitle("JTabbedPane");

		createLayout(tbp);

		btn1.setBounds(140, 480, 80, 40);
		btn1.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
		btn2.setBounds(280, 480, 80, 40);
		btn2.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
		frame.add(btn1);
		btn1.addActionListener(this);
		frame.add(btn2);
		btn2.addActionListener(this);

		frame.getContentPane().add(tbp);
	}

	private JPanel createPanel_CPLEX(String text) {

		ckb1.setCheckboxGroup(grp);
		ckb17.setCheckboxGroup(grp);
		ckb1.setBounds(40, 20, 140, 40);
		ckb17.setBounds(40, 60, 140, 40);
		JPanel panel = new JPanel();

		panel.setLayout(null);
		panel.add(ckb1);
		panel.add(ckb17);
		return panel;
	}

	private JPanel createPane2_GA(String text) {

		ckb2.setCheckboxGroup(grp);
		ckb3.setCheckboxGroup(grp);
		ckb2.setBounds(40, 20, 140, 40);
		ckb3.setBounds(40, 60, 140, 40);

		JPanel panel = new JPanel();

		panel.setLayout(null);
		panel.add(ckb2);
		panel.add(ckb3);

		return panel;
	}

	private JPanel createPanel3_PSO_and_LR(String text) {

		ckb4.setCheckboxGroup(grp);
		ckb5.setCheckboxGroup(grp);
		ckb10.setCheckboxGroup(grp);
		ckb11.setCheckboxGroup(grp);
		ckb12.setCheckboxGroup(grp);
		ckb13.setCheckboxGroup(grp);
		ckb14.setCheckboxGroup(grp);
		ckb15.setCheckboxGroup(grp);
		ckb53.setCheckboxGroup(grp);
		ckb54.setCheckboxGroup(grp);

		ckb55.setCheckboxGroup(grp);
		ckb56.setCheckboxGroup(grp);
		ckb57.setCheckboxGroup(grp);
		ckb58.setCheckboxGroup(grp);

		ckb59.setCheckboxGroup(grp);
		ckb63.setCheckboxGroup(grp);

		ckb4.setBounds(40, 20, 100, 40);
		ckb5.setBounds(40, 60, 100, 40);
		ckb10.setBounds(40, 100, 100, 40);
		ckb11.setBounds(40, 140, 100, 40);
		ckb12.setBounds(40, 180, 100, 40);
		ckb13.setBounds(40, 220, 100, 40);
		ckb14.setBounds(40, 260, 100, 40);
		ckb15.setBounds(40, 300, 100, 40);

		ckb53.setBounds(480, 20, 200, 40);
		ckb54.setBounds(480, 60, 200, 40);

		ckb55.setBounds(480, 100, 200, 40);
		ckb56.setBounds(480, 140, 200, 40);
		ckb57.setBounds(480, 180, 200, 40);
		ckb58.setBounds(480, 260, 200, 40);

		ckb59.setBounds(480, 300, 200, 40);
		ckb63.setBounds(480, 340, 200, 40);
		JPanel panel = new JPanel();

		panel.setLayout(null);
		panel.add(ckb4);
		panel.add(ckb5);
		panel.add(ckb10);
		panel.add(ckb11);
		panel.add(ckb12);
		panel.add(ckb13);
		panel.add(ckb14);
		panel.add(ckb15);
		panel.add(ckb53);
		panel.add(ckb54);

		panel.add(ckb55);
		panel.add(ckb56);
		panel.add(ckb57);
		panel.add(ckb58);
		panel.add(ckb59);
		panel.add(ckb63);

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
		ckb27.setCheckboxGroup(grp);
		ckb28.setCheckboxGroup(grp);
		ckb29.setCheckboxGroup(grp);
		ckb30.setCheckboxGroup(grp);
		ckb31.setCheckboxGroup(grp);
		ckb32.setCheckboxGroup(grp);
		ckb33.setCheckboxGroup(grp);

		ckb34.setCheckboxGroup(grp);
		ckb35.setCheckboxGroup(grp);
		ckb36.setCheckboxGroup(grp);
		ckb37.setCheckboxGroup(grp);
		ckb38.setCheckboxGroup(grp);
		ckb39.setCheckboxGroup(grp);
		ckb40.setCheckboxGroup(grp);
		ckb41.setCheckboxGroup(grp);
		ckb42.setCheckboxGroup(grp);
		ckb43.setCheckboxGroup(grp);

		ckb44.setCheckboxGroup(grp);
		ckb45.setCheckboxGroup(grp);
		ckb46.setCheckboxGroup(grp);
		ckb47.setCheckboxGroup(grp);
		ckb48.setCheckboxGroup(grp);
		ckb49.setCheckboxGroup(grp);
		ckb50.setCheckboxGroup(grp);

		ckb51.setCheckboxGroup(grp);
		ckb52.setCheckboxGroup(grp);

		ckb62.setCheckboxGroup(grp);

		ckb64.setCheckboxGroup(grp);
		ckb65.setCheckboxGroup(grp);
		ckb66.setCheckboxGroup(grp);

		ckb67.setCheckboxGroup(grp);
		ckb68.setCheckboxGroup(grp);
		ckb69.setCheckboxGroup(grp);

		ckb19.setBounds(40, 20, 140, 40);
		ckb20.setBounds(40, 60, 140, 40);
		ckb21.setBounds(40, 100, 140, 40);
		ckb22.setBounds(40, 140, 140, 40);
		ckb23.setBounds(40, 180, 140, 40);
		ckb24.setBounds(40, 220, 140, 40);
		ckb25.setBounds(40, 260, 140, 40);
		ckb51.setBounds(40, 300, 140, 40);
		ckb52.setBounds(40, 340, 140, 40);
		ckb62.setBounds(40, 380, 140, 40);

		ckb27.setBounds(220, 20, 180, 40);
		ckb28.setBounds(220, 60, 180, 40);
		ckb29.setBounds(220, 100, 180, 40);
		ckb30.setBounds(220, 140, 180, 40);
		ckb31.setBounds(220, 180, 180, 40);
		ckb32.setBounds(220, 220, 180, 40);
		ckb33.setBounds(220, 260, 180, 40);

		ckb34.setBounds(220, 300, 180, 40);
		ckb35.setBounds(220, 340, 180, 40);
		ckb36.setBounds(220, 380, 180, 40);
		ckb37.setBounds(400, 20, 180, 40);
		ckb38.setBounds(400, 60, 180, 40);
		ckb39.setBounds(400, 100, 180, 40);
		ckb40.setBounds(400, 140, 180, 40);
		ckb41.setBounds(400, 180, 180, 40);
		ckb42.setBounds(400, 220, 180, 40);
		ckb43.setBounds(400, 260, 180, 40);
		ckb64.setBounds(400, 300, 180, 40);
		ckb65.setBounds(400, 340, 180, 40);
		ckb66.setBounds(400, 380, 180, 40);

		ckb44.setBounds(600, 20, 240, 40);
		ckb45.setBounds(600, 60, 240, 40);
		ckb46.setBounds(600, 100, 240, 40);
		ckb47.setBounds(600, 140, 240, 40);
		ckb48.setBounds(600, 180, 240, 40);
		ckb49.setBounds(600, 220, 240, 40);
		ckb50.setBounds(600, 260, 240, 40);
		ckb67.setBounds(600, 300, 240, 40);
		ckb68.setBounds(600, 340, 240, 40);
		ckb69.setBounds(600, 380, 240, 40);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.add(ckb19);
		panel.add(ckb20);
		panel.add(ckb21);
		panel.add(ckb22);
		panel.add(ckb23);
		panel.add(ckb24);
		panel.add(ckb25);
		panel.add(ckb27);
		panel.add(ckb28);
		panel.add(ckb29);
		panel.add(ckb30);
		panel.add(ckb31);
		panel.add(ckb32);
		panel.add(ckb33);
		panel.add(ckb34);
		panel.add(ckb35);
		panel.add(ckb36);
		panel.add(ckb37);
		panel.add(ckb38);
		panel.add(ckb39);
		panel.add(ckb40);
		panel.add(ckb41);
		panel.add(ckb42);
		panel.add(ckb43);
		panel.add(ckb44);
		panel.add(ckb45);
		panel.add(ckb46);
		panel.add(ckb47);
		panel.add(ckb48);
		panel.add(ckb49);
		panel.add(ckb50);
		panel.add(ckb51);
		panel.add(ckb52);
		panel.add(ckb62);
		panel.add(ckb64);
		panel.add(ckb65);
		panel.add(ckb66);
		panel.add(ckb67);
		panel.add(ckb68);
		panel.add(ckb69);
		return panel;
	}

	private JPanel createPanel5_FA(String text) {

		ckb60.setCheckboxGroup(grp);
		ckb61.setCheckboxGroup(grp);
		ckb60.setBounds(40, 40, 140, 40);
		ckb61.setBounds(40, 80, 140, 40);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.add(ckb60);
		panel.add(ckb61);

		return panel;
	}

	private JPanel createPanel6_Select_multi_Algorithm(String text) {

		ckb99.setCheckboxGroup(grp);
		ckb99.setBounds(40, 20, 140, 40);

		JPanel panel = new JPanel();

		panel.setLayout(null);
		panel.add(ckb99);

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
		JButton btn = (JButton) e.getSource();

		if (ckb1.getState() == true && btn == btn1)
		{
			System.out.println("CPLEX");
			Algorithm = "CPLEX";
			path1 = "\\CPLEX\\";
			method = "CPLEX";
		}
		if (ckb2.getState() == true && btn == btn1)
		{
			System.out.println("GA1");
			Algorithm = "GA1";
			path1 = "\\GA1\\";
			method = "GA1";
		}
		if (ckb3.getState() == true && btn == btn1)
		{
			System.out.println("GA2");
			Algorithm = "GA2";
			path1 = "\\GA2\\";
			method = "GA2";
		}
		if (ckb4.getState() == true && btn == btn1)
		{
			System.out.println("PSO1");
			Algorithm = "PSO1";
			path1 = "\\PSO1\\";
			method = "PSO1";
		}

		if (ckb5.getState() == true && btn == btn1)
		{
			System.out.println("PSO2");
			Algorithm = "PSO2";
			path1 = "\\PSO2\\";
			method = "PSO2";
		}
		if (ckb10.getState() == true && btn == btn1)
		{
			System.out.println("ALPSO");
			Algorithm = "ALPSO";
			path1 = "\\ALPSO\\";
			method = "ALPSO";
		}

		if (ckb11.getState() == true && btn == btn1)
		{
			System.out.println("LRPSO");
			Algorithm = "LRPSO";
			path1 = "\\LRPSO\\";
			method = "LRPSO";
		}
		if (ckb12.getState() == true && btn == btn1)
		{
			System.out.println("LR");
			Algorithm = "LR";
			path1 = "\\LR\\";
			method = "LR";
		}

		if (ckb13.getState() == true && btn == btn1)
		{
			System.out.println("LR+PSO2");
			Algorithm = "LR_and_PSO2";
			path1 = "\\LR_and_PSO2\\";
			method = "LR_and_PSO2";
		}
		if (ckb14.getState() == true && btn == btn1)
		{
			System.out.println("LR+PSO1");
			Algorithm = "LR_and_PSO1";
			path1 = "\\LR_and_PSO1\\";
			method = "LR_and_PSO1";
		}
		if (ckb15.getState() == true && btn == btn1)
		{
			System.out.println("CCPSO2");
			Algorithm = "CCPSO2";
			path1 = "\\CCPSO2\\";
			method = "CCPSO2";
		}
		if (ckb17.getState() == true && btn == btn1)
		{
			System.out.println("CPLEX_LP");
			Algorithm = "CPLEX_LP";
			path1 = "\\CPLEX_LP\\";
			method = "CPLEX_LP";
		}

		if (ckb19.getState() == true && btn == btn1)
		{
			System.out.println("DE");
			Algorithm = "DE_Tourism";
			path1 = "\\DE_Tourism\\";
			method = "DE_Tourism";
		}

		if (ckb20.getState() == true && btn == btn1)
		{
			System.out.println("DE_strategy1");
			Algorithm = "DE_Tourism_strategy1";
			path1 = "\\DE_Tourism_strategy1\\";
			method = "DE_Tourism_strategy1";
		}

		if (ckb21.getState() == true && btn == btn1)
		{
			System.out.println("D_strategy2");
			Algorithm = "DE_Tourism_strategy2";
			path1 = "\\DE_Tourism_strategy2\\";
			method = "DE_Tourism_strategy2";
		}

		if (ckb22.getState() == true && btn == btn1)
		{
			System.out.println("DE_strategy3");
			Algorithm = "DE_Tourism_strategy3";
			path1 = "\\DE_Tourism_strategy3\\";
			method = "DE_Tourism_strategy3";
		}

		if (ckb23.getState() == true && btn == btn1)
		{
			System.out.println("DE_strategy4");
			Algorithm = "DE_Tourism_strategy4";
			path1 = "\\DE_Tourism_strategy4\\";
			method = "DE_Tourism_strategy4";
		}

		if (ckb24.getState() == true && btn == btn1)
		{
			System.out.println("DE_strategy5");
			Algorithm = "DE_Tourism_strategy5";
			path1 = "\\DE_Tourism_strategy5\\";
			method = "DE_Tourism_strategy5";
		}

		if (ckb25.getState() == true && btn == btn1)
		{
			System.out.println("DE_strategy6");
			Algorithm = "DE_Tourism_strategy6";
			path1 = "\\DE_Tourism_strategy6\\";
			method = "DE_Tourism_strategy6";
		}

		if (ckb27.getState() == true && btn == btn1)
		{
			System.out.println("DE_Tourism_Real");
			Algorithm = "DE_Tourism_Real";
			path1 = "\\DE_Tourism_Real\\";
			method = "DE_Tourism_Real";
		}

		if (ckb28.getState() == true && btn == btn1)
		{
			System.out.println("DE_Tourism_strategy1_Real");
			Algorithm = "DE_Tourism_strategy1_Real";
			path1 = "\\DE_Tourism_strategy1_Real\\";
			method = "DE_Tourism_strategy1_Real";
		}

		if (ckb29.getState() == true && btn == btn1)
		{
			System.out.println("DE_Tourism_strategy2_Real");
			Algorithm = "DE_Tourism_strategy2_Real";
			path1 = "\\DE_Tourism_strategy2_Real\\";
			method = "DE_Tourism_strategy2_Real";
		}

		if (ckb30.getState() == true && btn == btn1)
		{
			System.out.println("DE_Tourism_strategy3_Real");
			Algorithm = "DE_Tourism_strategy3_Real";
			path1 = "\\DE_Tourism_strategy3_Real\\";
			method = "DE_Tourism_strategy3_Real";
		}

		if (ckb31.getState() == true && btn == btn1)
		{
			System.out.println("DE_Tourism_strategy4_Real");
			Algorithm = "DE_Tourism_strategy4_Real";
			path1 = "\\DE_Tourism_strategy4_Real\\";
			method = "DE_Tourism_strategy4_Real";
		}

		if (ckb32.getState() == true && btn == btn1)
		{
			System.out.println("DE_Tourism_strategy5_Real");
			Algorithm = "DE_Tourism_strategy5_Real";
			path1 = "\\DE_Tourism_strategy5_Real\\";
			method = "DE_Tourism_strategy5_Real";
		}

		if (ckb33.getState() == true && btn == btn1)
		{
			System.out.println("DE_Tourism_strategy6_Real");
			Algorithm = "DE_Tourism_strategy6_Real";
			path1 = "\\DE_Tourism_strategy6_Real\\";
			method = "DE_Tourism_strategy6_Real";
		}
		if (ckb34.getState() == true && btn == btn1)
		{
			System.out.println("NSDE");
			Algorithm = "NSDE";
			path1 = "\\NSDE\\";
			method = "NSDE";
		}
		if (ckb35.getState() == true && btn == btn1)
		{
			System.out.println("SaNSDE");
			Algorithm = "SaNSDE";
			path1 = "\\SaNSDE\\";
			method = "SaNSDE";
		}
		if (ckb36.getState() == true && btn == btn1)
		{
			System.out.println("DECC");
			Algorithm = "DECC";
			path1 = "\\DECC\\";
			method = "DECC";
		}
		if (ckb37.getState() == true && btn == btn1)
		{
			System.out.println("DE_Real_POP");
			Algorithm = "DE_Real_POP";
			path1 = "\\DE_Real_POP\\";
			method = "DE_Real_POP";
		}
		if (ckb38.getState() == true && btn == btn1)
		{
			System.out.println("DE_strategy1_Real_POP");
			Algorithm = "DE_strategy1_Real_POP";
			path1 = "\\DE_strategy1_Real_POP\\";
			method = "DE_strategy1_Real_POP";
		}
		if (ckb39.getState() == true && btn == btn1)
		{
			System.out.println("DE_strategy2_Real_POP");
			Algorithm = "DE_strategy2_Real_POP";
			path1 = "\\DE_strategy2_Real_POP\\";
			method = "DE_strategy2_Real_POP";
		}
		if (ckb40.getState() == true && btn == btn1)
		{
			System.out.println("DE_strategy3_Real_POP");
			Algorithm = "DE_strategy3_Real_POP";
			path1 = "\\DE_strategy3_Real_POP\\";
			method = "DE_strategy3_Real_POP";
		}
		if (ckb41.getState() == true && btn == btn1)
		{
			System.out.println("DE_strategy4_Real_POP");
			Algorithm = "DE_strategy4_Real_POP";
			path1 = "\\DE_strategy4_Real_POP\\";
			method = "DE_strategy4_Real_POP";
		}
		if (ckb42.getState() == true && btn == btn1)
		{
			System.out.println("DE_strategy5_Real_POP");
			Algorithm = "DE_strategy5_Real_POP";
			path1 = "\\DE_strategy5_Real_POP\\";
			method = "DE_strategy5_Real_POP";
		}
		if (ckb43.getState() == true && btn == btn1)
		{
			System.out.println("DE_strategy6_Real_POP");
			Algorithm = "DE_strategy6_Real_POP";
			path1 = "\\DE_strategy6_Real_POP\\";
			method = "DE_strategy6_Real_POP";
		}
		if (ckb44.getState() == true && btn == btn1)
		{
			System.out.println("DE_Real_POP_NEW");
			Algorithm = "DE_Real_POP_NEW";
			path1 = "\\DE_Real_POP_NEW\\";
			method = "DE_Real_POP_NEW";
		}
		if (ckb45.getState() == true && btn == btn1)
		{
			System.out.println("DE_strategy1_Real_POP_NEW");
			Algorithm = "DE_strategy1_Real_POP_NEW";
			path1 = "\\DE_strategy1_Real_POP_NEW\\";
			method = "DE_strategy1_Real_POP_NEW";
		}

		if (ckb46.getState() == true && btn == btn1)
		{
			System.out.println("DE_strategy2_Real_POP_NEW");
			Algorithm = "DE_strategy2_Real_POP_NEW";
			path1 = "\\DE_strategy2_Real_POP_NEW\\";
			method = "DE_strategy2_Real_POP_NEW";
		}

		if (ckb47.getState() == true && btn == btn1)
		{
			System.out.println("DE_strategy3_Real_POP_NEW");
			Algorithm = "DE_strategy3_Real_POP_NEW";
			path1 = "\\DE_strategy3_Real_POP_NEW\\";
			method = "DE_strategy3_Real_POP_NEW";
		}

		if (ckb48.getState() == true && btn == btn1)
		{
			System.out.println("DE_strategy4_Real_POP_NEW");
			Algorithm = "DE_strategy4_Real_POP_NEW";
			path1 = "\\DE_strategy4_Real_POP_NEW\\";
			method = "DE_strategy4_Real_POP_NEW";
		}

		if (ckb49.getState() == true && btn == btn1)
		{
			System.out.println("DE_strategy5_Real_POP_NEW");
			Algorithm = "DE_strategy5_Real_POP_NEW";
			path1 = "\\DE_strategy5_Real_POP_NEW\\";
			method = "DE_strategy5_Real_POP_NEW";
		}

		if (ckb50.getState() == true && btn == btn1)
		{
			System.out.println("DE_strategy6_Real_POP_NEW");
			Algorithm = "DE_strategy6_Real_POP_NEW";
			path1 = "\\DE_strategy6_Real_POP_NEW\\";
			method = "DE_strategy6_Real_POP_NEW";
		}
		if (ckb51.getState() == true && btn == btn1)
		{
			System.out.println("DynDE");
			Algorithm = "DynDE";
			path1 = "\\DynDE\\";
			method = "DynDE";
		}
		if (ckb52.getState() == true && btn == btn1)
		{
			System.out.println("DynDE_POP");
			Algorithm = "DynDE_POP";
			path1 = "\\DynDE_POP\\";
			method = "DynDE_POP";
		}
		if (ckb53.getState() == true && btn == btn1)
		{
			System.out.println("ALPSO2_NEW");
			Algorithm = "ALPSO2_NEW";
			path1 = "\\ALPSO2_NEW\\";
			method = "ALPSO2_NEW";
		}
		if (ckb54.getState() == true && btn == btn1)
		{
			System.out.println("ALPSO2_NEW_PrematureConvegence1");
			Algorithm = "ALPSO2_NEW_PrematureConvegence1";
			path1 = "\\ALPSO2_NEW_PrematureConvegence1\\";
			method = "ALPSO2_NEW_PrematureConvegence1";
		}
		if (ckb55.getState() == true && btn == btn1)
		{
			System.out.println("DMS-L-PSO");
			Algorithm = "DMS-L-PSO";
			path1 = "\\DMS-L-PSO\\";
			method = "DMS-L-PSO";
		}
		if (ckb56.getState() == true && btn == btn1)
		{
			System.out.println("DMSDL-PSO");
			Algorithm = "DMSDL-PSO";
			path1 = "\\DMSDL-PSO\\";
			method = "DMSDL-PSO";
		}
		if (ckb57.getState() == true && btn == btn1)
		{
			System.out.println("NLPSO2");
			Algorithm = "NLPSO2";
			path1 = "\\NLPSO2\\";
			method = "NLPSO2";
		}
		if (ckb58.getState() == true && btn == btn1)
		{
			System.out.println("CLPSO2");
			Algorithm = "CLPSO2";
			path1 = "\\CLPSO2\\";
			method = "CLPSO2";
		}
		if (ckb59.getState() == true && btn == btn1)
		{
			System.out.println("CC-CLPSO2");
			Algorithm = "CC-CLPSO2";
			path1 = "\\CC-CLPSO2\\";
			method = "CC-CLPSO2";
		}
		if (ckb60.getState() == true && btn == btn1)
		{
			System.out.println("FA_PSO");
			Algorithm = "FA_PSO";
			path1 = "\\FA_PSO\\";
			method = "FA_PSO";
		}
		if (ckb61.getState() == true && btn == btn1)
		{
			System.out.println("FA");
			Algorithm = "FA";
			path1 = "\\FA\\";
			method = "FA";
		}
		if (ckb62.getState() == true && btn == btn1)
		{
			System.out.println("L-SHADE");
			Algorithm = "L-SHADE";
			path1 = "\\L-SHADE\\";
			method = "L-SHADE";
		}
		if (ckb63.getState() == true && btn == btn1)
		{
			System.out.println("L_SHADE_CCPSO2");
			Algorithm = "L_SHADE_CCPSO2";
			path1 = "\\L_SHADE_CCPSO2\\";
			method = "L_SHADE_CCPSO2";
		}
		if (ckb64.getState() == true && btn == btn1)
		{
			System.out.println("NSDE_POP");
			Algorithm = "NSDE_POP";
			path1 = "\\NSDE_POP\\";
			method = "NSDE_POP";
		}
		if (ckb65.getState() == true && btn == btn1)
		{
			System.out.println("SaNSDE_POP");
			Algorithm = "SaNSDE_POP";
			path1 = "\\SaNSDE_POP\\";
			method = "SaNSDE_POP";
		}
		if (ckb66.getState() == true && btn == btn1)
		{
			System.out.println("DECC_POP");
			Algorithm = "DECC_POP";
			path1 = "\\DECC_POP\\";
			method = "DECC_POP";
		}
		if (ckb67.getState() == true && btn == btn1)
		{
			System.out.println("NSDE_POP_NEW");
			Algorithm = "NSDE_POP_NEW";
			path1 = "\\NSDE_POP_NEW\\";
			method = "NSDE_POP_NEW";
		}
		if (ckb68.getState() == true && btn == btn1)
		{
			System.out.println("SaNSDE_POP_NEW");
			Algorithm = "SaNSDE_POP_NEW";
			path1 = "\\SaNSDE_POP_NEW\\";
			method = "SaNSDE_POP_NEW";
		}
		if (ckb69.getState() == true && btn == btn1)
		{
			System.out.println("DECC_POP_NEW");
			Algorithm = "DECC_POP_NEW";
			path1 = "\\DECC_POP_NEW\\";
			method = "DECC_POP_NEW";
		}
		if (ckb99.getState() == true && btn == btn1)
		{
			System.out.println("Run_multi_Algorithm");
			Algorithm = "Run_multi_Algorithm";
		}
		frame.setVisible(false);
	}

	public static String path() {
		return path1;
	}

	public static String method() {
		return method;
	}

	public static void Setpath(String Path) {
		path1 = Path;
	}

	public static void Setmethod(String Method) {
		method = Method;
	}
}
