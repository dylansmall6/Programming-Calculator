package com.dylanscode.math;

public class Hex {
	public static String decimalToHex(int dec) {
		if (dec == 0) {
			return "0";
		}
		String hex = "";
		while (dec > 0) {
			String l = "";
			switch (dec % 16) {
				case 0:
					l = "0";
					break;
				case 1:
					l = "1";
					break;
				case 2:
					l = "2";
					break;
				case 3:
					l = "3";
					break;
				case 4:
					l = "4";
					break;
				case 5:
					l = "5";
					break;
				case 6:
					l = "6";
					break;
				case 7:
					l = "7";
					break;
				case 8:
					l = "8";
					break;
				case 9:
					l = "9";
					break;
				case 10:
					l = "a";
					break;
				case 11:
					l = "b";
					break;
				case 12:
					l = "c";
					break;
				case 13:
					l = "d";
					break;
				case 14:
					l = "e";
					break;
				case 15:
					l = "f";
					break;
				default:
					break;
			}
			hex = l + hex;
			dec /= 16;
		}
		return hex;
	}
}
