package com.java.base.test.listfile;
 
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
 
public class FileSystem {
 
    // ���õݹ�
    public static void main(String[] args) {
 
        long a = System.currentTimeMillis();
        List<File> filelisList = new ArrayList<File>();
        /**
         * ��ʽ��-----�����õݹ� 
         * ʱ��:------87188 
         * �ļ�����:-----47292
         */
        /**
         * ��ʽ��-----�����õݹ� 
         * ʱ��:------79781 
         * �ļ�����:-----47292
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
        System.out.println("��ʽ��-----�����õݹ�");
        System.out.println("ʱ��:------" + (System.currentTimeMillis() - a));
        System.out.println("�ļ�����:-----" + filelisList.size());
 
    }
 
}