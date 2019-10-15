package ch03;

public class Pro3 {

	public static void main(String[] args) {
		int[] answer = { 1, 4, 4, 3, 1, 4, 4, 2, 1, 3, 2 };
		int[] counter = new int[4];

		for (int i = 0; i < answer.length; i++) {
			switch (answer[i]) {
			case 1:
				counter[0] += 1;
				break;
			case 2:
				counter[1] += 1;
				break;
			case 3:
				counter[2] += 1;
				break;
			case 4:
				counter[3] += 1;
				break;

			}
		}
		for (int i = 0; i < counter.length; i++) {
			System.out.print("" + counter[i]);
			for (int j = 0; j < counter[i]; j++)
				System.out.print("*");
			System.out.println();
		}

	}

}
