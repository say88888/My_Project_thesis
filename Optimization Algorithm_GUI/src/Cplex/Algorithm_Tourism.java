package Cplex;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Algorithm_Tourism.Function_Vector;
import Input_Output_txt.Tourism.Output_EXCEL;
import Input_Output_txt.Tourism.Output_Result;
import Input_Output_txt.Tourism.Read_Tourism;
import ilog.concert.IloException;
import ilog.concert.IloLinearNumExpr;
import ilog.concert.IloNumVar;
import ilog.cplex.IloCplex;

public class Algorithm_Tourism extends CPLEX_Tourism {
	public static void CPLEX_Algorithm() throws IOException {
		long startTime = System.currentTimeMillis();
		try {
			IloCplex cplex = new IloCplex();
			// 建立x,y陣列大小
			
			IloNumVar[][] Xa = new IloNumVar[Read_Tourism.Ia()][];
			IloNumVar[][] Xh = new IloNumVar[Read_Tourism.Ih()][];
			IloNumVar[][] Xt = new IloNumVar[Read_Tourism.It()][];
			IloNumVar[][] Y = new IloNumVar[Read_Tourism.N()][];
			 
			for (int i = 0; i < Read_Tourism.Ia(); i++) 
				Xa[i] = new IloNumVar[Read_Tourism.Ja(i)];
			for (int i = 0; i < Read_Tourism.Ih(); i++) 
				Xh[i] = new IloNumVar[Read_Tourism.Jh(i)];
			for (int i = 0; i < Read_Tourism.It(); i++) 
				Xt[i] = new IloNumVar[Read_Tourism.Jt(i)];
			for (int i = 0; i < Read_Tourism.N(); i++) 
				Y[i] = new IloNumVar[Read_Tourism.H(i)];
			
			// x,y矩陣以二進制顯示
			for (int i = 0; i < Read_Tourism.Ia(); i++)
				for (int j = 0; j <Read_Tourism.Ja(i); j++)
					Xa[i][j] = cplex.boolVar();
			for (int i = 0; i < Read_Tourism.Ih(); i++)
				for (int j = 0; j <Read_Tourism.Jh(i); j++)
					Xh[i][j] = cplex.boolVar();
			for (int i = 0; i < Read_Tourism.It(); i++)
				for (int j = 0; j <Read_Tourism.Jt(i); j++)
					Xt[i][j] = cplex.boolVar();
			for (int i = 0; i < Read_Tourism.N(); i++)
				for (int j = 0; j < Read_Tourism.H(i); j++)
					Y[i][j] = cplex.boolVar();
			
			ArrayList<Double> C = Function_Vector.C_Vector(Omega_1,Omega_2);
			 
			// 目標式
			IloLinearNumExpr max = cplex.linearNumExpr();
			IloLinearNumExpr driver = cplex.linearNumExpr();
			 int w=0;
			 for(int n=0;n<2;n++){
				 for (int i = 0; i < Read_Tourism.N(); i++)
					 for (int j = 0; j < Read_Tourism.H(i); j++)
						 max.addTerm(C.get(w++), Y[i][j]);
				 for (int i = 0; i < Read_Tourism.Ia(); i++)
					 for (int j = 0; j < Read_Tourism.Ja(i); j++)
						max.addTerm(C.get(w++), Xa[i][j]);
				 for (int i = 0; i < Read_Tourism.Ih(); i++)
					 for (int j = 0; j < Read_Tourism.Jh(i); j++)
						 max.addTerm(C.get(w++), Xh[i][j]);
				 for (int i = 0; i < Read_Tourism.It(); i++)
					 for (int j = 0; j < Read_Tourism.Jt(i); j++)
						 max.addTerm(C.get(w++), Xt[i][j]);
			 }
			cplex.addMaximize(max );
			
			// 限制式
			IloLinearNumExpr d = cplex.linearNumExpr();
			ArrayList<List<Integer>> A = Function_Vector.A_Vector();
			ArrayList<Integer> B = Function_Vector.B_Vector();
			
			 
			for(int l=0;l<A.size();l++){
				d.clear();
				 int w1=0;
				 for (int i = 0; i < Read_Tourism.N(); i++)
					 for (int j = 0; j < Read_Tourism.H(i); j++)
						 d.addTerm(A.get(l).get(w1++), Y[i][j]);
				 for (int i = 0; i < Read_Tourism.Ia(); i++)
					 for (int j = 0; j < Read_Tourism.Ja(i); j++)
						d.addTerm(A.get(l).get(w1++), Xa[i][j]);
				 for (int i = 0; i < Read_Tourism.Ih(); i++)
					 for (int j = 0; j < Read_Tourism.Jh(i); j++)
						 d.addTerm(A.get(l).get(w1++), Xh[i][j]);
				 for (int i = 0; i < Read_Tourism.It(); i++)
					 for (int j = 0; j < Read_Tourism.Jt(i); j++)
						 d.addTerm(A.get(l).get(w1++), Xt[i][j]);
				 for (int i = 0; i < Read_Tourism.N(); i++)
					 for (int j = 0; j < Read_Tourism.H(i); j++)
						 d.addTerm(A.get(l).get(w1++), Y[i][j]);
				 for (int i = 0; i < Read_Tourism.Ia(); i++)
					 for (int j = 0; j < Read_Tourism.Ja(i); j++)
						d.addTerm(A.get(l).get(w1++), Xa[i][j]);
				 for (int i = 0; i < Read_Tourism.Ih(); i++)
					 for (int j = 0; j < Read_Tourism.Jh(i); j++)
						 d.addTerm(A.get(l).get(w1++), Xh[i][j]);
				 for (int i = 0; i < Read_Tourism.It(); i++)
					 for (int j = 0; j < Read_Tourism.Jt(i); j++)
						 d.addTerm(A.get(l).get(w1++), Xt[i][j]);
				 cplex.addGe(d, B.get(l));
			}
			
			 

			long endTime = System.currentTimeMillis();
			String xa="",xh="",xt="",y="",str="";
			
			if (cplex.solve()) {
				
					System.out.println();
					
					System.out.println("F(X,Y)= " + cplex.getObjValue());
					str+="Generation=1  Fitness Function= "+cplex.getObjValue()+ " Time="+(endTime-startTime)+" ms";
					System.out.print("Y= ");
					for (int i = 0; i < Read_Tourism.N(); i++)
						 for (int j = 0; j < Read_Tourism.H(i); j++) {
							System.out.print((int) (cplex.getValue(Y[i][j])));
							 y+=((int) (cplex.getValue(Y[i][j]))+" ");
						}
					System.out.println();
					System.out.print("Xa= ");
					for (int i = 0; i < Read_Tourism.Ia(); i++)
						 for (int j = 0; j < Read_Tourism.Ja(i); j++){
								System.out.print((int) (cplex.getValue(Xa[i][j])) );
								xa+=((int) (cplex.getValue(Xa[i][j]))+" ");
							}	
					System.out.println();
					System.out.print("Xh= ");
					 for (int i = 0; i < Read_Tourism.Ih(); i++)
						 for (int j = 0; j < Read_Tourism.Jh(i); j++){
								System.out.print((int) (cplex.getValue(Xh[i][j])) );
								xh+=((int) (cplex.getValue(Xh[i][j]))+" ");
							}	
					 System.out.println();
						System.out.print("Xt= ");
					 for (int i = 0; i < Read_Tourism.It(); i++)
						 for (int j = 0; j < Read_Tourism.Jt(i); j++) {
								System.out.print((int) (cplex.getValue(Xt[i][j])) );
								xt+=((int) (cplex.getValue(Xt[i][j]))+" ");
							}	
						
				
			} else {
				System.out.println("not solved");
			}
			System.out.println("\n" + "程式執行時間:" + (endTime - startTime));
			try {
				Output_Result.CPLEX_Tourism(y,xa,xh,xt,cplex.getObjValue(),endTime-startTime,str,A,B,C);
				Output_EXCEL.main(N,Ia,Ih,It,K,Omega_1,Omega_2,xa,xh,xt,y,cplex.getObjValue(),0,0,endTime-startTime,endTime-startTime,true);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IloException e) {
			System.err.println("Concert exception '" + e + "' caught");
		}
	}
}
