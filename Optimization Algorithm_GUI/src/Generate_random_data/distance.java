package Generate_random_data;

import java.io.FileWriter;

import carpool_Alogorithm_MOD.DistanceCaculateApi;
import GUI.I_Set_Paths_for_Current_Simulation_Example;
import READ_TXT.Read_API_KEY;

public class distance {
	public static int k = 0;

	public static void main( ) throws Exception {
		Read_API_KEY.main();
		Read_Generate_random.main();
		String[] Key = new String[Read_API_KEY.Key().size()];
		for (int i = 0; i < Key.length; i++)
			Key[i] = Read_API_KEY.Key().get(i);

		double[] lat = new double[Read_Generate_random.N()];
		double[] lng = new double[Read_Generate_random.N()];
		double[][] distance = new double[Read_Generate_random.N()][Read_Generate_random
				.N()];
		for (int i = 0; i < lat.length; i++) {
			lat[i] = Read_Generate_random.lat(i);
			lng[i] = Read_Generate_random.lng(i);
		}
		int t = 0;
		DistanceCaculateApi d1 = new DistanceCaculateApi();
		FileWriter fw2 = new FileWriter(I_Set_Paths_for_Current_Simulation_Example.path()+"\\Generate_random\\DistanceMatrix",false);
		for (int i = 0; i < distance.length; i++) {
			for (int j = 0; j < distance.length; j++) {
				distance[i][j] = d1.newRequest(lat[i], lng[i], lat[j], lng[j],
						Key[k]);
				k++;
				if (k == Key.length)
					k = 0;
				fw2.write(String.valueOf(distance[i][j]) + " ");
				t++;
				System.out.println(t);
			}
			fw2.write("\r\n");
		}

		fw2.close();
	}
}
