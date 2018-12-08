package Cplex;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import Input_Output_txt.Carpool.Output_EXCEL;
import Input_Output_txt.Carpool.Output_Result;
import Input_Output_txt.Carpool.Read_BPL_TXT;
import Input_Output_txt.Carpool.Read_CarpoolData_Generation_Mode;
import Input_Output_txt.Carpool.Read_file;
import ilog.concert.IloException;
import ilog.concert.IloIntExpr;
import ilog.concert.IloLinearNumExpr;
import ilog.concert.IloNumExpr;
import ilog.concert.IloNumVar;
import ilog.cplex.IloCplex;

public class Algorithm extends CPLEX {
	public static void CPLEX_Algorithm() {
		long startTime = System.currentTimeMillis();

		try {
			IloCplex cplex = new IloCplex();
			// 建立x,y陣列大小
			IloNumVar[][] x = new IloNumVar[D][];
			IloNumVar[][] y = new IloNumVar[P][];
			double[][] driver_money = new double[D][];
			double[][] passenger_money = new double[P][];
			for (int i = 0; i < D; i++) {
				x[i] = new IloNumVar[Read_file.getJd(i)];
				driver_money[i] = new double[Read_file.getJd(i)];
			}
			for (int i = 0; i < P; i++) {
				y[i] = new IloNumVar[Read_file.getHp(i)];
				passenger_money[i] = new double[Read_file.getHp(i)];
			}
			// x,y矩陣以二進制顯示
			for (int i = 0; i < D; i++)
				for (int j = 0; j < Read_file.getJd(i); j++)
					x[i][j] = cplex.boolVar();
			for (int i = 0; i < P; i++)
				for (int j = 0; j < Read_file.getHp(i); j++)
					y[i][j] = cplex.boolVar();
			// 目標式
			IloLinearNumExpr passenger = cplex.linearNumExpr();
			IloLinearNumExpr driver = cplex.linearNumExpr();
			IloLinearNumExpr passenger2 = cplex.linearNumExpr();
			IloLinearNumExpr  driver2 = cplex.linearNumExpr();

			IloLinearNumExpr  dp = cplex.linearNumExpr();
			
			for (int p = 0; p < P; p++)
				for (int h = 0; h < Read_file.getHp(p); h++) {
					passenger_money[p][h] = Read_file.getfph(p, h)
							+ (Read_file.getfph(p, h) * Read_file.getTpm());
					passenger.addTerm(y[p][h], passenger_money[p][h]);
					passenger2.addTerm(y[p][h],1);
				}
			
			for (int d = 0; d < D; d++)
				for (int j = 0; j < Read_file.getJd(d); j++) {
					driver_money[d][j] = (Read_file.getCdj(d, j)-Read_file.getOdj(d, j))
							- ((Read_file.getCdj(d, j)-Read_file.getOdj(d, j)) * Read_file.getTdm());
					driver.addTerm(x[d][j], driver_money[d][j]);
					driver2.addTerm(x[d][j],1);
				}
			
			cplex.addMaximize(cplex.sum(cplex.prod(Omega_1, cplex.diff(passenger, driver)),cplex.prod(Omega_2, cplex.sum(passenger2,driver2))));
		
			// 限制式
			// 限制1
			IloLinearNumExpr p1 = cplex.linearNumExpr();
			IloLinearNumExpr d1 = cplex.linearNumExpr();
			for (int k = 0; k < K; k++) {
				p1.clear();
				d1.clear();
				for (int d = 0; d < D; d++)
					for (int j = 0; j < Read_file.getJd(d); j++)
						d1.addTerm(x[d][j], Read_file.getqdjk(d, j, k));
				for (int p = 0; p < P; p++)
					for (int h = 0; h < Read_file.getHp(p); h++)
						p1.addTerm(y[p][h], Read_file.getSphk(p, h, k));
				cplex.addGe(d1, p1);
			}
			// 限制式2
			IloLinearNumExpr p2 = cplex.linearNumExpr();
			IloLinearNumExpr d2 = cplex.linearNumExpr();
			for (int p = 0; p < P; p++)
				for (int h = 0; h < Read_file.getHp(p); h++)
					p2.addTerm(y[p][h], Read_file.getfph(p, h));
			for (int d = 0; d < D; d++)
				for (int j = 0; j < Read_file.getJd(d); j++)
					d2.addTerm(x[d][j], Read_file.getCdj(d, j)-Read_file.getOdj(d, j));
			cplex.addGe(p2, d2);
			// 限制式3
			IloLinearNumExpr d3 = cplex.linearNumExpr();
			for (int d = 0; d < D; d++)
				for (int j = 0; j < Read_file.getJd(d); j++) {
					d3.clear();
					for (int k = 0; k < K; k++)
						d3.addTerm(x[d][j], Read_file.getqdjk(d, j, k));
					cplex.addLe(d3, Read_file.getadj(d, j));
				}
			// 限制式4
			IloLinearNumExpr d4 = cplex.linearNumExpr();
			for (int d = 0; d < D; d++)
				for (int j = 0; j < Read_file.getJd(d); j++) {
					d4.clear();
					for (int k = 0; k < K; k++)
						d4.addTerm(x[d][j], Read_file.getWqdjk(d, j, k));
					cplex.addLe(d4, Read_file.getldj(d, j));
				}
			// 限制式5
			IloLinearNumExpr d5 = cplex.linearNumExpr();
			for (int d = 0; d < D; d++) {
				d5.clear();
				for (int j = 0; j < Read_file.getJd(d); j++) {
					d5.addTerm(x[d][j], 1);
					cplex.addLe(d5, 1);
				}
			}
			
			if(Read_CarpoolData_Generation_Mode.mode().contains("multi_hop")){
			/*	IloLinearNumExpr d6 = cplex.linearNumExpr();
				IloLinearNumExpr d9 = cplex.linearNumExpr();
				for(int p=0;p<Read_BPL_TXT.Bpl().size();p++){
					int a=0;
				 
					for(int j=0;j<Read_BPL_TXT.Bpl().get(p).size();j++){
						d6.clear();d9.clear();
						for(int k=0;k<Read_BPL_TXT.Bpl().get(p).get(j);k++){
							d6.addTerm(y[p][a],1);
					
							a+=1;
						}
						//	cplex.prod(d6,cplex.diff(Read_BPL_TXT.Bpl().get(p).get(j), d6));
						//	cplex.addEq(cplex.prod(d9,cplex.diff(Read_BPL_TXT.Bpl().get(p).get(j), d9)), 0);
						cplex.addEq(d6, cplex.prod(-1, cplex.diff(Read_BPL_TXT.Bpl().get(p).get(j), d6)));
					}
				}
			*/
	
				IloLinearNumExpr d7 = cplex.linearNumExpr();
				IloLinearNumExpr d8 = cplex.linearNumExpr();
				for(int p=0;p<Read_BPL_TXT.Bpl().size();p++){
					int a=0;
					d8.clear();
					for(int j=0;j<Read_BPL_TXT.Bpl().get(p).size();j++){
						d7.clear();
						for(int k=0;k<Read_BPL_TXT.Bpl().get(p).get(j);k++){
							d7.addTerm(y[p][a],1);
							a+=1;
						}
						d8.add(d7);
					}cplex.addLe(d8, 1);
				}
		 
			}
			long endTime = System.currentTimeMillis();
			String X="",Y="",str="";
			
			if (cplex.solve()) {
				
					System.out.println();
					
					System.out.println("F(X,Y)= " + cplex.getObjValue());
					str+="Generation=1  Fitness Function= "+cplex.getObjValue()+ " Time="+(endTime-startTime)+" ms";
					System.out.print("Y= ");
					for (int p = 0; p < P; p++)
						for (int h = 0; h < Read_file.getHp(p); h++) {
							System.out.print((int) (cplex.getValue(y[p][h]))
									+ "  ");
							 Y+=((int) (cplex.getValue(y[p][h]))+" ");
						}
					System.out.println();
					System.out.print("X= ");
					for (int d = 0; d < D; d++)
						for (int j = 0; j < Read_file.getJd(d); j++) {
							System.out.print((int) (cplex.getValue(x[d][j]))
									+ "  ");
							X+=((int) (cplex.getValue(x[d][j]))+" ");
						}
				
			} else {
				System.out.println("not solved");
			}
			System.out.println("\n" + "程式執行時間:" + (endTime - startTime));
			try {
				Output_Result.CPLEX(Y,X,cplex.getObjValue(),endTime-startTime,str);
				Output_EXCEL.main(D,P,Omega_1,Omega_2,Omega_3,Omega_4,Omega_5,Omega_6,Omega_7,Omega_8,X,Y,cplex.getObjValue(),0,0,endTime-startTime,endTime-startTime,true);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IloException e) {
			System.err.println("Concert exception '" + e + "' caught");
		}
	}
}
