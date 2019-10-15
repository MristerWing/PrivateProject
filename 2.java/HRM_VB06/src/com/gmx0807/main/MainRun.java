package com.gmx0807.main;

import com.gmx0807.view.Menu;

public class MainRun {

	public static void main(String[] args) {
		
		Menu m = new Menu();
		
		//Register Oracle Driver 
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//call menu
		m.main_menu();
	}

}

