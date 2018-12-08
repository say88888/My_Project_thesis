package GUI.GUI_Carpool;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;

import Algorithm_Carpool.ALPSO2_NEW.ALPSO2_NEW;
import Algorithm_Carpool.ALPSO2_NEW_PrematureConvegence1.ALPSO2_NEW_PrematureConvegence1;
import Algorithm_Carpool.ALPSO2_NEW_PrematureConvegence1_AB_2Si_ApproachI.ALPSO2_NEW_PrematureConvegence1_AB_2Si_ApproachI;
import Algorithm_Carpool.ALPSO2_NEW_PrematureConvegence1_AB_2Si_ApproachII.ALPSO2_NEW_PrematureConvegence1_AB_2Si_ApproachII;
import Algorithm_Carpool.ALPSO2_NEW_PrematureConvegence1_AB_NNH.ALPSO2_NEW_PrematureConvegence1_AB_NNH;
import Algorithm_Carpool.APSO1.APSO1;
import Algorithm_Carpool.APSO1_P.APSO1_P;
import Algorithm_Carpool.APSO2.APSO2;
import Algorithm_Carpool.APSO2_P.APSO2_P;
import Algorithm_Carpool.CCPSO2.CCPSO2;
import Algorithm_Carpool.CCPSO2_AB_2Si_ApproachI.CCPSO2_AB_2Si_ApproachI;
import Algorithm_Carpool.CCPSO2_AB_2Si_ApproachII.CCPSO2_AB_2Si_ApproachII;
import Algorithm_Carpool.CCPSO2_AB_NNH.CCPSO2_AB_NNH;
import Algorithm_Carpool.CCPSO2_P.CCPSO2_P;
import Algorithm_Carpool.CC_CLPSO2.CC_CLPSO2;
import Algorithm_Carpool.CC_CLPSO2_AB_2Si_ApproachI.CC_CLPSO2_AB_2Si_ApproachI;
import Algorithm_Carpool.CC_CLPSO2_AB_2Si_ApproachII.CC_CLPSO2_AB_2Si_ApproachII;
import Algorithm_Carpool.CC_CLPSO2_AB_NNH.CC_CLPSO2_AB_NNH;
import Algorithm_Carpool.CLPSO2.CLPSO2;
import Algorithm_Carpool.DE.DE;
import Algorithm_Carpool.DECC.DECC;
import Algorithm_Carpool.DECC_POP.DECC_POP;
import Algorithm_Carpool.DECC_POP_NEW.DECC_POP_NEW;
import Algorithm_Carpool.DE_Real.DE_Real;
import Algorithm_Carpool.DE_Real_AB_2Si_ApproachI.DE_Real_AB_2Si_ApproachI;
import Algorithm_Carpool.DE_Real_AB_2Si_ApproachII.DE_Real_AB_2Si_ApproachII;
import Algorithm_Carpool.DE_Real_AB_NNH.DE_Real_AB_NNH;
import Algorithm_Carpool.DE_Real_POP.DE_Real_POP;
import Algorithm_Carpool.DE_Real_POP_NEW.DE_Real_POP_NEW;
import Algorithm_Carpool.DMSDL_PSO2.DMSDL_PSO2;
import Algorithm_Carpool.DMSDL_PSO2_AB_2Si_ApproachI.DMSDL_PSO2_AB_2Si_ApproachI;
import Algorithm_Carpool.DMSDL_PSO2_AB_2Si_ApproachII.DMSDL_PSO2_AB_2Si_ApproachII;
import Algorithm_Carpool.DMSDL_PSO2_AB_NNH.DMSDL_PSO2_AB_NNH;
import Algorithm_Carpool.DMS_L_PSO2.DMS_L_PSO2;
import Algorithm_Carpool.DynDE.DynDE;
import Algorithm_Carpool.DynDE_AB_2Si_ApproachI.DynDE_AB_2Si_ApproachI;
import Algorithm_Carpool.DynDE_AB_2Si_ApproachII.DynDE_AB_2Si_ApproachII;
import Algorithm_Carpool.DynDE_AB_NNH.DynDE_AB_NNH;
import Algorithm_Carpool.DynDE_POP.DynDE_POP;
import Algorithm_Carpool.FA.FA;
import Algorithm_Carpool.FA_AB_2Si_ApproachI.FA_AB_2Si_ApproachI;
import Algorithm_Carpool.FA_AB_2Si_ApproachII.FA_AB_2Si_ApproachII;
import Algorithm_Carpool.FA_AB_NNH.FA_AB_NNH;
import Algorithm_Carpool.FA_PSO.FA_PSO;
import Algorithm_Carpool.FA_PSO_AB_2Si_ApproachI.FA_PSO_AB_2Si_ApproachI;
import Algorithm_Carpool.FA_PSO_AB_2Si_ApproachII.FA_PSO_AB_2Si_ApproachII;
import Algorithm_Carpool.FA_PSO_AB_NNH.FA_PSO_AB_NNH;
import Algorithm_Carpool.GA1.GA1;
import Algorithm_Carpool.GA2.GA2;
import Algorithm_Carpool.L_SHADE.L_SHADE;
import Algorithm_Carpool.L_SHADE_CCPSO2.L_SHADE_CCPSO2;
import Algorithm_Carpool.Lagrangian_PSO.ALPSO;
import Algorithm_Carpool.Lagrangian_PSO_P.ALPSO_P;
import Algorithm_Carpool.Lagrangian_Relaxation.LR;
import Algorithm_Carpool.Lagrangian_Relaxation_PSO.LRPSO;
import Algorithm_Carpool.Lagrangian_Relaxation_PSO_P.LRPSO_P;
import Algorithm_Carpool.Lagrangian_Relaxation_and_PSO1.LR_and_PSO1;
import Algorithm_Carpool.Lagrangian_Relaxation_and_PSO1_P.LR_and_PSO1_P;
import Algorithm_Carpool.Lagrangian_Relaxation_and_PSO2.LR_and_PSO2;
import Algorithm_Carpool.Lagrangian_Relaxation_and_PSO2_P.LR_and_PSO2_P;
import Algorithm_Carpool.NLPSO2.NLPSO2;
import Algorithm_Carpool.NSDE.NSDE;
import Algorithm_Carpool.NSDE_AB_2Si_ApproachI.NSDE_AB_2Si_ApproachI;
import Algorithm_Carpool.NSDE_AB_2Si_ApproachII.NSDE_AB_2Si_ApproachII;
import Algorithm_Carpool.NSDE_AB_NNH.NSDE_AB_NNH;
import Algorithm_Carpool.NSDE_POP.NSDE_POP;
import Algorithm_Carpool.NSDE_POP_NEW.NSDE_POP_NEW;
import Algorithm_Carpool.PSO1.PSO1;
import Algorithm_Carpool.PSO1_P.PSO1_P;
import Algorithm_Carpool.PSO2.PSO2;
import Algorithm_Carpool.PSO2_AB_2Si_ApproachI.PSO2_AB_2Si_ApproachI;
import Algorithm_Carpool.PSO2_AB_2Si_ApproachII.PSO2_AB_2Si_ApproachII;
import Algorithm_Carpool.PSO2_AB_NNH.PSO2_AB_NNH;
import Algorithm_Carpool.PSO2_P.PSO2_P;
import Algorithm_Carpool.PSO3.PSO3;
import Algorithm_Carpool.PSO4.PSO4;
import Algorithm_Carpool.PSO_LS.PSO_LS;
import Algorithm_Carpool.PSO_LS_SetBased.PSO_LS_SetBased;
import Algorithm_Carpool.PSO_LS_WaitingTime.PSO_LS_WaitingTime;
import Algorithm_Carpool.SaNSDE.SaNSDE;
import Algorithm_Carpool.SaNSDE_AB_2Si_ApproachI.SaNSDE_AB_2Si_ApproachI;
import Algorithm_Carpool.SaNSDE_AB_2Si_ApproachII.SaNSDE_AB_2Si_ApproachII;
import Algorithm_Carpool.SaNSDE_AB_NNH.SaNSDE_AB_NNH;
import Algorithm_Carpool.SaNSDE_POP.SaNSDE_POP;
import Algorithm_Carpool.SaNSDE_POP_NEW.SaNSDE_POP_NEW;
import Cplex.CPLEX;
import GUI.I_Set_Paths_for_Current_Simulation_Example;
import Input_Output_txt.Carpool.check_batch_TXT;
import Result_to_out_Carpool.carpool_results_test;

public class XII_Run_the_selected_Algorithm_and_result_to_out_for_Carpool extends Carpool
		implements ActionListener {

	JFrame frm = new JFrame();

	JButton btn1 = new JButton("Run_the_selected_Algorithm");
	JButton btn2 = new JButton("result to out");
	JButton btn3 = new JButton("Exit");

	XII_Run_the_selected_Algorithm_and_result_to_out_for_Carpool() {

		frm.setSize(400, 300); // 設定視窗的大小為 200*150
		frm.setLocation(400, 50); // 設定視窗位置為(100,50)

		frm.setTitle("XII_Run_the_selected_Algorithm_and_result_to_out");
		frm.setLayout(null);

		btn1.setBounds(60, 50, 200, 40);
		btn1.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
		frm.add(btn1);
		btn1.addActionListener(this);

		btn2.setBounds(60, 130, 200, 40);
		btn2.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
		frm.add(btn2);
		btn2.addActionListener(this);

		btn3.setBounds(60, 200, 200, 40);
		btn3.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
		frm.add(btn3);
		btn3.addActionListener(this);

		frm.setVisible(true); // 設定視窗為可見
	}

	public static void main() {

		new XII_Run_the_selected_Algorithm_and_result_to_out_for_Carpool();
	}

	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		if (btn == btn1) {
			if (Algorithm.equals("CPLEX")) {
				try {
					CPLEX.main();
				} catch (IOException e1) {

					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("GA1")) {
				try {
				GA1.main();
				//	Double_Action_GA1.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("GA2"))  {
				try {
					GA2.main();
				//	Double_Action_GA2.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("PSO1")) {
				try {
				//	Double_Action_PSO1.main();
					PSO1.main();
				} catch (IOException e1) {

					e1.printStackTrace();
				}
			}

			if (Algorithm.equals("PSO2")) {
			//	for(int i=0;i<10;i++){
				try {
						PSO2.main();
				} catch (IOException e1) {

					e1.printStackTrace();
				}
		//		}
			}
			if (Algorithm.equals("PSO3")) {
				try {
					PSO3.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("PSO4")) {
				try {
					PSO4.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("APSO1")) {
				try {
					APSO1.main();
				} catch (IOException e1) {

					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("APSO2")) {
				try {
					APSO2.main();
				} catch (IOException e1) {

					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("ALPSO")) {
				try {
					ALPSO.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("LRPSO")) {
				try {
					LRPSO.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("LR")) {
				try {
					LR.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("LR_and_PSO2")) {
				try {
					LR_and_PSO2.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("LR_and_PSO1")) {
				try {
					LR_and_PSO1.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("CCPSO2")) {
		//		for(int i=0;i<10;i++){
				try {
					CCPSO2.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
		//		}
			}
			if (Algorithm.equals("PSO_LS")) {
		//		for(int i=0;i<10;i++){
				try {
					 PSO_LS.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			//	}
			}
			
			if (Algorithm.equals("PSO1_P")) {
				try {
				//	Double_Action_PSO1.main();
					PSO1_P.main();
				} catch (IOException e1) {

					e1.printStackTrace();
				}
			}

			if (Algorithm.equals("PSO2_P")) {
				try {
						PSO2_P.main();
				} catch (IOException e1) {

					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("APSO1_P")) {
				try {
					APSO1_P.main();
				} catch (IOException e1) {

					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("APSO2_P")) {
				try {
					APSO2_P.main();
				} catch (IOException e1) {

					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("ALPSO_P")) {
				try {
					ALPSO_P.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("LRPSO_P")) {
				try {
					LRPSO_P.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("LR_and_PSO2_P")) {
				try {
					LR_and_PSO2_P.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("LR_and_PSO1_P")) {
				try {
					LR_and_PSO1_P.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("CCPSO2_P")) {
	//			for(int i=0;i<10;i++){
				try {
					CCPSO2_P.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
	//			}
			}
			if (Algorithm.equals("DE_Carpool")) {
		//		for(int i=0;i<15;i++){
				try {
					DE.main();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		//		}
			}
			if (Algorithm.equals("DE_Carpool_strategy1")) {
		//		for(int i=0;i<15;i++){
				try {
					DE.main();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		//		}
			} 
			if (Algorithm.equals("DE_Carpool_strategy2")) {
		//		for(int i=0;i<15;i++){
				try {
					DE.main();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		//		}
			}
			if (Algorithm.equals("DE_Carpool_strategy3")) {
		//		for(int i=0;i<15;i++){
				try {
					DE.main();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		//		}
			}
			if (Algorithm.equals("DE_Carpool_strategy4")) {
		//		for(int i=0;i<15;i++){
				try {
					DE.main();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		//		}
			}
			if (Algorithm.equals("DE_Carpool_strategy5")) {
	//			for(int i=0;i<15;i++){
				try {
					DE.main();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	//			}
			}
			if (Algorithm.equals("DE_Carpool_strategy6") ) {
	//			for(int i=0;i<15;i++){
				try {
					DE.main();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	//			}
			}
			if (Algorithm.equals("DE_Carpool_Real")) {
				try {
					DE_Real.main();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			if (Algorithm.equals("DE_Carpool_strategy1_Real")) {
				try {
					DE_Real.main();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			if (Algorithm.equals("DE_Carpool_strategy2_Real")) {
				try {
					DE_Real.main();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			if (Algorithm.equals("DE_Carpool_strategy3_Real")) {
				try {
					DE_Real.main();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			if (Algorithm.equals("DE_Carpool_strategy4_Real")) {
				try {
					DE_Real.main();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			if (Algorithm.equals("DE_Carpool_strategy5_Real")) {
				try {
					DE_Real.main();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			if (Algorithm.equals("DE_Carpool_strategy6_Real") ) {
				try {
					DE_Real.main();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			if (Algorithm.equals("NSDE_Carpool")) {
				try {
					NSDE.main();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			if (Algorithm.equals("FA_PSO")) {
				try {
				FA_PSO.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("FA")) {
			 
				try {
				FA.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("SaNSDE")) {
				try {
					SaNSDE.main();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			if (Algorithm.equals("DECC")) {
				try {
					DECC.main();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			if (Algorithm.equals("DE_Carpool_Real_POP") || Algorithm.equals("DE_strategy1_Real_POP")
					|| Algorithm.equals("DE_strategy2_Real_POP") || Algorithm.equals("DE_strategy3_Real_POP")
					|| Algorithm.equals("DE_strategy4_Real_POP") || Algorithm.equals("DE_strategy5_Real_POP")
					|| Algorithm.equals("DE_strategy6_Real_POP")) {
				try {
					DE_Real_POP.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("NSDE_POP")) {
				try {
						NSDE_POP.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("SaNSDE_POP")) {
				try {
						SaNSDE_POP.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("DECC_POP")) {
				try {
						DECC_POP.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("DE_Real_POP_NEW") || Algorithm.equals("DE_strategy1_Real_POP_NEW") 
					|| Algorithm.equals("DE_strategy2_Real_POP_NEW") || Algorithm.equals("DE_strategy3_Real_POP_NEW") 
					|| Algorithm.equals("DE_strategy4_Real_POP_NEW") || Algorithm.equals("DE_strategy5_Real_POP_NEW")
					|| Algorithm.equals("DE_strategy6_Real_POP_NEW")) {
				try {
					DE_Real_POP_NEW.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("NSDE_POP_NEW")) {
				try {
						NSDE_POP_NEW.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("SaNSDE_POP_NEW")) {
				try {
						SaNSDE_POP_NEW.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("DECC_POP_NEW")) {
				try {
						DECC_POP_NEW.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("PSO_LS_WaitingTime")) {
				try {
					PSO_LS_WaitingTime.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("PSO_LS_SetBased")) {
				try {
					PSO_LS_SetBased.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("DMS-L-PSO")) {
				try {
					DMS_L_PSO2.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("DMSDL-PSO")) {
				try {
					DMSDL_PSO2.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("ALPSO2_NEW")) {
				try {
					ALPSO2_NEW.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("ALPSO2_NEW_PrematureConvegence1")) {
				try {
					ALPSO2_NEW_PrematureConvegence1.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("NLPSO2")) {
				try {
					NLPSO2.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("DynDE")) {
				try {
					DynDE.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("DynDE_POP")) {
				try {
					DynDE_POP.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("CLPSO2")) {
				try {
					CLPSO2.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("CC-CLPSO2")) {
				try {
					CC_CLPSO2.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("L-SHADE")) {
				try {
					L_SHADE.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("L_SHADE_CCPSO2")) {
				try {
					L_SHADE_CCPSO2.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("DE_Real_AB_NNH")|| Algorithm.equals("DE_Real_strategy1_AB_NNH")
			|| Algorithm.equals("DE_Real_strategy2_AB_NNH") || Algorithm.equals("DE_Real_strategy3_AB_NNH")
			|| Algorithm.equals("DE_Real_strategy4_AB_NNH") || Algorithm.equals("DE_Real_strategy5_AB_NNH")
			|| Algorithm.equals("DE_Real_strategy6_AB_NNH")) {
				try {
					DE_Real_AB_NNH.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("DE_Real_AB_2Si_ApproachI")) {
				try {
					DE_Real_AB_2Si_ApproachI.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}	
			if (Algorithm.equals("DE_Real_AB_2Si_ApproachII")) {
				try {
					DE_Real_AB_2Si_ApproachII.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("CCPSO2_AB_NNH")) {
				try {
					CCPSO2_AB_NNH.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("CCPSO2_AB_2Si_ApproachI")) {
				try {
					CCPSO2_AB_2Si_ApproachI.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("CCPSO2_AB_2Si_ApproachII")) {
				try {
					CCPSO2_AB_2Si_ApproachII.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("PSO2_AB_NNH")) {
				try {
					PSO2_AB_NNH.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("PSO2_AB_2Si_ApproachI")) {
				try {
					PSO2_AB_2Si_ApproachI.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("PSO2_AB_2Si_ApproachII")) {
				try {
					PSO2_AB_2Si_ApproachII.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("CC-CLPSO2_AB_NNH")) {
				try {
					CC_CLPSO2_AB_NNH.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("CC-CLPSO2_AB_2Si_ApproachI")) {
				try {
					CC_CLPSO2_AB_2Si_ApproachI.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("CC-CLPSO2_AB_2Si_ApproachII")) {
				try {
					CC_CLPSO2_AB_2Si_ApproachII.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("DMSDL-PSO_AB_NNH")) {
				try {
					DMSDL_PSO2_AB_NNH.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("DMSDL-PSO_AB_2Si_ApproachI")) {
				try {
					DMSDL_PSO2_AB_2Si_ApproachI.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("DMSDL-PSO_AB_2Si_ApproachII")) {
				try {
					DMSDL_PSO2_AB_2Si_ApproachII.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("ALPSO2_NEW_PrematureConvegence1_AB_NNH")) {
				try {
					ALPSO2_NEW_PrematureConvegence1_AB_NNH.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("ALPSO2_NEW_PrematureConvegence1_AB_2Si_ApproachI")) {
				try {
					ALPSO2_NEW_PrematureConvegence1_AB_2Si_ApproachI.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("ALPSO2_NEW_PrematureConvegence1_AB_2Si_ApproachII")) {
				try {
					ALPSO2_NEW_PrematureConvegence1_AB_2Si_ApproachII.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("NSDE_AB_NNH")) {
				try {
					NSDE_AB_NNH.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("NSDE_AB_2Si_ApproachI")) {
				try {
					NSDE_AB_2Si_ApproachI.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("NSDE_AB_2Si_ApproachII")) {
				try {
					NSDE_AB_2Si_ApproachII.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("SaNSDE_AB_NNH")) {
				try {
					SaNSDE_AB_NNH.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("SaNSDE_AB_2Si_ApproachI")) {
				try {
					SaNSDE_AB_2Si_ApproachI.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("SaNSDE_AB_2Si_ApproachII")) {
				try {
					SaNSDE_AB_2Si_ApproachII.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("DynDE_AB_NNH")) {
				try {
					DynDE_AB_NNH.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("DynDE_AB_2Si_ApproachI")) {
				try {
					DynDE_AB_2Si_ApproachI.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("DynDE_AB_2Si_ApproachII")) {
				try {
					DynDE_AB_2Si_ApproachII.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("FA_AB_NNH")) {
				try {
					FA_AB_NNH.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("FA_AB_2Si_ApproachI")) {
				try {
					FA_AB_2Si_ApproachI.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("FA_AB_2Si_ApproachII")) {
				try {
					FA_AB_2Si_ApproachII.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("FA_PSO_AB_NNH")) {
				try {
					FA_PSO_AB_NNH.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("FA_PSO_AB_2Si_ApproachI")) {
				try {
					FA_PSO_AB_2Si_ApproachI.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("FA_PSO_AB_2Si_ApproachII")) {
				try {
					FA_PSO_AB_2Si_ApproachII.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			
			if (Algorithm.equals("Run_multi_Algorithm")) {
				
				int k;

				String fileName;

				fileName = "input\\";

				String[] filename;
				String CfileName, line, line1, line2, line3, DfileName;
				File f = new File(fileName);
				if (f.isDirectory()) {
					filename = f.list();
					System.out.println("開始讀檔...");

					for (k = 0; k < filename.length; k++) {
						// ---------------------
						CfileName = fileName + "\\" + filename[k] + "\\";
		    				System.out.println(CfileName);
		    			I_Set_Paths_for_Current_Simulation_Example.setfilename( filename[k]);
						I_Set_Paths_for_Current_Simulation_Example.Setpath(CfileName);
						
						for(int repeat=0;repeat<Select_multi_Algorithm.repeat();repeat++){
						
						for(int x=0;x<Select_multi_Algorithm.lst_Select_Algorithm2().size();x++){
							
							String method=Select_multi_Algorithm.lst_Select_Algorithm2().get(x);
							String Setpath="\\"+Select_multi_Algorithm.lst_Select_Algorithm2().get(x)+"\\";
							
						X_Select_Algorithm_Type_to_Solve_the_Problem.Setmethod(method);
						X_Select_Algorithm_Type_to_Solve_the_Problem.Setpath(Setpath);
						X_Select_Algorithm_Type_to_Solve_the_Problem.SetAdvance_bid(true);
					
							if (method.equals("CPLEX")) {
								try {
									CPLEX.main();
								} catch (IOException e1) {

									e1.printStackTrace();
								}
							}
							if (method.equals("GA1")) {
								try {
								GA1.main();
								//	Double_Action_GA1.main();
								} catch (IOException e1) {
									e1.printStackTrace();
								}
							}
							if (method.equals("GA2"))  {
								try {
									GA2.main();
								//	Double_Action_GA2.main();
								} catch (IOException e1) {
									e1.printStackTrace();
								}
							}
							if (method.equals("PSO1")) {
								try {
								//	Double_Action_PSO1.main();
									PSO1.main();
								} catch (IOException e1) {

									e1.printStackTrace();
								}
							}

							if (method.equals("PSO2")) {
							//	for(int i=0;i<10;i++){
								try {
										PSO2.main();
								} catch (IOException e1) {

									e1.printStackTrace();
								}
						//		}
							}
							if (method.equals("PSO3")) {
								try {
									PSO3.main();
								} catch (IOException e1) {
									e1.printStackTrace();
								}
							}
							if (method.equals("PSO4")) {
								try {
									PSO4.main();
								} catch (IOException e1) {
									e1.printStackTrace();
								}
							}
							if (method.equals("APSO1")) {
								try {
									APSO1.main();
								} catch (IOException e1) {

									e1.printStackTrace();
								}
							}
							if (method.equals("APSO2")) {
								try {
									APSO2.main();
								} catch (IOException e1) {

									e1.printStackTrace();
								}
							}
							if (method.equals("ALPSO")) {
								try {
									ALPSO.main();
								} catch (IOException e1) {
									e1.printStackTrace();
								}
							}
							if (method.equals("LRPSO")) {
								try {
									LRPSO.main();
								} catch (IOException e1) {
									e1.printStackTrace();
								}
							}
							if (method.equals("LR")) {
								try {
									LR.main();
								} catch (IOException e1) {
									e1.printStackTrace();
								}
							}
							if (method.equals("LR_and_PSO2")) {
								try {
									LR_and_PSO2.main();
								} catch (IOException e1) {
									e1.printStackTrace();
								}
							}
							if (method.equals("LR_and_PSO1")) {
								try {
									LR_and_PSO1.main();
								} catch (IOException e1) {
									e1.printStackTrace();
								}
							}
							if (method.equals("CCPSO2")) {
						//		for(int i=0;i<10;i++){
								try {
									CCPSO2.main();
								} catch (IOException e1) {
									e1.printStackTrace();
								}
						//		}
							}
							if (method.equals("PSO_LS")) {
								X_Select_Algorithm_Type_to_Solve_the_Problem.SetAdvance_bid(false);
						//		for(int i=0;i<10;i++){
								try {
									 PSO_LS.main();
								} catch (IOException e1) {
									e1.printStackTrace();
								}
							//	}
							}
							
							if (method.equals("PSO1_P")) {
								try {
								//	Double_Action_PSO1.main();
									PSO1_P.main();
								} catch (IOException e1) {

									e1.printStackTrace();
								}
							}

							if (method.equals("PSO2_P")) {
								try {
										PSO2_P.main();
								} catch (IOException e1) {

									e1.printStackTrace();
								}
							}
							if (method.equals("APSO1_P")) {
								try {
									APSO1_P.main();
								} catch (IOException e1) {

									e1.printStackTrace();
								}
							}
							if (method.equals("APSO2_P")) {
								try {
									APSO2_P.main();
								} catch (IOException e1) {

									e1.printStackTrace();
								}
							}
							if (method.equals("ALPSO_P")) {
								try {
									ALPSO_P.main();
								} catch (IOException e1) {
									e1.printStackTrace();
								}
							}
							if (method.equals("LRPSO_P")) {
								try {
									LRPSO_P.main();
								} catch (IOException e1) {
									e1.printStackTrace();
								}
							}
							if (method.equals("LR_and_PSO2_P")) {
								try {
									LR_and_PSO2_P.main();
								} catch (IOException e1) {
									e1.printStackTrace();
								}
							}
							if (method.equals("LR_and_PSO1_P")) {
								try {
									LR_and_PSO1_P.main();
								} catch (IOException e1) {
									e1.printStackTrace();
								}
							}
							if (method.equals("CCPSO2_P")) {
					//			for(int i=0;i<10;i++){
								try {
									CCPSO2_P.main();
								} catch (IOException e1) {
									e1.printStackTrace();
								}
					//			}
							}
							if (method.equals("DE_Carpool")) {
						//		for(int i=0;i<15;i++){
								try {
									DE.main();
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
						//		}
							}
							if (method.equals("DE_Carpool_strategy1")) {
						//		for(int i=0;i<15;i++){
								try {
									DE.main();
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
						//		}
							} 
							if (method.equals("DE_Carpool_strategy2")) {
						//		for(int i=0;i<15;i++){
								try {
									DE.main();
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
						//		}
							}
							if (method.equals("DE_Carpool_strategy3")) {
						//		for(int i=0;i<15;i++){
								try {
									DE.main();
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
						//		}
							}
							if (method.equals("DE_Carpool_strategy4")) {
						//		for(int i=0;i<15;i++){
								try {
									DE.main();
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
						//		}
							}
							if (method.equals("DE_Carpool_strategy5")) {
					//			for(int i=0;i<15;i++){
								try {
									DE.main();
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
					//			}
							}
							if (method.equals("DE_Carpool_strategy6")) {
					//			for(int i=0;i<15;i++){
								try {
									DE.main();
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
					//			}
							}
							if (method.equals("DE_Carpool_Real")) {
								try {
									DE_Real.main();
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								}
							if (method.equals("DE_Carpool_strategy1_Real")) {
								try {
									DE_Real.main();
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								}
							if (method.equals("DE_Carpool_strategy2_Real")) {
								try {
									DE_Real.main();
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								}
							if (method.equals("DE_Carpool_strategy3_Real")) {
								try {
									DE_Real.main();
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								}
							if (method.equals("DE_Carpool_strategy4_Real")) {
								try {
									DE_Real.main();
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								}
							if (method.equals("DE_Carpool_strategy5_Real") ) {
								try {
									DE_Real.main();
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								}
							if (method.equals("DE_Carpool_strategy6_Real") ) {
								try {
									DE_Real.main();
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								}
							if (method.equals("NSDE_Carpool")) {
								try {
									NSDE.main();
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								}
							if (method.equals("FA_PSO")) {
								try {
									FA_PSO.main();
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								}
							if (method.equals("FA")) {
								try {
									FA.main();
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								}
							if (method.equals("SaNSDE")) {
								try {
									SaNSDE.main();
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								}
							if (method.equals("DECC")) {
								try {
									DECC.main();
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								}
							if (method.equals("DE_Real_POP") || method.equals("DE_strategy1_Real_POP")  || method.equals("DE_strategy2_Real_POP")
									 || method.equals("DE_strategy3_Real_POP")  || method.equals("DE_strategy4_Real_POP")  || method.equals("DE_strategy5_Real_POP")
									 || method.equals("DE_strategy6_Real_POP") ) {
								try {
									DE_Real_POP.main();
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								}
							if (method.equals("NSDE_POP") ) {
								 
								try {
										NSDE_POP.main();
								} catch (IOException e1) {
									e1.printStackTrace();
								}
							}
							if (method.equals("SaNSDE_POP") ) {
								 
								try {
										SaNSDE_POP.main();
								} catch (IOException e1) {
									e1.printStackTrace();
								}
							}
							if (method.equals("DECC_POP") ) {
								 
								try {
										DECC_POP.main();
								} catch (IOException e1) {
									e1.printStackTrace();
								}
							}
							if (method.equals("DE_Real_POP_NEW") || method.equals("DE_strategy1_Real_POP_NEW")  || method.equals("DE_strategy2_Real_POP_NEW")
									 || method.equals("DE_strategy3_Real_POP_NEW")  || method.equals("DE_strategy4_Real_POP_NEW")  || method.equals("DE_strategy5_Real_POP_NEW")
									 || method.equals("DE_strategy6_Real_POP_NEW") ) {
								try {
									DE_Real_POP_NEW.main();
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								}
							if (method.equals("NSDE_POP_NEW") ) {
								 
								try {
										NSDE_POP_NEW.main();
								} catch (IOException e1) {
									e1.printStackTrace();
								}
							}
							if (method.equals("SaNSDE_POP_NEW") ) {
								 
								try {
										SaNSDE_POP_NEW.main();
								} catch (IOException e1) {
									e1.printStackTrace();
								}
							}
							if (method.equals("DECC_POP_NEW") ) {
								 
								try {
										DECC_POP_NEW.main();
								} catch (IOException e1) {
									e1.printStackTrace();
								}
							}
							if (method.equals("PSO_LS_WaitingTime")) {
								X_Select_Algorithm_Type_to_Solve_the_Problem.SetAdvance_bid(false);
								try {
									PSO_LS_WaitingTime.main();
								} catch (IOException e1) {
									e1.printStackTrace();
								}
							}
							if (method.equals("PSO_LS_SetBased")) {
								X_Select_Algorithm_Type_to_Solve_the_Problem.SetAdvance_bid(false);
								try {
									PSO_LS_SetBased.main();
								} catch (IOException e1) {
									e1.printStackTrace();
								}
							}
							if (method.equals("DMS-L-PSO") ) {
								 
								try {
									DMS_L_PSO2.main();
								} catch (IOException e1) {
									e1.printStackTrace();
								}
							}
							if (method.equals("DMSDL-PSO") ) {
								 
								try {
									DMSDL_PSO2.main();
								} catch (IOException e1) {
									e1.printStackTrace();
								}
							}
							if (method.equals("ALPSO2_NEW") ) {
								 
								try {
									ALPSO2_NEW.main();
								} catch (IOException e1) {
									e1.printStackTrace();
								}
							}
							if (method.equals("ALPSO2_NEW_PrematureConvegence1") ) {
								 
								try {
									ALPSO2_NEW_PrematureConvegence1.main();
								} catch (IOException e1) {
									e1.printStackTrace();
								}
							}
							if (method.equals("NLPSO2") ) {
								 
								try {
									NLPSO2.main();
								} catch (IOException e1) {
									e1.printStackTrace();
								}
							}
							if (method.equals("DynDE") ) {
								 
								try {
									DynDE.main();
								} catch (IOException e1) {
									e1.printStackTrace();
								}
							}
							if (method.equals("DynDE_POP") ) {
								 
								try {
									DynDE_POP.main();
								} catch (IOException e1) {
									e1.printStackTrace();
								}
							}
							if (method.equals("CLPSO2") ) {
								 
								try {
									CLPSO2.main();
								} catch (IOException e1) {
									e1.printStackTrace();
								}
							}
							if (method.equals("CC-CLPSO2") ) {
								 
								try {
									CC_CLPSO2.main();
								} catch (IOException e1) {
									e1.printStackTrace();
								}
							}
							if (method.equals("L-SHADE") ) {
								 
								try {
									L_SHADE.main();
								} catch (IOException e1) {
									e1.printStackTrace();
								}
							}
							if (method.equals("L_SHADE_CCPSO2") ) {
								 
								try {
									L_SHADE_CCPSO2.main();
								} catch (IOException e1) {
									e1.printStackTrace();
								}
							}
							if (method.equals("DE_Real_AB_NNH")|| method.equals("DE_Real_strategy1_AB_NNH")
									|| method.equals("DE_Real_strategy2_AB_NNH") || method.equals("DE_Real_strategy3_AB_NNH")
									|| method.equals("DE_Real_strategy4_AB_NNH") || method.equals("DE_Real_strategy5_AB_NNH")
									|| method.equals("DE_Real_strategy6_AB_NNH")) {
								X_Select_Algorithm_Type_to_Solve_the_Problem.SetAdvance_bid(false);
										try {
											DE_Real_AB_NNH.main();
										} catch (IOException e1) {
											e1.printStackTrace();
										}
									}
							if (method.equals("DE_Real_AB_2Si_ApproachI") ) {
								X_Select_Algorithm_Type_to_Solve_the_Problem.SetAdvance_bid(false);
								try {
									DE_Real_AB_2Si_ApproachI.main();
								} catch (IOException e1) {
									e1.printStackTrace();
								}
							}
							if (method.equals("DE_Real_AB_2Si_ApproachII") ) {
								X_Select_Algorithm_Type_to_Solve_the_Problem.SetAdvance_bid(false);
								try {
									DE_Real_AB_2Si_ApproachII.main();
								} catch (IOException e1) {
									e1.printStackTrace();
								}
							}
							if (method.equals("CCPSO2_AB_NNH") ) {
								X_Select_Algorithm_Type_to_Solve_the_Problem.SetAdvance_bid(false);
								try {
									CCPSO2_AB_NNH.main();
								} catch (IOException e1) {
									e1.printStackTrace();
								}
							}
							if (method.equals("CCPSO2_AB_2Si_ApproachI") ) {
								X_Select_Algorithm_Type_to_Solve_the_Problem.SetAdvance_bid(false);
								try {
									CCPSO2_AB_2Si_ApproachI.main();
								} catch (IOException e1) {
									e1.printStackTrace();
								}
							}
							if (method.equals("CCPSO2_AB_2Si_ApproachII") ) {
								X_Select_Algorithm_Type_to_Solve_the_Problem.SetAdvance_bid(false);
								try {
									CCPSO2_AB_2Si_ApproachII.main();
								} catch (IOException e1) {
									e1.printStackTrace();
								}
							}
							if (method.equals("PSO2_AB_NNH") ) {
								X_Select_Algorithm_Type_to_Solve_the_Problem.SetAdvance_bid(false);
								try {
									PSO2_AB_NNH.main();
								} catch (IOException e1) {
									e1.printStackTrace();
								}
							}
							if (method.equals("PSO2_AB_2Si_ApproachI") ) {
								X_Select_Algorithm_Type_to_Solve_the_Problem.SetAdvance_bid(false);
								try {
									PSO2_AB_2Si_ApproachI.main();
								} catch (IOException e1) {
									e1.printStackTrace();
								}
							}
							if (method.equals("PSO2_AB_2Si_ApproachII") ) {
								X_Select_Algorithm_Type_to_Solve_the_Problem.SetAdvance_bid(false);
								try {
									PSO2_AB_2Si_ApproachII.main();
								} catch (IOException e1) {
									e1.printStackTrace();
								}
							}
							if (method.equals("CC-CLPSO2_AB_NNH")) {
								X_Select_Algorithm_Type_to_Solve_the_Problem.SetAdvance_bid(false);
								try {
									CC_CLPSO2_AB_NNH.main();
								} catch (IOException e1) {
									e1.printStackTrace();
								}
							}
							if (method.equals("CC-CLPSO2_AB_2Si_ApproachI")) {
								X_Select_Algorithm_Type_to_Solve_the_Problem.SetAdvance_bid(false);
								try {
									CC_CLPSO2_AB_2Si_ApproachI.main();
								} catch (IOException e1) {
									e1.printStackTrace();
								}
							}
							if (method.equals("CC-CLPSO2_AB_2Si_ApproachII")) {
								X_Select_Algorithm_Type_to_Solve_the_Problem.SetAdvance_bid(false);
								try {
									CC_CLPSO2_AB_2Si_ApproachII.main();
								} catch (IOException e1) {
									e1.printStackTrace();
								}
							}
							if (method.equals("DMSDL-PSO_AB_NNH")) {
								X_Select_Algorithm_Type_to_Solve_the_Problem.SetAdvance_bid(false);
								try {
									DMSDL_PSO2_AB_NNH.main();
								} catch (IOException e1) {
									e1.printStackTrace();
								}
							}
							if (method.equals("DMSDL-PSO_AB_2Si_ApproachI")) {
								X_Select_Algorithm_Type_to_Solve_the_Problem.SetAdvance_bid(false);
								try {
									DMSDL_PSO2_AB_2Si_ApproachI.main();
								} catch (IOException e1) {
									e1.printStackTrace();
								}
							}
							if (method.equals("DMSDL-PSO_AB_2Si_ApproachII")) {
								X_Select_Algorithm_Type_to_Solve_the_Problem.SetAdvance_bid(false);
								try {
									DMSDL_PSO2_AB_2Si_ApproachII.main();
								} catch (IOException e1) {
									e1.printStackTrace();
								}
							}
							if (method.equals("ALPSO2_NEW_PrematureConvegence1_AB_NNH")) {
								X_Select_Algorithm_Type_to_Solve_the_Problem.SetAdvance_bid(false);
								try {
									ALPSO2_NEW_PrematureConvegence1_AB_NNH.main();
								} catch (IOException e1) {
									e1.printStackTrace();
								}
							}
							if (method.equals("ALPSO2_NEW_PrematureConvegence1_AB_2Si_ApproachI")) {
								X_Select_Algorithm_Type_to_Solve_the_Problem.SetAdvance_bid(false);
								try {
									ALPSO2_NEW_PrematureConvegence1_AB_2Si_ApproachI.main();
								} catch (IOException e1) {
									e1.printStackTrace();
								}
							}
							if (method.equals("ALPSO2_NEW_PrematureConvegence1_AB_2Si_ApproachII")) {
								X_Select_Algorithm_Type_to_Solve_the_Problem.SetAdvance_bid(false);
								try {
									ALPSO2_NEW_PrematureConvegence1_AB_2Si_ApproachII.main();
								} catch (IOException e1) {
									e1.printStackTrace();
								}
							}
							if (method.equals("NSDE_AB_NNH")) {
								X_Select_Algorithm_Type_to_Solve_the_Problem.SetAdvance_bid(false);
								try {
									NSDE_AB_NNH.main();
								} catch (IOException e1) {
									e1.printStackTrace();
								}
							}
							if (method.equals("NSDE_AB_2Si_ApproachI")) {
								X_Select_Algorithm_Type_to_Solve_the_Problem.SetAdvance_bid(false);
								try {
									NSDE_AB_2Si_ApproachI.main();
								} catch (IOException e1) {
									e1.printStackTrace();
								}
							}
							if (method.equals("NSDE_AB_2Si_ApproachII")) {
								X_Select_Algorithm_Type_to_Solve_the_Problem.SetAdvance_bid(false);
								try {
									NSDE_AB_2Si_ApproachII.main();
								} catch (IOException e1) {
									e1.printStackTrace();
								}
							}
							if (method.equals("SaNSDE_AB_NNH")) {
								X_Select_Algorithm_Type_to_Solve_the_Problem.SetAdvance_bid(false);
								try {
									SaNSDE_AB_NNH.main();
								} catch (IOException e1) {
									e1.printStackTrace();
								}
							}
							if (method.equals("SaNSDE_AB_2Si_ApproachI")) {
								X_Select_Algorithm_Type_to_Solve_the_Problem.SetAdvance_bid(false);
								try {
									SaNSDE_AB_2Si_ApproachI.main();
								} catch (IOException e1) {
									e1.printStackTrace();
								}
							}
							if (method.equals("SaNSDE_AB_2Si_ApproachII")) {
								X_Select_Algorithm_Type_to_Solve_the_Problem.SetAdvance_bid(false);
								try {
									SaNSDE_AB_2Si_ApproachII.main();
								} catch (IOException e1) {
									e1.printStackTrace();
								}
							}
							if (method.equals("DynDE_AB_NNH")) {
								X_Select_Algorithm_Type_to_Solve_the_Problem.SetAdvance_bid(false);
								try {
									DynDE_AB_NNH.main();
								} catch (IOException e1) {
									e1.printStackTrace();
								}
							}
							if (method.equals("DynDE_AB_2Si_ApproachI")) {
								X_Select_Algorithm_Type_to_Solve_the_Problem.SetAdvance_bid(false);
								try {
									DynDE_AB_2Si_ApproachI.main();
								} catch (IOException e1) {
									e1.printStackTrace();
								}
							}
							if (method.equals("DynDE_AB_2Si_ApproachII")) {
								X_Select_Algorithm_Type_to_Solve_the_Problem.SetAdvance_bid(false);
								try {
									DynDE_AB_2Si_ApproachII.main();
								} catch (IOException e1) {
									e1.printStackTrace();
								}
							}
							if (method.equals("FA_AB_NNH")) {
								X_Select_Algorithm_Type_to_Solve_the_Problem.SetAdvance_bid(false);
								try {
									FA_AB_NNH.main();
								} catch (IOException e1) {
									e1.printStackTrace();
								}
							}
							if (method.equals("FA_AB_2Si_ApproachI")) {
								X_Select_Algorithm_Type_to_Solve_the_Problem.SetAdvance_bid(false);
								try {
									FA_AB_2Si_ApproachI.main();
								} catch (IOException e1) {
									e1.printStackTrace();
								}
							}
							if (method.equals("FA_AB_2Si_ApproachII")) {
								X_Select_Algorithm_Type_to_Solve_the_Problem.SetAdvance_bid(false);
								try {
									FA_AB_2Si_ApproachII.main();
								} catch (IOException e1) {
									e1.printStackTrace();
								}
							}
							if (method.equals("FA_PSO_AB_NNH")) {
								X_Select_Algorithm_Type_to_Solve_the_Problem.SetAdvance_bid(false);
								try {
									FA_PSO_AB_NNH.main();
								} catch (IOException e1) {
									e1.printStackTrace();
								}
							}
							if (method.equals("FA_PSO_AB_2Si_ApproachI")) {
								X_Select_Algorithm_Type_to_Solve_the_Problem.SetAdvance_bid(false);
								try {
									FA_PSO_AB_2Si_ApproachI.main();
								} catch (IOException e1) {
									e1.printStackTrace();
								}
							}
							if (method.equals("FA_PSO_AB_2Si_ApproachII")) {
								X_Select_Algorithm_Type_to_Solve_the_Problem.SetAdvance_bid(false);
								try {
									FA_PSO_AB_2Si_ApproachII.main();
								} catch (IOException e1) {
									e1.printStackTrace();
								}
							}
							
								try {
									carpool_results_test.main();
								} catch (Exception e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
						}	
					 }
					}
				}
			}
			
		}
		if (btn == btn2) {
			if (GUI.main.getmethod() != 2) {
				try {
					carpool_results_test.main();
				} catch (Exception e1) {

					e1.printStackTrace();
				}
			} else if (GUI.main.getmethod() == 2) {
				check_batch_TXT.main();
			}
		}
		if (btn == btn3) {
			frm.setVisible(false);
		}
	}
}