package ch03;

public class Pro5 {

	public static void main(String[] args) {
		int[] ballArr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		int[] ball3 = new int [3];
		
		//sort random index
		for(int i = 0;i < ballArr.length;i++) {
			int j = (int) (Math.random() * ballArr.length);
			int tmp = 0;
			
			if(j != i) {
				tmp = ballArr[j];
				ballArr[j] = ballArr[i];
				ballArr[i] = tmp;
			}else i--;
		}
		
		//copy index
		int cnt = 0;
		for(int index:ballArr) {
			ball3[cnt] = index;
			if(cnt == ball3.length - 1) break;
			cnt++;
		}
		
		//print array
		for(int i = 0;i < ball3.length;i++) {
			System.out.print(ball3[i] + "");
		}

	}

}
