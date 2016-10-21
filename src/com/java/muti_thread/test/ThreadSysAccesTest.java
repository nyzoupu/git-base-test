package com.java.muti_thread.test;

/** 
 * ClassName: ThreadSysAccesTest <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * 
 * @author Paulsen��Zou 
 * @version  
 * @Date:2016��6��5������6:12:09 
 * @version V1.0
 */
public class ThreadSysAccesTest {

	/**
	 * 
	 */
	public ThreadSysAccesTest() {
		// TODO Auto-generated constructor stub
	}
	static InstanceClass instanceClass = new InstanceClass();
	
	/**
	 * main(������һ�仰�����������������)</p>
	 *
	 * @param args    �趨�ļ�
	 * @return void    ��������
	 * @throws
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				instanceClass.loopMethod();
			}
		}).start();
		
		new Thread(new ThreadClass(instanceClass)).start();

		
	}

}
class ThreadClass implements Runnable
{

	
	InstanceClass instanceClass;
	/**
	 * 
	 */
	public ThreadClass(InstanceClass instanceClass) {
		this.instanceClass = instanceClass;
	}

	/**
	 * <p>Title: run</p>
	 * <p>Description: </p>
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//instanceClass.loopMethod2();
		instanceClass.loopMethod2();
	}
	
}

class InstanceClass{
	public static void staticMethod()
	{
		System.out.println("I am static method��"); 
	}
	
	public synchronized void  loopMethod() {
		for (int i = 0; i < 1; i++) {
			
				try {
					Thread.currentThread().sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				
			}
		}
	}
	public synchronized void  loopMethod2() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 1; j++) {
				try {
					System.out.println(i);
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public  void normalMethod()
	{
		System.out.println("I am normal method��"); 
	}
}
