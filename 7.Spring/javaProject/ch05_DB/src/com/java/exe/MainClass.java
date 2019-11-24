package com.java.exe;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.java.ui.FriendUI;

public class MainClass {

	public static void main(String[] args) throws Throwable {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(
				"appCTX.xml");

		FriendUI friendUI = (FriendUI) ctx.getBean("friendUIImp");

		friendUI.execute();

		ctx.close();
	}

}
