package GUI.GUI_Batch;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;

import Algorithm_Carpool.APSO1.APSO1;
import Algorithm_Carpool.APSO2.APSO2;
import Algorithm_Carpool.CCPSO2.CCPSO2;
import Algorithm_Carpool.GA1.GA1;
import Algorithm_Carpool.GA2.GA2;
import Algorithm_Carpool.Lagrangian_PSO.ALPSO;
import Algorithm_Carpool.Lagrangian_Relaxation.LR;
import Algorithm_Carpool.Lagrangian_Relaxation_PSO.LRPSO;
import Algorithm_Carpool.Lagrangian_Relaxation_and_PSO1.LR_and_PSO1;
import Algorithm_Carpool.Lagrangian_Relaxation_and_PSO2.LR_and_PSO2;
import Algorithm_Carpool.PSO1.PSO1;
import Algorithm_Carpool.PSO2.PSO2;
import Algorithm_Carpool.PSO3.PSO3;
import Algorithm_Carpool.PSO4.PSO4;
import Algorithm_Carpool.PSO_LS.PSO_LS;
import Algorithm_DoubleAuction.CCPSO2_DA.Double_Auction_CCPSO2;
import Algorithm_DoubleAuction.DE_DA.Double_Auction_DE;
import Algorithm_DoubleAuction.GA1_DA.Double_Auction_GA1;
import Algorithm_DoubleAuction.GA2_DA.Double_Auction_GA2;
import Algorithm_DoubleAuction.Lagrangain_Relaxation_DA.Double_Auction_LR;
import Algorithm_DoubleAuction.Lagrangian_PSO_DA.Double_Auction_ALPSO;
import Algorithm_DoubleAuction.Lagrangian_Relaxation_PSO_DA.Double_Auction_LRPSO;
import Algorithm_DoubleAuction.Lagrangian_Relaxation_and_PSO1_DA.Double_Auction_LR_and_PSO1;
import Algorithm_DoubleAuction.Lagrangian_Relaxation_and_PSO2_DA.Double_Auction_LR_and_PSO2;
import Algorithm_DoubleAuction.PSO1_DA.Double_Auction_PSO1;
import Algorithm_DoubleAuction.PSO2_DA.Double_Auction_PSO2;
import Algorithm_DoubleAuction.PSO_TS_DA.PSO_TS_DA;
import Algorithm_DoubleAuction.TS_DA.TS_DA;
import Algorithm_Tourism.DE_Tourism.DE_Tourism;
import Algorithm_Tourism.GA1_Tourism.GA1_Tourism;
import Algorithm_Tourism.GA2_Tourism.GA2_Tourism;
import Algorithm_Tourism.PSO1_Tourism.PSO1_Tourism;
import Algorithm_Tourism.PSO2_Tourism.PSO2_Tourism;
import Cplex.CPLEX;
import Cplex.CPLEX_DA;
import Cplex.CPLEX_DA_LP;
import Cplex.CPLEX_Tourism;
import Input_Output_txt.Carpool.check_batch_TXT;
import Result_to_out_Carpool.carpool_results_test;

public class XII_Run_the_selected_Algorithm_and_result_to_out extends Batch
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

		if (GUI.main.getmethod()== 3 || GUI.main.getmethod() == 4)
			frm.remove(btn2);
		frm.setVisible(true); // 設定視窗為可見
	}

	public static void main() {

		new XII_Run_the_selected_Algorithm_and_result_to_out();
	}

	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		if (btn == btn1) {
			if (Algorithm == 1 && (GUI.main.getmethod()!=3 &&GUI.main.getmethod()!=4)) {
				try {
					CPLEX.main();
				} catch (IOException e1) {

					e1.printStackTrace();
				}
			} else if (Algorithm == 1 &&GUI.main.getmethod() == 3) {
				try {
					CPLEX_DA.main();
				//	CPLEX_DA_LP.main();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else if (Algorithm == 1 &&GUI.main.getmethod() == 4) {
				try {
					CPLEX_Tourism.main();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if (Algorithm == 2 && (GUI.main.getmethod()!=3 && GUI.main.getmethod()!=4)) {
				try {
				GA1.main();
				//	Double_Action_GA1.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			} else if (Algorithm == 2 &&GUI.main.getmethod() == 3) {
				try {
					Double_Auction_GA1.main();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}else if (Algorithm == 2 &&GUI.main.getmethod() == 4) {
				try {
					GA1_Tourism.main();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (Algorithm == 3 &&  (GUI.main.getmethod()!=3 &&GUI.main.getmethod()!=4))  {
				try {
					GA2.main();
				//	Double_Action_GA2.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			} else if (Algorithm == 3 &&GUI.main.getmethod() == 3) {
				try {
					Double_Auction_GA2.main();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else if (Algorithm == 3 &&GUI.main.getmethod() == 4) {
				try {
					 GA2_Tourism.main();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (Algorithm == 4 &&  (GUI.main.getmethod()!=3 &&GUI.main.getmethod()!=4)) {
				try {
				//	Double_Action_PSO1.main();
					PSO1.main();
				} catch (IOException e1) {

					e1.printStackTrace();
				}
			} else if (Algorithm == 4 &&GUI.main.getmethod() == 3) {
				try {
					Double_Auction_PSO1.main();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}else if (Algorithm == 4 &&GUI.main.getmethod() == 4) {
				try {
					PSO1_Tourism.main();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (Algorithm == 5 && (GUI.main.getmethod()!=3 &&GUI.main.getmethod()!=4)) {
				try {
				//	Double_Action_PSO2.main();
						PSO2.main();
				} catch (IOException e1) {

					e1.printStackTrace();
				}
			} else if (Algorithm == 5 &&GUI.main.getmethod() == 3) {
				try {
					Double_Auction_PSO2.main();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}else if (Algorithm == 5 &&GUI.main.getmethod() == 4) {
				try {
					PSO2_Tourism.main();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if (Algorithm == 6) {
				try {
					PSO3.main();
				} catch (IOException e1) {

					e1.printStackTrace();
				}
			}
			if (Algorithm == 7) {
				try {
					PSO4.main();
				} catch (IOException e1) {

					e1.printStackTrace();
				}
			}
			if (Algorithm == 8) {
				try {
					APSO1.main();
				} catch (IOException e1) {

					e1.printStackTrace();
				}
			}
			if (Algorithm == 9) {
				try {
					APSO2.main();
				} catch (IOException e1) {

					e1.printStackTrace();
				}
			}
			if (Algorithm == 10 &&GUI.main.getmethod() != 3) {
				try {
					
					ALPSO.main();
				} catch (IOException e1) {

					e1.printStackTrace();
				}
			} else if (Algorithm == 10 &&GUI.main.getmethod() == 3) {
				try {
					Double_Auction_ALPSO.main();
				} catch (IOException e1) {

					e1.printStackTrace();
				}
			}
			if (Algorithm == 11 &&GUI.main.getmethod() != 3) {
				try {
					//Double_Action_LRPSO.main();
					LRPSO.main();
				} catch (IOException e1) {

					e1.printStackTrace();
				}
			} else if (Algorithm == 11 &&GUI.main.getmethod() == 3) {
				try {
					
					Double_Auction_LRPSO.main();
				} catch (IOException e1) {

					e1.printStackTrace();
				}
			}
			if (Algorithm == 12 &&GUI.main.getmethod() != 3) {
				try {
					LR.main();
				} catch (IOException e1) {

					e1.printStackTrace();
				}
			} else if (Algorithm == 12 &&GUI.main.getmethod() == 3) {
				try {
					Double_Auction_LR.main();
				} catch (IOException e1) {

					e1.printStackTrace();
				}
			}
			if (Algorithm == 13 &&GUI.main.getmethod() != 3) {
				try {
			//		Double_Action_LR_and_PSO2.main();
					LR_and_PSO2.main();
				} catch (IOException e1) {

					e1.printStackTrace();
				}
			}
			if (Algorithm == 13 &&GUI.main.getmethod() == 3) {
				try {
					// LAPSO.main();
					Double_Auction_LR_and_PSO2.main();
				} catch (IOException e1) {

					e1.printStackTrace();
				}
			}
			if (Algorithm == 14 &&GUI.main.getmethod() != 3) {
				try {
				//	Double_Action_LR_and_PSO1.main();
					LR_and_PSO1.main();
				} catch (IOException e1) {

					e1.printStackTrace();
				}
			}
			if (Algorithm == 14 &&GUI.main.getmethod() == 3) {
				try {
					// LAPSO.main();
					Double_Auction_LR_and_PSO1.main();
				} catch (IOException e1) {

					e1.printStackTrace();
				}
			}
			if (Algorithm == 15 &&GUI.main.getmethod() != 3) {
				try {
					CCPSO2.main();
				} catch (IOException e1) {

					e1.printStackTrace();
				}
			}
			if (Algorithm == 15 &&GUI.main.getmethod() == 3) {
				try {
				Double_Auction_CCPSO2.main();
				} catch (IOException e1) {

					e1.printStackTrace();
				}
			}
			if (Algorithm == 16 &&GUI.main.getmethod() != 3) {
				try {
					 PSO_LS.main();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			} 
			if (Algorithm == 17 &&GUI.main.getmethod() == 3) {
				try {
					
					CPLEX_DA_LP.main();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if (Algorithm == 18 &&GUI.main.getmethod() == 3) {
				try {
					TS_DA.main();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if (Algorithm == 19 &&GUI.main.getmethod() == 3) {
				try {
					Double_Auction_DE.main();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}else if (Algorithm == 19 &&GUI.main.getmethod() == 4) {
				try {
					DE_Tourism.main();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if (Algorithm == 20 &&GUI.main.getmethod() == 3) {
				try {
					Double_Auction_DE.main();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}else if (Algorithm == 20 &&GUI.main.getmethod() == 4) {
				try {
					DE_Tourism.main();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if (Algorithm == 21 &&GUI.main.getmethod() == 3) {
				try {
					Double_Auction_DE.main();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}else if (Algorithm == 21 &&GUI.main.getmethod() == 4) {
				try {
					DE_Tourism.main();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if (Algorithm == 22 &&GUI.main.getmethod() == 3) {
				try {
					Double_Auction_DE.main();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}else if (Algorithm == 22 &&GUI.main.getmethod() == 4) {
				try {
					DE_Tourism.main();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if (Algorithm == 23 &&GUI.main.getmethod() == 3) {
				try {
					Double_Auction_DE.main();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}else if (Algorithm == 23 &&GUI.main.getmethod() == 4) {
				try {
					DE_Tourism.main();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if (Algorithm == 24 &&GUI.main.getmethod() == 3) {
				try {
					Double_Auction_DE.main();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}else if (Algorithm == 24 &&GUI.main.getmethod() == 4) {
				try {
					DE_Tourism.main();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if (Algorithm == 25 &&GUI.main.getmethod() == 3) {
				try {
					Double_Auction_DE.main();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}else if (Algorithm == 25 &&GUI.main.getmethod() == 4) {
				try {
					DE_Tourism.main();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if (Algorithm == 26 &&GUI.main.getmethod() == 3) {
				try {
					PSO_TS_DA.main();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
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