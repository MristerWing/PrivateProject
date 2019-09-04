package com.gmx0807.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

import com.gmx0807.domain.EmpBean;
import com.gmx0807.domain.EmpData;

//1.사원정보 조회
public class SearchEmp {
	public BufferedReader br;
	private boolean isStop = false;
	private String flag = "";
	private ArrayList<EmpBean> emp;

	public SearchEmp(BufferedReader br, ArrayList<EmpBean> emp) {
		this.br = br;
		this.emp = emp;
	}

	public SearchEmp() {
	}

	public void searchInfo() {
		int sEmp = 0;
		boolean isB = false;

		while (!isStop) {

			if (!isB) {
				System.out.println("=> 사원정보 조회입니다.('exit' 입력시 종료)");
				System.out.println("a. 전체사원정보조회");
				System.out.println("b. 선택사원정보조회");
			}

			// BufferedReader exception
			try {
				if (!isB) {
					flag = br.readLine();
				}

				// select a
				if (flag.equals("a")) {
					new SearchEmp().getAllEmp(emp);
					continue;

					// select b
				} else if (flag.equals("b")) {
					isB = true;
					System.out.print("사원사원번호를 입력하세요: ");

					// insert sEmp
					try {
						sEmp = Integer.parseInt(br.readLine());
						if (sEmp <= 999) {
							System.err.println("사원번호는 4자릿수 입니다. 다시입력하세요. ");
							continue;
						}
						new SearchEmp().getSelectEmp(emp, sEmp);
						isB = false;
						continue;
					} catch (NumberFormatException e) {
						System.err.println("정확한 값이 아닙니다. 다시입력하세요. ");
						continue;
					}

					// select exit
				} else if (flag.equals("exit")) {
					isStop = true;
					System.out.println("exit, 사원정보조회를 종료합니다.");
					continue;
				}
				System.err.println("정확한 값이 아닙니다. 다시입력하세요. ");
				continue;

			} catch (IOException e) {
				System.err.println(e);
			}

		}
	}

	// 모든 정보
	public void getAllEmp(ArrayList<EmpBean> emp) {

		System.out.println("조회 결과");

		for (int i = 0; i < emp.size(); i++) {
			System.out.println(emp.get(i).getData());
		}
		System.out.println();

	}

	// 선택된 정보
	public void getSelectEmp(ArrayList<EmpBean> emp, int sEmp) {
		boolean isfind = false;
		String empno = Integer.toString(sEmp);

//		0: empno 1: ename 2: mgr 3: job 4: sal 5: comm 6: hiredate 7:deptno

		System.out.println("조회 결과");

		// split data
		String[] index = new EmpData().getEmp(emp, empno).getData().split(" ");

		// find empno
		if (empno.equals(index[0])) {

			// print data
			for (int j = 0; j < index.length; j++) {
				System.out.print(index[j] + "\t");
				isfind = true;
			}
			System.out.println();

		} else
			isfind = false;

		if (!isfind)
			System.out.println("입력한 사원번호는 없는 번호입니다.");
		System.out.println();

	}
}

//System.out.println("사원번호" + "   " + "이름" + "      " + "매니저" + "\t" + "직업" + "\t" + "월급" + "      " + "보너스"
//+ "         " + "등록일" + "     " + "근무지번호");
