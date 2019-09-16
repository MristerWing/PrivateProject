package com.gmx0807.view.dept;

import java.util.ArrayList;

import com.gmx0807.domain.DeptBean;
import com.gmx0807.domain.DeptData;
import com.gmx0807.view.InputMSG;

public class AddDept extends InputMSG implements Io{
	ArrayList<DeptBean> dept = new DeptData().defData();
	
	@Override
	public void edit() {
		
		// loop flag
		boolean isStop = false;

		// data flag
		boolean isGetNo = false;
		boolean isGetName = false;
		boolean isGetLoc = false;
		
		int deptno = -1;
		String dname = "";
		String loc = "";
		
		//check deptno's overlap
		int[] dtOver = new int[dept.size()];
		int loop = 0;
		boolean isOver = false;
		
		for(DeptBean index : dept) {
			dtOver[loop] = index.getDeptno();
			loop++;
		}
		
		while(!isStop) {
			System.out.println("=> 부서 추가를 선택하였습니다. 추가하고자 하는 부서의 번호를 입력하시오.");

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

				isGetNo = true;
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
			
			if (isGetNo && isGetName && isGetLoc) {
				new DeptData().addDept(new DeptBean(deptno, dname, loc));
				System.out.println("입력이 완료되었습니다.\n");
				isStop = true;
			}
			
		}
	}
	
	
}
