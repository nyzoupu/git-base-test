package com.java.muti_thread.test;

/** 
 * ClassName: ThreadSynTest <br/> 
 * Function: ���߳�ִ��10�Σ��������߳�ִ��100�Σ������ֻص����߳�ִ��10�Σ�
 *           �����ֻص����߳�ִ��100�����ѭ��50�� <br/> 
 * 
 * @author Paulsen��Zou 
 * @version  
 * @Date:2016��6��5������5:32:55 
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
	 * main(������һ�仰�����������������)</p>
	 *
	 * @param args    �趨�ļ�
	 * @return void    ��������
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
