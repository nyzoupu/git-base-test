package com.java.io_nio.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import com.alibaba.fastjson.JSON;

public class SerialTest {

    public SerialTest() {
    }

    public static void main(String[] args) throws IOException{ 
        
        String string= "\\\\\"";
        System.out.println(string);
        SerialCls serialcls = new SerialCls();  
        serialcls.setName("zopu");
        serialcls.setAge(4);
          
          ObjectOutputStream oos = null;     
            FileOutputStream fos = null;     
            try {     
                fos = new FileOutputStream(new File("d:\\object.txt"));   
                oos = new ObjectOutputStream(fos);     
                oos.writeObject(JSON.toJSON(serialcls));  
                  
            } catch (Exception e) {     
                e.printStackTrace();     
            } finally {     
                if (oos != null) {     
                    try {     
                        oos.close();     
                    } catch (IOException e1) {     
                        e1.printStackTrace();     
                    }     
                }     
                if (fos != null) {     
                    try {     
                        fos.close();     
                    } catch (IOException e2) {     
                        e2.printStackTrace();     
                    }     
                }     
            }     
    System.out.println(Integer.toBinaryString(32));
    }  
}

class SerialCls implements Serializable
{
    public String name;
    public int age;
    /**
     * Getter method for property <tt>name</tt>.
     * 
     * @return property value of name
     */
    public String getName() {
        return name;
    }
    /**
     * Setter method for property <tt>name</tt>.
     * 
     * @param name value to be assigned to property name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Getter method for property <tt>age</tt>.
     * 
     * @return property value of age
     */
    public int getAge() {
        return age;
    }
    /**
     * Setter method for property <tt>age</tt>.
     * 
     * @param age value to be assigned to property age
     */
    public void setAge(int age) {
        this.age = age;
    }
    }