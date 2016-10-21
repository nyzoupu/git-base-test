package com.java.muti_thread.test;

/** 
 * ClassName: ThreadSynTest <br/> 
 * Function: 子线程执行10次，接着主线程执行100次，接着又回到子线程执行10次，
 *           接着又回到主线程执行100，如此循环50次 <br/> 
 * 
 * @author Paulsen·Zou 
 * @version  
 * @Date:2016年6月5日下午5:32:55 
 * @version V1.0
 */
public class ThreadSynExamTest {

	/**
	 * 
	 */
	public ThreadSynExamTest() {
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
		new ThreadSynExamTest().init();
	}
	private void  init() {
		final Business business = new Business();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i < 50; i++) {
					business.subThreadMethod(i);
				}
			}
		}).start();;
		for (int i = 0; i < 50; i++) {
			business.mainThreadMethod(i);
		}
	}
	
	 class Business{
		
		public boolean isShouldSub = true;
		
		
		public synchronized void mainThreadMethod(int i)
		{
			if (isShouldSub) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			for (int j = 0; j < 100; j++) {
				System.out.println("mainThreadMethod: i="+ i+", j="+j);
			}
			this.isShouldSub = true;
			this.notify();
		}
		
		public synchronized void subThreadMethod(int i ){
			if (!isShouldSub) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			for (int j = 0; j < 10; j++) {
				System.out.println("subThreadMethod: i="+ i+", j="+j);
			}
			this.isShouldSub = false;
			this.notify();
			
		}
		
		
		
		
		
		
	}

}
