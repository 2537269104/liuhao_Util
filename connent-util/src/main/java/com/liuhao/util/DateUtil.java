package com.liuhao.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * 
 * @author 刘浩
 * @Title: DateUtil.java
 * @Package com.liuhao.util
 * @Description: TODO关于日期的工具类
 * @date 2019年12月5日 下午6:50:12
 */
public class DateUtil {

	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private static SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	/**
	 * 
	 * @Title: getAge @Description: 根据 日期算年龄 @param birthdayDate @param 设定文件 @return
	 * int 返回类型 @throws
	 */
	public static int getAge(Date birthdayDate) {

		// 获得日历控件
		Calendar calendar = Calendar.getInstance();
		// 获得年、月、日
		int currentYear = calendar.get(Calendar.YEAR);
		int currentMonth = calendar.get(Calendar.MONTH);
		int currentDay = calendar.get(Calendar.DAY_OF_MONTH);
		// 获取生日的
		calendar.setTime(birthdayDate);
		Date date = new Date();
		int birthYear = calendar.get(Calendar.YEAR);
		int birthMonth = calendar.get(Calendar.MONTH);
		int birthDay = calendar.get(Calendar.DAY_OF_MONTH);
		int age = currentYear - birthYear;
		// 如果生日的月份大于当前月份则减一
		if (birthMonth > currentMonth) {
			age--;
		}
		// 月份相同 则 生日日期大于当前日期 减一
		if (birthMonth == currentMonth && birthDay > currentDay) {
			age--;
		}

		return age;
	}

	/**
	 * 
	 * @Title: getDateOfStartAndEnd @Description: 根据两个时间段算出时间段之间的天数 @param @param
	 * date @param @param birthdayDate @param @return 设定文件 @return int 返回类型 @throws
	 */
	public static int getDayOfStartAndEnd(Date date1, Date date2) {

		long time1 = date1.getTime();
		long time2 = date2.getTime();
		long dayTime = 1000 * 60 * 60 * 24L;

		double ceil = Math.ceil(Math.abs((time1 - time2) / (dayTime * 1.0)));

		return (int) (ceil);
	}

	/**
	 * 
	 * @Title: getDayOfFutureToNow @Description: 现在距离未来某个时间的天数 @param @return
	 * 设定文件 @return int 返回类型 @throws
	 */
	public static int getDayOfFutureToNow(Date futureDate) {

		Date date = new Date();

		return getDayOfStartAndEnd(date, futureDate);
	}

	/**
	 * 
	 * @Title: getDayOfPastToNow @Description: 现在距离过去某个时间的天数 @param @return
	 * 设定文件 @return int 返回类型 @throws
	 */
	public static int getDayOfPastToNow(Date pastDate) {

		Date date = new Date();

		return getDayOfStartAndEnd(date, pastDate);
	}

	/**
	 * 
	 * @Title: isTodayOfDate @Description: 判断给定的日期是否为今天 @param @param
	 * date @param @return 设定文件 @return boolean 返回类型 @throws
	 */
	public static boolean isTodayOfDate(Date date1) {

		Date date2 = new Date();

		String dateStr1 = date1.toString();
		String dateStr2 = date2.toString();

		System.out.println(dateStr1 + "---------------" + dateStr2);

		if (dateStr1.equals(dateStr2)) {
			return true;
		}

		return false;
	}

	/**
	 * 
	 * @Title: isThisWeekOfDate @Description: 判断给定的时间是否在本周之中 @param @param
	 * date1 @param @return 设定文件 @return boolean 返回类型 @throws
	 */
	public static boolean isThisWeekOfDate(Date date1) {
		
		// 获取日历
		Calendar firstDayOfWeek = Calendar.getInstance(Locale.getDefault());
		
		// 给日历 setFirstDayOfWeek() 设置一星期的第一天是那一天
		firstDayOfWeek.setFirstDayOfWeek(Calendar.MONDAY);
		
		// Calendar.DAY_OF_WEEK 指一个星期的第几天 从星期日开始算    get()返回给定日历字段的值
		int day = firstDayOfWeek.get(Calendar.DAY_OF_WEEK);
		
		// Calendar.DATE 当前是星期几 add(a,b) a的日历时间-b的天数
		firstDayOfWeek.add(Calendar.DATE, -day+1+1);// 后面的+1是因为从周日开始
		//System.out.println("当前是星期" + Calendar.DATE);
		
		//System.out.println(firstDayOfWeek.getFirstDayOfWeek() + "============" + day);
		// 本周的周一
	//	System.out.println(sdf2.format(firstDayOfWeek.getTime()));

		// 获取日历
		Calendar lastDayOfWeek = Calendar.getInstance(Locale.getDefault());
		// 给日历
		lastDayOfWeek.setFirstDayOfWeek(Calendar.MONDAY);

		int day2 = lastDayOfWeek.get(Calendar.DAY_OF_WEEK);

		lastDayOfWeek.add(Calendar.DATE, 7 - day2 + 1);// 后面的+1是因为从周日开始

		//System.out.println(lastDayOfWeek.getFirstDayOfWeek() + "============" + day2);
		// 本周的周一
		//System.out.println(sdf2.format(lastDayOfWeek.getTime()));
      
		
		boolean a =date1.getTime()<lastDayOfWeek.getTime().getTime();
		/*
		 * System.out.println("本周最后一天的毫秒值："+lastDayOfWeek.getTime().getTime());
		 * System.out.println("本周第一天的毫秒值："+firstDayOfWeek.getTime().getTime());
		 * System.out.println("给定时间的毫秒值："+date1.getTime());
		 */
        boolean b =(date1.getTime()>firstDayOfWeek.getTime().getTime());

		return a&&b;
		}

	public static void main(String[] args) throws ParseException {

		/*
		 * try {
		 * 
		 * System.out.println(getDateOfStartAndEnd(new Date(),
		 * sdf.parse("2019-12-05")));
		 * 
		 * } catch (ParseException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
		System.out.println(isThisWeekOfDate(sdf2.parse("2019-12-02 13:18:00")));
	}
}
