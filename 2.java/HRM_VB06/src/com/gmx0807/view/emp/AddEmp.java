package com.gmx0807.view.emp;

import com.gmx0807.domain.EmpBean;
import com.gmx0807.domain.EmpData;
import com.gmx0807.view.InputMSG;

public class AddEmp extends InputMSG {

	public void addEmp() {

		// loop flag
		boolean isStop = false;

		// data flag
		boolean isGetNo = false;
		boolean isGetName = false;
		boolean isGetM = false;
		boolean isGetJ = false;
		boolean isGetS = false;
		boolean isGetC = false;
		boolean isGetHD = false;
		boolean isGetDno = false;

		// define data
		int empno = -1;
		String ename = "";
		int mgr = -1;
		String job = "";
		double sal = -1.0;
		double comm = -1.0;
		String hiredate = "";
		int deptno = -1;

		System.out.println("=> 사원 추가를 선택하였습니다. 추가하고자 하는 사원의 번호를 입력하시오.");
		new EmpData().insEmpBatch();
		while (!isStop) {

			if (!isGetNo) {
				// get empno
				System.out.print("사원번호 입력: ");
				empno = getInt();
				if (empno <= 999) {
					System.err.println("사원번호는 4자릿수 입니다. 다시입력하세요. ");
					continue;
				}

				// check overlap
				EmpBean tmpBean = new EmpData().getEmp(Integer.toString(empno));
				if (tmpBean.getEmpno() == empno) {
					System.err.println("이미 있는 사원번호입니다. 다시입력하세요. ");
					continue;
				}

				isGetNo = true;
			}

			if (!isGetName) {
				// get ename
				System.out.print("사원이름 입력: ");
				ename = getString();
				isGetName = true;
			}

			if (!isGetJ) {
				// get job
				System.out.print("직업 입력: ");
				job = getString();
				isGetJ = true;
			}

			if (!isGetM) {
				// get mgr
				System.out.print("매니저 입력: ");
				mgr = getInt();
				if (mgr <= 999) {
					System.err.println("사원번호는 4자릿수 입니다. 다시입력하세요. ");
					continue;
				}
				isGetM = true;
			}

			if (!isGetHD) {
				// get hiredate
				System.out.print("입사일 입력: ");
				hiredate = getString();
				isGetHD = true;
			}

			if (!isGetS) {
				// get sal
				System.out.print("월급 입력: ");
				sal = getDouble();
				isGetS = true;
			}

			if (!isGetC) {
				// get comm
				System.out.print("보너스 입력: ");
				comm = getDouble();
				isGetC = true;
			}

			if (!isGetDno) {
				// get deptno
				System.out.print("부서번호 입력: ");
				deptno = getInt();
				isGetDno = true;
			}

			if (isGetNo && isGetName && isGetJ && isGetM && isGetHD && isGetS && isGetC && isGetDno) {
				new EmpData().addEmp(new EmpBean(empno, ename, job, mgr, hiredate, sal, comm, deptno));
				System.out.println("입력이 완료되었습니다.\n");
				isStop = true;
			}

		}
	}
}
