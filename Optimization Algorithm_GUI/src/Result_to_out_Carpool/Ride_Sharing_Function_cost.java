package Result_to_out_Carpool;

public class Ride_Sharing_Function_cost extends carpool_results_test {

	// 所有司機和乘客的乘坐共享和無乘坐共享的總行程距離之間的比率 ;cdj1=共乘後的費率
	public static double ride_sharing_distance_Ratio() {

		int c = 0;
		int[][] Y = new int[Read_Carpool_file.getP()][];
		for (int i = 0; i < Read_Carpool_file.getP(); i++)
			Y[i] = new int[Read_Carpool_file.getHp(i)];
		int[][] X = new int[Read_Carpool_file.getD()][];
		for (int i = 0; i < Read_Carpool_file.getD(); i++)
			X[i] = new int[Read_Carpool_file.getJd(i)];

		int b = 0;
		for (int i = 0; i < Y.length; i++)
			for (int j = 0; j < Y[i].length; j++)
				Y[i][j] = Yph[c++];
		for (int i = 0; i < X.length; i++)
			for (int j = 0; j < X[i].length; j++)
				X[i][j] = Xdj[b++];

		double fit = 0;
		for (int p = 0; p < Read_Carpool_file.getP(); p++)
			for (int h = 0; h < Read_Carpool_file.getHp(p); h++) {
				fit += (1 - Y[p][h]) * Read_Carpool_file.getfph(p, h);
				System.out.println("Y"+p+","+h+"="+Y[p][h]+" f"+p+","+h+"="+Read_Carpool_file.getfph(p, h)+" (1-yph)fph="+ (1 - Y[p][h]) * Read_Carpool_file.getfph(p, h));
			}
		System.out.println("總和(1-yph)fph="+fit);
		double fit1=0;
		int a = 0;
		for (int d = 0; d < Read_Carpool_file.getD(); d++)
			for (int j = 0; j < Read_Carpool_file.getJd(d); j++) {
				if (X[d][j] == 1) {
					fit1 += X[d][j] * DriverBids[a][P];
					System.out.println("X"+d+","+j+"="+X[d][j]+"~C"+d+","+j+DriverBids[a][P]+"Xdj*~Cdj="+X[d][j] * DriverBids[a][P]);
					a++;
				}
			}
		System.out.println("總和Xdj*~Cdj="+fit1);
		double fit2=0;
		for (int d = 0; d < Read_Carpool_file.getD(); d++)
			for (int j = 0; j < Read_Carpool_file.getJd(d); j++) {
				fit2 += (1 - X[d][j]) * Read_Carpool_file.getCdj(d, j);
				System.out.println("X"+d+","+j+"="+X[d][j]+" C"+d+","+j+"="+Read_Carpool_file.getCdj(d, j)+" (1-Xdj)Cdj="+ (1 - X[d][j]) * Read_Carpool_file.getCdj(d, j));
			}
		System.out.println("總和(1-Xdj)Cdj="+fit2);
		double fit3 = 0;
		for (int p = 0; p < Read_Carpool_file.getP(); p++)
			for (int h = 0; h < Read_Carpool_file.getHp(p); h++) {
				fit3 += Read_Carpool_file.getfph(p, h);
			}
		System.out.println("總和fph="+fit3);
		double fit4=0;
		for (int d = 0; d < Read_Carpool_file.getD(); d++)
			for (int j = 0; j < Read_Carpool_file.getJd(d); j++) {
				fit4 += Read_Carpool_file.getCdj(d, j);
			}
		System.out.println("總和Cdj="+fit4);
		
		return (fit+fit1+fit2)/( fit3+fit4);
	}

	// 所有司機和乘客的總行程距離減少百分比
	public static double distance_reduction_Percentage() {

		int c = 0;
		int[][] Y = new int[Read_Carpool_file.getP()][];
		for (int i = 0; i < Read_Carpool_file.getP(); i++)
			Y[i] = new int[Read_Carpool_file.getHp(i)];
		int[][] X = new int[Read_Carpool_file.getD()][];
		for (int i = 0; i < Read_Carpool_file.getD(); i++)
			X[i] = new int[Read_Carpool_file.getJd(i)];

		int b = 0;
		for (int i = 0; i < Y.length; i++)
			for (int j = 0; j < Y[i].length; j++)
				Y[i][j] = Yph[c++];
		for (int i = 0; i < X.length; i++)
			for (int j = 0; j < X[i].length; j++)
				X[i][j] = Xdj[b++];

		double fit = 0, fit1 = 0;
		for (int p = 0; p < Read_Carpool_file.getP(); p++)
			for (int h = 0; h < Read_Carpool_file.getHp(p); h++) {
				fit += (1 - Y[p][h]) * Read_Carpool_file.getfph(p, h);
				fit1 += Read_Carpool_file.getfph(p, h);
			}
		int a = 0;
		for (int d = 0; d < Read_Carpool_file.getD(); d++)
			for (int j = 0; j < Read_Carpool_file.getJd(d); j++) {
				if (X[d][j] == 1) {
					fit += X[d][j] * DriverBids[a][P];
					a++;
				}
				fit += (1 - X[d][j]) * Read_Carpool_file.getCdj(d, j);
				fit1 += Read_Carpool_file.getCdj(d, j);
			}

		return 1 - (fit / fit1);
	}

	// 成功的乘坐共享駕駛員和乘客之間的乘坐共享和沒有乘坐共享的總行程距離之間的比率
	public static double successful_ride_sharing_and_no_ride_sharing_distance_Ratio() {

		int c = 0;
		int[][] Y = new int[Read_Carpool_file.getP()][];
		for (int i = 0; i < Read_Carpool_file.getP(); i++)
			Y[i] = new int[Read_Carpool_file.getHp(i)];
		int[][] X = new int[Read_Carpool_file.getD()][];
		for (int i = 0; i < Read_Carpool_file.getD(); i++)
			X[i] = new int[Read_Carpool_file.getJd(i)];

		int b = 0;
		for (int i = 0; i < Y.length; i++)
			for (int j = 0; j < Y[i].length; j++)
				Y[i][j] = Yph[c++];
		for (int i = 0; i < X.length; i++)
			for (int j = 0; j < X[i].length; j++)
				X[i][j] = Xdj[b++];

		double fit = 0, fit1 = 0;
		int a = 0;
		for (int p = 0; p < Read_Carpool_file.getP(); p++)
			for (int h = 0; h < Read_Carpool_file.getHp(p); h++) {
				if (Y[p][h] == 1) {
					fit += Y[p][h] * PassengerBids[a][P];
					a++;
				}
				fit1 += Y[p][h] * Read_Carpool_file.getfph(p, h);
			}
		a = 0;
		for (int d = 0; d < Read_Carpool_file.getD(); d++)
			for (int j = 0; j < Read_Carpool_file.getJd(d); j++) {
				if (X[d][j] == 1) {
					fit += X[d][j] * DriverBids[a][P];
					a++;
				}
				fit1 += X[d][j] * Read_Carpool_file.getCdj(d, j);
			}

		return fit / fit1;
	}

	// 成功的乘坐共享駕駛員和乘客的總體行駛距離減少的百分比
	public static double successful_distance_reduction_Percentage() {

		
		int c = 0;
		int[][] Y = new int[Read_Carpool_file.getP()][];
		for (int i = 0; i < Read_Carpool_file.getP(); i++)
			Y[i] = new int[Read_Carpool_file.getHp(i)];
		int[][] X = new int[Read_Carpool_file.getD()][];
		for (int i = 0; i < Read_Carpool_file.getD(); i++)
			X[i] = new int[Read_Carpool_file.getJd(i)];

		int b = 0;
		for (int i = 0; i < Y.length; i++)
			for (int j = 0; j < Y[i].length; j++)
				Y[i][j] = Yph[c++];
		for (int i = 0; i < X.length; i++)
			for (int j = 0; j < X[i].length; j++)
				X[i][j] = Xdj[b++];

		double fit = 0, fit1 = 0;
		int a = 0;
		for (int p = 0; p < Read_Carpool_file.getP(); p++)
			for (int h = 0; h < Read_Carpool_file.getHp(p); h++) {
				if (Y[p][h] == 1) {
					fit += Y[p][h] * PassengerBids[a][P];
					a++;
				}
				fit1 += Y[p][h] * Read_Carpool_file.getfph(p, h);
			}
		a = 0;
		for (int d = 0; d < Read_Carpool_file.getD(); d++)
			for (int j = 0; j < Read_Carpool_file.getJd(d); j++) {
				if (X[d][j] == 1) {
					fit += X[d][j] * DriverBids[a][P];
					a++;
				}
				fit1 += X[d][j] * Read_Carpool_file.getCdj(d, j);
			}

		return 1 - (fit / fit1);
	}
}
