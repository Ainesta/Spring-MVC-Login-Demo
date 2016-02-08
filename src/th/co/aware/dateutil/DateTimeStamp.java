package th.co.aware.dateutil;

import java.sql.Timestamp;
import java.util.Calendar;

public class DateTimeStamp{
	
	public static Timestamp getTs(){
		
		long timeNow = Calendar.getInstance().getTimeInMillis();
		Timestamp ts = new Timestamp(timeNow);
		
		return ts;
	}

}
