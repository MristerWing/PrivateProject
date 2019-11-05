package com.java.webapp.lifecylce;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author kjs
 * @작성일 2019.11.4.
 * @설명 웹 어플리케이션 생명주기 리스너이 해당 메소드가 웹 어프리케이션 시작과 종료를 호출한다.
 */

public class ContextListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("Wep App End --------------------------");
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("Wep App Start --------------------------");
	}

}
