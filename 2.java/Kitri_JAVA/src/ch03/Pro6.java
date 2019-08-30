package ch03;

public class Pro6 {

	public static void main(String[] args) {
		int[] coinUnit = {500, 100, 50, 10};
		int money = 2680;
		
		System.out.println("money: " + money);
		
		for(int i = 0;i < coinUnit.length;i++) {
			int cnt = money / coinUnit[i]; //number of coin
			System.out.println(coinUnit[i] + "원: " + cnt);
			money -= cnt * coinUnit[i];
		}

	}

}
