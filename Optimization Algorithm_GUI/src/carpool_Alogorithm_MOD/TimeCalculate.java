package carpool_Alogorithm_MOD;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeCalculate {	
		public boolean time(String RRIVER_Time,String RIVAL_Time) throws ParseException{
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			if(RRIVER_Time==null || RIVAL_Time==null)
			{return false;}
				
			Date dt1 =sdf.parse(RRIVER_Time);
			Date dt2 =sdf.parse(RIVAL_Time);
			//取得兩個時間的Unix時間
			Long ut1=dt1.getTime();
			Long ut2=dt2.getTime();
			//相減獲得兩個時間差距的毫秒
			Long timeP=ut2-ut1;//毫秒差
			int min=(int) (timeP/(1000*60));   //相差分鐘，並轉為整數型態。
			//Long hr=timeP/(1000*60*60);    //相差小時
			//Long day=timeP/(1000*60*60*24);   //相差天數
			
			//System.out.println("相差"+timeP+"毫秒   "+min+"分鐘   "+hr+"小時   "+day+"天");
			if(min>=0){
			return true;}
			else{
			return false;}
		}
		
			public int reducetime(String RIVER_Time,String RRIVAL_Time) throws ParseException{
			
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			Date dt1 =sdf.parse(RIVER_Time);
			Date dt2 =sdf.parse(RRIVAL_Time);
			 
			//取得兩個時間的Unix時間
			Long ut1=dt1.getTime();
			Long ut2=dt2.getTime();
			//相減獲得兩個時間差距的毫秒
			Long timeP=ut2-ut1;//毫秒差
			int min=(int) (timeP/(1000*60));   //相差分鐘，並轉為整數型態。
			//Long hr=timeP/(1000*60*60);    //相差小時
			//Long day=timeP/(1000*60*60*24);   //相差天數
			
			//System.out.println("相差"+timeP+"毫秒   "+min+"分鐘   "+hr+"小時   "+day+"天");
			
			return min;
	
			}
			
			public String Addtime(String Driving_time,double d) throws ParseException {
				// TODO Auto-generated method stub
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date date =format.parse(Driving_time);
				
				/*DateFormat shortDate=DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);   
				DateFormat mediumDate =DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);   
				DateFormat longDate =DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);   
				DateFormat fullDate =DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL);   
				  
				System.out.println(shortDate.format(date));   
				System.out.println(mediumDate.format(date));   
				System.out.println(longDate.format(date));   
				System.out.println(fullDate.format(date));   
				*/  
				  
				Calendar c = Calendar.getInstance();   
			    c.setTime(date);  
				int a=(int) d;
				c.add(Calendar.MINUTE, a); // 目前時間加1分鐘
				//System.out.println(format.format(c.getTime()));   
				String GG=format.format(c.getTime());
			
			/*	c.add(Calendar.MONTH, 1); // 目前時間加1個月   
				System.out.println(sdf.format(c.getTime()));   
				  
				c.add(Calendar.HOUR, 3); // 目前時間加3小時   
				System.out.println(sdf.format(c.getTime()));   
				  
				c.add(Calendar.YEAR, -2); // 目前時間減2年   
				System.out.println(sdf.format(c.getTime()));   
				  
				c.add(Calendar.DAY_OF_WEEK, 7); // 目前的時間加7天   
				System.out.println(sdf.format(c.getTime()));   
			*/
				return GG;
			}
			
			public String Reducetime(String Driving_time,double d) throws ParseException {
				// TODO Auto-generated method stub
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date date =format.parse(Driving_time);
				
				/*DateFormat shortDate=DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);   
				DateFormat mediumDate =DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);   
				DateFormat longDate =DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);   
				DateFormat fullDate =DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL);   
				  
				System.out.println(shortDate.format(date));   
				System.out.println(mediumDate.format(date));   
				System.out.println(longDate.format(date));   
				System.out.println(fullDate.format(date));   
				*/  
				  
				Calendar c = Calendar.getInstance();   
			    c.setTime(date);  
				int a=(int) d;
				c.add(Calendar.MINUTE, -a); // 目前時間減1分鐘   
				//System.out.println(format.format(c.getTime()));   
				String GG=format.format(c.getTime());
			
			/*	c.add(Calendar.MONTH, 1); // 目前時間加1個月   
				System.out.println(sdf.format(c.getTime()));   
				  
				c.add(Calendar.HOUR, 3); // 目前時間加3小時   
				System.out.println(sdf.format(c.getTime()));   
				  
				c.add(Calendar.YEAR, -2); // 目前時間減2年   
				System.out.println(sdf.format(c.getTime()));   
				  
				c.add(Calendar.DAY_OF_WEEK, 7); // 目前的時間加7天   
				System.out.println(sdf.format(c.getTime()));   
			*/
				
				return GG;
			}
			
}
