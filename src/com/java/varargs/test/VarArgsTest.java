package com.java.varargs.test;

public class VarArgsTest {
    
	public static void m2(String str)
	{
		
	}
	
	public static void m1(String s, String... ss) {
		for (int i = 0; i < ss.length; i++) {
			System.out.println(ss[i]);
		}
    }

    public static void main(String[] args) {

        m1("");
        m1("aaa");
        m1("aaa", "bbb");
        String string;
        
        
        System.out.println(new TestCls().getA());
        System.out.println(new TestCls().getString());
        System.out.println(new TestCls().getS());
    
   
    }
}
class TestCls{
	Integer a;
	int b;
	char s;
	String string;
	
	/**
	 * @return the b
	 */
	public int getB() {
		return b;
	}
	/**
	 * @param b the b to set
	 */
	public void setB(int b) {
		this.b = b;
	}
	/**
	 * @return the s
	 */
	public char getS() {
		return s;
	}
	/**
	 * @param s the s to set
	 */
	public void setS(char s) {
		this.s = s;
	}
	/**
	 * @return the a
	 */
	public Integer getA() {
		return a;
	}
	/**
	 * @param a the a to set
	 */
	public void setA(Integer a) {
		this.a = a;
	}
	/**
	 * @return the string
	 */
	public String getString() {
		return string;
	}
	/**
	 * @param string the string to set
	 */
	public void setString(String string) {
		this.string = string;
	}
	
}