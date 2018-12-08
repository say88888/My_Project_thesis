package Algorithm_Carpool.DMSDL_PSO2_AB_2Si_ApproachII;


public class Function extends DMSDL_PSO2_AB_2Si_ApproachII{
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
			
			 double[] Ux=new double[Xsize];
			 double[] Uy=new double[Ysize];
			int a= PSO_Read_Write_txt.random_generate_or_read5(Execution_Mode,Xsize);
			
			U_Individual U=new U_Individual();
		 
			for(int i=0;i<Xsize;i++)
				if(PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode)<=CR || i==a){
					
					U.setUx(i, Vim_indiv.getVimx(i));
					Ux[i]=Vim_indiv.getVimx(i);
				}else{
					U.setUx(i, P_indiv.getPx(i));
					Ux[i]=P_indiv.getPx(i);
				}
			
			a= PSO_Read_Write_txt.random_generate_or_read5(Execution_Mode,Ysize);
			for(int i=0;i<Ysize;i++)
				if(PSO_Read_Write_txt.random_generate_or_read1(Execution_Mode)<=CR || i==a){
					U.setUy(i, Vim_indiv.getVimy(i));
					Uy[i]=Vim_indiv.getVimy(i);
				}else{
					U.setUy(i, P_indiv.getPy(i));
					Uy[i]=P_indiv.getPy(i);
				}
			 //------------取得 x 與 y 的A、B 字串--------------------
			Convert_Function.main(Ux,Uy);
			
			for(int d=0;d<P;d++){
				U.setUA(d,Convert_Function.getA(d));
			}
			for(int d=0;d<(P*2);d++){
				U.setUB(d,Convert_Function.getB(d));
			}
			for(int d=0;d<D;d++) {
				U.setbinaryUx(d,Convert_Function.getbinaryX(d));
			}
			for(int d=0;d<P;d++) {
				U.setbinaryUy(d,Convert_Function.getbinaryY(d));
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
			
			for(int d=0;d<newGinvid.UAsize();d++)
				GV.setGVA(d, newGinvid.getUA(d));
			for(int d=0;d<newGinvid.UBsize();d++)
				GV.setGVB(d, newGinvid.getUB(d));
			
			for(int d=0;d<newGinvid.binaryUxsize();d++)
				GV.setbinaryGVx(d, newGinvid.getbinaryUx(d));
			for(int d=0;d<newGinvid.binaryUysize();d++)
				GV.setbinaryGVy(d, newGinvid.getbinaryUy(d));
		}else{
			for(int d=0;d<pinvid.Pxsize();d++)
				GV.setGVx(d, pinvid.getPx(d));
			for(int d=0;d<pinvid.Pysize();d++)
				GV.setGVy(d, pinvid.getPy(d));
			
			for(int d=0;d<pinvid.PAsize();d++)
				GV.setGVA(d, pinvid.getPA(d));
			for(int d=0;d<pinvid.PBsize();d++)
				GV.setGVB(d, pinvid.getPB(d));
			
			for(int d=0;d<pinvid.binaryPxsize();d++)
				GV.setbinaryGVx(d, pinvid.getbinaryPx(d));
			for(int d=0;d<pinvid.binaryPysize();d++)
				GV.setbinaryGVy(d, pinvid.getbinaryPy(d));
		}
		 
		return GV;
	}
	 
	 
}
