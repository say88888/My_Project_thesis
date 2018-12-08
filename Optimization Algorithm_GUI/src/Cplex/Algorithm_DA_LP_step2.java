package Cplex;

import ilog.concert.IloException;
import ilog.concert.IloLinearNumExpr;
import ilog.concert.IloNumVar;
import ilog.cplex.IloCplex;

import java.io.IOException;






import Input_Output_txt.Double_Auction.Output_EXCEL;
import Input_Output_txt.Double_Auction.Output_Result;
import Input_Output_txt.Double_Auction.Read_Double_Auction;

public class Algorithm_DA_LP_step2 extends CPLEX_DA_LP {
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
			String[] XAfterSplit = X.split(" ");
		//	for (int i = 0; i < XAfterSplit.length; i++)
		//	    System.out.println(XAfterSplit[i]);
			String[] YAfterSplit = Y.split(" ");
		//	for (int i = 0; i < YAfterSplit.length; i++)
		//	    System.out.println(YAfterSplit[i]);
			int a=0;
			// x,y矩陣以實數顯示	 
			for (int i = 0; i < I; i++)
				for (int j = 0; j <Read_Double_Auction.getJ(i); j++){
					if(Double.parseDouble(XAfterSplit[a])==0 )
						x[i][j]=cplex.numVar(0, 0);
					else if(Double.parseDouble(XAfterSplit[a])==1)
						x[i][j]=cplex.numVar(1, 1);
					else
						x[i][j]=cplex.numVar(0, 1);
					a+=1;
				}
			a=0;
			for (int i = 0; i < N; i++)
				for (int j = 0; j < Read_Double_Auction.getH(i); j++){
					if(Double.parseDouble(YAfterSplit[a])==0 )
						y[i][j]=cplex.numVar(0, 0);
					else if(Double.parseDouble(YAfterSplit[a])==1)
						y[i][j]=cplex.numVar(1, 1);
					else
						y[i][j] = cplex.numVar(0, 1);
					a+=1;
				}
			 
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
		

		 	cplex.addMaximize( cplex.diff(passenger, driver)   );
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
			String X="",Y="",str="";
			
			if (cplex.solve()) {
				
					System.out.println();
					
					System.out.println("F(X,Y)= " + cplex.getObjValue());
					Fitness= cplex.getObjValue();
					str+="Generation=1  Fitness Function= "+cplex.getObjValue()+ " Time="+(endTime-startTime)+" ms";
					System.out.print("Y= ");
					int a1=0;
					for (int n= 0; n < N; n++)
						for (int h = 0; h < Read_Double_Auction.getH(n); h++) {
							System.out.print( (cplex.getValue(y[n][h]))+" ");
							 Y+=( (cplex.getValue(y[n][h]))+" ");
							 Y_LP[a1++]=(cplex.getValue(y[n][h]));
						}
					System.out.println();
					System.out.print("X= ");
					a1=0;
					for (int i = 0; i < I; i++)
						for (int j = 0; j < Read_Double_Auction.getJ(i); j++) {
							System.out.print( (cplex.getValue(x[i][j])) +" ");
							X+=( (cplex.getValue(x[i][j]))+" ");
							 X_LP[a1++]=(cplex.getValue(x[i][j]));
						}
				
			} else {
				System.out.println("not solved");
			}
			System.out.println("\n" + "程式執行時間:" + (endTime - startTime));
			try {
				Output_Result.CPLEX_LP(Y,X,cplex.getObjValue(),endTime-startTime,str);
				Output_EXCEL.main(N, I, K, X, Y, cplex.getObjValue(), 0, 0, endTime-startTime, endTime-startTime,true);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IloException e) {
			System.err.println("Concert exception '" + e + "' caught");
		}
	}

}
