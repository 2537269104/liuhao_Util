package com.liuhao.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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

	/**
	 * 
	 * @Title: getAge 
	 * @Description: 根据 日期算年龄
	 * @param  birthdayDate
	 * @param    设定文件 
	 * @return int    返回类型 
	 * @throws
	 */
	public static int getAge(Date birthdayDate) {
		
		Date date = new Date();
		 
		int i=getDateOfStartAndEnd(date,birthdayDate);
		 
		return i;
	}
      /**
       * 
       * @Title: getDateOfStartAndEnd 
       * @Description: 根据两个时间段算出时间段之间的天数
       * @param @param date
       * @param @param birthdayDate
       * @param @return    设定文件 
       * @return int    返回类型 
       * @throws
       */
	public static int getDateOfStartAndEnd(Date date1, Date date2) {
	
		long time1 = date1.getTime();
		long time2 = date2.getTime();
		long dayTime = 1000*60*60*24L;
		
		double ceil = Math.ceil(Math.abs((time1-time2)/(dayTime*1.0)));
	
		
		return (int)(ceil);
	}
	 
	
	public static void main(String[] args) {
		
		try {
			System.out.println(getDateOfStartAndEnd(new Date(), sdf.parse("2019-12-05")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
