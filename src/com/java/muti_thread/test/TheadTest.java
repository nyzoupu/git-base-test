package com.java.muti_thread.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.security.auth.callback.Callback;

/** 
 * ClassName: TheadTest <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * 
 * @author Paulsen·Zou 
 * @version  
 * @Date:2016年5月29日下午5:36:43 
 * @version V1.0
 */
public class TheadTest {

	/**
	 * 
	 */
	public TheadTest() {
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
		
		
		Thread thread = new  Thread(new ThreadInstacne1());
	    thread.start();
	    
	    ThreadInstacne1 instacne1 = new ThreadInstacne1();
	    instacne1.run();
	    
	    
	    ThreadInstance2 instance2 = new ThreadInstance2();
	    instance2.start();
	    
	    ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
	    
	    	cachedThreadPool.execute(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					for (int i = 0; i < 50; i++) {
						System.out.println(i++);
					}
				}
			});
	    	
	    	cachedThreadPool.submit(instance2);
	    	
	}
	public static void callBackFun()
	{
		System.out.println("我是在线程池中线程都执行完了，才调用回调函数");
	}

}

class CallBackClass  implements Callback
{
 public void show() {
	 System.out.println("我是回调函数");
}	
}

class ThreadInstacne1 implements Runnable
{

	/**
	 * <p>Title: run</p>
	 * <p>Description: </p>
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		System.out.println(" 这里是线程实例1.。"+Thread.currentThread().getName());
		
	} 
	
	
	}


class ThreadInstance2 extends Thread
{

	/**
	 * <p>Title: run</p>
	 * <p>Description: </p>
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("我是线程池2.。哈哈哈");
	}
	

}
