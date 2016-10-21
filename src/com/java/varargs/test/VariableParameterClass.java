package com.java.varargs.test;

/** 
 * ClassName: VariableParameterClass <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * 
 * @author Paulsen·Zou 
 * @version  
 * @Date:2016年5月17日下午10:25:43 
 * @version V1.0
 */
public class VariableParameterClass {

	/**
	 * 
	 */
	public VariableParameterClass() {
		// TODO Auto-generated constructor stub
	}
 
    static void show(String...parameters)
    {
    	for(int i = 0; i<parameters.length; i++)
    	System.out.println(parameters[i]);
    }
	
	
	public static void main(String[]  args)
	{
		show("hello,","邹普");
	}

}
