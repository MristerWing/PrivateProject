package com.gmx0807.view;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

import com.gmx0807.domain.EmpData;

/*HRM 시스템 구성(Human Resource Management)
#1. 각 기능상의 목록을 출력 할 수 있는 메뉴 출력하기(Scanner, Sysytem.out, if~else, Loop)
	*Skin꾸미기
	*KITRI Human Resource Management System에 오신것을 환영합니다.
	*다음 수행하고자 하는 메뉴 번호를 누르세요.
		1. 사원정보 조회
		2. 사원추가
		3. 사원수정
		4. 사원삭제
		5. 부서정보 조회
		6. 종료*/

public class Menu {

	public void main_menu() {

		// define empData
		EmpData[] emp = new EmpData[3];
		emp[0] = new EmpData(9999, "Smith", 1111, "IT", 3000.0, 300.0, "2015-02-02", 10);
		emp[1] = new EmpData(1111, "KING", 1111, "President", 5000.0, 800.0, "1996-12-02", 10);
		emp[2] = new EmpData(2323, "Allen", 9999, "Salesman", 1600.0, 300.0, "2075-03-22", 20);

		Menu m = new Menu();
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader br;

		int plag = 0;
		boolean isStop = false;

		br = new BufferedReader(in);

		while (!isStop) {

			System.out.println("KITRI Human Resource Management System에 오신것을 환영합니다.");
			System.out.println("다음 수행하고자 하는 메뉴 번호를 누르세요.");
			System.out.println("1. 사원정보조회");
			System.out.println("2. 사원추가");
			System.out.println("3. 사원수정");
			System.out.println("4. 사원삭제");
			System.out.println("5. 부서정보 조회");
			System.out.println("6. 종료");
			System.out.print("값을 입력하세요: ");

			// BufferedReader exception
			try {
				// NumberFormatException, 값이 숫자가 아니면 예외처리로 경고
				try {

					plag = Integer.parseInt(br.readLine());

					// plag
					if (plag <= 0 || plag > 6) {
						System.err.print("정확한 값이 아닙니다. 다시입력하세요: ");
						continue;
					}

				} catch (NumberFormatException e) {
					System.err.print("정확한 값이 아닙니다. 다시입력하세요: ");
					continue;
				}

			} catch (IOException e) {
				System.err.println(e);
			}

			// use class or method
			System.out.print("입력한 메뉴: ");
			switch (plag) {
			case 1:
				System.out.println("1. 사원정보조회");
				new SearchEmp(br, emp).searchInfo();
				break;
			case 2:
				System.out.println("2. 사원추가");
				break;
			case 3:
				System.out.println("3. 사원수정");
				break;
			case 4:
				System.out.println("4. 사원삭제");
				break;
			case 5:
				System.out.println("5. 부서정보 조회");
				break;
			case 6:
				System.out.println("6. 종료");
				isStop = true;
				break;
			}

			if (isStop) {
				stop();
			}

		}

	}

	public static void stop() {
		System.out.println("프로그램이 종료되었습니다.");
	}

}
