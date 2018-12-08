package Algorithm_DoubleAuction.TS_DA;

import java.util.Arrays;

public class Step6_1 extends TS_DA{

	public static void main() {
	
		//根據Gp與Gs 內的值做出R-UP、R-DN反應，更新Aspire的值為最大的抵抗值
		
		for(int i=0;i<X_Gp.size();i++)
		{
			int j=X_Gp.get(i);
			
			if(X_R_DN.contains(j)){
				if(X_GR_UP[j]>XAspire_UP[j])
					XAspire_UP[j]=X_GR_UP[j];
				}
			if(X_R_UP.contains(j)){
				if(X_GR_DN[j]>XAspire_DN[j])
					XAspire_DN[j]=X_GR_DN[j];
			}
			
			if(X_LP[j]<X_goalvalue[j] && X_Nup.contains(j))
			{
				X_Nup.removeAll(Arrays.asList(j));
				X_Ndn.add(j);					
				X_goalvalue[j]=Math.ceil(X_LP[j])-1;
				if(X_goalvalue[j]<0){X_goalvalue[j]=0;}
			}
			else if(X_LP[j]>X_goalvalue[j] && X_Ndn.contains(j))
			{
				X_Ndn.removeAll(Arrays.asList(j));
				X_Nup.add(j);							
				X_goalvalue[j]=Math.floor(X_LP[j])+1;
				if(X_goalvalue[j]>1){X_goalvalue[j]=1;}
			}
		}
		for(int i=0;i<X_Gs.size();i++)
		{
			int j=X_Gs.get(i);
			
			if(X_R_DN.contains(j)){
				if(X_GR_UP[j]>XAspire_UP[j])
					XAspire_UP[j]=X_GR_UP[j];
				}
			if(X_R_UP.contains(j)){
				if(X_GR_DN[j]>XAspire_DN[j])
					XAspire_DN[j]=X_GR_DN[j];
			}
			
			X_Nup.removeAll(Arrays.asList(j));
			X_Ndn.removeAll(Arrays.asList(j));
		}
		
		for(int i=0;i<Y_Gp.size();i++)
		{
			int j=Y_Gp.get(i);
			
			if(Y_R_DN.contains(j)){
				if(Y_GR_UP[j]>YAspire_UP[j])
					YAspire_UP[j]=Y_GR_UP[j];
				}
			if(Y_R_UP.contains(j)){
				if(Y_GR_DN[j]>YAspire_DN[j])
					YAspire_DN[j]=Y_GR_DN[j];
			}
			
			if(Y_LP[j]<Y_goalvalue[j] && Y_Nup.contains(j))
			{
				Y_Nup.removeAll(Arrays.asList(j));	
				Y_Ndn.add(j);
				Y_goalvalue[j]=Math.ceil(Y_LP[j])-1;
				if(Y_goalvalue[j]<0){Y_goalvalue[j]=0;}
			}
			else if(Y_LP[j]>Y_goalvalue[j] && Y_Ndn.contains(j))
			{
				Y_Ndn.removeAll(Arrays.asList(j));
				Y_Nup.add(j);			
				Y_goalvalue[j]=Math.floor(Y_LP[j])+1;
				if(Y_goalvalue[j]>1){Y_goalvalue[j]=1;}
			}
		}
		
		for(int i=0;i<Y_Gs.size();i++)
		{
			int j=Y_Gs.get(i);
			Y_Nup.removeAll(Arrays.asList(j));
			Y_Ndn.removeAll(Arrays.asList(j));
			
			if(Y_R_DN.contains(j)){
				if(Y_GR_UP[j]>YAspire_UP[j])
					YAspire_UP[j]=Y_GR_UP[j];
				}
			if(X_R_UP.contains(j)){
				if(Y_GR_DN[j]>YAspire_DN[j])
					YAspire_DN[j]=Y_GR_DN[j];
			}
		}
		
		X_G.clear();
		Y_G.clear();
	}

}
