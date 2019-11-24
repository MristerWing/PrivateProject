package com.java.aop04;

import java.util.Scanner;

public class Student implements Person {
	@Override
	public void work() {
		System.out.println("수업을 듣는다.");

		Scanner scanner = new Scanner(System.in);

		System.out.print("input: numer:");
		int number = scanner.nextInt();
		scanner.close();

		if (number == 5) {
			System.out.println(number / 0);
		}
	}
}
