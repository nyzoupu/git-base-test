package com.java.design_mode.test;


import java.util.ArrayList;
import java.util.List;

/** 
 * ClassName: ObserModeTest <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * 
 * @author Paulsen��Zou 
 * @version  
 * @Date:2016��5��17������11:25:58 
 * @version V1.0
 */
public class ObserModeTest {

	/**
	 * 
	 */
	public ObserModeTest() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * main(������һ�仰�����������������)</p>
	 *
	 * @param args    �趨�ļ�
	 * @return void    ��������
	 * @throws
	 */
	public static void main(String[] args)
	{
		Watched watched = new ConcrectWatched();
		 
		
		Watcher watcher1 = new ConcrectWatcher();
		Watcher watcher2 = new ConcrectWatcher();
		Watcher watcher3 = new ConcrectWatcher();
		Watcher watcher4 = new ConcrectWatcher();
		
		watched.add(watcher1);
		watched.add(watcher2);
		watched.add(watcher3);
		watched.add(watcher4);
		
		watched.notified("Hello,��λ");
		
		
	}
}

interface Watcher
{
	public void update(String str);
	
}

interface Watched
{
	public void add(Watcher watcher);
	public void remove(Watcher watcher);
	public void notified(String str);
}

class ConcrectWatcher implements Watcher
{

	/**
	 * <p>Title: update</p>
	 * <p>Description: </p>
	 * @param str
	 * @see easytest.Watcher#update(java.lang.String)
	 */
	@Override
	public void update(String str) {
		System.out.println(str);
	}
}

class ConcrectWatched implements Watched
{
	private List<Watcher> watchList = new ArrayList<Watcher>();

	 
	/**
	 * <p>Title: add</p>
	 * <p>Description: </p>
	 * @param watcher
	 * @see easytest.Watched#add(easytest.Watcher)
	 */
	@Override
	public void add(Watcher watcher) {
		watchList.add(watcher);
		
	}

	/**
	 * <p>Title: remove</p>
	 * <p>Description: </p>
	 * @param watcher
	 * @see easytest.Watched#remove(easytest.Watcher)
	 */
	@Override
	public void remove(Watcher watcher) {
		watchList.remove(watcher);
	}

	/**
	 * <p>Title: notified</p>
	 * <p>Description: </p>
	 * @param watcher
	 * @see easytest.Watched#notified(easytest.Watcher)
	 */
	@Override
	public void notified(String str) {
		for (Watcher watcherVar : watchList) {
			watcherVar.update(str);
		}
	}
	
}
