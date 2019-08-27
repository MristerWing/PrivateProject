package ch02;

public class Pro4 {

	public static void main(String[] args) {
		int loop = 0;
		int innerLoop = 0;
		
		while(loop <= 10) {
			innerLoop = 0;
			while(innerLoop <= loop) {
				System.out.print("*");
				innerLoop++;
			}
			System.out.println("");
			loop++;
		}

	}

}
