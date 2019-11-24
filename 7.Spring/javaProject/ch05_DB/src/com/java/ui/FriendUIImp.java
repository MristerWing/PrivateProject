package com.java.ui;

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

		Scanner scanner = new Scanner(System.in);

		System.out.print("메뉴를 선택하시오.: ");
		int choice = scanner.nextInt();

		switch (choice) {
		case 1:
			System.out.println("주소록 입력");
			addressInsert();
			break;
		case 2:
			System.out.println("주소록 전체 출력");
			break;
		case 3:
			System.out.println("주소록 검색");
			break;
		case 4:
			System.out.println("주소록 수정");
			break;
		case 5:
			System.out.println("주소록 삭제");
			break;
		default:
			System.out.println("ERROR");
			break;
		}

		scanner.close();

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

	}

	public void addressSearchAndPrint() {

	}

	public void addressUpdate() {

	}

	public void addressDelete() {

	}

}
