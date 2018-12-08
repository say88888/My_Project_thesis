package READ_TXT;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.util.Vector;

import GUI.I_Set_Paths_for_Current_Simulation_Example;
import GUI.main;

public class Read_distance  {


	private static double[][] Distance;
	private static int[][] Distancetime;
	
	public static void Read_distance()  {
		
		String str;
		String Parameter[][];
		String Parameter1[][];
		
		Vector<String []> str_vec = new Vector<String []>(); //暫存
		Vector<String []> str_vec1 = new Vector<String []>(); //暫存
		
		
		int i,j,k=0;
		
		try {
			FileReader PBr = new FileReader("Read_Distance_MOD.txt");
			BufferedReader br = new BufferedReader(PBr);
			while ((str = br.readLine()) != null) { //每次讀一行
		str_vec1.add(str.split(" ")); //將此行以空白(white space)切成字串陣列, 存入 Vector暫存 
		}
		br.close(); //關檔
		} catch (Exception e) {
		e.printStackTrace();
		}

		Parameter1 = new String [str_vec1.size()][]; //產生二維陣列, 依據暫存的size(txt檔的行數)
		for (i = 0; i < str_vec1.size(); i++)
		Parameter1[i] = str_vec1.elementAt(i); //將暫存區每一個元素(一行裡的字串陣列)放入二維陣列
		
		
		
		if(Parameter1[0][0].equals("online")){
		// TODO Auto-generated method stub
		try {
			FileReader PBr = new FileReader(I_Set_Paths_for_Current_Simulation_Example.path()+"\\Generate_random\\DistanceMatrix");
			BufferedReader br = new BufferedReader(PBr);
			while ((str = br.readLine()) != null) { //每次讀一行
				k++;
		str_vec.add(str.split(" ")); //將此行以空白(white space)切成字串陣列, 存入 Vector暫存 
		}
		br.close(); //關檔
		} catch (Exception e) {
		e.printStackTrace();
		}
	}
		else if(Parameter1[0][0].equals("offline")){
			try {
				FileReader PBr = new FileReader(I_Set_Paths_for_Current_Simulation_Example.path()+"\\Generate_random\\DistanceMatrix200X200");
				BufferedReader br = new BufferedReader(PBr);
				while ((str = br.readLine()) != null) { //每次讀一行
					k++;
			str_vec.add(str.split(" ")); //將此行以空白(white space)切成字串陣列, 存入 Vector暫存 
			}
			br.close(); //關檔
			} catch (Exception e) {
			e.printStackTrace();
			}
		}
		
		
		
		Parameter = new String [str_vec.size()][]; //產生二維陣列, 依據暫存的size(txt檔的行數)
		for (i = 0; i < str_vec.size(); i++)
		Parameter[i] = str_vec.elementAt(i); //將暫存區每一個元素(一行裡的字串陣列)放入二維陣列
	
		Distance = new double[Parameter.length+1][ ];
	    for( i=0;i<Parameter.length;i++)
	    	Distance[i]=new double[Parameter[i].length+1];
	    
	    Distancetime= new int[Parameter.length+1][ ];
	    for( i=0;i<Parameter.length;i++)
	    	Distancetime[i]=new int[Parameter[i].length+1];
		
		//印出二維陣列內容
		for (i = 0; i < Parameter.length; i++) {
		for (j = 0; j <= Parameter[i].length-1; j++){
			Distance[i][j]=Double.parseDouble(Parameter[i][j]);			
			Distancetime[i][j]=(int) ((RoundingDistance(Distance[i][j])/0.35));}
			
		}
	}
	
	public static double RoundingDistance(double i){
		double d1 = i/1000;
		DecimalFormat df = new DecimalFormat("##.00");
		d1 = Double.parseDouble(df.format(d1));
		return d1;
	}
	
	public static double getDistance(int i,int j){
		return Distance[i][j];
	}
	
	
	public static int getDistancetime(int i,int j){
		return Distancetime[i][j];
	}

}
