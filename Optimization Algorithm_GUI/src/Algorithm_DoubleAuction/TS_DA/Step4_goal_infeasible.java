package Algorithm_DoubleAuction.TS_DA;

import java.util.ArrayList;
import java.util.Arrays;

public class Step4_goal_infeasible extends TS_DA{

	public static void main(double[] x, double[] y) {

		X_G.clear();
		X_Gp.clear();
		X_Gs.clear();
		X_R_UP.clear();
		X_R_DN.clear();
		Y_G.clear();
		Y_Gp.clear();
		Y_Gs.clear();
		Y_R_UP.clear();
		Y_R_DN.clear();
		
		
	for(int i=0;i<Xsize;i++)
		{
			if(X_LP[i]<X_goalvalue[i] && X_Nup.contains(i))
			{
				X_G.add(i);
				X_GR_UP[i]=Math.abs(X_LP[i]-X_goalvalue[i] );
				X_R_DN.add(i);
			}
			else if(X_LP[i]>X_goalvalue[i] && X_Ndn.contains(i))
			{
				X_G.add(i);
				X_GR_DN[i]=Math.abs(X_LP[i]-X_goalvalue[i] );
				X_R_UP.add(i);
			}
		}

	for(int i=0;i<Ysize;i++)
	{
		if(Y_LP[i]<Y_goalvalue[i] && Y_Nup.contains(i))
		{
			Y_G.add(i);
			Y_GR_UP[i]=Math.abs(Y_LP[i]-Y_goalvalue[i] );
			Y_R_DN.add(i);
		}
		else if(Y_LP[i]>Y_goalvalue[i] && Y_Ndn.contains(i))
		{
			Y_G.add(i);
			Y_GR_DN[i]=Math.abs(Y_LP[i]-Y_goalvalue[i] );
			Y_R_UP.add(i);
		}
	}
	

	//如果G>0 Considering tabu status
		if(X_G.size()!=0 || Y_G.size()!=0)
		{
			Step4_print.X_G_and_X_GRj();
			Step4_print.X_Tabu();
			Step4_print.XAspire();
			//排序 X_G
			SortX_G();
			//更新
			Update_X_tabu_tenures();
			Step4_print.Xtabu_tenures();
			Step4_print.XMaxtabu_tenures();
			CheckXTabuTenure();
			Step4_print.X_Gp_Gs();
			Step4_print.X_Tabu();
			System.out.println();	
		
			//排序Y_G		
			Step4_print.Y_G_and_Y_GRj();
			Step4_print.Y_Tabu();
			Step4_print.YAspire();
			//排序
			SortY_G();
			//更新
			Update_Y_tabu_tenures();
			Step4_print.Ytabu_tenures();
			Step4_print.YMaxtabu_tenures();
			CheckYTabuTenure();
			Step4_print.Y_Gp_Gs();
			Step4_print.Y_Tabu();
			System.out.println();	
		}
	}
	
	//更新 tabu_tenures
	
	public static void Update_X_tabu_tenures() {
	
		int j; //定義G集合的位置
		
		double Tenure;
		
		for(int i=0;i<X_G.size();i++)
		{
			j=X_G.get(i);
			
			if(X_Gp.size()<gp){
				
				if(X_R_DN.contains(j))
				{
					if(X_Tabu.contains(j))
					{ 
						if(X_GR_UP[j]>XAspire_DN[j])
						{
							X_Gp.add(j);
						}
						else if(X_GR_UP[j]<=XAspire_DN[j])
						{
							Tenure=Math.max(1, Math.random()*Xsize);
							XTabuTenure_UP[j]+=Tenure;
						}
					}
					else if(!X_Tabu.contains(j))
					{
						X_Tabu.add(j);
						X_Gp.add(j);
					}
				}
				else if(X_R_UP.contains(j))
				{  
					if(X_Tabu.contains(j))
					{
						if(X_GR_DN[j]>XAspire_UP[j])
						{
							X_Gp.add(j);
						}
						else if(X_GR_DN[j]<=XAspire_UP[j])
						{
							Tenure=Math.max(1, Math.random()*Xsize);
							XTabuTenure_DN[j]+=Tenure;
						}
					}
					else if(!X_Tabu.contains(j))
					{
						X_Tabu.add(j);
						X_Gp.add(j);
					}
				}
			}
		}
		
		for(int i=0;i<X_G.size();i++)
		{
			j=X_G.get(i);
			
			if(X_Gs.size()<gs && !X_Gp.contains(j)){
				
				if(X_R_DN.contains(j))
				{
					if(X_Tabu.contains(j))
					{ 
						if(X_GR_UP[j]>XAspire_DN[j])
						{
							X_Gs.add(j);
						}
						else if(X_GR_UP[j]<=XAspire_DN[j])
						{
							Tenure=Math.max(1, Math.random()*Xsize);
							XTabuTenure_UP[j]+=Tenure;
						}
					}
					else if(!X_Tabu.contains(j))
					{
						X_Tabu.add(j);
						X_Gs.add(j);
					}
				}
				else if(X_R_UP.contains(j))
				{  
					if(X_Tabu.contains(j))
					{
						if(X_GR_DN[j]>XAspire_UP[j])
						{
							X_Gs.add(j);
						}
						else if(X_GR_DN[j]<=XAspire_UP[j])
						{
							Tenure=Math.max(1, Math.random()*Xsize);
							XTabuTenure_DN[j]+=Tenure;
						}
					}
					else if(!X_Tabu.contains(j))
					{
						X_Tabu.add(j);
						X_Gs.add(j);
					}
				}
			}
		}
	}
	
	
	public static void Update_Y_tabu_tenures() {
		
		int j; //定義G集合的位置
		
		double Tenure;
		
		for(int i=0;i<Y_G.size();i++)
		{
			j=Y_G.get(i);
			
			if(Y_Gp.size()<gp){
				
				if(Y_R_DN.contains(j))
				{
					if(Y_Tabu.contains(j))
					{ 
						if(Y_GR_UP[j]>YAspire_DN[j])
						{
							Y_Gp.add(j);
						}
						else if(Y_GR_UP[j]<=YAspire_DN[j])
						{
							Tenure=Math.max(1, Math.random()*Ysize);
							YTabuTenure_UP[j]+=Tenure;
						}
					}
					else if(!Y_Tabu.contains(j))
					{
						Y_Tabu.add(j);
						Y_Gp.add(j);
					}
				}
				else if(Y_R_UP.contains(j))
				{  
					if(Y_Tabu.contains(j))
					{
						if(Y_GR_DN[j]>YAspire_UP[j])
						{
							Y_Gp.add(j);
						}
						else if(Y_GR_DN[j]<=YAspire_UP[j])
						{
							Tenure=Math.max(1, Math.random()*Ysize);
							YTabuTenure_DN[j]+=Tenure;
						}
					}
					else if(!Y_Tabu.contains(j))
					{
						Y_Tabu.add(j);
						Y_Gp.add(j);
					}
				}
			}
		}
		
		for(int i=0;i<Y_G.size();i++)
		{
			j=Y_G.get(i);
			
			if(Y_Gs.size()<gs && !Y_Gp.contains(j)){
				
				if(Y_R_DN.contains(j))
				{
					if(Y_Tabu.contains(j))
					{ 
						if(Y_GR_UP[j]>YAspire_DN[j])
						{
							Y_Gs.add(j);
						}
						else if(Y_GR_UP[j]<=YAspire_DN[j])
						{
							Tenure=Math.max(1, Math.random()*Ysize);
							YTabuTenure_UP[j]+=Tenure;
						}
					}
					else if(!Y_Tabu.contains(j))
					{
						Y_Tabu.add(j);
						Y_Gs.add(j);
					}
				}
				else if(Y_R_UP.contains(j))
				{  
					if(Y_Tabu.contains(j))
					{
						if(Y_GR_DN[j]>YAspire_UP[j])
						{
							Y_Gs.add(j);
						}
						else if(Y_GR_DN[j]<=YAspire_UP[j])
						{
							Tenure=Math.max(1, Math.random()*Ysize);
							YTabuTenure_DN[j]+=Tenure;
						}
					}
					else if(!Y_Tabu.contains(j))
					{
						Y_Tabu.add(j);
						Y_Gs.add(j);
					}
				}
			}
		}
	}
	
		static void SortX_G(){
			
			// 將X_G由大排至小的編號
			int[] Xsortnum = new int[X_G.size()];
			for (int i = 0; i < Xsortnum.length; i++)
				Xsortnum[i] = X_G.get(i);
			int temp;
			double temp1;
			
			double[] GRj=new double[X_G.size()];
			
			for(int i=0;i<X_G.size();i++)
			{
				int j=X_G.get(i);
				if(X_R_DN.contains(j))
				{
					GRj[i]=X_GR_UP[j];
				}
				else if(X_R_UP.contains(j))
				{
					GRj[i]=X_GR_DN[j];
				}
			}
			
			for (int i = 0; i < GRj.length; i++)
				for (int j = i + 1; j < GRj.length; j++)
					if (GRj[j] > GRj[i]) {
						temp = Xsortnum[i];
						Xsortnum[i] = Xsortnum[j];
						Xsortnum[j] = temp;
					
						temp1=GRj[i];
						GRj[i]=GRj[j];
						GRj[j]=temp1;
					}
			
			X_G.clear();
			for (int i = 0; i < Xsortnum.length; i++)
				X_G.add(Xsortnum[i]);
			
		}
		
		
		static void SortY_G(){
			
			// 將X_G由大排至小的編號
			int[] Ysortnum = new int[Y_G.size()];
			for (int i = 0; i < Ysortnum.length; i++)
				Ysortnum[i] = Y_G.get(i);
			int temp;
			double temp1;
			
			double[] GRj=new double[Y_G.size()];
			
			for(int i=0;i<Y_G.size();i++)
			{
				int j=Y_G.get(i);
				if(Y_R_DN.contains(j))
				{
					GRj[i]=Y_GR_UP[j];
				}
				else if(Y_R_UP.contains(j))
				{
					GRj[i]=Y_GR_DN[j];
				}
			}
			
			for (int i = 0; i < GRj.length; i++)
				for (int j = i + 1; j < GRj.length; j++)
					if (GRj[j] > GRj[i]) {
						temp = Ysortnum[i];
						Ysortnum[i] = Ysortnum[j];
						Ysortnum[j] = temp;
						
						temp1=GRj[i];
						GRj[i]=GRj[j];
						GRj[j]=temp1;
					}
			
			Y_G.clear();
			for (int i = 0; i < Ysortnum.length; i++)
				Y_G.add(Ysortnum[i]);
		}
		
		static void CheckXTabuTenure(){
			System.out.println();
		int j;
		for(int i=0;i<X_G.size();i++)
		{
			j=X_G.get(i);
				
				if(X_R_DN.contains(j))
				{	
					if(XTabuTenure_UP[j]> XMaxtenure[j]){
					System.out.println("第 "+ j +" 的XTabuTenure > XMaxtenure  初始化 XTabuTenure 並將 Tabu 移除 "+j );
					if(XTabuTenure_UP[j]>XMaxtenure[j]){
						X_Tabu.removeAll(Arrays.asList(j));
						XTabuTenure_UP[j]=Mintenure;
					}
					}
				}
				else if(X_R_UP.contains(j))
				{  
					if(XTabuTenure_DN[j]> XMaxtenure[j]){
						System.out.println("第 "+ j +" 的XTabuTenure > XMaxtenure  初始化 XTabuTenure 並將 Tabu 移除 "+j );
						if(XTabuTenure_DN[j]>XMaxtenure[j]){
							X_Tabu.removeAll(Arrays.asList(j));
							XTabuTenure_DN[j]=Mintenure;
						}
					}
				}
		}
		}
		static void CheckYTabuTenure(){
			System.out.println();
			int j;
			for(int i=0;i<Y_G.size();i++)
			{
				j=Y_G.get(i);
					
					if(Y_R_DN.contains(j))
					{	
						if(YTabuTenure_UP[j]> YMaxtenure[j]){
						System.out.println("第 "+ j +" 的YTabuTenure > YMaxtenure  初始化 YTabuTenure 並將 Tabu 移除 "+j );
						if(YTabuTenure_UP[j]>YMaxtenure[j]){
							Y_Tabu.removeAll(Arrays.asList(j));
							YTabuTenure_UP[j]=Mintenure;
						}
						}
					}
					else if(Y_R_UP.contains(j))
					{  
						if(YTabuTenure_DN[j]> YMaxtenure[j]){
							System.out.println("第 "+ j +" 的YTabuTenure > YMaxtenure  初始化 YTabuTenure 並將 Tabu 移除 "+j );
							if(YTabuTenure_DN[j]>YMaxtenure[j]){
								Y_Tabu.removeAll(Arrays.asList(j));
								YTabuTenure_DN[j]=Mintenure;
							}
						}
					}
			}
			}
		
}
