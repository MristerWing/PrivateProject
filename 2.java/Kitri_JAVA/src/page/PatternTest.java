package page;

import java.util.regex.Pattern;

//사용이 필요할 경우 정규표현식을 참고할것

public class PatternTest {

	public static void main(String[] args) {
		String regExp = "(02|010)-\\d{3,4}-\\d{4}"; // 패턴 \\d는 와일드카드
		String data = "010-123-4567";
		boolean result = Pattern.matches(regExp, data);
		
		if(result) {
			System.out.println("1. Pattern is right");
		} else {
			System.out.println("1. ERROR");
		}
		
		regExp = "\\w+@\\w+\\.\\w+(\\.\\w+)?"; //1개이상의 알파벳 혹은 1개이상의 숫자, (\\.\\w+)?: \.\\w+가 없거나 한번 더 올 수 있음
		data = "angel@naver.com";
		result = Pattern.matches(regExp, data);
		
		if(result) {
			System.out.println("2. Pattern is right");
		} else {
			System.out.println("2. ERROR");
		}
	}

}
