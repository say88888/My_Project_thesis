package Cplex;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import Input_Output_txt.Double_Auction.Output_EXCEL;
import Input_Output_txt.Double_Auction.Output_Result;
import Input_Output_txt.Double_Auction.Read_Double_Auction;
import ilog.concert.IloException;
import ilog.concert.IloLinearNumExpr;
import ilog.concert.IloNumVar;
import ilog.cplex.IloCplex;

public class Algorithm_DA extends CPLEX_DA {
	public static void CPLEX_Algorithm() {
		long startTime = System.currentTimeMillis();
		try {
			IloCplex cplex = new IloCplex();
			// 建立x,y陣列大小
			IloNumVar[][] x = new IloNumVar[I][];
			IloNumVar[][] y = new IloNumVar[N][];
			double[][] driver_money = new double[I][];
			double[][] passenger_money = new double[N][];
			for (int i = 0; i < I; i++) {
				x[i] = new IloNumVar[Read_Double_Auction.getJ(i)];
				driver_money[i] = new double[Read_Double_Auction.getJ(i)];
			}
			for (int i = 0; i < N; i++) {
				y[i] = new IloNumVar[Read_Double_Auction.getH(i)];
				passenger_money[i] = new double[Read_Double_Auction.getH(i)];
			}
			// x,y矩陣以二進制顯示
			for (int i = 0; i < I; i++)
				for (int j = 0; j <Read_Double_Auction.getJ(i); j++)
					x[i][j] = cplex.boolVar();
			for (int i = 0; i < N; i++)
				for (int j = 0; j < Read_Double_Auction.getH(i); j++)
					y[i][j] = cplex.boolVar();
			// 目標式
			IloLinearNumExpr passenger = cplex.linearNumExpr();
			IloLinearNumExpr driver = cplex.linearNumExpr();
			 
			for (int n = 0; n < N; n++)
				for (int h = 0; h < Read_Double_Auction.getH(n); h++) {
					passenger_money[n][h]=Read_Double_Auction.getPnh(n, h)+(Read_Double_Auction.getTbm()*Read_Double_Auction.getPnh(n, h));
					passenger.addTerm(y[n][h], passenger_money[n][h]);
			
				}
			for (int i = 0; i < I; i++)
				for (int j = 0; j < Read_Double_Auction.getJ(i); j++) {
					driver_money[i][j]=Read_Double_Auction.getPij(i, j)-(Read_Double_Auction.getTsm()*Read_Double_Auction.getPij(i, j));
					driver.addTerm(x[i][j],driver_money[i][j] );
					 
				}
			cplex.addMaximize(cplex.diff(passenger, driver) );
			// 限制式
			// 限制1
			IloLinearNumExpr p1 = cplex.linearNumExpr();
			IloLinearNumExpr d1 = cplex.linearNumExpr();
			for (int k = 0; k < K; k++) {
				p1.clear();
				d1.clear();
				for (int i = 0; i < I; i++)
					for (int j = 0; j < Read_Double_Auction.getJ(i); j++)
						d1.addTerm(x[i][j], Read_Double_Auction.getqijk(i, j, k));
				for (int n = 0; n < N; n++)
					for (int h = 0; h <Read_Double_Auction.getH(n); h++)
						p1.addTerm(y[n][h], Read_Double_Auction.getdnhk(n, h, k));
				cplex.addGe(d1, p1);
			}
			// 限制式2
			IloLinearNumExpr p2 = cplex.linearNumExpr();
			IloLinearNumExpr d2 = cplex.linearNumExpr();
			for (int n = 0; n < N; n++)
				for (int h = 0; h < Read_Double_Auction.getH(n); h++)
					p2.addTerm(y[n][h], Read_Double_Auction.getPnh(n, h));
			for (int i = 0; i < I; i++)
				for (int j = 0; j < Read_Double_Auction.getJ(i); j++)
					d2.addTerm(x[i][j], Read_Double_Auction.getPij(i, j));
			cplex.addGe(p2, d2);
			// 限制式3
			IloLinearNumExpr d3 = cplex.linearNumExpr();
			for (int i = 0; i < I; i++)
				for (int k = 0; k < K; k++){
					d3.clear();
					for (int j = 0; j < Read_Double_Auction.getJ(i); j++)
						d3.addTerm(x[i][j], Read_Double_Auction.getqijk(i, j, k));
					cplex.addLe(d3, Read_Double_Auction.getSik(i, k));
				}
			 

			long endTime = System.currentTimeMillis();
			String X="",Y="",str="";
			
			if (cplex.solve()) {
				
					System.out.println();
					
					System.out.println("F(X,Y)= " + cplex.getObjValue());
					str+="Generation=1  Fitness Function= "+cplex.getObjValue()+ " Time="+(endTime-startTime)+" ms";
					System.out.print("Y= ");
					for (int n= 0; n < N; n++)
						for (int h = 0; h < Read_Double_Auction.getH(n); h++) {
							System.out.print((int) (cplex.getValue(y[n][h])));
							 Y+=((int) (cplex.getValue(y[n][h]))+" ");
						}
					System.out.println();
					System.out.print("X= ");
					for (int i = 0; i < I; i++)
						for (int j = 0; j < Read_Double_Auction.getJ(i); j++) {
							System.out.print((int) (cplex.getValue(x[i][j])) );
							X+=((int) (cplex.getValue(x[i][j]))+" ");
						}
				
			} else {
				System.out.println("not solved");
			}
			System.out.println("\n" + "程式執行時間:" + (endTime - startTime));
			try {
				Output_Result.CPLEX(Y,X,cplex.getObjValue(),endTime-startTime,str);
				Output_EXCEL.main(N,I,K,X,Y,cplex.getObjValue(),0,0,endTime-startTime,endTime-startTime,true);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IloException e) {
			System.err.println("Concert exception '" + e + "' caught");
		}
	}
}
