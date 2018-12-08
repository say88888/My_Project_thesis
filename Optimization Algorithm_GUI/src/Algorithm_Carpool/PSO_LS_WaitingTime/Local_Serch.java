package Algorithm_Carpool.PSO_LS_WaitingTime;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import READ_TXT.Read_INPUT_TXT_filter;
import READ_TXT.Read_distance;

public class Local_Serch extends PSO_LS_WaitingTime {

	private static List<List<Integer>> Bdm = new ArrayList<List<Integer>>();
	private static List<List<Integer>> Bdm_position = new ArrayList<List<Integer>>();
	private static int X[][];

	public static void NNH(int[] A) {
		// TODO Auto-generated method stub

		List<List<Integer>> B = new ArrayList<List<Integer>>();
		for (int j = 1; j <= D; j++) {
			List<Integer> b = new ArrayList<Integer>();
			for (int i = 0; i < P; i++)
				if (A[i] == j) {
					b.add(i + 1);
					b.add(-(i + 1));
				}
			B.add(b);
		}

		int location1, location2, k;
		Bstring = new ArrayList<Integer>();
		for (int d = 0; d < B.size(); d++) {
			double route = 99999999.0;
			int min = 0, i = 0;

			while (B.get(d).size() != 0) {
				int n = 0;
				if (i == 0)
					location1 = Integer.parseInt(Read_INPUT_TXT_filter	.getD_S_PLACE(d));
				else if (min > 0)
					location1 = Integer.parseInt(Read_INPUT_TXT_filter	.getP_R_PLACE(min - 1));
				else
					location1 = Integer.parseInt(Read_INPUT_TXT_filter	.getP_D_ADDRESS((-min) - 1));
				i++;
				for (int j = 0; j < B.get(d).size(); j++) {
					if (B.get(d).get(j) > 0) {
						k = B.get(d).get(j);
						location2 = Integer.parseInt(Read_INPUT_TXT_filter	.getP_R_PLACE(k - 1));
						if (Read_distance.getDistance(location1, location2) < route) {
							route = Read_distance.getDistance(location1,	location2);
							min = B.get(d).get(j);
							n = j;
						}
					} else if (B.get(d).get(j) < 0) {
						k = -(B.get(d).get(j));
						location2 = Integer.parseInt(Read_INPUT_TXT_filter	.getP_D_ADDRESS(k - 1));
						if (Read_distance.getDistance(location1, location2) < route) {
							route = Read_distance.getDistance(location1,	location2);
							min = B.get(d).get(j);
							n = j;
						}
					}
				}
				Bstring.add(B.get(d).get(n));
				B.get(d).remove(n);

			}
		}

	}
	
	public static P_Individual Two_Opt(Population pop, Population newPopulation,int s) 
	{

		P_Individual Pinvid = pop.getP_Individual(s);
		E_Individual Einvid = pop.getE_Individual();
	
		System.out.println(" LOCAL_SEARCH ");	
		System.out.println("  -------- Two_Opt ------------");	
		
		for (int d = 0; d < Einvid.EAsize(); d++)
			Einvid.setEA(d, Pinvid.getPA(d));
		for (int d = 0; d < Einvid.EBsize(); d++)
			Einvid.setEB(d, Pinvid.getPB(d));
		
		make_Bdm(Einvid);
		
		
		List<Integer> Dlist = new ArrayList<Integer>();
		for (int d = 0; d < D; d++)
			for (int j = 0; j < X[d].length; j++) {
				if(X[d][j]==1){
					System.out.println(" 司機 "+(d+1));
					Bdm_print(Bdm.get(d),Bdm_position.get(d));
					if(Bdm.get(d).size()>2)
					{
						Dlist.add(d);
					}
				}
			}
	if(Dlist.size()>0){	
		for(int m=0;m<Dlist.size();m++){

		int DD=Dlist.get(m);
		
		System.out.println();
		System.out.println(" 挑中司機 "+(DD+1));
		
		System.out.println(Bdm.get(DD) + " "+Bdm_position.get(DD));
		
		int k;
		boolean Two_Opt=false;
		while (Two_Opt==false){
			
			make_Bdm(Einvid);
			Bdm_print(Bdm.get(DD),Bdm_position.get(DD));
			k=0;
			
			for(int i=0;i<Bdm.get(DD).size()-2;i++)
				{
					for(int j=i+2;j<Bdm.get(DD).size();j++)
					{
						Einvid=TwoOptSwap(Einvid,Bdm.get(DD),Bdm_position.get(DD),i,j);
						newPopulation.saveE_Individual(Einvid);
				
						if(check_Bstring_Bdm(Einvid)==true)
						{
							if(Pinvid.getFitness()<Einvid.getFitness1())
							{
								System.out.println(" 取代  " +  "F(PAstring,PBstring)= "+ Pinvid.getFitness() + " < " + " F(EAstring,EBstring)= " + Einvid.getFitness1());
								for (int d = 0; d < Einvid.EAsize(); d++)
									Pinvid.setPA(d, Einvid.getEA(d));
								for (int d = 0; d < Einvid.EBsize(); d++)
									Pinvid.setPB(d, Einvid.getEB(d));		
								newPopulation.saveP_Individual(s, Pinvid);
							
								System.out.print(" PAstring=");
								for (int d = 0; d < Pinvid.PAsize(); d++)
								System.out.print(Pinvid.getPA(d));
								System.out.print(" PBstring=");
								for (int d = 0; d < Pinvid.PBsize(); d++)
									System.out.print(Pinvid.getPB(d));
								System.out.print(" EAstring=");
								for (int d = 0; d < Einvid.EAsize(); d++)
									System.out.print(Einvid.getEA(d));
								System.out.print(" EBstring=");
								for (int d = 0; d < Einvid.EBsize(); d++)
									System.out.print(Einvid.getEB(d));			
								System.out.println();
								System.out.println();
								k++;
								break; 
							}
							else
							{
								System.out.println("  沒取代  "   +  "F(PAstring,PBstring)= "+ Pinvid.getFitness() + " > " + " F(EAstring,EBstring)= " + Einvid.getFitness1());
								for (int d = 0; d < Einvid.EAsize(); d++)
									Einvid.setEA(d, Pinvid.getPA(d));
								for (int d = 0; d < Einvid.EBsize(); d++)
									Einvid.setEB(d, Pinvid.getPB(d));
							
								System.out.print(" PAstring=");
								for (int d = 0; d < Pinvid.PAsize(); d++)
									System.out.print(Pinvid.getPA(d));
								System.out.print(" PBstring=");
								for (int d = 0; d < Pinvid.PBsize(); d++)
									System.out.print(Pinvid.getPB(d));
								System.out.print(" EAstring=");
								for (int d = 0; d < Einvid.EAsize(); d++)
									System.out.print(Einvid.getEA(d));
								System.out.print(" EBstring=");
								for (int d = 0; d < Einvid.EBsize(); d++)
									System.out.print(Einvid.getEB(d));		
								System.out.println();
								System.out.println();
							}
						}else
						{
							System.out.println("  沒取代  "   +  "F(PAstring,PBstring)= "+ Pinvid.getFitness() + " > " + " F(EAstring,EBstring)= " + Einvid.getFitness1());
							for (int d = 0; d < Einvid.EAsize(); d++)
								Einvid.setEA(d, Pinvid.getPA(d));
							for (int d = 0; d < Einvid.EBsize(); d++)
								Einvid.setEB(d, Pinvid.getPB(d));
							
							System.out.print(" PAstring=");
							for (int d = 0; d < Pinvid.PAsize(); d++)
								System.out.print(Pinvid.getPA(d));
							System.out.print(" PBstring=");
							for (int d = 0; d < Pinvid.PBsize(); d++)
								System.out.print(Pinvid.getPB(d));
							System.out.print(" EAstring=");
							for (int d = 0; d < Einvid.EAsize(); d++)
								System.out.print(Einvid.getEA(d));
							System.out.print(" EBstring=");
							for (int d = 0; d < Einvid.EBsize(); d++)
								System.out.print(Einvid.getEB(d));			
							System.out.println();
							System.out.println();
						}
					}
				}
				if(k==0){Two_Opt=true;}
			}
		}
	}
	
		System.out.println(" -----------------End-------------------");
	
		return Pinvid;	
	}
	
	
	
	public static P_Individual Exchange(Population pop, Population newPopulation,int s) 
	{
		
		P_Individual Pinvid = pop.getP_Individual(s);
		E_Individual Einvid = pop.getE_Individual();
	
		System.out.println(" LOCAL_SEARCH ");	
		System.out.println("  -------- Exchange ------------");	
		
		for (int d = 0; d < Einvid.EAsize(); d++)
			Einvid.setEA(d, Pinvid.getPA(d));
		for (int d = 0; d < Einvid.EBsize(); d++)
			Einvid.setEB(d, Pinvid.getPB(d));
	
		make_Bdm(Einvid);
		List<Integer> Dlist = new ArrayList<Integer>();
		for (int d = 0; d < D; d++)
			for (int j = 0; j < X[d].length; j++) {
				if(X[d][j]==1){
					System.out.println(" 司機 "+(d+1));
					Bdm_print(Bdm.get(d),Bdm_position.get(d));
					if(Bdm.get(d).size()>2)
					{
						Dlist.add(d);
					}
				}
			}
	if(Dlist.size()>0){	
		for(int m=0;m<Dlist.size();m++){
		
		int DD=Dlist.get(m);
		
		System.out.println();
		System.out.println(" 挑中司機 "+(DD+1));
		
		make_Bdm(Einvid);
		
		System.out.println(Bdm.get(DD) + " "+Bdm_position.get(DD));
		
		int k;
		boolean Exchange=false;
		while (Exchange==false){
			
			make_Bdm(Einvid);
			Bdm_print(Bdm.get(DD),Bdm_position.get(DD));
			k=0;
			
			for(int i=0;i<Bdm.get(DD).size()-1;i++)
				{
					for(int j=i+1;j<Bdm.get(DD).size();j++)
					{
						Einvid=Exchange(Einvid,Bdm.get(DD),Bdm_position.get(DD),i,j);
						newPopulation.saveE_Individual(Einvid);
				
						if(check_Bstring_Bdm(Einvid)==true)
						{
							
							if(Pinvid.getFitness()<Einvid.getFitness1())
							{
								System.out.println("  取代  " +  "F(PAstring,PBstring)= "+ Pinvid.getFitness() + " < " + " F(EAstring,EBstring)= " + Einvid.getFitness1());
								for (int d = 0; d < Einvid.EAsize(); d++)
									Pinvid.setPA(d, Einvid.getEA(d));
								for (int d = 0; d < Einvid.EBsize(); d++)
									Pinvid.setPB(d, Einvid.getEB(d));		
								newPopulation.saveP_Individual(s, Pinvid);
							
								System.out.print(" PAstring=");
								for (int d = 0; d < Pinvid.PAsize(); d++)
									System.out.print(Pinvid.getPA(d));
								System.out.print(" PBstring=");
								for (int d = 0; d < Pinvid.PBsize(); d++)
									System.out.print(Pinvid.getPB(d));
								System.out.print(" EAstring=");
								for (int d = 0; d < Einvid.EAsize(); d++)
									System.out.print(Einvid.getEA(d));
								System.out.print(" EBstring=");
								for (int d = 0; d < Einvid.EBsize(); d++)
									System.out.print(Einvid.getEB(d));		
								System.out.println();
								System.out.println();
								k++;
								break; 
							}
							else
							{
								System.out.println("  沒取代  " +  "F(PAstring,PBstring)= "+ Pinvid.getFitness() + " > " + " F(EAstring,EBstring)= " + Einvid.getFitness1());
								for (int d = 0; d < Einvid.EAsize(); d++)
									Einvid.setEA(d, Pinvid.getPA(d));
								for (int d = 0; d < Einvid.EBsize(); d++)
									Einvid.setEB(d, Pinvid.getPB(d));
							
								System.out.print(" PAstring=");
								for (int d = 0; d < Pinvid.PAsize(); d++)
									System.out.print(Pinvid.getPA(d));
								System.out.print(" PBstring=");
								for (int d = 0; d < Pinvid.PBsize(); d++)
									System.out.print(Pinvid.getPB(d));
								System.out.print(" EAstring=");
								for (int d = 0; d < Einvid.EAsize(); d++)
									System.out.print(Einvid.getEA(d));
								System.out.print(" EBstring=");
								for (int d = 0; d < Einvid.EBsize(); d++)
									System.out.print(Einvid.getEB(d));				
								System.out.println();
								System.out.println();
							}
						}else
						{
							System.out.println("  沒取代  " +  "F(PAstring,PBstring)= "+ Pinvid.getFitness() + " > " + " F(EAstring,EBstring)= " + Einvid.getFitness1());
							for (int d = 0; d < Einvid.EAsize(); d++)
								Einvid.setEA(d, Pinvid.getPA(d));
							for (int d = 0; d < Einvid.EBsize(); d++)
								Einvid.setEB(d, Pinvid.getPB(d));
						
							System.out.print(" PAstring=");
							for (int d = 0; d < Pinvid.PAsize(); d++)
								System.out.print(Pinvid.getPA(d));
							System.out.print(" PBstring=");
							for (int d = 0; d < Pinvid.PBsize(); d++)
								System.out.print(Pinvid.getPB(d));
							System.out.print(" EAstring=");
							for (int d = 0; d < Einvid.EAsize(); d++)
								System.out.print(Einvid.getEA(d));
							System.out.print(" EBstring=");
							for (int d = 0; d < Einvid.EBsize(); d++)
								System.out.print(Einvid.getEB(d));			
							System.out.println();
							System.out.println();
						}
					}
				}
				if(k==0){Exchange=true;}
				}
			}
		}
	 
		System.out.println(" ---------------End-------------------");
		
		return Pinvid;	
	}
	
	public static P_Individual Reverse(Population pop, Population newPopulation,int s) 
	{
		P_Individual Pinvid = pop.getP_Individual(s);
		E_Individual Einvid = pop.getE_Individual();
	
		System.out.println(" LOCAL_SEARCH ");	
		System.out.println("  -------- Reverse ------------");	
		
		for (int d = 0; d < Einvid.EAsize(); d++)
			Einvid.setEA(d, Pinvid.getPA(d));
		for (int d = 0; d < Einvid.EBsize(); d++)
			Einvid.setEB(d, Pinvid.getPB(d));
	
		make_Bdm(Einvid);
		
		List<Integer> Dlist = new ArrayList<Integer>();
		for (int d = 0; d < D; d++)
			for (int j = 0; j < X[d].length; j++) {
				if(X[d][j]==1){
					System.out.println(" 司機 "+(d+1));
					Bdm_print(Bdm.get(d),Bdm_position.get(d));
					if(Bdm.get(d).size()>2)
					{
						Dlist.add(d);
					}
				}
			}
	if(Dlist.size()>0){	
		
		for(int m=0;m<Dlist.size();m++){
			int DD=Dlist.get(m);
		
		System.out.println();
		System.out.println(" 挑中司機 "+(DD+1));
		
		make_Bdm(Einvid);
		
		System.out.println(Bdm.get(DD) + " "+Bdm_position.get(DD));
	
		Einvid=Reverse(Einvid,Bdm.get(DD),Bdm_position.get(DD));
		newPopulation.saveE_Individual(Einvid);

		if(check_Bstring_Bdm(Einvid)==true){
		
			if(Pinvid.getFitness()<Einvid.getFitness1())
			{
				System.out.println("  取代  " +  "F(PAstring,PBstring)= "+ Pinvid.getFitness() + " < " + " F(EAstring,EBstring)= " + Einvid.getFitness1());
				for (int d = 0; d < Einvid.EAsize(); d++)
					Pinvid.setPA(d, Einvid.getEA(d));
				for (int d = 0; d < Einvid.EBsize(); d++)
					Pinvid.setPB(d, Einvid.getEB(d));		
				newPopulation.saveP_Individual(s, Pinvid);
			
				System.out.print(" PAstring=");
				for (int d = 0; d < Pinvid.PAsize(); d++)
					System.out.print(Pinvid.getPA(d));
				System.out.print(" PBstring=");
				for (int d = 0; d < Pinvid.PBsize(); d++)
					System.out.print(Pinvid.getPB(d));
				System.out.print(" EAstring=");
				for (int d = 0; d < Einvid.EAsize(); d++)
					System.out.print(Einvid.getEA(d));
				System.out.print(" EBstring=");
				for (int d = 0; d < Einvid.EBsize(); d++)
					System.out.print(Einvid.getEB(d));
				System.out.println();
				System.out.println();
			}
			else
			{
				System.out.println("  沒取代   "+  "F(PAstring,PBstring)= "+ Pinvid.getFitness() + " > " + " F(EAstring,EBstring)= " + Einvid.getFitness1());
				for (int d = 0; d < Einvid.EAsize(); d++)
					Einvid.setEA(d, Pinvid.getPA(d));
				for (int d = 0; d < Einvid.EBsize(); d++)
					Einvid.setEB(d, Pinvid.getPB(d));
			
				System.out.print(" PAstring=");
				for (int d = 0; d < Pinvid.PAsize(); d++)
					System.out.print(Pinvid.getPA(d));
				System.out.print(" PBstring=");
				for (int d = 0; d < Pinvid.PBsize(); d++)
					System.out.print(Pinvid.getPB(d));
				System.out.print(" EAstring=");
				for (int d = 0; d < Einvid.EAsize(); d++)
					System.out.print(Einvid.getEA(d));
				System.out.print(" EBstring=");
				for (int d = 0; d < Einvid.EBsize(); d++)
					System.out.print(Einvid.getEB(d));
				System.out.println();
				System.out.println();
			}
		}
		else
		{
			System.out.println("  沒取代   "+  "F(PAstring,PBstring)= "+ Pinvid.getFitness() + " > " + " F(EAstring,EBstring)= " + Einvid.getFitness1());
			for (int d = 0; d < Einvid.EAsize(); d++)
				Einvid.setEA(d, Pinvid.getPA(d));
			for (int d = 0; d < Einvid.EBsize(); d++)
				Einvid.setEB(d, Pinvid.getPB(d));
			
			System.out.print(" PAstring=");
			for (int d = 0; d < Pinvid.PAsize(); d++)
				System.out.print(Pinvid.getPA(d));
			System.out.print(" PBstring=");
			for (int d = 0; d < Pinvid.PBsize(); d++)
				System.out.print(Pinvid.getPB(d));
			System.out.print(" EAstring=");
			for (int d = 0; d < Einvid.EAsize(); d++)
				System.out.print(Einvid.getEA(d));
			System.out.print(" EBstring=");
			for (int d = 0; d < Einvid.EBsize(); d++)
				System.out.print(Einvid.getEB(d));
			System.out.println();
			System.out.println();
		}
		}
	}
		System.out.println(" ---------------End-------------------");
		
		return Pinvid;	
	}
	
	static void make_Bdm(E_Individual Einvid)
	{
		Bdm.clear();
		Bdm_position.clear();
		
		System.out.println("--------AString---------------------");
		for (int d = 0; d < Einvid.EAsize(); d++)
			System.out.print(Einvid.getEA(d)+" ");
		System.out.println();
		System.out.println("-----------------------------");
		
		System.out.println("--------BString---------------------");
		for (int d = 0; d < Einvid.EBsize(); d++)
			System.out.print(Einvid.getEB(d)+" ");
		System.out.println();
		System.out.println("-----------------------------");
		System.out.println();
		
		List<List<Integer>> Dlist = new ArrayList<List<Integer>>();
		
		int[][] Adp = new int[D][P];
		for (int d = 0; d < D; d++){
			List<Integer> list = new ArrayList<Integer>();
			for (int p = 0; p < P; p++) {
				if (Einvid.getEA(p) == (d + 1)){
					Adp[d][p] = 1;
					list.add(p+1);
				}else
					Adp[d][p] = 0;
			}
			Dlist.add(list);
		}
		for (int d = 0; d < D; d++) {
			List<Integer> B = new ArrayList<Integer>();
			List<Integer> B_position = new ArrayList<Integer>();
					for (int i = 0; i < Einvid.EBsize(); i++)
						for(int j=0;j<Dlist.get(d).size();j++){
						if (Math.abs(Einvid.getEB(i)) == (Dlist.get(d).get(j))){
							B.add(Einvid.getEB(i));
							B_position.add(i);
						}
					}
			Bdm.add(B);
			Bdm_position.add(B_position);
		}
		
		X = new int[D][];
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
	}
	
	static void Bdm_print(List<Integer> Bdm,List<Integer> Bdm_postion)
	{
		
		System.out.println(" 輸出順序 與 BString 位置");
		for (int i = 0; i < Bdm.size(); i++) 
			System.out.print(Bdm.get(i)+" ");

		System.out.println();
		//return D;
		for (int i = 0; i < Bdm.size(); i++)
				System.out.print(Bdm_postion.get(i)+" ");
		
		System.out.println();
	}
	
	static E_Individual  TwoOptSwap(E_Individual Einvid,List<Integer> Bdm,List<Integer> Bdm_postion,int i,int j)
	{
		System.out.println(" 輸出交換位置的順序與位置");
		
		System.out.println("交換位置 i = "+i+" j = "+j);
	
		Einvid.setEB(Bdm_postion.get(i), Bdm.get(j));
		Einvid.setEB(Bdm_postion.get(j), Bdm.get(i));
		
		System.out.println("交換後的 BString ");
		for (int d = 0; d < Einvid.EBsize(); d++)
			System.out.print(Einvid.getEB(d)+" ");
			
		System.out.println();
		System.out.println();
		return Einvid;
	}
	static E_Individual  Exchange(E_Individual Einvid,List<Integer> Bdm,List<Integer> Bdm_postion,int i,int j)
	{
		System.out.println(" 輸出交換位置的順序與位置");
		
		System.out.println("交換位置 i = "+i+" j = "+j);
	
		Einvid.setEB(Bdm_postion.get(i), Bdm.get(j));
		Einvid.setEB(Bdm_postion.get(j), Bdm.get(i));
		
		System.out.println("交換後的 BString ");
		for (int d = 0; d < Einvid.EBsize(); d++)
			System.out.print(Einvid.getEB(d)+" ");
		
		System.out.println();
		System.out.println();
		return Einvid;
	}
	
	static E_Individual  Reverse(E_Individual Einvid,List<Integer> Bdm,List<Integer> Bdm_postion)
	{
		List<Integer> B = new ArrayList<Integer>();
		B=Bdm;
		System.out.println("B= "+ B);
		 Collections.reverse(B); 
		System.out.println("反轉B= "+ B);
	
		List<Integer> B1 = new ArrayList<Integer>();
		List<Integer> B1_postion = new ArrayList<Integer>();
		
		for(int i=0;i<B.size();i++)
			B1.add(-(B.get(i)));
		System.out.println("B1= "+ B1);
		
		for(int i=0;i<B1.size();i++)
			for(int j=0;j<Bdm.size();j++)
			{
				if(B1.get(i)==Bdm.get(j)){
					B1_postion.add(Bdm_postion.get(i));
					System.out.println(i+" "+Bdm_postion.get(i));
				}
			}
		
		System.out.println("B1_postion= "+ B1_postion);
		
		for(int i=0;i<B1.size();i++)
			Einvid.setEB(B1_postion.get(i), B1.get(i));
		
		System.out.println(" 輸出交換位置的順序與位置");
		
		System.out.println("交換後的 BString ");
		for (int d = 0; d < Einvid.EBsize(); d++)
			System.out.print(Einvid.getEB(d)+" ");
		
		System.out.println();
		System.out.println();
		
		
		return Einvid;
	}
	
	static boolean check_Bstring_Bdm(E_Individual Einvid)
	{
		boolean Bdn=true;
		List<List<Integer>> Dlist = new ArrayList<List<Integer>>();
		
		int[][] Adp = new int[D][P];
		for (int d = 0; d < D; d++){
			List<Integer> list = new ArrayList<Integer>();
			for (int p = 0; p < P; p++) {
				if (Einvid.getEA(p) == (d + 1)){
					Adp[d][p] = 1;
					list.add(p+1);
				}else
					Adp[d][p] = 0;
			}
			Dlist.add(list);
		}
		
		for (int d = 0; d < D; d++) {
			List<Integer> B = new ArrayList<Integer>();
					for (int i = 0; i < Einvid.EBsize(); i++)
						for(int j=0;j<Dlist.get(d).size();j++){
						if (Math.abs(Einvid.getEB(i)) == (Dlist.get(d).get(j))){
							if(Einvid.getEB(i)<0)
							{
								if(!B.contains((-Einvid.getEB(i)))){
									Bdn=false;
								}
							}
							B.add(Einvid.getEB(i));
						}
					}
		}
		
		if(Bdn==false)
			System.out.print("此BString 的 Bdm 順序有誤");
		else
			System.out.print("此BString 的 Bdm 順序無誤");
		
		System.out.println();
		return Bdn;
	}
	
}
