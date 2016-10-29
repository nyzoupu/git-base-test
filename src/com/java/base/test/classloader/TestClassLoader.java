package com.java.base.test.classloader;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;

public class TestClassLoader extends ClassLoader{
	private String rootDir;
	public TestClassLoader(String rootDir) {
		this.rootDir = rootDir;
	}
	@Override
	public  Class<?> findClass(String name) throws ClassNotFoundException{
		Class<?>  instanceClass = findLoadedClass(name);
		if (instanceClass != null) {
			return instanceClass;
		}else {
//			ClassLoader parent = this.getParent();
//			try {
//				instanceClass = parent.loadClass(name);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			if (instanceClass!= null) {
//				return instanceClass;
//			}
			byte[] classData = getClassData(name);
			if (classData == null) {
				throw new ClassNotFoundException();
			}else {
				instanceClass = defineClass(null, classData, 0, classData.length);
			}
			
		}
		return instanceClass;
	}
	
	private byte[] getClassData(String name ){
		String path= rootDir + name.replace(".","\\") + ".class";
		System.out.println(path);
		InputStream is = null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {	
			is= new FileInputStream(path);
			byte[] buffer = new byte[1024];
			int temp=0;
			while ((temp = is.read(buffer)) != -1) {
				baos.write(buffer, 0, temp);
			}
			return baos.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
			return null;	
		}finally{
			if (is != null	) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (baos!=null) {
				try {
					baos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException {
		 TestClassLoader classLoader = new TestClassLoader("E:\\java-code-demo\\java-based-test\\bin\\");
		 Class<?> instance = classLoader.findClass("com.java.timestamp.test.TimeStamp");
		 System.out.println(instance.hashCode() + "," + instance.getClassLoader());
		 Object object= instance.newInstance();
		 String str=(String) instance.getMethod("showMsg").invoke(object);
		 System.out.println(str);
	}
}
