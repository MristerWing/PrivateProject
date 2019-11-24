package com.java.aop05;

import java.util.Scanner;

public class Student implements Person {
	@Override
	public void work() {
		System.out.println("수업을 듣는다.");

		Scanner scanner = new Scanner(System.in);

		System.out.print("5 is Late:");
		int number = scanner.nextInt();
		scanner.close();

		if (number == 5) {
			System.out.println(number / 0);
		}
	}
}
