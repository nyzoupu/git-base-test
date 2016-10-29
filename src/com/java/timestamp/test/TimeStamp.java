package com.java.timestamp.test;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


/** 
 * ClassName: TimeStamp <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * 
 * @author Paulsen·Zou 
 * @version  
 * @Date:2016年5月12日下午10:08:16 
 * @version V1.0
 */
public class TimeStamp {

	/**
	 * 
	 */
	public TimeStamp() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * main(这里用一句话描述这个方法的作用)</p>
	 *
	 * @param args    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Date().getTime());
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String str = sdf.format(date);
		System.out.println(str);
		
		System.out.println(System.currentTimeMillis());
		
		String dateOutString = DateFormat.getDateTimeInstance().format(date);
		System.out.println(dateOutString);
		
		DateFormat df4 = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss EE", Locale.CHINA); 
		System.out.println(df4.format(date));
	}

	public String showMsg() {
		return "fa";
	}
}
