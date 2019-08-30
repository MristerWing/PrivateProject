package ch03;

public class Pro4 {

	public static void main(String[] args) {
		int[][] score = { { 100, 100, 100 }, { 20, 20, 20 }, { 30, 30, 30 }, { 40, 40, 40 }, { 50, 50, 50 } };
		int[][] result = new int[score.length + 1][score[0].length + 1];

		//input
		for (int i = 0; i < score.length; i++) {
			for (int j = 0; j < score[j].length; j++) {
				int cnt; //sum loop counter

				result[i][j] = score[i][j];

				//row sum
				if (j == score[i].length - 1) {
					cnt = 0;
					for (int index : result[i]) {
						result[i][j + 1] += index;
						cnt++;

						if (cnt == score[i].length)
							break;
					}
				}//row sum end

				//column sum
				if (i == score.length - 1) {
					cnt = 0;
					for (int[] index : result) {
						result[i + 1][j] += index[j];

						if (j == score[i].length - 1)
							result[i + 1][j + 1] += index[j + 1];

						cnt++;

						if (cnt == result.length - 1)
							break;

					}
				}//column sum end

			} //input j loop end
			
		}//input i loop end
		
		//out put
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[j].length; j++) {
				System.out.printf("%4d", result[i][j]);
			}//output j end
			
			System.out.println();
			
		}//output i end
		
	}//main end

}//class end
