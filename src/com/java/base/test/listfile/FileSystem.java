package com.java.base.test.listfile;
 
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
 
public class FileSystem {
 
    // 不用递归
    public static void main(String[] args) {
 
        long a = System.currentTimeMillis();
        List<File> filelisList = new ArrayList<File>();
        /**
         * 方式：-----不采用递归 
         * 时间:------87188 
         * 文件个数:-----47292
         */
        /**
         * 方式：-----不采用递归 
         * 时间:------79781 
         * 文件个数:-----47292
         */
 
        LinkedList<File> list = new LinkedList<File>();
        File dir = new File("F:");
        File file[] = dir.listFiles();
        for (int i = 0; i < file.length; i++) {
            if (file[i].isDirectory()) {
                list.add(file[i]);
            } else {
                // System.out.println(file[i].getAbsolutePath());
                filelisList.add(file[i]);
            }
        }
        File tmp;
        while (!list.isEmpty()) {
            tmp = list.removeFirst();
            if (tmp.isDirectory()) {
                file = tmp.listFiles();
                if (file == null)
                    continue;
                for (int i = 0; i < file.length; i++) {
                    if (file[i].isDirectory()) {
                        list.add(file[i]);
                    } else {
                        // System.out.println(file[i].getAbsolutePath());
                        filelisList.add(file[i]);
                    }
                }
                // System.out.println(tmp.getAbsolutePath());
                filelisList.add(tmp);
            }
 
        }
        System.out.println("方式：-----不采用递归");
        System.out.println("时间:------" + (System.currentTimeMillis() - a));
        System.out.println("文件个数:-----" + filelisList.size());
 
    }
 
}