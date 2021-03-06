package com.gmx0807.view.dept;

import java.util.ArrayList;

import com.gmx0807.domain.DeptBean;
import com.gmx0807.domain.DeptData;
import com.gmx0807.view.Search;

public class SearchDept extends Search {
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
				this.allView();
				;
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

					this.selectView(sDept);
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
						System.err.println("정확한 값이 아닙니다. 제대로 입력하세요.");
					}

				} // while end

				flag = "exit";

				// select exit
			} else if (flag.equals("exit")) {
				isStop = true;
				System.out.println("exit, 부서정보조회를 종료합니다.");
				continue;
			} else {
				System.err.println("정확한 값이 아닙니다. 다시입력하세요. ");
				continue;

			}

		} // while isStop end
	}

	// 모든 정보
	@Override
	public void allView() {
		ArrayList<DeptBean> dept = new DeptData().defData();

		System.out.println("조회 결과");

		for (int i = 0; i < dept.size(); i++) {
			System.out.println(dept.get(i).getData());
		}

		System.out.println();

	}

	// 선택된 정보
	@Override
	public void selectView(Object obj) {
		String deptno = obj.toString();

		System.out.println("조회 결과");

		// find data
		DeptBean tmpBean = new DeptData().getDept(deptno);
		
		// find Deptno
		if (tmpBean.getDeptno() != -1) {
			System.out.println(tmpBean.getData());
		} else {
			System.out.println("입력한 부서번호는 없는 번호입니다.");
		}
		
		System.out.println();

	}

}