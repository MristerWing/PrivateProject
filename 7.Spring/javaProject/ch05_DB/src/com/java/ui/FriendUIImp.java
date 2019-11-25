package com.java.ui;

import java.util.List;
import java.util.Scanner;

import com.java.dao.FriendDao;
import com.java.dto.FriendDto;

public class FriendUIImp implements FriendUI {
	private FriendDto friendDto;
	private FriendDao friendDao;

	public FriendUIImp() {
	}

	public FriendUIImp(FriendDto friendDto, FriendDao friendDao) {
		this.friendDto = friendDto;
		this.friendDao = friendDao;
	}

	public void setFriendDto(FriendDto friendDto) {
		this.friendDto = friendDto;
	}

	public void setFriendDao(FriendDao friendDao) {
		this.friendDao = friendDao;
	}

	@Override
	public void execute() {
		showMenu();
		boolean end = false;
		Scanner scanner = new Scanner(System.in);

		System.out.print("메뉴를 선택하시오.: ");
		int choice = scanner.nextInt();

		switch (choice) {
		case 1:
			System.out.println("주소록 입력");
			scanner.close();
			addressInsert();
			break;
		case 2:
			System.out.println("주소록 전체 출력");
			addressALLPrint();
			break;
		case 3:
			System.out.println("주소록 검색");
			addressSearchAndPrint();
			break;
		case 4:
			System.out.println("주소록 수정");
			addressUpdate();
			break;
		case 5:
			System.out.println("주소록 삭제");
			addressDelete();
			break;
		default:
			System.out.println("ERROR");
			end = true;
			break;
		}

		if (end) {
			scanner.close();
		}
	}

	public void showMenu() {
		System.out.println("-----------------------------------------");
		System.out.println("1. 주소록작성");
		System.out.println("2. 주소록 전체 출력");
		System.out.println("3. 주소록 검색");
		System.out.println("4. 주소록 수정");
		System.out.println("5. 주소록 삭제");
	}

	public void addressInsert() {
		Scanner scanner = new Scanner(System.in);

		System.out.print("이름: ");
		friendDto.setName(scanner.next());

		System.out.print("전화번호: ");
		friendDto.setPhone(scanner.next());

		// MyAspect.logger.info(MyAspect.logMsg + friendDto.toString());

		int check = friendDao.insert(friendDto);
		if (check > 0) {
			System.out.println("input Sucess");
		}
		scanner.close();
	}

	public void addressALLPrint() {
		System.out.println("저장된 모든 전화번호 입니다.----------");
		List<FriendDto> friendList = friendDao.printAll();

		for (FriendDto friend : friendList) {
			System.out.print("순번: " + friend.getNum() + " ");
			System.out.print("이름: " + friend.getName() + "\t");
			System.out.print("번호: " + friend.getPhone() + "\n");
		}
	}

	public void addressSearchAndPrint() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("검색하려는 이름을 입력해 주세요.");
		List<FriendDto> searchResult = friendDao.searchAndPrint(scanner.next());

		System.out.println("검색결과--------------------");

		for (FriendDto friend : searchResult) {
			System.out.print("순번: " + friend.getNum() + " ");
			System.out.print("이름: " + friend.getName() + "\t");
			System.out.print("번호: " + friend.getPhone() + "\n");
		}

		scanner.close();
	}

	public void addressUpdate() {
		addressALLPrint();
		Scanner scanner = new Scanner(System.in);

		System.out.print("수정하려는 순번을 입력해 주세요.");
		friendDto.setNum(scanner.nextInt());

		System.out.print("이름을 입력해 주세요.");
		friendDto.setName(scanner.next());
		System.out.print("번호를 입력해 주세요.");
		friendDto.setPhone(scanner.next());

		int check = friendDao.update(friendDto);

		if (check > 0) {
			System.out.println("수정에 성공하였습니다.");
		} else {
			System.out.println("수정에 실패하였습니다.");
		}

		scanner.close();
	}

	public void addressDelete() {
		addressALLPrint();
		Scanner scanner = new Scanner(System.in);

		System.out.print("삭제하려는 순번을 입력해 주세요.");
		int check = friendDao.delete(scanner.nextInt());

		if (check > 0) {
			System.out.println("삭제에 성공하였습니다.");
		} else {
			System.out.println("삭제에 실패하였습니다.");
		}

		scanner.close();
	}

}
