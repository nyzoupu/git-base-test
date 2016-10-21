package com.java.generics.test;

/** 
 * ClassName: FaxXing <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * 
 * @author Paulsen·Zou 
 * @version  
 * @Date:2016年5月29日下午7:26:18 
 * @version V1.0
 */
public class FaxXing<T> {

	T conT;
	/**
	 * 
	 */
	public FaxXing(T con) {
		// TODO Auto-generated constructor stub
		this.conT = con;
	}
	
	public <T>  void show()
	{
		System.out.println("我是泛型，我也不知道发生了什么事情"  + conT);
		
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

		new FaxXing<>(3).show();
	}

}
