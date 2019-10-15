package com.gmx0807.view.dept;

import com.gmx0807.domain.DeptBean;
import com.gmx0807.domain.DeptData;
import com.gmx0807.view.InputMSG;

public class FixDept extends InputMSG implements Io {

	@Override
	public void edit() {

		// loop
		boolean isStop = false;

		// data
		int deptno;
		String dname = "";
		String loc = "";

		// data flag
		boolean isGetName = false;
		boolean isGetLoc = false;

		while (!isStop) {

			System.out.println("=> 부서 수정을 선택하였습니다.");

			new SearchDept().allView();

			System.out.println("수정할 부서의 부서번호를 입력해 주세요.");
			deptno = getInt();

			if (deptno < 10 || deptno >= 100) {
				System.err.println("부서번호는 2자릿수 입니다. 다시입력하세요. ");
				continue;
			}

			DeptBean tmpBean = new DeptData().getDept(Integer.toString(deptno));
			if (tmpBean.getDeptno() == -1) {
				System.out.println("존재하지 않는 부서번호 입니다.");
				continue;
			}

			if (!isGetName) {
				// get dname
				System.out.print("부서이름 입력: ");
				dname = getString();
				isGetName = true;
			}

			if (!isGetLoc) {
				// get loc
				System.out.print("부서위치 입력: ");
				loc = getString();
				isGetLoc = true;
			}

			new DeptData().fixDept(new DeptBean(deptno, dname, loc));
			System.out.println("수정이 완료되었습니다.");
			isStop = true;

		}
	}
}
