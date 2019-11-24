package com.java.quiz01;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Yonsan {
	private float frontNum;
	private float backNum;
	private String oper;
	private String result;

	public void input() {
		Scanner scanner = new Scanner(System.in);

		System.out.print("수: ");
		frontNum = scanner.nextInt();
		scanner.reset();

		System.out.print("부호: ");
		oper = scanner.next();
		scanner.reset();

		System.out.print("수: ");
		backNum = scanner.nextInt();

		scanner.close();
	}

	public void getYosan() {
		DecimalFormat floatFormat = new DecimalFormat("0.##");
		float tmpResult = 0f;

		if (oper.equals("+")) {
			tmpResult = frontNum + backNum;
		} else if (oper.equals("-")) {
			tmpResult = frontNum - backNum;
		} else if (oper.equals("*")) {
			tmpResult = frontNum * backNum;
		} else if (oper.equals("/")) {

			if (backNum == 0) {
				result = "ERROR:Zero Division error";
			} else {
				tmpResult = frontNum / backNum;
			}

		} else {
			result = "ERROR:Operator Error";
		}

		if (result == null) {
			String expression = floatFormat.format(frontNum) + " " + oper + " "
					+ floatFormat.format(backNum) + " = ";
			result = expression + floatFormat.format(tmpResult);
		}

	}

	public void disp() {
		System.out.println(result);
	}
}
