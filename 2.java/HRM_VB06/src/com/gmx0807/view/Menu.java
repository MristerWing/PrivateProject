package com.gmx0807.view;

import java.util.Map;

import com.gmx0807.domain.UserBean;
import com.gmx0807.domain.UserData;

/*HRM 시스템 구성(Human Resource Management)
#1. 각 기능상의 목록을 출력 할 수 있는 메뉴 출력하기(Scanner, Sysytem.out, if~else, Loop)
	*Skin꾸미기
	*KITRI Human Resource Management System에 오신것을 환영합니다
	**/
	

public class Menu extends InputMSG {

	public void main_menu() {

		// define User
		Map<?, ?> users = new UserData().defData();

		// program run
		boolean isStop = false;

		// login
		String id = "";
		UserBean loginUser = new UserBean();
		boolean isPW = false;

		System.out.println("KITRI Human Resource Management System에 오신것을 환영합니다.");
		while (!isStop) {
			
			//check id
			if (!isPW) {
				System.out.print("아이디 입력: ");
				id = getString();
				if (users.containsKey(id)) { // 만약 HashMap내의 Key값과 같다면 ture를 return
					loginUser = (UserBean) users.get(id);
					isPW = true;
				} else {
					System.out.println("존재하지 않는 아이디 입니다.");
					continue;
				}
			}

			//check password
			System.out.print("비밀번호 입력:");
			String pw = getString();
			if (loginUser.getName().equals(pw)) { // 만약 HashMap내의 Key값과 같다면 ture를 return
				System.out.println("로그인 성공. " + loginUser.getName() + "님 환영합니다.");
				isPW = false;
				if (loginUser.getType().equals("MANAGER") || loginUser.getType().equals("PRESIDENT")) {
					System.out.println("관리자 계정 로그인.");
				}
			} else {
				System.out.println("비밀번호가 틀립니다. 다시 입력해 주세요.");
				continue;
			}

			//run InnerMenu
			isStop = new InnerMenu(loginUser).runMenu();

		}

	}

}
