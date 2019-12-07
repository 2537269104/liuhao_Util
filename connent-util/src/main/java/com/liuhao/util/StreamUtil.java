package com.liuhao.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class StreamUtil {

	/**
	 * 
	 * 
	 * @Title: closeStream 
	 * @Description: 关流
	 * @param @param autoCloseables    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public static void closeStream(AutoCloseable...autoCloseables) {
		
		for (AutoCloseable autoCloseable : autoCloseables) {
			if(autoCloseable!=null) {
				try {
					autoCloseable.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	
	/**
	 * 
	 * @Title: readTextFile 
	 * @Description: 读取文件中的内容
	 * @param @param file
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@SuppressWarnings("resource")
	public static String  readTextFile(File file) {
		     InputStream input =null;
		     String str="";
		try {
			 input = new  FileInputStream(file);
			byte[] b = new byte[1024];
			while( input.read(b)!=-1) {
				
				str+=new String(b);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeStream(input);
		}
		
		return str;
		
	}	
	
	/**
	 * 
	 * @Title: readTextFileByLine 
	 * @Description: 按行读取文件内容
	 * @param @param file
	 * @param @return    设定文件 
	 * @return List<String>    返回类型 
	 * @throws
	 */
	
	
	public static List<String> readTextFileByLine(File file) {
		
		BufferedReader br =null;
		  List<String> list = new ArrayList<>();
		  try {
			   
			br = new BufferedReader(new FileReader(file));
			  String str="";
			  //此处你用fin.read方法已经读取一个字符了二循环体又用readline方法
			  //接着读显然会少一个字符因为你read方法读过一个字符游标就会移动一下
			while((str=br.readLine())!=null) {
				list.add(str);
				list.add("\r\n");
			}
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
            closeStream(br);
		}
		
		return list;
	}
	/**
	 * 
	 * @Title: copyStream 
	 * @Description: TODO复制流
	 * @param @param input
	 * @param @param out
	 * @param @param isCloseInputStream
	 * @param @param isCloseOutputStream    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	
	public static void copyStream(InputStream input,OutputStream out,boolean isCloseInputStream,boolean isCloseOutputStream) {
		
		
		
	}
	
	/**
	 * 
	 * @Title: writeFileContext 
	 * @Description: 
	 * @param @param path
	 * @param @param file    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	
      @SuppressWarnings("resource")
	   public static void  writeFileContext(String context,File file,boolean append) {
    	  
    	  BufferedWriter bw = null;
    	  
    	  try {
			
			 //判断所写的文件是否有父级路径
			 String parent = file.getParent();
			 File parentFile = new File(parent);
			 if(!parentFile.exists()) {
				 parentFile.mkdirs();
			 }
			 //写文件
			 bw = new BufferedWriter(new FileWriter(file,append));
			 bw.write(context);
			 bw.flush();
			 
			 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeStream(bw);
		}
      }
	
	 public static void downFileFromNet() {
		 
	 }
	
}
