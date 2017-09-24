package com.dylanscode.calculator;

import java.util.Scanner;

import com.dylanscode.math.Binary;
import com.dylanscode.math.Hex;

public class Main {
	public static void main(String[] args) {
		boolean on = true;
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		while(on) {
			System.out.println("Programming Calculator\nEnter Calculation. Type \"/HELP\" for instructions, or \"/QUIT\" to terminate program");
			String command = input.nextLine();
			switch(command) {
				case "/HELP":
					printInstructions();
					break;
				case "/QUIT":
					on = false;
					break;
				default:
					System.out.println(calculate(command));
					break;
			}
		}
	}
	public static void printInstructions() {
		System.out.println("INSTRUCTIONS:\nFormat:\t(D/B/H) (NUMBER) (OPERATOR) (D/B/H) (NUMBER) | OR | (D/B/H) (NUMBER) \"TO\" (D/B/H)");
		System.out.println("Sample: \"B 111 + D 10\" = 17 (111 in binary + 10 in decimal)");
		System.out.println("Sample: \"B 111 TO D\" = 7 (111 in binary is 7 in decimal)");
	}
	public static String calculate(String command) {
		String[] args = command.split(" ");
		String type1 = args[0];
		String num1 = args[1];
		int num1_ = -1;
		int num2_ = -1;
		String result = "-1";
		String operator = args[2];
		String type2 = args[3];
		String num2 = args.length == 5 ? args[4]: "-1";
		if(type1.equalsIgnoreCase("D")) {
			num1_ = Integer.parseInt(num1);
		}else if(type1.equalsIgnoreCase("H")) {
			num1_ = Integer.parseInt(num1,16);

		}else if(type1.equalsIgnoreCase("B")) {
			num1_ = Integer.parseInt(num1,2);
		}else {
			System.err.println("ERROR: INVALID INPUT!\n");
		}
		
		if(type2.equalsIgnoreCase("D")) {
			num2_ = Integer.parseInt(num2);
		}else if(type2.equalsIgnoreCase("H")) {
			num2_ = Integer.parseInt(num2,16);

		}else if(type2.equalsIgnoreCase("B")) {
			num2_ = Integer.parseInt(num2,2);
		}else {
			System.err.println("ERROR: INVALID INPUT!\n");
		}
		
		switch(operator) {
			case "+":
				result = num1_ + num2_+"";
				break;
			case "-":
				result = num1_ - num2_+"";
				break;
			case "*":
				result = num1_ * num2_+"";
				break;
			case "/":
				result = num1_ / (double) num2_+"";
				break;
			case "%":
				result = num1_ % num2_+"";
				break;
			case "|":
				result = (num1_ | num2_)+"";
				break;
			case "&":
				result = (num1_ & num2_)+"";
				break;
			case "^":
				result = (num1_ ^ num2_)+"";
				break;
			case "<<":
				result = (num1_ << num2_)+"";
				break;
			case ">>":
				result = (num1_ >> num2_)+"";
				break;
			case ">>>":
				result = (num1_ >>> num2_)+"";
			case "TO":
				if(args[0].equals("D")) {
					if(args[3].equals("H")) {
						result = Hex.decimalToHex(num1_);
					}else if(args[3].equals("B")) {
						result = Binary.decimalToBinary(num1_);
					}else {
						result = num1_+"";
					}
				}else if(args[0].equals("B")) {
					if(args[3].equals("D")) {
						result = Integer.parseInt(num1,2) + "";
					}else if(args[3].equals("H")) {
						result = Hex.decimalToHex(Integer.parseInt(num1,2));
					}else {
						result = num1;
					}
				}else if(args[0].equals("H")) {
					if(args[3].equals("D")) {
						result = Integer.parseInt(num1, 16) +"";
					}else if(args[3].equals("B")) {
						result = Binary.decimalToBinary(Integer.parseInt(num1,16));
					}else {
						result = num1;
					}
				}else {
					System.err.println("ERROR");
				}
				
		}
		return result;
	}
}
