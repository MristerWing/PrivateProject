package com.gmx0807.view.emp;

import java.util.ArrayList;

import com.gmx0807.domain.EmpBean;
import com.gmx0807.domain.EmpData;
import com.gmx0807.view.InputMSG;

//1.사원정보 조회
public class SearchEmp extends InputMSG {
	private boolean isStop = false;
	private String flag = "";

	public SearchEmp() {
	}

	public void searchInfo() {
		int sEmp = 0;
		boolean isB = false;
		boolean code = false;

		while (!isStop) {

			if (!isB) {
				System.out.println("=> 사원정보 조회입니다.('exit' 입력시 종료)");
				System.out.println("a. 전체사원정보조회");
				System.out.println("b. 선택사원정보조회");
			}

			flag = getString();

			if (flag.equals("a")) {
				this.getAllEmp();
				continue;

				// select b
			} else if (flag.equals("b")) {
				while (!code) {
					isB = true;
					System.out.print("사원사원번호를 입력하세요: ");
					sEmp = getInt();

					if (sEmp <= 999) {
						System.err.println("사원번호는 4자릿수 입니다. 다시입력하세요. ");
						continue;
					}

					this.getSelectEmp(Integer.toString(sEmp));
					isB = false;
					System.out.print("계속 검색하시겠습니까?(y/n)");
					String chk = getString();

					if (chk.equals("y")) {
						continue;
					} else if (chk.equals("n")) {
						code = true;
						isStop = true;
						flag = "exit";
						break;
					} else {
						System.out.println("정확한 값이 아닙니다. 제대로 입력하세요.");
					}

				} // while end
				
				flag = "exit";

				// select exit
			} else if (flag.equals("exit")) {
				isStop = true;
				System.out.println("exit, 사원정보조회를 종료합니다.");
				continue;
			}else {
				System.err.println("정확한 값이 아닙니다. 다시입력하세요. ");
				continue;
			}

		} // while isStop end
	}

	// 모든 정보
	public void getAllEmp() {
		ArrayList<EmpBean> emp = new EmpData().defData();

		System.out.println("조회 결과");

		for (int i = 0; i < emp.size(); i++) {
			System.out.println(emp.get(i).getData());
		}

		System.out.println();

	}

	// 선택된 정보
	public void getSelectEmp(String empno) {

		System.out.println("조회 결과");

		// find data
		EmpBean tmpBean = new EmpData().getEmp(empno);

		// find empno
		if (tmpBean.getEmpno() == Integer.parseInt(empno)) {
			// print data
			System.out.println(tmpBean.getData());
		} else {
			System.out.println("입력한 사원번호는 없는 번호입니다.");
		}

		System.out.println();

	}
}

