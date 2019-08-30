package page;

import java.util.Arrays;

import utils.FuncVoid;

public class Quiz0829 {

	// 맥스값
	public int returnMax(int num1, int num2, int num3) {
		int max = 0;
		if (num2 < num3)
			max = num3;
		else
			max = num2;
		if (max < num1)
			max = num1;

		return max;

	}

	// 배열복사
	public static void intArrayCopy(int[] src, int srcPos, int[] dest, int destPos, int length) {
		for (int i = srcPos; i < length; i++) {
			dest[destPos] = src[i];
			destPos++;
		}
	}

	// 행렬 합
	public static void plusMatrix(int[][] arr1, int[][] arr2, int[][] result) {
		int column = 0;

		for (int[] index : arr1) {
			for (int i = 0; i < arr2[0].length; i++) {
				result[column][i] = index[i] + arr2[column][i];
			}
			column++;
		}
	}

	// 행렬 차
	public static void minusMatrix(int[][] arr1, int[][] arr2, int[][] result) {
		int column = 0;

		for (int[] index : arr1) {
			for (int i = 0; i < arr2[0].length; i++) {
				result[column][i] = index[i] - arr2[column][i];
			}
			column++;
		}
	}

	// 행렬 곱

	/*
	 * i0j0 * k0l0 + i0j1 *k1l0 i0j0 * k0l1 + i0j1 *k1l1 i1j0 * k0l0 + i1j1 *k1l0
	 * i1j0 * k0l1 + i1j1 *k1l1
	 */

	public static void multiMatrix(int[][] arr1, int[][] arr2, int[][] result) {
		int column = 0; // 결과 배열의 열

		for (int[] index : arr1) {
			for (int i = 0; i < arr1.length; i++) {
				for (int j = 0; j < arr2.length; j++) { // 계산식의 행
					result[column][i] += index[j] * arr2[j][i];
				}
			}
			column++;
		}
	}

	// bubble sort, 0 오름차순, 1 내림차순
	public static void bubbleSort(int factor, int[] arr) {
		int cnt = 0;

		do {
			cnt = 0;
			for (int indexNum = 1; indexNum < arr.length; indexNum++) {
				if (factor == 0) {
					if (arr[indexNum - 1] < arr[indexNum]) {
						int tmp = arr[indexNum - 1];
						arr[indexNum - 1] = arr[indexNum];
						arr[indexNum] = tmp;
						cnt++;
					}
				} else if (factor == 1) {
					if (arr[indexNum - 1] > arr[indexNum]) {
						int tmp = arr[indexNum - 1];
						arr[indexNum - 1] = arr[indexNum];
						arr[indexNum] = tmp;
						cnt++;
					}
				}

			}
		} while (cnt > 0);
	}

	public static void main(String[] args) {
		Quiz0829 q = new Quiz0829();
		FuncVoid fv;

		// System.out.println(q.returnMax(100, 20, 300));

		/*
		 * int[][] gugudan = new int[9][9];
		 * 
		 * for(int i = 1;i <= 9;i++) { for(int j = 1;j <= 9;j++) { gugudan[i - 1][j - 1]
		 * = i * j; System.out.print(j + " X " + i + " = " + i * j + "\t"); }
		 * System.out.println(""); }
		 */

		// nomal
		fv = () -> {
			int[][] arr = new int[5][5];

			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					arr[i][j] = (i * 5) + (j + 1);
				}
			}
			for (int[] index : arr)
				System.out.println(Arrays.toString(index));
		};

		// ㄹ자
		fv = () -> {
			int[][] arr = new int[6][5];
			int cal;

			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 5; j++) {
					if (i != 0 && i % 2 != 0)
						cal = -j + 4;
					else
						cal = j;
					arr[i][cal] = (i * 5) + (j + 1);
				}
			}
			for (int[] index : arr)
				System.out.println(Arrays.toString(index));
		};

		// 배열 복사
		fv = () -> {
			int[] arr1 = { 1, 2, 3, 4, 5 };
			int[] arr2 = new int[3];

			intArrayCopy(arr1, 2, arr2, 0, 5);

			System.out.println(Arrays.toString(arr2));
		};

		//// 행렬
		fv = () -> {
			int arr1[][] = { { 1, 2 }, { 3, 4 } };
			int arr2[][] = { { 1, 2 }, { 3, 4 } };
			int[][] result = new int[arr1.length][arr2[0].length];

			multiMatrix(arr1, arr2, result);
			System.out.println(Arrays.deepToString(result));

			plusMatrix(arr1, arr2, result);
			System.out.println(Arrays.deepToString(result));

			minusMatrix(arr1, arr2, result);
			System.out.println(Arrays.deepToString(result));
		};

		// bubble sort
		fv = () -> {
			int factor = 0;
			int[] arr = new int[9];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = (int) (Math.random() * 45);
			}

			System.out.println("not sort: " + Arrays.toString(arr));

			bubbleSort(factor, arr);

			System.out.println("DESC sorted: " + Arrays.toString(arr));
			
			factor = 1;
			
			bubbleSort(factor, arr);

			System.out.println("AES sorted: " + Arrays.toString(arr));
		};

		fv.method();

	}

}
