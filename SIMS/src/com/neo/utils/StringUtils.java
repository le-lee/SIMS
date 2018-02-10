package com.neo.utils;

public class StringUtils {
	
	public static boolean isBlank(String str) {
		if (str != null && !str.equals("")) {
			return false;	
		}
		return true;
	}
}
