package targetNumber;

public class Solution {
	
	public int solution(int[] numbers, int target) {
		int answer = 0;
		
		answer = dfs(0, 0, numbers, target);
		
		return answer;
	}
	
	public int dfs(int value, int index, int[] numbers, int target) {
		
			if(index == numbers.length) {
				if(value == target) return 1;
				else return 0;
			}else {
				return dfs(value + numbers[index], index + 1, numbers, target)
						+ dfs(value - numbers[index], index + 1, numbers, target);
			}
		
	}
	

	public static void main(String[] args) {
		int[] arr = new int[5];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        int target = 3;
 
        System.out.println(new Solution().solution(arr, target));
	}

}
