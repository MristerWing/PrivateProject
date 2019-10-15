package network;

public class Solution {
	private static boolean[][] isConnect = new boolean[200][200];

	public int solution(int n, int[][] computers) {
		int answer = 0;

		// search computers
		for (int i = 0; i < n; i++) {
			if (!isConnect[i][i]) {
				dfs(computers, i, n);
				answer++;
			}
		}

		return answer;
	}

	// search network
	public void dfs(int[][] computers, int comIndex, int n) {
		for(int i = 0;i < n;i++) {
			if(computers[comIndex][i] == 1 && !isConnect[comIndex][i]) {
				isConnect[comIndex][i] = true;
				isConnect[i][comIndex] = true;
				dfs(computers, i, n);
			}
		}
		
	}

	public static void main(String[] args) {
		int[][] arr = new int[3][3];

		int[] arr1 = { 1, 1, 0 };
		int[] arr2 = { 1, 1, 1 };
		int[] arr3 = { 0, 1, 1 };

		arr[0] = arr1;
		arr[1] = arr2;
		arr[2] = arr3;

		System.out.println(new Solution().solution(3, arr));

	}

}
