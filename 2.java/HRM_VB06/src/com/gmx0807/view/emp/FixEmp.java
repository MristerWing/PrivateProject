package com.gmx0807.view.emp;

import java.util.ArrayList;

import com.gmx0807.domain.EmpBean;
import com.gmx0807.domain.EmpData;
import com.gmx0807.view.InputMSG;

public class FixEmp extends InputMSG {
	ArrayList<EmpBean> emp = new EmpData().defData();

	public void fixEmp() {
		boolean isStop = false;
		int empno;

		while (!isStop) {

			System.out.println("=> 사원 수정을 선택하였습니다.");

			new SearchEmp().getAllEmp();

			System.out.println("수정할 사원의 사원번호를 입력해 주세요.");
			empno = getInt();

			// find data
			EmpBean tmpBean = new EmpData().getEmp(Integer.toString(empno));
			if (tmpBean.getEmpno() == -1) {
				System.out.println("존재하지 않는 사원번호 입니다.");
				continue;
			} else {
				new EmpData().fixEmp(fix(tmpBean.getData().split(" ")));
				System.out.println("test");
				isStop = true;
				break;
			}

		}

	}

	private EmpBean fix(String[] tmp) {

		// loopFlag
		boolean isStop = false;

		// fixed emp
		EmpBean fixed = new EmpBean(-1);

		// data flag
		boolean isGetName = false;
		boolean isGetM = false;
		boolean isGetJ = false;
		boolean isGetS = false;
		boolean isGetC = false;
		boolean isGetHD = false;
		boolean isGetDno = false;

		// define data
		int empno = Integer.parseInt(tmp[0]);
		String ename = "";
		int mgr = -1;
		String job = "";
		double sal = -1.0;
		double comm = -1.0;
		String hiredate = "";
		int deptno = -1;

		while (!isStop) {
			System.out.println("-1 입력시 기존 값으로 유지됩니다.");

			if (!isGetName) {
				// get ename
				System.out.print("사원이름 입력: ");
				ename = getString();
				if (ename.equals("-1")) {
					ename = tmp[1];
				}
				isGetName = true;
			}
			
			if (!isGetJ) {
				// get job
				System.out.print("직업 입력: ");
				job = getString();
				if (job.equals("-1")) {
					job = tmp[2];
				}
				isGetJ = true;
			}

			if (!isGetM) {
				// get mgr
				System.out.print("매니저 입력: ");
				mgr = getInt();
				if (mgr == -1) {
					mgr = Integer.parseInt(tmp[3]);
				} else if (mgr <= 999) {
					System.err.println("사원번호는 4자릿수 입니다. 다시입력하세요. ");
					continue;
				}
				isGetM = true;
			}
			
			if (!isGetHD) {
				// get hiredate
				System.out.print("입사일 입력: ");
				hiredate = getString();
				if (hiredate.equals("-1")) {
					hiredate = tmp[4];
				}
				isGetHD = true;
			}

			if (!isGetS) {
				// get sal
				System.out.print("월급 입력: ");
				sal = getDouble();
				if (sal == -1) {
					sal = Double.parseDouble(tmp[6]);
				}
				isGetS = true;
			}

			if (!isGetC) { 
				// get comm
				System.out.print("보너스 입력: ");
				comm = getDouble();
				if (comm == -1) {
					comm = Double.parseDouble(tmp[7]);
				}
				isGetC = true;
			}

			if (!isGetDno) {
				// get deptno
				System.out.print("부서번호 입력: ");
				deptno = getInt();
				if (deptno == -1) {
					deptno = Integer.parseInt(tmp[8]);
				}
				isGetDno = true;
			}

			if (isGetName && isGetM && isGetJ && isGetS && isGetHD && isGetC && isGetDno) {
				fixed = new EmpBean(empno, ename, job, mgr, hiredate, sal, comm, deptno);
				System.out.println("입력이 완료되었습니다.\n");
				isStop = true;
			}

		}

		return fixed;
	}

}
