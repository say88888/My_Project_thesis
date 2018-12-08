package Algorithm_DoubleAuction.TS_DA;

import java.util.ArrayList;

public class Step5_integer_infeasible extends TS_DA {

	public static void main(double[] x, double[] y) {
		// TODO Auto-generated method stub
		X_D0.clear();
		Y_D0.clear();
		X_IP_UP.clear();
		Y_IP_UP.clear();
		X_IP_DN.clear();
		Y_IP_DN.clear();
		ArrayList<Integer> X_D = new ArrayList<Integer>();
		ArrayList<Integer> Y_D = new ArrayList<Integer>();
		ArrayList<Integer> X_F = new ArrayList<Integer>();
		ArrayList<Integer> Y_F = new ArrayList<Integer>();

		// 計算F集合
		for (int i = 0; i < x.length; i++)
			if (x[i] % 1 != 0)
				X_F.add(i);
		for (int i = 0; i < y.length; i++)
			if (y[i] % 1 != 0)
				Y_F.add(i);

		// 計算D集合
		for (int i = 0; i < X_F.size(); i++)
			X_D.add(X_F.get(i));
		for (int i = 0; i < X_D.size(); i++)
			for (int j = 0; j < X_G.size(); j++)
				if (X_D.get(i) == X_G.get(j))
					X_D.remove(i);
		for (int i = 0; i < Y_F.size(); i++)
			Y_D.add(Y_F.get(i));
		for (int i = 0; i < Y_D.size(); i++)
			for (int j = 0; j < Y_G.size(); j++)
				if (Y_D.get(i) == Y_G.get(j))
					Y_D.remove(i);

		// 計算IP(UP)、IP(DN)、CP
		double[] X_CP = new double[X_D.size()];
		double[] Y_CP = new double[Y_D.size()];
		for (int i = 0; i < X_CP.length; i++) {
			X_IP_UP.add(Math.ceil(x[X_D.get(i)]) - x[X_D.get(i)]);
			X_IP_DN.add(x[X_D.get(i)] - Math.floor(x[X_D.get(i)]));
			X_CP[i] = Math.abs(X_IP_UP.get(i) - X_IP_DN.get(i));
		}
		for (int i = 0; i < Y_CP.length; i++) {
			Y_IP_UP.add(Math.ceil(y[Y_D.get(i)]) - y[Y_D.get(i)]);
			Y_IP_DN.add(y[Y_D.get(i)] - Math.floor(y[Y_D.get(i)]));
			Y_CP[i] = Math.abs(Y_IP_UP.get(i) - Y_IP_DN.get(i));
		}

		// 將CP由大排至小的編號
		int[] Xsortnum = new int[X_CP.length];
		for (int i = 0; i < Xsortnum.length; i++)
			Xsortnum[i] = X_D.get(i);
		int temp;
		for (int i = 0; i < X_CP.length; i++)
			for (int j = i + 1; j < X_CP.length; j++)
				if (X_CP[j] > X_CP[i]) {
					temp = Xsortnum[i];
					Xsortnum[i] = Xsortnum[j];
					Xsortnum[j] = temp;
				}
		int[] Ysortnum = new int[Y_CP.length];
		for (int i = 0; i < Ysortnum.length; i++)
			Ysortnum[i] = Y_D.get(i);
		for (int i = 0; i < Y_CP.length; i++)
			for (int j = i + 1; j < Y_CP.length; j++)
				if (Y_CP[j] > Y_CP[i]) {
					temp = Ysortnum[i];
					Ysortnum[i] = Ysortnum[j];
					Ysortnum[j] = temp;
				}

		// 計算D0集合
		for (int i = 0; i < Xsortnum.length; i++)
			if (X_D0.size() < d0)
				X_D0.add(Xsortnum[i]);
			else
				break;
		for (int i = 0; i < Ysortnum.length; i++)
			if (Y_D0.size() < d0)
				Y_D0.add(Ysortnum[i]);
			else
				break;

		System.out.print("X_D= ");
		for(int j=0;j<X_D.size();j++)
			System.out.print(X_D.get(j)+"  ");
		System.out.println();
		System.out.print("Y_D= ");
		for(int j=0;j<Y_D.size();j++)
			System.out.print(Y_D.get(j)+"  ");
		System.out.println();
		System.out.print("X_CP= ");
		for(int j=0;j<X_CP.length;j++)
			System.out.print(X_CP[j]+"  ");
		System.out.println();
		System.out.print("Y_CP= ");
		for(int j=0;j<Y_CP.length;j++)
			System.out.print(Y_CP[j]+"  ");
		System.out.println();
		System.out.print("X_IP_UP= ");
		for(int j=0;j<X_IP_UP.size();j++)
			System.out.print(X_IP_UP.get(j)+"  ");
		System.out.println();
		System.out.print("X_IP_DN= ");
		for(int j=0;j<X_IP_DN.size();j++)
			System.out.print(X_IP_DN.get(j)+"  ");
		System.out.println();
		System.out.print("Y_IP_UP= ");
		for(int j=0;j<Y_IP_UP.size();j++)
			System.out.print(Y_IP_UP.get(j)+"  ");
		System.out.println();
		System.out.print("Y_IP_DN= ");
		for(int j=0;j<Y_IP_DN.size();j++)
			System.out.print(Y_IP_DN.get(j)+"  ");
		System.out.println();
		System.out.println("d0= "+d0);
		System.out.print("X_D0= ");
		for(int j=0;j<X_D0.size();j++)
			System.out.print(X_D0.get(j)+"  ");
		System.out.println();
		
		System.out.print("Y_D0= ");
		for(int j=0;j<Y_D0.size();j++)
			System.out.print(Y_D0.get(j)+"  ");
		System.out.println();
		
	}

}
