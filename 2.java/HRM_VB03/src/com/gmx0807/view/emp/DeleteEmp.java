package com.gmx0807.view.emp;

import java.util.ArrayList;

import com.gmx0807.domain.EmpBean;
import com.gmx0807.domain.EmpData;
import com.gmx0807.view.InputMSG;

public class DeleteEmp extends InputMSG{
	ArrayList<EmpBean> emp;

	public DeleteEmp(ArrayList<EmpBean> emp) {
		this.emp = emp;
	}

	public void deleteEmp() {

		boolean isStop = false;
		boolean isB = false;
		String flag = "";
		int empno;

		while (!isStop) {

			if (!isB) {
				System.out.println("=> 사원 삭제를 선택하였습니다.");
				System.out.println("a. 전체삭제");
				System.out.println("b. 선택삭제");

				flag = getString();
			}

			//select a
			if (flag.equals("a")) {
				emp.clear();
				System.out.println("모든 사원번호가 삭제되었습니다.");
				isStop = true;
				
				//select b
			} else if (flag.equals("b")) {
				isB = true;
				System.out.println("삭제하고자 하는 사원의 번호를 입력하시오.");
				System.out.print("사원번호 입력: ");
				empno = getInt();
				if (empno <= 999) {
					System.err.println("사원번호는 4자릿수 입니다. 다시입력하세요. ");
					continue;
				}

				//split data
				EmpBean tmpBean = new EmpData().getEmp(emp, Integer.toString(empno));
				String[] tmp = tmpBean.getData().split(" ");
				if (tmp[0].equals("-1")) {
					System.out.println("존재하지 않는 사원번호 입니다.");
					continue;
				}else {
					int index = emp.indexOf(tmpBean);
					
					emp.remove(index);
					isB = false;
					isStop = true;
					System.out.println("선택한 사원번호가 삭제되었습니다.");
				}
			}

		}
	}
}
