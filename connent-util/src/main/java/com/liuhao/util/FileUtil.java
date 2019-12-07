package com.liuhao.util;

import java.io.File;
import java.text.DecimalFormat;

public class FileUtil {
       /**
        * 
        * @Title: getExtName 
        * @Description: 获取文件名的拓展名 
        * @param @param fileName
        * @param @return    设定文件 
        * @return String    返回类型 
        * @throws
        */
	public static String getExtName(String fileName) {
		
		String extName = fileName.substring(fileName.lastIndexOf("."));
		
		return extName;
	}
	/**
	 * 
	 * @Title: deleteFile 
	 * @Description: 递归删除文件
	 * @param @param file    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public static void deleteFile(File file) {
		//isDirectory() 判断该文件是否是文件夹
		if(file.isDirectory()) {
			File[] listFiles = file.listFiles();
			for (File file2 : listFiles) {
				deleteFile(file2);
			}   
			file.delete();
		}
		else {
			file.delete();
		}
		
		
	}
	/**
	 * 
	 * @Title: deleteFile 
	 * @Description: 删除文件
	 * @param @param filePath    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public static void deleteFile(String filePath) {
		
		deleteFile(new File(filePath));
	} 
	
	
	/**
	 * 
	 * @Title: getSystemUserHome 
	 * @Description: 获取操作系统用户目录 
	 * @param @param args    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	public static String getSystemUserHome() {
		
		return System.getProperty("user.home");
	}
	
	
	/**
	 * 
	 * @Title: getFileSizeOfB 
	 * @Description: 文件的指定大小 KB结尾
	 * @param @param file
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 * 
	 */
	public static String  getFileSize(File file) {
		
		long size = file.length();
		
		float i = (float) (size/1024.0f);
		/*
		 * String s = String.format("%.2f", i);
		 * System.out.println("============"+s);
		 */
		DecimalFormat df = new DecimalFormat("#.00");
		return df.format(i)+"kb";
	}
	
}
