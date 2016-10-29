package com.java.code.statist;

import java.io.*;

public class CodeCounter {
	static long normaiLines = 0;// ʵ�ʴ�������
	static long commentLines = 0;// ע������
	static long whiteLines = 0;// �հ�����

	public static void main(String[] args) {
		File f = new File("E:\\java-code-demo\\java-based-test\\src\\com\\java\\muti_thread\\test");
		File[] codeFiles = f.listFiles();
		for (File child : codeFiles) {
			if (child.getName().matches(".*\\.java$")) {
				parse(child);
			}
		}
		System.out.println("normalLinesʵ�ʴ�������:" + normaiLines);
		System.out.println("commentLinesע������:" + commentLines);
		System.out.println("whiteLines�հ�����:" + whiteLines);
	}

	private static void parse(File f) {
		BufferedReader br = null;
		boolean comment = false;
		try {
			br = new BufferedReader(new FileReader(f));
			String line = "";

			while ((line = br.readLine()) != null) {
				line = line.trim();
				if (line.matches("^[\\s&&[^\\n]]*$")) {
					whiteLines++;
				} else if (line.startsWith("/*") && !line.endsWith("*/")) {
					commentLines++;
					comment = true;
				} else if (true == comment) {
					commentLines++;
					if (line.endsWith("*/")) {
						comment = false;
					}
				} else {

					normaiLines++;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
					br = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
