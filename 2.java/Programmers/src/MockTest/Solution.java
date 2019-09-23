package MockTest;

import java.util.Arrays;

public class Solution {

	public static int[] solution(int[] answers) {
		int[] answer = {};

		// 정답패턴
		int[] pattern1 = { 1, 2, 3, 4, 5 };
		int[] pattern2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
		int[] pattern3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };

		// 정답수
		int give1 = 0;
		int give2 = 0;
		int give3 = 0;
		int tmp = 0;

		// 인덱스 넘버
		int index1 = 0;
		int index2 = 0;
		int index3 = 0;

		for (int index : answers) {

			// 맞추면 정답++
			if (pattern1[index1] == index) {
				give1++;
			}

			if (pattern2[index2] == index) {
				give2++;
			}

			if (pattern3[index3] == index) {
				give3++;
			}

			// index번호 증가
			index1++;
			if (pattern1.length == index1) {
				index1 = 0;
			}
			index2++;
			if (pattern2.length == index2) {
				index2 = 0;
			}
			index3++;
			if (pattern3.length == index3) {
				index3 = 0;
			}
		}

		if (give1 == give2 && give2 == give3) {
			answer = new int[] { 1, 2, 3 };
		} else {
			if (give1 > give2) {
				answer = new int[] { 1 };
				tmp = give1;
			} else if (give2 > give1) {
				answer = new int[] { 2 };
				tmp = give2;
			} else {
				answer = new int[] { 1, 2 };
				tmp = give1;
			}

			if (tmp < give3) {
				answer = new int[] { 3 };
			} else if (tmp == give3) {
				if (tmp == give1)
					answer = new int[] { 1, 3 };
				if (tmp == give2)
					answer = new int[] { 2, 3 };
			}
		}

		return answer;

	}

	public static void main(String[] args) {
		int[] answers = { 1, 2, 3, 4, 5 };

		System.out.println(Arrays.toString(solution(answers)));
	}

}
