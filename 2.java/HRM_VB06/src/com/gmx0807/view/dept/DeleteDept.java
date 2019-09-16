package com.gmx0807.view.dept;

import java.util.ArrayList;

import com.gmx0807.domain.DeptBean;
import com.gmx0807.domain.DeptData;
import com.gmx0807.view.InputMSG;

public class DeleteDept extends InputMSG {
	ArrayList<DeptBean> dept = new DeptData().defData();

	public void deleteDept() {

		boolean isStop = false;
		int deptno;

		System.out.println("=> 부서 삭제를 선택하였습니다.");

		while (!isStop) {
			System.out.println("삭제하고자 하는 부서의 번호를 입력하시오.");
			System.out.print("부서번호 입력: ");
			deptno = getInt();
			if (deptno < 10 || deptno >= 100) {
				System.err.println("부서번호는 2자릿수 입니다. 다시입력하세요. ");
				continue;
			}

			// find data
			DeptBean tmpBean = new DeptData().getDept(Integer.toString(deptno));
			if (tmpBean.getDeptno() == -1) {
				System.out.println("존재하지 않는 사원번호 입니다.");
				continue;
			} else {
				new DeptData().deleteDept(Integer.toString(deptno));
				System.out.println("선택한 사원번호가 삭제되었습니다.");
			}

			System.out.print("계속 검색하시겠습니까?(y/n)");
			String chk = getString();

			if (chk.equals("y")) {
				continue;
			} else if (chk.equals("n")) {
				isStop = true;
			} else {
				System.out.println("정확한 값이 아닙니다. 제대로 입력하세요.");
			}

		}
	}
}
