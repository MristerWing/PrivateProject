package com.gmx0807.view.emp;

import java.util.ArrayList;

import com.gmx0807.domain.EmpBean;
import com.gmx0807.domain.EmpData;
import com.gmx0807.view.InputMSG;

public class FixEmp extends InputMSG{
	ArrayList<EmpBean> emp;
	
	public FixEmp() {}

	public FixEmp(ArrayList<EmpBean> emp) {
		this.emp = emp;
	}

	public void fixEmp() {
		boolean isStop = false;
		int empno;

		while (!isStop) {

			System.out.println("=> 사원 수정을 선택하였습니다.");
			
			new SearchEmp().getAllEmp(emp);
			
			System.out.println("수정할 사원의 사원번호를 입력해 주세요.");
			empno = getInt();
			
			//split data
			EmpBean tmpBean = new EmpData().getEmp(emp, Integer.toString(empno));
			String[] tmp = tmpBean.getData().split(" ");
			if (tmp[0].equals("-1")) {
				System.out.println("존재하지 않는 사원번호 입니다.");
				continue;
			}else {
				int index = emp.indexOf(tmpBean);
				EmpBean fixed = new FixEmp().fix(tmp);
				emp.set(index, fixed);
				isStop = true;
			}
			

		}

	}

	private EmpBean fix(String[] tmp) {
		
		//loopFlag
		boolean isStop = false;
		
		//fixed emp
		EmpBean fixed = new EmpBean(-1);
		
		// data flag
		boolean isGetNo = false;
		boolean isGetName = false;
		boolean isGetM = false;
		boolean isGetJ = false;
		boolean isGetS = false;
//		boolean isGetC = false;
		boolean isGetHD = false;
		boolean isGetDno = false;

		// define data
		int empno = -1;
		String ename = "";
		int mgr = -1;
		String job = "";
		double sal = -1.0;
//		double comm = -1.0;
		String hiredate = "";
		int deptno = -1;
		
		
		while (!isStop) {
			System.out.println("0 입력시 기존 값으로 유지됩니다.");

			if (!isGetNo) {
				// get empno
				System.out.print("사원번호 입력: ");
				empno = getInt();
				if(empno == 0) {
					empno = Integer.parseInt(tmp[0]);
				}else if (empno <= 999) {
					System.err.println("사원번호는 4자릿수 입니다. 다시입력하세요. ");
					continue;
				}
				isGetNo = true;
			}

			if (!isGetName) {
				// get ename
				System.out.print("사원이름 입력: ");
				ename = getString();
				if(ename.equals("0")) {
					ename = tmp[1];
				}
				isGetName = true;
			}

			if (!isGetM) {
				// get mgr
				System.out.print("매니저 입력: ");
				mgr = getInt();
				if(mgr == 0) {
					mgr = Integer.parseInt(tmp[2]);
				}else if (mgr <= 999) {
					System.err.println("사원번호는 4자릿수 입니다. 다시입력하세요. ");
					continue;
				}
				isGetM = true;
			}

			if (!isGetJ) {
				// get job
				System.out.print("직업 입력: ");
				job = getString();
				if(job.equals("0")) {
					job = tmp[3];
				}
				isGetJ = true;
			}

			if (!isGetS) {
				// get sal
				System.out.print("월급 입력: ");
				sal = getDouble();
				if(sal == 0) {
					sal = Double.parseDouble(tmp[4]);
				}
				isGetS = true;
			}

			/*
			 * if (!isGetC) { // get comm System.out.print("보너스 입력: "); comm =
			 * getDouble(); if(comm == 0) { comm = Double.parseDouble(tmp[5]); } isGetC =
			 * true; }
			 */

			if (!isGetHD) {
				// get hiredate
				System.out.print("입사일 입력: ");
				hiredate = getString();
				if(hiredate.equals("0")) {
					hiredate = tmp[6];
				}
				isGetHD = true;
			}

			if (!isGetDno) {
				// get deptno
				System.out.print("부서번호 입력: ");
				deptno = getInt();
				if(deptno == 0) {
					deptno = Integer.parseInt(tmp[7]);
				}
				isGetDno = true;
			}

			if (isGetNo && isGetName && isGetM && isGetJ && isGetS && isGetHD && isGetDno) {
				fixed = new EmpBean(empno, ename, mgr, job, sal, hiredate, deptno);
				System.out.println("입력이 완료되었습니다.\n");
				isStop = true;
			}

		}
		
		return fixed;
	}

}
