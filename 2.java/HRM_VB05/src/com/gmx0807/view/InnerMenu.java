package com.gmx0807.view;

import java.util.ArrayList;

import com.gmx0807.domain.DeptBean;
import com.gmx0807.domain.EmpBean;
import com.gmx0807.domain.UserBean;
import com.gmx0807.view.dept.AddDept;
import com.gmx0807.view.dept.DeleteDept;
import com.gmx0807.view.dept.FixDept;
import com.gmx0807.view.dept.Io;
import com.gmx0807.view.dept.SearchDept;
import com.gmx0807.view.emp.AddEmp;
import com.gmx0807.view.emp.DeleteEmp;
import com.gmx0807.view.emp.FixEmp;
import com.gmx0807.view.emp.SearchEmp;

import ex.CodeValueNotFoundException;
import ex.ExceptionRun;

/*다음 수행하고자 하는 메뉴 번호를 누르세요.
1. 사원정보 조회
2. 사원추가
3. 사원수정
4. 사원삭제
5. 부서정보 조회
5. 부서추가
5. 부서수정
5. 부서삭제
9. 종료*/

public class InnerMenu extends InputMSG {
	private final boolean EXIT = true; // end flag
	private UserBean loginUser;
	private ArrayList<EmpBean> emp;
	private ArrayList<DeptBean> dept;

	public InnerMenu(UserBean loginUser, ArrayList<EmpBean> emp, ArrayList<DeptBean> dept) {
		this.loginUser = loginUser;
		this.emp = emp;
		this.dept = dept;
	}

	//Permission confirmation
	public boolean runMenu() {
		if (loginUser.getType().equals("admin"))
			return this.admin();
		else if (loginUser.getType().equals("user"))
			return this.users();

		return EXIT;
	}

	public boolean admin() {
		int flag = 0;
		boolean isStop = false;

		while (!isStop) {

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

			try {
				flag = getInt();
				new ExceptionRun().run(flag);
			} catch (CodeValueNotFoundException e) {
				System.err.println("정확한 값이 아닙니다. 다시입력하세요: ");
				continue;
			}

			Io deptView;
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
				deptView = new AddDept(dept);
				deptView.edit();
				break;
			case 7:
				System.out.println("7. 부서수정");
				deptView = new FixDept(dept);
				deptView.edit();
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
				return this.stop();
			}

		}

		return EXIT;
	}

	public boolean users() {

		int flag = 0;
		boolean isStop = false;

		while (!isStop) {
			System.out.println("다음 수행하고자 하는 메뉴 번호를 누르세요.");
			System.out.println("1. 사원정보조회");
			System.out.println("2. 부서정보 조회");
			System.out.println("3. 종료");
			System.out.print("값을 입력하세요: ");

			flag = getInt();

			if (flag <= 0 || flag > 3) {
				System.err.println("정확한 값이 아닙니다. 다시입력하세요: ");
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
				System.out.println("2. 부서정보 조회"); //자신의 부서만 확인 가능하게 할 경우 메소드 생성해야 함
				System.out.println("당신이 소속된 부서의 조회결과 입니다.");
				new SearchDept(dept).selectView(loginUser.getDept());
				break;
			case 3:
				System.out.println("3. 종료");
				isStop = true;
				break;
			}

			if (isStop) {
				return this.stop();
			}

		}

		return EXIT;
	}

	public boolean stop() {
		System.out.println("프로그램이 종료되었습니다.");
		return EXIT;
	}

}
