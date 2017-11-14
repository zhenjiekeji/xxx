package com.uk.sec.framework.util;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/*
 * author xzw
 * function: 字符串与日期类型之间相互转化
 */
public class StringOrDate {
	public static String dateToString(Date date, String type) {
		String str = null;
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		if (type.equals("SHORT")) {
			// 07-1-18
			format = DateFormat.getDateInstance(DateFormat.SHORT);
			str = format.format(date);
		} else if (type.equals("MEDIUM")) {
			// 2007-1-18
			format = DateFormat.getDateInstance(DateFormat.MEDIUM);
			str = format.format(date);
		} else if (type.equals("FULL")) {
			// 2007年1月18日 星期四
			format = DateFormat.getDateInstance(DateFormat.FULL);
			str = format.format(date);
		}
		return str;
	}
	public static Date stringToDate(String str) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		if(str == null || str.equals(""))
			return null;
		try {
			// Fri Feb 24 00:00:00 CST 2012
			date = format.parse(str); 
		} catch (ParseException e) {
			e.printStackTrace();
		}
		// 2012-02-24
		date = java.sql.Date.valueOf(str);
											
		return date;
	}
//	public static void main(String[] args) {
//		Date date = new Date();
//		System.out.println(StringOrDate.dateToString(date, "MEDIUM"));
//		String str = "2012-2-24";
//		System.out.println(StringOrDate.stringToDate(str));
//	}
}
