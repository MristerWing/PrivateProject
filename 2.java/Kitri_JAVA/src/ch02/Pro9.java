package ch02;

public class Pro9 {

	public static void main(String[] args) {
		int number = 12321;
		int tmp = number;
		int[] arr = new int[5];
		int result = 0; // reverse
		int cal = 1;
		int cnt = 0;

		/*
		 * while (tmp != 0) { if(tmp / cal >= 10) { cal *= 10; continue; }
		 * 
		 * result += (tmp % 10) * cal;
		 * 
		 * tmp = tmp / 10;
		 * 
		 * cal /= cal;
		 * 
		 * }
		 */
		
		do {
			arr[cnt] = tmp % 10;
			if(tmp >= 10) {
				cal *= 10;
			}
			tmp /= 10;
			cnt++;
		} while(tmp > 0);
		
		for(int index : arr) {
			result += index * cal;
			cal /= 10;
		}

		if (number == result)
			System.out.println(number + "회전수이다.");
		else
			System.out.println(number + "회전수가 아니다.");

	}

}
