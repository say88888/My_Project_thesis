package Algorithm_Carpool.NSDE_AB_NNH;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
 
public class Algorithm extends NSDE_AB_NNH {

	private static int[][] X;
	private static int[][] Y;
	
	// Evolve a population 演變人口
	public static Population evolvePopulation(Population pop) {
		Population newPopulation = new Population(pop.size(), false);

	 
		//計算F、CR
	//	Function.Algorithm3();
	
		// 突變V
		for (int i = 0; i < pop.size(); i++) {
			int r1 = 0, r2 = 0, r3 = 0 ;
			while (r1 == i || r2 == i || r3 == i ||  r1 == r2
					|| r1 == r3 ||  r2 == r3 ) {// 取r1,r2,r3,r4
				r1 = DE_Read_Write_txt.random_generate_or_read2(Execution_Mode,populationSize);
				r2 = DE_Read_Write_txt.random_generate_or_read2(Execution_Mode,populationSize);
				r3 = DE_Read_Write_txt.random_generate_or_read2(Execution_Mode,populationSize);
				 
			}
 
			Individual invid = pop.getIndividual(i);
			Individual invid1 = pop.getIndividual(r1);
			Individual invid2 = pop.getIndividual(r2);
			Individual invid3 = pop.getIndividual(r3);
			  
			V_Individual newPinvid=new V_Individual();
			
			 
				newPinvid =Function.Algorithm1_1(F, invid1, invid2, invid3);
		 
		
			//交叉U
			U_Individual newGinvid=new U_Individual();
			newGinvid=Function.Algorithm2(i,  invid, newPinvid);
			newPopulation.saveU_Individual(i, newGinvid);
		 
		}
	
		//貪婪選擇
		for(int i=0;i<pop.size();i++){
			U_Individual Ginvid=pop.getU_Individual(i);
			Individual invid = pop.getIndividual(i);
			int number;
			int[] Am = new int[P];
			int[] Bm = new int[P*2];
			int[] rid_m = new int[P];
			double[] Si = new double[P];
			int[] Si_m = new int[P];
			
			for(int d=0;d<invid.Xsize();d++){
				if(Md.get(d).size()>0){
					number=(int) Math.round(((Md.get(d).size()-1)*(invid.getX(d)+Vmax))/(2*Vmax)+1);
					invid.setrid(d,number);
					rid_m[d]=number;
				}
				else 
				{
					invid.setrid(d,0);
					rid_m[d]=0;
				}
			}
			
			for(int d=0;d<invid.Ysize();d++)
				Si[d]=invid.getY(d);
			
			Si_m=sortSi(Si);
			
			Am=Convert_Function.Get_A(rid_m);
			Bm=Convert_Function.Get_B(Am,Si_m);
			for(int j=0;j<Am.length;j++){
				invid.setA(j, Am[j]);
			}
			for(int j=0;j<Bm.length;j++){
				invid.setB(j, Bm[j]);
			}
			getbinaryXY(Am);
			for (int d = 0; d < X.length; d++)
				for (int j = 0; j < X[d].length; j++) 
					invid.setbinaryX(d,X[d][j]);
			for (int p = 0; p < Y.length; p++)
				for (int h = 0; h < Y[p].length; h++)
					invid.setbinaryY(p,Y[p][h]);
			
			for(int d=0;d<Ginvid.Uxsize();d++){
				if(Md.get(d).size()>0){
					number=(int) Math.round(((Md.get(d).size()-1)*(Ginvid.getUx(d)+Vmax))/(2*Vmax)+1);
					Ginvid.setUrid(d,number);
					rid_m[d]=number;
				}
				else 
				{
					Ginvid.setUrid(d,0);
					rid_m[d]=0;
				}
			}

			for(int d=0;d<Ginvid.Uysize();d++)
				Si[d]=Ginvid.getUy(d);
			
			Si_m=sortSi(Si);
			
			Am=Convert_Function.Get_A(rid_m);
			Bm=Convert_Function.Get_B(Am,Si_m);
			
			for(int j=0;j<Am.length;j++){
				Ginvid.setUA(j, Am[j]);
			}
			for(int j=0;j<Bm.length;j++){
				Ginvid.setUB(j, Bm[j]);
			}
			getbinaryXY(Am);
			for (int d = 0; d < X.length; d++)
				for (int j = 0; j < X[d].length; j++) 
					Ginvid.setbinaryUx(d,X[d][j]);
			for (int p = 0; p < Y.length; p++)
				for (int h = 0; h < Y[p].length; h++)
					Ginvid.setbinaryUy(p,Y[p][h]);
		
		//	System.out.println("Ginvid的解 "+ Ginvid.getFitness1() +"invid的解 " + invid.getFitness1() );
			
			if(Ginvid.getFitness1() > invid.getFitness1()){
				for(int d=0;d<invid.Xsize();d++){
					invid.setX(d, Ginvid.getUx(d));
					invid.setrid(d, Ginvid.getUrid(d));
				}
					
				for(int d=0;d<invid.Ysize();d++){
					invid.setY(d, Ginvid.getUy(d));
					invid.setSi(d, Ginvid.getUsi(d));
				}
				
				for(int d=0;d<invid.Asize();d++){
					invid.setA(d, Ginvid.getUA(d));
					}
				for(int d=0;d<invid.Bsize();d++){
					invid.setB(d, Ginvid.getUB(d));
					}
				for(int d=0;d<D;d++){
					invid.setbinaryX(d,Ginvid.getbinaryUx(d));
					}
				for(int d=0;d<P;d++){
					invid.setbinaryY(d,Ginvid.getbinaryUy(d));
					}
				
		//		System.out.println("invid的解 " + invid.getFitness1() );
			}
			newPopulation.saveIndividual(i, invid);
		}
		return newPopulation;
	}
	
	static int[] sortSi(double[] Si) 
	{
		int[] Si_p=new int[P];
		for(int i=0;i<P;i++)
			Si_p[i]=i+1;
		
	//	System.out.println();
	//	System.out.print("排序前 Si[i] = ");
	//	for(int i=0;i<P;i++)
	//		System.out.print(Si[i]+" ");
		
		for(int i=0;i<P-1;i++)
			for(int j=0;j<P-1;j++)
			{
				if(Si[j]<Si[j+1]){
					double temp;
					temp=Si[j];
					Si[j]=Si[j+1];
					Si[j+1]=temp;
					int temp1;
					temp1=Si_p[j];
					Si_p[j]=Si_p[j+1];
					Si_p[j+1]=temp1;
				}
			}
		
	//	System.out.println();
	//	System.out.print("排序後 Si[i] = ");
	//	for(int i=0;i<P;i++)
	//		System.out.print(Si[i]+" ");
		
	//	System.out.println();
	//	System.out.print("乘客順序 Si_p[i] = ");
	//	for(int i=0;i<P;i++)
	//		System.out.print(Si_p[i]+" ");
		
		return Si_p;
	}
	
	static void getbinaryXY(int[] A) 
	{
		List<List<Integer>> Dlist = new ArrayList<List<Integer>>();
		int[][] Adp = new int[D][P];
		for (int d = 0; d < D; d++){
			List<Integer> list = new ArrayList<Integer>();
			for (int p = 0; p < P; p++) {
				if (A[p] == (d + 1)){
					Adp[d][p] = 1;
					list.add(p+1);
				}else
					Adp[d][p] = 0;
			}
			Dlist.add(list);
		}
		
		Y = new int[P][];
		for (int i = 0; i < Y.length; i++)
			Y[i] = new int[1];
		for (int p = 0; p < Y.length; p++)
			for (int h = 0; h < Y[p].length; h++) {
				for (int d = 0; d < D; d++)
					Y[p][h] += Adp[d][p];
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
}
