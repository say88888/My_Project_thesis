package Algorithm_DoubleAuction.TS_DA;

public class Step6_2 extends TS_DA{

	public static void main() {

		// TODO Auto-generated method stub
		//計算目標X、Y 和存放N+、N-
		for(int i=0;i<X_D0.size();i++){
			if(X_IP_DN.get(i)<=X_IP_UP.get(i)){
				X_goalvalue[X_D0.get(i)]=Math.ceil(X_LP[X_D0.get(i)])-1;
				if(!X_Ndn.contains(X_D0.get(i)))
					X_Ndn.add(X_D0.get(i));
			}
			else{
				X_goalvalue[X_D0.get(i)]=Math.floor(X_LP[X_D0.get(i)])+1;
				if(!X_Nup.contains(X_D0.get(i)))
					X_Nup.add(X_D0.get(i));
			}
		}
		for(int i=0;i<Y_D0.size();i++){
			if(Y_IP_DN.get(i)<=Y_IP_UP.get(i)){
				Y_goalvalue[Y_D0.get(i)]=Math.ceil(Y_LP[Y_D0.get(i)])-1;
				if(!Y_Ndn.contains(Y_D0.get(i)))
					Y_Ndn.add(Y_D0.get(i));
			}
			else{
				Y_goalvalue[Y_D0.get(i)]=Math.floor(Y_LP[Y_D0.get(i)])+1;
				if(!Y_Nup.contains(Y_D0.get(i)))
					Y_Nup.add(Y_D0.get(i));
			}
		}
		

	/*	System.out.print("X_Ndn ");
		for(int i=0;i<X_Ndn.size();i++)
			System.out.print(X_Ndn.get(i)+" ");
		System.out.println();
		System.out.print("X_Nup ");
		for(int i=0;i<X_Nup.size();i++)
			System.out.print(X_Nup.get(i)+" ");
		System.out.println();
		for(int i=0;i<X1.length;i++)
			System.out.print(X1[i]+" ");
		System.out.println();
		System.out.print("Y_Ndn ");
		for(int i=0;i<Y_Ndn.size();i++)
			System.out.print(Y_Ndn.get(i)+" ");
		System.out.println();
		System.out.print("Y_Nup ");
		for(int i=0;i<Y_Nup.size();i++)
			System.out.print(Y_Nup.get(i)+" ");
		System.out.println();
		for(int i=0;i<Y1.length;i++)
			System.out.print(Y1[i]+" ");
		System.out.println();*/
	}

}
