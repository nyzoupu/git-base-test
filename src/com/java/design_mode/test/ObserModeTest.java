package com.java.design_mode.test;


import java.util.ArrayList;
import java.util.List;

/** 
 * ClassName: ObserModeTest <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * 
 * @author Paulsen·Zou 
 * @version  
 * @Date:2016年5月17日下午11:25:58 
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
	 * main(这里用一句话描述这个方法的作用)</p>
	 *
	 * @param args    设定文件
	 * @return void    返回类型
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
		
		watched.notified("Hello,各位");
		
		
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
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		for (Watcher watcherVar : watchList) {
			watcherVar.update(str);
		}
	}
	
}
