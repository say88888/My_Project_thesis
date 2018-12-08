package Algorithm_Tourism.DE_Tourism;

import java.util.Collections;
import java.util.Random;

import GUI.GUI_Tourism.X_Select_Algorithm_Type_to_Solve_the_Problem;

public class Function extends DE_Tourism{
	static V_Individual Algorithm1_1(double F,Individual individual_r1,Individual individual_r2,Individual individual_r3) {
		int[] XaV1=new int[Xasize];
		for(int i=0;i<Xasize;i++)
			XaV1[i]=individual_r2.getXa(i)^individual_r3.getXa(i);
			
		int[] XaI=new int[Xasize];
		for(int i=0;i<Xasize;i++)
			if(DE_Read_Write_txt.random_generate_or_read1(Execution_Mode)<F)
				XaI[i]=1;
		
		for(int i=0;i<Xasize;i++)
			XaV1[i]=XaV1[i]&XaI[i];
			
		int[] XhV1=new int[Xhsize];
		for(int i=0;i<Xhsize;i++)
			XhV1[i]=individual_r2.getXh(i)^individual_r3.getXh(i);
			
		int[] XhI=new int[Xhsize];
		for(int i=0;i<Xhsize;i++)
			if(DE_Read_Write_txt.random_generate_or_read1(Execution_Mode)<F)
				XhI[i]=1;
		
		for(int i=0;i<Xhsize;i++)
			XhV1[i]=XhV1[i]&XhI[i];
		
		int[] XtV1=new int[Xtsize];
		for(int i=0;i<Xtsize;i++)
			XtV1[i]=individual_r2.getXt(i)^individual_r3.getXt(i);
			
		int[] XtI=new int[Xtsize];
		for(int i=0;i<Xtsize;i++)
			if(DE_Read_Write_txt.random_generate_or_read1(Execution_Mode)<F)
				XtI[i]=1;
		
		for(int i=0;i<Xtsize;i++)
			XtV1[i]=XtV1[i]&XtI[i];
		
		int[] YV1=new int[Ysize];	
		for(int i=0;i<Ysize;i++)
			YV1[i]=individual_r2.getY(i)^individual_r3.getY(i);
			
		
		int[] YI=new int[Ysize];
		for(int i=0;i<Ysize;i++)
			if(DE_Read_Write_txt.random_generate_or_read1(Execution_Mode)<F)
				YI[i]=1;
		
		for(int i=0;i<Ysize;i++)
			YV1[i]=YV1[i]&YI[i];
			
		V_Individual V=new V_Individual();
		for(int i=0;i<Xasize;i++)
			V.setVxa(i, individual_r1.getXa(i)^XaV1[i]);
			
		for(int i=0;i<Xhsize;i++)
			V.setVxh(i, individual_r1.getXh(i)^XhV1[i]);

		for(int i=0;i<Xtsize;i++)
			V.setVxt(i, individual_r1.getXt(i)^XtV1[i]);
		
		for(int i=0;i<Ysize;i++)
			V.setVy(i, individual_r1.getY(i)^YV1[i]);
		return V;
	}

	static V_Individual Algorithm1_2( double F,Individual individual_b,Individual individual_r2,Individual individual_r3) {
	
		int[] XaV1=new int[Xasize];
		for(int i=0;i<Xasize;i++)
			XaV1[i]=individual_r2.getXa(i)^individual_r3.getXa(i);	
		int[] XaI=new int[Xasize];
		for(int i=0;i<Xasize;i++)
			if(DE_Read_Write_txt.random_generate_or_read1(Execution_Mode)<F)
				XaI[i]=1;
		for(int i=0;i<Xasize;i++)
			XaV1[i]=XaV1[i]&XaI[i];
		
		int[] XhV1=new int[Xhsize];
		for(int i=0;i<Xhsize;i++)
			XhV1[i]=individual_r2.getXh(i)^individual_r3.getXh(i);	
		int[] XhI=new int[Xhsize];
		for(int i=0;i<Xhsize;i++)
			if(DE_Read_Write_txt.random_generate_or_read1(Execution_Mode)<F)
				XhI[i]=1;
		for(int i=0;i<Xhsize;i++)
			XhV1[i]=XhV1[i]&XhI[i];
		
		int[] XtV1=new int[Xtsize];
		for(int i=0;i<Xtsize;i++)
			XtV1[i]=individual_r2.getXt(i)^individual_r3.getXt(i);	
		int[] XtI=new int[Xtsize];
		for(int i=0;i<Xtsize;i++)
			if(DE_Read_Write_txt.random_generate_or_read1(Execution_Mode)<F)
				XtI[i]=1;
		for(int i=0;i<Xtsize;i++)
			XtV1[i]=XtV1[i]&XtI[i];
		
		int[] YV1=new int[Ysize];
		
		for(int i=0;i<Ysize;i++)
			YV1[i]=individual_r2.getY(i)^individual_r3.getY(i);
			
		
		int[] YI=new int[Ysize];
		for(int i=0;i<Ysize;i++)
			if(DE_Read_Write_txt.random_generate_or_read1(Execution_Mode)<F)
				YI[i]=1;
		
		for(int i=0;i<Ysize;i++)
			YV1[i]=YV1[i]&YI[i];
			
		 
		V_Individual V=new V_Individual();
		for(int i=0;i<Xasize;i++)
			V.setVxa(i, individual_b.getXa(i)^XaV1[i]);
		for(int i=0;i<Xhsize;i++)
			V.setVxh(i, individual_b.getXh(i)^XhV1[i]);
		for(int i=0;i<Xtsize;i++)
			V.setVxt(i, individual_b.getXt(i)^XtV1[i]);
		for(int i=0;i<Ysize;i++)
			V.setVy(i, individual_b.getY(i)^YV1[i]);
		return V;
	}
	
	static V_Individual Algorithm1_3(double F,Individual individual_r1,Individual individual_r2,Individual individual_r3,Individual individual_r4,Individual individual_r5) {
		int[] XaV1=new int[Xasize];
		int[] XaV2=new int[Xasize];
		for(int i=0;i<Xasize;i++){
			XaV1[i]=individual_r2.getXa(i)^individual_r3.getXa(i);
			XaV2[i]=individual_r4.getXa(i)^individual_r5.getXa(i);
		}
		int[] XaI=new int[Xasize];
		for(int i=0;i<Xasize;i++)
			if(DE_Read_Write_txt.random_generate_or_read1(Execution_Mode)<F)
				XaI[i]=1;
		
		for(int i=0;i<Xasize;i++){
			XaV1[i]=XaV1[i]&XaI[i];
			XaV2[i]=XaV2[i]&XaI[i];
		}
		
		int[] XhV1=new int[Xhsize];
		int[] XhV2=new int[Xhsize];
		for(int i=0;i<Xhsize;i++){
			XhV1[i]=individual_r2.getXh(i)^individual_r3.getXh(i);
			XhV2[i]=individual_r4.getXh(i)^individual_r5.getXh(i);
		}
		int[] XhI=new int[Xhsize];
		for(int i=0;i<Xhsize;i++)
			if(DE_Read_Write_txt.random_generate_or_read1(Execution_Mode)<F)
				XhI[i]=1;
		
		for(int i=0;i<Xhsize;i++){
			XhV1[i]=XhV1[i]&XhI[i];
			XhV2[i]=XhV2[i]&XhI[i];
		}
		
		int[] XtV1=new int[Xtsize];
		int[] XtV2=new int[Xtsize];
		for(int i=0;i<Xtsize;i++){
			XtV1[i]=individual_r2.getXt(i)^individual_r3.getXt(i);
			XtV2[i]=individual_r4.getXt(i)^individual_r5.getXt(i);
		}
		int[] XtI=new int[Xtsize];
		for(int i=0;i<Xtsize;i++)
			if(DE_Read_Write_txt.random_generate_or_read1(Execution_Mode)<F)
				XtI[i]=1;
		
		for(int i=0;i<Xtsize;i++){
			XtV1[i]=XtV1[i]&XtI[i];
			XtV2[i]=XtV2[i]&XtI[i];
		}
		
		int[] YV1=new int[Ysize];	
		int[] YV2=new int[Ysize];	
		for(int i=0;i<Ysize;i++){
			YV1[i]=individual_r2.getY(i)^individual_r3.getY(i);
			YV2[i]=individual_r4.getY(i)^individual_r5.getY(i);
		}
		int[] YI=new int[Ysize];
		for(int i=0;i<Ysize;i++)
			if(DE_Read_Write_txt.random_generate_or_read1(Execution_Mode)<F)
				YI[i]=1;
		
		for(int i=0;i<Ysize;i++){
			YV1[i]=YV1[i]&YI[i];
			YV2[i]=YV2[i]&YI[i];
		}
			
		V_Individual V=new V_Individual();
		int[] Vxa=new int[Xasize];
		for(int i=0;i<Xasize;i++){
			Vxa[i]=XaV1[i]|XaV2[i];
			V.setVxa(i, Vxa[i]^individual_r1.getXa(i));
		}
		int[] Vxh=new int[Xhsize];
		for(int i=0;i<Xhsize;i++){
			Vxh[i]=XhV1[i]|XhV2[i];
			V.setVxh(i, Vxh[i]^individual_r1.getXh(i));
		}
		int[] Vxt=new int[Xtsize];
		for(int i=0;i<Xtsize;i++){
			Vxt[i]=XtV1[i]|XtV2[i];
			V.setVxt(i, Vxt[i]^individual_r1.getXt(i));
		}
		int[] Vy=new int[Ysize];
		for(int i=0;i<Ysize;i++){
			Vy[i]=YV1[i]|YV2[i];
			V.setVy(i, Vy[i]^individual_r1.getY(i));
		}
		return V;
	}
	
	static V_Individual Algorithm1_4(double F,Individual individual_b,Individual individual_r1,Individual individual_r2,Individual individual_r3,Individual individual_r4) {
		int[] XaV1=new int[Xasize];
		int[] XaV2=new int[Xasize];
		for(int i=0;i<Xasize;i++){
			XaV1[i]=individual_r1.getXa(i)^individual_r2.getXa(i);
			XaV2[i]=individual_r3.getXa(i)^individual_r4.getXa(i);
		}
		int[] XaI=new int[Xasize];
		for(int i=0;i<Xasize;i++)
			if(DE_Read_Write_txt.random_generate_or_read1(Execution_Mode)<F)
				XaI[i]=1;
		
		for(int i=0;i<Xasize;i++){
			XaV1[i]=XaV1[i]&XaI[i];
			XaV2[i]=XaV2[i]&XaI[i];
		}
		
		int[] XhV1=new int[Xhsize];
		int[] XhV2=new int[Xhsize];
		for(int i=0;i<Xhsize;i++){
			XhV1[i]=individual_r1.getXh(i)^individual_r2.getXh(i);
			XhV2[i]=individual_r3.getXh(i)^individual_r4.getXh(i);
		}
		int[] XhI=new int[Xhsize];
		for(int i=0;i<Xhsize;i++)
			if(DE_Read_Write_txt.random_generate_or_read1(Execution_Mode)<F)
				XhI[i]=1;
		
		for(int i=0;i<Xhsize;i++){
			XhV1[i]=XhV1[i]&XhI[i];
			XhV2[i]=XhV2[i]&XhI[i];
		}
		
		int[] XtV1=new int[Xtsize];
		int[] XtV2=new int[Xtsize];
		for(int i=0;i<Xtsize;i++){
			XtV1[i]=individual_r1.getXt(i)^individual_r2.getXt(i);
			XtV2[i]=individual_r3.getXt(i)^individual_r4.getXt(i);
		}
		int[] XtI=new int[Xtsize];
		for(int i=0;i<Xtsize;i++)
			if(DE_Read_Write_txt.random_generate_or_read1(Execution_Mode)<F)
				XtI[i]=1;
		
		for(int i=0;i<Xtsize;i++){
			XtV1[i]=XtV1[i]&XtI[i];
			XtV2[i]=XtV2[i]&XtI[i];
		}
		int[] YV1=new int[Ysize];	
		int[] YV2=new int[Ysize];	
		for(int i=0;i<Ysize;i++){
			YV1[i]=individual_r1.getY(i)^individual_r2.getY(i);
			YV2[i]=individual_r3.getY(i)^individual_r4.getY(i);
		}
		int[] YI=new int[Ysize];
		for(int i=0;i<Ysize;i++)
			if(DE_Read_Write_txt.random_generate_or_read1(Execution_Mode)<F)
				YI[i]=1;
		
		for(int i=0;i<Ysize;i++){
			YV1[i]=YV1[i]&YI[i];
			YV2[i]=YV2[i]&YI[i];
		}
			
		V_Individual V=new V_Individual();
		int[] Vxa=new int[Xasize];
		for(int i=0;i<Xasize;i++){
			Vxa[i]=XaV1[i]|XaV2[i];
			V.setVxa(i, Vxa[i]^individual_b.getXa(i));
		}
		int[] Vxh=new int[Xhsize];
		for(int i=0;i<Xhsize;i++){
			Vxh[i]=XhV1[i]|XhV2[i];
			V.setVxh(i, Vxh[i]^individual_b.getXh(i));
		}
		int[] Vxt=new int[Xtsize];
		for(int i=0;i<Xtsize;i++){
			Vxt[i]=XtV1[i]|XtV2[i];
			V.setVxt(i, Vxt[i]^individual_b.getXt(i));
		}
		int[] Vy=new int[Ysize];
		for(int i=0;i<Ysize;i++){
			Vy[i]=YV1[i]|YV2[i];
			V.setVy(i, Vy[i]^individual_b.getY(i));
		}
		return V;
	}
	
	static V_Individual Algorithm1_5(double F,Individual individual,Individual individual_b,Individual individual_r1,Individual individual_r2) {
		int[] XaV1=new int[Xasize];
		int[] XaV2=new int[Xasize];
		for(int i=0;i<Xasize;i++){
			XaV1[i]=individual_b.getXa(i)^individual.getXa(i);
			XaV2[i]=individual_r1.getXa(i)^individual_r2.getXa(i);
		}
		int[] XaI=new int[Xasize];
		for(int i=0;i<Xasize;i++)
			if(DE_Read_Write_txt.random_generate_or_read1(Execution_Mode)<F)
				XaI[i]=1;
		
		for(int i=0;i<Xasize;i++){
			XaV1[i]=XaV1[i]&XaI[i];
			XaV2[i]=XaV2[i]&XaI[i];
		}
		
		int[] XhV1=new int[Xhsize];
		int[] XhV2=new int[Xhsize];
		for(int i=0;i<Xhsize;i++){
			XhV1[i]=individual_b.getXh(i)^individual.getXh(i);
			XhV2[i]=individual_r1.getXh(i)^individual_r2.getXh(i);
		}
		int[] XhI=new int[Xhsize];
		for(int i=0;i<Xhsize;i++)
			if(DE_Read_Write_txt.random_generate_or_read1(Execution_Mode)<F)
				XhI[i]=1;
		
		for(int i=0;i<Xhsize;i++){
			XhV1[i]=XhV1[i]&XhI[i];
			XhV2[i]=XhV2[i]&XhI[i];
		}
		
		int[] XtV1=new int[Xtsize];
		int[] XtV2=new int[Xtsize];
		for(int i=0;i<Xtsize;i++){
			XtV1[i]=individual_b.getXt(i)^individual.getXt(i);
			XtV2[i]=individual_r1.getXt(i)^individual_r2.getXt(i);
		}
		int[] XtI=new int[Xtsize];
		for(int i=0;i<Xtsize;i++)
			if(DE_Read_Write_txt.random_generate_or_read1(Execution_Mode)<F)
				XtI[i]=1;
		
		for(int i=0;i<Xtsize;i++){
			XtV1[i]=XtV1[i]&XtI[i];
			XtV2[i]=XtV2[i]&XtI[i];
		}
		int[] YV1=new int[Ysize];	
		int[] YV2=new int[Ysize];	
		for(int i=0;i<Ysize;i++){
			YV1[i]=individual_b.getY(i)^individual.getY(i);
			YV2[i]=individual_r1.getY(i)^individual_r2.getY(i);
		}
		int[] YI=new int[Ysize];
		for(int i=0;i<Ysize;i++)
			if(DE_Read_Write_txt.random_generate_or_read1(Execution_Mode)<F)
				YI[i]=1;
		
		for(int i=0;i<Ysize;i++){
			YV1[i]=YV1[i]&YI[i];
			YV2[i]=YV2[i]&YI[i];
		}
			
		V_Individual V=new V_Individual();
		int[] Vxa=new int[Xasize];
		for(int i=0;i<Xasize;i++){
			Vxa[i]=XaV1[i]|XaV2[i];
			V.setVxa(i, Vxa[i]^individual.getXa(i));
		}
		int[] Vxh=new int[Xhsize];
		for(int i=0;i<Xhsize;i++){
			Vxh[i]=XhV1[i]|XhV2[i];
			V.setVxh(i, Vxh[i]^individual.getXh(i));
		}
		int[] Vxt=new int[Xtsize];
		for(int i=0;i<Xtsize;i++){
			Vxt[i]=XtV1[i]|XtV2[i];
			V.setVxt(i, Vxt[i]^individual.getXt(i));
		}
		int[] Vy=new int[Ysize];
		for(int i=0;i<Ysize;i++){
			Vy[i]=YV1[i]|YV2[i];
			V.setVy(i, Vy[i]^individual.getY(i));
		}
		return V;
	}
	
	static V_Individual Algorithm1_6( double F,Individual individual,Individual individual_b,Individual individual_r1,Individual individual_r2,Individual individual_r3,Individual individual_r4) {
		int[] XaV1=new int[Xasize];
		int[] XaV2=new int[Xasize];
		int[] XaV3=new int[Xasize];
		
		for(int i=0;i<Xasize;i++){
			XaV1[i]=individual_b.getXa(i)^individual.getXa(i);
			XaV2[i]=individual_r1.getXa(i)^individual_r2.getXa(i);
			XaV3[i]=individual_r3.getXa(i)^individual_r4.getXa(i);
		}
		
		int[] XaI=new int[Xasize];
		for(int i=0;i<Xasize;i++)
			if(DE_Read_Write_txt.random_generate_or_read1(Execution_Mode)<F)
				XaI[i]=1;
		
		for(int i=0;i<Xasize;i++){
			XaV1[i]=XaV1[i]&XaI[i];
			XaV2[i]=XaV2[i]&XaI[i];
			XaV3[i]=XaV3[i]&XaI[i];
		}
		
		int[] XhV1=new int[Xhsize];
		int[] XhV2=new int[Xhsize];
		int[] XhV3=new int[Xhsize];
		
		for(int i=0;i<Xhsize;i++){
			XhV1[i]=individual_b.getXh(i)^individual.getXh(i);
			XhV2[i]=individual_r1.getXh(i)^individual_r2.getXh(i);
			XhV3[i]=individual_r3.getXh(i)^individual_r4.getXh(i);
		}
		
		int[] XhI=new int[Xhsize];
		for(int i=0;i<Xhsize;i++)
			if(DE_Read_Write_txt.random_generate_or_read1(Execution_Mode)<F)
				XhI[i]=1;
		
		for(int i=0;i<Xhsize;i++){
			XhV1[i]=XhV1[i]&XhI[i];
			XhV2[i]=XhV2[i]&XhI[i];
			XhV3[i]=XhV3[i]&XhI[i];
		}
		
		int[] XtV1=new int[Xtsize];
		int[] XtV2=new int[Xtsize];
		int[] XtV3=new int[Xtsize];
		
		for(int i=0;i<Xtsize;i++){
			XtV1[i]=individual_b.getXt(i)^individual.getXt(i);
			XtV2[i]=individual_r1.getXt(i)^individual_r2.getXt(i);
			XtV3[i]=individual_r3.getXt(i)^individual_r4.getXt(i);
		}
		
		int[] XtI=new int[Xtsize];
		for(int i=0;i<Xtsize;i++)
			if(DE_Read_Write_txt.random_generate_or_read1(Execution_Mode)<F)
				XtI[i]=1;
		
		for(int i=0;i<Xtsize;i++){
			XtV1[i]=XtV1[i]&XtI[i];
			XtV2[i]=XtV2[i]&XtI[i];
			XtV3[i]=XtV3[i]&XtI[i];
		}
		int[] YV1=new int[Ysize];
		int[] YV2=new int[Ysize];
		int[] YV3=new int[Ysize];
		
		for(int i=0;i<Ysize;i++){
			YV1[i]=individual_b.getY(i)^individual.getY(i);
			YV2[i]=individual_r1.getY(i)^individual_r2.getY(i);
			YV3[i]=individual_r3.getY(i)^individual_r4.getY(i);
		}
		
		int[] YI=new int[Ysize];
		for(int i=0;i<Ysize;i++)
			if(DE_Read_Write_txt.random_generate_or_read1(Execution_Mode)<F)
				YI[i]=1;
		
		for(int i=0;i<Ysize;i++){
			YV1[i]=YV1[i]&YI[i];
			YV2[i]=YV2[i]&YI[i];
			YV3[i]=YV3[i]&YI[i];
		}
	 
		V_Individual V=new V_Individual();
		int[] Vxa=new int[Xasize];
		for(int i=0;i<Xasize;i++){
			Vxa[i]=XaV1[i]|XaV2[i];
			Vxa[i]=Vxa[i]|XaV3[i];
			V.setVxa(i, Vxa[i]^individual.getXa(i));
		}
		int[] Vxh=new int[Xhsize];
		for(int i=0;i<Xhsize;i++){
			Vxh[i]=XhV1[i]|XhV2[i];
			Vxh[i]=Vxh[i]|XhV3[i];
			V.setVxh(i, Vxh[i]^individual.getXh(i));
		}
		int[] Vxt=new int[Xtsize];
		for(int i=0;i<Xtsize;i++){
			Vxt[i]=XtV1[i]|XtV2[i];
			Vxt[i]=Vxt[i]|XtV3[i];
			V.setVxt(i, Vxt[i]^individual.getXt(i));
		}
		int[] Vy=new int[Ysize];
		for(int i=0;i<Ysize;i++){
			Vy[i]=YV1[i]|YV2[i];
			Vy[i]=Vy[i]|YV3[i];
			V.setVy(i, Vy[i]^individual.getY(i));
		}
		return V;
	}

	static void Update_p_f_cr( ) {
		// 計算S總和
		int S = 0;
		for (int i = 0; i < 6; i++)
			S += s[i];
		// Update p、 f、cr
		for (int i = 0; i < 6; i++) {
			p[i] = s[i] / (Epsilon + S);
			if (successfulF.size() != 0){
				Collections.sort(successfulF);
				if (successfulF.size() % 2 != 0)
					f[i] = successfulF.get((successfulF.size() + 1) / 2-1);
				else
					f[i] = (successfulF.get(successfulF.size() / 2-1) + successfulF.get((successfulF.size() / 2) )) / 2;
			
			}else
				f[i] = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
			
			if (successfulCR.size() != 0){
				Collections.sort(successfulCR);
				if (successfulCR.size() % 2 != 0)
					cr[i] = successfulCR	.get((successfulCR.size() + 1) / 2-1);
				else
					cr[i] = (successfulCR.get(successfulCR.size() / 2-1) + successfulCR.get((successfulCR.size() / 2) )) / 2;
			}else
				cr[i] = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
			}
	//	generationCount=0;
	//	susuccessfulF = new ArrayList<Double>();
	//	successfulCR = new ArrayList<Double>();
	}

	 static int select_strategy() {
			int strategy = 0;
			String Select_Algorithm_Type=X_Select_Algorithm_Type_to_Solve_the_Problem.method();
			
			if(Select_Algorithm_Type.equals("DE_Tourism")){
				System.out.println("DE");
			double strategy_R =DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
			if (strategy_R <= p[0])
				strategy = 1;
			else if (strategy_R <= p[0]+p[1])
				strategy = 2;
			else if (strategy_R <= p[0]+p[1]+p[2])
				strategy = 3;
			else if (strategy_R <= p[0]+p[1]+p[2]+p[3])
				strategy = 4;
			else if (strategy_R <= p[0]+p[1]+p[2]+p[3]+p[4])
				strategy = 5;
			else
				strategy = 6;
			}
			else if(Select_Algorithm_Type.equals("DE_Tourism_strategy1")){
				System.out.println("DE_Tourism_strategy1");
				strategy = 1;
			}
			else if(Select_Algorithm_Type.equals("DE_Tourism_strategy2")){
				System.out.println("DE_Tourism_strategy2");
				strategy = 2;
			}
			else if(Select_Algorithm_Type.equals("DE_Tourism_strategy3")){
				System.out.println("DE_Tourism_strategy3");
				strategy = 3;
			}
			else if(Select_Algorithm_Type.equals("DE_Tourism_strategy4")){
				System.out.println("DE_Tourism_strategy4");
				strategy = 4;
			}
			else if(Select_Algorithm_Type.equals("DE_Tourism_strategy5")){
				System.out.println("DE_Tourism_strategy5");
				strategy = 5;
			}
			else if(Select_Algorithm_Type.equals("DE_Tourism_strategy6")){
				System.out.println("DE_Tourism_strategy6");
				strategy = 6;
			}
			
			return strategy;
		}

	 static U_Individual Algorithm2(int j,int strategy,Individual indiv,V_Individual P_indiv) {
			
			 
			int a= DE_Read_Write_txt.random_generate_or_read2(Execution_Mode,Xasize);
			
			U_Individual U=new U_Individual();
			for(int i=0;i<Xasize;i++)
				U.setUxa(i, indiv.getXa(i));
			
			for(int i=0;i<Xasize;i++)
				if(DE_Read_Write_txt.random_generate_or_read1(Execution_Mode)<CR[strategy-1][j] || i==a)
					U.setUxa(i,P_indiv.getVxa(i));

			a= DE_Read_Write_txt.random_generate_or_read2(Execution_Mode,Xhsize);
			
			for(int i=0;i<Xhsize;i++)
				U.setUxh(i, indiv.getXh(i));
			
			for(int i=0;i<Xhsize;i++)
				if(DE_Read_Write_txt.random_generate_or_read1(Execution_Mode)<CR[strategy-1][j] || i==a)
					U.setUxh(i,P_indiv.getVxh(i));
			
			a= DE_Read_Write_txt.random_generate_or_read2(Execution_Mode,Xtsize);
			
			for(int i=0;i<Xtsize;i++)
				U.setUxt(i, indiv.getXt(i));
			
			for(int i=0;i<Xtsize;i++)
				if(DE_Read_Write_txt.random_generate_or_read1(Execution_Mode)<CR[strategy-1][j] || i==a)
					U.setUxt(i,P_indiv.getVxt(i));
			
			  a= DE_Read_Write_txt.random_generate_or_read2(Execution_Mode,Ysize);
			for(int i=0;i<Ysize;i++)
				if(DE_Read_Write_txt.random_generate_or_read1(Execution_Mode)<CR[strategy-1][j] || i==a)
					U.setUy(i,P_indiv.getVy(i));
			
			return U;
		}
	 
	 static void Algorithm3() {
			Random r = new Random();
			double c=DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
			while (c == 0.25 || c==0.5 || c==0.75) {
				c = DE_Read_Write_txt.random_generate_or_read1(Execution_Mode);
			}
			
			for(int k=0;k<6;k++)
				for(int i=0;i<populationSize;i++){
					c=4*c*(1-c);
					F[k][i]=f[k]+0.2*(c-0.5);
					while(F[k][i] >1.5 || F[k][i]<0){
						c=4*c*(1-c);
						F[k][i]=f[k]+0.2*(c-0.5);
					}
				}
			
			for(int k=0;k<6;k++)
				for(int i=0;i<populationSize;i++){
					c=4*c*(1-c);
					CR[k][i]=cr[k]+0.1*(c-0.5);
					while(CR[k][i] >1 || CR[k][i]<0){
						c=4*c*(1-c);
						CR[k][i]=cr[k]+0.1*(c-0.5);
					}
				}
		}
	 
}
