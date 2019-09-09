package com.gmx0807.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputMSG {
	
	private InputStreamReader in = new InputStreamReader(System.in);
	private BufferedReader br = new BufferedReader(in);

	//insert int
	public int getInt() {
		int input;

		try {
			try {
				input = Integer.parseInt(br.readLine());
				return input;
			} catch (NumberFormatException e) {
				System.err.println("정확한 값이 아닙니다. 다시입력하세요. ");
			}
		} catch (IOException e) {
			System.err.println(e);
		}

		return -1;
	}

	//insert String
	public String getString() {
		String input;

		try {
			input = br.readLine();
			return input;
		} catch (IOException e) {
			System.err.println(e);
		}

		return "";
	}

	//insert double
	public double getDouble() {
		double input;

		try {
			try {
				input = Double.parseDouble(br.readLine());
				return input;
			} catch (NumberFormatException e) {
				System.err.println("정확한 값이 아닙니다. 다시입력하세요. ");
			}
		} catch (IOException e) {
			System.err.println(e);
		}

		return -1.0;
	}
}
