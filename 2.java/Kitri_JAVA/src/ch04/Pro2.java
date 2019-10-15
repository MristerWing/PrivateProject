package ch04;

public class Pro2 {

	public static int max(int[] arr) {
		int cnt = 1;
		int max = 0;
		boolean isNull = arr == null;

		if (isNull || arr.length == 0) {
			return -999999;
		}
		while (cnt <= arr.length - 1) {
			if (arr[max] < arr[cnt]) {
				max = cnt;
			}
			cnt++;
		}

		return arr[max];
	}

	public static int abs(int value) {
		if (value < 0) {
			return value * -1;
		}
		return value;
	}

	public static void main(String[] args) {
		int[] data = { 3, 2, 9, 4, 7 };
		System.out.println("최댓값: " + Integer.toString(max(data)));
		System.out.println("최댓값: " + Integer.toString(max(null)));
		System.out.println("최댓값: " + Integer.toString(max(new int[] {})));

		int value = 5;
		System.out.println(value + "의 절댓값: " + abs(value));

		value = -10;
		System.out.println(value + "의 절댓값: " + abs(value));

	}

}
