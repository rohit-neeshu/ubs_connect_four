package com.ubs.connect_four.util;

public class Util {
	public static boolean yesOrNo(String line) throws Exception {
		if(line.length() == 0 || line.length() > 1) {
			throw new Exception();
		}
		if(line.equalsIgnoreCase("y")) {
			return true;
		}
		else if(line.equalsIgnoreCase("n"))
			return false;
		else
			throw new Exception();
	}
}
