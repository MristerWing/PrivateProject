package hIndex;

//import java.util.ArrayList;
import java.util.Arrays;
//import java.util.Collections;

public class Solution {

	public static int solution(int[] citations) {

//		int h = citations.length;
		int answer = 0;
//		boolean isH = false;

		Arrays.sort(citations);

		// find h-index
		/*
		 * while (!isH) { for (int i = citations.length - 1; i >= 0; i--) { if
		 * (citations[i] >= h) { answer++; }else break; }
		 * 
		 * if(h == answer) isH = true; else { h--; answer = 0; }
		 * 
		 * }
		 */

		for (int i = 0; i < citations.length - 1; i++) {
			int h = citations.length - i;
			if (h <= citations[i]) {
				answer = h;
				break;
			}
		}

		return answer;
	}

	/*
	 * int answer = 0; Arrays.sort(citations); for(int i = 0;i <
	 * citations.length;i++) { int minimum = Math.min(citations[i], citations.length
	 * - 1); answer = Math.max(answer, minimum); }
	 * 
	 * return answer; }
	 */

	public static void main(String[] args) {
		int[] citations = { 3, 0, 6, 1, 5 };

		System.out.println(solution(citations));
	}

}
