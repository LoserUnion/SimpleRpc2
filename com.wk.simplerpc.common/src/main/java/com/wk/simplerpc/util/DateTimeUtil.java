package com.wk.simplerpc.util;


import org.springframework.util.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * 包名称： com.bj58.fbf.common.utils <br/>
 * 创建人：@author  <br/>
 * 创建时间：2014-7-7/18:08:04    <br/>
 * 类描述：   日期工具类<br/>
 *
 * @version V1.0     <br/>
 */
public class DateTimeUtil {

	public static String YYYY_MM_DD_HH_MI_SS = "yyyy-MM-dd HH:mm:ss";
	public static String YYYY_MM_DD = "yyyy-MM-dd";
	public static String FORMAT_NO_SECONDES = "yyyy/MM/dd HH:mm";
	public static String YYYYMMDD="yyyyMMdd";
	public static String FORMAT_DEFAULT_MIN = "yyyyMMddHHmmss";
	public static String FORMAT_DEFAULT = "yyyy-MM-dd HH:mm:ss";
	public static String FORMAT_DEFAULT_CH = "yyyy年MM月dd日 HH时mm分ss秒";
	public static String FORMAT_DEFAULT_CH_YMD = "yyyy年MM月dd日";
	public static String FORMAT_DEFAULT_YMD = "yyyy-MM-dd";
	public static String FORMAT_DEFAULT_YMDHM ="yyyy-MM-dd HH:mm";
	public static String FORMAT_DEFAULT_ME = "yyyy-MM";
	public static String FORMAT_DEFAULT_M = "yyyy年MM月";

	/**
	 * 取得当前日期对象
	 *
	 * @return the date
	 */
	public static Date current() {
		return new Date();
	}


	/**
	 * 取得当前日期，并封装为整形的数组
	 *
	 * @param date the date
	 * @return the ymdhms
	 */
	public static Integer[] getYMDHMS(Date date) {
		Calendar cal = getCalendar(date);
		return new Integer[] { cal.get(Calendar.YEAR),
				cal.get(Calendar.MONTH) + 1, cal.get(Calendar.DAY_OF_MONTH),
				cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE),
				cal.get(Calendar.SECOND) };
	}
	public static Date strToDateOfYmdFormat(String dateStr) {
		return strToDate(dateStr, FORMAT_DEFAULT_YMD);
	}

	/**
	 * 
	 *计算指定日期是当月的第几周
	 * @param date the date
	 * @return the week of month
	 */
	public static Integer getWeekOfMonth(Date date) {
		Calendar cal = getCalendar(date);

		return cal.get(Calendar.WEEK_OF_MONTH);
	}

	/**
	 * 取本周周一的日期(周一为一周第一天)
	 * 
	 * @param date
	 * @return
	 */
	public static Date thisWeekMonday(Date date) {
		Calendar cal = getCalendar(date);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		return cal.getTime();
	}

	/**
	 * 返回星期数（周日返回7）
	 * 
	 * @param date
	 * @return
	 */
	public static Integer getDayOfWeek(Date date) {
		Calendar cal = getCalendar(date);
		int re = cal.get(Calendar.DAY_OF_WEEK);
		if (re == 0) {
			return 7;
		} else {
			return re - 1;
		}
	}

	/**
	 * 在日期上添加秒的日期
	 *
	 * @param date the date
	 * @param num the num
	 * @return the date
	 */
	public static Date addSecond(Date date, int num) {
		return add(date, Calendar.SECOND, num);
	}

	/**
	 * 在日期上添加分钟的日期
	 *
	 * @param date the date
	 * @param num the num
	 * @return the date
	 */
	public static Date addMinute(Date date, int num) {
		return add(date, Calendar.MINUTE, num);
	}

	/**
	 * 在日期上添加小时的日期。
	 *
	 * @param date the date
	 * @param num the num
	 * @return the date
	 */
	public static Date addHour(Date date, int num) {
		return add(date, Calendar.HOUR_OF_DAY, num);
	}

	/**
	 * 在日期上添加天的日期.
	 *
	 * @param date the date
	 * @param num the num
	 * @return the date
	 */
	public static Date addDay(Date date, int num) {
		return add(date, Calendar.DAY_OF_MONTH, num);
	}

	public static Date add(Date date, int field, int num) {
		Calendar cal = getCalendar(date);
		cal.add(field, num);
		return cal.getTime();
	}
	public static Date addDate(Date date, int day) {
		return add(date,Calendar.DATE,day);
	}
	
	/**
	 *  在日期上添加月的日期。
	 *
	 * @param date the date
	 * @param month the month
	 * @return the date
	 */
	public static Date addMonth(Date date,int month) {
		return add(date,Calendar.MONTH,month);
	}
	
	/**
	 * 取得当前月的第一天此时的日期..
	 *
	 * @param date the date
	 * @return the date
	 */
	public static Date firstOfMonth(Date date) {
		return first(date, Calendar.DAY_OF_MONTH);
	}

	/**
	 * 取得当前月的最后一天此时的日期.
	 *
	 * @param date the date
	 * @return the date
	 */
	public static Date lastOfMonth(Date date) {
		return last(date, Calendar.DAY_OF_MONTH);
	}

	/**
	 * 取得当前天第一小时的此时时间.
	 *
	 * @param date the date
	 * @return the date
	 */
	public static Date firstOfHour(Date date) {
		return first(date, Calendar.HOUR_OF_DAY);
	}

	/**
	 * 取得当前天最后小时的此时时间.
	 *
	 * @param date the date
	 * @return the date
	 */
	public static Date lastOfHour(Date date) {
		return last(date, Calendar.HOUR_OF_DAY);
	}

	/**
	 * 取得指定日期，在指定时间段中最早的时间。
	 *
	 * @param date the date
	 * @param d the d
	 * @return the date
	 */
	public static Date first(Date date, int d) {
		if (null == date)
			return date;
		Calendar cal = getCalendar(date);
		cal.set(d, cal.getMinimum(d));
		return cal.getTime();
	}

	/**
	 * 取得指定日期，在指定时间段中最后的时间.
	 *
	 * @param date the date
	 * @param d the d
	 * @return the date
	 */
	public static Date last(Date date, int d) {
		if (null == date)
			return date;
		Calendar cal = getCalendar(date);
		cal.set(d, cal.getMaximum(d));
		return cal.getTime();
	}

	/**
	 * 设置周一为当前周的第一天
	 *
	 * @param date the date
	 * @return the calendar
	 */
	public static Calendar getCalendar(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setFirstDayOfWeek(Calendar.MONDAY);
		cal.setTime(date);
		return cal;
	}

	/**
	 * 把日期转换为yyyy-MM-dd格式的日期字符.
	 *
	 * @param date the date
	 * @return the string
	 */
	public static String dateFormatShort(Date date) {
		return dateFormat(date, YYYY_MM_DD);
	}

	/**
	 *把日期转换为 yyyy-MM-dd HH:mm:ss格式的日期字符.
	 *
	 * @param date the date
	 * @return the string
	 */
	public static String dateFormatLong(Date date) {
		return dateFormat(date, YYYY_MM_DD_HH_MI_SS);
	}
	
	/**
	 * 把yyyy-MM-dd HH:mm:ss格式的日期字符，转换为 yyyy/MM/dd HH:mm格式的日期字符
	 *
	 * @param dateStr the date str
	 * @return the string
	 */
	public static String toStrOfNosecondsFormat(String dateStr) {
		Date date = formatLongDate(dateStr);
		return dateFormat(date, FORMAT_NO_SECONDES);
	}

	/**
	 * 日期转换为制定的字符串格式
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public static String dateFormat(Date date, String format) {
		if (null == date)
			return "";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}

	/**
	 * 按照yyyy-MM-dd格式转换日期
	 *
	 * @param dateStr the date str
	 * @return the date
	 */
	public static Date formatShortDate(String dateStr) {
		return formatDate(dateStr, YYYY_MM_DD);
	}

	/**
	 *按照yyyy-MM-dd HH:mm:ss格式转换日期
	 *
	 * @param dateStr the date str
	 * @return the date
	 */
	public static Date formatLongDate(String dateStr) {
		return formatDate(dateStr, YYYY_MM_DD_HH_MI_SS);
	}

	/**
	 * 字符串转换为日期类型
	 * 
	 * @param dateStr
	 * @param format
	 * @return
	 */
	public static Date formatDate(String dateStr, String format) {
		if (null == dateStr || StringUtils.isEmpty(dateStr))
			return null;
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			return sdf.parse(dateStr);
		} catch (ParseException e) {
			// e.printStackTrace();
		}
		return null;
	}

	/**
	 * 计算两日期间相差天数.
	 * 
	 * 
	 * @param d1
	 *            开始日期 日期型
	 * @param d2
	 *            结束日期 日期型
	 * @return long 天数
	 */
	public static long signDaysBetweenTowDate(Date d1, Date d2) {
		return (d2.getTime() - d1.getTime()) / (3600 * 24 * 1000);
	}

	/**
	 * 获取2个日期("yyyy-MM-dd")之间的所有日期
	 * 
	 * @param d1
	 * @param d2
	 * @return GregorianCalendar[]
	 * @throws ParseException
	 */
	public static Calendar[] getBetweenDate(String d1, String d2) {
		List<GregorianCalendar> v = new ArrayList<GregorianCalendar>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar gc1 = new GregorianCalendar(), gc2 = new GregorianCalendar();
		try {
			gc1.setTime(sdf.parse(d1));
			gc2.setTime(sdf.parse(d2));
			do {
				GregorianCalendar gc3 = (GregorianCalendar) gc1.clone();
				v.add(gc3);
				gc1.add(Calendar.DAY_OF_MONTH, 1);
			} while (!gc1.after(gc2));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return v.toArray(new GregorianCalendar[v.size()]);
	}

	/**
	 * 获取2个日期("yyyy-MM-dd")之间的所有日期
	 *
	 * @param d1
	 * @param d2
	 * @return GregorianCalendar[]
	 * @throws ParseException
	 */
	public static Calendar[] getBetweenDate(Date d1, Date d2) {
		List<GregorianCalendar> v = new ArrayList<GregorianCalendar>();
		Calendar gc1 = new GregorianCalendar(), gc2 = new GregorianCalendar();
		gc1.setTime(d1);
		gc2.setTime(d2);
		do {
			GregorianCalendar gc3 = (GregorianCalendar) gc1.clone();
			v.add(gc3);
			gc1.add(Calendar.DAY_OF_MONTH, 1);
		} while (!gc1.after(gc2));

		return v.toArray(new GregorianCalendar[v.size()]);
	}
	
	/**
	 * 返回45天前时间
	 * @param date
	 * @return 
	 */
	public static Date getOneMonthBefore(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, -45);
		return cal.getTime();
		
	}
	
	/**
	 * 返回1天后时间
	 * @param date
	 * @return 
	 */
	public static Date getOneDayLater(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, +1);
		return cal.getTime();
		
	}

	public static Date getSixHoursLater(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.HOUR, +6);
		return cal.getTime();

	}
	
	/**
	 * 当前天的起始时间
	 */
	public static Date getDayStart() {
		Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        
        return calendar.getTime();
	}

	/**
	 * 当前天的结束时间
	 */
	public static Date getDayEnd() {
		Calendar calendar = Calendar.getInstance();
        calendar.setTime(DateTimeUtil.addDay(new Date(), 1));
        
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        
        return calendar.getTime();
	}

	/**
	 * 当前月的开始时间
	 */
	public static Date getMonthStart() {
		Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        
        return calendar.getTime();
	}

	/**
	 * 当前月的结束时间
	 */
	public static Date getMonthEnd() {
		Calendar calendar = Calendar.getInstance();
        calendar.setTime(DateTimeUtil.addMonth(new Date(), 1));
        
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        
        return calendar.getTime();
	}
	
	public static String dateToStrOfDefaulfFormat(Date date) {
		return dateToStr(date, YYYY_MM_DD_HH_MI_SS);
	}

	/**
	 * 日期转换为制定的字符串格式
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public static String dateToStr(Date date, String format) {
		if (null == date) {
			return "";
		}

		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}

	public static Date strToDateOfDefaulfFormat(String dateStr) {
		return strToDate(dateStr, YYYY_MM_DD_HH_MI_SS);
	}

	/**
	 * 字符串转换为日期类型
	 * 
	 * @param dateStr
	 * @param format
	 * @return
	 */
	public static Date strToDate(String dateStr, String format) {
		if (null == dateStr || StringUtils.isEmpty(dateStr)) {
			return null;
		}

		SimpleDateFormat sdf = new SimpleDateFormat(format);

		try {
			return sdf.parse(dateStr);
		} catch (ParseException e) {
			// e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * 格式化
	 * @return
	 */
	public static Date format(String date,String ... formats){
		for(String f : formats){
			Date d = strToDate(date,f);
			if(d == null){
				continue;
			}else {
				return d;
			}
		}
		return null;
	}
	
	/**
	 * 处理用户端、客服端时间格式问题
	 * @param date
	 * @return
	 */
	public static Date format(String date){
		return format(date,new String[]{
				FORMAT_DEFAULT,
				FORMAT_DEFAULT_YMDHM,
				FORMAT_DEFAULT_YMD,
				FORMAT_DEFAULT_ME,
				FORMAT_DEFAULT_M
		});
	}
	
	/**
	 * 处理用户端 客服端时间字段问题
	 * @param date
	 * @return
	 */
	public static String parseDate(String date,String msg){
		Date d = format(date);
		if(d == null){
			throw new RuntimeException(msg);
		}
		return dateToStrOfDefaulfFormat(d);
	}
	/**
	 * 获取指定时间对应的毫秒数
	 * @param time "HH:mm:ss"
	 * @return
	 */
	public static long getTimeMillis(String time) {
		try {
			DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
			DateFormat dayFormat = new SimpleDateFormat("yy-MM-dd");
			Date curDate = dateFormat.parse(dayFormat.format(new Date()) + " " + time);
			return curDate.getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * 获取到指定时刻的时间差
	 * @param moment hh:mm:ss eg: 00:00:00
	 * @return （秒）
	 */
	public static int getTimeDiff(String moment){
		long oneday = 24*60*60*1000;
		long initDalay = getTimeMillis(moment) - System.currentTimeMillis();
		initDalay = initDalay > 0 ? initDalay : oneday + initDalay;
		int delay = (int)(initDalay /1000);
		return delay;
	}


}
