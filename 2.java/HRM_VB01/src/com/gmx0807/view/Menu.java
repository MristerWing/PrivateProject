package com.gmx0807.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.gmx0807.domain.EmpBean;
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
		ArrayList<EmpBean> emp = new EmpData().defData();
		
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader br;

		int flag = 0;
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

					flag = Integer.parseInt(br.readLine());

					// flag
					if (flag <= 0 || flag > 6) {
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
			switch (flag) {
			case 1:
				System.out.println("1. 사원정보조회");
				new SearchEmp(br, emp).searchInfo();
				break;
			case 2:
				System.out.println("2. 사원추가");
				new AddEmp(br, emp).addEmp();
				break;
			case 3:
				System.out.println("3. 사원수정");
				new FixEmp(br, emp).fixEmp();
				break;
			case 4:
				System.out.println("4. 사원삭제");
				new DeleteEmp(br, emp).deleteEmp();
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
