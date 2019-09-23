package baseball;

import java.util.ArrayList;

public class Solution {

	public static int solution(int[][] baseball) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		int answer = 0;
		int cnt = 0;
		int[] chk = new int[3];
		int[] digit = new int[3];
		
		for(int i = 123;i < 987;i++) {
			chk[0] = i % 10;
			chk[1] = i % 100 / 10;
			chk[2] = i % 1000 / 100;
			
			//0제거
			if(chk[0] != 0 && chk[1] != 0) {
				//중복제거
				if(chk[0] != chk[1] && chk[0] != chk[2] && chk[1] !=chk[2]) {
					
					//값비교
					for(int j = 0;j < baseball.length;j++) {
						
						
						if(i != baseball[j][0]) {
							//strike, ball
							int strike = 0;
							int ball = 0;
							
							//자릿수를 구함
							digit[0] = baseball[j][0] % 10;
							digit[1] = baseball[j][0] % 100 / 10;
							digit[2] = baseball[j][0] % 1000 / 100;
							
							
							for(int k = 0;k < 3;k++) {
								//strike
								if(chk[k] == digit[k])
									strike++;
								//ball
								for(int index : digit) {
									if(chk[k] == index)
										ball++;
								}
							}
							
							ball -= strike;
			
							//조건을 만족하는 경우를 확인
							if(strike == baseball[j][1] && ball == baseball[j][2]) {
								cnt++;
							}
						}
						
					}
					
					//정해진 조건을 모두 만족했을 경우 List에 추가
					if(cnt == baseball.length) {
						result.add(i);
					}
					
					cnt = 0;
				}
				
			}
		}
		
		answer = result.size();
		
		return answer;
	}

	public static void main(String[] args) {
		int[][] answers = { { 123, 1, 1 }, { 356, 1, 0 }, { 327, 2, 0 }, { 489, 0, 1 } };

		System.out.println(solution(answers));

	}

}
