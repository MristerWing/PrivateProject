package com.gmx0807.view.emp;

import com.gmx0807.domain.EmpBean;
import com.gmx0807.domain.EmpData;
import com.gmx0807.view.InputMSG;

public class DeleteEmp extends InputMSG {

	public void deleteEmp() {

		boolean isStop = false;
		int empno;

		while (!isStop) {
			System.out.println("=> 사원 삭제를 선택하였습니다.");

			System.out.println("삭제하고자 하는 사원의 번호를 입력하시오.");
			System.out.print("사원번호 입력: ");
			empno = getInt();
			if (empno <= 999) {
				System.err.println("사원번호는 4자릿수 입니다. 다시입력하세요. ");
				continue;
			}

			// find data
			EmpBean tmpBean = new EmpData().getEmp(Integer.toString(empno));
			if (tmpBean.getEmpno() == -1) {
				System.out.println("존재하지 않는 사원번호 입니다.");
				continue;
			} else {
				new EmpData().deleteEmp(Integer.toString(empno));
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
