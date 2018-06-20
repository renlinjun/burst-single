package burst.core.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	 public static String dateFormat(Date date, String pattern) throws ParseException{
         SimpleDateFormat sdf = new SimpleDateFormat(pattern);
         return sdf.format(date);
      }
	 
	 public static String dateFormat(String pattern) throws ParseException{
         SimpleDateFormat sdf = new SimpleDateFormat(pattern);
         return sdf.format(new Date());
      }
}
