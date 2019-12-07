package com.liuhao.util;

import java.util.Random;
import java.util.regex.Pattern;
/**
 * 
 * @author 刘浩
 * @Title: SpringUtil.java 
 * @Package com.liuhao.util 
 * @Description: TODO(字符串工具类，用于判断字符串是否为空以及该字符串是否为手机号)    
 * @date 2019年12月5日 下午1:48:28
 */
public class SpringUtil {

	
	public static boolean isBlank(String str) {
		//字符串为null或字符串为空串 
		//str.trim()用于去除字符串前后的空格 排除 空格字符串的可能
		if(null == str || "".equals(str.trim())) {
			return true;
		}
		
		return false;
	}
	//判断该字符串是否为手机号
	public static boolean isPhoneNum(String str) {
		
		String partten = "1[3|5|7|9]\\d{9}";
		
		  boolean b = Pattern.matches(partten, str);
		
		
		return b;
	}
	
	//判断该字符串是否是电子邮箱
	public static boolean isEmailAddress(String str) {

		String partten = "[\\w]+@[\\w]+\\.com(.cn)*";

		boolean b = Pattern.matches(partten, str);

		return b;
	}
	//判断字符串是否全部为字母
	public static boolean isEnglishLetter(String str) {
		
		String partten = "^[a-z|A-Z]+$";
          
		boolean b = Pattern.matches(partten, str);

		return b;
		
	}
	
	//获取n位随机英文字符串
	public static String getRandomsEnglishString(int n){
		
		String str ="";
		StringBuilder stringBuilder = new StringBuilder();
		Random random = new Random();
		for(int i=1;i<=n;i++) {
			int t='A'+random.nextInt(26);
		    stringBuilder.append((char)t);
		}
		
		return stringBuilder.toString();
	}
	/**
	 * 
	 * @Title: getCharOfLetter 
	 * @Description: 获取一个随机的英文字母 
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	public static char getCharOfLetter() {
		
		Random random = new Random();

		int t = 'a'+random.nextInt(26);
		
		char c = (char)(t);
		return c;
		
	}
	/**
	 * 
	 * @Title: getCharOfLetter 
	 * @Description: 获取一个随机的数字
	 * @param @return    设定文件 
	 * @return char    返回类型 
	 * @throws
	 */
      public static int getCharOfNumber() {
		
		Random random = new Random();

		 
		return random.nextInt(10);
		
	}
	
	
	//获取n位随机英文和数字字符串
	public static String getStrOfLetterAndNumber(int n) {
		
		Random random = new Random();
		StringBuffer stringBuffer = new StringBuffer();
		for (int i = 0; i < n; i++) {
			if(random.nextInt(36)<10) {
				stringBuffer.append(getCharOfNumber());
			}
			else {
				stringBuffer.append(getCharOfLetter());
			}
		}
		
		
		return  stringBuffer.toString();
	}
	/**
	 * 
	 * @Title: main 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param args    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	
}
