package com.gmx0807.view;

import java.io.BufferedReader;
import java.util.ArrayList;

import com.gmx0807.domain.EmpBean;
import com.gmx0807.domain.EmpData;

public class DeleteEmp {
	BufferedReader br;
	ArrayList<EmpBean> emp;

	public DeleteEmp(BufferedReader br, ArrayList<EmpBean> emp) {
		this.br = br;
		this.emp = emp;
	}

	public void delete() {
		// inputStream
		InputMSG in = new InputMSG(br);

		boolean isStop = false;
		boolean isB = false;
		String flag = "";
		int empno;

		System.out.println("삭제하고자 하는 사원의 번호를 입력하시오.");

		while (!isStop) {

			if (!isB) {
				System.out.println("=> 사원 삭제를 선택하였습니다.");
				System.out.println("a. 전체삭제");
				System.out.println("b. 선택삭제");

				flag = in.getString();
			}

			//select a
			if (flag.equals("a")) {
				emp.clear();
				System.out.println("모든 사원번호가 삭제되었습니다.");
				isStop = true;
				
				//select b
			} else if (flag.equals("b")) {
				System.out.print("사원번호 입력: ");
				empno = in.getInt();
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
					System.out.println("선택한 사원번호가 삭제되었습니다.");
					isStop = true;
				}
			}

		}
	}
}
