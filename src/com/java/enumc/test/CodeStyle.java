package com.java.enumc.test;
/**
 * @author Paulsen
 *
 */
public class CodeStyle {

	public static void main(String[] args) {
		System.out.println(Color.getName(2));
	}
}


enum Color {
	RED("��ɫ", 1), GREEN("��ɫ", 2), BLANK("��ɫ", 3), YELLO("��ɫ", 4);
	// ��Ա����
	private String colorName;
	private int index;

	public static String getName(int id) {
		for (Color color : Color.values()) {
			if (color.getIndex() == id) {
				return color.getColorName();
			}
		}
		return null;
	}
	// ���췽��
	private Color(String colorName, int index) {
		this.colorName = colorName;
		this.index = index;
	}

	public String getColorName() {
		return colorName;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public void setColorName(String colorName) {
		this.colorName = colorName;
	}
}
