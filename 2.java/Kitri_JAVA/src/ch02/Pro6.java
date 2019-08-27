package ch02;

public class Pro6 {

	public static void main(String[] args) {
		for(int x = 0;x <= 10;x++) {
			for(int y = 0;y <= 10;y++) {
				if((2 * x) + (4 * y) == 10)
					System.out.println("2 * " + x + "(x) + " + "4 * " + y + "(y) = " + ((2 * x) + (4 * y)));
			}
		}

	}

}
