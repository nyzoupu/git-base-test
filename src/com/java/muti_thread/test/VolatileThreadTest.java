package com.java.muti_thread.test;

/** 
 * @author Paulsen��Zou 
 * @Date:2016��8��26������11:01:14 
 * @version V1.0
 */
public class VolatileThreadTest {

	public static boolean num= true;
	/**
	 * @throws InterruptedException 
	 * main(������һ�仰�����������������)</p>
	 *
	 * @param args    �趨�ļ�
	 * @return void    ��������
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
