package com.java.muti_thread.test;

/** 
 * @author Paulsen·Zou 
 * @Date:2016年8月26日下午11:01:14 
 * @version V1.0
 */
public class VolatileThreadTest {

	public static boolean num= true;
	/**
	 * @throws InterruptedException 
	 * main(这里用一句话描述这个方法的作用)</p>
	 *
	 * @param args    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public static void main(String[] args) throws InterruptedException {
		new Thread(new SubThread()).start();
		Thread.currentThread().sleep(2000L);
		num=false;
	}

}
class SubThread implements Runnable{

	/**
	 * <p>Title: run</p>
	 * <p>Description: </p>
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		while (VolatileThreadTest.num) {
		
		};
	}
	
} 
