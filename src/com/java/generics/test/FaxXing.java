package com.java.generics.test;

/** 
 * ClassName: FaxXing <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * 
 * @author Paulsen��Zou 
 * @version  
 * @Date:2016��5��29������7:26:18 
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
		System.out.println("���Ƿ��ͣ���Ҳ��֪��������ʲô����"  + conT);
		
	}

	/**
	 * main(������һ�仰�����������������)</p>
	 *
	 * @param args    �趨�ļ�
	 * @return void    ��������
	 * @throws
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new FaxXing<>(3).show();
	}

}
