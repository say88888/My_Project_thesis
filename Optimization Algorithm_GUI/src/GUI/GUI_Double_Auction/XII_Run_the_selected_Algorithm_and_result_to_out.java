package GUI.GUI_Double_Auction;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;

import Algorithm_DoubleAuction.ALPSO2_NEW_DA.ALPSO2_NEW;
import Algorithm_DoubleAuction.ALPSO2_NEW_PrematureConvegence1_DA.ALPSO2_NEW_PrematureConvegence1;
import Algorithm_DoubleAuction.CCPSO2_DA.Double_Auction_CCPSO2;
import Algorithm_DoubleAuction.CCPSO2_P_DA.Double_Auction_CCPSO2_P;
import Algorithm_DoubleAuction.CCPSO2_Tanh_DA.Double_Auction_CCPSO2_Tanh;
import Algorithm_DoubleAuction.CC_CLPSO2_DA.Double_Auction_CC_CLPSO2;
import Algorithm_DoubleAuction.CLPSO2_DA.Double_Auction_CLPSO2;
import Algorithm_DoubleAuction.DECC_DA.Double_Auction_DECC;
import Algorithm_DoubleAuction.DECC_POP_DA.Double_Auction_DECC_POP;
import Algorithm_DoubleAuction.DECC_POP_NEW_DA.Double_Auction_DECC_POP_NEW;
import Algorithm_DoubleAuction.DE_DA.Double_Auction_DE;
import Algorithm_DoubleAuction.DE_DA_Porblem3.Double_Auction_DE_Problem3;
import Algorithm_DoubleAuction.DE_Real_DA.Double_Auction_DE_Real;
import Algorithm_DoubleAuction.DE_Real_DA_Problem3.Double_Auction_DE_Real_Problem3;
import Algorithm_DoubleAuction.DE_Real_POP_DA.Double_Auction_DE_Real_POP;
import Algorithm_DoubleAuction.DE_Real_POP_DA_Problem3.Double_Auction_DE_Real_POP_Problem3;
import Algorithm_DoubleAuction.DE_Real_POP_NEW_DA.Double_Auction_DE_Real_POP_NEW;
import Algorithm_DoubleAuction.DMSDL_PSO2_DA.DMSDL_PSO2;
import Algorithm_DoubleAuction.DMS_L_PSO2_DA.DMS_L_PSO2;
import Algorithm_DoubleAuction.DynDE_DA.DynDE;
import Algorithm_DoubleAuction.DynDE_POP_DA.DynDE_POP;
import Algorithm_DoubleAuction.FA_DA.Double_Auction_FA;
import Algorithm_DoubleAuction.FA_PSO_DA.Double_Auction_FA_PSO;
import Algorithm_DoubleAuction.GA1_DA.Double_Auction_GA1;
import Algorithm_DoubleAuction.GA2_DA.Double_Auction_GA2;
import Algorithm_DoubleAuction.Heuristic_PSO_DA.Heuristic_PSO_DA;
import Algorithm_DoubleAuction.L_SHADE_CCPSO2_DA.Double_Auction_L_SHADE_CCPSO2;
import Algorithm_DoubleAuction.L_SHADE_DA.Double_Auction_L_SHADE;
import Algorithm_DoubleAuction.Lagrangain_Relaxation_DA.Double_Auction_LR;
import Algorithm_DoubleAuction.Lagrangian_PSO_DA.Double_Auction_ALPSO;
import Algorithm_DoubleAuction.Lagrangian_PSO_P_DA.Double_Auction_ALPSO_P;
import Algorithm_DoubleAuction.Lagrangian_PSO_Tanh_DA.Double_Auction_ALPSO_Tanh;
import Algorithm_DoubleAuction.Lagrangian_Relaxation_PSO_DA.Double_Auction_LRPSO;
import Algorithm_DoubleAuction.Lagrangian_Relaxation_PSO_P_DA.Double_Auction_LRPSO_P;
import Algorithm_DoubleAuction.Lagrangian_Relaxation_PSO_Tanh_DA.Double_Auction_LRPSO_Tanh;
import Algorithm_DoubleAuction.Lagrangian_Relaxation_and_PSO1_DA.Double_Auction_LR_and_PSO1;
import Algorithm_DoubleAuction.Lagrangian_Relaxation_and_PSO1_P_DA.Double_Auction_LR_and_PSO1_P;
import Algorithm_DoubleAuction.Lagrangian_Relaxation_and_PSO1_Tanh_DA.Double_Auction_LR_and_PSO1_Tanh;
import Algorithm_DoubleAuction.Lagrangian_Relaxation_and_PSO2_DA.Double_Auction_LR_and_PSO2;
import Algorithm_DoubleAuction.Lagrangian_Relaxation_and_PSO2_P_DA.Double_Auction_LR_and_PSO2_P;
import Algorithm_DoubleAuction.Lagrangian_Relaxation_and_PSO2_Tanh_DA.Double_Auction_LR_and_PSO2_Tanh;
import Algorithm_DoubleAuction.NLPSO2_DA.NLPSO2;
import Algorithm_DoubleAuction.NSDE_DA.Double_Auction_NSDE;
import Algorithm_DoubleAuction.NSDE_DA_Problem3.Double_Auction_NSDE_Problem3;
import Algorithm_DoubleAuction.NSDE_POP_DA.Double_Auction_NSDE_POP;
import Algorithm_DoubleAuction.NSDE_POP_NEW_DA.Double_Auction_NSDE_POP_NEW;
import Algorithm_DoubleAuction.PSO1_DA.Double_Auction_PSO1;
import Algorithm_DoubleAuction.PSO1_P_DA.Double_Auction_PSO1_P;
import Algorithm_DoubleAuction.PSO1_Tanh_DA.Double_Auction_PSO1_Tanh;
import Algorithm_DoubleAuction.PSO2_DA.Double_Auction_PSO2;
import Algorithm_DoubleAuction.PSO2_P_DA.Double_Auction_PSO2_P;
import Algorithm_DoubleAuction.PSO2_Tanh_DA.Double_Auction_PSO2_Tanh;
import Algorithm_DoubleAuction.PSO_TS_DA.PSO_TS_DA;
import Algorithm_DoubleAuction.SaNSDE_DA.Double_Auction_SaNSDE;
import Algorithm_DoubleAuction.SaNSDE_DA_Problem3.Double_Auction_SaNSDE_Problem3;
import Algorithm_DoubleAuction.SaNSDE_POP_DA.Double_Auction_SaNSDE_POP;
import Algorithm_DoubleAuction.SaNSDE_POP_NEW_DA.Double_Auction_SaNSDE_POP_NEW;
import Algorithm_DoubleAuction.TS_DA.TS_DA;
import Cplex.CPLEX_DA;
import Cplex.CPLEX_DA_Problem3;
import Cplex.CPLEX_Vector_DA;
import GUI.I_Set_Paths_for_Current_Simulation_Example;
import Result_DoubleAuction.Allocate_surplus;

public class XII_Run_the_selected_Algorithm_and_result_to_out extends Double_Auction
		implements ActionListener {

	JFrame frm = new JFrame();

	JButton btn1 = new JButton("Run_the_selected_Algorithm");
	JButton btn2 = new JButton("result to out");
	JButton btn3 = new JButton("Exit");
	JButton btn4 = new JButton("Set_Alpha");

	XII_Run_the_selected_Algorithm_and_result_to_out() {

		frm.setSize(400, 400); // 設定視窗的大小為 200*150
		frm.setLocation(400, 50); // 設定視窗位置為(100,50)

		frm.setTitle("XII_Run_the_selected_Algorithm_and_result_to_out");
		frm.setLayout(null);

		btn1.setBounds(60, 50, 200, 40);
		btn1.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
		frm.add(btn1);
		btn1.addActionListener(this);

		btn4.setBounds(60, 130, 200, 40);
		btn4.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
		frm.add(btn4);
		btn4.addActionListener(this);

		btn2.setBounds(60, 210, 200, 40);
		btn2.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
		frm.add(btn2);
		btn2.addActionListener(this);

		btn3.setBounds(60, 290, 200, 40);
		btn3.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
		frm.add(btn3);
		btn3.addActionListener(this);

		// frm.remove(btn2);
		frm.setVisible(true); // 設定視窗為可見
	}

	public static void main() {

		new XII_Run_the_selected_Algorithm_and_result_to_out();
	}

	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		if (btn == btn1) {
			if (Algorithm.equals("CPLEX")) {
				try {
					CPLEX_DA.main();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("GA1")) {
				try {
					Double_Auction_GA1.main();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("GA2")) {
				try {
					Double_Auction_GA2.main();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("PSO1")) {
				try {
					Double_Auction_PSO1.main();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("PSO2")) {

				try {
					Double_Auction_PSO2.main();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
			if (Algorithm.equals("ALPSO")) {
				try {
					Double_Auction_ALPSO.main();
				} catch (IOException e1) {

					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("LRPSO")) {
				try {

					Double_Auction_LRPSO.main();
				} catch (IOException e1) {

					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("LR")) {
				try {
					Double_Auction_LR.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("LR_and_PSO2")) {
				try {
					// LAPSO.main();
					Double_Auction_LR_and_PSO2.main();
				} catch (IOException e1) {

					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("LR_and_PSO1")) {
				try {
					// LAPSO.main();
					Double_Auction_LR_and_PSO1.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("CCPSO2")) {

				try {

					/*
					 * int k; String fileName; fileName = "input\\"; String[]
					 * filename, Pfilename, Dfilename; String CfileName, line,
					 * line1, line2, line3, DfileName;
					 * 
					 * File f = new File(fileName); if (f.isDirectory()) {
					 * filename = f.list(); System.out.println("開始讀檔...");
					 * 
					 * for (k = 0; k < filename.length; k++) { //
					 * --------------------- CfileName = fileName + "\\" +
					 * filename[k] + "\\"; System.out.println(CfileName);
					 * I_Set_Paths_for_Current_Simulation_Example
					 * .Setpath(CfileName);
					 * I_Set_Paths_for_Current_Simulation_Example
					 * .setfilename(filename[k]); Double_Auction_CCPSO2.main();
					 * 
					 * // } } } else { System.out.println("Error 目錄錯誤"); }
					 */
					Double_Auction_CCPSO2.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}
			if (Algorithm.equals("CPLEX_LP")) {
				try {
					CPLEX_Vector_DA.main();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("TS_DA")) {
				try {
					TS_DA.main();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("DE_DA")) {

				try {

					Double_Auction_DE.main();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
			if (Algorithm.equals("DE_DA_strategy1")) {

				try {
					Double_Auction_DE.main();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
			if (Algorithm.equals("DE_DA_strategy2")) {

				try {
					Double_Auction_DE.main();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
			if (Algorithm.equals("DE_DA_strategy3")) {

				try {
					Double_Auction_DE.main();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
			if (Algorithm.equals("DE_DA_strategy4")) {

				try {
					Double_Auction_DE.main();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
			if (Algorithm.equals("DE_DA_strategy5")) {

				try {
					Double_Auction_DE.main();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
			if (Algorithm.equals("DE_DA_strategy6")) {

				try {
					Double_Auction_DE.main();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
			if (Algorithm.equals("DE_DA_Real")) {

				try {
					Double_Auction_DE_Real.main();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
			if (Algorithm.equals("DE_DA_strategy1_Real")) {

				try {
					Double_Auction_DE_Real.main();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
			if (Algorithm.equals("DE_DA_strategy2_Real")) {

				try {
					Double_Auction_DE_Real.main();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
			if (Algorithm.equals("DE_DA_strategy3_Real")) {

				try {
					Double_Auction_DE_Real.main();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
			if (Algorithm.equals("DE_DA_strategy4_Real")) {

				try {
					Double_Auction_DE_Real.main();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
			if (Algorithm.equals("DE_DA_strategy5_Real")) {

				try {
					Double_Auction_DE_Real.main();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
			if (Algorithm.equals("DE_DA_strategy6_Real")) {

				try {
					Double_Auction_DE_Real.main();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

			if (Algorithm.equals("PSO_TS_DA")) {
				try {
					PSO_TS_DA.main();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("Heuristic_PSO")) {
				try {
					Heuristic_PSO_DA.main();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("PSO1_P")) {
				try {
					Double_Auction_PSO1_P.main();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("PSO2_P")) {
				try {
					Double_Auction_PSO2_P.main();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("ALPSO_P")) {
				try {
					Double_Auction_ALPSO_P.main();
				} catch (IOException e1) {

					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("LRPSO_P")) {
				try {

					Double_Auction_LRPSO_P.main();
				} catch (IOException e1) {

					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("LR_and_PSO2_P")) {
				try {
					// LAPSO.main();
					Double_Auction_LR_and_PSO2_P.main();
				} catch (IOException e1) {

					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("LR_and_PSO1_P")) {
				try {
					// LAPSO.main();
					Double_Auction_LR_and_PSO1_P.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("CCPSO2_P")) {
				try {
					Double_Auction_CCPSO2_P.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}

			if (Algorithm.equals("PSO1_Tanh")) {
				try {
					Double_Auction_PSO1_Tanh.main();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("PSO2_Tanh")) {
				try {
					Double_Auction_PSO2_Tanh.main();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("ALPSO_Tanh")) {
				try {
					Double_Auction_ALPSO_Tanh.main();
				} catch (IOException e1) {

					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("LRPSO_Tanh")) {
				try {

					Double_Auction_LRPSO_Tanh.main();
				} catch (IOException e1) {

					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("LR_and_PSO2_Tanh")) {
				try {
					// LAPSO.main();
					Double_Auction_LR_and_PSO2_Tanh.main();
				} catch (IOException e1) {

					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("LR_and_PSO1_Tanh")) {
				try {
					// LAPSO.main();
					Double_Auction_LR_and_PSO1_Tanh.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("CCPSO2_Tanh")) {
				try {
					Double_Auction_CCPSO2_Tanh.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("FA_PSO")) {
				try {
					Double_Auction_FA_PSO.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("FA")) {

				try {
					Double_Auction_FA.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}

			if (Algorithm.equals("NSDE")) {

				try {
					Double_Auction_NSDE.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("SaNSDE")) {

				try {

					Double_Auction_SaNSDE.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("DECC")) {

				try {

					Double_Auction_DECC.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("DE_DA_Real_POP") || Algorithm.equals("DE_DA_strategy1_Real_POP") || Algorithm.equals("DE_DA_strategy2_Real_POP")
					|| Algorithm.equals("DE_DA_strategy3_Real_POP")	|| Algorithm.equals("DE_DA_strategy4_Real_POP") 
					|| Algorithm.equals("DE_DA_strategy5_Real_POP")  || Algorithm.equals("DE_DA_strategy6_Real_POP") ) {
				try {
					Double_Auction_DE_Real_POP.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("NSDE_POP")) {

				try {
					Double_Auction_NSDE_POP.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("SaNSDE_POP")) {

				try {
					Double_Auction_SaNSDE_POP.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("DECC_POP")) {

				try {
					Double_Auction_DECC_POP.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("DE_Real_POP_NEW") || Algorithm.equals("DE_strategy1_Real_POP_NEW")
					|| Algorithm.equals("DE_strategy2_Real_POP_NEW") || Algorithm.equals("DE_strategy3_Real_POP_NEW")
					|| Algorithm.equals("DE_strategy4_Real_POP_NEW") || Algorithm.equals("DE_strategy5_Real_POP_NEW")
					|| Algorithm.equals("DE_strategy6_Real_POP_NEW")) {
				try {
					Double_Auction_DE_Real_POP_NEW.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("NSDE_POP_NEW")) {

				try {
					Double_Auction_NSDE_POP_NEW.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("SaNSDE_POP_NEW")) {

				try {
					Double_Auction_SaNSDE_POP_NEW.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("DECC_POP_NEW")) {

				try {
					Double_Auction_DECC_POP_NEW.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("CPLEX")) {

				try {
					CPLEX_DA_Problem3.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("DE_DA_Real_Problem3")) {

				try {
					Double_Auction_DE_Real_Problem3.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("DE_DA_Real_POP_Problem3")) {

				try {
					Double_Auction_DE_Real_POP_Problem3.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("NSDE_Problem3")) {

				try {
					Double_Auction_NSDE_Problem3.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("SaNSDE_Problem3")) {

				try {
					Double_Auction_SaNSDE_Problem3.main();
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
					Double_Auction_CLPSO2.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("CC-CLPSO2")) {

				try {
					Double_Auction_CC_CLPSO2.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("L-SHADE")) {

				try {
					Double_Auction_L_SHADE.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("L_SHADE_CCPSO2")) {

				try {
					Double_Auction_L_SHADE_CCPSO2.main();
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
						I_Set_Paths_for_Current_Simulation_Example.setfilename(filename[k]);
						I_Set_Paths_for_Current_Simulation_Example.Setpath(CfileName);

						for (int repeat = 0; repeat < Select_multi_Algorithm.repeat(); repeat++) {

							for (int x = 0; x < Select_multi_Algorithm.lst_Select_Algorithm2().size(); x++) {

								String method = Select_multi_Algorithm.lst_Select_Algorithm2().get(x);
								String Setpath = "\\" + Select_multi_Algorithm.lst_Select_Algorithm2().get(x) + "\\";

								X_Select_Algorithm_Type_to_Solve_the_Problem.Setmethod(method);
								X_Select_Algorithm_Type_to_Solve_the_Problem.Setpath(Setpath);

								if (method.equals("CPLEX")) {
									try {
										CPLEX_DA.main();
									} catch (IOException e1) {

										e1.printStackTrace();
									}
								}
								if (method.equals("GA1")) {
									try {
										Double_Auction_GA1.main();
										// Double_Action_GA1.main();
									} catch (IOException e1) {
										e1.printStackTrace();
									}
								}
								if (method.equals("GA2")) {
									try {
										Double_Auction_GA2.main();
										// Double_Action_GA2.main();
									} catch (IOException e1) {
										e1.printStackTrace();
									}
								}
								if (method.equals("PSO1")) {
									try {
										// Double_Action_PSO1.main();
										Double_Auction_PSO1.main();
									} catch (IOException e1) {

										e1.printStackTrace();
									}
								}

								if (method.equals("PSO2")) {
									// for(int i=0;i<10;i++){
									try {
										Double_Auction_PSO2.main();
									} catch (IOException e1) {

										e1.printStackTrace();
									}
									// }
								}
								if (method.equals("ALPSO")) {
									try {
										Double_Auction_ALPSO.main();
									} catch (IOException e1) {
										e1.printStackTrace();
									}
								}
								if (method.equals("LRPSO")) {
									try {
										Double_Auction_LRPSO.main();
									} catch (IOException e1) {
										e1.printStackTrace();
									}
								}
								if (method.equals("LR")) {
									try {
										Double_Auction_LR.main();
									} catch (IOException e1) {
										e1.printStackTrace();
									}
								}
								if (method.equals("LR_and_PSO2")) {
									try {
										Double_Auction_LR_and_PSO2.main();
									} catch (IOException e1) {
										e1.printStackTrace();
									}
								}
								if (method.equals("LR_and_PSO1")) {
									try {
										Double_Auction_LR_and_PSO1.main();
									} catch (IOException e1) {
										e1.printStackTrace();
									}
								}
								if (method.equals("CCPSO2")) {
									// for(int i=0;i<10;i++){
									try {
										Double_Auction_CCPSO2.main();
									} catch (IOException e1) {
										e1.printStackTrace();
									}
									// }
								}
								if (method.equals("CPLEX_LP")) {
									// for(int i=0;i<10;i++){
									try {
										CPLEX_Vector_DA.main();
									} catch (IOException e1) {
										e1.printStackTrace();
									}
									// }
								}
								if (method.equals("TS_DA")) {
									// for(int i=0;i<10;i++){
									try {
										TS_DA.main();
									} catch (IOException e1) {
										e1.printStackTrace();
									}
									// }
								}
								if (method.equals("PSO_TS_DA")) {
									// for(int i=0;i<10;i++){
									try {
										PSO_TS_DA.main();
									} catch (IOException e1) {
										e1.printStackTrace();
									}
									// }
								}
								if (method.equals("Heuristic_PSO")) {
									// for(int i=0;i<10;i++){
									try {
										Heuristic_PSO_DA.main();
									} catch (IOException e1) {
										e1.printStackTrace();
									}
									// }
								}
								if (method.equals("PSO1_P")) {
									try {
										// Double_Action_PSO1.main();
										Double_Auction_PSO1_P.main();
									} catch (IOException e1) {

										e1.printStackTrace();
									}
								}

								if (method.equals("PSO2_P")) {
									try {
										Double_Auction_PSO2_P.main();
									} catch (IOException e1) {

										e1.printStackTrace();
									}
								}
								if (method.equals("ALPSO_P")) {
									try {
										Double_Auction_ALPSO_P.main();
									} catch (IOException e1) {
										e1.printStackTrace();
									}
								}
								if (method.equals("LRPSO_P")) {
									try {
										Double_Auction_LRPSO_P.main();
									} catch (IOException e1) {
										e1.printStackTrace();
									}
								}
								if (method.equals("LR_and_PSO2_P")) {
									try {
										Double_Auction_LR_and_PSO2_P.main();
									} catch (IOException e1) {
										e1.printStackTrace();
									}
								}
								if (method.equals("LR_and_PSO1_P")) {
									try {
										Double_Auction_LR_and_PSO1_P.main();
									} catch (IOException e1) {
										e1.printStackTrace();
									}
								}
								if (method.equals("CCPSO2_P")) {
									// for(int i=0;i<10;i++){
									try {
										Double_Auction_CCPSO2_P.main();
									} catch (IOException e1) {
										e1.printStackTrace();
									}
									// }
								}
								if (method.equals("PSO1_Tanh")) {
									try {
										// Double_Action_PSO1.main();
										Double_Auction_PSO1_Tanh.main();
									} catch (IOException e1) {

										e1.printStackTrace();
									}
								}

								if (method.equals("PSO2_Tanh")) {
									try {
										Double_Auction_PSO2_Tanh.main();
									} catch (IOException e1) {

										e1.printStackTrace();
									}
								}
								if (method.equals("ALPSO_Tanh")) {
									try {
										Double_Auction_ALPSO_Tanh.main();
									} catch (IOException e1) {
										e1.printStackTrace();
									}
								}
								if (method.equals("LRPSO_Tanh")) {
									try {
										Double_Auction_LRPSO_Tanh.main();
									} catch (IOException e1) {
										e1.printStackTrace();
									}
								}
								if (method.equals("LR_and_PSO2_Tanh")) {
									try {
										Double_Auction_LR_and_PSO2_Tanh.main();
									} catch (IOException e1) {
										e1.printStackTrace();
									}
								}
								if (method.equals("LR_and_PSO1_Tanh")) {
									try {
										Double_Auction_LR_and_PSO1_Tanh.main();
									} catch (IOException e1) {
										e1.printStackTrace();
									}
								}
								if (method.equals("CCPSO2_Tanh")) {
									// for(int i=0;i<10;i++){
									try {
										Double_Auction_CCPSO2_Tanh.main();
									} catch (IOException e1) {
										e1.printStackTrace();
									}
									// }
								}
								if (method.equals("FA_PSO")) {
									// for(int i=0;i<10;i++){
									try {
										Double_Auction_FA_PSO.main();
									} catch (IOException e1) {
										e1.printStackTrace();
									}
									// }
								}
								if (method.equals("FA")) {
									// for(int i=0;i<10;i++){
									try {
										Double_Auction_FA.main();
									} catch (IOException e1) {
										e1.printStackTrace();
									}
									// }
								}
								if (method.equals("DE_DA")) {
									// for(int i=0;i<15;i++){
									try {
										Double_Auction_DE.main();
									} catch (IOException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									// }
								}
								if (method.equals("DE_DA_strategy1")) {
									// for(int i=0;i<15;i++){
									try {
										Double_Auction_DE.main();
									} catch (IOException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									// }
								}
								if (method.equals("DE_DA_strategy2")) {
									// for(int i=0;i<15;i++){
									try {
										Double_Auction_DE.main();
									} catch (IOException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									// }
								}
								if (method.equals("DE_DA_strategy3")) {
									// for(int i=0;i<15;i++){
									try {
										Double_Auction_DE.main();
									} catch (IOException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									// }
								}
								if (method.equals("DE_DA_strategy4")) {
									// for(int i=0;i<15;i++){
									try {
										Double_Auction_DE.main();
									} catch (IOException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									// }
								}
								if (method.equals("DE_DA_strategy5")) {
									// for(int i=0;i<15;i++){
									try {
										Double_Auction_DE.main();
									} catch (IOException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									// }
								}
								if (method.equals("DE_DA_strategy6")) {
									// for(int i=0;i<15;i++){
									try {
										Double_Auction_DE.main();
									} catch (IOException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									// }
								}
								if (method.equals("DE_DA_Real")) {
									try {
										Double_Auction_DE_Real.main();
									} catch (IOException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
								}
								if (method.equals("DE_DA_strategy1_Real")) {
									try {
										Double_Auction_DE_Real.main();
									} catch (IOException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
								}
								if (method.equals("DE_DA_strategy2_Real")) {
									try {
										Double_Auction_DE_Real.main();
									} catch (IOException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
								}
								if (method.equals("DE_DA_strategy3_Real")) {
									try {
										Double_Auction_DE_Real.main();
									} catch (IOException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
								}
								if (method.equals("DE_DA_strategy4_Real")) {
									try {
										Double_Auction_DE_Real.main();
									} catch (IOException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
								}
								if (method.equals("DE_DA_strategy5_Real")) {
									try {
										Double_Auction_DE_Real.main();
									} catch (IOException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
								}
								if (method.equals("DE_DA_strategy6_Real")) {
									try {
										Double_Auction_DE_Real.main();
									} catch (IOException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
								}
								if (method.equals("NSDE")) {
									try {
										Double_Auction_NSDE.main();
									} catch (IOException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
								}
								if (method.equals("SaNSDE")) {
									try {
										Double_Auction_SaNSDE.main();
									} catch (IOException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
								}
								if (method.equals("DECC")) {
									try {
										Double_Auction_DECC.main();
									} catch (IOException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
								}
								if (method.equals("DE_Real_POP") || method.equals("DE_strategy1_Real_POP") || method.equals("DE_strategy2_Real_POP")
										|| method.equals("DE_strategy3_Real_POP") || method.equals("DE_strategy4_Real_POP") || method.equals("DE_strategy5_Real_POP")
										|| method.equals("DE_strategy6_Real_POP")) {
									try {
										Double_Auction_DE_Real_POP.main();
									} catch (IOException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
								}
								if (method.equals("NSDE_POP")) {

									try {
										Double_Auction_NSDE_POP.main();
									} catch (IOException e1) {
										e1.printStackTrace();
									}
								}
								if (method.equals("SaNSDE_POP")) {

									try {
										Double_Auction_SaNSDE_POP.main();
									} catch (IOException e1) {
										e1.printStackTrace();
									}
								}
								if (method.equals("DECC_POP")) {
									try {
										Double_Auction_DECC_POP.main();
									} catch (IOException e1) {
										e1.printStackTrace();
									}
								}
								if (method.equals("DE_Real_POP_NEW") || method.equals("DE_strategy1_Real_POP_NEW") || method.equals("DE_strategy2_Real_POP_NEW")
										|| method.equals("DE_strategy3_Real_POP_NEW") || method.equals("DE_strategy4_Real_POP_NEW") || method.equals("DE_strategy5_Real_POP_NEW")
										|| method.equals("DE_strategy6_Real_POP_NEW")) {
									try {
										Double_Auction_DE_Real_POP_NEW.main();
									} catch (IOException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
								}
								if (method.equals("NSDE_POP_NEW")) {

									try {
										Double_Auction_NSDE_POP_NEW.main();
									} catch (IOException e1) {
										e1.printStackTrace();
									}
								}
								if (method.equals("SaNSDE_POP_NEW")) {

									try {
										Double_Auction_SaNSDE_POP_NEW.main();
									} catch (IOException e1) {
										e1.printStackTrace();
									}
								}
								if (method.equals("DECC_POP_NEW")) {
									try {
										Double_Auction_DECC_POP_NEW.main();
									} catch (IOException e1) {
										e1.printStackTrace();
									}
								}
								if (method.equals("DE_DA_Real_Problem3")) {
									try {
										Double_Auction_DE_Real_Problem3.main();
									} catch (IOException e1) {
										e1.printStackTrace();
									}
								}
								if (method.equals("DE_DA_Real_POP_Problem3")) {
									try {
										Double_Auction_DE_Real_POP_Problem3.main();
									} catch (IOException e1) {
										e1.printStackTrace();
									}
								}
								if (method.equals("NSDE_Problem3")) {
									try {
										Double_Auction_NSDE_Problem3.main();
									} catch (IOException e1) {
										e1.printStackTrace();
									}
								}
								if (method.equals("SaNSDE_Problem3")) {
									try {
										Double_Auction_SaNSDE_Problem3.main();
									} catch (IOException e1) {
										e1.printStackTrace();
									}
								}
								if (method.equals("ALPSO2_NEW")) {

									try {
										ALPSO2_NEW.main();
									} catch (IOException e1) {
										e1.printStackTrace();
									}
								}
								if (method.equals("ALPSO2_NEW_PrematureConvegence1")) {

									try {
										ALPSO2_NEW_PrematureConvegence1.main();
									} catch (IOException e1) {
										e1.printStackTrace();
									}
								}
								if (method.equals("DMS-L-PSO")) {

									try {
										DMS_L_PSO2.main();
									} catch (IOException e1) {
										e1.printStackTrace();
									}
								}
								if (method.equals("DMSDL-PSO")) {

									try {
										DMSDL_PSO2.main();
									} catch (IOException e1) {
										e1.printStackTrace();
									}
								}
								if (method.equals("NLPSO2")) {

									try {
										NLPSO2.main();
									} catch (IOException e1) {
										e1.printStackTrace();
									}
								}
								if (method.equals("DynDE")) {

									try {
										DynDE.main();
									} catch (IOException e1) {
										e1.printStackTrace();
									}
								}
								if (method.equals("DynDE_POP")) {

									try {
										DynDE_POP.main();
									} catch (IOException e1) {
										e1.printStackTrace();
									}
								}
								if (method.equals("CLPSO2")) {

									try {
										Double_Auction_CLPSO2.main();
									} catch (IOException e1) {
										e1.printStackTrace();
									}
								}
								if (method.equals("CC-CLPSO2")) {
									try {
										Double_Auction_CC_CLPSO2.main();
									} catch (IOException e1) {
										e1.printStackTrace();
									}
								}
								if (method.equals("L-SHADE")) {
									try {
										Double_Auction_L_SHADE.main();
									} catch (IOException e1) {
										e1.printStackTrace();
									}
								}
								if (method.equals("L_SHADE_CCPSO2")) {
									try {
										Double_Auction_L_SHADE_CCPSO2.main();
									} catch (IOException e1) {
										e1.printStackTrace();
									}
								}
							}
						}
					}
				}
			}

		}
		if (btn == btn4) {
			Set_Alpha_TransactionFee.main();

		}
		if (btn == btn2) {
			Allocate_surplus.main();
		}
		if (btn == btn3) {
			frm.setVisible(false);
		}
	}
}