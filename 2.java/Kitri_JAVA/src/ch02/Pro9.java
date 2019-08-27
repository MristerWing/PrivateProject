package ch02;

public class Pro9 {

	public static void main(String[] args) {
		int number = 12321;
		int tmp = number;
		int result = 0; // reverse
		int cal = 10;

		while (tmp != 0) {
			if(tmp / cal >= 10) {
				cal *= 10;
				continue;
			}
			
			result += (tmp % 10) *  cal;
			
			tmp = tmp / 10;
			
			cal /= cal;

		}

		if (number == result)
			System.out.println(number + "는 회문수 입니다.");
		else
			System.out.println(number + "는 회문수가 아닙니다.");

	}

}
