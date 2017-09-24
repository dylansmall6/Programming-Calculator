package com.dylanscode.math;

public class Binary {
	public static String decimalToBinary(int dec) {
		if(dec == 0) {
			return "0";
		}
		String bin = "";
		while(dec > 0) {
			bin = (dec % 2) + bin;
			dec /= 2;
		}
		return bin;
	}
}
