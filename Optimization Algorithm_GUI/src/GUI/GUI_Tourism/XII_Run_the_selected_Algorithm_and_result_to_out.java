package GUI.GUI_Tourism;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
  
 
import Algorithm_Tourism.ALPSO2_NEW_PrematureConvegence1_Tourism.ALPSO2_NEW_PrematureConvegence1_Tourism;
import Algorithm_Tourism.ALPSO2_NEW_Tourism.ALPSO2_NEW_Tourism;
import Algorithm_Tourism.CCPSO2_Tourism.CCPSO2_Tourism;
import Algorithm_Tourism.CC_CLPSO2_Tourism.CC_CLPSO2_Tourism;
import Algorithm_Tourism.CLPSO2_Tourism.CLPSO2_Tourism;
import Algorithm_Tourism.DECC_POP_NEW_Tourism.DECC_POP_NEW_Tourism;
import Algorithm_Tourism.DECC_POP_Tourism.DECC_POP_Tourism;
import Algorithm_Tourism.DECC_Tourism.DECC_Tourism;
import Algorithm_Tourism.DE_Real_POP_NEW_Tourism.DE_Real_POP_NEW_Tourism;
import Algorithm_Tourism.DE_Real_POP_Tourism.DE_Real_POP_Tourism;
import Algorithm_Tourism.DE_Real_Tourism.DE_Real_Tourism;
import Algorithm_Tourism.DE_Tourism.DE_Tourism;
import Algorithm_Tourism.DMSDL_PSO2_Tourism.DMSDL_PSO2_Tourism;
import Algorithm_Tourism.DMS_L_PSO2_Tourism.DMS_L_PSO2_Tourism;
import Algorithm_Tourism.DynDE_POP_Tourism.DynDE_POP_Tourism;
import Algorithm_Tourism.DynDE_Tourism.DynDE_Tourism;
import Algorithm_Tourism.FA_PSO_Tourism.FA_PSO_Tourism;
import Algorithm_Tourism.FA_Tourism.FA_Tourism;
import Algorithm_Tourism.GA1_Tourism.GA1_Tourism;
import Algorithm_Tourism.GA2_Tourism.GA2_Tourism;
import Algorithm_Tourism.L_SHADE_CCPSO2_Tourism.L_SHADE_CCPSO2_Tourism;
import Algorithm_Tourism.L_SHADE_Tourism.L_SHADE_Tourism;
import Algorithm_Tourism.Lagrangain_Relaxation_Tourism.LR_Tourism;
import Algorithm_Tourism.Lagrangian_PSO_Tourism.ALPSO_Tourism;
import Algorithm_Tourism.Lagrangian_RelaxationPSO_Tourism.LRPSO_Tourism;
import Algorithm_Tourism.Lagrangian_Relaxation_and_PSO1_Tourism.LR_and_PSO1_Tourism;
import Algorithm_Tourism.Lagrangian_Relaxation_and_PSO2_Tourism.LR_and_PSO2_Tourism;
import Algorithm_Tourism.NLPSO2_Tourism.NLPSO2_Tourism;
import Algorithm_Tourism.NSDE_POP_NEW_Tourism.NSDE_POP_NEW_Tourism;
import Algorithm_Tourism.NSDE_POP_Tourism.NSDE_POP_Tourism;
import Algorithm_Tourism.NSDE_Tourism.NSDE_Tourism;
import Algorithm_Tourism.PSO1_Tourism.PSO1_Tourism;
import Algorithm_Tourism.PSO2_Tourism.PSO2_Tourism;
import Algorithm_Tourism.PSO_TS_Tourism.PSO_TS_Tourism;
import Algorithm_Tourism.SaNSDE_POP_NEW_Tourism.SaNSDE_POP_NEW_Tourism;
import Algorithm_Tourism.SaNSDE_POP_Tourism.SaNSDE_POP_Tourism;
import Algorithm_Tourism.SaNSDE_Tourism.SaNSDE_Tourism;
import Cplex.CPLEX_Tourism;
import GUI.I_Set_Paths_for_Current_Simulation_Example;


public class XII_Run_the_selected_Algorithm_and_result_to_out extends Tourism
		implements ActionListener {

	JFrame frm = new JFrame();

	JButton btn1 = new JButton("Run_the_selected_Algorithm");
	JButton btn2 = new JButton("result to out");
	JButton btn3 = new JButton("Exit");

	XII_Run_the_selected_Algorithm_and_result_to_out() {

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

			frm.remove(btn2);
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
					CPLEX_Tourism.main();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("GA1")) {
				try {
					GA1_Tourism.main();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("GA2")) {
				try {
					GA2_Tourism.main();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("PSO1")) {
				try {
					PSO1_Tourism.main();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("PSO2")) {
				try {
					PSO2_Tourism.main();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			 if (Algorithm.equals("ALPSO")) {
				try {
					ALPSO_Tourism.main();
					 
				} catch (IOException e1) {

					e1.printStackTrace();
				}
			}
			 if (Algorithm.equals("LRPSO")) {
				try {
					LRPSO_Tourism.main();
					
				} catch (IOException e1) {

					e1.printStackTrace();
				}
			}
			 if (Algorithm.equals("LR") ) {
				try {
					LR_Tourism.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("LR_and_PSO2")) {
				try {
					// LAPSO.main();
					LR_and_PSO2_Tourism.main();
					
				} catch (IOException e1) {

					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("LR_and_PSO1")) {
				try {
					// LAPSO.main();
					LR_and_PSO1_Tourism.main();

				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("CCPSO2")) {
				try {
					CCPSO2_Tourism.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		 
		 
			if ((Algorithm.equals("DE_Tourism") || Algorithm.equals("DE_Tourism_strategy1") || Algorithm.equals("DE_Tourism_strategy2") 
					|| Algorithm.equals("DE_Tourism_strategy3")|| Algorithm.equals("DE_Tourism_strategy4") || Algorithm.equals("DE_Tourism_strategy5") 
					|| Algorithm.equals("DE_Tourism_strategy6"))) {
				try {
					DE_Tourism.main();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			if (Algorithm.equals("PSO_TS")) {
				try {
					PSO_TS_Tourism.main();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if ((Algorithm.equals("DE_Tourism_Real") || Algorithm.equals("DE_Tourism_strategy1_Real") || Algorithm.equals("DE_Tourism_strategy2_Real") 
					|| Algorithm.equals("DE_Tourism_strategy3_Real")|| Algorithm.equals("DE_Tourism_strategy4_Real") || Algorithm.equals("DE_Tourism_strategy5_Real") 
					|| Algorithm.equals("DE_Tourism_strategy6_Real"))) {
				try {
					DE_Real_Tourism.main();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("NSDE")) {
				try {
					NSDE_Tourism.main();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("SaNSDE")) {
				try {
					SaNSDE_Tourism.main();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("DECC")) {
				try {
					DECC_Tourism.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("DE_Real_POP") || Algorithm.equals("DE_strategy1_Real_POP") || Algorithm.equals("DE_strategy2_Real_POP")
					|| Algorithm.equals("DE_strategy3_Real_POP") || Algorithm.equals("DE_strategy4_Real_POP") || Algorithm.equals("DE_strategy5_Real_POP")
					|| Algorithm.equals("DE_strategy6_Real_POP") ) {
				try {
					DE_Real_POP_Tourism.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("DE_Real_POP_NEW") || Algorithm.equals("DE_strategy1_Real_POP_NEW")
					|| Algorithm.equals("DE_strategy2_Real_POP_NEW") || Algorithm.equals("DE_strategy3_Real_POP_NEW")
					|| Algorithm.equals("DE_strategy4_Real_POP_NEW") || Algorithm.equals("DE_strategy5_Real_POP_NEW")
					|| Algorithm.equals("DE_strategy6_Real_POP_NEW")) {
				try {
					DE_Real_POP_NEW_Tourism.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("DynDE")) {
				try {
					DynDE_Tourism.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("DynDE_POP")) {
				try {
					DynDE_POP_Tourism.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("ALPSO2_NEW")) {
				try {
					ALPSO2_NEW_Tourism.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("ALPSO2_NEW_PrematureConvegence1")) {
				try {
					ALPSO2_NEW_PrematureConvegence1_Tourism.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("DMS-L-PSO")) {
				try {
					DMS_L_PSO2_Tourism.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("DMSDL-PSO")) {
				try {
					DMSDL_PSO2_Tourism.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("NLPSO2")) {
				try {
					NLPSO2_Tourism.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("CLPSO2")) {
				try {
					CLPSO2_Tourism.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("CC-CLPSO2")) {
				try {
					CC_CLPSO2_Tourism.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("FA_PSO")) {
				try {
					FA_PSO_Tourism.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("FA")) {
				try {
					FA_Tourism.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("L-SHADE")) {
				try {
					L_SHADE_Tourism.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("L_SHADE_CCPSO2")) {
				try {
					L_SHADE_CCPSO2_Tourism.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("NSDE_POP")) {
				try {
					NSDE_POP_Tourism.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("SaNSDE_POP")) {
				try {
					SaNSDE_POP_Tourism.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("DECC_POP")) {
				try {
					DECC_POP_Tourism.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("NSDE_POP_NEW")) {
				try {
					NSDE_POP_NEW_Tourism.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("SaNSDE_POP_NEW")) {
				try {
					SaNSDE_POP_NEW_Tourism.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (Algorithm.equals("DECC_POP_NEW")) {
				try {
					DECC_POP_NEW_Tourism.main();
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
										CPLEX_Tourism.main();
									} catch (IOException e1) {

										e1.printStackTrace();
									}
								}
								if (method.equals("GA1")) {
									try {
										GA1_Tourism.main();
									} catch (IOException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
								}
								if (method.equals("GA2")) {
									try {
										GA2_Tourism.main();
									} catch (IOException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
								}
								if (method.equals("PSO1")) {
									try {
										PSO1_Tourism.main();
									} catch (IOException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
								}
								if (method.equals("PSO2")) {
									try {
										PSO2_Tourism.main();
									} catch (IOException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
								}
								 if (method.equals("ALPSO")) {
									try {
										ALPSO_Tourism.main();
										 
									} catch (IOException e1) {

										e1.printStackTrace();
									}
								}
								 if (method.equals("LRPSO")) {
									try {
										LRPSO_Tourism.main();
										
									} catch (IOException e1) {

										e1.printStackTrace();
									}
								}
								 if (method.equals("LR") ) {
									try {
										LR_Tourism.main();
									} catch (IOException e1) {
										e1.printStackTrace();
									}
								}
								if (method.equals("LR_and_PSO2")) {
									try {
										// LAPSO.main();
										LR_and_PSO2_Tourism.main();
										
									} catch (IOException e1) {

										e1.printStackTrace();
									}
								}
								if (method.equals("LR_and_PSO1")) {
									try {
										// LAPSO.main();
										LR_and_PSO1_Tourism.main();

									} catch (IOException e1) {
										e1.printStackTrace();
									}
								}
								if (method.equals("CCPSO2")) {
									try {
										CCPSO2_Tourism.main();
									} catch (IOException e1) {
										e1.printStackTrace();
									}
								}
								if ((method.equals("DE_Tourism") || method.equals("DE_Tourism_strategy1") || method.equals("DE_Tourism_strategy2") 
										|| method.equals("DE_Tourism_strategy3")|| method.equals("DE_Tourism_strategy4") || method.equals("DE_Tourism_strategy5") 
										|| method.equals("DE_Tourism_strategy6"))) {
									try {
										DE_Tourism.main();
									} catch (IOException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
								}
								if ((method.equals("DE_Tourism_Real") || method.equals("DE_Tourism_strategy1_Real") || method.equals("DE_Tourism_strategy2_Real") 
										|| method.equals("DE_Tourism_strategy3_Real")|| method.equals("DE_Tourism_strategy4_Real") || method.equals("DE_Tourism_strategy5_Real") 
										|| method.equals("DE_Tourism_strategy6_Real"))) {
									try {
										DE_Real_Tourism.main();
									} catch (IOException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
								}
								if (method.equals("NSDE")) {
									try {
										NSDE_Tourism.main();
									} catch (IOException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
								}
								if (method.equals("SaNSDE")) {
									try {
										SaNSDE_Tourism.main();
									} catch (IOException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
								}
								if (method.equals("DECC")) {
									try {
										DECC_Tourism.main();
									} catch (IOException e1) {
										e1.printStackTrace();
									}
								}
								if (method.equals("DE_Real_POP") || method.equals("DE_strategy1_Real_POP") || method.equals("DE_strategy2_Real_POP")
										|| method.equals("DE_strategy3_Real_POP") || method.equals("DE_strategy4_Real_POP") || method.equals("DE_strategy5_Real_POP")
										|| method.equals("DE_strategy6_Real_POP") ) {
									try {
										DE_Real_POP_Tourism.main();
									} catch (IOException e1) {
										e1.printStackTrace();
									}
								}
								if (method.equals("DE_Real_POP_NEW") || method.equals("DE_strategy1_Real_POP_NEW")
										|| method.equals("DE_strategy2_Real_POP_NEW") || method.equals("DE_strategy3_Real_POP_NEW")
										|| method.equals("DE_strategy4_Real_POP_NEW") || method.equals("DE_strategy5_Real_POP_NEW")
										|| method.equals("DE_strategy6_Real_POP_NEW")) {
									try {
										DE_Real_POP_NEW_Tourism.main();
									} catch (IOException e1) {
										e1.printStackTrace();
									}
								}
								if (method.equals("DynDE")) {
									try {
										DynDE_Tourism.main();
									} catch (IOException e1) {
										e1.printStackTrace();
									}
								}
								if (method.equals("DynDE_POP")) {
									try {
										DynDE_POP_Tourism.main();
									} catch (IOException e1) {
										e1.printStackTrace();
									}
								}
								if (method.equals("ALPSO2_NEW")) {
									try {
										ALPSO2_NEW_Tourism.main();
									} catch (IOException e1) {
										e1.printStackTrace();
									}
								}
								if (method.equals("ALPSO2_NEW_PrematureConvegence1")) {
									try {
										ALPSO2_NEW_PrematureConvegence1_Tourism.main();
									} catch (IOException e1) {
										e1.printStackTrace();
									}
								}
								if (method.equals("DMS-L-PSO")) {
									try {
										DMS_L_PSO2_Tourism.main();
									} catch (IOException e1) {
										e1.printStackTrace();
									}
								}
								if (method.equals("DMSDL-PSO")) {
									try {
										DMSDL_PSO2_Tourism.main();
									} catch (IOException e1) {
										e1.printStackTrace();
									}
								}
								if (method.equals("NLPSO2")) {
									try {
										NLPSO2_Tourism.main();
									} catch (IOException e1) {
										e1.printStackTrace();
									}
								}
								if (method.equals("CLPSO2")) {
									try {
										CLPSO2_Tourism.main();
									} catch (IOException e1) {
										e1.printStackTrace();
									}
								}
								if (method.equals("CC-CLPSO2")) {
									try {
										CC_CLPSO2_Tourism.main();
									} catch (IOException e1) {
										e1.printStackTrace();
									}
								}
								if (method.equals("FA_PSO")) {
									try {
										FA_PSO_Tourism.main();
									} catch (IOException e1) {
										e1.printStackTrace();
									}
								}
								if (method.equals("FA")) {
									try {
										FA_Tourism.main();
									} catch (IOException e1) {
										e1.printStackTrace();
									}
								}
								if (method.equals("L-SHADE")) {
									try {
										L_SHADE_Tourism.main();
									} catch (IOException e1) {
										e1.printStackTrace();
									}
								}
								if (method.equals("L_SHADE_CCPSO2")) {
									try {
										L_SHADE_CCPSO2_Tourism.main();
									} catch (IOException e1) {
										e1.printStackTrace();
									}
								}
								if (method.equals("NSDE_POP")) {
									try {
										NSDE_POP_Tourism.main();
									} catch (IOException e1) {
										e1.printStackTrace();
									}
								}
								if (method.equals("SaNSDE_POP")) {
									try {
										SaNSDE_POP_Tourism.main();
									} catch (IOException e1) {
										e1.printStackTrace();
									}
								}
								if (method.equals("DECC_POP")) {
									try {
										DECC_POP_Tourism.main();
									} catch (IOException e1) {
										e1.printStackTrace();
									}
								}
								if (method.equals("NSDE_POP_NEW")) {
									try {
										NSDE_POP_NEW_Tourism.main();
									} catch (IOException e1) {
										e1.printStackTrace();
									}
								}
								if (method.equals("SaNSDE_POP_NEW")) {
									try {
										SaNSDE_POP_NEW_Tourism.main();
									} catch (IOException e1) {
										e1.printStackTrace();
									}
								}
								if (method.equals("DECC_POP_NEW")) {
									try {
										DECC_POP_NEW_Tourism.main();
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
	
	
		if (btn == btn3) {
			frm.setVisible(false);
		}
	}
}