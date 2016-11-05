 	package com.java.base.test.listfile;
 
import java.io.File;
import java.util.ArrayList;
 
//�ݹ�
public class FileSystemDigui {
    private static ArrayList<File> filelist = new ArrayList<File>();
 
    public static void main(String[] args) {
        /**
         * ��ʽ:------���õݹ� 
         * ʱ��:-------75797 
         * �ļ�����:--------47292
         */
        /**
         *  ��ʽ:------���õݹ�
         *  ʱ��:-------69344 
         *  �ļ�����:--------47292
         */
        long a = System.currentTimeMillis();
        refreshFileList("F:");
        System.out.println("��ʽ:------���õݹ�");
        System.out.println("ʱ��:-------" + (System.currentTimeMillis() - a));
        System.out.println("�ļ�����:--------" + filelist.size());
 
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