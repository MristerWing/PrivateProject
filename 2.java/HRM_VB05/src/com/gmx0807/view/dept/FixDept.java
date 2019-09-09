package com.gmx0807.view.dept;

import java.util.ArrayList;

import com.gmx0807.domain.DeptBean;
import com.gmx0807.view.InputMSG;

public class FixDept extends InputMSG implements Io {

	ArrayList<DeptBean> dept;

	public FixDept() {
	}

	public FixDept(ArrayList<DeptBean> dept) {
		this.dept = dept;
	}

	@Override
	public void edit() {
		
		//loop
		boolean isStop = false;
		
		//data
		int deptno;
		String dname = "";
		String loc = "";
		int fix = 0;
		
		//not found
		boolean isFound = false;
		
		//is fix
		boolean isFixed = false;

		// data flag
		boolean isGetNo = false;
		boolean isGetName = false;
		boolean isGetLoc = false;

		// check deptno's overlap
		int[] dtOver = new int[dept.size()];
		int loop = 0;
		boolean isOver = false;

		for (DeptBean index : dept) {
			dtOver[loop] = index.getDeptno();
			loop++;
		}

		while (!isStop) {

			System.out.println("=> 부서 수정을 선택하였습니다.");

			new SearchDept().allView();

			System.out.println("수정할 부서의 부서번호를 입력해 주세요.");
			deptno = getInt();
			
			if (deptno < 10 || deptno >= 100) {
				System.err.println("부서번호는 2자릿수 입니다. 다시입력하세요. ");
				continue;
			}
			
			for(DeptBean i : dept) {
				if(deptno == i.getDeptno()) {
					fix = dept.indexOf(i);
					isFound = true;
					break;
				}
			}
			
			if(!isFound) {
				System.out.println("존재하지 않는 부서번호 입니다.");
				continue;
			}

			while (!isFixed) {

					if (!isGetNo) {
						// get empno
						System.out.print("부서번호 입력: ");
						deptno = getInt();
						if (deptno < 10 || deptno >= 100) {
							System.err.println("부서번호는 2자릿수 입니다. 다시입력하세요. ");
							continue;
						}

						// check overlap
						for (int over : dtOver) {
							if (deptno == over) {
								System.err.println("이미 있는 부서번호입니다. 다시입력하세요. ");
								isOver = true;
								break;
							}
						}

						// is Overlap?
						if (isOver) {
							isOver = false;
							continue;
						}

						dept.get(fix).setDeptno(deptno);
						isGetNo = true;
					}

					if (!isGetName) {
						// get dname
						System.out.print("부서이름 입력: ");
						dname = getString();

						dept.get(fix).setDname(dname);
						isGetName = true;
					}

					if (!isGetLoc) {
						// get loc
						System.out.print("부서위치 입력: ");
						loc = getString();
						
						dept.get(fix).setLoc(loc);
						isGetLoc = true;
					}

					System.out.println("수정이 완료되었습니다.");
					isFixed = true;
					isStop = true;;
			}

		}
	}
}
