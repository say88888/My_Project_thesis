package Generate_random_data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

import GUI.I_Set_Paths_for_Current_Simulation_Example;


public class Read_INPUT_TXT_Original_passenger_initial_itinerary {	
	
	

	//乘客資料輸入   乘客四筆資料
	private static	int P;
	private static    String[] P_ID;                          //乘客ID
	private static   int[] P_itinerary_ID;                //乘客行程ID
	private static   String[] P_F_R_Time;       //乘客提早搭車時間
	private static   String[] P_D_R_Time;       //乘客延遲搭車時間						 	 
	private static   String[] P_F_A_Time;        //乘客到達目的時間
	private static   String[] P_D_A_Time;          //乘客延遲到達目的地時間
	private static String[] P_R_PLACE;        //乘客搭車地點
	private static	double[] P_R_LAT;          //乘客搭車地點緯度
	private static	double[] P_R_LNG;          //乘客搭車地點經度		   
	private static	String[] P_D_ADDRESS;     //定義乘客目的地位置			              
	private static	double[] P_D_LAT;			//乘客目的地經度
	private static	double[] P_D_LNG;           //乘客目的地緯度
	private static double[] fph;                     //乘客願意支付的成本
	private static int[] seat;                   //乘客要求座位
	private static int[] weight;                 //乘客要求重量
	private static double[] PassengerOilConsumption;     //乘客油耗量   
	
	
	private static	int P_length;
	private static String[] Passenger_Account_Number;   //帳號
	private static String[] Passenger_Password;              //密碼
	private static String[] Passenger_Birthday;               //生日
	private static String[] Passenger_Cell_Phone;               //電話
	private static String[] Passenger_E_mail;                 //電子郵件
	private static String[] Passenger_Occupation;           //職業
	private static String[] Passenger_Age;                      // 年齡
	private static String[] Passenger_Gender;                  //性別
	private static String[] Passenger_School;                  // 學校
	private static String[] Passenger_Department;           // 科系
	
//定義投標資料-----------------------------------------------

	private static int i=0,j=0;
	
	
	public static void loadData() throws IOException{
	
	P=0;
	String str;
	Vector<String []> str_vec = new Vector<String []>(); //暫存
	Vector<String []> str_vec3 = new Vector<String []>(); //暫存
	int count=0;

	//---------------讀 passenger_initial itinerary.txt-------------------------------
	try {
		FileReader PBr = new FileReader(I_Set_Paths_for_Current_Simulation_Example.path()+"\\SQL_input_random\\Original_passenger_initial_itinerary");
		BufferedReader br = new BufferedReader(PBr);
		while ((str = br.readLine()) != null) { //每次讀一行
			str_vec.add(str.split(",")); //將此行以空白(white space)切成字串陣列, 存入 Vector暫存 
				P++;
		}
	br.close(); //關檔
	} catch (Exception e) {
	e.printStackTrace();
	}
	
	//--------------------------------讀取 passenger_data--------------------------------
	try {
		FileReader PBr3 = new FileReader(I_Set_Paths_for_Current_Simulation_Example.path()+"\\SQL_input_random\\passenger_data");
		BufferedReader br3 = new BufferedReader(PBr3);
		while ((str = br3.readLine()) != null) { //每次讀一行
	str_vec3.add(str.split(",")); //將此行以空白(white space)切成字串陣列, 存入 Vector暫存 
	P_length++;
	}
	br3.close(); //關檔
	} catch (Exception e) {
	e.printStackTrace();
	}
	
	//-----------------------------------------------------
		 P_ID=new String[P];                          //乘客ID
		P_itinerary_ID=new int[P];                //乘客行程ID
		P_F_R_Time=new String[P];       //乘客提早搭車時間
		 P_D_R_Time=new String[P];       //乘客延遲搭車時間						 	 
		P_F_A_Time=new String[P];        //乘客到達目的時間
		 P_D_A_Time=new String[P];          //乘客延遲到達目的地時間
		P_R_PLACE=new String[P];        //乘客搭車地點
		P_R_LAT=new double[P];          //乘客搭車地點緯度
		 P_R_LNG=new double[P];          //乘客搭車地點經度		   
		P_D_ADDRESS=new String[P];     //定義乘客目的地位置			              
		 P_D_LAT=new double[P];			//乘客目的地經度
		P_D_LNG=new double[P];           //乘客目的地緯度
		fph=new double[P];                     //乘客願意支付的成本
		 seat=new int[P];                   //乘客要求座位
		 weight=new int[P];                 //乘客要求重量
		 PassengerOilConsumption=new double[P];

		 
			String[][] Passenger_itinerary =new String[P][14];
			String[][] Passenger_data =new String[P][11];
			String[] Pri = new String[P_length];
			
			double[] P_Fuel=new double[P_length];
			
			Passenger_Account_Number=new String[P_length];   //帳號
			Passenger_Password=new String[P_length];              //密碼
			Passenger_Birthday=new String[P_length];               //生日
			Passenger_Cell_Phone=new String[P_length];               //電話
			Passenger_E_mail=new String[P_length];                 //電子郵件
			Passenger_Occupation=new String[P_length];           //職業
			Passenger_Age=new String[P_length];                      // 年齡
			Passenger_Gender=new String[P_length];                  //性別
			Passenger_School=new String[P_length];                  // 學校
			Passenger_Department=new String[P_length];           // 科系
	//------------------------------------------------------
	
	Passenger_itinerary = new String [str_vec.size()][]; //產生二維陣列, 依據暫存的size(txt檔的行數)
	for (i = 0; i < str_vec.size(); i++)
		Passenger_itinerary[i] = str_vec.elementAt(i); //將暫存區每一個元素(一行裡的字串陣列)放入二維陣列
	//印出二維陣列內容
	for (i = 0; i < Passenger_itinerary.length; i++) {
	for (j = Passenger_itinerary[i].length-1; j <= Passenger_itinerary[i].length-1; j++) {
		P_ID[i]=Passenger_itinerary[i][0]; 		P_itinerary_ID[i]=Integer.parseInt(Passenger_itinerary[i][1]);
		P_F_R_Time[i]=Passenger_itinerary[i][2].toString();         P_D_R_Time[i]=Passenger_itinerary[i][3].toString();
		P_F_A_Time[i]=Passenger_itinerary[i][4].toString(); 		P_D_A_Time[i]=Passenger_itinerary[i][5].toString();
		P_R_LAT[i]=Double.parseDouble(Passenger_itinerary[i][6]);	P_R_LNG[i]=Double.parseDouble(Passenger_itinerary[i][7]);
		P_R_PLACE[i]=Passenger_itinerary[i][8];						P_D_LAT[i]=Double.parseDouble(Passenger_itinerary[i][9]);
		P_D_LNG[i]=Double.parseDouble(Passenger_itinerary[i][10]);	P_D_ADDRESS[i]=Passenger_itinerary[i][11];
		fph[i]=Double.parseDouble(Passenger_itinerary[i][12]);   seat[i]=Integer.parseInt(Passenger_itinerary[i][13]); 
		weight[i]=Integer.parseInt(Passenger_itinerary[i][14]);
	}
	}

		//--------------------------------------------------
		Passenger_data = new String [str_vec3.size()][]; //產生二維陣列, 依據暫存的size(txt檔的行數)
		for (i = 0; i < str_vec3.size(); i++)
			Passenger_data[i] = str_vec3.elementAt(i); //將暫存區每一個元素(一行裡的字串陣列)放入二維陣列
		//印出二維陣列內容
		for (i = 0; i < Passenger_data.length; i++) {
			for (j = Passenger_data[i].length-1; j <= Passenger_data[i].length-1; j++){
				Pri[i]=Passenger_data[i][0];
				Passenger_Account_Number[i]=Passenger_data[i][1];   //帳號
				Passenger_Password[i]=Passenger_data[i][2];               //密碼
				Passenger_Birthday[i]=Passenger_data[i][3];                //生日
				Passenger_Cell_Phone[i]=Passenger_data[i][4];                //電話
				Passenger_E_mail[i]=Passenger_data[i][5];                 //電子郵件
				Passenger_Occupation[i]=Passenger_data[i][6];           //職業
				Passenger_Age[i]=Passenger_data[i][7];                      // 年齡
				Passenger_Gender[i]=Passenger_data[i][8];                  //性別
				Passenger_School[i]=Passenger_data[i][9];                  // 學校
				Passenger_Department[i]=Passenger_data[i][10];           // 科系
				P_Fuel[i]=Double.parseDouble(Passenger_data[i][11]);
				}
			count++;
			}
		
		for(i=0;i<count;i++)
			for(j=0;j<P;j++)
				if(P_ID[j].equals(Pri[i])){
					PassengerOilConsumption[j]=P_Fuel[i];
				}
	}
		//--------------------------
		//----------乘客回傳值------------------------------
		public static int getP(){
			return P;
			}

		public static String getP_ID(int i){
			return P_ID[i];
			}
		public static int getP_itinerary_ID(int i){
			return P_itinerary_ID[i];
			}
		public static String getP_F_R_Time(int i){
			return P_F_R_Time[i];
			}
		public static String getP_D_R_Time(int i){
			return P_D_R_Time[i];
			}
		public static String getP_F_A_Time(int i){
			return P_F_A_Time[i];
			}
		public static String getP_D_A_Time(int i){
			return P_D_A_Time[i];
		}
		public static String getP_R_PLACE(int i){
			return P_R_PLACE[i];
		}
		public static double getP_R_LAT(int i){
			return P_R_LAT[i];
		}
		public static double getP_R_LNG(int i){
			return P_R_LNG[i];
		}
		public static String getP_D_ADDRESS(int i){
			return P_D_ADDRESS[i];
		}
		public static double getP_D_LAT(int i){
			return P_D_LAT[i];
		}
		public static double getP_D_LNG(int i){
			return P_D_LNG[i];
		}
		public static double getfph(int i){
			return fph[i];
		}
		public static int getseat(int i){
			return seat[i];
		}
		public static int getweight(int i){
			return weight[i];
		}
		public static double  getPassengerOilConsumption(int i){
			return PassengerOilConsumption[i];
		}
		
		public static String getPassenger_Account_Number(int i){
			return Passenger_Account_Number[i];
		}
		public static String getPassenger_Password(int i){
			return Passenger_Password[i];
		}
		public static String getPassenger_Birthday(int i){
			return Passenger_Birthday[i];
		}
		public static String getPassenger_Cell_Phone(int i){
			return Passenger_Cell_Phone[i];
		}
		public static String getPassenger_E_mail(int i){
			return Passenger_E_mail[i];
		}
		public static String getPassenger_Occupation(int i){
			return Passenger_Occupation[i];
		}
		public static String getPassenger_Age(int i){
			return Passenger_Age[i];
		}
		public static String getPassenger_Gender(int i){
			return Passenger_Gender[i];
		}
		public static String getPassenger_School(int i){
			return Passenger_School[i];
		}
		public static String getPassenger_Department(int i){
			return Passenger_Department[i];
		}
}
