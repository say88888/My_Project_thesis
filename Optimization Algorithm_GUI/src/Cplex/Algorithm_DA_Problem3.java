package Cplex;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import Input_Output_txt.Double_Auction.Output_EXCEL;
import Input_Output_txt.Double_Auction.Output_Result;
import Input_Output_txt.Double_Auction.Read_Double_Auction_Problem3;
import Input_Output_txt.Double_Auction.Read_Seller_Price_Parameter;
import ilog.concert.IloException;
import ilog.concert.IloLinearNumExpr;
import ilog.concert.IloNumVar;
import ilog.cplex.IloCplex;

public class Algorithm_DA_Problem3 extends CPLEX_DA_Problem3 {
	public static void CPLEX_Algorithm() {
		long startTime = System.currentTimeMillis();
		try {
			IloCplex cplex = new IloCplex();
			// 建立x,y陣列大小
			IloNumVar[][][][] q = new IloNumVar[I][][][];
	
			for(int i=0;i<I;i++)
				q[i]=new IloNumVar[N][][];
			for(int i=0;i<I;i++)
				for(int n=0;n<N;n++)
					q[i][n]=new IloNumVar[Read_Double_Auction_Problem3.getH(n)][];
			for(int i=0;i<I;i++)
				for(int n=0;n<N;n++)
					for(int h=0;h<Read_Double_Auction_Problem3.getH(n);h++)
					q[i][n][h]=new IloNumVar[K];
			IloNumVar[][] y = new IloNumVar[N][];
			double[][] driver_money = new double[I][K];
			double[][] passenger_money = new double[N][];
			for (int i = 0; i < N; i++) {
				y[i] = new IloNumVar[Read_Double_Auction_Problem3.getH(i)];
				passenger_money[i] = new double[Read_Double_Auction_Problem3.getH(i)];
			}

			// x,y矩陣以二進制顯示
			for (int i = 0; i < I; i++)
				for (int n = 0; n < N; n++)
					for (int h = 0; h < Read_Double_Auction_Problem3.getH(n); h++)
						for (int k = 0; k < K; k++)
							q[i][n][h][k] = cplex.intVar(0, Read_Seller_Price_Parameter.top());
			for (int i = 0; i < N; i++)
				for (int j = 0; j < Read_Double_Auction_Problem3.getH(i); j++)
					y[i][j] = cplex.boolVar();

			// 目標式
			IloLinearNumExpr passenger = cplex.linearNumExpr();
			IloLinearNumExpr driver = cplex.linearNumExpr();

			for (int n = 0; n < N; n++)
				for (int h = 0; h < Read_Double_Auction_Problem3.getH(n); h++) {
					passenger_money[n][h] = Read_Double_Auction_Problem3.getPnh(n, h) + (Read_Double_Auction_Problem3.getTbm() * Read_Double_Auction_Problem3.getPnh(n, h));
					passenger.addTerm(y[n][h], passenger_money[n][h]);
				}
			for (int i = 0; i < I; i++)
				for (int n = 0; n < N; n++)
					for (int h = 0; h < q[i][n].length; h++)
						for (int k = 0; k < K; k++) {
							driver_money[i][k] = Read_Double_Auction_Problem3.getPij(i, k) - (Read_Double_Auction_Problem3.getTsm() * Read_Double_Auction_Problem3.getPij(i, k));
							driver.addTerm(q[i][n][h][k], driver_money[i][k]);
						}
			cplex.addMaximize(cplex.diff(passenger, driver));
			// 限制式
			// 限制1
			IloLinearNumExpr p1 = cplex.linearNumExpr();
			IloLinearNumExpr d1 = cplex.linearNumExpr();
			for (int n = 0; n < N; n++)
				for (int h = 0; h < Read_Double_Auction_Problem3.getH(n); h++)
					for (int k = 0; k < K; k++) {
						p1.clear();
						d1.clear();
						for (int i = 0; i < I; i++)
							d1.addTerm(q[i][n][h][k], 1);
						p1.addTerm(y[n][h], Read_Double_Auction_Problem3.getdnhk(n, h, k));
						cplex.addEq(d1, p1);
					}

			// 限制式2
			IloLinearNumExpr p2 = cplex.linearNumExpr();
			IloLinearNumExpr d2 = cplex.linearNumExpr();
			for (int n = 0; n < N; n++)
				for (int h = 0; h < Read_Double_Auction_Problem3.getH(n); h++) {
					p2.clear();
					d2.clear();
					p2.addTerm(y[n][h], Read_Double_Auction_Problem3.getPnh(n, h));
					for (int i = 0; i < I; i++)
						for (int k = 0; k < K; k++)
							d2.addTerm(q[i][n][h][k], Read_Double_Auction_Problem3.getPij(i, k));
					cplex.addGe(p2, d2);
				}

			// 限制式3
			IloLinearNumExpr d3 = cplex.linearNumExpr();
			for (int i = 0; i < I; i++)
				for (int k = 0; k < K; k++) {
					d3.clear();
					for (int n = 0; n < N; n++)
						for (int h = 0; h < Read_Double_Auction_Problem3.getH(n); h++)
							d3.addTerm(q[i][n][h][k], 1);
					cplex.addLe(d3, Read_Double_Auction_Problem3.getSik(i, k));
				}

			long endTime = System.currentTimeMillis();
			String X = "", Y = "", str = "";

			if (cplex.solve()) {

				System.out.println();

				System.out.println("F(X,Y)= " + cplex.getObjValue());
				str += "Generation=1  Fitness Function= " + cplex.getObjValue() + " Time=" + (endTime - startTime) + " ms";
				System.out.print("Y= ");
				for (int n = 0; n < N; n++)
					for (int h = 0; h < Read_Double_Auction_Problem3.getH(n); h++) {
						System.out.print((int) (cplex.getValue(y[n][h])));
						Y += ((int) (cplex.getValue(y[n][h])) + " ");
					}
				System.out.println();
				System.out.print("q= ");
		
				for (int i = 0; i < I; i++)
					for (int n = 0; n < N; n++)
						for (int h = 0; h < Read_Double_Auction_Problem3.getH(n); h++){
							for (int k = 0; k < K; k++) {
								System.out.print((int) (cplex.getValue(q[i][n][h][k])));
								X += ((int) (cplex.getValue(q[i][n][h][k])) + " ");
								
							}
						System.out.println( );
						}
			} else {
				System.out.println("not solved");
			}
			System.out.println("\n" + "程式執行時間:" + (endTime - startTime));
			try {
				Output_Result.CPLEX(Y, X, cplex.getObjValue(), endTime - startTime, str);
				Output_EXCEL.main(N, I, K, X, Y, cplex.getObjValue(), 0, 0, endTime - startTime, endTime - startTime, true);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IloException e) {
			System.err.println("Concert exception '" + e + "' caught");
		}
	}
}
