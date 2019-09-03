package com.gmx0807.view;

import java.io.BufferedReader;
import java.io.IOException;

import com.gmx0807.domain.EmpData;

//1.사원정보 조회
public class SearchEmp {
	public BufferedReader br;
	private boolean isStop = false;
	private String plag = "";
	private EmpData[] emp;

	public SearchEmp(BufferedReader br, EmpData[] emp) {
		this.br = br;
		this.emp = emp;
	}

	public SearchEmp() {
	}

	public void searchInfo() {
		int sEmp = 0;

		while (!isStop) {

			System.out.println("사원정보 조회입니다.");
			System.out.println("a. 전체사원정보조회");
			System.out.println("b. 선택사원정보조회");

			// BufferedReader exception
			try {
				plag = br.readLine();
				if (plag.equals("a")) {
					isStop = true;
					continue;
				} else if (plag.equals("b")) {
					System.out.print("사원사원번호를 입력하세요: ");

					// input sEmp
					try {
						sEmp = Integer.parseInt(br.readLine());
						if (sEmp <= 999) {
							System.err.println("사원번호는 4자릿수 입니다. 다시입력하세요. ");
							continue;
						}
						isStop = true;
						continue;
					} catch (NumberFormatException e) {
						System.err.println("정확한 값이 아닙니다. 다시입력하세요. ");
						continue;
					}

				}
				System.err.println("정확한 값이 아닙니다. 다시입력하세요. ");
				continue;

			} catch (IOException e) {
				System.err.println(e);
			}

		}

		if (plag.equals("a")) {
			new SearchEmp().getAllEmp(emp);
		} else if (plag.equals("b")) {
			new SearchEmp().getSelectEmp(emp, sEmp);
		} else {
			System.out.println("ERORR");
		}
	}

	// 모든 정보
	public void getAllEmp(EmpData[] emp) {
//		System.out.println("사원번호" + "   " + "이름" + "      " + "매니저" + "\t" + "직업" + "\t" + "월급" + "      " + "보너스"
//				+ "         " + "등록일" + "     " + "근무지번호");

//		0: empno 1: ename 2: mgr 3: job 4: sal 5: comm 6: hiredate 7:deptno
		System.out.println("조회 결과");

		for (int i = 0; i < emp.length; i++) {
			// split data
			String[] empArr = emp[i].getData().split(" ");
			// print data
			for (int j = 0; j < empArr.length; j++) {
				System.out.print(empArr[j] + "\t");
			}
			System.out.println();
		}
		System.out.println();

	}

	// 선택된 정보
	public void getSelectEmp(EmpData[] emp, int sEmp) {
		boolean isfind = false;
		System.out.println("조회 결과");

		for (int i = 0; i < emp.length; i++) {

			// split data
			String[] empArr = emp[i].getData().split(" ");

			// find empno
			if (sEmp == Integer.parseInt(empArr[0])) {

				// print data
				for (int j = 0; j < empArr.length; j++) {
					System.out.print(empArr[j] + "\t");
					isfind = true;
				}
				System.out.println();
				break;

			}else isfind = false;
		}
		
		if(!isfind) System.out.println("입력한 사원번호는 없는 번호입니다.");
		
	}
}
