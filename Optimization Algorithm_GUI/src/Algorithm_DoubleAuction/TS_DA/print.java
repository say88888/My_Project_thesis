package Algorithm_DoubleAuction.TS_DA;

public class print extends TS_DA{

	public static void main() {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.print("X_M= ");
		for (int i = 0; i < X_M.size(); i++)
			System.out.print(X_M.get(i) + " ");
		System.out.println();
		System.out.print("Y_M= ");
		for (int i = 0; i < Y_M.size(); i++)
			System.out.print(Y_M.get(i) + " ");
		System.out.println();

		System.out.print("X goal value= ");
		for (int i = 0; i < X_goalvalue.length; i++)
			System.out.print(X_goalvalue[i] + " ");
		System.out.println();

		System.out.print("Y goal value= ");
		for (int i = 0; i < Y_goalvalue.length; i++)
			System.out.print(Y_goalvalue[i] + " ");
		System.out.println();

		System.out.print("X_Nup =  ");
		for (int j = 0; j < X_Nup.size(); j++)
			System.out.print(X_Nup.get(j) + " ");
		System.out.println();

		System.out.print("X_Ndn = ");
		for (int j = 0; j < X_Ndn.size(); j++)
			System.out.print(X_Ndn.get(j) + " ");
		System.out.println();

		System.out.print("Y_Nup = ");
		for (int j = 0; j < Y_Nup.size(); j++)
			System.out.print(Y_Nup.get(j) + " ");
		System.out.println();

		System.out.print("Y_Ndn = ");
		for (int j = 0; j < Y_Ndn.size(); j++)
			System.out.print(Y_Ndn.get(j) + " ");
		System.out.println();
	}
	

}
