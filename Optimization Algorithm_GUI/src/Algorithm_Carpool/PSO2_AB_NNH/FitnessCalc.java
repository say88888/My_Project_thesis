package Algorithm_Carpool.PSO2_AB_NNH;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import Generate_random_data.Read_Generate_random_OilConsumptionBounds;
import Input_Output_txt.Carpool.Read_file;
import READ_TXT.Read_INPUT_TXT_filter;
import READ_TXT.Read_distance;
import carpool_Alogorithm_MOD.Calculate_the_function;
import carpool_Alogorithm_MOD.TimeCalculate;

public class FitnessCalc extends PSO2_AB_NNH {
	
	// F2(X,Y)
	static double getFitness(G_Individual individual) {
	
		double fitness = 0;

		List<List<Integer>> Dlist = new ArrayList<List<Integer>>();
		int[][] Adp = new int[D][P];
		for (int d = 0; d < D; d++){
			List<Integer> list = new ArrayList<Integer>();
			for (int p = 0; p < P; p++) {
				if (individual.getGA(p) == (d + 1)){
					Adp[d][p] = 1;
					list.add(p+1);
				}else
					Adp[d][p] = 0;
			}
			Dlist.add(list);
		}
		List<List<Integer>> Bdm = new ArrayList<List<Integer>>();
		for (int d = 0; d < D; d++) {
			List<Integer> B = new ArrayList<Integer>();
			for (int i = 0; i < individual.GBsize(); i++)
				for(int j=0;j<Dlist.get(d).size();j++){
					if (Math.abs(individual.getGB(i)) == (Dlist.get(d).get(j)))
							B.add(individual.getGB(i));
					}
			Bdm.add(B);
		}

		int[][][] Cdmp = new int[D][][];
		for (int i = 0; i < D; i++)
			Cdmp[i] = new int[Bdm.get(i).size()][P];
		for (int d = 0; d < D; d++) {
			for (int m = 0; m < Cdmp[d].length; m++) {
				for (int p = 0; p < P; p++) {
					if (Bdm.get(d).get(m) == (p + 1))
						Cdmp[d][m][p] = 1;
					else if (Bdm.get(d).get(m) == (-(p + 1)))
						Cdmp[d][m][p] = -1;
					else
						Cdmp[d][m][p] = 0;
				}
			}
		}

		String[][] Tdm = new String[Bdm.size()][];
		for (int i = 0; i < Tdm.length; i++)
			Tdm[i] = new String[Bdm.get(i).size()+2];
		Tdm =Tdm(Bdm);
		
		int[][] Y = new int[P][];
		for (int i = 0; i < Y.length; i++)
			Y[i] = new int[1];
		for (int p = 0; p < Y.length; p++)
			for (int h = 0; h < Y[p].length; h++) {
				for (int d = 0; d < D; d++)
					Y[p][h] += Adp[d][p];
			}

		int[][] X = new int[D][];
		for (int i = 0; i < D; i++)
			X[i] = new int[1];
		for (int d = 0; d < X.length; d++) {
			for (int j = 0; j < X[d].length; j++) {
				int a = 0;
				for (int p = 0; p < P; p++)
					a += Adp[d][p];
				if (a >= 1)
					X[d][j] = 1;
				else
					X[d][j] = 0;
			}
		}
		Object_Function.Function(X, Y, Bdm);
		
			fitness = Fitness(X, Y, Bdm);
			SFminsb.append(fitness + " ");
		return fitness;
	}
	
	static double getFitness1(Individual individual) {
		
		double fitness = 0;

		List<List<Integer>> Dlist = new ArrayList<List<Integer>>();
		int[][] Adp = new int[D][P];
		for (int d = 0; d < D; d++){
			List<Integer> list = new ArrayList<Integer>();
			for (int p = 0; p < P; p++) {
				if (individual.getA(p) == (d + 1)){
					Adp[d][p] = 1;
					list.add(p+1);
				}else
					Adp[d][p] = 0;
			}
			Dlist.add(list);
		}
		List<List<Integer>> Bdm = new ArrayList<List<Integer>>();
		for (int d = 0; d < D; d++) {
			List<Integer> B = new ArrayList<Integer>();
			for (int i = 0; i < individual.Bsize(); i++)
				for(int j=0;j<Dlist.get(d).size();j++){
					if (Math.abs(individual.getB(i)) == (Dlist.get(d).get(j)))
							B.add(individual.getB(i));
					}
			Bdm.add(B);
		}

		int[][][] Cdmp = new int[D][][];
		for (int i = 0; i < D; i++)
			Cdmp[i] = new int[Bdm.get(i).size()][P];
		for (int d = 0; d < D; d++) {
			for (int m = 0; m < Cdmp[d].length; m++) {
				for (int p = 0; p < P; p++) {
					if (Bdm.get(d).get(m) == (p + 1))
						Cdmp[d][m][p] = 1;
					else if (Bdm.get(d).get(m) == (-(p + 1)))
						Cdmp[d][m][p] = -1;
					else
						Cdmp[d][m][p] = 0;
				}
			}
		}

		String[][] Tdm = new String[Bdm.size()][];
		for (int i = 0; i < Tdm.length; i++)
			Tdm[i] = new String[Bdm.get(i).size()+2];
		Tdm =Tdm(Bdm);
		
		int[][] Y = new int[P][];
		for (int i = 0; i < Y.length; i++)
			Y[i] = new int[1];
		for (int p = 0; p < Y.length; p++)
			for (int h = 0; h < Y[p].length; h++) {
				for (int d = 0; d < D; d++)
					Y[p][h] += Adp[d][p];
			}

		int[][] X = new int[D][];
		for (int i = 0; i < D; i++)
			X[i] = new int[1];
		for (int d = 0; d < X.length; d++) {
			for (int j = 0; j < X[d].length; j++) {
				int a = 0;
				for (int p = 0; p < P; p++)
					a += Adp[d][p];
				if (a >= 1)
					X[d][j] = 1;
				else
					X[d][j] = 0;
			}
		}

		// F(X,Y)
		// if((st22==K)&&(st23>=0)&&(st24==Xsize)&&(st25==Xsize)&&(st26<=D) ){
		Object_Function.Function(X, Y, Bdm);
		
		if (constraint(X, Y, Adp, Bdm, Cdmp,Tdm) == true) {
			fitness = Fitness(X, Y, Bdm);
			SFminsb.append(fitness + " ");
		}
		// U1(X,Y)
		else {
			double Sfmin;
			Sfmin = PSO2_AB_NNH.Sfmin;
			fitness = Sfmin + U1(X, Y, Adp, Bdm, Cdmp,Tdm);
		}
		return fitness;
	}
	
	static double getPFitness(P_Individual individual) {

		int c = 0;
		double fitness = 0;

		List<List<Integer>> Dlist = new ArrayList<List<Integer>>();
		int[][] Adp = new int[D][P];
		for (int d = 0; d < D; d++){
			List<Integer> list = new ArrayList<Integer>();
			for (int p = 0; p < P; p++) {
				if (individual.getPA(p) == (d + 1)){
					Adp[d][p] = 1;
					list.add(p+1);
				}else
					Adp[d][p] = 0;
			}
			Dlist.add(list);
		}
		List<List<Integer>> Bdm = new ArrayList<List<Integer>>();
		for (int d = 0; d < D; d++) {
			List<Integer> B = new ArrayList<Integer>();
			for (int i = 0; i < individual.PBsize(); i++)
				for(int j=0;j<Dlist.get(d).size();j++){
					if (Math.abs(individual.getPB(i)) == (Dlist.get(d).get(j)))
							B.add(individual.getPB(i));
					}
			Bdm.add(B);
		}

		int[][][] Cdmp = new int[D][][];
		for (int i = 0; i < D; i++)
			Cdmp[i] = new int[Bdm.get(i).size()][P];
		for (int d = 0; d < D; d++) {
			for (int m = 0; m < Cdmp[d].length; m++) {
				for (int p = 0; p < P; p++) {
					if (Bdm.get(d).get(m) == (p + 1))
						Cdmp[d][m][p] = 1;
					else if (Bdm.get(d).get(m) == (-(p + 1)))
						Cdmp[d][m][p] = -1;
					else
						Cdmp[d][m][p] = 0;
				}
			}
		}

		String[][] Tdm = new String[Bdm.size()][];
		for (int i = 0; i < Tdm.length; i++)
			Tdm[i] = new String[Bdm.get(i).size()+2];
		Tdm =Tdm(Bdm);
		
		int[][] Y = new int[P][];
		for (int i = 0; i < Y.length; i++)
			Y[i] = new int[1];
		for (int p = 0; p < Y.length; p++)
			for (int h = 0; h < Y[p].length; h++) {
				for (int d = 0; d < D; d++)
					Y[p][h] += Adp[d][p];
			}

		int[][] X = new int[D][];
		for (int i = 0; i < D; i++)
			X[i] = new int[1];
		for (int d = 0; d < X.length; d++) {
			for (int j = 0; j < X[d].length; j++) {
				int a = 0;
				for (int p = 0; p < P; p++)
					a += Adp[d][p];
				if (a >= 1)
					X[d][j] = 1;
				else
					X[d][j] = 0;
			}
		}
		Object_Function.Function(X, Y, Bdm);
		
		if (constraint(X, Y, Adp, Bdm, Cdmp,Tdm) == true) {
			fitness = Fitness(X, Y, Bdm);
			SFminsb.append(fitness + " ");
		}
		// U1(X,Y)
		else {
			double Sfmin;
			Sfmin = PSO2_AB_NNH.Sfmin;
			fitness = Sfmin + U1(X, Y, Adp, Bdm, Cdmp,Tdm);
		}
		return fitness;
	}
	
	static double getGFitness(G_Individual individual) {

		int c = 0;
		double fitness = 0;

		List<List<Integer>> Dlist = new ArrayList<List<Integer>>();
		int[][] Adp = new int[D][P];
		for (int d = 0; d < D; d++){
			List<Integer> list = new ArrayList<Integer>();
			for (int p = 0; p < P; p++) {
				if (individual.getGA(p) == (d + 1)){
					Adp[d][p] = 1;
					list.add(p+1);
				}else
					Adp[d][p] = 0;
			}
			Dlist.add(list);
		}
		List<List<Integer>> Bdm = new ArrayList<List<Integer>>();
		for (int d = 0; d < D; d++) {
			List<Integer> B = new ArrayList<Integer>();
			for (int i = 0; i < individual.GBsize(); i++)
				for(int j=0;j<Dlist.get(d).size();j++){
					if (Math.abs(individual.getGB(i)) == (Dlist.get(d).get(j)))
							B.add(individual.getGB(i));
					}
			Bdm.add(B);
		}

		int[][][] Cdmp = new int[D][][];
		for (int i = 0; i < D; i++)
			Cdmp[i] = new int[Bdm.get(i).size()][P];
		for (int d = 0; d < D; d++) {
			for (int m = 0; m < Cdmp[d].length; m++) {
				for (int p = 0; p < P; p++) {
					if (Bdm.get(d).get(m) == (p + 1))
						Cdmp[d][m][p] = 1;
					else if (Bdm.get(d).get(m) == (-(p + 1)))
						Cdmp[d][m][p] = -1;
					else
						Cdmp[d][m][p] = 0;
				}
			}
		}

		String[][] Tdm = new String[Bdm.size()][];
		for (int i = 0; i < Tdm.length; i++)
			Tdm[i] = new String[Bdm.get(i).size()+2];
		Tdm =Tdm(Bdm);
		
		int[][] Y = new int[P][];
		for (int i = 0; i < Y.length; i++)
			Y[i] = new int[1];
		for (int p = 0; p < Y.length; p++)
			for (int h = 0; h < Y[p].length; h++) {
				for (int d = 0; d < D; d++)
					Y[p][h] += Adp[d][p];
			}

		int[][] X = new int[D][];
		for (int i = 0; i < D; i++)
			X[i] = new int[1];
		for (int d = 0; d < X.length; d++) {
			for (int j = 0; j < X[d].length; j++) {
				int a = 0;
				for (int p = 0; p < P; p++)
					a += Adp[d][p];
				if (a >= 1)
					X[d][j] = 1;
				else
					X[d][j] = 0;
			}
		}
		Object_Function.Function(X, Y, Bdm);
		
		if (constraint(X, Y, Adp, Bdm, Cdmp,Tdm) == true) {
			fitness = Fitness(X, Y, Bdm);
			SFminsb.append(fitness + " ");
		}
		// U1(X,Y)
		else {
			double Sfmin;
			Sfmin = PSO2_AB_NNH.Sfmin;
			fitness = Sfmin + U1(X, Y, Adp, Bdm, Cdmp,Tdm);
		}
		return fitness;
	}
	
	static double Fitness(int[][] X, int[][] Y, List<List<Integer>> Bdm) {
		double fitness = 0, fitness2 = 0,fitness3=0,fitness4=0,fitness5=0,fitness6=0,fitness7=0;
		for (int p = 0; p < P; p++)
			for (int h = 0; h < Y[p].length; h++) {
				fitness += Y[p][h] * fph(p);
				fitness += Y[p][h] * Read_file.getTpm()*fph(p);
				fitness2 += Y[p][h];
				
				fitness5 += Y[p][h] * fph(p);
			}
		for (int d = 0; d < D; d++)
			for (int j = 0; j < X[d].length; j++) {
				fitness -= X[d][j]
						* (Cdj(d, Bdm.get(d)) - Odj(d));
				fitness += X[d][j] * Read_file.getTdm()
						* (Cdj(d, Bdm.get(d)) - Odj(d));
				fitness2 += X[d][j];
				
				fitness5 += X[d][j] * Cdj(d, Bdm.get(d)) ;
			}
		
		if(fitness2>0) {
		fitness3 = (fitness/fitness2)*Omega_3;
		fitness4=Omega_4*(wp*Object_Function.get_aps()+Object_Function.get_ads()*wd);
		fitness5 = (fitness/fitness5)*Omega_5;
		fitness *= Omega_1;
		fitness2 *= Omega_2;
		fitness6=Omega_6*Object_Function.get_cp_all_actual();
		fitness7=Omega_7*((Object_Function.get_cp_p()*wp1)+(Object_Function.get_cp_d()*wd1));
		
	//	System.err.print("NOT_U1"+(fitness + fitness2 + fitness3 + fitness5+fitness6+fitness7));
		return fitness + fitness2 + fitness3+fitness4 + fitness5+fitness6+fitness7;
		
		}
		else {
			return 0;
		}
	}

	static double U1(int[][] X, int[][] Y, int[][] Adp,
			List<List<Integer>> Bdm, int[][][] Cdmp, String[][] Tdm) {
		double fitness = 0;

		double s3 = 0, s4 = 0;
		for (int p = 0; p < P; p++) {
			for (int h = 0; h < Y[p].length; h++)
				s3 += Y[p][h] * fph(p);
		}
		for (int d = 0; d < D; d++) {
			for (int j = 0; j < X[d].length; j++)
				s4 += X[d][j] * (Cdj(d, Bdm.get(d)) - Odj(d));
		}
		fitness += Math.min(s3 - s4, 0.0);

		/*for (int d = 0; d < D; d++) {
			double s5 = 0;
			for (int p = 0; p < P; p++)
				s5 += Adp[d][p];
			fitness += Math.min(Read_INPUT_TXT_filter.getP_NUMBER(d) - s5, 0.0);
		}
		 */
		for (int d = 0; d < D; d++) {
			double s6 = 0;
			for (int p = 0; p < P; p++)
				s6 += Adp[d][p] * Read_INPUT_TXT_filter.getweight(p);
			fitness += Math.min(Read_INPUT_TXT_filter.getWeight_Limit(d) - s6,
					0.0);
		}
		TimeCalculate c1 = new TimeCalculate();
		for(int p=0;p<P;p++){
			double s7=0;
			for(int d=0;d<D;d++)
				for(int m=0;m<Cdmp[d].length;m++){
					try {
						s7+=Adp[d][p]*Cdmp[d][m][p]*(c1.reducetime(Tdm[d][m+1],Read_INPUT_TXT_filter.getP_F_R_Time(p)));
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			fitness += Math.min(s7, 0.0);
		}
		
		for(int p=0;p<P;p++){
			double s8=0;
			for(int d=0;d<D;d++)
				for(int m=0;m<Cdmp[d].length;m++){
					try {
						s8+=Adp[d][p]*Cdmp[d][m][p]*(c1.reducetime(Tdm[d][m+1],Read_INPUT_TXT_filter.getP_D_A_Time(p)));
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			fitness += Math.min(s8, 0.0);
		}
		
		for(int d=0;d<D;d++){
			int s=0;
			for(int p=0;p<P;p++)
				s+=Adp[d][p];
			if(s>=1)
				s=1;
			try {
				fitness+=Math.min((c1.reducetime(Tdm[d][0],Read_INPUT_TXT_filter.getD_F_D_Time(d)))*s, 0.0);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		for(int d=0;d<D;d++){
			int s=0;
			for(int p=0;p<P;p++)
				s+=Adp[d][p];
			if(s>=1)
				s=1;
			try {
				fitness+=Math.min((c1.reducetime(Tdm[d][Tdm[d].length-1],Read_INPUT_TXT_filter.getD_S_A_Time(d)))*s, 0.0);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//(2-14)
		fitness+=Math.min(Object_Function.get_aps()-(1-Epsilon1)*Object_Function.get_ads(),0.0);
		fitness+=Math.min((1+Epsilon2)*Object_Function.get_ads()-Object_Function.get_aps(),0.0);
		//(2-15)
		fitness+=Math.min(Object_Function.get_cp_p()-(1-Epsilon3)*Object_Function.get_cp_d(),0.0);
		fitness+=Math.min((1+Epsilon4)*Object_Function.get_cp_d()-Object_Function.get_cp_p(),0.0);
		
		return fitness;
	}

	static boolean constraint(int[][] X, int[][] Y, int[][] Adp, List<List<Integer>> Bdm, int[][][] Cdmp, String[][] Tdm) {
		boolean right = true;
		double s3 = 0, s4 = 0;
		for (int p = 0; p < P; p++) {
			for (int h = 0; h < Y[p].length; h++)
				s3 += Y[p][h] * fph(p);
		}
		for (int d = 0; d < D; d++) {
			for (int j = 0; j < X[d].length; j++)
				s4 += X[d][j] * (Cdj(d, Bdm.get(d)) -Odj(d));
		}
		if(s3<s4)
			right=false;

		for (int d = 0; d < D; d++) {
			double s5 = 0;
			for (int p = 0; p < P; p++)
				s5 += Adp[d][p];
			if(Read_INPUT_TXT_filter.getP_NUMBER(d)<s5)
				right=false;
		
		}

		for (int d = 0; d < D; d++) {
			double s6 = 0;
			for (int p = 0; p < P; p++)
				s6 += Adp[d][p] * Read_INPUT_TXT_filter.getweight(p);
			if(Read_INPUT_TXT_filter.getWeight_Limit(d)<s6)
				right=false;
		
		}
		
		for(int p=0;p<P;p++){
			int s=0;
			for(int d=0;d<D;d++)
				s+=Adp[d][p];
			if(s>1)
				right=false;
		}
		
		TimeCalculate c1 = new TimeCalculate();
		for(int p=0;p<P;p++){
			double s7=0;
			for(int d=0;d<D;d++)
				for(int m=0;m<Cdmp[d].length;m++){
					try {
						s7+=Adp[d][p]*Cdmp[d][m][p]*(c1.reducetime(Tdm[d][m+1],Read_INPUT_TXT_filter.getP_F_R_Time(p)));
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
			if(s7<0)
				right=false;
		}
		
		for(int p=0;p<P;p++){
			double s8=0;
			for(int d=0;d<D;d++)
				for(int m=0;m<Cdmp[d].length;m++){
					try {
						s8+=Adp[d][p]*Cdmp[d][m][p]*(c1.reducetime(Tdm[d][m+1],Read_INPUT_TXT_filter.getP_D_A_Time(p)));
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			if(s8<0)
				right=false;
		}
		
		for(int d=0;d<D;d++){
			int s=0;
			for(int p=0;p<P;p++)
				s+=Adp[d][p];
			if(s>=1)
				s=1;
			try {
				if((c1.reducetime(Tdm[d][0],Read_INPUT_TXT_filter.getD_F_D_Time(d)))*s<0)
					right=false;
			
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		for(int d=0;d<D;d++){
			int s=0;
			for(int p=0;p<P;p++)
				s+=Adp[d][p];
			if(s>=1)
				s=1;
			try {
				if((c1.reducetime(Tdm[d][Tdm[d].length-1],Read_INPUT_TXT_filter.getD_S_A_Time(d)))*s<0)
					right=false;
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//(2-14)
		 if((Omega_4*(1-Epsilon1)*Object_Function.get_ads()) <= (Omega_4*Object_Function.get_aps())
					&& (Omega_4*Object_Function.get_aps()) >= (Omega_4*(1-Epsilon1)*Object_Function.get_ads())
					&& (Omega_4*Object_Function.get_aps()) <= (Omega_4*(1+Epsilon2)*Object_Function.get_ads()))
					 {}
					 else{
				 right=false;}
		//(2-15)
		 if((Omega_7*(1-Epsilon3)*Object_Function.get_cp_d()) <= (Omega_7*Object_Function.get_cp_p())
		&& (Omega_7*Object_Function.get_cp_p()) >= (Omega_7*(1-Epsilon3)*Object_Function.get_cp_d())
		&& (Omega_7*Object_Function.get_cp_p()) <= (Omega_7*(1+Epsilon4)*Object_Function.get_cp_d()))
		 {}
		 else{
			 right=false;}
			 
		return right;
	}

	static double getSFmin(StringBuilder sb) {
		double SFmin;
		String[] a = sb.toString().split(" ");
		if (a.length == 1) {
			SFmin = 0;
		} else {
			SFmin = Double.parseDouble(a[0]);
			for (int i = 0; i < a.length; i++)
				if (SFmin >= Double.parseDouble(a[i]))
					SFmin = Double.parseDouble(a[i]);

		}
		SFminsb = new StringBuilder();
		return SFmin;
	}

	static double Cdj(int d, List<Integer> Bdm) {

		int location1, location2, k;
		int qdjk=0;
		double route = 0;
		location1 = Integer.parseInt(Read_INPUT_TXT_filter.getD_S_PLACE(d));
		for (int i = 0; i < Bdm.size(); i++) {
			if (Bdm.get(i) > 0) {
				k = Bdm.get(i);
				location2 = Integer.parseInt(Read_INPUT_TXT_filter
						.getP_R_PLACE(k - 1));
				route += Read_distance.getDistance(location1, location2);
				location1 = location2;
				qdjk++;
			} else if (Bdm.get(i) < 0) {
				k = -(Bdm.get(i));
				location2 = Integer.parseInt(Read_INPUT_TXT_filter
						.getP_D_ADDRESS(k - 1));
				route += Read_distance.getDistance(location1, location2);
				location1 = location2;
			}
		}
		location2 = Integer.parseInt(Read_INPUT_TXT_filter.getD_D_ADDRESS(d));
		route += Read_distance.getDistance(location1, location2);
		double cost = Calculate_the_function.Cdj_cost(route,
				Read_INPUT_TXT_filter.getDriverOilConsumption(d),
				Read_Generate_random_OilConsumptionBounds.Driver_OilPrice(),"Single_mode",qdjk);
		return cost;
	}
	
	static double fph(int p) {

		int location1, location2, k;
		double route = 0;
		location1 = Integer.parseInt(Read_INPUT_TXT_filter.getP_R_PLACE(p));
		
		location2 = Integer.parseInt(Read_INPUT_TXT_filter	.getP_D_ADDRESS(p));
		route += Read_distance.getDistance(location1, location2);
			

		double cost = Calculate_the_function.Fph_cost(route,
				Read_INPUT_TXT_filter.getPassengerOilConsumption(p),
				Read_Generate_random_OilConsumptionBounds.Passenger_OilPrice());
		return cost;
	}
	
	static double Odj(int d) {

		int location1, location2, k;
		double route = 0;
		location1 = Integer.parseInt(Read_INPUT_TXT_filter.getD_S_PLACE(d));
		
		location2 = Integer.parseInt(Read_INPUT_TXT_filter	.getD_D_ADDRESS(d));
		route += Read_distance.getDistance(location1, location2);
			

		double cost = Calculate_the_function.Fph_cost(route,
				Read_INPUT_TXT_filter.getDriverOilConsumption(d),
				Read_Generate_random_OilConsumptionBounds.Driver_OilPrice());
		return cost;
	}
	
	static String[][] Tdm(List<List<Integer>> Bdm)  {

		// 宣告c1為TimeCalculate類別物件
		TimeCalculate c1 = new TimeCalculate();

		String[][] Tdm = new String[Bdm.size()][];
		for (int i = 0; i < Tdm.length; i++)
			Tdm[i] = new String[Bdm.get(i).size()+2];

		int location1, location2, k;
		String Driving_time;
		for (int d = 0; d < Tdm.length; d++) {
			Driving_time = Read_INPUT_TXT_filter.getD_F_D_Time(d);
			location1 = Integer.parseInt(Read_INPUT_TXT_filter.getD_S_PLACE(d));
			Tdm[d][0]=Driving_time;
			for (int m = 1; m < Tdm[d].length-1; m++) {
				if (Bdm.get(d).get(m-1) > 0) {
					k = Bdm.get(d).get(m-1);
					location2 = Integer.parseInt(Read_INPUT_TXT_filter	.getP_R_PLACE(k - 1));
					try {
						Driving_time = c1.Addtime(Driving_time, Read_distance.getDistancetime(location1, location2));
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					Tdm[d][m] = Driving_time;
					location1 = location2;
				} else if (Bdm.get(d).get(m-1) < 0) {
					k = -Bdm.get(d).get(m-1);
					location2 = Integer.parseInt(Read_INPUT_TXT_filter	.getP_D_ADDRESS(k - 1));
					try {
						Driving_time = c1.Addtime(Driving_time, Read_distance.getDistancetime(location1, location2));
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					Tdm[d][m] = Driving_time;
					location1 = location2;
				}
			}
			location2 = Integer.parseInt(Read_INPUT_TXT_filter.getD_D_ADDRESS(d));
			try {
				Driving_time = c1.Addtime(Driving_time, Read_distance.getDistancetime(location1, location2));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Tdm[d][Tdm[d].length-1] = Driving_time;
		}
		return Tdm;
	}
	
}
