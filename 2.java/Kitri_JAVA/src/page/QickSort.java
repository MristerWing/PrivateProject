package page;

import java.util.ArrayList;
import java.util.Arrays;

public class QickSort {
	public static int[] mergerArr = new int[8];

	public static void quickSort(int[] arr, int left, int right) {
		int i, j, pivot, tmp;
		if (left < right) {
			i = left;
			j = right;
			pivot = arr[(left + right) / 2];
			// 분할 과정
			while (i < j) {
				while (arr[j] > pivot)
					j--;
				// 이 부분에서 arr[j-1]에 접근해서 익셉션 발생가능함.
				while (i < j && arr[i] < pivot)
					i++;

				tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
			}
			// 정렬 과정
			quickSort(arr, left, i - 1);
			quickSort(arr, i + 1, right);
		}
	}

	public static void mergeSort(int[] arr, int start, int end) {

		int cnt = 0;

		int len = (start + end) / 2;

		if (start < end) {
			mergeSort(arr, start, len);
			mergeSort(arr, len + 1, end);
			merge(arr, start, len, end);

		}

		System.out.println(Arrays.toString(mergerArr));

	}

	public static void merge(int[] arr, int start, int len, int end) {
		int mid = len + 1;

		/*
		 * for(int i = start;i < len;i++) { System.out.print(arr[i] + " "); }
		 */

		System.out.print("s: " + start + " l: ");
		System.out.print(mid + " e: ");
		System.out.print(end + " ");

		System.out.println();

		if (mid == end) {
			if (arr[start] > arr[mid]) {
				mergerArr[start] = arr[mid];
				mergerArr[mid] = arr[start];
			} else {
				mergerArr[start] = arr[start];
				mergerArr[mid] = arr[mid];

			}
		} else if (mid < end) {
			for (int i = start; i < end; i++) {
				if (arr[i] > arr[mid]) {
					int tmp = arr[i];
					arr[i] = arr[mid];
					arr[mid] = tmp;
				}
			}
		}

	}

	public static void main(String[] args) {
		int[] arr = new int[8];
		int[] arr1 = new int[8];
		for (int i = 1; i <= arr.length; i++) {
			arr[i - 1] = (int) (Math.random() * 45);

			for (int j = 0; j < i - 1; j++) {
				if (arr[i - 1] == arr[j]) {
					i--;
					break;
				}
			}
			arr1[i - 1] = arr[i - 1];
		}

		System.out.println("origin: " + Arrays.toString(arr));

		quickSort(arr, 0, arr.length - 1);

		System.out.println("qick: " + Arrays.toString(arr));

//		mergeSort(arr1, 0, arr.length - 1);
//
//		System.out.println("merge: " + Arrays.toString(arr1));
	}

}
