package com.gmx0807.view;

import java.util.ArrayList;

import com.gmx0807.domain.DeptBean;
import com.gmx0807.domain.DeptData;
import com.gmx0807.domain.EmpBean;
import com.gmx0807.domain.EmpData;
import com.gmx0807.view.dept.AddDept;
import com.gmx0807.view.dept.DeleteDept;
import com.gmx0807.view.dept.FixDept;
import com.gmx0807.view.dept.SearchDept;
import com.gmx0807.view.emp.AddEmp;
import com.gmx0807.view.emp.DeleteEmp;
import com.gmx0807.view.emp.FixEmp;
import com.gmx0807.view.emp.SearchEmp;

/*HRM 시스템 구성(Human Resource Management)
#1. 각 기능상의 목록을 출력 할 수 있는 메뉴 출력하기(Scanner, Sysytem.out, if~else, Loop)
	*Skin꾸미기
	*KITRI Human Resource Management System에 오신것을 환영합니다.
	*다음 수행하고자 하는 메뉴 번호를 누르세요.
		1. 사원정보 조회
		2. 사원추가
		3. 사원수정
		4. 사원삭제
		5. 부서정보 조회
		6. 종료*/

public class Menu extends InputMSG {

	public void main_menu() {

		// define Data
		ArrayList<EmpBean> emp = new EmpData().defData();
		ArrayList<DeptBean> dept = new DeptData().defData();

		int flag = 0;
		boolean isStop = false;

		while (!isStop) {

			System.out.println("KITRI Human Resource Management System에 오신것을 환영합니다.");
			System.out.println("다음 수행하고자 하는 메뉴 번호를 누르세요.");
			System.out.println("1. 사원정보조회");
			System.out.println("2. 사원추가");
			System.out.println("3. 사원수정");
			System.out.println("4. 사원삭제");
			System.out.println("5. 부서정보 조회");
			System.out.println("6. 부서추가");
			System.out.println("7. 부서수정");
			System.out.println("8. 부서삭제");
			System.out.println("9. 종료");
			System.out.print("값을 입력하세요: ");

			flag = getInt();
			// flag
			if (flag <= 0 || flag > 9) {
				System.err.print("정확한 값이 아닙니다. 다시입력하세요: ");
				continue;
			}

			// use class or method
			System.out.print("입력한 메뉴: ");
			switch (flag) {
			case 1:
				System.out.println("1. 사원정보조회");
				new SearchEmp(emp).searchInfo();
				break;
			case 2:
				System.out.println("2. 사원추가");
				new AddEmp(emp).addEmp();
				break;
			case 3:
				System.out.println("3. 사원수정");
				new FixEmp(emp).fixEmp();
				break;
			case 4:
				System.out.println("4. 사원삭제");
				new DeleteEmp(emp).deleteEmp();
				break;
			case 5:
				System.out.println("5. 부서정보 조회");
				new SearchDept(dept).searchInfo();
				break;
			case 6:
				System.out.println("6. 부서추가");
				new AddDept(dept).edit();
				break;
			case 7:
				System.out.println("7. 부서수정");
				new FixDept(dept).edit();
				break;
			case 8:
				System.out.println("8. 부서삭제");
				new DeleteDept(dept).deleteDept();
				break;
			case 9:
				System.out.println("9. 종료");
				isStop = true;
				break;
			}

			if (isStop) {
				stop();
			}

		}

	}

	public static void stop() {
		System.out.println("프로그램이 종료되었습니다.");
	}

}
