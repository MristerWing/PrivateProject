package ch02;

public class Pro8 {

	public static void main(String[] args) {
		int num1 = 1;
		int num2 = 1;
		int num3 = 0;
		int tmp = 0;

		System.out.print(num1 + ", " + num2);
		for (int i = 0; i < 8; i++) {
			if (i == 0) {
				num3 = num1 + num2;
				tmp = num1;
			}else {
				int tmp2 = num3;
				num3 = num3 + tmp;
				tmp = tmp2;
			}
			System.out.print(", " + num3);
		}

	}

}
