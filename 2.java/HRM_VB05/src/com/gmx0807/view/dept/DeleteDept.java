package com.gmx0807.view.dept;

import java.util.ArrayList;

import com.gmx0807.domain.DeptBean;
import com.gmx0807.view.InputMSG;

public class DeleteDept extends InputMSG{
	ArrayList<DeptBean> dept;

	public DeleteDept(ArrayList<DeptBean> dept) {
		this.dept = dept;
	}

	public void deleteDept() {

		boolean isStop = false;
		boolean isB = false;
		boolean isFound = false;
		String flag = "";
		int deptno;

		while (!isStop) {

			if (!isB) {
				System.out.println("=> 부서 삭제를 선택하였습니다.");
				System.out.println("a. 전체삭제");
				System.out.println("b. 선택삭제");

				flag = getString();
			}

			//select a
			if (flag.equals("a")) {
				dept.clear();
				System.out.println("모든 부서번호가 삭제되었습니다.");
				isStop = true;
				
				//select b
			} else if (flag.equals("b")) {
				isB = true;
				System.out.println("삭제하고자 하는 부서의 번호를 입력하시오.");
				System.out.print("부서번호 입력: ");
				deptno = getInt();
				if (deptno < 10 || deptno >= 100) {
					System.err.println("부서번호는 2자릿수 입니다. 다시입력하세요. ");
					continue;
				}
				
				for(DeptBean i : dept) {
					if(deptno == i.getDeptno()) {
						dept.remove(dept.indexOf(i));
						System.out.println("선택한 부서번호가 삭제되었습니다.");
						isB = false;
						isFound = true;
						isStop = true;
						break;
					}
				}
				
				if(!isFound) {
					System.out.println("존재하지 않는 부서번호 입니다.");
					continue;
				}

			}

		}
	}
}
