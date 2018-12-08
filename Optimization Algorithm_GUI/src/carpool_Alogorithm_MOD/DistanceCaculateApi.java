package carpool_Alogorithm_MOD;

import com.google.maps.DistanceMatrixApi;
import com.google.maps.GeoApiContext;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.LatLng;




public class DistanceCaculateApi {
	


	public static double GetDistanceApi(GeoApiContext context,String[] origins,String[] destinations) throws Exception

	{DistanceMatrix matrix = DistanceMatrixApi.getDistanceMatrix(context, origins, destinations).await();
		
		long c;
		c=matrix.rows[0].elements[0].distance.inMeters;
		//System.out.println(matrix.rows[0].elements[0].duration.humanReadable);
	return c;
	}
	
	public static double GetdurationApi(GeoApiContext context,String[] origins,String[] destinations) throws Exception
	{
	
		DistanceMatrix matrix = DistanceMatrixApi.getDistanceMatrix(context, origins, destinations).await();
		
		long b;
		int c;
		b=matrix.rows[0].elements[0].duration.inSeconds;
		c=(int) b/60;
		//System.out.println(matrix.rows[0].elements[0].duration.humanReadable);
		
	return c;
	}


	public int GetDistance(String string, String string2) throws Exception {
		
		 String[] origins = new String[] {
				 string
			    };
		String[] destinations = new String[] {
			    		string2
			    };
		GeoApiContext context = new GeoApiContext().setApiKey("AIzaSyC-BxwQ26hELsn7lKS2QUGBxDfNIwD4BGw");
			//呼叫API 回傳距離
			   long a= (long) GetDistanceApi(context,origins,destinations);
		return (int) a;
	}
	
	
	public int Getduration(String string, String string2) throws Exception {
		
		 String[] origins = new String[] {
				 string
			    };
		String[] destinations = new String[] {
			    		string2
			    };
		GeoApiContext context = new GeoApiContext().setApiKey("AIzaSyC-BxwQ26hELsn7lKS2QUGBxDfNIwD4BGw");	    
			//呼叫API 回傳時間
			   long a= (long) GetdurationApi(context,origins,destinations);
		return (int) a;
		
		
	}
	
	

	
	//--------------------------以下為使用-----------------------------------------------------
	
	//---------------------以下為使用經緯度----------------------------------------------------------
	
	public double newRequest(double lat1, double lng1, double lat2, double lng2,String key)
			throws Exception {

		GeoApiContext context = new GeoApiContext().setApiKey(key);
	
		DistanceMatrix matrix = DistanceMatrixApi.newRequest(context)
				.origins(new LatLng(lat1, lng1))
				.destinations(new LatLng(lat2, lng2)).awaitIgnoreError();
		// 回傳距離
		double a = matrix.rows[0].elements[0].distance.inMeters;
		return a;

	}

	public double newRequesttime(double lat1, double lng1, double lat2,
			double lng2) throws Exception {

		GeoApiContext context = new GeoApiContext()
				.setApiKey("AIzaSyCUF2jgIdM8_xJCZh3UCHJV5St0ATLyGi8");

		DistanceMatrix matrix = DistanceMatrixApi.newRequest(context)
				.origins(new LatLng(lat1, lng1))
				.destinations(new LatLng(lat2, lng2)).awaitIgnoreError();
		// 回傳行駛時間
		double a = matrix.rows[0].elements[0].duration.inSeconds;
		int c = (int) a / 60;

		return c;

	}

	public double newRequestcost(double lat1, double lng1, double lat2,
			double lng2, double Vehicle_Displacement) throws Exception {

		GeoApiContext context = new GeoApiContext()
				.setApiKey("AIzaSyCUF2jgIdM8_xJCZh3UCHJV5St0ATLyGi8");

		DistanceMatrix matrix = DistanceMatrixApi.newRequest(context)
				.origins(new LatLng(lat1, lng1))
				.destinations(new LatLng(lat2, lng2)).awaitIgnoreError();
		// 計算載客成本-------------------------------
		double a = matrix.rows[0].elements[0].distance.inMeters;
		a = (a / 1000) * (Vehicle_Displacement / 1000);
		return a;

	}
}
