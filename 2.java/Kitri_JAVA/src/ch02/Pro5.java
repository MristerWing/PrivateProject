package ch02;

public class Pro5 {

	public static void main(String[] args) {

		for (int dice1 = 1; dice1 <= 6; dice1++) {
			for (int dice2 = 1; dice2 <= 6; dice2++) {
				if(dice1 + dice2 == 6) {
					System.out.println(dice1 + " + " + dice2 + " = " + (dice1 + dice2));
				}
			}
		}

	}

}
