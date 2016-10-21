package com.java.muti_thread.test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/** 
 * ClassName: ThreadQuene <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * 
 * @author Paulsen·Zou 
 * @version  
 * @Date:2016年5月29日下午6:41:03 
 * @version V1.0
 */
public class ThreadQueneTest {

	/**
	 * 
	 */
	public ThreadQueneTest() {
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
		
	         BlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>();  
	         ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 6, 1, TimeUnit.DAYS, queue);  
	         for (int i = 0; i < 100; i++) {     
	             executor.execute(new Thread(new ThreadPoolTest(), "TestThread".concat(""+i)));     
	             int threadSize = queue.size();  
	             System.out.println("线程队列大小为-->"+threadSize);  
	         }     
	         executor.shutdown();    
	         
	         
	}

}


class ThreadPoolTest implements Runnable
{
  
  /**
 * <p>Title: run</p>
 * <p>Description: </p>
 * @see java.lang.Runnable#run()
 */
@Override
public void run() {
	// TODO Auto-generated method stub
	for (int i = 0; i < 100000000; i++) {
		
	}
}
}
