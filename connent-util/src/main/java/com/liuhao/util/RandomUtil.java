package com.liuhao.util;

import java.util.Random;

/**
 * 
 * @author 刘浩
 * @Title: RandomUtil.java 
 * @Package com.liuhao.util 
 * @Description: 随机数字字母等等操作
 * @date 2019年12月6日 下午7:32:55
 */
public class RandomUtil {
    /**
     * 
     * @Title: random 
     * @Description: 根据传入的最大最小值，获取随机数
     * @param @param min
     * @param @param max
     * @param @return    设定文件 
     * @return int    返回类型 
     * @throws
     */
    
	public static int random(int min,int max) {
		
		Random random = new Random();
		int num =min+random.nextInt(max-min+1);
		//int num = min+(int)(Math.random()*(max-min+1));
		return num;
	}
	
	/**
	 * 
	 * @Title: random 
	 * @Description: 给定一个最大值，一个最小值，一个随机数的数量
	 * @param @param min
	 * @param @param max
	 * @param @param count
	 * @param @return    设定文件 
	 * @return int[]    返回类型 
	 * @throws
	 * 
	 */
public static int[] random(int min,int max,int count) {
		
	       int [] a =new int[count];
	      for(int i=0;i<count;i++){
	    	  
	    	  int j = random(min, max);
	    	  a[i] =j;
	    	  
	      }	
	
		return a;
	}
	
	
	
}
