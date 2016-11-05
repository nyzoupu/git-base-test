 	package com.java.base.test.listfile;
 
import java.io.File;
import java.util.ArrayList;
 
//递归
public class FileSystemDigui {
    private static ArrayList<File> filelist = new ArrayList<File>();
 
    public static void main(String[] args) {
        /**
         * 方式:------采用递归 
         * 时间:-------75797 
         * 文件个数:--------47292
         */
        /**
         *  方式:------采用递归
         *  时间:-------69344 
         *  文件个数:--------47292
         */
        long a = System.currentTimeMillis();
        refreshFileList("F:");
        System.out.println("方式:------采用递归");
        System.out.println("时间:-------" + (System.currentTimeMillis() - a));
        System.out.println("文件个数:--------" + filelist.size());
 
    }

    public static void refreshFileList(String strPath) {
        File dir = new File(strPath);
        File[] files = dir.listFiles();
 
        if (files == null)
            return;
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                filelist.add(files[i]);
                refreshFileList(files[i].getAbsolutePath());
            } else {
                //String strFileName = files[i].getAbsolutePath().toLowerCase();
                // System.out.println("---"+strFileName);
                filelist.add(files[i]);
            }
        }
    }
}