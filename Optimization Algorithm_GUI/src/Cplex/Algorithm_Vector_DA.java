package Cplex;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Algorithm_DoubleAuction.Function_Vector_DA;
import Input_Output_txt.Double_Auction.Output_Result;
import Input_Output_txt.Double_Auction.Read_Double_Auction;
import ilog.concert.IloException;
import ilog.concert.IloLinearNumExpr;
import ilog.concert.IloNumVar;
import ilog.cplex.IloCplex;

public class Algorithm_Vector_DA extends CPLEX_Vector_DA {
	public static void CPLEX_Algorithm() throws IOException {
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
			IloLinearNumExpr max = cplex.linearNumExpr();
			 
			ArrayList<Double> C = Function_Vector_DA.C_Vector();
			 int w=0;
			 for (int i = 0; i < N; i++)
					for (int j = 0; j < Read_Double_Auction.getH(i); j++)
						 max.addTerm(C.get(w++), y[i][j]);
			 for (int i = 0; i < I; i++)
					for (int j = 0; j <Read_Double_Auction.getJ(i); j++)
						 max.addTerm(C.get(w++), x[i][j]);
			cplex.addMaximize(max );
			// 限制式
			// 限制1
			IloLinearNumExpr d = cplex.linearNumExpr();
			ArrayList<List<Integer>> A = Function_Vector_DA.A_Vector();
			ArrayList<Integer> B = Function_Vector_DA.B_Vector();
			for(int l=0;l<A.size();l++){
				d.clear();
				 int w1=0;
				 for (int i = 0; i < Read_Double_Auction.getN(); i++)
					 for (int j = 0; j < Read_Double_Auction.getH(i); j++)
						 d.addTerm(A.get(l).get(w1++), y[i][j]);
				 for (int i = 0; i < Read_Double_Auction.getI(); i++)
					 for (int j = 0; j < Read_Double_Auction.getJ(i); j++)
						d.addTerm(A.get(l).get(w1++), x[i][j]);
				 
				 cplex.addGe(d, B.get(l));
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
				Output_Result.CPLEX_Vector(Y,X,cplex.getObjValue(),endTime-startTime,str,A,B,C);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IloException e) {
			System.err.println("Concert exception '" + e + "' caught");
		}
	}
}
