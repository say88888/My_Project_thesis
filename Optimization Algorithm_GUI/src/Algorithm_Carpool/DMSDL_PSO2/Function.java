package Algorithm_Carpool.DMSDL_PSO2;

import java.util.Collections;
import java.util.Random;
 
 
public class Function extends DMSDL_PSO2{
	static Vim_Individual Algorithm1_1(double F,Plbest_Individual plbestinvid,P_Individual pinvid1,P_Individual pinvid2) {
		
		Vim_Individual V=new Vim_Individual();
		for(int i=0;i<Xsize;i++)
			V.setVimx(i,plbestinvid.getPx(i)+F*(pinvid1.getPx(i)-pinvid2.getPx(i)));
		
		for(int i=0;i<Ysize;i++)
			V.setVimy(i,plbestinvid.getPy(i)+F*(pinvid1.getPy(i)-pinvid2.getPy(i)));
		
		for(int i=0;i<Xsize;i++){
			if (V.getVimx(i) > Vmax)
				V.setVimx(i, Vmax);
			if (V.getVimx(i) < -Vmax)
				V.setVimx(i, -Vmax);
		}
		for(int i=0;i<Ysize;i++){
			if (V.getVimy(i) > Vmax)
				V.setVimy(i, Vmax);
			if (V.getVimy(i) < -Vmax)
				V.setVimy(i, -Vmax);
		}
	 
		return V;
	}


	 static U_Individual Algorithm2(int j,P_Individual P_indiv,Vim_Individual Vim_indiv) {
			
			 
			int a= PSO_Read_Write_txt.random_generate_or_read5(Execution_Mode,Xsize);
			
			U_Individual U=new U_Individual();
		 
			for(int i=0;i<Xsize;i++)
				if(PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode)<=CR || i==a){
					double rsid = PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode);
					if (rsid < 1 / (1 + Math.exp(-PSO_lamda * Vim_indiv.getVimx(i)))) {
						U.setUx(i, 1);
					}
					else {
						U.setUx(i, 0);
					}
				}else{
					U.setUx(i, P_indiv.getPx(i));
				}
			
			a= PSO_Read_Write_txt.random_generate_or_read5(Execution_Mode,Ysize);
			for(int i=0;i<Ysize;i++)
				if(PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode)<=CR || i==a){
					double rsid = PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode);
					if (rsid < 1 / (1 + Math.exp(-PSO_lamda * Vim_indiv.getVimy(i)))) {
						U.setUy(i, 1);
					}
					else {
						U.setUy(i, 0);
					}
				}else{
					U.setUy(i, P_indiv.getPy(i));
				}
			
			return U;
		}
	
	public static GV_Individual Algorithm3(U_Individual newGinvid, P_Individual pinvid) {
		// TODO Auto-generated method stub
		GV_Individual GV=new GV_Individual();
		
		if(newGinvid.getFitness1()>pinvid.getFitness()){
			for(int d=0;d<newGinvid.Uxsize();d++)
				GV.setGVx(d, newGinvid.getUx(d));
			for(int d=0;d<newGinvid.Uysize();d++)
				GV.setGVy(d, newGinvid.getUy(d));
		}else{
			for(int d=0;d<pinvid.Pxsize();d++)
				GV.setGVx(d, pinvid.getPx(d));
			for(int d=0;d<pinvid.Pysize();d++)
				GV.setGVy(d, pinvid.getPy(d));
		}
		 
		return GV;
	}
	 
	 
}
