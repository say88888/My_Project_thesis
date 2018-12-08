package Algorithm_DoubleAuction.TS_DA;

import java.util.Arrays;

public class Step4_print  extends TS_DA{
	public static void X_G_and_X_GRj( ) {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.print("X_G= ");
		for (int i = 0; i < X_G.size(); i++)
			System.out.print(X_G.get(i) + " ");
		System.out.println();
		System.out.print("X_GRj= ");
		
		for(int i=0;i<X_G.size();i++)
		{
			int j=X_G.get(i);
			if(X_R_DN.contains(j))
			{
				System.out.print(X_GR_UP[j]+" ");
			}
			else if(X_R_UP.contains(j))
			{
				System.out.print(X_GR_DN[j]+" ");
			}
		}

	}
	public static void Y_G_and_Y_GRj( ) {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.print("Y_G= ");
		for (int i = 0; i < Y_G.size(); i++)
			System.out.print(Y_G.get(i) + " ");
		System.out.println();
		System.out.print("Y_GRj= ");
		
		for(int i=0;i<Y_G.size();i++)
		{
			int j=Y_G.get(i);
			if(Y_R_DN.contains(j))
			{
				System.out.print(Y_GR_UP[j]+" ");
			}
			else if(Y_R_UP.contains(j))
			{
				System.out.print(Y_GR_DN[j]+" ");
			}
		}
	}
	public static void X_Tabu()
	{
		System.out.println();
		System.out.print("X_Tabu = ");
		for(int i=0;i<X_Tabu.size();i++)
			System.out.print(X_Tabu.get(i)+" ");
	}
	public static void Y_Tabu()
	{
		System.out.println();
		System.out.print("Y_Tabu = ");
		for(int i=0;i<Y_Tabu.size();i++)
			System.out.print(Y_Tabu.get(i)+" ");
	}
	
	public static void X_Gp_Gs(){
		System.out.println();
		System.out.println("gp= "+ gp + "    "+"gs= "+gs);
		
		System.out.print("X_Gp= ");
		for(int j=0;j<X_Gp.size();j++)
			System.out.print(X_Gp.get(j)+"  ");
		System.out.println();
		System.out.print("X_Gs= ");
		for(int j=0;j<X_Gs.size();j++)
			System.out.print(X_Gs.get(j)+"  ");
	}
	
	public static void Y_Gp_Gs(){
		System.out.println();
		System.out.println("gp= "+ gp + "    "+"gs= "+gs);
		System.out.print("Y_Gp= ");
		for(int j=0;j<Y_Gp.size();j++)
			System.out.print(Y_Gp.get(j)+"  ");
		System.out.println();
		System.out.print("Y_Gs= ");
		for(int j=0;j<Y_Gs.size();j++)
			System.out.print(Y_Gs.get(j)+"  ");
	}
	
	public static void Xtabu_tenures(){
	int j; //定義G集合的位置
		
		System.out.println();
		System.out.print("XTabuTenure =");
		
		for(int i=0;i<X_G.size();i++)
		{
			j=X_G.get(i);
			
				if(X_R_DN.contains(j))
				{	 
					System.out.print(XTabuTenure_UP[j]+ "  ");
				}
				else if(X_R_UP.contains(j))
				{  
					System.out.print(XTabuTenure_DN[j]+ "  ");
				}
		}
	}
	
	public static void Ytabu_tenures(){
	int j; //定義G集合的位置
		
		System.out.println();
		System.out.print("YTabuTenure = ");
		
		for(int i=0;i<Y_G.size();i++)
		{
			j=Y_G.get(i);
			
				if(Y_R_DN.contains(j))
				{	 
					System.out.print(YTabuTenure_UP[j]+ "  ");
				}
				else if(Y_R_UP.contains(j))
				{  
					System.out.print(YTabuTenure_DN[j]+ "  ");
				}
		}
	}
	public static void XMaxtabu_tenures(){
	int j; //定義G集合的位置
		
		System.out.println();
		System.out.print("XMaxtabu_tenures =");
		
		for(int i=0;i<X_G.size();i++)
		{
			j=X_G.get(i);	
			System.out.print(XMaxtenure[j]+ "  ");
		}
	}
	
	public static void YMaxtabu_tenures(){
	int j; //定義G集合的位置
		
		System.out.println();
		System.out.print("YMaxtabu_tenures = ");
		
		for(int i=0;i<Y_G.size();i++)
		{
			j=Y_G.get(i);
			System.out.print(YMaxtenure[j]+ "  ");
		}
	}
	public static void XAspire(){
		System.out.println();
	System.out.print("XAspire = ");
	for(int i=0;i<X_G.size();i++)
	{
		int j=X_G.get(i);
		if(X_R_DN.contains(j))
		{
			System.out.print(XAspire_DN[j]+" "); 
		}
		else if(X_R_UP.contains(j))
		{
			System.out.print(XAspire_UP[j]+" "); 
		}
	}
	}
	
	public static void YAspire(){
		System.out.println();
		System.out.print("YAspire = ");
		for(int i=0;i<Y_G.size();i++)
		{
			int j=Y_G.get(i);
			if(Y_R_DN.contains(j))
			{
				System.out.print(YAspire_DN[j]+" "); 
			}
			else if(Y_R_UP.contains(j))
			{
				System.out.print(YAspire_UP[j]+" "); 
			}
		}
	}
}
