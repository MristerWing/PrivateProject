package com.gmx0807.view.dept;

import java.util.ArrayList;

import com.gmx0807.domain.DeptBean;
import com.gmx0807.domain.DeptData;
import com.gmx0807.view.InputMSG;


public class SearchDept extends InputMSG {
	private ArrayList<DeptBean> dept;

	public SearchDept(ArrayList<DeptBean> dept) {
		this.dept = dept;
	}

	public SearchDept() {
	}

	public void searchInfo() {
		boolean isStop = false;
		String flag = "";
		int sDept = 0;
		boolean isB = false;
		boolean code = false;

		while (!isStop) {

			if (!isB) {
				System.out.println("=> 부서정보 조회입니다.('exit' 입력시 종료)");
				System.out.println("a. 전체부서정보조회");
				System.out.println("b. 선택부서정보조회");
			}

			flag = getString();

			if (flag.equals("a")) {
				new SearchDept().getAllDept(dept);
				continue;

				// select b
			} else if (flag.equals("b")) {
				while (!code) {
					isB = true;
					System.out.print("부서번호를 입력하세요: ");
					sDept = getInt();

					if (sDept < 10 || sDept >= 100) {
						System.err.println("부서번호는 2자릿수 입니다. 다시입력하세요. ");
						continue;
					}

					new SearchDept().getSelectDept(dept, sDept);
					isB = false;
					System.out.print("계속 검색하시겠습니까?(y/n)");
					String chk = getString();

					if (chk.equals("y")) {
						continue;
					} else if (chk.equals("n")) {
						code = true;
						isStop = true;
						break;
					} else {
						System.out.println("정확한 값이 아닙니다. 제대로 입력하세요.");
					}

				} // while end

				// select exit
			} else if (flag.equals("exit")) {
				isStop = true;
				System.out.println("exit, 부서정보조회를 종료합니다.");
				continue;
			}

			System.err.println("정확한 값이 아닙니다. 다시입력하세요. ");
			continue;

		} // while isStop end
	}

	// 모든 정보
	public void getAllDept(ArrayList<DeptBean> dept) {

		System.out.println("조회 결과");

		for (int i = 0; i < dept.size(); i++) {
			System.out.println(dept.get(i).getData());
		}

		System.out.println();

	}

	// 선택된 정보
	public void getSelectDept(ArrayList<DeptBean> dept, int sDept) {
		boolean isfind = false;
		String Deptno = Integer.toString(sDept);

		System.out.println("조회 결과");

		// split data
		String[] index = new DeptData().getDept(dept, Deptno).getData().split(" ");

		// find Deptno
		if (Deptno.equals(index[0])) {
			// print data
			for (int j = 0; j < index.length; j++) {
				System.out.print(index[j] + "\t");
				isfind = true;
			}
			System.out.println();
		} else
			isfind = false;

		if (!isfind)
			System.out.println("입력한 부서번호는 없는 번호입니다.");
		System.out.println();

	}

}