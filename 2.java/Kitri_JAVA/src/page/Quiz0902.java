package page;

import page.init.date0902.Singleton;

public class Quiz0902 {

	public static void main(String[] args) {
		Singleton obj1 = Singleton.getInstance();
		Singleton obj2 = Singleton.getInstance();

		/* 객체에서 객체끼리 비교할때 메모리에 의한 비교일 경우 '==' 을 사용하는것이 맞고,
		 * 객체에서 객체의 값만을 비교할 경우 equals 를 사용해야한다.
		 *  */
		
		if(obj1 == obj2) { 
			System.out.println("same Singleton");
		}else {
			System.out.println("different Singleton");
		}
		
	}

}
