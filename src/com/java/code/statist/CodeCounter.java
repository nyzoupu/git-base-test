package com.java.code.statist;

import java.io.*;

public class CodeCounter {
	static long normaiLines = 0;// 实际代码行数
	static long commentLines = 0;// 注释行数
	static long whiteLines = 0;// 空白行数

	public static void main(String[] args) {
		File f = new File("E:\\java-code-demo\\java-based-test\\src\\com\\java\\muti_thread\\test");
		File[] codeFiles = f.listFiles();
		for (File child : codeFiles) {
			if (child.getName().matches(".*\\.java$")) {
				parse(child);
			}
		}
		System.out.println("normalLines实际代码行数:" + normaiLines);
		System.out.println("commentLines注释行数:" + commentLines);
		System.out.println("whiteLines空白行数:" + whiteLines);
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
