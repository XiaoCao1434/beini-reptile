package com.beini.beinireptile.util;

public class PrintUtil {
	public static void print(String msg, Object... args) {
		System.out.println(String.format(msg, args));
	}

	public static String trim(String s, int width) {
		if (s.length() > width)
			return s.substring(0, width - 1) + ".";
		else
			return s;
	}
}
