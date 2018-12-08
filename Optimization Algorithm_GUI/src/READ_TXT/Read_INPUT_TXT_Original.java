package READ_TXT;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

import GUI.I_Set_Paths_for_Current_Simulation_Example;


public class Read_INPUT_TXT_Original {	
	
	private static	int D;
	private static	String[] D_ID;				private static	int[] D_itinerary_ID; 		//司機ID 	//司機行程ID;
	private static	String[] D_F_D_Time;        //司機提早發車時間
	private static	String[] D_S_D_Time;        //司機延遲發車時間
	private static	String[] D_F_A_Time;        //司機到達目的地時間
	private static	String[] D_S_A_Time;        //司機延遲到達目的地時間
	private static	String[] D_S_PLACE;        //司機發車地點
	private static	double[] D_S_LAT;           //司機發車地點緯度
	private static	double[] D_S_LNG;           //司機發車地點經度
	private static	String[] D_D_ADDRESS;       //定義司機目的地位置
	private static	double[] D_D_LAT;           //司機目的地緯度
	private static	double[] D_D_LNG;            //司機目的地經度
	private static int[] P_NUMBER;                 //可搭乘人數
	private static double[] DriverOilConsumption;     //司機油耗量   
	private static String[] License_Plate;     //車牌
	private static int[] Weight_Limit;                 //重量限制
	
	private static int[] Vehicle_Age;                 //車齡
	private static int[] Vehicle_Displacement; //汽車排量
	private static String[] Vehicle_Color;   //車子顏色


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
	private static	String[] P_data_Id;
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
	
	P=0;D=0;
	String str;
	Vector<String []> str_vec = new Vector<String []>(); //暫存
	Vector<String []> str_vec1 = new Vector<String []>(); //暫存
	Vector<String []> str_vec2 = new Vector<String []>(); //暫存
	Vector<String []> str_vec3 = new Vector<String []>(); //暫存
	int count=0;

	//---------------讀 passenger_initial itinerary.txt-------------------------------
	try {
		FileReader PBr = new FileReader(I_Set_Paths_for_Current_Simulation_Example.path()+"\\SQL_input_random_original\\Original_passenger_initial_itinerary");
		BufferedReader br = new BufferedReader(PBr);
		while ((str = br.readLine()) != null) { //每次讀一行
	str_vec.add(str.split(",")); //將此行以空白(white space)切成字串陣列, 存入 Vector暫存 
	P++;
		}
	br.close(); //關檔
	} catch (Exception e) {
	e.printStackTrace();
	}
	
	//-----------讀  driver_initial itinerary.txt---------------------------------------------------------------------
	try {
		FileReader PBr1 = new FileReader(I_Set_Paths_for_Current_Simulation_Example.path()+"\\SQL_input_random_original\\driver_initial_itinerary");
		BufferedReader br1 = new BufferedReader(PBr1);
		while ((str = br1.readLine()) != null) { //每次讀一行
	str_vec1.add(str.split(",")); //將此行以空白(white space)切成字串陣列, 存入 Vector暫存 
	D++;
		}
	br1.close(); //關檔
	} catch (Exception e) {
	e.printStackTrace();
	}
	//--------------------------------讀取CarData--------------------------------
	try {
		FileReader PBr2 = new FileReader(I_Set_Paths_for_Current_Simulation_Example.path()+"\\SQL_input_random_original\\car_data");
		BufferedReader br2 = new BufferedReader(PBr2);
		while ((str = br2.readLine()) != null) { //每次讀一行
	str_vec2.add(str.split(",")); //將此行以空白(white space)切成字串陣列, 存入 Vector暫存 
	}
	br2.close(); //關檔
	} catch (Exception e) {
	e.printStackTrace();
	}
	//--------------------------------讀取 passenger_data--------------------------------
	try {
		FileReader PBr3 = new FileReader(I_Set_Paths_for_Current_Simulation_Example.path()+"\\SQL_input_random_original\\passenger_data");
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
	D_ID=new String[D];				 D_itinerary_ID=new int[D]; 		//司機ID 	//司機行程ID;
	D_F_D_Time=new String[D];        //司機提早發車時間
	 D_S_D_Time=new String[D];        //司機延遲發車時間
	D_F_A_Time=new String[D];        //司機到達目的地時間
	D_S_A_Time=new String[D];        //司機延遲到達目的地時間
	 D_S_PLACE=new String[D];        //司機發車地點
	 D_S_LAT=new double[D];           //司機發車地點緯度
	 D_S_LNG=new double[D];           //司機發車地點經度
	D_D_ADDRESS=new String[D];       //定義司機目的地位置
	 D_D_LAT=new double[D];           //司機目的地緯度
	 D_D_LNG=new double[D];            //司機目的地經度
	 P_NUMBER=new int[D];                 //可搭乘人數
	 DriverOilConsumption=new double[D];     //車子油耗量   
	License_Plate=new String[D];     //車牌
	 Weight_Limit=new int[D];                 //重量限制
	
	 Vehicle_Age=new int[D];                 //車齡
	 Vehicle_Displacement=new int[D]; //汽車排量
	 Vehicle_Color=new String[D];   //車子顏色
	 
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

		 
			String[][] CarData =new String[D][8];
			String[][] Passenger_itinerary =new String[P][14];
			String[][] Driver_itinerary =new String[D][11];
			String[][] Passenger_data =new String[P][11];
			String[] Dri = new String[D];
			
			P_data_Id = new String[P_length];
			
			int[] number=new int[D];
			String[] License=new String [D];
			int[] w_limit=new int[D];
			 int[] Ve_Age=new int[D];                 //車齡
			int[] Ve_Displacement=new int[D]; //汽車排量
			String[] Ve_Color=new String[D];
			double[] D_Fuel = new double[D];
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

	//--------------------------------------------------------------------------
	Driver_itinerary = new String [str_vec1.size()][]; //產生二維陣列, 依據暫存的size(txt檔的行數)
	for (i = 0; i < str_vec1.size(); i++)
		Driver_itinerary[i] = str_vec1.elementAt(i); //將暫存區每一個元素(一行裡的字串陣列)放入二維陣列
	for (i = 0; i < Driver_itinerary.length; i++) {
		for (j = Driver_itinerary[i].length-1; j <= Driver_itinerary[i].length-1; j++) {
			D_ID[i]=Driver_itinerary[i][0]; 		D_itinerary_ID[i]=Integer.parseInt(Driver_itinerary[i][1]);
			D_F_D_Time[i]=Driver_itinerary[i][2].toString();             		D_S_D_Time[i]=Driver_itinerary[i][3].toString();
			D_F_A_Time[i]=Driver_itinerary[i][4].toString(); 					D_S_A_Time[i]=Driver_itinerary[i][5].toString();
		    D_S_LAT[i]=Double.parseDouble(Driver_itinerary[i][6]);		D_S_LNG[i]=Double.parseDouble(Driver_itinerary[i][7]);
			D_S_PLACE[i]=Driver_itinerary[i][8];						D_D_LAT[i]=Double.parseDouble(Driver_itinerary[i][9]);
			D_D_LNG[i]=Double.parseDouble(Driver_itinerary[i][10]);			D_D_ADDRESS[i]=Driver_itinerary[i][11];
		}
		}

		//--------------------------------------------------
		CarData = new String [str_vec2.size()][]; //產生二維陣列, 依據暫存的size(txt檔的行數)
		for (i = 0; i < str_vec2.size(); i++)
			CarData[i] = str_vec2.elementAt(i); //將暫存區每一個元素(一行裡的字串陣列)放入二維陣列
		//印出二維陣列內容
		for (i = 0; i < CarData.length; i++) {
			for (j = CarData[i].length-1; j <= CarData[i].length-1; j++){
				Dri[i]=CarData[i][0];
				License[i]=CarData[i][1];
				number[i]=Integer.parseInt(CarData[i][2]);
				D_Fuel[i]=Double.parseDouble(CarData[i][3]);
				w_limit[i]=Integer.parseInt(CarData[i][7]);
				
				Ve_Age[i]=Integer.parseInt(CarData[i][5]);               //車齡
				Ve_Displacement[i]=Integer.parseInt(CarData[i][4]); //汽車排量
				Ve_Color[i]=CarData[i][6];
				}
			count++;
			}
		
		for(i=0;i<count;i++)
			for(j=0;j<D;j++)
				if(D_ID[j].equals(Dri[i])){
					DriverOilConsumption[j]=D_Fuel[i];
					P_NUMBER[j]=number[i];
					License_Plate[j]=License[i];
					Weight_Limit[j]=w_limit[i];
				 Vehicle_Age[i]=Ve_Age[i];               //車齡
					Vehicle_Displacement[i]	=Ve_Displacement[i]; //汽車排量
					Vehicle_Color[i]=Ve_Color[i];
				}
		
		count=0;
		//--------------------------------------------------
		Passenger_data = new String [str_vec3.size()][]; //產生二維陣列, 依據暫存的size(txt檔的行數)
		for (i = 0; i < str_vec3.size(); i++)
			Passenger_data[i]= str_vec3.elementAt(i); //將暫存區每一個元素(一行裡的字串陣列)放入二維陣列
		//印出二維陣列內容
		for (i = 0; i < Passenger_data.length; i++) {
			for (j = Passenger_data[i].length-1; j <= Passenger_data[i].length-1; j++){
				P_data_Id[i]=Passenger_data[i][0];
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
				if(P_ID[j].equals(P_data_Id[i])){
					PassengerOilConsumption[j]=P_Fuel[i];
				}
		
	//----------------------------------------------------
	}
	//------------司機回傳值---------------------------------------
		
		public static int getD(){
			return D;
			}
		public static String getD_ID(int i){
			return D_ID[i];
			}
		public static int getD_itinerary_ID(int i){
			return D_itinerary_ID[i];
			}
		public static String getD_F_D_Time(int i){
			return D_F_D_Time[i];
			}
		public static String getD_S_D_Time(int i){
			return D_S_D_Time[i];
			}
		public static String getD_F_A_Time(int i){
			return D_F_A_Time[i];
			}
		public static String getD_S_A_Time(int i){
			return D_S_A_Time[i];
		}
		public static String getD_S_PLACE(int i){
			return D_S_PLACE[i];
		}
		public static double getD_S_LAT(int i){
			return D_S_LAT[i];
		}
		public static double getD_S_LNG(int i){
			return D_S_LNG[i];
		}
		public static String getD_D_ADDRESS(int i){
			return D_D_ADDRESS[i];
		}
		public static double getD_D_LAT(int i){
			return D_D_LAT[i];
		}
		public static double getD_D_LNG(int i){
			return D_D_LNG[i];
		}
		public static int getP_NUMBER(int i){
			return P_NUMBER[i];
		}
		public static double  getDriverOilConsumption(int i){
			return DriverOilConsumption[i];
		}
		public static String  getLicense_Plate(int i){
			return License_Plate[i];
		}
		public static int  getWeight_Limit(int i){
			return Weight_Limit[i];
		}
		public static int  getVehicle_Age(int i){
			return Vehicle_Age[i];
		}
		public static int  getVehicle_Displacement(int i){
			return Vehicle_Displacement[i];
		}
		public static String  getVehicle_Color(int i){
			return Vehicle_Color[i];
		}
		//--------------------------
		//----------乘客回傳值------------------------------
		public static int getP(){
			return P;
			}
		
		public static int getP_data_length(){
			return P_length;
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
		public static String getP_data_Id(int i){
			return P_data_Id[i];
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
