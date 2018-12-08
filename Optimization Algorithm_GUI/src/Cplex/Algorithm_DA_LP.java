package Cplex;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import Input_Output_txt.Double_Auction.Read_Double_Auction;
import ilog.concert.IloException;
import ilog.concert.IloIntSetVar;
import ilog.concert.IloLinearNumExpr;
import ilog.concert.IloNumExpr;
import ilog.concert.IloNumVar;
import ilog.cplex.IloCplex;

public class Algorithm_DA_LP extends CPLEX_DA_LP {
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
			// x,y矩陣以實數顯示
			for (int i = 0; i < I; i++)
				for (int j = 0; j <Read_Double_Auction.getJ(i); j++)
					x[i][j] = cplex.numVar(0, 1);
				//	x[i][j] = cplex.boolVar();
			for (int i = 0; i < N; i++)
				for (int j = 0; j < Read_Double_Auction.getH(i); j++)
					y[i][j] =cplex.numVar(0, 1);
				//	y[i][j] = cplex.boolVar();
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
			IloLinearNumExpr penalty_Xup = cplex.linearNumExpr();
			IloLinearNumExpr penalty_Xdn = cplex.linearNumExpr();
			double penalty_X=0;
			for(int k=0;k<X_Nup.size();k++){
				int num=0;
				for (int i = 0; i < I; i++)
					for (int j = 0; j < Read_Double_Auction.getJ(i); j++) {
						if(num++==X_Nup.get(k)){
							penalty_X+=X_M.get(X_Nup.get(k));
							penalty_Xup.addTerm(X_M.get(X_Nup.get(k)), x[i][j]);
						}
					}
			}
			for(int k=0;k<X_Ndn.size();k++){
				int num=0;
				for (int i = 0; i < I; i++)
					for (int j = 0; j < Read_Double_Auction.getJ(i); j++) {
						if(num++==X_Ndn.get(k))
							penalty_Xdn.addTerm(X_M.get(X_Ndn.get(k)), x[i][j]);
					}
			}
			IloLinearNumExpr penalty_Yup = cplex.linearNumExpr();
			IloLinearNumExpr penalty_Ydn = cplex.linearNumExpr();
			double penalty_Y=0;
			for(int k=0;k<Y_Nup.size();k++){
				int num=0;
				for (int n = 0; n < N; n++)
					for (int h = 0; h < Read_Double_Auction.getH(n); h++) {
						if(num++==Y_Nup.get(k)){
							penalty_Y+=Y_M.get(Y_Nup.get(k));
							penalty_Yup.addTerm(Y_M.get(Y_Nup.get(k)), y[n][h]);
						}
					}
			}
			for(int k=0;k<Y_Ndn.size();k++){
				int num=0;
				for (int n = 0; n < N; n++)
					for (int h = 0; h < Read_Double_Auction.getH(n); h++) {
						if(num++==Y_Ndn.get(k))
							penalty_Ydn.addTerm(Y_M.get(Y_Ndn.get(k)), y[n][h]);
					}
			}
			 
		 	cplex.addMaximize( cplex.prod(-1, cplex.sum(cplex.sum(penalty_Xdn,cplex.diff(penalty_X, penalty_Xup)), cplex.sum(penalty_Ydn,cplex.diff(penalty_Y, penalty_Yup))))  );

		// 	cplex.addMaximize(cplex.diff(cplex.sum(cplex.diff(cplex.diff(cplex.sum(penalty_Y, penalty_Yup), penalty_Ydn), penalty_X), penalty_Xup), penalty_Xdn)  );
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
		 
				cplex.addGe(cplex.diff(passenger, driver), x0+Epsilon);
				
			long endTime = System.currentTimeMillis();
			String str="";
			X="";Y="";
			if (cplex.solve()) {
				right=true;
					System.out.println();
					
					System.out.println("F(X,Y)= " + cplex.getObjValue());
				//	Fitness= cplex.getObjValue();
					str+="Generation=1  Fitness Function= "+cplex.getObjValue()+ " Time="+(endTime-startTime)+" ms";
					System.out.print("Y= ");
					int a1=0;
					for (int n= 0; n < N; n++)
						for (int h = 0; h < Read_Double_Auction.getH(n); h++) {
							System.out.print( (cplex.getValue(y[n][h]))+" ");
							 Y+=( (cplex.getValue(y[n][h]))+" ");
						//	 Y_LP1[a1++]=(cplex.getValue(y[n][h]));
						}
					System.out.println();
					System.out.print("X= ");
					a1=0;
					for (int i = 0; i < I; i++)
						for (int j = 0; j < Read_Double_Auction.getJ(i); j++) {
							System.out.print( (cplex.getValue(x[i][j])) +" ");
							X+=( (cplex.getValue(x[i][j]))+" ");
						//	 X_LP1[a1++]=(cplex.getValue(x[i][j]));
						}
					System.out.println();
					System.out.println();
					System.out.println("CPLEX第二步驟  解F(X,Y) ");
					Algorithm_DA_LP_step2.CPLEX_Algorithm();
					
			} else {
				System.out.println("not solved");
			}
			System.out.println("\n" + "程式執行時間:" + (endTime - startTime));
		} catch (IloException e) {
			System.err.println("Concert exception '" + e + "' caught");
		}
	}

}
